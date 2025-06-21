package com.aliyun.svideo.base.databinding;

/* loaded from: classes.dex */
public final class AliyunSvideoProgressDialogBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout aliyunBody;

    @androidx.annotation.NonNull
    public final android.widget.TextView message;

    @androidx.annotation.NonNull
    public final android.widget.ProgressBar progress;

    @androidx.annotation.NonNull
    private final android.widget.FrameLayout rootView;

    private AliyunSvideoProgressDialogBinding(@androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.ProgressBar progressBar) {
        this.rootView = frameLayout;
        this.aliyunBody = linearLayout;
        this.message = textView;
        this.progress = progressBar;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.base.databinding.AliyunSvideoProgressDialogBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = com.aliyun.svideo.base.R.id.aliyun_body;
        android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = android.R.id.message;
            android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, android.R.id.message);
            if (textView != null) {
                i = android.R.id.progress;
                android.widget.ProgressBar progressBar = (android.widget.ProgressBar) androidx.viewbinding.ViewBindings.findChildViewById(view, android.R.id.progress);
                if (progressBar != null) {
                    return new com.aliyun.svideo.base.databinding.AliyunSvideoProgressDialogBinding((android.widget.FrameLayout) view, linearLayout, textView, progressBar);
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.base.databinding.AliyunSvideoProgressDialogBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.base.databinding.AliyunSvideoProgressDialogBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.base.R.layout.aliyun_svideo_progress_dialog, viewGroup, false);
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
