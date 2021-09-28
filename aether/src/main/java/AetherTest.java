import org.apache.maven.repository.internal.MavenRepositorySystemUtils;
import org.eclipse.aether.DefaultRepositorySystemSession;
import org.eclipse.aether.RepositorySystem;
import org.eclipse.aether.RepositorySystemSession;
import org.eclipse.aether.artifact.Artifact;
import org.eclipse.aether.artifact.DefaultArtifact;
import org.eclipse.aether.collection.CollectRequest;
import org.eclipse.aether.collection.CollectResult;
import org.eclipse.aether.collection.DependencyCollectionException;
import org.eclipse.aether.connector.basic.BasicRepositoryConnectorFactory;
import org.eclipse.aether.graph.Dependency;
import org.eclipse.aether.graph.DependencyNode;
import org.eclipse.aether.impl.DefaultServiceLocator;
import org.eclipse.aether.repository.Authentication;
import org.eclipse.aether.repository.LocalRepository;
import org.eclipse.aether.repository.RemoteRepository;
import org.eclipse.aether.resolution.*;
import org.eclipse.aether.spi.connector.RepositoryConnectorFactory;
import org.eclipse.aether.spi.connector.transport.TransporterFactory;
import org.eclipse.aether.transport.file.FileTransporterFactory;
import org.eclipse.aether.transport.http.HttpTransporterFactory;
import org.eclipse.aether.util.graph.visitor.PreorderNodeListGenerator;
import org.eclipse.aether.util.repository.AuthenticationBuilder;
import org.eclipse.aether.version.Version;
import org.eclipse.aether.version.VersionConstraint;

import java.util.List;

/**
 * @author wangguize
 * @date 2021/9/27
 */
public class AetherTest {

    public static void main(String[] args) throws Exception {


        // test1();

        test2();

//        DependencyRequest dependencyRequest = new DependencyRequest();
//        dependencyRequest.setRoot( node );
//
//        repoSystem.resolveDependencies( session, dependencyRequest  );
//
//        PreorderNodeListGenerator nlg = new PreorderNodeListGenerator();
//        node.accept( nlg );
//        System.out.println( nlg.getClassPath() );

        System.out.println();
    }


    public static void test1() throws Exception {
        RepositorySystem repoSystem = newRepositorySystem();
        RepositorySystemSession session = newSession(repoSystem, "/Users/wangguize/tmp");


        RemoteRepository repository01 = new RemoteRepository.Builder("central1", "default", "http://mvn.hz.netease.com/artifactory/libs-releases").build();
        RemoteRepository repository02 = new RemoteRepository.Builder("central2", "default", "http://mvn.hz.netease.com/artifactory/libs-snapshots").build();
        RemoteRepository repository03 = new RemoteRepository.Builder("central3", "default", "http://maven.aliyun.com/nexus/content/groups/public").build();
        // Authentication authentication=new AuthenticationBuilder().addUsername(username).addPassword(password).build();
        // central = new RemoteRepository.Builder( "central", "default", repositoryUrl ).setAuthentication(authentication).build();
        /**
         * 下载一个jar包
         */
        ArtifactRequest artifactRequest = new ArtifactRequest();

        artifactRequest.addRepository(repository01);
        artifactRequest.addRepository(repository02);
        artifactRequest.addRepository(repository03);
        // Artifact artifact = new DefaultArtifact("com.netease.music:overmind-x-api:1.0-SNAPSHOT");
        // Artifact artifact = new DefaultArtifact("com.netease.music:music-server-parent:2.5.8");
        Artifact artifact = new DefaultArtifact("com.netease.music", "music-server-parent", "pom", "2.5.8");
        artifactRequest.setArtifact(artifact);

        ArtifactResult artifactResult = repoSystem.resolveArtifact(session, artifactRequest);
        Artifact resolved = artifactResult.getArtifact();

        System.out.println("success");
    }

    public static void test2() throws Exception {
        RepositorySystem repoSystem = newRepositorySystem();
        RepositorySystemSession session = newSession(repoSystem, "/Users/wangguize/tmp");


        RemoteRepository repository01 = new RemoteRepository.Builder("central1", "default", "http://mvn.hz.netease.com/artifactory/libs-releases").build();
        RemoteRepository repository02 = new RemoteRepository.Builder("central2", "default", "http://mvn.hz.netease.com/artifactory/libs-snapshots").build();
        RemoteRepository repository03 = new RemoteRepository.Builder("central3", "default", "http://maven.aliyun.com/nexus/content/groups/public").build();


        // Dependency dependency = new Dependency(new DefaultArtifact("com.netease.music:overmind-x-service:1.0-SNAPSHOT"), null);
        // Dependency dependency = new Dependency(new DefaultArtifact("com.netease.music:overmind-x-service:1.0-SNAPSHOT"), null);
        // DefaultArtifact artifact = new DefaultArtifact("com.netease.music", "music-server-parent", "pom", "2.5.8");
        DefaultArtifact artifact = new DefaultArtifact("com.netease.music", "overmind-x-api", "jar", "1.0-SNAPSHOT");
        // DefaultArtifact artifact = new DefaultArtifact("com.onetest", "test-pom", "pom", "1.0.0-SNAPSHOT");
        Dependency dependency = new Dependency(artifact, null);
        CollectRequest collectRequest = new CollectRequest();
        collectRequest.setRoot(dependency);
        collectRequest.addRepository(repository01);
        collectRequest.addRepository(repository02);
        collectRequest.addRepository(repository03);

        CollectResult collectResult = repoSystem.collectDependencies(session, collectRequest);

        DependencyNode node = collectResult.getRoot();
        Dependency nodeDep = node.getDependency();
        List<DependencyNode> nodeChildren = node.getChildren();
        Version nodeVersion = node.getVersion();
        VersionConstraint versionConstraint = node.getVersionConstraint();

        System.out.println();
    }

    /**
     * 建立RepositorySystem
     *
     * @return RepositorySystem
     */
    private static RepositorySystem newRepositorySystem() {
        DefaultServiceLocator locator = MavenRepositorySystemUtils.newServiceLocator();
        locator.addService(RepositoryConnectorFactory.class, BasicRepositoryConnectorFactory.class);
        locator.addService(TransporterFactory.class, FileTransporterFactory.class);
        locator.addService(TransporterFactory.class, HttpTransporterFactory.class);

        return locator.getService(RepositorySystem.class);
    }

    /**
     * create a repository system session
     *
     * @param system RepositorySystem
     * @return RepositorySystemSession
     */
    private static RepositorySystemSession newSession(RepositorySystem system, String target) {
        DefaultRepositorySystemSession session = MavenRepositorySystemUtils.newSession();

        LocalRepository localRepo = new LocalRepository( /*"target/local-repo" */target);
        session.setLocalRepositoryManager(system.newLocalRepositoryManager(session, localRepo));

        return session;
    }

}
