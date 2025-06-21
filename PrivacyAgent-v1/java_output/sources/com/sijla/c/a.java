package com.sijla.c;

/* loaded from: classes19.dex */
public final class a {
    private static com.sijla.c.a a;
    private long b = -1;
    private int c = -1;

    private static int a(int i, int i2, int i3, int i4, int i5, int[] iArr) {
        return ((i ^ i2) + (iArr[(i4 & 3) ^ i5] ^ i3)) ^ (((i3 >>> 5) ^ (i2 << 2)) + ((i2 >>> 3) ^ (i3 << 4)));
    }

    public static com.sijla.c.a a() {
        if (a == null) {
            a = new com.sijla.c.a();
        }
        return a;
    }

    public static com.sijla.f.c a(java.lang.String str, org.json.JSONObject jSONObject, java.util.Map<java.lang.String, java.io.File> map) {
        com.sijla.f.c cVar = new com.sijla.f.c();
        com.sijla.h.c.a.a();
        com.sijla.h.j a2 = com.sijla.h.c.a.a(str, jSONObject, map, new com.sijla.h.c.a.a.a());
        int a3 = a2.a();
        if (200 == a3 || 204 == a3) {
            cVar.a(true);
        } else {
            cVar.a(false);
            cVar.a(a2.b());
        }
        return cVar;
    }

    public static java.lang.String a(android.content.Context context) {
        return b(context.getApplicationContext());
    }

    private static java.lang.String a(byte[] bArr) {
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("SHA1");
            if (messageDigest == null) {
                return null;
            }
            byte[] digest = messageDigest.digest(bArr);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            for (byte b : digest) {
                sb.append(java.lang.Integer.toHexString((b & 255) | 256).substring(1, 3));
            }
            return sb.toString();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void a(android.app.Application application) {
        com.sijla.a.a.a(new com.sijla.c.b(application));
    }

    public static void a(android.content.Context context, java.io.File file) {
        java.lang.String optString = com.sijla.c.d.a.optString("cfgurl", "https://log.qchannel03.cn/n/dpz/");
        java.io.File a2 = new com.sijla.c.c(context, com.sijla.h.c.a(optString) ? "https://log.qchannel03.cn/n/dpz/" : optString, file.getAbsolutePath()).a();
        if (a2 != null && a2.exists() && a2.isFile()) {
            try {
                if (com.sijla.mla.a.y.b(a2)) {
                    com.sijla.mla.a.y.a(a2);
                } else {
                    a2.renameTo(new java.io.File(a2.getAbsolutePath().replace(".gz", "")));
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void a(java.io.File file, com.sijla.h.b.a aVar) {
        if (!com.sijla.h.c.g(file.getAbsolutePath()) && aVar.a(file)) {
            java.io.File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (java.io.File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        a(file2, aVar);
                    } else if (!aVar.b(file2)) {
                        return;
                    }
                }
            }
            aVar.c(file);
        }
    }

    public static boolean a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        return a(com.sijla.h.a.d.d(context) + str, str2);
    }

    public static boolean a(android.content.Context context, java.lang.String str, java.util.List<java.lang.String> list) {
        int i = 0;
        if (list.size() == 0) {
            return false;
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        while (i < list.size()) {
            stringBuffer.append(list.get(i));
            stringBuffer.append(i == list.size() + (-1) ? "\n" : "\t");
            i++;
        }
        return a(com.sijla.h.a.d.d(context) + str, stringBuffer.toString());
    }

    private static boolean a(java.lang.String str, java.lang.String str2) {
        java.io.File a2;
        java.lang.String b = com.sijla.h.c.b(str2);
        return (b == null || (a2 = com.sijla.h.a.e.a(str, com.sijla.h.c.e(b))) == null || !a2.exists()) ? false : true;
    }

    public static boolean a(org.json.JSONArray jSONArray, boolean z, org.json.JSONObject jSONObject, java.util.Map<java.lang.String, java.io.File> map) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return false;
        }
        boolean z2 = false;
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                java.lang.String optString = jSONArray.optString(i, "");
                if ((z || !z2) && !com.sijla.h.c.a(optString) && a(optString, jSONObject, map).b() && !z2) {
                    z2 = true;
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
        return z2;
    }

    public static byte[] a(java.io.InputStream inputStream) {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr, 0, 1024);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr.length == 0) {
            return bArr;
        }
        int[] a2 = a(bArr, true);
        if (bArr2.length != 16) {
            byte[] bArr3 = new byte[16];
            java.lang.System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length < 16 ? bArr2.length : 16);
            bArr2 = bArr3;
        }
        int[] a3 = a(bArr2, false);
        int length = a2.length - 1;
        if (length > 0) {
            int i = (52 / (length + 1)) + 6;
            int i2 = a2[length];
            int i3 = 0;
            while (true) {
                int i4 = i - 1;
                if (i <= 0) {
                    break;
                }
                int i5 = (-1640531527) + i3;
                int i6 = (i5 >>> 2) & 3;
                int i7 = i2;
                int i8 = 0;
                while (i8 < length) {
                    int i9 = i8 + 1;
                    i7 = a2[i8] + a(i5, a2[i9], i7, i8, i6, a3);
                    a2[i8] = i7;
                    i8 = i9;
                }
                i3 = i5;
                i2 = a(i3, a2[0], i7, i8, i6, a3) + a2[length];
                a2[length] = i2;
                i = i4;
            }
        }
        int length2 = a2.length << 2;
        byte[] bArr4 = new byte[length2];
        for (int i10 = 0; i10 < length2; i10++) {
            bArr4[i10] = (byte) (a2[i10 >>> 2] >>> ((i10 & 3) << 3));
        }
        return bArr4;
    }

    private static int[] a(byte[] bArr, boolean z) {
        int[] iArr;
        int length = (bArr.length & 3) == 0 ? bArr.length >>> 2 : (bArr.length >>> 2) + 1;
        if (z) {
            iArr = new int[length + 1];
            iArr[length] = bArr.length;
        } else {
            iArr = new int[length];
        }
        int length2 = bArr.length;
        for (int i = 0; i < length2; i++) {
            int i2 = i >>> 2;
            iArr[i2] = iArr[i2] | ((bArr[i] & 255) << ((i & 3) << 3));
        }
        return iArr;
    }

    private static java.lang.String b(android.content.Context context) {
        android.content.pm.Signature[] signatureArr;
        try {
            signatureArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            signatureArr = null;
        }
        if (signatureArr == null || signatureArr.length <= 0) {
            return null;
        }
        return a(signatureArr[0].toByteArray());
    }

    public static java.lang.String d() {
        return new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
    }

    public static java.lang.String e() {
        try {
            return new java.text.SimpleDateFormat("yyyyMMdd").format(new java.util.Date(java.lang.System.currentTimeMillis()));
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    @android.annotation.SuppressLint({"SimpleDateFormat"})
    public static java.lang.String f() {
        try {
            return new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date(java.lang.System.currentTimeMillis()));
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    public final java.lang.String b() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(this.b);
        return sb.toString();
    }

    public final java.lang.String c() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(this.c);
        return sb.toString();
    }
}
