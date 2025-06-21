package net.lingala.zip4j.io;

/* loaded from: classes23.dex */
public class ZipOutputStream extends net.lingala.zip4j.io.DeflaterOutputStream {
    public ZipOutputStream(java.io.OutputStream outputStream) {
        this(outputStream, null);
    }

    public ZipOutputStream(java.io.OutputStream outputStream, net.lingala.zip4j.model.ZipModel zipModel) {
        super(outputStream, zipModel);
    }

    @Override // net.lingala.zip4j.io.DeflaterOutputStream, net.lingala.zip4j.io.CipherOutputStream, net.lingala.zip4j.io.BaseOutputStream, java.io.OutputStream
    public void write(int i) throws java.io.IOException {
        write(new byte[]{(byte) i}, 0, 1);
    }

    @Override // net.lingala.zip4j.io.DeflaterOutputStream, net.lingala.zip4j.io.CipherOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws java.io.IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // net.lingala.zip4j.io.DeflaterOutputStream, net.lingala.zip4j.io.CipherOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws java.io.IOException {
        this.crc.update(bArr, i, i2);
        updateTotalBytesRead(i2);
        super.write(bArr, i, i2);
    }
}
