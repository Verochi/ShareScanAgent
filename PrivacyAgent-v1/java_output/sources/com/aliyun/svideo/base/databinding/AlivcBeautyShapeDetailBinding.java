package com.aliyun.svideo.base.databinding;

/* loaded from: classes.dex */
public final class AlivcBeautyShapeDetailBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout alivcBeautyFace;

    @androidx.annotation.NonNull
    public final android.widget.RadioButton beautyBigEye;

    @androidx.annotation.NonNull
    public final android.widget.RadioButton beautyCutCheek;

    @androidx.annotation.NonNull
    public final android.widget.RadioButton beautyCutFace;

    @androidx.annotation.NonNull
    public final android.widget.RadioGroup beautyDetailShapeGroup;

    @androidx.annotation.NonNull
    public final android.widget.RadioButton beautyLongFace;

    @androidx.annotation.NonNull
    public final android.widget.RadioButton beautyLowerJaw;

    @androidx.annotation.NonNull
    public final android.widget.RadioButton beautyMouthWidth;

    @androidx.annotation.NonNull
    public final com.aliyun.svideo.base.widget.beauty.seekbar.BeautySeekBar beautySeekbar;

    @androidx.annotation.NonNull
    public final android.widget.RadioButton beautyThinFace;

    @androidx.annotation.NonNull
    public final android.widget.RadioButton beautyThinMandible;

    @androidx.annotation.NonNull
    public final android.widget.RadioButton beautyThinNose;

    @androidx.annotation.NonNull
    public final android.view.View blankView;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivReset;

    @androidx.annotation.NonNull
    private final android.widget.LinearLayout rootView;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvBack;

    private AlivcBeautyShapeDetailBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout2, @androidx.annotation.NonNull android.widget.RadioButton radioButton, @androidx.annotation.NonNull android.widget.RadioButton radioButton2, @androidx.annotation.NonNull android.widget.RadioButton radioButton3, @androidx.annotation.NonNull android.widget.RadioGroup radioGroup, @androidx.annotation.NonNull android.widget.RadioButton radioButton4, @androidx.annotation.NonNull android.widget.RadioButton radioButton5, @androidx.annotation.NonNull android.widget.RadioButton radioButton6, @androidx.annotation.NonNull com.aliyun.svideo.base.widget.beauty.seekbar.BeautySeekBar beautySeekBar, @androidx.annotation.NonNull android.widget.RadioButton radioButton7, @androidx.annotation.NonNull android.widget.RadioButton radioButton8, @androidx.annotation.NonNull android.widget.RadioButton radioButton9, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.TextView textView) {
        this.rootView = linearLayout;
        this.alivcBeautyFace = linearLayout2;
        this.beautyBigEye = radioButton;
        this.beautyCutCheek = radioButton2;
        this.beautyCutFace = radioButton3;
        this.beautyDetailShapeGroup = radioGroup;
        this.beautyLongFace = radioButton4;
        this.beautyLowerJaw = radioButton5;
        this.beautyMouthWidth = radioButton6;
        this.beautySeekbar = beautySeekBar;
        this.beautyThinFace = radioButton7;
        this.beautyThinMandible = radioButton8;
        this.beautyThinNose = radioButton9;
        this.blankView = view;
        this.ivReset = imageView;
        this.tvBack = textView;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.base.databinding.AlivcBeautyShapeDetailBinding bind(@androidx.annotation.NonNull android.view.View view) {
        android.view.View findChildViewById;
        int i = com.aliyun.svideo.base.R.id.alivc_beauty_face;
        android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = com.aliyun.svideo.base.R.id.beauty_big_eye;
            android.widget.RadioButton radioButton = (android.widget.RadioButton) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (radioButton != null) {
                i = com.aliyun.svideo.base.R.id.beauty_cut_cheek;
                android.widget.RadioButton radioButton2 = (android.widget.RadioButton) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (radioButton2 != null) {
                    i = com.aliyun.svideo.base.R.id.beauty_cut_face;
                    android.widget.RadioButton radioButton3 = (android.widget.RadioButton) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (radioButton3 != null) {
                        i = com.aliyun.svideo.base.R.id.beauty_detail_shape_group;
                        android.widget.RadioGroup radioGroup = (android.widget.RadioGroup) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (radioGroup != null) {
                            i = com.aliyun.svideo.base.R.id.beauty_long_face;
                            android.widget.RadioButton radioButton4 = (android.widget.RadioButton) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (radioButton4 != null) {
                                i = com.aliyun.svideo.base.R.id.beauty_lower_jaw;
                                android.widget.RadioButton radioButton5 = (android.widget.RadioButton) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (radioButton5 != null) {
                                    i = com.aliyun.svideo.base.R.id.beauty_mouth_width;
                                    android.widget.RadioButton radioButton6 = (android.widget.RadioButton) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                    if (radioButton6 != null) {
                                        i = com.aliyun.svideo.base.R.id.beauty_seekbar;
                                        com.aliyun.svideo.base.widget.beauty.seekbar.BeautySeekBar beautySeekBar = (com.aliyun.svideo.base.widget.beauty.seekbar.BeautySeekBar) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                        if (beautySeekBar != null) {
                                            i = com.aliyun.svideo.base.R.id.beauty_thin_face;
                                            android.widget.RadioButton radioButton7 = (android.widget.RadioButton) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                            if (radioButton7 != null) {
                                                i = com.aliyun.svideo.base.R.id.beauty_thin_mandible;
                                                android.widget.RadioButton radioButton8 = (android.widget.RadioButton) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                if (radioButton8 != null) {
                                                    i = com.aliyun.svideo.base.R.id.beauty_thin_nose;
                                                    android.widget.RadioButton radioButton9 = (android.widget.RadioButton) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                    if (radioButton9 != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = com.aliyun.svideo.base.R.id.blank_view))) != null) {
                                                        i = com.aliyun.svideo.base.R.id.iv_reset;
                                                        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                        if (imageView != null) {
                                                            i = com.aliyun.svideo.base.R.id.tv_back;
                                                            android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                            if (textView != null) {
                                                                return new com.aliyun.svideo.base.databinding.AlivcBeautyShapeDetailBinding((android.widget.LinearLayout) view, linearLayout, radioButton, radioButton2, radioButton3, radioGroup, radioButton4, radioButton5, radioButton6, beautySeekBar, radioButton7, radioButton8, radioButton9, findChildViewById, imageView, textView);
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
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.base.databinding.AlivcBeautyShapeDetailBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.base.databinding.AlivcBeautyShapeDetailBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.base.R.layout.alivc_beauty_shape_detail, viewGroup, false);
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
