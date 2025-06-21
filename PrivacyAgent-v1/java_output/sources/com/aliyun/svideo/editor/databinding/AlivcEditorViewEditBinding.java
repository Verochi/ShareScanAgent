package com.aliyun.svideo.editor.databinding;

/* loaded from: classes31.dex */
public final class AlivcEditorViewEditBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.aliyun.svideo.editor.databinding.AlivcEditorIncludeActionBarProfileBinding actionBar;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout barLinear;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout copyResTip;

    @androidx.annotation.NonNull
    public final com.aliyun.svideo.editor.databinding.AlivcEditorIncludeEditBottomBinding editBottomTab;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout glsurfaceView;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout llPlayBar;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout pasterView;

    @androidx.annotation.NonNull
    public final android.widget.ImageView playButton;

    @androidx.annotation.NonNull
    public final android.widget.ProgressBar playProgress;

    @androidx.annotation.NonNull
    public final android.view.SurfaceView playView;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout root;

    @androidx.annotation.NonNull
    private final android.widget.RelativeLayout rootView;

    @androidx.annotation.NonNull
    public final com.aliyun.svideo.editor.editor.thumblinebar.OverlayThumbLineBar simplethumblinebar;

    @androidx.annotation.NonNull
    public final android.widget.ProgressBar transcodeProgress;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout transcodeTip;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvCurrDuration;

    private AlivcEditorViewEditBinding(@androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout, @androidx.annotation.NonNull com.aliyun.svideo.editor.databinding.AlivcEditorIncludeActionBarProfileBinding alivcEditorIncludeActionBarProfileBinding, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull com.aliyun.svideo.editor.databinding.AlivcEditorIncludeEditBottomBinding alivcEditorIncludeEditBottomBinding, @androidx.annotation.NonNull android.widget.FrameLayout frameLayout2, @androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout2, @androidx.annotation.NonNull android.widget.FrameLayout frameLayout3, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.ProgressBar progressBar, @androidx.annotation.NonNull android.view.SurfaceView surfaceView, @androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout3, @androidx.annotation.NonNull com.aliyun.svideo.editor.editor.thumblinebar.OverlayThumbLineBar overlayThumbLineBar, @androidx.annotation.NonNull android.widget.ProgressBar progressBar2, @androidx.annotation.NonNull android.widget.FrameLayout frameLayout4, @androidx.annotation.NonNull android.widget.TextView textView) {
        this.rootView = relativeLayout;
        this.actionBar = alivcEditorIncludeActionBarProfileBinding;
        this.barLinear = linearLayout;
        this.copyResTip = frameLayout;
        this.editBottomTab = alivcEditorIncludeEditBottomBinding;
        this.glsurfaceView = frameLayout2;
        this.llPlayBar = relativeLayout2;
        this.pasterView = frameLayout3;
        this.playButton = imageView;
        this.playProgress = progressBar;
        this.playView = surfaceView;
        this.root = relativeLayout3;
        this.simplethumblinebar = overlayThumbLineBar;
        this.transcodeProgress = progressBar2;
        this.transcodeTip = frameLayout4;
        this.tvCurrDuration = textView;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorViewEditBinding bind(@androidx.annotation.NonNull android.view.View view) {
        android.view.View findChildViewById;
        int i = com.aliyun.svideo.editor.R.id.action_bar;
        android.view.View findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById2 != null) {
            com.aliyun.svideo.editor.databinding.AlivcEditorIncludeActionBarProfileBinding bind = com.aliyun.svideo.editor.databinding.AlivcEditorIncludeActionBarProfileBinding.bind(findChildViewById2);
            i = com.aliyun.svideo.editor.R.id.bar_linear;
            android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = com.aliyun.svideo.editor.R.id.copy_res_tip;
                android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (frameLayout != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = com.aliyun.svideo.editor.R.id.edit_bottom_tab))) != null) {
                    com.aliyun.svideo.editor.databinding.AlivcEditorIncludeEditBottomBinding bind2 = com.aliyun.svideo.editor.databinding.AlivcEditorIncludeEditBottomBinding.bind(findChildViewById);
                    i = com.aliyun.svideo.editor.R.id.glsurface_view;
                    android.widget.FrameLayout frameLayout2 = (android.widget.FrameLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (frameLayout2 != null) {
                        i = com.aliyun.svideo.editor.R.id.ll_play_bar;
                        android.widget.RelativeLayout relativeLayout = (android.widget.RelativeLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (relativeLayout != null) {
                            i = com.aliyun.svideo.editor.R.id.pasterView;
                            android.widget.FrameLayout frameLayout3 = (android.widget.FrameLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (frameLayout3 != null) {
                                i = com.aliyun.svideo.editor.R.id.play_button;
                                android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (imageView != null) {
                                    i = com.aliyun.svideo.editor.R.id.play_progress;
                                    android.widget.ProgressBar progressBar = (android.widget.ProgressBar) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                    if (progressBar != null) {
                                        i = com.aliyun.svideo.editor.R.id.play_view;
                                        android.view.SurfaceView surfaceView = (android.view.SurfaceView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                        if (surfaceView != null) {
                                            android.widget.RelativeLayout relativeLayout2 = (android.widget.RelativeLayout) view;
                                            i = com.aliyun.svideo.editor.R.id.simplethumblinebar;
                                            com.aliyun.svideo.editor.editor.thumblinebar.OverlayThumbLineBar overlayThumbLineBar = (com.aliyun.svideo.editor.editor.thumblinebar.OverlayThumbLineBar) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                            if (overlayThumbLineBar != null) {
                                                i = com.aliyun.svideo.editor.R.id.transcode_progress;
                                                android.widget.ProgressBar progressBar2 = (android.widget.ProgressBar) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                if (progressBar2 != null) {
                                                    i = com.aliyun.svideo.editor.R.id.transcode_tip;
                                                    android.widget.FrameLayout frameLayout4 = (android.widget.FrameLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                    if (frameLayout4 != null) {
                                                        i = com.aliyun.svideo.editor.R.id.tv_curr_duration;
                                                        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                        if (textView != null) {
                                                            return new com.aliyun.svideo.editor.databinding.AlivcEditorViewEditBinding(relativeLayout2, bind, linearLayout, frameLayout, bind2, frameLayout2, relativeLayout, frameLayout3, imageView, progressBar, surfaceView, relativeLayout2, overlayThumbLineBar, progressBar2, frameLayout4, textView);
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
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorViewEditBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorViewEditBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_view_edit, viewGroup, false);
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
