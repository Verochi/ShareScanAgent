package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class ActivityTableScreenBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout llSplashView;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout n;

    public ActivityTableScreenBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout2) {
        this.n = linearLayout;
        this.llSplashView = linearLayout2;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivityTableScreenBinding bind(@androidx.annotation.NonNull android.view.View view) {
        if (view == null) {
            throw new java.lang.NullPointerException("rootView");
        }
        android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) view;
        return new moji.com.mjweather.databinding.ActivityTableScreenBinding(linearLayout, linearLayout);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivityTableScreenBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivityTableScreenBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.activity_table_screen, viewGroup, false);
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
