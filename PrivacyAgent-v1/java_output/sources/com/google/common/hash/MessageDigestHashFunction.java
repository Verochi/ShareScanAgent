package com.google.common.hash;

@com.google.errorprone.annotations.Immutable
/* loaded from: classes22.dex */
final class MessageDigestHashFunction extends com.google.common.hash.AbstractHashFunction implements java.io.Serializable {
    private final int bytes;
    private final java.security.MessageDigest prototype;
    private final boolean supportsClone;
    private final java.lang.String toString;

    public static final class MessageDigestHasher extends com.google.common.hash.AbstractByteHasher {
        public final java.security.MessageDigest b;
        public final int c;
        public boolean d;

        public MessageDigestHasher(java.security.MessageDigest messageDigest, int i) {
            this.b = messageDigest;
            this.c = i;
        }

        public /* synthetic */ MessageDigestHasher(java.security.MessageDigest messageDigest, int i, com.google.common.hash.MessageDigestHashFunction.AnonymousClass1 anonymousClass1) {
            this(messageDigest, i);
        }

        public final void a() {
            com.google.common.base.Preconditions.checkState(!this.d, "Cannot re-use a Hasher after calling hash() on it");
        }

        @Override // com.google.common.hash.Hasher
        public com.google.common.hash.HashCode hash() {
            a();
            this.d = true;
            return this.c == this.b.getDigestLength() ? com.google.common.hash.HashCode.fromBytesNoCopy(this.b.digest()) : com.google.common.hash.HashCode.fromBytesNoCopy(java.util.Arrays.copyOf(this.b.digest(), this.c));
        }

        @Override // com.google.common.hash.AbstractByteHasher
        public void update(byte b) {
            a();
            this.b.update(b);
        }

        @Override // com.google.common.hash.AbstractByteHasher
        public void update(java.nio.ByteBuffer byteBuffer) {
            a();
            this.b.update(byteBuffer);
        }

        @Override // com.google.common.hash.AbstractByteHasher
        public void update(byte[] bArr, int i, int i2) {
            a();
            this.b.update(bArr, i, i2);
        }
    }

    public static final class SerializedForm implements java.io.Serializable {
        private static final long serialVersionUID = 0;
        private final java.lang.String algorithmName;
        private final int bytes;
        private final java.lang.String toString;

        private SerializedForm(java.lang.String str, int i, java.lang.String str2) {
            this.algorithmName = str;
            this.bytes = i;
            this.toString = str2;
        }

        public /* synthetic */ SerializedForm(java.lang.String str, int i, java.lang.String str2, com.google.common.hash.MessageDigestHashFunction.AnonymousClass1 anonymousClass1) {
            this(str, i, str2);
        }

        private java.lang.Object readResolve() {
            return new com.google.common.hash.MessageDigestHashFunction(this.algorithmName, this.bytes, this.toString);
        }
    }

    public MessageDigestHashFunction(java.lang.String str, int i, java.lang.String str2) {
        this.toString = (java.lang.String) com.google.common.base.Preconditions.checkNotNull(str2);
        java.security.MessageDigest messageDigest = getMessageDigest(str);
        this.prototype = messageDigest;
        int digestLength = messageDigest.getDigestLength();
        com.google.common.base.Preconditions.checkArgument(i >= 4 && i <= digestLength, "bytes (%s) must be >= 4 and < %s", i, digestLength);
        this.bytes = i;
        this.supportsClone = supportsClone(messageDigest);
    }

    public MessageDigestHashFunction(java.lang.String str, java.lang.String str2) {
        java.security.MessageDigest messageDigest = getMessageDigest(str);
        this.prototype = messageDigest;
        this.bytes = messageDigest.getDigestLength();
        this.toString = (java.lang.String) com.google.common.base.Preconditions.checkNotNull(str2);
        this.supportsClone = supportsClone(messageDigest);
    }

    private static java.security.MessageDigest getMessageDigest(java.lang.String str) {
        try {
            return java.security.MessageDigest.getInstance(str);
        } catch (java.security.NoSuchAlgorithmException e) {
            throw new java.lang.AssertionError(e);
        }
    }

    private static boolean supportsClone(java.security.MessageDigest messageDigest) {
        try {
            messageDigest.clone();
            return true;
        } catch (java.lang.CloneNotSupportedException unused) {
            return false;
        }
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return this.bytes * 8;
    }

    @Override // com.google.common.hash.HashFunction
    public com.google.common.hash.Hasher newHasher() {
        if (this.supportsClone) {
            try {
                return new com.google.common.hash.MessageDigestHashFunction.MessageDigestHasher((java.security.MessageDigest) this.prototype.clone(), this.bytes, null);
            } catch (java.lang.CloneNotSupportedException unused) {
            }
        }
        return new com.google.common.hash.MessageDigestHashFunction.MessageDigestHasher(getMessageDigest(this.prototype.getAlgorithm()), this.bytes, null);
    }

    public java.lang.String toString() {
        return this.toString;
    }

    public java.lang.Object writeReplace() {
        return new com.google.common.hash.MessageDigestHashFunction.SerializedForm(this.prototype.getAlgorithm(), this.bytes, this.toString, null);
    }
}
