package com.baidu.mobads.sdk.internal.widget;

/* loaded from: classes.dex */
final class ScrollEventAdapter extends androidx.recyclerview.widget.RecyclerView.OnScrollListener {
    private static final int a = 0;
    private static final int b = 1;
    private static final int c = 2;
    private static final int d = 3;
    private static final int e = 4;
    private static final int f = -1;
    private com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback g;

    @androidx.annotation.NonNull
    private final com.baidu.mobads.sdk.internal.widget.ViewPager2 h;

    @androidx.annotation.NonNull
    private final androidx.recyclerview.widget.RecyclerView i;

    @androidx.annotation.NonNull
    private final androidx.recyclerview.widget.LinearLayoutManager j;
    private int k;
    private int l;
    private com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter.ScrollEventValues m;
    private int n;
    private int o;
    private boolean p;
    private boolean q;
    private boolean r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f299s;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface AdapterState {
    }

    public static final class ScrollEventValues {
        int a;
        float b;
        int c;

        public void a() {
            this.a = -1;
            this.b = 0.0f;
            this.c = 0;
        }
    }

    public ScrollEventAdapter(@androidx.annotation.NonNull com.baidu.mobads.sdk.internal.widget.ViewPager2 viewPager2) {
        this.h = viewPager2;
        androidx.recyclerview.widget.RecyclerView recyclerView = viewPager2.j;
        this.i = recyclerView;
        this.j = (androidx.recyclerview.widget.LinearLayoutManager) recyclerView.getLayoutManager();
        this.m = new com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter.ScrollEventValues();
        i();
    }

    private void a(int i) {
        if ((this.k == 3 && this.l == 0) || this.l == i) {
            return;
        }
        this.l = i;
        com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback onPageChangeCallback = this.g;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.onPageScrollStateChanged(i);
        }
    }

    private void a(int i, float f2, int i2) {
        com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback onPageChangeCallback = this.g;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.onPageScrolled(i, f2, i2);
        }
    }

    private void a(boolean z) {
        this.f299s = z;
        this.k = z ? 4 : 1;
        int i = this.o;
        if (i != -1) {
            this.n = i;
            this.o = -1;
        } else if (this.n == -1) {
            this.n = l();
        }
        a(1);
    }

    private void b(int i) {
        com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback onPageChangeCallback = this.g;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.onPageSelected(i);
        }
    }

    private void i() {
        this.k = 0;
        this.l = 0;
        this.m.a();
        this.n = -1;
        this.o = -1;
        this.p = false;
        this.q = false;
        this.f299s = false;
        this.r = false;
    }

    private void j() {
        int top;
        com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter.ScrollEventValues scrollEventValues = this.m;
        int findFirstVisibleItemPosition = this.j.findFirstVisibleItemPosition();
        scrollEventValues.a = findFirstVisibleItemPosition;
        if (findFirstVisibleItemPosition == -1) {
            scrollEventValues.a();
            return;
        }
        android.view.View findViewByPosition = this.j.findViewByPosition(findFirstVisibleItemPosition);
        if (findViewByPosition == null) {
            scrollEventValues.a();
            return;
        }
        int leftDecorationWidth = this.j.getLeftDecorationWidth(findViewByPosition);
        int rightDecorationWidth = this.j.getRightDecorationWidth(findViewByPosition);
        int topDecorationHeight = this.j.getTopDecorationHeight(findViewByPosition);
        int bottomDecorationHeight = this.j.getBottomDecorationHeight(findViewByPosition);
        android.view.ViewGroup.LayoutParams layoutParams = findViewByPosition.getLayoutParams();
        if (layoutParams instanceof android.view.ViewGroup.MarginLayoutParams) {
            android.view.ViewGroup.MarginLayoutParams marginLayoutParams = (android.view.ViewGroup.MarginLayoutParams) layoutParams;
            leftDecorationWidth += marginLayoutParams.leftMargin;
            rightDecorationWidth += marginLayoutParams.rightMargin;
            topDecorationHeight += marginLayoutParams.topMargin;
            bottomDecorationHeight += marginLayoutParams.bottomMargin;
        }
        int height = findViewByPosition.getHeight() + topDecorationHeight + bottomDecorationHeight;
        int width = findViewByPosition.getWidth() + leftDecorationWidth + rightDecorationWidth;
        if (this.j.getOrientation() == 0) {
            top = (findViewByPosition.getLeft() - leftDecorationWidth) - this.i.getPaddingLeft();
            if (this.h.c()) {
                top = -top;
            }
            height = width;
        } else {
            top = (findViewByPosition.getTop() - topDecorationHeight) - this.i.getPaddingTop();
        }
        int i = -top;
        scrollEventValues.c = i;
        if (i >= 0) {
            scrollEventValues.b = height == 0 ? 0.0f : i / height;
        } else {
            if (!new com.baidu.mobads.sdk.internal.widget.AnimateLayoutChangeDetector(this.j).a()) {
                throw new java.lang.IllegalStateException(java.lang.String.format(java.util.Locale.US, "Page can only be offset by a positive amount, not by %d", java.lang.Integer.valueOf(scrollEventValues.c)));
            }
            throw new java.lang.IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
        }
    }

    private boolean k() {
        int i = this.k;
        return i == 1 || i == 4;
    }

    private int l() {
        return this.j.findFirstVisibleItemPosition();
    }

    public void a() {
        this.r = true;
    }

    public void a(int i, boolean z) {
        this.k = z ? 2 : 3;
        this.f299s = false;
        boolean z2 = this.o != i;
        this.o = i;
        a(2);
        if (z2) {
            b(i);
        }
    }

    public void a(com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.g = onPageChangeCallback;
    }

    public void b() {
        this.k = 4;
        a(true);
    }

    public void c() {
        if (!f() || this.f299s) {
            this.f299s = false;
            j();
            com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter.ScrollEventValues scrollEventValues = this.m;
            if (scrollEventValues.c != 0) {
                a(2);
                return;
            }
            int i = scrollEventValues.a;
            if (i != this.n) {
                b(i);
            }
            a(0);
            i();
        }
    }

    public int d() {
        return this.l;
    }

    public boolean e() {
        return this.l == 0;
    }

    public boolean f() {
        return this.l == 1;
    }

    public boolean g() {
        return this.f299s;
    }

    public double h() {
        j();
        com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter.ScrollEventValues scrollEventValues = this.m;
        return scrollEventValues.a + scrollEventValues.b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView, int i) {
        boolean z = true;
        if (!(this.k == 1 && this.l == 1) && i == 1) {
            a(false);
            return;
        }
        if (k() && i == 2) {
            if (this.q) {
                a(2);
                this.p = true;
                return;
            }
            return;
        }
        if (k() && i == 0) {
            j();
            if (this.q) {
                com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter.ScrollEventValues scrollEventValues = this.m;
                if (scrollEventValues.c == 0) {
                    int i2 = this.n;
                    int i3 = scrollEventValues.a;
                    if (i2 != i3) {
                        b(i3);
                    }
                } else {
                    z = false;
                }
            } else {
                int i4 = this.m.a;
                if (i4 != -1) {
                    a(i4, 0.0f, 0);
                }
            }
            if (z) {
                a(0);
                i();
            }
        }
        if (this.k == 2 && i == 0 && this.r) {
            j();
            com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter.ScrollEventValues scrollEventValues2 = this.m;
            if (scrollEventValues2.c == 0) {
                int i5 = this.o;
                int i6 = scrollEventValues2.a;
                if (i5 != i6) {
                    if (i6 == -1) {
                        i6 = 0;
                    }
                    b(i6);
                }
                a(0);
                i();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001d, code lost:
    
        if ((r5 < 0) == r3.h.c()) goto L14;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0039  */
    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onScrolled(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView, int i, int i2) {
        boolean z;
        int i3;
        this.q = true;
        j();
        if (this.p) {
            this.p = false;
            if (i2 <= 0) {
                if (i2 == 0) {
                }
                z = false;
                if (z) {
                    com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter.ScrollEventValues scrollEventValues = this.m;
                    if (scrollEventValues.c != 0) {
                        i3 = scrollEventValues.a + 1;
                        this.o = i3;
                        if (this.n != i3) {
                            b(i3);
                        }
                    }
                }
                i3 = this.m.a;
                this.o = i3;
                if (this.n != i3) {
                }
            }
            z = true;
            if (z) {
            }
            i3 = this.m.a;
            this.o = i3;
            if (this.n != i3) {
            }
        } else if (this.k == 0) {
            int i4 = this.m.a;
            if (i4 == -1) {
                i4 = 0;
            }
            b(i4);
        }
        com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter.ScrollEventValues scrollEventValues2 = this.m;
        int i5 = scrollEventValues2.a;
        if (i5 == -1) {
            i5 = 0;
        }
        a(i5, scrollEventValues2.b, scrollEventValues2.c);
        com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter.ScrollEventValues scrollEventValues3 = this.m;
        int i6 = scrollEventValues3.a;
        int i7 = this.o;
        if ((i6 == i7 || i7 == -1) && scrollEventValues3.c == 0 && this.l != 1) {
            a(0);
            i();
        }
    }
}
