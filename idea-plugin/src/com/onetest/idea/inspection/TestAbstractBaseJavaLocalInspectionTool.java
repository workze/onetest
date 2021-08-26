package com.onetest.idea.inspection;

import com.intellij.codeInspection.AbstractBaseJavaLocalInspectionTool;
import com.intellij.codeInspection.ProblemDescriptor;
import com.intellij.codeInspection.ProblemsHolder;
import com.intellij.codeInspection.SuppressQuickFix;
import com.intellij.openapi.project.Project;
import com.intellij.psi.JavaElementVisitor;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiField;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TestAbstractBaseJavaLocalInspectionTool extends AbstractBaseJavaLocalInspectionTool {

    @NotNull
    @Override
    public PsiElementVisitor buildVisitor(@NotNull ProblemsHolder holder, boolean isOnTheFly) {

        JavaElementVisitor visitor = new JavaElementVisitor() {
            @Override
            public void visitField(PsiField field) {
                super.visitField(field);
                if(field.getName().equals("error")) {
                    holder.registerProblem(field, "字段名称不合法: error");
                }
            }
        };
        return visitor;
    }

    /*@NotNull
    @Override
    public SuppressQuickFix[] getBatchSuppressActions(@Nullable PsiElement element) {
        SuppressQuickFix suppressQuickFix = new SuppressQuickFix() {
            @Nls(capitalization = Nls.Capitalization.Sentence)
            @NotNull
            @Override
            public String getFamilyName() {
                return "QuickFix2222";
            }

            @Override
            public void applyFix(@NotNull Project project, @NotNull ProblemDescriptor problemDescriptor) {
                System.out.println("==========");
            }

            @Override
            public boolean isAvailable(@NotNull Project project, @NotNull PsiElement psiElement) {
                return psiElement instanceof PsiField;
            }

            @Override
            public boolean isSuppressAll() {
                return false;
            }
        };
        return new SuppressQuickFix[]{suppressQuickFix};

    }*/
    
}