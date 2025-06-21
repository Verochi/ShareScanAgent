package moji.com.mjweatherservicebase.detail;

@kotlin.Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"moji/com/mjweatherservicebase/detail/BaseFlowersDetailActivity$initTitleBar$shareAction$1", "Lcom/moji/titlebar/ShareIconAction;", "performAction", "", com.anythink.expressad.a.B, "Landroid/view/View;", "MJWeatherServiceBase_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes20.dex */
public final class BaseFlowersDetailActivity$initTitleBar$shareAction$1 extends com.moji.titlebar.ShareIconAction {
    public final /* synthetic */ moji.com.mjweatherservicebase.detail.BaseFlowersDetailActivity d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseFlowersDetailActivity$initTitleBar$shareAction$1(moji.com.mjweatherservicebase.detail.BaseFlowersDetailActivity baseFlowersDetailActivity) {
        super(false, false, 2, (kotlin.jvm.internal.DefaultConstructorMarker) null);
        this.d = baseFlowersDetailActivity;
    }

    public void performAction(@org.jetbrains.annotations.NotNull android.view.View view) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(view, "view");
        this.d.doShare();
        this.d.eventShareClick();
    }
}
