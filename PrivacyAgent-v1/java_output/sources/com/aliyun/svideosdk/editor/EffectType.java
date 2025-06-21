package com.aliyun.svideosdk.editor;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public enum EffectType {
    EFFECT_TYPE_TIME(0),
    EFFECT_TYPE_MIX(1),
    EFFECT_TYPE_MV(2),
    EFFECT_TYPE_PITCH(3),
    EFFECT_TYPE_MV_AUDIO(4);

    private int effectType;

    EffectType(int i) {
        this.effectType = i;
    }

    public int getEffectType() {
        return this.effectType;
    }
}
