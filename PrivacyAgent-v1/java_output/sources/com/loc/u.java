package com.loc;

/* loaded from: classes23.dex */
public final class u {
    private static volatile com.loc.u.b a = com.loc.u.b.Unknow;
    private static volatile com.loc.u.d b = com.loc.u.d.Unknow;
    private static volatile java.lang.String c = "";
    private static volatile java.lang.String d = "";
    private static volatile long e = -1;
    private static volatile com.loc.u.a f = com.loc.u.a.Unknow;
    private static volatile long g = -1;
    private static volatile java.lang.String h = "";
    private static volatile java.lang.String i = "";
    private static volatile long j = 0;
    private static volatile long k = 0;
    private static volatile boolean l = false;
    private static volatile boolean m = true;

    /* renamed from: com.loc.u$1, reason: invalid class name */
    public class AnonymousClass1 extends com.loc.cu {
        final /* synthetic */ android.content.Context a;

        public AnonymousClass1(android.content.Context context) {
            this.a = context;
        }

        @Override // com.loc.cu
        public final void a() {
            java.util.Iterator it = com.loc.u.b(com.loc.u.f(this.a)).iterator();
            while (it.hasNext()) {
                com.loc.u.a(this.a, ((java.io.File) it.next()).getName());
            }
            com.loc.u.b(this.a);
        }
    }

    /* renamed from: com.loc.u$2, reason: invalid class name */
    public class AnonymousClass2 extends com.loc.cu {
        final /* synthetic */ boolean a;
        final /* synthetic */ android.content.Context b;
        final /* synthetic */ long c;
        final /* synthetic */ org.json.JSONObject d;

        public AnonymousClass2(boolean z, android.content.Context context, long j, org.json.JSONObject jSONObject) {
            this.a = z;
            this.b = context;
            this.c = j;
            this.d = jSONObject;
        }

        @Override // com.loc.cu
        public final void a() {
            if (this.a) {
                java.util.Iterator it = com.loc.u.b(com.loc.u.f(this.b)).iterator();
                while (it.hasNext()) {
                    com.loc.u.a(this.b, ((java.io.File) it.next()).getName());
                }
            }
            com.loc.u.d(this.b);
            com.loc.u.a(this.b, this.d, this.c);
            boolean b = com.loc.u.b(this.b, this.d);
            if (b) {
                com.loc.u.b(this.b, com.loc.u.b(this.c));
            }
            if (this.a) {
                com.loc.u.b(this.b);
            }
            if (b) {
                return;
            }
            com.loc.u.a(this.b, com.loc.u.b(this.c));
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

        public static com.loc.u.a a(int i) {
            com.loc.u.a aVar = NotAgree;
            if (i == aVar.a()) {
                return aVar;
            }
            com.loc.u.a aVar2 = DidAgree;
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

        public static com.loc.u.b a(int i) {
            com.loc.u.b bVar = NotContain;
            if (i == bVar.a()) {
                return bVar;
            }
            com.loc.u.b bVar2 = DidContain;
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

        public static com.loc.u.d a(int i) {
            com.loc.u.d dVar = NotShow;
            if (i == dVar.a()) {
                return dVar;
            }
            com.loc.u.d dVar2 = DidShow;
            return i == dVar2.a() ? dVar2 : Unknow;
        }

        public final int a() {
            return this.d;
        }
    }

    public static synchronized com.loc.v a(android.content.Context context, com.loc.x xVar) {
        boolean z;
        synchronized (com.loc.u.class) {
            if (context == null || xVar == null) {
                return new com.loc.v(com.loc.u.c.IllegalArgument, xVar);
            }
            if (!l) {
                e(context);
                l = true;
            }
            com.loc.v vVar = null;
            if (b != com.loc.u.d.DidShow) {
                if (b == com.loc.u.d.Unknow) {
                    vVar = new com.loc.v(com.loc.u.c.ShowUnknowCode, xVar);
                } else if (b == com.loc.u.d.NotShow) {
                    vVar = new com.loc.v(com.loc.u.c.ShowNoShowCode, xVar);
                }
                z = false;
            } else {
                z = true;
            }
            if (z && a != com.loc.u.b.DidContain) {
                if (a == com.loc.u.b.Unknow) {
                    vVar = new com.loc.v(com.loc.u.c.InfoUnknowCode, xVar);
                } else if (a == com.loc.u.b.NotContain) {
                    vVar = new com.loc.v(com.loc.u.c.InfoNotContainCode, xVar);
                }
                z = false;
            }
            if (z && f != com.loc.u.a.DidAgree) {
                if (f == com.loc.u.a.Unknow) {
                    vVar = new com.loc.v(com.loc.u.c.AgreeUnknowCode, xVar);
                } else if (f == com.loc.u.a.NotAgree) {
                    vVar = new com.loc.v(com.loc.u.c.AgreeNotAgreeCode, xVar);
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
                    com.loc.ct.a().b(new com.loc.u.AnonymousClass2(m, context, j2, jSONObject));
                } catch (java.lang.Throwable unused) {
                }
            } else if (m) {
                com.loc.ct.a().b(new com.loc.u.AnonymousClass1(context));
            }
            m = false;
            java.lang.String f2 = com.loc.m.f(context);
            if (f2 == null || f2.length() <= 0) {
                vVar = new com.loc.v(com.loc.u.c.InvaildUserKeyCode, xVar);
                xVar.a();
                java.lang.String.format("获取apikey失败：\nerrorCode : %d\n原因：%s", java.lang.Integer.valueOf(vVar.a.a()), vVar.b);
            }
            if (z) {
                vVar = new com.loc.v(com.loc.u.c.SuccessCode, xVar);
            } else {
                xVar.a();
                java.lang.String.format("隐私合规校验失败：\nerrorCode : %d\n原因：%s", java.lang.Integer.valueOf(vVar.a.a()), vVar.b);
            }
            return vVar;
        }
    }

    private static synchronized void a(android.content.Context context, com.loc.u.a aVar, com.loc.x xVar) {
        synchronized (com.loc.u.class) {
            if (context == null || xVar == null) {
                return;
            }
            if (!l) {
                e(context);
                l = true;
            }
            if (aVar != f) {
                f = aVar;
                h = xVar.a();
                i = xVar.b();
                long currentTimeMillis = java.lang.System.currentTimeMillis();
                g = currentTimeMillis;
                j = currentTimeMillis;
                d(context);
            }
        }
    }

    private static synchronized void a(android.content.Context context, com.loc.u.d dVar, com.loc.u.b bVar, com.loc.x xVar) {
        synchronized (com.loc.u.class) {
            if (context == null || xVar == null) {
                return;
            }
            if (!l) {
                e(context);
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
                c = xVar.a();
                d = xVar.b();
                long currentTimeMillis = java.lang.System.currentTimeMillis();
                e = currentTimeMillis;
                j = currentTimeMillis;
                d(context);
            }
        }
    }

    public static /* synthetic */ void a(android.content.Context context, java.lang.String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        try {
            java.io.File file = new java.io.File(f(context) + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + str);
            if (file.exists()) {
                java.io.File file2 = new java.io.File(g(context) + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + str);
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
            byte[] a2 = com.loc.be.a(context, jSONObject.toString().getBytes());
            java.lang.String b2 = b(j2);
            java.io.File file = new java.io.File(f(context) + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + b2);
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

    public static void a(android.content.Context context, boolean z, com.loc.x xVar) {
        a(context, z ? com.loc.u.a.DidAgree : com.loc.u.a.NotAgree, xVar);
    }

    public static void a(android.content.Context context, boolean z, boolean z2, com.loc.x xVar) {
        a(context, z2 ? com.loc.u.d.DidShow : com.loc.u.d.NotShow, z ? com.loc.u.b.DidContain : com.loc.u.b.NotContain, xVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.String b(long j2) {
        return java.lang.String.format("%d-%s", java.lang.Long.valueOf(j2), "privacy.data");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.util.ArrayList<java.io.File> b(java.lang.String str) {
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

    public static /* synthetic */ void b(android.content.Context context) {
        java.lang.String name;
        java.lang.String[] split;
        try {
            java.util.Iterator<java.io.File> it = b(g(context)).iterator();
            while (it.hasNext()) {
                java.io.File next = it.next();
                try {
                    name = next.getName();
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                }
                if (name.endsWith("-privacy.data") && (((split = name.split(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER)) != null || split.length == 2) && java.lang.Long.parseLong(split[0]) > 0)) {
                    java.io.FileInputStream fileInputStream = new java.io.FileInputStream(next);
                    byte[] bArr = new byte[fileInputStream.available()];
                    fileInputStream.read(bArr);
                    if (b(context, new org.json.JSONObject(new java.lang.String(com.loc.be.b(context, bArr))))) {
                    }
                }
                next.delete();
            }
        } catch (java.lang.Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static /* synthetic */ void b(android.content.Context context, java.lang.String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        try {
            java.io.File file = new java.io.File(f(context) + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + str);
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
            com.loc.ay ayVar = new com.loc.ay();
            ayVar.b = context;
            ayVar.a = jSONObject;
            new com.loc.bp();
            com.loc.bv a2 = com.loc.bp.a(ayVar);
            if (a2 == null) {
                return false;
            }
            org.json.JSONObject jSONObject2 = new org.json.JSONObject(com.loc.y.a(a2.a));
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
    public static synchronized void d(android.content.Context context) {
        synchronized (com.loc.u.class) {
            if (context == null) {
                return;
            }
            if (!l) {
                e(context);
                l = true;
            }
            try {
                com.loc.be.a(context, "AMap.privacy.data", "AMap.privacy.data", java.lang.String.format("%d&%d&%d&%s&%s&%d&%d&%s&%s&%d&%d", java.lang.Integer.valueOf(a.a()), java.lang.Integer.valueOf(b.a()), java.lang.Long.valueOf(e), c, d, java.lang.Integer.valueOf(f.a()), java.lang.Long.valueOf(g), h, i, java.lang.Long.valueOf(j), java.lang.Long.valueOf(k)));
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private static void e(android.content.Context context) {
        java.lang.String str;
        if (context == null) {
            return;
        }
        try {
            str = com.loc.be.a(context, "AMap.privacy.data", "AMap.privacy.data");
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
            a = com.loc.u.b.a(java.lang.Integer.parseInt(split[0]));
            b = com.loc.u.d.a(java.lang.Integer.parseInt(split[1]));
            e = java.lang.Long.parseLong(split[2]);
            d = split[3];
            d = split[4];
            f = com.loc.u.a.a(java.lang.Integer.parseInt(split[5]));
            g = java.lang.Long.parseLong(split[6]);
            h = split[7];
            i = split[8];
            j = java.lang.Long.parseLong(split[9]);
            k = java.lang.Long.parseLong(split[10]);
        } catch (java.lang.Throwable th2) {
            th2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.String f(android.content.Context context) {
        return context.getFilesDir().getAbsolutePath() + "/AMap/Privacy/Upload";
    }

    private static java.lang.String g(android.content.Context context) {
        return context.getFilesDir().getAbsolutePath() + "/AMap/Privacy/Reload";
    }
}
