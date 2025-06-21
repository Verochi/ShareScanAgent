package cn.fly.verify;

/* loaded from: classes.dex */
public class au {
    public static android.net.ConnectivityManager a;
    private static cn.fly.verify.au c;
    public volatile android.net.Network b;
    private android.net.ConnectivityManager.NetworkCallback d;

    private au(android.content.Context context) {
        try {
            a = (android.net.ConnectivityManager) context.getSystemService("connectivity");
        } catch (java.lang.Throwable unused) {
        }
    }

    public static cn.fly.verify.au a(android.content.Context context) {
        if (c == null) {
            synchronized (cn.fly.verify.au.class) {
                if (c == null) {
                    c = new cn.fly.verify.au(context);
                }
            }
        }
        return c;
    }

    public void a() {
        try {
            if (a != null && this.d != null) {
                this.b = null;
                a.unregisterNetworkCallback(this.d);
            }
            cn.fly.verify.aj.b();
            cn.fly.verify.f.a().b("[FlyVerify] ==>%s", "release cell");
        } catch (java.lang.Throwable unused) {
        }
    }
}
