package com.baidu.mobads.sdk.api;

/* loaded from: classes.dex */
public class BDMarketingLabel extends android.widget.LinearLayout {
    private android.view.View mAdView;
    private android.content.Context mContext;
    private java.lang.ClassLoader mLoader;

    public BDMarketingLabel(android.content.Context context) {
        super(context);
        this.mContext = context;
        initView(context);
    }

    public BDMarketingLabel(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BDMarketingLabel(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView(context);
    }

    private void initView(android.content.Context context) {
        this.mContext = context;
        java.lang.Object[] objArr = {context};
        java.lang.ClassLoader a = com.baidu.mobads.sdk.internal.bs.a(context);
        this.mLoader = a;
        android.view.View view = (android.view.View) com.baidu.mobads.sdk.internal.au.a(com.baidu.mobads.sdk.internal.z.g, a, (java.lang.Class<?>[]) new java.lang.Class[]{android.content.Context.class}, objArr);
        this.mAdView = view;
        if (view != null) {
            addView(view, new android.widget.RelativeLayout.LayoutParams(-2, -2));
        }
    }

    public void setAdData(com.baidu.mobads.sdk.api.NativeResponse nativeResponse) {
        android.view.View view = this.mAdView;
        if (view != null) {
            com.baidu.mobads.sdk.internal.au.a(com.baidu.mobads.sdk.internal.z.g, view, this.mLoader, "setAdData", new java.lang.Class[]{java.lang.Object.class}, nativeResponse);
        }
    }

    public void setLabelFontSizeSp(int i) {
        android.view.View view = this.mAdView;
        if (view != null) {
            com.baidu.mobads.sdk.internal.au.a(com.baidu.mobads.sdk.internal.z.g, view, this.mLoader, "setLabelFontSizeSp", new java.lang.Class[]{java.lang.Integer.TYPE}, java.lang.Integer.valueOf(i));
        }
    }

    public void setLabelFontTypeFace(android.graphics.Typeface typeface) {
        android.view.View view = this.mAdView;
        if (view != null) {
            com.baidu.mobads.sdk.internal.au.a(com.baidu.mobads.sdk.internal.z.g, view, this.mLoader, "setLabelFontTypeFace", new java.lang.Class[]{android.graphics.Typeface.class}, typeface);
        }
    }
}
