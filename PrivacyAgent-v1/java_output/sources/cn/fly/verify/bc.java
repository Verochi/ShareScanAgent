package cn.fly.verify;

/* loaded from: classes.dex */
public class bc {
    public static <T> T a(cn.fly.verify.bd bdVar, java.lang.String str, java.lang.Class<T> cls, T t) {
        if (android.os.Looper.myLooper() == android.os.Looper.getMainLooper()) {
            cn.fly.verify.ed.a().b("WARNING: gt mta in main: key = " + str);
        }
        java.lang.Object a = cn.fly.verify.ds.a(str, cls, bdVar);
        if (a == null) {
            a = cn.fly.verify.ds.a(str);
        }
        return a == null ? t : (T) a;
    }
}
