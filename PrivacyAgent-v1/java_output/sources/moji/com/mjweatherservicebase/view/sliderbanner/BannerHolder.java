package moji.com.mjweatherservicebase.view.sliderbanner;

@kotlin.Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Lmoji/com/mjweatherservicebase/view/sliderbanner/BannerHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/moji/http/me/MeServiceEntity$EntranceRegionResListBean$EntranceResListBean;", "data", "Lcom/moji/opevent/OperationEventPage;", "type", "", "bindData", "Lmoji/com/mjweatherservicebase/databinding/ItemBannerPagerBinding;", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Lmoji/com/mjweatherservicebase/databinding/ItemBannerPagerBinding;", "binding", "Landroid/view/View;", com.anythink.expressad.a.B, "<init>", "(Landroid/view/View;)V", "MJWeatherServiceBase_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes20.dex */
public final class BannerHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {

    /* renamed from: n, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final moji.com.mjweatherservicebase.databinding.ItemBannerPagerBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BannerHolder(@org.jetbrains.annotations.NotNull android.view.View view) {
        super(view);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(view, "view");
        moji.com.mjweatherservicebase.databinding.ItemBannerPagerBinding bind = moji.com.mjweatherservicebase.databinding.ItemBannerPagerBinding.bind(view);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bind, "bind(view)");
        this.binding = bind;
    }

    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public static final void b(com.moji.opevent.OperationEventPage operationEventPage, android.view.View view) {
        if (!com.moji.tool.Utils.canClick()) {
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        java.lang.Object tag = view.getTag();
        com.moji.http.me.MeServiceEntity.EntranceRegionResListBean.EntranceResListBean entranceResListBean = tag instanceof com.moji.http.me.MeServiceEntity.EntranceRegionResListBean.EntranceResListBean ? (com.moji.http.me.MeServiceEntity.EntranceRegionResListBean.EntranceResListBean) tag : null;
        if (entranceResListBean == null) {
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        com.moji.share.EventJumpTool.processJump(entranceResListBean.link_type, entranceResListBean.link_sub_type, entranceResListBean.link_param);
        if (operationEventPage == com.moji.opevent.OperationEventPage.P_ALLERGY) {
            com.moji.statistics.EventManager.getInstance().notifEvent(com.moji.statistics.EVENT_TAG2.MAIN_VIP_ALLERGY_BANNER_CK, java.lang.String.valueOf(entranceResListBean.entrance_id));
        } else if (operationEventPage == com.moji.opevent.OperationEventPage.P_FLU) {
            com.moji.statistics.EventManager.getInstance().notifEvent(com.moji.statistics.EVENT_TAG2.MAIN_VIP_FLU_BANNER_CK, java.lang.String.valueOf(entranceResListBean.entrance_id));
        }
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void bindData(@org.jetbrains.annotations.NotNull com.moji.http.me.MeServiceEntity.EntranceRegionResListBean.EntranceResListBean data, @org.jetbrains.annotations.Nullable com.moji.opevent.OperationEventPage type) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(data, "data");
        moji.com.mjweatherservicebase.databinding.ItemBannerPagerBinding itemBannerPagerBinding = this.binding;
        com.moji.glide.util.ImageUtils.loadImage(itemBannerPagerBinding.getRoot().getContext(), data.picture_path, itemBannerPagerBinding.ivPoster);
        this.binding.getRoot().setTag(data);
        this.binding.getRoot().setOnClickListener(new defpackage.ig(type));
    }
}
