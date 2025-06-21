package moji.com.mjweather.databinding;

/* loaded from: classes31.dex */
public final class ActivityAccountPhoneValidateViewBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.CheckBox cbTreaty;

    @androidx.annotation.NonNull
    public final android.widget.TextView knowCool;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout llTreatyLayout;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout n;

    @androidx.annotation.NonNull
    public final com.moji.titlebar.MJTitleBar titleBar;

    @androidx.annotation.NonNull
    public final android.widget.TextView treatyTip;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvAction;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvCheckbox;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvErrorInfo;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvHint;

    @androidx.annotation.NonNull
    public final android.view.ViewStub vsLoginSnscode;

    public ActivityAccountPhoneValidateViewBinding(@androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull android.widget.CheckBox checkBox, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout2, @androidx.annotation.NonNull com.moji.titlebar.MJTitleBar mJTitleBar, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull android.widget.TextView textView3, @androidx.annotation.NonNull android.widget.TextView textView4, @androidx.annotation.NonNull android.widget.TextView textView5, @androidx.annotation.NonNull android.widget.TextView textView6, @androidx.annotation.NonNull android.view.ViewStub viewStub) {
        this.n = constraintLayout;
        this.cbTreaty = checkBox;
        this.knowCool = textView;
        this.llTreatyLayout = constraintLayout2;
        this.titleBar = mJTitleBar;
        this.treatyTip = textView2;
        this.tvAction = textView3;
        this.tvCheckbox = textView4;
        this.tvErrorInfo = textView5;
        this.tvHint = textView6;
        this.vsLoginSnscode = viewStub;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivityAccountPhoneValidateViewBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.titlebar.MJTitleBar findChildViewById;
        int i = moji.com.mjweather.R.id.cb_treaty;
        android.widget.CheckBox checkBox = (android.widget.CheckBox) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (checkBox != null) {
            i = moji.com.mjweather.R.id.know_cool;
            android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = moji.com.mjweather.R.id.ll_treaty_layout;
                androidx.constraintlayout.widget.ConstraintLayout constraintLayout = (androidx.constraintlayout.widget.ConstraintLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (constraintLayout != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.title_bar))) != null) {
                    i = moji.com.mjweather.R.id.treaty_tip;
                    android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = moji.com.mjweather.R.id.tv_action;
                        android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            i = moji.com.mjweather.R.id.tv_checkbox;
                            android.widget.TextView textView4 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (textView4 != null) {
                                i = moji.com.mjweather.R.id.tv_error_info;
                                android.widget.TextView textView5 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (textView5 != null) {
                                    i = moji.com.mjweather.R.id.tv_hint;
                                    android.widget.TextView textView6 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                    if (textView6 != null) {
                                        i = moji.com.mjweather.R.id.vs_login_snscode;
                                        android.view.ViewStub viewStub = (android.view.ViewStub) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                        if (viewStub != null) {
                                            return new moji.com.mjweather.databinding.ActivityAccountPhoneValidateViewBinding((androidx.constraintlayout.widget.ConstraintLayout) view, checkBox, textView, constraintLayout, findChildViewById, textView2, textView3, textView4, textView5, textView6, viewStub);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivityAccountPhoneValidateViewBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivityAccountPhoneValidateViewBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.activity_account_phone_validate_view, viewGroup, false);
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
