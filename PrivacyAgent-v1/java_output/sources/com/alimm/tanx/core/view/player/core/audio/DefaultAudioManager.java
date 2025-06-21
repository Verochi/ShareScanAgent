package com.alimm.tanx.core.view.player.core.audio;

/* loaded from: classes.dex */
public class DefaultAudioManager implements com.alimm.tanx.core.view.player.core.audio.IAudioManager {
    private final android.media.AudioAttributes audioAttributes = new android.media.AudioAttributes.Builder().setUsage(1).setContentType(2).build();
    private android.media.AudioFocusRequest audioFocusRequest;
    private final android.media.AudioManager audioManager;
    private final android.content.Context context;
    private final com.alimm.tanx.core.view.player.core.ITanxPlayer iTanxPlayer;
    private final android.media.AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener;

    public DefaultAudioManager(android.content.Context context, com.alimm.tanx.core.view.player.core.ITanxPlayer iTanxPlayer) {
        this.context = context;
        this.iTanxPlayer = iTanxPlayer;
        this.audioManager = (android.media.AudioManager) context.getSystemService("audio");
        this.onAudioFocusChangeListener = new com.alimm.tanx.core.view.player.core.audio.DefaultAudioFocusChangeListener(new java.lang.ref.WeakReference(context), this, iTanxPlayer);
    }

    @Override // com.alimm.tanx.core.view.player.core.audio.IAudioManager
    public void abandonAudioFocus() {
        if (android.os.Build.VERSION.SDK_INT < 26) {
            this.audioManager.abandonAudioFocus(this.onAudioFocusChangeListener);
            return;
        }
        android.media.AudioFocusRequest audioFocusRequest = this.audioFocusRequest;
        if (audioFocusRequest != null) {
            this.audioManager.abandonAudioFocusRequest(audioFocusRequest);
        }
    }

    @Override // com.alimm.tanx.core.view.player.core.audio.IAudioManager
    public int getMaxVolume() {
        return this.audioManager.getStreamMaxVolume(3);
    }

    @Override // com.alimm.tanx.core.view.player.core.audio.IAudioManager
    public int getVolume() {
        return this.audioManager.getStreamVolume(3);
    }

    @Override // com.alimm.tanx.core.view.player.core.audio.IAudioManager
    public void mute() {
        this.audioManager.setStreamVolume(3, 0, 4);
    }

    @Override // com.alimm.tanx.core.view.player.core.audio.IAudioManager
    public void requestAudioFocus() {
        android.media.AudioFocusRequest.Builder audioAttributes;
        android.media.AudioFocusRequest.Builder acceptsDelayedFocusGain;
        android.media.AudioFocusRequest.Builder onAudioFocusChangeListener;
        android.media.AudioFocusRequest build;
        if (android.os.Build.VERSION.SDK_INT < 26) {
            this.audioManager.requestAudioFocus(this.onAudioFocusChangeListener, 3, 1);
            return;
        }
        audioAttributes = new android.media.AudioFocusRequest.Builder(1).setAudioAttributes(this.audioAttributes);
        acceptsDelayedFocusGain = audioAttributes.setAcceptsDelayedFocusGain(false);
        onAudioFocusChangeListener = acceptsDelayedFocusGain.setOnAudioFocusChangeListener(this.onAudioFocusChangeListener);
        build = onAudioFocusChangeListener.build();
        this.audioFocusRequest = build;
        this.audioManager.requestAudioFocus(build);
    }

    @Override // com.alimm.tanx.core.view.player.core.audio.IAudioManager
    public void setVolume(int i) {
        this.audioManager.setStreamVolume(3, i % this.audioManager.getStreamMaxVolume(3), 4);
    }
}
