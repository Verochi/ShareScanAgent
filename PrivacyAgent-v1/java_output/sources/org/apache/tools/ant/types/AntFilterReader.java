package org.apache.tools.ant.types;

/* loaded from: classes26.dex */
public final class AntFilterReader extends org.apache.tools.ant.types.DataType {
    public java.lang.String n;
    public final java.util.Vector<org.apache.tools.ant.types.Parameter> t = new java.util.Vector<>();
    public org.apache.tools.ant.types.Path u;

    public void addParam(org.apache.tools.ant.types.Parameter parameter) {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        this.t.addElement(parameter);
    }

    public org.apache.tools.ant.types.Path createClasspath() {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        if (this.u == null) {
            this.u = new org.apache.tools.ant.types.Path(getProject());
        }
        setChecked(false);
        return this.u.createPath();
    }

    @Override // org.apache.tools.ant.types.DataType
    public synchronized void dieOnCircularReference(java.util.Stack<java.lang.Object> stack, org.apache.tools.ant.Project project) throws org.apache.tools.ant.BuildException {
        if (isChecked()) {
            return;
        }
        if (isReference()) {
            super.dieOnCircularReference(stack, project);
        } else {
            org.apache.tools.ant.types.Path path = this.u;
            if (path != null) {
                org.apache.tools.ant.types.DataType.pushAndInvokeCircularReferenceCheck(path, stack, project);
            }
            setChecked(true);
        }
    }

    public java.lang.String getClassName() {
        if (isReference()) {
            return ((org.apache.tools.ant.types.AntFilterReader) getCheckedRef()).getClassName();
        }
        dieOnCircularReference();
        return this.n;
    }

    public org.apache.tools.ant.types.Path getClasspath() {
        if (isReference()) {
            ((org.apache.tools.ant.types.AntFilterReader) getCheckedRef()).getClasspath();
        }
        dieOnCircularReference();
        return this.u;
    }

    public org.apache.tools.ant.types.Parameter[] getParams() {
        if (isReference()) {
            ((org.apache.tools.ant.types.AntFilterReader) getCheckedRef()).getParams();
        }
        dieOnCircularReference();
        org.apache.tools.ant.types.Parameter[] parameterArr = new org.apache.tools.ant.types.Parameter[this.t.size()];
        this.t.copyInto(parameterArr);
        return parameterArr;
    }

    public void setClassName(java.lang.String str) {
        if (isReference()) {
            throw tooManyAttributes();
        }
        this.n = str;
    }

    public void setClasspath(org.apache.tools.ant.types.Path path) {
        if (isReference()) {
            throw tooManyAttributes();
        }
        org.apache.tools.ant.types.Path path2 = this.u;
        if (path2 == null) {
            this.u = path;
        } else {
            path2.append(path);
        }
        setChecked(false);
    }

    public void setClasspathRef(org.apache.tools.ant.types.Reference reference) {
        if (isReference()) {
            throw tooManyAttributes();
        }
        createClasspath().setRefid(reference);
    }

    @Override // org.apache.tools.ant.types.DataType
    public void setRefid(org.apache.tools.ant.types.Reference reference) throws org.apache.tools.ant.BuildException {
        if (!this.t.isEmpty() || this.n != null || this.u != null) {
            throw tooManyAttributes();
        }
        super.setRefid(reference);
    }
}
