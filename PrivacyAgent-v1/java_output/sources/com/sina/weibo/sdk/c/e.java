package com.sina.weibo.sdk.c;

import com.sina.weibo.sdk.a.a.AnonymousClass3;

/* loaded from: classes19.dex */
public final class e {
    private static char[] ap = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".toCharArray();
    private static byte[] aq = new byte[256];

    static {
        for (int i = 0; i < 256; i++) {
            aq[i] = -1;
        }
        for (int i2 = 65; i2 <= 90; i2++) {
            aq[i2] = (byte) (i2 - 65);
        }
        for (int i3 = 97; i3 <= 122; i3++) {
            aq[i3] = (byte) ((i3 + 26) - 97);
        }
        for (int i4 = 48; i4 <= 57; i4++) {
            aq[i4] = (byte) ((i4 + 52) - 48);
        }
        byte[] bArr = aq;
        bArr[43] = 62;
        bArr[47] = 63;
    }

    public static int a(int i, android.content.Context context) {
        return (int) ((i * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static byte[] b(byte[] bArr) {
        boolean z;
        byte[] bArr2 = new byte[((bArr.length + 2) / 3) * 4];
        int i = 0;
        int i2 = 0;
        while (i < bArr.length) {
            int i3 = (bArr[i] & 255) << 8;
            int i4 = i + 1;
            boolean z2 = true;
            if (i4 < bArr.length) {
                i3 |= bArr[i4] & 255;
                z = true;
            } else {
                z = false;
            }
            int i5 = i3 << 8;
            int i6 = i + 2;
            if (i6 < bArr.length) {
                i5 |= bArr[i6] & 255;
            } else {
                z2 = false;
            }
            int i7 = i2 + 3;
            char[] cArr = ap;
            int i8 = 64;
            bArr2[i7] = (byte) cArr[z2 ? i5 & 63 : 64];
            int i9 = i5 >> 6;
            int i10 = i2 + 2;
            if (z) {
                i8 = i9 & 63;
            }
            bArr2[i10] = (byte) cArr[i8];
            int i11 = i9 >> 6;
            bArr2[i2 + 1] = (byte) cArr[i11 & 63];
            bArr2[i2 + 0] = (byte) cArr[(i11 >> 6) & 63];
            i += 3;
            i2 += 4;
        }
        return bArr2;
    }

    public static java.lang.String e(android.content.Context context, java.lang.String str) {
        android.content.pm.Signature[] signatureArr;
        try {
            android.content.pm.PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo == null || (signatureArr = packageInfo.signatures) == null || signatureArr.length <= 0) {
                return null;
            }
            return com.sina.weibo.sdk.c.d.a(signatureArr[0].toByteArray());
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static java.lang.String f(android.content.Context context, java.lang.String str) {
        com.sina.weibo.sdk.a.a b = com.sina.weibo.sdk.a.a.b();
        java.lang.String c = !android.text.TextUtils.isEmpty(b.c) ? b.c : b.c(context, str);
        if (!android.text.TextUtils.isEmpty(c)) {
            return c;
        }
        com.sina.weibo.sdk.a.a b2 = com.sina.weibo.sdk.a.a.b();
        com.sina.weibo.sdk.a.a.a(context, str);
        new java.lang.Thread(b2.new AnonymousClass3()).start();
        return b2.c;
    }

    public static android.os.Bundle g(java.lang.String str) {
        try {
            return i(new java.net.URL(str).getQuery());
        } catch (java.net.MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static android.os.Bundle h(java.lang.String str) {
        try {
            return i(new java.net.URI(str).getQuery());
        } catch (java.net.URISyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static android.os.Bundle i(java.lang.String str) {
        android.os.Bundle bundle = new android.os.Bundle();
        if (str != null) {
            for (java.lang.String str2 : str.split("&")) {
                java.lang.String[] split = str2.split(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
                try {
                    if (split.length == 2) {
                        bundle.putString(java.net.URLDecoder.decode(split[0], "UTF-8"), java.net.URLDecoder.decode(split[1], "UTF-8"));
                    } else if (split.length == 1) {
                        bundle.putString(java.net.URLDecoder.decode(split[0], "UTF-8"), "");
                    }
                } catch (java.io.UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        return bundle;
    }

    public static java.lang.String r() {
        return android.os.Build.MANUFACTURER + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + android.os.Build.MODEL + "_" + android.os.Build.VERSION.RELEASE + "_weibosdk_0041005000_android";
    }
}
