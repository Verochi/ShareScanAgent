package org.apache.tools.ant.util;

/* loaded from: classes26.dex */
public class KeepAliveInputStream extends java.io.FilterInputStream {
    public KeepAliveInputStream(java.io.InputStream inputStream) {
        super(inputStream);
    }

    public static java.io.InputStream wrapSystemIn() {
        return new org.apache.tools.ant.util.KeepAliveInputStream(java.lang.System.in);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
    }
}
