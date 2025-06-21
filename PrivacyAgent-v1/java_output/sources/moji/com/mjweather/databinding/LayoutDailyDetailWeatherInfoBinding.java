package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class LayoutDailyDetailWeatherInfoBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.view.View divider1;

    @androidx.annotation.NonNull
    public final android.view.View divider2;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivHumidity;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivPressure;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivUltraviolet;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout layoutHumidity;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout layoutPressure;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout layoutUltraviolet;

    @androidx.annotation.NonNull
    public final android.view.View n;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvHumidityTitle;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvHumidityValue;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvPressureTitle;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvPressureValue;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvUltravioletTitle;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvUltravioletValue;

    public LayoutDailyDetailWeatherInfoBinding(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.view.View view2, @androidx.annotation.NonNull android.view.View view3, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.ImageView imageView2, @androidx.annotation.NonNull android.widget.ImageView imageView3, @androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout2, @androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout3, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull android.widget.TextView textView3, @androidx.annotation.NonNull android.widget.TextView textView4, @androidx.annotation.NonNull android.widget.TextView textView5, @androidx.annotation.NonNull android.widget.TextView textView6) {
        this.n = view;
        this.divider1 = view2;
        this.divider2 = view3;
        this.ivHumidity = imageView;
        this.ivPressure = imageView2;
        this.ivUltraviolet = imageView3;
        this.layoutHumidity = constraintLayout;
        this.layoutPressure = constraintLayout2;
        this.layoutUltraviolet = constraintLayout3;
        this.tvHumidityTitle = textView;
        this.tvHumidityValue = textView2;
        this.tvPressureTitle = textView3;
        this.tvPressureValue = textView4;
        this.tvUltravioletTitle = textView5;
        this.tvUltravioletValue = textView6;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutDailyDetailWeatherInfoBinding bind(@androidx.annotation.NonNull android.view.View view) {
        android.view.View findChildViewById;
        int i = moji.com.mjweather.R.id.divider_1;
        android.view.View findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById2 != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.divider_2))) != null) {
            i = moji.com.mjweather.R.id.iv_humidity;
            android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = moji.com.mjweather.R.id.iv_pressure;
                android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = moji.com.mjweather.R.id.iv_ultraviolet;
                    android.widget.ImageView imageView3 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (imageView3 != null) {
                        i = moji.com.mjweather.R.id.layout_humidity;
                        androidx.constraintlayout.widget.ConstraintLayout constraintLayout = (androidx.constraintlayout.widget.ConstraintLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (constraintLayout != null) {
                            i = moji.com.mjweather.R.id.layout_pressure;
                            androidx.constraintlayout.widget.ConstraintLayout constraintLayout2 = (androidx.constraintlayout.widget.ConstraintLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (constraintLayout2 != null) {
                                i = moji.com.mjweather.R.id.layout_ultraviolet;
                                androidx.constraintlayout.widget.ConstraintLayout constraintLayout3 = (androidx.constraintlayout.widget.ConstraintLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (constraintLayout3 != null) {
                                    i = moji.com.mjweather.R.id.tv_humidity_title;
                                    android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                    if (textView != null) {
                                        i = moji.com.mjweather.R.id.tv_humidity_value;
                                        android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                        if (textView2 != null) {
                                            i = moji.com.mjweather.R.id.tv_pressure_title;
                                            android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                            if (textView3 != null) {
                                                i = moji.com.mjweather.R.id.tv_pressure_value;
                                                android.widget.TextView textView4 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                if (textView4 != null) {
                                                    i = moji.com.mjweather.R.id.tv_ultraviolet_title;
                                                    android.widget.TextView textView5 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                    if (textView5 != null) {
                                                        i = moji.com.mjweather.R.id.tv_ultraviolet_value;
                                                        android.widget.TextView textView6 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                        if (textView6 != null) {
                                                            return new moji.com.mjweather.databinding.LayoutDailyDetailWeatherInfoBinding(view, findChildViewById2, findChildViewById, imageView, imageView2, imageView3, constraintLayout, constraintLayout2, constraintLayout3, textView, textView2, textView3, textView4, textView5, textView6);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutDailyDetailWeatherInfoBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.NonNull android.view.ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new java.lang.NullPointerException("parent");
        }
        layoutInflater.inflate(moji.com.mjweather.R.layout.layout_daily_detail_weather_info, viewGroup);
        return bind(viewGroup);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public android.view.View getRoot() {
        return this.n;
    }
}
