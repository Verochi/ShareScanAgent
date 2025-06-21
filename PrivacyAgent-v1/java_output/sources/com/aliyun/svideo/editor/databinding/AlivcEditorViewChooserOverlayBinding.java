package com.aliyun.svideo.editor.databinding;

/* loaded from: classes12.dex */
public final class AlivcEditorViewChooserOverlayBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final androidx.recyclerview.widget.RecyclerView categoryList;

    @androidx.annotation.NonNull
    public final com.aliyun.svideo.base.widget.pagerecyclerview.PageRecyclerView effectOverlayView;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout flThumblinebar;

    @androidx.annotation.NonNull
    private final android.widget.LinearLayout rootView;

    @androidx.annotation.NonNull
    public final com.aliyun.svideo.base.widget.pagerecyclerview.PageIndicatorView viewIndicator;

    private AlivcEditorViewChooserOverlayBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView, @androidx.annotation.NonNull com.aliyun.svideo.base.widget.pagerecyclerview.PageRecyclerView pageRecyclerView, @androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull com.aliyun.svideo.base.widget.pagerecyclerview.PageIndicatorView pageIndicatorView) {
        this.rootView = linearLayout;
        this.categoryList = recyclerView;
        this.effectOverlayView = pageRecyclerView;
        this.flThumblinebar = frameLayout;
        this.viewIndicator = pageIndicatorView;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorViewChooserOverlayBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = com.aliyun.svideo.editor.R.id.category_list;
        androidx.recyclerview.widget.RecyclerView recyclerView = (androidx.recyclerview.widget.RecyclerView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (recyclerView != null) {
            i = com.aliyun.svideo.editor.R.id.effect_overlay_view;
            com.aliyun.svideo.base.widget.pagerecyclerview.PageRecyclerView pageRecyclerView = (com.aliyun.svideo.base.widget.pagerecyclerview.PageRecyclerView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (pageRecyclerView != null) {
                i = com.aliyun.svideo.editor.R.id.fl_thumblinebar;
                android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (frameLayout != null) {
                    i = com.aliyun.svideo.editor.R.id.view_indicator;
                    com.aliyun.svideo.base.widget.pagerecyclerview.PageIndicatorView pageIndicatorView = (com.aliyun.svideo.base.widget.pagerecyclerview.PageIndicatorView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (pageIndicatorView != null) {
                        return new com.aliyun.svideo.editor.databinding.AlivcEditorViewChooserOverlayBinding((android.widget.LinearLayout) view, recyclerView, pageRecyclerView, frameLayout, pageIndicatorView);
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorViewChooserOverlayBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorViewChooserOverlayBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_view_chooser_overlay, viewGroup, false);
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
