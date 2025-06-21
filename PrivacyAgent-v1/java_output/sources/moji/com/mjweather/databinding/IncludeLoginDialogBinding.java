package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class IncludeLoginDialogBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout llLoginQq;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout llLoginWechat;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout llLoginWeibo;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout n;

    public IncludeLoginDialogBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout2, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout3, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout4) {
        this.n = linearLayout;
        this.llLoginQq = linearLayout2;
        this.llLoginWechat = linearLayout3;
        this.llLoginWeibo = linearLayout4;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.IncludeLoginDialogBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = moji.com.mjweather.R.id.ll_login_qq;
        android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = moji.com.mjweather.R.id.ll_login_wechat;
            android.widget.LinearLayout linearLayout2 = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (linearLayout2 != null) {
                i = moji.com.mjweather.R.id.ll_login_weibo;
                android.widget.LinearLayout linearLayout3 = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (linearLayout3 != null) {
                    return new moji.com.mjweather.databinding.IncludeLoginDialogBinding((android.widget.LinearLayout) view, linearLayout, linearLayout2, linearLayout3);
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.IncludeLoginDialogBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.IncludeLoginDialogBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.include_login_dialog, viewGroup, false);
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
