package moji.com.mjwallet.progress;

@kotlin.Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, d2 = {"moji/com/mjwallet/progress/ExtractProgressActivity$onCreate$2", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "MJWallet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes30.dex */
public final class ExtractProgressActivity$onCreate$2 extends androidx.recyclerview.widget.RecyclerView.OnScrollListener {
    public final /* synthetic */ moji.com.mjwallet.progress.ExtractProgressActivity t;
    public final /* synthetic */ moji.com.mjwallet.progress.ExtractProgressViewModel u;

    public ExtractProgressActivity$onCreate$2(moji.com.mjwallet.progress.ExtractProgressActivity extractProgressActivity, moji.com.mjwallet.progress.ExtractProgressViewModel extractProgressViewModel) {
        this.t = extractProgressActivity;
        this.u = extractProgressViewModel;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(@org.jetbrains.annotations.NotNull androidx.recyclerview.widget.RecyclerView recyclerView, int newState) {
        boolean hasMore;
        boolean b;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrollStateChanged(recyclerView, newState);
        if (newState == 0) {
            hasMore = this.t.getHasMore();
            if (hasMore) {
                b = moji.com.mjwallet.progress.ExtractProgressActivityKt.b(recyclerView);
                if (b) {
                    this.u.loadMore();
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(@org.jetbrains.annotations.NotNull androidx.recyclerview.widget.RecyclerView recyclerView, int dx, int dy) {
        boolean hasMore;
        boolean b;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, dx, dy);
        hasMore = this.t.getHasMore();
        if (hasMore) {
            b = moji.com.mjwallet.progress.ExtractProgressActivityKt.b(recyclerView);
            if (b) {
                this.u.loadMore();
            }
        }
    }
}
