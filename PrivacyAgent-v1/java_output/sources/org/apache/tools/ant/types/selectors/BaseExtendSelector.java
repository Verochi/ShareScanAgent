package org.apache.tools.ant.types.selectors;

/* loaded from: classes26.dex */
public abstract class BaseExtendSelector extends org.apache.tools.ant.types.selectors.BaseSelector implements org.apache.tools.ant.types.selectors.ExtendFileSelector {
    protected org.apache.tools.ant.types.Parameter[] parameters = null;

    public org.apache.tools.ant.types.Parameter[] getParameters() {
        return this.parameters;
    }

    @Override // org.apache.tools.ant.types.selectors.BaseSelector, org.apache.tools.ant.types.selectors.FileSelector
    public abstract boolean isSelected(java.io.File file, java.lang.String str, java.io.File file2) throws org.apache.tools.ant.BuildException;

    @Override // org.apache.tools.ant.types.Parameterizable
    public void setParameters(org.apache.tools.ant.types.Parameter[] parameterArr) {
        this.parameters = parameterArr;
    }
}
