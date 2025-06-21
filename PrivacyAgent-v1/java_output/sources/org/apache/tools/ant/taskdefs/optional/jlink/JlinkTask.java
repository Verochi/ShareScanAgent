package org.apache.tools.ant.taskdefs.optional.jlink;

/* loaded from: classes25.dex */
public class JlinkTask extends org.apache.tools.ant.taskdefs.MatchingTask {
    public java.io.File u = null;
    public org.apache.tools.ant.types.Path v = null;
    public org.apache.tools.ant.types.Path w = null;
    public boolean x = false;

    public final boolean c() {
        return d(this.w);
    }

    public org.apache.tools.ant.types.Path createAddfiles() {
        if (this.w == null) {
            this.w = new org.apache.tools.ant.types.Path(getProject());
        }
        return this.w.createPath();
    }

    public org.apache.tools.ant.types.Path createMergefiles() {
        if (this.v == null) {
            this.v = new org.apache.tools.ant.types.Path(getProject());
        }
        return this.v.createPath();
    }

    public final boolean d(org.apache.tools.ant.types.Path path) {
        return path != null && path.size() > 0;
    }

    public final boolean e() {
        return d(this.v);
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        if (this.u == null) {
            throw new org.apache.tools.ant.BuildException("outfile attribute is required! Please set.");
        }
        if (!c() && !e()) {
            throw new org.apache.tools.ant.BuildException("addfiles or mergefiles required! Please set.");
        }
        log("linking:     " + this.u.getPath());
        log("compression: " + this.x, 3);
        org.apache.tools.ant.taskdefs.optional.jlink.jlink jlinkVar = new org.apache.tools.ant.taskdefs.optional.jlink.jlink();
        jlinkVar.setOutfile(this.u.getPath());
        jlinkVar.setCompression(this.x);
        if (e()) {
            log("merge files: " + this.v.toString(), 3);
            jlinkVar.addMergeFiles(this.v.list());
        }
        if (c()) {
            log("add files: " + this.w.toString(), 3);
            jlinkVar.addAddFiles(this.w.list());
        }
        try {
            jlinkVar.link();
        } catch (java.lang.Exception e) {
            throw new org.apache.tools.ant.BuildException(e, getLocation());
        }
    }

    public void setAddfiles(org.apache.tools.ant.types.Path path) {
        org.apache.tools.ant.types.Path path2 = this.w;
        if (path2 == null) {
            this.w = path;
        } else {
            path2.append(path);
        }
    }

    public void setCompress(boolean z) {
        this.x = z;
    }

    public void setMergefiles(org.apache.tools.ant.types.Path path) {
        org.apache.tools.ant.types.Path path2 = this.v;
        if (path2 == null) {
            this.v = path;
        } else {
            path2.append(path);
        }
    }

    public void setOutfile(java.io.File file) {
        this.u = file;
    }
}
