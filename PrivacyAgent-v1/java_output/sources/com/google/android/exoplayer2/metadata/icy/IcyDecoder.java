package com.google.android.exoplayer2.metadata.icy;

/* loaded from: classes22.dex */
public final class IcyDecoder extends com.google.android.exoplayer2.metadata.SimpleMetadataDecoder {
    public static final java.util.regex.Pattern c = java.util.regex.Pattern.compile("(.+?)='(.*?)';", 32);
    public final java.nio.charset.CharsetDecoder a = com.google.common.base.Charsets.UTF_8.newDecoder();
    public final java.nio.charset.CharsetDecoder b = com.google.common.base.Charsets.ISO_8859_1.newDecoder();

    @androidx.annotation.Nullable
    public final java.lang.String a(java.nio.ByteBuffer byteBuffer) {
        try {
            return this.a.decode(byteBuffer).toString();
        } catch (java.nio.charset.CharacterCodingException unused) {
            try {
                java.lang.String charBuffer = this.b.decode(byteBuffer).toString();
                this.b.reset();
                byteBuffer.rewind();
                return charBuffer;
            } catch (java.nio.charset.CharacterCodingException unused2) {
                this.b.reset();
                byteBuffer.rewind();
                return null;
            } catch (java.lang.Throwable th) {
                this.b.reset();
                byteBuffer.rewind();
                throw th;
            }
        } finally {
            this.a.reset();
            byteBuffer.rewind();
        }
    }

    @Override // com.google.android.exoplayer2.metadata.SimpleMetadataDecoder
    public com.google.android.exoplayer2.metadata.Metadata decode(com.google.android.exoplayer2.metadata.MetadataInputBuffer metadataInputBuffer, java.nio.ByteBuffer byteBuffer) {
        java.lang.String a = a(byteBuffer);
        byte[] bArr = new byte[byteBuffer.limit()];
        byteBuffer.get(bArr);
        java.lang.String str = null;
        if (a == null) {
            return new com.google.android.exoplayer2.metadata.Metadata(new com.google.android.exoplayer2.metadata.icy.IcyInfo(bArr, null, null));
        }
        java.util.regex.Matcher matcher = c.matcher(a);
        java.lang.String str2 = null;
        for (int i = 0; matcher.find(i); i = matcher.end()) {
            java.lang.String lowerInvariant = com.google.android.exoplayer2.util.Util.toLowerInvariant(matcher.group(1));
            java.lang.String group = matcher.group(2);
            if (lowerInvariant != null) {
                if (lowerInvariant.equals("streamurl")) {
                    str2 = group;
                } else if (lowerInvariant.equals("streamtitle")) {
                    str = group;
                }
            }
        }
        return new com.google.android.exoplayer2.metadata.Metadata(new com.google.android.exoplayer2.metadata.icy.IcyInfo(bArr, str, str2));
    }
}
