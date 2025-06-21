package com.aliyun.svideo.editor.databinding;

/* loaded from: classes12.dex */
public final class AlivcEditorViewDownloadProgressBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.ProgressBar downloadProgressBg;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivDownloadFinish;

    @androidx.annotation.NonNull
    private final android.view.View rootView;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvDownloadState;

    private AlivcEditorViewDownloadProgressBinding(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.widget.ProgressBar progressBar, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.TextView textView) {
        this.rootView = view;
        this.downloadProgressBg = progressBar;
        this.ivDownloadFinish = imageView;
        this.tvDownloadState = textView;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorViewDownloadProgressBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = com.aliyun.svideo.editor.R.id.download_progress_bg;
        android.widget.ProgressBar progressBar = (android.widget.ProgressBar) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (progressBar != null) {
            i = com.aliyun.svideo.editor.R.id.iv_download_finish;
            android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = com.aliyun.svideo.editor.R.id.tv_download_state;
                android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    return new com.aliyun.svideo.editor.databinding.AlivcEditorViewDownloadProgressBinding(view, progressBar, imageView, textView);
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorViewDownloadProgressBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.NonNull android.view.ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new java.lang.NullPointerException("parent");
        }
        layoutInflater.inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_view_download_progress, viewGroup);
        return bind(viewGroup);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public android.view.View getRoot() {
        return this.rootView;
    }
}
