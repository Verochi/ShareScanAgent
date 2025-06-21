package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class MainWeatherConditionCorrectBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.Button btnLeft;

    @androidx.annotation.NonNull
    public final android.view.View divider;

    @androidx.annotation.NonNull
    public final android.view.View guideLine;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivWeatherAccurate;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivWeatherInaccurate;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout leftArea;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout llRight;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout n;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvWeatherAccurate;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.weathercorrect.MinWidthTextView tvWeatherInaccurate;

    @androidx.annotation.NonNull
    public final android.widget.ImageView weatherSelected;

    public MainWeatherConditionCorrectBinding(@androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull android.widget.Button button, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.view.View view2, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.ImageView imageView2, @androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout2, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull com.moji.mjweather.weathercorrect.MinWidthTextView minWidthTextView, @androidx.annotation.NonNull android.widget.ImageView imageView3) {
        this.n = constraintLayout;
        this.btnLeft = button;
        this.divider = view;
        this.guideLine = view2;
        this.ivWeatherAccurate = imageView;
        this.ivWeatherInaccurate = imageView2;
        this.leftArea = constraintLayout2;
        this.llRight = linearLayout;
        this.tvWeatherAccurate = textView;
        this.tvWeatherInaccurate = minWidthTextView;
        this.weatherSelected = imageView3;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.MainWeatherConditionCorrectBinding bind(@androidx.annotation.NonNull android.view.View view) {
        android.view.View findChildViewById;
        android.view.View findChildViewById2;
        com.moji.mjweather.weathercorrect.MinWidthTextView findChildViewById3;
        int i = moji.com.mjweather.R.id.btn_left;
        android.widget.Button button = (android.widget.Button) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (button != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.divider))) != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.guide_line))) != null) {
            i = moji.com.mjweather.R.id.iv_weather_accurate;
            android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = moji.com.mjweather.R.id.iv_weather_inaccurate;
                android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = moji.com.mjweather.R.id.left_area;
                    androidx.constraintlayout.widget.ConstraintLayout constraintLayout = (androidx.constraintlayout.widget.ConstraintLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (constraintLayout != null) {
                        i = moji.com.mjweather.R.id.ll_right;
                        android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (linearLayout != null) {
                            i = moji.com.mjweather.R.id.tv_weather_accurate;
                            android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (textView != null && (findChildViewById3 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tv_weather_inaccurate))) != null) {
                                i = moji.com.mjweather.R.id.weather_selected;
                                android.widget.ImageView imageView3 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (imageView3 != null) {
                                    return new moji.com.mjweather.databinding.MainWeatherConditionCorrectBinding((androidx.constraintlayout.widget.ConstraintLayout) view, button, findChildViewById, findChildViewById2, imageView, imageView2, constraintLayout, linearLayout, textView, findChildViewById3, imageView3);
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
    public static moji.com.mjweather.databinding.MainWeatherConditionCorrectBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.MainWeatherConditionCorrectBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.main_weather_condition_correct, viewGroup, false);
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
