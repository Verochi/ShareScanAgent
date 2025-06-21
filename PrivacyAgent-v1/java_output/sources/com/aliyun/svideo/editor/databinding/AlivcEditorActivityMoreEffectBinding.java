package com.aliyun.svideo.editor.databinding;

/* loaded from: classes12.dex */
public final class AlivcEditorActivityMoreEffectBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    private final androidx.recyclerview.widget.RecyclerView rootView;

    @androidx.annotation.NonNull
    public final androidx.recyclerview.widget.RecyclerView rvMorePaster;

    private AlivcEditorActivityMoreEffectBinding(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView2) {
        this.rootView = recyclerView;
        this.rvMorePaster = recyclerView2;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorActivityMoreEffectBinding bind(@androidx.annotation.NonNull android.view.View view) {
        if (view == null) {
            throw new java.lang.NullPointerException("rootView");
        }
        androidx.recyclerview.widget.RecyclerView recyclerView = (androidx.recyclerview.widget.RecyclerView) view;
        return new com.aliyun.svideo.editor.databinding.AlivcEditorActivityMoreEffectBinding(recyclerView, recyclerView);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorActivityMoreEffectBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorActivityMoreEffectBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_activity_more_effect, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public androidx.recyclerview.widget.RecyclerView getRoot() {
        return this.rootView;
    }
}
