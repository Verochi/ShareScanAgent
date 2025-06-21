package com.meizu.cloud.pushsdk.c.g;

/* loaded from: classes23.dex */
public final class b implements com.meizu.cloud.pushsdk.c.g.c, com.meizu.cloud.pushsdk.c.g.d, java.lang.Cloneable {
    private static final byte[] c = {org.apache.tools.tar.TarConstants.LF_NORMAL, org.apache.tools.tar.TarConstants.LF_LINK, org.apache.tools.tar.TarConstants.LF_SYMLINK, org.apache.tools.tar.TarConstants.LF_CHR, org.apache.tools.tar.TarConstants.LF_BLK, org.apache.tools.tar.TarConstants.LF_DIR, org.apache.tools.tar.TarConstants.LF_FIFO, org.apache.tools.tar.TarConstants.LF_CONTIG, 56, 57, 97, 98, 99, 100, 101, 102};
    com.meizu.cloud.pushsdk.c.g.j a;
    long b;

    /* renamed from: com.meizu.cloud.pushsdk.c.g.b$1, reason: invalid class name */
    public class AnonymousClass1 extends java.io.InputStream {
        public AnonymousClass1() {
        }

        @Override // java.io.InputStream
        public int available() {
            return (int) java.lang.Math.min(com.meizu.cloud.pushsdk.c.g.b.this.b, 2147483647L);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.InputStream
        public int read() {
            com.meizu.cloud.pushsdk.c.g.b bVar = com.meizu.cloud.pushsdk.c.g.b.this;
            if (bVar.b > 0) {
                return bVar.f() & 255;
            }
            return -1;
        }

        @Override // java.io.InputStream
        public int read(@androidx.annotation.NonNull byte[] bArr, int i, int i2) {
            return com.meizu.cloud.pushsdk.c.g.b.this.a(bArr, i, i2);
        }

        public java.lang.String toString() {
            return com.meizu.cloud.pushsdk.c.g.b.this + ".inputStream()";
        }
    }

    public int a(byte[] bArr, int i, int i2) {
        com.meizu.cloud.pushsdk.c.g.o.a(bArr.length, i, i2);
        com.meizu.cloud.pushsdk.c.g.j jVar = this.a;
        if (jVar == null) {
            return -1;
        }
        int min = java.lang.Math.min(i2, jVar.c - jVar.b);
        java.lang.System.arraycopy(jVar.a, jVar.b, bArr, i, min);
        int i3 = jVar.b + min;
        jVar.b = i3;
        this.b -= min;
        if (i3 == jVar.c) {
            this.a = jVar.a();
            com.meizu.cloud.pushsdk.c.g.k.a(jVar);
        }
        return min;
    }

    public long a() {
        return this.b;
    }

    @Override // com.meizu.cloud.pushsdk.c.g.c
    public long a(com.meizu.cloud.pushsdk.c.g.m mVar) throws java.io.IOException {
        if (mVar == null) {
            throw new java.lang.IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long b = mVar.b(this, 2048L);
            if (b == -1) {
                return j;
            }
            j += b;
        }
    }

    public com.meizu.cloud.pushsdk.c.g.b a(int i) {
        int i2;
        int i3;
        if (i >= 128) {
            if (i < 2048) {
                i3 = (i >> 6) | 192;
            } else {
                if (i < 65536) {
                    if (i >= 55296 && i <= 57343) {
                        throw new java.lang.IllegalArgumentException("Unexpected code point: " + java.lang.Integer.toHexString(i));
                    }
                    i2 = (i >> 12) | 224;
                } else {
                    if (i > 1114111) {
                        throw new java.lang.IllegalArgumentException("Unexpected code point: " + java.lang.Integer.toHexString(i));
                    }
                    b((i >> 18) | 240);
                    i2 = ((i >> 12) & 63) | 128;
                }
                b(i2);
                i3 = ((i >> 6) & 63) | 128;
            }
            b(i3);
            i = (i & 63) | 128;
        }
        b(i);
        return this;
    }

    @Override // com.meizu.cloud.pushsdk.c.g.c
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public com.meizu.cloud.pushsdk.c.g.b b(com.meizu.cloud.pushsdk.c.g.e eVar) {
        if (eVar == null) {
            throw new java.lang.IllegalArgumentException("byteString == null");
        }
        eVar.a(this);
        return this;
    }

    @Override // com.meizu.cloud.pushsdk.c.g.c
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public com.meizu.cloud.pushsdk.c.g.b b(java.lang.String str) {
        return a(str, 0, str.length());
    }

    public com.meizu.cloud.pushsdk.c.g.b a(java.lang.String str, int i, int i2) {
        int i3;
        if (str == null) {
            throw new java.lang.IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new java.lang.IllegalAccessError("beginIndex < 0: " + i);
        }
        if (i2 < i) {
            throw new java.lang.IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        }
        if (i2 > str.length()) {
            throw new java.lang.IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        }
        while (i < i2) {
            char charAt = str.charAt(i);
            if (charAt < 128) {
                com.meizu.cloud.pushsdk.c.g.j c2 = c(1);
                byte[] bArr = c2.a;
                int i4 = c2.c - i;
                int min = java.lang.Math.min(i2, 2048 - i4);
                int i5 = i + 1;
                bArr[i + i4] = (byte) charAt;
                while (i5 < min) {
                    char charAt2 = str.charAt(i5);
                    if (charAt2 >= 128) {
                        break;
                    }
                    bArr[i5 + i4] = (byte) charAt2;
                    i5++;
                }
                int i6 = c2.c;
                int i7 = (i4 + i5) - i6;
                c2.c = i6 + i7;
                this.b += i7;
                i = i5;
            } else {
                if (charAt < 2048) {
                    i3 = (charAt >> 6) | 192;
                } else if (charAt < 55296 || charAt > 57343) {
                    b((charAt >> '\f') | 224);
                    i3 = ((charAt >> 6) & 63) | 128;
                } else {
                    int i8 = i + 1;
                    char charAt3 = i8 < i2 ? str.charAt(i8) : (char) 0;
                    if (charAt > 56319 || charAt3 < 56320 || charAt3 > 57343) {
                        b(63);
                        i = i8;
                    } else {
                        int i9 = (((charAt & 10239) << 10) | (9215 & charAt3)) + 65536;
                        b((i9 >> 18) | 240);
                        b(((i9 >> 12) & 63) | 128);
                        b(((i9 >> 6) & 63) | 128);
                        b((i9 & 63) | 128);
                        i += 2;
                    }
                }
                b(i3);
                b((charAt & '?') | 128);
                i++;
            }
        }
        return this;
    }

    public java.lang.String a(long j, java.nio.charset.Charset charset) throws java.io.EOFException {
        com.meizu.cloud.pushsdk.c.g.o.a(this.b, 0L, j);
        if (charset == null) {
            throw new java.lang.IllegalArgumentException("charset == null");
        }
        if (j > 2147483647L) {
            throw new java.lang.IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        if (j == 0) {
            return "";
        }
        com.meizu.cloud.pushsdk.c.g.j jVar = this.a;
        int i = jVar.b;
        if (i + j > jVar.c) {
            return new java.lang.String(a(j), charset);
        }
        java.lang.String str = new java.lang.String(jVar.a, i, (int) j, charset);
        int i2 = (int) (jVar.b + j);
        jVar.b = i2;
        this.b -= j;
        if (i2 == jVar.c) {
            this.a = jVar.a();
            com.meizu.cloud.pushsdk.c.g.k.a(jVar);
        }
        return str;
    }

    @Override // com.meizu.cloud.pushsdk.c.g.l
    public void a(com.meizu.cloud.pushsdk.c.g.b bVar, long j) {
        if (bVar == null) {
            throw new java.lang.IllegalArgumentException("source == null");
        }
        if (bVar == this) {
            throw new java.lang.IllegalArgumentException("source == this");
        }
        com.meizu.cloud.pushsdk.c.g.o.a(bVar.b, 0L, j);
        while (j > 0) {
            com.meizu.cloud.pushsdk.c.g.j jVar = bVar.a;
            if (j < jVar.c - jVar.b) {
                com.meizu.cloud.pushsdk.c.g.j jVar2 = this.a;
                com.meizu.cloud.pushsdk.c.g.j jVar3 = jVar2 != null ? jVar2.g : null;
                if (jVar3 != null && jVar3.e) {
                    if ((jVar3.c + j) - (jVar3.d ? 0 : jVar3.b) <= 2048) {
                        jVar.a(jVar3, (int) j);
                        bVar.b -= j;
                        this.b += j;
                        return;
                    }
                }
                bVar.a = jVar.a((int) j);
            }
            com.meizu.cloud.pushsdk.c.g.j jVar4 = bVar.a;
            long j2 = jVar4.c - jVar4.b;
            bVar.a = jVar4.a();
            com.meizu.cloud.pushsdk.c.g.j jVar5 = this.a;
            if (jVar5 == null) {
                this.a = jVar4;
                jVar4.g = jVar4;
                jVar4.f = jVar4;
            } else {
                jVar5.g.a(jVar4).b();
            }
            bVar.b -= j2;
            this.b += j2;
            j -= j2;
        }
    }

    public void a(byte[] bArr) throws java.io.EOFException {
        int i = 0;
        while (i < bArr.length) {
            int a = a(bArr, i, bArr.length - i);
            if (a == -1) {
                throw new java.io.EOFException();
            }
            i += a;
        }
    }

    public byte[] a(long j) throws java.io.EOFException {
        com.meizu.cloud.pushsdk.c.g.o.a(this.b, 0L, j);
        if (j <= 2147483647L) {
            byte[] bArr = new byte[(int) j];
            a(bArr);
            return bArr;
        }
        throw new java.lang.IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
    }

    @Override // com.meizu.cloud.pushsdk.c.g.m
    public long b(com.meizu.cloud.pushsdk.c.g.b bVar, long j) {
        if (bVar == null) {
            throw new java.lang.IllegalArgumentException("sink == null");
        }
        if (j < 0) {
            throw new java.lang.IllegalArgumentException("byteCount < 0: " + j);
        }
        long j2 = this.b;
        if (j2 == 0) {
            return -1L;
        }
        if (j > j2) {
            j = j2;
        }
        bVar.a(this, j);
        return j;
    }

    @Override // com.meizu.cloud.pushsdk.c.g.c
    public com.meizu.cloud.pushsdk.c.g.b b() {
        return this;
    }

    public com.meizu.cloud.pushsdk.c.g.b b(int i) {
        com.meizu.cloud.pushsdk.c.g.j c2 = c(1);
        byte[] bArr = c2.a;
        int i2 = c2.c;
        c2.c = i2 + 1;
        bArr[i2] = (byte) i;
        this.b++;
        return this;
    }

    @Override // com.meizu.cloud.pushsdk.c.g.c
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public com.meizu.cloud.pushsdk.c.g.b c(byte[] bArr) {
        if (bArr != null) {
            return c(bArr, 0, bArr.length);
        }
        throw new java.lang.IllegalArgumentException("source == null");
    }

    @Override // com.meizu.cloud.pushsdk.c.g.c
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public com.meizu.cloud.pushsdk.c.g.b c(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new java.lang.IllegalArgumentException("source == null");
        }
        long j = i2;
        com.meizu.cloud.pushsdk.c.g.o.a(bArr.length, i, j);
        int i3 = i2 + i;
        while (i < i3) {
            com.meizu.cloud.pushsdk.c.g.j c2 = c(1);
            int min = java.lang.Math.min(i3 - i, 2048 - c2.c);
            java.lang.System.arraycopy(bArr, i, c2.a, c2.c, min);
            i += min;
            c2.c += min;
        }
        this.b += j;
        return this;
    }

    public void b(long j) throws java.io.EOFException {
        while (j > 0) {
            if (this.a == null) {
                throw new java.io.EOFException();
            }
            int min = (int) java.lang.Math.min(j, r0.c - r0.b);
            long j2 = min;
            this.b -= j2;
            j -= j2;
            com.meizu.cloud.pushsdk.c.g.j jVar = this.a;
            int i = jVar.b + min;
            jVar.b = i;
            if (i == jVar.c) {
                this.a = jVar.a();
                com.meizu.cloud.pushsdk.c.g.k.a(jVar);
            }
        }
    }

    @Override // com.meizu.cloud.pushsdk.c.g.c
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public com.meizu.cloud.pushsdk.c.g.b e(long j) {
        boolean z;
        if (j == 0) {
            return b(48);
        }
        int i = 1;
        if (j < 0) {
            j = -j;
            if (j < 0) {
                return b("-9223372036854775808");
            }
            z = true;
        } else {
            z = false;
        }
        if (j >= 100000000) {
            i = j < 1000000000000L ? j < 10000000000L ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= 10000) {
            i = j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
        } else if (j >= 100) {
            i = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i = 2;
        }
        if (z) {
            i++;
        }
        com.meizu.cloud.pushsdk.c.g.j c2 = c(i);
        byte[] bArr = c2.a;
        int i2 = c2.c + i;
        while (j != 0) {
            i2--;
            bArr[i2] = c[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i2 - 1] = 45;
        }
        c2.c += i;
        this.b += i;
        return this;
    }

    public com.meizu.cloud.pushsdk.c.g.j c(int i) {
        if (i < 1 || i > 2048) {
            throw new java.lang.IllegalArgumentException();
        }
        com.meizu.cloud.pushsdk.c.g.j jVar = this.a;
        if (jVar != null) {
            com.meizu.cloud.pushsdk.c.g.j jVar2 = jVar.g;
            return (jVar2.c + i > 2048 || !jVar2.e) ? jVar2.a(com.meizu.cloud.pushsdk.c.g.k.a()) : jVar2;
        }
        com.meizu.cloud.pushsdk.c.g.j a = com.meizu.cloud.pushsdk.c.g.k.a();
        this.a = a;
        a.g = a;
        a.f = a;
        return a;
    }

    public boolean c() {
        return this.b == 0;
    }

    @Override // com.meizu.cloud.pushsdk.c.g.l, java.io.Closeable, java.lang.AutoCloseable, com.meizu.cloud.pushsdk.c.g.m
    public void close() {
    }

    public com.meizu.cloud.pushsdk.c.g.b d(long j) {
        if (j == 0) {
            return b(48);
        }
        int numberOfTrailingZeros = (java.lang.Long.numberOfTrailingZeros(java.lang.Long.highestOneBit(j)) / 4) + 1;
        com.meizu.cloud.pushsdk.c.g.j c2 = c(numberOfTrailingZeros);
        byte[] bArr = c2.a;
        int i = c2.c;
        for (int i2 = (i + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = c[(int) (15 & j)];
            j >>>= 4;
        }
        c2.c += numberOfTrailingZeros;
        this.b += numberOfTrailingZeros;
        return this;
    }

    @Override // com.meizu.cloud.pushsdk.c.g.d
    public java.io.InputStream d() {
        return new com.meizu.cloud.pushsdk.c.g.b.AnonymousClass1();
    }

    public long e() {
        long j = this.b;
        if (j == 0) {
            return 0L;
        }
        com.meizu.cloud.pushsdk.c.g.j jVar = this.a.g;
        return (jVar.c >= 2048 || !jVar.e) ? j : j - (r3 - jVar.b);
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof com.meizu.cloud.pushsdk.c.g.b)) {
            return false;
        }
        com.meizu.cloud.pushsdk.c.g.b bVar = (com.meizu.cloud.pushsdk.c.g.b) obj;
        long j = this.b;
        if (j != bVar.b) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        com.meizu.cloud.pushsdk.c.g.j jVar = this.a;
        com.meizu.cloud.pushsdk.c.g.j jVar2 = bVar.a;
        int i = jVar.b;
        int i2 = jVar2.b;
        while (j2 < this.b) {
            long min = java.lang.Math.min(jVar.c - i, jVar2.c - i2);
            int i3 = 0;
            while (i3 < min) {
                int i4 = i + 1;
                int i5 = i2 + 1;
                if (jVar.a[i] != jVar2.a[i2]) {
                    return false;
                }
                i3++;
                i = i4;
                i2 = i5;
            }
            if (i == jVar.c) {
                jVar = jVar.f;
                i = jVar.b;
            }
            if (i2 == jVar2.c) {
                jVar2 = jVar2.f;
                i2 = jVar2.b;
            }
            j2 += min;
        }
        return true;
    }

    public byte f() {
        long j = this.b;
        if (j == 0) {
            throw new java.lang.IllegalStateException("size == 0");
        }
        com.meizu.cloud.pushsdk.c.g.j jVar = this.a;
        int i = jVar.b;
        int i2 = jVar.c;
        int i3 = i + 1;
        byte b = jVar.a[i];
        this.b = j - 1;
        if (i3 == i2) {
            this.a = jVar.a();
            com.meizu.cloud.pushsdk.c.g.k.a(jVar);
        } else {
            jVar.b = i3;
        }
        return b;
    }

    @Override // com.meizu.cloud.pushsdk.c.g.l, java.io.Flushable
    public void flush() {
    }

    public com.meizu.cloud.pushsdk.c.g.e g() {
        return new com.meizu.cloud.pushsdk.c.g.e(i());
    }

    @Override // com.meizu.cloud.pushsdk.c.g.d
    public java.lang.String h() {
        try {
            return a(this.b, com.meizu.cloud.pushsdk.c.g.o.a);
        } catch (java.io.EOFException e) {
            throw new java.lang.AssertionError(e);
        }
    }

    public int hashCode() {
        com.meizu.cloud.pushsdk.c.g.j jVar = this.a;
        if (jVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = jVar.c;
            for (int i3 = jVar.b; i3 < i2; i3++) {
                i = (i * 31) + jVar.a[i3];
            }
            jVar = jVar.f;
        } while (jVar != this.a);
        return i;
    }

    @Override // com.meizu.cloud.pushsdk.c.g.d
    public byte[] i() {
        try {
            return a(this.b);
        } catch (java.io.EOFException e) {
            throw new java.lang.AssertionError(e);
        }
    }

    public void j() {
        try {
            b(this.b);
        } catch (java.io.EOFException e) {
            throw new java.lang.AssertionError(e);
        }
    }

    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public com.meizu.cloud.pushsdk.c.g.b clone() {
        com.meizu.cloud.pushsdk.c.g.b bVar = new com.meizu.cloud.pushsdk.c.g.b();
        if (this.b == 0) {
            return bVar;
        }
        com.meizu.cloud.pushsdk.c.g.j jVar = new com.meizu.cloud.pushsdk.c.g.j(this.a);
        bVar.a = jVar;
        jVar.g = jVar;
        jVar.f = jVar;
        com.meizu.cloud.pushsdk.c.g.j jVar2 = this.a;
        while (true) {
            jVar2 = jVar2.f;
            if (jVar2 == this.a) {
                bVar.b = this.b;
                return bVar;
            }
            bVar.a.g.a(new com.meizu.cloud.pushsdk.c.g.j(jVar2));
        }
    }

    public java.lang.String toString() {
        long j = this.b;
        if (j == 0) {
            return "Buffer[size=0]";
        }
        if (j <= 16) {
            return java.lang.String.format("Buffer[size=%s data=%s]", java.lang.Long.valueOf(this.b), clone().g().c());
        }
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
            com.meizu.cloud.pushsdk.c.g.j jVar = this.a;
            byte[] bArr = jVar.a;
            int i = jVar.b;
            messageDigest.update(bArr, i, jVar.c - i);
            com.meizu.cloud.pushsdk.c.g.j jVar2 = this.a;
            while (true) {
                jVar2 = jVar2.f;
                if (jVar2 == this.a) {
                    return java.lang.String.format("Buffer[size=%s md5=%s]", java.lang.Long.valueOf(this.b), com.meizu.cloud.pushsdk.c.g.e.a(messageDigest.digest()).c());
                }
                byte[] bArr2 = jVar2.a;
                int i2 = jVar2.b;
                messageDigest.update(bArr2, i2, jVar2.c - i2);
            }
        } catch (java.security.NoSuchAlgorithmException unused) {
            throw new java.lang.AssertionError();
        }
    }
}
