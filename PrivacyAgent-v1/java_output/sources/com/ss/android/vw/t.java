package com.ss.android.vw;

/* loaded from: classes19.dex */
public class t {
    private static final char[] vw = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', com.aliyun.svideo.editor.guide.customView.MultiLamp.BOTTOM, 'c', 'd', 'e', 'f'};

    public static class vw {
        private int t;
        private long v;
        private int vw;
        private int wg;
        private java.lang.String yl;

        private vw() {
        }

        public /* synthetic */ vw(com.ss.android.vw.t.AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public static int vw(java.lang.String str, java.io.File file) {
        return vw(str, file, (com.ss.android.vw.wg) null);
    }

    public static int vw(java.lang.String str, java.io.File file, com.ss.android.vw.wg wgVar) {
        int i;
        long j;
        java.lang.String str2;
        if (str == null || str.length() == 0) {
            return 2;
        }
        try {
            if (wgVar != null) {
                if (wgVar.vw() <= 0) {
                    try {
                        wgVar.wg();
                    } catch (java.lang.Throwable unused) {
                    }
                    return 5;
                }
            } else if (file == null || !file.exists()) {
                return 5;
            }
            try {
                com.ss.android.vw.t.vw vw2 = vw(str);
                if (vw2 == null) {
                    i = -1;
                    j = -1;
                } else {
                    if (vw2.vw > 1) {
                        return 3;
                    }
                    i = vw2.t;
                    j = vw2.v;
                }
                com.ss.android.vw.t.vw vwVar = null;
                try {
                    str2 = wgVar != null ? vw(wgVar, i, j) : wg(file, i, j);
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                    str2 = null;
                }
                if (str2 != null && str2.length() != 0) {
                    if (vw2 != null && (vw2.vw != 1 || vw2.wg != 1)) {
                        if (vw2.yl != null) {
                            try {
                                vwVar = vw(str2);
                            } catch (java.lang.Throwable unused2) {
                            }
                            if (vwVar != null && vw2.t == vwVar.t && vw2.v == vwVar.v && vw2.yl.equals(vwVar.yl)) {
                                return 0;
                            }
                        }
                    }
                    return str2.equals(str) ? 0 : 1;
                }
                return 6;
            } catch (java.lang.Throwable unused3) {
                return 4;
            }
        } catch (java.lang.Throwable unused4) {
            return 99;
        }
    }

    private static com.ss.android.vw.t.vw vw(java.lang.String str) throws java.lang.Exception {
        if (!str.startsWith("ttmd5:")) {
            return null;
        }
        java.lang.String[] split = str.split(com.alipay.sdk.m.u.i.b);
        java.lang.String[] split2 = split[0].split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
        com.ss.android.vw.t.vw vwVar = new com.ss.android.vw.t.vw(null);
        vwVar.vw = java.lang.Integer.parseInt(split2[1]);
        if (vwVar.vw > 1) {
            return vwVar;
        }
        vwVar.wg = java.lang.Integer.parseInt(split2[2]);
        java.lang.String[] split3 = split2[3].split("g");
        vwVar.t = (int) wg(split3[0]);
        vwVar.v = wg(split3[1]);
        vwVar.yl = split[1];
        return vwVar;
    }

    private static java.lang.String vw(int i, long j) {
        return "ttmd5:1:1:" + vw(i) + "g" + vw(j);
    }

    private static java.lang.String vw(long j) {
        return java.lang.Long.toHexString((j << 4) + 31);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:5|6|(6:13|14|(3:16|(1:18)|19)|(1:21)|22|(4:31|32|33|34)(3:26|27|28))|38|14|(0)|(0)|22|(1:24)|31|32|33|34) */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0041 A[Catch: all -> 0x009f, TryCatch #3 {all -> 0x009f, blocks: (B:6:0x000d, B:10:0x001a, B:14:0x002e, B:16:0x0041, B:18:0x004e, B:21:0x0066, B:22:0x0071, B:31:0x0083), top: B:5:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0066 A[Catch: all -> 0x009f, TryCatch #3 {all -> 0x009f, blocks: (B:6:0x000d, B:10:0x001a, B:14:0x002e, B:16:0x0041, B:18:0x004e, B:21:0x0066, B:22:0x0071, B:31:0x0083), top: B:5:0x000d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static java.lang.String vw(com.ss.android.vw.wg wgVar, int i, long j) throws java.lang.Exception {
        long j2;
        java.lang.String vw2;
        int i2 = i;
        java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
        if (messageDigest == null) {
            return "";
        }
        try {
            long vw3 = wgVar.vw();
            long j3 = 0;
            if (i2 > 0 && j > 0 && i2 * j <= (8 * vw3) / 10) {
                j2 = j;
                byte[] bArr = new byte[8192];
                vw(wgVar, messageDigest, bArr, 0L, j2);
                if (i2 > 2) {
                    int i3 = i2 - 1;
                    long j4 = (vw3 - (i2 * j2)) / i3;
                    int i4 = 1;
                    while (i4 < i3) {
                        j3 += j2 + j4;
                        vw(wgVar, messageDigest, bArr, j3, j2);
                        i4++;
                        i3 = i3;
                    }
                }
                if (i2 > 1) {
                    vw(wgVar, messageDigest, bArr, vw3 - j2, j2);
                }
                vw2 = vw(messageDigest.digest());
                if (i2 != 1 && j2 == vw3) {
                    return vw2;
                }
                java.lang.String str = vw(i2, j2) + com.alipay.sdk.m.u.i.b + vw2;
                wgVar.wg();
                return str;
            }
            j2 = vw3;
            i2 = 1;
            byte[] bArr2 = new byte[8192];
            vw(wgVar, messageDigest, bArr2, 0L, j2);
            if (i2 > 2) {
            }
            if (i2 > 1) {
            }
            vw2 = vw(messageDigest.digest());
            if (i2 != 1) {
            }
            java.lang.String str2 = vw(i2, j2) + com.alipay.sdk.m.u.i.b + vw2;
            wgVar.wg();
            return str2;
        } finally {
            try {
                wgVar.wg();
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public static java.lang.String vw(java.io.File file) {
        return vw(file, 9, 8192L);
    }

    public static java.lang.String vw(java.io.File file, int i, long j) {
        if (file != null) {
            try {
                if (file.exists()) {
                    return wg(file, i, j);
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
        return "";
    }

    private static java.lang.String vw(byte[] bArr) {
        if (bArr == null) {
            throw new java.lang.NullPointerException("bytes is null");
        }
        int length = bArr.length;
        int i = length * 2;
        char[] cArr = new char[i];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = bArr[i3 + 0] & 255;
            int i5 = i2 + 1;
            char[] cArr2 = vw;
            cArr[i2] = cArr2[i4 >> 4];
            i2 = i5 + 1;
            cArr[i5] = cArr2[i4 & 15];
        }
        return new java.lang.String(cArr, 0, i);
    }

    private static void vw(com.ss.android.vw.wg wgVar, java.security.MessageDigest messageDigest, byte[] bArr, long j, long j2) throws java.io.IOException {
        wgVar.vw(j, j2);
        long j3 = 0;
        while (j3 < j2) {
            int vw2 = wgVar.vw(bArr, 0, (int) java.lang.Math.min(j2 - j3, bArr.length));
            if (vw2 <= 0) {
                throw new java.io.IOException("updateSample unexpected readCount <= 0, readCount = " + vw2 + ", readTotalCount = " + j3 + ", sampleSize = " + j2);
            }
            messageDigest.update(bArr, 0, vw2);
            j3 += vw2;
        }
    }

    private static long wg(java.lang.String str) throws java.lang.RuntimeException {
        return (java.lang.Long.parseLong(str, 16) - 31) >> 4;
    }

    private static java.lang.String wg(java.io.File file, int i, long j) throws java.lang.Exception {
        return vw(new com.ss.android.vw.vw(file), i, j);
    }
}
