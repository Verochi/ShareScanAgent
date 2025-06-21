package okhttp3.internal.publicsuffix;

/* loaded from: classes24.dex */
public final class PublicSuffixDatabase {
    public static final java.lang.String PUBLIC_SUFFIX_RESOURCE = "publicsuffixes.gz";
    public static final byte[] e = {42};
    public static final java.lang.String[] f = new java.lang.String[0];
    public static final java.lang.String[] g = {"*"};
    public static final okhttp3.internal.publicsuffix.PublicSuffixDatabase h = new okhttp3.internal.publicsuffix.PublicSuffixDatabase();
    public final java.util.concurrent.atomic.AtomicBoolean a = new java.util.concurrent.atomic.AtomicBoolean(false);
    public final java.util.concurrent.CountDownLatch b = new java.util.concurrent.CountDownLatch(1);
    public byte[] c;
    public byte[] d;

    public static java.lang.String a(byte[] bArr, byte[][] bArr2, int i) {
        int i2;
        boolean z;
        int i3;
        int i4;
        int length = bArr.length;
        int i5 = 0;
        while (i5 < length) {
            int i6 = (i5 + length) / 2;
            while (i6 > -1 && bArr[i6] != 10) {
                i6--;
            }
            int i7 = i6 + 1;
            int i8 = 1;
            while (true) {
                i2 = i7 + i8;
                if (bArr[i2] == 10) {
                    break;
                }
                i8++;
            }
            int i9 = i2 - i7;
            int i10 = i;
            boolean z2 = false;
            int i11 = 0;
            int i12 = 0;
            while (true) {
                if (z2) {
                    i3 = 46;
                    z = false;
                } else {
                    z = z2;
                    i3 = bArr2[i10][i11] & 255;
                }
                i4 = i3 - (bArr[i7 + i12] & 255);
                if (i4 == 0) {
                    i12++;
                    i11++;
                    if (i12 == i9) {
                        break;
                    }
                    if (bArr2[i10].length != i11) {
                        z2 = z;
                    } else {
                        if (i10 == bArr2.length - 1) {
                            break;
                        }
                        i10++;
                        z2 = true;
                        i11 = -1;
                    }
                } else {
                    break;
                }
            }
            if (i4 >= 0) {
                if (i4 <= 0) {
                    int i13 = i9 - i12;
                    int length2 = bArr2[i10].length - i11;
                    while (true) {
                        i10++;
                        if (i10 >= bArr2.length) {
                            break;
                        }
                        length2 += bArr2[i10].length;
                    }
                    if (length2 >= i13) {
                        if (length2 <= i13) {
                            return new java.lang.String(bArr, i7, i9, java.nio.charset.StandardCharsets.UTF_8);
                        }
                    }
                }
                i5 = i2 + 1;
            }
            length = i7 - 1;
        }
        return null;
    }

    public static okhttp3.internal.publicsuffix.PublicSuffixDatabase get() {
        return h;
    }

    public final java.lang.String[] b(java.lang.String[] strArr) {
        java.lang.String str;
        java.lang.String str2;
        java.lang.String str3;
        int i = 0;
        if (this.a.get() || !this.a.compareAndSet(false, true)) {
            try {
                this.b.await();
            } catch (java.lang.InterruptedException unused) {
                java.lang.Thread.currentThread().interrupt();
            }
        } else {
            d();
        }
        synchronized (this) {
            if (this.c == null) {
                throw new java.lang.IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
            }
        }
        int length = strArr.length;
        byte[][] bArr = new byte[length][];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            bArr[i2] = strArr[i2].getBytes(java.nio.charset.StandardCharsets.UTF_8);
        }
        int i3 = 0;
        while (true) {
            str = null;
            if (i3 >= length) {
                str2 = null;
                break;
            }
            str2 = a(this.c, bArr, i3);
            if (str2 != null) {
                break;
            }
            i3++;
        }
        if (length > 1) {
            byte[][] bArr2 = (byte[][]) bArr.clone();
            for (int i4 = 0; i4 < bArr2.length - 1; i4++) {
                bArr2[i4] = e;
                str3 = a(this.c, bArr2, i4);
                if (str3 != null) {
                    break;
                }
            }
        }
        str3 = null;
        if (str3 != null) {
            while (true) {
                if (i >= length - 1) {
                    break;
                }
                java.lang.String a = a(this.d, bArr, i);
                if (a != null) {
                    str = a;
                    break;
                }
                i++;
            }
        }
        if (str != null) {
            return ("!" + str).split("\\.");
        }
        if (str2 == null && str3 == null) {
            return g;
        }
        java.lang.String[] split = str2 != null ? str2.split("\\.") : f;
        java.lang.String[] split2 = str3 != null ? str3.split("\\.") : f;
        return split.length > split2.length ? split : split2;
    }

    public final void c() throws java.io.IOException {
        java.io.InputStream resourceAsStream = okhttp3.internal.publicsuffix.PublicSuffixDatabase.class.getResourceAsStream(PUBLIC_SUFFIX_RESOURCE);
        if (resourceAsStream == null) {
            return;
        }
        okio.BufferedSource buffer = okio.Okio.buffer(new okio.GzipSource(okio.Okio.source(resourceAsStream)));
        try {
            byte[] bArr = new byte[buffer.readInt()];
            buffer.readFully(bArr);
            byte[] bArr2 = new byte[buffer.readInt()];
            buffer.readFully(bArr2);
            buffer.close();
            synchronized (this) {
                this.c = bArr;
                this.d = bArr2;
            }
            this.b.countDown();
        } catch (java.lang.Throwable th) {
            try {
                throw th;
            } catch (java.lang.Throwable th2) {
                if (buffer != null) {
                    try {
                        buffer.close();
                    } catch (java.lang.Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public final void d() {
        boolean z = false;
        while (true) {
            try {
                try {
                    c();
                    break;
                } catch (java.io.InterruptedIOException unused) {
                    java.lang.Thread.interrupted();
                    z = true;
                } catch (java.io.IOException e2) {
                    okhttp3.internal.platform.Platform.get().log(5, "Failed to read public suffix list", e2);
                    if (z) {
                        java.lang.Thread.currentThread().interrupt();
                        return;
                    }
                    return;
                }
            } catch (java.lang.Throwable th) {
                if (z) {
                    java.lang.Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            java.lang.Thread.currentThread().interrupt();
        }
    }

    public java.lang.String getEffectiveTldPlusOne(java.lang.String str) {
        int length;
        int length2;
        if (str == null) {
            throw new java.lang.NullPointerException("domain == null");
        }
        java.lang.String[] split = java.net.IDN.toUnicode(str).split("\\.");
        java.lang.String[] b = b(split);
        if (split.length == b.length && b[0].charAt(0) != '!') {
            return null;
        }
        if (b[0].charAt(0) == '!') {
            length = split.length;
            length2 = b.length;
        } else {
            length = split.length;
            length2 = b.length + 1;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.lang.String[] split2 = str.split("\\.");
        for (int i = length - length2; i < split2.length; i++) {
            sb.append(split2[i]);
            sb.append('.');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
