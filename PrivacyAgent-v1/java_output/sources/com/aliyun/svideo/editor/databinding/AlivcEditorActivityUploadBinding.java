package com.aliyun.svideo.editor.databinding;

/* loaded from: classes31.dex */
public final class AlivcEditorActivityUploadBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.aliyun.svideo.editor.databinding.AlivcEditorIncludeActionBarProfileBinding actionBar;

    @androidx.annotation.NonNull
    public final android.widget.TextView progressText;

    @androidx.annotation.NonNull
    private final android.widget.LinearLayout rootView;

    @androidx.annotation.NonNull
    public final android.view.TextureView texture;

    @androidx.annotation.NonNull
    public final android.widget.ProgressBar uploadProgress;

    @androidx.annotation.NonNull
    public final android.widget.TextView videoDesc;

    private AlivcEditorActivityUploadBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull com.aliyun.svideo.editor.databinding.AlivcEditorIncludeActionBarProfileBinding alivcEditorIncludeActionBarProfileBinding, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.view.TextureView textureView, @androidx.annotation.NonNull android.widget.ProgressBar progressBar, @androidx.annotation.NonNull android.widget.TextView textView2) {
        this.rootView = linearLayout;
        this.actionBar = alivcEditorIncludeActionBarProfileBinding;
        this.progressText = textView;
        this.texture = textureView;
        this.uploadProgress = progressBar;
        this.videoDesc = textView2;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorActivityUploadBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = com.aliyun.svideo.editor.R.id.action_bar;
        android.view.View findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            com.aliyun.svideo.editor.databinding.AlivcEditorIncludeActionBarProfileBinding bind = com.aliyun.svideo.editor.databinding.AlivcEditorIncludeActionBarProfileBinding.bind(findChildViewById);
            i = com.aliyun.svideo.editor.R.id.progress_text;
            android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = com.aliyun.svideo.editor.R.id.texture;
                android.view.TextureView textureView = (android.view.TextureView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (textureView != null) {
                    i = com.aliyun.svideo.editor.R.id.upload_progress;
                    android.widget.ProgressBar progressBar = (android.widget.ProgressBar) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (progressBar != null) {
                        i = com.aliyun.svideo.editor.R.id.video_desc;
                        android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            return new com.aliyun.svideo.editor.databinding.AlivcEditorActivityUploadBinding((android.widget.LinearLayout) view, bind, textView, textureView, progressBar, textView2);
                        }
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorActivityUploadBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorActivityUploadBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_activity_upload, viewGroup, false);
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
