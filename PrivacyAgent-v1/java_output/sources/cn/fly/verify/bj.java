package cn.fly.verify;

/* loaded from: classes.dex */
public class bj implements android.os.Handler.Callback {
    private static cn.fly.verify.bj a = new cn.fly.verify.bj();
    private android.os.Handler b;

    private bj() {
        java.lang.String str;
        if (android.text.TextUtils.isEmpty("M-")) {
            str = null;
        } else {
            str = cn.fly.verify.ea.a + a("004_flidilig");
        }
        this.b = cn.fly.verify.ec.a(str, this);
    }

    private <T extends cn.fly.verify.bf> int a(T t) {
        int j = t.j();
        return j > 0 ? j + 10000 : j + com.anythink.core.common.h.i.k;
    }

    public static cn.fly.verify.bj a() {
        return a;
    }

    public static java.lang.String a(java.lang.String str) {
        return cn.fly.verify.dw.a(str, 100);
    }

    private void a(android.os.Message message, long j) {
        if (j > 0) {
            this.b.sendMessageDelayed(message, j);
        } else {
            this.b.sendMessage(message);
        }
    }

    private boolean a(int i, long j, java.lang.Runnable runnable) {
        if (this.b.hasMessages(i)) {
            return false;
        }
        b(i, j, runnable);
        return true;
    }

    private boolean b(int i, long j, java.lang.Runnable runnable) {
        android.os.Message obtain = android.os.Message.obtain();
        obtain.what = i;
        obtain.obj = runnable;
        a(obtain, j);
        return true;
    }

    public void a(long j, int i, cn.fly.verify.cd.b bVar) {
        android.os.Message obtain = android.os.Message.obtain();
        obtain.what = 1002;
        obtain.arg1 = i;
        obtain.obj = bVar;
        a(obtain, j * 1000);
    }

    public <T extends cn.fly.verify.bf> void a(long j, T t, int i) {
        int a2 = a((cn.fly.verify.bj) t);
        if (i == 1) {
            this.b.removeMessages(a2);
        } else if (i == 2 && this.b.hasMessages(a2)) {
            return;
        }
        android.os.Message obtain = android.os.Message.obtain();
        obtain.what = a2;
        obtain.obj = t;
        a(obtain, j * 1000);
    }

    public boolean a(long j, java.lang.Runnable runnable) {
        return a(1003, j * 1000, runnable);
    }

    public void b() {
        this.b.removeMessages(1002);
    }

    public boolean b(long j, java.lang.Runnable runnable) {
        return a(1004, j * 1000, runnable);
    }

    public boolean c(long j, java.lang.Runnable runnable) {
        return a(1006, j * 1000, runnable);
    }

    public boolean d(long j, java.lang.Runnable runnable) {
        return b(1005, j, runnable);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(android.os.Message message) {
        java.lang.Runnable runnable;
        java.util.concurrent.ThreadPoolExecutor threadPoolExecutor;
        cn.fly.verify.bf bfVar;
        try {
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().a(th);
        }
        if (!cn.fly.verify.bo.d()) {
            android.os.Message obtain = android.os.Message.obtain();
            obtain.copyFrom(message);
            this.b.sendMessageDelayed(obtain, 60000L);
            return false;
        }
        int i = message.what;
        if (i != 1003 && i != 1004 && i != 1006) {
            if (i == 1002) {
                cn.fly.verify.cd.b bVar = (cn.fly.verify.cd.b) message.obj;
                if (bVar != null) {
                    if (!bVar.a) {
                        bVar.a = true;
                    }
                    cn.fly.verify.ea.d.execute(bVar);
                    int i2 = message.arg1;
                    android.os.Message obtain2 = android.os.Message.obtain();
                    obtain2.what = 1002;
                    obtain2.obj = bVar;
                    obtain2.arg1 = i2;
                    a(obtain2, i2 * 1000);
                }
            } else if (i == 1005) {
                runnable = (java.lang.Runnable) message.obj;
                if (runnable != null) {
                    threadPoolExecutor = cn.fly.verify.ea.c;
                    threadPoolExecutor.execute(runnable);
                }
            } else if ((i >= 10000 || i < -10000) && (bfVar = (cn.fly.verify.bf) message.obj) != null) {
                bfVar.g();
            }
            return false;
        }
        runnable = (java.lang.Runnable) message.obj;
        if (runnable != null) {
            threadPoolExecutor = cn.fly.verify.ea.d;
            threadPoolExecutor.execute(runnable);
        }
        return false;
    }
}
