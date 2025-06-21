package net.lingala.zip4j.io;

/* loaded from: classes23.dex */
public class PartInputStream extends net.lingala.zip4j.io.BaseInputStream {
    public boolean A;
    public java.io.RandomAccessFile n;
    public long u;
    public net.lingala.zip4j.unzip.UnzipEngine v;
    public net.lingala.zip4j.crypto.IDecrypter w;
    public byte[] x = new byte[1];
    public byte[] y = new byte[16];
    public int z = 0;
    public int B = -1;
    public long t = 0;

    public PartInputStream(java.io.RandomAccessFile randomAccessFile, long j, long j2, net.lingala.zip4j.unzip.UnzipEngine unzipEngine) {
        this.A = false;
        this.n = randomAccessFile;
        this.v = unzipEngine;
        this.w = unzipEngine.getDecrypter();
        this.u = j2;
        this.A = unzipEngine.getFileHeader().isEncrypted() && unzipEngine.getFileHeader().getEncryptionMethod() == 99;
    }

    @Override // net.lingala.zip4j.io.BaseInputStream, java.io.InputStream
    public int available() {
        long j = this.u - this.t;
        if (j > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) j;
    }

    public void checkAndReadAESMacBytes() throws java.io.IOException {
        net.lingala.zip4j.crypto.IDecrypter iDecrypter;
        if (this.A && (iDecrypter = this.w) != null && (iDecrypter instanceof net.lingala.zip4j.crypto.AESDecrypter) && ((net.lingala.zip4j.crypto.AESDecrypter) iDecrypter).getStoredMac() == null) {
            byte[] bArr = new byte[10];
            int read = this.n.read(bArr);
            if (read != 10) {
                if (!this.v.getZipModel().isSplitArchive()) {
                    throw new java.io.IOException("Error occured while reading stored AES authentication bytes");
                }
                this.n.close();
                java.io.RandomAccessFile startNextSplitFile = this.v.startNextSplitFile();
                this.n = startNextSplitFile;
                startNextSplitFile.read(bArr, read, 10 - read);
            }
            ((net.lingala.zip4j.crypto.AESDecrypter) this.v.getDecrypter()).setStoredMac(bArr);
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        this.n.close();
    }

    @Override // net.lingala.zip4j.io.BaseInputStream
    public net.lingala.zip4j.unzip.UnzipEngine getUnzipEngine() {
        return this.v;
    }

    @Override // net.lingala.zip4j.io.BaseInputStream, java.io.InputStream
    public int read() throws java.io.IOException {
        if (this.t >= this.u) {
            return -1;
        }
        if (!this.A) {
            if (read(this.x, 0, 1) == -1) {
                return -1;
            }
            return this.x[0] & 255;
        }
        int i = this.z;
        if (i == 0 || i == 16) {
            if (read(this.y) == -1) {
                return -1;
            }
            this.z = 0;
        }
        byte[] bArr = this.y;
        int i2 = this.z;
        this.z = i2 + 1;
        return bArr[i2] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws java.io.IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws java.io.IOException {
        int i3;
        long j = i2;
        long j2 = this.u;
        long j3 = this.t;
        if (j > j2 - j3 && (i2 = (int) (j2 - j3)) == 0) {
            checkAndReadAESMacBytes();
            return -1;
        }
        if ((this.v.getDecrypter() instanceof net.lingala.zip4j.crypto.AESDecrypter) && this.t + i2 < this.u && (i3 = i2 % 16) != 0) {
            i2 -= i3;
        }
        synchronized (this.n) {
            int read = this.n.read(bArr, i, i2);
            this.B = read;
            if (read < i2 && this.v.getZipModel().isSplitArchive()) {
                this.n.close();
                java.io.RandomAccessFile startNextSplitFile = this.v.startNextSplitFile();
                this.n = startNextSplitFile;
                if (this.B < 0) {
                    this.B = 0;
                }
                int i4 = this.B;
                int read2 = startNextSplitFile.read(bArr, i4, i2 - i4);
                if (read2 > 0) {
                    this.B += read2;
                }
            }
        }
        int i5 = this.B;
        if (i5 > 0) {
            net.lingala.zip4j.crypto.IDecrypter iDecrypter = this.w;
            if (iDecrypter != null) {
                try {
                    iDecrypter.decryptData(bArr, i, i5);
                } catch (net.lingala.zip4j.exception.ZipException e) {
                    throw new java.io.IOException(e.getMessage());
                }
            }
            this.t += this.B;
        }
        if (this.t >= this.u) {
            checkAndReadAESMacBytes();
        }
        return this.B;
    }

    @Override // net.lingala.zip4j.io.BaseInputStream
    public void seek(long j) throws java.io.IOException {
        this.n.seek(j);
    }

    @Override // java.io.InputStream
    public long skip(long j) throws java.io.IOException {
        if (j < 0) {
            throw new java.lang.IllegalArgumentException();
        }
        long j2 = this.u;
        long j3 = this.t;
        if (j > j2 - j3) {
            j = j2 - j3;
        }
        this.t = j3 + j;
        return j;
    }
}
