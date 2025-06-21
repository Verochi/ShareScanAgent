package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class DialogWidgetGuidePosionSecondBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.TextView descFirstRow;

    @androidx.annotation.NonNull
    public final android.widget.TextView descSecondRow;

    @androidx.annotation.NonNull
    public final android.widget.TextView descThirdRow;

    @androidx.annotation.NonNull
    public final android.widget.TextView know;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout llLayout;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout llLayoutBottom;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout n;

    @androidx.annotation.NonNull
    public final com.airbnb.lottie.LottieAnimationView widgetLottie;

    public DialogWidgetGuidePosionSecondBinding(@androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull android.widget.TextView textView3, @androidx.annotation.NonNull android.widget.TextView textView4, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout2, @androidx.annotation.NonNull com.airbnb.lottie.LottieAnimationView lottieAnimationView) {
        this.n = relativeLayout;
        this.descFirstRow = textView;
        this.descSecondRow = textView2;
        this.descThirdRow = textView3;
        this.know = textView4;
        this.llLayout = linearLayout;
        this.llLayoutBottom = linearLayout2;
        this.widgetLottie = lottieAnimationView;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.DialogWidgetGuidePosionSecondBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = moji.com.mjweather.R.id.desc_first_row;
        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = moji.com.mjweather.R.id.desc_second_row;
            android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = moji.com.mjweather.R.id.desc_third_row;
                android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (textView3 != null) {
                    i = moji.com.mjweather.R.id.know;
                    android.widget.TextView textView4 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (textView4 != null) {
                        i = moji.com.mjweather.R.id.ll_layout;
                        android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (linearLayout != null) {
                            i = moji.com.mjweather.R.id.ll_layout_bottom;
                            android.widget.LinearLayout linearLayout2 = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (linearLayout2 != null) {
                                i = moji.com.mjweather.R.id.widget_lottie;
                                com.airbnb.lottie.LottieAnimationView lottieAnimationView = (com.airbnb.lottie.LottieAnimationView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (lottieAnimationView != null) {
                                    return new moji.com.mjweather.databinding.DialogWidgetGuidePosionSecondBinding((android.widget.RelativeLayout) view, textView, textView2, textView3, textView4, linearLayout, linearLayout2, lottieAnimationView);
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
    public static moji.com.mjweather.databinding.DialogWidgetGuidePosionSecondBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.DialogWidgetGuidePosionSecondBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.dialog_widget_guide_posion_second, viewGroup, false);
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
