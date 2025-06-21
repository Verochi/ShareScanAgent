package androidx.viewpager2.adapter;

/* loaded from: classes.dex */
public abstract class FragmentStateAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<androidx.viewpager2.adapter.FragmentViewHolder> implements androidx.viewpager2.adapter.StatefulAdapter {
    private static final long GRACE_WINDOW_TIME_MS = 10000;
    private static final java.lang.String KEY_PREFIX_FRAGMENT = "f#";
    private static final java.lang.String KEY_PREFIX_STATE = "s#";
    final androidx.fragment.app.FragmentManager mFragmentManager;
    private androidx.viewpager2.adapter.FragmentStateAdapter.FragmentMaxLifecycleEnforcer mFragmentMaxLifecycleEnforcer;
    final androidx.collection.LongSparseArray<androidx.fragment.app.Fragment> mFragments;
    private boolean mHasStaleFragments;
    boolean mIsInGracePeriod;
    private final androidx.collection.LongSparseArray<java.lang.Integer> mItemIdToViewHolder;
    final androidx.lifecycle.Lifecycle mLifecycle;
    private final androidx.collection.LongSparseArray<androidx.fragment.app.Fragment.SavedState> mSavedStates;

    /* renamed from: androidx.viewpager2.adapter.FragmentStateAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnLayoutChangeListener {
        final /* synthetic */ android.widget.FrameLayout val$container;
        final /* synthetic */ androidx.viewpager2.adapter.FragmentViewHolder val$holder;

        public AnonymousClass1(android.widget.FrameLayout frameLayout, androidx.viewpager2.adapter.FragmentViewHolder fragmentViewHolder) {
            this.val$container = frameLayout;
            this.val$holder = fragmentViewHolder;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(android.view.View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            if (this.val$container.getParent() != null) {
                this.val$container.removeOnLayoutChangeListener(this);
                androidx.viewpager2.adapter.FragmentStateAdapter.this.placeFragmentInViewHolder(this.val$holder);
            }
        }
    }

    /* renamed from: androidx.viewpager2.adapter.FragmentStateAdapter$2, reason: invalid class name */
    public class AnonymousClass2 implements androidx.lifecycle.LifecycleEventObserver {
        final /* synthetic */ androidx.viewpager2.adapter.FragmentViewHolder val$holder;

        public AnonymousClass2(androidx.viewpager2.adapter.FragmentViewHolder fragmentViewHolder) {
            this.val$holder = fragmentViewHolder;
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(@androidx.annotation.NonNull androidx.lifecycle.LifecycleOwner lifecycleOwner, @androidx.annotation.NonNull androidx.lifecycle.Lifecycle.Event event) {
            if (androidx.viewpager2.adapter.FragmentStateAdapter.this.shouldDelayFragmentTransactions()) {
                return;
            }
            lifecycleOwner.getLifecycle().removeObserver(this);
            if (androidx.core.view.ViewCompat.isAttachedToWindow(this.val$holder.getContainer())) {
                androidx.viewpager2.adapter.FragmentStateAdapter.this.placeFragmentInViewHolder(this.val$holder);
            }
        }
    }

    /* renamed from: androidx.viewpager2.adapter.FragmentStateAdapter$3, reason: invalid class name */
    public class AnonymousClass3 extends androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks {
        final /* synthetic */ android.widget.FrameLayout val$container;
        final /* synthetic */ androidx.fragment.app.Fragment val$fragment;

        public AnonymousClass3(androidx.fragment.app.Fragment fragment, android.widget.FrameLayout frameLayout) {
            this.val$fragment = fragment;
            this.val$container = frameLayout;
        }

        @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
        public void onFragmentViewCreated(@androidx.annotation.NonNull androidx.fragment.app.FragmentManager fragmentManager, @androidx.annotation.NonNull androidx.fragment.app.Fragment fragment, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.Nullable android.os.Bundle bundle) {
            if (fragment == this.val$fragment) {
                fragmentManager.unregisterFragmentLifecycleCallbacks(this);
                androidx.viewpager2.adapter.FragmentStateAdapter.this.addViewToContainer(view, this.val$container);
            }
        }
    }

    /* renamed from: androidx.viewpager2.adapter.FragmentStateAdapter$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        public AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public void run() {
            androidx.viewpager2.adapter.FragmentStateAdapter fragmentStateAdapter = androidx.viewpager2.adapter.FragmentStateAdapter.this;
            fragmentStateAdapter.mIsInGracePeriod = false;
            fragmentStateAdapter.gcFragments();
        }
    }

    /* renamed from: androidx.viewpager2.adapter.FragmentStateAdapter$5, reason: invalid class name */
    public class AnonymousClass5 implements androidx.lifecycle.LifecycleEventObserver {
        final /* synthetic */ android.os.Handler val$handler;
        final /* synthetic */ java.lang.Runnable val$runnable;

        public AnonymousClass5(android.os.Handler handler, java.lang.Runnable runnable) {
            this.val$handler = handler;
            this.val$runnable = runnable;
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(@androidx.annotation.NonNull androidx.lifecycle.LifecycleOwner lifecycleOwner, @androidx.annotation.NonNull androidx.lifecycle.Lifecycle.Event event) {
            if (event == androidx.lifecycle.Lifecycle.Event.ON_DESTROY) {
                this.val$handler.removeCallbacks(this.val$runnable);
                lifecycleOwner.getLifecycle().removeObserver(this);
            }
        }
    }

    public static abstract class DataSetChangeObserver extends androidx.recyclerview.widget.RecyclerView.AdapterDataObserver {
        private DataSetChangeObserver() {
        }

        public /* synthetic */ DataSetChangeObserver(androidx.viewpager2.adapter.FragmentStateAdapter.AnonymousClass1 anonymousClass1) {
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

    public class FragmentMaxLifecycleEnforcer {
        private androidx.recyclerview.widget.RecyclerView.AdapterDataObserver mDataObserver;
        private androidx.lifecycle.LifecycleEventObserver mLifecycleObserver;
        private androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback mPageChangeCallback;
        private long mPrimaryItemId = -1;
        private androidx.viewpager2.widget.ViewPager2 mViewPager;

        /* renamed from: androidx.viewpager2.adapter.FragmentStateAdapter$FragmentMaxLifecycleEnforcer$1, reason: invalid class name */
        public class AnonymousClass1 extends androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback {
            public AnonymousClass1() {
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrollStateChanged(int i) {
                androidx.viewpager2.adapter.FragmentStateAdapter.FragmentMaxLifecycleEnforcer.this.updateFragmentMaxLifecycle(false);
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i) {
                androidx.viewpager2.adapter.FragmentStateAdapter.FragmentMaxLifecycleEnforcer.this.updateFragmentMaxLifecycle(false);
            }
        }

        /* renamed from: androidx.viewpager2.adapter.FragmentStateAdapter$FragmentMaxLifecycleEnforcer$2, reason: invalid class name */
        public class AnonymousClass2 extends androidx.viewpager2.adapter.FragmentStateAdapter.DataSetChangeObserver {
            public AnonymousClass2() {
                super(null);
            }

            @Override // androidx.viewpager2.adapter.FragmentStateAdapter.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                androidx.viewpager2.adapter.FragmentStateAdapter.FragmentMaxLifecycleEnforcer.this.updateFragmentMaxLifecycle(true);
            }
        }

        /* renamed from: androidx.viewpager2.adapter.FragmentStateAdapter$FragmentMaxLifecycleEnforcer$3, reason: invalid class name */
        public class AnonymousClass3 implements androidx.lifecycle.LifecycleEventObserver {
            public AnonymousClass3() {
            }

            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(@androidx.annotation.NonNull androidx.lifecycle.LifecycleOwner lifecycleOwner, @androidx.annotation.NonNull androidx.lifecycle.Lifecycle.Event event) {
                androidx.viewpager2.adapter.FragmentStateAdapter.FragmentMaxLifecycleEnforcer.this.updateFragmentMaxLifecycle(false);
            }
        }

        public FragmentMaxLifecycleEnforcer() {
        }

        @androidx.annotation.NonNull
        private androidx.viewpager2.widget.ViewPager2 inferViewPager(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView) {
            android.view.ViewParent parent = recyclerView.getParent();
            if (parent instanceof androidx.viewpager2.widget.ViewPager2) {
                return (androidx.viewpager2.widget.ViewPager2) parent;
            }
            throw new java.lang.IllegalStateException("Expected ViewPager2 instance. Got: " + parent);
        }

        public void register(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView) {
            this.mViewPager = inferViewPager(recyclerView);
            androidx.viewpager2.adapter.FragmentStateAdapter.FragmentMaxLifecycleEnforcer.AnonymousClass1 anonymousClass1 = new androidx.viewpager2.adapter.FragmentStateAdapter.FragmentMaxLifecycleEnforcer.AnonymousClass1();
            this.mPageChangeCallback = anonymousClass1;
            this.mViewPager.registerOnPageChangeCallback(anonymousClass1);
            androidx.viewpager2.adapter.FragmentStateAdapter.FragmentMaxLifecycleEnforcer.AnonymousClass2 anonymousClass2 = new androidx.viewpager2.adapter.FragmentStateAdapter.FragmentMaxLifecycleEnforcer.AnonymousClass2();
            this.mDataObserver = anonymousClass2;
            androidx.viewpager2.adapter.FragmentStateAdapter.this.registerAdapterDataObserver(anonymousClass2);
            androidx.viewpager2.adapter.FragmentStateAdapter.FragmentMaxLifecycleEnforcer.AnonymousClass3 anonymousClass3 = new androidx.viewpager2.adapter.FragmentStateAdapter.FragmentMaxLifecycleEnforcer.AnonymousClass3();
            this.mLifecycleObserver = anonymousClass3;
            androidx.viewpager2.adapter.FragmentStateAdapter.this.mLifecycle.addObserver(anonymousClass3);
        }

        public void unregister(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView) {
            inferViewPager(recyclerView).unregisterOnPageChangeCallback(this.mPageChangeCallback);
            androidx.viewpager2.adapter.FragmentStateAdapter.this.unregisterAdapterDataObserver(this.mDataObserver);
            androidx.viewpager2.adapter.FragmentStateAdapter.this.mLifecycle.removeObserver(this.mLifecycleObserver);
            this.mViewPager = null;
        }

        public void updateFragmentMaxLifecycle(boolean z) {
            int currentItem;
            androidx.fragment.app.Fragment fragment;
            if (androidx.viewpager2.adapter.FragmentStateAdapter.this.shouldDelayFragmentTransactions() || this.mViewPager.getScrollState() != 0 || androidx.viewpager2.adapter.FragmentStateAdapter.this.mFragments.isEmpty() || androidx.viewpager2.adapter.FragmentStateAdapter.this.getItemCount() == 0 || (currentItem = this.mViewPager.getCurrentItem()) >= androidx.viewpager2.adapter.FragmentStateAdapter.this.getItemCount()) {
                return;
            }
            long itemId = androidx.viewpager2.adapter.FragmentStateAdapter.this.getItemId(currentItem);
            if ((itemId != this.mPrimaryItemId || z) && (fragment = androidx.viewpager2.adapter.FragmentStateAdapter.this.mFragments.get(itemId)) != null && fragment.isAdded()) {
                this.mPrimaryItemId = itemId;
                androidx.fragment.app.FragmentTransaction beginTransaction = androidx.viewpager2.adapter.FragmentStateAdapter.this.mFragmentManager.beginTransaction();
                androidx.fragment.app.Fragment fragment2 = null;
                for (int i = 0; i < androidx.viewpager2.adapter.FragmentStateAdapter.this.mFragments.size(); i++) {
                    long keyAt = androidx.viewpager2.adapter.FragmentStateAdapter.this.mFragments.keyAt(i);
                    androidx.fragment.app.Fragment valueAt = androidx.viewpager2.adapter.FragmentStateAdapter.this.mFragments.valueAt(i);
                    if (valueAt.isAdded()) {
                        if (keyAt != this.mPrimaryItemId) {
                            beginTransaction.setMaxLifecycle(valueAt, androidx.lifecycle.Lifecycle.State.STARTED);
                        } else {
                            fragment2 = valueAt;
                        }
                        valueAt.setMenuVisibility(keyAt == this.mPrimaryItemId);
                    }
                }
                if (fragment2 != null) {
                    beginTransaction.setMaxLifecycle(fragment2, androidx.lifecycle.Lifecycle.State.RESUMED);
                }
                if (beginTransaction.isEmpty()) {
                    return;
                }
                beginTransaction.commitNow();
            }
        }
    }

    public FragmentStateAdapter(@androidx.annotation.NonNull androidx.fragment.app.Fragment fragment) {
        this(fragment.getChildFragmentManager(), fragment.getLifecycle());
    }

    public FragmentStateAdapter(@androidx.annotation.NonNull androidx.fragment.app.FragmentActivity fragmentActivity) {
        this(fragmentActivity.getSupportFragmentManager(), fragmentActivity.getLifecycle());
    }

    public FragmentStateAdapter(@androidx.annotation.NonNull androidx.fragment.app.FragmentManager fragmentManager, @androidx.annotation.NonNull androidx.lifecycle.Lifecycle lifecycle) {
        this.mFragments = new androidx.collection.LongSparseArray<>();
        this.mSavedStates = new androidx.collection.LongSparseArray<>();
        this.mItemIdToViewHolder = new androidx.collection.LongSparseArray<>();
        this.mIsInGracePeriod = false;
        this.mHasStaleFragments = false;
        this.mFragmentManager = fragmentManager;
        this.mLifecycle = lifecycle;
        super.setHasStableIds(true);
    }

    @androidx.annotation.NonNull
    private static java.lang.String createKey(@androidx.annotation.NonNull java.lang.String str, long j) {
        return str + j;
    }

    private void ensureFragment(int i) {
        long itemId = getItemId(i);
        if (this.mFragments.containsKey(itemId)) {
            return;
        }
        androidx.fragment.app.Fragment createFragment = createFragment(i);
        createFragment.setInitialSavedState(this.mSavedStates.get(itemId));
        this.mFragments.put(itemId, createFragment);
    }

    private boolean isFragmentViewBound(long j) {
        android.view.View view;
        if (this.mItemIdToViewHolder.containsKey(j)) {
            return true;
        }
        androidx.fragment.app.Fragment fragment = this.mFragments.get(j);
        return (fragment == null || (view = fragment.getView()) == null || view.getParent() == null) ? false : true;
    }

    private static boolean isValidKey(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull java.lang.String str2) {
        return str.startsWith(str2) && str.length() > str2.length();
    }

    private java.lang.Long itemForViewHolder(int i) {
        java.lang.Long l = null;
        for (int i2 = 0; i2 < this.mItemIdToViewHolder.size(); i2++) {
            if (this.mItemIdToViewHolder.valueAt(i2).intValue() == i) {
                if (l != null) {
                    throw new java.lang.IllegalStateException("Design assumption violated: a ViewHolder can only be bound to one item at a time.");
                }
                l = java.lang.Long.valueOf(this.mItemIdToViewHolder.keyAt(i2));
            }
        }
        return l;
    }

    private static long parseIdFromKey(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull java.lang.String str2) {
        return java.lang.Long.parseLong(str.substring(str2.length()));
    }

    private void removeFragment(long j) {
        android.view.ViewParent parent;
        androidx.fragment.app.Fragment fragment = this.mFragments.get(j);
        if (fragment == null) {
            return;
        }
        if (fragment.getView() != null && (parent = fragment.getView().getParent()) != null) {
            ((android.widget.FrameLayout) parent).removeAllViews();
        }
        if (!containsItem(j)) {
            this.mSavedStates.remove(j);
        }
        if (!fragment.isAdded()) {
            this.mFragments.remove(j);
            return;
        }
        if (shouldDelayFragmentTransactions()) {
            this.mHasStaleFragments = true;
            return;
        }
        if (fragment.isAdded() && containsItem(j)) {
            this.mSavedStates.put(j, this.mFragmentManager.saveFragmentInstanceState(fragment));
        }
        this.mFragmentManager.beginTransaction().remove(fragment).commitNow();
        this.mFragments.remove(j);
    }

    private void scheduleGracePeriodEnd() {
        android.os.Handler handler = new android.os.Handler(android.os.Looper.getMainLooper());
        androidx.viewpager2.adapter.FragmentStateAdapter.AnonymousClass4 anonymousClass4 = new androidx.viewpager2.adapter.FragmentStateAdapter.AnonymousClass4();
        this.mLifecycle.addObserver(new androidx.viewpager2.adapter.FragmentStateAdapter.AnonymousClass5(handler, anonymousClass4));
        handler.postDelayed(anonymousClass4, 10000L);
    }

    private void scheduleViewAttach(androidx.fragment.app.Fragment fragment, @androidx.annotation.NonNull android.widget.FrameLayout frameLayout) {
        this.mFragmentManager.registerFragmentLifecycleCallbacks(new androidx.viewpager2.adapter.FragmentStateAdapter.AnonymousClass3(fragment, frameLayout), false);
    }

    public void addViewToContainer(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.widget.FrameLayout frameLayout) {
        if (frameLayout.getChildCount() > 1) {
            throw new java.lang.IllegalStateException("Design assumption violated.");
        }
        if (view.getParent() == frameLayout) {
            return;
        }
        if (frameLayout.getChildCount() > 0) {
            frameLayout.removeAllViews();
        }
        if (view.getParent() != null) {
            ((android.view.ViewGroup) view.getParent()).removeView(view);
        }
        frameLayout.addView(view);
    }

    public boolean containsItem(long j) {
        return j >= 0 && j < ((long) getItemCount());
    }

    @androidx.annotation.NonNull
    public abstract androidx.fragment.app.Fragment createFragment(int i);

    public void gcFragments() {
        if (!this.mHasStaleFragments || shouldDelayFragmentTransactions()) {
            return;
        }
        androidx.collection.ArraySet arraySet = new androidx.collection.ArraySet();
        for (int i = 0; i < this.mFragments.size(); i++) {
            long keyAt = this.mFragments.keyAt(i);
            if (!containsItem(keyAt)) {
                arraySet.add(java.lang.Long.valueOf(keyAt));
                this.mItemIdToViewHolder.remove(keyAt);
            }
        }
        if (!this.mIsInGracePeriod) {
            this.mHasStaleFragments = false;
            for (int i2 = 0; i2 < this.mFragments.size(); i2++) {
                long keyAt2 = this.mFragments.keyAt(i2);
                if (!isFragmentViewBound(keyAt2)) {
                    arraySet.add(java.lang.Long.valueOf(keyAt2));
                }
            }
        }
        java.util.Iterator<E> it = arraySet.iterator();
        while (it.hasNext()) {
            removeFragment(((java.lang.Long) it.next()).longValue());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @androidx.annotation.CallSuper
    public void onAttachedToRecyclerView(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView) {
        androidx.core.util.Preconditions.checkArgument(this.mFragmentMaxLifecycleEnforcer == null);
        androidx.viewpager2.adapter.FragmentStateAdapter.FragmentMaxLifecycleEnforcer fragmentMaxLifecycleEnforcer = new androidx.viewpager2.adapter.FragmentStateAdapter.FragmentMaxLifecycleEnforcer();
        this.mFragmentMaxLifecycleEnforcer = fragmentMaxLifecycleEnforcer;
        fragmentMaxLifecycleEnforcer.register(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(@androidx.annotation.NonNull androidx.viewpager2.adapter.FragmentViewHolder fragmentViewHolder, int i) {
        long itemId = fragmentViewHolder.getItemId();
        int id = fragmentViewHolder.getContainer().getId();
        java.lang.Long itemForViewHolder = itemForViewHolder(id);
        if (itemForViewHolder != null && itemForViewHolder.longValue() != itemId) {
            removeFragment(itemForViewHolder.longValue());
            this.mItemIdToViewHolder.remove(itemForViewHolder.longValue());
        }
        this.mItemIdToViewHolder.put(itemId, java.lang.Integer.valueOf(id));
        ensureFragment(i);
        android.widget.FrameLayout container = fragmentViewHolder.getContainer();
        if (androidx.core.view.ViewCompat.isAttachedToWindow(container)) {
            if (container.getParent() != null) {
                throw new java.lang.IllegalStateException("Design assumption violated.");
            }
            container.addOnLayoutChangeListener(new androidx.viewpager2.adapter.FragmentStateAdapter.AnonymousClass1(container, fragmentViewHolder));
        }
        gcFragments();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @androidx.annotation.NonNull
    public final androidx.viewpager2.adapter.FragmentViewHolder onCreateViewHolder(@androidx.annotation.NonNull android.view.ViewGroup viewGroup, int i) {
        return androidx.viewpager2.adapter.FragmentViewHolder.create(viewGroup);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @androidx.annotation.CallSuper
    public void onDetachedFromRecyclerView(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView) {
        this.mFragmentMaxLifecycleEnforcer.unregister(recyclerView);
        this.mFragmentMaxLifecycleEnforcer = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final boolean onFailedToRecycleView(@androidx.annotation.NonNull androidx.viewpager2.adapter.FragmentViewHolder fragmentViewHolder) {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(@androidx.annotation.NonNull androidx.viewpager2.adapter.FragmentViewHolder fragmentViewHolder) {
        placeFragmentInViewHolder(fragmentViewHolder);
        gcFragments();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewRecycled(@androidx.annotation.NonNull androidx.viewpager2.adapter.FragmentViewHolder fragmentViewHolder) {
        java.lang.Long itemForViewHolder = itemForViewHolder(fragmentViewHolder.getContainer().getId());
        if (itemForViewHolder != null) {
            removeFragment(itemForViewHolder.longValue());
            this.mItemIdToViewHolder.remove(itemForViewHolder.longValue());
        }
    }

    public void placeFragmentInViewHolder(@androidx.annotation.NonNull androidx.viewpager2.adapter.FragmentViewHolder fragmentViewHolder) {
        androidx.fragment.app.Fragment fragment = this.mFragments.get(fragmentViewHolder.getItemId());
        if (fragment == null) {
            throw new java.lang.IllegalStateException("Design assumption violated.");
        }
        android.widget.FrameLayout container = fragmentViewHolder.getContainer();
        android.view.View view = fragment.getView();
        if (!fragment.isAdded() && view != null) {
            throw new java.lang.IllegalStateException("Design assumption violated.");
        }
        if (fragment.isAdded() && view == null) {
            scheduleViewAttach(fragment, container);
            return;
        }
        if (fragment.isAdded() && view.getParent() != null) {
            if (view.getParent() != container) {
                addViewToContainer(view, container);
                return;
            }
            return;
        }
        if (fragment.isAdded()) {
            addViewToContainer(view, container);
            return;
        }
        if (shouldDelayFragmentTransactions()) {
            if (this.mFragmentManager.isDestroyed()) {
                return;
            }
            this.mLifecycle.addObserver(new androidx.viewpager2.adapter.FragmentStateAdapter.AnonymousClass2(fragmentViewHolder));
            return;
        }
        scheduleViewAttach(fragment, container);
        this.mFragmentManager.beginTransaction().add(fragment, "f" + fragmentViewHolder.getItemId()).setMaxLifecycle(fragment, androidx.lifecycle.Lifecycle.State.STARTED).commitNow();
        this.mFragmentMaxLifecycleEnforcer.updateFragmentMaxLifecycle(false);
    }

    @Override // androidx.viewpager2.adapter.StatefulAdapter
    public final void restoreState(@androidx.annotation.NonNull android.os.Parcelable parcelable) {
        if (!this.mSavedStates.isEmpty() || !this.mFragments.isEmpty()) {
            throw new java.lang.IllegalStateException("Expected the adapter to be 'fresh' while restoring state.");
        }
        android.os.Bundle bundle = (android.os.Bundle) parcelable;
        if (bundle.getClassLoader() == null) {
            bundle.setClassLoader(getClass().getClassLoader());
        }
        for (java.lang.String str : bundle.keySet()) {
            if (isValidKey(str, KEY_PREFIX_FRAGMENT)) {
                this.mFragments.put(parseIdFromKey(str, KEY_PREFIX_FRAGMENT), this.mFragmentManager.getFragment(bundle, str));
            } else {
                if (!isValidKey(str, KEY_PREFIX_STATE)) {
                    throw new java.lang.IllegalArgumentException("Unexpected key in savedState: " + str);
                }
                long parseIdFromKey = parseIdFromKey(str, KEY_PREFIX_STATE);
                androidx.fragment.app.Fragment.SavedState savedState = (androidx.fragment.app.Fragment.SavedState) bundle.getParcelable(str);
                if (containsItem(parseIdFromKey)) {
                    this.mSavedStates.put(parseIdFromKey, savedState);
                }
            }
        }
        if (this.mFragments.isEmpty()) {
            return;
        }
        this.mHasStaleFragments = true;
        this.mIsInGracePeriod = true;
        gcFragments();
        scheduleGracePeriodEnd();
    }

    @Override // androidx.viewpager2.adapter.StatefulAdapter
    @androidx.annotation.NonNull
    public final android.os.Parcelable saveState() {
        android.os.Bundle bundle = new android.os.Bundle(this.mFragments.size() + this.mSavedStates.size());
        for (int i = 0; i < this.mFragments.size(); i++) {
            long keyAt = this.mFragments.keyAt(i);
            androidx.fragment.app.Fragment fragment = this.mFragments.get(keyAt);
            if (fragment != null && fragment.isAdded()) {
                this.mFragmentManager.putFragment(bundle, createKey(KEY_PREFIX_FRAGMENT, keyAt), fragment);
            }
        }
        for (int i2 = 0; i2 < this.mSavedStates.size(); i2++) {
            long keyAt2 = this.mSavedStates.keyAt(i2);
            if (containsItem(keyAt2)) {
                bundle.putParcelable(createKey(KEY_PREFIX_STATE, keyAt2), this.mSavedStates.get(keyAt2));
            }
        }
        return bundle;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void setHasStableIds(boolean z) {
        throw new java.lang.UnsupportedOperationException("Stable Ids are required for the adapter to function properly, and the adapter takes care of setting the flag.");
    }

    public boolean shouldDelayFragmentTransactions() {
        return this.mFragmentManager.isStateSaved();
    }
}
