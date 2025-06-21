package com.aliyun.svideo.common.databinding;

/* loaded from: classes.dex */
public final class AlivcQuickViewLoadMoreBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout loadMoreLoadEndView;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout loadMoreLoadFailView;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout loadMoreLoadingView;

    @androidx.annotation.NonNull
    public final android.widget.ProgressBar loadingProgress;

    @androidx.annotation.NonNull
    public final android.widget.TextView loadingText;

    @androidx.annotation.NonNull
    private final android.widget.FrameLayout rootView;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvPrompt;

    private AlivcQuickViewLoadMoreBinding(@androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull android.widget.FrameLayout frameLayout2, @androidx.annotation.NonNull android.widget.FrameLayout frameLayout3, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.ProgressBar progressBar, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.TextView textView2) {
        this.rootView = frameLayout;
        this.loadMoreLoadEndView = frameLayout2;
        this.loadMoreLoadFailView = frameLayout3;
        this.loadMoreLoadingView = linearLayout;
        this.loadingProgress = progressBar;
        this.loadingText = textView;
        this.tvPrompt = textView2;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.common.databinding.AlivcQuickViewLoadMoreBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = com.aliyun.svideo.common.R.id.load_more_load_end_view;
        android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (frameLayout != null) {
            i = com.aliyun.svideo.common.R.id.load_more_load_fail_view;
            android.widget.FrameLayout frameLayout2 = (android.widget.FrameLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (frameLayout2 != null) {
                i = com.aliyun.svideo.common.R.id.load_more_loading_view;
                android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (linearLayout != null) {
                    i = com.aliyun.svideo.common.R.id.loading_progress;
                    android.widget.ProgressBar progressBar = (android.widget.ProgressBar) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (progressBar != null) {
                        i = com.aliyun.svideo.common.R.id.loading_text;
                        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            i = com.aliyun.svideo.common.R.id.tv_prompt;
                            android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                return new com.aliyun.svideo.common.databinding.AlivcQuickViewLoadMoreBinding((android.widget.FrameLayout) view, frameLayout, frameLayout2, linearLayout, progressBar, textView, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.common.databinding.AlivcQuickViewLoadMoreBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.common.databinding.AlivcQuickViewLoadMoreBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.common.R.layout.alivc_quick_view_load_more, viewGroup, false);
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
