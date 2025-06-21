package org.apache.commons.codec.binary;

/* loaded from: classes24.dex */
public class Base64OutputStream extends org.apache.commons.codec.binary.BaseNCodecOutputStream {
    public Base64OutputStream(java.io.OutputStream outputStream) {
        this(outputStream, true);
    }

    public Base64OutputStream(java.io.OutputStream outputStream, boolean z) {
        super(outputStream, new org.apache.commons.codec.binary.Base64(false), z);
    }

    public Base64OutputStream(java.io.OutputStream outputStream, boolean z, int i, byte[] bArr) {
        super(outputStream, new org.apache.commons.codec.binary.Base64(i, bArr), z);
    }
}
