package com.aliyun.svideo.editor.editor;

/* loaded from: classes12.dex */
public class PasterUIGifImpl extends com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl {
    protected com.aliyun.svideosdk.editor.AliyunIEditor mAliyunIEditor;

    /* renamed from: com.aliyun.svideo.editor.editor.PasterUIGifImpl$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.aliyun.svideosdk.common.struct.effect.EffectPaster effectPaster = (com.aliyun.svideosdk.common.struct.effect.EffectPaster) com.aliyun.svideo.editor.editor.PasterUIGifImpl.this.mController.getEffect();
            com.aliyun.svideo.editor.editor.PasterUIGifImpl.this.mPasterView.moveContent(com.aliyun.svideo.editor.editor.PasterUIGifImpl.this.mController.getPasterCenterX() - (effectPaster.displayWidth / 2), com.aliyun.svideo.editor.editor.PasterUIGifImpl.this.mController.getPasterCenterY() - (effectPaster.displayHeight / 2));
        }
    }

    public PasterUIGifImpl(com.aliyun.svideo.editor.widget.BaseAliyunPasterView baseAliyunPasterView, com.aliyun.svideosdk.editor.AliyunPasterController aliyunPasterController, com.aliyun.svideo.editor.editor.thumblinebar.OverlayThumbLineBar overlayThumbLineBar) {
        super(baseAliyunPasterView, aliyunPasterController, overlayThumbLineBar);
        this.mEditorPage = com.aliyun.svideo.editor.effects.control.UIEditorPage.OVERLAY;
        this.mText = (com.aliyun.svideo.editor.widget.AutoResizingTextView) baseAliyunPasterView.getContentView().findViewById(com.aliyun.svideo.editor.R.id.qupai_overlay_content_text);
        int pasterWidth = aliyunPasterController.getPasterWidth();
        int pasterHeight = aliyunPasterController.getPasterHeight();
        this.mPasterView.setContentWidth(pasterWidth);
        this.mPasterView.setContentHeight(pasterHeight);
        mirrorPaster(this.mController.isPasterMirrored());
        this.mPasterView.rotateContent(this.mController.getPasterRotation());
    }

    public PasterUIGifImpl(com.aliyun.svideo.editor.widget.BaseAliyunPasterView baseAliyunPasterView, com.aliyun.svideosdk.editor.AliyunPasterController aliyunPasterController, com.aliyun.svideo.editor.editor.thumblinebar.OverlayThumbLineBar overlayThumbLineBar, com.aliyun.svideosdk.editor.AliyunIEditor aliyunIEditor) {
        this(baseAliyunPasterView, aliyunPasterController, overlayThumbLineBar);
        this.mAliyunIEditor = aliyunIEditor;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void applyAnimation(com.aliyun.svideosdk.common.struct.effect.ActionBase actionBase) {
        com.aliyun.svideosdk.common.struct.effect.ActionTranslate actionTranslate;
        if (actionBase instanceof com.aliyun.svideosdk.common.struct.effect.ActionTranslate) {
            com.aliyun.svideosdk.common.struct.effect.ActionTranslate actionTranslate2 = (com.aliyun.svideosdk.common.struct.effect.ActionTranslate) actionBase;
            if (actionTranslate2.getFromPointX() == 0.0f && actionTranslate2.getFromPointY() == 0.0f && actionTranslate2.getToPointX() == 0.0f && actionTranslate2.getToPointY() == 0.0f) {
                actionTranslate = new com.aliyun.svideosdk.common.struct.effect.ActionTranslate();
                com.aliyun.svideosdk.editor.AliyunPasterController aliyunPasterController = this.mController;
                java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.MILLISECONDS;
                long pasterStartTime = aliyunPasterController.getPasterStartTime(timeUnit);
                actionBase.setTargetId(this.mController.getEffect().getViewId());
                actionBase.setStartTime(pasterStartTime, timeUnit);
                actionBase.setDuration(1000L, timeUnit);
                if (actionTranslate != null) {
                    this.mAliyunIEditor.addFrameAnimation(actionBase);
                    return;
                }
                actionTranslate.setTargetId(this.mController.getEffect().getViewId());
                actionTranslate.setStartTime(pasterStartTime, timeUnit);
                actionTranslate.setDuration(1000L, timeUnit);
                setTranslateParams(actionBase, actionTranslate);
                this.mAliyunIEditor.addFrameAnimation(actionTranslate);
                this.mFrameAction = actionTranslate;
                return;
            }
        }
        actionTranslate = null;
        com.aliyun.svideosdk.editor.AliyunPasterController aliyunPasterController2 = this.mController;
        java.util.concurrent.TimeUnit timeUnit2 = java.util.concurrent.TimeUnit.MILLISECONDS;
        long pasterStartTime2 = aliyunPasterController2.getPasterStartTime(timeUnit2);
        actionBase.setTargetId(this.mController.getEffect().getViewId());
        actionBase.setStartTime(pasterStartTime2, timeUnit2);
        actionBase.setDuration(1000L, timeUnit2);
        if (actionTranslate != null) {
        }
    }

    private void setTranslateParams(com.aliyun.svideosdk.common.struct.effect.ActionBase actionBase, com.aliyun.svideosdk.common.struct.effect.ActionBase actionBase2) {
        com.aliyun.svideosdk.common.struct.effect.ActionTranslate actionTranslate = (com.aliyun.svideosdk.common.struct.effect.ActionTranslate) actionBase2;
        if (this.mPasterView.getParent() == null) {
            return;
        }
        com.aliyun.svideosdk.common.struct.effect.ActionTranslate actionTranslate2 = (com.aliyun.svideosdk.common.struct.effect.ActionTranslate) actionBase;
        float toPointX = actionTranslate2.getToPointX();
        float toPointY = actionTranslate2.getToPointY();
        float width = this.mPasterView.getWidth() / 2.0f;
        float height = this.mPasterView.getHeight() / 2.0f;
        float right = (((this.mPasterView.getContentView().getRight() + this.mPasterView.getContentView().getLeft()) / 2.0f) - width) / width;
        float f = (-(((this.mPasterView.getContentView().getTop() + this.mPasterView.getContentView().getBottom()) / 2.0f) - height)) / height;
        actionTranslate.setToPointX(right);
        actionTranslate.setToPointY(f);
        if (toPointX == 1.0f) {
            actionTranslate.setFromPointY(f);
            actionTranslate.setFromPointX(-1.0f);
            return;
        }
        if (toPointX == -1.0f) {
            actionTranslate.setFromPointY(f);
            actionTranslate.setFromPointX(1.0f);
        } else if (toPointY == -1.0f) {
            actionTranslate.setFromPointX(right);
            actionTranslate.setFromPointY(1.0f);
        } else if (toPointY == 1.0f) {
            actionTranslate.setFromPointX(right);
            actionTranslate.setFromPointY(-1.0f);
        }
    }

    @Override // com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl, com.aliyun.svideo.editor.editor.AliyunBasePasterController
    public void editTimeCompleted() {
        com.aliyun.svideosdk.editor.AliyunIEditor aliyunIEditor;
        if (this.isEditStarted && isPasterExists() && !isPasterRemoved()) {
            super.editTimeCompleted();
            if (!this.mController.isOnlyApplyUI() && !isPasterRemoved() && (aliyunIEditor = this.mAliyunIEditor) != null) {
                com.aliyun.svideosdk.common.struct.effect.ActionBase actionBase = this.mOldFrameAction;
                if (actionBase != null) {
                    aliyunIEditor.removeFrameAnimation(actionBase);
                    this.mOldFrameAction = null;
                }
                com.aliyun.svideosdk.common.struct.effect.ActionBase actionBase2 = this.mTempFrameAction;
                this.mFrameAction = actionBase2;
                if (actionBase2 != null) {
                    applyAnimation(actionBase2);
                }
                this.mOldFrameAction = this.mFrameAction;
            }
            this.isEditStarted = false;
        }
    }

    @Override // com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl, com.aliyun.svideosdk.editor.AliyunPasterBaseView
    public int getPasterCenterX() {
        float[] center;
        if (this.mMoveDelay || (center = this.mPasterView.getCenter()) == null) {
            return 0;
        }
        return (int) center[0];
    }

    @Override // com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl, com.aliyun.svideosdk.editor.AliyunPasterBaseView
    public int getPasterCenterY() {
        float[] center;
        if (this.mMoveDelay || (center = this.mPasterView.getCenter()) == null) {
            return 0;
        }
        return (int) center[1];
    }

    @Override // com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl, com.aliyun.svideosdk.editor.AliyunPasterBaseView
    public int getPasterHeight() {
        return (int) (this.mPasterView.getContentHeight() * this.mPasterView.getScale()[1]);
    }

    @Override // com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl, com.aliyun.svideosdk.editor.AliyunPasterBaseView
    public float getPasterRotation() {
        return this.mPasterView.getRotation();
    }

    @Override // com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl, com.aliyun.svideosdk.editor.AliyunPasterBaseView
    public android.view.View getPasterView() {
        return this.mPasterView;
    }

    @Override // com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl, com.aliyun.svideosdk.editor.AliyunPasterBaseView
    public int getPasterWidth() {
        return (int) (this.mPasterView.getContentWidth() * this.mPasterView.getScale()[0]);
    }

    @Override // com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl
    public void mirrorPaster(boolean z) {
        super.mirrorPaster(z);
        this.animPlayerView.setMirror(z);
    }

    @Override // com.aliyun.svideo.editor.editor.AliyunBasePasterController
    public void moveToCenter() {
        this.mMoveDelay = true;
        this.mPasterView.post(new com.aliyun.svideo.editor.editor.PasterUIGifImpl.AnonymousClass1());
    }

    @Override // com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl
    public void playPasterEffect() {
        android.view.TextureView textureView = new android.view.TextureView(this.mPasterView.getContext());
        this.animPlayerView = this.mController.createPasterPlayer(textureView);
        ((android.view.ViewGroup) this.mPasterView.getContentView()).addView(textureView, new android.view.ViewGroup.LayoutParams(-1, -1));
    }

    @Override // com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl
    public void stopPasterEffect() {
        ((android.view.ViewGroup) this.mPasterView.getContentView()).removeAllViews();
        this.animPlayerView = null;
    }
}
