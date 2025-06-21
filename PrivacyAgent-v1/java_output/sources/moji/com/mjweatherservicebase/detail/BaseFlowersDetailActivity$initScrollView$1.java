package moji.com.mjweatherservicebase.detail;

@kotlin.Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"moji/com/mjweatherservicebase/detail/BaseFlowersDetailActivity$initScrollView$1", "Lcom/moji/scrollview/ScrollViewMonitor$OnScrollListener;", "onScroll", "", "scrollY", "", "onScrollStopped", "MJWeatherServiceBase_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes20.dex */
public final class BaseFlowersDetailActivity$initScrollView$1 implements com.moji.scrollview.ScrollViewMonitor.OnScrollListener {
    public final /* synthetic */ moji.com.mjweatherservicebase.detail.BaseFlowersDetailActivity n;
    public final /* synthetic */ com.moji.scrollview.ScrollViewMonitor t;

    public BaseFlowersDetailActivity$initScrollView$1(moji.com.mjweatherservicebase.detail.BaseFlowersDetailActivity baseFlowersDetailActivity, com.moji.scrollview.ScrollViewMonitor scrollViewMonitor) {
        this.n = baseFlowersDetailActivity;
        this.t = scrollViewMonitor;
    }

    public void onScroll(int scrollY) {
    }

    public void onScrollStopped() {
        this.n.mScrollY = this.t.getScrollY();
    }
}
