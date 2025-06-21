package com.anythink.expressad.foundation.h;

/* loaded from: classes12.dex */
public final class r {
    static boolean a = false;
    static java.lang.String b = "";
    public static char[] c = {'P', 'a', 'c', 'k', 'a', 'g', 'e', 'M', 'a', 'n', 'a', 'g', 'e', com.aliyun.svideo.editor.guide.customView.MultiLamp.RIGHT};
    private static final java.lang.String d = "common-exception";
    private static final java.lang.String e = "SameSDCardTool";
    private static boolean f = false;
    private static int g = -1;
    private static int h = -1;
    private static int i = -1;
    private static int j = -1;
    private static java.lang.String k;

    private static java.io.File a(java.io.File file) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(java.util.UUID.randomUUID());
        java.io.File file2 = new java.io.File(file, sb.toString());
        if (file2.exists()) {
            file2.delete();
        }
        if (!file2.mkdirs()) {
            return null;
        }
        file2.delete();
        return file.getAbsoluteFile();
    }

    public static java.lang.String a() {
        return k;
    }

    public static void a(android.content.Context context) {
        if (f) {
            return;
        }
        try {
            try {
                b = context.getFilesDir().getAbsolutePath() + java.io.File.separator;
                if (context.getPackageManager().checkPermission(com.anythink.china.common.d.b, context.getPackageName()) == 0) {
                    a = true;
                } else {
                    a = false;
                }
                b(context);
            } catch (java.lang.Exception unused) {
                b = context.getFilesDir().getAbsolutePath() + java.io.File.separator;
                b(context);
            }
        } catch (java.lang.Exception unused2) {
        }
        f = true;
    }

    public static boolean a(long j2) {
        return e() > j2;
    }

    private static void b(android.content.Context context) {
        java.lang.String c2 = c(context);
        k = c2;
        com.anythink.expressad.foundation.g.c.d.a(new com.anythink.expressad.foundation.g.c.b(c2));
        com.anythink.expressad.foundation.g.c.d.a().b();
    }

    public static boolean b() {
        try {
            return "mounted".equals(android.os.Environment.getExternalStorageState());
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x005b, code lost:
    
        if ((e() > 31457280) == false) goto L20;
     */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static java.lang.String c(android.content.Context context) {
        java.io.File file;
        java.io.File externalFilesDir;
        java.io.File file2 = null;
        try {
            externalFilesDir = context.getExternalFilesDir(null);
        } catch (java.lang.Throwable unused) {
        }
        if (externalFilesDir != null) {
            file = a(externalFilesDir);
            if (a) {
                if (file == null) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append(android.os.Environment.getExternalStorageDirectory().getPath());
                    java.lang.String str = java.io.File.separator;
                    sb.append(str);
                    sb.append("Android");
                    sb.append(str);
                    sb.append("data");
                    sb.append(str);
                    sb.append(context.getPackageName());
                    file = a(new java.io.File(sb.toString()));
                }
            }
            file2 = file;
            if (file2 != null || !file2.exists()) {
                file2 = context.getFilesDir().getAbsoluteFile();
            }
            return file2.getAbsolutePath();
        }
        file = null;
        if (a) {
        }
        file2 = file;
        if (file2 != null) {
        }
        file2 = context.getFilesDir().getAbsoluteFile();
        return file2.getAbsolutePath();
    }

    private static boolean c() {
        return a;
    }

    private static int d() {
        try {
            android.content.Context d2 = com.anythink.expressad.foundation.b.a.b().d();
            long longValue = ((java.lang.Long) com.anythink.expressad.foundation.h.v.b(d2, "freeExternalSize", 0L)).longValue();
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            if (currentTimeMillis - longValue > 1800000 || h == -1) {
                h = java.lang.Long.valueOf((e() / 1000) / 1000).intValue();
                com.anythink.expressad.foundation.h.v.a(d2, "freeExternalSize", java.lang.Long.valueOf(currentTimeMillis));
            }
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
        return h;
    }

    private static long d(android.content.Context context) {
        try {
            java.lang.String absolutePath = context.getFilesDir().getAbsolutePath();
            new android.os.StatFs(absolutePath).restat(absolutePath);
            return r0.getAvailableBlocks() * r0.getBlockSize();
        } catch (java.lang.Exception unused) {
            return 0L;
        }
    }

    private static long e() {
        if (b()) {
            try {
                android.os.StatFs statFs = new android.os.StatFs(android.os.Environment.getExternalStorageDirectory().getPath());
                return statFs.getAvailableBlocks() * statFs.getBlockSize();
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
            }
        }
        return 0L;
    }

    private static boolean f() {
        return e() > 31457280;
    }

    private static int g() {
        if (g == -1) {
            try {
                g = new java.lang.Long((h() / 1000) / 1000).intValue();
            } catch (java.lang.Throwable th) {
                th.getMessage();
            }
        }
        return g;
    }

    private static long h() {
        if (b()) {
            try {
                android.os.StatFs statFs = new android.os.StatFs(android.os.Environment.getExternalStorageDirectory().getPath());
                return statFs.getBlockCount() * statFs.getBlockSize();
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
            }
        }
        return 0L;
    }

    private static int i() {
        try {
            android.content.Context d2 = com.anythink.expressad.foundation.b.a.b().d();
            long longValue = ((java.lang.Long) com.anythink.expressad.foundation.h.v.b(d2, "TotalDataSize", 0L)).longValue();
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            if (currentTimeMillis - longValue > 1800000 || i == -1) {
                android.os.StatFs statFs = new android.os.StatFs(android.os.Environment.getDataDirectory().getPath());
                i = java.lang.Long.valueOf(((statFs.getBlockCount() * statFs.getBlockSize()) / 1000) / 1000).intValue();
                com.anythink.expressad.foundation.h.v.a(d2, "TotalDataSize", java.lang.Long.valueOf(currentTimeMillis));
            }
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
        return i;
    }

    private static int j() {
        try {
            android.content.Context d2 = com.anythink.expressad.foundation.b.a.b().d();
            long longValue = ((java.lang.Long) com.anythink.expressad.foundation.h.v.b(d2, "FreeDataSize", 0L)).longValue();
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            if (currentTimeMillis - longValue > 1800000 || j == -1) {
                android.os.StatFs statFs = new android.os.StatFs(android.os.Environment.getDataDirectory().getPath());
                j = java.lang.Long.valueOf(((statFs.getAvailableBlocks() * statFs.getBlockSize()) / 1000) / 1000).intValue();
                com.anythink.expressad.foundation.h.v.a(d2, "FreeDataSize", java.lang.Long.valueOf(currentTimeMillis));
            }
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
        return j;
    }

    private static long k() {
        android.os.StatFs statFs = new android.os.StatFs(android.os.Environment.getDataDirectory().getPath());
        return statFs.getAvailableBlocks() * statFs.getBlockSize();
    }

    private static long l() {
        android.os.StatFs statFs = new android.os.StatFs(android.os.Environment.getDataDirectory().getPath());
        return statFs.getBlockCount() * statFs.getBlockSize();
    }
}
