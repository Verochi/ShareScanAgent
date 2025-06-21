package com.google.android.exoplayer2;

/* loaded from: classes22.dex */
final class PlaylistTimeline extends com.google.android.exoplayer2.AbstractConcatenatedTimeline {
    public final int d;
    public final int e;
    public final int[] f;
    public final int[] g;
    public final com.google.android.exoplayer2.Timeline[] h;
    public final java.lang.Object[] i;
    public final java.util.HashMap<java.lang.Object, java.lang.Integer> j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlaylistTimeline(java.util.Collection<? extends com.google.android.exoplayer2.MediaSourceInfoHolder> collection, com.google.android.exoplayer2.source.ShuffleOrder shuffleOrder) {
        super(false, shuffleOrder);
        int i = 0;
        int size = collection.size();
        this.f = new int[size];
        this.g = new int[size];
        this.h = new com.google.android.exoplayer2.Timeline[size];
        this.i = new java.lang.Object[size];
        this.j = new java.util.HashMap<>();
        int i2 = 0;
        int i3 = 0;
        for (com.google.android.exoplayer2.MediaSourceInfoHolder mediaSourceInfoHolder : collection) {
            this.h[i3] = mediaSourceInfoHolder.a();
            this.g[i3] = i;
            this.f[i3] = i2;
            i += this.h[i3].getWindowCount();
            i2 += this.h[i3].getPeriodCount();
            this.i[i3] = mediaSourceInfoHolder.getUid();
            this.j.put(this.i[i3], java.lang.Integer.valueOf(i3));
            i3++;
        }
        this.d = i;
        this.e = i2;
    }

    public java.util.List<com.google.android.exoplayer2.Timeline> c() {
        return java.util.Arrays.asList(this.h);
    }

    @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
    public int getChildIndexByChildUid(java.lang.Object obj) {
        java.lang.Integer num = this.j.get(obj);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
    public int getChildIndexByPeriodIndex(int i) {
        return com.google.android.exoplayer2.util.Util.binarySearchFloor(this.f, i + 1, false, false);
    }

    @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
    public int getChildIndexByWindowIndex(int i) {
        return com.google.android.exoplayer2.util.Util.binarySearchFloor(this.g, i + 1, false, false);
    }

    @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
    public java.lang.Object getChildUidByChildIndex(int i) {
        return this.i[i];
    }

    @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
    public int getFirstPeriodIndexByChildIndex(int i) {
        return this.f[i];
    }

    @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
    public int getFirstWindowIndexByChildIndex(int i) {
        return this.g[i];
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getPeriodCount() {
        return this.e;
    }

    @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
    public com.google.android.exoplayer2.Timeline getTimelineByChildIndex(int i) {
        return this.h[i];
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getWindowCount() {
        return this.d;
    }
}
