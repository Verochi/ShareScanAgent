package okio;

/* loaded from: classes24.dex */
public final class HashingSink extends okio.ForwardingSink {

    @javax.annotation.Nullable
    private final javax.crypto.Mac mac;

    @javax.annotation.Nullable
    private final java.security.MessageDigest messageDigest;

    private HashingSink(okio.Sink sink, java.lang.String str) {
        super(sink);
        try {
            this.messageDigest = java.security.MessageDigest.getInstance(str);
            this.mac = null;
        } catch (java.security.NoSuchAlgorithmException unused) {
            throw new java.lang.AssertionError();
        }
    }

    private HashingSink(okio.Sink sink, okio.ByteString byteString, java.lang.String str) {
        super(sink);
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

    public static okio.HashingSink hmacSha1(okio.Sink sink, okio.ByteString byteString) {
        return new okio.HashingSink(sink, byteString, "HmacSHA1");
    }

    public static okio.HashingSink hmacSha256(okio.Sink sink, okio.ByteString byteString) {
        return new okio.HashingSink(sink, byteString, "HmacSHA256");
    }

    public static okio.HashingSink hmacSha512(okio.Sink sink, okio.ByteString byteString) {
        return new okio.HashingSink(sink, byteString, "HmacSHA512");
    }

    public static okio.HashingSink md5(okio.Sink sink) {
        return new okio.HashingSink(sink, "MD5");
    }

    public static okio.HashingSink sha1(okio.Sink sink) {
        return new okio.HashingSink(sink, "SHA-1");
    }

    public static okio.HashingSink sha256(okio.Sink sink) {
        return new okio.HashingSink(sink, "SHA-256");
    }

    public static okio.HashingSink sha512(okio.Sink sink) {
        return new okio.HashingSink(sink, "SHA-512");
    }

    public final okio.ByteString hash() {
        java.security.MessageDigest messageDigest = this.messageDigest;
        return okio.ByteString.of(messageDigest != null ? messageDigest.digest() : this.mac.doFinal());
    }

    @Override // okio.ForwardingSink, okio.Sink
    public void write(okio.Buffer buffer, long j) throws java.io.IOException {
        okio.Util.checkOffsetAndCount(buffer.size, 0L, j);
        okio.Segment segment = buffer.head;
        long j2 = 0;
        while (j2 < j) {
            int min = (int) java.lang.Math.min(j - j2, segment.limit - segment.pos);
            java.security.MessageDigest messageDigest = this.messageDigest;
            if (messageDigest != null) {
                messageDigest.update(segment.data, segment.pos, min);
            } else {
                this.mac.update(segment.data, segment.pos, min);
            }
            j2 += min;
            segment = segment.next;
        }
        super.write(buffer, j);
    }
}
