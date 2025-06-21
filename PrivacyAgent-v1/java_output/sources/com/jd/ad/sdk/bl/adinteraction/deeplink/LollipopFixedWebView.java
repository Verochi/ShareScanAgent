package com.jd.ad.sdk.bl.adinteraction.deeplink;

/* loaded from: classes23.dex */
public class LollipopFixedWebView extends android.webkit.WebView {
    public LollipopFixedWebView(android.content.Context context) {
        super(jad_an(context));
    }

    public LollipopFixedWebView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(jad_an(context), attributeSet);
    }

    public LollipopFixedWebView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(jad_an(context), attributeSet, i);
    }

    @android.annotation.TargetApi(21)
    public LollipopFixedWebView(android.content.Context context, android.util.AttributeSet attributeSet, int i, int i2) {
        super(jad_an(context), attributeSet, i, i2);
    }

    public LollipopFixedWebView(android.content.Context context, android.util.AttributeSet attributeSet, int i, boolean z) {
        super(jad_an(context), attributeSet, i, z);
    }

    public static android.content.Context jad_an(android.content.Context context) {
        return android.os.Build.VERSION.SDK_INT < 23 ? context.createConfigurationContext(new android.content.res.Configuration()) : context;
    }
}
