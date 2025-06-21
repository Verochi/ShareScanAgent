package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class ViewLoginUsernameBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.view.View editTextLine1;

    @androidx.annotation.NonNull
    public final android.view.View editTextLine2;

    @androidx.annotation.NonNull
    public final android.widget.EditText etLoginInputAccount;

    @androidx.annotation.NonNull
    public final android.widget.EditText etLoginInputPassword;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivInputClear;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivInputClearForgetPass;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout n;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvPasswordForget;

    public ViewLoginUsernameBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.view.View view2, @androidx.annotation.NonNull android.widget.EditText editText, @androidx.annotation.NonNull android.widget.EditText editText2, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.ImageView imageView2, @androidx.annotation.NonNull android.widget.TextView textView) {
        this.n = linearLayout;
        this.editTextLine1 = view;
        this.editTextLine2 = view2;
        this.etLoginInputAccount = editText;
        this.etLoginInputPassword = editText2;
        this.ivInputClear = imageView;
        this.ivInputClearForgetPass = imageView2;
        this.tvPasswordForget = textView;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ViewLoginUsernameBinding bind(@androidx.annotation.NonNull android.view.View view) {
        android.view.View findChildViewById;
        int i = moji.com.mjweather.R.id.edit_text_line1;
        android.view.View findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById2 != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.edit_text_line2))) != null) {
            i = moji.com.mjweather.R.id.et_login_input_account;
            android.widget.EditText editText = (android.widget.EditText) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (editText != null) {
                i = moji.com.mjweather.R.id.et_login_input_password;
                android.widget.EditText editText2 = (android.widget.EditText) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (editText2 != null) {
                    i = moji.com.mjweather.R.id.iv_input_clear;
                    android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        i = moji.com.mjweather.R.id.iv_input_clear_forget_pass;
                        android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (imageView2 != null) {
                            i = moji.com.mjweather.R.id.tv_password_forget;
                            android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                return new moji.com.mjweather.databinding.ViewLoginUsernameBinding((android.widget.LinearLayout) view, findChildViewById2, findChildViewById, editText, editText2, imageView, imageView2, textView);
                            }
                        }
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ViewLoginUsernameBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ViewLoginUsernameBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.view_login_username, viewGroup, false);
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
