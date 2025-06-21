package com.google.android.exoplayer2.offline;

/* loaded from: classes22.dex */
public final /* synthetic */ class a implements android.os.Handler.Callback {
    public final /* synthetic */ com.google.android.exoplayer2.offline.DownloadHelper.MediaPreparer n;

    public /* synthetic */ a(com.google.android.exoplayer2.offline.DownloadHelper.MediaPreparer mediaPreparer) {
        this.n = mediaPreparer;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(android.os.Message message) {
        boolean b;
        b = this.n.b(message);
        return b;
    }
}
