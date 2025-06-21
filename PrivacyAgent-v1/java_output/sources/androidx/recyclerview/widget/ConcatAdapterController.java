package androidx.recyclerview.widget;

/* loaded from: classes.dex */
class ConcatAdapterController implements androidx.recyclerview.widget.NestedAdapterWrapper.Callback {
    private final androidx.recyclerview.widget.ConcatAdapter mConcatAdapter;

    @androidx.annotation.NonNull
    private final androidx.recyclerview.widget.ConcatAdapter.Config.StableIdMode mStableIdMode;
    private final androidx.recyclerview.widget.StableIdStorage mStableIdStorage;
    private final androidx.recyclerview.widget.ViewTypeStorage mViewTypeStorage;
    private java.util.List<java.lang.ref.WeakReference<androidx.recyclerview.widget.RecyclerView>> mAttachedRecyclerViews = new java.util.ArrayList();
    private final java.util.IdentityHashMap<androidx.recyclerview.widget.RecyclerView.ViewHolder, androidx.recyclerview.widget.NestedAdapterWrapper> mBinderLookup = new java.util.IdentityHashMap<>();
    private java.util.List<androidx.recyclerview.widget.NestedAdapterWrapper> mWrappers = new java.util.ArrayList();
    private androidx.recyclerview.widget.ConcatAdapterController.WrapperAndLocalPosition mReusableHolder = new androidx.recyclerview.widget.ConcatAdapterController.WrapperAndLocalPosition();

    public static class WrapperAndLocalPosition {
        boolean mInUse;
        int mLocalPosition;
        androidx.recyclerview.widget.NestedAdapterWrapper mWrapper;
    }

    public ConcatAdapterController(androidx.recyclerview.widget.ConcatAdapter concatAdapter, androidx.recyclerview.widget.ConcatAdapter.Config config) {
        this.mConcatAdapter = concatAdapter;
        if (config.isolateViewTypes) {
            this.mViewTypeStorage = new androidx.recyclerview.widget.ViewTypeStorage.IsolatedViewTypeStorage();
        } else {
            this.mViewTypeStorage = new androidx.recyclerview.widget.ViewTypeStorage.SharedIdRangeViewTypeStorage();
        }
        androidx.recyclerview.widget.ConcatAdapter.Config.StableIdMode stableIdMode = config.stableIdMode;
        this.mStableIdMode = stableIdMode;
        if (stableIdMode == androidx.recyclerview.widget.ConcatAdapter.Config.StableIdMode.NO_STABLE_IDS) {
            this.mStableIdStorage = new androidx.recyclerview.widget.StableIdStorage.NoStableIdStorage();
        } else if (stableIdMode == androidx.recyclerview.widget.ConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS) {
            this.mStableIdStorage = new androidx.recyclerview.widget.StableIdStorage.IsolatedStableIdStorage();
        } else {
            if (stableIdMode != androidx.recyclerview.widget.ConcatAdapter.Config.StableIdMode.SHARED_STABLE_IDS) {
                throw new java.lang.IllegalArgumentException("unknown stable id mode");
            }
            this.mStableIdStorage = new androidx.recyclerview.widget.StableIdStorage.SharedPoolStableIdStorage();
        }
    }

    private void calculateAndUpdateStateRestorationPolicy() {
        androidx.recyclerview.widget.RecyclerView.Adapter.StateRestorationPolicy computeStateRestorationPolicy = computeStateRestorationPolicy();
        if (computeStateRestorationPolicy != this.mConcatAdapter.getStateRestorationPolicy()) {
            this.mConcatAdapter.internalSetStateRestorationPolicy(computeStateRestorationPolicy);
        }
    }

    private androidx.recyclerview.widget.RecyclerView.Adapter.StateRestorationPolicy computeStateRestorationPolicy() {
        for (androidx.recyclerview.widget.NestedAdapterWrapper nestedAdapterWrapper : this.mWrappers) {
            androidx.recyclerview.widget.RecyclerView.Adapter.StateRestorationPolicy stateRestorationPolicy = nestedAdapterWrapper.adapter.getStateRestorationPolicy();
            androidx.recyclerview.widget.RecyclerView.Adapter.StateRestorationPolicy stateRestorationPolicy2 = androidx.recyclerview.widget.RecyclerView.Adapter.StateRestorationPolicy.PREVENT;
            if (stateRestorationPolicy == stateRestorationPolicy2) {
                return stateRestorationPolicy2;
            }
            if (stateRestorationPolicy == androidx.recyclerview.widget.RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY && nestedAdapterWrapper.getCachedItemCount() == 0) {
                return stateRestorationPolicy2;
            }
        }
        return androidx.recyclerview.widget.RecyclerView.Adapter.StateRestorationPolicy.ALLOW;
    }

    private int countItemsBefore(androidx.recyclerview.widget.NestedAdapterWrapper nestedAdapterWrapper) {
        androidx.recyclerview.widget.NestedAdapterWrapper next;
        java.util.Iterator<androidx.recyclerview.widget.NestedAdapterWrapper> it = this.mWrappers.iterator();
        int i = 0;
        while (it.hasNext() && (next = it.next()) != nestedAdapterWrapper) {
            i += next.getCachedItemCount();
        }
        return i;
    }

    @androidx.annotation.NonNull
    private androidx.recyclerview.widget.ConcatAdapterController.WrapperAndLocalPosition findWrapperAndLocalPosition(int i) {
        androidx.recyclerview.widget.ConcatAdapterController.WrapperAndLocalPosition wrapperAndLocalPosition = this.mReusableHolder;
        if (wrapperAndLocalPosition.mInUse) {
            wrapperAndLocalPosition = new androidx.recyclerview.widget.ConcatAdapterController.WrapperAndLocalPosition();
        } else {
            wrapperAndLocalPosition.mInUse = true;
        }
        java.util.Iterator<androidx.recyclerview.widget.NestedAdapterWrapper> it = this.mWrappers.iterator();
        int i2 = i;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            androidx.recyclerview.widget.NestedAdapterWrapper next = it.next();
            if (next.getCachedItemCount() > i2) {
                wrapperAndLocalPosition.mWrapper = next;
                wrapperAndLocalPosition.mLocalPosition = i2;
                break;
            }
            i2 -= next.getCachedItemCount();
        }
        if (wrapperAndLocalPosition.mWrapper != null) {
            return wrapperAndLocalPosition;
        }
        throw new java.lang.IllegalArgumentException("Cannot find wrapper for " + i);
    }

    @androidx.annotation.Nullable
    private androidx.recyclerview.widget.NestedAdapterWrapper findWrapperFor(androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> adapter) {
        int indexOfWrapper = indexOfWrapper(adapter);
        if (indexOfWrapper == -1) {
            return null;
        }
        return this.mWrappers.get(indexOfWrapper);
    }

    @androidx.annotation.NonNull
    private androidx.recyclerview.widget.NestedAdapterWrapper getWrapper(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder) {
        androidx.recyclerview.widget.NestedAdapterWrapper nestedAdapterWrapper = this.mBinderLookup.get(viewHolder);
        if (nestedAdapterWrapper != null) {
            return nestedAdapterWrapper;
        }
        throw new java.lang.IllegalStateException("Cannot find wrapper for " + viewHolder + ", seems like it is not bound by this adapter: " + this);
    }

    private int indexOfWrapper(androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> adapter) {
        int size = this.mWrappers.size();
        for (int i = 0; i < size; i++) {
            if (this.mWrappers.get(i).adapter == adapter) {
                return i;
            }
        }
        return -1;
    }

    private boolean isAttachedTo(androidx.recyclerview.widget.RecyclerView recyclerView) {
        java.util.Iterator<java.lang.ref.WeakReference<androidx.recyclerview.widget.RecyclerView>> it = this.mAttachedRecyclerViews.iterator();
        while (it.hasNext()) {
            if (it.next().get() == recyclerView) {
                return true;
            }
        }
        return false;
    }

    private void releaseWrapperAndLocalPosition(androidx.recyclerview.widget.ConcatAdapterController.WrapperAndLocalPosition wrapperAndLocalPosition) {
        wrapperAndLocalPosition.mInUse = false;
        wrapperAndLocalPosition.mWrapper = null;
        wrapperAndLocalPosition.mLocalPosition = -1;
        this.mReusableHolder = wrapperAndLocalPosition;
    }

    public boolean addAdapter(int i, androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> adapter) {
        if (i < 0 || i > this.mWrappers.size()) {
            throw new java.lang.IndexOutOfBoundsException("Index must be between 0 and " + this.mWrappers.size() + ". Given:" + i);
        }
        if (hasStableIds()) {
            androidx.core.util.Preconditions.checkArgument(adapter.hasStableIds(), "All sub adapters must have stable ids when stable id mode is ISOLATED_STABLE_IDS or SHARED_STABLE_IDS");
        } else {
            adapter.hasStableIds();
        }
        if (findWrapperFor(adapter) != null) {
            return false;
        }
        androidx.recyclerview.widget.NestedAdapterWrapper nestedAdapterWrapper = new androidx.recyclerview.widget.NestedAdapterWrapper(adapter, this, this.mViewTypeStorage, this.mStableIdStorage.createStableIdLookup());
        this.mWrappers.add(i, nestedAdapterWrapper);
        java.util.Iterator<java.lang.ref.WeakReference<androidx.recyclerview.widget.RecyclerView>> it = this.mAttachedRecyclerViews.iterator();
        while (it.hasNext()) {
            androidx.recyclerview.widget.RecyclerView recyclerView = it.next().get();
            if (recyclerView != null) {
                adapter.onAttachedToRecyclerView(recyclerView);
            }
        }
        if (nestedAdapterWrapper.getCachedItemCount() > 0) {
            this.mConcatAdapter.notifyItemRangeInserted(countItemsBefore(nestedAdapterWrapper), nestedAdapterWrapper.getCachedItemCount());
        }
        calculateAndUpdateStateRestorationPolicy();
        return true;
    }

    public boolean addAdapter(androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> adapter) {
        return addAdapter(this.mWrappers.size(), adapter);
    }

    public boolean canRestoreState() {
        java.util.Iterator<androidx.recyclerview.widget.NestedAdapterWrapper> it = this.mWrappers.iterator();
        while (it.hasNext()) {
            if (!it.next().adapter.canRestoreState()) {
                return false;
            }
        }
        return true;
    }

    @androidx.annotation.Nullable
    public androidx.recyclerview.widget.RecyclerView.Adapter<? extends androidx.recyclerview.widget.RecyclerView.ViewHolder> getBoundAdapter(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder) {
        androidx.recyclerview.widget.NestedAdapterWrapper nestedAdapterWrapper = this.mBinderLookup.get(viewHolder);
        if (nestedAdapterWrapper == null) {
            return null;
        }
        return nestedAdapterWrapper.adapter;
    }

    public java.util.List<androidx.recyclerview.widget.RecyclerView.Adapter<? extends androidx.recyclerview.widget.RecyclerView.ViewHolder>> getCopyOfAdapters() {
        if (this.mWrappers.isEmpty()) {
            return java.util.Collections.emptyList();
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(this.mWrappers.size());
        java.util.Iterator<androidx.recyclerview.widget.NestedAdapterWrapper> it = this.mWrappers.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().adapter);
        }
        return arrayList;
    }

    public long getItemId(int i) {
        androidx.recyclerview.widget.ConcatAdapterController.WrapperAndLocalPosition findWrapperAndLocalPosition = findWrapperAndLocalPosition(i);
        long itemId = findWrapperAndLocalPosition.mWrapper.getItemId(findWrapperAndLocalPosition.mLocalPosition);
        releaseWrapperAndLocalPosition(findWrapperAndLocalPosition);
        return itemId;
    }

    public int getItemViewType(int i) {
        androidx.recyclerview.widget.ConcatAdapterController.WrapperAndLocalPosition findWrapperAndLocalPosition = findWrapperAndLocalPosition(i);
        int itemViewType = findWrapperAndLocalPosition.mWrapper.getItemViewType(findWrapperAndLocalPosition.mLocalPosition);
        releaseWrapperAndLocalPosition(findWrapperAndLocalPosition);
        return itemViewType;
    }

    public int getLocalAdapterPosition(androidx.recyclerview.widget.RecyclerView.Adapter<? extends androidx.recyclerview.widget.RecyclerView.ViewHolder> adapter, androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i) {
        androidx.recyclerview.widget.NestedAdapterWrapper nestedAdapterWrapper = this.mBinderLookup.get(viewHolder);
        if (nestedAdapterWrapper == null) {
            return -1;
        }
        int countItemsBefore = i - countItemsBefore(nestedAdapterWrapper);
        int itemCount = nestedAdapterWrapper.adapter.getItemCount();
        if (countItemsBefore >= 0 && countItemsBefore < itemCount) {
            return nestedAdapterWrapper.adapter.findRelativeAdapterPositionIn(adapter, viewHolder, countItemsBefore);
        }
        throw new java.lang.IllegalStateException("Detected inconsistent adapter updates. The local position of the view holder maps to " + countItemsBefore + " which is out of bounds for the adapter with size " + itemCount + ".Make sure to immediately call notify methods in your adapter when you change the backing dataviewHolder:" + viewHolder + "adapter:" + adapter);
    }

    public int getTotalCount() {
        java.util.Iterator<androidx.recyclerview.widget.NestedAdapterWrapper> it = this.mWrappers.iterator();
        int i = 0;
        while (it.hasNext()) {
            i += it.next().getCachedItemCount();
        }
        return i;
    }

    public boolean hasStableIds() {
        return this.mStableIdMode != androidx.recyclerview.widget.ConcatAdapter.Config.StableIdMode.NO_STABLE_IDS;
    }

    public void onAttachedToRecyclerView(androidx.recyclerview.widget.RecyclerView recyclerView) {
        if (isAttachedTo(recyclerView)) {
            return;
        }
        this.mAttachedRecyclerViews.add(new java.lang.ref.WeakReference<>(recyclerView));
        java.util.Iterator<androidx.recyclerview.widget.NestedAdapterWrapper> it = this.mWrappers.iterator();
        while (it.hasNext()) {
            it.next().adapter.onAttachedToRecyclerView(recyclerView);
        }
    }

    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i) {
        androidx.recyclerview.widget.ConcatAdapterController.WrapperAndLocalPosition findWrapperAndLocalPosition = findWrapperAndLocalPosition(i);
        this.mBinderLookup.put(viewHolder, findWrapperAndLocalPosition.mWrapper);
        findWrapperAndLocalPosition.mWrapper.onBindViewHolder(viewHolder, findWrapperAndLocalPosition.mLocalPosition);
        releaseWrapperAndLocalPosition(findWrapperAndLocalPosition);
    }

    @Override // androidx.recyclerview.widget.NestedAdapterWrapper.Callback
    public void onChanged(@androidx.annotation.NonNull androidx.recyclerview.widget.NestedAdapterWrapper nestedAdapterWrapper) {
        this.mConcatAdapter.notifyDataSetChanged();
        calculateAndUpdateStateRestorationPolicy();
    }

    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
        return this.mViewTypeStorage.getWrapperForGlobalType(i).onCreateViewHolder(viewGroup, i);
    }

    public void onDetachedFromRecyclerView(androidx.recyclerview.widget.RecyclerView recyclerView) {
        int size = this.mAttachedRecyclerViews.size() - 1;
        while (true) {
            if (size < 0) {
                break;
            }
            java.lang.ref.WeakReference<androidx.recyclerview.widget.RecyclerView> weakReference = this.mAttachedRecyclerViews.get(size);
            if (weakReference.get() == null) {
                this.mAttachedRecyclerViews.remove(size);
            } else if (weakReference.get() == recyclerView) {
                this.mAttachedRecyclerViews.remove(size);
                break;
            }
            size--;
        }
        java.util.Iterator<androidx.recyclerview.widget.NestedAdapterWrapper> it = this.mWrappers.iterator();
        while (it.hasNext()) {
            it.next().adapter.onDetachedFromRecyclerView(recyclerView);
        }
    }

    public boolean onFailedToRecycleView(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder) {
        androidx.recyclerview.widget.NestedAdapterWrapper nestedAdapterWrapper = this.mBinderLookup.get(viewHolder);
        if (nestedAdapterWrapper != null) {
            boolean onFailedToRecycleView = nestedAdapterWrapper.adapter.onFailedToRecycleView(viewHolder);
            this.mBinderLookup.remove(viewHolder);
            return onFailedToRecycleView;
        }
        throw new java.lang.IllegalStateException("Cannot find wrapper for " + viewHolder + ", seems like it is not bound by this adapter: " + this);
    }

    @Override // androidx.recyclerview.widget.NestedAdapterWrapper.Callback
    public void onItemRangeChanged(@androidx.annotation.NonNull androidx.recyclerview.widget.NestedAdapterWrapper nestedAdapterWrapper, int i, int i2) {
        this.mConcatAdapter.notifyItemRangeChanged(i + countItemsBefore(nestedAdapterWrapper), i2);
    }

    @Override // androidx.recyclerview.widget.NestedAdapterWrapper.Callback
    public void onItemRangeChanged(@androidx.annotation.NonNull androidx.recyclerview.widget.NestedAdapterWrapper nestedAdapterWrapper, int i, int i2, @androidx.annotation.Nullable java.lang.Object obj) {
        this.mConcatAdapter.notifyItemRangeChanged(i + countItemsBefore(nestedAdapterWrapper), i2, obj);
    }

    @Override // androidx.recyclerview.widget.NestedAdapterWrapper.Callback
    public void onItemRangeInserted(@androidx.annotation.NonNull androidx.recyclerview.widget.NestedAdapterWrapper nestedAdapterWrapper, int i, int i2) {
        this.mConcatAdapter.notifyItemRangeInserted(i + countItemsBefore(nestedAdapterWrapper), i2);
    }

    @Override // androidx.recyclerview.widget.NestedAdapterWrapper.Callback
    public void onItemRangeMoved(@androidx.annotation.NonNull androidx.recyclerview.widget.NestedAdapterWrapper nestedAdapterWrapper, int i, int i2) {
        int countItemsBefore = countItemsBefore(nestedAdapterWrapper);
        this.mConcatAdapter.notifyItemMoved(i + countItemsBefore, i2 + countItemsBefore);
    }

    @Override // androidx.recyclerview.widget.NestedAdapterWrapper.Callback
    public void onItemRangeRemoved(@androidx.annotation.NonNull androidx.recyclerview.widget.NestedAdapterWrapper nestedAdapterWrapper, int i, int i2) {
        this.mConcatAdapter.notifyItemRangeRemoved(i + countItemsBefore(nestedAdapterWrapper), i2);
    }

    @Override // androidx.recyclerview.widget.NestedAdapterWrapper.Callback
    public void onStateRestorationPolicyChanged(androidx.recyclerview.widget.NestedAdapterWrapper nestedAdapterWrapper) {
        calculateAndUpdateStateRestorationPolicy();
    }

    public void onViewAttachedToWindow(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder) {
        getWrapper(viewHolder).adapter.onViewAttachedToWindow(viewHolder);
    }

    public void onViewDetachedFromWindow(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder) {
        getWrapper(viewHolder).adapter.onViewDetachedFromWindow(viewHolder);
    }

    public void onViewRecycled(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder) {
        androidx.recyclerview.widget.NestedAdapterWrapper nestedAdapterWrapper = this.mBinderLookup.get(viewHolder);
        if (nestedAdapterWrapper != null) {
            nestedAdapterWrapper.adapter.onViewRecycled(viewHolder);
            this.mBinderLookup.remove(viewHolder);
            return;
        }
        throw new java.lang.IllegalStateException("Cannot find wrapper for " + viewHolder + ", seems like it is not bound by this adapter: " + this);
    }

    public boolean removeAdapter(androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> adapter) {
        int indexOfWrapper = indexOfWrapper(adapter);
        if (indexOfWrapper == -1) {
            return false;
        }
        androidx.recyclerview.widget.NestedAdapterWrapper nestedAdapterWrapper = this.mWrappers.get(indexOfWrapper);
        int countItemsBefore = countItemsBefore(nestedAdapterWrapper);
        this.mWrappers.remove(indexOfWrapper);
        this.mConcatAdapter.notifyItemRangeRemoved(countItemsBefore, nestedAdapterWrapper.getCachedItemCount());
        java.util.Iterator<java.lang.ref.WeakReference<androidx.recyclerview.widget.RecyclerView>> it = this.mAttachedRecyclerViews.iterator();
        while (it.hasNext()) {
            androidx.recyclerview.widget.RecyclerView recyclerView = it.next().get();
            if (recyclerView != null) {
                adapter.onDetachedFromRecyclerView(recyclerView);
            }
        }
        nestedAdapterWrapper.dispose();
        calculateAndUpdateStateRestorationPolicy();
        return true;
    }
}
