package com.aliyun.svideosdk.recorder.impl;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class AliyunRecordFacePasterController extends com.aliyun.svideosdk.recorder.impl.AliyunRecordPasterController {
    public AliyunRecordFacePasterController(com.aliyun.svideosdk.common.struct.project.Source source, com.aliyun.svideosdk.recorder.impl.d dVar) {
        super(source, dVar);
        ((com.aliyun.svideosdk.common.struct.effect.EffectSticker) this.mModel).setWidthRatio(0.0f);
        ((com.aliyun.svideosdk.common.struct.effect.EffectSticker) this.mModel).setHeightRatio(0.0f);
    }

    @Override // com.aliyun.svideosdk.recorder.impl.AliyunRecordPasterController, com.aliyun.svideosdk.recorder.impl.a
    public com.aliyun.svideosdk.recorder.impl.AliyunRecordStickerType getType() {
        return com.aliyun.svideosdk.recorder.impl.AliyunRecordStickerType.FACE_STICKER;
    }
}
