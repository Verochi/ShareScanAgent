package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class ActivityModifyPassBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout centerLayout;

    @androidx.annotation.NonNull
    public final android.widget.EditText etInputPass;

    @androidx.annotation.NonNull
    public final android.widget.EditText etLoginInputOldPassword;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivInputClearNew;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivInputClearOld;

    @androidx.annotation.NonNull
    public final android.widget.TextView knowCool;

    @androidx.annotation.NonNull
    public final com.moji.titlebar.MJTitleBar mjTitleBar;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout n;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout newPassLayout;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout rlInputOldPassword;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvAction;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvErrorNewPassword;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvErrorOldPassword;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvPasswordForget;

    public ActivityModifyPassBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout, @androidx.annotation.NonNull android.widget.EditText editText, @androidx.annotation.NonNull android.widget.EditText editText2, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.ImageView imageView2, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull com.moji.titlebar.MJTitleBar mJTitleBar, @androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout2, @androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout3, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull android.widget.TextView textView3, @androidx.annotation.NonNull android.widget.TextView textView4, @androidx.annotation.NonNull android.widget.TextView textView5) {
        this.n = linearLayout;
        this.centerLayout = relativeLayout;
        this.etInputPass = editText;
        this.etLoginInputOldPassword = editText2;
        this.ivInputClearNew = imageView;
        this.ivInputClearOld = imageView2;
        this.knowCool = textView;
        this.mjTitleBar = mJTitleBar;
        this.newPassLayout = relativeLayout2;
        this.rlInputOldPassword = relativeLayout3;
        this.tvAction = textView2;
        this.tvErrorNewPassword = textView3;
        this.tvErrorOldPassword = textView4;
        this.tvPasswordForget = textView5;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivityModifyPassBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.titlebar.MJTitleBar findChildViewById;
        int i = moji.com.mjweather.R.id.center_layout;
        android.widget.RelativeLayout relativeLayout = (android.widget.RelativeLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (relativeLayout != null) {
            i = moji.com.mjweather.R.id.et_input_pass;
            android.widget.EditText editText = (android.widget.EditText) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (editText != null) {
                i = moji.com.mjweather.R.id.et_login_input_old_password;
                android.widget.EditText editText2 = (android.widget.EditText) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (editText2 != null) {
                    i = moji.com.mjweather.R.id.iv_input_clear_new;
                    android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        i = moji.com.mjweather.R.id.iv_input_clear_old;
                        android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (imageView2 != null) {
                            i = moji.com.mjweather.R.id.know_cool;
                            android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (textView != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.mj_title_bar))) != null) {
                                i = moji.com.mjweather.R.id.new_pass_layout;
                                android.widget.RelativeLayout relativeLayout2 = (android.widget.RelativeLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (relativeLayout2 != null) {
                                    i = moji.com.mjweather.R.id.rl_input_old_password;
                                    android.widget.RelativeLayout relativeLayout3 = (android.widget.RelativeLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                    if (relativeLayout3 != null) {
                                        i = moji.com.mjweather.R.id.tv_action;
                                        android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                        if (textView2 != null) {
                                            i = moji.com.mjweather.R.id.tv_error_new_password;
                                            android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                            if (textView3 != null) {
                                                i = moji.com.mjweather.R.id.tv_error_old_password;
                                                android.widget.TextView textView4 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                if (textView4 != null) {
                                                    i = moji.com.mjweather.R.id.tv_password_forget;
                                                    android.widget.TextView textView5 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                    if (textView5 != null) {
                                                        return new moji.com.mjweather.databinding.ActivityModifyPassBinding((android.widget.LinearLayout) view, relativeLayout, editText, editText2, imageView, imageView2, textView, findChildViewById, relativeLayout2, relativeLayout3, textView2, textView3, textView4, textView5);
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
    public static moji.com.mjweather.databinding.ActivityModifyPassBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivityModifyPassBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.activity_modify_pass, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public android.widget.LinearLayout getRoot() {
        return this.n;
    }
}
