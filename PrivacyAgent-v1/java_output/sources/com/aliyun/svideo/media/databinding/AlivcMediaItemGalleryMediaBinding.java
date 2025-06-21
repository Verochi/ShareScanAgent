package com.aliyun.svideo.media.databinding;

/* loaded from: classes12.dex */
public final class AlivcMediaItemGalleryMediaBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.TextView draftDuration;

    @androidx.annotation.NonNull
    public final com.aliyun.svideo.common.widget.RoundSquareView draftThumbnail;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout durationLayoput;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivMask;

    @androidx.annotation.NonNull
    private final com.aliyun.svideo.common.widget.SquareFrameLayout rootView;

    private AlivcMediaItemGalleryMediaBinding(@androidx.annotation.NonNull com.aliyun.svideo.common.widget.SquareFrameLayout squareFrameLayout, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull com.aliyun.svideo.common.widget.RoundSquareView roundSquareView, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.ImageView imageView) {
        this.rootView = squareFrameLayout;
        this.draftDuration = textView;
        this.draftThumbnail = roundSquareView;
        this.durationLayoput = linearLayout;
        this.ivMask = imageView;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.media.databinding.AlivcMediaItemGalleryMediaBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = com.aliyun.svideo.media.R.id.draft_duration;
        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = com.aliyun.svideo.media.R.id.draft_thumbnail;
            com.aliyun.svideo.common.widget.RoundSquareView roundSquareView = (com.aliyun.svideo.common.widget.RoundSquareView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (roundSquareView != null) {
                i = com.aliyun.svideo.media.R.id.duration_layoput;
                android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (linearLayout != null) {
                    i = com.aliyun.svideo.media.R.id.iv_mask;
                    android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        return new com.aliyun.svideo.media.databinding.AlivcMediaItemGalleryMediaBinding((com.aliyun.svideo.common.widget.SquareFrameLayout) view, textView, roundSquareView, linearLayout, imageView);
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.media.databinding.AlivcMediaItemGalleryMediaBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.media.databinding.AlivcMediaItemGalleryMediaBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.media.R.layout.alivc_media_item_gallery_media, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public com.aliyun.svideo.common.widget.SquareFrameLayout getRoot() {
        return this.rootView;
    }
}
