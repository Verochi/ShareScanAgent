package cn.fly.verify;

/* loaded from: classes.dex */
public class dt {
    private static cn.fly.verify.dt a;
    private java.util.HashMap<java.lang.String, java.lang.Object> b;

    private dt() {
        java.util.HashMap<java.lang.String, java.lang.Object> c = c();
        this.b = c;
        if (c == null) {
            this.b = new java.util.HashMap<>();
        }
        java.util.ArrayList<cn.fly.verify.bd> b = cn.fly.verify.bk.b();
        if (b == null || b.isEmpty()) {
            return;
        }
        java.util.Iterator<cn.fly.verify.bd> it = b.iterator();
        while (it.hasNext()) {
            cn.fly.verify.bd next = it.next();
            if (!this.b.containsKey(next.a())) {
                this.b.put(next.a(), 0);
            }
        }
    }

    public static cn.fly.verify.dt a() {
        if (a == null) {
            synchronized (cn.fly.verify.dt.class) {
                if (a == null) {
                    a = new cn.fly.verify.dt();
                }
            }
        }
        return a;
    }

    public static java.lang.String a(java.lang.String str) {
        return cn.fly.verify.dw.a(str, 99);
    }

    private java.util.HashMap<java.lang.String, java.lang.Object> c() {
        try {
            return cn.fly.verify.bl.a().g();
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public java.util.HashMap<java.lang.String, java.lang.Object> b() {
        return this.b;
    }
}
