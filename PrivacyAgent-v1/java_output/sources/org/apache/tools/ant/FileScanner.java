package org.apache.tools.ant;

/* loaded from: classes25.dex */
public interface FileScanner {
    void addDefaultExcludes();

    java.io.File getBasedir();

    java.lang.String[] getExcludedDirectories();

    java.lang.String[] getExcludedFiles();

    java.lang.String[] getIncludedDirectories();

    java.lang.String[] getIncludedFiles();

    java.lang.String[] getNotIncludedDirectories();

    java.lang.String[] getNotIncludedFiles();

    void scan() throws java.lang.IllegalStateException;

    void setBasedir(java.io.File file);

    void setBasedir(java.lang.String str);

    void setCaseSensitive(boolean z);

    void setExcludes(java.lang.String[] strArr);

    void setIncludes(java.lang.String[] strArr);
}
