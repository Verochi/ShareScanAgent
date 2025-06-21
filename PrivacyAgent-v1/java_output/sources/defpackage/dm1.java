package defpackage;

/* loaded from: classes19.dex */
public final /* synthetic */ class dm1 implements com.moji.webview.bridge.BridgeHandler {
    public final /* synthetic */ com.moji.webview.jsfunction.MojiJsSdk a;
    public final /* synthetic */ java.util.List b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ java.lang.String d;
    public final /* synthetic */ org.json.JSONObject e;

    public /* synthetic */ dm1(com.moji.webview.jsfunction.MojiJsSdk mojiJsSdk, java.util.List list, boolean z, java.lang.String str, org.json.JSONObject jSONObject) {
        this.a = mojiJsSdk;
        this.b = list;
        this.c = z;
        this.d = str;
        this.e = jSONObject;
    }

    public final void handler(java.lang.String str, com.moji.webview.bridge.CallBackFunction callBackFunction) {
        com.moji.webview.jsfunction.MojiJsSdk.J(this.a, this.b, this.c, this.d, this.e, str, callBackFunction);
    }
}
