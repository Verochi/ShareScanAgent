package com.google.android.exoplayer2;

/* loaded from: classes22.dex */
public final /* synthetic */ class g implements com.google.android.exoplayer2.BasePlayer.ListenerInvocation {
    public final /* synthetic */ int a;

    public /* synthetic */ g(int i) {
        this.a = i;
    }

    @Override // com.google.android.exoplayer2.BasePlayer.ListenerInvocation
    public final void invokeListener(com.google.android.exoplayer2.Player.EventListener eventListener) {
        eventListener.onRepeatModeChanged(this.a);
    }
}
