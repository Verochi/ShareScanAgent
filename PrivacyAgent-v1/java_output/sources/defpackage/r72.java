package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class r72 implements com.moji.shorttime.ui.player.CacheListener {
    public final /* synthetic */ com.moji.shorttime.ui.player.RadarPlayer a;

    public /* synthetic */ r72(com.moji.shorttime.ui.player.RadarPlayer radarPlayer) {
        this.a = radarPlayer;
    }

    public final void onLoadingProgressUpdated(float f) {
        com.moji.shorttime.ui.player.RadarPlayer.a(this.a, f);
    }
}
