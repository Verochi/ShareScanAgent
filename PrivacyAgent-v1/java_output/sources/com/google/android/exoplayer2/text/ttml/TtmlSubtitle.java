package com.google.android.exoplayer2.text.ttml;

/* loaded from: classes22.dex */
final class TtmlSubtitle implements com.google.android.exoplayer2.text.Subtitle {
    public final com.google.android.exoplayer2.text.ttml.TtmlNode n;
    public final long[] t;
    public final java.util.Map<java.lang.String, com.google.android.exoplayer2.text.ttml.TtmlStyle> u;
    public final java.util.Map<java.lang.String, com.google.android.exoplayer2.text.ttml.TtmlRegion> v;
    public final java.util.Map<java.lang.String, java.lang.String> w;

    public TtmlSubtitle(com.google.android.exoplayer2.text.ttml.TtmlNode ttmlNode, java.util.Map<java.lang.String, com.google.android.exoplayer2.text.ttml.TtmlStyle> map, java.util.Map<java.lang.String, com.google.android.exoplayer2.text.ttml.TtmlRegion> map2, java.util.Map<java.lang.String, java.lang.String> map3) {
        this.n = ttmlNode;
        this.v = map2;
        this.w = map3;
        this.u = map != null ? java.util.Collections.unmodifiableMap(map) : java.util.Collections.emptyMap();
        this.t = ttmlNode.j();
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public java.util.List<com.google.android.exoplayer2.text.Cue> getCues(long j) {
        return this.n.h(j, this.u, this.v, this.w);
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public long getEventTime(int i) {
        return this.t[i];
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getEventTimeCount() {
        return this.t.length;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getNextEventTimeIndex(long j) {
        int binarySearchCeil = com.google.android.exoplayer2.util.Util.binarySearchCeil(this.t, j, false, false);
        if (binarySearchCeil < this.t.length) {
            return binarySearchCeil;
        }
        return -1;
    }
}
