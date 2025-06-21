package moji.com.mjweatherservicebase.view;

@kotlin.Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"moji/com/mjweatherservicebase/view/FlowersFeedbackDialog$getOnClickListener$1", "Lcom/moji/dialog/specific/MJSpecificDialog$OnViewClickListener;", "onClick", "", "viewHolder", "Lcom/moji/dialog/DialogViewHolder;", com.anythink.expressad.a.B, "Landroid/view/View;", "dialog", "Lcom/moji/dialog/specific/MJSpecificDialog;", "MJWeatherServiceBase_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes20.dex */
public final class FlowersFeedbackDialog$getOnClickListener$1 implements com.moji.dialog.specific.MJSpecificDialog.OnViewClickListener {
    public final /* synthetic */ moji.com.mjweatherservicebase.view.FlowersFeedbackDialog a;

    public FlowersFeedbackDialog$getOnClickListener$1(moji.com.mjweatherservicebase.view.FlowersFeedbackDialog flowersFeedbackDialog) {
        this.a = flowersFeedbackDialog;
    }

    public void onClick(@org.jetbrains.annotations.NotNull com.moji.dialog.DialogViewHolder viewHolder, @org.jetbrains.annotations.NotNull android.view.View view, @org.jetbrains.annotations.NotNull com.moji.dialog.specific.MJSpecificDialog dialog) {
        com.moji.dialog.specific.CheckBoxView checkBoxView;
        double d;
        double d2;
        int i;
        int i2;
        double d3;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(view, "view");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(dialog, "dialog");
        if (view.getId() != moji.com.mjweatherservicebase.R.id.mSendView) {
            this.a.dismiss();
            return;
        }
        checkBoxView = this.a.mCheckBoxView;
        kotlin.jvm.internal.Intrinsics.checkNotNull(checkBoxView);
        java.util.HashMap choices = checkBoxView.getChoices();
        java.lang.Object obj = choices.get(0);
        kotlin.jvm.internal.Intrinsics.checkNotNull(obj);
        if (((java.lang.Number) obj).intValue() <= -1) {
            com.moji.tool.ToastTool.showToast(moji.com.mjweatherservicebase.R.string.rapeflowers_select);
            return;
        }
        android.content.Context context = this.a.getContext();
        if (!com.moji.tool.DeviceTool.isConnected() || context == null) {
            com.moji.tool.toast.MJTipHelper.showFailTip(com.moji.tool.AppDelegate.getAppContext(), moji.com.mjweatherservicebase.R.string.rapeflowers_feedback_failure);
            return;
        }
        com.moji.dialog.MJDialog build = new com.moji.dialog.control.MJDialogLoadingControl.Builder(context).loadingMsg(moji.com.mjweatherservicebase.R.string.rapeflowers_loading).build();
        build.show();
        com.moji.common.area.AreaInfo locationArea = com.moji.areamanagement.MJAreaManager.getLocationArea();
        double d4 = -11111.0d;
        if (locationArea != null) {
            com.moji.location.entity.MJLocation historyLocation = com.moji.location.provider.HistoryLocationHelper.getHistoryLocation(com.moji.tool.AppDelegate.getAppContext(), com.moji.location.MJLocationSource.AMAP_LOCATION);
            if (historyLocation == null || !com.moji.location.util.LocationUtil.isLatLanValid(historyLocation.getLatitude(), historyLocation.getLongitude())) {
                d3 = -11111.0d;
            } else {
                d4 = historyLocation.getLatitude();
                d3 = historyLocation.getLongitude();
            }
            this.a.mCityId = locationArea.cityId;
            d = d4;
            d2 = d3;
        } else {
            com.moji.common.area.AreaInfo currentArea = com.moji.areamanagement.MJAreaManager.getCurrentArea();
            if (currentArea != null) {
                this.a.mCityId = currentArea.cityId;
            }
            d = -11111.0d;
            d2 = -11111.0d;
        }
        i = this.a.mSpotId;
        i2 = this.a.mCityId;
        java.lang.Object obj2 = choices.get(0);
        kotlin.jvm.internal.Intrinsics.checkNotNull(obj2);
        new com.moji.http.rapeflowers.RapeFlowersFeedBackRequest(i, i2, ((java.lang.Number) obj2).intValue() + 1, d, d2).execute(new moji.com.mjweatherservicebase.view.FlowersFeedbackDialog$getOnClickListener$1$onClick$1(build, this.a));
    }
}
