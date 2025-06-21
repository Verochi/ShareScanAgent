package com.aliyun.svideosdk.editor;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public enum AudioEffectType {
    EFFECT_TYPE_DEFAULT(0),
    EFFECT_TYPE_LOLITA(1),
    EFFECT_TYPE_UNCLE(2),
    EFFECT_TYPE_REVERB(3),
    EFFECT_TYPE_ECHO(4),
    EFFECT_TYPE_ROBOT(5),
    EFFECT_TYPE_BIG_DEVIL(6),
    EFFECT_TYPE_MINIONS(7),
    EFFECT_TYPE_DENOISE(8),
    EFFECT_TYPE_DIALECT(9);

    private int effectType;

    AudioEffectType(int i) {
        this.effectType = i;
    }

    public int getEffectType() {
        return this.effectType;
    }
}
