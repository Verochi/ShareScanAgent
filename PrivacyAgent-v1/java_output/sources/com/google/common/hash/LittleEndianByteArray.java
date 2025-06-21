package com.google.common.hash;

/* loaded from: classes22.dex */
final class LittleEndianByteArray {
    public static final com.google.common.hash.LittleEndianByteArray.LittleEndianBytes a;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class JavaLittleEndianBytes implements com.google.common.hash.LittleEndianByteArray.LittleEndianBytes {
        private static final /* synthetic */ com.google.common.hash.LittleEndianByteArray.JavaLittleEndianBytes[] $VALUES;
        public static final com.google.common.hash.LittleEndianByteArray.JavaLittleEndianBytes INSTANCE;

        /* renamed from: com.google.common.hash.LittleEndianByteArray$JavaLittleEndianBytes$1, reason: invalid class name */
        public enum AnonymousClass1 extends com.google.common.hash.LittleEndianByteArray.JavaLittleEndianBytes {
            public AnonymousClass1(java.lang.String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.hash.LittleEndianByteArray.JavaLittleEndianBytes, com.google.common.hash.LittleEndianByteArray.LittleEndianBytes
            public long getLongLittleEndian(byte[] bArr, int i) {
                return com.google.common.primitives.Longs.fromBytes(bArr[i + 7], bArr[i + 6], bArr[i + 5], bArr[i + 4], bArr[i + 3], bArr[i + 2], bArr[i + 1], bArr[i]);
            }

            @Override // com.google.common.hash.LittleEndianByteArray.JavaLittleEndianBytes
            public void putLongLittleEndian(byte[] bArr, int i, long j) {
                long j2 = 255;
                for (int i2 = 0; i2 < 8; i2++) {
                    bArr[i + i2] = (byte) ((j & j2) >> (i2 * 8));
                    j2 <<= 8;
                }
            }
        }

        static {
            com.google.common.hash.LittleEndianByteArray.JavaLittleEndianBytes.AnonymousClass1 anonymousClass1 = new com.google.common.hash.LittleEndianByteArray.JavaLittleEndianBytes.AnonymousClass1("INSTANCE", 0);
            INSTANCE = anonymousClass1;
            $VALUES = new com.google.common.hash.LittleEndianByteArray.JavaLittleEndianBytes[]{anonymousClass1};
        }

        private JavaLittleEndianBytes(java.lang.String str, int i) {
        }

        public /* synthetic */ JavaLittleEndianBytes(java.lang.String str, int i, com.google.common.hash.LittleEndianByteArray.AnonymousClass1 anonymousClass1) {
            this(str, i);
        }

        public static com.google.common.hash.LittleEndianByteArray.JavaLittleEndianBytes valueOf(java.lang.String str) {
            return (com.google.common.hash.LittleEndianByteArray.JavaLittleEndianBytes) java.lang.Enum.valueOf(com.google.common.hash.LittleEndianByteArray.JavaLittleEndianBytes.class, str);
        }

        public static com.google.common.hash.LittleEndianByteArray.JavaLittleEndianBytes[] values() {
            return (com.google.common.hash.LittleEndianByteArray.JavaLittleEndianBytes[]) $VALUES.clone();
        }

        @Override // com.google.common.hash.LittleEndianByteArray.LittleEndianBytes
        public abstract /* synthetic */ long getLongLittleEndian(byte[] bArr, int i);

        public abstract /* synthetic */ void putLongLittleEndian(byte[] bArr, int i, long j);
    }

    public interface LittleEndianBytes {
        long getLongLittleEndian(byte[] bArr, int i);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class UnsafeByteArray implements com.google.common.hash.LittleEndianByteArray.LittleEndianBytes {
        private static final /* synthetic */ com.google.common.hash.LittleEndianByteArray.UnsafeByteArray[] $VALUES;
        private static final int BYTE_ARRAY_BASE_OFFSET;
        public static final com.google.common.hash.LittleEndianByteArray.UnsafeByteArray UNSAFE_BIG_ENDIAN;
        public static final com.google.common.hash.LittleEndianByteArray.UnsafeByteArray UNSAFE_LITTLE_ENDIAN;
        private static final sun.misc.Unsafe theUnsafe;

        /* renamed from: com.google.common.hash.LittleEndianByteArray$UnsafeByteArray$1, reason: invalid class name */
        public enum AnonymousClass1 extends com.google.common.hash.LittleEndianByteArray.UnsafeByteArray {
            public AnonymousClass1(java.lang.String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.hash.LittleEndianByteArray.UnsafeByteArray, com.google.common.hash.LittleEndianByteArray.LittleEndianBytes
            public long getLongLittleEndian(byte[] bArr, int i) {
                return com.google.common.hash.LittleEndianByteArray.UnsafeByteArray.theUnsafe.getLong(bArr, i + com.google.common.hash.LittleEndianByteArray.UnsafeByteArray.BYTE_ARRAY_BASE_OFFSET);
            }

            @Override // com.google.common.hash.LittleEndianByteArray.UnsafeByteArray
            public void putLongLittleEndian(byte[] bArr, int i, long j) {
                com.google.common.hash.LittleEndianByteArray.UnsafeByteArray.theUnsafe.putLong(bArr, i + com.google.common.hash.LittleEndianByteArray.UnsafeByteArray.BYTE_ARRAY_BASE_OFFSET, j);
            }
        }

        /* renamed from: com.google.common.hash.LittleEndianByteArray$UnsafeByteArray$2, reason: invalid class name */
        public enum AnonymousClass2 extends com.google.common.hash.LittleEndianByteArray.UnsafeByteArray {
            public AnonymousClass2(java.lang.String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.hash.LittleEndianByteArray.UnsafeByteArray, com.google.common.hash.LittleEndianByteArray.LittleEndianBytes
            public long getLongLittleEndian(byte[] bArr, int i) {
                return java.lang.Long.reverseBytes(com.google.common.hash.LittleEndianByteArray.UnsafeByteArray.theUnsafe.getLong(bArr, i + com.google.common.hash.LittleEndianByteArray.UnsafeByteArray.BYTE_ARRAY_BASE_OFFSET));
            }

            @Override // com.google.common.hash.LittleEndianByteArray.UnsafeByteArray
            public void putLongLittleEndian(byte[] bArr, int i, long j) {
                com.google.common.hash.LittleEndianByteArray.UnsafeByteArray.theUnsafe.putLong(bArr, i + com.google.common.hash.LittleEndianByteArray.UnsafeByteArray.BYTE_ARRAY_BASE_OFFSET, java.lang.Long.reverseBytes(j));
            }
        }

        /* renamed from: com.google.common.hash.LittleEndianByteArray$UnsafeByteArray$3, reason: invalid class name */
        public static class AnonymousClass3 implements java.security.PrivilegedExceptionAction<sun.misc.Unsafe> {
            @Override // java.security.PrivilegedExceptionAction
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public sun.misc.Unsafe run() throws java.lang.Exception {
                for (java.lang.reflect.Field field : sun.misc.Unsafe.class.getDeclaredFields()) {
                    field.setAccessible(true);
                    java.lang.Object obj = field.get(null);
                    if (sun.misc.Unsafe.class.isInstance(obj)) {
                        return (sun.misc.Unsafe) sun.misc.Unsafe.class.cast(obj);
                    }
                }
                throw new java.lang.NoSuchFieldError("the Unsafe");
            }
        }

        static {
            com.google.common.hash.LittleEndianByteArray.UnsafeByteArray.AnonymousClass1 anonymousClass1 = new com.google.common.hash.LittleEndianByteArray.UnsafeByteArray.AnonymousClass1("UNSAFE_LITTLE_ENDIAN", 0);
            UNSAFE_LITTLE_ENDIAN = anonymousClass1;
            com.google.common.hash.LittleEndianByteArray.UnsafeByteArray.AnonymousClass2 anonymousClass2 = new com.google.common.hash.LittleEndianByteArray.UnsafeByteArray.AnonymousClass2("UNSAFE_BIG_ENDIAN", 1);
            UNSAFE_BIG_ENDIAN = anonymousClass2;
            $VALUES = new com.google.common.hash.LittleEndianByteArray.UnsafeByteArray[]{anonymousClass1, anonymousClass2};
            sun.misc.Unsafe unsafe = getUnsafe();
            theUnsafe = unsafe;
            BYTE_ARRAY_BASE_OFFSET = unsafe.arrayBaseOffset(byte[].class);
            if (unsafe.arrayIndexScale(byte[].class) != 1) {
                throw new java.lang.AssertionError();
            }
        }

        private UnsafeByteArray(java.lang.String str, int i) {
        }

        public /* synthetic */ UnsafeByteArray(java.lang.String str, int i, com.google.common.hash.LittleEndianByteArray.AnonymousClass1 anonymousClass1) {
            this(str, i);
        }

        private static sun.misc.Unsafe getUnsafe() {
            try {
                try {
                    return sun.misc.Unsafe.getUnsafe();
                } catch (java.security.PrivilegedActionException e) {
                    throw new java.lang.RuntimeException("Could not initialize intrinsics", e.getCause());
                }
            } catch (java.lang.SecurityException unused) {
                return (sun.misc.Unsafe) java.security.AccessController.doPrivileged(new com.google.common.hash.LittleEndianByteArray.UnsafeByteArray.AnonymousClass3());
            }
        }

        public static com.google.common.hash.LittleEndianByteArray.UnsafeByteArray valueOf(java.lang.String str) {
            return (com.google.common.hash.LittleEndianByteArray.UnsafeByteArray) java.lang.Enum.valueOf(com.google.common.hash.LittleEndianByteArray.UnsafeByteArray.class, str);
        }

        public static com.google.common.hash.LittleEndianByteArray.UnsafeByteArray[] values() {
            return (com.google.common.hash.LittleEndianByteArray.UnsafeByteArray[]) $VALUES.clone();
        }

        @Override // com.google.common.hash.LittleEndianByteArray.LittleEndianBytes
        public abstract /* synthetic */ long getLongLittleEndian(byte[] bArr, int i);

        public abstract /* synthetic */ void putLongLittleEndian(byte[] bArr, int i, long j);
    }

    static {
        com.google.common.hash.LittleEndianByteArray.LittleEndianBytes littleEndianBytes = com.google.common.hash.LittleEndianByteArray.JavaLittleEndianBytes.INSTANCE;
        try {
            if ("amd64".equals(java.lang.System.getProperty("os.arch"))) {
                littleEndianBytes = java.nio.ByteOrder.nativeOrder().equals(java.nio.ByteOrder.LITTLE_ENDIAN) ? com.google.common.hash.LittleEndianByteArray.UnsafeByteArray.UNSAFE_LITTLE_ENDIAN : com.google.common.hash.LittleEndianByteArray.UnsafeByteArray.UNSAFE_BIG_ENDIAN;
            }
        } catch (java.lang.Throwable unused) {
        }
        a = littleEndianBytes;
    }

    public static int a(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public static long b(byte[] bArr, int i) {
        return a.getLongLittleEndian(bArr, i);
    }
}
