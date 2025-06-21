package com.aliyun.svideo.editor.databinding;

/* loaded from: classes31.dex */
public final class AlivcEditorViewChooserRollCaptionBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.ImageView rollCaptionApplyIv;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout rollCaptionChooser;

    @androidx.annotation.NonNull
    public final android.widget.TextView rollCaptionClearTv;

    @androidx.annotation.NonNull
    public final com.aliyun.svideo.editor.effects.rollcaption.RollCaptionColorView rollCaptionColorView;

    @androidx.annotation.NonNull
    public final androidx.recyclerview.widget.RecyclerView rollCaptionFontRecyclerview;

    @androidx.annotation.NonNull
    private final android.widget.RelativeLayout rootView;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout top;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvRollCaptionColor;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvRollCaptionFont;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvRollCaptionSubtitle;

    private AlivcEditorViewChooserRollCaptionBinding(@androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull com.aliyun.svideo.editor.effects.rollcaption.RollCaptionColorView rollCaptionColorView, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView, @androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout2, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull android.widget.TextView textView3, @androidx.annotation.NonNull android.widget.TextView textView4) {
        this.rootView = relativeLayout;
        this.rollCaptionApplyIv = imageView;
        this.rollCaptionChooser = linearLayout;
        this.rollCaptionClearTv = textView;
        this.rollCaptionColorView = rollCaptionColorView;
        this.rollCaptionFontRecyclerview = recyclerView;
        this.top = relativeLayout2;
        this.tvRollCaptionColor = textView2;
        this.tvRollCaptionFont = textView3;
        this.tvRollCaptionSubtitle = textView4;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorViewChooserRollCaptionBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = com.aliyun.svideo.editor.R.id.roll_caption_apply_iv;
        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = com.aliyun.svideo.editor.R.id.roll_caption_chooser;
            android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = com.aliyun.svideo.editor.R.id.roll_caption_clear_tv;
                android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = com.aliyun.svideo.editor.R.id.roll_caption_color_view;
                    com.aliyun.svideo.editor.effects.rollcaption.RollCaptionColorView rollCaptionColorView = (com.aliyun.svideo.editor.effects.rollcaption.RollCaptionColorView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (rollCaptionColorView != null) {
                        i = com.aliyun.svideo.editor.R.id.roll_caption_font_recyclerview;
                        androidx.recyclerview.widget.RecyclerView recyclerView = (androidx.recyclerview.widget.RecyclerView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (recyclerView != null) {
                            i = com.aliyun.svideo.editor.R.id.top;
                            android.widget.RelativeLayout relativeLayout = (android.widget.RelativeLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (relativeLayout != null) {
                                i = com.aliyun.svideo.editor.R.id.tv_roll_caption_color;
                                android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (textView2 != null) {
                                    i = com.aliyun.svideo.editor.R.id.tv_roll_caption_font;
                                    android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                    if (textView3 != null) {
                                        i = com.aliyun.svideo.editor.R.id.tv_roll_caption_subtitle;
                                        android.widget.TextView textView4 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                        if (textView4 != null) {
                                            return new com.aliyun.svideo.editor.databinding.AlivcEditorViewChooserRollCaptionBinding((android.widget.RelativeLayout) view, imageView, linearLayout, textView, rollCaptionColorView, recyclerView, relativeLayout, textView2, textView3, textView4);
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
    public static com.aliyun.svideo.editor.databinding.AlivcEditorViewChooserRollCaptionBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorViewChooserRollCaptionBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_view_chooser_roll_caption, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public android.widget.RelativeLayout getRoot() {
        return this.rootView;
    }
}
