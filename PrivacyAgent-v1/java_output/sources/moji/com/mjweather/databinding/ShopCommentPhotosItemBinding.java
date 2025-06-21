package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class ShopCommentPhotosItemBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivMallCommentPhotosItem;

    @androidx.annotation.NonNull
    public final com.moji.SquareLayout n;

    public ShopCommentPhotosItemBinding(@androidx.annotation.NonNull com.moji.SquareLayout squareLayout, @androidx.annotation.NonNull android.widget.ImageView imageView) {
        this.n = squareLayout;
        this.ivMallCommentPhotosItem = imageView;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ShopCommentPhotosItemBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = moji.com.mjweather.R.id.iv_mall_comment_photos_item;
        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            return new moji.com.mjweather.databinding.ShopCommentPhotosItemBinding((com.moji.SquareLayout) view, imageView);
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ShopCommentPhotosItemBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ShopCommentPhotosItemBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.shop_comment_photos_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public com.moji.SquareLayout getRoot() {
        return this.n;
    }
}
