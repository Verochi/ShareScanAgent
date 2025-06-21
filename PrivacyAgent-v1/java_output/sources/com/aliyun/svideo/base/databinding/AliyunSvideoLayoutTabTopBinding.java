package com.aliyun.svideo.base.databinding;

/* loaded from: classes.dex */
public final class AliyunSvideoLayoutTabTopBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout aliyunEmptyLayout;

    @androidx.annotation.NonNull
    public final android.widget.TextView aliyunTvTitle;

    @androidx.annotation.NonNull
    private final android.widget.RelativeLayout rootView;

    private AliyunSvideoLayoutTabTopBinding(@androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout, @androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout2, @androidx.annotation.NonNull android.widget.TextView textView) {
        this.rootView = relativeLayout;
        this.aliyunEmptyLayout = relativeLayout2;
        this.aliyunTvTitle = textView;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.base.databinding.AliyunSvideoLayoutTabTopBinding bind(@androidx.annotation.NonNull android.view.View view) {
        android.widget.RelativeLayout relativeLayout = (android.widget.RelativeLayout) view;
        int i = com.aliyun.svideo.base.R.id.aliyun_tv_title;
        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            return new com.aliyun.svideo.base.databinding.AliyunSvideoLayoutTabTopBinding(relativeLayout, relativeLayout, textView);
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.base.databinding.AliyunSvideoLayoutTabTopBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.base.databinding.AliyunSvideoLayoutTabTopBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.base.R.layout.aliyun_svideo_layout_tab_top, viewGroup, false);
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
