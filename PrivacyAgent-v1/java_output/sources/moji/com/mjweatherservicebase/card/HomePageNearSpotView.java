package moji.com.mjweatherservicebase.card;

@kotlin.Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\u0012\u0006\u00100\u001a\u00020/\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0013\u001a\u00020\u000e¢\u0006\u0004\b1\u00102J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0014R\u0014\u0010\r\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010R#\u0010\u001a\u001a\n \u0015*\u0004\u0018\u00010\u00140\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R#\u0010\u001e\u001a\n \u0015*\u0004\u0018\u00010\u00050\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u001c\u0010\u001dR#\u0010!\u001a\n \u0015*\u0004\u0018\u00010\u00050\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0017\u001a\u0004\b \u0010\u001dR#\u0010&\u001a\n \u0015*\u0004\u0018\u00010\"0\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0017\u001a\u0004\b$\u0010%R\u001b\u0010+\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\u0017\u001a\u0004\b)\u0010*R\u0018\u0010.\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-¨\u00063"}, d2 = {"Lmoji/com/mjweatherservicebase/card/HomePageNearSpotView;", "Lcom/moji/viewcontrol/MJViewControl;", "Lcom/moji/http/rapeflowers/RapeFlowersInfoResp;", "", "getResLayoutId", "Landroid/view/View;", com.anythink.expressad.a.B, "", "onCreatedView", "nearbyData", "onBindViewData", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "I", "mCityId", "", "t", "D", "mLat", com.umeng.analytics.pro.bo.aN, "mLon", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "v", "Lkotlin/Lazy;", "k", "()Landroid/widget/TextView;", "mLabel", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH, "j", "()Landroid/view/View;", "mEmptyView", "x", "l", "mMoreView", "Landroidx/recyclerview/widget/RecyclerView;", "y", com.anythink.expressad.d.a.b.dH, "()Landroidx/recyclerview/widget/RecyclerView;", "mRecyclerView", "Lmoji/com/mjweatherservicebase/card/HomePageNearSpotAdapter;", com.umeng.analytics.pro.bo.aJ, "i", "()Lmoji/com/mjweatherservicebase/card/HomePageNearSpotAdapter;", "mAdapter", androidx.exifinterface.media.ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/moji/http/rapeflowers/RapeFlowersInfoResp;", "mNearbyData", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;IDD)V", "MJWeatherServiceBase_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes20.dex */
public final class HomePageNearSpotView extends com.moji.viewcontrol.MJViewControl<com.moji.http.rapeflowers.RapeFlowersInfoResp> {

    /* renamed from: A, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public com.moji.http.rapeflowers.RapeFlowersInfoResp mNearbyData;

    /* renamed from: n, reason: from kotlin metadata */
    public final int mCityId;

    /* renamed from: t, reason: from kotlin metadata */
    public final double mLat;

    /* renamed from: u, reason: from kotlin metadata */
    public final double mLon;

    /* renamed from: v, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final kotlin.Lazy mLabel;

    /* renamed from: w, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final kotlin.Lazy mEmptyView;

    /* renamed from: x, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final kotlin.Lazy mMoreView;

    /* renamed from: y, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final kotlin.Lazy mRecyclerView;

    /* renamed from: z, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final kotlin.Lazy mAdapter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomePageNearSpotView(@org.jetbrains.annotations.NotNull android.content.Context context, int i, double d, double d2) {
        super(context);
        kotlin.Lazy lazy;
        kotlin.Lazy lazy2;
        kotlin.Lazy lazy3;
        kotlin.Lazy lazy4;
        kotlin.Lazy lazy5;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        this.mCityId = i;
        this.mLat = d;
        this.mLon = d2;
        lazy = kotlin.LazyKt__LazyJVMKt.lazy(new moji.com.mjweatherservicebase.card.HomePageNearSpotView$mLabel$2(this));
        this.mLabel = lazy;
        lazy2 = kotlin.LazyKt__LazyJVMKt.lazy(new moji.com.mjweatherservicebase.card.HomePageNearSpotView$mEmptyView$2(this));
        this.mEmptyView = lazy2;
        lazy3 = kotlin.LazyKt__LazyJVMKt.lazy(new moji.com.mjweatherservicebase.card.HomePageNearSpotView$mMoreView$2(this));
        this.mMoreView = lazy3;
        lazy4 = kotlin.LazyKt__LazyJVMKt.lazy(new moji.com.mjweatherservicebase.card.HomePageNearSpotView$mRecyclerView$2(this));
        this.mRecyclerView = lazy4;
        lazy5 = kotlin.LazyKt__LazyJVMKt.lazy(new moji.com.mjweatherservicebase.card.HomePageNearSpotView$mAdapter$2(context, this));
        this.mAdapter = lazy5;
    }

    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public static final void n(moji.com.mjweatherservicebase.card.HomePageNearSpotView this$0, android.view.View view) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        moji.com.mjweatherservicebase.BaseFlowersMainPresenter flowersMainPresenter = moji.com.mjweatherservicebase.BaseHomePageActivity.INSTANCE.getFlowersMainPresenter();
        if (flowersMainPresenter != null) {
            flowersMainPresenter.nearbyMoreClick(this$0.mCityId, true, this$0.mLat, this$0.mLon);
        }
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public int getResLayoutId() {
        return moji.com.mjweatherservicebase.R.layout.layout_homepage_nearspot;
    }

    public final moji.com.mjweatherservicebase.card.HomePageNearSpotAdapter i() {
        return (moji.com.mjweatherservicebase.card.HomePageNearSpotAdapter) this.mAdapter.getValue();
    }

    public final android.view.View j() {
        return (android.view.View) this.mEmptyView.getValue();
    }

    public final android.widget.TextView k() {
        return (android.widget.TextView) this.mLabel.getValue();
    }

    public final android.view.View l() {
        return (android.view.View) this.mMoreView.getValue();
    }

    public final androidx.recyclerview.widget.RecyclerView m() {
        return (androidx.recyclerview.widget.RecyclerView) this.mRecyclerView.getValue();
    }

    public void onBindViewData(@org.jetbrains.annotations.NotNull com.moji.http.rapeflowers.RapeFlowersInfoResp nearbyData) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nearbyData, "nearbyData");
        this.mNearbyData = nearbyData;
        android.widget.TextView k = k();
        moji.com.mjweatherservicebase.BaseHomePageActivity.Companion companion = moji.com.mjweatherservicebase.BaseHomePageActivity.INSTANCE;
        moji.com.mjweatherservicebase.BaseFlowersMainPresenter flowersMainPresenter = companion.getFlowersMainPresenter();
        k.setText(flowersMainPresenter != null ? flowersMainPresenter.getNearbyTitle() : null);
        java.util.List list = nearbyData.list;
        if (list == null || list.isEmpty()) {
            j().setVisibility(0);
            l().setVisibility(4);
            m().setVisibility(8);
            return;
        }
        j().setVisibility(8);
        m().setVisibility(0);
        moji.com.mjweatherservicebase.BaseFlowersMainPresenter flowersMainPresenter2 = companion.getFlowersMainPresenter();
        kotlin.jvm.internal.Intrinsics.checkNotNull(flowersMainPresenter2);
        if (flowersMainPresenter2.needShowMoreView()) {
            l().setVisibility(0);
            l().setOnClickListener(new defpackage.co0(this));
        } else {
            l().setVisibility(8);
        }
        i().updateData(nearbyData.list);
    }

    public void onCreatedView(@org.jetbrains.annotations.NotNull android.view.View view) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(view, "view");
        m().addItemDecoration(new com.moji.member.view.RecyclerViewDirection(com.moji.tool.DeviceTool.dp2px(10.0f), true));
        m().setAdapter(i());
        m().addOnScrollListener(new moji.com.mjweatherservicebase.card.HomePageNearSpotView$onCreatedView$1());
    }
}
