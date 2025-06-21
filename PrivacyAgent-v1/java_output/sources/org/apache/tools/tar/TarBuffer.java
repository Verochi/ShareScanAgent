package org.apache.tools.tar;

/* loaded from: classes26.dex */
public class TarBuffer {
    public static final int DEFAULT_BLKSIZE = 10240;
    public static final int DEFAULT_RCDSIZE = 512;
    public java.io.InputStream a;
    public java.io.OutputStream b;
    public final int c;
    public final int d;
    public final int e;
    public final byte[] f;
    public int g;
    public int h;
    public boolean i;

    public TarBuffer(java.io.InputStream inputStream) {
        this(inputStream, 10240);
    }

    public TarBuffer(java.io.InputStream inputStream, int i) {
        this(inputStream, i, 512);
    }

    public TarBuffer(java.io.InputStream inputStream, int i, int i2) {
        this(inputStream, null, i, i2);
    }

    public TarBuffer(java.io.InputStream inputStream, java.io.OutputStream outputStream, int i, int i2) {
        this.a = inputStream;
        this.b = outputStream;
        this.i = false;
        this.c = i;
        this.d = i2;
        int i3 = i / i2;
        this.e = i3;
        this.f = new byte[i];
        if (inputStream != null) {
            this.g = -1;
            this.h = i3;
        } else {
            this.g = 0;
            this.h = 0;
        }
    }

    public TarBuffer(java.io.OutputStream outputStream) {
        this(outputStream, 10240);
    }

    public TarBuffer(java.io.OutputStream outputStream, int i) {
        this(outputStream, i, 512);
    }

    public TarBuffer(java.io.OutputStream outputStream, int i, int i2) {
        this(null, outputStream, i, i2);
    }

    public void a() throws java.io.IOException {
        if (this.i) {
            java.lang.System.err.println("TarBuffer.flushBlock() called.");
        }
        if (this.b == null) {
            throw new java.io.IOException("writing to an input buffer");
        }
        if (this.h > 0) {
            c();
        }
    }

    public final boolean b() throws java.io.IOException {
        if (this.i) {
            java.lang.System.err.println("ReadBlock: blkIdx = " + this.g);
        }
        if (this.a == null) {
            throw new java.io.IOException("reading from an output buffer");
        }
        this.h = 0;
        int i = this.c;
        int i2 = 0;
        while (true) {
            if (i <= 0) {
                break;
            }
            long read = this.a.read(this.f, i2, i);
            if (read != -1) {
                i2 = (int) (i2 + read);
                i = (int) (i - read);
                if (read != this.c && this.i) {
                    java.lang.System.err.println("ReadBlock: INCOMPLETE READ " + read + " of " + this.c + " bytes read.");
                }
            } else {
                if (i2 == 0) {
                    return false;
                }
                java.util.Arrays.fill(this.f, i2, i + i2, (byte) 0);
            }
        }
        this.g++;
        return true;
    }

    public final void c() throws java.io.IOException {
        if (this.i) {
            java.lang.System.err.println("WriteBlock: blkIdx = " + this.g);
        }
        java.io.OutputStream outputStream = this.b;
        if (outputStream == null) {
            throw new java.io.IOException("writing to an input buffer");
        }
        outputStream.write(this.f, 0, this.c);
        this.b.flush();
        this.h = 0;
        this.g++;
        java.util.Arrays.fill(this.f, (byte) 0);
    }

    public void close() throws java.io.IOException {
        if (this.i) {
            java.lang.System.err.println("TarBuffer.closeBuffer().");
        }
        if (this.b == null) {
            java.io.InputStream inputStream = this.a;
            if (inputStream != null) {
                if (inputStream != java.lang.System.in) {
                    inputStream.close();
                }
                this.a = null;
                return;
            }
            return;
        }
        a();
        java.io.OutputStream outputStream = this.b;
        if (outputStream == java.lang.System.out || outputStream == java.lang.System.err) {
            return;
        }
        outputStream.close();
        this.b = null;
    }

    public int getBlockSize() {
        return this.c;
    }

    public int getCurrentBlockNum() {
        return this.g;
    }

    public int getCurrentRecordNum() {
        return this.h - 1;
    }

    public int getRecordSize() {
        return this.d;
    }

    public boolean isEOFRecord(byte[] bArr) {
        int recordSize = getRecordSize();
        for (int i = 0; i < recordSize; i++) {
            if (bArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public byte[] readRecord() throws java.io.IOException {
        if (this.i) {
            java.lang.System.err.println("ReadRecord: recIdx = " + this.h + " blkIdx = " + this.g);
        }
        if (this.a == null) {
            if (this.b == null) {
                throw new java.io.IOException("input buffer is closed");
            }
            throw new java.io.IOException("reading from an output buffer");
        }
        if (this.h >= this.e && !b()) {
            return null;
        }
        int i = this.d;
        byte[] bArr = new byte[i];
        java.lang.System.arraycopy(this.f, this.h * i, bArr, 0, i);
        this.h++;
        return bArr;
    }

    public void setDebug(boolean z) {
        this.i = z;
    }

    public void skipRecord() throws java.io.IOException {
        if (this.i) {
            java.lang.System.err.println("SkipRecord: recIdx = " + this.h + " blkIdx = " + this.g);
        }
        if (this.a == null) {
            throw new java.io.IOException("reading (via skip) from an output buffer");
        }
        if (this.h < this.e || b()) {
            this.h++;
        }
    }

    public void writeRecord(byte[] bArr) throws java.io.IOException {
        if (this.i) {
            java.lang.System.err.println("WriteRecord: recIdx = " + this.h + " blkIdx = " + this.g);
        }
        if (this.b == null) {
            if (this.a != null) {
                throw new java.io.IOException("writing to an input buffer");
            }
            throw new java.io.IOException("Output buffer is closed");
        }
        if (bArr.length != this.d) {
            throw new java.io.IOException("record to write has length '" + bArr.length + "' which is not the record size of '" + this.d + "'");
        }
        if (this.h >= this.e) {
            c();
        }
        byte[] bArr2 = this.f;
        int i = this.h;
        int i2 = this.d;
        java.lang.System.arraycopy(bArr, 0, bArr2, i * i2, i2);
        this.h++;
    }

    public void writeRecord(byte[] bArr, int i) throws java.io.IOException {
        if (this.i) {
            java.lang.System.err.println("WriteRecord: recIdx = " + this.h + " blkIdx = " + this.g);
        }
        if (this.b == null) {
            if (this.a != null) {
                throw new java.io.IOException("writing to an input buffer");
            }
            throw new java.io.IOException("Output buffer is closed");
        }
        if (this.d + i <= bArr.length) {
            if (this.h >= this.e) {
                c();
            }
            byte[] bArr2 = this.f;
            int i2 = this.h;
            int i3 = this.d;
            java.lang.System.arraycopy(bArr, i, bArr2, i2 * i3, i3);
            this.h++;
            return;
        }
        throw new java.io.IOException("record has length '" + bArr.length + "' with offset '" + i + "' which is less than the record size of '" + this.d + "'");
    }
}
