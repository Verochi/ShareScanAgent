package com.aliyun.svideo.base.databinding;

/* loaded from: classes.dex */
public final class AlivcBeautyFaceViewBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.RadioButton beautyAdvanced0;

    @androidx.annotation.NonNull
    public final android.widget.RadioButton beautyAdvanced1;

    @androidx.annotation.NonNull
    public final android.widget.RadioButton beautyAdvanced2;

    @androidx.annotation.NonNull
    public final android.widget.RadioButton beautyAdvanced3;

    @androidx.annotation.NonNull
    public final android.widget.RadioButton beautyAdvanced4;

    @androidx.annotation.NonNull
    public final android.widget.RadioButton beautyAdvanced5;

    @androidx.annotation.NonNull
    public final android.widget.RadioGroup beautyAdvancedGroup;

    @androidx.annotation.NonNull
    public final android.view.View blankView;

    @androidx.annotation.NonNull
    private final android.widget.LinearLayout rootView;

    private AlivcBeautyFaceViewBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.RadioButton radioButton, @androidx.annotation.NonNull android.widget.RadioButton radioButton2, @androidx.annotation.NonNull android.widget.RadioButton radioButton3, @androidx.annotation.NonNull android.widget.RadioButton radioButton4, @androidx.annotation.NonNull android.widget.RadioButton radioButton5, @androidx.annotation.NonNull android.widget.RadioButton radioButton6, @androidx.annotation.NonNull android.widget.RadioGroup radioGroup, @androidx.annotation.NonNull android.view.View view) {
        this.rootView = linearLayout;
        this.beautyAdvanced0 = radioButton;
        this.beautyAdvanced1 = radioButton2;
        this.beautyAdvanced2 = radioButton3;
        this.beautyAdvanced3 = radioButton4;
        this.beautyAdvanced4 = radioButton5;
        this.beautyAdvanced5 = radioButton6;
        this.beautyAdvancedGroup = radioGroup;
        this.blankView = view;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.base.databinding.AlivcBeautyFaceViewBinding bind(@androidx.annotation.NonNull android.view.View view) {
        android.view.View findChildViewById;
        int i = com.aliyun.svideo.base.R.id.beauty_advanced_0;
        android.widget.RadioButton radioButton = (android.widget.RadioButton) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (radioButton != null) {
            i = com.aliyun.svideo.base.R.id.beauty_advanced_1;
            android.widget.RadioButton radioButton2 = (android.widget.RadioButton) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (radioButton2 != null) {
                i = com.aliyun.svideo.base.R.id.beauty_advanced_2;
                android.widget.RadioButton radioButton3 = (android.widget.RadioButton) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (radioButton3 != null) {
                    i = com.aliyun.svideo.base.R.id.beauty_advanced_3;
                    android.widget.RadioButton radioButton4 = (android.widget.RadioButton) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (radioButton4 != null) {
                        i = com.aliyun.svideo.base.R.id.beauty_advanced_4;
                        android.widget.RadioButton radioButton5 = (android.widget.RadioButton) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (radioButton5 != null) {
                            i = com.aliyun.svideo.base.R.id.beauty_advanced_5;
                            android.widget.RadioButton radioButton6 = (android.widget.RadioButton) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (radioButton6 != null) {
                                i = com.aliyun.svideo.base.R.id.beauty_advanced_group;
                                android.widget.RadioGroup radioGroup = (android.widget.RadioGroup) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (radioGroup != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = com.aliyun.svideo.base.R.id.blank_view))) != null) {
                                    return new com.aliyun.svideo.base.databinding.AlivcBeautyFaceViewBinding((android.widget.LinearLayout) view, radioButton, radioButton2, radioButton3, radioButton4, radioButton5, radioButton6, radioGroup, findChildViewById);
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
    public static com.aliyun.svideo.base.databinding.AlivcBeautyFaceViewBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.base.databinding.AlivcBeautyFaceViewBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.base.R.layout.alivc_beauty_face_view, viewGroup, false);
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
