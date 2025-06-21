package moji.com.mjweather.databinding;

/* loaded from: classes31.dex */
public final class ActivityAccountFindPassUseEmailBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.CheckBox cbTreaty;

    @androidx.annotation.NonNull
    public final android.widget.ImageView emailClear;

    @androidx.annotation.NonNull
    public final android.widget.EditText etLoginInput;

    @androidx.annotation.NonNull
    public final android.widget.TextView knowCool;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout llTreatyLayout;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout n;

    @androidx.annotation.NonNull
    public final com.moji.titlebar.MJTitleBar settingPhoneFindPasswordByEmail;

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

    public ActivityAccountFindPassUseEmailBinding(@androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull android.widget.CheckBox checkBox, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.EditText editText, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout2, @androidx.annotation.NonNull com.moji.titlebar.MJTitleBar mJTitleBar, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull android.widget.TextView textView3, @androidx.annotation.NonNull android.widget.TextView textView4, @androidx.annotation.NonNull android.widget.TextView textView5, @androidx.annotation.NonNull android.widget.TextView textView6) {
        this.n = constraintLayout;
        this.cbTreaty = checkBox;
        this.emailClear = imageView;
        this.etLoginInput = editText;
        this.knowCool = textView;
        this.llTreatyLayout = constraintLayout2;
        this.settingPhoneFindPasswordByEmail = mJTitleBar;
        this.treatyTip = textView2;
        this.tvAction = textView3;
        this.tvCheckbox = textView4;
        this.tvErrorInfo = textView5;
        this.tvHint = textView6;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivityAccountFindPassUseEmailBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.titlebar.MJTitleBar findChildViewById;
        int i = moji.com.mjweather.R.id.cb_treaty;
        android.widget.CheckBox checkBox = (android.widget.CheckBox) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (checkBox != null) {
            i = moji.com.mjweather.R.id.email_clear;
            android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = moji.com.mjweather.R.id.et_login_input;
                android.widget.EditText editText = (android.widget.EditText) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (editText != null) {
                    i = moji.com.mjweather.R.id.know_cool;
                    android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = moji.com.mjweather.R.id.ll_treaty_layout;
                        androidx.constraintlayout.widget.ConstraintLayout constraintLayout = (androidx.constraintlayout.widget.ConstraintLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (constraintLayout != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.setting_phone_find_password_by_email))) != null) {
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
                                                return new moji.com.mjweather.databinding.ActivityAccountFindPassUseEmailBinding((androidx.constraintlayout.widget.ConstraintLayout) view, checkBox, imageView, editText, textView, constraintLayout, findChildViewById, textView2, textView3, textView4, textView5, textView6);
                                            }
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
    public static moji.com.mjweather.databinding.ActivityAccountFindPassUseEmailBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivityAccountFindPassUseEmailBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.activity_account_find_pass_use_email, viewGroup, false);
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
