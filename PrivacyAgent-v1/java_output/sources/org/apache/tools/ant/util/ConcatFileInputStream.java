package org.apache.tools.ant.util;

/* loaded from: classes26.dex */
public class ConcatFileInputStream extends java.io.InputStream {
    public int n = -1;
    public boolean t = false;
    public java.io.File[] u;
    public java.io.InputStream v;
    public org.apache.tools.ant.ProjectComponent w;

    public ConcatFileInputStream(java.io.File[] fileArr) throws java.io.IOException {
        this.u = fileArr;
    }

    public final void a() {
        org.apache.tools.ant.util.FileUtils.close(this.v);
        this.v = null;
    }

    public final void b(int i) throws java.io.IOException {
        a();
        java.io.File[] fileArr = this.u;
        if (fileArr == null || i >= fileArr.length) {
            this.t = true;
            return;
        }
        log("Opening " + this.u[i], 3);
        try {
            this.v = new java.io.BufferedInputStream(new java.io.FileInputStream(this.u[i]));
        } catch (java.io.IOException e) {
            log("Failed to open " + this.u[i], 0);
            throw e;
        }
    }

    public final int c() throws java.io.IOException {
        java.io.InputStream inputStream;
        if (this.t || (inputStream = this.v) == null) {
            return -1;
        }
        return inputStream.read();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        a();
        this.t = true;
    }

    public void log(java.lang.String str, int i) {
        org.apache.tools.ant.ProjectComponent projectComponent = this.w;
        if (projectComponent != null) {
            projectComponent.log(str, i);
        } else if (i > 1) {
            java.lang.System.out.println(str);
        } else {
            java.lang.System.err.println(str);
        }
    }

    @Override // java.io.InputStream
    public int read() throws java.io.IOException {
        int c = c();
        if (c != -1 || this.t) {
            return c;
        }
        int i = this.n + 1;
        this.n = i;
        b(i);
        return c();
    }

    public void setManagingComponent(org.apache.tools.ant.ProjectComponent projectComponent) {
        this.w = projectComponent;
    }

    public void setManagingTask(org.apache.tools.ant.Task task) {
        setManagingComponent(task);
    }
}
