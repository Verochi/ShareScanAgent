package com.google.android.exoplayer2;

/* loaded from: classes22.dex */
public final /* synthetic */ class e implements com.google.android.exoplayer2.BasePlayer.ListenerInvocation {
    public final /* synthetic */ boolean a;

    public /* synthetic */ e(boolean z) {
        this.a = z;
    }

    @Override // com.google.android.exoplayer2.BasePlayer.ListenerInvocation
    public final void invokeListener(com.google.android.exoplayer2.Player.EventListener eventListener) {
        eventListener.onShuffleModeEnabledChanged(this.a);
    }
}
