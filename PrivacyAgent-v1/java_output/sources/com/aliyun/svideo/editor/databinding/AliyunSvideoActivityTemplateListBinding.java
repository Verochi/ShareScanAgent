package com.aliyun.svideo.editor.databinding;

/* loaded from: classes12.dex */
public final class AliyunSvideoActivityTemplateListBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.aliyun.svideo.editor.databinding.AlivcEditorIncludeActionBarProfileBinding actionBar;

    @androidx.annotation.NonNull
    public final androidx.recyclerview.widget.RecyclerView recyclerView;

    @androidx.annotation.NonNull
    private final android.widget.LinearLayout rootView;

    private AliyunSvideoActivityTemplateListBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull com.aliyun.svideo.editor.databinding.AlivcEditorIncludeActionBarProfileBinding alivcEditorIncludeActionBarProfileBinding, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView) {
        this.rootView = linearLayout;
        this.actionBar = alivcEditorIncludeActionBarProfileBinding;
        this.recyclerView = recyclerView;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AliyunSvideoActivityTemplateListBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = com.aliyun.svideo.editor.R.id.action_bar;
        android.view.View findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            com.aliyun.svideo.editor.databinding.AlivcEditorIncludeActionBarProfileBinding bind = com.aliyun.svideo.editor.databinding.AlivcEditorIncludeActionBarProfileBinding.bind(findChildViewById);
            int i2 = com.aliyun.svideo.editor.R.id.recycler_view;
            androidx.recyclerview.widget.RecyclerView recyclerView = (androidx.recyclerview.widget.RecyclerView) androidx.viewbinding.ViewBindings.findChildViewById(view, i2);
            if (recyclerView != null) {
                return new com.aliyun.svideo.editor.databinding.AliyunSvideoActivityTemplateListBinding((android.widget.LinearLayout) view, bind, recyclerView);
            }
            i = i2;
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AliyunSvideoActivityTemplateListBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AliyunSvideoActivityTemplateListBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.editor.R.layout.aliyun_svideo_activity_template_list, viewGroup, false);
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
