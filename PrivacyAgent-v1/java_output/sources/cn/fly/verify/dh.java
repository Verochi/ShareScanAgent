package cn.fly.verify;

/* loaded from: classes.dex */
public class dh {
    private static final java.lang.String a = cn.fly.verify.dt.a("004:fddcfhDg");
    private static cn.fly.verify.dh b;
    private cn.fly.verify.fb c;
    private java.lang.String f;
    private java.text.SimpleDateFormat d = new java.text.SimpleDateFormat(cn.fly.verify.dt.a("025)dkdkdkdkhkhchchkdcdciffjfj]k-dfdf^k:fhfhfdejejejifgc"));
    private java.util.HashMap<java.lang.String, java.lang.Object> e = new java.util.HashMap<>();
    private java.lang.String g = cn.fly.verify.dt.a("008,fhfedjdh+edLdf_f");
    private java.lang.Runnable h = new cn.fly.verify.dh.AnonymousClass1();

    /* renamed from: cn.fly.verify.dh$1, reason: invalid class name */
    public class AnonymousClass1 extends cn.fly.verify.fy {
        public AnonymousClass1() {
        }

        @Override // cn.fly.verify.fy
        public void a() {
            if (cn.fly.verify.bo.c()) {
                cn.fly.verify.dh.this.b();
            }
        }
    }

    /* renamed from: cn.fly.verify.dh$2, reason: invalid class name */
    public class AnonymousClass2 extends cn.fly.verify.fy {
        final /* synthetic */ android.os.Message a;

        public AnonymousClass2(android.os.Message message) {
            this.a = message;
        }

        @Override // cn.fly.verify.fy
        public void a() {
            cn.fly.verify.dh.this.a(this.a);
        }
    }

    /* renamed from: cn.fly.verify.dh$3, reason: invalid class name */
    public class AnonymousClass3 implements cn.fly.verify.fh.a {
        public AnonymousClass3() {
        }

        @Override // cn.fly.verify.fh.a
        public void a(cn.fly.verify.fh.b bVar) {
            cn.fly.verify.bj.a().c(10L, cn.fly.verify.dh.this.h);
        }
    }

    private dh() {
        this.f = null;
        this.f = java.util.UUID.randomUUID().toString();
    }

    public static synchronized cn.fly.verify.dh a() {
        cn.fly.verify.dh dhVar;
        synchronized (cn.fly.verify.dh.class) {
            if (b == null) {
                b = new cn.fly.verify.dh();
            }
            dhVar = b;
        }
        return dhVar;
    }

    private java.lang.String a(java.lang.Throwable th) {
        if (th == null) {
            return "";
        }
        java.lang.Throwable th2 = th;
        while (true) {
            java.io.StringWriter stringWriter = null;
            if (th2 != null) {
                try {
                    if (th2 instanceof java.net.UnknownHostException) {
                        cn.fly.verify.dw.a(null);
                        return "";
                    }
                    th2 = th2.getCause();
                } catch (java.lang.Throwable th3) {
                    th = th3;
                }
            } else {
                java.io.StringWriter stringWriter2 = new java.io.StringWriter();
                try {
                    java.io.PrintWriter printWriter = new java.io.PrintWriter(stringWriter2);
                    th.printStackTrace(printWriter);
                    printWriter.flush();
                    java.lang.String stringWriter3 = stringWriter2.toString();
                    cn.fly.verify.dw.a(stringWriter2);
                    return stringWriter3;
                } catch (java.lang.Throwable th4) {
                    th = th4;
                    stringWriter = stringWriter2;
                }
            }
            th = th3;
            try {
                if (th instanceof java.lang.OutOfMemoryError) {
                    java.lang.String a2 = cn.fly.verify.dt.a("0238ee2fi0ej6idc>dlekdj+dcf!ejTiXdjdiLe*eeifededdf");
                    cn.fly.verify.dw.a(stringWriter);
                    return a2;
                }
                java.lang.String message = th.getMessage();
                cn.fly.verify.dw.a(stringWriter);
                return message;
            } catch (java.lang.Throwable th5) {
                cn.fly.verify.dw.a(stringWriter);
                throw th5;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private synchronized void a(int i, int i2, java.lang.Throwable th, java.lang.String str, java.lang.String str2) {
        if (th == null) {
            cn.fly.verify.ed.a().a(str, new java.lang.Object[0]);
        } else {
            cn.fly.verify.ed.a().a(th);
        }
        if (cn.fly.verify.df.a()) {
            return;
        }
        android.os.Message message = new android.os.Message();
        message.what = 1;
        message.arg1 = 1;
        java.lang.Object[] objArr = new java.lang.Object[5];
        objArr[0] = java.lang.Long.valueOf(java.lang.System.currentTimeMillis());
        if (th == null) {
            th = str;
        }
        objArr[1] = th;
        objArr[2] = java.lang.Integer.valueOf(i);
        objArr[3] = java.lang.Integer.valueOf(i2);
        objArr[4] = str2;
        message.obj = objArr;
        cn.fly.verify.ea.d.execute(new cn.fly.verify.dh.AnonymousClass2(message));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(android.os.Message message) {
        if (this.e.size() > 10) {
            c(this.e);
            this.e.clear();
        }
        java.lang.Object[] objArr = (java.lang.Object[]) message.obj;
        this.e.put(cn.fly.verify.dt.a("002Zfhdc"), this.f);
        java.util.ArrayList arrayList = (java.util.ArrayList) this.e.get(cn.fly.verify.dt.a("004gHdifhVi"));
        if (arrayList == null) {
            arrayList = new java.util.ArrayList();
        }
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put(cn.fly.verify.dt.a("002ci"), objArr[0]);
        java.lang.Object obj = objArr[1];
        java.lang.String a2 = obj instanceof java.lang.Throwable ? a((java.lang.Throwable) obj) : java.lang.String.valueOf(obj);
        if (!android.text.TextUtils.isEmpty(a2)) {
            a2 = a2.replaceAll("\r\n\t", " ").replaceAll("\n\t", " ").replaceAll("\n", " ");
        }
        hashMap.put(cn.fly.verify.dt.a("002Rdfee"), "[" + this.d.format(objArr[0]) + "][" + objArr[2] + "][" + objArr[3] + "][" + objArr[4] + "] " + a2);
        hashMap.put(cn.fly.verify.dt.a("002fi"), objArr[2]);
        hashMap.put(cn.fly.verify.dt.a("002jVed"), objArr[3]);
        hashMap.put(this.g, objArr[4]);
        arrayList.add(hashMap);
        this.e.put(cn.fly.verify.dt.a("004g;difhVi"), arrayList);
        if (cn.fly.verify.df.a()) {
            return;
        }
        cn.fly.verify.fh.a(cn.fly.verify.ax.g()).a(new cn.fly.verify.dh.AnonymousClass3());
    }

    private boolean a(java.util.HashMap<java.lang.String, java.lang.Object> hashMap) {
        try {
            return b(hashMap);
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().a(th);
            try {
                return b(hashMap);
            } catch (java.lang.Throwable th2) {
                cn.fly.verify.ed.a().a(th2);
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        boolean z;
        java.io.File[] listFiles;
        if (this.e.size() > 0) {
            z = a(this.e);
            if (!z) {
                c(this.e);
            }
            this.e.clear();
        } else {
            z = true;
        }
        if (z) {
            java.io.File d = d();
            if (!d.exists() || !d.isDirectory() || (listFiles = d.listFiles()) == null || listFiles.length <= 0) {
                return;
            }
            for (java.io.File file : listFiles) {
                if (a((java.util.HashMap<java.lang.String, java.lang.Object>) cn.fly.verify.fq.a(file.getAbsolutePath())) && !file.delete()) {
                    file.delete();
                }
            }
        }
    }

    private boolean b(java.util.HashMap<java.lang.String, java.lang.Object> hashMap) throws java.lang.Throwable {
        if (hashMap == null || hashMap.isEmpty()) {
            return true;
        }
        java.util.HashMap<java.lang.String, java.lang.Object> d = cn.fly.verify.dv.d();
        d.put(cn.fly.verify.dt.a("006f6djdjeddjfh"), hashMap);
        c();
        java.util.HashMap hashMap2 = (java.util.HashMap) this.c.b(false, cn.fly.verify.av.a(), d, cn.fly.verify.dj.a().a("dtc") + "/v2/sdrl", true);
        return hashMap2 == null || hashMap2.isEmpty();
    }

    private void c() {
        if (this.c == null) {
            this.c = new cn.fly.verify.fb(1024, "ab0a0a6473d1891d388773574764b239d4ad80cb2fd3a83d81d03901c1548c13fee7c9692c326e6682b239d4c5d0021d1b607642c47ec29f10b0602908c3e6c9", "23c3c8cb41c47dd288cc7f4c218fbc7c839a34e0a0d1b2130e87b7914936b120a2d6570ee7ac66282328d50f2acfd82f2259957c89baea32547758db05de9cd7c6822304c8e45742f24bbbe41c1e12f09e18c6fab4d078065f2e5aaed94c900c66e8bbf8a120eefa7bd1fb52114d529250084f5f6f369ed4ce9645978dd30c51");
        }
    }

    private void c(java.util.HashMap<java.lang.String, java.lang.Object> hashMap) {
        java.io.File[] listFiles;
        try {
            java.io.File d = d();
            if (!d.exists() || !d.isDirectory()) {
                d.delete();
                d.mkdirs();
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            java.lang.String str = a;
            sb.append(str);
            sb.append("_");
            int i = 0;
            sb.append(0);
            java.io.File file = new java.io.File(d, sb.toString());
            if (file.exists() && (listFiles = d.listFiles()) != null && listFiles.length > 0) {
                file = new java.io.File(d, str + "_0");
                while (file.exists()) {
                    i++;
                    file = new java.io.File(d, a + "_" + i);
                }
            }
            cn.fly.verify.fq.a(file.getPath(), (java.lang.Object) hashMap);
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().a(th);
        }
    }

    private java.io.File d() {
        return new java.io.File(cn.fly.verify.fq.h(cn.fly.verify.ax.g()), a);
    }

    public synchronized void a(int i, int i2, java.lang.String str, java.lang.String str2) {
        a(i, i2, null, str, str2);
    }

    public synchronized void a(int i, int i2, java.lang.Throwable th, java.lang.String str) {
        a(i, i2, th, null, str);
    }
}
