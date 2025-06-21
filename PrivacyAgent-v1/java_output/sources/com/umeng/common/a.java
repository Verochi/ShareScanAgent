package com.umeng.common;

/* loaded from: classes19.dex */
public class a {
    private static java.lang.String a = null;
    private static final java.lang.String b = "umeng+";
    private static final java.lang.String c = "ek__id";
    private static final java.lang.String d = "ek_key";
    private static java.lang.String e = "";
    private static final java.lang.String f = com.umeng.analytics.pro.ay.b().b(com.umeng.analytics.pro.ay.n);
    private static java.lang.String g = "";
    private static com.umeng.common.a h;

    private a() {
    }

    public static com.umeng.common.a a() {
        if (h == null) {
            synchronized (com.umeng.common.a.class) {
                if (h == null) {
                    h = new com.umeng.common.a();
                }
            }
        }
        return h;
    }

    private java.lang.String c(java.lang.String str) {
        java.lang.String str2 = "";
        try {
            java.lang.String substring = str.substring(1, 9);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            for (int i = 0; i < substring.length(); i++) {
                char charAt = substring.charAt(i);
                if (!java.lang.Character.isDigit(charAt)) {
                    sb.append(charAt);
                } else if (java.lang.Integer.parseInt(java.lang.Character.toString(charAt)) == 0) {
                    sb.append(0);
                } else {
                    sb.append(10 - java.lang.Integer.parseInt(java.lang.Character.toString(charAt)));
                }
            }
            str2 = sb.toString();
            return str2 + new java.lang.StringBuilder(str2).reverse().toString();
        } catch (java.lang.Throwable unused) {
            return str2;
        }
    }

    public java.lang.String a(java.lang.String str) {
        try {
            return android.text.TextUtils.isEmpty(a) ? str : android.util.Base64.encodeToString(com.umeng.commonsdk.statistics.common.DataHelper.encrypt(str.getBytes(), a.getBytes()), 0);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public void a(android.content.Context context) {
        try {
            if (android.text.TextUtils.isEmpty(a)) {
                java.lang.String multiProcessSP = com.umeng.commonsdk.utils.UMUtils.getMultiProcessSP(context, c);
                if (!android.text.TextUtils.isEmpty(multiProcessSP)) {
                    e = c(multiProcessSP);
                    com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>>> primaryKey: " + e);
                }
                android.content.SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f, 0);
                if (sharedPreferences != null) {
                    g = sharedPreferences.getString(c, null);
                    com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> 子进程备份秘钥：主进程key: " + g);
                }
                a = c(com.umeng.commonsdk.utils.UMUtils.genId());
                com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>>> 正式秘钥：key: " + a);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public java.lang.String b(java.lang.String str) {
        java.lang.String str2;
        java.lang.String str3;
        try {
            return android.text.TextUtils.isEmpty(a) ? str : new java.lang.String(com.umeng.commonsdk.statistics.common.DataHelper.decrypt(android.util.Base64.decode(str.getBytes(), 0), a.getBytes()));
        } catch (java.lang.Exception unused) {
            com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败!");
            java.lang.String str4 = null;
            if (android.text.TextUtils.isEmpty(e)) {
                return null;
            }
            com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，换老秘钥重试");
            try {
                str3 = new java.lang.String(com.umeng.commonsdk.statistics.common.DataHelper.decrypt(android.util.Base64.decode(str.getBytes(), 0), e.getBytes()));
            } catch (java.lang.Exception unused2) {
            }
            try {
                com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，换老秘钥重试成功。");
                return str3;
            } catch (java.lang.Exception unused3) {
                str4 = str3;
                com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，换老秘钥重试失败。换子进程备份key重试。");
                try {
                    java.lang.String str5 = new java.lang.String(com.umeng.commonsdk.statistics.common.DataHelper.decrypt(android.util.Base64.decode(str.getBytes(), 0), g.getBytes()));
                    try {
                        com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，子进程备份key重试成功。");
                        return str5;
                    } catch (java.lang.Throwable unused4) {
                        str2 = str5;
                        com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，子进程备份key重试失败。");
                        return str2;
                    }
                } catch (java.lang.Throwable unused5) {
                    str2 = str4;
                }
            }
        }
    }
}
