package cn.fly.verify;

/* loaded from: classes31.dex */
public class bm {
    private static final java.lang.String a = cn.fly.verify.bj.a("002Wflgm");
    private static final java.lang.String b = cn.fly.verify.bj.a("005?gefePkjf");
    private static final java.lang.String c = cn.fly.verify.bj.a("005*gefe8k!ed4f");
    private static final java.lang.String d = cn.fly.verify.bj.a("016XigifkgimijiijkieikghQe?gfNd3edfgej");
    private static cn.fly.verify.bm e;
    private java.lang.String f;
    private android.content.Context g = cn.fly.verify.ax.g();
    private java.util.TreeMap<java.lang.String, java.lang.Object> h;

    /* renamed from: cn.fly.verify.bm$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements cn.fly.verify.fh.a {
        final /* synthetic */ java.lang.String[] a;
        final /* synthetic */ java.util.concurrent.CountDownLatch b;

        public AnonymousClass1(java.lang.String[] strArr, java.util.concurrent.CountDownLatch countDownLatch) {
            this.a = strArr;
            this.b = countDownLatch;
        }

        @Override // cn.fly.verify.fh.a
        public void a(cn.fly.verify.fh.b bVar) {
            this.a[0] = bVar.h();
            this.b.countDown();
        }
    }

    private bm() {
    }

    public static cn.fly.verify.bm a() {
        if (e == null) {
            synchronized (cn.fly.verify.bm.class) {
                if (e == null) {
                    e = new cn.fly.verify.bm();
                }
            }
        }
        return e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private java.lang.String a(java.lang.String str) throws java.lang.Throwable {
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        java.util.zip.GZIPOutputStream gZIPOutputStream;
        java.io.ByteArrayOutputStream byteArrayOutputStream2;
        byte[] c2 = cn.fly.verify.dw.c();
        java.io.BufferedOutputStream bufferedOutputStream = null;
        try {
            byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            try {
                gZIPOutputStream = new java.util.zip.GZIPOutputStream(byteArrayOutputStream);
                try {
                    java.io.BufferedOutputStream bufferedOutputStream2 = new java.io.BufferedOutputStream(gZIPOutputStream);
                    try {
                        bufferedOutputStream2.write(str.getBytes("utf-8"));
                        bufferedOutputStream2.flush();
                        cn.fly.verify.dw.a(bufferedOutputStream2, gZIPOutputStream, byteArrayOutputStream);
                        byte[] a2 = cn.fly.verify.fi.a(c2, byteArrayOutputStream.toByteArray());
                        byte[] a3 = new cn.fly.verify.fn(1024).a(c2, new java.math.BigInteger("ceeef5035212dfe7c6a0acdc0ef35ce5b118aab916477037d7381f85c6b6176fcf57b1d1c3296af0bb1c483fe5e1eb0ce9eb2953b44e494ca60777a1b033cc07", 16), new java.math.BigInteger("191737288d17e660c4b61440d5d14228a0bf9854499f9d68d8274db55d6d954489371ecf314f26bec236e58fac7fffa9b27bcf923e1229c4080d49f7758739e5bd6014383ed2a75ce1be9b0ab22f283c5c5e11216c5658ba444212b6270d629f2d615b8dfdec8545fb7d4f935b0cc10b6948ab4fc1cb1dd496a8f94b51e888dd", 16));
                        try {
                            byteArrayOutputStream2 = new java.io.ByteArrayOutputStream();
                            try {
                                java.io.DataOutputStream dataOutputStream = new java.io.DataOutputStream(byteArrayOutputStream2);
                                try {
                                    dataOutputStream.writeInt(a3.length);
                                    dataOutputStream.write(a3);
                                    dataOutputStream.writeInt(a2.length);
                                    dataOutputStream.write(a2);
                                    dataOutputStream.flush();
                                    cn.fly.verify.dw.a(dataOutputStream, byteArrayOutputStream2);
                                    return android.util.Base64.encodeToString(byteArrayOutputStream2.toByteArray(), 2);
                                } catch (java.lang.Throwable th) {
                                    th = th;
                                    bufferedOutputStream = dataOutputStream;
                                    cn.fly.verify.dw.a(bufferedOutputStream, byteArrayOutputStream2);
                                    throw th;
                                }
                            } catch (java.lang.Throwable th2) {
                                th = th2;
                            }
                        } catch (java.lang.Throwable th3) {
                            th = th3;
                            byteArrayOutputStream2 = null;
                        }
                    } catch (java.lang.Throwable th4) {
                        th = th4;
                        bufferedOutputStream = bufferedOutputStream2;
                        cn.fly.verify.dw.a(bufferedOutputStream, gZIPOutputStream, byteArrayOutputStream);
                        throw th;
                    }
                } catch (java.lang.Throwable th5) {
                    th = th5;
                }
            } catch (java.lang.Throwable th6) {
                th = th6;
                gZIPOutputStream = null;
            }
        } catch (java.lang.Throwable th7) {
            th = th7;
            byteArrayOutputStream = null;
            gZIPOutputStream = null;
        }
    }

    private java.lang.String a(java.util.TreeMap<java.lang.String, java.lang.Object> treeMap) {
        java.util.HashMap hashMap;
        java.lang.String str = null;
        if (!cn.fly.verify.bo.c() || treeMap == null || treeMap.isEmpty()) {
            return null;
        }
        try {
            java.util.HashMap hashMap2 = new java.util.HashMap();
            hashMap2.put(cn.fly.verify.bj.a("0074fgOedj@feekel"), treeMap.get(cn.fly.verify.bj.a("0074fgOedj@feekel")));
            hashMap2.put(cn.fly.verify.bj.a("005JegfeedPgh"), treeMap.get(cn.fly.verify.bj.a("005JegfeedPgh")));
            hashMap2.put(cn.fly.verify.bj.a("0064gielgiee(g+ek"), treeMap.get(cn.fly.verify.bj.a("0064gielgiee(g+ek")));
            hashMap2.put(cn.fly.verify.bj.a("008+edVgLeeej?dg<fjed"), treeMap.get(cn.fly.verify.bj.a("008+edVgLeeej?dg<fjed")));
            hashMap2.put(cn.fly.verify.bj.a("004,edehejed"), treeMap.get(cn.fly.verify.bj.a("004,edehejed")));
            java.util.HashMap<java.lang.String, java.lang.Object> hashMap3 = new java.util.HashMap<>();
            hashMap3.put(cn.fly.verify.bj.a("006ekk:em0gFel"), cn.fly.verify.dv.a());
            hashMap3.put(com.anythink.expressad.d.a.b.dH, a(cn.fly.verify.fm.a(hashMap2)));
            java.util.HashMap<java.lang.String, java.lang.String> hashMap4 = new java.util.HashMap<>();
            hashMap4.put(cn.fly.verify.bj.a("0139fhgiSg0ekilfjedLgfj*ej)j^el"), cn.fly.verify.bk.c());
            hashMap4.put(cn.fly.verify.bj.a("004Fegfeejed"), cn.fly.verify.eh.a(cn.fly.verify.ax.g()).d().ai());
            cn.fly.verify.fc.a aVar = new cn.fly.verify.fc.a();
            aVar.a = 30000;
            aVar.b = 30000;
            java.util.HashMap a2 = cn.fly.verify.fm.a(new cn.fly.verify.fc().b(cn.fly.verify.dj.a().a("gclg") + cn.fly.verify.bj.a("007m;fe]kgfRejed"), hashMap3, hashMap4, aVar));
            if (!com.meizu.cloud.pushsdk.platform.message.BasicPushStatus.SUCCESS_CODE.equals(java.lang.String.valueOf(a2.get(cn.fly.verify.bj.a("004dUfeed'g")))) || (hashMap = (java.util.HashMap) a2.get(cn.fly.verify.bj.a("004Wed:eje"))) == null) {
                return null;
            }
            java.lang.String str2 = (java.lang.String) hashMap.get(cn.fly.verify.bj.a("005j^feemRgf"));
            try {
                e.f = str2;
                b(str2);
                return str2;
            } catch (java.lang.Throwable th) {
                th = th;
                str = str2;
                cn.fly.verify.ed.a().c(th);
                return str;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    private java.util.HashMap<java.lang.String, java.lang.Object> a(java.lang.String str, byte[] bArr) {
        try {
            return cn.fly.verify.fm.a(cn.fly.verify.fi.a(str, bArr));
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().a(th);
            return new java.util.HashMap<>();
        }
    }

    private boolean a(java.util.HashMap<java.lang.String, java.lang.Object> hashMap) {
        java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
        java.lang.String[] strArr = new java.lang.String[1];
        cn.fly.verify.fh.a(cn.fly.verify.ax.g()).h().a(new cn.fly.verify.bm.AnonymousClass1(strArr, countDownLatch));
        try {
            this.h.put(cn.fly.verify.bj.a("007;fg>edj<feekel"), cn.fly.verify.fh.d.k());
            this.h.put(cn.fly.verify.bj.a("0058egfeedXgh"), cn.fly.verify.fh.d.j());
            this.h.put(cn.fly.verify.bj.a("006.gielgiee1g3ek"), java.lang.Integer.valueOf(cn.fly.verify.fh.d.g()));
            countDownLatch.await(100L, java.util.concurrent.TimeUnit.MILLISECONDS);
            java.lang.String str = strArr[0];
            if (!android.text.TextUtils.isEmpty(str)) {
                this.h.put(cn.fly.verify.bj.a("008?ed*gTeeej%dg_fjed"), str);
            }
            this.h.put(cn.fly.verify.bj.a("004$edehejed"), cn.fly.verify.df.a((cn.fly.verify.bd) null));
            java.lang.String b2 = cn.fly.verify.fi.b(new org.json.JSONObject(this.h).toString());
            java.util.TreeMap<java.lang.String, java.lang.Object> treeMap = new java.util.TreeMap<>();
            treeMap.put(cn.fly.verify.bj.a("010!ffAgfg^ek+eh,idedij"), b2);
            b(treeMap);
            if (hashMap == null || hashMap.isEmpty() || !b2.equals((java.lang.String) hashMap.get(cn.fly.verify.bj.a("010Bff6gfg0ekWeh]idedij")))) {
                return true;
            }
            cn.fly.verify.ed.a().a("[%s] %s", a, "No changes");
            return false;
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().c(th);
            return false;
        }
    }

    private byte[] a(java.lang.String str, java.util.TreeMap<java.lang.String, java.lang.Object> treeMap) {
        try {
            return cn.fly.verify.fi.a(str, new org.json.JSONObject(treeMap).toString());
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().a(th);
            return null;
        }
    }

    private void b(java.lang.String str) {
        java.io.FileOutputStream fileOutputStream;
        java.io.DataOutputStream dataOutputStream = null;
        try {
            java.io.File b2 = cn.fly.verify.fq.b(this.g, b);
            if (b2 != null) {
                fileOutputStream = new java.io.FileOutputStream(b2);
                try {
                    java.io.DataOutputStream dataOutputStream2 = new java.io.DataOutputStream(fileOutputStream);
                    try {
                        dataOutputStream2.writeUTF(str);
                        dataOutputStream2.flush();
                        dataOutputStream = dataOutputStream2;
                    } catch (java.lang.Throwable th) {
                        th = th;
                        dataOutputStream = dataOutputStream2;
                        try {
                            cn.fly.verify.ed.a().a(th);
                            cn.fly.verify.dw.a(dataOutputStream, fileOutputStream);
                            return;
                        } catch (java.lang.Throwable th2) {
                            cn.fly.verify.dw.a(dataOutputStream, fileOutputStream);
                            throw th2;
                        }
                    }
                } catch (java.lang.Throwable th3) {
                    th = th3;
                }
            } else {
                fileOutputStream = null;
            }
            cn.fly.verify.dw.a(dataOutputStream, fileOutputStream);
        } catch (java.lang.Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
    }

    private void b(java.util.TreeMap<java.lang.String, java.lang.Object> treeMap) {
        cn.fly.verify.fq.a(cn.fly.verify.fq.b(this.g, c), a(d, treeMap));
    }

    private java.lang.String d() {
        java.lang.String e2;
        boolean a2;
        java.util.TreeMap<java.lang.String, java.lang.Object> treeMap;
        this.h = new java.util.TreeMap<>();
        java.lang.String str = null;
        try {
            e2 = e();
            a2 = a(f());
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().a(th);
        }
        if (android.text.TextUtils.isEmpty(e2)) {
            treeMap = this.h;
        } else {
            cn.fly.verify.ed.a().a("[%s] %s", a, "tk status: " + a2);
            if (!a2) {
                str = e2;
                e.f = str;
                return str;
            }
            treeMap = this.h;
        }
        str = a(treeMap);
        e.f = str;
        return str;
    }

    private java.lang.String e() {
        java.io.DataInputStream dataInputStream;
        java.io.FileInputStream fileInputStream;
        java.lang.String str;
        java.io.DataInputStream dataInputStream2 = null;
        try {
            java.io.File b2 = cn.fly.verify.fq.b(this.g, b);
            if (!b2.exists() || b2.length() <= 0) {
                str = null;
                fileInputStream = null;
            } else {
                fileInputStream = new java.io.FileInputStream(b2);
                try {
                    dataInputStream = new java.io.DataInputStream(fileInputStream);
                } catch (java.lang.Throwable th) {
                    th = th;
                    dataInputStream = null;
                }
                try {
                    str = dataInputStream.readUTF();
                    dataInputStream2 = dataInputStream;
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    try {
                        cn.fly.verify.ed.a().a(th);
                        cn.fly.verify.dw.a(dataInputStream, fileInputStream);
                        return null;
                    } catch (java.lang.Throwable th3) {
                        cn.fly.verify.dw.a(dataInputStream, fileInputStream);
                        throw th3;
                    }
                }
            }
            cn.fly.verify.dw.a(dataInputStream2, fileInputStream);
            return str;
        } catch (java.lang.Throwable th4) {
            th = th4;
            dataInputStream = null;
            fileInputStream = null;
        }
    }

    private java.util.HashMap<java.lang.String, java.lang.Object> f() {
        return a(d, cn.fly.verify.fq.b(cn.fly.verify.fq.b(this.g, c)));
    }

    public java.lang.String b() {
        if (android.text.TextUtils.isEmpty(this.f)) {
            synchronized (cn.fly.verify.bm.class) {
                if (android.text.TextUtils.isEmpty(this.f)) {
                    return d();
                }
            }
        }
        return this.f;
    }

    public java.lang.String c() {
        java.lang.String str = this.f;
        return android.text.TextUtils.isEmpty(str) ? e() : str;
    }
}
