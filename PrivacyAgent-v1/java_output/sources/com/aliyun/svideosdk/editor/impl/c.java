package com.aliyun.svideosdk.editor.impl;

/* loaded from: classes12.dex */
public class c implements com.aliyun.svideosdk.editor.AliyunIAugmentationController {
    private com.aliyun.svideosdk.editor.NativeEditor a;
    private com.aliyun.svideosdk.common.AliyunPip b;
    private com.aliyun.svideosdk.common.struct.project.PipVideoTrackClip c;
    private java.lang.ref.WeakReference<com.aliyun.svideosdk.editor.impl.g> d;

    public c(com.aliyun.svideosdk.editor.NativeEditor nativeEditor, com.aliyun.svideosdk.common.AliyunPip aliyunPip, com.aliyun.svideosdk.common.struct.project.PipVideoTrackClip pipVideoTrackClip, com.aliyun.svideosdk.editor.impl.g gVar) {
        this.a = nativeEditor;
        this.b = aliyunPip;
        this.c = pipVideoTrackClip;
        this.d = new java.lang.ref.WeakReference<>(gVar);
    }

    private void b() {
        this.c.setBrightness(this.b.getBrightness());
        this.c.setContrast(this.b.getContrast());
        this.c.setSaturation(this.b.getSaturation());
        this.c.setSharpness(this.b.getSharpness());
        this.c.setVignette(this.b.getVignette());
    }

    public void a() {
        if (this.a != null) {
            this.a = null;
        }
        if (this.b != null) {
            this.b = null;
        }
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIAugmentationController
    public int apply() {
        this.a.updatePicInPic(this.b.getNativeHandle());
        b();
        if (this.d.get() == null) {
            return 0;
        }
        this.d.get().saveEffectToLocal();
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIAugmentationController
    public float getBrightness() {
        return this.b.getBrightness();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIAugmentationController
    public float getContrast() {
        return this.b.getContrast();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIAugmentationController
    public float getSaturation() {
        return this.b.getSaturation();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIAugmentationController
    public float getSharpness() {
        return this.b.getSharpness();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIAugmentationController
    public float getVignette() {
        return this.b.getVignette();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIAugmentationController
    public void resetDefault() {
        this.b.setBrightness(0.5f);
        this.b.setContrast(0.25f);
        this.b.setSaturation(0.5f);
        this.b.setSharpness(0.0f);
        this.b.setVignette(0.0f);
        apply();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIAugmentationController
    public com.aliyun.svideosdk.editor.AliyunIAugmentationController setBrightness(float f) {
        this.b.setBrightness(f);
        return this;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIAugmentationController
    public com.aliyun.svideosdk.editor.AliyunIAugmentationController setContrast(float f) {
        this.b.setContrast(f);
        return this;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIAugmentationController
    public com.aliyun.svideosdk.editor.AliyunIAugmentationController setSaturation(float f) {
        this.b.setSaturation(f);
        return this;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIAugmentationController
    public com.aliyun.svideosdk.editor.AliyunIAugmentationController setSharpness(float f) {
        this.b.setSharpness(f);
        return this;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIAugmentationController
    public com.aliyun.svideosdk.editor.AliyunIAugmentationController setVignette(float f) {
        this.b.setVignette(f);
        return this;
    }
}
