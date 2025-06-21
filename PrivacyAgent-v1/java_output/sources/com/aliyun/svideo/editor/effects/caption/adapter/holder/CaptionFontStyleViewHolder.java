package com.aliyun.svideo.editor.effects.caption.adapter.holder;

/* loaded from: classes12.dex */
public class CaptionFontStyleViewHolder extends com.aliyun.svideo.editor.effects.caption.adapter.holder.BaseCaptionViewHolder {
    private android.widget.CheckBox checkBoxFontItalic;
    private android.widget.CheckBox checkBoxFontWeight;
    private int currentCaptionControlId;
    android.widget.CompoundButton.OnCheckedChangeListener onCheckedChangeListener;

    /* renamed from: com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionFontStyleViewHolder$1, reason: invalid class name */
    public class AnonymousClass1 implements android.widget.CompoundButton.OnCheckedChangeListener {
        public AnonymousClass1() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onCheckedChanged(android.widget.CompoundButton compoundButton, boolean z) {
            boolean isChecked = com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionFontStyleViewHolder.this.checkBoxFontItalic.isChecked();
            boolean isChecked2 = com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionFontStyleViewHolder.this.checkBoxFontWeight.isChecked();
            com.aliyun.svideosdk.common.AliyunTypeface aliyunTypeface = com.aliyun.svideosdk.common.AliyunTypeface.NORMAL;
            if (isChecked) {
                aliyunTypeface = com.aliyun.svideosdk.common.AliyunTypeface.ITALIC;
            }
            if (isChecked2) {
                aliyunTypeface = com.aliyun.svideosdk.common.AliyunTypeface.BOLD;
            }
            if (isChecked && isChecked2) {
                aliyunTypeface = com.aliyun.svideosdk.common.AliyunTypeface.BOLD_ITALIC;
            }
            if (com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionFontStyleViewHolder.this.getCaptionChooserStateChangeListener() != null) {
                com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionFontStyleViewHolder.this.getCaptionChooserStateChangeListener().onCaptionTextFontTypeFaceChanged(aliyunTypeface);
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionFontStyleViewHolder$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$aliyun$svideosdk$common$AliyunTypeface;

        static {
            int[] iArr = new int[com.aliyun.svideosdk.common.AliyunTypeface.values().length];
            $SwitchMap$com$aliyun$svideosdk$common$AliyunTypeface = iArr;
            try {
                iArr[com.aliyun.svideosdk.common.AliyunTypeface.NORMAL.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$aliyun$svideosdk$common$AliyunTypeface[com.aliyun.svideosdk.common.AliyunTypeface.BOLD_ITALIC.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$aliyun$svideosdk$common$AliyunTypeface[com.aliyun.svideosdk.common.AliyunTypeface.ITALIC.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$aliyun$svideosdk$common$AliyunTypeface[com.aliyun.svideosdk.common.AliyunTypeface.BOLD.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
        }
    }

    public CaptionFontStyleViewHolder(android.content.Context context, java.lang.String str, com.aliyun.svideo.editor.effects.caption.listener.OnCaptionChooserStateChangeListener onCaptionChooserStateChangeListener) {
        super(context, str, onCaptionChooserStateChangeListener);
        this.onCheckedChangeListener = new com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionFontStyleViewHolder.AnonymousClass1();
    }

    @Override // com.aliyun.svideo.editor.effects.caption.adapter.holder.BaseCaptionViewHolder
    public void notifyDataSetChanged() {
        int captionControllerId;
        com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption captionController;
        if (this.checkBoxFontItalic == null || this.currentCaptionControlId == (captionControllerId = com.aliyun.svideo.editor.effects.caption.manager.CaptionManager.getCaptionControllerId(getCaptionChooserStateChangeListener())) || (captionController = com.aliyun.svideo.editor.effects.caption.manager.CaptionManager.getCaptionController(getCaptionChooserStateChangeListener())) == null) {
            return;
        }
        com.aliyun.svideosdk.common.AliyunTypeface fontTypeface = captionController.getFontTypeface();
        if (fontTypeface != null) {
            this.checkBoxFontItalic.setOnCheckedChangeListener(null);
            this.checkBoxFontWeight.setOnCheckedChangeListener(null);
            int i = com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionFontStyleViewHolder.AnonymousClass2.$SwitchMap$com$aliyun$svideosdk$common$AliyunTypeface[fontTypeface.ordinal()];
            if (i == 1) {
                this.checkBoxFontItalic.setChecked(false);
                this.checkBoxFontWeight.setChecked(false);
            } else if (i == 2) {
                this.checkBoxFontItalic.setChecked(true);
                this.checkBoxFontWeight.setChecked(true);
            } else if (i == 3) {
                this.checkBoxFontItalic.setChecked(true);
                this.checkBoxFontWeight.setChecked(false);
            } else if (i == 4) {
                this.checkBoxFontItalic.setChecked(false);
                this.checkBoxFontWeight.setChecked(true);
            }
        }
        this.checkBoxFontItalic.setOnCheckedChangeListener(this.onCheckedChangeListener);
        this.checkBoxFontWeight.setOnCheckedChangeListener(this.onCheckedChangeListener);
        this.currentCaptionControlId = captionControllerId;
    }

    @Override // com.aliyun.svideo.editor.effects.caption.adapter.holder.BaseCaptionViewHolder
    public void onBindViewHolder() {
        this.checkBoxFontItalic.setOnCheckedChangeListener(this.onCheckedChangeListener);
        this.checkBoxFontWeight.setOnCheckedChangeListener(this.onCheckedChangeListener);
        this.currentCaptionControlId = com.aliyun.svideo.editor.effects.caption.manager.CaptionManager.getCaptionControllerId(getCaptionChooserStateChangeListener());
    }

    @Override // com.aliyun.svideo.editor.effects.caption.adapter.holder.BaseCaptionViewHolder
    public android.view.View onCreateView(android.content.Context context) {
        android.view.View inflate = android.view.LayoutInflater.from(context).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_caption_font_style_container, (android.view.ViewGroup) null, false);
        this.checkBoxFontItalic = (android.widget.CheckBox) inflate.findViewById(com.aliyun.svideo.editor.R.id.btn_font_italic);
        this.checkBoxFontWeight = (android.widget.CheckBox) inflate.findViewById(com.aliyun.svideo.editor.R.id.btn_font_weight);
        return inflate;
    }

    @Override // com.aliyun.svideo.editor.effects.caption.adapter.holder.BaseCaptionViewHolder
    public void onTabClick() {
        notifyDataSetChanged();
    }
}
