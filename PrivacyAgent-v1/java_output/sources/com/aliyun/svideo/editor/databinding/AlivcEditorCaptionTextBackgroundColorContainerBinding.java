package com.aliyun.svideo.editor.databinding;

/* loaded from: classes12.dex */
public final class AlivcEditorCaptionTextBackgroundColorContainerBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final androidx.recyclerview.widget.RecyclerView colorList;

    @androidx.annotation.NonNull
    public final android.widget.ImageView imgClean;

    @androidx.annotation.NonNull
    public final android.widget.SeekBar radiusSeekBar;

    @androidx.annotation.NonNull
    private final android.widget.LinearLayout rootView;

    private AlivcEditorCaptionTextBackgroundColorContainerBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.SeekBar seekBar) {
        this.rootView = linearLayout;
        this.colorList = recyclerView;
        this.imgClean = imageView;
        this.radiusSeekBar = seekBar;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorCaptionTextBackgroundColorContainerBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = com.aliyun.svideo.editor.R.id.color_list;
        androidx.recyclerview.widget.RecyclerView recyclerView = (androidx.recyclerview.widget.RecyclerView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (recyclerView != null) {
            i = com.aliyun.svideo.editor.R.id.img_clean;
            android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = com.aliyun.svideo.editor.R.id.radius_seekBar;
                android.widget.SeekBar seekBar = (android.widget.SeekBar) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (seekBar != null) {
                    return new com.aliyun.svideo.editor.databinding.AlivcEditorCaptionTextBackgroundColorContainerBinding((android.widget.LinearLayout) view, recyclerView, imageView, seekBar);
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorCaptionTextBackgroundColorContainerBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorCaptionTextBackgroundColorContainerBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_caption_text_background_color_container, viewGroup, false);
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
