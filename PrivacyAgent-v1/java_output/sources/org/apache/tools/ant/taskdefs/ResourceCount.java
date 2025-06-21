package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class ResourceCount extends org.apache.tools.ant.Task implements org.apache.tools.ant.taskdefs.condition.Condition {
    public org.apache.tools.ant.types.ResourceCollection u;
    public org.apache.tools.ant.types.Comparison v = org.apache.tools.ant.types.Comparison.EQUAL;
    public java.lang.Integer w;
    public java.lang.String x;

    public void add(org.apache.tools.ant.types.ResourceCollection resourceCollection) {
        if (this.u != null) {
            throw new org.apache.tools.ant.BuildException("ResourceCount can count resources from exactly one nested ResourceCollection.");
        }
        this.u = resourceCollection;
    }

    @Override // org.apache.tools.ant.taskdefs.condition.Condition
    public boolean eval() {
        org.apache.tools.ant.types.ResourceCollection resourceCollection = this.u;
        if (resourceCollection == null) {
            throw new org.apache.tools.ant.BuildException("ResourceCount can count resources from exactly one nested ResourceCollection.");
        }
        if (this.w != null) {
            return this.v.evaluate(new java.lang.Integer(resourceCollection.size()).compareTo(this.w));
        }
        throw new org.apache.tools.ant.BuildException("Use of the ResourceCount condition requires that the count attribute be set.");
    }

    @Override // org.apache.tools.ant.Task
    public void execute() {
        if (this.u == null) {
            throw new org.apache.tools.ant.BuildException("ResourceCount can count resources from exactly one nested ResourceCollection.");
        }
        if (this.x != null) {
            getProject().setNewProperty(this.x, java.lang.Integer.toString(this.u.size()));
            return;
        }
        log("resource count = " + this.u.size());
    }

    public void setCount(int i) {
        this.w = new java.lang.Integer(i);
    }

    public void setProperty(java.lang.String str) {
        this.x = str;
    }

    public void setRefid(org.apache.tools.ant.types.Reference reference) {
        java.lang.Object referencedObject = reference.getReferencedObject();
        if (referencedObject instanceof org.apache.tools.ant.types.ResourceCollection) {
            add((org.apache.tools.ant.types.ResourceCollection) referencedObject);
            return;
        }
        throw new org.apache.tools.ant.BuildException(reference.getRefId() + " doesn't denote a ResourceCollection");
    }

    public void setWhen(org.apache.tools.ant.types.Comparison comparison) {
        this.v = comparison;
    }
}
