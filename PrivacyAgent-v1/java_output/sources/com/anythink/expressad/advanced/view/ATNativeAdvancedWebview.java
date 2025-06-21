package com.anythink.expressad.advanced.view;

/* loaded from: classes12.dex */
public class ATNativeAdvancedWebview extends com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView {
    private static final java.lang.String a = "ATNativeAdvancedWebview";
    private com.anythink.expressad.advanced.a.c b;

    public ATNativeAdvancedWebview(android.content.Context context) {
        super(context);
        setBackgroundColor(0);
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        registerNetWorkReceiver();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        unregisterNetWorkReceiver();
    }

    public void registerNetWorkReceiver() {
        try {
            if (this.b == null) {
                this.b = new com.anythink.expressad.advanced.a.c(this);
            }
            android.content.IntentFilter intentFilter = new android.content.IntentFilter();
            intentFilter.addAction(com.igexin.sdk.PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
            getContext().registerReceiver(this.b, intentFilter);
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    public void unregisterNetWorkReceiver() {
        try {
            com.anythink.expressad.advanced.a.c cVar = this.b;
            if (cVar != null) {
                cVar.a();
                getContext().unregisterReceiver(this.b);
            }
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }
}
