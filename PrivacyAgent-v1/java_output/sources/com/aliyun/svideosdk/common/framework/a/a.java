package com.aliyun.svideosdk.common.framework.a;

/* loaded from: classes12.dex */
public abstract class a<MODEL extends com.aliyun.svideosdk.common.struct.effect.ICopyable<MODEL>> implements com.aliyun.svideosdk.common.framework.AliyunIStickerController {
    protected long mDuration;
    protected com.aliyun.svideosdk.common.framework.a.a.EnumC0084a mEditMode = com.aliyun.svideosdk.common.framework.a.a.EnumC0084a.Editing;
    protected MODEL mModelBeforeEdit = null;
    protected MODEL mModel = null;

    /* renamed from: com.aliyun.svideosdk.common.framework.a.a$a, reason: collision with other inner class name */
    public enum EnumC0084a {
        Idle,
        Editing
    }

    @Override // com.aliyun.svideosdk.common.framework.AliyunIStickerController
    public void beginEdit() {
        com.aliyun.svideosdk.common.framework.a.a.EnumC0084a enumC0084a = this.mEditMode;
        com.aliyun.svideosdk.common.framework.a.a.EnumC0084a enumC0084a2 = com.aliyun.svideosdk.common.framework.a.a.EnumC0084a.Editing;
        if (enumC0084a == enumC0084a2) {
            return;
        }
        this.mEditMode = enumC0084a2;
        this.mModelBeforeEdit = (MODEL) this.mModel.copy();
    }

    @Override // com.aliyun.svideosdk.common.framework.AliyunIStickerController
    public void cancelEdit() {
        MODEL model;
        if (this.mEditMode != com.aliyun.svideosdk.common.framework.a.a.EnumC0084a.Editing || (model = this.mModelBeforeEdit) == null) {
            return;
        }
        this.mModel.copy(model);
        this.mEditMode = com.aliyun.svideosdk.common.framework.a.a.EnumC0084a.Idle;
        this.mModelBeforeEdit = null;
    }

    @Override // com.aliyun.svideosdk.common.framework.AliyunIStickerController
    public void endEdit() {
        if (this.mEditMode == com.aliyun.svideosdk.common.framework.a.a.EnumC0084a.Editing) {
            this.mEditMode = com.aliyun.svideosdk.common.framework.a.a.EnumC0084a.Idle;
            onUpdate(this.mModel);
            this.mModelBeforeEdit = null;
        }
    }

    public abstract void onUpdate(MODEL model);
}
