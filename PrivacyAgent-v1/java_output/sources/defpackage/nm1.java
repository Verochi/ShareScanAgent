package defpackage;

/* loaded from: classes19.dex */
public final /* synthetic */ class nm1 implements com.moji.webview.bridge.BridgeHandler {
    public final /* synthetic */ com.moji.webview.jsfunction.MojiJsSdk a;
    public final /* synthetic */ java.util.ArrayList b;
    public final /* synthetic */ boolean c;

    public /* synthetic */ nm1(com.moji.webview.jsfunction.MojiJsSdk mojiJsSdk, java.util.ArrayList arrayList, boolean z) {
        this.a = mojiJsSdk;
        this.b = arrayList;
        this.c = z;
    }

    public final void handler(java.lang.String str, com.moji.webview.bridge.CallBackFunction callBackFunction) {
        com.moji.webview.jsfunction.MojiJsSdk.b(this.a, this.b, this.c, str, callBackFunction);
    }
}
