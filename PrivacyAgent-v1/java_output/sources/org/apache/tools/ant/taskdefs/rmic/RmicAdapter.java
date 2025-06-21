package org.apache.tools.ant.taskdefs.rmic;

/* loaded from: classes25.dex */
public interface RmicAdapter {
    boolean execute() throws org.apache.tools.ant.BuildException;

    org.apache.tools.ant.types.Path getClasspath();

    org.apache.tools.ant.util.FileNameMapper getMapper();

    void setRmic(org.apache.tools.ant.taskdefs.Rmic rmic);
}
