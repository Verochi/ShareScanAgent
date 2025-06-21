package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class DialogDifferentCityTipsBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final androidx.viewpager.widget.ViewPager cityTipsViewpager;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout llDiamond;

    @androidx.annotation.NonNull
    public final android.widget.ImageView mCloseView;

    @androidx.annotation.NonNull
    public final android.widget.TextView mShareTravelView;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout n;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.share.TipsDialogIndicatorView viewIndicator;

    public DialogDifferentCityTipsBinding(@androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout, @androidx.annotation.NonNull androidx.viewpager.widget.ViewPager viewPager, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull com.moji.mjweather.share.TipsDialogIndicatorView tipsDialogIndicatorView) {
        this.n = relativeLayout;
        this.cityTipsViewpager = viewPager;
        this.llDiamond = linearLayout;
        this.mCloseView = imageView;
        this.mShareTravelView = textView;
        this.viewIndicator = tipsDialogIndicatorView;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.DialogDifferentCityTipsBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.mjweather.share.TipsDialogIndicatorView findChildViewById;
        int i = moji.com.mjweather.R.id.city_tips_viewpager;
        androidx.viewpager.widget.ViewPager viewPager = (androidx.viewpager.widget.ViewPager) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (viewPager != null) {
            i = moji.com.mjweather.R.id.ll_diamond;
            android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = moji.com.mjweather.R.id.mCloseView;
                android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = moji.com.mjweather.R.id.mShareTravelView;
                    android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (textView != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.viewIndicator))) != null) {
                        return new moji.com.mjweather.databinding.DialogDifferentCityTipsBinding((android.widget.RelativeLayout) view, viewPager, linearLayout, imageView, textView, findChildViewById);
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.DialogDifferentCityTipsBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.DialogDifferentCityTipsBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.dialog_different_city_tips, viewGroup, false);
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
