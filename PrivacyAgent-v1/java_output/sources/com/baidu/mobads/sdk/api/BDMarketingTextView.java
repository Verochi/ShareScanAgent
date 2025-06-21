package com.baidu.mobads.sdk.api;

/* loaded from: classes.dex */
public class BDMarketingTextView extends android.widget.RelativeLayout {
    private android.view.View mAdView;
    private android.content.Context mContext;
    private java.lang.ClassLoader mLoader;

    public BDMarketingTextView(android.content.Context context) {
        super(context);
        this.mContext = context;
        initView(context);
    }

    public BDMarketingTextView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BDMarketingTextView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView(context);
    }

    private void initView(android.content.Context context) {
        try {
            this.mContext = context;
            java.lang.Object[] objArr = {context};
            java.lang.ClassLoader a = com.baidu.mobads.sdk.internal.bs.a(context);
            this.mLoader = a;
            android.view.View view = (android.view.View) com.baidu.mobads.sdk.internal.au.a(com.baidu.mobads.sdk.internal.z.f, a, (java.lang.Class<?>[]) new java.lang.Class[]{android.content.Context.class}, objArr);
            this.mAdView = view;
            if (view != null) {
                addView(view, new android.widget.RelativeLayout.LayoutParams(-2, -2));
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public void setAdData(com.baidu.mobads.sdk.api.NativeResponse nativeResponse, java.lang.String str) {
        android.view.View view = this.mAdView;
        if (view != null) {
            com.baidu.mobads.sdk.internal.au.a(com.baidu.mobads.sdk.internal.z.f, view, this.mLoader, "setAdData", new java.lang.Class[]{java.lang.Object.class, java.lang.String.class}, nativeResponse, str);
        }
    }

    public void setEllipsize(android.text.TextUtils.TruncateAt truncateAt) {
        android.view.View view = this.mAdView;
        if (view != null) {
            com.baidu.mobads.sdk.internal.au.a(com.baidu.mobads.sdk.internal.z.f, view, this.mLoader, "setEllipsize", new java.lang.Class[]{android.text.TextUtils.TruncateAt.class}, truncateAt);
        }
    }

    public void setLabelFontSizeSp(int i) {
        android.view.View view = this.mAdView;
        if (view != null) {
            com.baidu.mobads.sdk.internal.au.a(com.baidu.mobads.sdk.internal.z.f, view, this.mLoader, "setLabelFontSizeSp", new java.lang.Class[]{java.lang.Integer.TYPE}, java.lang.Integer.valueOf(i));
        }
    }

    public void setLabelFontTypeFace(android.graphics.Typeface typeface) {
        android.view.View view = this.mAdView;
        if (view != null) {
            com.baidu.mobads.sdk.internal.au.a(com.baidu.mobads.sdk.internal.z.f, view, this.mLoader, "setLabelFontTypeFace", new java.lang.Class[]{android.graphics.Typeface.class}, typeface);
        }
    }

    public void setLabelVisibility(int i) {
        android.view.View view = this.mAdView;
        if (view != null) {
            com.baidu.mobads.sdk.internal.au.a(com.baidu.mobads.sdk.internal.z.f, view, this.mLoader, "setLabelVisibility", new java.lang.Class[]{java.lang.Integer.TYPE}, java.lang.Integer.valueOf(i));
        }
    }

    public void setLineSpacingExtra(int i) {
        android.view.View view = this.mAdView;
        if (view != null) {
            com.baidu.mobads.sdk.internal.au.a(com.baidu.mobads.sdk.internal.z.f, view, this.mLoader, "setLineSpacingExtra", new java.lang.Class[]{java.lang.Integer.TYPE}, java.lang.Integer.valueOf(i));
        }
    }

    public void setTextFontColor(int i) {
        android.view.View view = this.mAdView;
        if (view != null) {
            com.baidu.mobads.sdk.internal.au.a(com.baidu.mobads.sdk.internal.z.f, view, this.mLoader, "setTextFontColor", new java.lang.Class[]{java.lang.Integer.TYPE}, java.lang.Integer.valueOf(i));
        }
    }

    public void setTextFontSizeSp(int i) {
        android.view.View view = this.mAdView;
        if (view != null) {
            com.baidu.mobads.sdk.internal.au.a(com.baidu.mobads.sdk.internal.z.f, view, this.mLoader, "setTextFontSizeSp", new java.lang.Class[]{java.lang.Integer.TYPE}, java.lang.Integer.valueOf(i));
        }
    }

    public void setTextFontTypeFace(android.graphics.Typeface typeface) {
        android.view.View view = this.mAdView;
        if (view != null) {
            com.baidu.mobads.sdk.internal.au.a(com.baidu.mobads.sdk.internal.z.f, view, this.mLoader, "setTextFontTypeFace", new java.lang.Class[]{android.graphics.Typeface.class}, typeface);
        }
    }

    public void setTextMaxLines(int i) {
        android.view.View view = this.mAdView;
        if (view != null) {
            com.baidu.mobads.sdk.internal.au.a(com.baidu.mobads.sdk.internal.z.f, view, this.mLoader, "setTextMaxLines", new java.lang.Class[]{java.lang.Integer.TYPE}, java.lang.Integer.valueOf(i));
        }
    }
}
