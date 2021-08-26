package com.onetest.idea.util;

import com.intellij.execution.ui.ConsoleView;
import com.intellij.execution.ui.ConsoleViewContentType;
import org.jetbrains.annotations.NotNull;

/**
 * @author guize
 * @date 2021/8/26
 */
public class ConsoleLogger {

    private final ConsoleView consoleView;

    public ConsoleLogger(@NotNull ConsoleView consoleView) {
        this.consoleView = consoleView;
    }

    public void log(String msg) {
        log(msg, ConsoleViewContentType.NORMAL_OUTPUT);
    }

    public void info(String msg) {
        log(msg, ConsoleViewContentType.LOG_INFO_OUTPUT);
    }

    public void warn(String msg) {
        log(msg, ConsoleViewContentType.LOG_WARNING_OUTPUT);
    }

    public void error(String msg) {
        log(msg, ConsoleViewContentType.LOG_ERROR_OUTPUT);
    }

    public void debug(String msg) {
        log(msg, ConsoleViewContentType.LOG_DEBUG_OUTPUT);
    }

    /*  */

    private void log(String msg, ConsoleViewContentType contentType) {
        this.consoleView.print(msg + "\n", contentType);
    }

}
