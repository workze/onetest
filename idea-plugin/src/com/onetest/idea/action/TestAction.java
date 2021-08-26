package com.onetest.idea.action;

import com.intellij.execution.filters.BrowserHyperlinkInfo;
import com.intellij.execution.ui.ConsoleView;
import com.intellij.execution.ui.ConsoleViewContentType;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowManager;
import com.onetest.idea.toolwindow.ConsoleViewHolder;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;

/**
 * @author guize
 */
public class TestAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        final Project project = e.getProject();
        if (project == null || project.isDisposed()) {
            return;
        }

        // 激活toolwindow
        ToolWindow toolWindow = ToolWindowManager.getInstance(e.getProject()).getToolWindow("TestToolWindow");
        if (toolWindow == null) {
            throw new RuntimeException("toolWindow is null");
        }
        toolWindow.activate(null);


        // 打开浏览器, 跳转到网页
        final ConsoleView consoleView = ConsoleViewHolder.getInstance(project).getConsoleView();

        // 控制台输出超链接
        consoleView.printHyperlink("http://www.baidu.com\n", new BrowserHyperlinkInfo("http://www.baidu.com"));

        consoleView.print(Thread.currentThread().getName(), ConsoleViewContentType.NORMAL_OUTPUT);

        // 滚动条滚到最后
        consoleView.requestScrollingToEnd();

        ApplicationManager.getApplication().executeOnPooledThread(() -> {
            ApplicationManager.getApplication().runReadAction(() -> {
                consoleView.print(Thread.currentThread().getName(), ConsoleViewContentType.NORMAL_OUTPUT);
                for (int i = 0; i < 3; i++) {
                    try {
                        consoleView.print("hello " + i + "\n", ConsoleViewContentType.NORMAL_OUTPUT);
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                }
            });
        });
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

