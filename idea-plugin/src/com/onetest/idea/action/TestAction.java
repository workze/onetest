package com.onetest.idea.action;

import com.intellij.execution.ui.ConsoleView;
import com.intellij.execution.ui.ConsoleViewContentType;
import com.intellij.ide.BrowserUtil;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.onetest.idea.toolwindow.ConsoleViewHolder;
import org.jetbrains.annotations.NotNull;

/**
 * @author guize
 */
public class TestAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        final Project project = e.getProject();
        if (project != null && project.isDisposed()) {
            return;
        }


        // BrowserUtil.browse("https://www.baidu.com");
        final ConsoleView consoleView = ConsoleViewHolder.getInstance(project).getConsoleView();
        consoleView.print("AnAction.actionPerformed()\n", ConsoleViewContentType.NORMAL_OUTPUT);
    }

    @Override
    public void update(@NotNull AnActionEvent e) {
        final ConsoleView consoleView = ConsoleViewHolder.getInstance(e.getProject()).getConsoleView();
        consoleView.print("AnAction.update()\n", ConsoleViewContentType.NORMAL_OUTPUT);

        // Get required data keys
        final Project project = e.getProject();
        final Editor editor = e.getData(CommonDataKeys.EDITOR);

        // Set visibility only in case of existing project and editor and if a selection exists
        //e.getPresentation().setEnabled( project != null
        //         && editor != null
        //        && editor.getSelectionModel().hasSelection() );
    }


}

