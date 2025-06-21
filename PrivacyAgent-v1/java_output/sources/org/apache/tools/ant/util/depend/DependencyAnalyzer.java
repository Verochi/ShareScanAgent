package org.apache.tools.ant.util.depend;

/* loaded from: classes26.dex */
public interface DependencyAnalyzer {
    void addClassPath(org.apache.tools.ant.types.Path path);

    void addRootClass(java.lang.String str);

    void addSourcePath(org.apache.tools.ant.types.Path path);

    void config(java.lang.String str, java.lang.Object obj);

    java.io.File getClassContainer(java.lang.String str) throws java.io.IOException;

    java.util.Enumeration<java.lang.String> getClassDependencies();

    java.util.Enumeration<java.io.File> getFileDependencies();

    java.io.File getSourceContainer(java.lang.String str) throws java.io.IOException;

    void reset();

    void setClosure(boolean z);
}
