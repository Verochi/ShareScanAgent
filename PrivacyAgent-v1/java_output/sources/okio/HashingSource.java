package okio;

/* loaded from: classes24.dex */
public final class HashingSource extends okio.ForwardingSource {
    private final javax.crypto.Mac mac;
    private final java.security.MessageDigest messageDigest;

    private HashingSource(okio.Source source, java.lang.String str) {
        super(source);
        try {
            this.messageDigest = java.security.MessageDigest.getInstance(str);
            this.mac = null;
        } catch (java.security.NoSuchAlgorithmException unused) {
            throw new java.lang.AssertionError();
        }
    }

    private HashingSource(okio.Source source, okio.ByteString byteString, java.lang.String str) {
        super(source);
        try {
            javax.crypto.Mac mac = javax.crypto.Mac.getInstance(str);
            this.mac = mac;
            mac.init(new javax.crypto.spec.SecretKeySpec(byteString.toByteArray(), str));
            this.messageDigest = null;
        } catch (java.security.InvalidKeyException e) {
            throw new java.lang.IllegalArgumentException(e);
        } catch (java.security.NoSuchAlgorithmException unused) {
            throw new java.lang.AssertionError();
        }
    }

    public static okio.HashingSource hmacSha1(okio.Source source, okio.ByteString byteString) {
        return new okio.HashingSource(source, byteString, "HmacSHA1");
    }

    public static okio.HashingSource hmacSha256(okio.Source source, okio.ByteString byteString) {
        return new okio.HashingSource(source, byteString, "HmacSHA256");
    }

    public static okio.HashingSource md5(okio.Source source) {
        return new okio.HashingSource(source, "MD5");
    }

    public static okio.HashingSource sha1(okio.Source source) {
        return new okio.HashingSource(source, "SHA-1");
    }

    public static okio.HashingSource sha256(okio.Source source) {
        return new okio.HashingSource(source, "SHA-256");
    }

    public final okio.ByteString hash() {
        java.security.MessageDigest messageDigest = this.messageDigest;
        return okio.ByteString.of(messageDigest != null ? messageDigest.digest() : this.mac.doFinal());
    }

    @Override // okio.ForwardingSource, okio.Source
    public long read(okio.Buffer buffer, long j) throws java.io.IOException {
        long read = super.read(buffer, j);
        if (read != -1) {
            long j2 = buffer.size;
            long j3 = j2 - read;
            okio.Segment segment = buffer.head;
            while (j2 > j3) {
                segment = segment.prev;
                j2 -= segment.limit - segment.pos;
            }
            while (j2 < buffer.size) {
                int i = (int) ((segment.pos + j3) - j2);
                java.security.MessageDigest messageDigest = this.messageDigest;
                if (messageDigest != null) {
                    messageDigest.update(segment.data, i, segment.limit - i);
                } else {
                    this.mac.update(segment.data, i, segment.limit - i);
                }
                j3 = (segment.limit - segment.pos) + j2;
                segment = segment.next;
                j2 = j3;
            }
        }
        return read;
    }
}
