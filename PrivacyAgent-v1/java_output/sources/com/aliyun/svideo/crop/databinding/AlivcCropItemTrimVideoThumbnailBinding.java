package com.aliyun.svideo.crop.databinding;

/* loaded from: classes.dex */
public final class AlivcCropItemTrimVideoThumbnailBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.aliyun.svideo.base.widget.SquareFrameLayout aliyunVideoTailorFrame;

    @androidx.annotation.NonNull
    public final android.widget.ImageView aliyunVideoTailorImgItem;

    @androidx.annotation.NonNull
    private final android.widget.FrameLayout rootView;

    private AlivcCropItemTrimVideoThumbnailBinding(@androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull com.aliyun.svideo.base.widget.SquareFrameLayout squareFrameLayout, @androidx.annotation.NonNull android.widget.ImageView imageView) {
        this.rootView = frameLayout;
        this.aliyunVideoTailorFrame = squareFrameLayout;
        this.aliyunVideoTailorImgItem = imageView;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.crop.databinding.AlivcCropItemTrimVideoThumbnailBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = com.aliyun.svideo.crop.R.id.aliyun_video_tailor_frame;
        com.aliyun.svideo.base.widget.SquareFrameLayout squareFrameLayout = (com.aliyun.svideo.base.widget.SquareFrameLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (squareFrameLayout != null) {
            i = com.aliyun.svideo.crop.R.id.aliyun_video_tailor_img_item;
            android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                return new com.aliyun.svideo.crop.databinding.AlivcCropItemTrimVideoThumbnailBinding((android.widget.FrameLayout) view, squareFrameLayout, imageView);
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.crop.databinding.AlivcCropItemTrimVideoThumbnailBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.crop.databinding.AlivcCropItemTrimVideoThumbnailBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.crop.R.layout.alivc_crop_item_trim_video_thumbnail, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public android.widget.FrameLayout getRoot() {
        return this.rootView;
    }
}
