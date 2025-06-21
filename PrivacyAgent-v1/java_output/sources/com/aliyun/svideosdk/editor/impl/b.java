package com.aliyun.svideosdk.editor.impl;

/* loaded from: classes12.dex */
public class b implements com.aliyun.svideosdk.editor.AliyunIAudioController {
    private com.aliyun.svideosdk.editor.NativeEditor a;
    private com.aliyun.svideosdk.common.AliyunPip b;
    private com.aliyun.svideosdk.common.struct.project.PipVideoTrackClip c;
    private java.lang.ref.WeakReference<com.aliyun.svideosdk.editor.impl.g> d;

    public b(com.aliyun.svideosdk.editor.NativeEditor nativeEditor, com.aliyun.svideosdk.common.AliyunPip aliyunPip, com.aliyun.svideosdk.common.struct.project.PipVideoTrackClip pipVideoTrackClip, com.aliyun.svideosdk.editor.impl.g gVar) {
        this.a = nativeEditor;
        this.b = aliyunPip;
        this.c = pipVideoTrackClip;
        this.d = new java.lang.ref.WeakReference<>(gVar);
    }

    private static final int a(int i, boolean z) {
        return (!z ? i == 3 : i == 2) ? 0 : 1;
    }

    private void a() {
        this.c.setMixWeight(this.b.getVolume());
        this.c.setDenoiseWeight(this.b.getDenoiseWeight());
        com.aliyun.svideosdk.common.AliyunPip.AliyunAudioEffect audioEffect = this.b.getAudioEffect();
        com.aliyun.svideosdk.common.AliyunPip.AliyunAudioFade audioFadeIn = this.b.getAudioFadeIn();
        com.aliyun.svideosdk.common.AliyunPip.AliyunAudioFade audioFadeOut = this.b.getAudioFadeOut();
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        for (com.aliyun.svideosdk.common.struct.project.Effect effect : this.c.getEffects()) {
            if (effect.getType() == com.aliyun.svideosdk.common.struct.project.Effect.Type.audio_effect) {
                com.aliyun.svideosdk.common.struct.project.AudioEffect audioEffect2 = (com.aliyun.svideosdk.common.struct.project.AudioEffect) effect;
                audioEffect2.mEffectType = audioEffect.mEffectType;
                audioEffect2.mEffectParam = (int) (audioEffect.mEffectParam * 100.0f);
                z = true;
            } else if (effect.getType() == com.aliyun.svideosdk.common.struct.project.Effect.Type.audio_fade) {
                com.aliyun.svideosdk.common.struct.project.AudioFade audioFade = (com.aliyun.svideosdk.common.struct.project.AudioFade) effect;
                if (audioFade.isFadeIn) {
                    audioFade.shapeType = a(audioFadeIn.shapeType, true);
                    audioFade.duration = com.aliyun.common.media.TimeUnitUtil.microToSecond(audioFadeIn.duration);
                    z2 = true;
                } else {
                    audioFade.shapeType = a(audioFadeOut.shapeType, false);
                    audioFade.duration = com.aliyun.common.media.TimeUnitUtil.microToSecond(audioFadeOut.duration);
                    z3 = true;
                }
            }
        }
        if (!z) {
            com.aliyun.svideosdk.common.struct.project.AudioEffect audioEffect3 = new com.aliyun.svideosdk.common.struct.project.AudioEffect();
            audioEffect3.mEffectType = audioEffect.mEffectType;
            audioEffect3.mEffectParam = (int) (audioEffect.mEffectParam * 100.0f);
            this.c.getEffects().add(audioEffect3);
        }
        if (!z2) {
            long j = audioFadeIn.duration;
            if (j > 0) {
                this.c.getEffects().add(new com.aliyun.svideosdk.common.struct.project.AudioFade(audioFadeIn.shapeType, j, true));
            }
        }
        if (z3) {
            return;
        }
        long j2 = audioFadeOut.duration;
        if (j2 > 0) {
            this.c.getEffects().add(new com.aliyun.svideosdk.common.struct.project.AudioFade(audioFadeOut.shapeType, j2, false));
        }
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIAudioController
    public int apply() {
        this.a.updatePicInPic(this.b.getNativeHandle());
        a();
        if (this.d.get() == null) {
            return 0;
        }
        this.d.get().saveEffectToLocal();
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIAudioController
    public com.aliyun.svideosdk.editor.AliyunIAudioController denoise(int i) {
        this.b.setDenoiseWeight(i);
        return this;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIAudioController
    public int getVolume() {
        return this.b.getVolume();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIAudioController
    public com.aliyun.svideosdk.editor.AliyunIAudioController removeAudioFadeIn() {
        this.b.setAudioFadeIn(new com.aliyun.svideosdk.common.AliyunPip.AliyunAudioFade(0, 0L, true));
        return this;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIAudioController
    public com.aliyun.svideosdk.editor.AliyunIAudioController removeAudioFadeOut() {
        this.b.setAudioFadeOut(new com.aliyun.svideosdk.common.AliyunPip.AliyunAudioFade(1, 0L, false));
        return this;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIAudioController
    public com.aliyun.svideosdk.editor.AliyunIAudioController setAudioEffect(com.aliyun.svideosdk.editor.AudioEffectType audioEffectType, float f) {
        this.b.addEffect(new com.aliyun.svideosdk.common.AliyunPip.AliyunAudioEffect(audioEffectType.getEffectType(), f));
        return this;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIAudioController
    public com.aliyun.svideosdk.editor.AliyunIAudioController setAudioFadeIn(com.aliyun.svideosdk.editor.ShapeType shapeType, long j) {
        this.b.setAudioFadeIn(new com.aliyun.svideosdk.common.AliyunPip.AliyunAudioFade(shapeType == com.aliyun.svideosdk.editor.ShapeType.SHAPE_TYPE_LINEAR ? 0 : 2, com.aliyun.common.media.TimeUnitUtil.millToMicros(j), true));
        return this;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIAudioController
    public com.aliyun.svideosdk.editor.AliyunIAudioController setAudioFadeOut(com.aliyun.svideosdk.editor.ShapeType shapeType, long j) {
        this.b.setAudioFadeOut(new com.aliyun.svideosdk.common.AliyunPip.AliyunAudioFade(shapeType == com.aliyun.svideosdk.editor.ShapeType.SHAPE_TYPE_LINEAR ? 1 : 3, com.aliyun.common.media.TimeUnitUtil.millToMicros(j), false));
        return this;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIAudioController
    public com.aliyun.svideosdk.editor.AliyunIAudioController setVolume(int i) {
        this.b.setVolume(i);
        return this;
    }
}
