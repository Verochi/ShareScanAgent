package com.chad.library.databinding;

/* loaded from: classes31.dex */
public final class BrvahQuickViewLoadMoreBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout loadMoreLoadCompleteView;

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
    public final android.widget.FrameLayout n;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvPrompt;

    public BrvahQuickViewLoadMoreBinding(@androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull android.widget.FrameLayout frameLayout2, @androidx.annotation.NonNull android.widget.FrameLayout frameLayout3, @androidx.annotation.NonNull android.widget.FrameLayout frameLayout4, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.ProgressBar progressBar, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.TextView textView2) {
        this.n = frameLayout;
        this.loadMoreLoadCompleteView = frameLayout2;
        this.loadMoreLoadEndView = frameLayout3;
        this.loadMoreLoadFailView = frameLayout4;
        this.loadMoreLoadingView = linearLayout;
        this.loadingProgress = progressBar;
        this.loadingText = textView;
        this.tvPrompt = textView2;
    }

    @androidx.annotation.NonNull
    public static com.chad.library.databinding.BrvahQuickViewLoadMoreBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = com.chad.library.R.id.load_more_load_complete_view;
        android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (frameLayout != null) {
            i = com.chad.library.R.id.load_more_load_end_view;
            android.widget.FrameLayout frameLayout2 = (android.widget.FrameLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (frameLayout2 != null) {
                i = com.chad.library.R.id.load_more_load_fail_view;
                android.widget.FrameLayout frameLayout3 = (android.widget.FrameLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (frameLayout3 != null) {
                    i = com.chad.library.R.id.load_more_loading_view;
                    android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (linearLayout != null) {
                        i = com.chad.library.R.id.loading_progress;
                        android.widget.ProgressBar progressBar = (android.widget.ProgressBar) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (progressBar != null) {
                            i = com.chad.library.R.id.loading_text;
                            android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                i = com.chad.library.R.id.tv_prompt;
                                android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (textView2 != null) {
                                    return new com.chad.library.databinding.BrvahQuickViewLoadMoreBinding((android.widget.FrameLayout) view, frameLayout, frameLayout2, frameLayout3, linearLayout, progressBar, textView, textView2);
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
    public static com.chad.library.databinding.BrvahQuickViewLoadMoreBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.chad.library.databinding.BrvahQuickViewLoadMoreBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.chad.library.R.layout.brvah_quick_view_load_more, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public android.widget.FrameLayout getRoot() {
        return this.n;
    }
}
