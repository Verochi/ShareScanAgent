package org.apache.tools.ant.types.optional;

/* loaded from: classes26.dex */
public abstract class AbstractScriptComponent extends org.apache.tools.ant.ProjectComponent {
    public org.apache.tools.ant.util.ScriptRunnerHelper n = new org.apache.tools.ant.util.ScriptRunnerHelper();
    public org.apache.tools.ant.util.ScriptRunnerBase t = null;

    public void addText(java.lang.String str) {
        this.n.addText(str);
    }

    public org.apache.tools.ant.types.Path createClasspath() {
        return this.n.createClasspath();
    }

    public void executeScript(java.lang.String str) {
        getRunner().executeScript(str);
    }

    public org.apache.tools.ant.util.ScriptRunnerBase getRunner() {
        initScriptRunner();
        return this.t;
    }

    public void initScriptRunner() {
        if (this.t != null) {
            return;
        }
        this.n.setProjectComponent(this);
        this.t = this.n.getScriptRunner();
    }

    public void setClasspath(org.apache.tools.ant.types.Path path) {
        this.n.setClasspath(path);
    }

    public void setClasspathRef(org.apache.tools.ant.types.Reference reference) {
        this.n.setClasspathRef(reference);
    }

    public void setLanguage(java.lang.String str) {
        this.n.setLanguage(str);
    }

    public void setManager(java.lang.String str) {
        this.n.setManager(str);
    }

    @Override // org.apache.tools.ant.ProjectComponent
    public void setProject(org.apache.tools.ant.Project project) {
        super.setProject(project);
        this.n.setProjectComponent(this);
    }

    public void setSetBeans(boolean z) {
        this.n.setSetBeans(z);
    }

    public void setSrc(java.io.File file) {
        this.n.setSrc(file);
    }
}
