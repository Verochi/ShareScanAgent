package com.jd.ad.sdk.jad_hk;

/* loaded from: classes23.dex */
public final class jad_an implements com.jd.ad.sdk.jad_hk.jad_bo, java.io.Closeable, java.io.Flushable, java.nio.channels.WritableByteChannel, java.lang.Cloneable, java.nio.channels.ByteChannel {

    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_hk.jad_jw jad_an;
    public long jad_bo;

    public java.lang.Object clone() {
        com.jd.ad.sdk.jad_hk.jad_an jad_anVar = new com.jd.ad.sdk.jad_hk.jad_an();
        if (this.jad_bo != 0) {
            com.jd.ad.sdk.jad_hk.jad_jw jad_bo = this.jad_an.jad_bo();
            jad_anVar.jad_an = jad_bo;
            jad_bo.jad_jt = jad_bo;
            jad_bo.jad_fs = jad_bo;
            com.jd.ad.sdk.jad_hk.jad_jw jad_jwVar = this.jad_an;
            while (true) {
                jad_jwVar = jad_jwVar.jad_fs;
                if (jad_jwVar == this.jad_an) {
                    break;
                }
                jad_anVar.jad_an.jad_jt.jad_an(jad_jwVar.jad_bo());
            }
            jad_anVar.jad_bo = this.jad_bo;
        }
        return jad_anVar;
    }

    @Override // com.jd.ad.sdk.jad_hk.jad_mz, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() {
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof com.jd.ad.sdk.jad_hk.jad_an)) {
            return false;
        }
        com.jd.ad.sdk.jad_hk.jad_an jad_anVar = (com.jd.ad.sdk.jad_hk.jad_an) obj;
        long j = this.jad_bo;
        if (j != jad_anVar.jad_bo) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        com.jd.ad.sdk.jad_hk.jad_jw jad_jwVar = this.jad_an;
        com.jd.ad.sdk.jad_hk.jad_jw jad_jwVar2 = jad_anVar.jad_an;
        int i = jad_jwVar.jad_bo;
        int i2 = jad_jwVar2.jad_bo;
        while (j2 < this.jad_bo) {
            long min = java.lang.Math.min(jad_jwVar.jad_cp - i, jad_jwVar2.jad_cp - i2);
            int i3 = 0;
            while (i3 < min) {
                int i4 = i + 1;
                int i5 = i2 + 1;
                if (jad_jwVar.jad_an[i] != jad_jwVar2.jad_an[i2]) {
                    return false;
                }
                i3++;
                i = i4;
                i2 = i5;
            }
            if (i == jad_jwVar.jad_cp) {
                jad_jwVar = jad_jwVar.jad_fs;
                i = jad_jwVar.jad_bo;
            }
            if (i2 == jad_jwVar2.jad_cp) {
                jad_jwVar2 = jad_jwVar2.jad_fs;
                i2 = jad_jwVar2.jad_bo;
            }
            j2 += min;
        }
        return true;
    }

    @Override // java.io.Flushable
    public void flush() {
    }

    public int hashCode() {
        com.jd.ad.sdk.jad_hk.jad_jw jad_jwVar = this.jad_an;
        if (jad_jwVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = jad_jwVar.jad_cp;
            for (int i3 = jad_jwVar.jad_bo; i3 < i2; i3++) {
                i = (i * 31) + jad_jwVar.jad_an[i3];
            }
            jad_jwVar = jad_jwVar.jad_fs;
        } while (jad_jwVar != this.jad_an);
        return i;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    @Override // com.jd.ad.sdk.jad_hk.jad_bo
    public int jad_an(com.jd.ad.sdk.jad_hk.jad_fs jad_fsVar) {
        int jad_an = jad_an(jad_fsVar, false);
        if (jad_an == -1) {
            return -1;
        }
        try {
            jad_dq(jad_fsVar.jad_an[jad_an].jad_cp());
            return jad_an;
        } catch (java.io.EOFException unused) {
            throw new java.lang.AssertionError();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0055, code lost:
    
        if (r19 == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0057, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0058, code lost:
    
        return r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int jad_an(com.jd.ad.sdk.jad_hk.jad_fs jad_fsVar, boolean z) {
        int i;
        int i2;
        int i3;
        int i4;
        com.jd.ad.sdk.jad_hk.jad_jw jad_jwVar;
        com.jd.ad.sdk.jad_hk.jad_jw jad_jwVar2 = this.jad_an;
        int i5 = -2;
        if (jad_jwVar2 != null) {
            byte[] bArr = jad_jwVar2.jad_an;
            int i6 = jad_jwVar2.jad_bo;
            int i7 = jad_jwVar2.jad_cp;
            int[] iArr = jad_fsVar.jad_bo;
            com.jd.ad.sdk.jad_hk.jad_jw jad_jwVar3 = jad_jwVar2;
            int i8 = 0;
            int i9 = -1;
            loop0: while (true) {
                int i10 = i8 + 1;
                int i11 = iArr[i8];
                int i12 = i10 + 1;
                int i13 = iArr[i10];
                if (i13 != -1) {
                    i9 = i13;
                }
                if (jad_jwVar3 == null) {
                    break;
                }
                if (i11 >= 0) {
                    int i14 = i6 + 1;
                    int i15 = bArr[i6] & 255;
                    int i16 = i12 + i11;
                    while (i12 != i16) {
                        if (i15 == iArr[i12]) {
                            i = iArr[i12 + i11];
                            if (i14 == i7) {
                                jad_jwVar3 = jad_jwVar3.jad_fs;
                                i2 = jad_jwVar3.jad_bo;
                                bArr = jad_jwVar3.jad_an;
                                i7 = jad_jwVar3.jad_cp;
                                if (jad_jwVar3 == jad_jwVar2) {
                                    jad_jwVar3 = null;
                                }
                            } else {
                                i2 = i14;
                            }
                        } else {
                            i12++;
                        }
                    }
                    return i9;
                }
                int i17 = (i11 * (-1)) + i12;
                while (true) {
                    int i18 = i6 + 1;
                    int i19 = i12 + 1;
                    if ((bArr[i6] & 255) != iArr[i12]) {
                        return i9;
                    }
                    boolean z2 = i19 == i17;
                    if (i18 == i7) {
                        com.jd.ad.sdk.jad_hk.jad_jw jad_jwVar4 = jad_jwVar3.jad_fs;
                        i4 = jad_jwVar4.jad_bo;
                        byte[] bArr2 = jad_jwVar4.jad_an;
                        i3 = jad_jwVar4.jad_cp;
                        if (jad_jwVar4 != jad_jwVar2) {
                            jad_jwVar = jad_jwVar4;
                            bArr = bArr2;
                        } else {
                            if (!z2) {
                                break loop0;
                            }
                            bArr = bArr2;
                            jad_jwVar = null;
                        }
                    } else {
                        com.jd.ad.sdk.jad_hk.jad_jw jad_jwVar5 = jad_jwVar3;
                        i3 = i7;
                        i4 = i18;
                        jad_jwVar = jad_jwVar5;
                    }
                    if (z2) {
                        i = iArr[i19];
                        i2 = i4;
                        i7 = i3;
                        jad_jwVar3 = jad_jwVar;
                        break;
                    }
                    i6 = i4;
                    i7 = i3;
                    i12 = i19;
                    jad_jwVar3 = jad_jwVar;
                }
                if (i >= 0) {
                    return i;
                }
                i8 = -i;
                i6 = i2;
                i5 = -2;
            }
        } else {
            if (z) {
                return -2;
            }
            return jad_fsVar.indexOf(com.jd.ad.sdk.jad_hk.jad_cp.jad_er);
        }
    }

    public int jad_an(byte[] bArr, int i, int i2) {
        com.jd.ad.sdk.jad_hk.jad_ob.jad_an(bArr.length, i, i2);
        com.jd.ad.sdk.jad_hk.jad_jw jad_jwVar = this.jad_an;
        if (jad_jwVar == null) {
            return -1;
        }
        int min = java.lang.Math.min(i2, jad_jwVar.jad_cp - jad_jwVar.jad_bo);
        java.lang.System.arraycopy(jad_jwVar.jad_an, jad_jwVar.jad_bo, bArr, i, min);
        int i3 = jad_jwVar.jad_bo + min;
        jad_jwVar.jad_bo = i3;
        this.jad_bo -= min;
        if (i3 == jad_jwVar.jad_cp) {
            this.jad_an = jad_jwVar.jad_an();
            com.jd.ad.sdk.jad_hk.jad_kx.jad_an(jad_jwVar);
        }
        return min;
    }

    @Override // com.jd.ad.sdk.jad_hk.jad_mz
    public long jad_an(com.jd.ad.sdk.jad_hk.jad_an jad_anVar, long j) {
        if (jad_anVar == null) {
            throw new java.lang.IllegalArgumentException("sink == null");
        }
        if (j < 0) {
            throw new java.lang.IllegalArgumentException("byteCount < 0: " + j);
        }
        long j2 = this.jad_bo;
        if (j2 == 0) {
            return -1L;
        }
        if (j > j2) {
            j = j2;
        }
        jad_anVar.jad_bo(this, j);
        return j;
    }

    @Override // com.jd.ad.sdk.jad_hk.jad_bo
    public long jad_an(com.jd.ad.sdk.jad_hk.jad_cp jad_cpVar) {
        return jad_an(jad_cpVar, 0L);
    }

    public long jad_an(com.jd.ad.sdk.jad_hk.jad_cp jad_cpVar, long j) {
        int i;
        long j2 = 0;
        if (j < 0) {
            throw new java.lang.IllegalArgumentException("fromIndex < 0");
        }
        com.jd.ad.sdk.jad_hk.jad_jw jad_jwVar = this.jad_an;
        if (jad_jwVar == null) {
            return -1L;
        }
        long j3 = this.jad_bo;
        if (j3 - j < j) {
            while (j3 > j) {
                jad_jwVar = jad_jwVar.jad_jt;
                j3 -= jad_jwVar.jad_cp - jad_jwVar.jad_bo;
            }
        } else {
            while (true) {
                long j4 = (jad_jwVar.jad_cp - jad_jwVar.jad_bo) + j2;
                if (j4 >= j) {
                    break;
                }
                jad_jwVar = jad_jwVar.jad_fs;
                j2 = j4;
            }
            j3 = j2;
        }
        if (jad_cpVar.jad_cp() == 2) {
            byte jad_an = jad_cpVar.jad_an(0);
            byte jad_an2 = jad_cpVar.jad_an(1);
            while (j3 < this.jad_bo) {
                byte[] bArr = jad_jwVar.jad_an;
                i = (int) ((jad_jwVar.jad_bo + j) - j3);
                int i2 = jad_jwVar.jad_cp;
                while (i < i2) {
                    byte b = bArr[i];
                    if (b != jad_an && b != jad_an2) {
                        i++;
                    }
                    return (i - jad_jwVar.jad_bo) + j3;
                }
                j3 += jad_jwVar.jad_cp - jad_jwVar.jad_bo;
                jad_jwVar = jad_jwVar.jad_fs;
                j = j3;
            }
            return -1L;
        }
        byte[] jad_bo = jad_cpVar.jad_bo();
        while (j3 < this.jad_bo) {
            byte[] bArr2 = jad_jwVar.jad_an;
            i = (int) ((jad_jwVar.jad_bo + j) - j3);
            int i3 = jad_jwVar.jad_cp;
            while (i < i3) {
                byte b2 = bArr2[i];
                for (byte b3 : jad_bo) {
                    if (b2 == b3) {
                        return (i - jad_jwVar.jad_bo) + j3;
                    }
                }
                i++;
            }
            j3 += jad_jwVar.jad_cp - jad_jwVar.jad_bo;
            jad_jwVar = jad_jwVar.jad_fs;
            j = j3;
        }
        return -1L;
    }

    @Override // com.jd.ad.sdk.jad_hk.jad_bo
    public com.jd.ad.sdk.jad_hk.jad_an jad_an() {
        return this;
    }

    public com.jd.ad.sdk.jad_hk.jad_an jad_an(java.lang.String str, int i, int i2) {
        char charAt;
        int i3;
        if (str == null) {
            throw new java.lang.IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new java.lang.IllegalArgumentException("beginIndex < 0: " + i);
        }
        if (i2 < i) {
            throw new java.lang.IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        }
        if (i2 > str.length()) {
            throw new java.lang.IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        }
        while (i < i2) {
            char charAt2 = str.charAt(i);
            if (charAt2 < 128) {
                com.jd.ad.sdk.jad_hk.jad_jw jad_an = jad_an(1);
                byte[] bArr = jad_an.jad_an;
                int i4 = jad_an.jad_cp - i;
                int min = java.lang.Math.min(i2, 8192 - i4);
                int i5 = i + 1;
                bArr[i + i4] = (byte) charAt2;
                while (true) {
                    i = i5;
                    if (i >= min || (charAt = str.charAt(i)) >= 128) {
                        break;
                    }
                    i5 = i + 1;
                    bArr[i + i4] = (byte) charAt;
                }
                int i6 = jad_an.jad_cp;
                int i7 = (i4 + i) - i6;
                jad_an.jad_cp = i6 + i7;
                this.jad_bo += i7;
            } else {
                if (charAt2 < 2048) {
                    i3 = (charAt2 >> 6) | 192;
                } else if (charAt2 < 55296 || charAt2 > 57343) {
                    jad_bo((charAt2 >> '\f') | 224);
                    i3 = ((charAt2 >> 6) & 63) | 128;
                } else {
                    int i8 = i + 1;
                    char charAt3 = i8 < i2 ? str.charAt(i8) : (char) 0;
                    if (charAt2 > 56319 || charAt3 < 56320 || charAt3 > 57343) {
                        jad_bo(63);
                        i = i8;
                    } else {
                        int i9 = (((charAt2 & 10239) << 10) | (9215 & charAt3)) + 65536;
                        jad_bo((i9 >> 18) | 240);
                        jad_bo(((i9 >> 12) & 63) | 128);
                        jad_bo(((i9 >> 6) & 63) | 128);
                        jad_bo((i9 & 63) | 128);
                        i += 2;
                    }
                }
                jad_bo(i3);
                jad_bo((charAt2 & '?') | 128);
                i++;
            }
        }
        return this;
    }

    public com.jd.ad.sdk.jad_hk.jad_jw jad_an(int i) {
        if (i < 1 || i > 8192) {
            throw new java.lang.IllegalArgumentException();
        }
        com.jd.ad.sdk.jad_hk.jad_jw jad_jwVar = this.jad_an;
        if (jad_jwVar != null) {
            com.jd.ad.sdk.jad_hk.jad_jw jad_jwVar2 = jad_jwVar.jad_jt;
            return (jad_jwVar2.jad_cp + i > 8192 || !jad_jwVar2.jad_er) ? jad_jwVar2.jad_an(com.jd.ad.sdk.jad_hk.jad_kx.jad_an()) : jad_jwVar2;
        }
        com.jd.ad.sdk.jad_hk.jad_jw jad_an = com.jd.ad.sdk.jad_hk.jad_kx.jad_an();
        this.jad_an = jad_an;
        jad_an.jad_jt = jad_an;
        jad_an.jad_fs = jad_an;
        return jad_an;
    }

    public java.lang.String jad_an(long j, java.nio.charset.Charset charset) {
        com.jd.ad.sdk.jad_hk.jad_ob.jad_an(this.jad_bo, 0L, j);
        if (charset == null) {
            throw new java.lang.IllegalArgumentException("charset == null");
        }
        if (j > 2147483647L) {
            throw new java.lang.IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        if (j == 0) {
            return "";
        }
        com.jd.ad.sdk.jad_hk.jad_jw jad_jwVar = this.jad_an;
        int i = jad_jwVar.jad_bo;
        if (i + j > jad_jwVar.jad_cp) {
            return new java.lang.String(jad_cp(j), charset);
        }
        java.lang.String str = new java.lang.String(jad_jwVar.jad_an, i, (int) j, charset);
        int i2 = (int) (jad_jwVar.jad_bo + j);
        jad_jwVar.jad_bo = i2;
        this.jad_bo -= j;
        if (i2 == jad_jwVar.jad_cp) {
            this.jad_an = jad_jwVar.jad_an();
            com.jd.ad.sdk.jad_hk.jad_kx.jad_an(jad_jwVar);
        }
        return str;
    }

    @Override // com.jd.ad.sdk.jad_hk.jad_bo
    public boolean jad_an(long j) {
        return this.jad_bo >= j;
    }

    public byte jad_bo() {
        long j = this.jad_bo;
        if (j == 0) {
            throw new java.lang.IllegalStateException("size == 0");
        }
        com.jd.ad.sdk.jad_hk.jad_jw jad_jwVar = this.jad_an;
        int i = jad_jwVar.jad_bo;
        int i2 = jad_jwVar.jad_cp;
        int i3 = i + 1;
        byte b = jad_jwVar.jad_an[i];
        this.jad_bo = j - 1;
        if (i3 == i2) {
            this.jad_an = jad_jwVar.jad_an();
            com.jd.ad.sdk.jad_hk.jad_kx.jad_an(jad_jwVar);
        } else {
            jad_jwVar.jad_bo = i3;
        }
        return b;
    }

    public final byte jad_bo(long j) {
        int i;
        com.jd.ad.sdk.jad_hk.jad_ob.jad_an(this.jad_bo, j, 1L);
        long j2 = this.jad_bo;
        if (j2 - j <= j) {
            long j3 = j - j2;
            com.jd.ad.sdk.jad_hk.jad_jw jad_jwVar = this.jad_an;
            do {
                jad_jwVar = jad_jwVar.jad_jt;
                int i2 = jad_jwVar.jad_cp;
                i = jad_jwVar.jad_bo;
                j3 += i2 - i;
            } while (j3 < 0);
            return jad_jwVar.jad_an[i + ((int) j3)];
        }
        com.jd.ad.sdk.jad_hk.jad_jw jad_jwVar2 = this.jad_an;
        while (true) {
            int i3 = jad_jwVar2.jad_cp;
            int i4 = jad_jwVar2.jad_bo;
            long j4 = i3 - i4;
            if (j < j4) {
                return jad_jwVar2.jad_an[i4 + ((int) j)];
            }
            j -= j4;
            jad_jwVar2 = jad_jwVar2.jad_fs;
        }
    }

    public com.jd.ad.sdk.jad_hk.jad_an jad_bo(int i) {
        com.jd.ad.sdk.jad_hk.jad_jw jad_an = jad_an(1);
        byte[] bArr = jad_an.jad_an;
        int i2 = jad_an.jad_cp;
        jad_an.jad_cp = i2 + 1;
        bArr[i2] = (byte) i;
        this.jad_bo++;
        return this;
    }

    public void jad_bo(com.jd.ad.sdk.jad_hk.jad_an jad_anVar, long j) {
        com.jd.ad.sdk.jad_hk.jad_jw jad_an;
        if (jad_anVar == this) {
            throw new java.lang.IllegalArgumentException("source == this");
        }
        com.jd.ad.sdk.jad_hk.jad_ob.jad_an(jad_anVar.jad_bo, 0L, j);
        while (j > 0) {
            com.jd.ad.sdk.jad_hk.jad_jw jad_jwVar = jad_anVar.jad_an;
            int i = jad_jwVar.jad_cp - jad_jwVar.jad_bo;
            if (j < i) {
                com.jd.ad.sdk.jad_hk.jad_jw jad_jwVar2 = this.jad_an;
                com.jd.ad.sdk.jad_hk.jad_jw jad_jwVar3 = jad_jwVar2 != null ? jad_jwVar2.jad_jt : null;
                if (jad_jwVar3 != null && jad_jwVar3.jad_er) {
                    if ((jad_jwVar3.jad_cp + j) - (jad_jwVar3.jad_dq ? 0 : jad_jwVar3.jad_bo) <= 8192) {
                        jad_jwVar.jad_an(jad_jwVar3, (int) j);
                        jad_anVar.jad_bo -= j;
                        this.jad_bo += j;
                        return;
                    }
                }
                int i2 = (int) j;
                if (i2 <= 0 || i2 > i) {
                    throw new java.lang.IllegalArgumentException();
                }
                if (i2 >= 1024) {
                    jad_an = jad_jwVar.jad_bo();
                } else {
                    jad_an = com.jd.ad.sdk.jad_hk.jad_kx.jad_an();
                    java.lang.System.arraycopy(jad_jwVar.jad_an, jad_jwVar.jad_bo, jad_an.jad_an, 0, i2);
                }
                jad_an.jad_cp = jad_an.jad_bo + i2;
                jad_jwVar.jad_bo += i2;
                jad_jwVar.jad_jt.jad_an(jad_an);
                jad_anVar.jad_an = jad_an;
            }
            com.jd.ad.sdk.jad_hk.jad_jw jad_jwVar4 = jad_anVar.jad_an;
            long j2 = jad_jwVar4.jad_cp - jad_jwVar4.jad_bo;
            jad_anVar.jad_an = jad_jwVar4.jad_an();
            com.jd.ad.sdk.jad_hk.jad_jw jad_jwVar5 = this.jad_an;
            if (jad_jwVar5 == null) {
                this.jad_an = jad_jwVar4;
                jad_jwVar4.jad_jt = jad_jwVar4;
                jad_jwVar4.jad_fs = jad_jwVar4;
            } else {
                com.jd.ad.sdk.jad_hk.jad_jw jad_an2 = jad_jwVar5.jad_jt.jad_an(jad_jwVar4);
                com.jd.ad.sdk.jad_hk.jad_jw jad_jwVar6 = jad_an2.jad_jt;
                if (jad_jwVar6 == jad_an2) {
                    throw new java.lang.IllegalStateException();
                }
                if (jad_jwVar6.jad_er) {
                    int i3 = jad_an2.jad_cp - jad_an2.jad_bo;
                    if (i3 <= (8192 - jad_jwVar6.jad_cp) + (jad_jwVar6.jad_dq ? 0 : jad_jwVar6.jad_bo)) {
                        jad_an2.jad_an(jad_jwVar6, i3);
                        jad_an2.jad_an();
                        com.jd.ad.sdk.jad_hk.jad_kx.jad_an(jad_an2);
                    }
                }
            }
            jad_anVar.jad_bo -= j2;
            this.jad_bo += j2;
            j -= j2;
        }
    }

    public com.jd.ad.sdk.jad_hk.jad_an jad_cp(int i) {
        com.jd.ad.sdk.jad_hk.jad_jw jad_an = jad_an(4);
        byte[] bArr = jad_an.jad_an;
        int i2 = jad_an.jad_cp;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        jad_an.jad_cp = i5 + 1;
        this.jad_bo += 4;
        return this;
    }

    public byte[] jad_cp(long j) {
        com.jd.ad.sdk.jad_hk.jad_ob.jad_an(this.jad_bo, 0L, j);
        if (j > 2147483647L) {
            throw new java.lang.IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        int i = (int) j;
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int jad_an = jad_an(bArr, i2, i - i2);
            if (jad_an == -1) {
                throw new java.io.EOFException();
            }
            i2 += jad_an;
        }
        return bArr;
    }

    public void jad_dq(long j) {
        while (j > 0) {
            if (this.jad_an == null) {
                throw new java.io.EOFException();
            }
            int min = (int) java.lang.Math.min(j, r0.jad_cp - r0.jad_bo);
            long j2 = min;
            this.jad_bo -= j2;
            j -= j2;
            com.jd.ad.sdk.jad_hk.jad_jw jad_jwVar = this.jad_an;
            int i = jad_jwVar.jad_bo + min;
            jad_jwVar.jad_bo = i;
            if (i == jad_jwVar.jad_cp) {
                this.jad_an = jad_jwVar.jad_an();
                com.jd.ad.sdk.jad_hk.jad_kx.jad_an(jad_jwVar);
            }
        }
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(java.nio.ByteBuffer byteBuffer) {
        com.jd.ad.sdk.jad_hk.jad_jw jad_jwVar = this.jad_an;
        if (jad_jwVar == null) {
            return -1;
        }
        int min = java.lang.Math.min(byteBuffer.remaining(), jad_jwVar.jad_cp - jad_jwVar.jad_bo);
        byteBuffer.put(jad_jwVar.jad_an, jad_jwVar.jad_bo, min);
        int i = jad_jwVar.jad_bo + min;
        jad_jwVar.jad_bo = i;
        this.jad_bo -= min;
        if (i == jad_jwVar.jad_cp) {
            this.jad_an = jad_jwVar.jad_an();
            com.jd.ad.sdk.jad_hk.jad_kx.jad_an(jad_jwVar);
        }
        return min;
    }

    public java.lang.String toString() {
        long j = this.jad_bo;
        if (j <= 2147483647L) {
            int i = (int) j;
            return (i == 0 ? com.jd.ad.sdk.jad_hk.jad_cp.jad_er : new com.jd.ad.sdk.jad_hk.jad_ly(this, i)).toString();
        }
        java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_hk.jad_pc.jad_an("size > Integer.MAX_VALUE: ");
        jad_an.append(this.jad_bo);
        throw new java.lang.IllegalArgumentException(jad_an.toString());
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(java.nio.ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            throw new java.lang.IllegalArgumentException("source == null");
        }
        int remaining = byteBuffer.remaining();
        int i = remaining;
        while (i > 0) {
            com.jd.ad.sdk.jad_hk.jad_jw jad_an = jad_an(1);
            int min = java.lang.Math.min(i, 8192 - jad_an.jad_cp);
            byteBuffer.get(jad_an.jad_an, jad_an.jad_cp, min);
            i -= min;
            jad_an.jad_cp += min;
        }
        this.jad_bo += remaining;
        return remaining;
    }
}
