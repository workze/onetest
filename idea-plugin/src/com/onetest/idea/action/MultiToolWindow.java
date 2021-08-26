package com.onetest.idea.action;

import com.intellij.execution.filters.TextConsoleBuilderFactory;
import com.intellij.execution.ui.ConsoleView;
import com.intellij.execution.ui.ConsoleViewContentType;
import com.intellij.icons.AllIcons;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowManager;
import com.intellij.ui.content.Content;

import javax.swing.*;
import java.awt.*;

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

        final Content content = toolWindow.getContentManager().getFactory().createContent(consoleView.getComponent(), "  Test  ", false);
        content.setCloseable(true);
        content.setDescription("ContentDesc");
        content.setTabName("ContentTabName");
        content.setIcon(AllIcons.Json.Object);
        content.setDisplayName("ContentDisplayName");

        toolWindow.getContentManager().addContent(content);
        toolWindow.getContentManager().setSelectedContent(content);
        toolWindow.activate(null);
        toolWindow.setToHideOnEmptyContent(true);

        consoleView.print("hello world", ConsoleViewContentType.LOG_INFO_OUTPUT);
    }
}
