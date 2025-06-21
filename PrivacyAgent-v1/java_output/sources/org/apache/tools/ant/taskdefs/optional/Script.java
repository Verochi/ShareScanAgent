package org.apache.tools.ant.taskdefs.optional;

/* loaded from: classes25.dex */
public class Script extends org.apache.tools.ant.Task {
    public org.apache.tools.ant.util.ScriptRunnerHelper u = new org.apache.tools.ant.util.ScriptRunnerHelper();

    public void addText(java.lang.String str) {
        this.u.addText(str);
    }

    public org.apache.tools.ant.types.Path createClasspath() {
        return this.u.createClasspath();
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        this.u.getScriptRunner().executeScript("ANT");
    }

    public void setClasspath(org.apache.tools.ant.types.Path path) {
        this.u.setClasspath(path);
    }

    public void setClasspathRef(org.apache.tools.ant.types.Reference reference) {
        this.u.setClasspathRef(reference);
    }

    public void setLanguage(java.lang.String str) {
        this.u.setLanguage(str);
    }

    public void setManager(java.lang.String str) {
        this.u.setManager(str);
    }

    @Override // org.apache.tools.ant.ProjectComponent
    public void setProject(org.apache.tools.ant.Project project) {
        super.setProject(project);
        this.u.setProjectComponent(this);
    }

    public void setSetBeans(boolean z) {
        this.u.setSetBeans(z);
    }

    public void setSrc(java.lang.String str) {
        this.u.setSrc(new java.io.File(str));
    }
}
