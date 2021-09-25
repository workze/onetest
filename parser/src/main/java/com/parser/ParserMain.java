package com.parser;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ParserConfiguration;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.TypeDeclaration;
import com.github.javaparser.ast.modules.ModuleDeclaration;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.github.javaparser.metamodel.CompilationUnitMetaModel;
import com.github.javaparser.resolution.declarations.ResolvedReferenceTypeDeclaration;
import com.github.javaparser.symbolsolver.JavaSymbolSolver;
import com.github.javaparser.symbolsolver.javaparser.Navigator;
import com.github.javaparser.symbolsolver.model.resolution.TypeSolver;
import com.github.javaparser.symbolsolver.reflectionmodel.ReflectionClassDeclaration;
import com.github.javaparser.symbolsolver.resolution.typesolvers.CombinedTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.JavaParserTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.ReflectionTypeSolver;
import com.sun.javafx.css.Declaration;
import javassist.compiler.ast.AssignExpr;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Optional;

/**
 * @author wangguize
 * @date 2021/9/18
 */
public class ParserMain {

    public static void main(String[] args) throws Exception {


        // testRead();

        // testVisit();

        // testSymbol();

        testSymbol2();
    }

    private static void testSymbol2() throws FileNotFoundException {
        TypeSolver reflectionTypeSolver = new ReflectionTypeSolver();

        String SRC_PATH = "parser/src/main/java";
        TypeSolver javaParserTypeSolver = new JavaParserTypeSolver(new File(SRC_PATH));

        CombinedTypeSolver combinedSolver = new CombinedTypeSolver();
        combinedSolver.add(reflectionTypeSolver);
        combinedSolver.add(javaParserTypeSolver);

        JavaSymbolSolver symbolSolver = new JavaSymbolSolver(combinedSolver);
        StaticJavaParser.getConfiguration().setSymbolResolver(symbolSolver);

        String FILE_PATH = "parser/src/main/java/com/demo/test/FanClassImpl.java";
        CompilationUnit cu = StaticJavaParser.parse(new File(FILE_PATH));

        ClassOrInterfaceDeclaration classDeclaration = (ClassOrInterfaceDeclaration)cu.getPrimaryType().get();
        ResolvedReferenceTypeDeclaration resolved = classDeclaration.resolve();



    }

    private static void testSymbol() throws FileNotFoundException {
        String file = "parser/src/main/java/com/demo/SimpleController.java";
        ParserConfiguration configuration = new ParserConfiguration();

        TypeSolver typeSolver = new CombinedTypeSolver();
        JavaSymbolSolver symbolSolver = new JavaSymbolSolver(typeSolver);
        configuration.setSymbolResolver(symbolSolver);


        configuration.setLanguageLevel(ParserConfiguration.LanguageLevel.JAVA_8);

        JavaParser javaParser = new JavaParser(configuration);


        CompilationUnit cu = javaParser.parse(new File(file)).getResult().get();


        // 反射
        ReflectionTypeSolver reflectionTypeSolver = new ReflectionTypeSolver();
        ResolvedReferenceTypeDeclaration resolvedReferenceTypeDeclaration = reflectionTypeSolver.solveType("java.lang.String");

        ReflectionClassDeclaration reflectionClassDeclaration = (ReflectionClassDeclaration) resolvedReferenceTypeDeclaration;


        // 元素触发resolve
        ClassOrInterfaceDeclaration classOrInterfaceDeclaration = (ClassOrInterfaceDeclaration) cu.getPrimaryType().get();
        ResolvedReferenceTypeDeclaration referenceTypeDeclaration = classOrInterfaceDeclaration.resolve();


        System.out.println();
    }


    private static void testVisit() throws FileNotFoundException {
        String file = "parser/src/main/java/com/demo/SimpleController.java";
        ParserConfiguration configuration = new ParserConfiguration();

        configuration.setLanguageLevel(ParserConfiguration.LanguageLevel.JAVA_8);

        JavaParser javaParser = new JavaParser(configuration);
        ParseResult<CompilationUnit> result = javaParser.parse(new File(file));
        if (result.getResult().isPresent()) {
            CompilationUnit compilationUnit = result.getResult().get();

            new VoidVisitorAdapter<Void>() {
                @Override
                public void visit(MethodDeclaration n, Void arg) {
                    super.visit(n, arg);


                }
            }.visit(compilationUnit, null);


        }


    }

    private static void testRead() throws FileNotFoundException {
        String file = "parser/src/main/java/com/demo/SimpleController.java";

        ParserConfiguration configuration = new ParserConfiguration();

        configuration.setLanguageLevel(ParserConfiguration.LanguageLevel.JAVA_8);

        JavaParser javaParser = new JavaParser(configuration);
        ParseResult<CompilationUnit> result = javaParser.parse(new File(file));
        if (result.getResult().isPresent()) {
            CompilationUnit compilationUnit = result.getResult().get();

            NodeList<TypeDeclaration<?>> types = compilationUnit.getTypes();

            ModuleDeclaration moduleDeclaration = compilationUnit.getModule().orElse(null);
            CompilationUnitMetaModel metaModel = compilationUnit.getMetaModel();
            String s = compilationUnit.getPrimaryTypeName().orElse(null);

            ClassOrInterfaceDeclaration classDeclaration = (ClassOrInterfaceDeclaration) compilationUnit.getPrimaryType().orElse(null);

            ClassOrInterfaceType extendedType = classDeclaration.getExtendedTypes().get(0);


            System.out.println("");
        }


        System.out.println();

    }

}
