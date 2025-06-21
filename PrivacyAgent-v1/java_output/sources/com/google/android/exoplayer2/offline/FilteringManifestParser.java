package com.google.android.exoplayer2.offline;

/* loaded from: classes22.dex */
public final class FilteringManifestParser<T extends com.google.android.exoplayer2.offline.FilterableManifest<T>> implements com.google.android.exoplayer2.upstream.ParsingLoadable.Parser<T> {
    public final com.google.android.exoplayer2.upstream.ParsingLoadable.Parser<? extends T> n;

    @androidx.annotation.Nullable
    public final java.util.List<com.google.android.exoplayer2.offline.StreamKey> t;

    public FilteringManifestParser(com.google.android.exoplayer2.upstream.ParsingLoadable.Parser<? extends T> parser, @androidx.annotation.Nullable java.util.List<com.google.android.exoplayer2.offline.StreamKey> list) {
        this.n = parser;
        this.t = list;
    }

    @Override // com.google.android.exoplayer2.upstream.ParsingLoadable.Parser
    public T parse(android.net.Uri uri, java.io.InputStream inputStream) throws java.io.IOException {
        T parse = this.n.parse(uri, inputStream);
        java.util.List<com.google.android.exoplayer2.offline.StreamKey> list = this.t;
        return (list == null || list.isEmpty()) ? parse : (T) parse.copy(this.t);
    }
}
