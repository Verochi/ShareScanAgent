package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class ItemWeatherListEmptyBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.view.View n;

    public ItemWeatherListEmptyBinding(@androidx.annotation.NonNull android.view.View view) {
        this.n = view;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ItemWeatherListEmptyBinding bind(@androidx.annotation.NonNull android.view.View view) {
        if (view != null) {
            return new moji.com.mjweather.databinding.ItemWeatherListEmptyBinding(view);
        }
        throw new java.lang.NullPointerException("rootView");
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ItemWeatherListEmptyBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ItemWeatherListEmptyBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.item_weather_list_empty, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public android.view.View getRoot() {
        return this.n;
    }
}
