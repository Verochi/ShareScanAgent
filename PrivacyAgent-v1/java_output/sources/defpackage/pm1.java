package defpackage;

/* loaded from: classes19.dex */
public final /* synthetic */ class pm1 implements com.moji.webview.bridge.BridgeHandler {
    public final /* synthetic */ com.moji.webview.jsfunction.MojiJsSdk a;
    public final /* synthetic */ com.moji.http.h5.JsPermissionReturnData b;
    public final /* synthetic */ org.json.JSONObject c;
    public final /* synthetic */ java.util.List d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ com.moji.http.h5.JsPermissionReturnData.JsPermissionData f;

    public /* synthetic */ pm1(com.moji.webview.jsfunction.MojiJsSdk mojiJsSdk, com.moji.http.h5.JsPermissionReturnData jsPermissionReturnData, org.json.JSONObject jSONObject, java.util.List list, boolean z, com.moji.http.h5.JsPermissionReturnData.JsPermissionData jsPermissionData) {
        this.a = mojiJsSdk;
        this.b = jsPermissionReturnData;
        this.c = jSONObject;
        this.d = list;
        this.e = z;
        this.f = jsPermissionData;
    }

    public final void handler(java.lang.String str, com.moji.webview.bridge.CallBackFunction callBackFunction) {
        com.moji.webview.jsfunction.MojiJsSdk.x(this.a, this.b, this.c, this.d, this.e, this.f, str, callBackFunction);
    }
}
