package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class ItemDailyDetailLimitBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.moji.imageview.MJImageView ivNext;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout layoutLimit;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout layoutNum2;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout n;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView noLimit;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView tvContent;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView tvNum1;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView tvNum2;

    public ItemDailyDetailLimitBinding(@androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout, @androidx.annotation.NonNull com.moji.imageview.MJImageView mJImageView, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout2, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView2, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView3, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView4) {
        this.n = relativeLayout;
        this.ivNext = mJImageView;
        this.layoutLimit = linearLayout;
        this.layoutNum2 = linearLayout2;
        this.noLimit = mJTextView;
        this.tvContent = mJTextView2;
        this.tvNum1 = mJTextView3;
        this.tvNum2 = mJTextView4;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ItemDailyDetailLimitBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.textview.MJTextView findChildViewById;
        com.moji.textview.MJTextView findChildViewById2;
        com.moji.textview.MJTextView findChildViewById3;
        com.moji.textview.MJTextView findChildViewById4;
        int i = moji.com.mjweather.R.id.iv_next;
        com.moji.imageview.MJImageView findChildViewById5 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById5 != null) {
            i = moji.com.mjweather.R.id.layoutLimit;
            android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = moji.com.mjweather.R.id.layoutNum2;
                android.widget.LinearLayout linearLayout2 = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (linearLayout2 != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.noLimit))) != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tv_content))) != null && (findChildViewById3 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tvNum1))) != null && (findChildViewById4 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tvNum2))) != null) {
                    return new moji.com.mjweather.databinding.ItemDailyDetailLimitBinding((android.widget.RelativeLayout) view, findChildViewById5, linearLayout, linearLayout2, findChildViewById, findChildViewById2, findChildViewById3, findChildViewById4);
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ItemDailyDetailLimitBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ItemDailyDetailLimitBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.item_daily_detail_limit, viewGroup, false);
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
