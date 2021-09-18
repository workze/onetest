package com.onetest.idea.executor;

import com.intellij.execution.Executor;
import com.intellij.openapi.Disposable;
import com.intellij.openapi.util.Disposer;
import com.intellij.util.IconUtil;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 * @author guize
 * @date 2021/8/21
 */
public class TestExecutor extends Executor implements Disposable{
    @Override
    public void dispose() {
        Disposer.dispose(this);
    }


    @NotNull
    @Override
    public String getToolWindowId() {
        return "ExecutorId";
    }

    @NotNull
    @Override
    public Icon getToolWindowIcon() {
        return  IconUtil.getAddIcon();
    }

    @NotNull
    @Override
    public Icon getIcon() {
        return  IconUtil.getAddIcon();
    }

    @Override
    public Icon getDisabledIcon() {
        return  IconUtil.getAddIcon();
    }

    @Override
    public  String getDescription() {
        return "这是Action描述";
    }

    @NotNull
    @Override
    public String getActionName() {
        return null;
    }

    @NotNull
    @Override
    public String getId() {
        return null;
    }

    @Nls(capitalization = Nls.Capitalization.Title)
    @NotNull
    @Override
    public String getStartActionText() {
        return null;
    }

    @Override
    public String getContextActionId() {
        return null;
    }

    @Override
    public String getHelpId() {
        return null;
    }
}
