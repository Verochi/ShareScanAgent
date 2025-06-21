package com.baidu.mobads.sdk.internal.widget;

/* loaded from: classes.dex */
final class CompositeOnPageChangeCallback extends com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback {

    @androidx.annotation.NonNull
    private final java.util.List<com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback> a;

    public CompositeOnPageChangeCallback(int i) {
        this.a = new java.util.ArrayList(i);
    }

    private void a(java.util.ConcurrentModificationException concurrentModificationException) {
        throw new java.lang.IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", concurrentModificationException);
    }

    public void a(com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.a.add(onPageChangeCallback);
    }

    public void b(com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.a.remove(onPageChangeCallback);
    }

    @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrollStateChanged(int i) {
        try {
            java.util.Iterator<com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().onPageScrollStateChanged(i);
            }
        } catch (java.util.ConcurrentModificationException e) {
            a(e);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrolled(int i, float f, @androidx.annotation.Px int i2) {
        try {
            java.util.Iterator<com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().onPageScrolled(i, f, i2);
            }
        } catch (java.util.ConcurrentModificationException e) {
            a(e);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
    public void onPageSelected(int i) {
        try {
            java.util.Iterator<com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().onPageSelected(i);
            }
        } catch (java.util.ConcurrentModificationException e) {
            a(e);
        }
    }
}
