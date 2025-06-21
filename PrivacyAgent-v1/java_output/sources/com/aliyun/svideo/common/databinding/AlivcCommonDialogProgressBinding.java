package com.aliyun.svideo.common.databinding;

/* loaded from: classes.dex */
public final class AlivcCommonDialogProgressBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.ProgressBar pbDialogProgress;

    @androidx.annotation.NonNull
    private final android.widget.FrameLayout rootView;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvDialogMessage;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvDialogProgress;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvDialogTitle;

    private AlivcCommonDialogProgressBinding(@androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull android.widget.ProgressBar progressBar, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull android.widget.TextView textView3) {
        this.rootView = frameLayout;
        this.pbDialogProgress = progressBar;
        this.tvDialogMessage = textView;
        this.tvDialogProgress = textView2;
        this.tvDialogTitle = textView3;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.common.databinding.AlivcCommonDialogProgressBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = com.aliyun.svideo.common.R.id.pb_dialog_progress;
        android.widget.ProgressBar progressBar = (android.widget.ProgressBar) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (progressBar != null) {
            i = com.aliyun.svideo.common.R.id.tv_dialog_message;
            android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = com.aliyun.svideo.common.R.id.tv_dialog_progress;
                android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = com.aliyun.svideo.common.R.id.tv_dialog_title;
                    android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        return new com.aliyun.svideo.common.databinding.AlivcCommonDialogProgressBinding((android.widget.FrameLayout) view, progressBar, textView, textView2, textView3);
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.common.databinding.AlivcCommonDialogProgressBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.common.databinding.AlivcCommonDialogProgressBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.common.R.layout.alivc_common_dialog_progress, viewGroup, false);
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
