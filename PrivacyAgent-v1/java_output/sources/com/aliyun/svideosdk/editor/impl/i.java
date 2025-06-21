package com.aliyun.svideosdk.editor.impl;

/* loaded from: classes12.dex */
public class i implements com.aliyun.svideosdk.editor.AliyunILayoutController {
    private com.aliyun.svideosdk.common.AliyunLayoutParams a;
    private com.aliyun.svideosdk.editor.impl.AliyunIControllerCallback b;

    public i(com.aliyun.svideosdk.common.AliyunLayoutParams aliyunLayoutParams, com.aliyun.svideosdk.editor.impl.AliyunIControllerCallback aliyunIControllerCallback) {
        this.a = aliyunLayoutParams;
        this.b = aliyunIControllerCallback;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunILayoutController
    public int apply() {
        com.aliyun.svideosdk.editor.impl.AliyunIControllerCallback aliyunIControllerCallback = this.b;
        if (aliyunIControllerCallback != null) {
            return aliyunIControllerCallback.onApply();
        }
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunILayoutController
    public float getAlpha() {
        return this.a.getAlpha();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunILayoutController
    public android.graphics.PointF getPosition() {
        return this.a.getPosition();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunILayoutController
    public float getRotationRadian() {
        return this.a.getRotationRadian();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunILayoutController
    public float getScale() {
        return this.a.getScale();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunILayoutController
    public com.aliyun.svideosdk.editor.AliyunILayoutController setAlpha(float f) {
        this.a.setAlpha(f);
        return this;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunILayoutController
    public com.aliyun.svideosdk.editor.AliyunILayoutController setPosition(float f, float f2) {
        this.a.setPosition(new android.graphics.PointF(f, f2));
        return this;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunILayoutController
    public com.aliyun.svideosdk.editor.AliyunILayoutController setRotation(float f) {
        this.a.setRotationRadian(f);
        return this;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunILayoutController
    public com.aliyun.svideosdk.editor.AliyunILayoutController setScale(float f) {
        this.a.setScale(f);
        return this;
    }
}
