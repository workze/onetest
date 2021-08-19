package com.onetest.idea.persistent.impl;

import com.onetest.idea.persistent.AppPersistentService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class AppPersistentServiceImpl implements AppPersistentService {

    private String configStr = "";

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
