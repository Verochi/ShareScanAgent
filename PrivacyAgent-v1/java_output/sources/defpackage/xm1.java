package defpackage;

/* loaded from: classes19.dex */
public final /* synthetic */ class xm1 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.webview.bridge.CallBackFunction n;
    public final /* synthetic */ java.util.Map t;

    public /* synthetic */ xm1(com.moji.webview.bridge.CallBackFunction callBackFunction, java.util.Map map) {
        this.n = callBackFunction;
        this.t = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.webview.jsfunction.MojiJsSdk.v(this.n, this.t);
    }
}
