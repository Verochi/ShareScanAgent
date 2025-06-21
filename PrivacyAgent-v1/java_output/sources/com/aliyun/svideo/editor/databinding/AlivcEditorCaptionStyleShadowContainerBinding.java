package com.aliyun.svideo.editor.databinding;

/* loaded from: classes12.dex */
public final class AlivcEditorCaptionStyleShadowContainerBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final androidx.recyclerview.widget.RecyclerView colorList;

    @androidx.annotation.NonNull
    private final android.widget.LinearLayout rootView;

    @androidx.annotation.NonNull
    public final android.widget.SeekBar xSeekbar;

    @androidx.annotation.NonNull
    public final android.widget.SeekBar ySeekbar;

    private AlivcEditorCaptionStyleShadowContainerBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView, @androidx.annotation.NonNull android.widget.SeekBar seekBar, @androidx.annotation.NonNull android.widget.SeekBar seekBar2) {
        this.rootView = linearLayout;
        this.colorList = recyclerView;
        this.xSeekbar = seekBar;
        this.ySeekbar = seekBar2;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorCaptionStyleShadowContainerBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = com.aliyun.svideo.editor.R.id.color_list;
        androidx.recyclerview.widget.RecyclerView recyclerView = (androidx.recyclerview.widget.RecyclerView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (recyclerView != null) {
            i = com.aliyun.svideo.editor.R.id.x_seekbar;
            android.widget.SeekBar seekBar = (android.widget.SeekBar) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (seekBar != null) {
                i = com.aliyun.svideo.editor.R.id.y_seekbar;
                android.widget.SeekBar seekBar2 = (android.widget.SeekBar) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (seekBar2 != null) {
                    return new com.aliyun.svideo.editor.databinding.AlivcEditorCaptionStyleShadowContainerBinding((android.widget.LinearLayout) view, recyclerView, seekBar, seekBar2);
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorCaptionStyleShadowContainerBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorCaptionStyleShadowContainerBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_caption_style_shadow_container, viewGroup, false);
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
