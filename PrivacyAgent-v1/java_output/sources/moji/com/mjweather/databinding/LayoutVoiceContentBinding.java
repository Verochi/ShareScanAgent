package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class LayoutVoiceContentBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.ImageView imageViewForecastDayIcon;

    @androidx.annotation.NonNull
    public final android.widget.ImageView imageViewForecastNightIcon;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout layoutVoiceDate;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout n;

    @androidx.annotation.NonNull
    public final android.widget.TextView textViewDate;

    @androidx.annotation.NonNull
    public final android.widget.TextView textViewDateCurr;

    @androidx.annotation.NonNull
    public final android.widget.TextView textViewForcecastDayDes;

    @androidx.annotation.NonNull
    public final android.widget.TextView textViewForcecastNightDes;

    @androidx.annotation.NonNull
    public final android.widget.TextView textViewWeek;

    public LayoutVoiceContentBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.ImageView imageView2, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout2, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull android.widget.TextView textView3, @androidx.annotation.NonNull android.widget.TextView textView4, @androidx.annotation.NonNull android.widget.TextView textView5) {
        this.n = linearLayout;
        this.imageViewForecastDayIcon = imageView;
        this.imageViewForecastNightIcon = imageView2;
        this.layoutVoiceDate = linearLayout2;
        this.textViewDate = textView;
        this.textViewDateCurr = textView2;
        this.textViewForcecastDayDes = textView3;
        this.textViewForcecastNightDes = textView4;
        this.textViewWeek = textView5;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutVoiceContentBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = moji.com.mjweather.R.id.imageView_forecast_day_icon;
        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = moji.com.mjweather.R.id.imageView_forecast_night_icon;
            android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = moji.com.mjweather.R.id.layout_voice_date;
                android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (linearLayout != null) {
                    i = moji.com.mjweather.R.id.textView_date;
                    android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = moji.com.mjweather.R.id.textView_date_curr;
                        android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = moji.com.mjweather.R.id.textView_forcecast_day_des;
                            android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (textView3 != null) {
                                i = moji.com.mjweather.R.id.textView_forcecast_night_des;
                                android.widget.TextView textView4 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (textView4 != null) {
                                    i = moji.com.mjweather.R.id.textView_week;
                                    android.widget.TextView textView5 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                    if (textView5 != null) {
                                        return new moji.com.mjweather.databinding.LayoutVoiceContentBinding((android.widget.LinearLayout) view, imageView, imageView2, linearLayout, textView, textView2, textView3, textView4, textView5);
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
    public static moji.com.mjweather.databinding.LayoutVoiceContentBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutVoiceContentBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.layout_voice_content, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public android.widget.LinearLayout getRoot() {
        return this.n;
    }
}
