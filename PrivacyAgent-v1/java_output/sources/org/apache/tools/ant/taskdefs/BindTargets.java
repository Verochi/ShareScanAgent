package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class BindTargets extends org.apache.tools.ant.Task {
    public java.lang.String u;
    public final java.util.List<java.lang.String> v = new java.util.ArrayList();
    public org.apache.tools.ant.ProjectHelper.OnMissingExtensionPoint w;

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        if (this.u == null) {
            throw new org.apache.tools.ant.BuildException("extensionPoint required", getLocation());
        }
        if (getOwningTarget() == null || !"".equals(getOwningTarget().getName())) {
            throw new org.apache.tools.ant.BuildException("bindtargets only allowed as a top-level task");
        }
        if (this.w == null) {
            this.w = org.apache.tools.ant.ProjectHelper.OnMissingExtensionPoint.FAIL;
        }
        org.apache.tools.ant.ProjectHelper projectHelper = (org.apache.tools.ant.ProjectHelper) getProject().getReference("ant.projectHelper");
        java.util.Iterator<java.lang.String> it = this.v.iterator();
        while (it.hasNext()) {
            projectHelper.getExtensionStack().add(new java.lang.String[]{this.u, it.next(), this.w.name()});
        }
    }

    public void setExtensionPoint(java.lang.String str) {
        this.u = str;
    }

    public void setOnMissingExtensionPoint(java.lang.String str) {
        try {
            this.w = org.apache.tools.ant.ProjectHelper.OnMissingExtensionPoint.valueOf(str);
        } catch (java.lang.IllegalArgumentException unused) {
            throw new org.apache.tools.ant.BuildException("Invalid onMissingExtensionPoint: " + str);
        }
    }

    public void setOnMissingExtensionPoint(org.apache.tools.ant.ProjectHelper.OnMissingExtensionPoint onMissingExtensionPoint) {
        this.w = onMissingExtensionPoint;
    }

    public void setTargets(java.lang.String str) {
        for (java.lang.String str2 : str.split(",")) {
            java.lang.String trim = str2.trim();
            if (trim.length() > 0) {
                this.v.add(trim);
            }
        }
    }
}
