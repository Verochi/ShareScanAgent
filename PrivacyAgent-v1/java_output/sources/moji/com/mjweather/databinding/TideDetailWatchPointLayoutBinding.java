package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class TideDetailWatchPointLayoutBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout n;

    @androidx.annotation.NonNull
    public final com.moji.base.curve.Day15Hour24HorizontalScrollView scrollviewTrend;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.dailydetail.view.TideCurveView tideCurveView;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout tideDetail24hourTrend;

    @androidx.annotation.NonNull
    public final android.widget.ImageView tideDetailBtnSwitch;

    @androidx.annotation.NonNull
    public final android.widget.ImageView tideDetailDivider;

    @androidx.annotation.NonNull
    public final android.widget.TextView tideDetailPortName;

    @androidx.annotation.NonNull
    public final android.widget.TextView tideDetailSeaLevel;

    @androidx.annotation.NonNull
    public final com.moji.index.view.TideTrendView tideDetailTrendView;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.dailydetail.view.TideFloatView tideFloatView;

    public TideDetailWatchPointLayoutBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull com.moji.base.curve.Day15Hour24HorizontalScrollView day15Hour24HorizontalScrollView, @androidx.annotation.NonNull com.moji.mjweather.dailydetail.view.TideCurveView tideCurveView, @androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.ImageView imageView2, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull com.moji.index.view.TideTrendView tideTrendView, @androidx.annotation.NonNull com.moji.mjweather.dailydetail.view.TideFloatView tideFloatView) {
        this.n = linearLayout;
        this.scrollviewTrend = day15Hour24HorizontalScrollView;
        this.tideCurveView = tideCurveView;
        this.tideDetail24hourTrend = relativeLayout;
        this.tideDetailBtnSwitch = imageView;
        this.tideDetailDivider = imageView2;
        this.tideDetailPortName = textView;
        this.tideDetailSeaLevel = textView2;
        this.tideDetailTrendView = tideTrendView;
        this.tideFloatView = tideFloatView;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.TideDetailWatchPointLayoutBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.mjweather.dailydetail.view.TideCurveView findChildViewById;
        com.moji.index.view.TideTrendView findChildViewById2;
        com.moji.mjweather.dailydetail.view.TideFloatView findChildViewById3;
        int i = moji.com.mjweather.R.id.scrollview_trend;
        com.moji.base.curve.Day15Hour24HorizontalScrollView findChildViewById4 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById4 != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tide_curve_view))) != null) {
            i = moji.com.mjweather.R.id.tide_detail_24hour_trend;
            android.widget.RelativeLayout relativeLayout = (android.widget.RelativeLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (relativeLayout != null) {
                i = moji.com.mjweather.R.id.tide_detail_btn_switch;
                android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = moji.com.mjweather.R.id.tide_detail_divider;
                    android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (imageView2 != null) {
                        i = moji.com.mjweather.R.id.tide_detail_port_name;
                        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            i = moji.com.mjweather.R.id.tide_detail_sea_level;
                            android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (textView2 != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tide_detail_trend_view))) != null && (findChildViewById3 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tide_float_view))) != null) {
                                return new moji.com.mjweather.databinding.TideDetailWatchPointLayoutBinding((android.widget.LinearLayout) view, findChildViewById4, findChildViewById, relativeLayout, imageView, imageView2, textView, textView2, findChildViewById2, findChildViewById3);
                            }
                        }
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.TideDetailWatchPointLayoutBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.TideDetailWatchPointLayoutBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.tide_detail_watch_point_layout, viewGroup, false);
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
