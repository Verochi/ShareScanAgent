package org.apache.tools.ant.taskdefs.condition;

/* loaded from: classes25.dex */
public class ResourceExists extends org.apache.tools.ant.ProjectComponent implements org.apache.tools.ant.taskdefs.condition.Condition {
    public org.apache.tools.ant.types.Resource n;

    public void add(org.apache.tools.ant.types.Resource resource) {
        if (this.n != null) {
            throw new org.apache.tools.ant.BuildException("only one resource can be tested");
        }
        this.n = resource;
    }

    @Override // org.apache.tools.ant.taskdefs.condition.Condition
    public boolean eval() throws org.apache.tools.ant.BuildException {
        validate();
        return this.n.isExists();
    }

    public void validate() throws org.apache.tools.ant.BuildException {
        if (this.n == null) {
            throw new org.apache.tools.ant.BuildException("resource is required");
        }
    }
}
