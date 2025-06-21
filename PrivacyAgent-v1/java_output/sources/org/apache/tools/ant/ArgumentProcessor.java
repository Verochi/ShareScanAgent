package org.apache.tools.ant;

/* loaded from: classes25.dex */
public interface ArgumentProcessor {
    boolean handleArg(java.util.List<java.lang.String> list);

    boolean handleArg(org.apache.tools.ant.Project project, java.util.List<java.lang.String> list);

    void prepareConfigure(org.apache.tools.ant.Project project, java.util.List<java.lang.String> list);

    void printUsage(java.io.PrintStream printStream);

    int readArguments(java.lang.String[] strArr, int i);
}
