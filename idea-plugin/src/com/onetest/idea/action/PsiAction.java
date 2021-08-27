package com.onetest.idea.action;

import com.intellij.execution.ui.ConsoleView;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.LangDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.onetest.idea.toolwindow.ConsoleViewHolder;
import com.onetest.idea.util.ConsoleLogger;
import com.onetest.idea.util.PsiDisplayUtil;

public class PsiAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        final Project project = e.getProject();
        if (project == null) {
            return;
        }

        final ConsoleView consoleView = ConsoleViewHolder.getInstance(project).getConsoleView();
        ConsoleLogger logger = new ConsoleLogger(consoleView);

        final PsiElement psiElement = e.getData(LangDataKeys.PSI_ELEMENT);
        final String display = PsiDisplayUtil.display(psiElement);
        logger.log("LangDataKeys.PSI_ELEMENT: \n" + display);
    }
}
