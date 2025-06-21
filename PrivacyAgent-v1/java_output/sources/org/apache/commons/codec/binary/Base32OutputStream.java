package org.apache.commons.codec.binary;

/* loaded from: classes24.dex */
public class Base32OutputStream extends org.apache.commons.codec.binary.BaseNCodecOutputStream {
    public Base32OutputStream(java.io.OutputStream outputStream) {
        this(outputStream, true);
    }

    public Base32OutputStream(java.io.OutputStream outputStream, boolean z) {
        super(outputStream, new org.apache.commons.codec.binary.Base32(false), z);
    }

    public Base32OutputStream(java.io.OutputStream outputStream, boolean z, int i, byte[] bArr) {
        super(outputStream, new org.apache.commons.codec.binary.Base32(i, bArr), z);
    }
}
