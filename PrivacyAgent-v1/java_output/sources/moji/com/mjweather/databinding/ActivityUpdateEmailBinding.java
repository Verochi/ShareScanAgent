package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class ActivityUpdateEmailBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.ImageView emailClear;

    @androidx.annotation.NonNull
    public final android.widget.EditText etLoginInput;

    @androidx.annotation.NonNull
    public final android.widget.TextView knowCool;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout n;

    @androidx.annotation.NonNull
    public final com.moji.titlebar.MJTitleBar titleBar;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvAction;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvErrorInfo;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvPoint;

    public ActivityUpdateEmailBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.EditText editText, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull com.moji.titlebar.MJTitleBar mJTitleBar, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull android.widget.TextView textView3, @androidx.annotation.NonNull android.widget.TextView textView4) {
        this.n = linearLayout;
        this.emailClear = imageView;
        this.etLoginInput = editText;
        this.knowCool = textView;
        this.titleBar = mJTitleBar;
        this.tvAction = textView2;
        this.tvErrorInfo = textView3;
        this.tvPoint = textView4;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivityUpdateEmailBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.titlebar.MJTitleBar findChildViewById;
        int i = moji.com.mjweather.R.id.email_clear;
        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = moji.com.mjweather.R.id.et_login_input;
            android.widget.EditText editText = (android.widget.EditText) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (editText != null) {
                i = moji.com.mjweather.R.id.know_cool;
                android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (textView != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.title_bar))) != null) {
                    i = moji.com.mjweather.R.id.tv_action;
                    android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = moji.com.mjweather.R.id.tv_error_info;
                        android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            i = moji.com.mjweather.R.id.tv_point;
                            android.widget.TextView textView4 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (textView4 != null) {
                                return new moji.com.mjweather.databinding.ActivityUpdateEmailBinding((android.widget.LinearLayout) view, imageView, editText, textView, findChildViewById, textView2, textView3, textView4);
                            }
                        }
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivityUpdateEmailBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivityUpdateEmailBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.activity_update_email, viewGroup, false);
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
