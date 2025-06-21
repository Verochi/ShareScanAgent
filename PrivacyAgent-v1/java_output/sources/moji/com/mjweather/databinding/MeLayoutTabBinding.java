package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class MeLayoutTabBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.TextView meContentPrivacyTips;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout n;

    @androidx.annotation.NonNull
    public final android.view.View tabDivider;

    @androidx.annotation.NonNull
    public final com.moji.tablayout.TabLayout titleContainer;

    @androidx.annotation.NonNull
    public final androidx.viewpager.widget.ViewPager viewpager;

    public MeLayoutTabBinding(@androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull com.moji.tablayout.TabLayout tabLayout, @androidx.annotation.NonNull androidx.viewpager.widget.ViewPager viewPager) {
        this.n = frameLayout;
        this.meContentPrivacyTips = textView;
        this.tabDivider = view;
        this.titleContainer = tabLayout;
        this.viewpager = viewPager;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.MeLayoutTabBinding bind(@androidx.annotation.NonNull android.view.View view) {
        android.view.View findChildViewById;
        com.moji.tablayout.TabLayout findChildViewById2;
        int i = moji.com.mjweather.R.id.me_content_privacy_tips;
        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (textView != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tab_divider))) != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.title_container))) != null) {
            i = moji.com.mjweather.R.id.viewpager;
            androidx.viewpager.widget.ViewPager viewPager = (androidx.viewpager.widget.ViewPager) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (viewPager != null) {
                return new moji.com.mjweather.databinding.MeLayoutTabBinding((android.widget.FrameLayout) view, textView, findChildViewById, findChildViewById2, viewPager);
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.MeLayoutTabBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.MeLayoutTabBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.me_layout_tab, viewGroup, false);
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
