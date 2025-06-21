package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class k32 implements android.os.Handler.Callback {
    public final /* synthetic */ com.google.android.exoplayer2.ui.PlayerNotificationManager n;

    public /* synthetic */ k32(com.google.android.exoplayer2.ui.PlayerNotificationManager playerNotificationManager) {
        this.n = playerNotificationManager;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(android.os.Message message) {
        boolean o;
        o = this.n.o(message);
        return o;
    }
}
