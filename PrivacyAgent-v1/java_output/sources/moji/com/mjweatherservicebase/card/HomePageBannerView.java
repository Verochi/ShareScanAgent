package moji.com.mjweatherservicebase.card;

@kotlin.Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0014R\u0016\u0010\r\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lmoji/com/mjweatherservicebase/card/HomePageBannerView;", "Lcom/moji/viewcontrol/MJViewControl;", "Lcom/moji/http/me/MeServiceEntity$EntranceRegionResListBean$EntranceResListBean;", "", "getResLayoutId", "Landroid/view/View;", com.anythink.expressad.a.B, "", "onCreatedView", "nearbyData", "onBindViewData", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Lcom/moji/http/me/MeServiceEntity$EntranceRegionResListBean$EntranceResListBean;", "url", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/moji/http/me/MeServiceEntity$EntranceRegionResListBean$EntranceResListBean;)V", "MJWeatherServiceBase_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes20.dex */
public final class HomePageBannerView extends com.moji.viewcontrol.MJViewControl<com.moji.http.me.MeServiceEntity.EntranceRegionResListBean.EntranceResListBean> {

    /* renamed from: n, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public final com.moji.http.me.MeServiceEntity.EntranceRegionResListBean.EntranceResListBean url;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomePageBannerView(@org.jetbrains.annotations.NotNull android.content.Context context, @org.jetbrains.annotations.Nullable com.moji.http.me.MeServiceEntity.EntranceRegionResListBean.EntranceResListBean entranceResListBean) {
        super(context);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        this.url = entranceResListBean;
    }

    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public static final void b(moji.com.mjweatherservicebase.card.HomePageBannerView this$0, android.view.View view) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.moji.statistics.EventManager.getInstance().notifEvent(com.moji.statistics.EVENT_TAG2.MAIN_SERVICE_COLEFLOWERSTOP_BANNER_CK);
        com.moji.http.me.MeServiceEntity.EntranceRegionResListBean.EntranceResListBean entranceResListBean = this$0.url;
        com.moji.share.EventJumpTool.processJump(entranceResListBean.link_type, entranceResListBean.link_sub_type, entranceResListBean.link_param);
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public int getResLayoutId() {
        return moji.com.mjweatherservicebase.R.layout.layout_rflowers_banner;
    }

    public void onBindViewData(@org.jetbrains.annotations.NotNull com.moji.http.me.MeServiceEntity.EntranceRegionResListBean.EntranceResListBean nearbyData) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nearbyData, "nearbyData");
    }

    public void onCreatedView(@org.jetbrains.annotations.NotNull android.view.View view) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(view, "view");
        if (this.url == null) {
            return;
        }
        android.widget.ImageView imageView = (android.widget.ImageView) view.findViewById(moji.com.mjweatherservicebase.R.id.mImageView);
        com.moji.glide.util.ImageUtils.loadImage(imageView, this.url.picture_path);
        imageView.setOnClickListener(new defpackage.ao0(this));
    }
}
