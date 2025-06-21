package moji.com.mjweatherservicebase.card;

@kotlin.Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u001f\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0013\u001a\u00020\u000e¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0014J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0004H\u0014J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0002H\u0014R\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001c"}, d2 = {"Lmoji/com/mjweatherservicebase/card/HomePageRegionView;", "Lcom/moji/viewcontrol/MJViewControl;", "Lcom/moji/http/rapeflowers/RapeFlowersInfoResp$AreasBean;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", "v", "", "onClick", "", "getResLayoutId", com.anythink.expressad.a.B, "onCreatedView", "bean", "onBindViewData", "", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "D", "mLat", "t", "mLon", "Lmoji/com/mjweatherservicebase/databinding/LayoutHomepageRegionItemBinding;", com.umeng.analytics.pro.bo.aN, "Lmoji/com/mjweatherservicebase/databinding/LayoutHomepageRegionItemBinding;", "binding", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;DD)V", "MJWeatherServiceBase_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes20.dex */
public final class HomePageRegionView extends com.moji.viewcontrol.MJViewControl<com.moji.http.rapeflowers.RapeFlowersInfoResp.AreasBean> implements android.view.View.OnClickListener {

    /* renamed from: n, reason: from kotlin metadata */
    public double mLat;

    /* renamed from: t, reason: from kotlin metadata */
    public double mLon;

    /* renamed from: u, reason: from kotlin metadata */
    public moji.com.mjweatherservicebase.databinding.LayoutHomepageRegionItemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomePageRegionView(@org.jetbrains.annotations.NotNull android.content.Context context, double d, double d2) {
        super(context);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        this.mLat = d;
        this.mLon = d2;
    }

    public int getResLayoutId() {
        return moji.com.mjweatherservicebase.R.layout.layout_homepage_region_item;
    }

    public void onBindViewData(@org.jetbrains.annotations.NotNull com.moji.http.rapeflowers.RapeFlowersInfoResp.AreasBean bean) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bean, "bean");
        getView().setTag(bean);
        moji.com.mjweatherservicebase.databinding.LayoutHomepageRegionItemBinding layoutHomepageRegionItemBinding = this.binding;
        moji.com.mjweatherservicebase.databinding.LayoutHomepageRegionItemBinding layoutHomepageRegionItemBinding2 = null;
        if (layoutHomepageRegionItemBinding == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            layoutHomepageRegionItemBinding = null;
        }
        layoutHomepageRegionItemBinding.mRegionName.setText(bean.provinceName);
        moji.com.mjweatherservicebase.databinding.LayoutHomepageRegionItemBinding layoutHomepageRegionItemBinding3 = this.binding;
        if (layoutHomepageRegionItemBinding3 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            layoutHomepageRegionItemBinding2 = layoutHomepageRegionItemBinding3;
        }
        layoutHomepageRegionItemBinding2.mRegionNum.setText(com.moji.tool.DeviceTool.getStringById(moji.com.mjweatherservicebase.R.string.spot_num, new java.lang.Object[]{java.lang.Integer.valueOf(bean.num)}));
    }

    @Override // android.view.View.OnClickListener
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onClick(@org.jetbrains.annotations.Nullable android.view.View v) {
        if ((v != null ? v.getTag() : null) == null) {
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(v);
            return;
        }
        java.lang.Object tag = v.getTag();
        if (tag == null) {
            java.lang.NullPointerException nullPointerException = new java.lang.NullPointerException("null cannot be cast to non-null type com.moji.http.rapeflowers.RapeFlowersInfoResp.AreasBean");
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(v);
            throw nullPointerException;
        }
        com.moji.http.rapeflowers.RapeFlowersInfoResp.AreasBean areasBean = (com.moji.http.rapeflowers.RapeFlowersInfoResp.AreasBean) tag;
        moji.com.mjweatherservicebase.card.SpotJumpManager spotJumpManager = moji.com.mjweatherservicebase.card.SpotJumpManager.INSTANCE;
        int i = areasBean.provinceId;
        java.lang.String str = areasBean.provinceName;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(str, "bean.provinceName");
        spotJumpManager.openSpotListActivity(i, str, this.mLat, this.mLon, false);
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(v);
    }

    public void onCreatedView(@org.jetbrains.annotations.NotNull android.view.View view) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(view, "view");
        moji.com.mjweatherservicebase.databinding.LayoutHomepageRegionItemBinding bind = moji.com.mjweatherservicebase.databinding.LayoutHomepageRegionItemBinding.bind(view);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bind, "bind(view)");
        this.binding = bind;
        view.setOnClickListener(this);
    }
}
