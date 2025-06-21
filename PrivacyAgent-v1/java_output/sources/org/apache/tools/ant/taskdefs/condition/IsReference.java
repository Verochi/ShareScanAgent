package org.apache.tools.ant.taskdefs.condition;

/* loaded from: classes25.dex */
public class IsReference extends org.apache.tools.ant.ProjectComponent implements org.apache.tools.ant.taskdefs.condition.Condition {
    public org.apache.tools.ant.types.Reference n;
    public java.lang.String t;

    @Override // org.apache.tools.ant.taskdefs.condition.Condition
    public boolean eval() throws org.apache.tools.ant.BuildException {
        org.apache.tools.ant.types.Reference reference = this.n;
        if (reference == null) {
            throw new org.apache.tools.ant.BuildException("No reference specified for isreference condition");
        }
        java.lang.String refId = reference.getRefId();
        if (!getProject().hasReference(refId)) {
            return false;
        }
        if (this.t == null) {
            return true;
        }
        java.lang.Object reference2 = getProject().getReference(refId);
        java.lang.Class<?> cls = getProject().getDataTypeDefinitions().get(this.t);
        if (cls == null) {
            cls = getProject().getTaskDefinitions().get(this.t);
        }
        if (cls == null) {
            return false;
        }
        return cls.isAssignableFrom(reference2.getClass());
    }

    public void setRefid(org.apache.tools.ant.types.Reference reference) {
        this.n = reference;
    }

    public void setType(java.lang.String str) {
        this.t = str;
    }
}
