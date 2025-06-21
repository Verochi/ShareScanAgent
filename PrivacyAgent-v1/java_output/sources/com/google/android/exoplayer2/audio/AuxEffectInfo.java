package com.google.android.exoplayer2.audio;

/* loaded from: classes22.dex */
public final class AuxEffectInfo {
    public static final int NO_AUX_EFFECT_ID = 0;
    public final int effectId;
    public final float sendLevel;

    public AuxEffectInfo(int i, float f) {
        this.effectId = i;
        this.sendLevel = f;
    }

    public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || com.google.android.exoplayer2.audio.AuxEffectInfo.class != obj.getClass()) {
            return false;
        }
        com.google.android.exoplayer2.audio.AuxEffectInfo auxEffectInfo = (com.google.android.exoplayer2.audio.AuxEffectInfo) obj;
        return this.effectId == auxEffectInfo.effectId && java.lang.Float.compare(auxEffectInfo.sendLevel, this.sendLevel) == 0;
    }

    public int hashCode() {
        return ((527 + this.effectId) * 31) + java.lang.Float.floatToIntBits(this.sendLevel);
    }
}
