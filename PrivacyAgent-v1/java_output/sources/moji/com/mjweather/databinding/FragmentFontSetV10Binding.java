package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class FragmentFontSetV10Binding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView fontBigTxt;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView fontNormalTxt;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout fontSizeBtnContainer;

    @androidx.annotation.NonNull
    public final android.widget.ImageView fontSizePreview;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView fontSizeSwitchDesc;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout n;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView tvFontSizePreview;

    public FragmentFontSetV10Binding(@androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView2, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView3, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView4) {
        this.n = constraintLayout;
        this.fontBigTxt = mJTextView;
        this.fontNormalTxt = mJTextView2;
        this.fontSizeBtnContainer = linearLayout;
        this.fontSizePreview = imageView;
        this.fontSizeSwitchDesc = mJTextView3;
        this.tvFontSizePreview = mJTextView4;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.FragmentFontSetV10Binding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.textview.MJTextView findChildViewById;
        com.moji.textview.MJTextView findChildViewById2;
        com.moji.textview.MJTextView findChildViewById3;
        int i = moji.com.mjweather.R.id.font_big_txt;
        com.moji.textview.MJTextView findChildViewById4 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById4 != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.font_normal_txt))) != null) {
            i = moji.com.mjweather.R.id.font_size_btn_container;
            android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = moji.com.mjweather.R.id.font_size_preview;
                android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (imageView != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.font_size_switch_desc))) != null && (findChildViewById3 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tv_font_size_preview))) != null) {
                    return new moji.com.mjweather.databinding.FragmentFontSetV10Binding((androidx.constraintlayout.widget.ConstraintLayout) view, findChildViewById4, findChildViewById, linearLayout, imageView, findChildViewById2, findChildViewById3);
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.FragmentFontSetV10Binding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.FragmentFontSetV10Binding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.fragment_font_set_v10, viewGroup, false);
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
