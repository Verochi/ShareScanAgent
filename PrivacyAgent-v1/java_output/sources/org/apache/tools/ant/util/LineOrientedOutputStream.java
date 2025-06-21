package org.apache.tools.ant.util;

/* loaded from: classes26.dex */
public abstract class LineOrientedOutputStream extends java.io.OutputStream {
    public java.io.ByteArrayOutputStream n = new java.io.ByteArrayOutputStream(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_ID);
    public boolean t = false;

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        if (this.n.size() > 0) {
            processBuffer();
        }
        super.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws java.io.IOException {
    }

    public void processBuffer() throws java.io.IOException {
        try {
            processLine(this.n.toByteArray());
        } finally {
            this.n.reset();
        }
    }

    public abstract void processLine(java.lang.String str) throws java.io.IOException;

    public void processLine(byte[] bArr) throws java.io.IOException {
        processLine(new java.lang.String(bArr));
    }

    @Override // java.io.OutputStream
    public final void write(int i) throws java.io.IOException {
        byte b = (byte) i;
        if (b != 10 && b != 13) {
            this.n.write(i);
        } else if (!this.t) {
            processBuffer();
        }
        this.t = b == 13;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) throws java.io.IOException {
        byte b;
        while (i2 > 0) {
            int i3 = i;
            while (i2 > 0 && (b = bArr[i3]) != 10 && b != 13) {
                i3++;
                i2--;
            }
            int i4 = i3 - i;
            if (i4 > 0) {
                this.n.write(bArr, i, i4);
            }
            i = i3;
            while (i2 > 0) {
                byte b2 = bArr[i];
                if (b2 == 10 || b2 == 13) {
                    write(b2);
                    i++;
                    i2--;
                }
            }
        }
    }
}
