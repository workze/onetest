package com.onetest.idea.action;

import com.intellij.execution.filters.TextConsoleBuilderFactory;
import com.intellij.execution.ui.ConsoleView;
import com.intellij.execution.ui.ConsoleViewContentType;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowManager;
import com.intellij.ui.content.Content;

public class MultiToolWindow extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        if (e.getProject() == null) {
            return;
        }

        ToolWindow toolWindow = ToolWindowManager.getInstance(e.getProject()).getToolWindow("TestToolWindow");
        if (toolWindow == null) {
            return;
        }

        final ConsoleView consoleView = TextConsoleBuilderFactory.getInstance().createBuilder(e.getProject()).getConsole();

        final Content content = toolWindow.getContentManager().getFactory().createContent(consoleView.getComponent(), "  Test  ", true);
        toolWindow.getContentManager().addContent(content);
        toolWindow.getContentManager().setSelectedContent(content);
        toolWindow.activate(null);

        consoleView.print("hello world", ConsoleViewContentType.LOG_INFO_OUTPUT);
    }
}
