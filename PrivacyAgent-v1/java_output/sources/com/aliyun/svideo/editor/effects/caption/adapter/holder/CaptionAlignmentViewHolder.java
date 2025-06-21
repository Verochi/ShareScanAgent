package com.aliyun.svideo.editor.effects.caption.adapter.holder;

/* loaded from: classes12.dex */
public class CaptionAlignmentViewHolder extends com.aliyun.svideo.editor.effects.caption.adapter.holder.BaseCaptionViewHolder {
    private android.widget.RadioButton alignmentLeft;
    private android.widget.RadioButton alignmentMiddle;
    private android.widget.RadioButton alignmentRight;
    private int currentCaptionControlId;
    android.widget.CompoundButton.OnCheckedChangeListener onCheckedChangeListener;

    /* renamed from: com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionAlignmentViewHolder$1, reason: invalid class name */
    public class AnonymousClass1 implements android.widget.CompoundButton.OnCheckedChangeListener {
        public AnonymousClass1() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onCheckedChanged(android.widget.CompoundButton compoundButton, boolean z) {
            if (z) {
                int id = compoundButton.getId();
                int i = 1;
                if (id != com.aliyun.svideo.editor.R.id.btn_alignment_left) {
                    if (id == com.aliyun.svideo.editor.R.id.btn_alignment_middle) {
                        i = 4;
                    } else if (id == com.aliyun.svideo.editor.R.id.btn_alignment_right) {
                        i = 2;
                    }
                }
                if (com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionAlignmentViewHolder.this.getCaptionChooserStateChangeListener() != null) {
                    com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionAlignmentViewHolder.this.getCaptionChooserStateChangeListener().onCaptionTextAlignmentChanged(i);
                }
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
        }
    }

    public CaptionAlignmentViewHolder(android.content.Context context, java.lang.String str, com.aliyun.svideo.editor.effects.caption.listener.OnCaptionChooserStateChangeListener onCaptionChooserStateChangeListener) {
        super(context, str, onCaptionChooserStateChangeListener);
        this.onCheckedChangeListener = new com.aliyun.svideo.editor.effects.caption.adapter.holder.CaptionAlignmentViewHolder.AnonymousClass1();
    }

    @Override // com.aliyun.svideo.editor.effects.caption.adapter.holder.BaseCaptionViewHolder
    public void notifyDataSetChanged() {
        int captionControllerId;
        com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption captionController;
        if (this.alignmentLeft == null || this.currentCaptionControlId == (captionControllerId = com.aliyun.svideo.editor.effects.caption.manager.CaptionManager.getCaptionControllerId(getCaptionChooserStateChangeListener())) || (captionController = com.aliyun.svideo.editor.effects.caption.manager.CaptionManager.getCaptionController(getCaptionChooserStateChangeListener())) == null) {
            return;
        }
        int textAlignment = captionController.getTextAlignment();
        this.alignmentLeft.setOnCheckedChangeListener(null);
        this.alignmentMiddle.setOnCheckedChangeListener(null);
        this.alignmentRight.setOnCheckedChangeListener(null);
        if (textAlignment == 1) {
            this.alignmentLeft.setChecked(true);
            this.alignmentMiddle.setChecked(false);
            this.alignmentRight.setChecked(false);
        } else if (textAlignment == 2) {
            this.alignmentLeft.setChecked(false);
            this.alignmentMiddle.setChecked(false);
            this.alignmentRight.setChecked(true);
        } else if (textAlignment == 4) {
            this.alignmentLeft.setChecked(false);
            this.alignmentMiddle.setChecked(true);
            this.alignmentRight.setChecked(false);
        }
        this.alignmentLeft.setOnCheckedChangeListener(this.onCheckedChangeListener);
        this.alignmentMiddle.setOnCheckedChangeListener(this.onCheckedChangeListener);
        this.alignmentRight.setOnCheckedChangeListener(this.onCheckedChangeListener);
        this.currentCaptionControlId = captionControllerId;
    }

    @Override // com.aliyun.svideo.editor.effects.caption.adapter.holder.BaseCaptionViewHolder
    public void onBindViewHolder() {
        this.alignmentLeft.setOnCheckedChangeListener(this.onCheckedChangeListener);
        this.alignmentMiddle.setOnCheckedChangeListener(this.onCheckedChangeListener);
        this.alignmentRight.setOnCheckedChangeListener(this.onCheckedChangeListener);
        this.currentCaptionControlId = com.aliyun.svideo.editor.effects.caption.manager.CaptionManager.getCaptionControllerId(getCaptionChooserStateChangeListener());
    }

    @Override // com.aliyun.svideo.editor.effects.caption.adapter.holder.BaseCaptionViewHolder
    public android.view.View onCreateView(android.content.Context context) {
        android.view.View inflate = android.view.LayoutInflater.from(context).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_caption_text_alignment_container, (android.view.ViewGroup) null, false);
        this.alignmentLeft = (android.widget.RadioButton) inflate.findViewById(com.aliyun.svideo.editor.R.id.btn_alignment_left);
        this.alignmentMiddle = (android.widget.RadioButton) inflate.findViewById(com.aliyun.svideo.editor.R.id.btn_alignment_middle);
        this.alignmentRight = (android.widget.RadioButton) inflate.findViewById(com.aliyun.svideo.editor.R.id.btn_alignment_right);
        return inflate;
    }

    @Override // com.aliyun.svideo.editor.effects.caption.adapter.holder.BaseCaptionViewHolder
    public void onTabClick() {
        notifyDataSetChanged();
    }
}
