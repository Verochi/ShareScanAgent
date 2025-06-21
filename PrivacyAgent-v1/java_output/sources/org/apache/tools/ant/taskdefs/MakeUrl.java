package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class MakeUrl extends org.apache.tools.ant.Task {
    public static final java.lang.String ERROR_MISSING_FILE = "A source file is missing: ";
    public static final java.lang.String ERROR_NO_FILES = "No files defined";
    public static final java.lang.String ERROR_NO_PROPERTY = "No property defined";
    public java.lang.String u;
    public java.io.File v;
    public java.lang.String w = " ";
    public java.util.List<org.apache.tools.ant.types.FileSet> x = new java.util.LinkedList();
    public java.util.List<org.apache.tools.ant.types.Path> y = new java.util.LinkedList();
    public boolean z = true;

    public void addFileSet(org.apache.tools.ant.types.FileSet fileSet) {
        this.x.add(fileSet);
    }

    public void addPath(org.apache.tools.ant.types.Path path) {
        this.y.add(path);
    }

    public final java.lang.String c() {
        if (this.x.isEmpty()) {
            return "";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.util.ListIterator<org.apache.tools.ant.types.FileSet> listIterator = this.x.listIterator();
        int i = 0;
        while (listIterator.hasNext()) {
            org.apache.tools.ant.DirectoryScanner directoryScanner = listIterator.next().getDirectoryScanner(getProject());
            for (java.lang.String str : directoryScanner.getIncludedFiles()) {
                java.io.File file = new java.io.File(directoryScanner.getBasedir(), str);
                g(file);
                java.lang.String f = f(file);
                sb.append(f);
                log(f, 4);
                sb.append(this.w);
                i++;
            }
        }
        return e(sb, i);
    }

    public final java.lang.String d() {
        if (this.y.isEmpty()) {
            return "";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.util.ListIterator<org.apache.tools.ant.types.Path> listIterator = this.y.listIterator();
        int i = 0;
        while (listIterator.hasNext()) {
            for (java.lang.String str : listIterator.next().list()) {
                java.io.File file = new java.io.File(str);
                g(file);
                java.lang.String f = f(file);
                sb.append(f);
                log(f, 4);
                sb.append(this.w);
                i++;
            }
        }
        return e(sb, i);
    }

    public final java.lang.String e(java.lang.StringBuilder sb, int i) {
        if (i <= 0) {
            return "";
        }
        sb.delete(sb.length() - this.w.length(), sb.length());
        return new java.lang.String(sb);
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        validate();
        if (getProject().getProperty(this.u) != null) {
            return;
        }
        java.lang.String c = c();
        java.io.File file = this.v;
        if (file != null) {
            g(file);
            java.lang.String f = f(this.v);
            if (c.length() > 0) {
                c = f + this.w + c;
            } else {
                c = f;
            }
        }
        java.lang.String d = d();
        if (d.length() > 0) {
            if (c.length() > 0) {
                c = c + this.w + d;
            } else {
                c = d;
            }
        }
        log("Setting " + this.u + " to URL " + c, 3);
        getProject().setNewProperty(this.u, c);
    }

    public final java.lang.String f(java.io.File file) {
        return org.apache.tools.ant.util.FileUtils.getFileUtils().toURI(file.getAbsolutePath());
    }

    public final void g(java.io.File file) {
        if (!this.z || file.exists()) {
            return;
        }
        throw new org.apache.tools.ant.BuildException(ERROR_MISSING_FILE + file.toString());
    }

    public void setFile(java.io.File file) {
        this.v = file;
    }

    public void setProperty(java.lang.String str) {
        this.u = str;
    }

    public void setSeparator(java.lang.String str) {
        this.w = str;
    }

    public void setValidate(boolean z) {
        this.z = z;
    }

    public final void validate() {
        if (this.u == null) {
            throw new org.apache.tools.ant.BuildException(ERROR_NO_PROPERTY);
        }
        if (this.v == null && this.x.isEmpty() && this.y.isEmpty()) {
            throw new org.apache.tools.ant.BuildException(ERROR_NO_FILES);
        }
    }
}
