package moji.com.mjweather.databinding;

/* loaded from: classes31.dex */
public final class ActivityAccountEmailPhoneLoginBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.CheckBox cbTreaty;

    @androidx.annotation.NonNull
    public final android.widget.TextView knowCool;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout layoutBottom;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout layoutTop;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout llTreatyLayout;

    @androidx.annotation.NonNull
    public final android.widget.ImageView loginBg;

    @androidx.annotation.NonNull
    public final android.widget.ImageView loginBgCoverImg;

    @androidx.annotation.NonNull
    public final com.moji.titlebar.MJTitleBar loginByUsernameTitlebar;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout n;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout rootLayout;

    @androidx.annotation.NonNull
    public final com.moji.imageview.RoundCornerImageView titleIndicator;

    @androidx.annotation.NonNull
    public final android.widget.TextView treatyTip;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvActionLogin;

    @androidx.annotation.NonNull
    public final androidx.appcompat.widget.AppCompatTextView tvCheckbox;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvErrorInfo;

    @androidx.annotation.NonNull
    public final android.view.ViewStub vsLoginSnscode;

    @androidx.annotation.NonNull
    public final android.view.ViewStub vsLoginUsername;

    public ActivityAccountEmailPhoneLoginBinding(@androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull android.widget.CheckBox checkBox, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout2, @androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout2, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.ImageView imageView2, @androidx.annotation.NonNull com.moji.titlebar.MJTitleBar mJTitleBar, @androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout3, @androidx.annotation.NonNull com.moji.imageview.RoundCornerImageView roundCornerImageView, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull android.widget.TextView textView3, @androidx.annotation.NonNull androidx.appcompat.widget.AppCompatTextView appCompatTextView, @androidx.annotation.NonNull android.widget.TextView textView4, @androidx.annotation.NonNull android.view.ViewStub viewStub, @androidx.annotation.NonNull android.view.ViewStub viewStub2) {
        this.n = constraintLayout;
        this.cbTreaty = checkBox;
        this.knowCool = textView;
        this.layoutBottom = linearLayout;
        this.layoutTop = linearLayout2;
        this.llTreatyLayout = constraintLayout2;
        this.loginBg = imageView;
        this.loginBgCoverImg = imageView2;
        this.loginByUsernameTitlebar = mJTitleBar;
        this.rootLayout = constraintLayout3;
        this.titleIndicator = roundCornerImageView;
        this.treatyTip = textView2;
        this.tvActionLogin = textView3;
        this.tvCheckbox = appCompatTextView;
        this.tvErrorInfo = textView4;
        this.vsLoginSnscode = viewStub;
        this.vsLoginUsername = viewStub2;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivityAccountEmailPhoneLoginBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.titlebar.MJTitleBar findChildViewById;
        int i = moji.com.mjweather.R.id.cb_treaty;
        android.widget.CheckBox checkBox = (android.widget.CheckBox) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (checkBox != null) {
            i = moji.com.mjweather.R.id.know_cool;
            android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = moji.com.mjweather.R.id.layout_bottom;
                android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (linearLayout != null) {
                    i = moji.com.mjweather.R.id.layout_top;
                    android.widget.LinearLayout linearLayout2 = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (linearLayout2 != null) {
                        i = moji.com.mjweather.R.id.ll_treaty_layout;
                        androidx.constraintlayout.widget.ConstraintLayout constraintLayout = (androidx.constraintlayout.widget.ConstraintLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (constraintLayout != null) {
                            i = moji.com.mjweather.R.id.loginBg;
                            android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (imageView != null) {
                                i = moji.com.mjweather.R.id.loginBgCoverImg;
                                android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (imageView2 != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.login_by_username_titlebar))) != null) {
                                    androidx.constraintlayout.widget.ConstraintLayout constraintLayout2 = (androidx.constraintlayout.widget.ConstraintLayout) view;
                                    i = moji.com.mjweather.R.id.titleIndicator;
                                    com.moji.imageview.RoundCornerImageView findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                    if (findChildViewById2 != null) {
                                        i = moji.com.mjweather.R.id.treaty_tip;
                                        android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                        if (textView2 != null) {
                                            i = moji.com.mjweather.R.id.tv_action_login;
                                            android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                            if (textView3 != null) {
                                                i = moji.com.mjweather.R.id.tv_checkbox;
                                                androidx.appcompat.widget.AppCompatTextView appCompatTextView = (androidx.appcompat.widget.AppCompatTextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                if (appCompatTextView != null) {
                                                    i = moji.com.mjweather.R.id.tv_error_info;
                                                    android.widget.TextView textView4 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                    if (textView4 != null) {
                                                        i = moji.com.mjweather.R.id.vs_login_snscode;
                                                        android.view.ViewStub viewStub = (android.view.ViewStub) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                        if (viewStub != null) {
                                                            i = moji.com.mjweather.R.id.vs_login_username;
                                                            android.view.ViewStub viewStub2 = (android.view.ViewStub) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                            if (viewStub2 != null) {
                                                                return new moji.com.mjweather.databinding.ActivityAccountEmailPhoneLoginBinding(constraintLayout2, checkBox, textView, linearLayout, linearLayout2, constraintLayout, imageView, imageView2, findChildViewById, constraintLayout2, findChildViewById2, textView2, textView3, appCompatTextView, textView4, viewStub, viewStub2);
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
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivityAccountEmailPhoneLoginBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivityAccountEmailPhoneLoginBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.activity_account_email_phone_login, viewGroup, false);
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
