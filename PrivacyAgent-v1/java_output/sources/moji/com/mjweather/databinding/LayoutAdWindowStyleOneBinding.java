package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class LayoutAdWindowStyleOneBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.moji.mjweather.weather.view.PicassoButton bigWindowButton;

    @androidx.annotation.NonNull
    public final android.widget.TextView bigWindowText;

    @androidx.annotation.NonNull
    public final android.widget.TextView bigWindowTitle;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivBigWindowIcon;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.weather.view.PicassoLinearLayout llBigWindowText;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout n;

    public LayoutAdWindowStyleOneBinding(@androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout, @androidx.annotation.NonNull com.moji.mjweather.weather.view.PicassoButton picassoButton, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull com.moji.mjweather.weather.view.PicassoLinearLayout picassoLinearLayout) {
        this.n = relativeLayout;
        this.bigWindowButton = picassoButton;
        this.bigWindowText = textView;
        this.bigWindowTitle = textView2;
        this.ivBigWindowIcon = imageView;
        this.llBigWindowText = picassoLinearLayout;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutAdWindowStyleOneBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.mjweather.weather.view.PicassoLinearLayout findChildViewById;
        int i = moji.com.mjweather.R.id.big_window_button;
        com.moji.mjweather.weather.view.PicassoButton findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById2 != null) {
            i = moji.com.mjweather.R.id.big_window_text;
            android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = moji.com.mjweather.R.id.big_window_title;
                android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = moji.com.mjweather.R.id.iv_big_window_icon;
                    android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (imageView != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.ll_big_window_text))) != null) {
                        return new moji.com.mjweather.databinding.LayoutAdWindowStyleOneBinding((android.widget.RelativeLayout) view, findChildViewById2, textView, textView2, imageView, findChildViewById);
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutAdWindowStyleOneBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutAdWindowStyleOneBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.layout_ad_window_style_one, viewGroup, false);
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
