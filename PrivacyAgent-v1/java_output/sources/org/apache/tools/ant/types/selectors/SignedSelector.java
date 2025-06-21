package org.apache.tools.ant.types.selectors;

/* loaded from: classes26.dex */
public class SignedSelector extends org.apache.tools.ant.types.DataType implements org.apache.tools.ant.types.selectors.FileSelector {
    public org.apache.tools.ant.taskdefs.condition.IsSigned n = new org.apache.tools.ant.taskdefs.condition.IsSigned();

    @Override // org.apache.tools.ant.types.selectors.FileSelector
    public boolean isSelected(java.io.File file, java.lang.String str, java.io.File file2) {
        if (file2.isDirectory()) {
            return false;
        }
        this.n.setProject(getProject());
        this.n.setFile(file2);
        return this.n.eval();
    }

    public void setName(java.lang.String str) {
        this.n.setName(str);
    }
}
