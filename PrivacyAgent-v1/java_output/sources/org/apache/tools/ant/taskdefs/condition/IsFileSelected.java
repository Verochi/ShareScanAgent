package org.apache.tools.ant.taskdefs.condition;

/* loaded from: classes25.dex */
public class IsFileSelected extends org.apache.tools.ant.types.selectors.AbstractSelectorContainer implements org.apache.tools.ant.taskdefs.condition.Condition {
    public static final org.apache.tools.ant.util.FileUtils v = org.apache.tools.ant.util.FileUtils.getFileUtils();
    public java.io.File t;
    public java.io.File u;

    @Override // org.apache.tools.ant.taskdefs.condition.Condition
    public boolean eval() {
        if (this.t == null) {
            throw new org.apache.tools.ant.BuildException("file attribute not set");
        }
        validate();
        java.io.File file = this.u;
        if (file == null) {
            file = getProject().getBaseDir();
        }
        return getSelectors(getProject())[0].isSelected(file, v.removeLeadingPath(file, this.t), this.t);
    }

    public void setBaseDir(java.io.File file) {
        this.u = file;
    }

    public void setFile(java.io.File file) {
        this.t = file;
    }

    @Override // org.apache.tools.ant.types.selectors.AbstractSelectorContainer
    public void validate() {
        if (selectorCount() != 1) {
            throw new org.apache.tools.ant.BuildException("Only one selector allowed");
        }
        super.validate();
    }
}
