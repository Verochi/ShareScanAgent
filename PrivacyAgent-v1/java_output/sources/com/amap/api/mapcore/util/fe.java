package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class fe {
    private static volatile com.amap.api.mapcore.util.fe.b a = com.amap.api.mapcore.util.fe.b.Unknow;
    private static volatile com.amap.api.mapcore.util.fe.d b = com.amap.api.mapcore.util.fe.d.Unknow;
    private static volatile java.lang.String c = "";
    private static volatile java.lang.String d = "";
    private static volatile long e = -1;
    private static volatile com.amap.api.mapcore.util.fe.a f = com.amap.api.mapcore.util.fe.a.Unknow;
    private static volatile long g = -1;
    private static volatile java.lang.String h = "";
    private static volatile java.lang.String i = "";
    private static volatile long j = 0;
    private static volatile long k = 0;
    private static volatile boolean l = false;

    /* renamed from: com.amap.api.mapcore.util.fe$1, reason: invalid class name */
    public static class AnonymousClass1 extends com.amap.api.mapcore.util.ij {
        final /* synthetic */ java.util.ArrayList a;
        final /* synthetic */ android.content.Context b;

        public AnonymousClass1(java.util.ArrayList arrayList, android.content.Context context) {
            this.a = arrayList;
            this.b = context;
        }

        @Override // com.amap.api.mapcore.util.ij
        public final void runTask() {
            java.util.Iterator it = this.a.iterator();
            while (it.hasNext()) {
                com.amap.api.mapcore.util.fe.a(this.b, ((java.io.File) it.next()).getName());
            }
            com.amap.api.mapcore.util.fe.a(this.b);
        }
    }

    /* renamed from: com.amap.api.mapcore.util.fe$2, reason: invalid class name */
    public static class AnonymousClass2 extends com.amap.api.mapcore.util.ij {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ long b;
        final /* synthetic */ org.json.JSONObject c;

        public AnonymousClass2(android.content.Context context, long j, org.json.JSONObject jSONObject) {
            this.a = context;
            this.b = j;
            this.c = jSONObject;
        }

        @Override // com.amap.api.mapcore.util.ij
        public final void runTask() {
            com.amap.api.mapcore.util.fe.c(this.a);
            com.amap.api.mapcore.util.fe.a(this.a, this.c, this.b);
            if (com.amap.api.mapcore.util.fe.b(this.a, this.c)) {
                com.amap.api.mapcore.util.fe.b(this.a, com.amap.api.mapcore.util.fe.b(this.b));
            } else {
                com.amap.api.mapcore.util.fe.a(this.a, com.amap.api.mapcore.util.fe.b(this.b));
            }
        }
    }

    public enum a {
        Unknow(-1),
        NotAgree(0),
        DidAgree(1);

        private int d;

        a(int i) {
            this.d = i;
        }

        public static com.amap.api.mapcore.util.fe.a a(int i) {
            com.amap.api.mapcore.util.fe.a aVar = NotAgree;
            if (i == aVar.a()) {
                return aVar;
            }
            com.amap.api.mapcore.util.fe.a aVar2 = DidAgree;
            return i == aVar2.a() ? aVar2 : Unknow;
        }

        public final int a() {
            return this.d;
        }
    }

    public enum b {
        Unknow(-1),
        NotContain(0),
        DidContain(1);

        private int d;

        b(int i) {
            this.d = i;
        }

        public static com.amap.api.mapcore.util.fe.b a(int i) {
            com.amap.api.mapcore.util.fe.b bVar = NotContain;
            if (i == bVar.a()) {
                return bVar;
            }
            com.amap.api.mapcore.util.fe.b bVar2 = DidContain;
            return i == bVar2.a() ? bVar2 : Unknow;
        }

        public final int a() {
            return this.d;
        }
    }

    public enum c {
        SuccessCode(0),
        ShowUnknowCode(555570),
        ShowNoShowCode(555571),
        InfoUnknowCode(555572),
        InfoNotContainCode(555573),
        AgreeUnknowCode(555574),
        AgreeNotAgreeCode(555575),
        InvaildUserKeyCode(10001),
        IllegalArgument(20001);

        private final int j;

        c(int i) {
            this.j = i;
        }

        public final int a() {
            return this.j;
        }
    }

    public enum d {
        Unknow(-1),
        NotShow(0),
        DidShow(1);

        private int d;

        d(int i) {
            this.d = i;
        }

        public static com.amap.api.mapcore.util.fe.d a(int i) {
            com.amap.api.mapcore.util.fe.d dVar = NotShow;
            if (i == dVar.a()) {
                return dVar;
            }
            com.amap.api.mapcore.util.fe.d dVar2 = DidShow;
            return i == dVar2.a() ? dVar2 : Unknow;
        }

        public final int a() {
            return this.d;
        }
    }

    public static synchronized com.amap.api.mapcore.util.ff a(android.content.Context context, com.amap.api.mapcore.util.fh fhVar) {
        boolean z;
        synchronized (com.amap.api.mapcore.util.fe.class) {
            if (context == null || fhVar == null) {
                return new com.amap.api.mapcore.util.ff(com.amap.api.mapcore.util.fe.c.IllegalArgument, fhVar);
            }
            if (!l) {
                d(context);
                l = true;
            }
            com.amap.api.mapcore.util.ff ffVar = null;
            if (b != com.amap.api.mapcore.util.fe.d.DidShow) {
                if (b == com.amap.api.mapcore.util.fe.d.Unknow) {
                    ffVar = new com.amap.api.mapcore.util.ff(com.amap.api.mapcore.util.fe.c.ShowUnknowCode, fhVar);
                } else if (b == com.amap.api.mapcore.util.fe.d.NotShow) {
                    ffVar = new com.amap.api.mapcore.util.ff(com.amap.api.mapcore.util.fe.c.ShowNoShowCode, fhVar);
                }
                z = false;
            } else {
                z = true;
            }
            if (z && a != com.amap.api.mapcore.util.fe.b.DidContain) {
                if (a == com.amap.api.mapcore.util.fe.b.Unknow) {
                    ffVar = new com.amap.api.mapcore.util.ff(com.amap.api.mapcore.util.fe.c.InfoUnknowCode, fhVar);
                } else if (a == com.amap.api.mapcore.util.fe.b.NotContain) {
                    ffVar = new com.amap.api.mapcore.util.ff(com.amap.api.mapcore.util.fe.c.InfoNotContainCode, fhVar);
                }
                z = false;
            }
            if (z && f != com.amap.api.mapcore.util.fe.a.DidAgree) {
                if (f == com.amap.api.mapcore.util.fe.a.Unknow) {
                    ffVar = new com.amap.api.mapcore.util.ff(com.amap.api.mapcore.util.fe.c.AgreeUnknowCode, fhVar);
                } else if (f == com.amap.api.mapcore.util.fe.a.NotAgree) {
                    ffVar = new com.amap.api.mapcore.util.ff(com.amap.api.mapcore.util.fe.c.AgreeNotAgreeCode, fhVar);
                }
                z = false;
            }
            if (k != j) {
                long j2 = j;
                k = j;
                try {
                    org.json.JSONObject jSONObject = new org.json.JSONObject();
                    jSONObject.put("privacyInfo", a.a());
                    jSONObject.put("privacyShow", b.a());
                    jSONObject.put("showTime", e);
                    jSONObject.put("show2SDK", c);
                    jSONObject.put("show2SDKVer", d);
                    jSONObject.put("privacyAgree", f.a());
                    jSONObject.put("agreeTime", g);
                    jSONObject.put("agree2SDK", h);
                    jSONObject.put("agree2SDKVer", i);
                    com.amap.api.mapcore.util.ii.a().a(new com.amap.api.mapcore.util.fe.AnonymousClass2(context, j2, jSONObject));
                } catch (java.lang.Throwable unused) {
                }
            }
            java.lang.String f2 = com.amap.api.mapcore.util.ev.f(context);
            if (f2 == null || f2.length() <= 0) {
                ffVar = new com.amap.api.mapcore.util.ff(com.amap.api.mapcore.util.fe.c.InvaildUserKeyCode, fhVar);
                fhVar.a();
                java.lang.String.format("获取apikey失败：\nerrorCode : %d\n原因：%s", java.lang.Integer.valueOf(ffVar.a.a()), ffVar.b);
            }
            if (z) {
                ffVar = new com.amap.api.mapcore.util.ff(com.amap.api.mapcore.util.fe.c.SuccessCode, fhVar);
            } else {
                fhVar.a();
                java.lang.String.format("隐私合规校验失败：\nerrorCode : %d\n原因：%s", java.lang.Integer.valueOf(ffVar.a.a()), ffVar.b);
            }
            return ffVar;
        }
    }

    private static java.util.ArrayList<java.io.File> a(java.lang.String str) {
        java.util.ArrayList<java.io.File> arrayList = new java.util.ArrayList<>();
        if (str != null && str.length() != 0) {
            java.io.File file = new java.io.File(str);
            if (!file.exists()) {
                return arrayList;
            }
            java.io.File[] listFiles = file.listFiles();
            for (java.io.File file2 : listFiles) {
                if (file2.isFile()) {
                    arrayList.add(file2);
                }
            }
        }
        return arrayList;
    }

    public static /* synthetic */ void a(android.content.Context context) {
        try {
            java.util.Iterator<java.io.File> it = a(f(context)).iterator();
            while (it.hasNext()) {
                java.io.File next = it.next();
                try {
                    java.lang.String name = next.getName();
                    if (name.endsWith("-privacy.data")) {
                        java.lang.String[] split = name.split(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                        if (split == null && split.length != 2) {
                            next.delete();
                        } else if (java.lang.Long.parseLong(split[0]) <= 0) {
                            next.delete();
                        } else {
                            java.io.FileInputStream fileInputStream = new java.io.FileInputStream(next);
                            byte[] bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            if (b(context, new org.json.JSONObject(new java.lang.String(com.amap.api.mapcore.util.gq.b(context, bArr))))) {
                                next.delete();
                            }
                        }
                    } else {
                        next.delete();
                    }
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                }
            }
        } catch (java.lang.Throwable th2) {
            th2.printStackTrace();
        }
    }

    private static synchronized void a(android.content.Context context, com.amap.api.mapcore.util.fe.a aVar, com.amap.api.mapcore.util.fh fhVar) {
        synchronized (com.amap.api.mapcore.util.fe.class) {
            if (context == null || fhVar == null) {
                return;
            }
            if (!l) {
                d(context);
                l = true;
            }
            if (aVar != f) {
                f = aVar;
                h = fhVar.a();
                i = fhVar.b();
                long currentTimeMillis = java.lang.System.currentTimeMillis();
                g = currentTimeMillis;
                j = currentTimeMillis;
                c(context);
            }
        }
    }

    private static synchronized void a(android.content.Context context, com.amap.api.mapcore.util.fe.d dVar, com.amap.api.mapcore.util.fe.b bVar, com.amap.api.mapcore.util.fh fhVar) {
        synchronized (com.amap.api.mapcore.util.fe.class) {
            if (context == null || fhVar == null) {
                return;
            }
            if (!l) {
                d(context);
                l = true;
            }
            java.lang.Boolean bool = java.lang.Boolean.FALSE;
            if (dVar != b) {
                bool = java.lang.Boolean.TRUE;
                b = dVar;
            }
            if (bVar != a) {
                bool = java.lang.Boolean.TRUE;
                a = bVar;
            }
            if (bool.booleanValue()) {
                c = fhVar.a();
                d = fhVar.b();
                long currentTimeMillis = java.lang.System.currentTimeMillis();
                e = currentTimeMillis;
                j = currentTimeMillis;
                c(context);
            }
        }
    }

    public static /* synthetic */ void a(android.content.Context context, java.lang.String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        try {
            java.io.File file = new java.io.File(e(context) + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + str);
            if (file.exists()) {
                java.io.File file2 = new java.io.File(f(context) + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + str);
                if (!file2.getParentFile().exists()) {
                    file2.getParentFile().mkdirs();
                }
                file.renameTo(file2);
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public static /* synthetic */ void a(android.content.Context context, org.json.JSONObject jSONObject, long j2) {
        java.io.FileOutputStream fileOutputStream = null;
        try {
            byte[] a2 = com.amap.api.mapcore.util.gq.a(context, jSONObject.toString().getBytes());
            java.lang.String b2 = b(j2);
            java.io.File file = new java.io.File(e(context) + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + b2);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            java.io.FileOutputStream fileOutputStream2 = new java.io.FileOutputStream(file);
            try {
                fileOutputStream2.write(a2);
                try {
                    fileOutputStream2.close();
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                }
            } catch (java.lang.Throwable th2) {
                fileOutputStream = fileOutputStream2;
                th = th2;
                try {
                    th.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (java.lang.Throwable th3) {
                            th3.printStackTrace();
                        }
                    }
                } catch (java.lang.Throwable th4) {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (java.lang.Throwable th5) {
                            th5.printStackTrace();
                        }
                    }
                    throw th4;
                }
            }
        } catch (java.lang.Throwable th6) {
            th = th6;
        }
    }

    public static void a(android.content.Context context, boolean z, com.amap.api.mapcore.util.fh fhVar) {
        a(context, z ? com.amap.api.mapcore.util.fe.a.DidAgree : com.amap.api.mapcore.util.fe.a.NotAgree, fhVar);
    }

    public static void a(android.content.Context context, boolean z, boolean z2, com.amap.api.mapcore.util.fh fhVar) {
        a(context, z2 ? com.amap.api.mapcore.util.fe.d.DidShow : com.amap.api.mapcore.util.fe.d.NotShow, z ? com.amap.api.mapcore.util.fe.b.DidContain : com.amap.api.mapcore.util.fe.b.NotContain, fhVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.String b(long j2) {
        return java.lang.String.format("%d-%s", java.lang.Long.valueOf(j2), "privacy.data");
    }

    public static /* synthetic */ void b(android.content.Context context, java.lang.String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        try {
            java.io.File file = new java.io.File(e(context) + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + str);
            if (file.exists()) {
                file.delete();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(android.content.Context context, org.json.JSONObject jSONObject) {
        try {
            com.amap.api.mapcore.util.gf gfVar = new com.amap.api.mapcore.util.gf();
            gfVar.b = context;
            gfVar.a = jSONObject;
            new com.amap.api.mapcore.util.hb();
            com.amap.api.mapcore.util.hj b2 = com.amap.api.mapcore.util.hb.b(gfVar);
            if (b2 == null) {
                return false;
            }
            org.json.JSONObject jSONObject2 = new org.json.JSONObject(com.amap.api.mapcore.util.fi.a(b2.a));
            if (jSONObject2.has("status")) {
                return jSONObject2.getInt("status") == 1;
            }
            return false;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void c(android.content.Context context) {
        synchronized (com.amap.api.mapcore.util.fe.class) {
            if (context == null) {
                return;
            }
            if (!l) {
                d(context);
                l = true;
            }
            try {
                com.amap.api.mapcore.util.gq.a(context, "AMap.privacy.data", "AMap.privacy.data", java.lang.String.format("%d&%d&%d&%s&%s&%d&%d&%s&%s&%d&%d", java.lang.Integer.valueOf(a.a()), java.lang.Integer.valueOf(b.a()), java.lang.Long.valueOf(e), c, d, java.lang.Integer.valueOf(f.a()), java.lang.Long.valueOf(g), h, i, java.lang.Long.valueOf(j), java.lang.Long.valueOf(k)));
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private static void d(android.content.Context context) {
        java.lang.String str;
        if (context == null) {
            return;
        }
        com.amap.api.mapcore.util.ii.a().a(new com.amap.api.mapcore.util.fe.AnonymousClass1(a(e(context)), context));
        try {
            str = com.amap.api.mapcore.util.gq.a(context, "AMap.privacy.data", "AMap.privacy.data");
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            str = null;
        }
        if (str == null) {
            return;
        }
        java.lang.String[] split = str.split("&");
        if (split.length != 11) {
            return;
        }
        try {
            a = com.amap.api.mapcore.util.fe.b.a(java.lang.Integer.parseInt(split[0]));
            b = com.amap.api.mapcore.util.fe.d.a(java.lang.Integer.parseInt(split[1]));
            e = java.lang.Long.parseLong(split[2]);
            d = split[3];
            d = split[4];
            f = com.amap.api.mapcore.util.fe.a.a(java.lang.Integer.parseInt(split[5]));
            g = java.lang.Long.parseLong(split[6]);
            h = split[7];
            i = split[8];
            j = java.lang.Long.parseLong(split[9]);
            k = java.lang.Long.parseLong(split[10]);
        } catch (java.lang.Throwable th2) {
            th2.printStackTrace();
        }
    }

    private static java.lang.String e(android.content.Context context) {
        return context.getFilesDir().getAbsolutePath() + "/AMap/Privacy/Upload";
    }

    private static java.lang.String f(android.content.Context context) {
        return context.getFilesDir().getAbsolutePath() + "/AMap/Privacy/Reload";
    }
}
