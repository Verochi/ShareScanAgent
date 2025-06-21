package com.aliyun.svideo.editor.databinding;

/* loaded from: classes31.dex */
public final class AlivcEditorViewChooserCompoundCaptionBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.ImageView compoundCaptionApplyIv;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout compoundCaptionChooser;

    @androidx.annotation.NonNull
    public final com.aliyun.svideo.editor.effects.rollcaption.RollCaptionColorView rollCaptionColorView;

    @androidx.annotation.NonNull
    public final androidx.recyclerview.widget.RecyclerView rollCaptionFontRecyclerview;

    @androidx.annotation.NonNull
    private final android.widget.RelativeLayout rootView;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout top;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvCompoundCaptionAdd;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvCompoundCaptionColor;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvCompoundCaptionDelete;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvCompoundCaptionFont;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvCompoundCaptionRotate;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvCompoundScaleHFont;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvCompoundScaleLFont;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvCompoundSearch;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvCompoundStyleFont;

    private AlivcEditorViewChooserCompoundCaptionBinding(@androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull com.aliyun.svideo.editor.effects.rollcaption.RollCaptionColorView rollCaptionColorView, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView, @androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout2, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull android.widget.TextView textView3, @androidx.annotation.NonNull android.widget.TextView textView4, @androidx.annotation.NonNull android.widget.TextView textView5, @androidx.annotation.NonNull android.widget.TextView textView6, @androidx.annotation.NonNull android.widget.TextView textView7, @androidx.annotation.NonNull android.widget.TextView textView8, @androidx.annotation.NonNull android.widget.TextView textView9) {
        this.rootView = relativeLayout;
        this.compoundCaptionApplyIv = imageView;
        this.compoundCaptionChooser = linearLayout;
        this.rollCaptionColorView = rollCaptionColorView;
        this.rollCaptionFontRecyclerview = recyclerView;
        this.top = relativeLayout2;
        this.tvCompoundCaptionAdd = textView;
        this.tvCompoundCaptionColor = textView2;
        this.tvCompoundCaptionDelete = textView3;
        this.tvCompoundCaptionFont = textView4;
        this.tvCompoundCaptionRotate = textView5;
        this.tvCompoundScaleHFont = textView6;
        this.tvCompoundScaleLFont = textView7;
        this.tvCompoundSearch = textView8;
        this.tvCompoundStyleFont = textView9;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorViewChooserCompoundCaptionBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = com.aliyun.svideo.editor.R.id.compound_caption_apply_iv;
        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = com.aliyun.svideo.editor.R.id.compound_caption_chooser;
            android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = com.aliyun.svideo.editor.R.id.roll_caption_color_view;
                com.aliyun.svideo.editor.effects.rollcaption.RollCaptionColorView rollCaptionColorView = (com.aliyun.svideo.editor.effects.rollcaption.RollCaptionColorView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (rollCaptionColorView != null) {
                    i = com.aliyun.svideo.editor.R.id.roll_caption_font_recyclerview;
                    androidx.recyclerview.widget.RecyclerView recyclerView = (androidx.recyclerview.widget.RecyclerView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (recyclerView != null) {
                        i = com.aliyun.svideo.editor.R.id.top;
                        android.widget.RelativeLayout relativeLayout = (android.widget.RelativeLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (relativeLayout != null) {
                            i = com.aliyun.svideo.editor.R.id.tv_compound_caption_add;
                            android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                i = com.aliyun.svideo.editor.R.id.tv_compound_caption_color;
                                android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (textView2 != null) {
                                    i = com.aliyun.svideo.editor.R.id.tv_compound_caption_delete;
                                    android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                    if (textView3 != null) {
                                        i = com.aliyun.svideo.editor.R.id.tv_compound_caption_font;
                                        android.widget.TextView textView4 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                        if (textView4 != null) {
                                            i = com.aliyun.svideo.editor.R.id.tv_compound_caption_rotate;
                                            android.widget.TextView textView5 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                            if (textView5 != null) {
                                                i = com.aliyun.svideo.editor.R.id.tv_compound_scale_h_font;
                                                android.widget.TextView textView6 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                if (textView6 != null) {
                                                    i = com.aliyun.svideo.editor.R.id.tv_compound_scale_l_font;
                                                    android.widget.TextView textView7 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                    if (textView7 != null) {
                                                        i = com.aliyun.svideo.editor.R.id.tv_compound_search;
                                                        android.widget.TextView textView8 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                        if (textView8 != null) {
                                                            i = com.aliyun.svideo.editor.R.id.tv_compound_style_font;
                                                            android.widget.TextView textView9 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                            if (textView9 != null) {
                                                                return new com.aliyun.svideo.editor.databinding.AlivcEditorViewChooserCompoundCaptionBinding((android.widget.RelativeLayout) view, imageView, linearLayout, rollCaptionColorView, recyclerView, relativeLayout, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9);
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
    public static com.aliyun.svideo.editor.databinding.AlivcEditorViewChooserCompoundCaptionBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorViewChooserCompoundCaptionBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_view_chooser_compound_caption, viewGroup, false);
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
