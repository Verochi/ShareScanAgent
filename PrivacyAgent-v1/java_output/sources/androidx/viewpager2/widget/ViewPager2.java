package androidx.viewpager2.widget;

/* loaded from: classes.dex */
public final class ViewPager2 extends android.view.ViewGroup {
    public static final int OFFSCREEN_PAGE_LIMIT_DEFAULT = -1;
    public static final int ORIENTATION_HORIZONTAL = 0;
    public static final int ORIENTATION_VERTICAL = 1;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    static boolean sFeatureEnhancedA11yEnabled = true;
    androidx.viewpager2.widget.ViewPager2.AccessibilityProvider mAccessibilityProvider;
    int mCurrentItem;
    private androidx.recyclerview.widget.RecyclerView.AdapterDataObserver mCurrentItemDataSetChangeObserver;
    boolean mCurrentItemDirty;
    private androidx.viewpager2.widget.CompositeOnPageChangeCallback mExternalPageChangeCallbacks;
    private androidx.viewpager2.widget.FakeDrag mFakeDragger;
    private androidx.recyclerview.widget.LinearLayoutManager mLayoutManager;
    private int mOffscreenPageLimit;
    private androidx.viewpager2.widget.CompositeOnPageChangeCallback mPageChangeEventDispatcher;
    private androidx.viewpager2.widget.PageTransformerAdapter mPageTransformerAdapter;
    private androidx.recyclerview.widget.PagerSnapHelper mPagerSnapHelper;
    private android.os.Parcelable mPendingAdapterState;
    private int mPendingCurrentItem;
    androidx.recyclerview.widget.RecyclerView mRecyclerView;
    private androidx.recyclerview.widget.RecyclerView.ItemAnimator mSavedItemAnimator;
    private boolean mSavedItemAnimatorPresent;
    androidx.viewpager2.widget.ScrollEventAdapter mScrollEventAdapter;
    private final android.graphics.Rect mTmpChildRect;
    private final android.graphics.Rect mTmpContainerRect;
    private boolean mUserInputEnabled;

    /* renamed from: androidx.viewpager2.widget.ViewPager2$1, reason: invalid class name */
    public class AnonymousClass1 extends androidx.viewpager2.widget.ViewPager2.DataSetChangeObserver {
        public AnonymousClass1() {
            super(null);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            androidx.viewpager2.widget.ViewPager2 viewPager2 = androidx.viewpager2.widget.ViewPager2.this;
            viewPager2.mCurrentItemDirty = true;
            viewPager2.mScrollEventAdapter.notifyDataSetChangeHappened();
        }
    }

    /* renamed from: androidx.viewpager2.widget.ViewPager2$2, reason: invalid class name */
    public class AnonymousClass2 extends androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback {
        public AnonymousClass2() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i) {
            if (i == 0) {
                androidx.viewpager2.widget.ViewPager2.this.updateCurrentItem();
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i) {
            androidx.viewpager2.widget.ViewPager2 viewPager2 = androidx.viewpager2.widget.ViewPager2.this;
            if (viewPager2.mCurrentItem != i) {
                viewPager2.mCurrentItem = i;
                viewPager2.mAccessibilityProvider.onSetNewCurrentItem();
            }
        }
    }

    /* renamed from: androidx.viewpager2.widget.ViewPager2$3, reason: invalid class name */
    public class AnonymousClass3 extends androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback {
        public AnonymousClass3() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i) {
            androidx.viewpager2.widget.ViewPager2.this.clearFocus();
            if (androidx.viewpager2.widget.ViewPager2.this.hasFocus()) {
                androidx.viewpager2.widget.ViewPager2.this.mRecyclerView.requestFocus(2);
            }
        }
    }

    /* renamed from: androidx.viewpager2.widget.ViewPager2$4, reason: invalid class name */
    public class AnonymousClass4 implements androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener {
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

    public abstract class AccessibilityProvider {
        private AccessibilityProvider() {
        }

        public /* synthetic */ AccessibilityProvider(androidx.viewpager2.widget.ViewPager2 viewPager2, androidx.viewpager2.widget.ViewPager2.AnonymousClass1 anonymousClass1) {
            this();
        }

        public boolean handlesGetAccessibilityClassName() {
            return false;
        }

        public boolean handlesLmPerformAccessibilityAction(int i) {
            return false;
        }

        public boolean handlesPerformAccessibilityAction(int i, android.os.Bundle bundle) {
            return false;
        }

        public boolean handlesRvGetAccessibilityClassName() {
            return false;
        }

        public void onAttachAdapter(@androidx.annotation.Nullable androidx.recyclerview.widget.RecyclerView.Adapter<?> adapter) {
        }

        public void onDetachAdapter(@androidx.annotation.Nullable androidx.recyclerview.widget.RecyclerView.Adapter<?> adapter) {
        }

        public java.lang.String onGetAccessibilityClassName() {
            throw new java.lang.IllegalStateException("Not implemented.");
        }

        public void onInitialize(@androidx.annotation.NonNull androidx.viewpager2.widget.CompositeOnPageChangeCallback compositeOnPageChangeCallback, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView) {
        }

        public void onInitializeAccessibilityNodeInfo(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
        }

        public void onLmInitializeAccessibilityNodeInfo(@androidx.annotation.NonNull androidx.core.view.accessibility.AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        }

        public boolean onLmPerformAccessibilityAction(int i) {
            throw new java.lang.IllegalStateException("Not implemented.");
        }

        public boolean onPerformAccessibilityAction(int i, android.os.Bundle bundle) {
            throw new java.lang.IllegalStateException("Not implemented.");
        }

        public void onRestorePendingState() {
        }

        public java.lang.CharSequence onRvGetAccessibilityClassName() {
            throw new java.lang.IllegalStateException("Not implemented.");
        }

        public void onRvInitializeAccessibilityEvent(@androidx.annotation.NonNull android.view.accessibility.AccessibilityEvent accessibilityEvent) {
        }

        public void onSetLayoutDirection() {
        }

        public void onSetNewCurrentItem() {
        }

        public void onSetOrientation() {
        }

        public void onSetUserInputEnabled() {
        }
    }

    public class BasicAccessibilityProvider extends androidx.viewpager2.widget.ViewPager2.AccessibilityProvider {
        public BasicAccessibilityProvider() {
            super(androidx.viewpager2.widget.ViewPager2.this, null);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public boolean handlesLmPerformAccessibilityAction(int i) {
            return (i == 8192 || i == 4096) && !androidx.viewpager2.widget.ViewPager2.this.isUserInputEnabled();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public boolean handlesRvGetAccessibilityClassName() {
            return true;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void onLmInitializeAccessibilityNodeInfo(@androidx.annotation.NonNull androidx.core.view.accessibility.AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (androidx.viewpager2.widget.ViewPager2.this.isUserInputEnabled()) {
                return;
            }
            accessibilityNodeInfoCompat.removeAction(androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
            accessibilityNodeInfoCompat.removeAction(androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
            accessibilityNodeInfoCompat.setScrollable(false);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public boolean onLmPerformAccessibilityAction(int i) {
            if (handlesLmPerformAccessibilityAction(i)) {
                return false;
            }
            throw new java.lang.IllegalStateException();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public java.lang.CharSequence onRvGetAccessibilityClassName() {
            if (handlesRvGetAccessibilityClassName()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new java.lang.IllegalStateException();
        }
    }

    public static abstract class DataSetChangeObserver extends androidx.recyclerview.widget.RecyclerView.AdapterDataObserver {
        private DataSetChangeObserver() {
        }

        public /* synthetic */ DataSetChangeObserver(androidx.viewpager2.widget.ViewPager2.AnonymousClass1 anonymousClass1) {
            this();
        }

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
        public void calculateExtraLayoutSpace(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.State state, @androidx.annotation.NonNull int[] iArr) {
            int offscreenPageLimit = androidx.viewpager2.widget.ViewPager2.this.getOffscreenPageLimit();
            if (offscreenPageLimit == -1) {
                super.calculateExtraLayoutSpace(state, iArr);
                return;
            }
            int pageSize = androidx.viewpager2.widget.ViewPager2.this.getPageSize() * offscreenPageLimit;
            iArr[0] = pageSize;
            iArr[1] = pageSize;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void onInitializeAccessibilityNodeInfo(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.Recycler recycler, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.State state, @androidx.annotation.NonNull androidx.core.view.accessibility.AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(recycler, state, accessibilityNodeInfoCompat);
            androidx.viewpager2.widget.ViewPager2.this.mAccessibilityProvider.onLmInitializeAccessibilityNodeInfo(accessibilityNodeInfoCompat);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean performAccessibilityAction(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.Recycler recycler, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.State state, int i, @androidx.annotation.Nullable android.os.Bundle bundle) {
            return androidx.viewpager2.widget.ViewPager2.this.mAccessibilityProvider.handlesLmPerformAccessibilityAction(i) ? androidx.viewpager2.widget.ViewPager2.this.mAccessibilityProvider.onLmPerformAccessibilityAction(i) : super.performAccessibilityAction(recycler, state, i, bundle);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean requestChildRectangleOnScreen(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.graphics.Rect rect, boolean z, boolean z2) {
            return false;
        }
    }

    @androidx.annotation.IntRange(from = 1)
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface OffscreenPageLimit {
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
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface Orientation {
    }

    public class PageAwareAccessibilityProvider extends androidx.viewpager2.widget.ViewPager2.AccessibilityProvider {
        private final androidx.core.view.accessibility.AccessibilityViewCommand mActionPageBackward;
        private final androidx.core.view.accessibility.AccessibilityViewCommand mActionPageForward;
        private androidx.recyclerview.widget.RecyclerView.AdapterDataObserver mAdapterDataObserver;

        /* renamed from: androidx.viewpager2.widget.ViewPager2$PageAwareAccessibilityProvider$1, reason: invalid class name */
        public class AnonymousClass1 implements androidx.core.view.accessibility.AccessibilityViewCommand {
            public AnonymousClass1() {
            }

            @Override // androidx.core.view.accessibility.AccessibilityViewCommand
            public boolean perform(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.Nullable androidx.core.view.accessibility.AccessibilityViewCommand.CommandArguments commandArguments) {
                androidx.viewpager2.widget.ViewPager2.PageAwareAccessibilityProvider.this.setCurrentItemFromAccessibilityCommand(((androidx.viewpager2.widget.ViewPager2) view).getCurrentItem() + 1);
                return true;
            }
        }

        /* renamed from: androidx.viewpager2.widget.ViewPager2$PageAwareAccessibilityProvider$2, reason: invalid class name */
        public class AnonymousClass2 implements androidx.core.view.accessibility.AccessibilityViewCommand {
            public AnonymousClass2() {
            }

            @Override // androidx.core.view.accessibility.AccessibilityViewCommand
            public boolean perform(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.Nullable androidx.core.view.accessibility.AccessibilityViewCommand.CommandArguments commandArguments) {
                androidx.viewpager2.widget.ViewPager2.PageAwareAccessibilityProvider.this.setCurrentItemFromAccessibilityCommand(((androidx.viewpager2.widget.ViewPager2) view).getCurrentItem() - 1);
                return true;
            }
        }

        /* renamed from: androidx.viewpager2.widget.ViewPager2$PageAwareAccessibilityProvider$3, reason: invalid class name */
        public class AnonymousClass3 extends androidx.viewpager2.widget.ViewPager2.DataSetChangeObserver {
            public AnonymousClass3() {
                super(null);
            }

            @Override // androidx.viewpager2.widget.ViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                androidx.viewpager2.widget.ViewPager2.PageAwareAccessibilityProvider.this.updatePageAccessibilityActions();
            }
        }

        public PageAwareAccessibilityProvider() {
            super(androidx.viewpager2.widget.ViewPager2.this, null);
            this.mActionPageForward = new androidx.viewpager2.widget.ViewPager2.PageAwareAccessibilityProvider.AnonymousClass1();
            this.mActionPageBackward = new androidx.viewpager2.widget.ViewPager2.PageAwareAccessibilityProvider.AnonymousClass2();
        }

        private void addCollectionInfo(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
            int i;
            int i2;
            if (androidx.viewpager2.widget.ViewPager2.this.getAdapter() == null) {
                i = 0;
            } else {
                if (androidx.viewpager2.widget.ViewPager2.this.getOrientation() != 1) {
                    i2 = androidx.viewpager2.widget.ViewPager2.this.getAdapter().getItemCount();
                    i = 0;
                    androidx.core.view.accessibility.AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(androidx.core.view.accessibility.AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(i, i2, false, 0));
                }
                i = androidx.viewpager2.widget.ViewPager2.this.getAdapter().getItemCount();
            }
            i2 = 0;
            androidx.core.view.accessibility.AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(androidx.core.view.accessibility.AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(i, i2, false, 0));
        }

        private void addScrollActions(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
            int itemCount;
            androidx.recyclerview.widget.RecyclerView.Adapter adapter = androidx.viewpager2.widget.ViewPager2.this.getAdapter();
            if (adapter == null || (itemCount = adapter.getItemCount()) == 0 || !androidx.viewpager2.widget.ViewPager2.this.isUserInputEnabled()) {
                return;
            }
            if (androidx.viewpager2.widget.ViewPager2.this.mCurrentItem > 0) {
                accessibilityNodeInfo.addAction(8192);
            }
            if (androidx.viewpager2.widget.ViewPager2.this.mCurrentItem < itemCount - 1) {
                accessibilityNodeInfo.addAction(4096);
            }
            accessibilityNodeInfo.setScrollable(true);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public boolean handlesGetAccessibilityClassName() {
            return true;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public boolean handlesPerformAccessibilityAction(int i, android.os.Bundle bundle) {
            return i == 8192 || i == 4096;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void onAttachAdapter(@androidx.annotation.Nullable androidx.recyclerview.widget.RecyclerView.Adapter<?> adapter) {
            updatePageAccessibilityActions();
            if (adapter != null) {
                adapter.registerAdapterDataObserver(this.mAdapterDataObserver);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void onDetachAdapter(@androidx.annotation.Nullable androidx.recyclerview.widget.RecyclerView.Adapter<?> adapter) {
            if (adapter != null) {
                adapter.unregisterAdapterDataObserver(this.mAdapterDataObserver);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public java.lang.String onGetAccessibilityClassName() {
            if (handlesGetAccessibilityClassName()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new java.lang.IllegalStateException();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void onInitialize(@androidx.annotation.NonNull androidx.viewpager2.widget.CompositeOnPageChangeCallback compositeOnPageChangeCallback, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView) {
            androidx.core.view.ViewCompat.setImportantForAccessibility(recyclerView, 2);
            this.mAdapterDataObserver = new androidx.viewpager2.widget.ViewPager2.PageAwareAccessibilityProvider.AnonymousClass3();
            if (androidx.core.view.ViewCompat.getImportantForAccessibility(androidx.viewpager2.widget.ViewPager2.this) == 0) {
                androidx.core.view.ViewCompat.setImportantForAccessibility(androidx.viewpager2.widget.ViewPager2.this, 1);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void onInitializeAccessibilityNodeInfo(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
            addCollectionInfo(accessibilityNodeInfo);
            addScrollActions(accessibilityNodeInfo);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public boolean onPerformAccessibilityAction(int i, android.os.Bundle bundle) {
            if (!handlesPerformAccessibilityAction(i, bundle)) {
                throw new java.lang.IllegalStateException();
            }
            setCurrentItemFromAccessibilityCommand(i == 8192 ? androidx.viewpager2.widget.ViewPager2.this.getCurrentItem() - 1 : androidx.viewpager2.widget.ViewPager2.this.getCurrentItem() + 1);
            return true;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void onRestorePendingState() {
            updatePageAccessibilityActions();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void onRvInitializeAccessibilityEvent(@androidx.annotation.NonNull android.view.accessibility.AccessibilityEvent accessibilityEvent) {
            accessibilityEvent.setSource(androidx.viewpager2.widget.ViewPager2.this);
            accessibilityEvent.setClassName(onGetAccessibilityClassName());
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void onSetLayoutDirection() {
            updatePageAccessibilityActions();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void onSetNewCurrentItem() {
            updatePageAccessibilityActions();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void onSetOrientation() {
            updatePageAccessibilityActions();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
        public void onSetUserInputEnabled() {
            updatePageAccessibilityActions();
        }

        public void setCurrentItemFromAccessibilityCommand(int i) {
            if (androidx.viewpager2.widget.ViewPager2.this.isUserInputEnabled()) {
                androidx.viewpager2.widget.ViewPager2.this.setCurrentItemInternal(i, true);
            }
        }

        public void updatePageAccessibilityActions() {
            int itemCount;
            androidx.viewpager2.widget.ViewPager2 viewPager2 = androidx.viewpager2.widget.ViewPager2.this;
            int i = android.R.id.accessibilityActionPageLeft;
            androidx.core.view.ViewCompat.removeAccessibilityAction(viewPager2, android.R.id.accessibilityActionPageLeft);
            androidx.core.view.ViewCompat.removeAccessibilityAction(viewPager2, android.R.id.accessibilityActionPageRight);
            androidx.core.view.ViewCompat.removeAccessibilityAction(viewPager2, android.R.id.accessibilityActionPageUp);
            androidx.core.view.ViewCompat.removeAccessibilityAction(viewPager2, android.R.id.accessibilityActionPageDown);
            if (androidx.viewpager2.widget.ViewPager2.this.getAdapter() == null || (itemCount = androidx.viewpager2.widget.ViewPager2.this.getAdapter().getItemCount()) == 0 || !androidx.viewpager2.widget.ViewPager2.this.isUserInputEnabled()) {
                return;
            }
            if (androidx.viewpager2.widget.ViewPager2.this.getOrientation() != 0) {
                if (androidx.viewpager2.widget.ViewPager2.this.mCurrentItem < itemCount - 1) {
                    androidx.core.view.ViewCompat.replaceAccessibilityAction(viewPager2, new androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(android.R.id.accessibilityActionPageDown, null), null, this.mActionPageForward);
                }
                if (androidx.viewpager2.widget.ViewPager2.this.mCurrentItem > 0) {
                    androidx.core.view.ViewCompat.replaceAccessibilityAction(viewPager2, new androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(android.R.id.accessibilityActionPageUp, null), null, this.mActionPageBackward);
                    return;
                }
                return;
            }
            boolean isRtl = androidx.viewpager2.widget.ViewPager2.this.isRtl();
            int i2 = isRtl ? android.R.id.accessibilityActionPageLeft : android.R.id.accessibilityActionPageRight;
            if (isRtl) {
                i = android.R.id.accessibilityActionPageRight;
            }
            if (androidx.viewpager2.widget.ViewPager2.this.mCurrentItem < itemCount - 1) {
                androidx.core.view.ViewCompat.replaceAccessibilityAction(viewPager2, new androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(i2, null), null, this.mActionPageForward);
            }
            if (androidx.viewpager2.widget.ViewPager2.this.mCurrentItem > 0) {
                androidx.core.view.ViewCompat.replaceAccessibilityAction(viewPager2, new androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat(i, null), null, this.mActionPageBackward);
            }
        }
    }

    public interface PageTransformer {
        void transformPage(@androidx.annotation.NonNull android.view.View view, float f);
    }

    public class PagerSnapHelperImpl extends androidx.recyclerview.widget.PagerSnapHelper {
        public PagerSnapHelperImpl() {
        }

        @Override // androidx.recyclerview.widget.PagerSnapHelper, androidx.recyclerview.widget.SnapHelper
        @androidx.annotation.Nullable
        public android.view.View findSnapView(androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager) {
            if (androidx.viewpager2.widget.ViewPager2.this.isFakeDragging()) {
                return null;
            }
            return super.findSnapView(layoutManager);
        }
    }

    public class RecyclerViewImpl extends androidx.recyclerview.widget.RecyclerView {
        public RecyclerViewImpl(@androidx.annotation.NonNull android.content.Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
        @androidx.annotation.RequiresApi(23)
        public java.lang.CharSequence getAccessibilityClassName() {
            return androidx.viewpager2.widget.ViewPager2.this.mAccessibilityProvider.handlesRvGetAccessibilityClassName() ? androidx.viewpager2.widget.ViewPager2.this.mAccessibilityProvider.onRvGetAccessibilityClassName() : super.getAccessibilityClassName();
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(@androidx.annotation.NonNull android.view.accessibility.AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setFromIndex(androidx.viewpager2.widget.ViewPager2.this.mCurrentItem);
            accessibilityEvent.setToIndex(androidx.viewpager2.widget.ViewPager2.this.mCurrentItem);
            androidx.viewpager2.widget.ViewPager2.this.mAccessibilityProvider.onRvInitializeAccessibilityEvent(accessibilityEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
        public boolean onInterceptTouchEvent(android.view.MotionEvent motionEvent) {
            return androidx.viewpager2.widget.ViewPager2.this.isUserInputEnabled() && super.onInterceptTouchEvent(motionEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
        @android.annotation.SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
            return androidx.viewpager2.widget.ViewPager2.this.isUserInputEnabled() && super.onTouchEvent(motionEvent);
        }
    }

    public static class SavedState extends android.view.View.BaseSavedState {
        public static final android.os.Parcelable.Creator<androidx.viewpager2.widget.ViewPager2.SavedState> CREATOR = new androidx.viewpager2.widget.ViewPager2.SavedState.AnonymousClass1();
        android.os.Parcelable mAdapterState;
        int mCurrentItem;
        int mRecyclerViewId;

        /* renamed from: androidx.viewpager2.widget.ViewPager2$SavedState$1, reason: invalid class name */
        public static class AnonymousClass1 implements android.os.Parcelable.ClassLoaderCreator<androidx.viewpager2.widget.ViewPager2.SavedState> {
            @Override // android.os.Parcelable.Creator
            public androidx.viewpager2.widget.ViewPager2.SavedState createFromParcel(android.os.Parcel parcel) {
                return createFromParcel(parcel, (java.lang.ClassLoader) null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public androidx.viewpager2.widget.ViewPager2.SavedState createFromParcel(android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
                return android.os.Build.VERSION.SDK_INT >= 24 ? new androidx.viewpager2.widget.ViewPager2.SavedState(parcel, classLoader) : new androidx.viewpager2.widget.ViewPager2.SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public androidx.viewpager2.widget.ViewPager2.SavedState[] newArray(int i) {
                return new androidx.viewpager2.widget.ViewPager2.SavedState[i];
            }
        }

        public SavedState(android.os.Parcel parcel) {
            super(parcel);
            readValues(parcel, null);
        }

        @androidx.annotation.RequiresApi(24)
        public SavedState(android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
            super(parcel, classLoader);
            readValues(parcel, classLoader);
        }

        public SavedState(android.os.Parcelable parcelable) {
            super(parcelable);
        }

        private void readValues(android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
            this.mRecyclerViewId = parcel.readInt();
            this.mCurrentItem = parcel.readInt();
            this.mAdapterState = parcel.readParcelable(classLoader);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.mRecyclerViewId);
            parcel.writeInt(this.mCurrentItem);
            parcel.writeParcelable(this.mAdapterState, i);
        }
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface ScrollState {
    }

    public static class SmoothScrollToPosition implements java.lang.Runnable {
        private final int mPosition;
        private final androidx.recyclerview.widget.RecyclerView mRecyclerView;

        public SmoothScrollToPosition(int i, androidx.recyclerview.widget.RecyclerView recyclerView) {
            this.mPosition = i;
            this.mRecyclerView = recyclerView;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.mRecyclerView.smoothScrollToPosition(this.mPosition);
        }
    }

    public ViewPager2(@androidx.annotation.NonNull android.content.Context context) {
        super(context);
        this.mTmpContainerRect = new android.graphics.Rect();
        this.mTmpChildRect = new android.graphics.Rect();
        this.mExternalPageChangeCallbacks = new androidx.viewpager2.widget.CompositeOnPageChangeCallback(3);
        this.mCurrentItemDirty = false;
        this.mCurrentItemDataSetChangeObserver = new androidx.viewpager2.widget.ViewPager2.AnonymousClass1();
        this.mPendingCurrentItem = -1;
        this.mSavedItemAnimator = null;
        this.mSavedItemAnimatorPresent = false;
        this.mUserInputEnabled = true;
        this.mOffscreenPageLimit = -1;
        initialize(context, null);
    }

    public ViewPager2(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTmpContainerRect = new android.graphics.Rect();
        this.mTmpChildRect = new android.graphics.Rect();
        this.mExternalPageChangeCallbacks = new androidx.viewpager2.widget.CompositeOnPageChangeCallback(3);
        this.mCurrentItemDirty = false;
        this.mCurrentItemDataSetChangeObserver = new androidx.viewpager2.widget.ViewPager2.AnonymousClass1();
        this.mPendingCurrentItem = -1;
        this.mSavedItemAnimator = null;
        this.mSavedItemAnimatorPresent = false;
        this.mUserInputEnabled = true;
        this.mOffscreenPageLimit = -1;
        initialize(context, attributeSet);
    }

    public ViewPager2(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTmpContainerRect = new android.graphics.Rect();
        this.mTmpChildRect = new android.graphics.Rect();
        this.mExternalPageChangeCallbacks = new androidx.viewpager2.widget.CompositeOnPageChangeCallback(3);
        this.mCurrentItemDirty = false;
        this.mCurrentItemDataSetChangeObserver = new androidx.viewpager2.widget.ViewPager2.AnonymousClass1();
        this.mPendingCurrentItem = -1;
        this.mSavedItemAnimator = null;
        this.mSavedItemAnimatorPresent = false;
        this.mUserInputEnabled = true;
        this.mOffscreenPageLimit = -1;
        initialize(context, attributeSet);
    }

    @androidx.annotation.RequiresApi(21)
    public ViewPager2(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mTmpContainerRect = new android.graphics.Rect();
        this.mTmpChildRect = new android.graphics.Rect();
        this.mExternalPageChangeCallbacks = new androidx.viewpager2.widget.CompositeOnPageChangeCallback(3);
        this.mCurrentItemDirty = false;
        this.mCurrentItemDataSetChangeObserver = new androidx.viewpager2.widget.ViewPager2.AnonymousClass1();
        this.mPendingCurrentItem = -1;
        this.mSavedItemAnimator = null;
        this.mSavedItemAnimatorPresent = false;
        this.mUserInputEnabled = true;
        this.mOffscreenPageLimit = -1;
        initialize(context, attributeSet);
    }

    private androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener enforceChildFillListener() {
        return new androidx.viewpager2.widget.ViewPager2.AnonymousClass4();
    }

    private void initialize(android.content.Context context, android.util.AttributeSet attributeSet) {
        this.mAccessibilityProvider = sFeatureEnhancedA11yEnabled ? new androidx.viewpager2.widget.ViewPager2.PageAwareAccessibilityProvider() : new androidx.viewpager2.widget.ViewPager2.BasicAccessibilityProvider();
        androidx.viewpager2.widget.ViewPager2.RecyclerViewImpl recyclerViewImpl = new androidx.viewpager2.widget.ViewPager2.RecyclerViewImpl(context);
        this.mRecyclerView = recyclerViewImpl;
        recyclerViewImpl.setId(androidx.core.view.ViewCompat.generateViewId());
        this.mRecyclerView.setDescendantFocusability(131072);
        androidx.viewpager2.widget.ViewPager2.LinearLayoutManagerImpl linearLayoutManagerImpl = new androidx.viewpager2.widget.ViewPager2.LinearLayoutManagerImpl(context);
        this.mLayoutManager = linearLayoutManagerImpl;
        this.mRecyclerView.setLayoutManager(linearLayoutManagerImpl);
        this.mRecyclerView.setScrollingTouchSlop(1);
        setOrientation(context, attributeSet);
        this.mRecyclerView.setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -1));
        this.mRecyclerView.addOnChildAttachStateChangeListener(enforceChildFillListener());
        androidx.viewpager2.widget.ScrollEventAdapter scrollEventAdapter = new androidx.viewpager2.widget.ScrollEventAdapter(this);
        this.mScrollEventAdapter = scrollEventAdapter;
        this.mFakeDragger = new androidx.viewpager2.widget.FakeDrag(this, scrollEventAdapter, this.mRecyclerView);
        androidx.viewpager2.widget.ViewPager2.PagerSnapHelperImpl pagerSnapHelperImpl = new androidx.viewpager2.widget.ViewPager2.PagerSnapHelperImpl();
        this.mPagerSnapHelper = pagerSnapHelperImpl;
        pagerSnapHelperImpl.attachToRecyclerView(this.mRecyclerView);
        this.mRecyclerView.addOnScrollListener(this.mScrollEventAdapter);
        androidx.viewpager2.widget.CompositeOnPageChangeCallback compositeOnPageChangeCallback = new androidx.viewpager2.widget.CompositeOnPageChangeCallback(3);
        this.mPageChangeEventDispatcher = compositeOnPageChangeCallback;
        this.mScrollEventAdapter.setOnPageChangeCallback(compositeOnPageChangeCallback);
        androidx.viewpager2.widget.ViewPager2.AnonymousClass2 anonymousClass2 = new androidx.viewpager2.widget.ViewPager2.AnonymousClass2();
        androidx.viewpager2.widget.ViewPager2.AnonymousClass3 anonymousClass3 = new androidx.viewpager2.widget.ViewPager2.AnonymousClass3();
        this.mPageChangeEventDispatcher.addOnPageChangeCallback(anonymousClass2);
        this.mPageChangeEventDispatcher.addOnPageChangeCallback(anonymousClass3);
        this.mAccessibilityProvider.onInitialize(this.mPageChangeEventDispatcher, this.mRecyclerView);
        this.mPageChangeEventDispatcher.addOnPageChangeCallback(this.mExternalPageChangeCallbacks);
        androidx.viewpager2.widget.PageTransformerAdapter pageTransformerAdapter = new androidx.viewpager2.widget.PageTransformerAdapter(this.mLayoutManager);
        this.mPageTransformerAdapter = pageTransformerAdapter;
        this.mPageChangeEventDispatcher.addOnPageChangeCallback(pageTransformerAdapter);
        androidx.recyclerview.widget.RecyclerView recyclerView = this.mRecyclerView;
        attachViewToParent(recyclerView, 0, recyclerView.getLayoutParams());
    }

    private void registerCurrentItemDataSetTracker(@androidx.annotation.Nullable androidx.recyclerview.widget.RecyclerView.Adapter<?> adapter) {
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.mCurrentItemDataSetChangeObserver);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void restorePendingState() {
        androidx.recyclerview.widget.RecyclerView.Adapter adapter;
        if (this.mPendingCurrentItem == -1 || (adapter = getAdapter()) == 0) {
            return;
        }
        android.os.Parcelable parcelable = this.mPendingAdapterState;
        if (parcelable != null) {
            if (adapter instanceof androidx.viewpager2.adapter.StatefulAdapter) {
                ((androidx.viewpager2.adapter.StatefulAdapter) adapter).restoreState(parcelable);
            }
            this.mPendingAdapterState = null;
        }
        int max = java.lang.Math.max(0, java.lang.Math.min(this.mPendingCurrentItem, adapter.getItemCount() - 1));
        this.mCurrentItem = max;
        this.mPendingCurrentItem = -1;
        this.mRecyclerView.scrollToPosition(max);
        this.mAccessibilityProvider.onRestorePendingState();
    }

    private void setOrientation(android.content.Context context, android.util.AttributeSet attributeSet) {
        int[] iArr = androidx.viewpager2.R.styleable.ViewPager2;
        android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, iArr, attributeSet, obtainStyledAttributes, 0, 0);
        }
        try {
            setOrientation(obtainStyledAttributes.getInt(androidx.viewpager2.R.styleable.ViewPager2_android_orientation, 0));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void unregisterCurrentItemDataSetTracker(@androidx.annotation.Nullable androidx.recyclerview.widget.RecyclerView.Adapter<?> adapter) {
        if (adapter != null) {
            adapter.unregisterAdapterDataObserver(this.mCurrentItemDataSetChangeObserver);
        }
    }

    public void addItemDecoration(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.ItemDecoration itemDecoration) {
        this.mRecyclerView.addItemDecoration(itemDecoration);
    }

    public void addItemDecoration(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.ItemDecoration itemDecoration, int i) {
        this.mRecyclerView.addItemDecoration(itemDecoration, i);
    }

    public boolean beginFakeDrag() {
        return this.mFakeDragger.beginFakeDrag();
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i) {
        return this.mRecyclerView.canScrollHorizontally(i);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i) {
        return this.mRecyclerView.canScrollVertically(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(android.util.SparseArray<android.os.Parcelable> sparseArray) {
        android.os.Parcelable parcelable = sparseArray.get(getId());
        if (parcelable instanceof androidx.viewpager2.widget.ViewPager2.SavedState) {
            int i = ((androidx.viewpager2.widget.ViewPager2.SavedState) parcelable).mRecyclerViewId;
            sparseArray.put(this.mRecyclerView.getId(), sparseArray.get(i));
            sparseArray.remove(i);
        }
        super.dispatchRestoreInstanceState(sparseArray);
        restorePendingState();
    }

    public boolean endFakeDrag() {
        return this.mFakeDragger.endFakeDrag();
    }

    public boolean fakeDragBy(@androidx.annotation.Px @android.annotation.SuppressLint({"SupportAnnotationUsage"}) float f) {
        return this.mFakeDragger.fakeDragBy(f);
    }

    @Override // android.view.ViewGroup, android.view.View
    @androidx.annotation.RequiresApi(23)
    public java.lang.CharSequence getAccessibilityClassName() {
        return this.mAccessibilityProvider.handlesGetAccessibilityClassName() ? this.mAccessibilityProvider.onGetAccessibilityClassName() : super.getAccessibilityClassName();
    }

    @androidx.annotation.Nullable
    public androidx.recyclerview.widget.RecyclerView.Adapter getAdapter() {
        return this.mRecyclerView.getAdapter();
    }

    public int getCurrentItem() {
        return this.mCurrentItem;
    }

    @androidx.annotation.NonNull
    public androidx.recyclerview.widget.RecyclerView.ItemDecoration getItemDecorationAt(int i) {
        return this.mRecyclerView.getItemDecorationAt(i);
    }

    public int getItemDecorationCount() {
        return this.mRecyclerView.getItemDecorationCount();
    }

    public int getOffscreenPageLimit() {
        return this.mOffscreenPageLimit;
    }

    public int getOrientation() {
        return this.mLayoutManager.getOrientation();
    }

    public int getPageSize() {
        int height;
        int paddingBottom;
        androidx.recyclerview.widget.RecyclerView recyclerView = this.mRecyclerView;
        if (getOrientation() == 0) {
            height = recyclerView.getWidth() - recyclerView.getPaddingLeft();
            paddingBottom = recyclerView.getPaddingRight();
        } else {
            height = recyclerView.getHeight() - recyclerView.getPaddingTop();
            paddingBottom = recyclerView.getPaddingBottom();
        }
        return height - paddingBottom;
    }

    public int getScrollState() {
        return this.mScrollEventAdapter.getScrollState();
    }

    public void invalidateItemDecorations() {
        this.mRecyclerView.invalidateItemDecorations();
    }

    public boolean isFakeDragging() {
        return this.mFakeDragger.isFakeDragging();
    }

    public boolean isRtl() {
        return this.mLayoutManager.getLayoutDirection() == 1;
    }

    public boolean isUserInputEnabled() {
        return this.mUserInputEnabled;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        this.mAccessibilityProvider.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = this.mRecyclerView.getMeasuredWidth();
        int measuredHeight = this.mRecyclerView.getMeasuredHeight();
        this.mTmpContainerRect.left = getPaddingLeft();
        this.mTmpContainerRect.right = (i3 - i) - getPaddingRight();
        this.mTmpContainerRect.top = getPaddingTop();
        this.mTmpContainerRect.bottom = (i4 - i2) - getPaddingBottom();
        android.view.Gravity.apply(com.google.android.material.badge.BadgeDrawable.TOP_START, measuredWidth, measuredHeight, this.mTmpContainerRect, this.mTmpChildRect);
        androidx.recyclerview.widget.RecyclerView recyclerView = this.mRecyclerView;
        android.graphics.Rect rect = this.mTmpChildRect;
        recyclerView.layout(rect.left, rect.top, rect.right, rect.bottom);
        if (this.mCurrentItemDirty) {
            updateCurrentItem();
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        measureChild(this.mRecyclerView, i, i2);
        int measuredWidth = this.mRecyclerView.getMeasuredWidth();
        int measuredHeight = this.mRecyclerView.getMeasuredHeight();
        int measuredState = this.mRecyclerView.getMeasuredState();
        int paddingLeft = measuredWidth + getPaddingLeft() + getPaddingRight();
        int paddingTop = measuredHeight + getPaddingTop() + getPaddingBottom();
        setMeasuredDimension(android.view.View.resolveSizeAndState(java.lang.Math.max(paddingLeft, getSuggestedMinimumWidth()), i, measuredState), android.view.View.resolveSizeAndState(java.lang.Math.max(paddingTop, getSuggestedMinimumHeight()), i2, measuredState << 16));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(android.os.Parcelable parcelable) {
        if (!(parcelable instanceof androidx.viewpager2.widget.ViewPager2.SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        androidx.viewpager2.widget.ViewPager2.SavedState savedState = (androidx.viewpager2.widget.ViewPager2.SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mPendingCurrentItem = savedState.mCurrentItem;
        this.mPendingAdapterState = savedState.mAdapterState;
    }

    @Override // android.view.View
    @androidx.annotation.Nullable
    public android.os.Parcelable onSaveInstanceState() {
        androidx.viewpager2.widget.ViewPager2.SavedState savedState = new androidx.viewpager2.widget.ViewPager2.SavedState(super.onSaveInstanceState());
        savedState.mRecyclerViewId = this.mRecyclerView.getId();
        int i = this.mPendingCurrentItem;
        if (i == -1) {
            i = this.mCurrentItem;
        }
        savedState.mCurrentItem = i;
        android.os.Parcelable parcelable = this.mPendingAdapterState;
        if (parcelable != null) {
            savedState.mAdapterState = parcelable;
        } else {
            java.lang.Object adapter = this.mRecyclerView.getAdapter();
            if (adapter instanceof androidx.viewpager2.adapter.StatefulAdapter) {
                savedState.mAdapterState = ((androidx.viewpager2.adapter.StatefulAdapter) adapter).saveState();
            }
        }
        return savedState;
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(android.view.View view) {
        throw new java.lang.IllegalStateException(androidx.viewpager2.widget.ViewPager2.class.getSimpleName() + " does not support direct child views");
    }

    @Override // android.view.View
    @androidx.annotation.RequiresApi(16)
    public boolean performAccessibilityAction(int i, android.os.Bundle bundle) {
        return this.mAccessibilityProvider.handlesPerformAccessibilityAction(i, bundle) ? this.mAccessibilityProvider.onPerformAccessibilityAction(i, bundle) : super.performAccessibilityAction(i, bundle);
    }

    public void registerOnPageChangeCallback(@androidx.annotation.NonNull androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.mExternalPageChangeCallbacks.addOnPageChangeCallback(onPageChangeCallback);
    }

    public void removeItemDecoration(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.ItemDecoration itemDecoration) {
        this.mRecyclerView.removeItemDecoration(itemDecoration);
    }

    public void removeItemDecorationAt(int i) {
        this.mRecyclerView.removeItemDecorationAt(i);
    }

    public void requestTransform() {
        if (this.mPageTransformerAdapter.getPageTransformer() == null) {
            return;
        }
        double relativeScrollPosition = this.mScrollEventAdapter.getRelativeScrollPosition();
        int i = (int) relativeScrollPosition;
        float f = (float) (relativeScrollPosition - i);
        this.mPageTransformerAdapter.onPageScrolled(i, f, java.lang.Math.round(getPageSize() * f));
    }

    public void setAdapter(@androidx.annotation.Nullable androidx.recyclerview.widget.RecyclerView.Adapter adapter) {
        androidx.recyclerview.widget.RecyclerView.Adapter adapter2 = this.mRecyclerView.getAdapter();
        this.mAccessibilityProvider.onDetachAdapter(adapter2);
        unregisterCurrentItemDataSetTracker(adapter2);
        this.mRecyclerView.setAdapter(adapter);
        this.mCurrentItem = 0;
        restorePendingState();
        this.mAccessibilityProvider.onAttachAdapter(adapter);
        registerCurrentItemDataSetTracker(adapter);
    }

    public void setCurrentItem(int i) {
        setCurrentItem(i, true);
    }

    public void setCurrentItem(int i, boolean z) {
        if (isFakeDragging()) {
            throw new java.lang.IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
        }
        setCurrentItemInternal(i, z);
    }

    public void setCurrentItemInternal(int i, boolean z) {
        androidx.recyclerview.widget.RecyclerView.Adapter adapter = getAdapter();
        if (adapter == null) {
            if (this.mPendingCurrentItem != -1) {
                this.mPendingCurrentItem = java.lang.Math.max(i, 0);
                return;
            }
            return;
        }
        if (adapter.getItemCount() <= 0) {
            return;
        }
        int min = java.lang.Math.min(java.lang.Math.max(i, 0), adapter.getItemCount() - 1);
        if (min == this.mCurrentItem && this.mScrollEventAdapter.isIdle()) {
            return;
        }
        int i2 = this.mCurrentItem;
        if (min == i2 && z) {
            return;
        }
        double d = i2;
        this.mCurrentItem = min;
        this.mAccessibilityProvider.onSetNewCurrentItem();
        if (!this.mScrollEventAdapter.isIdle()) {
            d = this.mScrollEventAdapter.getRelativeScrollPosition();
        }
        this.mScrollEventAdapter.notifyProgrammaticScroll(min, z);
        if (!z) {
            this.mRecyclerView.scrollToPosition(min);
            return;
        }
        double d2 = min;
        if (java.lang.Math.abs(d2 - d) <= 3.0d) {
            this.mRecyclerView.smoothScrollToPosition(min);
            return;
        }
        this.mRecyclerView.scrollToPosition(d2 > d ? min - 3 : min + 3);
        androidx.recyclerview.widget.RecyclerView recyclerView = this.mRecyclerView;
        recyclerView.post(new androidx.viewpager2.widget.ViewPager2.SmoothScrollToPosition(min, recyclerView));
    }

    @Override // android.view.View
    @androidx.annotation.RequiresApi(17)
    public void setLayoutDirection(int i) {
        super.setLayoutDirection(i);
        this.mAccessibilityProvider.onSetLayoutDirection();
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 1 && i != -1) {
            throw new java.lang.IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
        }
        this.mOffscreenPageLimit = i;
        this.mRecyclerView.requestLayout();
    }

    public void setOrientation(int i) {
        this.mLayoutManager.setOrientation(i);
        this.mAccessibilityProvider.onSetOrientation();
    }

    public void setPageTransformer(@androidx.annotation.Nullable androidx.viewpager2.widget.ViewPager2.PageTransformer pageTransformer) {
        if (pageTransformer != null) {
            if (!this.mSavedItemAnimatorPresent) {
                this.mSavedItemAnimator = this.mRecyclerView.getItemAnimator();
                this.mSavedItemAnimatorPresent = true;
            }
            this.mRecyclerView.setItemAnimator(null);
        } else if (this.mSavedItemAnimatorPresent) {
            this.mRecyclerView.setItemAnimator(this.mSavedItemAnimator);
            this.mSavedItemAnimator = null;
            this.mSavedItemAnimatorPresent = false;
        }
        if (pageTransformer == this.mPageTransformerAdapter.getPageTransformer()) {
            return;
        }
        this.mPageTransformerAdapter.setPageTransformer(pageTransformer);
        requestTransform();
    }

    public void setUserInputEnabled(boolean z) {
        this.mUserInputEnabled = z;
        this.mAccessibilityProvider.onSetUserInputEnabled();
    }

    public void snapToPage() {
        android.view.View findSnapView = this.mPagerSnapHelper.findSnapView(this.mLayoutManager);
        if (findSnapView == null) {
            return;
        }
        int[] calculateDistanceToFinalSnap = this.mPagerSnapHelper.calculateDistanceToFinalSnap(this.mLayoutManager, findSnapView);
        int i = calculateDistanceToFinalSnap[0];
        if (i == 0 && calculateDistanceToFinalSnap[1] == 0) {
            return;
        }
        this.mRecyclerView.smoothScrollBy(i, calculateDistanceToFinalSnap[1]);
    }

    public void unregisterOnPageChangeCallback(@androidx.annotation.NonNull androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.mExternalPageChangeCallbacks.removeOnPageChangeCallback(onPageChangeCallback);
    }

    public void updateCurrentItem() {
        androidx.recyclerview.widget.PagerSnapHelper pagerSnapHelper = this.mPagerSnapHelper;
        if (pagerSnapHelper == null) {
            throw new java.lang.IllegalStateException("Design assumption violated.");
        }
        android.view.View findSnapView = pagerSnapHelper.findSnapView(this.mLayoutManager);
        if (findSnapView == null) {
            return;
        }
        int position = this.mLayoutManager.getPosition(findSnapView);
        if (position != this.mCurrentItem && getScrollState() == 0) {
            this.mPageChangeEventDispatcher.onPageSelected(position);
        }
        this.mCurrentItemDirty = false;
    }
}
