package defpackage;

/* loaded from: classes.dex */
public final /* synthetic */ class tu1 implements java.lang.Runnable {
    public final /* synthetic */ com.alimm.tanx.core.net.callback.NetWorkCallBack n;
    public final /* synthetic */ java.lang.Object t;
    public final /* synthetic */ java.lang.String u;

    public /* synthetic */ tu1(com.alimm.tanx.core.net.callback.NetWorkCallBack netWorkCallBack, java.lang.Object obj, java.lang.String str) {
        this.n = netWorkCallBack;
        this.t = obj;
        this.u = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.alimm.tanx.core.net.okhttp.OkHttpNetWorkImpl.lambda$succCallBack$13(this.n, this.t, this.u);
    }
}
