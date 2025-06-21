package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class ud1 {
    @java.lang.Deprecated
    public static com.google.android.exoplayer2.source.MediaSource a(com.google.android.exoplayer2.source.MediaSourceFactory mediaSourceFactory, android.net.Uri uri) {
        return mediaSourceFactory.createMediaSource(com.google.android.exoplayer2.MediaItem.fromUri(uri));
    }

    @java.lang.Deprecated
    public static com.google.android.exoplayer2.source.MediaSourceFactory b(com.google.android.exoplayer2.source.MediaSourceFactory mediaSourceFactory, @androidx.annotation.Nullable java.util.List list) {
        return mediaSourceFactory;
    }
}
