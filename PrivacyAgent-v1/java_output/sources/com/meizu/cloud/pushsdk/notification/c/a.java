package com.meizu.cloud.pushsdk.notification.c;

/* loaded from: classes23.dex */
public class a {

    /* renamed from: com.meizu.cloud.pushsdk.notification.c.a$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.io.FileFilter {
        final /* synthetic */ java.lang.String a;

        public AnonymousClass1(java.lang.String str) {
            this.a = str;
        }

        @Override // java.io.FileFilter
        public boolean accept(java.io.File file) {
            try {
                return java.lang.Long.valueOf(this.a).longValue() > java.lang.Long.valueOf(file.getName().split(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER)[1]).longValue();
            } catch (java.lang.Exception e) {
                com.meizu.cloud.pushinternal.DebugLogger.e("FileUtil", "filters file error " + e.getMessage());
                return true;
            }
        }
    }

    public static void a(java.lang.String str, java.lang.String str2) {
        try {
            new java.io.File(str2).mkdirs();
            for (java.lang.String str3 : new java.io.File(str).list()) {
                java.lang.String str4 = java.io.File.separator;
                java.io.File file = str.endsWith(str4) ? new java.io.File(str + str3) : new java.io.File(str + str4 + str3);
                if (file.isFile()) {
                    java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
                    java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(str2 + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + file.getName());
                    byte[] bArr = new byte[com.badlogic.gdx.graphics.GL20.GL_BYTE];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        } else {
                            fileOutputStream.write(bArr, 0, read);
                        }
                    }
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    fileInputStream.close();
                } else if (file.isDirectory()) {
                    a(str + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + str3, str2 + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + str3);
                }
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean a(java.lang.String str) {
        if (!android.text.TextUtils.isEmpty(str) && !str.contains("../")) {
            java.io.File file = new java.io.File(str);
            if (file.isFile() && file.exists()) {
                return file.delete();
            }
        }
        return false;
    }

    public static boolean b(java.lang.String str) {
        if (!android.text.TextUtils.isEmpty(str) && !str.contains("../")) {
            java.lang.String str2 = java.io.File.separator;
            if (!str.endsWith(str2)) {
                str = str + str2;
            }
            java.io.File file = new java.io.File(str);
            if (file.exists() && file.isDirectory()) {
                boolean z = true;
                for (java.io.File file2 : file.listFiles()) {
                    boolean isFile = file2.isFile();
                    java.lang.String absolutePath = file2.getAbsolutePath();
                    if (isFile) {
                        z = a(absolutePath);
                        if (!z) {
                            break;
                        }
                    } else {
                        z = b(absolutePath);
                        if (!z) {
                            break;
                        }
                    }
                }
                if (z) {
                    return file.delete();
                }
                return false;
            }
        }
        return false;
    }

    public static java.io.File[] b(java.lang.String str, java.lang.String str2) {
        java.io.File file = new java.io.File(str);
        return file.isDirectory() ? file.listFiles(new com.meizu.cloud.pushsdk.notification.c.a.AnonymousClass1(str2)) : new java.io.File[0];
    }
}
