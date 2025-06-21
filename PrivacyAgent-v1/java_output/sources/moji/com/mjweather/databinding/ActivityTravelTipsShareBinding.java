package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class ActivityTravelTipsShareBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout mFragmentContainer;

    @androidx.annotation.NonNull
    public final android.widget.ProgressBar mProgressBar;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout mShareContainer;

    @androidx.annotation.NonNull
    public final com.moji.share.pane.PaneShareView mShareView;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout n;

    @androidx.annotation.NonNull
    public final com.moji.titlebar.MJTitleBar travelTipsTitleBar;

    public ActivityTravelTipsShareBinding(@androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout, @androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull android.widget.ProgressBar progressBar, @androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout2, @androidx.annotation.NonNull com.moji.share.pane.PaneShareView paneShareView, @androidx.annotation.NonNull com.moji.titlebar.MJTitleBar mJTitleBar) {
        this.n = relativeLayout;
        this.mFragmentContainer = frameLayout;
        this.mProgressBar = progressBar;
        this.mShareContainer = relativeLayout2;
        this.mShareView = paneShareView;
        this.travelTipsTitleBar = mJTitleBar;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivityTravelTipsShareBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.share.pane.PaneShareView findChildViewById;
        com.moji.titlebar.MJTitleBar findChildViewById2;
        int i = moji.com.mjweather.R.id.mFragmentContainer;
        android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (frameLayout != null) {
            i = moji.com.mjweather.R.id.mProgressBar;
            android.widget.ProgressBar progressBar = (android.widget.ProgressBar) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (progressBar != null) {
                i = moji.com.mjweather.R.id.mShareContainer;
                android.widget.RelativeLayout relativeLayout = (android.widget.RelativeLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (relativeLayout != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.mShareView))) != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.travelTipsTitleBar))) != null) {
                    return new moji.com.mjweather.databinding.ActivityTravelTipsShareBinding((android.widget.RelativeLayout) view, frameLayout, progressBar, relativeLayout, findChildViewById, findChildViewById2);
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivityTravelTipsShareBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivityTravelTipsShareBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.activity_travel_tips_share, viewGroup, false);
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
