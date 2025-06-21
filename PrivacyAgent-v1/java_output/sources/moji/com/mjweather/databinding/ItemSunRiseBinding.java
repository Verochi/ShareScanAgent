package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class ItemSunRiseBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView labelSet;

    @androidx.annotation.NonNull
    public final moji.com.mjweather.databinding.LayoutDailyItemHeaderBinding layoutHeader;

    @androidx.annotation.NonNull
    public final android.view.View lineRise;

    @androidx.annotation.NonNull
    public final android.view.View lineSet;

    @androidx.annotation.NonNull
    public final android.view.View middleLine;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout n;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView riseLabel;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.dailydetails.view.RiseView sunRiseView;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView tvSunRise;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView tvSunSet;

    public ItemSunRiseBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView, @androidx.annotation.NonNull moji.com.mjweather.databinding.LayoutDailyItemHeaderBinding layoutDailyItemHeaderBinding, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.view.View view2, @androidx.annotation.NonNull android.view.View view3, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView2, @androidx.annotation.NonNull com.moji.mjweather.dailydetails.view.RiseView riseView, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView3, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView4) {
        this.n = linearLayout;
        this.labelSet = mJTextView;
        this.layoutHeader = layoutDailyItemHeaderBinding;
        this.lineRise = view;
        this.lineSet = view2;
        this.middleLine = view3;
        this.riseLabel = mJTextView2;
        this.sunRiseView = riseView;
        this.tvSunRise = mJTextView3;
        this.tvSunSet = mJTextView4;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ItemSunRiseBinding bind(@androidx.annotation.NonNull android.view.View view) {
        android.view.View findChildViewById;
        android.view.View findChildViewById2;
        android.view.View findChildViewById3;
        com.moji.textview.MJTextView findChildViewById4;
        com.moji.mjweather.dailydetails.view.RiseView findChildViewById5;
        com.moji.textview.MJTextView findChildViewById6;
        com.moji.textview.MJTextView findChildViewById7;
        int i = moji.com.mjweather.R.id.label_set;
        com.moji.textview.MJTextView findChildViewById8 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById8 != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.layout_header))) != null) {
            moji.com.mjweather.databinding.LayoutDailyItemHeaderBinding bind = moji.com.mjweather.databinding.LayoutDailyItemHeaderBinding.bind(findChildViewById);
            i = moji.com.mjweather.R.id.line_rise;
            android.view.View findChildViewById9 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (findChildViewById9 != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.line_set))) != null && (findChildViewById3 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.middle_line))) != null && (findChildViewById4 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.rise_label))) != null && (findChildViewById5 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.sunRiseView))) != null && (findChildViewById6 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tv_sun_rise))) != null && (findChildViewById7 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tv_sun_set))) != null) {
                return new moji.com.mjweather.databinding.ItemSunRiseBinding((android.widget.LinearLayout) view, findChildViewById8, bind, findChildViewById9, findChildViewById2, findChildViewById3, findChildViewById4, findChildViewById5, findChildViewById6, findChildViewById7);
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ItemSunRiseBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ItemSunRiseBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.item_sun_rise, viewGroup, false);
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
