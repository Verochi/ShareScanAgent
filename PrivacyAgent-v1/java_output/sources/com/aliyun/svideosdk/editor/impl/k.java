package com.aliyun.svideosdk.editor.impl;

@java.lang.Deprecated
/* loaded from: classes12.dex */
class k extends com.aliyun.svideosdk.editor.impl.m {
    private com.aliyun.svideosdk.common.struct.effect.EffectCaption j;

    public k(com.aliyun.svideosdk.common.struct.effect.EffectCaption effectCaption, com.aliyun.svideosdk.editor.impl.p pVar, com.aliyun.svideosdk.editor.AliyunPasterManager aliyunPasterManager) {
        super(effectCaption, pVar, aliyunPasterManager, false);
        this.j = effectCaption;
    }

    public k(com.aliyun.svideosdk.common.struct.effect.EffectCaption effectCaption, com.aliyun.svideosdk.editor.impl.p pVar, com.aliyun.svideosdk.editor.AliyunPasterManager aliyunPasterManager, boolean z) {
        super(effectCaption, pVar, aliyunPasterManager, z);
        this.j = effectCaption;
    }

    private void c() {
        if (isRevert()) {
            return;
        }
        int pasterTextOffsetX = this.b.getPasterTextOffsetX();
        if (pasterTextOffsetX != 0) {
            this.j.textCenterX = pasterTextOffsetX;
        }
        int pasterTextOffsetY = this.b.getPasterTextOffsetY();
        if (pasterTextOffsetY != 0) {
            this.j.textCenterY = pasterTextOffsetY;
        }
        this.j.textRotation = this.b.getPasterTextRotation();
        int pasterTextWidth = this.b.getPasterTextWidth();
        if (pasterTextWidth != 0) {
            this.j.textWidth = pasterTextWidth;
        }
        int pasterTextHeight = this.b.getPasterTextHeight();
        if (pasterTextHeight != 0) {
            this.j.textHeight = pasterTextHeight;
        }
    }

    @Override // com.aliyun.svideosdk.editor.impl.m, com.aliyun.svideosdk.editor.impl.l, com.aliyun.svideosdk.editor.AliyunPasterController
    public int editCompleted() {
        if (this.b == null) {
            return -4;
        }
        a();
        b();
        c();
        if (isOnlyApplyUI()) {
            return 0;
        }
        if (this.c) {
            return this.mRender.showCaptionPaster(this, this.j);
        }
        int addCaptionPaster = this.mRender.addCaptionPaster(this, this.j);
        if (addCaptionPaster != 0) {
            return addCaptionPaster;
        }
        this.c = true;
        return addCaptionPaster;
    }

    @Override // com.aliyun.svideosdk.editor.impl.m, com.aliyun.svideosdk.editor.impl.l, com.aliyun.svideosdk.editor.AliyunPasterController
    public com.aliyun.svideosdk.common.struct.effect.EffectBase getEffect() {
        return this.j;
    }

    @Override // com.aliyun.svideosdk.editor.impl.a, com.aliyun.svideosdk.editor.AliyunPasterController
    public int getPasterTextHeight() {
        return this.j.textHeight;
    }

    @Override // com.aliyun.svideosdk.editor.impl.a, com.aliyun.svideosdk.editor.AliyunPasterController
    public int getPasterTextOffsetX() {
        return this.j.textCenterX;
    }

    @Override // com.aliyun.svideosdk.editor.impl.a, com.aliyun.svideosdk.editor.AliyunPasterController
    public int getPasterTextOffsetY() {
        return this.j.textCenterY;
    }

    @Override // com.aliyun.svideosdk.editor.impl.a, com.aliyun.svideosdk.editor.AliyunPasterController
    public float getPasterTextRotation() {
        return this.j.textRotation;
    }

    @Override // com.aliyun.svideosdk.editor.impl.a, com.aliyun.svideosdk.editor.AliyunPasterController
    public int getPasterTextWidth() {
        return this.j.textWidth;
    }

    @Override // com.aliyun.svideosdk.editor.impl.m, com.aliyun.svideosdk.editor.impl.l, com.aliyun.svideosdk.editor.AliyunPasterController
    public int getPasterType() {
        return 2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.impl.m, com.aliyun.svideosdk.editor.impl.l, com.aliyun.svideosdk.editor.AliyunPasterController
    public boolean isPasterExists() {
        return new java.io.File(((com.aliyun.svideosdk.common.struct.effect.EffectPaster) this.a).getPath()).exists();
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, com.aliyun.svideosdk.common.struct.effect.EffectCaption, com.aliyun.svideosdk.common.struct.effect.EffectText] */
    @Override // com.aliyun.svideosdk.editor.impl.m, com.aliyun.svideosdk.editor.impl.l, com.aliyun.svideosdk.editor.AliyunPasterController
    public void setEffect(com.aliyun.svideosdk.common.struct.effect.EffectBase effectBase) {
        if (effectBase instanceof com.aliyun.svideosdk.common.struct.effect.EffectCaption) {
            ?? r2 = (com.aliyun.svideosdk.common.struct.effect.EffectCaption) effectBase;
            this.j = r2;
            this.a = r2;
            this.i = r2;
        }
    }
}
