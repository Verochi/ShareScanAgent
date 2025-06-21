package com.aliyun.svideo.crop.databinding;

/* loaded from: classes.dex */
public final class AlivcCropActivityVideoCropBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.ImageView aliyunBack;

    @androidx.annotation.NonNull
    public final com.aliyun.svideo.base.widget.FanProgressBar aliyunCropProgress;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout aliyunCropProgressBg;

    @androidx.annotation.NonNull
    public final android.widget.TextView aliyunDurationTxt;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout aliyunListLayout;

    @androidx.annotation.NonNull
    public final android.widget.ImageView aliyunNext;

    @androidx.annotation.NonNull
    public final com.aliyun.svideo.base.widget.VideoSliceSeekBar aliyunSeekBar;

    @androidx.annotation.NonNull
    public final android.widget.ImageView aliyunTransform;

    @androidx.annotation.NonNull
    public final com.aliyun.svideo.base.widget.VideoTrimFrameLayout aliyunVideoSurfaceLayout;

    @androidx.annotation.NonNull
    public final com.aliyun.svideo.base.widget.HorizontalListView aliyunVideoTailorImageList;

    @androidx.annotation.NonNull
    public final android.view.TextureView aliyunVideoTextureview;

    @androidx.annotation.NonNull
    private final android.widget.RelativeLayout rootView;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout trimRoot;

    private AlivcCropActivityVideoCropBinding(@androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull com.aliyun.svideo.base.widget.FanProgressBar fanProgressBar, @androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.ImageView imageView2, @androidx.annotation.NonNull com.aliyun.svideo.base.widget.VideoSliceSeekBar videoSliceSeekBar, @androidx.annotation.NonNull android.widget.ImageView imageView3, @androidx.annotation.NonNull com.aliyun.svideo.base.widget.VideoTrimFrameLayout videoTrimFrameLayout, @androidx.annotation.NonNull com.aliyun.svideo.base.widget.HorizontalListView horizontalListView, @androidx.annotation.NonNull android.view.TextureView textureView, @androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout2) {
        this.rootView = relativeLayout;
        this.aliyunBack = imageView;
        this.aliyunCropProgress = fanProgressBar;
        this.aliyunCropProgressBg = frameLayout;
        this.aliyunDurationTxt = textView;
        this.aliyunListLayout = linearLayout;
        this.aliyunNext = imageView2;
        this.aliyunSeekBar = videoSliceSeekBar;
        this.aliyunTransform = imageView3;
        this.aliyunVideoSurfaceLayout = videoTrimFrameLayout;
        this.aliyunVideoTailorImageList = horizontalListView;
        this.aliyunVideoTextureview = textureView;
        this.trimRoot = relativeLayout2;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.crop.databinding.AlivcCropActivityVideoCropBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = com.aliyun.svideo.crop.R.id.aliyun_back;
        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = com.aliyun.svideo.crop.R.id.aliyun_crop_progress;
            com.aliyun.svideo.base.widget.FanProgressBar fanProgressBar = (com.aliyun.svideo.base.widget.FanProgressBar) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (fanProgressBar != null) {
                i = com.aliyun.svideo.crop.R.id.aliyun_crop_progress_bg;
                android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (frameLayout != null) {
                    i = com.aliyun.svideo.crop.R.id.aliyun_duration_txt;
                    android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = com.aliyun.svideo.crop.R.id.aliyun_list_layout;
                        android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (linearLayout != null) {
                            i = com.aliyun.svideo.crop.R.id.aliyun_next;
                            android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (imageView2 != null) {
                                i = com.aliyun.svideo.crop.R.id.aliyun_seek_bar;
                                com.aliyun.svideo.base.widget.VideoSliceSeekBar videoSliceSeekBar = (com.aliyun.svideo.base.widget.VideoSliceSeekBar) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (videoSliceSeekBar != null) {
                                    i = com.aliyun.svideo.crop.R.id.aliyun_transform;
                                    android.widget.ImageView imageView3 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                    if (imageView3 != null) {
                                        i = com.aliyun.svideo.crop.R.id.aliyun_video_surfaceLayout;
                                        com.aliyun.svideo.base.widget.VideoTrimFrameLayout videoTrimFrameLayout = (com.aliyun.svideo.base.widget.VideoTrimFrameLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                        if (videoTrimFrameLayout != null) {
                                            i = com.aliyun.svideo.crop.R.id.aliyun_video_tailor_image_list;
                                            com.aliyun.svideo.base.widget.HorizontalListView horizontalListView = (com.aliyun.svideo.base.widget.HorizontalListView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                            if (horizontalListView != null) {
                                                i = com.aliyun.svideo.crop.R.id.aliyun_video_textureview;
                                                android.view.TextureView textureView = (android.view.TextureView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                if (textureView != null) {
                                                    android.widget.RelativeLayout relativeLayout = (android.widget.RelativeLayout) view;
                                                    return new com.aliyun.svideo.crop.databinding.AlivcCropActivityVideoCropBinding(relativeLayout, imageView, fanProgressBar, frameLayout, textView, linearLayout, imageView2, videoSliceSeekBar, imageView3, videoTrimFrameLayout, horizontalListView, textureView, relativeLayout);
                                                }
                                            }
                                        }
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
    public static com.aliyun.svideo.crop.databinding.AlivcCropActivityVideoCropBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.crop.databinding.AlivcCropActivityVideoCropBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.crop.R.layout.alivc_crop_activity_video_crop, viewGroup, false);
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
