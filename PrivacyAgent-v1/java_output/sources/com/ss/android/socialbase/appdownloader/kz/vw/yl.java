package com.ss.android.socialbase.appdownloader.kz.vw;

/* loaded from: classes19.dex */
public class yl {
    public static android.content.pm.PackageInfo vw(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.io.File file, int i) {
        if (com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode.isSwitchEnable(268435456) && android.os.Build.VERSION.SDK_INT < 26) {
            try {
                return vw(file);
            } catch (java.lang.Throwable th) {
                vw("getPackageInfo::unzip_getpackagearchiveinfo", th.getMessage());
            }
        }
        return wg(context, file, i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:147:0x0068, code lost:
    
        r13 = r1.getInputStream(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x006c, code lost:
    
        r4 = r1;
        r5 = r2;
        r1 = null;
        r13 = r13;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static android.content.pm.PackageInfo vw(@androidx.annotation.NonNull java.io.File file) {
        java.io.InputStream inputStream;
        ?? r2;
        java.util.zip.ZipFile zipFile;
        java.io.InputStream inputStream2;
        java.util.zip.ZipFile zipFile2;
        java.util.zip.ZipEntry zipEntry;
        java.util.zip.ZipInputStream zipInputStream;
        java.io.InputStream inputStream3;
        java.util.zip.ZipFile zipFile3;
        java.util.zip.ZipInputStream zipInputStream2;
        int wg;
        long j;
        com.ss.android.socialbase.appdownloader.kz.vw.vw vwVar = null;
        vwVar = null;
        java.lang.String str = null;
        vwVar = null;
        vwVar = null;
        try {
            if (android.os.Build.VERSION.SDK_INT >= 24) {
                java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
                try {
                    java.util.zip.ZipInputStream zipInputStream3 = new java.util.zip.ZipInputStream(fileInputStream);
                    while (true) {
                        java.util.zip.ZipEntry nextEntry = zipInputStream3.getNextEntry();
                        if (nextEntry == null) {
                            zipFile3 = null;
                            zipEntry = nextEntry;
                            r2 = fileInputStream;
                            zipInputStream2 = zipInputStream3;
                            inputStream3 = null;
                            break;
                        }
                        if (!nextEntry.isDirectory()) {
                            if ("AndroidManifest.xml".equals(nextEntry.getName())) {
                                zipFile3 = null;
                                zipEntry = nextEntry;
                                r2 = fileInputStream;
                                zipInputStream2 = zipInputStream3;
                                inputStream3 = zipInputStream3;
                                break;
                            }
                            zipInputStream3.closeEntry();
                        } else {
                            try {
                                zipInputStream3.closeEntry();
                            } catch (java.lang.Throwable unused) {
                            }
                        }
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    zipFile = null;
                    r2 = fileInputStream;
                    inputStream = null;
                    try {
                        throw new com.ss.android.socialbase.appdownloader.kz.vw.t("throwable: " + th.getMessage() + th.toString());
                    } finally {
                    }
                }
            } else {
                java.util.zip.ZipFile zipFile4 = new java.util.zip.ZipFile(file);
                try {
                    java.util.Enumeration<? extends java.util.zip.ZipEntry> entries = zipFile4.entries();
                    java.util.zip.ZipEntry zipEntry2 = null;
                    while (true) {
                        if (!entries.hasMoreElements()) {
                            inputStream2 = null;
                            zipFile2 = zipFile4;
                            zipEntry = zipEntry2;
                            zipInputStream = null;
                            break;
                        }
                        zipEntry2 = entries.nextElement();
                        if (!zipEntry2.isDirectory() && "AndroidManifest.xml".equals(zipEntry2.getName())) {
                            break;
                        }
                    }
                    r2 = zipInputStream;
                    zipInputStream2 = zipInputStream;
                    zipFile3 = zipFile2;
                    inputStream3 = inputStream2;
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    r2 = null;
                    zipFile = zipFile4;
                    inputStream = null;
                    throw new com.ss.android.socialbase.appdownloader.kz.vw.t("throwable: " + th.getMessage() + th.toString());
                }
            }
            if (zipEntry != null) {
                try {
                    if ("AndroidManifest.xml".equals(zipEntry.getName())) {
                        com.ss.android.socialbase.appdownloader.kz.vw.vw vwVar2 = new com.ss.android.socialbase.appdownloader.kz.vw.vw();
                        try {
                            vwVar2.vw(inputStream3);
                            do {
                                wg = vwVar2.wg();
                                if (wg == 1) {
                                    throw new com.ss.android.socialbase.appdownloader.kz.vw.t("已达到END_DOCUMENT");
                                }
                            } while (wg != 2);
                            int yl = vwVar2.yl();
                            java.lang.String str2 = null;
                            java.lang.String str3 = null;
                            for (int i = 0; i != yl; i++) {
                                if (com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_VERSION_NAME.equals(vwVar2.vw(i))) {
                                    str2 = vw(vwVar2, i);
                                } else if (com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_VERSION_CODE.equals(vwVar2.vw(i))) {
                                    str = vw(vwVar2, i);
                                } else if ("package".equals(vwVar2.vw(i))) {
                                    str3 = vw(vwVar2, i);
                                }
                            }
                            try {
                                j = java.lang.Long.parseLong(str);
                            } catch (com.ss.android.socialbase.appdownloader.kz.vw.t unused2) {
                                j = -1;
                            }
                            if (j == -1) {
                                throw new com.ss.android.socialbase.appdownloader.kz.vw.t("versionCode获取失败: ".concat(java.lang.String.valueOf(str)));
                            }
                            android.content.pm.PackageInfo packageInfo = new android.content.pm.PackageInfo();
                            packageInfo.versionName = str2;
                            packageInfo.versionCode = (int) j;
                            packageInfo.packageName = str3;
                            if (zipInputStream2 != null) {
                                try {
                                    zipInputStream2.closeEntry();
                                } catch (java.lang.Throwable unused3) {
                                }
                            }
                            try {
                                vwVar2.vw();
                            } catch (java.lang.Throwable unused4) {
                            }
                            if (inputStream3 != null) {
                                try {
                                    inputStream3.close();
                                } catch (java.lang.Throwable unused5) {
                                }
                            }
                            if (zipFile3 != null) {
                                try {
                                    zipFile3.close();
                                } catch (java.lang.Throwable unused6) {
                                }
                            }
                            if (r2 != null) {
                                try {
                                    r2.close();
                                } catch (java.lang.Throwable unused7) {
                                }
                            }
                            return packageInfo;
                        } catch (java.lang.Throwable th3) {
                            inputStream = inputStream3;
                            th = th3;
                            vwVar = vwVar2;
                            zipFile = zipFile3;
                            throw new com.ss.android.socialbase.appdownloader.kz.vw.t("throwable: " + th.getMessage() + th.toString());
                        }
                    }
                } catch (java.lang.Throwable th4) {
                    inputStream = inputStream3;
                    th = th4;
                    zipFile = zipFile3;
                }
            }
            throw new com.ss.android.socialbase.appdownloader.kz.vw.t("没有找到AndroidManifest.xml entry");
        } catch (java.lang.Throwable th5) {
            th = th5;
            inputStream = vwVar;
            r2 = inputStream;
            zipFile = r2;
        }
    }

    private static java.lang.String vw(int i) {
        return (i >>> 24) == 1 ? "android:" : "";
    }

    public static java.lang.String vw(android.content.Context context, android.content.pm.PackageInfo packageInfo, java.lang.String str) {
        android.content.pm.ApplicationInfo applicationInfo;
        if (packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null) {
            return null;
        }
        applicationInfo.sourceDir = str;
        applicationInfo.publicSourceDir = str;
        try {
            return applicationInfo.loadLabel(context.getPackageManager()).toString();
        } catch (java.lang.OutOfMemoryError e) {
            vw("getPackageInfo::fail_load_label", e.getMessage());
            return null;
        }
    }

    private static java.lang.String vw(com.ss.android.socialbase.appdownloader.kz.vw.vw vwVar, int i) {
        int wg = vwVar.wg(i);
        int t = vwVar.t(i);
        return wg == 3 ? vwVar.v(i) : wg == 2 ? java.lang.String.format("?%s%08X", vw(t), java.lang.Integer.valueOf(t)) : (wg < 16 || wg > 31) ? java.lang.String.format("<0x%X, type 0x%02X>", java.lang.Integer.valueOf(t), java.lang.Integer.valueOf(wg)) : java.lang.String.valueOf(t);
    }

    private static void vw(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull java.lang.String str2) {
        com.ss.android.socialbase.downloader.monitor.IDownloadMonitorListener downloadMonitorListener = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getDownloadMonitorListener();
        if (downloadMonitorListener == null) {
            return;
        }
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("message", str2);
        } catch (org.json.JSONException unused) {
        }
        downloadMonitorListener.monitorEvent(str, jSONObject, null, null);
    }

    private static android.content.pm.PackageInfo wg(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.io.File file, int i) {
        android.content.pm.PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            vw("unzip_getpackagearchiveinfo", "packageManager == null");
            return null;
        }
        try {
            return packageManager.getPackageArchiveInfo(file.getPath(), i);
        } catch (java.lang.Throwable th) {
            vw("unzip_getpackagearchiveinfo", "pm.getPackageArchiveInfo failed: " + th.getMessage());
            return null;
        }
    }
}
