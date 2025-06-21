package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class v {

    public static class a {
        public static final com.zx.a.I8b7.v a = new com.zx.a.I8b7.v();
    }

    public static void a(java.io.File file, java.io.File file2) throws java.io.IOException {
        java.util.zip.ZipInputStream zipInputStream = new java.util.zip.ZipInputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(file)));
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                java.util.zip.ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry == null) {
                    zipInputStream.close();
                    return;
                }
                java.io.File file3 = new java.io.File(file2, nextEntry.getName().replaceFirst("^\\./", ""));
                java.io.File parentFile = nextEntry.isDirectory() ? file3 : file3.getParentFile();
                if (!parentFile.isDirectory() && !parentFile.mkdirs()) {
                    throw new java.io.FileNotFoundException("Failed to ensure directory: " + parentFile.getAbsolutePath());
                }
                if (!nextEntry.isDirectory()) {
                    java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file3);
                    while (true) {
                        try {
                            int read = zipInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            } else {
                                fileOutputStream.write(bArr, 0, read);
                            }
                        } finally {
                        }
                    }
                    fileOutputStream.close();
                }
            }
        } catch (java.lang.Throwable th) {
            try {
                zipInputStream.close();
            } catch (java.lang.Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public com.zx.module.base.ZXModule a(android.content.Context context) {
        com.zx.module.base.ZXModule zXModule = null;
        try {
            com.zx.a.I8b7.m3.a = context;
            com.zx.a.I8b7.l2.a.a.a.a("3.3.4.43514");
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(context.getFilesDir().getAbsolutePath());
            java.lang.String str = java.io.File.separator;
            sb.append(str);
            sb.append("zx-core-3.3.4.43514.zip");
            java.lang.String sb2 = sb.toString();
            java.lang.String str2 = context.getFilesDir().getAbsolutePath() + str + "zx-core-3.3.4.43514";
            java.io.File file = new java.io.File(str2);
            java.io.File file2 = new java.io.File(sb2);
            if (file2.exists()) {
                file.delete();
                a(file2, file);
                java.io.File file3 = new java.io.File(str2 + str + "classes.jar");
                com.zx.module.base.ZXModule zXModule2 = (com.zx.module.base.ZXModule) new com.zx.a.I8b7.t(file3.getAbsolutePath(), str2, null).b().newInstance();
                java.lang.String str3 = str2 + str + "libzx-core-d.so";
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.put("path", str3);
                zXModule2.invoke("loadLib", jSONObject.toString());
                com.zx.a.I8b7.v3.f.a.b.execute(new com.zx.a.I8b7.u(this, file3, str3, file2, file));
                zXModule = zXModule2;
            }
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.r2.a(th);
        }
        return zXModule == null ? new com.zx.a.I8b7.j2() : zXModule;
    }
}
