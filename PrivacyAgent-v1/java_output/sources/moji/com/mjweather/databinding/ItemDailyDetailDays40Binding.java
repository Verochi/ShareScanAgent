package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class ItemDailyDetailDays40Binding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout bgLayout;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivLogo;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivVip;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout n;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvDesc;

    public ItemDailyDetailDays40Binding(@androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout2, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.ImageView imageView2, @androidx.annotation.NonNull android.widget.TextView textView) {
        this.n = constraintLayout;
        this.bgLayout = constraintLayout2;
        this.ivLogo = imageView;
        this.ivVip = imageView2;
        this.tvDesc = textView;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ItemDailyDetailDays40Binding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = moji.com.mjweather.R.id.bg_layout;
        androidx.constraintlayout.widget.ConstraintLayout constraintLayout = (androidx.constraintlayout.widget.ConstraintLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = moji.com.mjweather.R.id.iv_logo;
            android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = moji.com.mjweather.R.id.iv_vip;
                android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = moji.com.mjweather.R.id.tv_desc;
                    android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        return new moji.com.mjweather.databinding.ItemDailyDetailDays40Binding((androidx.constraintlayout.widget.ConstraintLayout) view, constraintLayout, imageView, imageView2, textView);
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ItemDailyDetailDays40Binding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ItemDailyDetailDays40Binding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.item_daily_detail_days_40, viewGroup, false);
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
