package com.aliyun.svideo.editor.databinding;

/* loaded from: classes31.dex */
public final class AlivcEditorViewChooserTimeBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout flThumblinebar;

    @androidx.annotation.NonNull
    private final android.widget.LinearLayout rootView;

    @androidx.annotation.NonNull
    public final android.widget.ImageView timeEffectNone;

    @androidx.annotation.NonNull
    public final android.widget.ImageView timeEffectRepeat;

    @androidx.annotation.NonNull
    public final android.widget.ImageView timeEffectRepeatInvert;

    @androidx.annotation.NonNull
    public final android.widget.ImageView timeEffectSlow;

    @androidx.annotation.NonNull
    public final android.widget.ImageView timeEffectSpeedUp;

    private AlivcEditorViewChooserTimeBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.ImageView imageView2, @androidx.annotation.NonNull android.widget.ImageView imageView3, @androidx.annotation.NonNull android.widget.ImageView imageView4, @androidx.annotation.NonNull android.widget.ImageView imageView5) {
        this.rootView = linearLayout;
        this.flThumblinebar = frameLayout;
        this.timeEffectNone = imageView;
        this.timeEffectRepeat = imageView2;
        this.timeEffectRepeatInvert = imageView3;
        this.timeEffectSlow = imageView4;
        this.timeEffectSpeedUp = imageView5;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorViewChooserTimeBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = com.aliyun.svideo.editor.R.id.fl_thumblinebar;
        android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (frameLayout != null) {
            i = com.aliyun.svideo.editor.R.id.time_effect_none;
            android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = com.aliyun.svideo.editor.R.id.time_effect_repeat;
                android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = com.aliyun.svideo.editor.R.id.time_effect_repeat_invert;
                    android.widget.ImageView imageView3 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (imageView3 != null) {
                        i = com.aliyun.svideo.editor.R.id.time_effect_slow;
                        android.widget.ImageView imageView4 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (imageView4 != null) {
                            i = com.aliyun.svideo.editor.R.id.time_effect_speed_up;
                            android.widget.ImageView imageView5 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (imageView5 != null) {
                                return new com.aliyun.svideo.editor.databinding.AlivcEditorViewChooserTimeBinding((android.widget.LinearLayout) view, frameLayout, imageView, imageView2, imageView3, imageView4, imageView5);
                            }
                        }
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorViewChooserTimeBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorViewChooserTimeBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_view_chooser_time, viewGroup, false);
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
