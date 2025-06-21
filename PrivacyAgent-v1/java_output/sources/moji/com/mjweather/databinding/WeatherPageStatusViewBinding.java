package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class WeatherPageStatusViewBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.moji.mjweather.weather.view.WeatherStatusSkeletonBottomView bottomView;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.weather.view.FirstPageSpace firstPageSpace;

    @androidx.annotation.NonNull
    public final com.moji.imageview.MJImageView ivIcon;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout n;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.weather.view.HomeTitleBarLayout titleBarLayout;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView tvActionView;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView tvMessage;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView tvSubMessage;

    public WeatherPageStatusViewBinding(@androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull com.moji.mjweather.weather.view.WeatherStatusSkeletonBottomView weatherStatusSkeletonBottomView, @androidx.annotation.NonNull com.moji.mjweather.weather.view.FirstPageSpace firstPageSpace, @androidx.annotation.NonNull com.moji.imageview.MJImageView mJImageView, @androidx.annotation.NonNull com.moji.mjweather.weather.view.HomeTitleBarLayout homeTitleBarLayout, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView2, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView3) {
        this.n = constraintLayout;
        this.bottomView = weatherStatusSkeletonBottomView;
        this.firstPageSpace = firstPageSpace;
        this.ivIcon = mJImageView;
        this.titleBarLayout = homeTitleBarLayout;
        this.tvActionView = mJTextView;
        this.tvMessage = mJTextView2;
        this.tvSubMessage = mJTextView3;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.WeatherPageStatusViewBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.mjweather.weather.view.FirstPageSpace findChildViewById;
        com.moji.imageview.MJImageView findChildViewById2;
        com.moji.mjweather.weather.view.HomeTitleBarLayout findChildViewById3;
        com.moji.textview.MJTextView findChildViewById4;
        com.moji.textview.MJTextView findChildViewById5;
        com.moji.textview.MJTextView findChildViewById6;
        int i = moji.com.mjweather.R.id.bottom_view;
        com.moji.mjweather.weather.view.WeatherStatusSkeletonBottomView findChildViewById7 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById7 == null || (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.firstPageSpace))) == null || (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.iv_icon))) == null || (findChildViewById3 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.titleBarLayout))) == null || (findChildViewById4 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tv_action_view))) == null || (findChildViewById5 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tv_message))) == null || (findChildViewById6 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tv_sub_message))) == null) {
            throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new moji.com.mjweather.databinding.WeatherPageStatusViewBinding((androidx.constraintlayout.widget.ConstraintLayout) view, findChildViewById7, findChildViewById, findChildViewById2, findChildViewById3, findChildViewById4, findChildViewById5, findChildViewById6);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.WeatherPageStatusViewBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.WeatherPageStatusViewBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.weather_page_status_view, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public androidx.constraintlayout.widget.ConstraintLayout getRoot() {
        return this.n;
    }
}
