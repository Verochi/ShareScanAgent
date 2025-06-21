package org.apache.tools.ant.taskdefs.compilers;

/* loaded from: classes25.dex */
public interface CompilerAdapter {
    boolean execute() throws org.apache.tools.ant.BuildException;

    void setJavac(org.apache.tools.ant.taskdefs.Javac javac);
}
