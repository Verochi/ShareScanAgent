package cn.shuzilm.core;

/* loaded from: classes.dex */
class g extends android.net.ConnectivityManager.NetworkCallback {
    final /* synthetic */ android.content.Context a;

    public g(android.content.Context context) {
        this.a = context;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onAvailable(android.net.Network network) {
        super.onAvailable(network);
        try {
            cn.shuzilm.core.DUHelper.oxlbmV0d(this.a, network, 1);
        } catch (java.lang.Throwable unused) {
        }
    }
}
