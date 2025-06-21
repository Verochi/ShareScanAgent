package com.aliyun.svideo.base.databinding;

/* loaded from: classes.dex */
public final class AliyunSvideoEffectParamsItemBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    private final android.widget.LinearLayout rootView;

    @androidx.annotation.NonNull
    public final com.aliyun.svideo.base.widget.beauty.seekbar.BeautySeekBar seekbarEffectParams;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvEffectParamsName;

    private AliyunSvideoEffectParamsItemBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull com.aliyun.svideo.base.widget.beauty.seekbar.BeautySeekBar beautySeekBar, @androidx.annotation.NonNull android.widget.TextView textView) {
        this.rootView = linearLayout;
        this.seekbarEffectParams = beautySeekBar;
        this.tvEffectParamsName = textView;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.base.databinding.AliyunSvideoEffectParamsItemBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = com.aliyun.svideo.base.R.id.seekbar_effect_params;
        com.aliyun.svideo.base.widget.beauty.seekbar.BeautySeekBar beautySeekBar = (com.aliyun.svideo.base.widget.beauty.seekbar.BeautySeekBar) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (beautySeekBar != null) {
            i = com.aliyun.svideo.base.R.id.tv_effect_params_name;
            android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                return new com.aliyun.svideo.base.databinding.AliyunSvideoEffectParamsItemBinding((android.widget.LinearLayout) view, beautySeekBar, textView);
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.base.databinding.AliyunSvideoEffectParamsItemBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.base.databinding.AliyunSvideoEffectParamsItemBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.base.R.layout.aliyun_svideo_effect_params_item, viewGroup, false);
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
