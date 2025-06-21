package com.google.common.hash;

@com.google.errorprone.annotations.Immutable
/* loaded from: classes22.dex */
final class ChecksumHashFunction extends com.google.common.hash.AbstractHashFunction implements java.io.Serializable {
    private static final long serialVersionUID = 0;
    private final int bits;
    private final com.google.common.hash.ImmutableSupplier<? extends java.util.zip.Checksum> checksumSupplier;
    private final java.lang.String toString;

    public final class ChecksumHasher extends com.google.common.hash.AbstractByteHasher {
        public final java.util.zip.Checksum b;

        public ChecksumHasher(java.util.zip.Checksum checksum) {
            this.b = (java.util.zip.Checksum) com.google.common.base.Preconditions.checkNotNull(checksum);
        }

        public /* synthetic */ ChecksumHasher(com.google.common.hash.ChecksumHashFunction checksumHashFunction, java.util.zip.Checksum checksum, com.google.common.hash.ChecksumHashFunction.AnonymousClass1 anonymousClass1) {
            this(checksum);
        }

        @Override // com.google.common.hash.Hasher
        public com.google.common.hash.HashCode hash() {
            long value = this.b.getValue();
            return com.google.common.hash.ChecksumHashFunction.this.bits == 32 ? com.google.common.hash.HashCode.fromInt((int) value) : com.google.common.hash.HashCode.fromLong(value);
        }

        @Override // com.google.common.hash.AbstractByteHasher
        public void update(byte b) {
            this.b.update(b);
        }

        @Override // com.google.common.hash.AbstractByteHasher
        public void update(byte[] bArr, int i, int i2) {
            this.b.update(bArr, i, i2);
        }
    }

    public ChecksumHashFunction(com.google.common.hash.ImmutableSupplier<? extends java.util.zip.Checksum> immutableSupplier, int i, java.lang.String str) {
        this.checksumSupplier = (com.google.common.hash.ImmutableSupplier) com.google.common.base.Preconditions.checkNotNull(immutableSupplier);
        com.google.common.base.Preconditions.checkArgument(i == 32 || i == 64, "bits (%s) must be either 32 or 64", i);
        this.bits = i;
        this.toString = (java.lang.String) com.google.common.base.Preconditions.checkNotNull(str);
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return this.bits;
    }

    @Override // com.google.common.hash.HashFunction
    public com.google.common.hash.Hasher newHasher() {
        return new com.google.common.hash.ChecksumHashFunction.ChecksumHasher(this, this.checksumSupplier.get(), null);
    }

    public java.lang.String toString() {
        return this.toString;
    }
}
