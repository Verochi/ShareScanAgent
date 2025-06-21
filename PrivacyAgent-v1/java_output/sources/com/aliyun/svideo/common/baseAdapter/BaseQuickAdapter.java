package com.aliyun.svideo.common.baseAdapter;

/* loaded from: classes.dex */
public abstract class BaseQuickAdapter<T, K extends com.aliyun.svideo.common.baseAdapter.BaseViewHolder> extends androidx.recyclerview.widget.RecyclerView.Adapter<K> {
    public static final int EMPTY_VIEW = 1365;
    public static final int FOOTER_VIEW = 819;
    public static final int HEADER_VIEW = 273;
    public static final int LOADING_VIEW = 546;
    protected static final java.lang.String TAG = "BaseQuickAdapter";
    private boolean footerViewAsFlow;
    private boolean headerViewAsFlow;
    protected android.content.Context mContext;
    private com.aliyun.svideo.common.baseAdapter.animation.AlphaInAnimation mCustomAnimation;
    protected java.util.List<T> mData;
    private int mDuration;
    private android.widget.FrameLayout mEmptyLayout;
    private boolean mEnableLoadMoreEndClick;
    private boolean mFirstOnlyEnable;
    private boolean mFootAndEmptyEnable;
    private android.widget.LinearLayout mFooterLayout;
    private boolean mHeadAndEmptyEnable;
    private android.widget.LinearLayout mHeaderLayout;
    private android.view.animation.Interpolator mInterpolator;
    private boolean mIsUseEmpty;
    private int mLastPosition;
    protected android.view.LayoutInflater mLayoutInflater;
    protected int mLayoutResId;
    private boolean mLoadMoreEnable;
    private com.aliyun.svideo.common.baseAdapter.LoadMoreView mLoadMoreView;
    private boolean mLoading;
    private com.aliyun.svideo.common.baseAdapter.delegate.MultiTypeDelegate<T> mMultiTypeDelegate;
    private boolean mNextLoadEnable;
    private com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter.OnItemChildClickListener mOnItemChildClickListener;
    private com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter.OnItemChildLongClickListener mOnItemChildLongClickListener;
    private com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter.OnItemClickListener mOnItemClickListener;
    private com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter.OnItemLongClickListener mOnItemLongClickListener;
    private boolean mOpenAnimationEnable;
    private int mPreLoadNumber;
    private androidx.recyclerview.widget.RecyclerView mRecyclerView;
    private com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter.RequestLoadMoreListener mRequestLoadMoreListener;
    private com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter.SpanSizeLookup mSpanSizeLookup;
    private int mStartUpFetchPosition;
    private boolean mUpFetchEnable;
    private com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter.UpFetchListener mUpFetchListener;
    private boolean mUpFetching;

    /* renamed from: com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ androidx.recyclerview.widget.LinearLayoutManager val$linearLayoutManager;

        public AnonymousClass1(androidx.recyclerview.widget.LinearLayoutManager linearLayoutManager) {
            this.val$linearLayoutManager = linearLayoutManager;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter.this.isFullScreen(this.val$linearLayoutManager)) {
                com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter.this.setEnableLoadMore(true);
            }
        }
    }

    /* renamed from: com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ androidx.recyclerview.widget.StaggeredGridLayoutManager val$staggeredGridLayoutManager;

        public AnonymousClass2(androidx.recyclerview.widget.StaggeredGridLayoutManager staggeredGridLayoutManager) {
            this.val$staggeredGridLayoutManager = staggeredGridLayoutManager;
        }

        @Override // java.lang.Runnable
        public void run() {
            int[] iArr = new int[this.val$staggeredGridLayoutManager.getSpanCount()];
            this.val$staggeredGridLayoutManager.findLastCompletelyVisibleItemPositions(iArr);
            if (com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter.this.getTheBiggestNumber(iArr) + 1 != com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter.this.getItemCount()) {
                com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter.this.setEnableLoadMore(true);
            }
        }
    }

    /* renamed from: com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter$3, reason: invalid class name */
    public class AnonymousClass3 implements android.view.View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            if (com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter.this.mLoadMoreView.getLoadMoreStatus() == 3) {
                com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter.this.notifyLoadMoreToLoading();
            }
            if (com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter.this.mEnableLoadMoreEndClick && com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter.this.mLoadMoreView.getLoadMoreStatus() == 4) {
                com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter.this.notifyLoadMoreToLoading();
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter$4, reason: invalid class name */
    public class AnonymousClass4 extends androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup {
        final /* synthetic */ androidx.recyclerview.widget.GridLayoutManager val$gridManager;

        public AnonymousClass4(androidx.recyclerview.widget.GridLayoutManager gridLayoutManager) {
            this.val$gridManager = gridLayoutManager;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i) {
            int itemViewType = com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter.this.getItemViewType(i);
            if (itemViewType == 273 && com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter.this.isHeaderViewAsFlow()) {
                return 1;
            }
            if (itemViewType == 819 && com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter.this.isFooterViewAsFlow()) {
                return 1;
            }
            if (com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter.this.mSpanSizeLookup != null) {
                return com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter.this.isFixedViewType(itemViewType) ? this.val$gridManager.getSpanCount() : com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter.this.mSpanSizeLookup.getSpanSize(this.val$gridManager, i - com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter.this.getHeaderLayoutCount());
            }
            if (com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter.this.isFixedViewType(itemViewType)) {
                return this.val$gridManager.getSpanCount();
            }
            return 1;
        }
    }

    /* renamed from: com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter$5, reason: invalid class name */
    public class AnonymousClass5 implements android.view.View.OnClickListener {
        final /* synthetic */ com.aliyun.svideo.common.baseAdapter.BaseViewHolder val$baseViewHolder;

        public AnonymousClass5(com.aliyun.svideo.common.baseAdapter.BaseViewHolder baseViewHolder) {
            this.val$baseViewHolder = baseViewHolder;
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter.this.setOnItemClick(view, this.val$baseViewHolder.getLayoutPosition() - com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter.this.getHeaderLayoutCount());
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter$6, reason: invalid class name */
    public class AnonymousClass6 implements android.view.View.OnLongClickListener {
        final /* synthetic */ com.aliyun.svideo.common.baseAdapter.BaseViewHolder val$baseViewHolder;

        public AnonymousClass6(com.aliyun.svideo.common.baseAdapter.BaseViewHolder baseViewHolder) {
            this.val$baseViewHolder = baseViewHolder;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(android.view.View view) {
            return com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter.this.setOnItemLongClick(view, this.val$baseViewHolder.getLayoutPosition() - com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter.this.getHeaderLayoutCount());
        }
    }

    /* renamed from: com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter$7, reason: invalid class name */
    public class AnonymousClass7 implements java.lang.Runnable {
        public AnonymousClass7() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter.this.mRequestLoadMoreListener.onLoadMoreRequested();
        }
    }

    public interface OnItemChildClickListener {
        void onItemChildClick(com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter baseQuickAdapter, android.view.View view, int i);
    }

    public interface OnItemChildLongClickListener {
        boolean onItemChildLongClick(com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter baseQuickAdapter, android.view.View view, int i);
    }

    public interface OnItemClickListener {
        void onItemClick(com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter baseQuickAdapter, android.view.View view, int i);
    }

    public interface OnItemLongClickListener {
        boolean onItemLongClick(com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter baseQuickAdapter, android.view.View view, int i);
    }

    public interface RequestLoadMoreListener {
        void onLoadMoreRequested();
    }

    public interface SpanSizeLookup {
        int getSpanSize(androidx.recyclerview.widget.GridLayoutManager gridLayoutManager, int i);
    }

    public interface UpFetchListener {
        void onUpFetch();
    }

    public BaseQuickAdapter(@androidx.annotation.LayoutRes int i) {
        this(i, null);
    }

    public BaseQuickAdapter(@androidx.annotation.LayoutRes int i, @androidx.annotation.Nullable java.util.List<T> list) {
        this.mNextLoadEnable = false;
        this.mLoadMoreEnable = false;
        this.mLoading = false;
        this.mLoadMoreView = new com.aliyun.svideo.common.baseAdapter.SimpleLoadMoreView();
        this.mEnableLoadMoreEndClick = false;
        this.mFirstOnlyEnable = true;
        this.mOpenAnimationEnable = false;
        this.mInterpolator = new android.view.animation.LinearInterpolator();
        this.mDuration = 300;
        this.mLastPosition = -1;
        this.mIsUseEmpty = true;
        this.mPreLoadNumber = 1;
        this.mStartUpFetchPosition = 1;
        this.mData = list == null ? new java.util.ArrayList<>() : list;
        if (i != 0) {
            this.mLayoutResId = i;
        }
    }

    public BaseQuickAdapter(@androidx.annotation.Nullable java.util.List<T> list) {
        this(0, list);
    }

    private void addAnimation(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder) {
        if (this.mOpenAnimationEnable) {
            if (!this.mFirstOnlyEnable || viewHolder.getLayoutPosition() > this.mLastPosition) {
                com.aliyun.svideo.common.baseAdapter.animation.AlphaInAnimation alphaInAnimation = new com.aliyun.svideo.common.baseAdapter.animation.AlphaInAnimation();
                com.aliyun.svideo.common.baseAdapter.animation.AlphaInAnimation alphaInAnimation2 = this.mCustomAnimation;
                if (alphaInAnimation2 != null) {
                    alphaInAnimation = alphaInAnimation2;
                }
                for (android.animation.Animator animator : alphaInAnimation.getAnimators(viewHolder.itemView)) {
                    startAnim(animator, viewHolder.getLayoutPosition());
                }
                this.mLastPosition = viewHolder.getLayoutPosition();
            }
        }
    }

    private void autoLoadMore(int i) {
        if (getLoadMoreViewCount() != 0 && i >= getItemCount() - this.mPreLoadNumber && this.mLoadMoreView.getLoadMoreStatus() == 1) {
            this.mLoadMoreView.setLoadMoreStatus(2);
            if (this.mLoading) {
                return;
            }
            this.mLoading = true;
            if (getRecyclerView() != null) {
                getRecyclerView().post(new com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter.AnonymousClass7());
            } else {
                this.mRequestLoadMoreListener.onLoadMoreRequested();
            }
        }
    }

    private void autoUpFetch(int i) {
        com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter.UpFetchListener upFetchListener;
        if (!isUpFetchEnable() || isUpFetching() || i > this.mStartUpFetchPosition || (upFetchListener = this.mUpFetchListener) == null) {
            return;
        }
        upFetchListener.onUpFetch();
    }

    private void bindViewClickListener(com.aliyun.svideo.common.baseAdapter.BaseViewHolder baseViewHolder) {
        android.view.View view;
        if (baseViewHolder == null || (view = baseViewHolder.itemView) == null) {
            return;
        }
        if (getOnItemClickListener() != null) {
            view.setOnClickListener(new com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter.AnonymousClass5(baseViewHolder));
        }
        if (getOnItemLongClickListener() != null) {
            view.setOnLongClickListener(new com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter.AnonymousClass6(baseViewHolder));
        }
    }

    private void checkNotNull() {
        if (getRecyclerView() == null) {
            throw new java.lang.IllegalStateException("please bind recyclerView first!");
        }
    }

    private void compatibilityDataSizeChanged(int i) {
        java.util.List<T> list = this.mData;
        if ((list == null ? 0 : list.size()) == i) {
            notifyDataSetChanged();
        }
    }

    private K createGenericKInstance(java.lang.Class cls, android.view.View view) {
        try {
            if (!cls.isMemberClass() || java.lang.reflect.Modifier.isStatic(cls.getModifiers())) {
                java.lang.reflect.Constructor<T> declaredConstructor = cls.getDeclaredConstructor(android.view.View.class);
                declaredConstructor.setAccessible(true);
                return (K) declaredConstructor.newInstance(view);
            }
            java.lang.reflect.Constructor<T> declaredConstructor2 = cls.getDeclaredConstructor(getClass(), android.view.View.class);
            declaredConstructor2.setAccessible(true);
            return (K) declaredConstructor2.newInstance(this, view);
        } catch (java.lang.IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (java.lang.InstantiationException e2) {
            e2.printStackTrace();
            return null;
        } catch (java.lang.NoSuchMethodException e3) {
            e3.printStackTrace();
            return null;
        } catch (java.lang.reflect.InvocationTargetException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    private int getFooterViewPosition() {
        int i = 1;
        if (getEmptyViewCount() != 1) {
            return getHeaderLayoutCount() + this.mData.size();
        }
        if (this.mHeadAndEmptyEnable && getHeaderLayoutCount() != 0) {
            i = 2;
        }
        if (this.mFootAndEmptyEnable) {
            return i;
        }
        return -1;
    }

    private int getHeaderViewPosition() {
        return (getEmptyViewCount() != 1 || this.mHeadAndEmptyEnable) ? 0 : -1;
    }

    private java.lang.Class getInstancedGenericKClass(java.lang.Class cls) {
        java.lang.reflect.Type genericSuperclass = cls.getGenericSuperclass();
        if (!(genericSuperclass instanceof java.lang.reflect.ParameterizedType)) {
            return null;
        }
        for (java.lang.reflect.Type type : ((java.lang.reflect.ParameterizedType) genericSuperclass).getActualTypeArguments()) {
            if (type instanceof java.lang.Class) {
                java.lang.Class cls2 = (java.lang.Class) type;
                if (com.aliyun.svideo.common.baseAdapter.BaseViewHolder.class.isAssignableFrom(cls2)) {
                    return cls2;
                }
            } else if (type instanceof java.lang.reflect.ParameterizedType) {
                java.lang.reflect.Type rawType = ((java.lang.reflect.ParameterizedType) type).getRawType();
                if (rawType instanceof java.lang.Class) {
                    java.lang.Class cls3 = (java.lang.Class) rawType;
                    if (com.aliyun.svideo.common.baseAdapter.BaseViewHolder.class.isAssignableFrom(cls3)) {
                        return cls3;
                    }
                } else {
                    continue;
                }
            } else {
                continue;
            }
        }
        return null;
    }

    private int getItemPosition(T t) {
        java.util.List<T> list;
        if (t == null || (list = this.mData) == null || list.isEmpty()) {
            return -1;
        }
        return this.mData.indexOf(t);
    }

    private K getLoadingView(android.view.ViewGroup viewGroup) {
        K createBaseViewHolder = createBaseViewHolder(getItemView(this.mLoadMoreView.getLayoutId(), viewGroup));
        createBaseViewHolder.itemView.setOnClickListener(new com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter.AnonymousClass3());
        return createBaseViewHolder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getTheBiggestNumber(int[] iArr) {
        int i = -1;
        if (iArr != null && iArr.length != 0) {
            for (int i2 : iArr) {
                if (i2 > i) {
                    i = i2;
                }
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFullScreen(androidx.recyclerview.widget.LinearLayoutManager linearLayoutManager) {
        return (linearLayoutManager.findLastCompletelyVisibleItemPosition() + 1 == getItemCount() && linearLayoutManager.findFirstCompletelyVisibleItemPosition() == 0) ? false : true;
    }

    private void openLoadMore(com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter.RequestLoadMoreListener requestLoadMoreListener) {
        this.mRequestLoadMoreListener = requestLoadMoreListener;
        this.mNextLoadEnable = true;
        this.mLoadMoreEnable = true;
        this.mLoading = false;
    }

    private void setRecyclerView(androidx.recyclerview.widget.RecyclerView recyclerView) {
        this.mRecyclerView = recyclerView;
    }

    @java.lang.Deprecated
    public void add(@androidx.annotation.IntRange(from = 0) int i, @androidx.annotation.NonNull T t) {
        addData(i, (int) t);
    }

    public void addData(@androidx.annotation.IntRange(from = 0) int i, @androidx.annotation.NonNull T t) {
        this.mData.add(i, t);
        notifyItemInserted(i + getHeaderLayoutCount());
        compatibilityDataSizeChanged(1);
    }

    public void addData(@androidx.annotation.IntRange(from = 0) int i, @androidx.annotation.NonNull java.util.Collection<? extends T> collection) {
        this.mData.addAll(i, collection);
        notifyItemRangeInserted(i + getHeaderLayoutCount(), collection.size());
        compatibilityDataSizeChanged(collection.size());
    }

    public void addData(@androidx.annotation.NonNull T t) {
        this.mData.add(t);
        notifyItemInserted(this.mData.size() + getHeaderLayoutCount());
        compatibilityDataSizeChanged(1);
    }

    public void addData(@androidx.annotation.NonNull java.util.Collection<? extends T> collection) {
        this.mData.addAll(collection);
        notifyItemRangeInserted((this.mData.size() - collection.size()) + getHeaderLayoutCount(), collection.size());
        compatibilityDataSizeChanged(collection.size());
    }

    public int addFooterView(android.view.View view) {
        return addFooterView(view, -1, 1);
    }

    public int addFooterView(android.view.View view, int i) {
        return addFooterView(view, i, 1);
    }

    public int addFooterView(android.view.View view, int i, int i2) {
        int footerViewPosition;
        if (this.mFooterLayout == null) {
            android.widget.LinearLayout linearLayout = new android.widget.LinearLayout(view.getContext());
            this.mFooterLayout = linearLayout;
            if (i2 == 1) {
                linearLayout.setOrientation(1);
                this.mFooterLayout.setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -2));
            } else {
                linearLayout.setOrientation(0);
                this.mFooterLayout.setLayoutParams(new android.view.ViewGroup.LayoutParams(-2, -1));
            }
        }
        int childCount = this.mFooterLayout.getChildCount();
        if (i < 0 || i > childCount) {
            i = childCount;
        }
        this.mFooterLayout.addView(view, i);
        if (this.mFooterLayout.getChildCount() == 1 && (footerViewPosition = getFooterViewPosition()) != -1) {
            notifyItemInserted(footerViewPosition);
        }
        return i;
    }

    public int addHeaderView(android.view.View view) {
        return addHeaderView(view, -1);
    }

    public int addHeaderView(android.view.View view, int i) {
        return addHeaderView(view, i, 1);
    }

    public int addHeaderView(android.view.View view, int i, int i2) {
        int headerViewPosition;
        if (this.mHeaderLayout == null) {
            android.widget.LinearLayout linearLayout = new android.widget.LinearLayout(view.getContext());
            this.mHeaderLayout = linearLayout;
            if (i2 == 1) {
                linearLayout.setOrientation(1);
                this.mHeaderLayout.setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -2));
            } else {
                linearLayout.setOrientation(0);
                this.mHeaderLayout.setLayoutParams(new android.view.ViewGroup.LayoutParams(-2, -1));
            }
        }
        int childCount = this.mHeaderLayout.getChildCount();
        if (i < 0 || i > childCount) {
            i = childCount;
        }
        this.mHeaderLayout.addView(view, i);
        if (this.mHeaderLayout.getChildCount() == 1 && (headerViewPosition = getHeaderViewPosition()) != -1) {
            notifyItemInserted(headerViewPosition);
        }
        return i;
    }

    public void bindToRecyclerView(androidx.recyclerview.widget.RecyclerView recyclerView) {
        if (getRecyclerView() != null) {
            throw new java.lang.IllegalStateException("Don't bind twice");
        }
        setRecyclerView(recyclerView);
        getRecyclerView().setAdapter(this);
    }

    public void closeLoadAnimation() {
        this.mOpenAnimationEnable = false;
    }

    public abstract void convert(K k, T t);

    public K createBaseViewHolder(android.view.View view) {
        java.lang.Class cls = null;
        for (java.lang.Class<?> cls2 = getClass(); cls == null && cls2 != null; cls2 = cls2.getSuperclass()) {
            cls = getInstancedGenericKClass(cls2);
        }
        K createGenericKInstance = cls == null ? (K) new com.aliyun.svideo.common.baseAdapter.BaseViewHolder(view) : createGenericKInstance(cls, view);
        return createGenericKInstance != null ? createGenericKInstance : (K) new com.aliyun.svideo.common.baseAdapter.BaseViewHolder(view);
    }

    public K createBaseViewHolder(android.view.ViewGroup viewGroup, int i) {
        return createBaseViewHolder(getItemView(i, viewGroup));
    }

    public void disableLoadMoreIfNotFullPage() {
        checkNotNull();
        disableLoadMoreIfNotFullPage(getRecyclerView());
    }

    public void disableLoadMoreIfNotFullPage(androidx.recyclerview.widget.RecyclerView recyclerView) {
        androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager;
        setEnableLoadMore(false);
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null) {
            return;
        }
        if (layoutManager instanceof androidx.recyclerview.widget.LinearLayoutManager) {
            recyclerView.postDelayed(new com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter.AnonymousClass1((androidx.recyclerview.widget.LinearLayoutManager) layoutManager), 50L);
        } else if (layoutManager instanceof androidx.recyclerview.widget.StaggeredGridLayoutManager) {
            recyclerView.postDelayed(new com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter.AnonymousClass2((androidx.recyclerview.widget.StaggeredGridLayoutManager) layoutManager), 50L);
        }
    }

    public void enableLoadMoreEndClick(boolean z) {
        this.mEnableLoadMoreEndClick = z;
    }

    @androidx.annotation.NonNull
    public java.util.List<T> getData() {
        return this.mData;
    }

    public int getDefItemViewType(int i) {
        com.aliyun.svideo.common.baseAdapter.delegate.MultiTypeDelegate<T> multiTypeDelegate = this.mMultiTypeDelegate;
        return multiTypeDelegate != null ? multiTypeDelegate.getDefItemViewType(this.mData, i) : super.getItemViewType(i);
    }

    public android.view.View getEmptyView() {
        return this.mEmptyLayout;
    }

    public int getEmptyViewCount() {
        android.widget.FrameLayout frameLayout = this.mEmptyLayout;
        return (frameLayout == null || frameLayout.getChildCount() == 0 || !this.mIsUseEmpty || this.mData.size() != 0) ? 0 : 1;
    }

    public android.widget.LinearLayout getFooterLayout() {
        return this.mFooterLayout;
    }

    public int getFooterLayoutCount() {
        android.widget.LinearLayout linearLayout = this.mFooterLayout;
        return (linearLayout == null || linearLayout.getChildCount() == 0) ? 0 : 1;
    }

    @java.lang.Deprecated
    public int getFooterViewsCount() {
        return getFooterLayoutCount();
    }

    public android.widget.LinearLayout getHeaderLayout() {
        return this.mHeaderLayout;
    }

    public int getHeaderLayoutCount() {
        android.widget.LinearLayout linearLayout = this.mHeaderLayout;
        return (linearLayout == null || linearLayout.getChildCount() == 0) ? 0 : 1;
    }

    @java.lang.Deprecated
    public int getHeaderViewsCount() {
        return getHeaderLayoutCount();
    }

    @androidx.annotation.Nullable
    public T getItem(@androidx.annotation.IntRange(from = 0) int i) {
        if (i < 0 || i >= this.mData.size()) {
            return null;
        }
        return this.mData.get(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        int i = 1;
        if (1 != getEmptyViewCount()) {
            return getLoadMoreViewCount() + getHeaderLayoutCount() + this.mData.size() + getFooterLayoutCount();
        }
        if (this.mHeadAndEmptyEnable && getHeaderLayoutCount() != 0) {
            i = 2;
        }
        return (!this.mFootAndEmptyEnable || getFooterLayoutCount() == 0) ? i : i + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return i;
    }

    public android.view.View getItemView(@androidx.annotation.LayoutRes int i, android.view.ViewGroup viewGroup) {
        return this.mLayoutInflater.inflate(i, viewGroup, false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (getEmptyViewCount() == 1) {
            boolean z = this.mHeadAndEmptyEnable && getHeaderLayoutCount() != 0;
            if (i != 0) {
                return i != 1 ? i != 2 ? EMPTY_VIEW : FOOTER_VIEW : z ? EMPTY_VIEW : FOOTER_VIEW;
            }
            if (z) {
                return 273;
            }
            return EMPTY_VIEW;
        }
        int headerLayoutCount = getHeaderLayoutCount();
        if (i < headerLayoutCount) {
            return 273;
        }
        int i2 = i - headerLayoutCount;
        int size = this.mData.size();
        return i2 < size ? getDefItemViewType(i2) : i2 - size < getFooterLayoutCount() ? FOOTER_VIEW : LOADING_VIEW;
    }

    public int getLoadMoreViewCount() {
        if (this.mRequestLoadMoreListener == null || !this.mLoadMoreEnable) {
            return 0;
        }
        return ((this.mNextLoadEnable || !this.mLoadMoreView.isLoadEndMoreGone()) && this.mData.size() != 0) ? 1 : 0;
    }

    public int getLoadMoreViewPosition() {
        return getHeaderLayoutCount() + this.mData.size() + getFooterLayoutCount();
    }

    public com.aliyun.svideo.common.baseAdapter.delegate.MultiTypeDelegate<T> getMultiTypeDelegate() {
        return this.mMultiTypeDelegate;
    }

    @androidx.annotation.Nullable
    public final com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter.OnItemChildClickListener getOnItemChildClickListener() {
        return this.mOnItemChildClickListener;
    }

    @androidx.annotation.Nullable
    public final com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter.OnItemChildLongClickListener getOnItemChildLongClickListener() {
        return this.mOnItemChildLongClickListener;
    }

    public final com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter.OnItemClickListener getOnItemClickListener() {
        return this.mOnItemClickListener;
    }

    public final com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter.OnItemLongClickListener getOnItemLongClickListener() {
        return this.mOnItemLongClickListener;
    }

    public androidx.recyclerview.widget.RecyclerView getRecyclerView() {
        return this.mRecyclerView;
    }

    @androidx.annotation.Nullable
    public android.view.View getViewByPosition(int i, @androidx.annotation.IdRes int i2) {
        checkNotNull();
        return getViewByPosition(getRecyclerView(), i, i2);
    }

    @androidx.annotation.Nullable
    public android.view.View getViewByPosition(androidx.recyclerview.widget.RecyclerView recyclerView, int i, @androidx.annotation.IdRes int i2) {
        com.aliyun.svideo.common.baseAdapter.BaseViewHolder baseViewHolder;
        if (recyclerView == null || (baseViewHolder = (com.aliyun.svideo.common.baseAdapter.BaseViewHolder) recyclerView.findViewHolderForLayoutPosition(i)) == null) {
            return null;
        }
        return baseViewHolder.getView(i2);
    }

    public void isFirstOnly(boolean z) {
        this.mFirstOnlyEnable = z;
    }

    public boolean isFixedViewType(int i) {
        return i == 1365 || i == 273 || i == 819 || i == 546;
    }

    public boolean isFooterViewAsFlow() {
        return this.footerViewAsFlow;
    }

    public boolean isHeaderViewAsFlow() {
        return this.headerViewAsFlow;
    }

    public boolean isLoadMoreEnable() {
        return this.mLoadMoreEnable;
    }

    public boolean isLoading() {
        return this.mLoading;
    }

    public boolean isUpFetchEnable() {
        return this.mUpFetchEnable;
    }

    public boolean isUpFetching() {
        return this.mUpFetching;
    }

    public void isUseEmpty(boolean z) {
        this.mIsUseEmpty = z;
    }

    public void loadMoreComplete() {
        if (getLoadMoreViewCount() == 0) {
            return;
        }
        this.mLoading = false;
        this.mNextLoadEnable = true;
        this.mLoadMoreView.setLoadMoreStatus(1);
        notifyItemChanged(getLoadMoreViewPosition());
    }

    public void loadMoreEnd() {
        loadMoreEnd(false);
    }

    public void loadMoreEnd(boolean z) {
        if (getLoadMoreViewCount() == 0) {
            return;
        }
        this.mLoading = false;
        this.mNextLoadEnable = false;
        this.mLoadMoreView.setLoadMoreEndGone(z);
        if (z) {
            notifyItemRemoved(getLoadMoreViewPosition());
        } else {
            this.mLoadMoreView.setLoadMoreStatus(4);
            notifyItemChanged(getLoadMoreViewPosition());
        }
    }

    public void loadMoreFail() {
        if (getLoadMoreViewCount() == 0) {
            return;
        }
        this.mLoading = false;
        this.mLoadMoreView.setLoadMoreStatus(3);
        notifyItemChanged(getLoadMoreViewPosition());
    }

    public void notifyLoadMoreToLoading() {
        if (this.mLoadMoreView.getLoadMoreStatus() == 2) {
            return;
        }
        this.mLoadMoreView.setLoadMoreStatus(1);
        notifyItemChanged(getLoadMoreViewPosition());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(androidx.recyclerview.widget.RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof androidx.recyclerview.widget.GridLayoutManager) {
            androidx.recyclerview.widget.GridLayoutManager gridLayoutManager = (androidx.recyclerview.widget.GridLayoutManager) layoutManager;
            gridLayoutManager.setSpanSizeLookup(new com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter.AnonymousClass4(gridLayoutManager));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(K k, int i) {
        autoUpFetch(i);
        autoLoadMore(i);
        int itemViewType = k.getItemViewType();
        if (itemViewType == 0) {
            convert(k, getItem(i - getHeaderLayoutCount()));
            return;
        }
        if (itemViewType != 273) {
            if (itemViewType == 546) {
                this.mLoadMoreView.convert(k);
            } else {
                if (itemViewType == 819 || itemViewType == 1365) {
                    return;
                }
                convert(k, getItem(i - getHeaderLayoutCount()));
            }
        }
    }

    public K onCreateDefViewHolder(android.view.ViewGroup viewGroup, int i) {
        int i2 = this.mLayoutResId;
        com.aliyun.svideo.common.baseAdapter.delegate.MultiTypeDelegate<T> multiTypeDelegate = this.mMultiTypeDelegate;
        if (multiTypeDelegate != null) {
            i2 = multiTypeDelegate.getLayoutId(i);
        }
        return createBaseViewHolder(viewGroup, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public K onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
        K createBaseViewHolder;
        android.content.Context context = viewGroup.getContext();
        this.mContext = context;
        this.mLayoutInflater = android.view.LayoutInflater.from(context);
        if (i == 273) {
            createBaseViewHolder = createBaseViewHolder(this.mHeaderLayout);
        } else if (i == 546) {
            createBaseViewHolder = getLoadingView(viewGroup);
        } else if (i == 819) {
            createBaseViewHolder = createBaseViewHolder(this.mFooterLayout);
        } else if (i != 1365) {
            createBaseViewHolder = onCreateDefViewHolder(viewGroup, i);
            bindViewClickListener(createBaseViewHolder);
        } else {
            createBaseViewHolder = createBaseViewHolder(this.mEmptyLayout);
        }
        createBaseViewHolder.setAdapter(this);
        return createBaseViewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(K k) {
        super.onViewAttachedToWindow((com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter<T, K>) k);
        int itemViewType = k.getItemViewType();
        if (itemViewType == 1365 || itemViewType == 273 || itemViewType == 819 || itemViewType == 546) {
            setFullSpan(k);
        } else {
            addAnimation(k);
        }
    }

    public void openLoadAnimation() {
        this.mOpenAnimationEnable = true;
    }

    public final void refreshNotifyItemChanged(int i) {
        notifyItemChanged(i + getHeaderLayoutCount());
    }

    public void remove(@androidx.annotation.IntRange(from = 0) int i) {
        this.mData.remove(i);
        int headerLayoutCount = i + getHeaderLayoutCount();
        notifyItemRemoved(headerLayoutCount);
        compatibilityDataSizeChanged(0);
        notifyItemRangeChanged(headerLayoutCount, this.mData.size() - headerLayoutCount);
    }

    public void removeAllFooterView() {
        if (getFooterLayoutCount() == 0) {
            return;
        }
        this.mFooterLayout.removeAllViews();
        int footerViewPosition = getFooterViewPosition();
        if (footerViewPosition != -1) {
            notifyItemRemoved(footerViewPosition);
        }
    }

    public void removeAllHeaderView() {
        if (getHeaderLayoutCount() == 0) {
            return;
        }
        this.mHeaderLayout.removeAllViews();
        int headerViewPosition = getHeaderViewPosition();
        if (headerViewPosition != -1) {
            notifyItemRemoved(headerViewPosition);
        }
    }

    public void removeFooterView(android.view.View view) {
        int footerViewPosition;
        if (getFooterLayoutCount() == 0) {
            return;
        }
        this.mFooterLayout.removeView(view);
        if (this.mFooterLayout.getChildCount() != 0 || (footerViewPosition = getFooterViewPosition()) == -1) {
            return;
        }
        notifyItemRemoved(footerViewPosition);
    }

    public void removeHeaderView(android.view.View view) {
        int headerViewPosition;
        if (getHeaderLayoutCount() == 0) {
            return;
        }
        this.mHeaderLayout.removeView(view);
        if (this.mHeaderLayout.getChildCount() != 0 || (headerViewPosition = getHeaderViewPosition()) == -1) {
            return;
        }
        notifyItemRemoved(headerViewPosition);
    }

    public void replaceData(@androidx.annotation.NonNull java.util.Collection<? extends T> collection) {
        java.util.List<T> list = this.mData;
        if (collection != list) {
            list.clear();
            this.mData.addAll(collection);
        }
        notifyDataSetChanged();
    }

    @java.lang.Deprecated
    public void setAutoLoadMoreSize(int i) {
        setPreLoadNumber(i);
    }

    public void setData(@androidx.annotation.IntRange(from = 0) int i, @androidx.annotation.NonNull T t) {
        this.mData.set(i, t);
        notifyItemChanged(i + getHeaderLayoutCount());
    }

    public void setDuration(int i) {
        this.mDuration = i;
    }

    @java.lang.Deprecated
    public void setEmptyView(int i) {
        checkNotNull();
        setEmptyView(i, getRecyclerView());
    }

    public void setEmptyView(int i, android.view.ViewGroup viewGroup) {
        setEmptyView(android.view.LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false));
    }

    public void setEmptyView(android.view.View view) {
        boolean z;
        int itemCount = getItemCount();
        if (this.mEmptyLayout == null) {
            this.mEmptyLayout = new android.widget.FrameLayout(view.getContext());
            android.view.ViewGroup.LayoutParams layoutParams = new android.view.ViewGroup.LayoutParams(-1, -1);
            android.view.ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams.width = layoutParams2.width;
                layoutParams.height = layoutParams2.height;
            }
            this.mEmptyLayout.setLayoutParams(layoutParams);
            z = true;
        } else {
            z = false;
        }
        this.mEmptyLayout.removeAllViews();
        this.mEmptyLayout.addView(view);
        this.mIsUseEmpty = true;
        if (z && getEmptyViewCount() == 1) {
            int i = (!this.mHeadAndEmptyEnable || getHeaderLayoutCount() == 0) ? 0 : 1;
            if (getItemCount() > itemCount) {
                notifyItemInserted(i);
            } else {
                notifyDataSetChanged();
            }
        }
    }

    public void setEnableLoadMore(boolean z) {
        int loadMoreViewCount = getLoadMoreViewCount();
        this.mLoadMoreEnable = z;
        int loadMoreViewCount2 = getLoadMoreViewCount();
        if (loadMoreViewCount == 1) {
            if (loadMoreViewCount2 == 0) {
                notifyItemRemoved(getLoadMoreViewPosition());
            }
        } else if (loadMoreViewCount2 == 1) {
            this.mLoadMoreView.setLoadMoreStatus(1);
            notifyItemInserted(getLoadMoreViewPosition());
        }
    }

    public int setFooterView(android.view.View view) {
        return setFooterView(view, 0, 1);
    }

    public int setFooterView(android.view.View view, int i) {
        return setFooterView(view, i, 1);
    }

    public int setFooterView(android.view.View view, int i, int i2) {
        android.widget.LinearLayout linearLayout = this.mFooterLayout;
        if (linearLayout == null || linearLayout.getChildCount() <= i) {
            return addFooterView(view, i, i2);
        }
        this.mFooterLayout.removeViewAt(i);
        this.mFooterLayout.addView(view, i);
        return i;
    }

    public void setFooterViewAsFlow(boolean z) {
        this.footerViewAsFlow = z;
    }

    public void setFullSpan(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder) {
        if (viewHolder.itemView.getLayoutParams() instanceof androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams) {
            ((androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams) viewHolder.itemView.getLayoutParams()).setFullSpan(true);
        }
    }

    public void setHeaderAndEmpty(boolean z) {
        setHeaderFooterEmpty(z, false);
    }

    public void setHeaderFooterEmpty(boolean z, boolean z2) {
        this.mHeadAndEmptyEnable = z;
        this.mFootAndEmptyEnable = z2;
    }

    public int setHeaderView(android.view.View view) {
        return setHeaderView(view, 0, 1);
    }

    public int setHeaderView(android.view.View view, int i) {
        return setHeaderView(view, i, 1);
    }

    public int setHeaderView(android.view.View view, int i, int i2) {
        android.widget.LinearLayout linearLayout = this.mHeaderLayout;
        if (linearLayout == null || linearLayout.getChildCount() <= i) {
            return addHeaderView(view, i, i2);
        }
        this.mHeaderLayout.removeViewAt(i);
        this.mHeaderLayout.addView(view, i);
        return i;
    }

    public void setHeaderViewAsFlow(boolean z) {
        this.headerViewAsFlow = z;
    }

    public void setLoadMoreView(com.aliyun.svideo.common.baseAdapter.LoadMoreView loadMoreView) {
        this.mLoadMoreView = loadMoreView;
    }

    public void setMultiTypeDelegate(com.aliyun.svideo.common.baseAdapter.delegate.MultiTypeDelegate<T> multiTypeDelegate) {
        this.mMultiTypeDelegate = multiTypeDelegate;
    }

    public void setNewData(@androidx.annotation.Nullable java.util.List<T> list) {
        if (list == null) {
            list = new java.util.ArrayList<>();
        }
        this.mData = list;
        if (this.mRequestLoadMoreListener != null) {
            this.mNextLoadEnable = true;
            this.mLoadMoreEnable = true;
            this.mLoading = false;
            this.mLoadMoreView.setLoadMoreStatus(1);
        }
        this.mLastPosition = -1;
        notifyDataSetChanged();
    }

    public void setNotDoAnimationCount(int i) {
        this.mLastPosition = i;
    }

    public void setOnItemChildClickListener(com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter.OnItemChildClickListener onItemChildClickListener) {
        this.mOnItemChildClickListener = onItemChildClickListener;
    }

    public void setOnItemChildLongClickListener(com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter.OnItemChildLongClickListener onItemChildLongClickListener) {
        this.mOnItemChildLongClickListener = onItemChildLongClickListener;
    }

    public void setOnItemClick(android.view.View view, int i) {
        getOnItemClickListener().onItemClick(this, view, i);
    }

    public void setOnItemClickListener(@androidx.annotation.Nullable com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter.OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public boolean setOnItemLongClick(android.view.View view, int i) {
        return getOnItemLongClickListener().onItemLongClick(this, view, i);
    }

    public void setOnItemLongClickListener(com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter.OnItemLongClickListener onItemLongClickListener) {
        this.mOnItemLongClickListener = onItemLongClickListener;
    }

    @java.lang.Deprecated
    public void setOnLoadMoreListener(com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter.RequestLoadMoreListener requestLoadMoreListener) {
        openLoadMore(requestLoadMoreListener);
    }

    public void setOnLoadMoreListener(com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter.RequestLoadMoreListener requestLoadMoreListener, androidx.recyclerview.widget.RecyclerView recyclerView) {
        openLoadMore(requestLoadMoreListener);
        if (getRecyclerView() == null) {
            setRecyclerView(recyclerView);
        }
    }

    public void setPreLoadNumber(int i) {
        if (i > 1) {
            this.mPreLoadNumber = i;
        }
    }

    public void setSpanSizeLookup(com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter.SpanSizeLookup spanSizeLookup) {
        this.mSpanSizeLookup = spanSizeLookup;
    }

    public void setStartUpFetchPosition(int i) {
        this.mStartUpFetchPosition = i;
    }

    public void setUpFetchEnable(boolean z) {
        this.mUpFetchEnable = z;
    }

    public void setUpFetchListener(com.aliyun.svideo.common.baseAdapter.BaseQuickAdapter.UpFetchListener upFetchListener) {
        this.mUpFetchListener = upFetchListener;
    }

    public void setUpFetching(boolean z) {
        this.mUpFetching = z;
    }

    public void startAnim(android.animation.Animator animator, int i) {
        animator.setDuration(this.mDuration).start();
        animator.setInterpolator(this.mInterpolator);
    }
}
