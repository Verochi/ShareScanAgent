package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class js {
    public static long a(com.google.android.exoplayer2.upstream.cache.ContentMetadata contentMetadata) {
        return contentMetadata.get(com.google.android.exoplayer2.upstream.cache.ContentMetadata.KEY_CONTENT_LENGTH, -1L);
    }

    @androidx.annotation.Nullable
    public static android.net.Uri b(com.google.android.exoplayer2.upstream.cache.ContentMetadata contentMetadata) {
        java.lang.String str = contentMetadata.get(com.google.android.exoplayer2.upstream.cache.ContentMetadata.KEY_REDIRECTED_URI, (java.lang.String) null);
        if (str == null) {
            return null;
        }
        return android.net.Uri.parse(str);
    }
}
