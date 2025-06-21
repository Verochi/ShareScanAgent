package com.xiaomi.push;

/* loaded from: classes19.dex */
public abstract class bz {

    public static class a extends com.xiaomi.push.by {
        @Override // com.xiaomi.push.by
        public final java.lang.String a(android.content.Context context, java.lang.String str) {
            return com.xiaomi.push.ai.a(context, new java.net.URL(str));
        }
    }

    private static int a() {
        throw null;
    }

    private static int a(int i, int i2) {
        return (((i2 + 243) / 1448) * com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_ID) + com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_TTNET_NOT_MODIFIED + i + i2;
    }

    private static int a(int i, int i2, int i3) {
        return (((i2 + 200) / 1448) * com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_ID) + 1011 + i2 + i + i3;
    }

    private static int a(com.xiaomi.push.by byVar, java.lang.String str, java.lang.String str2) {
        int i = byVar.a;
        if (i == 1) {
            return a(str.length(), a(str2));
        }
        if (i != 2) {
            return -1;
        }
        return a(str.length(), a(), a(str2));
    }

    private static int a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return str.getBytes("UTF-8").length;
        } catch (java.io.UnsupportedEncodingException unused) {
            return 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0099 A[Catch: MalformedURLException -> 0x00b2, TRY_ENTER, TryCatch #5 {MalformedURLException -> 0x00b2, blocks: (B:6:0x000b, B:8:0x001a, B:9:0x001e, B:11:0x0024, B:12:0x0027, B:13:0x002c, B:15:0x0032, B:35:0x0099, B:36:0x00ab), top: B:5:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String a(android.content.Context context, java.lang.String str, com.xiaomi.push.by byVar) {
        java.io.IOException iOException;
        java.lang.String str2;
        java.lang.String a2;
        java.lang.String str3;
        if (com.xiaomi.push.ai.a(context)) {
            try {
                java.util.ArrayList<java.lang.String> arrayList = new java.util.ArrayList<>();
                com.xiaomi.push.br a3 = com.xiaomi.push.bv.a().a(str);
                if (a3 != null) {
                    arrayList = a3.a(str);
                }
                if (!arrayList.contains(str)) {
                    arrayList.add(str);
                }
                java.util.Iterator<java.lang.String> it = arrayList.iterator();
                java.lang.String str4 = null;
                while (it.hasNext()) {
                    java.lang.String next = it.next();
                    long currentTimeMillis = java.lang.System.currentTimeMillis();
                    try {
                        a2 = byVar.a(context, next);
                        try {
                        } catch (java.io.IOException e) {
                            e = e;
                            str3 = a2;
                        }
                    } catch (java.io.IOException e2) {
                        iOException = e2;
                        str2 = str4;
                    }
                    if (!android.text.TextUtils.isEmpty(a2)) {
                        if (a3 != null) {
                            try {
                                try {
                                    a3.a(new java.net.URL(next).getHost(), java.lang.System.currentTimeMillis() - currentTimeMillis, a(byVar, next, a2));
                                } catch (java.net.MalformedURLException unused) {
                                }
                            } catch (java.io.IOException e3) {
                                iOException = e3;
                                str2 = a2;
                                if (a3 != null) {
                                    a3.a(next, java.lang.System.currentTimeMillis() - currentTimeMillis, a(byVar, next, str2), iOException);
                                }
                                iOException.printStackTrace();
                                str4 = str2;
                            }
                        }
                        return a2;
                    }
                    if (a3 != null) {
                        str3 = a2;
                        try {
                            a3.a(next, java.lang.System.currentTimeMillis() - currentTimeMillis, a(byVar, next, a2), null);
                        } catch (java.io.IOException e4) {
                            e = e4;
                            java.lang.String str5 = str3;
                            iOException = e;
                            str2 = str5;
                            if (a3 != null) {
                            }
                            iOException.printStackTrace();
                            str4 = str2;
                        }
                    } else {
                        str3 = a2;
                    }
                    str4 = str3;
                }
                return str4;
            } catch (java.net.MalformedURLException e5) {
                e5.printStackTrace();
            }
        }
        return null;
    }
}
