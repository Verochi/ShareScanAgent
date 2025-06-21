package com.google.android.exoplayer2;

/* loaded from: classes22.dex */
public final /* synthetic */ class j implements com.google.android.exoplayer2.BasePlayer.ListenerInvocation {
    public final /* synthetic */ com.google.android.exoplayer2.ExoPlayerImpl.PlaybackInfoUpdate a;

    public /* synthetic */ j(com.google.android.exoplayer2.ExoPlayerImpl.PlaybackInfoUpdate playbackInfoUpdate) {
        this.a = playbackInfoUpdate;
    }

    @Override // com.google.android.exoplayer2.BasePlayer.ListenerInvocation
    public final void invokeListener(com.google.android.exoplayer2.Player.EventListener eventListener) {
        this.a.o(eventListener);
    }
}
