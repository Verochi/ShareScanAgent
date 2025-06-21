package moji.com.mjweatherservicebase.databinding;

/* loaded from: classes20.dex */
public final class ViewAutoSlideBannerBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout n;

    @androidx.annotation.NonNull
    public final androidx.viewpager2.widget.ViewPager2 pager;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout root;

    @androidx.annotation.NonNull
    public final com.moji.emotion.CityIndexControlView viewIndex;

    public ViewAutoSlideBannerBinding(@androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull androidx.viewpager2.widget.ViewPager2 viewPager2, @androidx.annotation.NonNull android.widget.FrameLayout frameLayout2, @androidx.annotation.NonNull com.moji.emotion.CityIndexControlView cityIndexControlView) {
        this.n = frameLayout;
        this.pager = viewPager2;
        this.root = frameLayout2;
        this.viewIndex = cityIndexControlView;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweatherservicebase.databinding.ViewAutoSlideBannerBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = moji.com.mjweatherservicebase.R.id.pager;
        androidx.viewpager2.widget.ViewPager2 viewPager2 = (androidx.viewpager2.widget.ViewPager2) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (viewPager2 != null) {
            android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) view;
            int i2 = moji.com.mjweatherservicebase.R.id.viewIndex;
            com.moji.emotion.CityIndexControlView findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, i2);
            if (findChildViewById != null) {
                return new moji.com.mjweatherservicebase.databinding.ViewAutoSlideBannerBinding(frameLayout, viewPager2, frameLayout, findChildViewById);
            }
            i = i2;
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweatherservicebase.databinding.ViewAutoSlideBannerBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweatherservicebase.databinding.ViewAutoSlideBannerBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweatherservicebase.R.layout.view_auto_slide_banner, viewGroup, false);
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
