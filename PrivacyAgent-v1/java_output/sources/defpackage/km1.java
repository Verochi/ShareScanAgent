package defpackage;

/* loaded from: classes19.dex */
public final /* synthetic */ class km1 implements com.moji.webview.bridge.BridgeHandler {
    public final /* synthetic */ com.moji.webview.jsfunction.MojiJsSdk a;

    public /* synthetic */ km1(com.moji.webview.jsfunction.MojiJsSdk mojiJsSdk) {
        this.a = mojiJsSdk;
    }

    public final void handler(java.lang.String str, com.moji.webview.bridge.CallBackFunction callBackFunction) {
        com.moji.webview.jsfunction.MojiJsSdk.r(this.a, str, callBackFunction);
    }
}
