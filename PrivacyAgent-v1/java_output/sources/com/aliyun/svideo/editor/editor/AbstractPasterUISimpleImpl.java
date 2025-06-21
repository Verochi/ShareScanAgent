package com.aliyun.svideo.editor.editor;

/* loaded from: classes12.dex */
public abstract class AbstractPasterUISimpleImpl extends com.aliyun.svideo.editor.editor.AliyunBasePasterController {
    private static final java.lang.String TAG = "com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl";
    protected com.aliyun.svideosdk.editor.pplayer.AnimPlayerView animPlayerView;
    private boolean isDeleted;
    protected boolean isEditStarted;
    private float mCenterX;
    private float mCenterY;
    public com.aliyun.svideosdk.editor.AliyunPasterController mController;
    protected com.aliyun.svideo.editor.effects.control.UIEditorPage mEditorPage;
    protected com.aliyun.svideosdk.common.struct.effect.ActionBase mFrameAction;
    protected boolean mMoveDelay;
    protected com.aliyun.svideosdk.common.struct.effect.ActionBase mOldFrameAction;
    public com.aliyun.svideo.editor.widget.BaseAliyunPasterView mPasterView;
    protected com.aliyun.svideosdk.common.struct.effect.ActionBase mTempFrameAction;
    protected com.aliyun.svideo.editor.widget.AutoResizingTextView mText;
    protected com.aliyun.svideo.editor.editor.thumblinebar.OverlayThumbLineBar mThumbLBar;
    protected com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay mThumbLineOverlay;
    private float[] originalCenter;
    private int mFrameActionSelect = -1;
    private boolean isFirstTouch = true;

    /* renamed from: com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnTouchListener {
        private float mLastX;
        private float mLastY;

        public AnonymousClass1() {
        }

        private void update(float f, float f2) {
            android.view.View contentView = com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl.this.mPasterView.getContentView();
            float left = contentView.getLeft() + (contentView.getWidth() / 2);
            float top = contentView.getTop() + (contentView.getHeight() / 2);
            float f3 = f - left;
            float f4 = f2 - top;
            float length = android.graphics.PointF.length(f3, f4) / java.lang.Math.max(android.graphics.PointF.length(this.mLastX - left, this.mLastY - top), android.graphics.PointF.length(contentView.getWidth() / 2, contentView.getHeight() / 2));
            float atan2 = (float) (java.lang.Math.atan2(f4, f3) - java.lang.Math.atan2(this.mLastY - top, this.mLastX - left));
            if (java.lang.Float.isInfinite(length) || java.lang.Float.isNaN(length) || java.lang.Float.isInfinite(atan2) || java.lang.Float.isNaN(atan2)) {
                return;
            }
            this.mLastX = f;
            this.mLastY = f2;
            com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl.this.mPasterView.scaleContent(length, length);
            com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl abstractPasterUISimpleImpl = com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl.this;
            abstractPasterUISimpleImpl.mPasterView.rotateContent(atan2, abstractPasterUISimpleImpl.mCenterX, com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl.this.mCenterY);
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                if (com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl.this.isFirstTouch) {
                    float height = com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl.this.mPasterView.getHeight() / 2;
                    float[] fArr = {com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl.this.mPasterView.getWidth() / 2, height};
                    if (fArr[0] != 0.0f && height != 0.0f) {
                        com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl.this.originalCenter = fArr;
                        com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl.this.isFirstTouch = false;
                    }
                }
                this.mLastX = view.getLeft() + motionEvent.getX();
                this.mLastY = view.getTop() + motionEvent.getY();
                float[] center = com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl.this.mPasterView.getCenter();
                com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl abstractPasterUISimpleImpl = com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl.this;
                abstractPasterUISimpleImpl.mCenterX = center[0] - abstractPasterUISimpleImpl.originalCenter[0];
                com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl abstractPasterUISimpleImpl2 = com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl.this;
                abstractPasterUISimpleImpl2.mCenterY = center[1] - abstractPasterUISimpleImpl2.originalCenter[1];
            } else if (actionMasked == 2) {
                update(view.getLeft() + motionEvent.getX(), view.getTop() + motionEvent.getY());
            }
            return true;
        }
    }

    /* renamed from: com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl$2, reason: invalid class name */
    public class AnonymousClass2 implements android.view.View.OnTouchListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
            if (motionEvent.getActionMasked() == 0 && com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl.this.isFirstTouch) {
                com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl abstractPasterUISimpleImpl = com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl.this;
                abstractPasterUISimpleImpl.originalCenter = abstractPasterUISimpleImpl.mPasterView.getCenter();
                com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl.this.isFirstTouch = false;
            }
            return false;
        }
    }

    /* renamed from: com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl$3, reason: invalid class name */
    public class AnonymousClass3 implements android.view.View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl.this.removePaster();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl$4, reason: invalid class name */
    public class AnonymousClass4 implements android.view.View.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl.this.mirrorPaster(!com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl.this.mPasterView.isMirror());
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl$5, reason: invalid class name */
    public class AnonymousClass5 implements com.aliyun.svideo.editor.effects.caption.TextDialog.OnStateChangeListener {
        public AnonymousClass5() {
        }

        @Override // com.aliyun.svideo.editor.effects.caption.TextDialog.OnStateChangeListener
        public void onTextEditCompleted(com.aliyun.svideo.editor.effects.caption.TextDialog.EditTextInfo editTextInfo) {
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl.this.mPasterView.getParent();
            if (viewGroup == null) {
                return;
            }
            viewGroup.setEnabled(true);
            if (android.text.TextUtils.isEmpty(editTextInfo.text)) {
                com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl abstractPasterUISimpleImpl = com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl.this;
                if (abstractPasterUISimpleImpl.mEditorPage == com.aliyun.svideo.editor.effects.control.UIEditorPage.FONT) {
                    abstractPasterUISimpleImpl.removePaster();
                    return;
                }
            }
            com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl.this.mText.setText(editTextInfo.text);
            com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl.this.mText.setCurrentColor(editTextInfo.textColor);
            com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl.this.mText.setTextStrokeColor(editTextInfo.textStrokeColor);
            if (editTextInfo.isTextOnly) {
                com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl.this.mPasterView.setContentWidth(editTextInfo.textWidth);
                com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl.this.mPasterView.setContentHeight(editTextInfo.textHeight);
            }
            com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl.this.mText.setFontPath(editTextInfo.font);
            com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl abstractPasterUISimpleImpl2 = com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl.this;
            com.aliyun.svideosdk.common.struct.effect.ActionBase actionBase = editTextInfo.mAnimation;
            abstractPasterUISimpleImpl2.mFrameAction = actionBase;
            abstractPasterUISimpleImpl2.mTempFrameAction = actionBase;
            abstractPasterUISimpleImpl2.mFrameActionSelect = editTextInfo.mAnimationSelect;
            com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl.this.mText.setEditCompleted(true);
            com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl.this.mPasterView.setEditCompleted(true);
            com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl abstractPasterUISimpleImpl3 = com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl.this;
            if (abstractPasterUISimpleImpl3.isEditStarted) {
                abstractPasterUISimpleImpl3.mPasterView.setVisibility(0);
            }
        }
    }

    /* renamed from: com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl$6, reason: invalid class name */
    public class AnonymousClass6 implements com.aliyun.svideo.editor.effects.overlay.AnimationDialog.OnConfirmListener {
        public AnonymousClass6() {
        }

        @Override // com.aliyun.svideo.editor.effects.overlay.AnimationDialog.OnConfirmListener
        public void onCompleted(com.aliyun.svideo.editor.effects.overlay.AnimationDialog.PasterInfo pasterInfo) {
            com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl abstractPasterUISimpleImpl = com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl.this;
            com.aliyun.svideosdk.common.struct.effect.ActionBase actionBase = pasterInfo.mAnimation;
            abstractPasterUISimpleImpl.mFrameAction = actionBase;
            abstractPasterUISimpleImpl.mTempFrameAction = actionBase;
            abstractPasterUISimpleImpl.mFrameActionSelect = pasterInfo.mAnimationSelect;
        }
    }

    /* renamed from: com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl$7, reason: invalid class name */
    public class AnonymousClass7 implements com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.ThumbLineOverlayView {
        private android.view.View rootView;

        public AnonymousClass7() {
            this.rootView = android.view.LayoutInflater.from(com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl.this.mPasterView.getContext()).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_view_timeline_overlay, (android.view.ViewGroup) null);
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

    /* renamed from: com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl$8, reason: invalid class name */
    public class AnonymousClass8 implements com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.OnSelectedDurationChangeListener {
        public AnonymousClass8() {
        }

        @Override // com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay.OnSelectedDurationChangeListener
        public void onDurationChange(long j, long j2, long j3) {
            com.aliyun.svideosdk.editor.AliyunPasterController aliyunPasterController = com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl.this.mController;
            java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.MILLISECONDS;
            aliyunPasterController.setPasterStartTime(j, timeUnit);
            com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl.this.mController.setPasterDuration(j3, timeUnit);
            com.aliyun.svideosdk.editor.pplayer.AnimPlayerView animPlayerView = com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl.this.animPlayerView;
            if (animPlayerView != null) {
                animPlayerView.setPlayTime(timeUnit.toMicros(j), timeUnit.toMicros(j2));
                java.lang.String unused = com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl.TAG;
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("showTimeEdit: startTime :");
                sb.append(j);
                sb.append(" , endTime :");
                sb.append(j2);
            }
        }
    }

    public AbstractPasterUISimpleImpl(com.aliyun.svideo.editor.widget.BaseAliyunPasterView baseAliyunPasterView, com.aliyun.svideosdk.editor.AliyunPasterController aliyunPasterController, com.aliyun.svideo.editor.editor.thumblinebar.OverlayThumbLineBar overlayThumbLineBar) {
        this.mPasterView = baseAliyunPasterView;
        this.mController = aliyunPasterController;
        this.mThumbLBar = overlayThumbLineBar;
        baseAliyunPasterView.setTag(this);
        this.mController.setPasterView(this);
        android.view.View findViewById = this.mPasterView.findViewById(com.aliyun.svideo.editor.R.id.qupai_btn_edit_overlay_transform);
        if (findViewById != null) {
            findViewById.setOnTouchListener(new com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl.AnonymousClass1());
        }
        this.mPasterView.setOnTouchListener(new com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl.AnonymousClass2());
        android.view.View findViewById2 = baseAliyunPasterView.findViewById(com.aliyun.svideo.editor.R.id.qupai_btn_edit_overlay_cancel);
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(new com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl.AnonymousClass3());
        }
        android.view.View findViewById3 = baseAliyunPasterView.findViewById(com.aliyun.svideo.editor.R.id.qupai_btn_edit_overlay_mirror);
        if (findViewById3 != null) {
            findViewById3.setOnClickListener(new com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl.AnonymousClass4());
        }
        editTimeStart();
    }

    @Override // com.aliyun.svideo.editor.editor.AliyunBasePasterController
    public boolean contentContains(float f, float f2) {
        return this.mPasterView.contentContains(f, f2);
    }

    @Override // com.aliyun.svideo.editor.editor.AliyunBasePasterController
    public void editTimeCompleted() {
        if (!this.mController.isRevert() && !this.mController.isOnlyApplyUI() && this.mPasterView.getWidth() == 0 && this.mPasterView.getHeight() == 0) {
            this.mController.removePaster();
            return;
        }
        this.mPasterView.setVisibility(4);
        stopPasterEffect();
        this.mController.editCompleted();
        this.mMoveDelay = false;
        com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay thumbLineOverlay = this.mThumbLineOverlay;
        if (thumbLineOverlay != null) {
            thumbLineOverlay.switchState((byte) 2);
        }
    }

    @Override // com.aliyun.svideo.editor.editor.AliyunBasePasterController
    public void editTimeStart() {
        if (this.isEditStarted) {
            return;
        }
        this.isEditStarted = true;
        this.mPasterView.setVisibility(0);
        this.mPasterView.bringToFront();
        playPasterEffect();
        this.mController.editStart();
        com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay thumbLineOverlay = this.mThumbLineOverlay;
        if (thumbLineOverlay != null) {
            thumbLineOverlay.switchState((byte) 1);
        }
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterBaseView
    public android.graphics.Bitmap getBackgroundBitmap() {
        return null;
    }

    public com.aliyun.svideosdk.editor.AliyunPasterController getController() {
        return this.mController;
    }

    @Override // com.aliyun.svideo.editor.editor.AliyunBasePasterController
    public com.aliyun.svideo.editor.effects.control.UIEditorPage getEditorPage() {
        return this.mEditorPage;
    }

    public com.aliyun.svideosdk.common.struct.effect.EffectBase getEffect() {
        if (getController() != null) {
            return getController().getEffect();
        }
        return null;
    }

    public com.aliyun.svideosdk.common.struct.effect.ActionBase getFrameAction() {
        return this.mFrameAction;
    }

    public int getFrameSelectPosition() {
        return this.mFrameActionSelect;
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
        return this.mText.getFontPath();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterBaseView
    public com.aliyun.svideosdk.common.struct.project.Source getPasterTextFontSource() {
        return this.mText.getFontSource();
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
        return this.mPasterView;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterBaseView
    public int getPasterWidth() {
        return 0;
    }

    public com.aliyun.svideosdk.common.struct.effect.ActionBase getTempFrameAction() {
        return this.mTempFrameAction;
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
        return this.mText;
    }

    @Override // com.aliyun.svideo.editor.editor.AliyunBasePasterController
    public void hideOverlayView() {
        com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineOverlay thumbLineOverlay = this.mThumbLineOverlay;
        if (thumbLineOverlay != null) {
            thumbLineOverlay.getOverlayView().setVisibility(4);
        }
    }

    @Override // com.aliyun.svideo.editor.editor.AliyunBasePasterController
    public boolean isAddedAnimation() {
        return this.mFrameActionSelect != 0;
    }

    @Override // com.aliyun.svideo.editor.editor.AliyunBasePasterController
    public boolean isEditCompleted() {
        return (isPasterRemoved() || this.isEditStarted) ? false : true;
    }

    @Override // com.aliyun.svideo.editor.editor.AliyunBasePasterController
    public boolean isPasterExists() {
        return this.mController.isPasterExists();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterBaseView
    public boolean isPasterMirrored() {
        return this.mPasterView.isMirror();
    }

    @Override // com.aliyun.svideo.editor.editor.AliyunBasePasterController
    public boolean isPasterRemoved() {
        return this.isDeleted;
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
        com.aliyun.svideosdk.editor.AliyunPasterController aliyunPasterController = this.mController;
        java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.MILLISECONDS;
        long pasterStartTime = aliyunPasterController.getPasterStartTime(timeUnit);
        return j >= pasterStartTime && j <= pasterStartTime + this.mController.getPasterDuration(timeUnit);
    }

    public void mirrorPaster(boolean z) {
        this.mPasterView.setMirror(z);
    }

    @Override // com.aliyun.svideo.editor.editor.AliyunBasePasterController
    public void moveContent(float f, float f2) {
        this.mPasterView.moveContent(f, f2);
    }

    public abstract void playPasterEffect();

    @Override // com.aliyun.svideo.editor.editor.AliyunBasePasterController
    public void removePaster() {
        this.isDeleted = true;
        this.mController.removePaster();
        android.view.ViewParent parent = this.mPasterView.getParent();
        if (parent != null) {
            ((android.view.ViewGroup) parent).removeView(this.mPasterView);
        }
        this.mThumbLBar.removeOverlay(this.mThumbLineOverlay);
    }

    public void setFrameAction(com.aliyun.svideosdk.common.struct.effect.ActionBase actionBase) {
        this.mFrameAction = actionBase;
        this.mOldFrameAction = actionBase;
    }

    public void setFrameSelectedPosition(int i) {
        this.mFrameActionSelect = i;
    }

    @Override // com.aliyun.svideo.editor.editor.AliyunBasePasterController
    public void setOnlyApplyUI(boolean z) {
        if (getController() != null) {
            getController().setOnlyApplyUI(z);
        }
    }

    @Override // com.aliyun.svideo.editor.editor.AliyunBasePasterController
    public void setPasterViewVisibility(int i) {
        com.aliyun.svideo.editor.widget.BaseAliyunPasterView baseAliyunPasterView = this.mPasterView;
        if (baseAliyunPasterView != null) {
            baseAliyunPasterView.setVisibility(i);
        }
    }

    public void setTempFrameAction(com.aliyun.svideosdk.common.struct.effect.ActionBase actionBase) {
        this.mTempFrameAction = actionBase;
    }

    public void showAnimationDialog(boolean z) {
        com.aliyun.svideo.editor.effects.overlay.AnimationDialog.PasterInfo pasterInfo = new com.aliyun.svideo.editor.effects.overlay.AnimationDialog.PasterInfo();
        pasterInfo.mAnimation = this.mOldFrameAction;
        pasterInfo.mAnimationSelect = this.mFrameActionSelect;
        com.aliyun.svideo.editor.effects.overlay.AnimationDialog newInstance = com.aliyun.svideo.editor.effects.overlay.AnimationDialog.newInstance(pasterInfo, z);
        newInstance.setOnStateChangeListener(new com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl.AnonymousClass6());
        newInstance.show(((android.app.Activity) this.mPasterView.getContext()).getFragmentManager(), "pasterinfo");
    }

    @Override // com.aliyun.svideo.editor.editor.AliyunBasePasterController
    public void showTextEdit(boolean z) {
        com.aliyun.svideo.editor.widget.AutoResizingTextView autoResizingTextView = this.mText;
        if (autoResizingTextView == null) {
            return;
        }
        autoResizingTextView.setEditCompleted(true);
        this.mPasterView.setEditCompleted(true);
        com.aliyun.svideo.editor.effects.caption.TextDialog.EditTextInfo editTextInfo = new com.aliyun.svideo.editor.effects.caption.TextDialog.EditTextInfo();
        editTextInfo.dTextColor = this.mController.getConfigTextColor();
        editTextInfo.dTextStrokeColor = this.mController.getConfigTextStrokeColor();
        editTextInfo.isTextOnly = this.mController.getPasterType() == 1;
        editTextInfo.isShowAnimation = true;
        editTextInfo.text = this.mText.getText().toString();
        editTextInfo.textColor = this.mText.getCurrentTextColor();
        editTextInfo.textStrokeColor = this.mText.getTextStrokeColor();
        editTextInfo.font = this.mText.getFontPath();
        editTextInfo.mAnimation = this.mOldFrameAction;
        editTextInfo.mAnimationSelect = this.mFrameActionSelect;
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) getPasterView().getParent();
        if (viewGroup != null) {
            editTextInfo.layoutWidth = viewGroup.getWidth();
            viewGroup.setEnabled(false);
        }
        if (editTextInfo.isTextOnly) {
            editTextInfo.textWidth = getPasterWidth();
            editTextInfo.textHeight = getPasterHeight();
        } else {
            editTextInfo.textWidth = getPasterTextWidth();
            editTextInfo.textHeight = getPasterTextHeight();
        }
        this.mPasterView.setVisibility(8);
        com.aliyun.svideo.editor.effects.caption.TextDialog newInstance = com.aliyun.svideo.editor.effects.caption.TextDialog.newInstance(editTextInfo, z);
        if (newInstance == null) {
            return;
        }
        newInstance.setOnStateChangeListener(new com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl.AnonymousClass5());
        newInstance.show(((android.app.Activity) this.mPasterView.getContext()).getFragmentManager(), "textedit");
    }

    @Override // com.aliyun.svideo.editor.editor.AliyunBasePasterController
    public void showTimeEdit() {
        if (isPasterExists()) {
            if (this.mThumbLineOverlay == null) {
                com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl.AnonymousClass7 anonymousClass7 = new com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl.AnonymousClass7();
                com.aliyun.svideo.editor.effects.control.UIEditorPage uIEditorPage = this.mEditorPage;
                if (com.aliyun.svideo.editor.effects.control.UIEditorPage.FONT == uIEditorPage) {
                    uIEditorPage = com.aliyun.svideo.editor.effects.control.UIEditorPage.CAPTION;
                }
                com.aliyun.svideo.editor.effects.control.UIEditorPage uIEditorPage2 = uIEditorPage;
                com.aliyun.svideo.editor.editor.thumblinebar.OverlayThumbLineBar overlayThumbLineBar = this.mThumbLBar;
                com.aliyun.svideosdk.editor.AliyunPasterController aliyunPasterController = this.mController;
                java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.MILLISECONDS;
                this.mThumbLineOverlay = overlayThumbLineBar.addOverlay(aliyunPasterController.getPasterStartTime(timeUnit), this.mController.getPasterDuration(timeUnit), anonymousClass7, 500L, false, uIEditorPage2, new com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl.AnonymousClass8());
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("showTimeEdit: duration :");
                sb.append(this.mController.getPasterDuration());
            }
            this.mThumbLineOverlay.switchState((byte) 1);
        }
    }

    public abstract void stopPasterEffect();

    @Override // com.aliyun.svideosdk.editor.AliyunPasterBaseView
    public android.graphics.Bitmap transToImage() {
        return null;
    }
}
