package org.apache.tools.ant.taskdefs.optional.extension;

/* loaded from: classes25.dex */
public class ExtensionSet extends org.apache.tools.ant.types.DataType {
    public final java.util.ArrayList n = new java.util.ArrayList();
    public final java.util.ArrayList t = new java.util.ArrayList();

    public void addExtension(org.apache.tools.ant.taskdefs.optional.extension.ExtensionAdapter extensionAdapter) {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        setChecked(false);
        this.n.add(extensionAdapter);
    }

    public void addFileset(org.apache.tools.ant.types.FileSet fileSet) {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        setChecked(false);
        this.t.add(fileSet);
    }

    public void addLibfileset(org.apache.tools.ant.taskdefs.optional.extension.LibFileSet libFileSet) {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        setChecked(false);
        this.t.add(libFileSet);
    }

    @Override // org.apache.tools.ant.types.DataType
    public synchronized void dieOnCircularReference(java.util.Stack stack, org.apache.tools.ant.Project project) throws org.apache.tools.ant.BuildException {
        if (isChecked()) {
            return;
        }
        if (isReference()) {
            super.dieOnCircularReference(stack, project);
        } else {
            java.util.Iterator it = this.n.iterator();
            while (it.hasNext()) {
                org.apache.tools.ant.types.DataType.pushAndInvokeCircularReferenceCheck((org.apache.tools.ant.taskdefs.optional.extension.ExtensionAdapter) it.next(), stack, project);
            }
            java.util.Iterator it2 = this.t.iterator();
            while (it2.hasNext()) {
                org.apache.tools.ant.types.DataType.pushAndInvokeCircularReferenceCheck((org.apache.tools.ant.types.FileSet) it2.next(), stack, project);
            }
            setChecked(true);
        }
    }

    @Override // org.apache.tools.ant.types.DataType
    public void setRefid(org.apache.tools.ant.types.Reference reference) throws org.apache.tools.ant.BuildException {
        if (!this.n.isEmpty() || !this.t.isEmpty()) {
            throw tooManyAttributes();
        }
        super.setRefid(reference);
    }

    public org.apache.tools.ant.taskdefs.optional.extension.Extension[] toExtensions(org.apache.tools.ant.Project project) throws org.apache.tools.ant.BuildException {
        if (isReference()) {
            return ((org.apache.tools.ant.taskdefs.optional.extension.ExtensionSet) getCheckedRef()).toExtensions(project);
        }
        dieOnCircularReference();
        java.util.ArrayList g = org.apache.tools.ant.taskdefs.optional.extension.ExtensionUtil.g(this.n);
        org.apache.tools.ant.taskdefs.optional.extension.ExtensionUtil.c(project, g, this.t);
        return (org.apache.tools.ant.taskdefs.optional.extension.Extension[]) g.toArray(new org.apache.tools.ant.taskdefs.optional.extension.Extension[g.size()]);
    }

    @Override // org.apache.tools.ant.types.DataType
    public java.lang.String toString() {
        return "ExtensionSet" + java.util.Arrays.asList(toExtensions(getProject()));
    }
}
