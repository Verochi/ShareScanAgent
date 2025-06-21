package com.aliyun.svideo.editor.editor;

/* loaded from: classes12.dex */
public class PasterUICaptionImpl extends com.aliyun.svideo.editor.editor.PasterUIGifImpl {
    private int textCenterOffsetX;
    private int textCenterOffsetY;

    public PasterUICaptionImpl(com.aliyun.svideo.editor.widget.BaseAliyunPasterView baseAliyunPasterView, com.aliyun.svideosdk.editor.AliyunPasterController aliyunPasterController, com.aliyun.svideo.editor.editor.thumblinebar.OverlayThumbLineBar overlayThumbLineBar) {
        super(baseAliyunPasterView, aliyunPasterController, overlayThumbLineBar);
        int pasterTextWidth = aliyunPasterController.getPasterTextWidth();
        int pasterTextHeight = aliyunPasterController.getPasterTextHeight();
        this.textCenterOffsetX = aliyunPasterController.getPasterTextOffsetX();
        this.textCenterOffsetY = aliyunPasterController.getPasterTextOffsetY();
        int pasterWidth = aliyunPasterController.getPasterWidth();
        int pasterHeight = aliyunPasterController.getPasterHeight();
        int i = this.textCenterOffsetX;
        int i2 = pasterTextWidth / 2;
        int i3 = this.textCenterOffsetY;
        int i4 = pasterTextHeight / 2;
        this.mText.setText(aliyunPasterController.getText());
        this.mText.setEditCompleted(true);
        this.mText.setTextStrokeColor(aliyunPasterController.getTextStrokeColor());
        this.mText.setCurrentColor(aliyunPasterController.getTextColor());
        this.mText.setFontPath(aliyunPasterController.getPasterTextFont());
        this.mText.setFontSource(aliyunPasterController.getPasterTextFontSource());
        this.mText.setTextWidth(pasterTextWidth);
        this.mText.setTextHeight(pasterTextHeight);
        this.mText.setTextTop(i3 - i4);
        this.mText.setTextLeft(i - i2);
        this.mText.setTextRight((pasterWidth - i) - i2);
        this.mText.setTextBottom((pasterHeight - i3) - i4);
        this.mText.setTextAngle(aliyunPasterController.getPasterTextRotation());
    }

    public PasterUICaptionImpl(com.aliyun.svideo.editor.widget.BaseAliyunPasterView baseAliyunPasterView, com.aliyun.svideosdk.editor.AliyunPasterController aliyunPasterController, com.aliyun.svideo.editor.editor.thumblinebar.OverlayThumbLineBar overlayThumbLineBar, com.aliyun.svideosdk.editor.AliyunIEditor aliyunIEditor) {
        this(baseAliyunPasterView, aliyunPasterController, overlayThumbLineBar);
        this.mAliyunIEditor = aliyunIEditor;
        this.mEditorPage = com.aliyun.svideo.editor.effects.control.UIEditorPage.CAPTION;
    }

    @Override // com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl, com.aliyun.svideosdk.editor.AliyunPasterBaseView
    public java.lang.String getPasterTextFont() {
        return this.mText.getFontPath();
    }

    @Override // com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl, com.aliyun.svideosdk.editor.AliyunPasterBaseView
    public com.aliyun.svideosdk.common.struct.project.Source getPasterTextFontSource() {
        return this.mText.getFontSource();
    }

    @Override // com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl, com.aliyun.svideosdk.editor.AliyunPasterBaseView
    public int getPasterTextHeight() {
        return this.mText.getTextHeight();
    }

    @Override // com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl, com.aliyun.svideosdk.editor.AliyunPasterBaseView
    public int getPasterTextOffsetX() {
        return (int) (this.textCenterOffsetX * this.mPasterView.getScale()[0]);
    }

    @Override // com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl, com.aliyun.svideosdk.editor.AliyunPasterBaseView
    public int getPasterTextOffsetY() {
        return (int) (this.textCenterOffsetY * this.mPasterView.getScale()[1]);
    }

    @Override // com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl, com.aliyun.svideosdk.editor.AliyunPasterBaseView
    public float getPasterTextRotation() {
        return this.mText.getTextRotation();
    }

    @Override // com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl, com.aliyun.svideosdk.editor.AliyunPasterBaseView
    public int getPasterTextWidth() {
        return this.mText.getTextWidth();
    }

    @Override // com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl, com.aliyun.svideosdk.editor.AliyunPasterBaseView
    public java.lang.String getText() {
        return this.mText.getText().toString();
    }

    @Override // com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl, com.aliyun.svideosdk.editor.AliyunPasterBaseView
    public int getTextBgLabelColor() {
        return super.getTextBgLabelColor();
    }

    @Override // com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl, com.aliyun.svideosdk.editor.AliyunPasterBaseView
    public int getTextColor() {
        return this.mText.getTextColor();
    }

    @Override // com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl, com.aliyun.svideosdk.editor.AliyunPasterBaseView
    public int getTextStrokeColor() {
        return this.mText.getTextStrokeColor();
    }

    @Override // com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl, com.aliyun.svideosdk.editor.AliyunPasterBaseView
    public boolean isTextHasLabel() {
        return this.mPasterView.getTextLabel() != null;
    }

    @Override // com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl, com.aliyun.svideosdk.editor.AliyunPasterBaseView
    public boolean isTextHasStroke() {
        return getTextStrokeColor() == 0;
    }

    @Override // com.aliyun.svideo.editor.editor.PasterUIGifImpl, com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl
    public void mirrorPaster(boolean z) {
        this.mPasterView.setMirror(z);
        this.mText.setMirror(z);
        this.animPlayerView.setMirror(z);
    }

    @Override // com.aliyun.svideo.editor.editor.PasterUIGifImpl, com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl
    public void playPasterEffect() {
        android.view.TextureView textureView = new android.view.TextureView(this.mPasterView.getContext());
        this.animPlayerView = this.mController.createPasterPlayer(textureView);
        ((android.view.ViewGroup) this.mPasterView.getContentView()).addView(textureView, 0, new android.view.ViewGroup.LayoutParams(-1, -1));
    }

    @Override // com.aliyun.svideo.editor.editor.PasterUIGifImpl, com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl
    public void stopPasterEffect() {
        ((android.view.ViewGroup) this.mPasterView.getContentView()).removeViewAt(0);
        this.animPlayerView = null;
    }

    @Override // com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl, com.aliyun.svideosdk.editor.AliyunPasterBaseView
    public android.graphics.Bitmap transToImage() {
        return this.mText.layoutToBitmap();
    }
}
