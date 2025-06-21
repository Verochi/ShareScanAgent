package com.aliyun.svideo.editor.databinding;

/* loaded from: classes12.dex */
public final class AlivcEditorRollCaptionItemSubtitleEffectBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.TextView rollCaptionEditTv;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout rollCaptionItem;

    @androidx.annotation.NonNull
    public final android.widget.CheckBox rollCaptionSubtitleCheckbox;

    @androidx.annotation.NonNull
    public final android.widget.EditText rollCaptionSubtitleEt;

    @androidx.annotation.NonNull
    private final android.widget.LinearLayout rootView;

    private AlivcEditorRollCaptionItemSubtitleEffectBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout2, @androidx.annotation.NonNull android.widget.CheckBox checkBox, @androidx.annotation.NonNull android.widget.EditText editText) {
        this.rootView = linearLayout;
        this.rollCaptionEditTv = textView;
        this.rollCaptionItem = linearLayout2;
        this.rollCaptionSubtitleCheckbox = checkBox;
        this.rollCaptionSubtitleEt = editText;
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorRollCaptionItemSubtitleEffectBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = com.aliyun.svideo.editor.R.id.roll_caption_edit_tv;
        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) view;
            i = com.aliyun.svideo.editor.R.id.roll_caption_subtitle_checkbox;
            android.widget.CheckBox checkBox = (android.widget.CheckBox) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (checkBox != null) {
                i = com.aliyun.svideo.editor.R.id.roll_caption_subtitle_et;
                android.widget.EditText editText = (android.widget.EditText) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (editText != null) {
                    return new com.aliyun.svideo.editor.databinding.AlivcEditorRollCaptionItemSubtitleEffectBinding(linearLayout, textView, linearLayout, checkBox, editText);
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorRollCaptionItemSubtitleEffectBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static com.aliyun.svideo.editor.databinding.AlivcEditorRollCaptionItemSubtitleEffectBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_roll_caption_item_subtitle_effect, viewGroup, false);
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
