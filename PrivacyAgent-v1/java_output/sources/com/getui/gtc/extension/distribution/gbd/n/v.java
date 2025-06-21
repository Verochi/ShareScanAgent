package com.getui.gtc.extension.distribution.gbd.n;

/* loaded from: classes22.dex */
public final class v {
    private static final java.lang.String a = "GBD_RAU";

    /* renamed from: com.getui.gtc.extension.distribution.gbd.n.v$1, reason: invalid class name */
    public static class AnonymousClass1 implements com.getui.gtc.extension.distribution.gbd.f.j<java.lang.String, java.util.List<java.lang.String>> {
        final /* synthetic */ boolean a = true;
        final /* synthetic */ boolean b = false;

        private java.util.List<java.lang.String> a() {
            java.util.List<java.lang.String> a = com.getui.gtc.extension.distribution.gbd.n.v.a(this.a, this.b);
            if (a.isEmpty() && !this.b) {
                a = com.getui.gtc.extension.distribution.gbd.n.v.a();
            }
            if (a != null) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(com.getui.gtc.extension.distribution.gbd.n.v.a, android.os.Build.VERSION.SDK_INT + ", running = " + a.toString());
            }
            return a;
        }

        @Override // com.getui.gtc.extension.distribution.gbd.f.j
        public final /* synthetic */ java.util.List<java.lang.String> a(java.lang.String str) {
            java.util.List<java.lang.String> a = com.getui.gtc.extension.distribution.gbd.n.v.a(this.a, this.b);
            if (a.isEmpty() && !this.b) {
                a = com.getui.gtc.extension.distribution.gbd.n.v.a();
            }
            if (a != null) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(com.getui.gtc.extension.distribution.gbd.n.v.a, android.os.Build.VERSION.SDK_INT + ", running = " + a.toString());
            }
            return a;
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.n.v$2, reason: invalid class name */
    public static class AnonymousClass2 implements java.io.FileFilter {
        final /* synthetic */ int a;

        public AnonymousClass2(int i) {
            this.a = i;
        }

        @Override // java.io.FileFilter
        public final boolean accept(java.io.File file) {
            try {
                int parseInt = java.lang.Integer.parseInt(file.getName());
                if (file.isDirectory()) {
                    if (parseInt >= this.a) {
                        return true;
                    }
                }
            } catch (java.lang.Exception unused) {
            }
            return false;
        }
    }

    private static int a(java.lang.String str, java.lang.String str2) {
        int length = str.split(str2).length - 1;
        if (length > 0) {
            return length;
        }
        return 0;
    }

    private static java.lang.String a(int i) {
        java.lang.String str;
        try {
            str = b(java.lang.String.format("/proc/%d/cmdline", java.lang.Integer.valueOf(i))).trim();
        } catch (java.lang.Exception e) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(e);
            str = null;
        }
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return b(java.lang.String.format("/proc/%d/stat", java.lang.Integer.valueOf(i))).split("\\s+")[1].replace("(", "").replace(")", "");
            }
        } catch (java.lang.Exception e2) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(e2);
        }
        return str;
    }

    private static java.lang.String a(java.lang.String str) {
        try {
            if (java.util.regex.Pattern.compile("^([a-zA-Z]+[.][a-zA-Z]+)[.]*.*").matcher(str).find()) {
                return str.contains(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR) ? str.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)[0] : str;
            }
            return null;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return null;
        }
    }

    private static java.lang.String a(java.lang.String str, boolean z) {
        java.util.regex.Matcher matcher;
        java.lang.String str2;
        boolean contains;
        try {
            matcher = java.util.regex.Pattern.compile("^([a-zA-Z]+[.][a-zA-Z]+)[.]*.*").matcher(str);
            java.util.List<java.lang.String> list = com.getui.gtc.extension.distribution.gbd.d.h.aC;
            if (list == null || list.isEmpty()) {
                com.getui.gtc.extension.distribution.gbd.d.h.aC = new java.util.ArrayList(java.util.Arrays.asList(com.getui.gtc.extension.distribution.gbd.d.d.cg.split(",")));
            }
            if (str.contains(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)) {
                java.lang.String[] split = str.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                java.lang.String str3 = split[0];
                str2 = split[1];
                str = str3;
            } else {
                str2 = null;
            }
            contains = com.getui.gtc.extension.distribution.gbd.d.h.aC.contains(str);
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
        if (!matcher.find() || ((str.startsWith("com.android") && !contains) || str.startsWith("android.process") || str.startsWith("org."))) {
            return null;
        }
        try {
            int i = com.getui.gtc.extension.distribution.gbd.n.k.a(str, 0).applicationInfo.flags;
            if ((i & 1) == 0 || (i & 128) != 0) {
                if (!z || str2 == null) {
                    return str;
                }
                return str + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + str2;
            }
        } catch (java.lang.Exception e) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(e);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:108:0x0095, code lost:
    
        r2.add(r3);
     */
    /* JADX WARN: Removed duplicated region for block: B:104:0x008d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009a A[Catch: all -> 0x0124, TryCatch #1 {all -> 0x0124, blocks: (B:10:0x0049, B:12:0x004f, B:118:0x005e, B:32:0x0083, B:105:0x008d, B:108:0x0095, B:34:0x009a, B:39:0x00aa, B:41:0x00ad, B:43:0x00b5, B:45:0x00b9, B:47:0x00c5, B:52:0x00cb, B:54:0x00ce, B:56:0x00d6, B:58:0x00da, B:60:0x00e6, B:65:0x00ec, B:67:0x00ef, B:69:0x00f7, B:71:0x00fb, B:73:0x0107, B:78:0x010d, B:81:0x0117, B:17:0x0065, B:19:0x0068, B:21:0x0070, B:23:0x0075, B:27:0x007e), top: B:9:0x0049 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:104:0x0132 -> B:82:0x0136). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static java.util.ArrayList<java.lang.String[]> a(java.lang.String str, boolean z, java.lang.String str2) {
        java.lang.String[] split;
        boolean z2;
        boolean z3;
        boolean z4;
        java.lang.Runtime runtime = java.lang.Runtime.getRuntime();
        java.util.ArrayList<java.lang.String[]> arrayList = new java.util.ArrayList<>();
        java.io.BufferedReader bufferedReader = null;
        try {
            try {
                split = com.getui.gtc.extension.distribution.gbd.d.d.bt.split("\\|");
            } catch (java.lang.Throwable th) {
                th = th;
            }
        } catch (java.lang.Exception e) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(e);
        }
        if (split.length != 4) {
            return null;
        }
        java.lang.String[] split2 = split[0].split(",");
        java.lang.String[] split3 = split[1].split(",");
        java.lang.String[] split4 = split[2].split(",");
        java.lang.String[] split5 = split[3].split(",");
        java.io.BufferedReader bufferedReader2 = new java.io.BufferedReader(new java.io.InputStreamReader(runtime.exec(str).getInputStream()));
        while (true) {
            try {
                java.lang.String readLine = bufferedReader2.readLine();
                if (readLine == null) {
                    break;
                }
                if (!readLine.contains("USER")) {
                    if (!z) {
                        if (split3.length > 1 && !split3[0].equals("none")) {
                            boolean z5 = true;
                            for (java.lang.String str3 : split3) {
                                if (readLine.contains(str3)) {
                                    z5 = false;
                                }
                            }
                            if (!z5) {
                                continue;
                            }
                        }
                        java.lang.String[] split6 = readLine.split(" +");
                        int length = split6.length - 1;
                        if (z) {
                        }
                    } else if (readLine.contains("zygote")) {
                        java.lang.String[] split62 = readLine.split(" +");
                        int length2 = split62.length - 1;
                        if (z) {
                            int length3 = split62[length2].split("\\.").length - 1;
                            if (length3 <= 0) {
                                length3 = 0;
                            }
                            if (length3 <= 2) {
                                if (split4.length > 0 && !split4[0].equals("none")) {
                                    int length4 = split4.length;
                                    int i = 0;
                                    while (true) {
                                        if (i >= length4) {
                                            z4 = true;
                                            break;
                                        }
                                        if (!split62[length2].contains(split4[i])) {
                                            z4 = false;
                                            break;
                                        }
                                        i++;
                                    }
                                    if (z4) {
                                    }
                                }
                                if (split2.length > 0 && !split2[0].equals("none")) {
                                    int length5 = split2.length;
                                    int i2 = 0;
                                    while (true) {
                                        if (i2 >= length5) {
                                            z3 = true;
                                            break;
                                        }
                                        if (split62[length2].startsWith(split2[i2])) {
                                            z3 = false;
                                            break;
                                        }
                                        i2++;
                                    }
                                    if (z3) {
                                    }
                                }
                                if (split5.length > 0 && !split5[0].equals("none")) {
                                    int length6 = split5.length;
                                    int i3 = 0;
                                    while (true) {
                                        if (i3 >= length6) {
                                            z2 = true;
                                            break;
                                        }
                                        if (split62[length2].endsWith(split5[i3])) {
                                            z2 = false;
                                            break;
                                        }
                                        i3++;
                                    }
                                    if (z2) {
                                    }
                                }
                                if (split62[2].equals(str2)) {
                                    arrayList.add(split62);
                                }
                            }
                        } else if (split62[length2].equals("zygote")) {
                            break;
                        }
                    }
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                bufferedReader = bufferedReader2;
                try {
                    com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    return arrayList;
                } finally {
                }
            }
        }
        bufferedReader2.close();
        return arrayList;
    }

    public static java.util.List<java.lang.String> a() {
        java.util.ArrayList<java.lang.String[]> a2;
        try {
            java.util.ArrayList<java.lang.String[]> a3 = a("ps -P", true, "");
            if (a3 != null && !a3.isEmpty() && !a3.isEmpty() && (a2 = a("ps -P", false, a3.get(0)[1])) != null && !a2.isEmpty()) {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                java.util.Iterator<java.lang.String[]> it = a2.iterator();
                while (it.hasNext()) {
                    arrayList.add(0, it.next()[9]);
                }
                return arrayList;
            }
            return null;
        } catch (java.lang.Exception e) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(e);
            return null;
        }
    }

    private static java.util.List<java.lang.String> a(java.util.ArrayList<java.lang.String[]> arrayList) {
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        arrayList.getClass();
        java.util.Iterator<java.lang.String[]> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(0, it.next()[9]);
        }
        return arrayList2;
    }

    private static java.util.List<java.lang.String> a(boolean z) {
        com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
        return (java.util.List) com.getui.gtc.extension.distribution.gbd.f.c.a(z, com.getui.gtc.extension.distribution.gbd.f.b.d, "", new com.getui.gtc.extension.distribution.gbd.n.v.AnonymousClass1());
    }

    public static java.util.List<java.lang.String> a(boolean z, boolean z2) {
        java.util.Map<java.lang.String, java.lang.Long> map;
        java.lang.Long valueOf;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (com.getui.gtc.extension.distribution.gbd.d.h.G == null) {
            com.getui.gtc.extension.distribution.gbd.d.h.G = new java.util.HashMap();
        }
        if (z) {
            com.getui.gtc.extension.distribution.gbd.d.h.G.clear();
        }
        for (java.io.File file : new java.io.File("/proc").listFiles(new com.getui.gtc.extension.distribution.gbd.n.v.AnonymousClass2(z2 ? 0 : 2000))) {
            try {
                int parseInt = java.lang.Integer.parseInt(file.getName());
                try {
                    java.lang.String a2 = a(parseInt);
                    if (!android.text.TextUtils.isEmpty(a2)) {
                        a2 = z2 ? a(a2) : a(a2, z);
                    }
                    if (!android.text.TextUtils.isEmpty(a2) && !arrayList.contains(a2)) {
                        arrayList.add(a2);
                        if (!z2) {
                            if (a2.contains(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)) {
                                a2 = a2.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)[0];
                            }
                            long b = b(parseInt);
                            if (!com.getui.gtc.extension.distribution.gbd.d.h.G.containsKey(a2)) {
                                map = com.getui.gtc.extension.distribution.gbd.d.h.G;
                                valueOf = java.lang.Long.valueOf(b);
                            } else if (b < com.getui.gtc.extension.distribution.gbd.d.h.G.get(a2).longValue()) {
                                map = com.getui.gtc.extension.distribution.gbd.d.h.G;
                                valueOf = java.lang.Long.valueOf(b);
                            }
                            map.put(a2, valueOf);
                        }
                    }
                } catch (java.lang.Throwable th) {
                    com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                }
            } catch (java.lang.Exception unused) {
            }
        }
        return arrayList;
    }

    private static long b(int i) {
        try {
            return (com.getui.gtc.extension.distribution.gbd.n.l.C() - android.os.SystemClock.elapsedRealtime()) + (java.lang.Long.parseLong(b(java.lang.String.format("/proc/%d/stat", java.lang.Integer.valueOf(i))).split("\\s+")[21]) * 10);
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return 0L;
        }
    }

    private static java.lang.String b(java.lang.String str) {
        java.io.BufferedReader bufferedReader;
        java.io.FileReader fileReader;
        try {
            try {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                fileReader = new java.io.FileReader(str);
                try {
                    bufferedReader = new java.io.BufferedReader(fileReader);
                    try {
                        java.lang.String str2 = "";
                        for (java.lang.String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                            sb.append(str2);
                            sb.append(readLine);
                            str2 = "\n";
                        }
                        java.lang.String sb2 = sb.toString();
                        try {
                            fileReader.close();
                        } catch (java.lang.Exception e) {
                            com.getui.gtc.extension.distribution.gbd.n.j.a(e);
                        }
                        try {
                            bufferedReader.close();
                        } catch (java.lang.Exception e2) {
                            com.getui.gtc.extension.distribution.gbd.n.j.a(e2);
                        }
                        return sb2;
                    } catch (java.lang.Throwable th) {
                        th = th;
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (java.lang.Exception e3) {
                                com.getui.gtc.extension.distribution.gbd.n.j.a(e3);
                            }
                        }
                        if (bufferedReader == null) {
                            throw th;
                        }
                        try {
                            bufferedReader.close();
                            throw th;
                        } catch (java.lang.Exception e4) {
                            com.getui.gtc.extension.distribution.gbd.n.j.a(e4);
                            throw th;
                        }
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    bufferedReader = null;
                }
            } catch (java.lang.Throwable th3) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th3);
                return null;
            }
        } catch (java.lang.Throwable th4) {
            th = th4;
            bufferedReader = null;
            fileReader = null;
        }
    }
}
