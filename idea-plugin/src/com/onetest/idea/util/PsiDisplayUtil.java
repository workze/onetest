package com.onetest.idea.util;

import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiReference;

import java.util.Arrays;

/**
 * @author guize
 * @date 2021/8/27
 */
public class PsiDisplayUtil {

    public static String display(PsiElement element) {
        if (element == null) {
            return "null";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("class: ").append(element.getClass().getName()).append("\n");
        sb.append("text: ").append(element.getText()).append("\n");
        sb.append("psiFile: ").append(display(element.getContainingFile())).append("\n");
        // sb.append("Reference: ").append(display(element.getReference())).append("\n");
        // sb.append("parentReference: ").append(display(element.getParent()));

        sb.append("Children: ");
        Arrays.stream(element.getChildren()).forEach((item)->{
            sb.append(display(item));
        });
        sb.append("\n");

        sb.append("Reference: ").append(element.getReference()).append("\n");

        return sb.toString();
    }

    private static String display(PsiReference reference) {
        if (reference == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();

        sb.append("class: ").append(reference.getClass().getName()).append("\n");
        sb.append("CanonicalText: ").append(reference.getCanonicalText()).append("\n");
        sb.append("element: ").append(display(reference.getElement())).append("\n");

        return sb.toString();
    }

    public static String display(PsiFile file) {
        if (file == null) {
            return "null";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("class: ").append(file.getClass().getName()).append("\n");
        sb.append("text: ").append(file.getText()).append("\n");
        sb.append("virtualFile: ").append(file.getVirtualFile()).append("\n");
        sb.append("ModificationStamp: ").append(file.getModificationStamp()).append("\n");
        sb.append("FileType: ").append(file.getFileType()).append("\n");
        sb.append("name: ").append(file.getName()).append("\n");

        return sb.toString();
    }

    public static String display(VirtualFile file) {
        if (file == null) {
            return "null";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("class: ").append(file.getClass().getName()).append("\n");
        sb.append("path: ").append(file.getPath()).append("\n");
        sb.append("canonicalPath: ").append(file.getCanonicalPath()).append("\n");
        sb.append("Charset: ").append(file.getCharset()).append("\n");
        sb.append("Extension: ").append(file.getExtension()).append("\n");
        sb.append("url: ").append(file.getUrl()).append("\n");
        sb.append("url: ").append(file.getFileSystem()).append("\n");

        return sb.toString();
    }



}
