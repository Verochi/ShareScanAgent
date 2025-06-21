package com.aliyun.svideo.editor.databinding;

/* loaded from: classes12.dex */
public final class AlivcEditorItemEffcetSoundBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout effectSoundImage;

    @androidx.annotation.NonNull
    public final com.aliyun.svideo.base.widget.CircularImageView effectSoundImageView;

    @androidx.annotation.NonNull
    public final android.widget.TextView effectSoundName;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivEffectSelectState;

    @androidx.annotation.NonNull
    private final android.widget.LinearLayout rootView;

    private AlivcEditorItemEffcetSoundBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull com.aliyun.svideo.base.widget.CircularImageView circularImageView, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.ImageView imageView) {
        this.rootView = linearLayout;
        this.effectSoundImage = frameLayout;
        this.effectSoundImageView = circularImageView;
        this.effectSoundName = textView;
        this.ivEffectSelectState = imageView;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorItemEffcetSoundBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = com.aliyun.svideo.editor.R.id.effect_sound_image;
        android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (frameLayout != null) {
            i = com.aliyun.svideo.editor.R.id.effect_sound_image_view;
            com.aliyun.svideo.base.widget.CircularImageView circularImageView = (com.aliyun.svideo.base.widget.CircularImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (circularImageView != null) {
                i = com.aliyun.svideo.editor.R.id.effect_sound_name;
                android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = com.aliyun.svideo.editor.R.id.iv_effect_select_state;
                    android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        return new com.aliyun.svideo.editor.databinding.AlivcEditorItemEffcetSoundBinding((android.widget.LinearLayout) view, frameLayout, circularImageView, textView, imageView);
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorItemEffcetSoundBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorItemEffcetSoundBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_item_effcet_sound, viewGroup, false);
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
