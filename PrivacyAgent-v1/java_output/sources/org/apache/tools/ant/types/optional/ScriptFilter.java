package org.apache.tools.ant.types.optional;

/* loaded from: classes26.dex */
public class ScriptFilter extends org.apache.tools.ant.filters.TokenFilter.ChainableReaderFilter {
    public org.apache.tools.ant.util.ScriptRunnerHelper t = new org.apache.tools.ant.util.ScriptRunnerHelper();
    public org.apache.tools.ant.util.ScriptRunnerBase u = null;
    public java.lang.String v;

    public void addText(java.lang.String str) {
        this.t.addText(str);
    }

    public org.apache.tools.ant.types.Path createClasspath() {
        return this.t.createClasspath();
    }

    @Override // org.apache.tools.ant.filters.TokenFilter.Filter
    public java.lang.String filter(java.lang.String str) {
        init();
        setToken(str);
        this.u.executeScript("ant_filter");
        return getToken();
    }

    public java.lang.String getToken() {
        return this.v;
    }

    public final void init() throws org.apache.tools.ant.BuildException {
        if (this.u != null) {
            return;
        }
        this.u = this.t.getScriptRunner();
    }

    public void setClasspath(org.apache.tools.ant.types.Path path) {
        this.t.setClasspath(path);
    }

    public void setClasspathRef(org.apache.tools.ant.types.Reference reference) {
        this.t.setClasspathRef(reference);
    }

    public void setLanguage(java.lang.String str) {
        this.t.setLanguage(str);
    }

    public void setManager(java.lang.String str) {
        this.t.setManager(str);
    }

    @Override // org.apache.tools.ant.ProjectComponent
    public void setProject(org.apache.tools.ant.Project project) {
        super.setProject(project);
        this.t.setProjectComponent(this);
    }

    public void setSetBeans(boolean z) {
        this.t.setSetBeans(z);
    }

    public void setSrc(java.io.File file) {
        this.t.setSrc(file);
    }

    public void setToken(java.lang.String str) {
        this.v = str;
    }
}
