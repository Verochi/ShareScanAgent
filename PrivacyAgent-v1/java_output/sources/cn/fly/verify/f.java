package cn.fly.verify;

/* loaded from: classes.dex */
public class f {
    private static cn.fly.verify.f a = new cn.fly.verify.f();
    private static cn.fly.verify.eu b;

    private f() {
        try {
            b = cn.fly.verify.eu.a(cn.fly.verify.FlyVerify.sdkTag);
            cn.fly.verify.dm.a().a(cn.fly.verify.FlyVerify.sdkTag, 130604);
        } catch (java.lang.Throwable unused) {
        }
    }

    public static cn.fly.verify.f a() {
        if (a == null) {
            synchronized (cn.fly.verify.f.class) {
                if (a == null) {
                    a = new cn.fly.verify.f();
                }
            }
        }
        return a;
    }

    public void a(java.lang.String str) {
        cn.fly.verify.eu euVar = b;
        if (euVar != null) {
            euVar.a("[FlyVerify] ==>%s", str);
        }
    }

    public void a(java.lang.String str, java.lang.String str2) {
        cn.fly.verify.eu euVar = b;
        if (euVar != null) {
            euVar.c(str, str2);
        }
    }

    public void a(java.lang.Throwable th) {
        cn.fly.verify.eu euVar = b;
        if (euVar != null) {
            euVar.d("[FlyVerify] ==>%s", th);
        }
    }

    public void a(java.lang.Throwable th, java.lang.String str, java.lang.String str2) {
        cn.fly.verify.eu euVar = b;
        if (euVar != null) {
            euVar.a(th, str, str2);
        }
    }

    public void a(java.lang.Throwable th, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
    }

    public void b(java.lang.String str, java.lang.String str2) {
        cn.fly.verify.eu euVar = b;
        if (euVar != null) {
            euVar.a(str, str2);
        }
    }

    public void b(java.lang.Throwable th) {
        cn.fly.verify.eu euVar = b;
        if (euVar != null) {
            euVar.a("[FlyVerify] ==>%s", th);
        }
    }

    public void b(java.lang.Throwable th, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
    }

    public void c(java.lang.String str, java.lang.String str2) {
        cn.fly.verify.eu euVar = b;
        if (euVar != null) {
            euVar.d(str, str2);
        }
    }

    public void c(java.lang.Throwable th) {
        cn.fly.verify.eu euVar = b;
        if (euVar != null) {
            euVar.b("[FlyVerify] ==>%s", th);
        }
    }
}
