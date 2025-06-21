package com.loc;

/* loaded from: classes23.dex */
public final class be {
    static byte[] a;
    static byte[] b;
    private java.lang.String c;

    public be(java.lang.String str) {
        this.c = com.loc.t.a(android.text.TextUtils.isDigitsOnly(str) ? "SPUtil" : str);
    }

    public static int a(android.content.Context context, java.lang.String str, java.lang.String str2, int i) {
        try {
            return context.getSharedPreferences(str, 0).getInt(str2, i);
        } catch (java.lang.Throwable th) {
            com.loc.aw.b(th, com.anythink.expressad.foundation.d.d.r, "giv");
            return i;
        }
    }

    public static long a(android.content.Context context, java.lang.String str, java.lang.String str2, long j) {
        try {
            return context.getSharedPreferences(str, 0).getLong(str2, j);
        } catch (java.lang.Throwable th) {
            com.loc.aw.b(th, com.anythink.expressad.foundation.d.d.r, "glv");
            return j;
        }
    }

    public static android.content.SharedPreferences.Editor a(android.content.Context context, java.lang.String str) {
        if (context != null) {
            try {
                if (!android.text.TextUtils.isEmpty(str)) {
                    return context.getSharedPreferences(str, 0).edit();
                }
            } catch (java.lang.Throwable th) {
                com.loc.at.a(th, "sp", "ge");
            }
        }
        return null;
    }

    public static java.lang.String a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        if (context == null) {
            return "";
        }
        try {
            return com.loc.y.a(b(context, com.loc.y.d(context.getSharedPreferences(str, 0).getString(str2, ""))));
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    public static void a(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (context == null || android.text.TextUtils.isEmpty(str2) || android.text.TextUtils.isEmpty(str3)) {
            return;
        }
        try {
            android.content.SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.putString(str2, com.loc.y.g(a(context, com.loc.y.a(str3))));
            a(edit);
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void a(android.content.SharedPreferences.Editor editor) {
        if (editor == null) {
            return;
        }
        try {
            editor.apply();
        } catch (java.lang.Throwable th) {
            com.loc.at.a(th, "sp", com.aliyun.common.log.struct.AliyunLogKey.KEY_CROP_MODE);
        }
    }

    public static void a(android.content.SharedPreferences.Editor editor, java.lang.String str) {
        if (editor != null) {
            try {
                if (android.text.TextUtils.isEmpty(str)) {
                    return;
                }
                editor.remove(str);
            } catch (java.lang.Throwable th) {
                com.loc.at.a(th, "sp", "rk");
            }
        }
    }

    public static void a(android.content.SharedPreferences.Editor editor, java.lang.String str, int i) {
        try {
            editor.putInt(str, i);
        } catch (java.lang.Throwable th) {
            com.loc.aw.b(th, com.anythink.expressad.foundation.d.d.r, "putPrefsInt");
        }
    }

    public static void a(android.content.SharedPreferences.Editor editor, java.lang.String str, long j) {
        if (editor == null || android.text.TextUtils.isEmpty(str)) {
            return;
        }
        try {
            editor.putLong(str, j);
        } catch (java.lang.Throwable th) {
            com.loc.aw.b(th, com.anythink.expressad.foundation.d.d.r, "plv");
        }
    }

    public static void a(android.content.SharedPreferences.Editor editor, java.lang.String str, java.lang.String str2) {
        if (editor != null) {
            try {
                if (!android.text.TextUtils.isEmpty(str) && !android.text.TextUtils.isEmpty(str2)) {
                    editor.putString(str, str2);
                }
            } catch (java.lang.Throwable th) {
                com.loc.at.a(th, "sp", com.aliyun.vod.log.struct.AliyunLogKey.KEY_PART_SIZE);
            }
        }
    }

    public static void a(android.content.SharedPreferences.Editor editor, java.lang.String str, boolean z) {
        try {
            editor.putBoolean(str, z);
        } catch (java.lang.Throwable th) {
            com.loc.aw.b(th, com.anythink.expressad.foundation.d.d.r, "setPrefsStr");
        }
    }

    public static boolean a(android.content.Context context, java.lang.String str, java.lang.String str2, boolean z) {
        try {
            return context.getSharedPreferences(str, 0).getBoolean(str2, z);
        } catch (java.lang.Throwable th) {
            com.loc.aw.b(th, com.anythink.expressad.foundation.d.d.r, "gbv");
            return z;
        }
    }

    private static byte[] a(android.content.Context context) {
        if (context == null) {
            return new byte[0];
        }
        byte[] bArr = a;
        if (bArr != null && bArr.length > 0) {
            return bArr;
        }
        byte[] bytes = com.loc.m.f(context).getBytes();
        a = bytes;
        return bytes;
    }

    public static byte[] a(android.content.Context context, byte[] bArr) {
        try {
            return com.loc.q.b(a(context), bArr, b(context));
        } catch (java.lang.Throwable unused) {
            return new byte[0];
        }
    }

    public static java.lang.String b(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (context == null) {
            return null;
        }
        try {
            return context.getSharedPreferences(str, 0).getString(str2, str3);
        } catch (java.lang.Throwable th) {
            com.loc.aw.b(th, com.anythink.expressad.foundation.d.d.r, "gsv");
            return str3;
        }
    }

    private static byte[] b(android.content.Context context) {
        byte[] bArr = b;
        if (bArr != null && bArr.length > 0) {
            return bArr;
        }
        byte[] copyOfRange = java.util.Arrays.copyOfRange(a(context), 0, a(context).length / 2);
        b = copyOfRange;
        return copyOfRange;
    }

    public static byte[] b(android.content.Context context, byte[] bArr) {
        try {
            return com.loc.q.a(a(context), bArr, b(context));
        } catch (java.lang.Exception unused) {
            return new byte[0];
        }
    }
}
