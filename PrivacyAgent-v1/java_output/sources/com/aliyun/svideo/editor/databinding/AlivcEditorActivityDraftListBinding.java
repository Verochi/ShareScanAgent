package com.aliyun.svideo.editor.databinding;

/* loaded from: classes12.dex */
public final class AlivcEditorActivityDraftListBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.ImageView alivcBackBtn;

    @androidx.annotation.NonNull
    public final android.widget.ImageView alivcDraftConfigBtn;

    @androidx.annotation.NonNull
    private final android.widget.LinearLayout rootView;

    @androidx.annotation.NonNull
    public final com.google.android.material.tabs.TabLayout tabLayout;

    @androidx.annotation.NonNull
    public final androidx.viewpager.widget.ViewPager viewPager;

    private AlivcEditorActivityDraftListBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.ImageView imageView2, @androidx.annotation.NonNull com.google.android.material.tabs.TabLayout tabLayout, @androidx.annotation.NonNull androidx.viewpager.widget.ViewPager viewPager) {
        this.rootView = linearLayout;
        this.alivcBackBtn = imageView;
        this.alivcDraftConfigBtn = imageView2;
        this.tabLayout = tabLayout;
        this.viewPager = viewPager;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorActivityDraftListBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = com.aliyun.svideo.editor.R.id.alivc_back_btn;
        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = com.aliyun.svideo.editor.R.id.alivc_draft_config_btn;
            android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = com.aliyun.svideo.editor.R.id.tab_layout;
                com.google.android.material.tabs.TabLayout tabLayout = (com.google.android.material.tabs.TabLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (tabLayout != null) {
                    i = com.aliyun.svideo.editor.R.id.view_pager;
                    androidx.viewpager.widget.ViewPager viewPager = (androidx.viewpager.widget.ViewPager) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (viewPager != null) {
                        return new com.aliyun.svideo.editor.databinding.AlivcEditorActivityDraftListBinding((android.widget.LinearLayout) view, imageView, imageView2, tabLayout, viewPager);
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorActivityDraftListBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorActivityDraftListBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_activity_draft_list, viewGroup, false);
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
