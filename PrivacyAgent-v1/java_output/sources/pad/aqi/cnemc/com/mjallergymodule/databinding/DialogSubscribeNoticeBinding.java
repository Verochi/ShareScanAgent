package pad.aqi.cnemc.com.mjallergymodule.databinding;

/* loaded from: classes21.dex */
public final class DialogSubscribeNoticeBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.TextView btnCancel;

    @androidx.annotation.NonNull
    public final android.widget.TextView btnMobile;

    @androidx.annotation.NonNull
    public final android.widget.TextView btnOk;

    @androidx.annotation.NonNull
    public final android.widget.CheckBox cbMessage;

    @androidx.annotation.NonNull
    public final android.widget.CheckBox cbPush;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout n;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvMobile;

    public DialogSubscribeNoticeBinding(@androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull android.widget.TextView textView3, @androidx.annotation.NonNull android.widget.CheckBox checkBox, @androidx.annotation.NonNull android.widget.CheckBox checkBox2, @androidx.annotation.NonNull android.widget.TextView textView4) {
        this.n = constraintLayout;
        this.btnCancel = textView;
        this.btnMobile = textView2;
        this.btnOk = textView3;
        this.cbMessage = checkBox;
        this.cbPush = checkBox2;
        this.tvMobile = textView4;
    }

    @androidx.annotation.NonNull
    public static pad.aqi.cnemc.com.mjallergymodule.databinding.DialogSubscribeNoticeBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = pad.aqi.cnemc.com.mjallergymodule.R.id.btn_cancel;
        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = pad.aqi.cnemc.com.mjallergymodule.R.id.btn_mobile;
            android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = pad.aqi.cnemc.com.mjallergymodule.R.id.btn_ok;
                android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (textView3 != null) {
                    i = pad.aqi.cnemc.com.mjallergymodule.R.id.cb_message;
                    android.widget.CheckBox checkBox = (android.widget.CheckBox) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (checkBox != null) {
                        i = pad.aqi.cnemc.com.mjallergymodule.R.id.cb_push;
                        android.widget.CheckBox checkBox2 = (android.widget.CheckBox) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (checkBox2 != null) {
                            i = pad.aqi.cnemc.com.mjallergymodule.R.id.tv_mobile;
                            android.widget.TextView textView4 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (textView4 != null) {
                                return new pad.aqi.cnemc.com.mjallergymodule.databinding.DialogSubscribeNoticeBinding((androidx.constraintlayout.widget.ConstraintLayout) view, textView, textView2, textView3, checkBox, checkBox2, textView4);
                            }
                        }
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static pad.aqi.cnemc.com.mjallergymodule.databinding.DialogSubscribeNoticeBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static pad.aqi.cnemc.com.mjallergymodule.databinding.DialogSubscribeNoticeBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(pad.aqi.cnemc.com.mjallergymodule.R.layout.dialog_subscribe_notice, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public androidx.constraintlayout.widget.ConstraintLayout getRoot() {
        return this.n;
    }
}
