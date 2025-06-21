package org.apache.tools.ant.util;

/* loaded from: classes26.dex */
public class PropertyOutputStream extends java.io.ByteArrayOutputStream {
    public org.apache.tools.ant.Project n;
    public java.lang.String t;
    public boolean u;

    public PropertyOutputStream(org.apache.tools.ant.Project project, java.lang.String str) {
        this(project, str, true);
    }

    public PropertyOutputStream(org.apache.tools.ant.Project project, java.lang.String str, boolean z) {
        this.n = project;
        this.t = str;
        this.u = z;
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.n == null || this.t == null) {
            return;
        }
        java.lang.String str = new java.lang.String(toByteArray());
        org.apache.tools.ant.Project project = this.n;
        java.lang.String str2 = this.t;
        if (this.u) {
            str = str.trim();
        }
        project.setNewProperty(str2, str);
    }
}
