package com.bytedance.pangle.g;

/* loaded from: classes12.dex */
final class f {
    static final java.util.HashMap<java.lang.String, android.util.SparseArray<com.bytedance.pangle.g.m>> a = new java.util.HashMap<>();

    /* renamed from: com.bytedance.pangle.g.f$1, reason: invalid class name */
    public static class AnonymousClass1 implements com.bytedance.pangle.g.i {
        @Override // com.bytedance.pangle.g.i
        public final java.nio.ByteBuffer a(int i) {
            return java.nio.ByteBuffer.allocate(i);
        }
    }

    public static class a implements com.bytedance.pangle.g.j {
        private final java.security.MessageDigest[] a;

        public a(java.security.MessageDigest[] messageDigestArr) {
            this.a = messageDigestArr;
        }

        @Override // com.bytedance.pangle.g.j
        public final void a(java.nio.ByteBuffer byteBuffer) {
            java.nio.ByteBuffer slice = byteBuffer.slice();
            for (java.security.MessageDigest messageDigest : this.a) {
                slice.position(0);
                messageDigest.update(slice);
            }
        }
    }

    public static int a(int i) {
        if (i == 513) {
            return 1;
        }
        if (i == 514) {
            return 2;
        }
        if (i == 769) {
            return 1;
        }
        if (i == 1057 || i == 1059 || i == 1061) {
            return 3;
        }
        switch (i) {
            case 257:
            case 259:
                return 1;
            case 258:
            case 260:
                return 2;
            default:
                throw new java.lang.IllegalArgumentException("Unknown signature algorithm: 0x" + java.lang.Long.toHexString(i & (-1)));
        }
    }

    public static int a(int i, int i2) {
        int a2 = a(i);
        int a3 = a(i2);
        if (a2 == 1) {
            if (a3 == 1) {
                return 0;
            }
            if (a3 == 2 || a3 == 3) {
                return -1;
            }
            throw new java.lang.IllegalArgumentException("Unknown digestAlgorithm2: ".concat(java.lang.String.valueOf(a3)));
        }
        if (a2 == 2) {
            if (a3 != 1) {
                if (a3 == 2) {
                    return 0;
                }
                if (a3 != 3) {
                    throw new java.lang.IllegalArgumentException("Unknown digestAlgorithm2: ".concat(java.lang.String.valueOf(a3)));
                }
            }
            return 1;
        }
        if (a2 != 3) {
            throw new java.lang.IllegalArgumentException("Unknown digestAlgorithm1: ".concat(java.lang.String.valueOf(a2)));
        }
        if (a3 == 1) {
            return 1;
        }
        if (a3 == 2) {
            return -1;
        }
        if (a3 == 3) {
            return 0;
        }
        throw new java.lang.IllegalArgumentException("Unknown digestAlgorithm2: ".concat(java.lang.String.valueOf(a3)));
    }

    public static java.nio.ByteBuffer a(java.nio.ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() < 4) {
            throw new java.io.IOException("Remaining buffer too short to contain length of length-prefixed field. Remaining: " + byteBuffer.remaining());
        }
        int i = byteBuffer.getInt();
        if (i < 0) {
            throw new java.lang.IllegalArgumentException("Negative length");
        }
        if (i <= byteBuffer.remaining()) {
            return b(byteBuffer, i);
        }
        throw new java.io.IOException("Length-prefixed field longer than remaining buffer. Field length: " + i + ", remaining: " + byteBuffer.remaining());
    }

    private static java.nio.ByteBuffer a(java.nio.ByteBuffer byteBuffer, int i) {
        if (i < 8) {
            throw new java.lang.IllegalArgumentException("end < start: " + i + " < 8");
        }
        int capacity = byteBuffer.capacity();
        if (i > byteBuffer.capacity()) {
            throw new java.lang.IllegalArgumentException("end > capacity: " + i + " > " + capacity);
        }
        int limit = byteBuffer.limit();
        int position = byteBuffer.position();
        try {
            byteBuffer.position(0);
            byteBuffer.limit(i);
            byteBuffer.position(8);
            java.nio.ByteBuffer slice = byteBuffer.slice();
            slice.order(byteBuffer.order());
            return slice;
        } finally {
            byteBuffer.position(0);
            byteBuffer.limit(limit);
            byteBuffer.position(position);
        }
    }

    private static void a(int i, byte[] bArr) {
        bArr[1] = (byte) (i & 255);
        bArr[2] = (byte) ((i >>> 8) & 255);
        bArr[3] = (byte) ((i >>> 16) & 255);
        bArr[4] = (byte) ((i >>> 24) & 255);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0236  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(java.lang.String str, java.io.RandomAccessFile randomAccessFile, int... iArr) {
        android.util.Pair<java.nio.ByteBuffer, java.lang.Long> a2;
        boolean z;
        long j;
        java.util.HashSet hashSet;
        long j2;
        java.lang.String str2 = str;
        a.put(str2, new android.util.SparseArray<>());
        android.util.Pair pair = null;
        if (randomAccessFile.length() < 22) {
            a2 = null;
        } else {
            a2 = com.bytedance.pangle.g.s.a(randomAccessFile, 0);
            if (a2 == null) {
                a2 = com.bytedance.pangle.g.s.a(randomAccessFile, 65535);
            }
        }
        if (a2 == null) {
            throw new com.bytedance.pangle.g.n("Not an APK file: ZIP End of Central Directory record not found");
        }
        java.nio.ByteBuffer byteBuffer = (java.nio.ByteBuffer) a2.first;
        long longValue = ((java.lang.Long) a2.second).longValue();
        long j3 = longValue - 20;
        if (j3 >= 0) {
            randomAccessFile.seek(j3);
            if (randomAccessFile.readInt() == 1347094023) {
                z = true;
                if (!z) {
                    throw new com.bytedance.pangle.g.n("ZIP64 APK not supported");
                }
                com.bytedance.pangle.g.s.a(byteBuffer);
                long a3 = com.bytedance.pangle.g.s.a(byteBuffer, byteBuffer.position() + 16);
                if (a3 > longValue) {
                    throw new com.bytedance.pangle.g.n("ZIP Central Directory offset out of range: " + a3 + ". ZIP End of Central Directory offset: " + longValue);
                }
                com.bytedance.pangle.g.s.a(byteBuffer);
                if (com.bytedance.pangle.g.s.a(byteBuffer, byteBuffer.position() + 12) + a3 != longValue) {
                    throw new com.bytedance.pangle.g.n("ZIP Central Directory is not immediately followed by End of Central Directory");
                }
                if (a3 < 32) {
                    throw new com.bytedance.pangle.g.n("APK too small for APK Signing Block. ZIP Central Directory offset: ".concat(java.lang.String.valueOf(a3)));
                }
                java.nio.ByteBuffer allocate = java.nio.ByteBuffer.allocate(24);
                java.nio.ByteOrder byteOrder = java.nio.ByteOrder.LITTLE_ENDIAN;
                allocate.order(byteOrder);
                randomAccessFile.seek(a3 - allocate.capacity());
                randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
                if (allocate.getLong(8) == 2334950737559900225L && allocate.getLong(16) == 3617552046287187010L) {
                    long j4 = allocate.getLong(0);
                    if (j4 < allocate.capacity() || j4 > 2147483639) {
                        throw new com.bytedance.pangle.g.n("APK Signing Block size out of range: ".concat(java.lang.String.valueOf(j4)));
                    }
                    int i = (int) (8 + j4);
                    long j5 = a3 - i;
                    if (j5 < 0) {
                        throw new com.bytedance.pangle.g.n("APK Signing Block offset out of range: ".concat(java.lang.String.valueOf(j5)));
                    }
                    java.nio.ByteBuffer allocate2 = java.nio.ByteBuffer.allocate(i);
                    allocate2.order(byteOrder);
                    randomAccessFile.seek(j5);
                    randomAccessFile.readFully(allocate2.array(), allocate2.arrayOffset(), allocate2.capacity());
                    long j6 = allocate2.getLong(0);
                    if (j6 != j4) {
                        throw new com.bytedance.pangle.g.n("APK Signing Block sizes in header and footer do not match: " + j6 + " vs " + j4);
                    }
                    pair = android.util.Pair.create(allocate2, java.lang.Long.valueOf(j5));
                }
                if (pair == null) {
                    return;
                }
                java.nio.ByteBuffer byteBuffer2 = (java.nio.ByteBuffer) pair.first;
                long longValue2 = ((java.lang.Long) pair.second).longValue();
                if (byteBuffer2.order() != byteOrder) {
                    throw new java.lang.IllegalArgumentException("ByteBuffer byte order must be little endian");
                }
                java.nio.ByteBuffer a4 = a(byteBuffer2, byteBuffer2.capacity() - 24);
                java.util.HashSet hashSet2 = new java.util.HashSet();
                for (int i2 = 0; i2 < 2; i2++) {
                    hashSet2.add(java.lang.Integer.valueOf(iArr[i2]));
                }
                while (a4.hasRemaining() && a4.remaining() >= 8) {
                    long j7 = a4.getLong();
                    if (j7 < 4 || j7 > 2147483647L) {
                        return;
                    }
                    int i3 = (int) j7;
                    int position = a4.position() + i3;
                    if (i3 > a4.remaining()) {
                        return;
                    }
                    int i4 = a4.getInt();
                    if (hashSet2.contains(java.lang.Integer.valueOf(i4))) {
                        hashSet = hashSet2;
                        j = longValue2;
                        j2 = a3;
                        a.get(str2).put(i4, new com.bytedance.pangle.g.m(b(a4, i3 - 4), longValue2, a3, longValue, byteBuffer));
                    } else {
                        j = longValue2;
                        hashSet = hashSet2;
                        j2 = a3;
                    }
                    a4.position(position);
                    str2 = str;
                    hashSet2 = hashSet;
                    longValue2 = j;
                    a3 = j2;
                }
                return;
            }
        }
        z = false;
        if (!z) {
        }
    }

    private static void a(java.util.Map<java.lang.Integer, byte[]> map, java.io.FileDescriptor fileDescriptor, com.bytedance.pangle.g.m mVar) {
        com.bytedance.pangle.g.l lVar = new com.bytedance.pangle.g.l(fileDescriptor, 0L, mVar.b);
        long j = mVar.c;
        com.bytedance.pangle.g.l lVar2 = new com.bytedance.pangle.g.l(fileDescriptor, j, mVar.d - j);
        java.nio.ByteBuffer duplicate = mVar.e.duplicate();
        duplicate.order(java.nio.ByteOrder.LITTLE_ENDIAN);
        long j2 = mVar.b;
        com.bytedance.pangle.g.s.a(duplicate);
        int position = duplicate.position() + 16;
        if (j2 < 0 || j2 > net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT) {
            throw new java.lang.IllegalArgumentException("uint32 value of out range: ".concat(java.lang.String.valueOf(j2)));
        }
        duplicate.putInt(duplicate.position() + position, (int) j2);
        com.bytedance.pangle.g.h hVar = new com.bytedance.pangle.g.h(duplicate);
        int size = map.size();
        int[] iArr = new int[size];
        java.util.Iterator<java.lang.Integer> it = map.keySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            iArr[i] = it.next().intValue();
            i++;
        }
        try {
            byte[][] a2 = a(iArr, new com.bytedance.pangle.g.k[]{lVar, lVar2, hVar});
            for (int i2 = 0; i2 < size; i2++) {
                int i3 = iArr[i2];
                if (!java.security.MessageDigest.isEqual(map.get(java.lang.Integer.valueOf(i3)), a2[i2])) {
                    throw new java.lang.SecurityException(b(i3) + " digest of contents did not verify");
                }
            }
        } catch (java.security.DigestException e) {
            throw new java.lang.SecurityException("Failed to compute digest(s) of contents", e);
        }
    }

    @androidx.annotation.RequiresApi(api = 21)
    public static void a(java.util.Map<java.lang.Integer, byte[]> map, java.io.RandomAccessFile randomAccessFile, com.bytedance.pangle.g.m mVar) {
        if (map.isEmpty()) {
            throw new java.lang.SecurityException("No digests provided");
        }
        android.util.ArrayMap arrayMap = new android.util.ArrayMap();
        boolean z = true;
        if (map.containsKey(1)) {
            arrayMap.put(1, map.get(1));
        }
        if (map.containsKey(2)) {
            arrayMap.put(2, map.get(2));
        }
        boolean z2 = false;
        if (!arrayMap.isEmpty()) {
            try {
                a(arrayMap, randomAccessFile.getFD(), mVar);
                z = false;
            } catch (java.io.IOException e) {
                throw new java.lang.SecurityException("Cannot get FD", e);
            }
        }
        if (map.containsKey(3)) {
            try {
                if (!java.util.Arrays.equals(a(map.get(3), randomAccessFile.length(), mVar), com.bytedance.pangle.g.g.a(randomAccessFile, mVar, new com.bytedance.pangle.g.f.AnonymousClass1()).b)) {
                    throw new java.lang.SecurityException("APK verity digest of contents did not verify");
                }
            } catch (java.io.IOException | java.security.DigestException | java.security.NoSuchAlgorithmException e2) {
                throw new java.lang.SecurityException("Error during verification", e2);
            }
        } else {
            z2 = z;
        }
        if (z2) {
            throw new java.lang.SecurityException("No known digest exists for integrity check");
        }
    }

    public static byte[] a(byte[] bArr, long j, com.bytedance.pangle.g.m mVar) {
        if (bArr.length != 40) {
            throw new java.lang.SecurityException("Verity digest size is wrong: " + bArr.length);
        }
        java.nio.ByteBuffer order = java.nio.ByteBuffer.wrap(bArr).order(java.nio.ByteOrder.LITTLE_ENDIAN);
        order.position(32);
        if (order.getLong() == j - (mVar.c - mVar.b)) {
            return java.util.Arrays.copyOfRange(bArr, 0, 32);
        }
        throw new java.lang.SecurityException("APK content size did not verify");
    }

    private static byte[][] a(int[] iArr, com.bytedance.pangle.g.k[] kVarArr) {
        int i;
        long j;
        long j2 = 0;
        long j3 = 0;
        int i2 = 0;
        while (true) {
            i = 3;
            j = 1048576;
            if (i2 >= 3) {
                break;
            }
            j3 += ((kVarArr[i2].a() + 1048576) - 1) / 1048576;
            i2++;
        }
        if (j3 >= org.apache.tools.tar.TarConstants.MAXID) {
            throw new java.security.DigestException("Too many chunks: ".concat(java.lang.String.valueOf(j3)));
        }
        int i3 = (int) j3;
        byte[][] bArr = new byte[iArr.length][];
        for (int i4 = 0; i4 < iArr.length; i4++) {
            byte[] bArr2 = new byte[(e(iArr[i4]) * i3) + 5];
            bArr2[0] = 90;
            a(i3, bArr2);
            bArr[i4] = bArr2;
        }
        byte[] bArr3 = new byte[5];
        bArr3[0] = -91;
        int length = iArr.length;
        java.security.MessageDigest[] messageDigestArr = new java.security.MessageDigest[length];
        for (int i5 = 0; i5 < iArr.length; i5++) {
            java.lang.String b = b(iArr[i5]);
            try {
                messageDigestArr[i5] = java.security.MessageDigest.getInstance(b);
            } catch (java.security.NoSuchAlgorithmException e) {
                throw new java.lang.RuntimeException(b + " digest not supported", e);
            }
        }
        com.bytedance.pangle.g.f.a aVar = new com.bytedance.pangle.g.f.a(messageDigestArr);
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i6 < i) {
            com.bytedance.pangle.g.k kVar = kVarArr[i6];
            long j4 = j2;
            int i9 = i8;
            com.bytedance.pangle.g.f.a aVar2 = aVar;
            long a2 = kVar.a();
            while (a2 > j2) {
                int min = (int) java.lang.Math.min(a2, j);
                a(min, bArr3);
                for (int i10 = 0; i10 < length; i10++) {
                    messageDigestArr[i10].update(bArr3);
                }
                com.bytedance.pangle.g.f.a aVar3 = aVar2;
                long j5 = j4;
                try {
                    kVar.a(aVar3, j5, min);
                    aVar2 = aVar3;
                    com.bytedance.pangle.g.k kVar2 = kVar;
                    int i11 = 0;
                    while (i11 < iArr.length) {
                        int i12 = iArr[i11];
                        byte[] bArr4 = bArr3;
                        byte[] bArr5 = bArr[i11];
                        int e2 = e(i12);
                        int i13 = length;
                        java.security.MessageDigest messageDigest = messageDigestArr[i11];
                        java.security.MessageDigest[] messageDigestArr2 = messageDigestArr;
                        int digest = messageDigest.digest(bArr5, (i9 * e2) + 5, e2);
                        if (digest != e2) {
                            throw new java.lang.RuntimeException("Unexpected output size of " + messageDigest.getAlgorithm() + " digest: " + digest);
                        }
                        i11++;
                        bArr3 = bArr4;
                        length = i13;
                        messageDigestArr = messageDigestArr2;
                    }
                    long j6 = min;
                    long j7 = j5 + j6;
                    a2 -= j6;
                    i9++;
                    j2 = 0;
                    j = 1048576;
                    kVar = kVar2;
                    bArr3 = bArr3;
                    j4 = j7;
                } catch (java.io.IOException e3) {
                    throw new java.security.DigestException("Failed to digest chunk #" + i9 + " of section #" + i7, e3);
                }
            }
            i7++;
            i6++;
            i8 = i9;
            aVar = aVar2;
            j2 = 0;
            i = 3;
            j = 1048576;
        }
        byte[][] bArr6 = new byte[iArr.length][];
        for (int i14 = 0; i14 < iArr.length; i14++) {
            int i15 = iArr[i14];
            byte[] bArr7 = bArr[i14];
            java.lang.String b2 = b(i15);
            try {
                bArr6[i14] = java.security.MessageDigest.getInstance(b2).digest(bArr7);
            } catch (java.security.NoSuchAlgorithmException e4) {
                throw new java.lang.RuntimeException(b2 + " digest not supported", e4);
            }
        }
        return bArr6;
    }

    public static java.lang.String b(int i) {
        if (i == 1) {
            return "SHA-256";
        }
        if (i == 2) {
            return "SHA-512";
        }
        if (i == 3) {
            return "SHA-256";
        }
        throw new java.lang.IllegalArgumentException("Unknown content digest algorthm: ".concat(java.lang.String.valueOf(i)));
    }

    private static java.nio.ByteBuffer b(java.nio.ByteBuffer byteBuffer, int i) {
        if (i < 0) {
            throw new java.lang.IllegalArgumentException("size: ".concat(java.lang.String.valueOf(i)));
        }
        int limit = byteBuffer.limit();
        int position = byteBuffer.position();
        int i2 = i + position;
        if (i2 < position || i2 > limit) {
            throw new java.nio.BufferUnderflowException();
        }
        byteBuffer.limit(i2);
        try {
            java.nio.ByteBuffer slice = byteBuffer.slice();
            slice.order(byteBuffer.order());
            byteBuffer.position(i2);
            return slice;
        } finally {
            byteBuffer.limit(limit);
        }
    }

    public static byte[] b(java.nio.ByteBuffer byteBuffer) {
        int i = byteBuffer.getInt();
        if (i < 0) {
            throw new java.io.IOException("Negative length");
        }
        if (i <= byteBuffer.remaining()) {
            byte[] bArr = new byte[i];
            byteBuffer.get(bArr);
            return bArr;
        }
        throw new java.io.IOException("Underflow while reading length-prefixed value. Length: " + i + ", available: " + byteBuffer.remaining());
    }

    public static java.lang.String c(int i) {
        if (i == 513 || i == 514) {
            return "EC";
        }
        if (i == 769) {
            return "DSA";
        }
        if (i == 1057) {
            return com.alipay.sdk.m.n.d.a;
        }
        if (i == 1059) {
            return "EC";
        }
        if (i == 1061) {
            return "DSA";
        }
        switch (i) {
            case 257:
            case 258:
            case 259:
            case 260:
                return com.alipay.sdk.m.n.d.a;
            default:
                throw new java.lang.IllegalArgumentException("Unknown signature algorithm: 0x" + java.lang.Long.toHexString(i & (-1)));
        }
    }

    public static android.util.Pair<java.lang.String, ? extends java.security.spec.AlgorithmParameterSpec> d(int i) {
        if (i != 513) {
            if (i == 514) {
                return android.util.Pair.create("SHA512withECDSA", null);
            }
            if (i != 769) {
                if (i != 1057) {
                    if (i != 1059) {
                        if (i != 1061) {
                            switch (i) {
                                case 257:
                                    return android.util.Pair.create("SHA256withRSA/PSS", new java.security.spec.PSSParameterSpec("SHA-256", "MGF1", java.security.spec.MGF1ParameterSpec.SHA256, 32, 1));
                                case 258:
                                    return android.util.Pair.create("SHA512withRSA/PSS", new java.security.spec.PSSParameterSpec("SHA-512", "MGF1", java.security.spec.MGF1ParameterSpec.SHA512, 64, 1));
                                case 259:
                                    break;
                                case 260:
                                    return android.util.Pair.create("SHA512withRSA", null);
                                default:
                                    throw new java.lang.IllegalArgumentException("Unknown signature algorithm: 0x" + java.lang.Long.toHexString(i & (-1)));
                            }
                        }
                    }
                }
                return android.util.Pair.create("SHA256withRSA", null);
            }
            return android.util.Pair.create("SHA256withDSA", null);
        }
        return android.util.Pair.create("SHA256withECDSA", null);
    }

    private static int e(int i) {
        if (i == 1) {
            return 32;
        }
        if (i == 2) {
            return 64;
        }
        if (i == 3) {
            return 32;
        }
        throw new java.lang.IllegalArgumentException("Unknown content digest algorthm: ".concat(java.lang.String.valueOf(i)));
    }
}
