package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class ViewWeatherHomeBottomSupernatant1Binding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivCloseImg;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivImg;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout n;

    public ViewWeatherHomeBottomSupernatant1Binding(@androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.ImageView imageView2) {
        this.n = relativeLayout;
        this.ivCloseImg = imageView;
        this.ivImg = imageView2;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ViewWeatherHomeBottomSupernatant1Binding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = moji.com.mjweather.R.id.ivCloseImg;
        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = moji.com.mjweather.R.id.ivImg;
            android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                return new moji.com.mjweather.databinding.ViewWeatherHomeBottomSupernatant1Binding((android.widget.RelativeLayout) view, imageView, imageView2);
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ViewWeatherHomeBottomSupernatant1Binding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ViewWeatherHomeBottomSupernatant1Binding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.view_weather_home_bottom_supernatant_1, viewGroup, false);
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
