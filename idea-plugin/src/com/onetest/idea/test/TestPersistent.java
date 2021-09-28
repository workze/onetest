package com.onetest.idea.test;

import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiPrimitiveType;
import com.intellij.psi.PsiType;
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

        PsiClass psiClass;

        PsiType psiType;

        PsiPrimitiveType psiPrimitiveType;

    }

}
