package com.aliyun.svideo.media.databinding;

/* loaded from: classes12.dex */
public final class AlivcMediaActivityMediaImportBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.Button btnNextStep;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout galleryActionBar;

    @androidx.annotation.NonNull
    public final android.widget.ImageButton galleryCloseBtn;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout galleryContainer;

    @androidx.annotation.NonNull
    public final android.widget.ImageView galleryDrawer;

    @androidx.annotation.NonNull
    public final androidx.recyclerview.widget.RecyclerView galleryMedia;

    @androidx.annotation.NonNull
    public final android.widget.TextView galleryTitle;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout rlSelect;

    @androidx.annotation.NonNull
    private final android.widget.LinearLayout rootView;

    @androidx.annotation.NonNull
    public final androidx.recyclerview.widget.RecyclerView rvSelectedVideo;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout topPanel;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvDurationTitle;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvDurationValue;

    private AlivcMediaActivityMediaImportBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.Button button, @androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull android.widget.ImageButton imageButton, @androidx.annotation.NonNull android.widget.FrameLayout frameLayout2, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView2, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout2, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull android.widget.TextView textView3) {
        this.rootView = linearLayout;
        this.btnNextStep = button;
        this.galleryActionBar = frameLayout;
        this.galleryCloseBtn = imageButton;
        this.galleryContainer = frameLayout2;
        this.galleryDrawer = imageView;
        this.galleryMedia = recyclerView;
        this.galleryTitle = textView;
        this.rlSelect = relativeLayout;
        this.rvSelectedVideo = recyclerView2;
        this.topPanel = linearLayout2;
        this.tvDurationTitle = textView2;
        this.tvDurationValue = textView3;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.media.databinding.AlivcMediaActivityMediaImportBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = com.aliyun.svideo.media.R.id.btn_next_step;
        android.widget.Button button = (android.widget.Button) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = com.aliyun.svideo.media.R.id.gallery_actionBar;
            android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (frameLayout != null) {
                i = com.aliyun.svideo.media.R.id.gallery_closeBtn;
                android.widget.ImageButton imageButton = (android.widget.ImageButton) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (imageButton != null) {
                    i = com.aliyun.svideo.media.R.id.gallery_container;
                    android.widget.FrameLayout frameLayout2 = (android.widget.FrameLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (frameLayout2 != null) {
                        i = com.aliyun.svideo.media.R.id.gallery_drawer;
                        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (imageView != null) {
                            i = com.aliyun.svideo.media.R.id.gallery_media;
                            androidx.recyclerview.widget.RecyclerView recyclerView = (androidx.recyclerview.widget.RecyclerView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (recyclerView != null) {
                                i = com.aliyun.svideo.media.R.id.gallery_title;
                                android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (textView != null) {
                                    i = com.aliyun.svideo.media.R.id.rl_select;
                                    android.widget.RelativeLayout relativeLayout = (android.widget.RelativeLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                    if (relativeLayout != null) {
                                        i = com.aliyun.svideo.media.R.id.rv_selected_video;
                                        androidx.recyclerview.widget.RecyclerView recyclerView2 = (androidx.recyclerview.widget.RecyclerView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                        if (recyclerView2 != null) {
                                            i = com.aliyun.svideo.media.R.id.topPanel;
                                            android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                            if (linearLayout != null) {
                                                i = com.aliyun.svideo.media.R.id.tv_duration_title;
                                                android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                if (textView2 != null) {
                                                    i = com.aliyun.svideo.media.R.id.tv_duration_value;
                                                    android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                    if (textView3 != null) {
                                                        return new com.aliyun.svideo.media.databinding.AlivcMediaActivityMediaImportBinding((android.widget.LinearLayout) view, button, frameLayout, imageButton, frameLayout2, imageView, recyclerView, textView, relativeLayout, recyclerView2, linearLayout, textView2, textView3);
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
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.media.databinding.AlivcMediaActivityMediaImportBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.media.databinding.AlivcMediaActivityMediaImportBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.media.R.layout.alivc_media_activity_media_import, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public android.widget.LinearLayout getRoot() {
        return this.rootView;
    }
}
