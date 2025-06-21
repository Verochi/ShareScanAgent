package com.baidu.mobads.sdk.api;

@java.lang.Deprecated
/* loaded from: classes.dex */
public class FeedNativeView extends android.widget.RelativeLayout {
    private android.view.View mAdView;
    private android.content.Context mContext;
    private java.lang.ClassLoader mLoader;

    public FeedNativeView(android.content.Context context) {
        super(context);
        init(context);
    }

    public FeedNativeView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public FeedNativeView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(android.content.Context context) {
        this.mContext = context;
        java.lang.Object[] objArr = {context};
        java.lang.ClassLoader a = com.baidu.mobads.sdk.internal.bs.a(context);
        this.mLoader = a;
        android.view.View view = (android.view.View) com.baidu.mobads.sdk.internal.au.a(com.baidu.mobads.sdk.internal.z.e, a, (java.lang.Class<?>[]) new java.lang.Class[]{android.content.Context.class}, objArr);
        this.mAdView = view;
        if (view != null) {
            addView(view, new android.widget.RelativeLayout.LayoutParams(-2, -2));
        }
    }

    public void changeViewLayoutParams(java.lang.Object obj) {
        android.view.View view = this.mAdView;
        if (view != null) {
            com.baidu.mobads.sdk.internal.au.a(com.baidu.mobads.sdk.internal.z.e, view, this.mLoader, "changeLayoutParams", new java.lang.Class[]{java.lang.Object.class}, obj);
        }
    }

    public int getAdContainerHeight() {
        android.view.View view = this.mAdView;
        if (view != null) {
            java.lang.Object a = com.baidu.mobads.sdk.internal.au.a(com.baidu.mobads.sdk.internal.z.e, view, this.mLoader, "getAdContainerHeight", new java.lang.Class[0], new java.lang.Object[0]);
            if (a instanceof java.lang.Number) {
                return ((java.lang.Integer) a).intValue();
            }
        }
        return 0;
    }

    public int getAdContainerWidth() {
        android.view.View view = this.mAdView;
        if (view != null) {
            java.lang.Object a = com.baidu.mobads.sdk.internal.au.a(com.baidu.mobads.sdk.internal.z.e, view, this.mLoader, "getAdContainerWidth", new java.lang.Class[0], new java.lang.Object[0]);
            if (a instanceof java.lang.Number) {
                return ((java.lang.Integer) a).intValue();
            }
        }
        return 0;
    }

    public android.widget.RelativeLayout getContainerView() {
        android.view.View view = this.mAdView;
        if (view != null) {
            return (android.widget.RelativeLayout) com.baidu.mobads.sdk.internal.au.a(com.baidu.mobads.sdk.internal.z.e, view, this.mLoader, "getAdView", new java.lang.Class[0], new java.lang.Object[0]);
        }
        return null;
    }

    public void setAdData(com.baidu.mobads.sdk.api.XAdNativeResponse xAdNativeResponse) {
        android.view.View view = this.mAdView;
        if (view != null) {
            com.baidu.mobads.sdk.internal.au.a(com.baidu.mobads.sdk.internal.z.e, view, this.mLoader, "setAdResponse", new java.lang.Class[]{java.lang.Object.class}, xAdNativeResponse);
        }
    }
}
