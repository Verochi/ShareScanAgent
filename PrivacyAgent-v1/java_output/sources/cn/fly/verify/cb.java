package cn.fly.verify;

/* loaded from: classes.dex */
public class cb extends cn.fly.verify.bu {
    public cb(android.content.Context context) {
        super(context);
    }

    private java.lang.String a(android.content.Context context, java.lang.Object obj, java.lang.reflect.Method method) {
        if (obj == null || method == null) {
            return null;
        }
        try {
            java.lang.Object invoke = method.invoke(obj, context);
            if (invoke != null) {
                return (java.lang.String) invoke;
            }
            return null;
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().a(th);
            return null;
        }
    }

    @Override // cn.fly.verify.bu
    public cn.fly.verify.bu.b b() {
        java.lang.Class<?> cls;
        java.lang.Object obj;
        java.lang.reflect.Method method = null;
        try {
            cls = java.lang.Class.forName(cn.fly.verify.ba.a("034eDgffhhfKfgMfeflgffkfehffkfehffkfhPliHhfgkfeinflgffffkfe4hUflgkfhMli"));
            try {
                obj = cls.newInstance();
            } catch (java.lang.Throwable th) {
                th = th;
                cn.fly.verify.ed.a().a(th);
                obj = null;
                if (cls != null) {
                    try {
                        method = cls.getMethod(cn.fly.verify.ba.a("007Bgg5hkIiigngkhm"), android.content.Context.class);
                    } catch (java.lang.Throwable th2) {
                        cn.fly.verify.ed.a().a(th2);
                    }
                }
                cn.fly.verify.bu.b bVar = new cn.fly.verify.bu.b();
                bVar.b = a(this.a, obj, method);
                bVar.a = cls == null && obj != null;
                return bVar;
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            cls = null;
        }
        if (cls != null && obj != null) {
            method = cls.getMethod(cn.fly.verify.ba.a("007Bgg5hkIiigngkhm"), android.content.Context.class);
        }
        cn.fly.verify.bu.b bVar2 = new cn.fly.verify.bu.b();
        bVar2.b = a(this.a, obj, method);
        bVar2.a = cls == null && obj != null;
        return bVar2;
    }
}
