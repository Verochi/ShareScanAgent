package com.baidu.mobads.sdk.api;

/* loaded from: classes.dex */
public class BDRefinedActButton extends android.widget.LinearLayout {
    private android.view.View mAdView;
    private android.content.Context mContext;
    private java.lang.ClassLoader mLoader;

    public BDRefinedActButton(android.content.Context context) {
        this(context, null, 0);
    }

    public BDRefinedActButton(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BDRefinedActButton(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView(context);
    }

    private void initView(android.content.Context context) {
        try {
            this.mContext = context;
            java.lang.Object[] objArr = {context};
            java.lang.ClassLoader a = com.baidu.mobads.sdk.internal.bs.a(context);
            this.mLoader = a;
            android.view.View view = (android.view.View) com.baidu.mobads.sdk.internal.au.a(com.baidu.mobads.sdk.internal.z.h, a, (java.lang.Class<?>[]) new java.lang.Class[]{android.content.Context.class}, objArr);
            this.mAdView = view;
            if (view != null) {
                addView(view, new android.widget.RelativeLayout.LayoutParams(-2, -2));
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public void setAdData(com.baidu.mobads.sdk.api.NativeResponse nativeResponse) {
        android.view.View view = this.mAdView;
        if (view != null) {
            com.baidu.mobads.sdk.internal.au.a(com.baidu.mobads.sdk.internal.z.h, view, this.mLoader, "setAdData", new java.lang.Class[]{java.lang.Object.class}, nativeResponse);
        }
    }

    public void setButtonBackgroundColor(int i) {
        android.view.View view = this.mAdView;
        if (view != null) {
            com.baidu.mobads.sdk.internal.au.a(com.baidu.mobads.sdk.internal.z.h, view, this.mLoader, "setButtonBackgroundColor", new java.lang.Class[]{java.lang.Integer.TYPE}, java.lang.Integer.valueOf(i));
        }
    }

    public void setButtonFontSizeSp(int i) {
        android.view.View view = this.mAdView;
        if (view != null) {
            com.baidu.mobads.sdk.internal.au.a(com.baidu.mobads.sdk.internal.z.h, view, this.mLoader, "setButtonFontSizeSp", new java.lang.Class[]{java.lang.Integer.TYPE}, java.lang.Integer.valueOf(i));
        }
    }

    public void setButtonFontTypeFace(android.graphics.Typeface typeface) {
        android.view.View view = this.mAdView;
        if (view != null) {
            com.baidu.mobads.sdk.internal.au.a(com.baidu.mobads.sdk.internal.z.h, view, this.mLoader, "setButtonFontTypeFace", new java.lang.Class[]{android.graphics.Typeface.class}, typeface);
        }
    }

    public void setButtonTextColor(int i) {
        android.view.View view = this.mAdView;
        if (view != null) {
            com.baidu.mobads.sdk.internal.au.a(com.baidu.mobads.sdk.internal.z.h, view, this.mLoader, "setButtonTextColor", new java.lang.Class[]{java.lang.Integer.TYPE}, java.lang.Integer.valueOf(i));
        }
    }

    public void setIsShowDialog(boolean z) {
        android.view.View view = this.mAdView;
        if (view != null) {
            com.baidu.mobads.sdk.internal.au.a(com.baidu.mobads.sdk.internal.z.h, view, this.mLoader, "setIsShowDialog", new java.lang.Class[]{java.lang.Boolean.TYPE}, java.lang.Boolean.valueOf(z));
        }
    }
}
