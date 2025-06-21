package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class ab2 implements android.media.MediaPlayer.OnPreparedListener {
    public final /* synthetic */ com.moji.shorttime.ui.record.RecordVideoShareDialog n;

    public /* synthetic */ ab2(com.moji.shorttime.ui.record.RecordVideoShareDialog recordVideoShareDialog) {
        this.n = recordVideoShareDialog;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public final void onPrepared(android.media.MediaPlayer mediaPlayer) {
        com.moji.shorttime.ui.record.RecordVideoShareDialog.j(this.n, mediaPlayer);
    }
}
