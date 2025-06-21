package com.aliyun.svideo.media.databinding;

/* loaded from: classes12.dex */
public final class AlivcMediaItemVideoSelectedBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivDelete;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivPhoto;

    @androidx.annotation.NonNull
    private final android.widget.RelativeLayout rootView;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvDuration;

    private AlivcMediaItemVideoSelectedBinding(@androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.ImageView imageView2, @androidx.annotation.NonNull android.widget.TextView textView) {
        this.rootView = relativeLayout;
        this.ivDelete = imageView;
        this.ivPhoto = imageView2;
        this.tvDuration = textView;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.media.databinding.AlivcMediaItemVideoSelectedBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = com.aliyun.svideo.media.R.id.iv_delete;
        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = com.aliyun.svideo.media.R.id.iv_photo;
            android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = com.aliyun.svideo.media.R.id.tv_duration;
                android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    return new com.aliyun.svideo.media.databinding.AlivcMediaItemVideoSelectedBinding((android.widget.RelativeLayout) view, imageView, imageView2, textView);
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.media.databinding.AlivcMediaItemVideoSelectedBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.media.databinding.AlivcMediaItemVideoSelectedBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.media.R.layout.alivc_media_item_video_selected, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public android.widget.RelativeLayout getRoot() {
        return this.rootView;
    }
}
