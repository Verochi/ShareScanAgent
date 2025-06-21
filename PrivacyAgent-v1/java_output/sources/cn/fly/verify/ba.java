package cn.fly.verify;

/* loaded from: classes31.dex */
public class ba {
    private static cn.fly.verify.ba a;
    private volatile android.os.Handler c;
    private volatile long f;
    private final java.util.HashSet<cn.fly.verify.dl> b = new java.util.HashSet<>();
    private java.lang.String d = null;
    private volatile long e = -1;

    /* renamed from: cn.fly.verify.ba$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements android.os.Handler.Callback {
        public AnonymousClass1() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(android.os.Message message) {
            int i = message.what;
            if (i == 0) {
                cn.fly.verify.ba.this.e = android.os.SystemClock.elapsedRealtime();
                cn.fly.verify.ba.this.a(false);
                cn.fly.verify.ba.this.c();
            } else if (i == 1) {
                cn.fly.verify.ba.this.a(true);
            } else if (i == 2) {
                cn.fly.verify.ba.this.a(((java.lang.Long) message.obj).longValue(), true);
            } else if (i == 3) {
                try {
                    cn.fly.verify.dl dlVar = (cn.fly.verify.dl) message.obj;
                    if (dlVar != null) {
                        cn.fly.verify.ba.this.b.add(dlVar);
                        dlVar.a(cn.fly.verify.ba.this.e > 0, true, 0L);
                    }
                } catch (java.lang.Throwable th) {
                    cn.fly.verify.ed.a().a(th);
                }
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public class a implements cn.fly.verify.fg.b {
        public a() {
        }

        @Override // cn.fly.verify.fg.b
        public void a(android.app.Activity activity) {
        }

        @Override // cn.fly.verify.fg.b
        public void a(android.app.Activity activity, android.os.Bundle bundle) {
        }

        @Override // cn.fly.verify.fg.b
        public void b(android.app.Activity activity) {
            try {
                cn.fly.verify.ba.this.f = android.os.SystemClock.elapsedRealtime();
                if (cn.fly.verify.ba.this.e == 0) {
                    cn.fly.verify.ba.this.e = android.os.SystemClock.elapsedRealtime();
                    if (cn.fly.verify.ba.this.c != null) {
                        cn.fly.verify.ba.this.c.sendEmptyMessage(1);
                    }
                }
                cn.fly.verify.ba.this.d = activity == null ? null : activity.toString();
            } catch (java.lang.Throwable unused) {
            }
        }

        @Override // cn.fly.verify.fg.b
        public void b(android.app.Activity activity, android.os.Bundle bundle) {
        }

        @Override // cn.fly.verify.fg.b
        public void c(android.app.Activity activity) {
        }

        @Override // cn.fly.verify.fg.b
        public void d(android.app.Activity activity) {
            try {
                if (cn.fly.verify.ba.this.d != null) {
                    if (!cn.fly.verify.ba.this.d.equals(activity == null ? null : activity.toString())) {
                        return;
                    }
                }
                if (cn.fly.verify.ba.this.c != null) {
                    long elapsedRealtime = cn.fly.verify.ba.this.e > 0 ? android.os.SystemClock.elapsedRealtime() - cn.fly.verify.ba.this.e : 0L;
                    android.os.Message message = new android.os.Message();
                    message.what = 2;
                    message.obj = java.lang.Long.valueOf(elapsedRealtime);
                    cn.fly.verify.ba.this.c.sendMessage(message);
                }
                cn.fly.verify.ba.this.e = 0L;
                cn.fly.verify.ba.this.d = null;
            } catch (java.lang.Throwable unused) {
            }
        }

        @Override // cn.fly.verify.fg.b
        public void e(android.app.Activity activity) {
            if (cn.fly.verify.ba.this.e > 0) {
                d(activity);
            }
        }
    }

    private ba() {
        java.lang.String str = null;
        this.f = 0L;
        this.f = android.os.SystemClock.elapsedRealtime();
        if (!android.text.TextUtils.isEmpty("M-")) {
            str = cn.fly.verify.ea.a + a("0041hnhkjmjh");
        }
        this.c = cn.fly.verify.ec.a(str, new cn.fly.verify.ba.AnonymousClass1());
    }

    public static synchronized cn.fly.verify.ba a() {
        cn.fly.verify.ba baVar;
        synchronized (cn.fly.verify.ba.class) {
            if (a == null) {
                cn.fly.verify.ba baVar2 = new cn.fly.verify.ba();
                a = baVar2;
                if (baVar2.c != null) {
                    a.c.sendEmptyMessage(0);
                }
            }
            baVar = a;
        }
        return baVar;
    }

    public static java.lang.String a(java.lang.String str) {
        return cn.fly.verify.dw.a(str, 101);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, boolean z) {
        if (z) {
            a(false, false, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (z) {
            a(true, false, 0L);
        }
    }

    private void a(boolean z, boolean z2, long j) {
        synchronized (this.b) {
            java.util.Iterator<cn.fly.verify.dl> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().a(z, z2, j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        cn.fly.verify.fg.a(cn.fly.verify.ax.g()).a(new cn.fly.verify.ba.a());
    }

    public void a(cn.fly.verify.dl dlVar) {
        if (dlVar == null) {
            return;
        }
        synchronized (this.b) {
            if (this.b.contains(dlVar)) {
                return;
            }
            if (this.c != null) {
                android.os.Message message = new android.os.Message();
                message.what = 3;
                message.obj = dlVar;
                this.c.sendMessage(message);
            }
        }
    }

    public long b() {
        return this.f;
    }
}
