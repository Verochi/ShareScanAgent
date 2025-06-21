package moji.com.mjweatherservicebase.list;

@kotlin.Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, d2 = {"moji/com/mjweatherservicebase/list/BaseFlowersSpotListAdapter$onScrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "MJWeatherServiceBase_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes20.dex */
public final class BaseFlowersSpotListAdapter$onScrollListener$1 extends androidx.recyclerview.widget.RecyclerView.OnScrollListener {
    public final /* synthetic */ moji.com.mjweatherservicebase.list.BaseFlowersSpotListAdapter t;

    public BaseFlowersSpotListAdapter$onScrollListener$1(moji.com.mjweatherservicebase.list.BaseFlowersSpotListAdapter baseFlowersSpotListAdapter) {
        this.t = baseFlowersSpotListAdapter;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(@org.jetbrains.annotations.NotNull androidx.recyclerview.widget.RecyclerView recyclerView, int newState) {
        moji.com.mjweatherservicebase.list.BaseFlowersSpotListActivity baseFlowersSpotListActivity;
        boolean z;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager == null) {
            throw new java.lang.NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        }
        int findLastCompletelyVisibleItemPosition = ((androidx.recyclerview.widget.LinearLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition();
        if (newState == 0 && this.t.hasMore() && findLastCompletelyVisibleItemPosition + 1 == this.t.getItemCount()) {
            this.t.refreshStatus(1);
            baseFlowersSpotListActivity = this.t.mContext;
            z = this.t.mNextIsInner;
            baseFlowersSpotListActivity.requestMore(z);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(@org.jetbrains.annotations.NotNull androidx.recyclerview.widget.RecyclerView recyclerView, int dx, int dy) {
        boolean z;
        boolean d;
        float b;
        android.widget.TextView textView;
        int i;
        java.util.ArrayList arrayList;
        int i2;
        java.lang.String c;
        java.lang.String str;
        android.widget.TextView textView2;
        float b2;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        z = this.t.mIsNearby;
        if (z) {
            androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager == null) {
                throw new java.lang.NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            }
            androidx.recyclerview.widget.LinearLayoutManager linearLayoutManager = (androidx.recyclerview.widget.LinearLayoutManager) layoutManager;
            int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            int i3 = findFirstVisibleItemPosition + 1;
            android.view.View findViewByPosition = linearLayoutManager.findViewByPosition(i3);
            if (findViewByPosition == null) {
                return;
            }
            d = this.t.d(i3);
            float top = findViewByPosition.getTop();
            b = this.t.b();
            android.widget.TextView textView3 = null;
            if (top > b || !d) {
                textView = this.t.mLabelView;
                if (textView == null) {
                    kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("mLabelView");
                } else {
                    textView3 = textView;
                }
                textView3.setY(0.0f);
            } else {
                textView2 = this.t.mLabelView;
                if (textView2 == null) {
                    kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("mLabelView");
                } else {
                    textView3 = textView2;
                }
                float top2 = findViewByPosition.getTop();
                b2 = this.t.b();
                textView3.setY(top2 - b2);
            }
            i = this.t.mCurPos;
            if (i != findFirstVisibleItemPosition) {
                this.t.mCurPos = findFirstVisibleItemPosition;
                arrayList = this.t.mSpotList;
                i2 = this.t.mCurPos;
                java.lang.Object obj = arrayList.get(i2);
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(obj, "mSpotList[mCurPos]");
                com.moji.http.rapeflowers.RapeFlowersSpotResp.ListBean listBean = (com.moji.http.rapeflowers.RapeFlowersSpotResp.ListBean) obj;
                moji.com.mjweatherservicebase.list.BaseFlowersSpotListAdapter baseFlowersSpotListAdapter = this.t;
                int i4 = listBean.type;
                if (i4 == 4 || i4 == 7 || listBean.distance >= 300.0f) {
                    c = baseFlowersSpotListAdapter.c();
                    str = "mOuterStr";
                } else {
                    c = baseFlowersSpotListAdapter.a();
                    str = "mInnerStr";
                }
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(c, str);
                baseFlowersSpotListAdapter.mLabelText = c;
                this.t.e();
            }
        }
    }
}
