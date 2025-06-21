package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class DialogGuideCommonBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.moji.mjweather.guide.HomeGuideView flHighlight;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.weather.view.StatusBarImageView ivStatusBar;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout layoutBottom;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout n;

    @androidx.annotation.NonNull
    public final androidx.appcompat.widget.AppCompatTextView tvOk;

    @androidx.annotation.NonNull
    public final androidx.appcompat.widget.AppCompatTextView tvTip;

    public DialogGuideCommonBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull com.moji.mjweather.guide.HomeGuideView homeGuideView, @androidx.annotation.NonNull com.moji.mjweather.weather.view.StatusBarImageView statusBarImageView, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout2, @androidx.annotation.NonNull androidx.appcompat.widget.AppCompatTextView appCompatTextView, @androidx.annotation.NonNull androidx.appcompat.widget.AppCompatTextView appCompatTextView2) {
        this.n = linearLayout;
        this.flHighlight = homeGuideView;
        this.ivStatusBar = statusBarImageView;
        this.layoutBottom = linearLayout2;
        this.tvOk = appCompatTextView;
        this.tvTip = appCompatTextView2;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.DialogGuideCommonBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.mjweather.weather.view.StatusBarImageView findChildViewById;
        int i = moji.com.mjweather.R.id.fl_highlight;
        com.moji.mjweather.guide.HomeGuideView findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById2 != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.iv_status_bar))) != null) {
            i = moji.com.mjweather.R.id.layout_bottom;
            android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = moji.com.mjweather.R.id.tv_ok;
                androidx.appcompat.widget.AppCompatTextView appCompatTextView = (androidx.appcompat.widget.AppCompatTextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (appCompatTextView != null) {
                    i = moji.com.mjweather.R.id.tv_tip;
                    androidx.appcompat.widget.AppCompatTextView appCompatTextView2 = (androidx.appcompat.widget.AppCompatTextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (appCompatTextView2 != null) {
                        return new moji.com.mjweather.databinding.DialogGuideCommonBinding((android.widget.LinearLayout) view, findChildViewById2, findChildViewById, linearLayout, appCompatTextView, appCompatTextView2);
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.DialogGuideCommonBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.DialogGuideCommonBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.dialog_guide_common, viewGroup, false);
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
