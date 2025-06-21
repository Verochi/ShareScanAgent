package com.google.android.exoplayer2.audio;

/* loaded from: classes22.dex */
public interface AudioListener {
    void onAudioAttributesChanged(com.google.android.exoplayer2.audio.AudioAttributes audioAttributes);

    void onAudioSessionId(int i);

    void onSkipSilenceEnabledChanged(boolean z);

    void onVolumeChanged(float f);
}
