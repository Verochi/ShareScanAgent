package com.google.android.exoplayer2.upstream;

/* loaded from: classes22.dex */
public final class ParsingLoadable<T> implements com.google.android.exoplayer2.upstream.Loader.Loadable {
    public final com.google.android.exoplayer2.upstream.StatsDataSource a;
    public final com.google.android.exoplayer2.upstream.ParsingLoadable.Parser<? extends T> b;

    @androidx.annotation.Nullable
    public volatile T c;
    public final com.google.android.exoplayer2.upstream.DataSpec dataSpec;
    public final long loadTaskId;
    public final int type;

    public interface Parser<T> {
        T parse(android.net.Uri uri, java.io.InputStream inputStream) throws java.io.IOException;
    }

    public ParsingLoadable(com.google.android.exoplayer2.upstream.DataSource dataSource, android.net.Uri uri, int i, com.google.android.exoplayer2.upstream.ParsingLoadable.Parser<? extends T> parser) {
        this(dataSource, new com.google.android.exoplayer2.upstream.DataSpec.Builder().setUri(uri).setFlags(1).build(), i, parser);
    }

    public ParsingLoadable(com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.upstream.DataSpec dataSpec, int i, com.google.android.exoplayer2.upstream.ParsingLoadable.Parser<? extends T> parser) {
        this.a = new com.google.android.exoplayer2.upstream.StatsDataSource(dataSource);
        this.dataSpec = dataSpec;
        this.type = i;
        this.b = parser;
        this.loadTaskId = com.google.android.exoplayer2.source.LoadEventInfo.getNewId();
    }

    public static <T> T load(com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.upstream.ParsingLoadable.Parser<? extends T> parser, android.net.Uri uri, int i) throws java.io.IOException {
        com.google.android.exoplayer2.upstream.ParsingLoadable parsingLoadable = new com.google.android.exoplayer2.upstream.ParsingLoadable(dataSource, uri, i, parser);
        parsingLoadable.load();
        return (T) com.google.android.exoplayer2.util.Assertions.checkNotNull(parsingLoadable.getResult());
    }

    public static <T> T load(com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.upstream.ParsingLoadable.Parser<? extends T> parser, com.google.android.exoplayer2.upstream.DataSpec dataSpec, int i) throws java.io.IOException {
        com.google.android.exoplayer2.upstream.ParsingLoadable parsingLoadable = new com.google.android.exoplayer2.upstream.ParsingLoadable(dataSource, dataSpec, i, parser);
        parsingLoadable.load();
        return (T) com.google.android.exoplayer2.util.Assertions.checkNotNull(parsingLoadable.getResult());
    }

    public long bytesLoaded() {
        return this.a.getBytesRead();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public final void cancelLoad() {
    }

    public java.util.Map<java.lang.String, java.util.List<java.lang.String>> getResponseHeaders() {
        return this.a.getLastResponseHeaders();
    }

    @androidx.annotation.Nullable
    public final T getResult() {
        return this.c;
    }

    public android.net.Uri getUri() {
        return this.a.getLastOpenedUri();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public final void load() throws java.io.IOException {
        this.a.resetBytesRead();
        com.google.android.exoplayer2.upstream.DataSourceInputStream dataSourceInputStream = new com.google.android.exoplayer2.upstream.DataSourceInputStream(this.a, this.dataSpec);
        try {
            dataSourceInputStream.open();
            this.c = this.b.parse((android.net.Uri) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.a.getUri()), dataSourceInputStream);
        } finally {
            com.google.android.exoplayer2.util.Util.closeQuietly(dataSourceInputStream);
        }
    }
}
