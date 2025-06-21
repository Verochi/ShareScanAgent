package moji.com.mjweatherservicebase;

@kotlin.Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"moji/com/mjweatherservicebase/BaseFlowersInfoAdapter$onScrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "MJWeatherServiceBase_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes20.dex */
public final class BaseFlowersInfoAdapter$onScrollListener$1 extends androidx.recyclerview.widget.RecyclerView.OnScrollListener {
    public final /* synthetic */ moji.com.mjweatherservicebase.BaseFlowersInfoAdapter t;

    public BaseFlowersInfoAdapter$onScrollListener$1(moji.com.mjweatherservicebase.BaseFlowersInfoAdapter baseFlowersInfoAdapter) {
        this.t = baseFlowersInfoAdapter;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(@org.jetbrains.annotations.NotNull androidx.recyclerview.widget.RecyclerView recyclerView, int newState) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager == null) {
            throw new java.lang.NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        }
        androidx.recyclerview.widget.LinearLayoutManager linearLayoutManager = (androidx.recyclerview.widget.LinearLayoutManager) layoutManager;
        if (newState == 0) {
            this.t.recordRank(linearLayoutManager);
        }
    }
}
