package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class Copydir extends org.apache.tools.ant.taskdefs.MatchingTask {
    public java.io.File u;
    public java.io.File v;
    public boolean w = false;
    public boolean x = false;
    public boolean y = false;
    public java.util.Hashtable<java.lang.String, java.lang.String> z = new java.util.Hashtable<>();

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        log("DEPRECATED - The copydir task is deprecated.  Use copy instead.");
        java.io.File file = this.u;
        if (file == null) {
            throw new org.apache.tools.ant.BuildException("src attribute must be set!", getLocation());
        }
        if (!file.exists()) {
            throw new org.apache.tools.ant.BuildException("srcdir " + this.u.toString() + " does not exist!", getLocation());
        }
        java.io.File file2 = this.v;
        if (file2 == null) {
            throw new org.apache.tools.ant.BuildException("The dest attribute must be set.", getLocation());
        }
        if (this.u.equals(file2)) {
            log("Warning: src == dest", 1);
        }
        try {
            scanDir(this.u, this.v, super.getDirectoryScanner(this.u).getIncludedFiles());
            if (this.z.size() > 0) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Copying ");
                sb.append(this.z.size());
                sb.append(" file");
                sb.append(this.z.size() == 1 ? "" : "s");
                sb.append(" to ");
                sb.append(this.v.getAbsolutePath());
                log(sb.toString());
                for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : this.z.entrySet()) {
                    java.lang.String key = entry.getKey();
                    java.lang.String value = entry.getValue();
                    try {
                        getProject().copyFile(key, value, this.w, this.y);
                    } catch (java.io.IOException e) {
                        throw new org.apache.tools.ant.BuildException("Failed to copy " + key + " to " + value + " due to " + e.getMessage(), e, getLocation());
                    }
                }
            }
        } finally {
            this.z.clear();
        }
    }

    public final void scanDir(java.io.File file, java.io.File file2, java.lang.String[] strArr) {
        for (java.lang.String str : strArr) {
            java.io.File file3 = new java.io.File(file, str);
            java.io.File file4 = this.x ? new java.io.File(file2, new java.io.File(str).getName()) : new java.io.File(file2, str);
            if (this.y || file3.lastModified() > file4.lastModified()) {
                this.z.put(file3.getAbsolutePath(), file4.getAbsolutePath());
            }
        }
    }

    public void setDest(java.io.File file) {
        this.v = file;
    }

    public void setFiltering(boolean z) {
        this.w = z;
    }

    public void setFlatten(boolean z) {
        this.x = z;
    }

    public void setForceoverwrite(boolean z) {
        this.y = z;
    }

    public void setSrc(java.io.File file) {
        this.u = file;
    }
}
