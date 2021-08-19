package com.onetest.idea.persistent;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

/**
 * @author guize
 * 项目级别持久化
 */
public interface ProjectPersistentService extends PersistentStateComponent<String> {
    static ProjectPersistentService getInstance(@NotNull Project project) {
        return ServiceManager.getService(project, ProjectPersistentService.class);
    }
}
