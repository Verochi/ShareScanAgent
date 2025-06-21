package moji.com.mjwallet.progress;

@kotlin.Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0002\u001a\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0000H\u0002¨\u0006\u0006"}, d2 = {"Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "a", "", "b", "MJWallet_release"}, k = 2, mv = {1, 6, 0})
/* loaded from: classes20.dex */
public final class ExtractProgressActivityKt {
    public static final int a(androidx.recyclerview.widget.RecyclerView recyclerView) {
        androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager != null) {
            return ((androidx.recyclerview.widget.LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
        }
        throw new java.lang.NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
    }

    public static final boolean b(androidx.recyclerview.widget.RecyclerView recyclerView) {
        int a = a(recyclerView);
        if (a != -1) {
            androidx.recyclerview.widget.RecyclerView.Adapter adapter = recyclerView.getAdapter();
            kotlin.jvm.internal.Intrinsics.checkNotNull(adapter);
            if (a == adapter.getItemCount() - 1) {
                return true;
            }
        }
        return false;
    }
}
