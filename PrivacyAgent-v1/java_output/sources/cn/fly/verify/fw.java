package cn.fly.verify;

@android.annotation.SuppressLint({"MissingPermission"})
/* loaded from: classes.dex */
public class fw {
    private static cn.fly.verify.fw a;

    private fw() {
    }

    public static cn.fly.verify.fw a() {
        if (a == null) {
            synchronized (cn.fly.verify.fw.class) {
                if (a == null) {
                    a = new cn.fly.verify.fw();
                }
            }
        }
        return a;
    }

    public java.lang.Object a(android.content.Context context, int i, int i2, boolean z, boolean z2) {
        return null;
    }
}
