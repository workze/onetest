package com.onetest.idea.test;

import com.onetest.idea.persistent.AppPersistentService;
import com.onetest.idea.persistent.ProjectPersistentService;

import java.util.Date;

/**
 * @author guize
 * @date 2021/8/19
 */
public class TestPersistent {

    public void test() {
        final AppPersistentService persistentService = AppPersistentService.getInstance();
        persistentService.loadState(new Date().toString());
    }

}
