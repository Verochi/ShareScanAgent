package com.qq.e.comm.managers.plugin;

/* loaded from: classes19.dex */
class b {
    private static volatile java.lang.String a;

    public static synchronized java.lang.String a(android.content.Context context) {
        android.app.ActivityManager.RunningAppProcessInfo next;
        java.lang.String processName;
        synchronized (com.qq.e.comm.managers.plugin.b.class) {
            if (!android.text.TextUtils.isEmpty(a)) {
                return a;
            }
            if (android.os.Build.VERSION.SDK_INT >= 28) {
                processName = android.app.Application.getProcessName();
                a = processName;
                return a;
            }
            int myPid = android.os.Process.myPid();
            java.util.List<android.app.ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((android.app.ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses != null) {
                java.util.Iterator<android.app.ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                while (it.hasNext()) {
                    try {
                        next = it.next();
                    } catch (java.lang.Exception unused) {
                    }
                    if (next.pid == myPid) {
                        a = next.processName;
                        return a;
                    }
                    continue;
                }
            }
            return null;
        }
    }

    public static synchronized java.lang.String a(java.lang.String str) {
        java.lang.String str2;
        synchronized (com.qq.e.comm.managers.plugin.b.class) {
            if (android.text.TextUtils.isEmpty(str)) {
                return str;
            }
            java.lang.String str3 = a;
            if (android.text.TextUtils.isEmpty(str3)) {
                return str;
            }
            boolean endsWith = str3.endsWith("_");
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(str);
            sb.append(endsWith ? "" : "_");
            try {
                str2 = new java.lang.String(str3);
                try {
                    str2 = com.qq.e.comm.managers.plugin.d.a(java.security.MessageDigest.getInstance("MD5").digest(str2.getBytes("UTF-8")));
                } catch (java.lang.Exception unused) {
                }
            } catch (java.lang.Exception unused2) {
                str2 = null;
            }
            sb.append(str2);
            return sb.toString();
        }
    }

    public static void a(android.content.Context context, java.io.File file, java.io.File file2) throws java.lang.Throwable {
        java.io.InputStream inputStream;
        java.lang.String str;
        java.io.FileOutputStream fileOutputStream;
        java.io.InputStream inputStream2;
        boolean z;
        android.content.res.AssetManager assets = context.getAssets();
        java.io.FileOutputStream fileOutputStream2 = null;
        try {
            com.qq.e.comm.managers.plugin.h.a();
            java.lang.String[] list = assets.list("gdt_plugin");
            if (java.util.Arrays.binarySearch(list, "gdtadv2.jar") < 0) {
                if (list != null && list.length > 0) {
                    str = android.text.TextUtils.join(",", list);
                    java.lang.String str2 = "Asset Error " + str;
                    com.qq.e.comm.util.GDTLogger.e(str2);
                    throw new java.lang.Exception(str2);
                }
                str = "no asset";
                java.lang.String str22 = "Asset Error " + str;
                com.qq.e.comm.util.GDTLogger.e(str22);
                throw new java.lang.Exception(str22);
            }
            java.lang.String str3 = "gdt_plugin" + java.io.File.separator + "gdtadv2.jar";
            java.lang.String str4 = com.qq.e.comm.constants.Sig.ASSET_PLUGIN_SIG;
            if (str4 == null) {
                str4 = "";
            }
            com.qq.e.comm.managers.plugin.h.a(context);
            com.qq.e.comm.managers.plugin.h.a(com.qq.e.comm.managers.status.SDKStatus.getBuildInPluginVersion() + "#####" + str4, file2);
            if (android.text.TextUtils.isEmpty(com.qq.e.comm.constants.CustomPkgConstants.getAssetPluginXorKey())) {
                z = com.qq.e.comm.managers.plugin.h.a(assets.open(str3), file);
                inputStream2 = null;
            } else {
                inputStream = assets.open(str3);
                try {
                    if (!file.canWrite()) {
                        file.setWritable(true);
                    }
                    fileOutputStream = new java.io.FileOutputStream(file);
                } catch (java.lang.Throwable th) {
                    th = th;
                }
                try {
                    byte[] bytes = com.qq.e.comm.constants.CustomPkgConstants.getAssetPluginXorKey().getBytes(java.nio.charset.Charset.forName("UTF-8"));
                    byte[] bArr = new byte[1024];
                    int length = bytes.length;
                    int i = 0;
                    int i2 = 0;
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        int i3 = 0;
                        while (i3 < read) {
                            int i4 = i2 + 1;
                            if (i2 >= 64) {
                                bArr[i3] = (byte) (bytes[i % length] ^ bArr[i3]);
                                i++;
                            }
                            i3++;
                            i2 = i4;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream2 = fileOutputStream;
                    inputStream2 = inputStream;
                    z = true;
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    fileOutputStream2 = fileOutputStream;
                    try {
                        com.qq.e.comm.util.GDTLogger.e("插件加载失败", th);
                        throw th;
                    } catch (java.lang.Throwable th3) {
                        a(inputStream);
                        a(fileOutputStream2);
                        throw th3;
                    }
                }
            }
            if (z) {
                try {
                    z = com.qq.e.comm.managers.plugin.h.a(file, context);
                } catch (java.lang.Throwable th4) {
                    th = th4;
                    inputStream = inputStream2;
                    com.qq.e.comm.util.GDTLogger.e("插件加载失败", th);
                    throw th;
                }
            }
            a(inputStream2);
            a(fileOutputStream2);
            if (!z) {
                throw new java.lang.Exception("Plugin prepare failed");
            }
        } catch (java.lang.Throwable th5) {
            th = th5;
            inputStream = null;
        }
    }

    private static void a(java.io.Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (java.io.IOException unused) {
            }
        }
    }
}
