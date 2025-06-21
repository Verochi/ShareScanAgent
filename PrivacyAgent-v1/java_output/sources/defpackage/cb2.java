package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class cb2 implements android.media.MediaPlayer.OnErrorListener {
    public final /* synthetic */ com.moji.shorttime.ui.record.RecordVideoShareDialog n;

    public /* synthetic */ cb2(com.moji.shorttime.ui.record.RecordVideoShareDialog recordVideoShareDialog) {
        this.n = recordVideoShareDialog;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(android.media.MediaPlayer mediaPlayer, int i, int i2) {
        return com.moji.shorttime.ui.record.RecordVideoShareDialog.g(this.n, mediaPlayer, i, i2);
    }
}
