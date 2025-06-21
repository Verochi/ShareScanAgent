package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class ActivityMojiTeamIntroduceBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.moji.titlebar.MJTitleBar aboutTeamTitlebar;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout contentLayout;

    @androidx.annotation.NonNull
    public final android.widget.ImageView imageBack;

    @androidx.annotation.NonNull
    public final moji.com.mjweather.databinding.LayoutTeamIntroduceTextBinding layoutTeamIntroduceText;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout n;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout rootLayout;

    @androidx.annotation.NonNull
    public final android.widget.ScrollView scrollBack;

    @androidx.annotation.NonNull
    public final android.widget.ScrollView scrollView;

    @androidx.annotation.NonNull
    public final android.view.View viewBottom;

    @androidx.annotation.NonNull
    public final android.view.View viewTop;

    public ActivityMojiTeamIntroduceBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull com.moji.titlebar.MJTitleBar mJTitleBar, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout2, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull moji.com.mjweather.databinding.LayoutTeamIntroduceTextBinding layoutTeamIntroduceTextBinding, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout3, @androidx.annotation.NonNull android.widget.ScrollView scrollView, @androidx.annotation.NonNull android.widget.ScrollView scrollView2, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.view.View view2) {
        this.n = linearLayout;
        this.aboutTeamTitlebar = mJTitleBar;
        this.contentLayout = linearLayout2;
        this.imageBack = imageView;
        this.layoutTeamIntroduceText = layoutTeamIntroduceTextBinding;
        this.rootLayout = linearLayout3;
        this.scrollBack = scrollView;
        this.scrollView = scrollView2;
        this.viewBottom = view;
        this.viewTop = view2;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivityMojiTeamIntroduceBinding bind(@androidx.annotation.NonNull android.view.View view) {
        android.view.View findChildViewById;
        android.view.View findChildViewById2;
        android.view.View findChildViewById3;
        int i = moji.com.mjweather.R.id.about_team_titlebar;
        com.moji.titlebar.MJTitleBar findChildViewById4 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById4 != null) {
            i = moji.com.mjweather.R.id.content_layout;
            android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = moji.com.mjweather.R.id.image_back;
                android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (imageView != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.layout_team_introduce_text))) != null) {
                    moji.com.mjweather.databinding.LayoutTeamIntroduceTextBinding bind = moji.com.mjweather.databinding.LayoutTeamIntroduceTextBinding.bind(findChildViewById);
                    android.widget.LinearLayout linearLayout2 = (android.widget.LinearLayout) view;
                    i = moji.com.mjweather.R.id.scroll_back;
                    android.widget.ScrollView scrollView = (android.widget.ScrollView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (scrollView != null) {
                        i = moji.com.mjweather.R.id.scrollView;
                        android.widget.ScrollView scrollView2 = (android.widget.ScrollView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (scrollView2 != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.view_bottom))) != null && (findChildViewById3 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.view_top))) != null) {
                            return new moji.com.mjweather.databinding.ActivityMojiTeamIntroduceBinding(linearLayout2, findChildViewById4, linearLayout, imageView, bind, linearLayout2, scrollView, scrollView2, findChildViewById2, findChildViewById3);
                        }
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivityMojiTeamIntroduceBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivityMojiTeamIntroduceBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.activity_moji_team_introduce, viewGroup, false);
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
