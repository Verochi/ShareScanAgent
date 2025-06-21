package moji.com.mjweatherservicebase.view;

@kotlin.Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\t"}, d2 = {"moji/com/mjweatherservicebase/view/FlowersFeedbackDialog$getOnClickListener$1$onClick$1", "Lcom/moji/requestcore/MJBaseHttpCallback;", "Lcom/moji/requestcore/entity/MJBaseRespRc;", "onFailed", "", "e", "Lcom/moji/requestcore/MJException;", "onSuccess", "result", "MJWeatherServiceBase_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes20.dex */
public final class FlowersFeedbackDialog$getOnClickListener$1$onClick$1 extends com.moji.requestcore.MJBaseHttpCallback<com.moji.requestcore.entity.MJBaseRespRc> {
    public final /* synthetic */ com.moji.dialog.MJDialog n;
    public final /* synthetic */ moji.com.mjweatherservicebase.view.FlowersFeedbackDialog t;

    public FlowersFeedbackDialog$getOnClickListener$1$onClick$1(com.moji.dialog.MJDialog mJDialog, moji.com.mjweatherservicebase.view.FlowersFeedbackDialog flowersFeedbackDialog) {
        this.n = mJDialog;
        this.t = flowersFeedbackDialog;
    }

    public void onFailed(@org.jetbrains.annotations.Nullable com.moji.requestcore.MJException e) {
        com.moji.tool.toast.MJTipHelper.showFailTip(com.moji.tool.AppDelegate.getAppContext(), moji.com.mjweatherservicebase.R.string.rapeflowers_feedback_failure);
    }

    public void onSuccess(@org.jetbrains.annotations.Nullable com.moji.requestcore.entity.MJBaseRespRc result) {
        this.n.dismiss();
        if (result == null || !result.OK()) {
            onFailed(null);
            return;
        }
        com.moji.tool.toast.MJTipHelper.showSuccessTip(com.moji.tool.AppDelegate.getAppContext(), moji.com.mjweatherservicebase.R.string.rapeflowers_feedback_success);
        this.t.mStatDismiss = false;
        this.t.dismiss();
    }
}
