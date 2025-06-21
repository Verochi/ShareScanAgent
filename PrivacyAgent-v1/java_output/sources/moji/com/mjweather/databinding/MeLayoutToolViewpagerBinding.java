package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class MeLayoutToolViewpagerBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.Space mBottomSpace;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout n;

    @androidx.annotation.NonNull
    public final com.moji.viewpagerindicator.CirclePageIndicator pagerIndicatorView;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.tabme.ViewPagerSmooth toolViewpager;

    public MeLayoutToolViewpagerBinding(@androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull android.widget.Space space, @androidx.annotation.NonNull com.moji.viewpagerindicator.CirclePageIndicator circlePageIndicator, @androidx.annotation.NonNull com.moji.mjweather.tabme.ViewPagerSmooth viewPagerSmooth) {
        this.n = frameLayout;
        this.mBottomSpace = space;
        this.pagerIndicatorView = circlePageIndicator;
        this.toolViewpager = viewPagerSmooth;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.MeLayoutToolViewpagerBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.viewpagerindicator.CirclePageIndicator findChildViewById;
        com.moji.mjweather.tabme.ViewPagerSmooth findChildViewById2;
        int i = moji.com.mjweather.R.id.mBottomSpace;
        android.widget.Space space = (android.widget.Space) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (space == null || (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.pagerIndicatorView))) == null || (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.toolViewpager))) == null) {
            throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new moji.com.mjweather.databinding.MeLayoutToolViewpagerBinding((android.widget.FrameLayout) view, space, findChildViewById, findChildViewById2);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.MeLayoutToolViewpagerBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.MeLayoutToolViewpagerBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.me_layout_tool_viewpager, viewGroup, false);
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
