package org.apache.tools.ant.util;

/* loaded from: classes26.dex */
public class UUEncoder {
    protected static final int DEFAULT_MODE = 644;
    public java.io.OutputStream a;
    public java.lang.String b;

    public UUEncoder(java.lang.String str) {
        this.b = str;
    }

    public final void a() throws java.io.IOException {
        d("begin 644 " + this.b + "\n");
    }

    public final void b() throws java.io.IOException {
        d(" \nend\n");
    }

    public final void c(byte[] bArr, int i, int i2, java.io.OutputStream outputStream) throws java.io.IOException {
        byte b;
        outputStream.write((byte) ((i2 & 63) + 32));
        int i3 = 0;
        while (i3 < i2) {
            int i4 = i3 + 1;
            byte b2 = bArr[i3 + i];
            byte b3 = 1;
            if (i4 < i2) {
                int i5 = i4 + 1;
                byte b4 = bArr[i4 + i];
                if (i5 < i2) {
                    int i6 = i5 + 1;
                    b = bArr[i5 + i];
                    b3 = b4;
                    i4 = i6;
                    byte b5 = (byte) (((b2 >>> 2) & 63) + 32);
                    byte b6 = (byte) ((((b2 << 4) & 48) | ((b3 >>> 4) & 15)) + 32);
                    outputStream.write(b5);
                    outputStream.write(b6);
                    outputStream.write((byte) ((((b3 << 2) & 60) | ((b >>> 6) & 3)) + 32));
                    outputStream.write((byte) ((b & 63) + 32));
                    i3 = i4;
                } else {
                    b3 = b4;
                    i4 = i5;
                }
            }
            b = 1;
            byte b52 = (byte) (((b2 >>> 2) & 63) + 32);
            byte b62 = (byte) ((((b2 << 4) & 48) | ((b3 >>> 4) & 15)) + 32);
            outputStream.write(b52);
            outputStream.write(b62);
            outputStream.write((byte) ((((b3 << 2) & 60) | ((b >>> 6) & 3)) + 32));
            outputStream.write((byte) ((b & 63) + 32));
            i3 = i4;
        }
        outputStream.write(10);
    }

    public final void d(java.lang.String str) {
        java.io.PrintStream printStream = new java.io.PrintStream(this.a);
        printStream.print(str);
        printStream.flush();
    }

    public void encode(java.io.InputStream inputStream, java.io.OutputStream outputStream) throws java.io.IOException {
        this.a = outputStream;
        a();
        byte[] bArr = new byte[4500];
        while (true) {
            int i = 0;
            int read = inputStream.read(bArr, 0, 4500);
            if (read == -1) {
                outputStream.flush();
                b();
                return;
            } else {
                while (read > 0) {
                    int i2 = read <= 45 ? read : 45;
                    c(bArr, i, i2, outputStream);
                    i += i2;
                    read -= i2;
                }
            }
        }
    }
}
