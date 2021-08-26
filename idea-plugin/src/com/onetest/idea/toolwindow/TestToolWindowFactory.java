package com.onetest.idea.toolwindow;

import com.intellij.execution.ui.ConsoleView;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import org.jetbrains.annotations.NotNull;

public class TestToolWindowFactory implements ToolWindowFactory {
    
    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        final ConsoleView consoleView = ConsoleViewHolder.getInstance(project).getConsoleView();

        Content content = toolWindow.getContentManager().getFactory().createContent(consoleView.getComponent(), "First", true);
        toolWindow.getContentManager().addContent(content);
    }
}