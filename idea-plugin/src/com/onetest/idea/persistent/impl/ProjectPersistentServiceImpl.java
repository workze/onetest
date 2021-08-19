package com.onetest.idea.persistent.impl;

import com.onetest.idea.persistent.ProjectPersistentService;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ProjectPersistentServiceImpl implements ProjectPersistentService {

    private String configStr = "";

    public ProjectPersistentServiceImpl(Project project) {
    }

    @Nullable
    @Override
    public String getState() {
        return configStr;
    }

    @Override
    public void loadState(@NotNull String s) {
        this.configStr = s;
    }
}
