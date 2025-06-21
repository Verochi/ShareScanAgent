package moji.com.mjweatherservicebase.card;

@kotlin.Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\u0006\u0010\u001b\u001a\u00020\u0003¢\u0006\u0004\b\u001f\u0010 J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0014J\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0002H\u0014R\u0017\u0010\u0016\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001b\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lmoji/com/mjweatherservicebase/card/HomePageFeedbackView;", "Lcom/moji/viewcontrol/MJViewControl;", "Lcom/moji/http/me/MeServiceEntity$EntranceRegionResListBean$EntranceResListBean;", "", "getResLayoutId", "", com.anythink.expressad.foundation.h.i.g, "", "setBtnText", "Landroid/view/View;", com.anythink.expressad.a.B, "onCreatedView", "Landroid/widget/TextView;", "str", "setFeedbackText", "nearbyData", "onBindViewData", "Lcom/moji/base/MJActivity;", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Lcom/moji/base/MJActivity;", "getContext", "()Lcom/moji/base/MJActivity;", "context", "t", "I", "getMCityId", "()I", "mCityId", com.umeng.analytics.pro.bo.aN, "Ljava/lang/String;", "mBtnText", "<init>", "(Lcom/moji/base/MJActivity;I)V", "MJWeatherServiceBase_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes20.dex */
public final class HomePageFeedbackView extends com.moji.viewcontrol.MJViewControl<com.moji.http.me.MeServiceEntity.EntranceRegionResListBean.EntranceResListBean> {

    /* renamed from: n, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final com.moji.base.MJActivity context;

    /* renamed from: t, reason: from kotlin metadata */
    public final int mCityId;

    /* renamed from: u, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public java.lang.String mBtnText;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomePageFeedbackView(@org.jetbrains.annotations.NotNull com.moji.base.MJActivity context, int i) {
        super(context);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.mCityId = i;
        this.mBtnText = "点击反馈";
    }

    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public static final void b(moji.com.mjweatherservicebase.card.HomePageFeedbackView this$0, android.view.View view) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.moji.dialog.specific.MJSpecificDialog flowersFeedbackDialog = new moji.com.mjweatherservicebase.view.FlowersFeedbackDialog();
        androidx.fragment.app.FragmentTransaction beginTransaction = this$0.context.getSupportFragmentManager().beginTransaction();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(beginTransaction, "context.supportFragmentManager.beginTransaction()");
        beginTransaction.add((androidx.fragment.app.Fragment) flowersFeedbackDialog, (java.lang.String) null);
        beginTransaction.commitAllowingStateLoss();
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @org.jetbrains.annotations.NotNull
    public final com.moji.base.MJActivity getContext() {
        return this.context;
    }

    public final int getMCityId() {
        return this.mCityId;
    }

    public int getResLayoutId() {
        return moji.com.mjweatherservicebase.R.layout.layout_rflowers_feedback;
    }

    public void onBindViewData(@org.jetbrains.annotations.NotNull com.moji.http.me.MeServiceEntity.EntranceRegionResListBean.EntranceResListBean nearbyData) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nearbyData, "nearbyData");
    }

    public void onCreatedView(@org.jetbrains.annotations.NotNull android.view.View view) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(view, "view");
        android.view.View findViewById = view.findViewById(moji.com.mjweatherservicebase.R.id.mFeedbackView);
        if (findViewById == null) {
            throw new java.lang.NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        }
        setFeedbackText((android.widget.TextView) findViewById, this.mBtnText);
        findViewById.setOnClickListener(new defpackage.bo0(this));
    }

    public final void setBtnText(@org.jetbrains.annotations.NotNull java.lang.String string) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(string, "string");
        this.mBtnText = string;
    }

    public void setFeedbackText(@org.jetbrains.annotations.NotNull android.widget.TextView view, @org.jetbrains.annotations.NotNull java.lang.String str) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(view, "view");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "str");
        android.text.SpannableString spannableString = new android.text.SpannableString(str);
        spannableString.setSpan(new android.text.style.ForegroundColorSpan(com.moji.theme.AppThemeManager.getColor$default(this.context, moji.com.mjweatherservicebase.R.attr.moji_auto_blue, 0, 4, (java.lang.Object) null)), 2, 4, 18);
        view.setText(spannableString);
    }
}
