package moji.com.mjweatherservicebase.card;

@kotlin.Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0014J\u0012\u0010\r\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002R\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Lmoji/com/mjweatherservicebase/card/HomePageBestDateView;", "Lcom/moji/viewcontrol/MJViewControl;", "Lcom/moji/http/rapeflowers/RapeFlowersInfoResp;", "", "getResLayoutId", "Landroid/view/View;", com.anythink.expressad.a.B, "", "onCreatedView", "flowerData", "onBindViewData", "", "dateString", "a", "Lmoji/com/mjweatherservicebase/databinding/LayoutHomepageFlowerDateBinding;", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Lmoji/com/mjweatherservicebase/databinding/LayoutHomepageFlowerDateBinding;", "binding", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "MJWeatherServiceBase_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes20.dex */
public final class HomePageBestDateView extends com.moji.viewcontrol.MJViewControl<com.moji.http.rapeflowers.RapeFlowersInfoResp> {

    /* renamed from: n, reason: from kotlin metadata */
    public moji.com.mjweatherservicebase.databinding.LayoutHomepageFlowerDateBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomePageBestDateView(@org.jetbrains.annotations.NotNull android.content.Context context) {
        super(context);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
    }

    public final java.lang.String a(java.lang.String dateString) {
        if (dateString == null || dateString.length() == 0) {
            return "";
        }
        try {
            java.util.Date parse = new java.text.SimpleDateFormat("yyyyMMdd", java.util.Locale.getDefault()).parse(dateString);
            java.util.Calendar calendar = java.util.Calendar.getInstance();
            kotlin.jvm.internal.Intrinsics.checkNotNull(parse);
            calendar.setTime(parse);
            return (calendar.get(2) + 1) + "月" + calendar.get(5) + "日结束";
        } catch (java.text.ParseException e) {
            e.printStackTrace();
            return "";
        }
    }

    public int getResLayoutId() {
        return moji.com.mjweatherservicebase.R.layout.layout_homepage_flower_date;
    }

    public void onBindViewData(@org.jetbrains.annotations.NotNull com.moji.http.rapeflowers.RapeFlowersInfoResp flowerData) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(flowerData, "flowerData");
        com.moji.http.rapeflowers.RapeFlowersSpotResp.ListBean listBean = (com.moji.http.rapeflowers.RapeFlowersSpotResp.ListBean) flowerData.list.get(0);
        moji.com.mjweatherservicebase.databinding.LayoutHomepageFlowerDateBinding layoutHomepageFlowerDateBinding = this.binding;
        moji.com.mjweatherservicebase.databinding.LayoutHomepageFlowerDateBinding layoutHomepageFlowerDateBinding2 = null;
        if (layoutHomepageFlowerDateBinding == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            layoutHomepageFlowerDateBinding = null;
        }
        android.widget.TextView textView = layoutHomepageFlowerDateBinding.preDateName;
        java.lang.String str = listBean.spot_prev_state;
        textView.setText(str == null || str.length() == 0 ? "无" : listBean.spot_prev_state);
        moji.com.mjweatherservicebase.databinding.LayoutHomepageFlowerDateBinding layoutHomepageFlowerDateBinding3 = this.binding;
        if (layoutHomepageFlowerDateBinding3 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            layoutHomepageFlowerDateBinding3 = null;
        }
        layoutHomepageFlowerDateBinding3.preDateExact.setText(a(listBean.spot_prev_state_time));
        moji.com.mjweatherservicebase.databinding.LayoutHomepageFlowerDateBinding layoutHomepageFlowerDateBinding4 = this.binding;
        if (layoutHomepageFlowerDateBinding4 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            layoutHomepageFlowerDateBinding4 = null;
        }
        android.widget.TextView textView2 = layoutHomepageFlowerDateBinding4.nextDateName;
        java.lang.String str2 = listBean.spot_next_state;
        textView2.setText(str2 == null || str2.length() == 0 ? "无" : listBean.spot_next_state);
        moji.com.mjweatherservicebase.databinding.LayoutHomepageFlowerDateBinding layoutHomepageFlowerDateBinding5 = this.binding;
        if (layoutHomepageFlowerDateBinding5 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            layoutHomepageFlowerDateBinding5 = null;
        }
        layoutHomepageFlowerDateBinding5.nextDateExact.setText(a(listBean.spot_next_state_time));
        moji.com.mjweatherservicebase.databinding.LayoutHomepageFlowerDateBinding layoutHomepageFlowerDateBinding6 = this.binding;
        if (layoutHomepageFlowerDateBinding6 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            layoutHomepageFlowerDateBinding2 = layoutHomepageFlowerDateBinding6;
        }
        layoutHomepageFlowerDateBinding2.currentDateName.setText(listBean.spot_state);
    }

    public void onCreatedView(@org.jetbrains.annotations.NotNull android.view.View view) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(view, "view");
        moji.com.mjweatherservicebase.databinding.LayoutHomepageFlowerDateBinding bind = moji.com.mjweatherservicebase.databinding.LayoutHomepageFlowerDateBinding.bind(view);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bind, "bind(view)");
        this.binding = bind;
    }
}
