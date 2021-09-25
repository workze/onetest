package com.ox;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.resolution.declarations.ResolvedClassDeclaration;
import com.github.javaparser.resolution.declarations.ResolvedReferenceTypeDeclaration;
import com.github.javaparser.resolution.declarations.ResolvedTypeParameterDeclaration;
import com.github.javaparser.resolution.types.ResolvedReferenceType;
import com.github.javaparser.symbolsolver.JavaSymbolSolver;
import com.github.javaparser.symbolsolver.model.resolution.TypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.CombinedTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.JarTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.JavaParserTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.ReflectionTypeSolver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

/**
 * @author wangguize
 * @date 2021/9/19
 */
public class OxParser {

    static {
        try {
            TypeSolver reflectionTypeSolver = new ReflectionTypeSolver();

            String SRC_PATH = "parser/src/main/java";
            TypeSolver javaParserTypeSolver = new JavaParserTypeSolver(new File(SRC_PATH));


            JarTypeSolver jarTypeSolver = new JarTypeSolver(new File("common/target/common-1.0.0-SNAPSHOT.jar"));


            CombinedTypeSolver combinedSolver = new CombinedTypeSolver();
            combinedSolver.add(reflectionTypeSolver);
            combinedSolver.add(javaParserTypeSolver);
            combinedSolver.add(jarTypeSolver);

            JavaSymbolSolver symbolSolver = new JavaSymbolSolver(combinedSolver);
            StaticJavaParser.getConfiguration().setSymbolResolver(symbolSolver);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static OxClass parser(File file) throws FileNotFoundException {
        CompilationUnit cu = StaticJavaParser.parse(file);

        ClassOrInterfaceDeclaration classDeclaration = (ClassOrInterfaceDeclaration) cu.getPrimaryType().get();

        OxClass oxClass = new OxClass();
        oxClass.setClassOrInterfaceDeclaration(classDeclaration);

        NodeList<ClassOrInterfaceType> extendedTypes = classDeclaration.getExtendedTypes();

        ResolvedReferenceTypeDeclaration resolvedReferenceTypeDeclaration = classDeclaration.resolve();
        ResolvedClassDeclaration resolvedClassDeclaration = (ResolvedClassDeclaration) resolvedReferenceTypeDeclaration;
        List<ResolvedReferenceType> ancestors = resolvedReferenceTypeDeclaration.getAncestors();
        if (ancestors.size() > 0) {
            ResolvedReferenceType resolvedReferenceType = ancestors.get(0);
        }
        List<ResolvedTypeParameterDeclaration> typeParameters = resolvedReferenceTypeDeclaration.getTypeParameters();
        if (typeParameters.size() > 0) {
            ResolvedTypeParameterDeclaration resolvedTypeParameterDeclaration = typeParameters.get(0);
        }

        ResolvedReferenceType resolvedReferenceType = resolvedClassDeclaration.getSuperClass().get();

        return oxClass;
    }

    public static void main(String[] args) throws FileNotFoundException {
        OxClass oxClass = parser(new File("parser/src/main/java/com/demo/testsource2/Color.java"));


        System.out.println();
    }

}
