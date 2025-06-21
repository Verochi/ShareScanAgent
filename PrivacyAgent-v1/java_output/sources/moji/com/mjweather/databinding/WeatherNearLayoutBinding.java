package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class WeatherNearLayoutBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final androidx.recyclerview.widget.NearRecyclerView mRecyclerView;

    @androidx.annotation.NonNull
    public final android.widget.TextView mTitleView;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout n;

    @androidx.annotation.NonNull
    public final com.moji.FooterView vLoading;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout vRoot;

    @androidx.annotation.NonNull
    public final android.view.View vSpace;

    public WeatherNearLayoutBinding(@androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull androidx.recyclerview.widget.NearRecyclerView nearRecyclerView, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull com.moji.FooterView footerView, @androidx.annotation.NonNull android.widget.FrameLayout frameLayout2, @androidx.annotation.NonNull android.view.View view) {
        this.n = frameLayout;
        this.mRecyclerView = nearRecyclerView;
        this.mTitleView = textView;
        this.vLoading = footerView;
        this.vRoot = frameLayout2;
        this.vSpace = view;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.WeatherNearLayoutBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.FooterView findChildViewById;
        android.view.View findChildViewById2;
        int i = moji.com.mjweather.R.id.mRecyclerView;
        androidx.recyclerview.widget.NearRecyclerView nearRecyclerView = (androidx.recyclerview.widget.NearRecyclerView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (nearRecyclerView != null) {
            i = moji.com.mjweather.R.id.mTitleView;
            android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (textView != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.vLoading))) != null) {
                i = moji.com.mjweather.R.id.vRoot;
                android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (frameLayout != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.vSpace))) != null) {
                    return new moji.com.mjweather.databinding.WeatherNearLayoutBinding((android.widget.FrameLayout) view, nearRecyclerView, textView, findChildViewById, frameLayout, findChildViewById2);
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.WeatherNearLayoutBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.WeatherNearLayoutBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.weather_near_layout, viewGroup, false);
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
