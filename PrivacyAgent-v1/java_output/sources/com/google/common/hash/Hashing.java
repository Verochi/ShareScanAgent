package com.google.common.hash;

@com.google.common.annotations.Beta
/* loaded from: classes22.dex */
public final class Hashing {
    public static final int a = (int) java.lang.System.currentTimeMillis();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @com.google.errorprone.annotations.Immutable
    public static abstract class ChecksumType implements com.google.common.hash.ImmutableSupplier<java.util.zip.Checksum> {
        private static final /* synthetic */ com.google.common.hash.Hashing.ChecksumType[] $VALUES;
        public static final com.google.common.hash.Hashing.ChecksumType ADLER_32;
        public static final com.google.common.hash.Hashing.ChecksumType CRC_32;
        public final com.google.common.hash.HashFunction hashFunction;

        /* renamed from: com.google.common.hash.Hashing$ChecksumType$1, reason: invalid class name */
        public enum AnonymousClass1 extends com.google.common.hash.Hashing.ChecksumType {
            public AnonymousClass1(java.lang.String str, int i, java.lang.String str2) {
                super(str, i, str2, null);
            }

            @Override // com.google.common.base.Supplier
            public java.util.zip.Checksum get() {
                return new java.util.zip.CRC32();
            }
        }

        /* renamed from: com.google.common.hash.Hashing$ChecksumType$2, reason: invalid class name */
        public enum AnonymousClass2 extends com.google.common.hash.Hashing.ChecksumType {
            public AnonymousClass2(java.lang.String str, int i, java.lang.String str2) {
                super(str, i, str2, null);
            }

            @Override // com.google.common.base.Supplier
            public java.util.zip.Checksum get() {
                return new java.util.zip.Adler32();
            }
        }

        static {
            com.google.common.hash.Hashing.ChecksumType.AnonymousClass1 anonymousClass1 = new com.google.common.hash.Hashing.ChecksumType.AnonymousClass1("CRC_32", 0, "Hashing.crc32()");
            CRC_32 = anonymousClass1;
            com.google.common.hash.Hashing.ChecksumType.AnonymousClass2 anonymousClass2 = new com.google.common.hash.Hashing.ChecksumType.AnonymousClass2("ADLER_32", 1, "Hashing.adler32()");
            ADLER_32 = anonymousClass2;
            $VALUES = new com.google.common.hash.Hashing.ChecksumType[]{anonymousClass1, anonymousClass2};
        }

        private ChecksumType(java.lang.String str, int i, java.lang.String str2) {
            this.hashFunction = new com.google.common.hash.ChecksumHashFunction(this, 32, str2);
        }

        public /* synthetic */ ChecksumType(java.lang.String str, int i, java.lang.String str2, com.google.common.hash.Hashing.AnonymousClass1 anonymousClass1) {
            this(str, i, str2);
        }

        public static com.google.common.hash.Hashing.ChecksumType valueOf(java.lang.String str) {
            return (com.google.common.hash.Hashing.ChecksumType) java.lang.Enum.valueOf(com.google.common.hash.Hashing.ChecksumType.class, str);
        }

        public static com.google.common.hash.Hashing.ChecksumType[] values() {
            return (com.google.common.hash.Hashing.ChecksumType[]) $VALUES.clone();
        }
    }

    public static final class ConcatenatedHashFunction extends com.google.common.hash.AbstractCompositeHashFunction {
        public ConcatenatedHashFunction(com.google.common.hash.HashFunction... hashFunctionArr) {
            super(hashFunctionArr);
            for (com.google.common.hash.HashFunction hashFunction : hashFunctionArr) {
                com.google.common.base.Preconditions.checkArgument(hashFunction.bits() % 8 == 0, "the number of bits (%s) in hashFunction (%s) must be divisible by 8", hashFunction.bits(), (java.lang.Object) hashFunction);
            }
        }

        public /* synthetic */ ConcatenatedHashFunction(com.google.common.hash.HashFunction[] hashFunctionArr, com.google.common.hash.Hashing.AnonymousClass1 anonymousClass1) {
            this(hashFunctionArr);
        }

        @Override // com.google.common.hash.AbstractCompositeHashFunction
        public com.google.common.hash.HashCode b(com.google.common.hash.Hasher[] hasherArr) {
            byte[] bArr = new byte[bits() / 8];
            int i = 0;
            for (com.google.common.hash.Hasher hasher : hasherArr) {
                com.google.common.hash.HashCode hash = hasher.hash();
                i += hash.writeBytesTo(bArr, i, hash.bits() / 8);
            }
            return com.google.common.hash.HashCode.fromBytesNoCopy(bArr);
        }

        @Override // com.google.common.hash.HashFunction
        public int bits() {
            int i = 0;
            for (com.google.common.hash.HashFunction hashFunction : this.n) {
                i += hashFunction.bits();
            }
            return i;
        }

        public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
            if (obj instanceof com.google.common.hash.Hashing.ConcatenatedHashFunction) {
                return java.util.Arrays.equals(this.n, ((com.google.common.hash.Hashing.ConcatenatedHashFunction) obj).n);
            }
            return false;
        }

        public int hashCode() {
            return java.util.Arrays.hashCode(this.n);
        }
    }

    public static final class LinearCongruentialGenerator {
        public long a;

        public LinearCongruentialGenerator(long j) {
            this.a = j;
        }

        public double a() {
            this.a = (this.a * 2862933555777941757L) + 1;
            return (((int) (r2 >>> 33)) + 1) / 2.147483648E9d;
        }
    }

    public static class Md5Holder {
        public static final com.google.common.hash.HashFunction a = new com.google.common.hash.MessageDigestHashFunction("MD5", "Hashing.md5()");
    }

    public static class Sha1Holder {
        public static final com.google.common.hash.HashFunction a = new com.google.common.hash.MessageDigestHashFunction("SHA-1", "Hashing.sha1()");
    }

    public static class Sha256Holder {
        public static final com.google.common.hash.HashFunction a = new com.google.common.hash.MessageDigestHashFunction("SHA-256", "Hashing.sha256()");
    }

    public static class Sha384Holder {
        public static final com.google.common.hash.HashFunction a = new com.google.common.hash.MessageDigestHashFunction("SHA-384", "Hashing.sha384()");
    }

    public static class Sha512Holder {
        public static final com.google.common.hash.HashFunction a = new com.google.common.hash.MessageDigestHashFunction("SHA-512", "Hashing.sha512()");
    }

    public static int a(int i) {
        com.google.common.base.Preconditions.checkArgument(i > 0, "Number of bits must be positive");
        return (i + 31) & (-32);
    }

    public static com.google.common.hash.HashFunction adler32() {
        return com.google.common.hash.Hashing.ChecksumType.ADLER_32.hashFunction;
    }

    public static java.lang.String b(java.lang.String str, java.security.Key key) {
        return java.lang.String.format("Hashing.%s(Key[algorithm=%s, format=%s])", str, key.getAlgorithm(), key.getFormat());
    }

    public static com.google.common.hash.HashCode combineOrdered(java.lang.Iterable<com.google.common.hash.HashCode> iterable) {
        java.util.Iterator<com.google.common.hash.HashCode> it = iterable.iterator();
        com.google.common.base.Preconditions.checkArgument(it.hasNext(), "Must be at least 1 hash code to combine.");
        int bits = it.next().bits() / 8;
        byte[] bArr = new byte[bits];
        java.util.Iterator<com.google.common.hash.HashCode> it2 = iterable.iterator();
        while (it2.hasNext()) {
            byte[] asBytes = it2.next().asBytes();
            com.google.common.base.Preconditions.checkArgument(asBytes.length == bits, "All hashcodes must have the same bit length.");
            for (int i = 0; i < asBytes.length; i++) {
                bArr[i] = (byte) ((bArr[i] * 37) ^ asBytes[i]);
            }
        }
        return com.google.common.hash.HashCode.fromBytesNoCopy(bArr);
    }

    public static com.google.common.hash.HashCode combineUnordered(java.lang.Iterable<com.google.common.hash.HashCode> iterable) {
        java.util.Iterator<com.google.common.hash.HashCode> it = iterable.iterator();
        com.google.common.base.Preconditions.checkArgument(it.hasNext(), "Must be at least 1 hash code to combine.");
        int bits = it.next().bits() / 8;
        byte[] bArr = new byte[bits];
        java.util.Iterator<com.google.common.hash.HashCode> it2 = iterable.iterator();
        while (it2.hasNext()) {
            byte[] asBytes = it2.next().asBytes();
            com.google.common.base.Preconditions.checkArgument(asBytes.length == bits, "All hashcodes must have the same bit length.");
            for (int i = 0; i < asBytes.length; i++) {
                bArr[i] = (byte) (bArr[i] + asBytes[i]);
            }
        }
        return com.google.common.hash.HashCode.fromBytesNoCopy(bArr);
    }

    public static com.google.common.hash.HashFunction concatenating(com.google.common.hash.HashFunction hashFunction, com.google.common.hash.HashFunction hashFunction2, com.google.common.hash.HashFunction... hashFunctionArr) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(hashFunction);
        arrayList.add(hashFunction2);
        arrayList.addAll(java.util.Arrays.asList(hashFunctionArr));
        return new com.google.common.hash.Hashing.ConcatenatedHashFunction((com.google.common.hash.HashFunction[]) arrayList.toArray(new com.google.common.hash.HashFunction[0]), null);
    }

    public static com.google.common.hash.HashFunction concatenating(java.lang.Iterable<com.google.common.hash.HashFunction> iterable) {
        com.google.common.base.Preconditions.checkNotNull(iterable);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<com.google.common.hash.HashFunction> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        com.google.common.base.Preconditions.checkArgument(arrayList.size() > 0, "number of hash functions (%s) must be > 0", arrayList.size());
        return new com.google.common.hash.Hashing.ConcatenatedHashFunction((com.google.common.hash.HashFunction[]) arrayList.toArray(new com.google.common.hash.HashFunction[0]), null);
    }

    public static int consistentHash(long j, int i) {
        int i2 = 0;
        com.google.common.base.Preconditions.checkArgument(i > 0, "buckets must be positive: %s", i);
        com.google.common.hash.Hashing.LinearCongruentialGenerator linearCongruentialGenerator = new com.google.common.hash.Hashing.LinearCongruentialGenerator(j);
        while (true) {
            int a2 = (int) ((i2 + 1) / linearCongruentialGenerator.a());
            if (a2 < 0 || a2 >= i) {
                break;
            }
            i2 = a2;
        }
        return i2;
    }

    public static int consistentHash(com.google.common.hash.HashCode hashCode, int i) {
        return consistentHash(hashCode.padToLong(), i);
    }

    public static com.google.common.hash.HashFunction crc32() {
        return com.google.common.hash.Hashing.ChecksumType.CRC_32.hashFunction;
    }

    public static com.google.common.hash.HashFunction crc32c() {
        return com.google.common.hash.Crc32cHashFunction.n;
    }

    public static com.google.common.hash.HashFunction farmHashFingerprint64() {
        return com.google.common.hash.FarmHashFingerprint64.n;
    }

    public static com.google.common.hash.HashFunction goodFastHash(int i) {
        int a2 = a(i);
        if (a2 == 32) {
            return com.google.common.hash.Murmur3_32HashFunction.GOOD_FAST_HASH_32;
        }
        if (a2 <= 128) {
            return com.google.common.hash.Murmur3_128HashFunction.GOOD_FAST_HASH_128;
        }
        int i2 = (a2 + 127) / 128;
        com.google.common.hash.HashFunction[] hashFunctionArr = new com.google.common.hash.HashFunction[i2];
        hashFunctionArr[0] = com.google.common.hash.Murmur3_128HashFunction.GOOD_FAST_HASH_128;
        int i3 = a;
        for (int i4 = 1; i4 < i2; i4++) {
            i3 += 1500450271;
            hashFunctionArr[i4] = murmur3_128(i3);
        }
        return new com.google.common.hash.Hashing.ConcatenatedHashFunction(hashFunctionArr, null);
    }

    public static com.google.common.hash.HashFunction hmacMd5(java.security.Key key) {
        return new com.google.common.hash.MacHashFunction("HmacMD5", key, b("hmacMd5", key));
    }

    public static com.google.common.hash.HashFunction hmacMd5(byte[] bArr) {
        return hmacMd5(new javax.crypto.spec.SecretKeySpec((byte[]) com.google.common.base.Preconditions.checkNotNull(bArr), "HmacMD5"));
    }

    public static com.google.common.hash.HashFunction hmacSha1(java.security.Key key) {
        return new com.google.common.hash.MacHashFunction("HmacSHA1", key, b("hmacSha1", key));
    }

    public static com.google.common.hash.HashFunction hmacSha1(byte[] bArr) {
        return hmacSha1(new javax.crypto.spec.SecretKeySpec((byte[]) com.google.common.base.Preconditions.checkNotNull(bArr), "HmacSHA1"));
    }

    public static com.google.common.hash.HashFunction hmacSha256(java.security.Key key) {
        return new com.google.common.hash.MacHashFunction("HmacSHA256", key, b("hmacSha256", key));
    }

    public static com.google.common.hash.HashFunction hmacSha256(byte[] bArr) {
        return hmacSha256(new javax.crypto.spec.SecretKeySpec((byte[]) com.google.common.base.Preconditions.checkNotNull(bArr), "HmacSHA256"));
    }

    public static com.google.common.hash.HashFunction hmacSha512(java.security.Key key) {
        return new com.google.common.hash.MacHashFunction("HmacSHA512", key, b("hmacSha512", key));
    }

    public static com.google.common.hash.HashFunction hmacSha512(byte[] bArr) {
        return hmacSha512(new javax.crypto.spec.SecretKeySpec((byte[]) com.google.common.base.Preconditions.checkNotNull(bArr), "HmacSHA512"));
    }

    @java.lang.Deprecated
    public static com.google.common.hash.HashFunction md5() {
        return com.google.common.hash.Hashing.Md5Holder.a;
    }

    public static com.google.common.hash.HashFunction murmur3_128() {
        return com.google.common.hash.Murmur3_128HashFunction.MURMUR3_128;
    }

    public static com.google.common.hash.HashFunction murmur3_128(int i) {
        return new com.google.common.hash.Murmur3_128HashFunction(i);
    }

    public static com.google.common.hash.HashFunction murmur3_32() {
        return com.google.common.hash.Murmur3_32HashFunction.MURMUR3_32;
    }

    public static com.google.common.hash.HashFunction murmur3_32(int i) {
        return new com.google.common.hash.Murmur3_32HashFunction(i);
    }

    @java.lang.Deprecated
    public static com.google.common.hash.HashFunction sha1() {
        return com.google.common.hash.Hashing.Sha1Holder.a;
    }

    public static com.google.common.hash.HashFunction sha256() {
        return com.google.common.hash.Hashing.Sha256Holder.a;
    }

    public static com.google.common.hash.HashFunction sha384() {
        return com.google.common.hash.Hashing.Sha384Holder.a;
    }

    public static com.google.common.hash.HashFunction sha512() {
        return com.google.common.hash.Hashing.Sha512Holder.a;
    }

    public static com.google.common.hash.HashFunction sipHash24() {
        return com.google.common.hash.SipHashFunction.SIP_HASH_24;
    }

    public static com.google.common.hash.HashFunction sipHash24(long j, long j2) {
        return new com.google.common.hash.SipHashFunction(2, 4, j, j2);
    }
}
