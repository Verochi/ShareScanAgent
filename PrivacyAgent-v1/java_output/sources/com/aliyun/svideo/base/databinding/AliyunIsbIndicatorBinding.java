package com.aliyun.svideo.base.databinding;

/* loaded from: classes.dex */
public final class AliyunIsbIndicatorBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.aliyun.svideo.base.widget.beauty.seekbar.ArrowView indicatorArrow;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout indicatorContainer;

    @androidx.annotation.NonNull
    public final android.widget.TextView isbProgress;

    @androidx.annotation.NonNull
    private final android.widget.LinearLayout rootView;

    private AliyunIsbIndicatorBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull com.aliyun.svideo.base.widget.beauty.seekbar.ArrowView arrowView, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout2, @androidx.annotation.NonNull android.widget.TextView textView) {
        this.rootView = linearLayout;
        this.indicatorArrow = arrowView;
        this.indicatorContainer = linearLayout2;
        this.isbProgress = textView;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.base.databinding.AliyunIsbIndicatorBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = com.aliyun.svideo.base.R.id.indicator_arrow;
        com.aliyun.svideo.base.widget.beauty.seekbar.ArrowView arrowView = (com.aliyun.svideo.base.widget.beauty.seekbar.ArrowView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (arrowView != null) {
            i = com.aliyun.svideo.base.R.id.indicator_container;
            android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = com.aliyun.svideo.base.R.id.isb_progress;
                android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    return new com.aliyun.svideo.base.databinding.AliyunIsbIndicatorBinding((android.widget.LinearLayout) view, arrowView, linearLayout, textView);
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.base.databinding.AliyunIsbIndicatorBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.base.databinding.AliyunIsbIndicatorBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.base.R.layout.aliyun_isb_indicator, viewGroup, false);
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
