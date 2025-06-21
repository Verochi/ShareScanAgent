package com.getui.gtc.extension.distribution.gbd.n;

/* loaded from: classes22.dex */
public class m {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 4;
    public static final int e = 8;
    public static final int f = 16;
    static final /* synthetic */ boolean g = true;

    public static abstract class a {
        public byte[] a;
        public int b;

        public abstract int a(int i);

        public abstract boolean a(byte[] bArr, int i, int i2);
    }

    public static class b extends com.getui.gtc.extension.distribution.gbd.n.m.a {
        private static final int[] c = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        private static final int[] d = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        private static final int e = -1;
        private static final int f = -2;
        private int g;
        private int h;
        private final int[] i;

        public b(int i, byte[] bArr) {
            this.a = bArr;
            this.i = (i & 8) == 0 ? c : d;
            this.g = 0;
            this.h = 0;
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.m.a
        public final int a(int i) {
            return ((i * 3) / 4) + 10;
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.m.a
        public final boolean a(byte[] bArr, int i, int i2) {
            int i3 = this.g;
            if (i3 == 6) {
                return false;
            }
            int i4 = i2 + i;
            int i5 = this.h;
            byte[] bArr2 = this.a;
            int[] iArr = this.i;
            int i6 = i5;
            int i7 = 0;
            int i8 = i3;
            int i9 = i;
            while (i9 < i4) {
                if (i8 == 0) {
                    while (true) {
                        int i10 = i9 + 4;
                        if (i10 > i4 || (i6 = (iArr[bArr[i9] & 255] << 18) | (iArr[bArr[i9 + 1] & 255] << 12) | (iArr[bArr[i9 + 2] & 255] << 6) | iArr[bArr[i9 + 3] & 255]) < 0) {
                            break;
                        }
                        bArr2[i7 + 2] = (byte) i6;
                        bArr2[i7 + 1] = (byte) (i6 >> 8);
                        bArr2[i7] = (byte) (i6 >> 16);
                        i7 += 3;
                        i9 = i10;
                    }
                    if (i9 >= i4) {
                        break;
                    }
                }
                int i11 = i9 + 1;
                int i12 = iArr[bArr[i9] & 255];
                if (i8 != 0) {
                    if (i8 == 1) {
                        if (i12 < 0) {
                            if (i12 != -1) {
                                this.g = 6;
                                return false;
                            }
                        }
                        i6 = (i6 << 6) | i12;
                        i8++;
                    } else if (i8 != 2) {
                        if (i8 != 3) {
                            if (i8 == 4) {
                                if (i12 != -2) {
                                    if (i12 != -1) {
                                        this.g = 6;
                                        return false;
                                    }
                                }
                                i8++;
                            } else if (i8 == 5 && i12 != -1) {
                                this.g = 6;
                                return false;
                            }
                        } else if (i12 >= 0) {
                            i6 = (i6 << 6) | i12;
                            bArr2[i7 + 2] = (byte) i6;
                            bArr2[i7 + 1] = (byte) (i6 >> 8);
                            bArr2[i7] = (byte) (i6 >> 16);
                            i7 += 3;
                            i9 = i11;
                            i8 = 0;
                        } else if (i12 == -2) {
                            bArr2[i7 + 1] = (byte) (i6 >> 2);
                            bArr2[i7] = (byte) (i6 >> 10);
                            i7 += 2;
                            i9 = i11;
                            i8 = 5;
                        } else if (i12 != -1) {
                            this.g = 6;
                            return false;
                        }
                    } else if (i12 >= 0) {
                        i6 = (i6 << 6) | i12;
                        i8++;
                    } else if (i12 == -2) {
                        bArr2[i7] = (byte) (i6 >> 4);
                        i7++;
                        i9 = i11;
                        i8 = 4;
                    } else if (i12 != -1) {
                        this.g = 6;
                        return false;
                    }
                } else if (i12 >= 0) {
                    i8++;
                    i6 = i12;
                } else if (i12 != -1) {
                    this.g = 6;
                    return false;
                }
                i9 = i11;
            }
            if (i8 == 1) {
                this.g = 6;
                return false;
            }
            if (i8 == 2) {
                bArr2[i7] = (byte) (i6 >> 4);
                i7++;
            } else if (i8 == 3) {
                int i13 = i7 + 1;
                bArr2[i7] = (byte) (i6 >> 10);
                i7 = i13 + 1;
                bArr2[i13] = (byte) (i6 >> 2);
            } else if (i8 == 4) {
                this.g = 6;
                return false;
            }
            this.g = i8;
            this.b = i7;
            return true;
        }
    }

    public static class c extends com.getui.gtc.extension.distribution.gbd.n.m.a {
        public static final int c = 19;
        static final /* synthetic */ boolean h = true;
        private static final byte[] i = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, org.apache.tools.tar.TarConstants.LF_GNUTYPE_LONGLINK, org.apache.tools.tar.TarConstants.LF_GNUTYPE_LONGNAME, 77, 78, 79, 80, 81, 82, org.apache.tools.tar.TarConstants.LF_GNUTYPE_SPARSE, 84, 85, 86, 87, org.apache.tools.tar.TarConstants.LF_PAX_EXTENDED_HEADER_UC, 89, 90, 97, 98, 99, 100, 101, 102, org.apache.tools.tar.TarConstants.LF_PAX_GLOBAL_EXTENDED_HEADER, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, org.apache.tools.tar.TarConstants.LF_PAX_EXTENDED_HEADER_LC, 121, 122, org.apache.tools.tar.TarConstants.LF_NORMAL, org.apache.tools.tar.TarConstants.LF_LINK, org.apache.tools.tar.TarConstants.LF_SYMLINK, org.apache.tools.tar.TarConstants.LF_CHR, org.apache.tools.tar.TarConstants.LF_BLK, org.apache.tools.tar.TarConstants.LF_DIR, org.apache.tools.tar.TarConstants.LF_FIFO, org.apache.tools.tar.TarConstants.LF_CONTIG, 56, 57, 43, 47};
        private static final byte[] j = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, org.apache.tools.tar.TarConstants.LF_GNUTYPE_LONGLINK, org.apache.tools.tar.TarConstants.LF_GNUTYPE_LONGNAME, 77, 78, 79, 80, 81, 82, org.apache.tools.tar.TarConstants.LF_GNUTYPE_SPARSE, 84, 85, 86, 87, org.apache.tools.tar.TarConstants.LF_PAX_EXTENDED_HEADER_UC, 89, 90, 97, 98, 99, 100, 101, 102, org.apache.tools.tar.TarConstants.LF_PAX_GLOBAL_EXTENDED_HEADER, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, org.apache.tools.tar.TarConstants.LF_PAX_EXTENDED_HEADER_LC, 121, 122, org.apache.tools.tar.TarConstants.LF_NORMAL, org.apache.tools.tar.TarConstants.LF_LINK, org.apache.tools.tar.TarConstants.LF_SYMLINK, org.apache.tools.tar.TarConstants.LF_CHR, org.apache.tools.tar.TarConstants.LF_BLK, org.apache.tools.tar.TarConstants.LF_DIR, org.apache.tools.tar.TarConstants.LF_FIFO, org.apache.tools.tar.TarConstants.LF_CONTIG, 56, 57, 45, 95};
        int d;
        public final boolean e;
        public final boolean f;
        public final boolean g;
        private final byte[] k;
        private int l;
        private final byte[] m;

        public c(int i2) {
            this.a = null;
            this.e = (i2 & 1) == 0;
            boolean z = (i2 & 2) == 0;
            this.f = z;
            this.g = (i2 & 4) != 0;
            this.m = (i2 & 8) == 0 ? i : j;
            this.k = new byte[2];
            this.d = 0;
            this.l = z ? 19 : -1;
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.m.a
        public final int a(int i2) {
            return ((i2 * 8) / 5) + 10;
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0094  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00e6 A[SYNTHETIC] */
        @Override // com.getui.gtc.extension.distribution.gbd.n.m.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean a(byte[] r19, int r20, int r21) {
            /*
                Method dump skipped, instructions count: 472
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.getui.gtc.extension.distribution.gbd.n.m.c.a(byte[], int, int):boolean");
        }
    }

    private m() {
    }

    private static java.lang.String a(byte[] bArr, int i, int i2, int i3) {
        try {
            return new java.lang.String(b(bArr, i, i2, i3), "US-ASCII");
        } catch (java.io.UnsupportedEncodingException e2) {
            throw new java.lang.AssertionError(e2);
        }
    }

    private static byte[] a(java.lang.String str, int i) {
        byte[] bytes = str.getBytes();
        int length = bytes.length;
        com.getui.gtc.extension.distribution.gbd.n.m.b bVar = new com.getui.gtc.extension.distribution.gbd.n.m.b(i, new byte[(length * 3) / 4]);
        if (!bVar.a(bytes, 0, length)) {
            throw new java.lang.IllegalArgumentException("bad base-64");
        }
        int i2 = bVar.b;
        byte[] bArr = bVar.a;
        if (i2 == bArr.length) {
            return bArr;
        }
        byte[] bArr2 = new byte[i2];
        java.lang.System.arraycopy(bArr, 0, bArr2, 0, i2);
        return bArr2;
    }

    private static byte[] a(byte[] bArr, int i) {
        int length = bArr.length;
        com.getui.gtc.extension.distribution.gbd.n.m.b bVar = new com.getui.gtc.extension.distribution.gbd.n.m.b(i, new byte[(length * 3) / 4]);
        if (!bVar.a(bArr, 0, length)) {
            throw new java.lang.IllegalArgumentException("bad base-64");
        }
        int i2 = bVar.b;
        byte[] bArr2 = bVar.a;
        if (i2 == bArr2.length) {
            return bArr2;
        }
        byte[] bArr3 = new byte[i2];
        java.lang.System.arraycopy(bArr2, 0, bArr3, 0, i2);
        return bArr3;
    }

    private static byte[] a(byte[] bArr, int i, int i2) {
        com.getui.gtc.extension.distribution.gbd.n.m.b bVar = new com.getui.gtc.extension.distribution.gbd.n.m.b(i2, new byte[(i * 3) / 4]);
        if (!bVar.a(bArr, 0, i)) {
            throw new java.lang.IllegalArgumentException("bad base-64");
        }
        int i3 = bVar.b;
        byte[] bArr2 = bVar.a;
        if (i3 == bArr2.length) {
            return bArr2;
        }
        byte[] bArr3 = new byte[i3];
        java.lang.System.arraycopy(bArr2, 0, bArr3, 0, i3);
        return bArr3;
    }

    private static java.lang.String b(byte[] bArr, int i) {
        try {
            return new java.lang.String(b(bArr, 0, bArr.length, i), "US-ASCII");
        } catch (java.io.UnsupportedEncodingException e2) {
            throw new java.lang.AssertionError(e2);
        }
    }

    private static byte[] b(byte[] bArr, int i, int i2, int i3) {
        com.getui.gtc.extension.distribution.gbd.n.m.c cVar = new com.getui.gtc.extension.distribution.gbd.n.m.c(i3);
        int i4 = (i2 / 3) * 4;
        if (!cVar.e) {
            int i5 = i2 % 3;
            if (i5 == 1) {
                i4 += 2;
            } else if (i5 == 2) {
                i4 += 3;
            }
        } else if (i2 % 3 > 0) {
            i4 += 4;
        }
        if (cVar.f && i2 > 0) {
            i4 += (((i2 - 1) / 57) + 1) * (cVar.g ? 2 : 1);
        }
        cVar.a = new byte[i4];
        cVar.a(bArr, i, i2);
        if (g || cVar.b == i4) {
            return cVar.a;
        }
        throw new java.lang.AssertionError();
    }

    private static byte[] c(byte[] bArr, int i) {
        return b(bArr, 0, bArr.length, i);
    }
}
