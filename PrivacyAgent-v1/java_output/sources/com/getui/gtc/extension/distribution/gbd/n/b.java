package com.getui.gtc.extension.distribution.gbd.n;

/* loaded from: classes22.dex */
public final class b {
    private static final java.lang.String a = "GBD_AlUtils";
    private static java.util.List<android.content.pm.PackageInfo> b = java.util.Collections.emptyList();
    private static java.util.List<android.content.pm.PackageInfo> c = java.util.Collections.emptyList();
    private static java.util.List<android.content.pm.PackageInfo> d = null;

    /* renamed from: com.getui.gtc.extension.distribution.gbd.n.b$1, reason: invalid class name */
    public static class AnonymousClass1 extends com.getui.gtc.extension.distribution.gbd.f.f {
        @Override // com.getui.gtc.extension.distribution.gbd.f.f
        public final void a(com.getui.gtc.dim.DimRequest.Builder builder) {
            builder.storageCacheValidTime(0L);
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.n.b$10, reason: invalid class name */
    public static class AnonymousClass10 implements com.getui.gtc.extension.distribution.gbd.f.j<java.lang.String, java.util.List<java.lang.String>> {
        private static java.util.List<java.lang.String> a() {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            try {
                byte[] a = com.getui.gtc.extension.distribution.gbd.n.i.a(com.getui.gtc.extension.distribution.gbd.n.b.d());
                if (a != null) {
                    java.lang.String[] split = new java.lang.String(com.getui.gtc.extension.distribution.gbd.n.n.b(com.getui.gtc.extension.distribution.gbd.n.t.a(a, com.getui.gtc.extension.distribution.gbd.d.g.ad))).split("\\r");
                    com.getui.gtc.extension.distribution.gbd.n.j.b(com.getui.gtc.extension.distribution.gbd.n.b.a, "local 24al len = " + split.length);
                    for (java.lang.String str : split) {
                        if (!android.text.TextUtils.isEmpty(str)) {
                            java.lang.String str2 = com.getui.gtc.extension.distribution.gbd.d.c.a;
                            android.content.pm.PackageInfo f = com.getui.gtc.extension.distribution.gbd.n.l.f(str);
                            if (f != null) {
                                arrayList.add(f.packageName);
                            }
                        }
                    }
                }
            } catch (java.lang.Throwable th) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            }
            return arrayList;
        }

        @Override // com.getui.gtc.extension.distribution.gbd.f.j
        public final /* bridge */ /* synthetic */ java.util.List<java.lang.String> a(java.lang.String str) {
            return a();
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.n.b$11, reason: invalid class name */
    public static class AnonymousClass11 implements com.getui.gtc.extension.distribution.gbd.g.c {
        @Override // com.getui.gtc.extension.distribution.gbd.g.c
        public final void a(java.lang.Object obj) {
            if (obj != null) {
                com.getui.gtc.extension.distribution.gbd.d.h.aN = false;
            }
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.n.b$12, reason: invalid class name */
    public static class AnonymousClass12 implements com.getui.gtc.extension.distribution.gbd.g.c {
        @Override // com.getui.gtc.extension.distribution.gbd.g.c
        public final void a(java.lang.Object obj) {
            java.lang.String str;
            if (obj != null) {
                com.getui.gtc.extension.distribution.gbd.d.h.aL = false;
                str = "18al ds.";
            } else {
                str = "18al df.";
            }
            com.getui.gtc.extension.distribution.gbd.n.j.b(com.getui.gtc.extension.distribution.gbd.n.b.a, str);
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.n.b$13, reason: invalid class name */
    public static class AnonymousClass13 implements com.getui.gtc.extension.distribution.gbd.g.c {
        @Override // com.getui.gtc.extension.distribution.gbd.g.c
        public final void a(java.lang.Object obj) {
            if (obj != null) {
                com.getui.gtc.extension.distribution.gbd.d.h.aO = false;
            }
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.n.b$2, reason: invalid class name */
    public static class AnonymousClass2 implements com.getui.gtc.extension.distribution.gbd.g.c {
        @Override // com.getui.gtc.extension.distribution.gbd.g.c
        public final void a(java.lang.Object obj) {
            try {
                if (obj == null) {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(com.getui.gtc.extension.distribution.gbd.n.b.a, "wlp dl f.");
                    return;
                }
                com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                com.getui.gtc.extension.distribution.gbd.f.a.b.a(false);
                com.getui.gtc.extension.distribution.gbd.n.j.b(com.getui.gtc.extension.distribution.gbd.n.b.a, "wlp dl s.");
            } catch (java.lang.Throwable th) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            }
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.n.b$3, reason: invalid class name */
    public static class AnonymousClass3 implements com.getui.gtc.extension.distribution.gbd.f.j<java.lang.String[], java.lang.String> {
        final /* synthetic */ java.lang.String[] a;

        public AnonymousClass3(java.lang.String[] strArr) {
            this.a = strArr;
        }

        private java.lang.String a() {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            for (java.lang.String str : this.a) {
                try {
                    sb.append(str + "#" + com.getui.gtc.extension.distribution.gbd.n.b.b(com.getui.gtc.extension.distribution.gbd.n.k.a(str, 0)) + ",");
                } catch (java.lang.Throwable th) {
                    com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                }
            }
            if (sb.toString().endsWith(",")) {
                sb.deleteCharAt(sb.length() - 1);
            }
            return sb.toString();
        }

        @Override // com.getui.gtc.extension.distribution.gbd.f.j
        public final /* bridge */ /* synthetic */ java.lang.String a(java.lang.String[] strArr) {
            return a();
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.n.b$4, reason: invalid class name */
    public static class AnonymousClass4 implements com.getui.gtc.extension.distribution.gbd.f.j<java.lang.String, java.lang.String> {
        private static java.lang.String a() {
            java.nio.file.Path path;
            java.nio.file.attribute.BasicFileAttributes readAttributes;
            java.nio.file.attribute.FileTime creationTime;
            long millis;
            java.nio.file.attribute.FileTime lastAccessTime;
            long millis2;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            try {
                java.lang.String absolutePath = com.getui.gtc.extension.distribution.gbd.d.c.i.getAbsolutePath();
                java.util.Iterator it = new java.util.ArrayList(java.util.Arrays.asList(com.getui.gtc.extension.distribution.gbd.d.d.cI.split(","))).iterator();
                while (it.hasNext()) {
                    java.lang.String str = (java.lang.String) it.next();
                    try {
                        path = new java.io.File(absolutePath + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + str).toPath();
                        readAttributes = java.nio.file.Files.readAttributes(path, (java.lang.Class<java.nio.file.attribute.BasicFileAttributes>) java.nio.file.attribute.BasicFileAttributes.class, new java.nio.file.LinkOption[0]);
                        creationTime = readAttributes.creationTime();
                        millis = creationTime.toMillis();
                        lastAccessTime = readAttributes.lastAccessTime();
                        millis2 = lastAccessTime.toMillis();
                        sb.append(str + "#" + com.getui.gtc.extension.distribution.gbd.n.b.a(com.getui.gtc.extension.distribution.gbd.n.k.a(str, 0)) + "#" + millis + "#" + millis2);
                        sb.append(",");
                    } catch (java.lang.Throwable th) {
                        com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                    }
                }
                if (sb.toString().endsWith(",")) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } catch (java.lang.Throwable th2) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th2);
            }
            return sb.toString();
        }

        @Override // com.getui.gtc.extension.distribution.gbd.f.j
        public final /* bridge */ /* synthetic */ java.lang.String a(java.lang.String str) {
            return a();
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.n.b$5, reason: invalid class name */
    public static class AnonymousClass5 implements com.getui.gtc.extension.distribution.gbd.f.j<java.lang.String[], java.lang.String> {
        final /* synthetic */ java.util.List a;

        public AnonymousClass5(java.util.List list) {
            this.a = list;
        }

        /* renamed from: a, reason: avoid collision after fix types in other method */
        private java.lang.String a2(java.lang.String[] strArr) {
            for (java.lang.String str : strArr) {
                if (com.getui.gtc.extension.distribution.gbd.n.b.b(str)) {
                    this.a.add(str);
                }
            }
            return null;
        }

        @Override // com.getui.gtc.extension.distribution.gbd.f.j
        public final /* synthetic */ java.lang.String a(java.lang.String[] strArr) {
            for (java.lang.String str : strArr) {
                if (com.getui.gtc.extension.distribution.gbd.n.b.b(str)) {
                    this.a.add(str);
                }
            }
            return null;
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.n.b$6, reason: invalid class name */
    public static class AnonymousClass6 extends com.getui.gtc.extension.distribution.gbd.f.f {
        @Override // com.getui.gtc.extension.distribution.gbd.f.f
        public final void a(com.getui.gtc.dim.DimRequest.Builder builder) {
            builder.storageCacheValidTime(0L);
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.n.b$7, reason: invalid class name */
    public static class AnonymousClass7 extends com.getui.gtc.extension.distribution.gbd.f.f {
        @Override // com.getui.gtc.extension.distribution.gbd.f.f
        public final void a(com.getui.gtc.dim.DimRequest.Builder builder) {
            builder.storageCacheValidTime(0L);
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.n.b$8, reason: invalid class name */
    public static class AnonymousClass8 extends com.getui.gtc.extension.distribution.gbd.f.f {
        @Override // com.getui.gtc.extension.distribution.gbd.f.f
        public final void a(com.getui.gtc.dim.DimRequest.Builder builder) {
            builder.storageCacheValidTime(0L);
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.n.b$9, reason: invalid class name */
    public static class AnonymousClass9 implements java.io.FileFilter {
        @Override // java.io.FileFilter
        public final boolean accept(java.io.File file) {
            return file.isDirectory() && file.getName().contains(".");
        }
    }

    public static long a(android.content.pm.PackageInfo packageInfo) {
        try {
            if (packageInfo.packageName.equalsIgnoreCase(com.getui.gtc.extension.distribution.gbd.d.c.c)) {
                return packageInfo.firstInstallTime;
            }
            if (com.getui.gtc.extension.distribution.gbd.d.d.dv.equalsIgnoreCase("none") || com.getui.gtc.extension.distribution.gbd.d.d.dv.toLowerCase().contains(com.getui.gtc.extension.distribution.gbd.n.l.w().toLowerCase())) {
                return 0L;
            }
            return packageInfo.firstInstallTime;
        } catch (java.lang.Throwable unused) {
            return 0L;
        }
    }

    public static synchronized java.util.List<android.content.pm.PackageInfo> a() {
        java.lang.String str;
        java.lang.String str2;
        java.util.List<android.content.pm.PackageInfo> c2;
        synchronized (com.getui.gtc.extension.distribution.gbd.n.b.class) {
            try {
                java.util.List<android.content.pm.PackageInfo> list = d;
                if (list == null || list.isEmpty()) {
                    boolean z = true;
                    if (!q()) {
                        switch (com.getui.gtc.extension.distribution.gbd.d.d.ad) {
                            case 0:
                            case 1:
                            case 3:
                                str = a;
                                str2 = "common fetch al f.";
                                break;
                            case 2:
                                com.getui.gtc.extension.distribution.gbd.n.j.b(a, "common fetch al by query.");
                                com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
                                java.util.List list2 = (java.util.List) com.getui.gtc.extension.distribution.gbd.f.c.b(true, com.getui.gtc.extension.distribution.gbd.f.e.b.K, (com.getui.gtc.extension.distribution.gbd.f.f) new com.getui.gtc.extension.distribution.gbd.n.b.AnonymousClass8());
                                if (list2 != null && list2.size() > 0) {
                                    d = new java.util.ArrayList(list2);
                                    break;
                                }
                                break;
                            case 4:
                                com.getui.gtc.extension.distribution.gbd.n.j.b(a, "common fetch al list by sd.");
                                c2 = c(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_ID);
                                d = c2;
                                break;
                            case 5:
                                com.getui.gtc.extension.distribution.gbd.n.j.b(a, "common fetch al list by col.");
                                c2 = r();
                                d = c2;
                                break;
                            case 6:
                                com.getui.gtc.extension.distribution.gbd.n.j.b(a, "common fetch al by pm.");
                                c2 = b(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_ID);
                                d = c2;
                                break;
                        }
                    } else {
                        com.getui.gtc.extension.distribution.gbd.f.c unused2 = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
                        java.util.List list3 = (java.util.List) com.getui.gtc.extension.distribution.gbd.f.c.b(true, com.getui.gtc.extension.distribution.gbd.f.e.b.N, (com.getui.gtc.extension.distribution.gbd.f.f) new com.getui.gtc.extension.distribution.gbd.n.b.AnonymousClass7());
                        if (list3 != null && list3.size() > 0) {
                            d = new java.util.ArrayList(list3);
                        }
                        java.util.List<android.content.pm.PackageInfo> list4 = d;
                        if (list4 == null || list4.isEmpty()) {
                            z = false;
                        }
                        str = a;
                        str2 = "fetch al by gtc, enable = ".concat(java.lang.String.valueOf(z));
                    }
                    com.getui.gtc.extension.distribution.gbd.n.j.b(str, str2);
                }
                if (d == null) {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(a, "common read al error, return empty.");
                    return java.util.Collections.emptyList();
                }
                com.getui.gtc.extension.distribution.gbd.n.j.b(a, "al size = " + d.size());
                return d;
            } catch (java.lang.Throwable th) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                return java.util.Collections.emptyList();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x008c A[Catch: all -> 0x009b, TRY_LEAVE, TryCatch #1 {all -> 0x009b, blocks: (B:4:0x0003, B:6:0x000b, B:8:0x001d, B:10:0x0023, B:12:0x002a, B:15:0x0032, B:16:0x003e, B:18:0x008c, B:26:0x0042, B:27:0x0044, B:29:0x0048, B:30:0x0054, B:31:0x0060, B:33:0x0079, B:35:0x007f), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0099 A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static synchronized java.util.List<android.content.pm.PackageInfo> a(int i) {
        java.lang.String str;
        java.lang.String str2;
        synchronized (com.getui.gtc.extension.distribution.gbd.n.b.class) {
            try {
                boolean z = true;
                java.util.List<android.content.pm.PackageInfo> list = null;
                if (!q()) {
                    switch (com.getui.gtc.extension.distribution.gbd.d.d.ae) {
                        case 0:
                        case 1:
                        case 3:
                            str = a;
                            str2 = "28 fetch al f.";
                            break;
                        case 2:
                            com.getui.gtc.extension.distribution.gbd.n.j.b(a, "28 fetch al by query.");
                            com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
                            java.util.List list2 = (java.util.List) com.getui.gtc.extension.distribution.gbd.f.c.b(true, com.getui.gtc.extension.distribution.gbd.f.e.b.K, (com.getui.gtc.extension.distribution.gbd.f.f) new com.getui.gtc.extension.distribution.gbd.n.b.AnonymousClass6());
                            if (list2 != null && list2.size() > 0) {
                                list = new java.util.ArrayList<>(list2);
                                break;
                            }
                            break;
                        case 4:
                        case 5:
                            com.getui.gtc.extension.distribution.gbd.n.j.b(a, "28 fetch al by sd.");
                            list = c(i);
                            break;
                        case 6:
                            com.getui.gtc.extension.distribution.gbd.n.j.b(a, "28 fetch al by pm.");
                            list = b(i);
                            break;
                    }
                    if (list == null) {
                        return list;
                    }
                    com.getui.gtc.extension.distribution.gbd.n.j.b(a, "28 al empty.");
                    return java.util.Collections.emptyList();
                }
                com.getui.gtc.extension.distribution.gbd.f.c unused2 = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
                java.util.List list3 = (java.util.List) com.getui.gtc.extension.distribution.gbd.f.c.b(true, com.getui.gtc.extension.distribution.gbd.f.e.b.N, (com.getui.gtc.extension.distribution.gbd.f.f) new com.getui.gtc.extension.distribution.gbd.n.b.AnonymousClass1());
                if (list3 != null && list3.size() > 0) {
                    list = new java.util.ArrayList<>(list3);
                }
                if (list == null || list.isEmpty()) {
                    z = false;
                }
                str = a;
                str2 = "fetch al by gtc, enable = ".concat(java.lang.String.valueOf(z));
                com.getui.gtc.extension.distribution.gbd.n.j.b(str, str2);
                if (list == null) {
                }
            } catch (java.lang.Throwable th) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                return java.util.Collections.emptyList();
            }
        }
    }

    private static java.util.List<java.lang.String> a(boolean z) {
        com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
        return (java.util.List) com.getui.gtc.extension.distribution.gbd.f.c.a(z, com.getui.gtc.extension.distribution.gbd.f.b.b, "", new com.getui.gtc.extension.distribution.gbd.n.b.AnonymousClass10());
    }

    public static void a(java.lang.String str) {
        java.lang.String v = v();
        com.getui.gtc.extension.distribution.gbd.n.j.b(a, "run path f name = ".concat(java.lang.String.valueOf(v)));
        com.getui.gtc.extension.distribution.gbd.n.i.a(com.getui.gtc.extension.distribution.gbd.n.t.b(com.getui.gtc.extension.distribution.gbd.n.n.a(str.getBytes()), com.getui.gtc.extension.distribution.gbd.d.g.ad), v);
    }

    public static java.lang.String b(android.content.pm.PackageInfo packageInfo) {
        try {
            return packageInfo.packageName.equalsIgnoreCase(com.getui.gtc.extension.distribution.gbd.d.c.c) ? packageInfo.applicationInfo.sourceDir : (com.getui.gtc.extension.distribution.gbd.d.d.dv.equalsIgnoreCase("none") || com.getui.gtc.extension.distribution.gbd.d.d.dv.toLowerCase().contains(com.getui.gtc.extension.distribution.gbd.n.l.w().toLowerCase())) ? "" : packageInfo.applicationInfo.sourceDir;
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    private static java.util.List<android.content.pm.PackageInfo> b(int i) {
        java.lang.Process process;
        java.io.BufferedReader bufferedReader = null;
        try {
            android.content.pm.PackageManager packageManager = com.getui.gtc.extension.distribution.gbd.d.c.d.getPackageManager();
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.lang.String str = new java.lang.String(android.util.Base64.decode("cG0gbGlzdCBwYWNrYWdlcw==", 0));
            java.lang.Class<?> cls = java.lang.Class.forName(new java.lang.String(android.util.Base64.decode("amF2YS5sYW5nLlJ1bnRpbWU=", 0)));
            java.lang.reflect.Method declaredMethod = cls.getDeclaredMethod(new java.lang.String(android.util.Base64.decode("Z2V0UnVudGltZQ==", 0)), new java.lang.Class[0]);
            declaredMethod.setAccessible(true);
            java.lang.Object invoke = declaredMethod.invoke(null, new java.lang.Object[0]);
            java.lang.reflect.Method declaredMethod2 = cls.getDeclaredMethod(new java.lang.String(android.util.Base64.decode("ZXhlYw==", 0)), java.lang.String.class);
            declaredMethod2.setAccessible(true);
            process = (java.lang.Process) declaredMethod2.invoke(invoke, str);
            try {
                java.io.BufferedReader bufferedReader2 = new java.io.BufferedReader(new java.io.InputStreamReader(process.getInputStream()));
                while (true) {
                    try {
                        java.lang.String readLine = bufferedReader2.readLine();
                        if (readLine != null) {
                            try {
                                arrayList.add(packageManager.getPackageInfo(readLine.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)[1], i));
                            } catch (java.lang.Throwable unused) {
                            }
                        } else {
                            try {
                                break;
                            } catch (java.lang.Throwable unused2) {
                            }
                        }
                    } catch (java.lang.Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        try {
                            com.getui.gtc.extension.distribution.gbd.n.j.a.a.a.w(th);
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (java.lang.Throwable unused3) {
                                }
                            }
                            if (process != null) {
                                try {
                                    process.destroy();
                                } catch (java.lang.Throwable unused4) {
                                }
                            }
                            return java.util.Collections.emptyList();
                        } finally {
                        }
                    }
                }
                bufferedReader2.close();
                try {
                    process.destroy();
                } catch (java.lang.Throwable unused5) {
                }
                return arrayList;
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            process = null;
        }
    }

    public static boolean b() {
        try {
            java.lang.String str = (java.lang.String) com.getui.gtc.BuildConfig.class.getField("VERSION_NAME").get(null);
            if (!android.text.TextUtils.isEmpty(str) && str.startsWith("GTC-")) {
                java.lang.String[] split = str.substring(4).split("\\.");
                if (split.length >= 4) {
                    int parseInt = java.lang.Integer.parseInt(split[0]);
                    int parseInt2 = java.lang.Integer.parseInt(split[1]);
                    return (parseInt == 3 && parseInt2 == 1 && java.lang.Integer.parseInt(split[2]) >= 12 && java.lang.Integer.parseInt(split[3]) >= 0) || (parseInt == 3 && parseInt2 > 1) || parseInt > 3;
                }
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
        return false;
    }

    public static boolean b(java.lang.String str) {
        if (!android.text.TextUtils.isEmpty(str)) {
            if (com.getui.gtc.extension.distribution.gbd.d.d.cK) {
                try {
                    com.getui.gtc.extension.distribution.gbd.n.k.a(str, 0);
                    com.getui.gtc.extension.distribution.gbd.n.j.a(a, "specific " + str + " p info hit success");
                    return true;
                } catch (java.lang.Throwable th) {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(th);
                }
            }
            try {
                java.io.File file = new java.io.File("/data/data/".concat(java.lang.String.valueOf(str)));
                java.io.File file2 = new java.io.File("/sdcard/Android/data/".concat(java.lang.String.valueOf(str)));
                if (com.getui.gtc.extension.distribution.gbd.n.x.a(3, 1) && file.exists()) {
                    com.getui.gtc.extension.distribution.gbd.n.j.a(a, "specific " + str + " f d d hit success");
                    return file.exists();
                }
                if (com.getui.gtc.extension.distribution.gbd.n.x.a(1, 1) && file2.exists()) {
                    com.getui.gtc.extension.distribution.gbd.n.j.a(a, "specific " + str + " f a d hit success");
                    return file2.exists();
                }
            } catch (java.lang.Throwable th2) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th2);
            }
        }
        com.getui.gtc.extension.distribution.gbd.n.j.a(a, "specific " + str + " hit fail");
        return false;
    }

    private static java.lang.Process c(java.lang.String str) {
        java.lang.Class<?> cls = java.lang.Class.forName(new java.lang.String(android.util.Base64.decode("amF2YS5sYW5nLlJ1bnRpbWU=", 0)));
        java.lang.reflect.Method declaredMethod = cls.getDeclaredMethod(new java.lang.String(android.util.Base64.decode("Z2V0UnVudGltZQ==", 0)), new java.lang.Class[0]);
        declaredMethod.setAccessible(true);
        java.lang.Object invoke = declaredMethod.invoke(null, new java.lang.Object[0]);
        java.lang.reflect.Method declaredMethod2 = cls.getDeclaredMethod(new java.lang.String(android.util.Base64.decode("ZXhlYw==", 0)), java.lang.String.class);
        declaredMethod2.setAccessible(true);
        return (java.lang.Process) declaredMethod2.invoke(invoke, str);
    }

    public static java.lang.String c() {
        java.util.ArrayList arrayList = new java.util.ArrayList(java.util.Arrays.asList(com.getui.gtc.extension.distribution.gbd.d.h.u.split("&")));
        com.getui.gtc.extension.distribution.gbd.n.j.a(a, "active 24 old al = " + com.getui.gtc.extension.distribution.gbd.d.h.u);
        java.util.List<android.content.pm.PackageInfo> a2 = a();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (android.content.pm.PackageInfo packageInfo : a2) {
            if ((packageInfo.applicationInfo.flags & 1) == 0 && !arrayList.contains(packageInfo.packageName)) {
                java.lang.String str = packageInfo.packageName;
                sb.append("&");
                sb.append(str);
                arrayList.add(str);
            }
        }
        com.getui.gtc.extension.distribution.gbd.n.j.a(a, "active al to service gtc filter = ".concat(java.lang.String.valueOf(sb)));
        com.getui.gtc.extension.distribution.gbd.n.j.a(a, "124 c en = " + com.getui.gtc.extension.distribution.gbd.d.d.de);
        if (com.getui.gtc.extension.distribution.gbd.d.d.de) {
            int i = com.getui.gtc.extension.distribution.gbd.d.h.aZ;
            int i2 = Integer.MAX_VALUE;
            if (i != Integer.MAX_VALUE) {
                i2 = i + 1;
                com.getui.gtc.extension.distribution.gbd.d.h.aZ = i2;
            }
            com.getui.gtc.extension.distribution.gbd.f.a.b.a();
            com.getui.gtc.extension.distribution.gbd.d.h.aZ = i2;
            com.getui.gtc.extension.distribution.gbd.n.j.a("GBD_RDM", "124 collision al c : ".concat(java.lang.String.valueOf(i2)));
            com.getui.gtc.extension.distribution.gbd.f.a.b.a(332, java.lang.String.valueOf(i2));
            boolean c2 = com.getui.gtc.extension.distribution.gbd.n.l.c(com.getui.gtc.extension.distribution.gbd.d.c.d);
            boolean a3 = com.getui.gtc.extension.distribution.gbd.n.l.a();
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder("isAdbModeSafe = ");
            sb2.append(!c2);
            sb2.append(", isAppDebug = ");
            sb2.append(a3);
            com.getui.gtc.extension.distribution.gbd.n.j.a(a, sb2.toString());
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            com.getui.gtc.extension.distribution.gbd.n.j.a(a, "124 c current c = " + i2 + ", interval time = " + (currentTimeMillis - com.getui.gtc.extension.distribution.gbd.d.h.ba) + " , 18w c en = " + com.getui.gtc.extension.distribution.gbd.d.d.dd);
            if (i2 > com.getui.gtc.extension.distribution.gbd.d.d.df && currentTimeMillis - com.getui.gtc.extension.distribution.gbd.d.h.ba >= com.getui.gtc.extension.distribution.gbd.d.d.dg * 1000 && !c2 && !a3) {
                com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                com.getui.gtc.extension.distribution.gbd.d.h.ba = currentTimeMillis;
                com.getui.gtc.extension.distribution.gbd.n.j.a("GBD_RDM", "124 last al time : ".concat(java.lang.String.valueOf(currentTimeMillis)));
                com.getui.gtc.extension.distribution.gbd.f.a.b.a(com.autonavi.amap.mapcore.AMapEngineUtils.ARROW_LINE_SHADOW_TEXTURE_ID, java.lang.String.valueOf(currentTimeMillis));
                com.getui.gtc.extension.distribution.gbd.n.j.b(a, "24 al-c start");
                boolean z = com.getui.gtc.extension.distribution.gbd.d.d.dd;
                com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
                java.util.List<java.lang.String> list = (java.util.List) com.getui.gtc.extension.distribution.gbd.f.c.a(z, com.getui.gtc.extension.distribution.gbd.f.b.b, "", new com.getui.gtc.extension.distribution.gbd.n.b.AnonymousClass10());
                com.getui.gtc.extension.distribution.gbd.n.j.b(a, "24 al-c end");
                if (list != null && !list.isEmpty()) {
                    list.removeAll(arrayList);
                    com.getui.gtc.extension.distribution.gbd.n.j.a(a, "active al to service 1.8w filter = ".concat(java.lang.String.valueOf(list)));
                    for (java.lang.String str2 : list) {
                        sb.append("&");
                        sb.append(str2);
                        arrayList.add(str2);
                    }
                }
                java.util.List<java.lang.String> x = x();
                x.removeAll(arrayList);
                com.getui.gtc.extension.distribution.gbd.n.j.a(a, "active al to service collision special = ".concat(java.lang.String.valueOf(x)));
                for (java.lang.String str3 : x) {
                    sb.append("&");
                    sb.append(str3);
                }
            }
        }
        if (!android.text.TextUtils.isEmpty(sb)) {
            com.getui.gtc.extension.distribution.gbd.d.h.u += sb.substring(android.text.TextUtils.isEmpty(com.getui.gtc.extension.distribution.gbd.d.h.u) ? 1 : 0);
        }
        com.getui.gtc.extension.distribution.gbd.n.j.a(a, "24 new al to db form active = " + com.getui.gtc.extension.distribution.gbd.d.h.u);
        com.getui.gtc.extension.distribution.gbd.f.a.b.a();
        com.getui.gtc.extension.distribution.gbd.f.a.b.f(com.getui.gtc.extension.distribution.gbd.d.h.u);
        return com.getui.gtc.extension.distribution.gbd.d.h.u;
    }

    public static java.lang.String c(android.content.pm.PackageInfo packageInfo) {
        if (!com.getui.gtc.extension.distribution.gbd.d.d.dw) {
            return "";
        }
        try {
            java.lang.String str = (java.lang.String) com.getui.gtc.extension.distribution.gbd.d.c.d.getPackageManager().getApplicationLabel(packageInfo.applicationInfo);
            try {
                if (!android.text.TextUtils.isEmpty(str)) {
                    str = str.replace("|", "").replace("#", "").replace(",", "");
                }
            } catch (java.lang.Throwable unused) {
            }
            return str;
        } catch (java.lang.Throwable unused2) {
            return "";
        }
    }

    private static java.util.List<android.content.pm.PackageInfo> c(int i) {
        java.util.List<android.content.pm.PackageInfo> list = b;
        if (list != null && list.size() > 0) {
            return b;
        }
        boolean a2 = com.getui.gtc.extension.distribution.gbd.n.l.a(com.getui.gtc.extension.distribution.gbd.d.c.d);
        int i2 = android.os.Build.VERSION.SDK_INT;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (i2 < 30 && a2) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, "common fetch al by col use sd.");
            java.io.File[] listFiles = new java.io.File(android.os.Environment.getExternalStorageDirectory().getPath() + "/Android/data").listFiles(new com.getui.gtc.extension.distribution.gbd.n.b.AnonymousClass9());
            if (listFiles != null) {
                for (java.io.File file : listFiles) {
                    android.content.pm.PackageInfo a3 = com.getui.gtc.extension.distribution.gbd.n.l.a(file.getName(), i);
                    if (a3 != null) {
                        arrayList.add(a3);
                    }
                }
            }
        }
        b = arrayList;
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String d() {
        java.lang.String str;
        try {
            str = com.getui.gtc.extension.distribution.gbd.n.ad.a("bc3a83e2034ea799" + com.getui.gtc.extension.distribution.gbd.d.c.d.getPackageName());
            try {
                if (!android.text.TextUtils.isEmpty(str)) {
                    str = str.substring(10, str.length() - 10);
                }
            } catch (java.lang.Throwable th) {
                th = th;
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                if (android.text.TextUtils.isEmpty(str)) {
                }
                return com.getui.gtc.extension.distribution.gbd.d.c.d.getFilesDir().getPath() + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + (android.text.TextUtils.isEmpty(str) ? "bc3a83e2034ea799" : str);
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            str = "bc3a83e2034ea799";
        }
        return com.getui.gtc.extension.distribution.gbd.d.c.d.getFilesDir().getPath() + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + (android.text.TextUtils.isEmpty(str) ? "bc3a83e2034ea799" : str);
    }

    public static void e() {
        try {
            boolean z = java.lang.System.currentTimeMillis() - com.getui.gtc.extension.distribution.gbd.d.h.aE > 86400000;
            boolean i = com.getui.gtc.extension.distribution.gbd.n.l.i(com.getui.gtc.extension.distribution.gbd.d.c.d);
            boolean z2 = com.getui.gtc.extension.distribution.gbd.d.h.aN;
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, "24d 18al, isC = " + i + ", needUp = " + z2);
            if (z && i && z2) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(a, "start d 18al for 24.");
                if (!android.text.TextUtils.isEmpty(com.getui.gtc.extension.distribution.gbd.d.h.aM) && !com.getui.gtc.extension.distribution.gbd.d.h.aM.equalsIgnoreCase("none")) {
                    if (!android.text.TextUtils.isEmpty(com.getui.gtc.extension.distribution.gbd.d.h.aY) && !new java.io.File(d()).exists()) {
                        com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                        com.getui.gtc.extension.distribution.gbd.f.a.b.b("");
                    }
                    com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                    com.getui.gtc.extension.distribution.gbd.f.a.b.c(java.lang.System.currentTimeMillis());
                    com.getui.gtc.extension.distribution.gbd.g.a.b bVar = new com.getui.gtc.extension.distribution.gbd.g.a.b(new com.getui.gtc.extension.distribution.gbd.n.b.AnonymousClass11(), 124, com.getui.gtc.extension.distribution.gbd.d.h.aY);
                    bVar.e = com.getui.gtc.extension.distribution.gbd.d.h.aM;
                    com.getui.gtc.extension.distribution.gbd.l.a.C0311a.a.a(new com.getui.gtc.extension.distribution.gbd.g.a(bVar));
                    return;
                }
                com.getui.gtc.extension.distribution.gbd.n.j.a(a, "18al for 24 url empty, cancel.");
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, th.toString());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String f() {
        java.lang.String str;
        java.lang.String str2 = com.getui.gtc.extension.distribution.gbd.d.g.ad;
        try {
            str = com.getui.gtc.extension.distribution.gbd.n.ad.a(com.getui.gtc.extension.distribution.gbd.d.g.ad + com.getui.gtc.extension.distribution.gbd.d.c.d.getPackageName());
            try {
                if (!android.text.TextUtils.isEmpty(str)) {
                    str = str.substring(10, str.length() - 10);
                }
            } catch (java.lang.Throwable th) {
                th = th;
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                if (!android.text.TextUtils.isEmpty(str)) {
                }
                return com.getui.gtc.extension.distribution.gbd.d.c.d.getFilesDir().getPath() + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + str2;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            str = com.getui.gtc.extension.distribution.gbd.d.g.ad;
        }
        if (!android.text.TextUtils.isEmpty(str)) {
            str2 = str;
        }
        return com.getui.gtc.extension.distribution.gbd.d.c.d.getFilesDir().getPath() + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + str2;
    }

    public static void g() {
        try {
            java.lang.String f = f();
            boolean z = java.lang.System.currentTimeMillis() - com.getui.gtc.extension.distribution.gbd.d.h.aD > 86400000;
            boolean i = com.getui.gtc.extension.distribution.gbd.n.l.i(com.getui.gtc.extension.distribution.gbd.d.c.d);
            boolean z2 = com.getui.gtc.extension.distribution.gbd.d.h.aL;
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, "d 18al, isC = " + i + ", need up = " + z2);
            if (z && i) {
                if (!new java.io.File(f).exists() || z2) {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(a, "start d 18al.");
                    if (android.text.TextUtils.isEmpty(com.getui.gtc.extension.distribution.gbd.d.d.bR)) {
                        com.getui.gtc.extension.distribution.gbd.n.j.b(a, "18al url empty, cancel.");
                        return;
                    }
                    com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                    com.getui.gtc.extension.distribution.gbd.f.a.b.b(java.lang.System.currentTimeMillis());
                    com.getui.gtc.extension.distribution.gbd.g.a.b bVar = new com.getui.gtc.extension.distribution.gbd.g.a.b(new com.getui.gtc.extension.distribution.gbd.n.b.AnonymousClass12(), 28, null);
                    bVar.e = com.getui.gtc.extension.distribution.gbd.d.d.bR;
                    com.getui.gtc.extension.distribution.gbd.l.a.C0311a.a.a(new com.getui.gtc.extension.distribution.gbd.g.a(bVar));
                }
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, th.toString());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String h() {
        java.lang.String str;
        try {
            str = com.getui.gtc.extension.distribution.gbd.n.ad.a("199c9ba809a7228e" + com.getui.gtc.extension.distribution.gbd.d.c.d.getPackageName());
            try {
                if (!android.text.TextUtils.isEmpty(str)) {
                    str = str.substring(10, str.length() - 10);
                }
            } catch (java.lang.Throwable th) {
                th = th;
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                if (android.text.TextUtils.isEmpty(str)) {
                }
                return com.getui.gtc.extension.distribution.gbd.d.c.d.getFilesDir().getPath() + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + (android.text.TextUtils.isEmpty(str) ? "199c9ba809a7228e" : str);
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            str = "199c9ba809a7228e";
        }
        return com.getui.gtc.extension.distribution.gbd.d.c.d.getFilesDir().getPath() + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + (android.text.TextUtils.isEmpty(str) ? "199c9ba809a7228e" : str);
    }

    public static void i() {
        try {
            boolean z = java.lang.System.currentTimeMillis() - com.getui.gtc.extension.distribution.gbd.d.h.aW > 86400000;
            boolean i = com.getui.gtc.extension.distribution.gbd.n.l.i(com.getui.gtc.extension.distribution.gbd.d.c.d);
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, "d niche al, isNetworkConnected = " + i + ", niche al need up = " + com.getui.gtc.extension.distribution.gbd.d.h.aO);
            if (i && z && com.getui.gtc.extension.distribution.gbd.d.h.aO) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(a, "start d niche al.");
                if (android.text.TextUtils.isEmpty(com.getui.gtc.extension.distribution.gbd.d.d.cM)) {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(a, "niche al url empty, cancel.");
                    return;
                }
                if (!android.text.TextUtils.isEmpty(com.getui.gtc.extension.distribution.gbd.d.h.aX) && !new java.io.File(h()).exists()) {
                    com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                    com.getui.gtc.extension.distribution.gbd.f.a.b.c("");
                }
                com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                com.getui.gtc.extension.distribution.gbd.f.a.b.d(java.lang.System.currentTimeMillis());
                com.getui.gtc.extension.distribution.gbd.g.a.b bVar = new com.getui.gtc.extension.distribution.gbd.g.a.b(new com.getui.gtc.extension.distribution.gbd.n.b.AnonymousClass13(), 29, com.getui.gtc.extension.distribution.gbd.d.h.aX);
                bVar.e = com.getui.gtc.extension.distribution.gbd.d.d.cM;
                com.getui.gtc.extension.distribution.gbd.l.a.C0311a.a.a(new com.getui.gtc.extension.distribution.gbd.g.a(bVar));
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, th.toString());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String j() {
        java.lang.String str;
        try {
            str = com.getui.gtc.extension.distribution.gbd.n.ad.a("ae50b9c2266c320c" + com.getui.gtc.extension.distribution.gbd.d.c.d.getPackageName());
            try {
                if (!android.text.TextUtils.isEmpty(str)) {
                    str = str.substring(10, str.length() - 10);
                }
            } catch (java.lang.Throwable th) {
                th = th;
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                if (android.text.TextUtils.isEmpty(str)) {
                }
                return com.getui.gtc.extension.distribution.gbd.d.c.d.getFilesDir().getPath() + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + (android.text.TextUtils.isEmpty(str) ? "ae50b9c2266c320c" : str);
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            str = "ae50b9c2266c320c";
        }
        return com.getui.gtc.extension.distribution.gbd.d.c.d.getFilesDir().getPath() + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + (android.text.TextUtils.isEmpty(str) ? "ae50b9c2266c320c" : str);
    }

    public static boolean k() {
        return new java.io.File(j()).exists();
    }

    public static void l() {
        try {
            boolean i = com.getui.gtc.extension.distribution.gbd.n.l.i(com.getui.gtc.extension.distribution.gbd.d.c.d);
            boolean z = java.lang.System.currentTimeMillis() - com.getui.gtc.extension.distribution.gbd.d.h.aF > 86400000;
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, "dl wlp, isNetworkConnected = " + i + ", isTimeAllowed = " + z);
            if (i && z && com.getui.gtc.extension.distribution.gbd.d.h.aI) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(a, "start dl wlp.");
                com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                long currentTimeMillis = java.lang.System.currentTimeMillis();
                com.getui.gtc.extension.distribution.gbd.d.h.aF = currentTimeMillis;
                com.getui.gtc.extension.distribution.gbd.f.a.b.a(291, java.lang.String.valueOf(currentTimeMillis));
                if (android.text.TextUtils.isEmpty(com.getui.gtc.extension.distribution.gbd.d.d.Z)) {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(a, "wlp url empty, cancel.");
                    return;
                }
                com.getui.gtc.extension.distribution.gbd.g.a.b bVar = new com.getui.gtc.extension.distribution.gbd.g.a.b(new com.getui.gtc.extension.distribution.gbd.n.b.AnonymousClass2(), 24, null);
                bVar.e = com.getui.gtc.extension.distribution.gbd.d.d.Z;
                com.getui.gtc.extension.distribution.gbd.l.a.C0311a.a.a(new com.getui.gtc.extension.distribution.gbd.g.a(bVar));
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, th.toString());
        }
    }

    public static java.lang.String[] m() {
        java.lang.String j = j();
        com.getui.gtc.extension.distribution.gbd.n.j.b(a, "wlp read form lf = ".concat(java.lang.String.valueOf(j)));
        byte[] a2 = com.getui.gtc.extension.distribution.gbd.n.i.a(j);
        if (a2 == null) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, "read wlp file null");
            return null;
        }
        java.lang.String[] split = new java.lang.String(com.getui.gtc.extension.distribution.gbd.n.n.b(com.getui.gtc.extension.distribution.gbd.n.t.a(a2, com.getui.gtc.extension.distribution.gbd.d.g.ad))).replace("\n", "").split("\\r");
        com.getui.gtc.extension.distribution.gbd.n.j.b(a, "wlp file length = " + split.length);
        return split;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002a, code lost:
    
        if (com.getui.gtc.extension.distribution.gbd.n.l.e(r7) == false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String n() {
        if (com.getui.gtc.extension.distribution.gbd.n.l.a()) {
            return "debuggable";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.lang.String[] split = com.getui.gtc.extension.distribution.gbd.d.h.u.split("&");
        int length = split.length;
        int i = 0;
        while (true) {
            boolean z = true;
            if (i >= length) {
                break;
            }
            java.lang.String str = split[i];
            if (!android.text.TextUtils.isEmpty(str)) {
                java.lang.String str2 = com.getui.gtc.extension.distribution.gbd.d.c.a;
            }
            z = false;
            if (z) {
                sb.append(str);
                sb.append("&");
            }
            i++;
        }
        if (sb.toString().endsWith("&")) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public static java.lang.String o() {
        if (android.text.TextUtils.isEmpty(com.getui.gtc.extension.distribution.gbd.d.d.cH) || "none".equalsIgnoreCase(com.getui.gtc.extension.distribution.gbd.d.d.cH)) {
            return "";
        }
        java.lang.String[] split = com.getui.gtc.extension.distribution.gbd.d.d.cH.split(",");
        com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
        java.lang.String str = (java.lang.String) com.getui.gtc.extension.distribution.gbd.f.c.a(com.getui.gtc.extension.distribution.gbd.d.d.cG, "pi", split, new com.getui.gtc.extension.distribution.gbd.n.b.AnonymousClass3(split));
        return str == null ? "" : str;
    }

    @android.annotation.TargetApi(26)
    public static java.lang.String p() {
        if (android.os.Build.VERSION.SDK_INT < 26) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, "< 26.");
            return "";
        }
        if (!com.getui.gtc.extension.distribution.gbd.n.x.a(1, 2) || android.text.TextUtils.isEmpty(com.getui.gtc.extension.distribution.gbd.d.d.cI) || "none".equalsIgnoreCase(com.getui.gtc.extension.distribution.gbd.d.d.cI)) {
            return "";
        }
        com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
        java.lang.String str = (java.lang.String) com.getui.gtc.extension.distribution.gbd.f.c.a(com.getui.gtc.extension.distribution.gbd.d.d.cG, "pi", "", new com.getui.gtc.extension.distribution.gbd.n.b.AnonymousClass4());
        return str == null ? "" : str;
    }

    private static boolean q() {
        try {
            java.lang.String str = (java.lang.String) com.getui.gtc.BuildConfig.class.getField("VERSION_NAME").get(null);
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, "gtc version = ".concat(java.lang.String.valueOf(str)));
            if (!android.text.TextUtils.isEmpty(str) && str.startsWith("GTC-")) {
                java.lang.String[] split = str.substring(4).split("\\.");
                if (split.length >= 4) {
                    int parseInt = java.lang.Integer.parseInt(split[0]);
                    int parseInt2 = java.lang.Integer.parseInt(split[1]);
                    return (parseInt == 3 && parseInt2 == 1 && java.lang.Integer.parseInt(split[2]) >= 7 && java.lang.Integer.parseInt(split[3]) >= 0) || (parseInt == 3 && parseInt2 > 1) || parseInt > 3;
                }
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
        return false;
    }

    private static java.util.List<android.content.pm.PackageInfo> r() {
        java.util.List<android.content.pm.PackageInfo> list = c;
        if (list != null && list.size() > 0) {
            return c;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        boolean c2 = com.getui.gtc.extension.distribution.gbd.n.l.c(com.getui.gtc.extension.distribution.gbd.d.c.d);
        boolean a2 = com.getui.gtc.extension.distribution.gbd.n.l.a();
        java.lang.StringBuilder sb = new java.lang.StringBuilder("common isAdbS = ");
        sb.append(!c2);
        sb.append(", isAppDebug = ");
        sb.append(a2);
        sb.append(", isUse18w = ");
        sb.append(com.getui.gtc.extension.distribution.gbd.d.d.k);
        com.getui.gtc.extension.distribution.gbd.n.j.b(a, sb.toString());
        if (!com.getui.gtc.extension.distribution.gbd.d.d.k || c2 || a2) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, "common fetch al by col not s.");
            return java.util.Collections.emptyList();
        }
        com.getui.gtc.extension.distribution.gbd.n.j.b(a, "common fetch al by col use check.");
        byte[] a3 = com.getui.gtc.extension.distribution.gbd.n.i.a(f());
        if (a3 != null && a3.length > 0) {
            java.lang.String[] split = new java.lang.String(com.getui.gtc.extension.distribution.gbd.n.n.b(com.getui.gtc.extension.distribution.gbd.n.t.a(a3, com.getui.gtc.extension.distribution.gbd.d.g.ad))).split("\\r");
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, "local al len = " + split.length);
            for (java.lang.String str : split) {
                android.content.pm.PackageInfo a4 = com.getui.gtc.extension.distribution.gbd.n.l.a(str, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_ID);
                if (a4 != null) {
                    arrayList.add(a4);
                }
            }
        }
        c = arrayList;
        return arrayList;
    }

    private static void s() {
        if (android.text.TextUtils.isEmpty(com.getui.gtc.extension.distribution.gbd.d.h.aM) || com.getui.gtc.extension.distribution.gbd.d.h.aM.equalsIgnoreCase("none")) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(a, "18al for 24 url empty, cancel.");
            return;
        }
        if (!android.text.TextUtils.isEmpty(com.getui.gtc.extension.distribution.gbd.d.h.aY) && !new java.io.File(d()).exists()) {
            com.getui.gtc.extension.distribution.gbd.f.a.b.a();
            com.getui.gtc.extension.distribution.gbd.f.a.b.b("");
        }
        com.getui.gtc.extension.distribution.gbd.f.a.b.a();
        com.getui.gtc.extension.distribution.gbd.f.a.b.c(java.lang.System.currentTimeMillis());
        com.getui.gtc.extension.distribution.gbd.g.a.b bVar = new com.getui.gtc.extension.distribution.gbd.g.a.b(new com.getui.gtc.extension.distribution.gbd.n.b.AnonymousClass11(), 124, com.getui.gtc.extension.distribution.gbd.d.h.aY);
        bVar.e = com.getui.gtc.extension.distribution.gbd.d.h.aM;
        com.getui.gtc.extension.distribution.gbd.l.a.C0311a.a.a(new com.getui.gtc.extension.distribution.gbd.g.a(bVar));
    }

    private static void t() {
        if (android.text.TextUtils.isEmpty(com.getui.gtc.extension.distribution.gbd.d.d.bR)) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, "18al url empty, cancel.");
            return;
        }
        com.getui.gtc.extension.distribution.gbd.f.a.b.a();
        com.getui.gtc.extension.distribution.gbd.f.a.b.b(java.lang.System.currentTimeMillis());
        com.getui.gtc.extension.distribution.gbd.g.a.b bVar = new com.getui.gtc.extension.distribution.gbd.g.a.b(new com.getui.gtc.extension.distribution.gbd.n.b.AnonymousClass12(), 28, null);
        bVar.e = com.getui.gtc.extension.distribution.gbd.d.d.bR;
        com.getui.gtc.extension.distribution.gbd.l.a.C0311a.a.a(new com.getui.gtc.extension.distribution.gbd.g.a(bVar));
    }

    private static void u() {
        if (android.text.TextUtils.isEmpty(com.getui.gtc.extension.distribution.gbd.d.d.cM)) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, "niche al url empty, cancel.");
            return;
        }
        if (!android.text.TextUtils.isEmpty(com.getui.gtc.extension.distribution.gbd.d.h.aX) && !new java.io.File(h()).exists()) {
            com.getui.gtc.extension.distribution.gbd.f.a.b.a();
            com.getui.gtc.extension.distribution.gbd.f.a.b.c("");
        }
        com.getui.gtc.extension.distribution.gbd.f.a.b.a();
        com.getui.gtc.extension.distribution.gbd.f.a.b.d(java.lang.System.currentTimeMillis());
        com.getui.gtc.extension.distribution.gbd.g.a.b bVar = new com.getui.gtc.extension.distribution.gbd.g.a.b(new com.getui.gtc.extension.distribution.gbd.n.b.AnonymousClass13(), 29, com.getui.gtc.extension.distribution.gbd.d.h.aX);
        bVar.e = com.getui.gtc.extension.distribution.gbd.d.d.cM;
        com.getui.gtc.extension.distribution.gbd.l.a.C0311a.a.a(new com.getui.gtc.extension.distribution.gbd.g.a(bVar));
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static java.lang.String v() {
        java.lang.String str;
        try {
            str = com.getui.gtc.extension.distribution.gbd.n.ad.a("00126c3d406e6290" + com.getui.gtc.extension.distribution.gbd.d.c.d.getPackageName());
            try {
                if (!android.text.TextUtils.isEmpty(str)) {
                    str = str.substring(10, str.length() - 10);
                }
            } catch (java.lang.Throwable th) {
                th = th;
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                if (android.text.TextUtils.isEmpty(str)) {
                }
                return com.getui.gtc.extension.distribution.gbd.d.c.d.getFilesDir().getPath() + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + (android.text.TextUtils.isEmpty(str) ? "00126c3d406e6290" : str);
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            str = "00126c3d406e6290";
        }
        return com.getui.gtc.extension.distribution.gbd.d.c.d.getFilesDir().getPath() + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + (android.text.TextUtils.isEmpty(str) ? "00126c3d406e6290" : str);
    }

    private static void w() {
        if (android.text.TextUtils.isEmpty(com.getui.gtc.extension.distribution.gbd.d.d.Z)) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, "wlp url empty, cancel.");
            return;
        }
        com.getui.gtc.extension.distribution.gbd.g.a.b bVar = new com.getui.gtc.extension.distribution.gbd.g.a.b(new com.getui.gtc.extension.distribution.gbd.n.b.AnonymousClass2(), 24, null);
        bVar.e = com.getui.gtc.extension.distribution.gbd.d.d.Z;
        com.getui.gtc.extension.distribution.gbd.l.a.C0311a.a.a(new com.getui.gtc.extension.distribution.gbd.g.a(bVar));
    }

    private static java.util.List<java.lang.String> x() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (!android.text.TextUtils.isEmpty(com.getui.gtc.extension.distribution.gbd.d.d.dc) && !com.getui.gtc.extension.distribution.gbd.d.d.dc.equals("none")) {
            try {
                java.lang.String[] split = com.getui.gtc.extension.distribution.gbd.d.d.dc.split(",");
                com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
                com.getui.gtc.extension.distribution.gbd.f.c.a(true, "pi", split, new com.getui.gtc.extension.distribution.gbd.n.b.AnonymousClass5(arrayList));
            } catch (java.lang.Throwable th) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(th);
            }
        }
        return arrayList;
    }
}
