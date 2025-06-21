package com.aliyun.svideo.base.databinding;

/* loaded from: classes.dex */
public final class AlivcBeautyDetailBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.TextView alivcBaseBeautyBlushTextview;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout alivcBeautyFace;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout alivcBeautySkin;

    @androidx.annotation.NonNull
    public final android.widget.RadioButton beautyBigeye;

    @androidx.annotation.NonNull
    public final android.widget.RadioButton beautyBuffing;

    @androidx.annotation.NonNull
    public final android.widget.RadioGroup beautyDetailGroup;

    @androidx.annotation.NonNull
    public final android.widget.RadioButton beautyRuddy;

    @androidx.annotation.NonNull
    public final com.aliyun.svideo.base.widget.beauty.seekbar.BeautySeekBar beautySeekbar;

    @androidx.annotation.NonNull
    public final android.widget.RadioGroup beautySkinDetailGroup;

    @androidx.annotation.NonNull
    public final android.widget.RadioButton beautyThinFace;

    @androidx.annotation.NonNull
    public final android.widget.RadioButton beautyWhitening;

    @androidx.annotation.NonNull
    public final android.view.View blankView;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivReset;

    @androidx.annotation.NonNull
    private final android.widget.LinearLayout rootView;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvBack;

    private AlivcBeautyDetailBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout2, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout3, @androidx.annotation.NonNull android.widget.RadioButton radioButton, @androidx.annotation.NonNull android.widget.RadioButton radioButton2, @androidx.annotation.NonNull android.widget.RadioGroup radioGroup, @androidx.annotation.NonNull android.widget.RadioButton radioButton3, @androidx.annotation.NonNull com.aliyun.svideo.base.widget.beauty.seekbar.BeautySeekBar beautySeekBar, @androidx.annotation.NonNull android.widget.RadioGroup radioGroup2, @androidx.annotation.NonNull android.widget.RadioButton radioButton4, @androidx.annotation.NonNull android.widget.RadioButton radioButton5, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.TextView textView2) {
        this.rootView = linearLayout;
        this.alivcBaseBeautyBlushTextview = textView;
        this.alivcBeautyFace = linearLayout2;
        this.alivcBeautySkin = linearLayout3;
        this.beautyBigeye = radioButton;
        this.beautyBuffing = radioButton2;
        this.beautyDetailGroup = radioGroup;
        this.beautyRuddy = radioButton3;
        this.beautySeekbar = beautySeekBar;
        this.beautySkinDetailGroup = radioGroup2;
        this.beautyThinFace = radioButton4;
        this.beautyWhitening = radioButton5;
        this.blankView = view;
        this.ivReset = imageView;
        this.tvBack = textView2;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.base.databinding.AlivcBeautyDetailBinding bind(@androidx.annotation.NonNull android.view.View view) {
        android.view.View findChildViewById;
        int i = com.aliyun.svideo.base.R.id.alivc_base_beauty_blush_textview;
        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = com.aliyun.svideo.base.R.id.alivc_beauty_face;
            android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = com.aliyun.svideo.base.R.id.alivc_beauty_skin;
                android.widget.LinearLayout linearLayout2 = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (linearLayout2 != null) {
                    i = com.aliyun.svideo.base.R.id.beauty_bigeye;
                    android.widget.RadioButton radioButton = (android.widget.RadioButton) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (radioButton != null) {
                        i = com.aliyun.svideo.base.R.id.beauty_buffing;
                        android.widget.RadioButton radioButton2 = (android.widget.RadioButton) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (radioButton2 != null) {
                            i = com.aliyun.svideo.base.R.id.beauty_detail_group;
                            android.widget.RadioGroup radioGroup = (android.widget.RadioGroup) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (radioGroup != null) {
                                i = com.aliyun.svideo.base.R.id.beauty_ruddy;
                                android.widget.RadioButton radioButton3 = (android.widget.RadioButton) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (radioButton3 != null) {
                                    i = com.aliyun.svideo.base.R.id.beauty_seekbar;
                                    com.aliyun.svideo.base.widget.beauty.seekbar.BeautySeekBar beautySeekBar = (com.aliyun.svideo.base.widget.beauty.seekbar.BeautySeekBar) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                    if (beautySeekBar != null) {
                                        i = com.aliyun.svideo.base.R.id.beauty_skin_detail_group;
                                        android.widget.RadioGroup radioGroup2 = (android.widget.RadioGroup) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                        if (radioGroup2 != null) {
                                            i = com.aliyun.svideo.base.R.id.beauty_thin_face;
                                            android.widget.RadioButton radioButton4 = (android.widget.RadioButton) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                            if (radioButton4 != null) {
                                                i = com.aliyun.svideo.base.R.id.beauty_whitening;
                                                android.widget.RadioButton radioButton5 = (android.widget.RadioButton) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                if (radioButton5 != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = com.aliyun.svideo.base.R.id.blank_view))) != null) {
                                                    i = com.aliyun.svideo.base.R.id.iv_reset;
                                                    android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                    if (imageView != null) {
                                                        i = com.aliyun.svideo.base.R.id.tv_back;
                                                        android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                        if (textView2 != null) {
                                                            return new com.aliyun.svideo.base.databinding.AlivcBeautyDetailBinding((android.widget.LinearLayout) view, textView, linearLayout, linearLayout2, radioButton, radioButton2, radioGroup, radioButton3, beautySeekBar, radioGroup2, radioButton4, radioButton5, findChildViewById, imageView, textView2);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
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
    public static com.aliyun.svideo.base.databinding.AlivcBeautyDetailBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.base.databinding.AlivcBeautyDetailBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.base.R.layout.alivc_beauty_detail, viewGroup, false);
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
