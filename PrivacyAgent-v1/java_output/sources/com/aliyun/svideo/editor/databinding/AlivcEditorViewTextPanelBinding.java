package com.aliyun.svideo.editor.databinding;

/* loaded from: classes31.dex */
public final class AlivcEditorViewTextPanelBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.EditText flEditText;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivBack;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivConfirm;

    @androidx.annotation.NonNull
    private final android.widget.LinearLayout rootView;

    @androidx.annotation.NonNull
    public final com.google.android.material.tabs.TabLayout tlTab;

    @androidx.annotation.NonNull
    public final androidx.viewpager.widget.ViewPager viewpager;

    private AlivcEditorViewTextPanelBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.EditText editText, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.ImageView imageView2, @androidx.annotation.NonNull com.google.android.material.tabs.TabLayout tabLayout, @androidx.annotation.NonNull androidx.viewpager.widget.ViewPager viewPager) {
        this.rootView = linearLayout;
        this.flEditText = editText;
        this.ivBack = imageView;
        this.ivConfirm = imageView2;
        this.tlTab = tabLayout;
        this.viewpager = viewPager;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorViewTextPanelBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = com.aliyun.svideo.editor.R.id.fl_editText;
        android.widget.EditText editText = (android.widget.EditText) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (editText != null) {
            i = com.aliyun.svideo.editor.R.id.iv_back;
            android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = com.aliyun.svideo.editor.R.id.iv_confirm;
                android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = com.aliyun.svideo.editor.R.id.tl_tab;
                    com.google.android.material.tabs.TabLayout tabLayout = (com.google.android.material.tabs.TabLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (tabLayout != null) {
                        i = com.aliyun.svideo.editor.R.id.viewpager;
                        androidx.viewpager.widget.ViewPager viewPager = (androidx.viewpager.widget.ViewPager) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (viewPager != null) {
                            return new com.aliyun.svideo.editor.databinding.AlivcEditorViewTextPanelBinding((android.widget.LinearLayout) view, editText, imageView, imageView2, tabLayout, viewPager);
                        }
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorViewTextPanelBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorViewTextPanelBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_view_text_panel, viewGroup, false);
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
