package com.alimm.tanx.core.view.player.core.audio;

/* loaded from: classes.dex */
public class DefaultAudioFocusChangeListener implements android.media.AudioManager.OnAudioFocusChangeListener {
    private final java.lang.ref.WeakReference<android.content.Context> contextReference;
    private final com.alimm.tanx.core.view.player.core.audio.IAudioManager iAudioManager;
    private final com.alimm.tanx.core.view.player.core.ITanxPlayer iTanxPlayer;
    private boolean playOnAudioFocus = true;

    public DefaultAudioFocusChangeListener(java.lang.ref.WeakReference<android.content.Context> weakReference, com.alimm.tanx.core.view.player.core.audio.IAudioManager iAudioManager, com.alimm.tanx.core.view.player.core.ITanxPlayer iTanxPlayer) {
        this.contextReference = weakReference;
        this.iAudioManager = iAudioManager;
        this.iTanxPlayer = iTanxPlayer;
    }

    public int getCurrentVolume(android.content.Context context) {
        android.media.AudioManager audioManager = (android.media.AudioManager) context.getSystemService("audio");
        return (int) ((audioManager.getStreamVolume(3) * 1.0f) / audioManager.getStreamMaxVolume(3));
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public void onAudioFocusChange(int i) {
        android.content.Context context;
        if (this.iTanxPlayer == null || (context = this.contextReference.get()) == null) {
            return;
        }
        if (1 == i) {
            if (this.playOnAudioFocus && !this.iTanxPlayer.isPlaying()) {
                this.iTanxPlayer.start();
            } else if (this.iTanxPlayer.isPlaying()) {
                this.iTanxPlayer.setVolume(getCurrentVolume(context));
            }
            this.playOnAudioFocus = false;
            return;
        }
        if (-3 == i) {
            this.iTanxPlayer.setVolume(getCurrentVolume(context) * 0.8f);
            return;
        }
        if (-2 == i) {
            if (this.iTanxPlayer.isPlaying()) {
                this.playOnAudioFocus = true;
                this.iTanxPlayer.pause();
                return;
            }
            return;
        }
        if (-1 == i) {
            this.iAudioManager.abandonAudioFocus();
            this.playOnAudioFocus = false;
            this.iTanxPlayer.stop();
        }
    }
}
