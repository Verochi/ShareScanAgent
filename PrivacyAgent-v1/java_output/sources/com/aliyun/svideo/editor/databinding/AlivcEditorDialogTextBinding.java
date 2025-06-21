package com.aliyun.svideo.editor.databinding;

/* loaded from: classes31.dex */
public final class AlivcEditorDialogTextBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout colorContainer;

    @androidx.annotation.NonNull
    public final com.google.android.material.tabs.TabLayout colorTabHost;

    @androidx.annotation.NonNull
    public final androidx.viewpager.widget.ViewPager colorViewpager;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout container;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout flEditText;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout fontAnimation;

    @androidx.annotation.NonNull
    public final androidx.recyclerview.widget.RecyclerView fontAnimationView;

    @androidx.annotation.NonNull
    public final com.aliyun.svideo.editor.widget.WheelView fontCustomView;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout fontLayout;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout fontLayoutNew;

    @androidx.annotation.NonNull
    public final android.widget.GridView fontList;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivBack;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivConfirm;

    @androidx.annotation.NonNull
    public final android.widget.TextView message;

    @androidx.annotation.NonNull
    public final com.aliyun.svideo.editor.widget.AutoResizingEditText qupaiOverlayContentText;

    @androidx.annotation.NonNull
    private final android.widget.LinearLayout rootView;

    @androidx.annotation.NonNull
    public final com.google.android.material.tabs.TabLayout tlTab;

    private AlivcEditorDialogTextBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout2, @androidx.annotation.NonNull com.google.android.material.tabs.TabLayout tabLayout, @androidx.annotation.NonNull androidx.viewpager.widget.ViewPager viewPager, @androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull android.widget.FrameLayout frameLayout2, @androidx.annotation.NonNull android.widget.FrameLayout frameLayout3, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView, @androidx.annotation.NonNull com.aliyun.svideo.editor.widget.WheelView wheelView, @androidx.annotation.NonNull android.widget.FrameLayout frameLayout4, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout3, @androidx.annotation.NonNull android.widget.GridView gridView, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.ImageView imageView2, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull com.aliyun.svideo.editor.widget.AutoResizingEditText autoResizingEditText, @androidx.annotation.NonNull com.google.android.material.tabs.TabLayout tabLayout2) {
        this.rootView = linearLayout;
        this.colorContainer = linearLayout2;
        this.colorTabHost = tabLayout;
        this.colorViewpager = viewPager;
        this.container = frameLayout;
        this.flEditText = frameLayout2;
        this.fontAnimation = frameLayout3;
        this.fontAnimationView = recyclerView;
        this.fontCustomView = wheelView;
        this.fontLayout = frameLayout4;
        this.fontLayoutNew = linearLayout3;
        this.fontList = gridView;
        this.ivBack = imageView;
        this.ivConfirm = imageView2;
        this.message = textView;
        this.qupaiOverlayContentText = autoResizingEditText;
        this.tlTab = tabLayout2;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorDialogTextBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = com.aliyun.svideo.editor.R.id.color_container;
        android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = com.aliyun.svideo.editor.R.id.color_tab_host;
            com.google.android.material.tabs.TabLayout tabLayout = (com.google.android.material.tabs.TabLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (tabLayout != null) {
                i = com.aliyun.svideo.editor.R.id.color_viewpager;
                androidx.viewpager.widget.ViewPager viewPager = (androidx.viewpager.widget.ViewPager) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (viewPager != null) {
                    i = com.aliyun.svideo.editor.R.id.container;
                    android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (frameLayout != null) {
                        i = com.aliyun.svideo.editor.R.id.fl_editText;
                        android.widget.FrameLayout frameLayout2 = (android.widget.FrameLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (frameLayout2 != null) {
                            i = com.aliyun.svideo.editor.R.id.font_animation;
                            android.widget.FrameLayout frameLayout3 = (android.widget.FrameLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (frameLayout3 != null) {
                                i = com.aliyun.svideo.editor.R.id.font_animation_view;
                                androidx.recyclerview.widget.RecyclerView recyclerView = (androidx.recyclerview.widget.RecyclerView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (recyclerView != null) {
                                    i = com.aliyun.svideo.editor.R.id.font_custom_view;
                                    com.aliyun.svideo.editor.widget.WheelView wheelView = (com.aliyun.svideo.editor.widget.WheelView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                    if (wheelView != null) {
                                        i = com.aliyun.svideo.editor.R.id.font_layout;
                                        android.widget.FrameLayout frameLayout4 = (android.widget.FrameLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                        if (frameLayout4 != null) {
                                            i = com.aliyun.svideo.editor.R.id.font_layout_new;
                                            android.widget.LinearLayout linearLayout2 = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                            if (linearLayout2 != null) {
                                                i = com.aliyun.svideo.editor.R.id.font_list;
                                                android.widget.GridView gridView = (android.widget.GridView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                if (gridView != null) {
                                                    i = com.aliyun.svideo.editor.R.id.iv_back;
                                                    android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                    if (imageView != null) {
                                                        i = com.aliyun.svideo.editor.R.id.iv_confirm;
                                                        android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                        if (imageView2 != null) {
                                                            i = com.aliyun.svideo.editor.R.id.message;
                                                            android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                            if (textView != null) {
                                                                i = com.aliyun.svideo.editor.R.id.qupai_overlay_content_text;
                                                                com.aliyun.svideo.editor.widget.AutoResizingEditText autoResizingEditText = (com.aliyun.svideo.editor.widget.AutoResizingEditText) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                                if (autoResizingEditText != null) {
                                                                    i = com.aliyun.svideo.editor.R.id.tl_tab;
                                                                    com.google.android.material.tabs.TabLayout tabLayout2 = (com.google.android.material.tabs.TabLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                                    if (tabLayout2 != null) {
                                                                        return new com.aliyun.svideo.editor.databinding.AlivcEditorDialogTextBinding((android.widget.LinearLayout) view, linearLayout, tabLayout, viewPager, frameLayout, frameLayout2, frameLayout3, recyclerView, wheelView, frameLayout4, linearLayout2, gridView, imageView, imageView2, textView, autoResizingEditText, tabLayout2);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorDialogTextBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorDialogTextBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_dialog_text, viewGroup, false);
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
