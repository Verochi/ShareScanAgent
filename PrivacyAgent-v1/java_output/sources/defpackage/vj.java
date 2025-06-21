package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class vj {
    static {
        com.google.android.exoplayer2.upstream.cache.CacheKeyFactory cacheKeyFactory = com.google.android.exoplayer2.upstream.cache.CacheKeyFactory.DEFAULT;
    }

    public static /* synthetic */ java.lang.String a(com.google.android.exoplayer2.upstream.DataSpec dataSpec) {
        java.lang.String str = dataSpec.key;
        return str != null ? str : dataSpec.uri.toString();
    }
}
