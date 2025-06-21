package com.aliyun.svideo.editor.databinding;

/* loaded from: classes31.dex */
public final class AlivcEditorViewChooserPaintBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.ImageView cancel;

    @androidx.annotation.NonNull
    public final androidx.recyclerview.widget.RecyclerView colorList;

    @androidx.annotation.NonNull
    public final android.widget.ImageView complete;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout paintMenu;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout paintOne;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout paintThree;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout paintTwo;

    @androidx.annotation.NonNull
    private final android.widget.LinearLayout rootView;

    @androidx.annotation.NonNull
    public final android.widget.ImageView undo;

    private AlivcEditorViewChooserPaintBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView, @androidx.annotation.NonNull android.widget.ImageView imageView2, @androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout, @androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull android.widget.FrameLayout frameLayout2, @androidx.annotation.NonNull android.widget.FrameLayout frameLayout3, @androidx.annotation.NonNull android.widget.ImageView imageView3) {
        this.rootView = linearLayout;
        this.cancel = imageView;
        this.colorList = recyclerView;
        this.complete = imageView2;
        this.paintMenu = relativeLayout;
        this.paintOne = frameLayout;
        this.paintThree = frameLayout2;
        this.paintTwo = frameLayout3;
        this.undo = imageView3;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorViewChooserPaintBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = com.aliyun.svideo.editor.R.id.cancel;
        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = com.aliyun.svideo.editor.R.id.color_list;
            androidx.recyclerview.widget.RecyclerView recyclerView = (androidx.recyclerview.widget.RecyclerView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (recyclerView != null) {
                i = com.aliyun.svideo.editor.R.id.complete;
                android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = com.aliyun.svideo.editor.R.id.paint_menu;
                    android.widget.RelativeLayout relativeLayout = (android.widget.RelativeLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (relativeLayout != null) {
                        i = com.aliyun.svideo.editor.R.id.paint_one;
                        android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (frameLayout != null) {
                            i = com.aliyun.svideo.editor.R.id.paint_three;
                            android.widget.FrameLayout frameLayout2 = (android.widget.FrameLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (frameLayout2 != null) {
                                i = com.aliyun.svideo.editor.R.id.paint_two;
                                android.widget.FrameLayout frameLayout3 = (android.widget.FrameLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (frameLayout3 != null) {
                                    i = com.aliyun.svideo.editor.R.id.undo;
                                    android.widget.ImageView imageView3 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                    if (imageView3 != null) {
                                        return new com.aliyun.svideo.editor.databinding.AlivcEditorViewChooserPaintBinding((android.widget.LinearLayout) view, imageView, recyclerView, imageView2, relativeLayout, frameLayout, frameLayout2, frameLayout3, imageView3);
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
    public static com.aliyun.svideo.editor.databinding.AlivcEditorViewChooserPaintBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorViewChooserPaintBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_view_chooser_paint, viewGroup, false);
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
