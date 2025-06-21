package cn.fly.verify;

@java.lang.Deprecated
/* loaded from: classes.dex */
public class dm {
    private static cn.fly.verify.dm a;
    private final java.util.HashMap<java.lang.String, java.lang.Integer> b = new java.util.HashMap<>();

    private dm() {
    }

    public static synchronized cn.fly.verify.dm a() {
        cn.fly.verify.dm dmVar;
        synchronized (cn.fly.verify.dm.class) {
            if (a == null) {
                a = new cn.fly.verify.dm();
            }
            dmVar = a;
        }
        return dmVar;
    }

    public void a(java.lang.String str, int i) {
        synchronized (this.b) {
            this.b.put(str, java.lang.Integer.valueOf(i));
        }
    }
}
