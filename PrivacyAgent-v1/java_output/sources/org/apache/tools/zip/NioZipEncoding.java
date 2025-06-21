package org.apache.tools.zip;

/* loaded from: classes26.dex */
class NioZipEncoding implements org.apache.tools.zip.ZipEncoding {
    public final java.nio.charset.Charset a;

    public NioZipEncoding(java.nio.charset.Charset charset) {
        this.a = charset;
    }

    @Override // org.apache.tools.zip.ZipEncoding
    public boolean canEncode(java.lang.String str) {
        java.nio.charset.CharsetEncoder newEncoder = this.a.newEncoder();
        newEncoder.onMalformedInput(java.nio.charset.CodingErrorAction.REPORT);
        newEncoder.onUnmappableCharacter(java.nio.charset.CodingErrorAction.REPORT);
        return newEncoder.canEncode(str);
    }

    @Override // org.apache.tools.zip.ZipEncoding
    public java.lang.String decode(byte[] bArr) throws java.io.IOException {
        return this.a.newDecoder().onMalformedInput(java.nio.charset.CodingErrorAction.REPORT).onUnmappableCharacter(java.nio.charset.CodingErrorAction.REPORT).decode(java.nio.ByteBuffer.wrap(bArr)).toString();
    }

    @Override // org.apache.tools.zip.ZipEncoding
    public java.nio.ByteBuffer encode(java.lang.String str) {
        java.nio.charset.CharsetEncoder newEncoder = this.a.newEncoder();
        newEncoder.onMalformedInput(java.nio.charset.CodingErrorAction.REPORT);
        newEncoder.onUnmappableCharacter(java.nio.charset.CodingErrorAction.REPORT);
        java.nio.CharBuffer wrap = java.nio.CharBuffer.wrap(str);
        java.nio.ByteBuffer allocate = java.nio.ByteBuffer.allocate(str.length() + ((str.length() + 1) / 2));
        while (true) {
            if (wrap.remaining() <= 0) {
                break;
            }
            java.nio.charset.CoderResult encode = newEncoder.encode(wrap, allocate, true);
            if (!encode.isUnmappable() && !encode.isMalformed()) {
                if (!encode.isOverflow()) {
                    if (encode.isUnderflow()) {
                        newEncoder.flush(allocate);
                        break;
                    }
                } else {
                    allocate = org.apache.tools.zip.ZipEncodingHelper.b(allocate, 0);
                }
            } else {
                if (encode.length() * 6 > allocate.remaining()) {
                    allocate = org.apache.tools.zip.ZipEncodingHelper.b(allocate, allocate.position() + (encode.length() * 6));
                }
                for (int i = 0; i < encode.length(); i++) {
                    org.apache.tools.zip.ZipEncodingHelper.a(allocate, wrap.get());
                }
            }
        }
        allocate.limit(allocate.position());
        allocate.rewind();
        return allocate;
    }
}
