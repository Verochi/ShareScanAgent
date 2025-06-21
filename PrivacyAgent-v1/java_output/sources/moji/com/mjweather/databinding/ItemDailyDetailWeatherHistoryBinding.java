package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class ItemDailyDetailWeatherHistoryBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout clWeatherHistoryContent;

    @androidx.annotation.NonNull
    public final com.moji.imageview.MJImageView ivWeatherIcon;

    @androidx.annotation.NonNull
    public final moji.com.mjweather.databinding.LayoutDailyItemHeaderBinding layoutHeader;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout n;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView tvDate;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView tvTemp;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView tvTempDu;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView tvWeatherDes;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView tvWeatherTempUnit;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView tvWindDes;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView tvWindLevel;

    public ItemDailyDetailWeatherHistoryBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull com.moji.imageview.MJImageView mJImageView, @androidx.annotation.NonNull moji.com.mjweather.databinding.LayoutDailyItemHeaderBinding layoutDailyItemHeaderBinding, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView2, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView3, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView4, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView5, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView6, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView7) {
        this.n = linearLayout;
        this.clWeatherHistoryContent = constraintLayout;
        this.ivWeatherIcon = mJImageView;
        this.layoutHeader = layoutDailyItemHeaderBinding;
        this.tvDate = mJTextView;
        this.tvTemp = mJTextView2;
        this.tvTempDu = mJTextView3;
        this.tvWeatherDes = mJTextView4;
        this.tvWeatherTempUnit = mJTextView5;
        this.tvWindDes = mJTextView6;
        this.tvWindLevel = mJTextView7;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ItemDailyDetailWeatherHistoryBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.imageview.MJImageView findChildViewById;
        android.view.View findChildViewById2;
        com.moji.textview.MJTextView findChildViewById3;
        com.moji.textview.MJTextView findChildViewById4;
        com.moji.textview.MJTextView findChildViewById5;
        com.moji.textview.MJTextView findChildViewById6;
        com.moji.textview.MJTextView findChildViewById7;
        com.moji.textview.MJTextView findChildViewById8;
        int i = moji.com.mjweather.R.id.cl_weather_history_content;
        androidx.constraintlayout.widget.ConstraintLayout constraintLayout = (androidx.constraintlayout.widget.ConstraintLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.iv_weather_icon))) != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.layout_header))) != null) {
            moji.com.mjweather.databinding.LayoutDailyItemHeaderBinding bind = moji.com.mjweather.databinding.LayoutDailyItemHeaderBinding.bind(findChildViewById2);
            i = moji.com.mjweather.R.id.tv_date;
            com.moji.textview.MJTextView findChildViewById9 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (findChildViewById9 != null && (findChildViewById3 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tv_temp))) != null && (findChildViewById4 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tv_temp_du))) != null && (findChildViewById5 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tv_weather_des))) != null && (findChildViewById6 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tv_weather_temp_unit))) != null && (findChildViewById7 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tv_wind_des))) != null && (findChildViewById8 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tv_wind_level))) != null) {
                return new moji.com.mjweather.databinding.ItemDailyDetailWeatherHistoryBinding((android.widget.LinearLayout) view, constraintLayout, findChildViewById, bind, findChildViewById9, findChildViewById3, findChildViewById4, findChildViewById5, findChildViewById6, findChildViewById7, findChildViewById8);
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ItemDailyDetailWeatherHistoryBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ItemDailyDetailWeatherHistoryBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.item_daily_detail_weather_history, viewGroup, false);
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
