package com.uc.crashsdk.a;

/* loaded from: classes19.dex */
public class g {
    static final /* synthetic */ boolean a = true;
    private static android.content.Context b;
    private static java.lang.String c;
    private static java.lang.String d;
    private static java.lang.String e;
    private static java.lang.String f;
    private static java.lang.String g;
    private static boolean h;
    private static final java.lang.Object i = new java.lang.Object();
    private static final char[] j = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', com.aliyun.svideo.editor.guide.customView.MultiLamp.BOTTOM, 'c', 'd', 'e', 'f'};

    public static android.content.Context a() {
        return b;
    }

    public static java.lang.String a(java.io.File file, int i2, boolean z) {
        java.io.FileInputStream fileInputStream;
        try {
            fileInputStream = new java.io.FileInputStream(file);
            try {
                byte[] bArr = new byte[i2];
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    return new java.lang.String(bArr, 0, read);
                }
            } catch (java.lang.Throwable th) {
                th = th;
                if (z) {
                    try {
                        a(th, false);
                    } finally {
                        a(fileInputStream);
                    }
                }
                return null;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0027, code lost:
    
        if (r2.toLowerCase().startsWith(com.alipay.sdk.m.l.a.q) != false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String a(java.lang.String str, java.lang.String str2, boolean z) {
        java.lang.String str3 = null;
        if (new java.io.File(str).exists()) {
            java.lang.String a2 = com.uc.crashsdk.a.b.a(str);
            if (!a(a2)) {
                if (z) {
                    a2 = a2.trim();
                }
                str3 = a2;
            }
        }
        return str3 == null ? str2 : str3;
    }

    private static java.lang.String a(java.lang.String[] strArr) {
        java.io.BufferedReader bufferedReader;
        java.io.InputStreamReader inputStreamReader;
        try {
            inputStreamReader = new java.io.InputStreamReader(java.lang.Runtime.getRuntime().exec(strArr).getInputStream());
            try {
                bufferedReader = new java.io.BufferedReader(inputStreamReader, 512);
                try {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    while (true) {
                        java.lang.String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            return sb.toString().trim();
                        }
                        sb.append(readLine);
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    try {
                        a(th, false);
                        return null;
                    } finally {
                        a(bufferedReader);
                        a(inputStreamReader);
                    }
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            bufferedReader = null;
            inputStreamReader = null;
        }
    }

    public static java.util.ArrayList<java.lang.String> a(java.io.File file, int i2) {
        java.io.BufferedReader bufferedReader;
        java.util.ArrayList<java.lang.String> arrayList = new java.util.ArrayList<>();
        java.io.FileReader fileReader = null;
        try {
            java.io.FileReader fileReader2 = new java.io.FileReader(file);
            try {
                bufferedReader = new java.io.BufferedReader(fileReader2, 512);
                int i3 = 0;
                while (true) {
                    try {
                        java.lang.String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        arrayList.add(readLine);
                        i3++;
                        if (i2 > 0 && i3 >= i2) {
                            break;
                        }
                    } catch (java.lang.Throwable th) {
                        th = th;
                        fileReader = fileReader2;
                        try {
                            a(th, false);
                            a(fileReader);
                            a(bufferedReader);
                            return arrayList;
                        } catch (java.lang.Throwable th2) {
                            a(fileReader);
                            a(bufferedReader);
                            throw th2;
                        }
                    }
                }
                a(fileReader2);
            } catch (java.lang.Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
        } catch (java.lang.Throwable th4) {
            th = th4;
            bufferedReader = null;
        }
        a(bufferedReader);
        return arrayList;
    }

    public static void a(int i2) {
        if (i2 == 800) {
            l();
        } else if (!a) {
            throw new java.lang.AssertionError();
        }
    }

    public static void a(android.content.Context context) {
        if (b != null) {
            com.uc.crashsdk.a.a.b("mContext is existed");
        }
        b = context;
        android.content.pm.ApplicationInfo applicationInfo = context.getApplicationInfo();
        c = applicationInfo.dataDir;
        d = applicationInfo.sourceDir;
        try {
            java.lang.reflect.Field declaredField = android.content.pm.ApplicationInfo.class.getDeclaredField("primaryCpuAbi");
            declaredField.setAccessible(true);
            java.lang.Object obj = declaredField.get(applicationInfo);
            if (obj == null || !(obj instanceof java.lang.String)) {
                return;
            }
            e = (java.lang.String) obj;
        } catch (java.lang.Throwable th) {
            a(th, false);
        }
    }

    public static void a(java.io.Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (java.lang.Throwable th) {
                a(th, true);
            }
        }
    }

    public static void a(java.io.File file, java.io.File file2) {
        java.io.FileOutputStream fileOutputStream;
        byte[] bArr = new byte[524288];
        java.io.File parentFile = file2.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        if (file2.isDirectory()) {
            file2 = new java.io.File(file2, file.getName());
        }
        java.io.FileInputStream fileInputStream = null;
        try {
            java.io.FileInputStream fileInputStream2 = new java.io.FileInputStream(file);
            try {
                fileOutputStream = new java.io.FileOutputStream(file2);
                while (true) {
                    try {
                        int read = fileInputStream2.read(bArr);
                        if (read == -1) {
                            a(fileInputStream2);
                            a(fileOutputStream);
                            return;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    } catch (java.lang.Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                        a(fileInputStream);
                        a(fileOutputStream);
                        throw th;
                    }
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                fileOutputStream = null;
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }

    public static void a(java.lang.Throwable th) {
        a(th, false);
    }

    private static void a(java.lang.Throwable th, boolean z) {
        if (!z) {
            try {
                if (!com.uc.crashsdk.g.P()) {
                    return;
                }
            } catch (java.lang.Throwable unused) {
                return;
            }
        }
        th.printStackTrace();
    }

    public static boolean a(java.io.File file) {
        java.lang.String[] list;
        if (file.isDirectory() && (list = file.list()) != null) {
            for (java.lang.String str : list) {
                if (!a(new java.io.File(file, str))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public static boolean a(java.io.File file, java.lang.String str) {
        java.io.FileWriter fileWriter = null;
        try {
            java.io.FileWriter fileWriter2 = new java.io.FileWriter(file);
            try {
                fileWriter2.write(str, 0, str.length());
                a(fileWriter2);
                return true;
            } catch (java.lang.Throwable th) {
                th = th;
                fileWriter = fileWriter2;
                try {
                    a(th, false);
                    return false;
                } finally {
                    a(fileWriter);
                }
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    public static boolean a(java.io.File file, byte[] bArr) {
        java.io.FileOutputStream fileOutputStream = null;
        try {
            java.io.FileOutputStream fileOutputStream2 = new java.io.FileOutputStream(file);
            try {
                fileOutputStream2.write(bArr);
                fileOutputStream2.flush();
                a(fileOutputStream2);
                return true;
            } catch (java.lang.Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                try {
                    a(th, false);
                    a(fileOutputStream);
                    return false;
                } catch (java.lang.Throwable th2) {
                    a(fileOutputStream);
                    throw th2;
                }
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
        }
    }

    public static boolean a(java.lang.String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean a(java.lang.StringBuffer stringBuffer) {
        return stringBuffer == null || stringBuffer.length() == 0;
    }

    public static java.lang.String b() {
        return c;
    }

    public static void b(java.io.File file) {
        a(file, "");
    }

    public static void b(java.lang.Throwable th) {
        a(th, true);
    }

    public static boolean b(java.lang.String str) {
        return !a(str);
    }

    public static long c(java.lang.String str) {
        if (a(str)) {
            return 0L;
        }
        try {
            long parseLong = java.lang.Long.parseLong(str.trim());
            if (parseLong < 0) {
                return 0L;
            }
            return parseLong;
        } catch (java.lang.NumberFormatException unused) {
            return 0L;
        }
    }

    public static java.lang.String c() {
        return d;
    }

    public static java.lang.String c(java.io.File file) {
        java.lang.String str = "";
        if (!file.exists()) {
            return "";
        }
        java.io.FileInputStream fileInputStream = null;
        try {
            java.io.FileInputStream fileInputStream2 = new java.io.FileInputStream(file);
            try {
                byte[] bArr = new byte[256];
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                while (true) {
                    int read = fileInputStream2.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    sb.append(new java.lang.String(bArr, 0, read));
                }
                str = sb.toString();
                a(fileInputStream2);
            } catch (java.lang.Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                try {
                    a(th, false);
                    return str;
                } finally {
                    a(fileInputStream);
                }
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
        return str;
    }

    public static java.lang.String d() {
        java.lang.String str = e;
        return str != null ? str : "";
    }

    public static java.lang.String d(java.io.File file) {
        return a(file, 64, true);
    }

    public static java.lang.String d(java.lang.String str) {
        try {
            byte[] bytes = str.getBytes("utf-8");
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
            messageDigest.update(bytes);
            byte[] digest = messageDigest.digest();
            int length = digest.length;
            java.lang.StringBuilder sb = new java.lang.StringBuilder(length * 2);
            int i2 = length + 0;
            for (int i3 = 0; i3 < i2; i3++) {
                byte b2 = digest[i3];
                char[] cArr = j;
                char c2 = cArr[(b2 & 240) >> 4];
                char c3 = cArr[b2 & 15];
                sb.append(c2);
                sb.append(c3);
            }
            return sb.toString();
        } catch (java.lang.Exception e2) {
            com.uc.crashsdk.a.a.a("crashsdk", "getMD5: ", e2);
            return null;
        }
    }

    public static boolean e() {
        if (g()) {
            return true;
        }
        return f();
    }

    public static byte[] e(java.io.File file) {
        java.io.FileInputStream fileInputStream;
        if (!file.exists()) {
            return null;
        }
        try {
            byte[] bArr = new byte[(int) file.length()];
            fileInputStream = new java.io.FileInputStream(file);
            try {
                fileInputStream.read(bArr);
                return bArr;
            } catch (java.lang.Throwable th) {
                th = th;
                try {
                    a(th, false);
                    return null;
                } finally {
                    a(fileInputStream);
                }
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
    }

    public static boolean f() {
        java.lang.String str = android.os.Build.TAGS;
        return str != null && str.contains("test-keys");
    }

    public static boolean g() {
        int indexOf;
        java.lang.String i2 = i();
        if (!a(i2) && (indexOf = i2.indexOf(" root ")) > 0) {
            java.lang.String substring = i2.substring(0, indexOf);
            if (substring.contains("x") || substring.contains("s")) {
                return true;
            }
        }
        return false;
    }

    public static java.lang.String h() {
        l();
        return a(f) ? "" : f;
    }

    public static java.lang.String i() {
        l();
        return a(g) ? "" : g;
    }

    public static void j() {
        com.uc.crashsdk.a.f.a(0, new com.uc.crashsdk.a.e(800), 15000L);
    }

    public static void k() {
        if (com.uc.crashsdk.b.d && h) {
            com.uc.crashsdk.JNIBridge.set(123, f);
            com.uc.crashsdk.JNIBridge.set(124, g);
        }
    }

    private static void l() {
        java.lang.String trim;
        int indexOf;
        int indexOf2;
        if (h) {
            return;
        }
        synchronized (i) {
            if (h) {
                return;
            }
            java.lang.String a2 = a(new java.lang.String[]{com.anythink.expressad.foundation.d.d.t, "-c", "type su"});
            if (!a(a2) && (indexOf = (trim = a2.trim()).indexOf(32)) > 0 && trim.contains("/su") && (indexOf2 = trim.indexOf(47, indexOf + 1)) > 0) {
                java.lang.String substring = trim.substring(indexOf2);
                f = substring;
                java.lang.String a3 = a(new java.lang.String[]{"ls", "-l", substring});
                if (!a(a3)) {
                    g = a3.trim();
                }
            }
            h = true;
            k();
        }
    }
}
