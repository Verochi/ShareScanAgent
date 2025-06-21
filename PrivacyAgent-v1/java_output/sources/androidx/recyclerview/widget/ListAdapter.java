package androidx.recyclerview.widget;

/* loaded from: classes.dex */
public abstract class ListAdapter<T, VH extends androidx.recyclerview.widget.RecyclerView.ViewHolder> extends androidx.recyclerview.widget.RecyclerView.Adapter<VH> {
    final androidx.recyclerview.widget.AsyncListDiffer<T> mDiffer;
    private final androidx.recyclerview.widget.AsyncListDiffer.ListListener<T> mListener;

    /* renamed from: androidx.recyclerview.widget.ListAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements androidx.recyclerview.widget.AsyncListDiffer.ListListener<T> {
        public AnonymousClass1() {
        }

        @Override // androidx.recyclerview.widget.AsyncListDiffer.ListListener
        public void onCurrentListChanged(@androidx.annotation.NonNull java.util.List<T> list, @androidx.annotation.NonNull java.util.List<T> list2) {
            androidx.recyclerview.widget.ListAdapter.this.onCurrentListChanged(list, list2);
        }
    }

    public ListAdapter(@androidx.annotation.NonNull androidx.recyclerview.widget.AsyncDifferConfig<T> asyncDifferConfig) {
        androidx.recyclerview.widget.ListAdapter.AnonymousClass1 anonymousClass1 = new androidx.recyclerview.widget.ListAdapter.AnonymousClass1();
        this.mListener = anonymousClass1;
        androidx.recyclerview.widget.AsyncListDiffer<T> asyncListDiffer = new androidx.recyclerview.widget.AsyncListDiffer<>(new androidx.recyclerview.widget.AdapterListUpdateCallback(this), asyncDifferConfig);
        this.mDiffer = asyncListDiffer;
        asyncListDiffer.addListListener(anonymousClass1);
    }

    public ListAdapter(@androidx.annotation.NonNull androidx.recyclerview.widget.DiffUtil.ItemCallback<T> itemCallback) {
        androidx.recyclerview.widget.ListAdapter.AnonymousClass1 anonymousClass1 = new androidx.recyclerview.widget.ListAdapter.AnonymousClass1();
        this.mListener = anonymousClass1;
        androidx.recyclerview.widget.AsyncListDiffer<T> asyncListDiffer = new androidx.recyclerview.widget.AsyncListDiffer<>(new androidx.recyclerview.widget.AdapterListUpdateCallback(this), new androidx.recyclerview.widget.AsyncDifferConfig.Builder(itemCallback).build());
        this.mDiffer = asyncListDiffer;
        asyncListDiffer.addListListener(anonymousClass1);
    }

    @androidx.annotation.NonNull
    public java.util.List<T> getCurrentList() {
        return this.mDiffer.getCurrentList();
    }

    public T getItem(int i) {
        return this.mDiffer.getCurrentList().get(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mDiffer.getCurrentList().size();
    }

    public void onCurrentListChanged(@androidx.annotation.NonNull java.util.List<T> list, @androidx.annotation.NonNull java.util.List<T> list2) {
    }

    public void submitList(@androidx.annotation.Nullable java.util.List<T> list) {
        this.mDiffer.submitList(list);
    }

    public void submitList(@androidx.annotation.Nullable java.util.List<T> list, @androidx.annotation.Nullable java.lang.Runnable runnable) {
        this.mDiffer.submitList(list, runnable);
    }
}
