package moji.com.mjweather.databinding;

/* loaded from: classes31.dex */
public final class ActivityAbnormalExplainBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.view.View abnormalDivider;

    @androidx.annotation.NonNull
    public final com.moji.titlebar.MJTitleBar abnormalExplainTitle;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout gpsAbnormalTip;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout gpsLayout;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout n;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout netLayout;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvGpsTip;

    public ActivityAbnormalExplainBinding(@androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull com.moji.titlebar.MJTitleBar mJTitleBar, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout2, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout3, @androidx.annotation.NonNull android.widget.TextView textView) {
        this.n = relativeLayout;
        this.abnormalDivider = view;
        this.abnormalExplainTitle = mJTitleBar;
        this.gpsAbnormalTip = linearLayout;
        this.gpsLayout = linearLayout2;
        this.netLayout = linearLayout3;
        this.tvGpsTip = textView;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivityAbnormalExplainBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.titlebar.MJTitleBar findChildViewById;
        int i = moji.com.mjweather.R.id.abnormal_divider;
        android.view.View findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById2 != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.abnormal_explain_title))) != null) {
            i = moji.com.mjweather.R.id.gps_abnormal_tip;
            android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = moji.com.mjweather.R.id.gps_layout;
                android.widget.LinearLayout linearLayout2 = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (linearLayout2 != null) {
                    i = moji.com.mjweather.R.id.net_layout;
                    android.widget.LinearLayout linearLayout3 = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (linearLayout3 != null) {
                        i = moji.com.mjweather.R.id.tv_gps_tip;
                        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            return new moji.com.mjweather.databinding.ActivityAbnormalExplainBinding((android.widget.RelativeLayout) view, findChildViewById2, findChildViewById, linearLayout, linearLayout2, linearLayout3, textView);
                        }
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivityAbnormalExplainBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivityAbnormalExplainBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.activity_abnormal_explain, viewGroup, false);
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
