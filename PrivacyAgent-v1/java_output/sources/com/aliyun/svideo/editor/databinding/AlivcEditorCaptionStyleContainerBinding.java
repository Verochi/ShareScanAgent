package com.aliyun.svideo.editor.databinding;

/* loaded from: classes12.dex */
public final class AlivcEditorCaptionStyleContainerBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    private final android.widget.LinearLayout rootView;

    @androidx.annotation.NonNull
    public final com.google.android.material.tabs.TabLayout tlTab;

    @androidx.annotation.NonNull
    public final androidx.viewpager.widget.ViewPager viewpager;

    private AlivcEditorCaptionStyleContainerBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull com.google.android.material.tabs.TabLayout tabLayout, @androidx.annotation.NonNull androidx.viewpager.widget.ViewPager viewPager) {
        this.rootView = linearLayout;
        this.tlTab = tabLayout;
        this.viewpager = viewPager;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorCaptionStyleContainerBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = com.aliyun.svideo.editor.R.id.tl_tab;
        com.google.android.material.tabs.TabLayout tabLayout = (com.google.android.material.tabs.TabLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (tabLayout != null) {
            i = com.aliyun.svideo.editor.R.id.viewpager;
            androidx.viewpager.widget.ViewPager viewPager = (androidx.viewpager.widget.ViewPager) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (viewPager != null) {
                return new com.aliyun.svideo.editor.databinding.AlivcEditorCaptionStyleContainerBinding((android.widget.LinearLayout) view, tabLayout, viewPager);
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorCaptionStyleContainerBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorCaptionStyleContainerBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_caption_style_container, viewGroup, false);
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
