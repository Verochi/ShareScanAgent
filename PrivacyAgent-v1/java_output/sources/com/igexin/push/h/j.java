package com.igexin.push.h;

/* loaded from: classes23.dex */
public final class j {
    public static java.lang.String a = null;
    public static java.lang.String b = null;
    public static java.lang.String c = null;
    public static java.lang.String d = null;
    public static java.lang.String e = null;
    public static java.lang.String f = null;
    public static java.lang.String g = null;
    private static final java.lang.String h = "FileUtils";
    private static final java.lang.Object i = new java.lang.Object();
    private static java.lang.String j;

    /* renamed from: com.igexin.push.h.j$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.io.FileFilter {
        final long a = java.lang.System.currentTimeMillis();
        final long b = 604800000;

        @Override // java.io.FileFilter
        public final boolean accept(java.io.File file) {
            return this.a - file.lastModified() >= 604800000;
        }
    }

    /* renamed from: com.igexin.push.h.j$2, reason: invalid class name */
    public static class AnonymousClass2 implements java.io.FileFilter {
        final long a = java.lang.System.currentTimeMillis();
        final long b = 604800000;

        @Override // java.io.FileFilter
        public final boolean accept(java.io.File file) {
            return this.a - file.lastModified() >= 604800000;
        }
    }

    public static void a() {
        try {
            java.lang.String packageName = com.igexin.push.core.e.l.getPackageName();
            b = "/sdcard/libs/" + packageName + com.umeng.analytics.process.a.d;
            c = "/sdcard/libs/com.igexin.sdk.deviceId.db";
            a = "/sdcard/libs/" + packageName + ".properties";
            d = "/sdcard/libs/" + packageName + ".bin";
            e = com.igexin.push.core.e.l.getFilesDir().getPath() + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + packageName + ".properties";
            g = com.igexin.push.core.e.l.getFilesDir().getPath() + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + packageName + "-guard.properties";
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(com.igexin.push.core.e.l.getCacheDir());
            sb.append("/ImgCache/");
            f = sb.toString();
            j = "/sdcard/libs/com.getui.sdk.deviceId.db";
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    private static void a(java.io.File file) {
        java.io.File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (java.io.File file2 : listFiles) {
                while (file2.exists()) {
                    if (file2.isFile()) {
                        file2.delete();
                    } else if (!file2.delete()) {
                        a(file2);
                    }
                }
            }
        }
        file.delete();
    }

    public static void a(byte[] bArr, java.lang.String str) {
        java.io.FileOutputStream fileOutputStream = null;
        try {
            try {
                if (!str.startsWith("/sdcard/libs") || k()) {
                    java.io.File file = new java.io.File(str);
                    if (b(file)) {
                        java.io.FileOutputStream fileOutputStream2 = new java.io.FileOutputStream(file, false);
                        try {
                            fileOutputStream2.write(bArr);
                            try {
                                fileOutputStream2.close();
                            } catch (java.lang.Exception e2) {
                                com.igexin.c.a.c.a.a(e2);
                            }
                        } catch (java.lang.Exception e3) {
                            e = e3;
                            fileOutputStream = fileOutputStream2;
                            com.igexin.c.a.c.a.a(e);
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (java.lang.Exception e4) {
                                    com.igexin.c.a.c.a.a(e4);
                                }
                            }
                        } catch (java.lang.Throwable th) {
                            th = th;
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (java.lang.Exception e5) {
                                    com.igexin.c.a.c.a.a(e5);
                                }
                            }
                            throw th;
                        }
                    }
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (java.lang.Exception e6) {
            e = e6;
        }
    }

    public static boolean a(android.content.Context context) {
        return (new java.io.File(context.getFilesDir().getAbsolutePath(), com.igexin.push.core.d.d.a).exists() || new com.igexin.sdk.main.SdkInitSwitch(context).isSwitchOn()) ? false : true;
    }

    private static byte[] a(java.lang.String str) {
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        java.io.FileInputStream fileInputStream;
        java.io.FileInputStream fileInputStream2 = null;
        byte[] bArr = null;
        if (!new java.io.File(str).exists()) {
            com.igexin.c.a.c.a.a(h, "get data from file = " + str + " file not exist ######");
            com.igexin.c.a.c.a.a("FileUtils|get data from file = " + str + " file not exist ######", new java.lang.Object[0]);
            return null;
        }
        if (!c(new java.io.File(str))) {
            return null;
        }
        byte[] bArr2 = new byte[1024];
        try {
            fileInputStream = new java.io.FileInputStream(str);
        } catch (java.lang.Exception e2) {
            e = e2;
            byteArrayOutputStream = null;
            fileInputStream = null;
        } catch (java.lang.Throwable th) {
            th = th;
            byteArrayOutputStream = null;
            com.getui.gtc.base.util.io.IOUtils.safeClose(fileInputStream2);
            com.getui.gtc.base.util.io.IOUtils.safeClose(byteArrayOutputStream);
            throw th;
        }
        try {
            byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            while (true) {
                try {
                    try {
                        int read = fileInputStream.read(bArr2);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (java.lang.Exception e3) {
                        e = e3;
                        com.igexin.c.a.c.a.a(e);
                        com.igexin.c.a.c.a.a("FileUtils|" + e.toString(), new java.lang.Object[0]);
                        com.getui.gtc.base.util.io.IOUtils.safeClose(fileInputStream);
                        com.getui.gtc.base.util.io.IOUtils.safeClose(byteArrayOutputStream);
                        return bArr;
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    fileInputStream2 = fileInputStream;
                    com.getui.gtc.base.util.io.IOUtils.safeClose(fileInputStream2);
                    com.getui.gtc.base.util.io.IOUtils.safeClose(byteArrayOutputStream);
                    throw th;
                }
            }
            bArr = byteArrayOutputStream.toByteArray();
        } catch (java.lang.Exception e4) {
            e = e4;
            byteArrayOutputStream = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
            fileInputStream2 = fileInputStream;
            com.getui.gtc.base.util.io.IOUtils.safeClose(fileInputStream2);
            com.getui.gtc.base.util.io.IOUtils.safeClose(byteArrayOutputStream);
            throw th;
        }
        com.getui.gtc.base.util.io.IOUtils.safeClose(fileInputStream);
        com.getui.gtc.base.util.io.IOUtils.safeClose(byteArrayOutputStream);
        return bArr;
    }

    public static java.lang.String b(android.content.Context context) {
        return context.getExternalFilesDir("gtpush") + "/log/";
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
    
        if (r1.canRead() == false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static java.lang.String b(java.lang.String str) {
        java.lang.Exception e2;
        java.lang.String str2;
        try {
            str2 = f + com.igexin.assist.util.a.a(str) + ".bin";
        } catch (java.lang.Exception e3) {
            e2 = e3;
            str2 = "";
        }
        try {
            java.io.File file = new java.io.File(str2);
            if (file.exists()) {
            }
            if (com.igexin.push.core.e.l.getPackageManager().checkPermission(com.anythink.china.common.d.b, com.igexin.push.core.e.l.getPackageName()) == 0) {
                return "";
            }
            f = com.igexin.push.core.e.l.getCacheDir() + "/ImgCache/";
            return "";
        } catch (java.lang.Exception e4) {
            e2 = e4;
            com.igexin.c.a.c.a.a(e2);
            return str2;
        }
    }

    public static void b() {
        if (!k()) {
            com.igexin.c.a.c.a.a("FileUtils | save session to file no permission , v-" + android.os.Build.VERSION.SDK_INT, new java.lang.Object[0]);
            return;
        }
        java.io.FileOutputStream fileOutputStream = null;
        try {
            try {
                java.io.File file = new java.io.File(b);
                if (!file.exists() && !file.createNewFile()) {
                    com.igexin.c.a.c.a.a("FileUtils | create file : " + file.toString() + " failed !!!", new java.lang.Object[0]);
                    return;
                }
                java.io.FileOutputStream fileOutputStream2 = new java.io.FileOutputStream(b);
                try {
                    java.lang.String str = com.igexin.push.config.c.w + com.igexin.push.h.n.c();
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append(str);
                    sb.append(com.igexin.push.core.e.z);
                    sb.append("|");
                    sb.append(com.igexin.push.core.e.a);
                    sb.append("|");
                    sb.append(com.igexin.push.core.e.A);
                    sb.append("|");
                    com.igexin.push.core.ServiceManager.getInstance();
                    sb.append(com.igexin.push.core.ServiceManager.d(com.igexin.push.core.e.l));
                    fileOutputStream2.write(com.igexin.c.a.a.a.b(sb.toString().getBytes(), com.igexin.push.core.e.M));
                    try {
                        fileOutputStream2.close();
                    } catch (java.io.IOException e2) {
                        com.igexin.c.a.c.a.a(e2);
                    }
                } catch (java.lang.Exception e3) {
                    e = e3;
                    fileOutputStream = fileOutputStream2;
                    com.igexin.c.a.c.a.a(e);
                    com.igexin.c.a.c.a.a("FileUtils | " + e.toString(), new java.lang.Object[0]);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (java.io.IOException e4) {
                            com.igexin.c.a.c.a.a(e4);
                        }
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (java.io.IOException e5) {
                            com.igexin.c.a.c.a.a(e5);
                        }
                    }
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (java.lang.Exception e6) {
            e = e6;
        }
    }

    private static boolean b(java.io.File file) {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            return file.canWrite();
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x004d, code lost:
    
        if (r0.equals(com.igexin.push.core.b.m) != false) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String c() {
        byte[] a2;
        java.lang.String str = null;
        if (!p()) {
            com.igexin.c.a.c.a.a("FileUtils | read file cid no permission , v-" + android.os.Build.VERSION.SDK_INT, new java.lang.Object[0]);
            return null;
        }
        try {
            a2 = a(b);
        } catch (java.lang.Exception e2) {
            e = e2;
        }
        if (a2 == null) {
            com.igexin.c.a.c.a.a("FileUtils | read file cid id = null", new java.lang.Object[0]);
            return null;
        }
        java.lang.String[] split = new java.lang.String(com.igexin.c.a.a.a.a(a2, com.igexin.push.core.e.M)).split("\\|");
        if (split.length > 2) {
            java.lang.String str2 = split[2];
            if (str2 != null) {
                try {
                } catch (java.lang.Exception e3) {
                    str = str2;
                    e = e3;
                    com.igexin.c.a.c.a.a(e);
                    com.igexin.c.a.c.a.a("FileUtils|get cid from file cid = ".concat(java.lang.String.valueOf(str)), new java.lang.Object[0]);
                    return str;
                }
            }
            str = str2;
        }
        com.igexin.c.a.c.a.a("FileUtils|get cid from file cid = ".concat(java.lang.String.valueOf(str)), new java.lang.Object[0]);
        return str;
    }

    private static void c(java.lang.String str) {
        if (!k()) {
            com.igexin.c.a.c.a.a("FileUtils | saveDeviceIdToNewFile no permission , v-" + android.os.Build.VERSION.SDK_INT, new java.lang.Object[0]);
            return;
        }
        com.igexin.c.a.c.a.a("FileUtils|save deviceId = " + str + " to " + j, new java.lang.Object[0]);
        java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock writeLock = new java.util.concurrent.locks.ReentrantReadWriteLock().writeLock();
        java.io.FileOutputStream fileOutputStream = null;
        try {
            try {
                if (writeLock.tryLock()) {
                    java.io.File file = new java.io.File(j);
                    if (!file.exists() && !file.createNewFile()) {
                        com.igexin.c.a.c.a.a("FileUtils|create file " + file.toString() + " failed", new java.lang.Object[0]);
                        com.igexin.c.a.b.g.a((java.io.Closeable) null);
                        writeLock.unlock();
                        return;
                    }
                    java.io.FileOutputStream fileOutputStream2 = new java.io.FileOutputStream(j);
                    try {
                        fileOutputStream2.write(com.igexin.c.b.a.b("V1|".concat(java.lang.String.valueOf(str)).getBytes("utf-8")));
                        fileOutputStream = fileOutputStream2;
                    } catch (java.lang.Exception e2) {
                        e = e2;
                        fileOutputStream = fileOutputStream2;
                        com.igexin.c.a.c.a.a(e);
                        com.igexin.c.a.c.a.a("FileUtils|" + e.toString(), new java.lang.Object[0]);
                        com.igexin.c.a.b.g.a(fileOutputStream);
                        writeLock.unlock();
                        return;
                    } catch (java.lang.Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        com.igexin.c.a.b.g.a(fileOutputStream);
                        writeLock.unlock();
                        throw th;
                    }
                }
                com.igexin.c.a.b.g.a(fileOutputStream);
                writeLock.unlock();
            } catch (java.lang.Exception e3) {
                e = e3;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    private static boolean c(java.io.File file) {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            return file.canRead();
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return false;
        }
    }

    public static java.lang.String d() {
        java.lang.String str = null;
        if (!k()) {
            com.igexin.c.a.c.a.a("FileUtils | get device id from file no permission , v-" + android.os.Build.VERSION.SDK_INT, new java.lang.Object[0]);
            return null;
        }
        try {
            com.igexin.c.a.c.a.a("FileUtils|get device id from file : " + c, new java.lang.Object[0]);
            byte[] a2 = a(c);
            if (a2 == null) {
                com.igexin.c.a.c.a.a(h, "read file device id = null");
                com.igexin.c.a.c.a.a("FileUtils|read file device id = null", new java.lang.Object[0]);
                return null;
            }
            java.lang.String str2 = new java.lang.String(a2, "utf-8");
            try {
                com.igexin.c.a.c.a.a("FileUtils|read file device id = ".concat(str2), new java.lang.Object[0]);
                return str2;
            } catch (java.lang.Exception e2) {
                e = e2;
                str = str2;
                com.igexin.c.a.c.a.a(e);
                com.igexin.c.a.c.a.a("FileUtils|get device id from file : " + e.toString(), new java.lang.Object[0]);
                return str;
            }
        } catch (java.lang.Exception e3) {
            e = e3;
        }
    }

    private static void d(java.lang.String str) {
        try {
            com.igexin.push.core.e.f.a().a(str);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    public static long e() {
        byte[] a2;
        long j2 = 0;
        if (!p()) {
            com.igexin.c.a.c.a.a("FileUtils | get session from file no permission , v-" + android.os.Build.VERSION.SDK_INT, new java.lang.Object[0]);
            return 0L;
        }
        try {
            a2 = a(b);
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a(h, e2.toString());
            com.igexin.c.a.c.a.a("FileUtils|" + e2.toString(), new java.lang.Object[0]);
        }
        if (a2 == null) {
            com.igexin.c.a.c.a.a(h, "read session from file, not exist");
            com.igexin.c.a.c.a.a("FileUtils|read session from file, not exist", new java.lang.Object[0]);
            return 0L;
        }
        java.lang.String str = new java.lang.String(com.igexin.c.a.a.a.a(a2, com.igexin.push.core.e.M));
        java.lang.String substring = str.contains(com.igexin.push.core.b.m) ? str.substring(7) : str.substring(20);
        int indexOf = substring.indexOf("|");
        if (indexOf >= 0) {
            substring = substring.substring(0, indexOf);
        }
        long parseLong = java.lang.Long.parseLong(substring);
        if (parseLong != 0) {
            j2 = parseLong;
        }
        com.igexin.c.a.c.a.a("FileUtils|session : ".concat(java.lang.String.valueOf(j2)), new java.lang.Object[0]);
        return j2;
    }

    public static void f() {
        if (com.igexin.push.core.e.H == null) {
            return;
        }
        if (!k()) {
            com.igexin.c.a.c.a.a("FileUtils | save device id to file no permission , v-" + android.os.Build.VERSION.SDK_INT, new java.lang.Object[0]);
            return;
        }
        com.igexin.c.a.c.a.a("FileUtils|save device id to file : " + c, new java.lang.Object[0]);
        java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock writeLock = new java.util.concurrent.locks.ReentrantReadWriteLock().writeLock();
        java.io.FileOutputStream fileOutputStream = null;
        try {
            try {
                if (writeLock.tryLock()) {
                    java.io.File file = new java.io.File(c);
                    if (!file.exists() && !file.createNewFile()) {
                        com.igexin.c.a.c.a.a("FileUtils|create file : " + file.toString() + " failed !!!", new java.lang.Object[0]);
                        writeLock.unlock();
                        return;
                    }
                    java.io.FileOutputStream fileOutputStream2 = new java.io.FileOutputStream(c);
                    try {
                        byte[] bytes = com.igexin.push.core.e.H.getBytes("utf-8");
                        new java.lang.String(bytes, "utf-8");
                        fileOutputStream2.write(bytes);
                        fileOutputStream = fileOutputStream2;
                    } catch (java.lang.Exception e2) {
                        e = e2;
                        fileOutputStream = fileOutputStream2;
                        com.igexin.c.a.c.a.a(e);
                        com.igexin.c.a.c.a.a("FileUtils|" + e.toString(), new java.lang.Object[0]);
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (java.io.IOException e3) {
                                com.igexin.c.a.c.a.a(e3);
                            }
                        }
                        writeLock.unlock();
                        return;
                    } catch (java.lang.Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (java.io.IOException e4) {
                                com.igexin.c.a.c.a.a(e4);
                            }
                        }
                        writeLock.unlock();
                        throw th;
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (java.io.IOException e5) {
                        com.igexin.c.a.c.a.a(e5);
                    }
                }
                writeLock.unlock();
            } catch (java.lang.Exception e6) {
                e = e6;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    public static void g() {
        byte[] bytes = com.igexin.push.core.e.A.getBytes();
        byte[] bArr = new byte[bytes.length];
        for (int i2 = 0; i2 < bytes.length; i2++) {
            bArr[i2] = (byte) (bytes[i2] ^ com.igexin.push.core.e.ad[i2]);
        }
        com.igexin.push.core.d.d.a().a("c", android.util.Base64.encodeToString(bArr, 0));
    }

    public static void h() {
        java.io.File[] listFiles;
        java.io.File file = new java.io.File(f);
        if (file.exists() && (listFiles = file.listFiles(new com.igexin.push.h.j.AnonymousClass1())) != null) {
            for (java.io.File file2 : listFiles) {
                file2.delete();
            }
        }
    }

    public static void i() {
        java.io.File[] listFiles;
        if (k()) {
            java.io.File file = new java.io.File(com.getui.gtc.base.GtcProvider.getSdcardPath() + "/Sdk/WebCache/");
            if (file.exists() && (listFiles = file.listFiles(new com.igexin.push.h.j.AnonymousClass2())) != null) {
                for (java.io.File file2 : listFiles) {
                    if (file2.exists()) {
                        a(file2);
                    }
                }
            }
        }
    }

    public static void j() {
        if (!k()) {
            com.igexin.c.a.c.a.a("FileUtilsupdateDeviceId no permission , v-" + android.os.Build.VERSION.SDK_INT, new java.lang.Object[0]);
            return;
        }
        java.lang.String n = n();
        java.lang.String str = com.igexin.push.core.e.a;
        com.igexin.c.a.c.a.a("FileUtils|read deviceId.db = " + n + "; CoreRuntimeInfo.deviceId = " + com.igexin.push.core.e.H, new java.lang.Object[0]);
        if (n != null) {
            if (n.equals(com.igexin.push.core.e.H)) {
                return;
            }
            com.igexin.push.core.e.H = n;
            try {
                com.igexin.push.core.e.f.a().a(n);
                return;
            } catch (java.lang.Throwable th) {
                com.igexin.c.a.c.a.a(th);
                return;
            }
        }
        java.lang.String str2 = com.igexin.push.core.e.H;
        if (str2 == null) {
            return;
        }
        if (!k()) {
            com.igexin.c.a.c.a.a("FileUtils | saveDeviceIdToNewFile no permission , v-" + android.os.Build.VERSION.SDK_INT, new java.lang.Object[0]);
            return;
        }
        com.igexin.c.a.c.a.a("FileUtils|save deviceId = " + str2 + " to " + j, new java.lang.Object[0]);
        java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock writeLock = new java.util.concurrent.locks.ReentrantReadWriteLock().writeLock();
        java.io.FileOutputStream fileOutputStream = null;
        try {
            try {
                if (writeLock.tryLock()) {
                    java.io.File file = new java.io.File(j);
                    if (!file.exists() && !file.createNewFile()) {
                        com.igexin.c.a.c.a.a("FileUtils|create file " + file.toString() + " failed", new java.lang.Object[0]);
                        com.igexin.c.a.b.g.a((java.io.Closeable) null);
                        writeLock.unlock();
                        return;
                    }
                    java.io.FileOutputStream fileOutputStream2 = new java.io.FileOutputStream(j);
                    try {
                        fileOutputStream2.write(com.igexin.c.b.a.b("V1|".concat(java.lang.String.valueOf(str2)).getBytes("utf-8")));
                        fileOutputStream = fileOutputStream2;
                    } catch (java.lang.Exception e2) {
                        e = e2;
                        fileOutputStream = fileOutputStream2;
                        com.igexin.c.a.c.a.a(e);
                        com.igexin.c.a.c.a.a("FileUtils|" + e.toString(), new java.lang.Object[0]);
                        com.igexin.c.a.b.g.a(fileOutputStream);
                        writeLock.unlock();
                        return;
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        fileOutputStream = fileOutputStream2;
                        com.igexin.c.a.b.g.a(fileOutputStream);
                        writeLock.unlock();
                        throw th;
                    }
                }
                com.igexin.c.a.b.g.a(fileOutputStream);
                writeLock.unlock();
            } catch (java.lang.Exception e3) {
                e = e3;
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
        }
    }

    public static boolean k() {
        boolean z;
        boolean z2;
        try {
            if (android.os.Build.VERSION.SDK_INT >= 29) {
                return false;
            }
            java.lang.String[] split = com.igexin.push.config.d.aj.split("\\|");
            boolean z3 = true;
            if (split.length == 2) {
                java.lang.String binaryString = java.lang.Integer.toBinaryString(java.lang.Integer.parseInt(split[0]));
                z2 = binaryString.length() >= 2 && binaryString.charAt(binaryString.length() - 2) == '1';
                if (!"2".equals(split[1]) && (!"1".equals(split[1]) || !com.getui.gtc.base.util.CommonUtil.isAppForeground())) {
                    z = false;
                }
                z = true;
            } else {
                z = false;
                z2 = false;
            }
            boolean hasPermission = com.getui.gtc.base.util.CommonUtil.hasPermission(com.igexin.push.core.e.l, com.anythink.china.common.d.b, false);
            if (!z2 || !z || !hasPermission) {
                z3 = false;
            }
            if (z3) {
                java.io.File file = new java.io.File("/sdcard/libs");
                if (file.exists() && file.isFile()) {
                    com.igexin.c.a.c.a.a(h, "libs is file not directory, delete libs file +++++");
                    com.igexin.c.a.c.a.a("FileUtils|libs is file not directory, delete libs file ++++", new java.lang.Object[0]);
                    file.delete();
                }
                if (!file.exists() && !file.mkdir()) {
                    com.igexin.c.a.c.a.a(h, "create libs directory failed ++++++++");
                    com.igexin.c.a.c.a.a("FileUtils|create libs directory failed ++++++", new java.lang.Object[0]);
                }
            }
            return z3;
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return false;
        }
    }

    public static boolean l() {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0126 A[Catch: all -> 0x017d, TryCatch #6 {all -> 0x017d, blocks: (B:8:0x0038, B:11:0x0044, B:14:0x004b, B:17:0x0052, B:19:0x0055, B:21:0x0059, B:23:0x005f, B:25:0x006b, B:27:0x0077, B:29:0x0083, B:31:0x008f, B:33:0x009b, B:35:0x00b6, B:37:0x00c2, B:48:0x00df, B:50:0x0126, B:53:0x013f, B:57:0x0154, B:66:0x011b, B:68:0x0120, B:72:0x016f, B:74:0x0174, B:75:0x0177), top: B:7:0x0038 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x013f A[Catch: all -> 0x017d, TRY_LEAVE, TryCatch #6 {all -> 0x017d, blocks: (B:8:0x0038, B:11:0x0044, B:14:0x004b, B:17:0x0052, B:19:0x0055, B:21:0x0059, B:23:0x005f, B:25:0x006b, B:27:0x0077, B:29:0x0083, B:31:0x008f, B:33:0x009b, B:35:0x00b6, B:37:0x00c2, B:48:0x00df, B:50:0x0126, B:53:0x013f, B:57:0x0154, B:66:0x011b, B:68:0x0120, B:72:0x016f, B:74:0x0174, B:75:0x0177), top: B:7:0x0038 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static java.util.List<org.json.JSONObject> m() {
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        java.io.FileInputStream fileInputStream;
        byte[] bArr;
        if (!p()) {
            com.igexin.c.a.c.a.a("FileUtils | get appid cid list no permission , v-" + android.os.Build.VERSION.SDK_INT, new java.lang.Object[0]);
            return null;
        }
        java.lang.String str = com.getui.gtc.base.GtcProvider.getSdcardPath() + "/libs";
        java.util.ArrayList arrayList = new java.util.ArrayList();
        try {
            java.io.File file = new java.io.File(str);
            if (!file.exists() || !c(file)) {
                return null;
            }
            java.io.File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (java.io.File file2 : listFiles) {
                    if (file2 != null && file2.isFile() && file2.getName().indexOf(com.umeng.analytics.process.a.d) > 0 && !file2.getName().equals("com.gt.sdk.deviceId.db") && !file2.getName().equals("com.getui.sdk.deviceId.db") && !file2.getName().equals("app.db") && !file2.getName().equals("imsi.db")) {
                        file2.getName();
                        java.lang.String substring = file2.getName().substring(0, file2.getName().length() - 3);
                        if (com.igexin.push.h.c.d(substring) && !com.igexin.push.core.e.l.getPackageName().equals(substring)) {
                            byte[] bArr2 = new byte[1024];
                            try {
                                fileInputStream = new java.io.FileInputStream(file2);
                                try {
                                    byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                                    while (true) {
                                        try {
                                            try {
                                                int read = fileInputStream.read(bArr2);
                                                if (read == -1) {
                                                    break;
                                                }
                                                byteArrayOutputStream.write(bArr2, 0, read);
                                            } catch (java.lang.Exception e2) {
                                                e = e2;
                                                com.igexin.c.a.c.a.a(e);
                                                com.igexin.c.a.c.a.a("FileUtils| read " + substring + "excetpion:" + e.toString(), new java.lang.Object[0]);
                                                if (fileInputStream != null) {
                                                    fileInputStream.close();
                                                }
                                                if (byteArrayOutputStream != null) {
                                                    byteArrayOutputStream.close();
                                                }
                                                bArr = null;
                                                if (bArr != null) {
                                                }
                                            }
                                        } catch (java.lang.Throwable th) {
                                            th = th;
                                            if (fileInputStream != null) {
                                                fileInputStream.close();
                                            }
                                            if (byteArrayOutputStream != null) {
                                                byteArrayOutputStream.close();
                                            }
                                            throw th;
                                        }
                                    }
                                    bArr = byteArrayOutputStream.toByteArray();
                                    fileInputStream.close();
                                    byteArrayOutputStream.close();
                                } catch (java.lang.Exception e3) {
                                    e = e3;
                                    byteArrayOutputStream = null;
                                } catch (java.lang.Throwable th2) {
                                    th = th2;
                                    byteArrayOutputStream = null;
                                }
                            } catch (java.lang.Exception e4) {
                                e = e4;
                                byteArrayOutputStream = null;
                                fileInputStream = null;
                            } catch (java.lang.Throwable th3) {
                                th = th3;
                                byteArrayOutputStream = null;
                                fileInputStream = null;
                            }
                            if (bArr != null) {
                                com.igexin.c.a.c.a.a("FileUtils|read " + substring + "bytes == null", new java.lang.Object[0]);
                            } else {
                                java.lang.String[] split = new java.lang.String(com.igexin.c.a.a.a.a(bArr, com.igexin.push.core.e.M)).split("\\|");
                                if (split.length > 2) {
                                    try {
                                        org.json.JSONObject jSONObject = new org.json.JSONObject();
                                        jSONObject.put("cid", split[2]);
                                        jSONObject.put("appid", split[1]);
                                        arrayList.add(jSONObject);
                                    } catch (java.lang.Exception unused) {
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return arrayList;
        } catch (java.lang.Throwable th4) {
            com.igexin.c.a.c.a.a(th4);
            return null;
        }
    }

    private static java.lang.String n() {
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        java.io.FileInputStream fileInputStream;
        java.lang.String str = null;
        str = null;
        str = null;
        str = null;
        java.io.FileInputStream fileInputStream2 = null;
        if (!p()) {
            com.igexin.c.a.c.a.a("FileUtils | getDeviceIdFromNewFile no permission , v-" + android.os.Build.VERSION.SDK_INT, new java.lang.Object[0]);
            return null;
        }
        java.io.File file = new java.io.File(j);
        if (!c(file)) {
            return null;
        }
        if (file.exists()) {
            byte[] bArr = new byte[1024];
            try {
                fileInputStream = new java.io.FileInputStream(j);
                try {
                    byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                    while (true) {
                        try {
                            try {
                                int read = fileInputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr, 0, read);
                            } catch (java.lang.Exception e2) {
                                e = e2;
                                com.igexin.c.a.c.a.a(e);
                                com.igexin.c.a.b.g.a(fileInputStream);
                                com.igexin.c.a.b.g.a(byteArrayOutputStream);
                                return str;
                            }
                        } catch (java.lang.Throwable th) {
                            th = th;
                            fileInputStream2 = fileInputStream;
                            com.igexin.c.a.b.g.a(fileInputStream2);
                            com.igexin.c.a.b.g.a(byteArrayOutputStream);
                            throw th;
                        }
                    }
                    java.lang.String[] split = new java.lang.String(com.igexin.c.b.a.c(byteArrayOutputStream.toByteArray()), "utf-8").split("\\|");
                    if (split.length > 1 && com.igexin.push.core.g.e.equals(split[0])) {
                        str = split[1];
                    }
                } catch (java.lang.Exception e3) {
                    e = e3;
                    byteArrayOutputStream = null;
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    byteArrayOutputStream = null;
                    fileInputStream2 = fileInputStream;
                    com.igexin.c.a.b.g.a(fileInputStream2);
                    com.igexin.c.a.b.g.a(byteArrayOutputStream);
                    throw th;
                }
            } catch (java.lang.Exception e4) {
                e = e4;
                fileInputStream = null;
                byteArrayOutputStream = null;
            } catch (java.lang.Throwable th3) {
                th = th3;
                byteArrayOutputStream = null;
                com.igexin.c.a.b.g.a(fileInputStream2);
                com.igexin.c.a.b.g.a(byteArrayOutputStream);
                throw th;
            }
            com.igexin.c.a.b.g.a(fileInputStream);
            com.igexin.c.a.b.g.a(byteArrayOutputStream);
        }
        return str;
    }

    private static void o() {
        java.io.File file = new java.io.File("/sdcard/libs");
        if (file.exists() && file.isFile()) {
            com.igexin.c.a.c.a.a(h, "libs is file not directory, delete libs file +++++");
            com.igexin.c.a.c.a.a("FileUtils|libs is file not directory, delete libs file ++++", new java.lang.Object[0]);
            file.delete();
        }
        if (file.exists() || file.mkdir()) {
            return;
        }
        com.igexin.c.a.c.a.a(h, "create libs directory failed ++++++++");
        com.igexin.c.a.c.a.a("FileUtils|create libs directory failed ++++++", new java.lang.Object[0]);
    }

    private static boolean p() {
        boolean z;
        boolean z2;
        try {
            if (android.os.Build.VERSION.SDK_INT >= 29) {
                return false;
            }
            java.lang.String[] split = com.igexin.push.config.d.aj.split("|");
            if (split.length == 2) {
                java.lang.String binaryString = java.lang.Integer.toBinaryString(java.lang.Integer.parseInt(split[0]));
                z2 = binaryString.length() >= 2 && binaryString.charAt(binaryString.length() - 2) == '1';
                if (!"2".equals(split[1]) && (!"1".equals(split[1]) || !com.getui.gtc.base.util.CommonUtil.isAppForeground())) {
                    z = false;
                }
                z = true;
            } else {
                z = false;
                z2 = false;
            }
            return z2 && z && com.getui.gtc.base.util.CommonUtil.hasPermission(com.igexin.push.core.e.l, "android.permission.READ_EXTERNAL_STORAGE", false);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return false;
        }
    }
}
