package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class LayoutEverydayWeatherDialogBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.TextView btnEverydayKnow;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivEverydaySetting;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout n;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvEverydayDescribe;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvEverydayTitle;

    public LayoutEverydayWeatherDialogBinding(@androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull android.widget.TextView textView3) {
        this.n = relativeLayout;
        this.btnEverydayKnow = textView;
        this.ivEverydaySetting = imageView;
        this.tvEverydayDescribe = textView2;
        this.tvEverydayTitle = textView3;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutEverydayWeatherDialogBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = moji.com.mjweather.R.id.btn_everyday_know;
        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = moji.com.mjweather.R.id.iv_everyday_setting;
            android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = moji.com.mjweather.R.id.tv_everyday_describe;
                android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = moji.com.mjweather.R.id.tv_everyday_title;
                    android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        return new moji.com.mjweather.databinding.LayoutEverydayWeatherDialogBinding((android.widget.RelativeLayout) view, textView, imageView, textView2, textView3);
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutEverydayWeatherDialogBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutEverydayWeatherDialogBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.layout_everyday_weather_dialog, viewGroup, false);
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
