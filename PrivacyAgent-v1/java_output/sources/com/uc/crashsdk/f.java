package com.uc.crashsdk;

/* loaded from: classes19.dex */
public class f {
    static final /* synthetic */ boolean a = true;
    private static final java.lang.Object b = new java.lang.Object();
    private static final android.util.SparseArray<java.lang.String> c = new android.util.SparseArray<>();
    private static final java.lang.Object d = new java.lang.Object();
    private static boolean e = false;

    public static int a() {
        java.io.File[] d2 = com.uc.crashsdk.b.d();
        if (d2 == null) {
            return 0;
        }
        int i = 0;
        for (java.io.File file : d2) {
            if (a(file.getAbsolutePath(), false)) {
                i++;
            }
        }
        return i;
    }

    private static int a(java.lang.StringBuffer stringBuffer, java.lang.String str) {
        int indexOf = stringBuffer.indexOf(str);
        if (indexOf < 0) {
            return 0;
        }
        int indexOf2 = stringBuffer.indexOf(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER, indexOf + str.length());
        if (indexOf2 < 0) {
            com.uc.crashsdk.a.a.b(str + " line not contain '='!");
            return 0;
        }
        int i = indexOf2 + 1;
        int indexOf3 = stringBuffer.indexOf("\n", i);
        if (indexOf3 < 0) {
            indexOf3 = stringBuffer.length();
        }
        try {
            int parseInt = java.lang.Integer.parseInt(stringBuffer.substring(i, indexOf3));
            if (parseInt < 0) {
                return 0;
            }
            return parseInt;
        } catch (java.lang.NumberFormatException e2) {
            com.uc.crashsdk.a.g.a(e2);
            return 0;
        }
    }

    public static int a(boolean z) {
        if (z) {
            return c(com.uc.crashsdk.b.e()) ? 1 : 0;
        }
        java.io.File[] f = com.uc.crashsdk.b.f();
        if (f == null) {
            return 0;
        }
        int i = 0;
        for (java.io.File file : f) {
            if (c(file.getAbsolutePath())) {
                i++;
            }
        }
        return i;
    }

    private static java.lang.String a(java.lang.StringBuffer stringBuffer) {
        if (stringBuffer == null) {
            return null;
        }
        int indexOf = stringBuffer.indexOf("[");
        if (indexOf < 0) {
            com.uc.crashsdk.a.a.a("crashsdk", "getProcessName: Can not found process name start!", null);
            return null;
        }
        int i = indexOf + 1;
        int indexOf2 = stringBuffer.indexOf("]", i);
        if (indexOf2 < 0) {
            com.uc.crashsdk.a.a.a("crashsdk", "getProcessName: Can not found process name end!", null);
            return null;
        }
        java.lang.String substring = stringBuffer.substring(i, indexOf2);
        if (substring.length() > 0) {
            return substring;
        }
        com.uc.crashsdk.a.a.a("crashsdk", "getProcessName: process name is empty", null);
        return null;
    }

    private static java.lang.StringBuffer a(java.io.File file) {
        java.io.FileReader fileReader;
        java.io.FileReader fileReader2 = null;
        if (!file.exists()) {
            return null;
        }
        char[] d2 = d();
        if (d2 == null) {
            com.uc.crashsdk.a.a.a("crashsdk", "readCrashStatData alloc buffer failed!", null);
            return null;
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        try {
            try {
                fileReader = new java.io.FileReader(file);
            } catch (java.lang.Throwable th) {
                th = th;
            }
        } catch (java.lang.Exception e2) {
            e = e2;
        }
        try {
            int read = fileReader.read(d2);
            if (read > 0) {
                fileReader2 = null;
                stringBuffer.append(d2, 0, read);
            }
            com.uc.crashsdk.a.g.a(fileReader);
        } catch (java.lang.Exception e3) {
            e = e3;
            fileReader2 = fileReader;
            com.uc.crashsdk.a.g.a(e);
            com.uc.crashsdk.a.g.a(fileReader2);
            return stringBuffer;
        } catch (java.lang.Throwable th2) {
            th = th2;
            fileReader2 = fileReader;
            com.uc.crashsdk.a.g.a(fileReader2);
            throw th;
        }
        return stringBuffer;
    }

    public static void a(int i) {
        a(i, 1);
    }

    public static void a(int i, int i2) {
        if (i2 != 0) {
            a(com.uc.crashsdk.b.c(), new com.uc.crashsdk.a.e(751, new java.lang.Object[]{java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2)}));
            return;
        }
        com.uc.crashsdk.a.a.b("Add stat for type " + i + " with count 0!");
    }

    private static void a(java.lang.String str, java.util.HashMap<java.lang.String, java.lang.Integer> hashMap, java.lang.String str2) {
        if (hashMap.size() <= 0) {
            return;
        }
        if (com.uc.crashsdk.a.g.a(str)) {
            com.uc.crashsdk.a.a.a("crashsdk", "cacheReportedStatsForCallback: processName is null", null);
        } else if (com.uc.crashsdk.a.g.a(str2)) {
            com.uc.crashsdk.a.a.a("crashsdk", "cacheReportedStatsForCallback: callbackCacheFilePathName is null", null);
        } else {
            a(str2, new com.uc.crashsdk.a.e(754, new java.lang.Object[]{str, hashMap, str2}));
        }
    }

    private static void a(java.lang.StringBuffer stringBuffer, java.lang.String str, int i) {
        int indexOf = stringBuffer.indexOf(str);
        if (indexOf < 0) {
            if (i > 0) {
                stringBuffer.append(str);
                stringBuffer.append(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
                stringBuffer.append(i);
                stringBuffer.append("\n");
                return;
            }
            return;
        }
        int indexOf2 = stringBuffer.indexOf("\n", indexOf);
        if (indexOf2 < 0) {
            indexOf2 = stringBuffer.length();
        }
        stringBuffer.replace(indexOf, indexOf2, str + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + java.lang.String.valueOf(i));
    }

    public static boolean a(int i, java.lang.Object[] objArr) {
        switch (i) {
            case 751:
                if (a || objArr != null) {
                    return b(((java.lang.Integer) objArr[0]).intValue(), ((java.lang.Integer) objArr[1]).intValue());
                }
                throw new java.lang.AssertionError();
            case 752:
                if (a || objArr != null) {
                    return b((java.lang.String) objArr[0]);
                }
                throw new java.lang.AssertionError();
            case 753:
                if (!a && objArr == null) {
                    throw new java.lang.AssertionError();
                }
                java.io.File file = new java.io.File((java.lang.String) objArr[0]);
                if (!file.exists()) {
                    return false;
                }
                file.delete();
                return true;
            case 754:
                if (!a && objArr == null) {
                    throw new java.lang.AssertionError();
                }
                b((java.lang.String) objArr[0], (java.util.HashMap) objArr[1], (java.lang.String) objArr[2]);
                return true;
            case 755:
                if (a || objArr != null) {
                    return d((java.lang.String) objArr[0]);
                }
                throw new java.lang.AssertionError();
            case 756:
                if (!a && objArr == null) {
                    throw new java.lang.AssertionError();
                }
                java.io.File file2 = new java.io.File((java.lang.String) objArr[0]);
                if (!file2.exists()) {
                    return false;
                }
                file2.delete();
                return true;
            default:
                return false;
        }
    }

    private static boolean a(java.io.File file, java.lang.StringBuffer stringBuffer) {
        java.io.FileWriter fileWriter;
        java.io.FileWriter fileWriter2 = null;
        try {
            try {
                fileWriter = new java.io.FileWriter(file);
            } catch (java.lang.Exception e2) {
                e = e2;
            }
        } catch (java.lang.Throwable th) {
            th = th;
        }
        try {
            java.lang.String stringBuffer2 = stringBuffer.toString();
            fileWriter.write(stringBuffer2, 0, stringBuffer2.length());
            com.uc.crashsdk.a.g.a(fileWriter);
            return true;
        } catch (java.lang.Exception e3) {
            e = e3;
            fileWriter2 = fileWriter;
            com.uc.crashsdk.a.g.a(e);
            com.uc.crashsdk.a.g.a(fileWriter2);
            return false;
        } catch (java.lang.Throwable th2) {
            th = th2;
            fileWriter2 = fileWriter;
            com.uc.crashsdk.a.g.a(fileWriter2);
            throw th;
        }
    }

    public static boolean a(java.lang.String str) {
        return a(str, new com.uc.crashsdk.a.e(753, new java.lang.Object[]{str}));
    }

    private static boolean a(java.lang.String str, com.uc.crashsdk.a.e eVar) {
        return com.uc.crashsdk.b.a(b, str, eVar);
    }

    public static boolean a(java.lang.String str, boolean z) {
        if (com.uc.crashsdk.a.h.a(z, "crash detail report")) {
            return false;
        }
        return a(str, new com.uc.crashsdk.a.e(752, new java.lang.Object[]{str}));
    }

    public static int b() {
        java.io.File[] d2 = com.uc.crashsdk.b.d();
        if (d2 == null) {
            return 0;
        }
        int i = 0;
        for (java.io.File file : d2) {
            if (a(file.getAbsolutePath())) {
                i++;
            }
        }
        return i;
    }

    public static int b(boolean z) {
        if (z) {
            return e(com.uc.crashsdk.b.e()) ? 1 : 0;
        }
        java.io.File[] f = com.uc.crashsdk.b.f();
        if (f == null) {
            return 0;
        }
        int i = 0;
        for (java.io.File file : f) {
            if (e(file.getAbsolutePath())) {
                i++;
            }
        }
        return i;
    }

    public static void b(int i) {
        if (i != 700) {
            return;
        }
        d(false);
    }

    private static void b(java.lang.String str, java.util.HashMap<java.lang.String, java.lang.Integer> hashMap, java.lang.String str2) {
        try {
            com.uc.crashsdk.b.x();
        } catch (java.lang.Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        try {
            java.io.File file = new java.io.File(str2);
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
            } catch (java.lang.Throwable th2) {
                com.uc.crashsdk.a.g.a(th2);
            }
            java.lang.StringBuffer a2 = a(file);
            if (com.uc.crashsdk.a.g.a(a2)) {
                if (a2 == null) {
                    a2 = new java.lang.StringBuffer();
                }
                a2.append("[");
                a2.append(str);
                a2.append("]\n");
            }
            boolean z = false;
            for (java.util.Map.Entry<java.lang.String, java.lang.Integer> entry : hashMap.entrySet()) {
                int intValue = entry.getValue().intValue();
                if (intValue > 0) {
                    java.lang.String key = entry.getKey();
                    a(a2, key, intValue + a(a2, key));
                    z = true;
                }
            }
            if (z) {
                a(file, a2);
            }
        } catch (java.lang.Throwable th3) {
            com.uc.crashsdk.a.g.a(th3);
        }
    }

    private static boolean b(int i, int i2) {
        try {
            com.uc.crashsdk.b.x();
        } catch (java.lang.Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        try {
            java.lang.String c2 = c(i);
            if (c2 == null) {
                com.uc.crashsdk.a.a.a("crashsdk", "Stat type not exists: " + i, null);
                return false;
            }
            java.io.File file = new java.io.File(com.uc.crashsdk.b.c());
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
            } catch (java.lang.Throwable th2) {
                com.uc.crashsdk.a.g.a(th2);
            }
            java.lang.StringBuffer a2 = a(file);
            if (com.uc.crashsdk.a.g.a(a2)) {
                if (a2 == null) {
                    a2 = new java.lang.StringBuffer();
                }
                a2.append("[");
                a2.append(com.uc.crashsdk.e.h());
                a2.append("]\n");
            }
            a(a2, c2, a(a2, c2) + i2);
            return a(file, a2);
        } catch (java.lang.Throwable th3) {
            com.uc.crashsdk.a.g.a(th3);
            return false;
        }
    }

    private static boolean b(java.lang.String str) {
        java.io.File file = new java.io.File(str);
        java.lang.StringBuffer a2 = a(file);
        if (com.uc.crashsdk.a.g.a(a2)) {
            return false;
        }
        java.lang.String a3 = a(a2);
        java.lang.StringBuffer stringBuffer = null;
        if (a3 == null || a3.length() <= 0) {
            com.uc.crashsdk.a.a.a("crashsdk", "reportCrashStatImpl: process name is invalid", null);
            return false;
        }
        android.util.SparseArray<java.lang.String> e2 = e();
        java.util.HashMap hashMap = new java.util.HashMap();
        boolean P = com.uc.crashsdk.g.P();
        if (P) {
            stringBuffer = new java.lang.StringBuffer();
            stringBuffer.append("reportCrashStatImpl: processName: ");
            stringBuffer.append(a3 + "\n");
        }
        boolean z = false;
        for (int i = 0; i < e2.size(); i++) {
            try {
                int keyAt = e2.keyAt(i);
                java.lang.String str2 = e2.get(keyAt);
                int a4 = a(a2, str2);
                if (a4 > 0) {
                    if (P) {
                        stringBuffer.append("name: ");
                        stringBuffer.append(str2);
                        stringBuffer.append(", key: ");
                        stringBuffer.append(keyAt);
                        stringBuffer.append(", count: ");
                        stringBuffer.append(a4);
                        stringBuffer.append("\n");
                    }
                    com.uc.crashsdk.a.h.a(a3, keyAt, a4);
                    hashMap.put(str2, java.lang.Integer.valueOf(a4));
                    a(a2, str2, 0);
                    z = true;
                }
            } finally {
                if (z) {
                    a(file, a2);
                    if (hashMap.size() > 0) {
                        a(a3, (java.util.HashMap<java.lang.String, java.lang.Integer>) hashMap, com.uc.crashsdk.b.a(str));
                    }
                }
            }
        }
        if (P) {
            com.uc.crashsdk.a.a.a(stringBuffer.toString());
        }
        return true;
    }

    private static java.lang.String c(int i) {
        java.lang.String str;
        f();
        android.util.SparseArray<java.lang.String> sparseArray = c;
        synchronized (sparseArray) {
            str = sparseArray.get(i);
        }
        return str;
    }

    public static void c() {
        com.uc.crashsdk.a.f.a(1, new com.uc.crashsdk.a.e(700), 3000L);
    }

    public static void c(boolean z) {
        if (com.uc.crashsdk.g.R() && !com.uc.crashsdk.b.L()) {
            com.uc.crashsdk.e.j();
            if (!com.uc.crashsdk.a.h.e()) {
                com.uc.crashsdk.a.h.a(z);
            }
            if (com.uc.crashsdk.b.F()) {
                d(z);
                a(com.uc.crashsdk.b.c(), z);
                com.uc.crashsdk.a.h.b(z);
            }
        }
    }

    private static boolean c(java.lang.String str) {
        if (!com.uc.crashsdk.a.g.a(str) && new java.io.File(str).exists()) {
            return a(str, new com.uc.crashsdk.a.e(755, new java.lang.Object[]{str}));
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004a A[Catch: all -> 0x0056, TryCatch #0 {, blocks: (B:8:0x0008, B:10:0x000c, B:12:0x000e, B:14:0x0016, B:16:0x0018, B:18:0x001f, B:20:0x0029, B:23:0x004a, B:24:0x004d, B:25:0x0054, B:27:0x0030, B:29:0x0036, B:31:0x0041), top: B:7:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void d(boolean z) {
        boolean z2;
        if (e) {
            return;
        }
        synchronized (d) {
            if (e) {
                return;
            }
            if (com.uc.crashsdk.a.h.a(z, "crash detail")) {
                return;
            }
            if (com.uc.crashsdk.b.s()) {
                a(2, 1);
                if (com.uc.crashsdk.b.r()) {
                    a(42, 1);
                }
            } else {
                if (!com.uc.crashsdk.b.t()) {
                    z2 = false;
                    if (z2) {
                        a(1, 1);
                    }
                    a(100, 1);
                    e = true;
                }
                a(101, 1);
                if (com.uc.crashsdk.b.r()) {
                    a(43, 1);
                }
            }
            z2 = true;
            if (z2) {
            }
            a(100, 1);
            e = true;
        }
    }

    private static boolean d(java.lang.String str) {
        if (!a && str == null) {
            throw new java.lang.AssertionError();
        }
        java.io.File file = new java.io.File(str);
        java.lang.StringBuffer a2 = a(file);
        if (com.uc.crashsdk.a.g.a(a2)) {
            return false;
        }
        java.lang.String a3 = a(a2);
        java.lang.StringBuffer stringBuffer = null;
        if (a3 == null || a3.length() <= 0) {
            com.uc.crashsdk.a.a.a("crashsdk", "notifyStatsDetailImpl: process name is invalid", null);
            return false;
        }
        android.util.SparseArray<java.lang.String> e2 = e();
        boolean P = com.uc.crashsdk.g.P();
        if (P) {
            stringBuffer = new java.lang.StringBuffer();
            stringBuffer.append("notifyStatsDetailImpl: processName: ");
            stringBuffer.append(a3 + "\n");
        }
        boolean z = false;
        for (int i = 0; i < e2.size(); i++) {
            try {
                int keyAt = e2.keyAt(i);
                java.lang.String str2 = e2.get(keyAt);
                int a4 = a(a2, str2);
                if (a4 > 0) {
                    if (P) {
                        stringBuffer.append("name: ");
                        stringBuffer.append(str2);
                        stringBuffer.append(", key: ");
                        stringBuffer.append(keyAt);
                        stringBuffer.append(", count: ");
                        stringBuffer.append(a4);
                        stringBuffer.append("\n");
                    }
                    com.uc.crashsdk.d.a(a3, keyAt, a4);
                    a(a2, str2, 0);
                    z = true;
                }
            } finally {
                if (z) {
                    a(file, a2);
                }
            }
        }
        if (P) {
            com.uc.crashsdk.a.a.a(stringBuffer.toString());
        }
        if (z) {
            com.uc.crashsdk.d.a(a3, 1000000, 0);
        }
        return z;
    }

    private static char[] d() {
        char[] cArr = null;
        int i = 1024;
        while (cArr == null && i > 0) {
            try {
                cArr = new char[i];
            } catch (java.lang.Throwable unused) {
                i /= 2;
                if (i < 512) {
                    break;
                }
            }
        }
        return cArr;
    }

    private static android.util.SparseArray<java.lang.String> e() {
        android.util.SparseArray<java.lang.String> clone;
        f();
        android.util.SparseArray<java.lang.String> sparseArray = c;
        synchronized (sparseArray) {
            clone = sparseArray.clone();
        }
        return clone;
    }

    private static boolean e(java.lang.String str) {
        if (!com.uc.crashsdk.a.g.a(str) && new java.io.File(str).exists()) {
            return a(str, new com.uc.crashsdk.a.e(756, new java.lang.Object[]{str}));
        }
        return false;
    }

    private static void f() {
        android.util.SparseArray<java.lang.String> sparseArray = c;
        synchronized (sparseArray) {
            if (sparseArray.size() != 0) {
                return;
            }
            sparseArray.put(100, "start_pv");
            sparseArray.put(102, "start_hpv");
            sparseArray.put(1, "all_all");
            sparseArray.put(2, "all_fg");
            sparseArray.put(101, "all_bg");
            sparseArray.put(3, "java_fg");
            sparseArray.put(4, "java_bg");
            sparseArray.put(7, "native_fg");
            sparseArray.put(8, "native_bg");
            sparseArray.put(27, "native_anr_fg");
            sparseArray.put(28, "native_anr_bg");
            sparseArray.put(9, "native_ok");
            sparseArray.put(10, "unexp_anr");
            sparseArray.put(29, "unexp_lowmem");
            sparseArray.put(30, "unexp_killed");
            sparseArray.put(31, "unexp_exit");
            sparseArray.put(32, "unexp_restart");
            sparseArray.put(11, "unexp_fg");
            sparseArray.put(12, "unexp_bg");
            sparseArray.put(40, "anr_fg");
            sparseArray.put(41, "anr_bg");
            sparseArray.put(42, "anr_cr_fg");
            sparseArray.put(43, "anr_cr_bg");
            sparseArray.put(13, "log_up_succ");
            sparseArray.put(14, "log_up_fail");
            sparseArray.put(15, "log_empty");
            sparseArray.put(200, "log_tmp");
            sparseArray.put(16, "log_abd_all");
            sparseArray.put(22, "log_abd_builtin");
            sparseArray.put(23, "log_abd_custom");
            sparseArray.put(17, "log_large");
            sparseArray.put(18, "log_up_all");
            sparseArray.put(19, "log_up_bytes");
            sparseArray.put(20, "log_up_crash");
            sparseArray.put(21, "log_up_custom");
            sparseArray.put(24, "log_zipped");
            sparseArray.put(201, "log_enced");
            sparseArray.put(25, "log_renamed");
            sparseArray.put(26, "log_safe_skip");
        }
    }
}
