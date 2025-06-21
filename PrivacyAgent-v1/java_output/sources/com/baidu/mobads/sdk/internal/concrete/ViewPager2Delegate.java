package com.baidu.mobads.sdk.internal.concrete;

@android.annotation.SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
public class ViewPager2Delegate extends com.baidu.mobads.sdk.internal.widget.ViewPager2 implements com.baidu.mobads.sdk.internal.a.a {
    private static final java.lang.String m = "getScrollState";
    private static final java.lang.String n = "getCurrentItem";
    private static final java.lang.String o = "setCurrentItem";
    private static final java.lang.String p = "setOrientation";
    private static final java.lang.String q = "setAdapter";
    private static final java.lang.String r = "setOffscreenPageLimit";

    /* renamed from: s, reason: collision with root package name */
    private static final java.lang.String f298s = "setUserInputEnabled";
    private final com.baidu.mobads.sdk.internal.a.c t;

    /* renamed from: com.baidu.mobads.sdk.internal.concrete.ViewPager2Delegate$1, reason: invalid class name */
    class AnonymousClass1 implements com.baidu.mobads.sdk.internal.widget.ViewPager2.OnOverScrollListener {
        public AnonymousClass1() {
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnOverScrollListener
        public void onOverScrollEnd() {
            com.baidu.mobads.sdk.internal.concrete.ViewPager2Delegate.this.t.a("onOverScrollEnd");
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnOverScrollListener
        public void onOverScrollStart() {
            com.baidu.mobads.sdk.internal.concrete.ViewPager2Delegate.this.t.a("onOverScrollStart");
        }
    }

    /* renamed from: com.baidu.mobads.sdk.internal.concrete.ViewPager2Delegate$2, reason: invalid class name */
    class AnonymousClass2 extends com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback {
        public AnonymousClass2() {
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i) {
            com.baidu.mobads.sdk.internal.concrete.ViewPager2Delegate.this.t.a("onPageScrollStateChanged", java.lang.Integer.valueOf(i));
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i, float f, int i2) {
            com.baidu.mobads.sdk.internal.concrete.ViewPager2Delegate.this.t.a("onPageScrolled", java.lang.Integer.valueOf(i), java.lang.Float.valueOf(f), java.lang.Integer.valueOf(i2));
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i) {
            com.baidu.mobads.sdk.internal.concrete.ViewPager2Delegate.this.t.a("onPageSelected", java.lang.Integer.valueOf(i));
        }
    }

    public ViewPager2Delegate(com.baidu.mobads.sdk.api.IAdInterListener iAdInterListener, android.content.Context context) {
        super(context);
        this.t = com.baidu.mobads.sdk.internal.a.c.a(iAdInterListener, this);
        setOnOverScrollListener(new com.baidu.mobads.sdk.internal.concrete.ViewPager2Delegate.AnonymousClass1());
        registerOnPageChangeCallback(new com.baidu.mobads.sdk.internal.concrete.ViewPager2Delegate.AnonymousClass2());
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public int getCode() {
        return this.t.getCode();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public java.util.Map<java.lang.String, java.lang.Object> getData() {
        return this.t.getData();
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    @androidx.annotation.NonNull
    public com.baidu.mobads.sdk.api.IAdInterListener getDelegator() {
        return this.t.getDelegator();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public java.lang.String getMessage() {
        return this.t.getMessage();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public java.lang.Object getTarget() {
        return this.t.getTarget();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public java.lang.String getType() {
        return this.t.getType();
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    public java.lang.Object handleEvent(java.lang.String str, java.lang.String str2, java.lang.Object[] objArr) {
        if (m.equals(str2)) {
            return java.lang.Integer.valueOf(getScrollState());
        }
        if (n.equals(str2)) {
            return java.lang.Integer.valueOf(getCurrentItem());
        }
        if (o.equals(str2) && com.baidu.mobads.sdk.internal.a.c.a(objArr, (java.lang.Class<?>[]) new java.lang.Class[]{java.lang.Integer.class})) {
            setCurrentItem(((java.lang.Integer) objArr[0]).intValue());
            return null;
        }
        if (p.equals(str2) && com.baidu.mobads.sdk.internal.a.c.a(objArr, (java.lang.Class<?>[]) new java.lang.Class[]{java.lang.Integer.class})) {
            setOrientation(((java.lang.Integer) objArr[0]).intValue());
            return null;
        }
        if (q.equals(str2) && com.baidu.mobads.sdk.internal.a.c.a(objArr, (java.lang.Class<?>[]) new java.lang.Class[]{androidx.recyclerview.widget.RecyclerView.Adapter.class})) {
            setAdapter((androidx.recyclerview.widget.RecyclerView.Adapter) objArr[0]);
            return null;
        }
        if (r.equals(str2) && com.baidu.mobads.sdk.internal.a.c.a(objArr, (java.lang.Class<?>[]) new java.lang.Class[]{java.lang.Integer.class})) {
            setOffscreenPageLimit(((java.lang.Integer) objArr[0]).intValue());
            return null;
        }
        if (!f298s.equals(str2) || !com.baidu.mobads.sdk.internal.a.c.a(objArr, (java.lang.Class<?>[]) new java.lang.Class[]{java.lang.Boolean.class})) {
            return null;
        }
        setUserInputEnabled(((java.lang.Boolean) objArr[0]).booleanValue());
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public void setTarget(java.lang.Object obj) {
        this.t.setTarget(obj);
    }
}
