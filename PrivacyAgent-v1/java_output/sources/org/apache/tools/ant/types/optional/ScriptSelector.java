package org.apache.tools.ant.types.optional;

/* loaded from: classes26.dex */
public class ScriptSelector extends org.apache.tools.ant.types.selectors.BaseSelector {
    public org.apache.tools.ant.util.ScriptRunnerHelper u = new org.apache.tools.ant.util.ScriptRunnerHelper();
    public org.apache.tools.ant.util.ScriptRunnerBase v;
    public java.io.File w;
    public java.lang.String x;
    public java.io.File y;
    public boolean z;

    public void addText(java.lang.String str) {
        this.u.addText(str);
    }

    public org.apache.tools.ant.types.Path createClasspath() {
        return this.u.createClasspath();
    }

    public java.io.File getBasedir() {
        return this.w;
    }

    public java.io.File getFile() {
        return this.y;
    }

    public java.lang.String getFilename() {
        return this.x;
    }

    public final void init() throws org.apache.tools.ant.BuildException {
        if (this.v != null) {
            return;
        }
        this.v = this.u.getScriptRunner();
    }

    public boolean isSelected() {
        return this.z;
    }

    @Override // org.apache.tools.ant.types.selectors.BaseSelector, org.apache.tools.ant.types.selectors.FileSelector
    public boolean isSelected(java.io.File file, java.lang.String str, java.io.File file2) {
        init();
        setSelected(true);
        this.y = file2;
        this.w = file;
        this.x = str;
        this.v.addBean(org.apache.tools.ant.MagicNames.PROJECT_BASEDIR, file);
        this.v.addBean(com.liulishuo.filedownloader.model.FileDownloadModel.FILENAME, str);
        this.v.addBean("file", file2);
        this.v.executeScript("ant_selector");
        return isSelected();
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

    public void setSelected(boolean z) {
        this.z = z;
    }

    public void setSetBeans(boolean z) {
        this.u.setSetBeans(z);
    }

    public void setSrc(java.io.File file) {
        this.u.setSrc(file);
    }
}
