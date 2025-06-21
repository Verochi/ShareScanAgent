package org.apache.tools.ant.util;

/* loaded from: classes26.dex */
public class ConcatResourceInputStream extends java.io.InputStream {
    public java.util.Iterator<org.apache.tools.ant.types.Resource> t;
    public java.io.InputStream u;
    public org.apache.tools.ant.ProjectComponent v;
    public boolean n = false;
    public boolean w = false;

    public ConcatResourceInputStream(org.apache.tools.ant.types.ResourceCollection resourceCollection) {
        this.t = resourceCollection.iterator();
    }

    public final void a() {
        org.apache.tools.ant.util.FileUtils.close(this.u);
        this.u = null;
    }

    public final void c() throws java.io.IOException {
        a();
        while (this.t.hasNext()) {
            org.apache.tools.ant.types.Resource next = this.t.next();
            if (next.isExists()) {
                log("Concatenating " + next.toLongString(), 3);
                try {
                    this.u = new java.io.BufferedInputStream(next.getInputStream());
                    return;
                } catch (java.io.IOException e) {
                    if (!this.w) {
                        log("Failed to get input stream for " + next, 0);
                        throw e;
                    }
                }
            }
        }
        this.n = true;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        a();
        this.n = true;
    }

    public final int e() throws java.io.IOException {
        java.io.InputStream inputStream;
        if (this.n || (inputStream = this.u) == null) {
            return -1;
        }
        return inputStream.read();
    }

    public boolean isIgnoreErrors() {
        return this.w;
    }

    public void log(java.lang.String str, int i) {
        org.apache.tools.ant.ProjectComponent projectComponent = this.v;
        if (projectComponent != null) {
            projectComponent.log(str, i);
        } else {
            (i > 1 ? java.lang.System.out : java.lang.System.err).println(str);
        }
    }

    @Override // java.io.InputStream
    public int read() throws java.io.IOException {
        if (this.n) {
            return -1;
        }
        int e = e();
        if (e != -1) {
            return e;
        }
        c();
        return e();
    }

    public void setIgnoreErrors(boolean z) {
        this.w = z;
    }

    public void setManagingComponent(org.apache.tools.ant.ProjectComponent projectComponent) {
        this.v = projectComponent;
    }
}
