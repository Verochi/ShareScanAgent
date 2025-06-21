package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class ItemDailyDetailGlowBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout detailGlowView;

    @androidx.annotation.NonNull
    public final moji.com.mjweather.databinding.LayoutDailyItemHeaderBinding layoutHeader;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout n;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView tvRateProbability;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView tvRateQuality;

    public ItemDailyDetailGlowBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout2, @androidx.annotation.NonNull moji.com.mjweather.databinding.LayoutDailyItemHeaderBinding layoutDailyItemHeaderBinding, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView2) {
        this.n = linearLayout;
        this.detailGlowView = linearLayout2;
        this.layoutHeader = layoutDailyItemHeaderBinding;
        this.tvRateProbability = mJTextView;
        this.tvRateQuality = mJTextView2;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ItemDailyDetailGlowBinding bind(@androidx.annotation.NonNull android.view.View view) {
        android.view.View findChildViewById;
        com.moji.textview.MJTextView findChildViewById2;
        int i = moji.com.mjweather.R.id.detail_glow_view;
        android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (linearLayout != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.layout_header))) != null) {
            moji.com.mjweather.databinding.LayoutDailyItemHeaderBinding bind = moji.com.mjweather.databinding.LayoutDailyItemHeaderBinding.bind(findChildViewById);
            i = moji.com.mjweather.R.id.tv_rate_probability;
            com.moji.textview.MJTextView findChildViewById3 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (findChildViewById3 != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tv_rate_quality))) != null) {
                return new moji.com.mjweather.databinding.ItemDailyDetailGlowBinding((android.widget.LinearLayout) view, linearLayout, bind, findChildViewById3, findChildViewById2);
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ItemDailyDetailGlowBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ItemDailyDetailGlowBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.item_daily_detail_glow, viewGroup, false);
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
