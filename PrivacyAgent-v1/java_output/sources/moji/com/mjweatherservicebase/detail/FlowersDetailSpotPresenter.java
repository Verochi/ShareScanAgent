package moji.com.mjweatherservicebase.detail;

@kotlin.Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u001c\u0010\u001dJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001e"}, d2 = {"Lmoji/com/mjweatherservicebase/detail/FlowersDetailSpotPresenter;", "", "Lcom/moji/http/rapeflowers/RapeFlowersDetailResp;", "sakuraDetailInfo", "", "setData", "", "a", "I", "mFlowerType", "Landroid/widget/TextView;", "b", "Landroid/widget/TextView;", "mDetailInfomationView03", "c", "mSpotIntroduce", "Landroid/widget/LinearLayout;", "d", "Landroid/widget/LinearLayout;", "llTrafficLayout", "e", "llIntroduceLayout", "Lmoji/com/mjweatherservicebase/detail/FDetailLiveVerticalLayout;", "f", "Lmoji/com/mjweatherservicebase/detail/FDetailLiveVerticalLayout;", "detailLiveVerticalLayout", "Landroid/view/View;", "rootView", "<init>", "(Landroid/view/View;I)V", "MJWeatherServiceBase_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes20.dex */
public final class FlowersDetailSpotPresenter {

    /* renamed from: a, reason: from kotlin metadata */
    public final int mFlowerType;

    /* renamed from: b, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final android.widget.TextView mDetailInfomationView03;

    /* renamed from: c, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final android.widget.TextView mSpotIntroduce;

    /* renamed from: d, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final android.widget.LinearLayout llTrafficLayout;

    /* renamed from: e, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final android.widget.LinearLayout llIntroduceLayout;

    /* renamed from: f, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final moji.com.mjweatherservicebase.detail.FDetailLiveVerticalLayout detailLiveVerticalLayout;

    public FlowersDetailSpotPresenter(@org.jetbrains.annotations.NotNull android.view.View rootView, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(rootView, "rootView");
        this.mFlowerType = i;
        android.view.View findViewById = rootView.findViewById(moji.com.mjweatherservicebase.R.id.ll_detail_introduce_layout);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.…_detail_introduce_layout)");
        this.llIntroduceLayout = (android.widget.LinearLayout) findViewById;
        android.view.View findViewById2 = rootView.findViewById(moji.com.mjweatherservicebase.R.id.ll_detail_traffic_layout);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.…ll_detail_traffic_layout)");
        this.llTrafficLayout = (android.widget.LinearLayout) findViewById2;
        android.view.View findViewById3 = rootView.findViewById(moji.com.mjweatherservicebase.R.id.detail_vertical_live_view);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.…etail_vertical_live_view)");
        this.detailLiveVerticalLayout = (moji.com.mjweatherservicebase.detail.FDetailLiveVerticalLayout) findViewById3;
        android.view.View findViewById4 = rootView.findViewById(moji.com.mjweatherservicebase.R.id.spot_introduce);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.spot_introduce)");
        this.mSpotIntroduce = (android.widget.TextView) findViewById4;
        android.view.View findViewById5 = rootView.findViewById(moji.com.mjweatherservicebase.R.id.sakura_spot_bus);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.id.sakura_spot_bus)");
        this.mDetailInfomationView03 = (android.widget.TextView) findViewById5;
    }

    public final void setData(@org.jetbrains.annotations.NotNull com.moji.http.rapeflowers.RapeFlowersDetailResp sakuraDetailInfo) {
        boolean contains$default;
        java.lang.String str;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sakuraDetailInfo, "sakuraDetailInfo");
        if (android.text.TextUtils.isEmpty(sakuraDetailInfo.spot_desc)) {
            this.llIntroduceLayout.setVisibility(8);
        } else {
            this.mSpotIntroduce.setText(sakuraDetailInfo.spot_desc);
            if (this.mFlowerType == 45) {
                this.detailLiveVerticalLayout.setVisibility(0);
                this.detailLiveVerticalLayout.loadSpotPicture(this.mFlowerType);
            }
        }
        if (android.text.TextUtils.isEmpty(sakuraDetailInfo.spot_traffic)) {
            this.llTrafficLayout.setVisibility(8);
            return;
        }
        this.llTrafficLayout.setVisibility(0);
        android.widget.TextView textView = this.mDetailInfomationView03;
        java.lang.String str2 = sakuraDetailInfo.spot_traffic;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(str2, "sakuraDetailInfo.spot_traffic");
        contains$default = kotlin.text.StringsKt__StringsKt.contains$default((java.lang.CharSequence) str2, (java.lang.CharSequence) "\n", false, 2, (java.lang.Object) null);
        if (contains$default) {
            java.lang.String str3 = sakuraDetailInfo.spot_traffic;
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(str3, "sakuraDetailInfo.spot_traffic");
            str = kotlin.text.StringsKt__StringsJVMKt.replace$default(str3, "\n", "", false, 4, (java.lang.Object) null);
        } else {
            str = sakuraDetailInfo.spot_traffic;
        }
        textView.setText(str);
    }
}
