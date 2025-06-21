package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class HomeWeatherExpressItemPictureBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout bottmRoot;

    @androidx.annotation.NonNull
    public final com.moji.imageview.MJImageView ivPic;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivShadow;

    @androidx.annotation.NonNull
    public final com.moji.imageview.FourCornerImageView ivVideo;

    @androidx.annotation.NonNull
    public final com.moji.imageview.FourCornerImageView mHeadImg;

    @androidx.annotation.NonNull
    public final android.widget.ImageView mHeaderRoot;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView mNickTxt;

    @androidx.annotation.NonNull
    public final com.moji.paraiseview.WaterFallPraiseView mPraiseView2;

    @androidx.annotation.NonNull
    public final android.widget.ImageView mTitleRoot;

    @androidx.annotation.NonNull
    public final com.moji.cardView.CardView n;

    @androidx.annotation.NonNull
    public final com.moji.TickConstraintLayout tickLayout;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView tvTitle;

    public HomeWeatherExpressItemPictureBinding(@androidx.annotation.NonNull com.moji.cardView.CardView cardView, @androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull com.moji.imageview.MJImageView mJImageView, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull com.moji.imageview.FourCornerImageView fourCornerImageView, @androidx.annotation.NonNull com.moji.imageview.FourCornerImageView fourCornerImageView2, @androidx.annotation.NonNull android.widget.ImageView imageView2, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView, @androidx.annotation.NonNull com.moji.paraiseview.WaterFallPraiseView waterFallPraiseView, @androidx.annotation.NonNull android.widget.ImageView imageView3, @androidx.annotation.NonNull com.moji.TickConstraintLayout tickConstraintLayout, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView2) {
        this.n = cardView;
        this.bottmRoot = constraintLayout;
        this.ivPic = mJImageView;
        this.ivShadow = imageView;
        this.ivVideo = fourCornerImageView;
        this.mHeadImg = fourCornerImageView2;
        this.mHeaderRoot = imageView2;
        this.mNickTxt = mJTextView;
        this.mPraiseView2 = waterFallPraiseView;
        this.mTitleRoot = imageView3;
        this.tickLayout = tickConstraintLayout;
        this.tvTitle = mJTextView2;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.HomeWeatherExpressItemPictureBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.imageview.MJImageView findChildViewById;
        com.moji.imageview.FourCornerImageView findChildViewById2;
        com.moji.imageview.FourCornerImageView findChildViewById3;
        com.moji.textview.MJTextView findChildViewById4;
        com.moji.paraiseview.WaterFallPraiseView findChildViewById5;
        com.moji.TickConstraintLayout findChildViewById6;
        com.moji.textview.MJTextView findChildViewById7;
        int i = moji.com.mjweather.R.id.bottmRoot;
        androidx.constraintlayout.widget.ConstraintLayout constraintLayout = (androidx.constraintlayout.widget.ConstraintLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.ivPic))) != null) {
            i = moji.com.mjweather.R.id.ivShadow;
            android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (imageView != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.ivVideo))) != null && (findChildViewById3 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.mHeadImg))) != null) {
                i = moji.com.mjweather.R.id.mHeaderRoot;
                android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (imageView2 != null && (findChildViewById4 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.mNickTxt))) != null && (findChildViewById5 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.mPraiseView2))) != null) {
                    i = moji.com.mjweather.R.id.mTitleRoot;
                    android.widget.ImageView imageView3 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (imageView3 != null && (findChildViewById6 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tickLayout))) != null && (findChildViewById7 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tvTitle))) != null) {
                        return new moji.com.mjweather.databinding.HomeWeatherExpressItemPictureBinding((com.moji.cardView.CardView) view, constraintLayout, findChildViewById, imageView, findChildViewById2, findChildViewById3, imageView2, findChildViewById4, findChildViewById5, imageView3, findChildViewById6, findChildViewById7);
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.HomeWeatherExpressItemPictureBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.HomeWeatherExpressItemPictureBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.home_weather_express_item_picture, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public com.moji.cardView.CardView getRoot() {
        return this.n;
    }
}
