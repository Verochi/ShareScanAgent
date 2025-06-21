package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class ActivityTideDetailsBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivBkTide;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout llTideAll;

    @androidx.annotation.NonNull
    public final com.moji.multiplestatuslayout.MJMultipleStatusLayout mjTideLoading;

    @androidx.annotation.NonNull
    public final com.moji.titlebar.MJTitleBar mjTitleBar;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout n;

    @androidx.annotation.NonNull
    public final android.widget.ScrollView scrollView;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout tideDetailContent;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout tideDetailDataContainerLl;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout tideDetailNoTideDataLl;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvTideBottom;

    public ActivityTideDetailsBinding(@androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull com.moji.multiplestatuslayout.MJMultipleStatusLayout mJMultipleStatusLayout, @androidx.annotation.NonNull com.moji.titlebar.MJTitleBar mJTitleBar, @androidx.annotation.NonNull android.widget.ScrollView scrollView, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout2, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout3, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout4, @androidx.annotation.NonNull android.widget.TextView textView) {
        this.n = frameLayout;
        this.ivBkTide = imageView;
        this.llTideAll = linearLayout;
        this.mjTideLoading = mJMultipleStatusLayout;
        this.mjTitleBar = mJTitleBar;
        this.scrollView = scrollView;
        this.tideDetailContent = linearLayout2;
        this.tideDetailDataContainerLl = linearLayout3;
        this.tideDetailNoTideDataLl = linearLayout4;
        this.tvTideBottom = textView;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivityTideDetailsBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.multiplestatuslayout.MJMultipleStatusLayout findChildViewById;
        com.moji.titlebar.MJTitleBar findChildViewById2;
        int i = moji.com.mjweather.R.id.iv_bk_tide;
        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = moji.com.mjweather.R.id.ll_tide_all;
            android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (linearLayout != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.mj_tide_loading))) != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.mj_title_bar))) != null) {
                i = moji.com.mjweather.R.id.scroll_view;
                android.widget.ScrollView scrollView = (android.widget.ScrollView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (scrollView != null) {
                    i = moji.com.mjweather.R.id.tide_detail_content;
                    android.widget.LinearLayout linearLayout2 = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (linearLayout2 != null) {
                        i = moji.com.mjweather.R.id.tide_detail_data_container_ll;
                        android.widget.LinearLayout linearLayout3 = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (linearLayout3 != null) {
                            i = moji.com.mjweather.R.id.tide_detail_no_tide_data_ll;
                            android.widget.LinearLayout linearLayout4 = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (linearLayout4 != null) {
                                i = moji.com.mjweather.R.id.tv_tide_bottom;
                                android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (textView != null) {
                                    return new moji.com.mjweather.databinding.ActivityTideDetailsBinding((android.widget.FrameLayout) view, imageView, linearLayout, findChildViewById, findChildViewById2, scrollView, linearLayout2, linearLayout3, linearLayout4, textView);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivityTideDetailsBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivityTideDetailsBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.activity_tide_details, viewGroup, false);
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
