package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class FindPassIdentifyBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout doubleViewLayout;

    @androidx.annotation.NonNull
    public final android.widget.EditText editVerificationCode;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout identifyLayout;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivInputClear;

    @androidx.annotation.NonNull
    public final android.widget.TextView knowCool;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout n;

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

    @androidx.annotation.NonNull
    public final android.widget.TextView verificationCode;

    public FindPassIdentifyBinding(@androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout, @androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout2, @androidx.annotation.NonNull android.widget.EditText editText, @androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout3, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull com.moji.titlebar.MJTitleBar mJTitleBar, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull android.widget.TextView textView3, @androidx.annotation.NonNull android.widget.TextView textView4, @androidx.annotation.NonNull android.widget.TextView textView5, @androidx.annotation.NonNull android.widget.TextView textView6) {
        this.n = relativeLayout;
        this.doubleViewLayout = relativeLayout2;
        this.editVerificationCode = editText;
        this.identifyLayout = relativeLayout3;
        this.ivInputClear = imageView;
        this.knowCool = textView;
        this.titleBar = mJTitleBar;
        this.tvActionLogin = textView2;
        this.tvErrorInfo = textView3;
        this.tvPoint = textView4;
        this.tvRemind = textView5;
        this.verificationCode = textView6;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.FindPassIdentifyBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.titlebar.MJTitleBar findChildViewById;
        int i = moji.com.mjweather.R.id.double_view_layout;
        android.widget.RelativeLayout relativeLayout = (android.widget.RelativeLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (relativeLayout != null) {
            i = moji.com.mjweather.R.id.edit_verification_code;
            android.widget.EditText editText = (android.widget.EditText) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (editText != null) {
                i = moji.com.mjweather.R.id.identify_layout;
                android.widget.RelativeLayout relativeLayout2 = (android.widget.RelativeLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (relativeLayout2 != null) {
                    i = moji.com.mjweather.R.id.iv_input_clear;
                    android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
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
                                            i = moji.com.mjweather.R.id.verification_code;
                                            android.widget.TextView textView6 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                            if (textView6 != null) {
                                                return new moji.com.mjweather.databinding.FindPassIdentifyBinding((android.widget.RelativeLayout) view, relativeLayout, editText, relativeLayout2, imageView, textView, findChildViewById, textView2, textView3, textView4, textView5, textView6);
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
    public static moji.com.mjweather.databinding.FindPassIdentifyBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.FindPassIdentifyBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.find_pass_identify, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public android.widget.RelativeLayout getRoot() {
        return this.n;
    }
}
