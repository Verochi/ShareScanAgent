package org.apache.tools.ant.taskdefs.optional.jsp.compilers;

/* loaded from: classes25.dex */
public interface JspCompilerAdapter {
    org.apache.tools.ant.taskdefs.optional.jsp.JspMangler createMangler();

    boolean execute() throws org.apache.tools.ant.BuildException;

    boolean implementsOwnDependencyChecking();

    void setJspc(org.apache.tools.ant.taskdefs.optional.jsp.JspC jspC);
}
