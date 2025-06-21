package org.apache.commons.codec.binary;

/* loaded from: classes24.dex */
public class Base32InputStream extends org.apache.commons.codec.binary.BaseNCodecInputStream {
    public Base32InputStream(java.io.InputStream inputStream) {
        this(inputStream, false);
    }

    public Base32InputStream(java.io.InputStream inputStream, boolean z) {
        super(inputStream, new org.apache.commons.codec.binary.Base32(false), z);
    }

    public Base32InputStream(java.io.InputStream inputStream, boolean z, int i, byte[] bArr) {
        super(inputStream, new org.apache.commons.codec.binary.Base32(i, bArr), z);
    }
}
