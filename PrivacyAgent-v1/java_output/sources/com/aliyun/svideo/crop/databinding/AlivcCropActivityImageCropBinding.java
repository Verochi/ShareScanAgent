package com.aliyun.svideo.crop.databinding;

/* loaded from: classes.dex */
public final class AlivcCropActivityImageCropBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.ImageView aliyunBack;

    @androidx.annotation.NonNull
    public final com.aliyun.svideo.base.widget.FanProgressBar aliyunCropProgress;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout aliyunCropProgressBg;

    @androidx.annotation.NonNull
    public final android.widget.ImageView aliyunImageView;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout aliyunListLayout;

    @androidx.annotation.NonNull
    public final android.widget.ImageView aliyunNext;

    @androidx.annotation.NonNull
    public final android.widget.ImageView aliyunTransform;

    @androidx.annotation.NonNull
    public final com.aliyun.svideo.base.widget.VideoTrimFrameLayout aliyunVideoSurfaceLayout;

    @androidx.annotation.NonNull
    private final android.widget.RelativeLayout rootView;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout trimRoot;

    private AlivcCropActivityImageCropBinding(@androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull com.aliyun.svideo.base.widget.FanProgressBar fanProgressBar, @androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull android.widget.ImageView imageView2, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.ImageView imageView3, @androidx.annotation.NonNull android.widget.ImageView imageView4, @androidx.annotation.NonNull com.aliyun.svideo.base.widget.VideoTrimFrameLayout videoTrimFrameLayout, @androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout2) {
        this.rootView = relativeLayout;
        this.aliyunBack = imageView;
        this.aliyunCropProgress = fanProgressBar;
        this.aliyunCropProgressBg = frameLayout;
        this.aliyunImageView = imageView2;
        this.aliyunListLayout = linearLayout;
        this.aliyunNext = imageView3;
        this.aliyunTransform = imageView4;
        this.aliyunVideoSurfaceLayout = videoTrimFrameLayout;
        this.trimRoot = relativeLayout2;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.crop.databinding.AlivcCropActivityImageCropBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = com.aliyun.svideo.crop.R.id.aliyun_back;
        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = com.aliyun.svideo.crop.R.id.aliyun_crop_progress;
            com.aliyun.svideo.base.widget.FanProgressBar fanProgressBar = (com.aliyun.svideo.base.widget.FanProgressBar) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (fanProgressBar != null) {
                i = com.aliyun.svideo.crop.R.id.aliyun_crop_progress_bg;
                android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (frameLayout != null) {
                    i = com.aliyun.svideo.crop.R.id.aliyun_image_view;
                    android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (imageView2 != null) {
                        i = com.aliyun.svideo.crop.R.id.aliyun_list_layout;
                        android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (linearLayout != null) {
                            i = com.aliyun.svideo.crop.R.id.aliyun_next;
                            android.widget.ImageView imageView3 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (imageView3 != null) {
                                i = com.aliyun.svideo.crop.R.id.aliyun_transform;
                                android.widget.ImageView imageView4 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (imageView4 != null) {
                                    i = com.aliyun.svideo.crop.R.id.aliyun_video_surfaceLayout;
                                    com.aliyun.svideo.base.widget.VideoTrimFrameLayout videoTrimFrameLayout = (com.aliyun.svideo.base.widget.VideoTrimFrameLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                    if (videoTrimFrameLayout != null) {
                                        android.widget.RelativeLayout relativeLayout = (android.widget.RelativeLayout) view;
                                        return new com.aliyun.svideo.crop.databinding.AlivcCropActivityImageCropBinding(relativeLayout, imageView, fanProgressBar, frameLayout, imageView2, linearLayout, imageView3, imageView4, videoTrimFrameLayout, relativeLayout);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.crop.databinding.AlivcCropActivityImageCropBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.crop.databinding.AlivcCropActivityImageCropBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.crop.R.layout.alivc_crop_activity_image_crop, viewGroup, false);
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
