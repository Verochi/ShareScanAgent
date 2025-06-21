package com.google.android.exoplayer2.source.dash.manifest;

/* loaded from: classes22.dex */
public class Period {
    public final java.util.List<com.google.android.exoplayer2.source.dash.manifest.AdaptationSet> adaptationSets;

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.source.dash.manifest.Descriptor assetIdentifier;
    public final java.util.List<com.google.android.exoplayer2.source.dash.manifest.EventStream> eventStreams;

    @androidx.annotation.Nullable
    public final java.lang.String id;
    public final long startMs;

    public Period(@androidx.annotation.Nullable java.lang.String str, long j, java.util.List<com.google.android.exoplayer2.source.dash.manifest.AdaptationSet> list) {
        this(str, j, list, java.util.Collections.emptyList(), null);
    }

    public Period(@androidx.annotation.Nullable java.lang.String str, long j, java.util.List<com.google.android.exoplayer2.source.dash.manifest.AdaptationSet> list, java.util.List<com.google.android.exoplayer2.source.dash.manifest.EventStream> list2) {
        this(str, j, list, list2, null);
    }

    public Period(@androidx.annotation.Nullable java.lang.String str, long j, java.util.List<com.google.android.exoplayer2.source.dash.manifest.AdaptationSet> list, java.util.List<com.google.android.exoplayer2.source.dash.manifest.EventStream> list2, @androidx.annotation.Nullable com.google.android.exoplayer2.source.dash.manifest.Descriptor descriptor) {
        this.id = str;
        this.startMs = j;
        this.adaptationSets = java.util.Collections.unmodifiableList(list);
        this.eventStreams = java.util.Collections.unmodifiableList(list2);
        this.assetIdentifier = descriptor;
    }

    public int getAdaptationSetIndex(int i) {
        int size = this.adaptationSets.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.adaptationSets.get(i2).type == i) {
                return i2;
            }
        }
        return -1;
    }
}
