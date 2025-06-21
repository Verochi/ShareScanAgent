package org.apache.tools.ant.types.selectors;

/* loaded from: classes26.dex */
public abstract class BaseSelector extends org.apache.tools.ant.types.DataType implements org.apache.tools.ant.types.selectors.FileSelector {
    public java.lang.String n = null;
    public java.lang.Throwable t;

    public java.lang.String getError() {
        return this.n;
    }

    public abstract boolean isSelected(java.io.File file, java.lang.String str, java.io.File file2);

    public void setError(java.lang.String str) {
        if (this.n == null) {
            this.n = str;
        }
    }

    public void setError(java.lang.String str, java.lang.Throwable th) {
        if (this.n == null) {
            this.n = str;
            this.t = th;
        }
    }

    public void validate() {
        if (getError() == null) {
            verifySettings();
        }
        if (getError() != null) {
            throw new org.apache.tools.ant.BuildException(this.n, this.t);
        }
        if (isReference()) {
            return;
        }
        dieOnCircularReference();
    }

    public void verifySettings() {
        if (isReference()) {
            ((org.apache.tools.ant.types.selectors.BaseSelector) getCheckedRef()).verifySettings();
        }
    }
}
