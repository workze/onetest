package com.netease.test;

import com.alibaba.fastjson.JSON;
import org.gitlab4j.api.GitLabApi;
import org.gitlab4j.api.GitLabApiException;
import org.gitlab4j.api.models.Project;
import org.gitlab4j.api.models.ProjectFilter;

import java.util.List;

/**
 * @author wangguize
 * @date 2022/7/5
 */
public class GitlabTest {
    public static void main(String[] args) throws GitLabApiException {
        GitLabApi gitLabApi = new GitLabApi(GitLabApi.ApiVersion.V4, "https://g.hz.netease.com", "WygxhjxBAEmy1_ARogQx");
        final ProjectFilter projectFilter = new ProjectFilter();
        final List<Project> onecode = gitLabApi.getProjectApi().getProjects(projectFilter.withSearch("onecode"));
        final Project project = gitLabApi.getProjectApi().getProject(68163L);
        System.out.println(JSON.toJSONString(project, true));
    }
}
