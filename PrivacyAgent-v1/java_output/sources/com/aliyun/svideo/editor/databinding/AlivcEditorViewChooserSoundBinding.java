package com.aliyun.svideo.editor.databinding;

/* loaded from: classes31.dex */
public final class AlivcEditorViewChooserSoundBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.ImageView alivcBtnClose;

    @androidx.annotation.NonNull
    public final android.widget.ImageView alivcBtnDone;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout effectSoundListDismiss;

    @androidx.annotation.NonNull
    public final androidx.recyclerview.widget.RecyclerView effectSoundListFilter;

    @androidx.annotation.NonNull
    public final android.widget.TextView effectSoundTitleTv;

    @androidx.annotation.NonNull
    private final android.widget.LinearLayout rootView;

    private AlivcEditorViewChooserSoundBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.ImageView imageView2, @androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView, @androidx.annotation.NonNull android.widget.TextView textView) {
        this.rootView = linearLayout;
        this.alivcBtnClose = imageView;
        this.alivcBtnDone = imageView2;
        this.effectSoundListDismiss = relativeLayout;
        this.effectSoundListFilter = recyclerView;
        this.effectSoundTitleTv = textView;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorViewChooserSoundBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = com.aliyun.svideo.editor.R.id.alivc_btn_close;
        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = com.aliyun.svideo.editor.R.id.alivc_btn_done;
            android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = com.aliyun.svideo.editor.R.id.effect_sound_list_dismiss;
                android.widget.RelativeLayout relativeLayout = (android.widget.RelativeLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (relativeLayout != null) {
                    i = com.aliyun.svideo.editor.R.id.effect_sound_list_filter;
                    androidx.recyclerview.widget.RecyclerView recyclerView = (androidx.recyclerview.widget.RecyclerView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (recyclerView != null) {
                        i = com.aliyun.svideo.editor.R.id.effect_sound_title_tv;
                        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            return new com.aliyun.svideo.editor.databinding.AlivcEditorViewChooserSoundBinding((android.widget.LinearLayout) view, imageView, imageView2, relativeLayout, recyclerView, textView);
                        }
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorViewChooserSoundBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorViewChooserSoundBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_view_chooser_sound, viewGroup, false);
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
