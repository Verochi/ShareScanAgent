package defpackage;

/* loaded from: classes19.dex */
public final /* synthetic */ class rm1 implements com.moji.webview.bridge.BridgeHandler {
    public final /* synthetic */ com.moji.webview.jsfunction.MojiJsSdk a;
    public final /* synthetic */ java.util.List b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ org.json.JSONObject d;

    public /* synthetic */ rm1(com.moji.webview.jsfunction.MojiJsSdk mojiJsSdk, java.util.List list, boolean z, org.json.JSONObject jSONObject) {
        this.a = mojiJsSdk;
        this.b = list;
        this.c = z;
        this.d = jSONObject;
    }

    public final void handler(java.lang.String str, com.moji.webview.bridge.CallBackFunction callBackFunction) {
        com.moji.webview.jsfunction.MojiJsSdk.D(this.a, this.b, this.c, this.d, str, callBackFunction);
    }
}
