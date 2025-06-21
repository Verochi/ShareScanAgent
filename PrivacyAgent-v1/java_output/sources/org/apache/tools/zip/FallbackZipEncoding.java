package org.apache.tools.zip;

/* loaded from: classes26.dex */
class FallbackZipEncoding implements org.apache.tools.zip.ZipEncoding {
    public final java.lang.String a;

    public FallbackZipEncoding() {
        this.a = null;
    }

    public FallbackZipEncoding(java.lang.String str) {
        this.a = str;
    }

    @Override // org.apache.tools.zip.ZipEncoding
    public boolean canEncode(java.lang.String str) {
        return true;
    }

    @Override // org.apache.tools.zip.ZipEncoding
    public java.lang.String decode(byte[] bArr) throws java.io.IOException {
        java.lang.String str = this.a;
        return str == null ? new java.lang.String(bArr) : new java.lang.String(bArr, str);
    }

    @Override // org.apache.tools.zip.ZipEncoding
    public java.nio.ByteBuffer encode(java.lang.String str) throws java.io.IOException {
        java.lang.String str2 = this.a;
        return str2 == null ? java.nio.ByteBuffer.wrap(str.getBytes()) : java.nio.ByteBuffer.wrap(str.getBytes(str2));
    }
}
