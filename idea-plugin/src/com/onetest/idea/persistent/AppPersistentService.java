package com.onetest.idea.persistent;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ServiceManager;

/**
 * 应用级别持久化
 *
 * @author guize
 */
public interface AppPersistentService extends PersistentStateComponent<String> {
    static AppPersistentService getInstance() {
        return ServiceManager.getService(AppPersistentService.class);
    }
}
