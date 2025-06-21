package defpackage;

/* loaded from: classes19.dex */
public final /* synthetic */ class wm1 implements com.moji.auth.api.AlipayAuthListener {
    public final /* synthetic */ com.moji.webview.jsfunction.MojiJsSdk a;
    public final /* synthetic */ com.moji.webview.bridge.CallBackFunction b;

    public /* synthetic */ wm1(com.moji.webview.jsfunction.MojiJsSdk mojiJsSdk, com.moji.webview.bridge.CallBackFunction callBackFunction) {
        this.a = mojiJsSdk;
        this.b = callBackFunction;
    }

    public final void onAuthResult(java.util.Map map) {
        com.moji.webview.jsfunction.MojiJsSdk.s(this.a, this.b, map);
    }
}
