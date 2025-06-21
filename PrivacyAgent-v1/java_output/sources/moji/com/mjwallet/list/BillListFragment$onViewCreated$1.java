package moji.com.mjwallet.list;

@kotlin.Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"moji/com/mjwallet/list/BillListFragment$onViewCreated$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "MJWallet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes20.dex */
public final class BillListFragment$onViewCreated$1 extends androidx.recyclerview.widget.RecyclerView.OnScrollListener {
    public final /* synthetic */ moji.com.mjwallet.list.BillListFragment t;

    public BillListFragment$onViewCreated$1(moji.com.mjwallet.list.BillListFragment billListFragment) {
        this.t = billListFragment;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(@org.jetbrains.annotations.NotNull androidx.recyclerview.widget.RecyclerView recyclerView, int dx, int dy) {
        boolean hasMore;
        boolean d;
        int i;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, dx, dy);
        hasMore = this.t.getHasMore();
        if (hasMore) {
            d = this.t.d(recyclerView);
            if (d) {
                moji.com.mjwallet.list.RecordListViewModel recordListViewModel = (moji.com.mjwallet.list.RecordListViewModel) androidx.lifecycle.ViewModelProviders.of(this.t).get(moji.com.mjwallet.list.RecordListViewModel.class);
                i = this.t.type;
                recordListViewModel.loadMore(i);
            }
        }
    }
}
