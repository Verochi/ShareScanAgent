package moji.com.mjweatherservicebase.databinding;

/* loaded from: classes20.dex */
public final class FlowersVerticalItemPicBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.moji.imageview.RoundCornerImageView n;

    @androidx.annotation.NonNull
    public final com.moji.imageview.RoundCornerImageView sceneImage;

    public FlowersVerticalItemPicBinding(@androidx.annotation.NonNull com.moji.imageview.RoundCornerImageView roundCornerImageView, @androidx.annotation.NonNull com.moji.imageview.RoundCornerImageView roundCornerImageView2) {
        this.n = roundCornerImageView;
        this.sceneImage = roundCornerImageView2;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweatherservicebase.databinding.FlowersVerticalItemPicBinding bind(@androidx.annotation.NonNull android.view.View view) {
        if (view == null) {
            throw new java.lang.NullPointerException("rootView");
        }
        com.moji.imageview.RoundCornerImageView roundCornerImageView = (com.moji.imageview.RoundCornerImageView) view;
        return new moji.com.mjweatherservicebase.databinding.FlowersVerticalItemPicBinding(roundCornerImageView, roundCornerImageView);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweatherservicebase.databinding.FlowersVerticalItemPicBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweatherservicebase.databinding.FlowersVerticalItemPicBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweatherservicebase.R.layout.flowers_vertical_item_pic, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public com.moji.imageview.RoundCornerImageView getRoot() {
        return this.n;
    }
}
