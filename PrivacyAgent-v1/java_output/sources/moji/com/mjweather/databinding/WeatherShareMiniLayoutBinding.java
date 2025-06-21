package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class WeatherShareMiniLayoutBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.TextView areaView;

    @androidx.annotation.NonNull
    public final android.widget.ImageView bgView;

    @androidx.annotation.NonNull
    public final android.widget.TextView dayView1;

    @androidx.annotation.NonNull
    public final android.widget.TextView dayView2;

    @androidx.annotation.NonNull
    public final android.widget.TextView dayView3;

    @androidx.annotation.NonNull
    public final android.widget.TextView dayView4;

    @androidx.annotation.NonNull
    public final android.widget.TextView descView;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout n;

    @androidx.annotation.NonNull
    public final android.widget.TextView tempUnitView;

    @androidx.annotation.NonNull
    public final android.widget.TextView tempView;

    @androidx.annotation.NonNull
    public final android.widget.TextView tempView1;

    @androidx.annotation.NonNull
    public final android.widget.TextView tempView2;

    @androidx.annotation.NonNull
    public final android.widget.TextView tempView3;

    @androidx.annotation.NonNull
    public final android.widget.TextView tempView4;

    public WeatherShareMiniLayoutBinding(@androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull android.widget.TextView textView3, @androidx.annotation.NonNull android.widget.TextView textView4, @androidx.annotation.NonNull android.widget.TextView textView5, @androidx.annotation.NonNull android.widget.TextView textView6, @androidx.annotation.NonNull android.widget.TextView textView7, @androidx.annotation.NonNull android.widget.TextView textView8, @androidx.annotation.NonNull android.widget.TextView textView9, @androidx.annotation.NonNull android.widget.TextView textView10, @androidx.annotation.NonNull android.widget.TextView textView11, @androidx.annotation.NonNull android.widget.TextView textView12) {
        this.n = constraintLayout;
        this.areaView = textView;
        this.bgView = imageView;
        this.dayView1 = textView2;
        this.dayView2 = textView3;
        this.dayView3 = textView4;
        this.dayView4 = textView5;
        this.descView = textView6;
        this.tempUnitView = textView7;
        this.tempView = textView8;
        this.tempView1 = textView9;
        this.tempView2 = textView10;
        this.tempView3 = textView11;
        this.tempView4 = textView12;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.WeatherShareMiniLayoutBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = moji.com.mjweather.R.id.areaView;
        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = moji.com.mjweather.R.id.bgView;
            android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = moji.com.mjweather.R.id.dayView1;
                android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = moji.com.mjweather.R.id.dayView2;
                    android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        i = moji.com.mjweather.R.id.dayView3;
                        android.widget.TextView textView4 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (textView4 != null) {
                            i = moji.com.mjweather.R.id.dayView4;
                            android.widget.TextView textView5 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (textView5 != null) {
                                i = moji.com.mjweather.R.id.descView;
                                android.widget.TextView textView6 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (textView6 != null) {
                                    i = moji.com.mjweather.R.id.tempUnitView;
                                    android.widget.TextView textView7 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                    if (textView7 != null) {
                                        i = moji.com.mjweather.R.id.tempView;
                                        android.widget.TextView textView8 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                        if (textView8 != null) {
                                            i = moji.com.mjweather.R.id.tempView1;
                                            android.widget.TextView textView9 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                            if (textView9 != null) {
                                                i = moji.com.mjweather.R.id.tempView2;
                                                android.widget.TextView textView10 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                if (textView10 != null) {
                                                    i = moji.com.mjweather.R.id.tempView3;
                                                    android.widget.TextView textView11 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                    if (textView11 != null) {
                                                        i = moji.com.mjweather.R.id.tempView4;
                                                        android.widget.TextView textView12 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                        if (textView12 != null) {
                                                            return new moji.com.mjweather.databinding.WeatherShareMiniLayoutBinding((androidx.constraintlayout.widget.ConstraintLayout) view, textView, imageView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12);
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
    public static moji.com.mjweather.databinding.WeatherShareMiniLayoutBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.WeatherShareMiniLayoutBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.weather_share_mini_layout, viewGroup, false);
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
