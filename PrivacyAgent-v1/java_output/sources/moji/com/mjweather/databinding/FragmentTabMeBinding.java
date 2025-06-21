package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class FragmentTabMeBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout content;

    @androidx.annotation.NonNull
    public final com.moji.mjad.view.DragFloatButton dfbMeButton;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout llContainerContent;

    @androidx.annotation.NonNull
    public final android.widget.Space mHeaderSpace;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout n;

    @androidx.annotation.NonNull
    public final com.moji.pullzoom.PullZoomLayout pullZoomLayout;

    @androidx.annotation.NonNull
    public final com.moji.scrollview.NestedScrollMonitor scrollview;

    @androidx.annotation.NonNull
    public final com.moji.card.view.OpCardContainerView vCardContainer;

    public FragmentTabMeBinding(@androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull com.moji.mjad.view.DragFloatButton dragFloatButton, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout2, @androidx.annotation.NonNull android.widget.Space space, @androidx.annotation.NonNull com.moji.pullzoom.PullZoomLayout pullZoomLayout, @androidx.annotation.NonNull com.moji.scrollview.NestedScrollMonitor nestedScrollMonitor, @androidx.annotation.NonNull com.moji.card.view.OpCardContainerView opCardContainerView) {
        this.n = frameLayout;
        this.content = linearLayout;
        this.dfbMeButton = dragFloatButton;
        this.llContainerContent = linearLayout2;
        this.mHeaderSpace = space;
        this.pullZoomLayout = pullZoomLayout;
        this.scrollview = nestedScrollMonitor;
        this.vCardContainer = opCardContainerView;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.FragmentTabMeBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.mjad.view.DragFloatButton findChildViewById;
        com.moji.pullzoom.PullZoomLayout findChildViewById2;
        com.moji.scrollview.NestedScrollMonitor findChildViewById3;
        com.moji.card.view.OpCardContainerView findChildViewById4;
        int i = moji.com.mjweather.R.id.content;
        android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (linearLayout != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.dfb_me_button))) != null) {
            i = moji.com.mjweather.R.id.ll_container_content;
            android.widget.LinearLayout linearLayout2 = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (linearLayout2 != null) {
                i = moji.com.mjweather.R.id.mHeaderSpace;
                android.widget.Space space = (android.widget.Space) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (space != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.pull_zoom_layout))) != null && (findChildViewById3 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.scrollview))) != null && (findChildViewById4 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.v_card_container))) != null) {
                    return new moji.com.mjweather.databinding.FragmentTabMeBinding((android.widget.FrameLayout) view, linearLayout, findChildViewById, linearLayout2, space, findChildViewById2, findChildViewById3, findChildViewById4);
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.FragmentTabMeBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.FragmentTabMeBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.fragment_tab_me, viewGroup, false);
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
