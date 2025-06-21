package com.bytedance.pangle.e;

/* loaded from: classes12.dex */
public final class g {

    public static class a extends java.io.File {
        public a(java.io.File file, java.lang.String str) {
            super(file, str);
        }
    }

    private static int a(java.lang.String str) {
        return a().getInt(str, 0);
    }

    public static android.content.SharedPreferences a() {
        return com.bytedance.pangle.Zeus.getAppApplication().getSharedPreferences("plugin-multidex.version", 0);
    }

    public static java.lang.String a(java.lang.String str, int i) {
        int b = b(str, i);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i2 = 1; i2 <= b; i2++) {
            sb.append(new com.bytedance.pangle.e.g.a(new java.io.File(com.bytedance.pangle.d.c.i(str, i)), i2 == 1 ? "classes.dex" : "classes" + i2 + ".dex").getAbsolutePath());
            sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
        }
        if (sb.length() != 0) {
            sb.delete(sb.length() - 1, sb.length());
        }
        return sb.toString();
    }

    private static void a(java.io.Closeable closeable) {
        try {
            closeable.close();
        } catch (java.io.IOException e) {
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_INSTALL, "Plugin-MultiDex Failed to close resource", e);
        }
    }

    public static void a(java.io.File file) {
        java.io.File[] listFiles;
        if (!file.exists() || (listFiles = file.listFiles()) == null || listFiles.length == 0) {
            return;
        }
        for (java.io.File file2 : listFiles) {
            com.bytedance.pangle.log.ZeusLogger.i(com.bytedance.pangle.log.ZeusLogger.TAG_INSTALL, "Plugin-MultiDex Trying to delete old file " + file2.getPath() + " of size " + file2.length());
            if (!file2.delete()) {
                com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_INSTALL, "Plugin-MultiDex Failed to delete old file " + file2.getPath());
            }
        }
    }

    public static void a(java.util.zip.ZipFile zipFile, java.util.zip.ZipEntry zipEntry, com.bytedance.pangle.e.g.a aVar, java.lang.String str) {
        java.io.InputStream inputStream = zipFile.getInputStream(zipEntry);
        java.io.File createTempFile = java.io.File.createTempFile("tmp-".concat(java.lang.String.valueOf(str)), ".dex", aVar.getParentFile());
        try {
            java.io.BufferedOutputStream bufferedOutputStream = new java.io.BufferedOutputStream(new java.io.FileOutputStream(createTempFile));
            try {
                byte[] bArr = new byte[1048576];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    } else {
                        bufferedOutputStream.write(bArr, 0, read);
                    }
                }
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
                if (!createTempFile.setReadOnly()) {
                    throw new java.io.IOException("Failed to mark readonly \"" + createTempFile.getAbsolutePath() + "\" (tmp of \"" + aVar.getAbsolutePath() + "\")");
                }
                if (createTempFile.renameTo(aVar)) {
                    return;
                }
                throw new java.io.IOException("Failed to rename \"" + createTempFile.getAbsolutePath() + "\" to \"" + aVar.getAbsolutePath() + "\"");
            } catch (java.lang.Throwable th) {
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
                throw th;
            }
        } finally {
            a(inputStream);
            createTempFile.delete();
        }
    }

    private static int b(java.lang.String str, int i) {
        return a((str + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + i) + ".dex.number");
    }
}
