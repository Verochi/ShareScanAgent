package com.aliyun.svideo.editor.databinding;

/* loaded from: classes12.dex */
public final class AlivcEditorViewSettingPipBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final androidx.recyclerview.widget.RecyclerView effectListFilter;

    @androidx.annotation.NonNull
    public final android.widget.TextView ivReset;

    @androidx.annotation.NonNull
    private final android.widget.LinearLayout rootView;

    @androidx.annotation.NonNull
    public final android.widget.SeekBar seekBar;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout seekBarArea;

    private AlivcEditorViewSettingPipBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.SeekBar seekBar, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout2) {
        this.rootView = linearLayout;
        this.effectListFilter = recyclerView;
        this.ivReset = textView;
        this.seekBar = seekBar;
        this.seekBarArea = linearLayout2;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorViewSettingPipBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = com.aliyun.svideo.editor.R.id.effect_list_filter;
        androidx.recyclerview.widget.RecyclerView recyclerView = (androidx.recyclerview.widget.RecyclerView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (recyclerView != null) {
            i = com.aliyun.svideo.editor.R.id.iv_reset;
            android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = com.aliyun.svideo.editor.R.id.seek_bar;
                android.widget.SeekBar seekBar = (android.widget.SeekBar) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (seekBar != null) {
                    i = com.aliyun.svideo.editor.R.id.seek_bar_area;
                    android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (linearLayout != null) {
                        return new com.aliyun.svideo.editor.databinding.AlivcEditorViewSettingPipBinding((android.widget.LinearLayout) view, recyclerView, textView, seekBar, linearLayout);
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorViewSettingPipBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorViewSettingPipBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_view_setting_pip, viewGroup, false);
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
