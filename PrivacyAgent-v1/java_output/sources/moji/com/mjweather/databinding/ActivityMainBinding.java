package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class ActivityMainBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout fragmentContainer;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout n;

    public ActivityMainBinding(@androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull android.widget.FrameLayout frameLayout2) {
        this.n = frameLayout;
        this.fragmentContainer = frameLayout2;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivityMainBinding bind(@androidx.annotation.NonNull android.view.View view) {
        if (view == null) {
            throw new java.lang.NullPointerException("rootView");
        }
        android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) view;
        return new moji.com.mjweather.databinding.ActivityMainBinding(frameLayout, frameLayout);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivityMainBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivityMainBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.activity_main, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public android.widget.FrameLayout getRoot() {
        return this.n;
    }
}
