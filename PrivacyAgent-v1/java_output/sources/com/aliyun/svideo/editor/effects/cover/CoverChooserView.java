package com.aliyun.svideo.editor.effects.cover;

/* loaded from: classes12.dex */
public class CoverChooserView extends com.aliyun.svideo.editor.effects.control.BaseChooser implements android.view.View.OnClickListener {
    private boolean isFirstShow;
    private android.widget.ImageView mCancel;
    private android.widget.ImageView mComplete;
    private android.widget.FrameLayout mFlThumblinebar;
    private android.widget.ImageView mIvEffectIcon;
    private android.widget.TextView mTvEffectTitle;
    private android.view.View mView;

    public CoverChooserView(@androidx.annotation.NonNull android.content.Context context) {
        this(context, null);
    }

    public CoverChooserView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CoverChooserView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.aliyun.svideo.editor.effects.control.BaseChooser
    public android.widget.FrameLayout getThumbContainer() {
        return this.mFlThumblinebar;
    }

    @Override // com.aliyun.svideo.editor.effects.control.BaseChooser
    public com.aliyun.svideo.editor.effects.control.UIEditorPage getUIEditorPage() {
        return com.aliyun.svideo.editor.effects.control.UIEditorPage.COVER;
    }

    @Override // com.aliyun.svideo.editor.effects.control.BaseChooser
    public void init() {
        android.view.View inflate = android.view.LayoutInflater.from(getContext()).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_view_chooser_cover, (android.view.ViewGroup) null);
        this.mView = inflate;
        addView(inflate);
        this.mFlThumblinebar = (android.widget.FrameLayout) findViewById(com.aliyun.svideo.editor.R.id.fl_thumblinebar);
        this.mCancel = (android.widget.ImageView) findViewById(com.aliyun.svideo.editor.R.id.cancel);
        this.mTvEffectTitle = (android.widget.TextView) findViewById(com.aliyun.svideo.editor.R.id.tv_effect_title);
        this.mIvEffectIcon = (android.widget.ImageView) findViewById(com.aliyun.svideo.editor.R.id.iv_effect_icon);
        this.mComplete = (android.widget.ImageView) findViewById(com.aliyun.svideo.editor.R.id.complete);
        this.mIvEffectIcon.setImageResource(com.aliyun.svideo.editor.R.mipmap.alivc_svideo_icon_cover);
        this.mTvEffectTitle.setText(com.aliyun.svideo.editor.R.string.alivc_editor_effect_cover);
        this.mComplete.setOnClickListener(this);
        this.mCancel.setOnClickListener(this);
    }

    @Override // com.aliyun.svideo.editor.effects.control.BaseChooser
    public boolean isPlayerNeedZoom() {
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.isFirstShow) {
            android.view.View inflate = android.view.LayoutInflater.from(getContext()).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_view_tip_first_show, (android.view.ViewGroup) null, false);
            ((android.widget.TextView) inflate.findViewById(com.aliyun.svideo.editor.R.id.alivc_svideo_tip_first)).setText(com.aliyun.svideo.editor.R.string.alivc_editor_dialog_cover_tip_applay);
            android.widget.PopupWindow popupWindow = new android.widget.PopupWindow(inflate, -2, -2, true);
            popupWindow.setContentView(inflate);
            popupWindow.setOutsideTouchable(true);
            popupWindow.setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(0));
            int dip2px = 0 - com.aliyun.svideo.common.utils.DensityUtils.dip2px(getContext(), 80.0f);
            popupWindow.showAsDropDown(this.mFlThumblinebar, com.aliyun.svideo.common.utils.DensityUtils.dip2px(getContext(), 5.0f), dip2px);
            this.isFirstShow = false;
        }
    }

    @Override // com.aliyun.svideo.editor.effects.control.BaseChooser
    public void onBackPressed() {
        com.aliyun.svideo.editor.effects.control.OnEffectActionLister onEffectActionLister = this.mOnEffectActionLister;
        if (onEffectActionLister != null) {
            onEffectActionLister.onCancel();
        }
    }

    @Override // android.view.View.OnClickListener
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onClick(android.view.View view) {
        if (view == this.mComplete) {
            com.aliyun.svideo.editor.effects.control.OnEffectActionLister onEffectActionLister = this.mOnEffectActionLister;
            if (onEffectActionLister != null) {
                onEffectActionLister.onComplete();
            }
        } else if (view == this.mCancel) {
            onBackPressed();
        }
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void setFirstShow(boolean z) {
        this.isFirstShow = z;
    }
}
