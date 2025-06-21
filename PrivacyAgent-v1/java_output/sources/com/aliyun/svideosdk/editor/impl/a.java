package com.aliyun.svideosdk.editor.impl;

/* loaded from: classes12.dex */
abstract class a<T> extends com.aliyun.svideosdk.editor.impl.AliyunPasterAbstractController<T> implements com.aliyun.svideosdk.editor.AliyunPasterController {
    protected T a;
    protected com.aliyun.svideosdk.editor.AliyunPasterBaseView b;
    protected boolean c;
    protected boolean d;
    protected boolean e;
    protected com.aliyun.svideosdk.editor.AliyunPasterManager f;

    public a(T t, com.aliyun.svideosdk.editor.impl.p pVar, com.aliyun.svideosdk.editor.AliyunPasterManager aliyunPasterManager, boolean z) {
        super(t, pVar);
        this.a = t;
        this.c = z;
        this.f = aliyunPasterManager;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public int getConfigTextColor() {
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public int getConfigTextStrokeColor() {
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    @java.lang.Deprecated
    public java.lang.String getPasterTextFont() {
        return null;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public com.aliyun.svideosdk.common.struct.project.Source getPasterTextFontSource() {
        return null;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public int getPasterTextHeight() {
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public int getPasterTextOffsetX() {
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public int getPasterTextOffsetY() {
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public float getPasterTextRotation() {
        return 0.0f;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public int getPasterTextWidth() {
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public java.lang.String getText() {
        return null;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public int getTextBgLabelColor() {
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public int getTextColor() {
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public int getTextStrokeColor() {
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public boolean isTextHasStroke() {
        return false;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public void setPasterView(com.aliyun.svideosdk.editor.AliyunPasterBaseView aliyunPasterBaseView) {
        this.b = aliyunPasterBaseView;
    }
}
