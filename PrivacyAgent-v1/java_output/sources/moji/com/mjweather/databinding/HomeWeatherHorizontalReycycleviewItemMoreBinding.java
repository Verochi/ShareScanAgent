package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class HomeWeatherHorizontalReycycleviewItemMoreBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.moji.imageview.MJImageView ivArrow;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout n;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView tvText;

    public HomeWeatherHorizontalReycycleviewItemMoreBinding(@androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull com.moji.imageview.MJImageView mJImageView, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView) {
        this.n = constraintLayout;
        this.ivArrow = mJImageView;
        this.tvText = mJTextView;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.HomeWeatherHorizontalReycycleviewItemMoreBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.textview.MJTextView findChildViewById;
        int i = moji.com.mjweather.R.id.iv_arrow;
        com.moji.imageview.MJImageView findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById2 == null || (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tv_text))) == null) {
            throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new moji.com.mjweather.databinding.HomeWeatherHorizontalReycycleviewItemMoreBinding((androidx.constraintlayout.widget.ConstraintLayout) view, findChildViewById2, findChildViewById);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.HomeWeatherHorizontalReycycleviewItemMoreBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.HomeWeatherHorizontalReycycleviewItemMoreBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.home_weather_horizontal_reycycleview_item_more, viewGroup, false);
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
