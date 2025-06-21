package com.aliyun.svideo.editor.databinding;

/* loaded from: classes12.dex */
public final class AlivcEditorViewChooserCaptionBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final androidx.recyclerview.widget.RecyclerView categoryList;

    @androidx.annotation.NonNull
    public final androidx.recyclerview.widget.RecyclerView effectList;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout flThumblinebar;

    @androidx.annotation.NonNull
    private final android.widget.LinearLayout rootView;

    private AlivcEditorViewChooserCaptionBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView2, @androidx.annotation.NonNull android.widget.FrameLayout frameLayout) {
        this.rootView = linearLayout;
        this.categoryList = recyclerView;
        this.effectList = recyclerView2;
        this.flThumblinebar = frameLayout;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorViewChooserCaptionBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = com.aliyun.svideo.editor.R.id.category_list;
        androidx.recyclerview.widget.RecyclerView recyclerView = (androidx.recyclerview.widget.RecyclerView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (recyclerView != null) {
            i = com.aliyun.svideo.editor.R.id.effect_list;
            androidx.recyclerview.widget.RecyclerView recyclerView2 = (androidx.recyclerview.widget.RecyclerView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (recyclerView2 != null) {
                i = com.aliyun.svideo.editor.R.id.fl_thumblinebar;
                android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (frameLayout != null) {
                    return new com.aliyun.svideo.editor.databinding.AlivcEditorViewChooserCaptionBinding((android.widget.LinearLayout) view, recyclerView, recyclerView2, frameLayout);
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorViewChooserCaptionBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorViewChooserCaptionBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_view_chooser_caption, viewGroup, false);
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
