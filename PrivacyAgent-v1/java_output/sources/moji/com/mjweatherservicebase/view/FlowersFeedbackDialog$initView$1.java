package moji.com.mjweatherservicebase.view;

@kotlin.Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"moji/com/mjweatherservicebase/view/FlowersFeedbackDialog$initView$1", "Lcom/moji/dialog/specific/CheckBoxView$OnItemClick;", "onItemClick", "", "MJWeatherServiceBase_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes20.dex */
public final class FlowersFeedbackDialog$initView$1 implements com.moji.dialog.specific.CheckBoxView.OnItemClick {
    public final /* synthetic */ moji.com.mjweatherservicebase.view.FlowersFeedbackDialog a;
    public final /* synthetic */ android.view.View b;

    public FlowersFeedbackDialog$initView$1(moji.com.mjweatherservicebase.view.FlowersFeedbackDialog flowersFeedbackDialog, android.view.View view) {
        this.a = flowersFeedbackDialog;
        this.b = view;
    }

    public void onItemClick() {
        com.moji.dialog.specific.CheckBoxView checkBoxView;
        checkBoxView = this.a.mCheckBoxView;
        kotlin.jvm.internal.Intrinsics.checkNotNull(checkBoxView);
        java.util.HashMap choices = checkBoxView.getChoices();
        android.view.View view = this.b;
        java.lang.Object obj = choices.get(0);
        kotlin.jvm.internal.Intrinsics.checkNotNull(obj);
        view.setBackgroundResource(((java.lang.Number) obj).intValue() > -1 ? moji.com.mjweatherservicebase.R.drawable.mj_cp_select_dialog_btn_sure : moji.com.mjweatherservicebase.R.drawable.specific_dialog_disable_bg);
        com.moji.tool.log.MJLogger.d("RFlowersFeedbackDialog", "onItemClick: " + choices.get(0) + " ");
    }
}
