package org.apache.tools.ant.types.selectors;

/* loaded from: classes26.dex */
public interface SelectorScanner {
    java.lang.String[] getDeselectedDirectories();

    java.lang.String[] getDeselectedFiles();

    void setSelectors(org.apache.tools.ant.types.selectors.FileSelector[] fileSelectorArr);
}
