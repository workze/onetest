package com.onetest.idea.toolwindow.impl;

import com.intellij.execution.filters.TextConsoleBuilderFactory;
import com.intellij.execution.ui.ConsoleView;
import com.onetest.idea.toolwindow.ConsoleViewHolder;
import com.intellij.openapi.project.Project;

public class ConsoleViewHolderImpl implements ConsoleViewHolder {

    private final ConsoleView consoleView;

    public ConsoleViewHolderImpl(Project project) {
        consoleView = TextConsoleBuilderFactory.getInstance().createBuilder(project).getConsole();
    }

    @Override
    public ConsoleView getConsoleView() {
        return consoleView;
    }
}
