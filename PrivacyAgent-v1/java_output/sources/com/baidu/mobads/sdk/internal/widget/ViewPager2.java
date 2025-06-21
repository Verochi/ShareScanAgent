package com.baidu.mobads.sdk.internal.widget;

/* loaded from: classes.dex */
public class ViewPager2 extends android.view.ViewGroup {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 0;
    public static final int d = 1;
    public static final int e = 2;
    public static final int f = -1;
    static boolean g = true;
    private boolean A;
    private int B;
    int h;
    boolean i;
    androidx.recyclerview.widget.RecyclerView j;
    com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter k;
    com.baidu.mobads.sdk.internal.widget.ViewPager2.AccessibilityProvider l;
    private final android.graphics.Rect m;
    private final android.graphics.Rect n;
    private final int[] o;
    private com.baidu.mobads.sdk.internal.widget.CompositeOnPageChangeCallback p;
    private androidx.recyclerview.widget.RecyclerView.AdapterDataObserver q;
    private androidx.recyclerview.widget.LinearLayoutManager r;

    /* renamed from: s, reason: collision with root package name */
    private int f300s;
    private android.os.Parcelable t;
    private com.baidu.mobads.sdk.internal.widget.PagerSnapHelper u;
    private com.baidu.mobads.sdk.internal.widget.CompositeOnPageChangeCallback v;
    private com.baidu.mobads.sdk.internal.widget.FakeDrag w;
    private com.baidu.mobads.sdk.internal.widget.PageTransformerAdapter x;
    private androidx.recyclerview.widget.RecyclerView.ItemAnimator y;
    private boolean z;

    /* renamed from: com.baidu.mobads.sdk.internal.widget.ViewPager2$1, reason: invalid class name */
    class AnonymousClass1 extends com.baidu.mobads.sdk.internal.widget.ViewPager2.DataSetChangeObserver {
        public AnonymousClass1() {
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            com.baidu.mobads.sdk.internal.widget.ViewPager2 viewPager2 = com.baidu.mobads.sdk.internal.widget.ViewPager2.this;
            viewPager2.i = true;
            viewPager2.k.a();
        }
    }

    /* renamed from: com.baidu.mobads.sdk.internal.widget.ViewPager2$2, reason: invalid class name */
    class AnonymousClass2 extends com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback {
        public AnonymousClass2() {
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i) {
            if (i == 0) {
                com.baidu.mobads.sdk.internal.widget.ViewPager2.this.a();
            }
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i) {
            com.baidu.mobads.sdk.internal.widget.ViewPager2 viewPager2 = com.baidu.mobads.sdk.internal.widget.ViewPager2.this;
            if (viewPager2.h != i) {
                viewPager2.h = i;
                viewPager2.l.e();
            }
        }
    }

    /* renamed from: com.baidu.mobads.sdk.internal.widget.ViewPager2$3, reason: invalid class name */
    class AnonymousClass3 extends com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback {
        public AnonymousClass3() {
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i) {
            com.baidu.mobads.sdk.internal.widget.ViewPager2.this.clearFocus();
            if (com.baidu.mobads.sdk.internal.widget.ViewPager2.this.hasFocus()) {
                com.baidu.mobads.sdk.internal.widget.ViewPager2.this.j.requestFocus(2);
            }
        }
    }

    /* renamed from: com.baidu.mobads.sdk.internal.widget.ViewPager2$4, reason: invalid class name */
    class AnonymousClass4 implements androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener {
        public AnonymousClass4() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
        public void onChildViewAttachedToWindow(@androidx.annotation.NonNull android.view.View view) {
            androidx.recyclerview.widget.RecyclerView.LayoutParams layoutParams = (androidx.recyclerview.widget.RecyclerView.LayoutParams) view.getLayoutParams();
            if (((android.view.ViewGroup.MarginLayoutParams) layoutParams).width != -1 || ((android.view.ViewGroup.MarginLayoutParams) layoutParams).height != -1) {
                throw new java.lang.IllegalStateException("Pages must fill the whole ViewPager2 (use match_parent)");
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
        public void onChildViewDetachedFromWindow(@androidx.annotation.NonNull android.view.View view) {
        }
    }

    /* renamed from: com.baidu.mobads.sdk.internal.widget.ViewPager2$5, reason: invalid class name */
    class AnonymousClass5 extends com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback {
        boolean a = false;
        boolean b = false;
        boolean c = false;
        final /* synthetic */ com.baidu.mobads.sdk.internal.widget.ViewPager2.OnOverScrollListener d;

        public AnonymousClass5(com.baidu.mobads.sdk.internal.widget.ViewPager2.OnOverScrollListener onOverScrollListener) {
            this.d = onOverScrollListener;
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i) {
            if (i != 0) {
                if (i == 1) {
                    this.c = true;
                    return;
                } else {
                    if (i != 2) {
                        return;
                    }
                    this.a = false;
                    this.b = false;
                    return;
                }
            }
            androidx.recyclerview.widget.RecyclerView.Adapter adapter = com.baidu.mobads.sdk.internal.widget.ViewPager2.this.getAdapter();
            if (adapter == null || adapter.getItemCount() <= 0 || !this.c) {
                return;
            }
            if (1 == com.baidu.mobads.sdk.internal.widget.ViewPager2.this.getOrientation()) {
                if (!com.baidu.mobads.sdk.internal.widget.ViewPager2.this.canScrollVertically(-1) && com.baidu.mobads.sdk.internal.widget.ViewPager2.this.getOverScrolledDirection() < 0) {
                    this.d.onOverScrollStart();
                } else if (!com.baidu.mobads.sdk.internal.widget.ViewPager2.this.canScrollVertically(1) && com.baidu.mobads.sdk.internal.widget.ViewPager2.this.getOverScrolledDirection() > 0) {
                    this.d.onOverScrollEnd();
                }
            } else if (com.baidu.mobads.sdk.internal.widget.ViewPager2.this.getOrientation() == 0) {
                if (!com.baidu.mobads.sdk.internal.widget.ViewPager2.this.canScrollHorizontally(-1) && com.baidu.mobads.sdk.internal.widget.ViewPager2.this.getOverScrolledDirection() < 0) {
                    this.d.onOverScrollStart();
                } else if (!com.baidu.mobads.sdk.internal.widget.ViewPager2.this.canScrollHorizontally(1) && com.baidu.mobads.sdk.internal.widget.ViewPager2.this.getOverScrolledDirection() > 0) {
                    this.d.onOverScrollEnd();
                }
            }
            this.c = false;
        }
    }

    public abstract class AccessibilityProvider {
        private AccessibilityProvider() {
        }

        public /* synthetic */ AccessibilityProvider(com.baidu.mobads.sdk.internal.widget.ViewPager2 viewPager2, com.baidu.mobads.sdk.internal.widget.ViewPager2.AnonymousClass1 anonymousClass1) {
            this();
        }

        public void a(@androidx.annotation.NonNull android.view.accessibility.AccessibilityEvent accessibilityEvent) {
        }

        public void a(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
        }

        public void a(@androidx.annotation.Nullable androidx.recyclerview.widget.RecyclerView.Adapter<?> adapter) {
        }

        public void a(@androidx.annotation.NonNull com.baidu.mobads.sdk.internal.widget.CompositeOnPageChangeCallback compositeOnPageChangeCallback, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView) {
        }

        public boolean a() {
            return false;
        }

        public boolean a(int i, android.os.Bundle bundle) {
            return false;
        }

        public java.lang.String b() {
            throw new java.lang.IllegalStateException("Not implemented.");
        }

        public void b(@androidx.annotation.Nullable androidx.recyclerview.widget.RecyclerView.Adapter<?> adapter) {
        }

        public boolean b(int i, android.os.Bundle bundle) {
            throw new java.lang.IllegalStateException("Not implemented.");
        }

        public void c() {
        }

        public void d() {
        }

        public void e() {
        }

        public void f() {
        }

        public void g() {
        }

        public boolean handlesLmPerformAccessibilityAction(int i) {
            return false;
        }

        public boolean handlesRvGetAccessibilityClassName() {
            return false;
        }

        public void onLmInitializeAccessibilityNodeInfo(@androidx.annotation.NonNull androidx.core.view.accessibility.AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        }

        public boolean onLmPerformAccessibilityAction(int i) {
            throw new java.lang.IllegalStateException("Not implemented.");
        }

        public java.lang.CharSequence onRvGetAccessibilityClassName() {
            throw new java.lang.IllegalStateException("Not implemented.");
        }
    }

    public class BasicAccessibilityProvider extends com.baidu.mobads.sdk.internal.widget.ViewPager2.AccessibilityProvider {
        public BasicAccessibilityProvider() {
            super(com.baidu.mobads.sdk.internal.widget.ViewPager2.this, null);
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.AccessibilityProvider
        public boolean handlesLmPerformAccessibilityAction(int i) {
            return (i == 8192 || i == 4096) && !com.baidu.mobads.sdk.internal.widget.ViewPager2.this.isUserInputEnabled();
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.AccessibilityProvider
        public boolean handlesRvGetAccessibilityClassName() {
            return true;
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.AccessibilityProvider
        public void onLmInitializeAccessibilityNodeInfo(@androidx.annotation.NonNull androidx.core.view.accessibility.AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (com.baidu.mobads.sdk.internal.widget.ViewPager2.this.isUserInputEnabled()) {
                return;
            }
            accessibilityNodeInfoCompat.removeAction(androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
            accessibilityNodeInfoCompat.removeAction(androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
            accessibilityNodeInfoCompat.setScrollable(false);
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.AccessibilityProvider
        public boolean onLmPerformAccessibilityAction(int i) {
            if (handlesLmPerformAccessibilityAction(i)) {
                return false;
            }
            throw new java.lang.IllegalStateException();
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.AccessibilityProvider
        public java.lang.CharSequence onRvGetAccessibilityClassName() {
            if (handlesRvGetAccessibilityClassName()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new java.lang.IllegalStateException();
        }
    }

    public static abstract class DataSetChangeObserver extends androidx.recyclerview.widget.RecyclerView.AdapterDataObserver {
        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public abstract void onChanged();

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int i, int i2) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int i, int i2, @androidx.annotation.Nullable java.lang.Object obj) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeInserted(int i, int i2) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeMoved(int i, int i2, int i3) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeRemoved(int i, int i2) {
            onChanged();
        }
    }

    public class LinearLayoutManagerImpl extends androidx.recyclerview.widget.LinearLayoutManager {
        public LinearLayoutManagerImpl(android.content.Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public int getExtraLayoutSpace(androidx.recyclerview.widget.RecyclerView.State state) {
            int offscreenPageLimit = com.baidu.mobads.sdk.internal.widget.ViewPager2.this.getOffscreenPageLimit();
            return offscreenPageLimit == -1 ? super.getExtraLayoutSpace(state) : com.baidu.mobads.sdk.internal.widget.ViewPager2.this.b() * offscreenPageLimit;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void onInitializeAccessibilityNodeInfo(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.Recycler recycler, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.State state, @androidx.annotation.NonNull androidx.core.view.accessibility.AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(recycler, state, accessibilityNodeInfoCompat);
            com.baidu.mobads.sdk.internal.widget.ViewPager2.this.l.onLmInitializeAccessibilityNodeInfo(accessibilityNodeInfoCompat);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean performAccessibilityAction(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.Recycler recycler, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.State state, int i, @androidx.annotation.Nullable android.os.Bundle bundle) {
            return com.baidu.mobads.sdk.internal.widget.ViewPager2.this.l.handlesLmPerformAccessibilityAction(i) ? com.baidu.mobads.sdk.internal.widget.ViewPager2.this.l.onLmPerformAccessibilityAction(i) : super.performAccessibilityAction(recycler, state, i, bundle);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean requestChildRectangleOnScreen(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.graphics.Rect rect, boolean z, boolean z2) {
            return false;
        }
    }

    @androidx.annotation.IntRange(from = 1)
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface OffscreenPageLimit {
    }

    public interface OnOverScrollListener {
        void onOverScrollEnd();

        void onOverScrollStart();
    }

    public static abstract class OnPageChangeCallback {
        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f, @androidx.annotation.Px int i2) {
        }

        public void onPageSelected(int i) {
        }
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface Orientation {
    }

    public interface PageTransformer {
        void transformPage(@androidx.annotation.NonNull android.view.View view, float f);
    }

    public class PagerSnapHelperImpl extends com.baidu.mobads.sdk.internal.widget.PagerSnapHelper {
        public PagerSnapHelperImpl() {
        }

        @Override // com.baidu.mobads.sdk.internal.widget.PagerSnapHelper, androidx.recyclerview.widget.SnapHelper
        @androidx.annotation.Nullable
        public android.view.View findSnapView(androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager) {
            if (com.baidu.mobads.sdk.internal.widget.ViewPager2.this.isFakeDragging()) {
                return null;
            }
            return super.findSnapView(layoutManager);
        }
    }

    public class RecyclerViewImpl extends androidx.recyclerview.widget.RecyclerView {
        public RecyclerViewImpl(android.content.Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, androidx.core.view.NestedScrollingChild2
        public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr, int i5) {
            com.baidu.mobads.sdk.internal.widget.ViewPager2.this.o[1] = com.baidu.mobads.sdk.internal.widget.ViewPager2.this.o[0];
            if (1 == com.baidu.mobads.sdk.internal.widget.ViewPager2.this.getOrientation()) {
                com.baidu.mobads.sdk.internal.widget.ViewPager2.this.o[0] = i4;
            } else {
                com.baidu.mobads.sdk.internal.widget.ViewPager2.this.o[0] = i3;
            }
            return super.dispatchNestedScroll(i, i2, i3, i4, iArr, i5);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
        @androidx.annotation.RequiresApi(23)
        public java.lang.CharSequence getAccessibilityClassName() {
            return com.baidu.mobads.sdk.internal.widget.ViewPager2.this.l.handlesRvGetAccessibilityClassName() ? com.baidu.mobads.sdk.internal.widget.ViewPager2.this.l.onRvGetAccessibilityClassName() : super.getAccessibilityClassName();
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(@androidx.annotation.NonNull android.view.accessibility.AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setFromIndex(com.baidu.mobads.sdk.internal.widget.ViewPager2.this.h);
            accessibilityEvent.setToIndex(com.baidu.mobads.sdk.internal.widget.ViewPager2.this.h);
            com.baidu.mobads.sdk.internal.widget.ViewPager2.this.l.a(accessibilityEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
        public boolean onInterceptTouchEvent(android.view.MotionEvent motionEvent) {
            return com.baidu.mobads.sdk.internal.widget.ViewPager2.this.isUserInputEnabled() && super.onInterceptTouchEvent(motionEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
        @android.annotation.SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
            return com.baidu.mobads.sdk.internal.widget.ViewPager2.this.isUserInputEnabled() && super.onTouchEvent(motionEvent);
        }
    }

    public static class SavedState extends android.view.View.BaseSavedState {
        public static final android.os.Parcelable.Creator<com.baidu.mobads.sdk.internal.widget.ViewPager2.SavedState> d = new com.baidu.mobads.sdk.internal.widget.ViewPager2.SavedState.AnonymousClass1();
        int a;
        int b;
        android.os.Parcelable c;

        /* renamed from: com.baidu.mobads.sdk.internal.widget.ViewPager2$SavedState$1, reason: invalid class name */
        final class AnonymousClass1 implements android.os.Parcelable.ClassLoaderCreator<com.baidu.mobads.sdk.internal.widget.ViewPager2.SavedState> {
            @Override // android.os.Parcelable.Creator
            public com.baidu.mobads.sdk.internal.widget.ViewPager2.SavedState createFromParcel(android.os.Parcel parcel) {
                return createFromParcel(parcel, (java.lang.ClassLoader) null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public com.baidu.mobads.sdk.internal.widget.ViewPager2.SavedState createFromParcel(android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
                return android.os.Build.VERSION.SDK_INT >= 24 ? new com.baidu.mobads.sdk.internal.widget.ViewPager2.SavedState(parcel, classLoader) : new com.baidu.mobads.sdk.internal.widget.ViewPager2.SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public com.baidu.mobads.sdk.internal.widget.ViewPager2.SavedState[] newArray(int i) {
                return new com.baidu.mobads.sdk.internal.widget.ViewPager2.SavedState[i];
            }
        }

        public SavedState(android.os.Parcel parcel) {
            super(parcel);
            a(parcel, null);
        }

        @androidx.annotation.RequiresApi(24)
        public SavedState(android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
            super(parcel, classLoader);
            a(parcel, classLoader);
        }

        public SavedState(android.os.Parcelable parcelable) {
            super(parcelable);
        }

        private void a(android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
            this.a = parcel.readInt();
            this.b = parcel.readInt();
            this.c = parcel.readParcelable(classLoader);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a);
            parcel.writeInt(this.b);
            parcel.writeParcelable(this.c, i);
        }
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface ScrollState {
    }

    public static class SmoothScrollToPosition implements java.lang.Runnable {
        private final int a;
        private final androidx.recyclerview.widget.RecyclerView b;

        public SmoothScrollToPosition(int i, androidx.recyclerview.widget.RecyclerView recyclerView) {
            this.a = i;
            this.b = recyclerView;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.smoothScrollToPosition(this.a);
        }
    }

    public ViewPager2(@androidx.annotation.NonNull android.content.Context context) {
        super(context);
        this.m = new android.graphics.Rect();
        this.n = new android.graphics.Rect();
        this.o = new int[2];
        this.p = new com.baidu.mobads.sdk.internal.widget.CompositeOnPageChangeCallback(3);
        this.i = false;
        this.q = new com.baidu.mobads.sdk.internal.widget.ViewPager2.AnonymousClass1();
        this.f300s = -1;
        this.y = null;
        this.z = false;
        this.A = true;
        this.B = -1;
        a(context, (android.util.AttributeSet) null);
    }

    public ViewPager2(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.m = new android.graphics.Rect();
        this.n = new android.graphics.Rect();
        this.o = new int[2];
        this.p = new com.baidu.mobads.sdk.internal.widget.CompositeOnPageChangeCallback(3);
        this.i = false;
        this.q = new com.baidu.mobads.sdk.internal.widget.ViewPager2.AnonymousClass1();
        this.f300s = -1;
        this.y = null;
        this.z = false;
        this.A = true;
        this.B = -1;
        a(context, attributeSet);
    }

    public ViewPager2(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.m = new android.graphics.Rect();
        this.n = new android.graphics.Rect();
        this.o = new int[2];
        this.p = new com.baidu.mobads.sdk.internal.widget.CompositeOnPageChangeCallback(3);
        this.i = false;
        this.q = new com.baidu.mobads.sdk.internal.widget.ViewPager2.AnonymousClass1();
        this.f300s = -1;
        this.y = null;
        this.z = false;
        this.A = true;
        this.B = -1;
        a(context, attributeSet);
    }

    @androidx.annotation.RequiresApi(21)
    public ViewPager2(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.m = new android.graphics.Rect();
        this.n = new android.graphics.Rect();
        this.o = new int[2];
        this.p = new com.baidu.mobads.sdk.internal.widget.CompositeOnPageChangeCallback(3);
        this.i = false;
        this.q = new com.baidu.mobads.sdk.internal.widget.ViewPager2.AnonymousClass1();
        this.f300s = -1;
        this.y = null;
        this.z = false;
        this.A = true;
        this.B = -1;
        a(context, attributeSet);
    }

    private void a(android.content.Context context, android.util.AttributeSet attributeSet) {
        this.l = new com.baidu.mobads.sdk.internal.widget.ViewPager2.BasicAccessibilityProvider();
        com.baidu.mobads.sdk.internal.widget.ViewPager2.RecyclerViewImpl recyclerViewImpl = new com.baidu.mobads.sdk.internal.widget.ViewPager2.RecyclerViewImpl(context);
        this.j = recyclerViewImpl;
        recyclerViewImpl.setId(com.baidu.mobads.sdk.internal.concrete.ViewCompatDelegate.generateViewId());
        this.j.setDescendantFocusability(131072);
        com.baidu.mobads.sdk.internal.widget.ViewPager2.LinearLayoutManagerImpl linearLayoutManagerImpl = new com.baidu.mobads.sdk.internal.widget.ViewPager2.LinearLayoutManagerImpl(context);
        this.r = linearLayoutManagerImpl;
        this.j.setLayoutManager(linearLayoutManagerImpl);
        this.j.setScrollingTouchSlop(1);
        setOrientation(0);
        this.j.setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -1));
        this.j.addOnChildAttachStateChangeListener(e());
        com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter scrollEventAdapter = new com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter(this);
        this.k = scrollEventAdapter;
        this.w = new com.baidu.mobads.sdk.internal.widget.FakeDrag(this, scrollEventAdapter, this.j);
        com.baidu.mobads.sdk.internal.widget.ViewPager2.PagerSnapHelperImpl pagerSnapHelperImpl = new com.baidu.mobads.sdk.internal.widget.ViewPager2.PagerSnapHelperImpl();
        this.u = pagerSnapHelperImpl;
        pagerSnapHelperImpl.attachToRecyclerView(this.j);
        this.j.addOnScrollListener(this.k);
        com.baidu.mobads.sdk.internal.widget.CompositeOnPageChangeCallback compositeOnPageChangeCallback = new com.baidu.mobads.sdk.internal.widget.CompositeOnPageChangeCallback(3);
        this.v = compositeOnPageChangeCallback;
        this.k.a(compositeOnPageChangeCallback);
        com.baidu.mobads.sdk.internal.widget.ViewPager2.AnonymousClass2 anonymousClass2 = new com.baidu.mobads.sdk.internal.widget.ViewPager2.AnonymousClass2();
        com.baidu.mobads.sdk.internal.widget.ViewPager2.AnonymousClass3 anonymousClass3 = new com.baidu.mobads.sdk.internal.widget.ViewPager2.AnonymousClass3();
        this.v.a(anonymousClass2);
        this.v.a(anonymousClass3);
        this.l.a(this.v, this.j);
        this.v.a(this.p);
        com.baidu.mobads.sdk.internal.widget.PageTransformerAdapter pageTransformerAdapter = new com.baidu.mobads.sdk.internal.widget.PageTransformerAdapter(this.r);
        this.x = pageTransformerAdapter;
        this.v.a(pageTransformerAdapter);
        androidx.recyclerview.widget.RecyclerView recyclerView = this.j;
        attachViewToParent(recyclerView, 0, recyclerView.getLayoutParams());
    }

    private void a(@androidx.annotation.Nullable androidx.recyclerview.widget.RecyclerView.Adapter<?> adapter) {
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.q);
        }
    }

    private void b(@androidx.annotation.Nullable androidx.recyclerview.widget.RecyclerView.Adapter<?> adapter) {
        if (adapter != null) {
            adapter.unregisterAdapterDataObserver(this.q);
        }
    }

    private androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener e() {
        return new com.baidu.mobads.sdk.internal.widget.ViewPager2.AnonymousClass4();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void f() {
        androidx.recyclerview.widget.RecyclerView.Adapter adapter;
        if (this.f300s == -1 || (adapter = getAdapter()) == 0) {
            return;
        }
        android.os.Parcelable parcelable = this.t;
        if (parcelable != null) {
            if (adapter instanceof com.baidu.mobads.sdk.internal.widget.StatefulAdapter) {
                ((com.baidu.mobads.sdk.internal.widget.StatefulAdapter) adapter).restoreState(parcelable);
            }
            this.t = null;
        }
        int max = java.lang.Math.max(0, java.lang.Math.min(this.f300s, adapter.getItemCount() - 1));
        this.h = max;
        this.f300s = -1;
        this.j.scrollToPosition(max);
        this.l.c();
    }

    void a() {
        com.baidu.mobads.sdk.internal.widget.PagerSnapHelper pagerSnapHelper = this.u;
        if (pagerSnapHelper == null) {
            throw new java.lang.IllegalStateException("Design assumption violated.");
        }
        android.view.View findSnapView = pagerSnapHelper.findSnapView(this.r);
        if (findSnapView == null) {
            return;
        }
        int position = this.r.getPosition(findSnapView);
        if (position != this.h && getScrollState() == 0) {
            this.v.onPageSelected(position);
        }
        this.i = false;
    }

    public void a(int i, boolean z) {
        androidx.recyclerview.widget.RecyclerView.Adapter adapter = getAdapter();
        if (adapter == null) {
            if (this.f300s != -1) {
                this.f300s = java.lang.Math.max(i, 0);
                return;
            }
            return;
        }
        if (adapter.getItemCount() <= 0) {
            return;
        }
        int min = java.lang.Math.min(java.lang.Math.max(i, 0), adapter.getItemCount() - 1);
        if (min == this.h && this.k.e()) {
            return;
        }
        int i2 = this.h;
        if (min == i2 && z) {
            return;
        }
        double d2 = i2;
        this.h = min;
        this.l.e();
        if (!this.k.e()) {
            d2 = this.k.h();
        }
        this.k.a(min, z);
        if (!z) {
            this.j.scrollToPosition(min);
            return;
        }
        double d3 = min;
        if (java.lang.Math.abs(d3 - d2) <= 3.0d) {
            this.j.smoothScrollToPosition(min);
            return;
        }
        this.j.scrollToPosition(d3 > d2 ? min - 3 : min + 3);
        androidx.recyclerview.widget.RecyclerView recyclerView = this.j;
        recyclerView.post(new com.baidu.mobads.sdk.internal.widget.ViewPager2.SmoothScrollToPosition(min, recyclerView));
    }

    public void addItemDecoration(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.ItemDecoration itemDecoration) {
        this.j.addItemDecoration(itemDecoration);
    }

    public void addItemDecoration(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.ItemDecoration itemDecoration, int i) {
        this.j.addItemDecoration(itemDecoration, i);
    }

    public int b() {
        int height;
        int paddingBottom;
        androidx.recyclerview.widget.RecyclerView recyclerView = this.j;
        if (getOrientation() == 0) {
            height = recyclerView.getWidth() - recyclerView.getPaddingLeft();
            paddingBottom = recyclerView.getPaddingRight();
        } else {
            height = recyclerView.getHeight() - recyclerView.getPaddingTop();
            paddingBottom = recyclerView.getPaddingBottom();
        }
        return height - paddingBottom;
    }

    public boolean beginFakeDrag() {
        return this.w.b();
    }

    public boolean c() {
        return this.r.getLayoutDirection() == 1;
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i) {
        return this.j.canScrollHorizontally(i);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i) {
        return this.j.canScrollVertically(i);
    }

    void d() {
        android.view.View findSnapView = this.u.findSnapView(this.r);
        if (findSnapView == null) {
            return;
        }
        int[] calculateDistanceToFinalSnap = this.u.calculateDistanceToFinalSnap(this.r, findSnapView);
        int i = calculateDistanceToFinalSnap[0];
        if (i == 0 && calculateDistanceToFinalSnap[1] == 0) {
            return;
        }
        this.j.smoothScrollBy(i, calculateDistanceToFinalSnap[1]);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(android.util.SparseArray<android.os.Parcelable> sparseArray) {
        android.os.Parcelable parcelable = sparseArray.get(getId());
        if (parcelable instanceof com.baidu.mobads.sdk.internal.widget.ViewPager2.SavedState) {
            int i = ((com.baidu.mobads.sdk.internal.widget.ViewPager2.SavedState) parcelable).a;
            sparseArray.put(this.j.getId(), sparseArray.get(i));
            sparseArray.remove(i);
        }
        super.dispatchRestoreInstanceState(sparseArray);
        f();
    }

    public boolean endFakeDrag() {
        return this.w.c();
    }

    public boolean fakeDragBy(@androidx.annotation.Px @android.annotation.SuppressLint({"SupportAnnotationUsage"}) float f2) {
        return this.w.a(f2);
    }

    @Override // android.view.ViewGroup, android.view.View
    @androidx.annotation.RequiresApi(23)
    public java.lang.CharSequence getAccessibilityClassName() {
        return this.l.a() ? this.l.b() : super.getAccessibilityClassName();
    }

    @androidx.annotation.Nullable
    public androidx.recyclerview.widget.RecyclerView.Adapter getAdapter() {
        return this.j.getAdapter();
    }

    public int getCurrentItem() {
        return this.h;
    }

    @androidx.annotation.NonNull
    public androidx.recyclerview.widget.RecyclerView.ItemDecoration getItemDecorationAt(int i) {
        return this.j.getItemDecorationAt(i);
    }

    public int getItemDecorationCount() {
        return this.j.getItemDecorationCount();
    }

    public int getOffscreenPageLimit() {
        return this.B;
    }

    public int getOrientation() {
        return this.r.getOrientation();
    }

    public int getOverScrolledDirection() {
        int[] iArr = this.o;
        int i = iArr[0];
        return i == 0 ? iArr[1] : i;
    }

    public int getScrollState() {
        return this.k.d();
    }

    public void invalidateItemDecorations() {
        this.j.invalidateItemDecorations();
    }

    public boolean isFakeDragging() {
        return this.w.a();
    }

    public boolean isUserInputEnabled() {
        return this.A;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        this.l.a(accessibilityNodeInfo);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = this.j.getMeasuredWidth();
        int measuredHeight = this.j.getMeasuredHeight();
        this.m.left = getPaddingLeft();
        this.m.right = (i3 - i) - getPaddingRight();
        this.m.top = getPaddingTop();
        this.m.bottom = (i4 - i2) - getPaddingBottom();
        android.view.Gravity.apply(com.google.android.material.badge.BadgeDrawable.TOP_START, measuredWidth, measuredHeight, this.m, this.n);
        androidx.recyclerview.widget.RecyclerView recyclerView = this.j;
        android.graphics.Rect rect = this.n;
        recyclerView.layout(rect.left, rect.top, rect.right, rect.bottom);
        if (this.i) {
            a();
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        measureChild(this.j, i, i2);
        int measuredWidth = this.j.getMeasuredWidth();
        int measuredHeight = this.j.getMeasuredHeight();
        int measuredState = this.j.getMeasuredState();
        int paddingLeft = measuredWidth + getPaddingLeft() + getPaddingRight();
        int paddingTop = measuredHeight + getPaddingTop() + getPaddingBottom();
        setMeasuredDimension(android.view.View.resolveSizeAndState(java.lang.Math.max(paddingLeft, getSuggestedMinimumWidth()), i, measuredState), android.view.View.resolveSizeAndState(java.lang.Math.max(paddingTop, getSuggestedMinimumHeight()), i2, measuredState << 16));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(android.os.Parcelable parcelable) {
        if (!(parcelable instanceof com.baidu.mobads.sdk.internal.widget.ViewPager2.SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        com.baidu.mobads.sdk.internal.widget.ViewPager2.SavedState savedState = (com.baidu.mobads.sdk.internal.widget.ViewPager2.SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f300s = savedState.b;
        this.t = savedState.c;
    }

    @Override // android.view.View
    @androidx.annotation.Nullable
    public android.os.Parcelable onSaveInstanceState() {
        com.baidu.mobads.sdk.internal.widget.ViewPager2.SavedState savedState = new com.baidu.mobads.sdk.internal.widget.ViewPager2.SavedState(super.onSaveInstanceState());
        savedState.a = this.j.getId();
        int i = this.f300s;
        if (i == -1) {
            i = this.h;
        }
        savedState.b = i;
        android.os.Parcelable parcelable = this.t;
        if (parcelable != null) {
            savedState.c = parcelable;
        } else {
            java.lang.Object adapter = this.j.getAdapter();
            if (adapter instanceof com.baidu.mobads.sdk.internal.widget.StatefulAdapter) {
                savedState.c = ((com.baidu.mobads.sdk.internal.widget.StatefulAdapter) adapter).saveState();
            }
        }
        return savedState;
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(android.view.View view) {
        throw new java.lang.IllegalStateException(getClass().getSimpleName() + " does not support direct child views");
    }

    @Override // android.view.View
    @androidx.annotation.RequiresApi(16)
    public boolean performAccessibilityAction(int i, android.os.Bundle bundle) {
        return this.l.a(i, bundle) ? this.l.b(i, bundle) : super.performAccessibilityAction(i, bundle);
    }

    public void registerOnPageChangeCallback(@androidx.annotation.NonNull com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.p.a(onPageChangeCallback);
    }

    public void removeItemDecoration(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.ItemDecoration itemDecoration) {
        this.j.removeItemDecoration(itemDecoration);
    }

    public void removeItemDecorationAt(int i) {
        this.j.removeItemDecorationAt(i);
    }

    public void requestTransform() {
        if (this.x.a() == null) {
            return;
        }
        double h = this.k.h();
        int i = (int) h;
        float f2 = (float) (h - i);
        this.x.onPageScrolled(i, f2, java.lang.Math.round(b() * f2));
    }

    public void setAdapter(@androidx.annotation.Nullable androidx.recyclerview.widget.RecyclerView.Adapter adapter) {
        androidx.recyclerview.widget.RecyclerView.Adapter adapter2 = this.j.getAdapter();
        this.l.b(adapter2);
        b(adapter2);
        this.j.setAdapter(adapter);
        this.h = 0;
        f();
        this.l.a((androidx.recyclerview.widget.RecyclerView.Adapter<?>) adapter);
        a((androidx.recyclerview.widget.RecyclerView.Adapter<?>) adapter);
    }

    public void setCurrentItem(int i) {
        setCurrentItem(i, true);
    }

    public void setCurrentItem(int i, boolean z) {
        if (isFakeDragging()) {
            throw new java.lang.IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
        }
        a(i, z);
    }

    @Override // android.view.View
    @androidx.annotation.RequiresApi(17)
    public void setLayoutDirection(int i) {
        super.setLayoutDirection(i);
        this.l.g();
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 1 && i != -1) {
            throw new java.lang.IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
        }
        this.B = i;
        this.j.requestLayout();
    }

    public void setOnOverScrollListener(com.baidu.mobads.sdk.internal.widget.ViewPager2.OnOverScrollListener onOverScrollListener) {
        if (onOverScrollListener == null) {
            return;
        }
        registerOnPageChangeCallback(new com.baidu.mobads.sdk.internal.widget.ViewPager2.AnonymousClass5(onOverScrollListener));
    }

    public void setOrientation(int i) {
        this.r.setOrientation(i);
        this.l.d();
    }

    public void setPageTransformer(@androidx.annotation.Nullable com.baidu.mobads.sdk.internal.widget.ViewPager2.PageTransformer pageTransformer) {
        if (pageTransformer != null) {
            if (!this.z) {
                this.y = this.j.getItemAnimator();
                this.z = true;
            }
            this.j.setItemAnimator(null);
        } else if (this.z) {
            this.j.setItemAnimator(this.y);
            this.y = null;
            this.z = false;
        }
        if (pageTransformer == this.x.a()) {
            return;
        }
        this.x.a(pageTransformer);
        requestTransform();
    }

    public void setUserInputEnabled(boolean z) {
        this.A = z;
        this.l.f();
    }

    public void unregisterOnPageChangeCallback(@androidx.annotation.NonNull com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.p.b(onPageChangeCallback);
    }
}
