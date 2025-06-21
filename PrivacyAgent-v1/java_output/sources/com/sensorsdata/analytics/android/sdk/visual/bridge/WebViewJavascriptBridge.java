package com.sensorsdata.analytics.android.sdk.visual.bridge;

/* loaded from: classes19.dex */
public interface WebViewJavascriptBridge {
    void sendToWeb(android.view.View view, java.lang.String str, java.lang.Object obj);

    void sendToWeb(android.view.View view, java.lang.String str, java.lang.Object obj, com.sensorsdata.analytics.android.sdk.visual.bridge.OnBridgeCallback onBridgeCallback);
}
