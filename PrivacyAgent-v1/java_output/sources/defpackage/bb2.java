package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class bb2 implements android.media.MediaPlayer.OnInfoListener {
    public final /* synthetic */ com.moji.shorttime.ui.record.RecordVideoShareDialog n;

    public /* synthetic */ bb2(com.moji.shorttime.ui.record.RecordVideoShareDialog recordVideoShareDialog) {
        this.n = recordVideoShareDialog;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public final boolean onInfo(android.media.MediaPlayer mediaPlayer, int i, int i2) {
        return com.moji.shorttime.ui.record.RecordVideoShareDialog.d(this.n, mediaPlayer, i, i2);
    }
}
