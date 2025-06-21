package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class br {
    public static volatile com.amap.api.col.s.br.b a = com.amap.api.col.s.br.b.Unknow;
    public static volatile com.amap.api.col.s.br.d b = com.amap.api.col.s.br.d.Unknow;
    public static volatile java.lang.String c = "";
    public static volatile java.lang.String d = "";
    public static volatile long e = -1;
    public static volatile com.amap.api.col.s.br.a f = com.amap.api.col.s.br.a.Unknow;
    public static volatile long g = -1;
    public static volatile java.lang.String h = "";
    public static volatile java.lang.String i = "";
    public static volatile long j = 0;
    public static volatile long k = 0;
    public static volatile boolean l = false;

    /* renamed from: com.amap.api.col.s.br$1, reason: invalid class name */
    public static class AnonymousClass1 extends com.amap.api.col.s.ec {
        public final /* synthetic */ java.util.ArrayList t;
        public final /* synthetic */ android.content.Context u;

        public AnonymousClass1(java.util.ArrayList arrayList, android.content.Context context) {
            this.t = arrayList;
            this.u = context;
        }

        @Override // com.amap.api.col.s.ec
        public final void a() {
            java.util.Iterator it = this.t.iterator();
            while (it.hasNext()) {
                com.amap.api.col.s.br.g(this.u, ((java.io.File) it.next()).getName());
            }
            com.amap.api.col.s.br.d(this.u);
        }
    }

    /* renamed from: com.amap.api.col.s.br$2, reason: invalid class name */
    public static class AnonymousClass2 extends com.amap.api.col.s.ec {
        public final /* synthetic */ android.content.Context t;
        public final /* synthetic */ long u;
        public final /* synthetic */ org.json.JSONObject v;

        public AnonymousClass2(android.content.Context context, long j, org.json.JSONObject jSONObject) {
            this.t = context;
            this.u = j;
            this.v = jSONObject;
        }

        @Override // com.amap.api.col.s.ec
        public final void a() {
            com.amap.api.col.s.br.n(this.t);
            com.amap.api.col.s.br.h(this.t, this.v, this.u);
            if (com.amap.api.col.s.br.m(this.t, this.v)) {
                com.amap.api.col.s.br.l(this.t, com.amap.api.col.s.br.j(this.u));
            } else {
                com.amap.api.col.s.br.g(this.t, com.amap.api.col.s.br.j(this.u));
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

        public static com.amap.api.col.s.br.a a(int i) {
            com.amap.api.col.s.br.a aVar = NotAgree;
            if (i == aVar.a()) {
                return aVar;
            }
            com.amap.api.col.s.br.a aVar2 = DidAgree;
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

        public static com.amap.api.col.s.br.b a(int i) {
            com.amap.api.col.s.br.b bVar = NotContain;
            if (i == bVar.a()) {
                return bVar;
            }
            com.amap.api.col.s.br.b bVar2 = DidContain;
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

        public static com.amap.api.col.s.br.d a(int i) {
            com.amap.api.col.s.br.d dVar = NotShow;
            if (i == dVar.a()) {
                return dVar;
            }
            com.amap.api.col.s.br.d dVar2 = DidShow;
            return i == dVar2.a() ? dVar2 : Unknow;
        }

        public final int a() {
            return this.d;
        }
    }

    public static synchronized com.amap.api.col.s.bs a(android.content.Context context, com.amap.api.col.s.bt btVar) {
        boolean z;
        synchronized (com.amap.api.col.s.br.class) {
            if (context == null || btVar == null) {
                return new com.amap.api.col.s.bs(com.amap.api.col.s.br.c.IllegalArgument, btVar);
            }
            if (!l) {
                o(context);
                l = true;
            }
            com.amap.api.col.s.bs bsVar = null;
            if (b != com.amap.api.col.s.br.d.DidShow) {
                if (b == com.amap.api.col.s.br.d.Unknow) {
                    bsVar = new com.amap.api.col.s.bs(com.amap.api.col.s.br.c.ShowUnknowCode, btVar);
                } else if (b == com.amap.api.col.s.br.d.NotShow) {
                    bsVar = new com.amap.api.col.s.bs(com.amap.api.col.s.br.c.ShowNoShowCode, btVar);
                }
                z = false;
            } else {
                z = true;
            }
            if (z && a != com.amap.api.col.s.br.b.DidContain) {
                if (a == com.amap.api.col.s.br.b.Unknow) {
                    bsVar = new com.amap.api.col.s.bs(com.amap.api.col.s.br.c.InfoUnknowCode, btVar);
                } else if (a == com.amap.api.col.s.br.b.NotContain) {
                    bsVar = new com.amap.api.col.s.bs(com.amap.api.col.s.br.c.InfoNotContainCode, btVar);
                }
                z = false;
            }
            if (z && f != com.amap.api.col.s.br.a.DidAgree) {
                if (f == com.amap.api.col.s.br.a.Unknow) {
                    bsVar = new com.amap.api.col.s.bs(com.amap.api.col.s.br.c.AgreeUnknowCode, btVar);
                } else if (f == com.amap.api.col.s.br.a.NotAgree) {
                    bsVar = new com.amap.api.col.s.bs(com.amap.api.col.s.br.c.AgreeNotAgreeCode, btVar);
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
                    com.amap.api.col.s.eb.a().b(new com.amap.api.col.s.br.AnonymousClass2(context, j2, jSONObject));
                } catch (java.lang.Throwable unused) {
                }
            }
            java.lang.String f2 = com.amap.api.col.s.bi.f(context);
            if (f2 == null || f2.length() <= 0) {
                bsVar = new com.amap.api.col.s.bs(com.amap.api.col.s.br.c.InvaildUserKeyCode, btVar);
                btVar.b();
                java.lang.String.format("获取apikey失败：\nerrorCode : %d\n原因：%s", java.lang.Integer.valueOf(bsVar.a.a()), bsVar.b);
            }
            if (z) {
                bsVar = new com.amap.api.col.s.bs(com.amap.api.col.s.br.c.SuccessCode, btVar);
            } else {
                btVar.b();
                java.lang.String.format("隐私合规校验失败：\nerrorCode : %d\n原因：%s", java.lang.Integer.valueOf(bsVar.a.a()), bsVar.b);
            }
            return bsVar;
        }
    }

    public static void a(android.content.Context context, boolean z, com.amap.api.col.s.bt btVar) {
        e(context, z ? com.amap.api.col.s.br.a.DidAgree : com.amap.api.col.s.br.a.NotAgree, btVar);
    }

    public static void a(android.content.Context context, boolean z, boolean z2, com.amap.api.col.s.bt btVar) {
        f(context, z2 ? com.amap.api.col.s.br.d.DidShow : com.amap.api.col.s.br.d.NotShow, z ? com.amap.api.col.s.br.b.DidContain : com.amap.api.col.s.br.b.NotContain, btVar);
    }

    public static java.util.ArrayList<java.io.File> c(java.lang.String str) {
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

    public static /* synthetic */ void d(android.content.Context context) {
        try {
            java.util.Iterator<java.io.File> it = c(q(context)).iterator();
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
                            if (m(context, new org.json.JSONObject(new java.lang.String(com.amap.api.col.s.cm.b(context, bArr))))) {
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

    public static synchronized void e(android.content.Context context, com.amap.api.col.s.br.a aVar, com.amap.api.col.s.bt btVar) {
        synchronized (com.amap.api.col.s.br.class) {
            if (context == null || btVar == null) {
                return;
            }
            if (!l) {
                o(context);
                l = true;
            }
            if (aVar != f) {
                f = aVar;
                h = btVar.b();
                i = btVar.c();
                long currentTimeMillis = java.lang.System.currentTimeMillis();
                g = currentTimeMillis;
                j = currentTimeMillis;
                n(context);
            }
        }
    }

    public static synchronized void f(android.content.Context context, com.amap.api.col.s.br.d dVar, com.amap.api.col.s.br.b bVar, com.amap.api.col.s.bt btVar) {
        synchronized (com.amap.api.col.s.br.class) {
            if (context == null || btVar == null) {
                return;
            }
            if (!l) {
                o(context);
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
                c = btVar.b();
                d = btVar.c();
                long currentTimeMillis = java.lang.System.currentTimeMillis();
                e = currentTimeMillis;
                j = currentTimeMillis;
                n(context);
            }
        }
    }

    public static /* synthetic */ void g(android.content.Context context, java.lang.String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        try {
            java.io.File file = new java.io.File(p(context) + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + str);
            if (file.exists()) {
                java.io.File file2 = new java.io.File(q(context) + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + str);
                if (!file2.getParentFile().exists()) {
                    file2.getParentFile().mkdirs();
                }
                file.renameTo(file2);
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public static /* synthetic */ void h(android.content.Context context, org.json.JSONObject jSONObject, long j2) {
        java.io.FileOutputStream fileOutputStream = null;
        try {
            byte[] a2 = com.amap.api.col.s.cm.a(context, jSONObject.toString().getBytes());
            java.lang.String j3 = j(j2);
            java.io.File file = new java.io.File(p(context) + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + j3);
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

    public static java.lang.String j(long j2) {
        return java.lang.String.format("%d-%s", java.lang.Long.valueOf(j2), "privacy.data");
    }

    public static /* synthetic */ void l(android.content.Context context, java.lang.String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        try {
            java.io.File file = new java.io.File(p(context) + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + str);
            if (file.exists()) {
                file.delete();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public static boolean m(android.content.Context context, org.json.JSONObject jSONObject) {
        try {
            com.amap.api.col.s.cl clVar = new com.amap.api.col.s.cl();
            clVar.b = context;
            clVar.a = jSONObject;
            new com.amap.api.col.s.cx();
            com.amap.api.col.s.de a2 = com.amap.api.col.s.cx.a(clVar);
            if (a2 == null) {
                return false;
            }
            org.json.JSONObject jSONObject2 = new org.json.JSONObject(com.amap.api.col.s.bu.a(a2.a));
            if (jSONObject2.has("status")) {
                return jSONObject2.getInt("status") == 1;
            }
            return false;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static synchronized void n(android.content.Context context) {
        synchronized (com.amap.api.col.s.br.class) {
            if (context == null) {
                return;
            }
            if (!l) {
                o(context);
                l = true;
            }
            try {
                com.amap.api.col.s.cm.a(context, "AMap.privacy.data", "AMap.privacy.data", java.lang.String.format("%d&%d&%d&%s&%s&%d&%d&%s&%s&%d&%d", java.lang.Integer.valueOf(a.a()), java.lang.Integer.valueOf(b.a()), java.lang.Long.valueOf(e), c, d, java.lang.Integer.valueOf(f.a()), java.lang.Long.valueOf(g), h, i, java.lang.Long.valueOf(j), java.lang.Long.valueOf(k)));
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void o(android.content.Context context) {
        java.lang.String str;
        if (context == null) {
            return;
        }
        com.amap.api.col.s.eb.a().b(new com.amap.api.col.s.br.AnonymousClass1(c(p(context)), context));
        try {
            str = com.amap.api.col.s.cm.a(context, "AMap.privacy.data", "AMap.privacy.data");
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
            a = com.amap.api.col.s.br.b.a(java.lang.Integer.parseInt(split[0]));
            b = com.amap.api.col.s.br.d.a(java.lang.Integer.parseInt(split[1]));
            e = java.lang.Long.parseLong(split[2]);
            d = split[3];
            d = split[4];
            f = com.amap.api.col.s.br.a.a(java.lang.Integer.parseInt(split[5]));
            g = java.lang.Long.parseLong(split[6]);
            h = split[7];
            i = split[8];
            j = java.lang.Long.parseLong(split[9]);
            k = java.lang.Long.parseLong(split[10]);
        } catch (java.lang.Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static java.lang.String p(android.content.Context context) {
        return context.getFilesDir().getAbsolutePath() + "/AMap/Privacy/Upload";
    }

    public static java.lang.String q(android.content.Context context) {
        return context.getFilesDir().getAbsolutePath() + "/AMap/Privacy/Reload";
    }
}
