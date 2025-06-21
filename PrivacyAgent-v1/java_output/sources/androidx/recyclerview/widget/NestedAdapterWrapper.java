package androidx.recyclerview.widget;

/* loaded from: classes.dex */
class NestedAdapterWrapper {
    public final androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> adapter;
    private androidx.recyclerview.widget.RecyclerView.AdapterDataObserver mAdapterObserver = new androidx.recyclerview.widget.NestedAdapterWrapper.AnonymousClass1();
    int mCachedItemCount;
    final androidx.recyclerview.widget.NestedAdapterWrapper.Callback mCallback;

    @androidx.annotation.NonNull
    private final androidx.recyclerview.widget.StableIdStorage.StableIdLookup mStableIdLookup;

    @androidx.annotation.NonNull
    private final androidx.recyclerview.widget.ViewTypeStorage.ViewTypeLookup mViewTypeLookup;

    /* renamed from: androidx.recyclerview.widget.NestedAdapterWrapper$1, reason: invalid class name */
    public class AnonymousClass1 extends androidx.recyclerview.widget.RecyclerView.AdapterDataObserver {
        public AnonymousClass1() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            androidx.recyclerview.widget.NestedAdapterWrapper nestedAdapterWrapper = androidx.recyclerview.widget.NestedAdapterWrapper.this;
            nestedAdapterWrapper.mCachedItemCount = nestedAdapterWrapper.adapter.getItemCount();
            androidx.recyclerview.widget.NestedAdapterWrapper nestedAdapterWrapper2 = androidx.recyclerview.widget.NestedAdapterWrapper.this;
            nestedAdapterWrapper2.mCallback.onChanged(nestedAdapterWrapper2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2) {
            androidx.recyclerview.widget.NestedAdapterWrapper nestedAdapterWrapper = androidx.recyclerview.widget.NestedAdapterWrapper.this;
            nestedAdapterWrapper.mCallback.onItemRangeChanged(nestedAdapterWrapper, i, i2, null);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2, @androidx.annotation.Nullable java.lang.Object obj) {
            androidx.recyclerview.widget.NestedAdapterWrapper nestedAdapterWrapper = androidx.recyclerview.widget.NestedAdapterWrapper.this;
            nestedAdapterWrapper.mCallback.onItemRangeChanged(nestedAdapterWrapper, i, i2, obj);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i, int i2) {
            androidx.recyclerview.widget.NestedAdapterWrapper nestedAdapterWrapper = androidx.recyclerview.widget.NestedAdapterWrapper.this;
            nestedAdapterWrapper.mCachedItemCount += i2;
            nestedAdapterWrapper.mCallback.onItemRangeInserted(nestedAdapterWrapper, i, i2);
            androidx.recyclerview.widget.NestedAdapterWrapper nestedAdapterWrapper2 = androidx.recyclerview.widget.NestedAdapterWrapper.this;
            if (nestedAdapterWrapper2.mCachedItemCount <= 0 || nestedAdapterWrapper2.adapter.getStateRestorationPolicy() != androidx.recyclerview.widget.RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY) {
                return;
            }
            androidx.recyclerview.widget.NestedAdapterWrapper nestedAdapterWrapper3 = androidx.recyclerview.widget.NestedAdapterWrapper.this;
            nestedAdapterWrapper3.mCallback.onStateRestorationPolicyChanged(nestedAdapterWrapper3);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i, int i2, int i3) {
            androidx.core.util.Preconditions.checkArgument(i3 == 1, "moving more than 1 item is not supported in RecyclerView");
            androidx.recyclerview.widget.NestedAdapterWrapper nestedAdapterWrapper = androidx.recyclerview.widget.NestedAdapterWrapper.this;
            nestedAdapterWrapper.mCallback.onItemRangeMoved(nestedAdapterWrapper, i, i2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i, int i2) {
            androidx.recyclerview.widget.NestedAdapterWrapper nestedAdapterWrapper = androidx.recyclerview.widget.NestedAdapterWrapper.this;
            nestedAdapterWrapper.mCachedItemCount -= i2;
            nestedAdapterWrapper.mCallback.onItemRangeRemoved(nestedAdapterWrapper, i, i2);
            androidx.recyclerview.widget.NestedAdapterWrapper nestedAdapterWrapper2 = androidx.recyclerview.widget.NestedAdapterWrapper.this;
            if (nestedAdapterWrapper2.mCachedItemCount >= 1 || nestedAdapterWrapper2.adapter.getStateRestorationPolicy() != androidx.recyclerview.widget.RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY) {
                return;
            }
            androidx.recyclerview.widget.NestedAdapterWrapper nestedAdapterWrapper3 = androidx.recyclerview.widget.NestedAdapterWrapper.this;
            nestedAdapterWrapper3.mCallback.onStateRestorationPolicyChanged(nestedAdapterWrapper3);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onStateRestorationPolicyChanged() {
            androidx.recyclerview.widget.NestedAdapterWrapper nestedAdapterWrapper = androidx.recyclerview.widget.NestedAdapterWrapper.this;
            nestedAdapterWrapper.mCallback.onStateRestorationPolicyChanged(nestedAdapterWrapper);
        }
    }

    public interface Callback {
        void onChanged(@androidx.annotation.NonNull androidx.recyclerview.widget.NestedAdapterWrapper nestedAdapterWrapper);

        void onItemRangeChanged(@androidx.annotation.NonNull androidx.recyclerview.widget.NestedAdapterWrapper nestedAdapterWrapper, int i, int i2);

        void onItemRangeChanged(@androidx.annotation.NonNull androidx.recyclerview.widget.NestedAdapterWrapper nestedAdapterWrapper, int i, int i2, @androidx.annotation.Nullable java.lang.Object obj);

        void onItemRangeInserted(@androidx.annotation.NonNull androidx.recyclerview.widget.NestedAdapterWrapper nestedAdapterWrapper, int i, int i2);

        void onItemRangeMoved(@androidx.annotation.NonNull androidx.recyclerview.widget.NestedAdapterWrapper nestedAdapterWrapper, int i, int i2);

        void onItemRangeRemoved(@androidx.annotation.NonNull androidx.recyclerview.widget.NestedAdapterWrapper nestedAdapterWrapper, int i, int i2);

        void onStateRestorationPolicyChanged(androidx.recyclerview.widget.NestedAdapterWrapper nestedAdapterWrapper);
    }

    public NestedAdapterWrapper(androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> adapter, androidx.recyclerview.widget.NestedAdapterWrapper.Callback callback, androidx.recyclerview.widget.ViewTypeStorage viewTypeStorage, androidx.recyclerview.widget.StableIdStorage.StableIdLookup stableIdLookup) {
        this.adapter = adapter;
        this.mCallback = callback;
        this.mViewTypeLookup = viewTypeStorage.createViewTypeWrapper(this);
        this.mStableIdLookup = stableIdLookup;
        this.mCachedItemCount = adapter.getItemCount();
        adapter.registerAdapterDataObserver(this.mAdapterObserver);
    }

    public void dispose() {
        this.adapter.unregisterAdapterDataObserver(this.mAdapterObserver);
        this.mViewTypeLookup.dispose();
    }

    public int getCachedItemCount() {
        return this.mCachedItemCount;
    }

    public long getItemId(int i) {
        return this.mStableIdLookup.localToGlobal(this.adapter.getItemId(i));
    }

    public int getItemViewType(int i) {
        return this.mViewTypeLookup.localToGlobal(this.adapter.getItemViewType(i));
    }

    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i) {
        this.adapter.bindViewHolder(viewHolder, i);
    }

    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
        return this.adapter.onCreateViewHolder(viewGroup, this.mViewTypeLookup.globalToLocal(i));
    }
}
