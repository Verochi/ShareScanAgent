package net.lingala.zip4j.io;

/* loaded from: classes23.dex */
public class DeflaterOutputStream extends net.lingala.zip4j.io.CipherOutputStream {
    public boolean A;
    protected java.util.zip.Deflater deflater;
    public byte[] z;

    public DeflaterOutputStream(java.io.OutputStream outputStream, net.lingala.zip4j.model.ZipModel zipModel) {
        super(outputStream, zipModel);
        this.deflater = new java.util.zip.Deflater();
        this.z = new byte[4096];
        this.A = false;
    }

    @Override // net.lingala.zip4j.io.CipherOutputStream
    public void closeEntry() throws java.io.IOException, net.lingala.zip4j.exception.ZipException {
        if (this.zipParameters.getCompressionMethod() == 8) {
            if (!this.deflater.finished()) {
                this.deflater.finish();
                while (!this.deflater.finished()) {
                    l();
                }
            }
            this.A = false;
        }
        super.closeEntry();
    }

    @Override // net.lingala.zip4j.io.CipherOutputStream
    public void finish() throws java.io.IOException, net.lingala.zip4j.exception.ZipException {
        super.finish();
    }

    public final void l() throws java.io.IOException {
        java.util.zip.Deflater deflater = this.deflater;
        byte[] bArr = this.z;
        int deflate = deflater.deflate(bArr, 0, bArr.length);
        if (deflate > 0) {
            if (this.deflater.finished()) {
                if (deflate == 4) {
                    return;
                }
                if (deflate < 4) {
                    decrementCompressedFileSize(4 - deflate);
                    return;
                }
                deflate -= 4;
            }
            if (this.A) {
                super.write(this.z, 0, deflate);
            } else {
                super.write(this.z, 2, deflate - 2);
                this.A = true;
            }
        }
    }

    @Override // net.lingala.zip4j.io.CipherOutputStream
    public void putNextEntry(java.io.File file, net.lingala.zip4j.model.ZipParameters zipParameters) throws net.lingala.zip4j.exception.ZipException {
        super.putNextEntry(file, zipParameters);
        if (zipParameters.getCompressionMethod() == 8) {
            this.deflater.reset();
            if ((zipParameters.getCompressionLevel() < 0 || zipParameters.getCompressionLevel() > 9) && zipParameters.getCompressionLevel() != -1) {
                throw new net.lingala.zip4j.exception.ZipException("invalid compression level for deflater. compression level should be in the range of 0-9");
            }
            this.deflater.setLevel(zipParameters.getCompressionLevel());
        }
    }

    @Override // net.lingala.zip4j.io.CipherOutputStream, net.lingala.zip4j.io.BaseOutputStream, java.io.OutputStream
    public void write(int i) throws java.io.IOException {
        write(new byte[]{(byte) i}, 0, 1);
    }

    @Override // net.lingala.zip4j.io.CipherOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws java.io.IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // net.lingala.zip4j.io.CipherOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws java.io.IOException {
        if (this.zipParameters.getCompressionMethod() != 8) {
            super.write(bArr, i, i2);
            return;
        }
        this.deflater.setInput(bArr, i, i2);
        while (!this.deflater.needsInput()) {
            l();
        }
    }
}
