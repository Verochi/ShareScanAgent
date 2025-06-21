package org.apache.tools.ant.util;

/* loaded from: classes26.dex */
public class KeepAliveOutputStream extends java.io.FilterOutputStream {
    public KeepAliveOutputStream(java.io.OutputStream outputStream) {
        super(outputStream);
    }

    public static java.io.PrintStream a(java.io.PrintStream printStream) {
        return new java.io.PrintStream(new org.apache.tools.ant.util.KeepAliveOutputStream(printStream));
    }

    public static java.io.PrintStream wrapSystemErr() {
        return a(java.lang.System.err);
    }

    public static java.io.PrintStream wrapSystemOut() {
        return a(java.lang.System.out);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
    }
}
