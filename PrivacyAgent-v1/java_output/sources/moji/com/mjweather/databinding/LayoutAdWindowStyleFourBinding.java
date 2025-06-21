package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class LayoutAdWindowStyleFourBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.moji.mjweather.weather.view.PicassoButton bigWindowButton;

    @androidx.annotation.NonNull
    public final android.widget.TextView bigWindowText;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.weather.view.PicassoLinearLayout llAdBanner;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.weather.view.PicassoLinearLayout llBigWindowText;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout n;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout rlBanner;

    public LayoutAdWindowStyleFourBinding(@androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout, @androidx.annotation.NonNull com.moji.mjweather.weather.view.PicassoButton picassoButton, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull com.moji.mjweather.weather.view.PicassoLinearLayout picassoLinearLayout, @androidx.annotation.NonNull com.moji.mjweather.weather.view.PicassoLinearLayout picassoLinearLayout2, @androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout2) {
        this.n = relativeLayout;
        this.bigWindowButton = picassoButton;
        this.bigWindowText = textView;
        this.llAdBanner = picassoLinearLayout;
        this.llBigWindowText = picassoLinearLayout2;
        this.rlBanner = relativeLayout2;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutAdWindowStyleFourBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.mjweather.weather.view.PicassoLinearLayout findChildViewById;
        com.moji.mjweather.weather.view.PicassoLinearLayout findChildViewById2;
        int i = moji.com.mjweather.R.id.big_window_button;
        com.moji.mjweather.weather.view.PicassoButton findChildViewById3 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById3 != null) {
            i = moji.com.mjweather.R.id.big_window_text;
            android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (textView != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.ll_ad_banner))) != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.ll_big_window_text))) != null) {
                i = moji.com.mjweather.R.id.rl_banner;
                android.widget.RelativeLayout relativeLayout = (android.widget.RelativeLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (relativeLayout != null) {
                    return new moji.com.mjweather.databinding.LayoutAdWindowStyleFourBinding((android.widget.RelativeLayout) view, findChildViewById3, textView, findChildViewById, findChildViewById2, relativeLayout);
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutAdWindowStyleFourBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutAdWindowStyleFourBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.layout_ad_window_style_four, viewGroup, false);
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
