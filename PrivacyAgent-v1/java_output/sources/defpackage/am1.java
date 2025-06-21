package defpackage;

/* loaded from: classes19.dex */
public final /* synthetic */ class am1 implements com.moji.webview.bridge.BridgeHandler {
    public final /* synthetic */ com.moji.webview.jsfunction.MojiJsSdk a;

    public /* synthetic */ am1(com.moji.webview.jsfunction.MojiJsSdk mojiJsSdk) {
        this.a = mojiJsSdk;
    }

    public final void handler(java.lang.String str, com.moji.webview.bridge.CallBackFunction callBackFunction) {
        com.moji.webview.jsfunction.MojiJsSdk.I(this.a, str, callBackFunction);
    }
}
