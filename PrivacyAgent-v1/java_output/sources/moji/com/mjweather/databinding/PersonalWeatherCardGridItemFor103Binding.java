package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class PersonalWeatherCardGridItemFor103Binding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.moji.mjad.view.AdTagViewWithOutIcon adTagView;

    @androidx.annotation.NonNull
    public final android.view.View indexLeftMargin;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout itemRoot;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout itemview;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivShadow;

    @androidx.annotation.NonNull
    public final android.widget.TextView mBadgeView;

    @androidx.annotation.NonNull
    public final com.moji.imageview.MJImageView mIconView;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView mSubTextView;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView mTextView;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout n;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvRight;

    public PersonalWeatherCardGridItemFor103Binding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull com.moji.mjad.view.AdTagViewWithOutIcon adTagViewWithOutIcon, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout2, @androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull com.moji.imageview.MJImageView mJImageView, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView2, @androidx.annotation.NonNull android.widget.TextView textView2) {
        this.n = linearLayout;
        this.adTagView = adTagViewWithOutIcon;
        this.indexLeftMargin = view;
        this.itemRoot = linearLayout2;
        this.itemview = constraintLayout;
        this.ivShadow = imageView;
        this.mBadgeView = textView;
        this.mIconView = mJImageView;
        this.mSubTextView = mJTextView;
        this.mTextView = mJTextView2;
        this.tvRight = textView2;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.PersonalWeatherCardGridItemFor103Binding bind(@androidx.annotation.NonNull android.view.View view) {
        android.view.View findChildViewById;
        com.moji.imageview.MJImageView findChildViewById2;
        com.moji.textview.MJTextView findChildViewById3;
        com.moji.textview.MJTextView findChildViewById4;
        int i = moji.com.mjweather.R.id.adTagView;
        com.moji.mjad.view.AdTagViewWithOutIcon findChildViewById5 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById5 != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.index_left_margin))) != null) {
            android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) view;
            i = moji.com.mjweather.R.id.itemview;
            androidx.constraintlayout.widget.ConstraintLayout constraintLayout = (androidx.constraintlayout.widget.ConstraintLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (constraintLayout != null) {
                i = moji.com.mjweather.R.id.ivShadow;
                android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = moji.com.mjweather.R.id.mBadgeView;
                    android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (textView != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.mIconView))) != null && (findChildViewById3 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.mSubTextView))) != null && (findChildViewById4 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.mTextView))) != null) {
                        i = moji.com.mjweather.R.id.tv_right;
                        android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            return new moji.com.mjweather.databinding.PersonalWeatherCardGridItemFor103Binding(linearLayout, findChildViewById5, findChildViewById, linearLayout, constraintLayout, imageView, textView, findChildViewById2, findChildViewById3, findChildViewById4, textView2);
                        }
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.PersonalWeatherCardGridItemFor103Binding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.PersonalWeatherCardGridItemFor103Binding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.personal_weather_card_grid_item_for_10_3, viewGroup, false);
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
