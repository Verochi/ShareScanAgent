package moji.com.mjweather.databinding;

/* loaded from: classes31.dex */
public final class ActivityAccountInputSnsCodeBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.EditText editVerificationCode;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout identifyLayout;

    @androidx.annotation.NonNull
    public final android.widget.ImageView inputSNSCodeBg;

    @androidx.annotation.NonNull
    public final android.widget.ImageView inputSNSCodeBgCoverImg;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivInputClear;

    @androidx.annotation.NonNull
    public final android.widget.TextView knowCool;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout n;

    @androidx.annotation.NonNull
    public final com.moji.titlebar.MJTitleBar titleBar;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvActionLogin;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvErrorInfo;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvPoint;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvRemind;

    public ActivityAccountInputSnsCodeBinding(@androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull android.widget.EditText editText, @androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.ImageView imageView2, @androidx.annotation.NonNull android.widget.ImageView imageView3, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull com.moji.titlebar.MJTitleBar mJTitleBar, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull android.widget.TextView textView3, @androidx.annotation.NonNull android.widget.TextView textView4, @androidx.annotation.NonNull android.widget.TextView textView5) {
        this.n = constraintLayout;
        this.editVerificationCode = editText;
        this.identifyLayout = relativeLayout;
        this.inputSNSCodeBg = imageView;
        this.inputSNSCodeBgCoverImg = imageView2;
        this.ivInputClear = imageView3;
        this.knowCool = textView;
        this.titleBar = mJTitleBar;
        this.tvActionLogin = textView2;
        this.tvErrorInfo = textView3;
        this.tvPoint = textView4;
        this.tvRemind = textView5;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivityAccountInputSnsCodeBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.titlebar.MJTitleBar findChildViewById;
        int i = moji.com.mjweather.R.id.edit_verification_code;
        android.widget.EditText editText = (android.widget.EditText) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (editText != null) {
            i = moji.com.mjweather.R.id.identify_layout;
            android.widget.RelativeLayout relativeLayout = (android.widget.RelativeLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (relativeLayout != null) {
                i = moji.com.mjweather.R.id.inputSNSCodeBg;
                android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = moji.com.mjweather.R.id.inputSNSCodeBgCoverImg;
                    android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (imageView2 != null) {
                        i = moji.com.mjweather.R.id.iv_input_clear;
                        android.widget.ImageView imageView3 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (imageView3 != null) {
                            i = moji.com.mjweather.R.id.know_cool;
                            android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (textView != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.title_bar))) != null) {
                                i = moji.com.mjweather.R.id.tv_action_login;
                                android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (textView2 != null) {
                                    i = moji.com.mjweather.R.id.tv_error_info;
                                    android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                    if (textView3 != null) {
                                        i = moji.com.mjweather.R.id.tv_point;
                                        android.widget.TextView textView4 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                        if (textView4 != null) {
                                            i = moji.com.mjweather.R.id.tv_remind;
                                            android.widget.TextView textView5 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                            if (textView5 != null) {
                                                return new moji.com.mjweather.databinding.ActivityAccountInputSnsCodeBinding((androidx.constraintlayout.widget.ConstraintLayout) view, editText, relativeLayout, imageView, imageView2, imageView3, textView, findChildViewById, textView2, textView3, textView4, textView5);
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
    public static moji.com.mjweather.databinding.ActivityAccountInputSnsCodeBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivityAccountInputSnsCodeBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.activity_account_input_sns_code, viewGroup, false);
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
