package net.lingala.zip4j.io;

/* loaded from: classes23.dex */
public class SplitOutputStream extends java.io.OutputStream {
    public java.io.RandomAccessFile n;
    public long t;
    public java.io.File u;
    public java.io.File v;
    public int w;
    public long x;

    public SplitOutputStream(java.io.File file) throws java.io.FileNotFoundException, net.lingala.zip4j.exception.ZipException {
        this(file, -1L);
    }

    public SplitOutputStream(java.io.File file, long j) throws java.io.FileNotFoundException, net.lingala.zip4j.exception.ZipException {
        if (j >= 0 && j < 65536) {
            throw new net.lingala.zip4j.exception.ZipException("split length less than minimum allowed split length of 65536 Bytes");
        }
        this.n = new java.io.RandomAccessFile(file, "rw");
        this.t = j;
        this.v = file;
        this.u = file;
        this.w = 0;
        this.x = 0L;
    }

    public SplitOutputStream(java.lang.String str) throws java.io.FileNotFoundException, net.lingala.zip4j.exception.ZipException {
        this(net.lingala.zip4j.util.Zip4jUtil.isStringNotNullAndNotEmpty(str) ? new java.io.File(str) : null);
    }

    public SplitOutputStream(java.lang.String str, long j) throws java.io.FileNotFoundException, net.lingala.zip4j.exception.ZipException {
        this(!net.lingala.zip4j.util.Zip4jUtil.isStringNotNullAndNotEmpty(str) ? new java.io.File(str) : null, j);
    }

    public final boolean a(byte[] bArr) {
        if (bArr != null && bArr.length >= 4) {
            int readIntLittleEndian = net.lingala.zip4j.util.Raw.readIntLittleEndian(bArr, 0);
            long[] allHeaderSignatures = net.lingala.zip4j.util.Zip4jUtil.getAllHeaderSignatures();
            if (allHeaderSignatures != null && allHeaderSignatures.length > 0) {
                for (long j : allHeaderSignatures) {
                    if (j != 134695760 && j == readIntLittleEndian) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final void c() throws java.io.IOException {
        java.lang.String str;
        java.io.File file;
        try {
            java.lang.String zipFileNameWithoutExt = net.lingala.zip4j.util.Zip4jUtil.getZipFileNameWithoutExt(this.v.getName());
            java.lang.String absolutePath = this.u.getAbsolutePath();
            if (this.v.getParent() == null) {
                str = "";
            } else {
                str = this.v.getParent() + java.lang.System.getProperty("file.separator");
            }
            if (this.w < 9) {
                file = new java.io.File(str + zipFileNameWithoutExt + ".z0" + (this.w + 1));
            } else {
                file = new java.io.File(str + zipFileNameWithoutExt + ".z" + (this.w + 1));
            }
            this.n.close();
            if (file.exists()) {
                throw new java.io.IOException("split file: " + file.getName() + " already exists in the current directory, cannot rename this file");
            }
            if (!this.u.renameTo(file)) {
                throw new java.io.IOException("cannot rename newly created split file");
            }
            this.u = new java.io.File(absolutePath);
            this.n = new java.io.RandomAccessFile(this.u, "rw");
            this.w++;
        } catch (net.lingala.zip4j.exception.ZipException e) {
            throw new java.io.IOException(e.getMessage());
        }
    }

    public boolean checkBuffSizeAndStartNextSplitFile(int i) throws net.lingala.zip4j.exception.ZipException {
        if (i < 0) {
            throw new net.lingala.zip4j.exception.ZipException("negative buffersize for checkBuffSizeAndStartNextSplitFile");
        }
        if (isBuffSizeFitForCurrSplitFile(i)) {
            return false;
        }
        try {
            c();
            this.x = 0L;
            return true;
        } catch (java.io.IOException e) {
            throw new net.lingala.zip4j.exception.ZipException(e);
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        java.io.RandomAccessFile randomAccessFile = this.n;
        if (randomAccessFile != null) {
            randomAccessFile.close();
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws java.io.IOException {
    }

    public int getCurrSplitFileCounter() {
        return this.w;
    }

    public long getFilePointer() throws java.io.IOException {
        return this.n.getFilePointer();
    }

    public long getSplitLength() {
        return this.t;
    }

    public boolean isBuffSizeFitForCurrSplitFile(int i) throws net.lingala.zip4j.exception.ZipException {
        if (i < 0) {
            throw new net.lingala.zip4j.exception.ZipException("negative buffersize for isBuffSizeFitForCurrSplitFile");
        }
        long j = this.t;
        return j < 65536 || this.x + ((long) i) <= j;
    }

    public boolean isSplitZipFile() {
        return this.t != -1;
    }

    public void seek(long j) throws java.io.IOException {
        this.n.seek(j);
    }

    @Override // java.io.OutputStream
    public void write(int i) throws java.io.IOException {
        write(new byte[]{(byte) i}, 0, 1);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws java.io.IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws java.io.IOException {
        if (i2 <= 0) {
            return;
        }
        long j = this.t;
        if (j == -1) {
            this.n.write(bArr, i, i2);
            this.x += i2;
            return;
        }
        if (j < 65536) {
            throw new java.io.IOException("split length less than minimum allowed split length of 65536 Bytes");
        }
        long j2 = this.x;
        if (j2 >= j) {
            c();
            this.n.write(bArr, i, i2);
            this.x = i2;
            return;
        }
        long j3 = i2;
        if (j2 + j3 <= j) {
            this.n.write(bArr, i, i2);
            this.x += j3;
            return;
        }
        if (a(bArr)) {
            c();
            this.n.write(bArr, i, i2);
            this.x = j3;
            return;
        }
        this.n.write(bArr, i, (int) (this.t - this.x));
        c();
        java.io.RandomAccessFile randomAccessFile = this.n;
        long j4 = this.t;
        long j5 = this.x;
        randomAccessFile.write(bArr, i + ((int) (j4 - j5)), (int) (j3 - (j4 - j5)));
        this.x = j3 - (this.t - this.x);
    }
}
