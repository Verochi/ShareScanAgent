package cn.fly.verify;

/* loaded from: classes.dex */
public class ap {
    public static void a() {
        int i;
        if (cn.fly.verify.as.d(cn.fly.verify.ax.g()) && cn.fly.verify.as.b(cn.fly.verify.ax.g()) && cn.fly.verify.fh.d.l().equalsIgnoreCase(cn.fly.verify.as.b("4F50706F")) && (i = android.os.Build.VERSION.SDK_INT) >= 23 && i <= 28 && cn.fly.verify.ai.a().h() == 0 && !cn.fly.verify.aq.i()) {
            try {
                a(cn.fly.verify.ax.g().getApplicationContext());
                cn.fly.verify.f.a().b("[FlyVerify] ==>%s", "oppo reconnect");
            } catch (java.lang.Exception e) {
                cn.fly.verify.f.a().c(e);
            }
        }
    }

    public static void a(android.content.Context context) {
        android.net.wifi.WifiManager wifiManager;
        if (context == null || (wifiManager = (android.net.wifi.WifiManager) cn.fly.verify.fh.d.a(com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI)) == null) {
            return;
        }
        int networkId = wifiManager.getConnectionInfo().getNetworkId();
        wifiManager.disableNetwork(networkId);
        wifiManager.disconnect();
        try {
            java.lang.Thread.sleep(500L);
        } catch (java.lang.InterruptedException e) {
            cn.fly.verify.f.a().b("[FlyVerify] ==>%s", "reconnect wifi interrupted " + e.getMessage());
        }
        wifiManager.enableNetwork(networkId, true);
        wifiManager.reconnect();
    }
}
