package com.onetest.idea.action;

import com.intellij.execution.ui.ConsoleView;
import com.intellij.execution.ui.ConsoleViewContentType;
import com.intellij.ide.BrowserUtil;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.onetest.idea.toolwindow.ConsoleViewHolder;

/**
 * @author guize
 */
public class TestAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        System.out.println("actioned!");


        // BrowserUtil.browse("https://www.baidu.com");
        final ConsoleView consoleView = ConsoleViewHolder.getInstance(e.getProject()).getConsoleView();

        consoleView.clear();

        for (int i = 0; i < 10000; i++) {
            consoleView.print(i + "\n", ConsoleViewContentType.NORMAL_OUTPUT);
        }

    }
}
