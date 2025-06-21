package com.aliyun.svideo.editor.databinding;

/* loaded from: classes12.dex */
public final class AlivcEditorViewChooserTransitionBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.aliyun.svideo.base.EffectParamsAdjustView paramsEffectView;

    @androidx.annotation.NonNull
    private final android.widget.LinearLayout rootView;

    @androidx.annotation.NonNull
    public final androidx.recyclerview.widget.RecyclerView transitionCategoryList;

    @androidx.annotation.NonNull
    public final androidx.recyclerview.widget.RecyclerView transitionEffectView;

    @androidx.annotation.NonNull
    public final androidx.recyclerview.widget.RecyclerView transitionView;

    private AlivcEditorViewChooserTransitionBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull com.aliyun.svideo.base.EffectParamsAdjustView effectParamsAdjustView, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView2, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView3) {
        this.rootView = linearLayout;
        this.paramsEffectView = effectParamsAdjustView;
        this.transitionCategoryList = recyclerView;
        this.transitionEffectView = recyclerView2;
        this.transitionView = recyclerView3;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorViewChooserTransitionBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = com.aliyun.svideo.editor.R.id.params_effect_view;
        com.aliyun.svideo.base.EffectParamsAdjustView effectParamsAdjustView = (com.aliyun.svideo.base.EffectParamsAdjustView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (effectParamsAdjustView != null) {
            i = com.aliyun.svideo.editor.R.id.transition_category_list;
            androidx.recyclerview.widget.RecyclerView recyclerView = (androidx.recyclerview.widget.RecyclerView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (recyclerView != null) {
                i = com.aliyun.svideo.editor.R.id.transition_effect_view;
                androidx.recyclerview.widget.RecyclerView recyclerView2 = (androidx.recyclerview.widget.RecyclerView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (recyclerView2 != null) {
                    i = com.aliyun.svideo.editor.R.id.transition_view;
                    androidx.recyclerview.widget.RecyclerView recyclerView3 = (androidx.recyclerview.widget.RecyclerView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (recyclerView3 != null) {
                        return new com.aliyun.svideo.editor.databinding.AlivcEditorViewChooserTransitionBinding((android.widget.LinearLayout) view, effectParamsAdjustView, recyclerView, recyclerView2, recyclerView3);
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorViewChooserTransitionBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorViewChooserTransitionBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_view_chooser_transition, viewGroup, false);
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
