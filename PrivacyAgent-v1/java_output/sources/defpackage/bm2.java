package defpackage;

/* loaded from: classes29.dex */
public final /* synthetic */ class bm2 implements com.moji.requestcore.ProgressListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ com.moji.skywatchers.upload.SkyWatcherUploadAsyncTask c;

    public /* synthetic */ bm2(int i, int i2, com.moji.skywatchers.upload.SkyWatcherUploadAsyncTask skyWatcherUploadAsyncTask) {
        this.a = i;
        this.b = i2;
        this.c = skyWatcherUploadAsyncTask;
    }

    public final void update(long j, long j2, boolean z) {
        com.moji.skywatchers.upload.SkyWatcherUploadAsyncTask.j(this.a, this.b, this.c, j, j2, z);
    }
}
