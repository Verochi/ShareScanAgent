package com.aliyun.svideo.editor.editor;

/* loaded from: classes12.dex */
public class PasterUITextImpl extends com.aliyun.svideo.editor.editor.PasterUIGifImpl {
    public PasterUITextImpl(com.aliyun.svideo.editor.widget.BaseAliyunPasterView baseAliyunPasterView, com.aliyun.svideosdk.editor.AliyunPasterController aliyunPasterController, com.aliyun.svideo.editor.editor.thumblinebar.OverlayThumbLineBar overlayThumbLineBar, com.aliyun.svideosdk.editor.AliyunIEditor aliyunIEditor, boolean z) {
        super(baseAliyunPasterView, aliyunPasterController, overlayThumbLineBar);
        this.mEditorPage = com.aliyun.svideo.editor.effects.control.UIEditorPage.FONT;
        this.mAliyunIEditor = aliyunIEditor;
        if (this.mText == null) {
            this.mText = (com.aliyun.svideo.editor.widget.AutoResizingTextView) this.mPasterView.getContentView();
        }
        this.mText.setText(aliyunPasterController.getText());
        this.mText.setTextOnly(true);
        this.mText.setFontPath(aliyunPasterController.getPasterTextFont());
        this.mText.setFontSource(aliyunPasterController.getPasterTextFontSource());
        this.mText.setTextAngle(aliyunPasterController.getPasterTextRotation());
        this.mText.setTextStrokeColor(aliyunPasterController.getTextStrokeColor());
        this.mText.setCurrentColor(aliyunPasterController.getTextColor());
        if (!z) {
            this.mText.setEditCompleted(false);
            baseAliyunPasterView.setEditCompleted(false);
        } else {
            this.mText.setTextWidth(aliyunPasterController.getPasterWidth());
            this.mText.setTextHeight(aliyunPasterController.getPasterHeight());
            this.mText.setEditCompleted(true);
            baseAliyunPasterView.setEditCompleted(true);
        }
    }

    @Override // com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl, com.aliyun.svideosdk.editor.AliyunPasterBaseView
    public android.graphics.Bitmap getBackgroundBitmap() {
        return null;
    }

    @Override // com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl, com.aliyun.svideosdk.editor.AliyunPasterBaseView
    public java.lang.String getPasterTextFont() {
        return this.mText.getFontPath();
    }

    @Override // com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl, com.aliyun.svideosdk.editor.AliyunPasterBaseView
    public int getPasterTextHeight() {
        return this.mText.getTextHeight();
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
    public android.text.Layout.Alignment getTextAlign() {
        android.text.Layout layout = this.mText.getLayout();
        return layout != null ? layout.getAlignment() : android.text.Layout.Alignment.ALIGN_CENTER;
    }

    @Override // com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl, com.aliyun.svideosdk.editor.AliyunPasterBaseView
    public int getTextBgLabelColor() {
        return android.graphics.Color.parseColor("#00000000");
    }

    @Override // com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl, com.aliyun.svideosdk.editor.AliyunPasterBaseView
    public int getTextColor() {
        return this.mText.getTextColor();
    }

    @Override // com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl, com.aliyun.svideosdk.editor.AliyunPasterBaseView
    public int getTextFixSize() {
        return 0;
    }

    @Override // com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl, com.aliyun.svideosdk.editor.AliyunPasterBaseView
    public int getTextPaddingX() {
        return 0;
    }

    @Override // com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl, com.aliyun.svideosdk.editor.AliyunPasterBaseView
    public int getTextPaddingY() {
        return 0;
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
    }

    @Override // com.aliyun.svideo.editor.editor.PasterUIGifImpl, com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl
    public void playPasterEffect() {
    }

    @Override // com.aliyun.svideo.editor.editor.PasterUIGifImpl, com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl
    public void stopPasterEffect() {
    }

    @Override // com.aliyun.svideo.editor.editor.AbstractPasterUISimpleImpl, com.aliyun.svideosdk.editor.AliyunPasterBaseView
    public android.graphics.Bitmap transToImage() {
        return this.mText.layoutToBitmap();
    }
}
