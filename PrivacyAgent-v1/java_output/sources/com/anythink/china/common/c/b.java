package com.anythink.china.common.c;

/* loaded from: classes12.dex */
public final class b {
    private static final java.lang.String a = "anythink_myoffer_download";

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
        java.io.File file = null;
        if (e() == null) {
            return null;
        }
        try {
            java.io.File externalFilesDir = e().getExternalFilesDir(null);
            if (externalFilesDir != null) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(java.util.UUID.randomUUID());
                java.io.File file2 = new java.io.File(externalFilesDir, sb.toString());
                if (file2.exists()) {
                    file2.delete();
                }
                if (file2.mkdirs()) {
                    file2.delete();
                    file = externalFilesDir.getAbsoluteFile();
                }
                if (file != null) {
                    file = new java.io.File(file, a);
                }
            }
        } catch (java.lang.Throwable unused) {
        }
        if (file == null) {
            file = new java.io.File(e().getFilesDir().getAbsoluteFile() + java.io.File.separator + a);
        }
        return file.getAbsolutePath();
    }

    public static java.lang.String a(java.lang.String str) {
        java.lang.String a2 = a();
        if (a2 == null) {
            return null;
        }
        return a2 + java.io.File.separator + com.anythink.core.common.o.g.a(str);
    }

    private static java.lang.String b(java.lang.String str) {
        return com.anythink.core.common.o.g.a(str);
    }

    private static boolean b() {
        return c() > 104857600;
    }

    private static long c() {
        if ("mounted".equals(android.os.Environment.getExternalStorageState())) {
            try {
                android.os.StatFs statFs = new android.os.StatFs(android.os.Environment.getExternalStorageDirectory().getPath());
                return statFs.getAvailableBlocks() * statFs.getBlockSize();
            } catch (java.lang.Error unused) {
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
        return 0L;
    }

    private static long d() {
        try {
            android.os.StatFs statFs = new android.os.StatFs(android.os.Environment.getDataDirectory().getPath());
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (java.lang.Error unused) {
            return 0L;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    private static android.content.Context e() {
        try {
            return com.anythink.core.common.b.o.a().f().getApplicationContext();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static boolean f() {
        return "mounted".equals(android.os.Environment.getExternalStorageState());
    }

    private static boolean g() {
        android.content.Context e = e();
        if (e == null) {
            return false;
        }
        try {
            return e.getPackageManager().checkPermission(com.anythink.china.common.d.b, e.getPackageName()) == 0;
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
