package com.aliyun.svideo.editor.databinding;

/* loaded from: classes31.dex */
public final class AliyunSvideoActivityTemplateBuilderBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.aliyun.svideo.editor.databinding.AlivcEditorIncludeActionBarProfileBinding actionBar;

    @androidx.annotation.NonNull
    public final android.widget.ImageView aliyunTemplateBtnPlay;

    @androidx.annotation.NonNull
    public final android.widget.SeekBar aliyunTemplatePlaySeekbar;

    @androidx.annotation.NonNull
    public final android.widget.TextView aliyunTemplateTvDuration;

    @androidx.annotation.NonNull
    public final android.widget.TextView aliyunTemplateTvTime;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout layoutSurface;

    @androidx.annotation.NonNull
    public final androidx.recyclerview.widget.RecyclerView recyclerView;

    @androidx.annotation.NonNull
    private final android.widget.LinearLayout rootView;

    @androidx.annotation.NonNull
    public final android.view.SurfaceView surfaceView;

    private AliyunSvideoActivityTemplateBuilderBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull com.aliyun.svideo.editor.databinding.AlivcEditorIncludeActionBarProfileBinding alivcEditorIncludeActionBarProfileBinding, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.SeekBar seekBar, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView, @androidx.annotation.NonNull android.view.SurfaceView surfaceView) {
        this.rootView = linearLayout;
        this.actionBar = alivcEditorIncludeActionBarProfileBinding;
        this.aliyunTemplateBtnPlay = imageView;
        this.aliyunTemplatePlaySeekbar = seekBar;
        this.aliyunTemplateTvDuration = textView;
        this.aliyunTemplateTvTime = textView2;
        this.layoutSurface = frameLayout;
        this.recyclerView = recyclerView;
        this.surfaceView = surfaceView;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AliyunSvideoActivityTemplateBuilderBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = com.aliyun.svideo.editor.R.id.action_bar;
        android.view.View findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            com.aliyun.svideo.editor.databinding.AlivcEditorIncludeActionBarProfileBinding bind = com.aliyun.svideo.editor.databinding.AlivcEditorIncludeActionBarProfileBinding.bind(findChildViewById);
            i = com.aliyun.svideo.editor.R.id.aliyun_template_btn_play;
            android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = com.aliyun.svideo.editor.R.id.aliyun_template_play_seekbar;
                android.widget.SeekBar seekBar = (android.widget.SeekBar) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (seekBar != null) {
                    i = com.aliyun.svideo.editor.R.id.aliyun_template_tv_duration;
                    android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = com.aliyun.svideo.editor.R.id.aliyun_template_tv_time;
                        android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = com.aliyun.svideo.editor.R.id.layout_surface;
                            android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (frameLayout != null) {
                                i = com.aliyun.svideo.editor.R.id.recycler_view;
                                androidx.recyclerview.widget.RecyclerView recyclerView = (androidx.recyclerview.widget.RecyclerView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (recyclerView != null) {
                                    i = com.aliyun.svideo.editor.R.id.surface_view;
                                    android.view.SurfaceView surfaceView = (android.view.SurfaceView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                    if (surfaceView != null) {
                                        return new com.aliyun.svideo.editor.databinding.AliyunSvideoActivityTemplateBuilderBinding((android.widget.LinearLayout) view, bind, imageView, seekBar, textView, textView2, frameLayout, recyclerView, surfaceView);
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
    public static com.aliyun.svideo.editor.databinding.AliyunSvideoActivityTemplateBuilderBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AliyunSvideoActivityTemplateBuilderBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.editor.R.layout.aliyun_svideo_activity_template_builder, viewGroup, false);
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
