package com.baidu.mobads.sdk.internal.widget;

/* loaded from: classes.dex */
final class PageTransformerAdapter extends com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback {
    private final androidx.recyclerview.widget.LinearLayoutManager a;
    private com.baidu.mobads.sdk.internal.widget.ViewPager2.PageTransformer b;

    public PageTransformerAdapter(androidx.recyclerview.widget.LinearLayoutManager linearLayoutManager) {
        this.a = linearLayoutManager;
    }

    public com.baidu.mobads.sdk.internal.widget.ViewPager2.PageTransformer a() {
        return this.b;
    }

    public void a(@androidx.annotation.Nullable com.baidu.mobads.sdk.internal.widget.ViewPager2.PageTransformer pageTransformer) {
        this.b = pageTransformer;
    }

    @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrollStateChanged(int i) {
    }

    @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrolled(int i, float f, int i2) {
        if (this.b == null) {
            return;
        }
        float f2 = -f;
        for (int i3 = 0; i3 < this.a.getChildCount(); i3++) {
            android.view.View childAt = this.a.getChildAt(i3);
            if (childAt == null) {
                throw new java.lang.IllegalStateException(java.lang.String.format(java.util.Locale.US, "LayoutManager returned a null child at pos %d/%d while transforming pages", java.lang.Integer.valueOf(i3), java.lang.Integer.valueOf(this.a.getChildCount())));
            }
            this.b.transformPage(childAt, (this.a.getPosition(childAt) - i) + f2);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
    public void onPageSelected(int i) {
    }
}
