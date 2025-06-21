package org.apache.tools.mail;

/* loaded from: classes26.dex */
class MailPrintStream extends java.io.PrintStream {
    public int n;

    public MailPrintStream(java.io.OutputStream outputStream) {
        super(outputStream, true);
    }

    public void a(java.lang.String str) {
        for (char c : str.toCharArray()) {
            b(c);
        }
    }

    public void b(int i) {
        super.write(i);
    }

    @Override // java.io.PrintStream, java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) {
        if (i == 10 && this.n != 13) {
            b(13);
            b(i);
        } else if (i == 46 && this.n == 10) {
            b(46);
            b(i);
        } else {
            b(i);
        }
        this.n = i;
    }

    @Override // java.io.PrintStream, java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            write(bArr[i + i3]);
        }
    }
}
