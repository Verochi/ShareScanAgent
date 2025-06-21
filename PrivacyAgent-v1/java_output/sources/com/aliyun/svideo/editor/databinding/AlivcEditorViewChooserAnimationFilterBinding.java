package com.aliyun.svideo.editor.databinding;

/* loaded from: classes31.dex */
public final class AlivcEditorViewChooserAnimationFilterBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.TextView alivcSvideoTip;

    @androidx.annotation.NonNull
    public final androidx.recyclerview.widget.RecyclerView effectCategoryView;

    @androidx.annotation.NonNull
    public final androidx.recyclerview.widget.RecyclerView effectListFilter;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout flThumblinebar;

    @androidx.annotation.NonNull
    public final com.aliyun.svideo.base.EffectParamsAdjustView paramsEffectView;

    @androidx.annotation.NonNull
    private final android.widget.LinearLayout rootView;

    private AlivcEditorViewChooserAnimationFilterBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView2, @androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull com.aliyun.svideo.base.EffectParamsAdjustView effectParamsAdjustView) {
        this.rootView = linearLayout;
        this.alivcSvideoTip = textView;
        this.effectCategoryView = recyclerView;
        this.effectListFilter = recyclerView2;
        this.flThumblinebar = frameLayout;
        this.paramsEffectView = effectParamsAdjustView;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorViewChooserAnimationFilterBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = com.aliyun.svideo.editor.R.id.alivc_svideo_tip;
        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = com.aliyun.svideo.editor.R.id.effect_category_view;
            androidx.recyclerview.widget.RecyclerView recyclerView = (androidx.recyclerview.widget.RecyclerView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (recyclerView != null) {
                i = com.aliyun.svideo.editor.R.id.effect_list_filter;
                androidx.recyclerview.widget.RecyclerView recyclerView2 = (androidx.recyclerview.widget.RecyclerView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (recyclerView2 != null) {
                    i = com.aliyun.svideo.editor.R.id.fl_thumblinebar;
                    android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (frameLayout != null) {
                        i = com.aliyun.svideo.editor.R.id.params_effect_view;
                        com.aliyun.svideo.base.EffectParamsAdjustView effectParamsAdjustView = (com.aliyun.svideo.base.EffectParamsAdjustView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (effectParamsAdjustView != null) {
                            return new com.aliyun.svideo.editor.databinding.AlivcEditorViewChooserAnimationFilterBinding((android.widget.LinearLayout) view, textView, recyclerView, recyclerView2, frameLayout, effectParamsAdjustView);
                        }
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorViewChooserAnimationFilterBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorViewChooserAnimationFilterBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_view_chooser_animation_filter, viewGroup, false);
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
