package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class LayoutDay2S5Binding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.view.View n;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.weather.beta.WeatherHorizontalRecyclerview recyclerview;

    public LayoutDay2S5Binding(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull com.moji.mjweather.weather.beta.WeatherHorizontalRecyclerview weatherHorizontalRecyclerview) {
        this.n = view;
        this.recyclerview = weatherHorizontalRecyclerview;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutDay2S5Binding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = moji.com.mjweather.R.id.recyclerview;
        com.moji.mjweather.weather.beta.WeatherHorizontalRecyclerview findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            return new moji.com.mjweather.databinding.LayoutDay2S5Binding(view, findChildViewById);
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutDay2S5Binding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.NonNull android.view.ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new java.lang.NullPointerException("parent");
        }
        layoutInflater.inflate(moji.com.mjweather.R.layout.layout_day2_s5, viewGroup);
        return bind(viewGroup);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public android.view.View getRoot() {
        return this.n;
    }
}
