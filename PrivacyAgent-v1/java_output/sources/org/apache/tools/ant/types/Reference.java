package org.apache.tools.ant.types;

/* loaded from: classes26.dex */
public class Reference {
    public java.lang.String a;
    public org.apache.tools.ant.Project b;

    @java.lang.Deprecated
    public Reference() {
    }

    @java.lang.Deprecated
    public Reference(java.lang.String str) {
        setRefId(str);
    }

    public Reference(org.apache.tools.ant.Project project, java.lang.String str) {
        setRefId(str);
        setProject(project);
    }

    public org.apache.tools.ant.Project getProject() {
        return this.b;
    }

    public java.lang.String getRefId() {
        return this.a;
    }

    public java.lang.Object getReferencedObject() throws org.apache.tools.ant.BuildException {
        org.apache.tools.ant.Project project = this.b;
        if (project != null) {
            return getReferencedObject(project);
        }
        throw new org.apache.tools.ant.BuildException("No project set on reference to " + this.a);
    }

    public java.lang.Object getReferencedObject(org.apache.tools.ant.Project project) throws org.apache.tools.ant.BuildException {
        java.lang.String str = this.a;
        if (str == null) {
            throw new org.apache.tools.ant.BuildException("No reference specified");
        }
        org.apache.tools.ant.Project project2 = this.b;
        java.lang.Object reference = project2 == null ? project.getReference(str) : project2.getReference(str);
        if (reference != null) {
            return reference;
        }
        throw new org.apache.tools.ant.BuildException("Reference " + this.a + " not found.");
    }

    public void setProject(org.apache.tools.ant.Project project) {
        this.b = project;
    }

    public void setRefId(java.lang.String str) {
        this.a = str;
    }
}
