package com.aliyun.svideo.editor.editor;

/* loaded from: classes12.dex */
public class PasterUICompoundCaptionImpl extends com.aliyun.svideo.editor.editor.AliyunBasePasterController implements com.aliyun.svideo.editor.effects.caption.listener.OnCaptionChooserStateChangeListener {
    private static final java.lang.String TAG = "com.aliyun.svideo.editor.editor.PasterUICompoundCaptionImpl";
    protected boolean isEditStarted;
    private com.aliyun.svideosdk.editor.AliyunPasterManager mAliyunPasterManager;
    private com.aliyun.svideo.editor.widget.AliyunPasterCaptionBorderView mCaptionBorderView;
    private com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption mController;
    private int mControllerId;
    protected com.aliyun.svideosdk.common.struct.effect.ActionBase mFrameAction;
    private int mFrameActionSelect;
    private com.aliyun.svideo.editor.view.IAlivcEditView mIAliEditView;
    private boolean mIsInvert;
    protected com.aliyun.svideosdk.common.struct.effect.ActionBase mOldFrameAction;
    protected com.aliyun.svideosdk.common.struct.effect.ActionBase mTempFrameAction;
    protected com.aliyun.svideo.editor.editor.thumblinebar.OverlayThumbLineBar mThumbLBar;
    protected com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay mThumbLineOverlay;
    protected java.util.Map<java.lang.Integer, com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay> lineOverlayMap = new java.util.HashMap();
    private final android.view.View.OnClickListener mOnBorderClickListner = new com.aliyun.svideo.editor.editor.PasterUICompoundCaptionImpl.AnonymousClass1();
    private final android.graphics.PointF pasterPostionPointF = new android.graphics.PointF();
    private final com.aliyun.svideo.editor.widget.AliyunPasterCaptionBorderView.OnCaptionControllerChangeListener mOnBorderChangeListener = new com.aliyun.svideo.editor.editor.PasterUICompoundCaptionImpl.AnonymousClass2();
    private com.aliyun.svideo.editor.effects.caption.listener.OnVideoUpdateDurationListener mVideoUpdateDurationListener = new com.aliyun.svideo.editor.editor.PasterUICompoundCaptionImpl.AnonymousClass3();

    /* renamed from: com.aliyun.svideo.editor.editor.PasterUICompoundCaptionImpl$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            java.lang.Object tag = view.getTag();
            if (tag instanceof java.lang.Integer) {
                java.lang.Integer num = (java.lang.Integer) tag;
                if (num.intValue() == 0) {
                    com.aliyun.svideo.editor.editor.PasterUICompoundCaptionImpl.this.removePaster();
                } else if (num.intValue() == 1 && com.aliyun.svideo.editor.editor.PasterUICompoundCaptionImpl.this.mCaptionBorderView != null) {
                    com.aliyun.svideo.editor.editor.PasterUICompoundCaptionImpl.this.mirrorPaster(!com.aliyun.svideo.editor.editor.PasterUICompoundCaptionImpl.this.mCaptionBorderView.isMirror());
                }
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.editor.PasterUICompoundCaptionImpl$2, reason: invalid class name */
    public class AnonymousClass2 implements com.aliyun.svideo.editor.widget.AliyunPasterCaptionBorderView.OnCaptionControllerChangeListener {
        public AnonymousClass2() {
        }

        @Override // com.aliyun.svideo.editor.widget.AliyunPasterCaptionBorderView.OnCaptionControllerChangeListener
        public void onControllerChanged(float f, float[] fArr, int i, int i2, int i3, int i4) {
            if (com.aliyun.svideo.editor.editor.PasterUICompoundCaptionImpl.this.mController == null || com.aliyun.svideo.editor.editor.PasterUICompoundCaptionImpl.this.mIAliEditView == null) {
                return;
            }
            com.aliyun.svideo.editor.editor.PasterUICompoundCaptionImpl.this.pasterPostionPointF.x = (i + i3) >> 1;
            com.aliyun.svideo.editor.editor.PasterUICompoundCaptionImpl.this.pasterPostionPointF.y = (i2 + i4) >> 1;
            com.aliyun.svideo.editor.effects.caption.manager.CaptionManager.applyCaptionBorderChanged(com.aliyun.svideo.editor.editor.PasterUICompoundCaptionImpl.this.mController, -f, fArr, com.aliyun.svideo.editor.editor.PasterUICompoundCaptionImpl.this.pasterPostionPointF);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.editor.PasterUICompoundCaptionImpl$3, reason: invalid class name */
    public class AnonymousClass3 implements com.aliyun.svideo.editor.effects.caption.listener.OnVideoUpdateDurationListener {
        public AnonymousClass3() {
        }

        @Override // com.aliyun.svideo.editor.effects.caption.listener.OnVideoUpdateDurationListener
        public void onUpdateDuration(long j) {
            if (com.aliyun.svideo.editor.editor.PasterUICompoundCaptionImpl.this.mController != null) {
                com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption aliyunPasterControllerCompoundCaption = com.aliyun.svideo.editor.editor.PasterUICompoundCaptionImpl.this.mController;
                java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.MILLISECONDS;
                long startTime = (aliyunPasterControllerCompoundCaption.getStartTime(timeUnit) + com.aliyun.svideo.editor.editor.PasterUICompoundCaptionImpl.this.mController.getDuration(timeUnit)) - 100;
                com.aliyun.svideo.editor.view.AlivcEditView alivcEditView = com.aliyun.svideo.editor.editor.PasterUICompoundCaptionImpl.this.mIAliEditView.getAlivcEditView();
                com.aliyun.svideosdk.editor.AliyunIEditor aliyunIEditor = com.aliyun.svideo.editor.editor.PasterUICompoundCaptionImpl.this.mIAliEditView.getAliyunIEditor();
                if (aliyunIEditor != null) {
                    long currentPlayPosition = aliyunIEditor.getPlayerController().getCurrentPlayPosition();
                    java.lang.String unused = com.aliyun.svideo.editor.editor.PasterUICompoundCaptionImpl.TAG;
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("UpdateDuration: ");
                    sb.append(currentPlayPosition);
                    sb.append("   duration:");
                    sb.append(j);
                    sb.append("  endTime:");
                    sb.append(startTime);
                    if (currentPlayPosition > startTime) {
                        alivcEditView.playingPause();
                        aliyunIEditor.seek(com.aliyun.svideo.editor.editor.PasterUICompoundCaptionImpl.this.mController.getStartTime(timeUnit), timeUnit);
                        com.aliyun.svideo.editor.editor.PasterUICompoundCaptionImpl.this.mIAliEditView.removeVideoUpdateListener(com.aliyun.svideo.editor.editor.PasterUICompoundCaptionImpl.this.mVideoUpdateDurationListener);
                    }
                }
            }
        }
    }

    /* renamed from: com.aliyun.svideo.editor.editor.PasterUICompoundCaptionImpl$4, reason: invalid class name */
    public class AnonymousClass4 implements com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.ThumbLineOverlayView {
        private final android.view.View rootView;

        public AnonymousClass4() {
            this.rootView = android.view.LayoutInflater.from(com.aliyun.svideo.editor.editor.PasterUICompoundCaptionImpl.this.mThumbLBar.getContext()).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_view_timeline_overlay, (android.view.ViewGroup) null);
        }

        @Override // com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.ThumbLineOverlayView
        public android.view.ViewGroup getContainer() {
            return (android.view.ViewGroup) this.rootView;
        }

        @Override // com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.ThumbLineOverlayView
        public android.view.View getHeadView() {
            return this.rootView.findViewById(com.aliyun.svideo.editor.R.id.head_view);
        }

        @Override // com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.ThumbLineOverlayView
        public android.view.View getMiddleView() {
            return this.rootView.findViewById(com.aliyun.svideo.editor.R.id.middle_view);
        }

        @Override // com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.ThumbLineOverlayView
        public android.view.View getTailView() {
            return this.rootView.findViewById(com.aliyun.svideo.editor.R.id.tail_view);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.editor.PasterUICompoundCaptionImpl$5, reason: invalid class name */
    public class AnonymousClass5 implements com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.OnSelectedDurationChangeListener {
        public AnonymousClass5() {
        }

        @Override // com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.OnSelectedDurationChangeListener
        public void onDurationChange(long j, long j2, long j3) {
            com.aliyun.svideo.editor.effects.caption.manager.CaptionManager.applyDurationChanged(com.aliyun.svideo.editor.editor.PasterUICompoundCaptionImpl.this.mController, j, j3);
        }
    }

    private void adjustBorder() {
        android.view.View sufaceView;
        com.aliyun.svideo.editor.bean.AlivcCaptionBorderBean captionSize;
        com.aliyun.svideo.editor.view.IAlivcEditView iAlivcEditView = this.mIAliEditView;
        if (iAlivcEditView == null || this.mCaptionBorderView == null || (sufaceView = iAlivcEditView.getSufaceView()) == null || (captionSize = com.aliyun.svideo.editor.effects.caption.manager.CaptionManager.getCaptionSize(sufaceView.getLayoutParams(), this.mController)) == null) {
            return;
        }
        this.mCaptionBorderView.bind(captionSize, this.mOnBorderChangeListener);
    }

    @Override // com.aliyun.svideo.editor.editor.AliyunBasePasterController
    public boolean canDrag() {
        com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption aliyunPasterControllerCompoundCaption = this.mController;
        if (aliyunPasterControllerCompoundCaption == null) {
            return super.canDrag();
        }
        java.util.List<com.aliyun.svideosdk.common.struct.effect.ActionBase> frameAnimations = aliyunPasterControllerCompoundCaption.getFrameAnimations();
        return frameAnimations == null || frameAnimations.size() == 0;
    }

    @Override // com.aliyun.svideo.editor.editor.AliyunBasePasterController
    public boolean contentContains(float f, float f2) {
        com.aliyun.svideo.editor.widget.AliyunPasterCaptionBorderView aliyunPasterCaptionBorderView = this.mCaptionBorderView;
        if (aliyunPasterCaptionBorderView != null) {
            return aliyunPasterCaptionBorderView.contentContains(f, f2);
        }
        return false;
    }

    @Override // com.aliyun.svideo.editor.editor.AliyunBasePasterController
    public void editTimeCompleted() {
        if (this.mController == null) {
            return;
        }
        com.aliyun.svideo.editor.widget.AliyunPasterCaptionBorderView aliyunPasterCaptionBorderView = this.mCaptionBorderView;
        if (aliyunPasterCaptionBorderView != null) {
            aliyunPasterCaptionBorderView.setVisibility(8);
        }
        com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay thumbLineOverlay = this.mThumbLineOverlay;
        if (thumbLineOverlay != null) {
            thumbLineOverlay.switchState((byte) 2);
        }
        hideTextEdit();
        if (android.text.TextUtils.isEmpty(this.mController.getText())) {
            removePaster();
        }
        this.isEditStarted = false;
    }

    @Override // com.aliyun.svideo.editor.editor.AliyunBasePasterController
    public void editTimeStart() {
        if (this.mController != null) {
            com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay thumbLineOverlay = this.lineOverlayMap.get(java.lang.Integer.valueOf(this.mControllerId));
            this.mThumbLineOverlay = thumbLineOverlay;
            if (thumbLineOverlay != null) {
                thumbLineOverlay.switchState((byte) 1);
            }
        }
        this.isEditStarted = true;
    }

    @Override // com.aliyun.svideo.editor.effects.caption.listener.OnCaptionChooserStateChangeListener
    public com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption getAliyunPasterController() {
        return getController();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterBaseView
    public android.graphics.Bitmap getBackgroundBitmap() {
        return null;
    }

    public com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption getController() {
        return this.mController;
    }

    @Override // com.aliyun.svideo.editor.editor.AliyunBasePasterController
    public com.aliyun.svideo.editor.effects.control.UIEditorPage getEditorPage() {
        return com.aliyun.svideo.editor.effects.control.UIEditorPage.COMPOUND_CAPTION;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterBaseView
    public int getPasterCenterX() {
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterBaseView
    public int getPasterCenterY() {
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterBaseView
    public int getPasterHeight() {
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterBaseView
    public float getPasterRotation() {
        return 0.0f;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterBaseView
    public java.lang.String getPasterTextFont() {
        return null;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterBaseView
    public com.aliyun.svideosdk.common.struct.project.Source getPasterTextFontSource() {
        return null;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterBaseView
    public int getPasterTextHeight() {
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterBaseView
    public int getPasterTextOffsetX() {
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterBaseView
    public int getPasterTextOffsetY() {
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterBaseView
    public float getPasterTextRotation() {
        return 0.0f;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterBaseView
    public int getPasterTextWidth() {
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterBaseView
    public android.view.View getPasterView() {
        return this.mCaptionBorderView;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterBaseView
    public int getPasterWidth() {
        return 0;
    }

    public android.view.ViewGroup getRootView() {
        com.aliyun.svideo.editor.view.IAlivcEditView iAlivcEditView = this.mIAliEditView;
        if (iAlivcEditView != null) {
            return iAlivcEditView.getAlivcEditView();
        }
        return null;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterBaseView
    public java.lang.String getText() {
        return null;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterBaseView
    public android.text.Layout.Alignment getTextAlign() {
        return null;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterBaseView
    public int getTextBgLabelColor() {
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterBaseView
    public int getTextColor() {
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterBaseView
    public int getTextFixSize() {
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterBaseView
    public int getTextMaxLines() {
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterBaseView
    public int getTextPaddingX() {
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterBaseView
    public int getTextPaddingY() {
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterBaseView
    public int getTextStrokeColor() {
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterBaseView
    public android.view.View getTextView() {
        return null;
    }

    public void hideCaptionBorderView() {
        com.aliyun.svideo.editor.widget.AliyunPasterCaptionBorderView aliyunPasterCaptionBorderView = this.mCaptionBorderView;
        if (aliyunPasterCaptionBorderView != null) {
            aliyunPasterCaptionBorderView.setVisibility(8);
        }
    }

    @Override // com.aliyun.svideo.editor.editor.AliyunBasePasterController
    public void hideOverlayView() {
        com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay thumbLineOverlay = this.mThumbLineOverlay;
        if (thumbLineOverlay != null) {
            thumbLineOverlay.getOverlayView().setVisibility(8);
        }
    }

    public void hideTextEdit() {
        com.aliyun.svideo.editor.effects.caption.component.CaptionEditorPanelView findCaptionEditorPanelView = com.aliyun.svideo.editor.effects.caption.manager.AlivcEditorViewFactory.findCaptionEditorPanelView(getRootView());
        if (findCaptionEditorPanelView != null) {
            findCaptionEditorPanelView.setVisibility(8);
        }
    }

    @Override // com.aliyun.svideo.editor.editor.AliyunBasePasterController
    public boolean isAddedAnimation() {
        java.util.List<com.aliyun.svideosdk.common.struct.effect.ActionBase> frameAnimations;
        com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption aliyunPasterControllerCompoundCaption = this.mController;
        return (aliyunPasterControllerCompoundCaption == null || (frameAnimations = aliyunPasterControllerCompoundCaption.getFrameAnimations()) == null || frameAnimations.size() <= 0) ? false : true;
    }

    @Override // com.aliyun.svideo.editor.editor.AliyunBasePasterController
    public boolean isEditCompleted() {
        return !this.isEditStarted;
    }

    @Override // com.aliyun.svideo.editor.effects.caption.listener.OnCaptionChooserStateChangeListener
    public boolean isInvert() {
        return this.mIsInvert;
    }

    @Override // com.aliyun.svideo.editor.editor.AliyunBasePasterController
    public boolean isPasterExists() {
        return true;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterBaseView
    public boolean isPasterMirrored() {
        com.aliyun.svideo.editor.widget.AliyunPasterCaptionBorderView aliyunPasterCaptionBorderView = this.mCaptionBorderView;
        return aliyunPasterCaptionBorderView != null && aliyunPasterCaptionBorderView.isMirror();
    }

    @Override // com.aliyun.svideo.editor.editor.AliyunBasePasterController
    public boolean isPasterRemoved() {
        return false;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterBaseView
    public boolean isTextHasLabel() {
        return false;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterBaseView
    public boolean isTextHasStroke() {
        return false;
    }

    @Override // com.aliyun.svideo.editor.editor.AliyunBasePasterController
    public boolean isVisibleInTime(long j) {
        com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption aliyunPasterControllerCompoundCaption = this.mController;
        if (aliyunPasterControllerCompoundCaption == null) {
            return false;
        }
        java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.MILLISECONDS;
        long startTime = aliyunPasterControllerCompoundCaption.getStartTime(timeUnit);
        return j >= startTime && j <= startTime + this.mController.getDuration(timeUnit);
    }

    public void mirrorPaster(boolean z) {
        com.aliyun.svideo.editor.widget.AliyunPasterCaptionBorderView aliyunPasterCaptionBorderView = this.mCaptionBorderView;
        if (aliyunPasterCaptionBorderView != null) {
            aliyunPasterCaptionBorderView.setMirror(z);
        }
    }

    @Override // com.aliyun.svideo.editor.editor.AliyunBasePasterController
    public void moveContent(float f, float f2) {
        com.aliyun.svideo.editor.widget.AliyunPasterCaptionBorderView aliyunPasterCaptionBorderView = this.mCaptionBorderView;
        if (aliyunPasterCaptionBorderView != null) {
            aliyunPasterCaptionBorderView.moveContent(f, f2);
        }
    }

    @Override // com.aliyun.svideo.editor.editor.AliyunBasePasterController
    public void moveToCenter() {
    }

    @Override // com.aliyun.svideo.editor.effects.caption.listener.OnCaptionChooserStateChangeListener
    public void onBubbleEffectTemplateChanged(com.aliyun.svideosdk.common.struct.project.Source source, com.aliyun.svideosdk.common.struct.project.Source source2) {
        com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption aliyunPasterControllerCompoundCaption = this.mController;
        java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.MILLISECONDS;
        long duration = aliyunPasterControllerCompoundCaption.getDuration(timeUnit);
        com.aliyun.svideo.editor.effects.caption.manager.CaptionManager.applyBubbleEffectTemplateChanged(this.mController, source);
        com.aliyun.svideo.editor.effects.caption.manager.CaptionManager.applyCaptionTextFontTtfChanged(this.mController, source2);
        adjustBorder();
        com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption aliyunPasterControllerCompoundCaption2 = this.mController;
        com.aliyun.svideo.editor.effects.caption.manager.CaptionManager.applyDurationChanged(aliyunPasterControllerCompoundCaption2, aliyunPasterControllerCompoundCaption2.getStartTime(timeUnit), duration);
        if (this.mIAliEditView == null || source == null || source.getPath() == null) {
            return;
        }
        this.mIAliEditView.addVideoUpdateListener(this.mVideoUpdateDurationListener);
        com.aliyun.svideo.editor.view.AlivcEditView alivcEditView = this.mIAliEditView.getAlivcEditView();
        com.aliyun.svideosdk.editor.AliyunIEditor aliyunIEditor = this.mIAliEditView.getAliyunIEditor();
        if (alivcEditView != null) {
            alivcEditView.playingPause();
            aliyunIEditor.seek(this.mController.getStartTime(timeUnit), timeUnit);
            alivcEditView.playingResume();
        }
    }

    @Override // com.aliyun.svideo.editor.effects.caption.listener.OnCaptionChooserStateChangeListener
    public void onCaptionCancel() {
    }

    @Override // com.aliyun.svideo.editor.effects.caption.listener.OnCaptionChooserStateChangeListener
    public void onCaptionConfirm() {
        editTimeCompleted();
    }

    @Override // com.aliyun.svideo.editor.effects.caption.listener.OnCaptionChooserStateChangeListener
    public void onCaptionFrameAnimation(int i) {
        android.view.View contentView = this.mCaptionBorderView.getContentView();
        int left = contentView.getLeft();
        int top = contentView.getTop();
        int width = left + (contentView.getWidth() / 2);
        int height = top + (contentView.getHeight() / 2);
        android.view.ViewGroup.LayoutParams layoutParams = this.mIAliEditView.getSufaceView().getLayoutParams();
        com.aliyun.svideo.editor.effects.caption.manager.CaptionManager.applyCaptionFrameAnimation(this.mIAliEditView, this.mController, com.aliyun.svideo.editor.util.CaptionFrameAnimationUtil.createAction(this.mCaptionBorderView.getContext(), i, this.mController.getDuration(), this.mController.getStartTime(), layoutParams.width, layoutParams.height, width, height));
    }

    @Override // com.aliyun.svideo.editor.effects.caption.listener.OnCaptionChooserStateChangeListener
    public void onCaptionTextAlignmentChanged(int i) {
        com.aliyun.svideo.editor.effects.caption.manager.CaptionManager.applyCaptionTextAlignmentChanged(this.mController, i);
    }

    @Override // com.aliyun.svideo.editor.effects.caption.listener.OnCaptionChooserStateChangeListener
    public void onCaptionTextBackgroundColorChanged(com.aliyun.svideosdk.common.AliyunColor aliyunColor) {
        com.aliyun.svideo.editor.effects.caption.manager.CaptionManager.applyCaptionTextBackgroundColorChanged(this.mController, aliyunColor);
    }

    @Override // com.aliyun.svideo.editor.effects.caption.listener.OnCaptionChooserStateChangeListener
    public void onCaptionTextBackgroundCornerRadiusChanged(int i) {
        com.aliyun.svideo.editor.effects.caption.manager.CaptionManager.applyCaptionTextBackgroundCornerRadiusChanged(this.mController, com.aliyun.common.utils.DensityUtil.sp2px(i));
    }

    @Override // com.aliyun.svideo.editor.effects.caption.listener.OnCaptionChooserStateChangeListener
    public void onCaptionTextChanged(java.lang.String str) {
        com.aliyun.svideo.editor.effects.caption.manager.CaptionManager.applyCaptionTextChanged(this.mController, str);
        if (this.mCaptionBorderView != null) {
            android.graphics.RectF captionRectF = com.aliyun.svideo.editor.effects.caption.manager.CaptionManager.getCaptionRectF(this.mIAliEditView.getSufaceView().getLayoutParams(), this.mController);
            android.view.View contentView = this.mCaptionBorderView.getContentView();
            android.view.ViewGroup.LayoutParams layoutParams = contentView.getLayoutParams();
            layoutParams.width = (int) captionRectF.width();
            layoutParams.height = (int) captionRectF.height();
            contentView.setLayoutParams(layoutParams);
        }
    }

    @Override // com.aliyun.svideo.editor.effects.caption.listener.OnCaptionChooserStateChangeListener
    public void onCaptionTextColorChanged(com.aliyun.svideosdk.common.AliyunColor aliyunColor) {
        com.aliyun.svideo.editor.effects.caption.manager.CaptionManager.applyCaptionTextColorChanged(this.mController, aliyunColor);
    }

    @Override // com.aliyun.svideo.editor.effects.caption.listener.OnCaptionChooserStateChangeListener
    public void onCaptionTextFontTtfChanged(com.aliyun.svideosdk.common.struct.project.Source source) {
        com.aliyun.svideo.editor.effects.caption.manager.CaptionManager.applyCaptionTextFontTtfChanged(this.mController, source);
    }

    @Override // com.aliyun.svideo.editor.effects.caption.listener.OnCaptionChooserStateChangeListener
    public void onCaptionTextFontTypeFaceChanged(com.aliyun.svideosdk.common.AliyunTypeface aliyunTypeface) {
        com.aliyun.svideo.editor.effects.caption.manager.CaptionManager.applyCaptionTextFontTypeFaceChanged(this.mController, aliyunTypeface);
    }

    @Override // com.aliyun.svideo.editor.effects.caption.listener.OnCaptionChooserStateChangeListener
    public void onCaptionTextShandowColorChanged(com.aliyun.svideosdk.common.AliyunColor aliyunColor) {
        com.aliyun.svideo.editor.effects.caption.manager.CaptionManager.applyCaptionTextShandowColorChanged(this.mController, aliyunColor);
    }

    @Override // com.aliyun.svideo.editor.effects.caption.listener.OnCaptionChooserStateChangeListener
    public void onCaptionTextShandowOffsetChanged(android.graphics.PointF pointF) {
        com.aliyun.svideo.editor.effects.caption.manager.CaptionManager.applyCaptionTextShandowOffsetChanged(this.mController, pointF);
    }

    @Override // com.aliyun.svideo.editor.effects.caption.listener.OnCaptionChooserStateChangeListener
    public void onCaptionTextStrokeColorChanged(com.aliyun.svideosdk.common.AliyunColor aliyunColor) {
        com.aliyun.svideo.editor.effects.caption.manager.CaptionManager.applyCaptionTextStrokeColorChanged(this.mController, aliyunColor);
    }

    @Override // com.aliyun.svideo.editor.effects.caption.listener.OnCaptionChooserStateChangeListener
    public void onCaptionTextStrokeWidthChanged(int i) {
        com.aliyun.svideo.editor.effects.caption.manager.CaptionManager.applyCaptionTextStrokeWidthChanged(this.mController, i);
    }

    @Override // com.aliyun.svideo.editor.effects.caption.listener.OnCaptionChooserStateChangeListener
    public void onFontEffectTemplateChanged(com.aliyun.svideosdk.common.struct.project.Source source) {
        com.aliyun.svideo.editor.effects.caption.manager.CaptionManager.applyFontEffectTemplateChanged(this.mController, source);
    }

    @Override // com.aliyun.svideo.editor.editor.AliyunBasePasterController
    public void removePaster() {
        com.aliyun.svideo.editor.effects.caption.manager.CaptionManager.removeCaption(this.mAliyunPasterManager, this.mController);
        hideTextEdit();
        com.aliyun.svideo.editor.widget.AliyunPasterCaptionBorderView aliyunPasterCaptionBorderView = this.mCaptionBorderView;
        if (aliyunPasterCaptionBorderView != null) {
            aliyunPasterCaptionBorderView.setVisibility(8);
        }
        this.lineOverlayMap.remove(java.lang.Integer.valueOf(this.mControllerId));
        com.aliyun.svideo.editor.editor.thumblinebar.OverlayThumbLineBar overlayThumbLineBar = this.mThumbLBar;
        if (overlayThumbLineBar != null) {
            overlayThumbLineBar.removeOverlay(this.mThumbLineOverlay);
        }
    }

    @Override // com.aliyun.svideo.editor.editor.AliyunBasePasterController
    public void setOnlyApplyUI(boolean z) {
    }

    @Override // com.aliyun.svideo.editor.editor.AliyunBasePasterController
    public void setPasterViewVisibility(int i) {
        com.aliyun.svideo.editor.widget.AliyunPasterCaptionBorderView aliyunPasterCaptionBorderView = this.mCaptionBorderView;
        if (aliyunPasterCaptionBorderView != null) {
            aliyunPasterCaptionBorderView.setVisibility(i);
        }
    }

    public void showCaptionBorderView(android.view.ViewGroup viewGroup, android.view.View view) {
        if (this.mController == null || view == null) {
            return;
        }
        com.aliyun.svideo.editor.widget.AliyunPasterCaptionBorderView obtainCaptionBorderView = com.aliyun.svideo.editor.effects.caption.manager.AlivcEditorViewFactory.obtainCaptionBorderView(viewGroup);
        this.mCaptionBorderView = obtainCaptionBorderView;
        if (obtainCaptionBorderView != null) {
            this.mCaptionBorderView.bind(com.aliyun.svideo.editor.effects.caption.manager.CaptionManager.getCaptionSize(view.getLayoutParams(), this.mController), this.mOnBorderChangeListener);
            this.mCaptionBorderView.setTag(this);
            android.view.View findViewById = this.mCaptionBorderView.findViewById(com.aliyun.svideo.editor.R.id.qupai_btn_edit_overlay_cancel);
            if (findViewById != null) {
                findViewById.setTag(0);
                findViewById.setOnClickListener(this.mOnBorderClickListner);
            }
            android.view.View findViewById2 = this.mCaptionBorderView.findViewById(com.aliyun.svideo.editor.R.id.qupai_btn_edit_overlay_mirror);
            if (findViewById2 != null) {
                findViewById2.setTag(1);
                findViewById2.setOnClickListener(this.mOnBorderClickListner);
            }
        }
    }

    public void showTextEdit() {
        com.aliyun.svideo.editor.effects.caption.component.CaptionEditorPanelView obtainCaptionEditorPanelView = com.aliyun.svideo.editor.effects.caption.manager.AlivcEditorViewFactory.obtainCaptionEditorPanelView(getRootView(), this);
        if (obtainCaptionEditorPanelView != null) {
            obtainCaptionEditorPanelView.refreshData();
            obtainCaptionEditorPanelView.bringToFront();
            obtainCaptionEditorPanelView.setVisibility(0);
        }
    }

    @Override // com.aliyun.svideo.editor.editor.AliyunBasePasterController
    public void showTextEdit(boolean z) {
        this.mIsInvert = z;
        showTextEdit();
    }

    @Override // com.aliyun.svideo.editor.editor.AliyunBasePasterController
    public void showTimeEdit() {
        if (this.mThumbLBar == null || this.mController == null) {
            return;
        }
        com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay thumbLineOverlay = this.lineOverlayMap.get(java.lang.Integer.valueOf(this.mControllerId));
        this.mThumbLineOverlay = thumbLineOverlay;
        if (thumbLineOverlay == null) {
            com.aliyun.svideo.editor.editor.PasterUICompoundCaptionImpl.AnonymousClass4 anonymousClass4 = new com.aliyun.svideo.editor.editor.PasterUICompoundCaptionImpl.AnonymousClass4();
            com.aliyun.svideo.editor.editor.thumblinebar.OverlayThumbLineBar overlayThumbLineBar = this.mThumbLBar;
            com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption aliyunPasterControllerCompoundCaption = this.mController;
            java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.MILLISECONDS;
            this.mThumbLineOverlay = overlayThumbLineBar.addOverlay(aliyunPasterControllerCompoundCaption.getStartTime(timeUnit), this.mController.getDuration(timeUnit), anonymousClass4, 500L, false, com.aliyun.svideo.editor.effects.control.UIEditorPage.COMPOUND_CAPTION, new com.aliyun.svideo.editor.editor.PasterUICompoundCaptionImpl.AnonymousClass5());
            this.lineOverlayMap.put(java.lang.Integer.valueOf(this.mControllerId), this.mThumbLineOverlay);
        }
        this.mThumbLineOverlay.switchState((byte) 1);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterBaseView
    public android.graphics.Bitmap transToImage() {
        return null;
    }

    public void updateParams(com.aliyun.svideo.editor.view.IAlivcEditView iAlivcEditView, com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption aliyunPasterControllerCompoundCaption, com.aliyun.svideosdk.editor.AliyunPasterManager aliyunPasterManager, com.aliyun.svideo.editor.editor.thumblinebar.OverlayThumbLineBar overlayThumbLineBar) {
        this.mIAliEditView = iAlivcEditView;
        this.mController = aliyunPasterControllerCompoundCaption;
        this.mControllerId = java.lang.System.identityHashCode(aliyunPasterControllerCompoundCaption);
        this.mAliyunPasterManager = aliyunPasterManager;
        this.mThumbLBar = overlayThumbLineBar;
    }
}
