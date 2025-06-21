package moji.com.mjweatherservicebase.card;

@kotlin.Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"moji/com/mjweatherservicebase/card/HomePageNearSpotView$onCreatedView$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "MJWeatherServiceBase_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes20.dex */
public final class HomePageNearSpotView$onCreatedView$1 extends androidx.recyclerview.widget.RecyclerView.OnScrollListener {
    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(@org.jetbrains.annotations.NotNull androidx.recyclerview.widget.RecyclerView recyclerView, int newState) {
        moji.com.mjweatherservicebase.BaseFlowersMainPresenter flowersMainPresenter;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        if (newState != 0 || (flowersMainPresenter = moji.com.mjweatherservicebase.BaseHomePageActivity.INSTANCE.getFlowersMainPresenter()) == null) {
            return;
        }
        flowersMainPresenter.eventNearbyScroll();
    }
}
