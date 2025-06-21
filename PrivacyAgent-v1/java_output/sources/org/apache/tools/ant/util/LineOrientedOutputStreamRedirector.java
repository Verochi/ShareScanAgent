package org.apache.tools.ant.util;

/* loaded from: classes26.dex */
public class LineOrientedOutputStreamRedirector extends org.apache.tools.ant.util.LineOrientedOutputStream {
    public static final byte[] v = java.lang.System.getProperty("line.separator").getBytes();
    public java.io.OutputStream u;

    public LineOrientedOutputStreamRedirector(java.io.OutputStream outputStream) {
        this.u = outputStream;
    }

    @Override // org.apache.tools.ant.util.LineOrientedOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        super.close();
        this.u.close();
    }

    @Override // org.apache.tools.ant.util.LineOrientedOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() throws java.io.IOException {
        super.flush();
        this.u.flush();
    }

    @Override // org.apache.tools.ant.util.LineOrientedOutputStream
    public void processLine(java.lang.String str) throws java.io.IOException {
        this.u.write((str + java.lang.System.getProperty("line.separator")).getBytes());
    }

    @Override // org.apache.tools.ant.util.LineOrientedOutputStream
    public void processLine(byte[] bArr) throws java.io.IOException {
        this.u.write(bArr);
        this.u.write(v);
    }
}
