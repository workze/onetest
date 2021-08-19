package com.onetest.idea.toolwindow;

import com.intellij.execution.ui.ConsoleView;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

public interface ConsoleViewHolder {

    static ConsoleViewHolder getInstance(@NotNull Project project) {
        return ServiceManager.getService(project, ConsoleViewHolder.class);
    }

    ConsoleView getConsoleView();

}
