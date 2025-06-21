package com.aliyun.svideo.base.databinding;

/* loaded from: classes.dex */
public final class AliyunVideoAlertDialogProgressBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.TextView aliyunProgressNumber;

    @androidx.annotation.NonNull
    public final android.widget.TextView aliyunProgressPercent;

    @androidx.annotation.NonNull
    public final android.widget.ProgressBar progress;

    @androidx.annotation.NonNull
    private final android.widget.RelativeLayout rootView;

    private AliyunVideoAlertDialogProgressBinding(@androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull android.widget.ProgressBar progressBar) {
        this.rootView = relativeLayout;
        this.aliyunProgressNumber = textView;
        this.aliyunProgressPercent = textView2;
        this.progress = progressBar;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.base.databinding.AliyunVideoAlertDialogProgressBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = com.aliyun.svideo.base.R.id.aliyun_progress_number;
        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = com.aliyun.svideo.base.R.id.aliyun_progress_percent;
            android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = android.R.id.progress;
                android.widget.ProgressBar progressBar = (android.widget.ProgressBar) androidx.viewbinding.ViewBindings.findChildViewById(view, android.R.id.progress);
                if (progressBar != null) {
                    return new com.aliyun.svideo.base.databinding.AliyunVideoAlertDialogProgressBinding((android.widget.RelativeLayout) view, textView, textView2, progressBar);
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.base.databinding.AliyunVideoAlertDialogProgressBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.base.databinding.AliyunVideoAlertDialogProgressBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.base.R.layout.aliyun_video_alert_dialog_progress, viewGroup, false);
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
