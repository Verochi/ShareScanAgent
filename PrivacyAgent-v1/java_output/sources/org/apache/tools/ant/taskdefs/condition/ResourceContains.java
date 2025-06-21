package org.apache.tools.ant.taskdefs.condition;

/* loaded from: classes25.dex */
public class ResourceContains implements org.apache.tools.ant.taskdefs.condition.Condition {
    public org.apache.tools.ant.Project n;
    public java.lang.String t;
    public org.apache.tools.ant.types.Resource u;
    public java.lang.String v;
    public boolean w = true;

    public final void a() {
        try {
            if (getProject() == null) {
                throw new org.apache.tools.ant.BuildException("Cannot retrieve refid; project unset");
            }
            java.lang.Object reference = getProject().getReference(this.v);
            if (!(reference instanceof org.apache.tools.ant.types.Resource)) {
                if (!(reference instanceof org.apache.tools.ant.types.ResourceCollection)) {
                    throw new org.apache.tools.ant.BuildException("Illegal value at '" + this.v + "': " + java.lang.String.valueOf(reference));
                }
                org.apache.tools.ant.types.ResourceCollection resourceCollection = (org.apache.tools.ant.types.ResourceCollection) reference;
                if (resourceCollection.size() == 1) {
                    reference = resourceCollection.iterator().next();
                }
            }
            this.u = (org.apache.tools.ant.types.Resource) reference;
        } finally {
            this.v = null;
        }
    }

    public final void b() {
        org.apache.tools.ant.types.Resource resource = this.u;
        if (resource != null && this.v != null) {
            throw new org.apache.tools.ant.BuildException("Cannot set both resource and refid");
        }
        if (resource == null && this.v != null) {
            a();
        }
        if (this.u == null || this.t == null) {
            throw new org.apache.tools.ant.BuildException("both resource and substring are required in <resourcecontains>");
        }
    }

    @Override // org.apache.tools.ant.taskdefs.condition.Condition
    public synchronized boolean eval() throws org.apache.tools.ant.BuildException {
        java.io.BufferedReader bufferedReader;
        java.lang.Throwable th;
        b();
        if (this.t.length() == 0) {
            if (getProject() != null) {
                getProject().log("Substring is empty; returning true", 3);
            }
            return true;
        }
        if (this.u.getSize() == 0) {
            return false;
        }
        java.io.BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(this.u.getInputStream()));
            } catch (java.io.IOException unused) {
            }
        } catch (java.lang.Throwable th2) {
            bufferedReader = bufferedReader2;
            th = th2;
        }
        try {
            java.lang.String safeReadFully = org.apache.tools.ant.util.FileUtils.safeReadFully(bufferedReader);
            java.lang.String str = this.t;
            if (!this.w) {
                safeReadFully = safeReadFully.toLowerCase();
                str = str.toLowerCase();
            }
            boolean contains = safeReadFully.contains(str);
            org.apache.tools.ant.util.FileUtils.close(bufferedReader);
            return contains;
        } catch (java.io.IOException unused2) {
            bufferedReader2 = bufferedReader;
            throw new org.apache.tools.ant.BuildException("There was a problem accessing resource : " + this.u);
        } catch (java.lang.Throwable th3) {
            th = th3;
            org.apache.tools.ant.util.FileUtils.close(bufferedReader);
            throw th;
        }
    }

    public org.apache.tools.ant.Project getProject() {
        return this.n;
    }

    public void setCasesensitive(boolean z) {
        this.w = z;
    }

    public void setProject(org.apache.tools.ant.Project project) {
        this.n = project;
    }

    public void setRefid(java.lang.String str) {
        this.v = str;
    }

    public void setResource(java.lang.String str) {
        this.u = new org.apache.tools.ant.types.resources.FileResource(new java.io.File(str));
    }

    public void setSubstring(java.lang.String str) {
        this.t = str;
    }
}
