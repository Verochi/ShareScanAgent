package com.google.android.exoplayer2.upstream;

/* loaded from: classes22.dex */
public final class PriorityDataSourceFactory implements com.google.android.exoplayer2.upstream.DataSource.Factory {
    public final com.google.android.exoplayer2.upstream.DataSource.Factory a;
    public final com.google.android.exoplayer2.util.PriorityTaskManager b;
    public final int c;

    public PriorityDataSourceFactory(com.google.android.exoplayer2.upstream.DataSource.Factory factory, com.google.android.exoplayer2.util.PriorityTaskManager priorityTaskManager, int i) {
        this.a = factory;
        this.b = priorityTaskManager;
        this.c = i;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource.Factory
    public com.google.android.exoplayer2.upstream.PriorityDataSource createDataSource() {
        return new com.google.android.exoplayer2.upstream.PriorityDataSource(this.a.createDataSource(), this.b, this.c);
    }
}
