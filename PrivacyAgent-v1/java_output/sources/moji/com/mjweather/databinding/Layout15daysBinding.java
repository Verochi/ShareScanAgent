package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class Layout15daysBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.moji.mjad.common.view.CommonAdView adDay15;

    @androidx.annotation.NonNull
    public final com.moji.imageview.MJImageView day15IvSwitch;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView day15Switch;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout day15SwitchContainer;

    @androidx.annotation.NonNull
    public final android.view.ViewStub day15SwitchPop;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView day15Text;

    @androidx.annotation.NonNull
    public final com.moji.HorizontalMoreLayout horizontalMoreLayout;

    @androidx.annotation.NonNull
    public final android.view.View n;

    @androidx.annotation.NonNull
    public final androidx.recyclerview.widget.RecyclerView rvDays15;

    @androidx.annotation.NonNull
    public final android.view.View titleDividerView;

    public Layout15daysBinding(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull com.moji.mjad.common.view.CommonAdView commonAdView, @androidx.annotation.NonNull com.moji.imageview.MJImageView mJImageView, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.view.ViewStub viewStub, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView2, @androidx.annotation.NonNull com.moji.HorizontalMoreLayout horizontalMoreLayout, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView, @androidx.annotation.NonNull android.view.View view2) {
        this.n = view;
        this.adDay15 = commonAdView;
        this.day15IvSwitch = mJImageView;
        this.day15Switch = mJTextView;
        this.day15SwitchContainer = linearLayout;
        this.day15SwitchPop = viewStub;
        this.day15Text = mJTextView2;
        this.horizontalMoreLayout = horizontalMoreLayout;
        this.rvDays15 = recyclerView;
        this.titleDividerView = view2;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.Layout15daysBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.imageview.MJImageView findChildViewById;
        com.moji.textview.MJTextView findChildViewById2;
        com.moji.textview.MJTextView findChildViewById3;
        com.moji.HorizontalMoreLayout findChildViewById4;
        android.view.View findChildViewById5;
        int i = moji.com.mjweather.R.id.ad_day15;
        com.moji.mjad.common.view.CommonAdView findChildViewById6 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById6 != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.day15_iv_switch))) != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.day15_switch))) != null) {
            i = moji.com.mjweather.R.id.day15_switch_container;
            android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = moji.com.mjweather.R.id.day15_switch_pop;
                android.view.ViewStub viewStub = (android.view.ViewStub) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (viewStub != null && (findChildViewById3 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.day15_text))) != null && (findChildViewById4 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.horizontal_more_layout))) != null) {
                    i = moji.com.mjweather.R.id.rv_days15;
                    androidx.recyclerview.widget.RecyclerView recyclerView = (androidx.recyclerview.widget.RecyclerView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (recyclerView != null && (findChildViewById5 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.titleDividerView))) != null) {
                        return new moji.com.mjweather.databinding.Layout15daysBinding(view, findChildViewById6, findChildViewById, findChildViewById2, linearLayout, viewStub, findChildViewById3, findChildViewById4, recyclerView, findChildViewById5);
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.Layout15daysBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.NonNull android.view.ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new java.lang.NullPointerException("parent");
        }
        layoutInflater.inflate(moji.com.mjweather.R.layout.layout_15days, viewGroup);
        return bind(viewGroup);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public android.view.View getRoot() {
        return this.n;
    }
}
