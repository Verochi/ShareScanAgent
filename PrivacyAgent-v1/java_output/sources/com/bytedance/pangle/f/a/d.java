package com.bytedance.pangle.f.a;

/* loaded from: classes12.dex */
public final class d {
    public static com.bytedance.pangle.f.a.e a(java.io.File file) {
        java.util.zip.ZipFile zipFile;
        com.bytedance.pangle.f.a.a aVar;
        int b;
        int i;
        try {
            if (!file.exists()) {
                com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_INSTALL, file.getAbsolutePath() + " not exists!");
                com.bytedance.pangle.util.g.a((java.util.zip.ZipFile) null);
                return null;
            }
            java.util.zip.ZipFile zipFile2 = new java.util.zip.ZipFile(file);
            try {
                java.util.zip.ZipEntry entry = zipFile2.getEntry("AndroidManifest.xml");
                if (entry == null) {
                    com.bytedance.pangle.log.ZeusLogger.errReport(com.bytedance.pangle.log.ZeusLogger.TAG_INSTALL, "没有找到AndroidManifest.xml entry");
                    com.bytedance.pangle.util.g.a(zipFile2);
                    return null;
                }
                aVar = new com.bytedance.pangle.f.a.a();
                try {
                    java.io.InputStream inputStream = zipFile2.getInputStream(entry);
                    aVar.a();
                    if (inputStream != null) {
                        aVar.b = new com.bytedance.pangle.f.a.b(inputStream);
                    }
                    do {
                        b = aVar.b();
                        if (b == 1) {
                            com.bytedance.pangle.log.ZeusLogger.errReport(com.bytedance.pangle.log.ZeusLogger.TAG_INSTALL, "已达到END_DOCUMENT");
                            try {
                                aVar.a();
                            } catch (java.lang.Throwable unused) {
                            }
                            com.bytedance.pangle.util.g.a(zipFile2);
                            return null;
                        }
                    } while (b != 2);
                    int length = aVar.a != 2 ? -1 : aVar.c.length / 5;
                    java.lang.String str = null;
                    java.lang.String str2 = null;
                    for (int i2 = 0; i2 != length; i2++) {
                        if (com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_VERSION_CODE.equals(aVar.a(i2))) {
                            str = a(aVar, i2);
                        } else if ("package".equals(aVar.a(i2))) {
                            str2 = a(aVar, i2);
                        }
                    }
                    try {
                        i = java.lang.Integer.parseInt(str);
                    } catch (java.lang.Throwable unused2) {
                        i = -1;
                    }
                    if (i == -1) {
                        com.bytedance.pangle.log.ZeusLogger.errReport(com.bytedance.pangle.log.ZeusLogger.TAG_INSTALL, "versionCode获取失败:".concat(java.lang.String.valueOf(str)));
                        try {
                            aVar.a();
                        } catch (java.lang.Throwable unused3) {
                        }
                        com.bytedance.pangle.util.g.a(zipFile2);
                        return null;
                    }
                    com.bytedance.pangle.f.a.e eVar = new com.bytedance.pangle.f.a.e(str2, i);
                    try {
                        aVar.a();
                    } catch (java.lang.Throwable unused4) {
                    }
                    com.bytedance.pangle.util.g.a(zipFile2);
                    return eVar;
                } catch (java.lang.Throwable th) {
                    th = th;
                    java.lang.Throwable th2 = th;
                    zipFile = zipFile2;
                    th = th2;
                    try {
                        android.content.pm.PackageInfo packageArchiveInfo = com.bytedance.pangle.Zeus.getAppApplication().getPackageManager().getPackageArchiveInfo(file.getPath(), 0);
                        if (packageArchiveInfo == null) {
                            com.bytedance.pangle.log.ZeusLogger.errReport(com.bytedance.pangle.log.ZeusLogger.TAG_INSTALL, "packageArchiveInfo == null", th);
                            return null;
                        }
                        com.bytedance.pangle.f.a.e eVar2 = new com.bytedance.pangle.f.a.e(packageArchiveInfo.packageName, packageArchiveInfo.versionCode);
                        if (aVar != null) {
                            try {
                                aVar.a();
                            } catch (java.lang.Throwable unused5) {
                            }
                        }
                        com.bytedance.pangle.util.g.a(zipFile);
                        return eVar2;
                    } finally {
                        if (aVar != null) {
                            try {
                                aVar.a();
                            } catch (java.lang.Throwable unused6) {
                            }
                        }
                        com.bytedance.pangle.util.g.a(zipFile);
                    }
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
                aVar = null;
            }
        } catch (java.lang.Throwable th4) {
            th = th4;
            zipFile = null;
            aVar = null;
        }
    }

    private static java.lang.String a(int i) {
        return (i >>> 24) == 1 ? "android:" : "";
    }

    private static java.lang.String a(com.bytedance.pangle.f.a.a aVar, int i) {
        int b = aVar.b(i);
        int c = aVar.c(i);
        return b == 3 ? aVar.d(i) : b == 2 ? java.lang.String.format("?%s%08X", a(c), java.lang.Integer.valueOf(c)) : (b < 16 || b > 31) ? java.lang.String.format("<0x%X, type 0x%02X>", java.lang.Integer.valueOf(c), java.lang.Integer.valueOf(b)) : java.lang.String.valueOf(c);
    }
}
