package com.efs.sdk.base.core.util;

/* loaded from: classes22.dex */
public class c {
    private static volatile java.lang.String a = "";

    public static java.lang.String a(android.content.Context context) {
        if (android.text.TextUtils.isEmpty(a)) {
            synchronized (com.efs.sdk.base.core.util.c.class) {
                if (android.text.TextUtils.isEmpty(a)) {
                    java.lang.String b = b(context);
                    a = b;
                    if (android.text.TextUtils.isEmpty(b)) {
                        a = c(context);
                    }
                }
            }
        }
        return a;
    }

    private static java.lang.String b(android.content.Context context) {
        try {
            java.io.File file = new java.io.File(com.efs.sdk.base.core.util.a.a(context), "efsid");
            if (file.exists()) {
                return com.efs.sdk.base.core.util.FileUtil.read(file);
            }
            return null;
        } catch (java.lang.Exception e) {
            com.efs.sdk.base.core.util.Log.e("efs.base", "get uuid error", e);
            return null;
        }
    }

    private static java.lang.String c(android.content.Context context) {
        java.lang.String str = "";
        for (int i = 0; i < 3; i++) {
            try {
                str = java.util.UUID.randomUUID().toString();
            } catch (java.lang.Throwable unused) {
            }
            if (android.text.TextUtils.isEmpty(str)) {
            }
        }
        try {
            java.io.File a2 = com.efs.sdk.base.core.util.a.a(context);
            java.io.File file = new java.io.File(a2, "efsid" + android.os.Process.myPid());
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            com.efs.sdk.base.core.util.FileUtil.write(file, str);
            if (file.renameTo(new java.io.File(a2, "efsid"))) {
                file.delete();
            }
        } catch (java.lang.Exception e) {
            com.efs.sdk.base.core.util.Log.e("efs.base", "save uuid '" + str + "' error", e);
        }
        return str;
    }
}
