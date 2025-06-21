package com.getui.gtc.extension.distribution.gbd.n.a;

/* loaded from: classes22.dex */
public final class f {
    private static final java.lang.String a = "PhoneInfoUtils";

    /* renamed from: com.getui.gtc.extension.distribution.gbd.n.a.f$1, reason: invalid class name */
    public static class AnonymousClass1 implements com.getui.gtc.extension.distribution.gbd.f.j<java.util.List<java.lang.String>, java.util.List<java.lang.String>> {
        final /* synthetic */ android.content.Context a;

        public AnonymousClass1(android.content.Context context) {
            this.a = context;
        }

        /* renamed from: a, reason: avoid collision after fix types in other method */
        private static java.util.List<java.lang.String> a2(java.util.List<java.lang.String> list) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.util.Iterator<java.lang.String> it = list.iterator();
            while (it.hasNext()) {
                android.content.pm.PackageInfo b = com.getui.gtc.extension.distribution.gbd.n.a.f.b(it.next());
                if (b != null && (b.applicationInfo.flags & 1) == 0) {
                    arrayList.add(b.packageName);
                }
            }
            return arrayList;
        }

        @Override // com.getui.gtc.extension.distribution.gbd.f.j
        public final /* synthetic */ java.util.List<java.lang.String> a(java.util.List<java.lang.String> list) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.util.Iterator<java.lang.String> it = list.iterator();
            while (it.hasNext()) {
                android.content.pm.PackageInfo b = com.getui.gtc.extension.distribution.gbd.n.a.f.b(it.next());
                if (b != null && (b.applicationInfo.flags & 1) == 0) {
                    arrayList.add(b.packageName);
                }
            }
            return arrayList;
        }
    }

    public static java.lang.String a() {
        try {
            java.lang.String a2 = com.getui.gtc.extension.distribution.gbd.n.l.a(true);
            return (android.text.TextUtils.isEmpty(a2) || a2.contains("*")) ? "" : c(a2) != a2.length() ? a2 : "";
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return "";
        }
    }

    public static java.lang.String a(android.content.Context context) {
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            return a();
        }
        try {
            java.lang.String c = c(context);
            if (android.text.TextUtils.isEmpty(c)) {
                c = d(context);
            }
            return (android.text.TextUtils.isEmpty(c) || c.contains("*")) ? "" : c(c) != c.length() ? c : "";
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return "";
        }
    }

    private static java.lang.String a(java.io.BufferedInputStream bufferedInputStream) {
        int read;
        byte[] bArr = new byte[512];
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        do {
            try {
                read = bufferedInputStream.read(bArr);
                if (read > 0) {
                    sb.append(new java.lang.String(bArr, 0, read));
                }
            } catch (java.lang.Throwable th) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            }
        } while (read >= 512);
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006f  */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.io.BufferedInputStream, java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String a(java.lang.String str) {
        java.lang.Process process;
        java.io.Closeable closeable;
        java.io.BufferedOutputStream bufferedOutputStream;
        ?? r3;
        java.io.BufferedOutputStream bufferedOutputStream2 = null;
        try {
            process = java.lang.Runtime.getRuntime().exec(com.anythink.expressad.foundation.d.d.t);
            try {
                bufferedOutputStream = new java.io.BufferedOutputStream(process.getOutputStream());
                try {
                    r3 = new java.io.BufferedInputStream(process.getInputStream());
                    try {
                        try {
                            bufferedOutputStream.write(str.getBytes());
                            bufferedOutputStream.write(10);
                            bufferedOutputStream.flush();
                            bufferedOutputStream.close();
                            process.waitFor();
                            java.lang.String a2 = a((java.io.BufferedInputStream) r3);
                            com.getui.gtc.extension.distribution.gbd.n.a.e.a(bufferedOutputStream);
                            com.getui.gtc.extension.distribution.gbd.n.a.e.a((java.io.Closeable) r3);
                            process.destroy();
                            return a2;
                        } catch (java.lang.Exception e) {
                            e = e;
                            com.getui.gtc.extension.distribution.gbd.n.j.a(e);
                            com.getui.gtc.extension.distribution.gbd.n.a.e.a(bufferedOutputStream);
                            com.getui.gtc.extension.distribution.gbd.n.a.e.a((java.io.Closeable) r3);
                            if (process != null) {
                                process.destroy();
                            }
                            return null;
                        }
                    } catch (java.lang.Throwable th) {
                        th = th;
                        bufferedOutputStream2 = bufferedOutputStream;
                        closeable = r3;
                        com.getui.gtc.extension.distribution.gbd.n.a.e.a(bufferedOutputStream2);
                        com.getui.gtc.extension.distribution.gbd.n.a.e.a(closeable);
                        if (process != null) {
                            process.destroy();
                        }
                        throw th;
                    }
                } catch (java.lang.Exception e2) {
                    e = e2;
                    r3 = 0;
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    r3 = 0;
                    bufferedOutputStream2 = bufferedOutputStream;
                    closeable = r3;
                    com.getui.gtc.extension.distribution.gbd.n.a.e.a(bufferedOutputStream2);
                    com.getui.gtc.extension.distribution.gbd.n.a.e.a(closeable);
                    if (process != null) {
                    }
                    throw th;
                }
            } catch (java.lang.Exception e3) {
                e = e3;
                bufferedOutputStream = null;
                r3 = bufferedOutputStream;
                com.getui.gtc.extension.distribution.gbd.n.j.a(e);
                com.getui.gtc.extension.distribution.gbd.n.a.e.a(bufferedOutputStream);
                com.getui.gtc.extension.distribution.gbd.n.a.e.a((java.io.Closeable) r3);
                if (process != null) {
                }
                return null;
            } catch (java.lang.Throwable th3) {
                th = th3;
                closeable = null;
                com.getui.gtc.extension.distribution.gbd.n.a.e.a(bufferedOutputStream2);
                com.getui.gtc.extension.distribution.gbd.n.a.e.a(closeable);
                if (process != null) {
                }
                throw th;
            }
        } catch (java.lang.Exception e4) {
            e = e4;
            process = null;
            bufferedOutputStream = null;
        } catch (java.lang.Throwable th4) {
            th = th4;
            process = null;
            closeable = null;
        }
    }

    public static android.content.pm.PackageInfo b(java.lang.String str) {
        try {
            return com.getui.gtc.extension.distribution.gbd.n.k.a(str, 0);
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public static java.util.List<java.lang.String> b(android.content.Context context) {
        java.util.List<java.lang.String> list;
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        try {
            java.util.List<java.lang.String> a2 = com.getui.gtc.extension.distribution.gbd.n.a.b.a();
            com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
            list = (java.util.List) com.getui.gtc.extension.distribution.gbd.f.c.a(true, com.getui.gtc.extension.distribution.gbd.f.b.b, a2, new com.getui.gtc.extension.distribution.gbd.n.a.f.AnonymousClass1(context));
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            list = null;
        }
        com.getui.gtc.extension.distribution.gbd.n.j.a("getPackagesByHit", "used time:".concat(java.lang.String.valueOf(java.lang.System.currentTimeMillis() - currentTimeMillis)));
        return list == null ? new java.util.ArrayList() : list;
    }

    public static boolean b() {
        android.os.Bundle bundle;
        try {
            if (c()) {
                return true;
            }
            java.util.List<android.content.pm.PackageInfo> a2 = com.getui.gtc.extension.distribution.gbd.n.b.a();
            if (a2.isEmpty()) {
                a2 = java.util.Collections.emptyList();
            }
            java.util.Iterator<android.content.pm.PackageInfo> it = a2.iterator();
            while (it.hasNext()) {
                android.content.pm.ApplicationInfo applicationInfo = it.next().applicationInfo;
                if (applicationInfo.enabled && (bundle = applicationInfo.metaData) != null && bundle.containsKey("xposedmodule")) {
                    return true;
                }
            }
            return false;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return false;
        }
    }

    private static int c(java.lang.String str) {
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (str.charAt(i2) == '0') {
                i++;
            }
        }
        return i;
    }

    private static java.lang.String c(android.content.Context context) {
        try {
            java.lang.reflect.Method declaredMethod = java.lang.Class.forName("android.os.ServiceManager").getDeclaredMethod("getService", java.lang.String.class);
            declaredMethod.setAccessible(true);
            android.os.IBinder iBinder = (android.os.IBinder) declaredMethod.invoke(null, com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE);
            java.lang.reflect.Method declaredMethod2 = java.lang.Class.forName("com.android.internal.telephony.ITelephony$Stub").getDeclaredMethod("asInterface", android.os.IBinder.class);
            declaredMethod2.setAccessible(true);
            java.lang.Object invoke = declaredMethod2.invoke(null, iBinder);
            try {
                java.lang.reflect.Method declaredMethod3 = invoke.getClass().getDeclaredMethod("getDeviceId", java.lang.String.class);
                if (declaredMethod3 != null) {
                    return (java.lang.String) declaredMethod3.invoke(invoke, context.getPackageName());
                }
            } catch (java.lang.Throwable th) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            }
            java.lang.reflect.Method declaredMethod4 = invoke.getClass().getDeclaredMethod("getDeviceId", new java.lang.Class[0]);
            return declaredMethod4 != null ? (java.lang.String) declaredMethod4.invoke(invoke, new java.lang.Object[0]) : "";
        } catch (java.lang.Throwable th2) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th2);
            return "";
        }
    }

    public static boolean c() {
        if (com.getui.gtc.extension.distribution.gbd.n.b.b("de.robv.android.xposed.installer") || com.getui.gtc.extension.distribution.gbd.n.b.b("com.saurik.substrate")) {
            return true;
        }
        try {
            java.lang.ClassLoader.getSystemClassLoader().loadClass("de.robv.android.xposed.XposedHelpers");
            return true;
        } catch (java.lang.Exception e) {
            for (java.lang.StackTraceElement stackTraceElement : e.getStackTrace()) {
                if (stackTraceElement.getClassName().equals("de.robv.android.xposed.XposedBridge") && stackTraceElement.getMethodName().equals("main")) {
                    return true;
                }
                if (stackTraceElement.getClassName().equals("de.robv.android.xposed.XposedBridge") && stackTraceElement.getMethodName().equals("handleHookedMethod")) {
                    return true;
                }
            }
            java.io.StringWriter stringWriter = new java.io.StringWriter();
            new java.io.PrintWriter((java.io.Writer) stringWriter, true).flush();
            stringWriter.flush();
            if (stringWriter.toString().contains("xposed")) {
                return true;
            }
            try {
                java.util.HashSet<java.lang.String> hashSet = new java.util.HashSet();
                java.io.FileReader fileReader = new java.io.FileReader("/proc/" + android.os.Process.myPid() + "/maps");
                java.io.BufferedReader bufferedReader = new java.io.BufferedReader(fileReader);
                while (true) {
                    try {
                        java.lang.String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        if (readLine.endsWith(".so") || readLine.endsWith(".jar")) {
                            hashSet.add(readLine.substring(readLine.lastIndexOf(" ") + 1));
                        }
                    } catch (java.lang.Throwable th) {
                        try {
                            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                            fileReader.close();
                            bufferedReader.close();
                            return false;
                        } finally {
                            fileReader.close();
                            bufferedReader.close();
                        }
                    }
                }
                for (java.lang.String str : hashSet) {
                    if (str.contains("com.saurik.substrate")) {
                        return true;
                    }
                    if (str.contains("XposedBridge.jar")) {
                        return true;
                    }
                }
                fileReader.close();
                bufferedReader.close();
            } catch (java.lang.Throwable th2) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th2);
                return false;
            }
            return false;
        }
    }

    public static java.lang.String d() {
        try {
            java.lang.Process start = new java.lang.ProcessBuilder("/system/bin/cat", "/proc/cpuinfo").start();
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(start.getInputStream(), "utf-8"));
            while (true) {
                java.lang.String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    bufferedReader.close();
                    return stringBuffer.toString().toLowerCase();
                }
                stringBuffer.append(readLine);
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return "";
        }
    }

    private static java.lang.String d(android.content.Context context) {
        try {
            java.lang.reflect.Method declaredMethod = java.lang.Class.forName("android.os.ServiceManager").getDeclaredMethod("getService", java.lang.String.class);
            declaredMethod.setAccessible(true);
            android.os.IBinder iBinder = (android.os.IBinder) declaredMethod.invoke(null, "iphonesubinfo");
            java.lang.reflect.Method declaredMethod2 = java.lang.Class.forName("com.android.internal.telephony.IPhoneSubInfo$Stub").getDeclaredMethod("asInterface", android.os.IBinder.class);
            declaredMethod2.setAccessible(true);
            java.lang.Object invoke = declaredMethod2.invoke(null, iBinder);
            try {
                java.lang.reflect.Method declaredMethod3 = invoke.getClass().getDeclaredMethod("getDeviceId", java.lang.String.class);
                if (declaredMethod3 != null) {
                    return (java.lang.String) declaredMethod3.invoke(invoke, context.getPackageName());
                }
            } catch (java.lang.Throwable th) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            }
            java.lang.reflect.Method declaredMethod4 = invoke.getClass().getDeclaredMethod("getDeviceId", new java.lang.Class[0]);
            return declaredMethod4 != null ? (java.lang.String) declaredMethod4.invoke(invoke, new java.lang.Object[0]) : "";
        } catch (java.lang.Throwable th2) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th2);
            return "";
        }
    }

    private static java.lang.String e() {
        return a();
    }

    private static java.util.List<android.content.pm.PackageInfo> f() {
        java.util.List<android.content.pm.PackageInfo> a2 = com.getui.gtc.extension.distribution.gbd.n.b.a();
        return a2.isEmpty() ? java.util.Collections.emptyList() : a2;
    }
}
