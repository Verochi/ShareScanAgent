package androidx.recyclerview.widget;

/* loaded from: classes.dex */
public final class AdapterListUpdateCallback implements androidx.recyclerview.widget.ListUpdateCallback {

    @androidx.annotation.NonNull
    private final androidx.recyclerview.widget.RecyclerView.Adapter mAdapter;

    public AdapterListUpdateCallback(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.Adapter adapter) {
        this.mAdapter = adapter;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onChanged(int i, int i2, java.lang.Object obj) {
        this.mAdapter.notifyItemRangeChanged(i, i2, obj);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onInserted(int i, int i2) {
        this.mAdapter.notifyItemRangeInserted(i, i2);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onMoved(int i, int i2) {
        this.mAdapter.notifyItemMoved(i, i2);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onRemoved(int i, int i2) {
        this.mAdapter.notifyItemRangeRemoved(i, i2);
    }
}
