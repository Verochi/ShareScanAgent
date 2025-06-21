package moji.com.mjweatherservicebase.detail;

@kotlin.Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"moji/com/mjweatherservicebase/detail/BaseFlowersDetailActivity$initTitleBar$subAction$1", "Lmoji/com/mjweatherservicebase/view/SubscribeIconAction;", "performAction", "", com.anythink.expressad.a.B, "Landroid/view/View;", "MJWeatherServiceBase_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes20.dex */
public final class BaseFlowersDetailActivity$initTitleBar$subAction$1 extends moji.com.mjweatherservicebase.view.SubscribeIconAction {
    public final /* synthetic */ moji.com.mjweatherservicebase.detail.BaseFlowersDetailActivity e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseFlowersDetailActivity$initTitleBar$subAction$1(moji.com.mjweatherservicebase.detail.BaseFlowersDetailActivity baseFlowersDetailActivity) {
        super(false, 1, null);
        this.e = baseFlowersDetailActivity;
    }

    public void performAction(@org.jetbrains.annotations.NotNull android.view.View view) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(view, "view");
        com.moji.router.MJRouter.getInstance().build("member/remindv2").withInt(com.tencent.open.SocialConstants.PARAM_SOURCE, this.e.getVipFrom()).start(this.e, moji.com.mjweatherservicebase.detail.BaseFlowersDetailActivity.INSTANCE.getVIP_SUB_REQUEST_CODE());
    }
}
