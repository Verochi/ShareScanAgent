package org.apache.tools.ant;

/* loaded from: classes25.dex */
public abstract class ProjectComponent implements java.lang.Cloneable {

    @java.lang.Deprecated
    protected java.lang.String description;

    @java.lang.Deprecated
    protected org.apache.tools.ant.Location location = org.apache.tools.ant.Location.UNKNOWN_LOCATION;

    @java.lang.Deprecated
    protected org.apache.tools.ant.Project project;

    public java.lang.Object clone() throws java.lang.CloneNotSupportedException {
        org.apache.tools.ant.ProjectComponent projectComponent = (org.apache.tools.ant.ProjectComponent) super.clone();
        projectComponent.setLocation(getLocation());
        projectComponent.setProject(getProject());
        return projectComponent;
    }

    public java.lang.String getDescription() {
        return this.description;
    }

    public org.apache.tools.ant.Location getLocation() {
        return this.location;
    }

    public org.apache.tools.ant.Project getProject() {
        return this.project;
    }

    public void log(java.lang.String str) {
        log(str, 2);
    }

    public void log(java.lang.String str, int i) {
        if (getProject() != null) {
            getProject().log(str, i);
        } else if (i <= 2) {
            java.lang.System.err.println(str);
        }
    }

    public void setDescription(java.lang.String str) {
        this.description = str;
    }

    public void setLocation(org.apache.tools.ant.Location location) {
        this.location = location;
    }

    public void setProject(org.apache.tools.ant.Project project) {
        this.project = project;
    }
}
