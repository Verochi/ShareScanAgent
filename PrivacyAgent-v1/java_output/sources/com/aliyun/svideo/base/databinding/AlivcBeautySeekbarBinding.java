package com.aliyun.svideo.base.databinding;

/* loaded from: classes.dex */
public final class AlivcBeautySeekbarBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.SeekBar backSeekbar;

    @androidx.annotation.NonNull
    public final com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar frontSeekbar;

    @androidx.annotation.NonNull
    private final android.widget.FrameLayout rootView;

    private AlivcBeautySeekbarBinding(@androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull android.widget.SeekBar seekBar, @androidx.annotation.NonNull com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar indicatorSeekBar) {
        this.rootView = frameLayout;
        this.backSeekbar = seekBar;
        this.frontSeekbar = indicatorSeekBar;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.base.databinding.AlivcBeautySeekbarBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = com.aliyun.svideo.base.R.id.back_seekbar;
        android.widget.SeekBar seekBar = (android.widget.SeekBar) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (seekBar != null) {
            i = com.aliyun.svideo.base.R.id.front_seekbar;
            com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar indicatorSeekBar = (com.aliyun.svideo.base.widget.beauty.seekbar.IndicatorSeekBar) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (indicatorSeekBar != null) {
                return new com.aliyun.svideo.base.databinding.AlivcBeautySeekbarBinding((android.widget.FrameLayout) view, seekBar, indicatorSeekBar);
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.base.databinding.AlivcBeautySeekbarBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.base.databinding.AlivcBeautySeekbarBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.base.R.layout.alivc_beauty_seekbar, viewGroup, false);
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
