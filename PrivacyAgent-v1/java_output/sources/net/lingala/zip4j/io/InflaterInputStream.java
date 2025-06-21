package net.lingala.zip4j.io;

/* loaded from: classes23.dex */
public class InflaterInputStream extends net.lingala.zip4j.io.PartInputStream {
    public java.util.zip.Inflater C;
    public byte[] D;
    public byte[] E;
    public net.lingala.zip4j.unzip.UnzipEngine F;
    public long G;
    public long H;

    public InflaterInputStream(java.io.RandomAccessFile randomAccessFile, long j, long j2, net.lingala.zip4j.unzip.UnzipEngine unzipEngine) {
        super(randomAccessFile, j, j2, unzipEngine);
        this.E = new byte[1];
        this.C = new java.util.zip.Inflater(true);
        this.D = new byte[4096];
        this.F = unzipEngine;
        this.G = 0L;
        this.H = unzipEngine.getFileHeader().getUncompressedSize();
    }

    public final void a() throws java.io.IOException {
        byte[] bArr = this.D;
        int read = super.read(bArr, 0, bArr.length);
        if (read == -1) {
            throw new java.io.EOFException("Unexpected end of ZLIB input stream");
        }
        this.C.setInput(this.D, 0, read);
    }

    @Override // net.lingala.zip4j.io.PartInputStream, net.lingala.zip4j.io.BaseInputStream, java.io.InputStream
    public int available() {
        return !this.C.finished() ? 1 : 0;
    }

    public final void c() throws java.io.IOException {
        while (super.read(new byte[1024], 0, 1024) != -1) {
        }
        checkAndReadAESMacBytes();
    }

    @Override // net.lingala.zip4j.io.PartInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        this.C.end();
        super.close();
    }

    @Override // net.lingala.zip4j.io.PartInputStream, net.lingala.zip4j.io.BaseInputStream
    public net.lingala.zip4j.unzip.UnzipEngine getUnzipEngine() {
        return super.getUnzipEngine();
    }

    @Override // net.lingala.zip4j.io.PartInputStream, net.lingala.zip4j.io.BaseInputStream, java.io.InputStream
    public int read() throws java.io.IOException {
        if (read(this.E, 0, 1) == -1) {
            return -1;
        }
        return this.E[0] & 255;
    }

    @Override // net.lingala.zip4j.io.PartInputStream, java.io.InputStream
    public int read(byte[] bArr) throws java.io.IOException {
        if (bArr != null) {
            return read(bArr, 0, bArr.length);
        }
        throw new java.lang.NullPointerException("input buffer is null");
    }

    @Override // net.lingala.zip4j.io.PartInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws java.io.IOException {
        if (bArr == null) {
            throw new java.lang.NullPointerException("input buffer is null");
        }
        if (i < 0 || i2 < 0 || i2 > bArr.length - i) {
            throw new java.lang.IndexOutOfBoundsException();
        }
        if (i2 == 0) {
            return 0;
        }
        try {
            if (this.G >= this.H) {
                c();
                return -1;
            }
            while (true) {
                int inflate = this.C.inflate(bArr, i, i2);
                if (inflate != 0) {
                    this.G += inflate;
                    return inflate;
                }
                if (this.C.finished() || this.C.needsDictionary()) {
                    break;
                }
                if (this.C.needsInput()) {
                    a();
                }
            }
            c();
            return -1;
        } catch (java.util.zip.DataFormatException e) {
            java.lang.String message = e.getMessage() != null ? e.getMessage() : "Invalid ZLIB data format";
            net.lingala.zip4j.unzip.UnzipEngine unzipEngine = this.F;
            if (unzipEngine != null && unzipEngine.getLocalFileHeader().isEncrypted() && this.F.getLocalFileHeader().getEncryptionMethod() == 0) {
                message = message + " - Wrong Password?";
            }
            throw new java.io.IOException(message);
        }
    }

    @Override // net.lingala.zip4j.io.PartInputStream, net.lingala.zip4j.io.BaseInputStream
    public void seek(long j) throws java.io.IOException {
        super.seek(j);
    }

    @Override // net.lingala.zip4j.io.PartInputStream, java.io.InputStream
    public long skip(long j) throws java.io.IOException {
        if (j < 0) {
            throw new java.lang.IllegalArgumentException("negative skip length");
        }
        int min = (int) java.lang.Math.min(j, 2147483647L);
        byte[] bArr = new byte[512];
        int i = 0;
        while (i < min) {
            int i2 = min - i;
            if (i2 > 512) {
                i2 = 512;
            }
            int read = read(bArr, 0, i2);
            if (read == -1) {
                break;
            }
            i += read;
        }
        return i;
    }
}
