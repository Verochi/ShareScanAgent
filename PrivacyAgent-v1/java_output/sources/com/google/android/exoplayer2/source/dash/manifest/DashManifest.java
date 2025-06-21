package com.google.android.exoplayer2.source.dash.manifest;

/* loaded from: classes22.dex */
public class DashManifest implements com.google.android.exoplayer2.offline.FilterableManifest<com.google.android.exoplayer2.source.dash.manifest.DashManifest> {
    public final java.util.List<com.google.android.exoplayer2.source.dash.manifest.Period> a;
    public final long availabilityStartTimeMs;
    public final long durationMs;
    public final boolean dynamic;

    @androidx.annotation.Nullable
    public final android.net.Uri location;
    public final long minBufferTimeMs;
    public final long minUpdatePeriodMs;

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.source.dash.manifest.ProgramInformation programInformation;
    public final long publishTimeMs;
    public final long suggestedPresentationDelayMs;
    public final long timeShiftBufferDepthMs;

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.source.dash.manifest.UtcTimingElement utcTiming;

    public DashManifest(long j, long j2, long j3, boolean z, long j4, long j5, long j6, long j7, @androidx.annotation.Nullable com.google.android.exoplayer2.source.dash.manifest.ProgramInformation programInformation, @androidx.annotation.Nullable com.google.android.exoplayer2.source.dash.manifest.UtcTimingElement utcTimingElement, @androidx.annotation.Nullable android.net.Uri uri, java.util.List<com.google.android.exoplayer2.source.dash.manifest.Period> list) {
        this.availabilityStartTimeMs = j;
        this.durationMs = j2;
        this.minBufferTimeMs = j3;
        this.dynamic = z;
        this.minUpdatePeriodMs = j4;
        this.timeShiftBufferDepthMs = j5;
        this.suggestedPresentationDelayMs = j6;
        this.publishTimeMs = j7;
        this.programInformation = programInformation;
        this.utcTiming = utcTimingElement;
        this.location = uri;
        this.a = list == null ? java.util.Collections.emptyList() : list;
    }

    @java.lang.Deprecated
    public DashManifest(long j, long j2, long j3, boolean z, long j4, long j5, long j6, long j7, @androidx.annotation.Nullable com.google.android.exoplayer2.source.dash.manifest.UtcTimingElement utcTimingElement, @androidx.annotation.Nullable android.net.Uri uri, java.util.List<com.google.android.exoplayer2.source.dash.manifest.Period> list) {
        this(j, j2, j3, z, j4, j5, j6, j7, null, utcTimingElement, uri, list);
    }

    public static java.util.ArrayList<com.google.android.exoplayer2.source.dash.manifest.AdaptationSet> a(java.util.List<com.google.android.exoplayer2.source.dash.manifest.AdaptationSet> list, java.util.LinkedList<com.google.android.exoplayer2.offline.StreamKey> linkedList) {
        com.google.android.exoplayer2.offline.StreamKey poll = linkedList.poll();
        int i = poll.periodIndex;
        java.util.ArrayList<com.google.android.exoplayer2.source.dash.manifest.AdaptationSet> arrayList = new java.util.ArrayList<>();
        do {
            int i2 = poll.groupIndex;
            com.google.android.exoplayer2.source.dash.manifest.AdaptationSet adaptationSet = list.get(i2);
            java.util.List<com.google.android.exoplayer2.source.dash.manifest.Representation> list2 = adaptationSet.representations;
            java.util.ArrayList arrayList2 = new java.util.ArrayList();
            do {
                arrayList2.add(list2.get(poll.trackIndex));
                poll = linkedList.poll();
                if (poll.periodIndex != i) {
                    break;
                }
            } while (poll.groupIndex == i2);
            arrayList.add(new com.google.android.exoplayer2.source.dash.manifest.AdaptationSet(adaptationSet.id, adaptationSet.type, arrayList2, adaptationSet.accessibilityDescriptors, adaptationSet.essentialProperties, adaptationSet.supplementalProperties));
        } while (poll.periodIndex == i);
        linkedList.addFirst(poll);
        return arrayList;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.exoplayer2.offline.FilterableManifest
    public final com.google.android.exoplayer2.source.dash.manifest.DashManifest copy(java.util.List<com.google.android.exoplayer2.offline.StreamKey> list) {
        java.util.LinkedList linkedList = new java.util.LinkedList(list);
        java.util.Collections.sort(linkedList);
        linkedList.add(new com.google.android.exoplayer2.offline.StreamKey(-1, -1, -1));
        java.util.ArrayList arrayList = new java.util.ArrayList();
        long j = 0;
        int i = 0;
        while (true) {
            if (i >= getPeriodCount()) {
                break;
            }
            if (((com.google.android.exoplayer2.offline.StreamKey) linkedList.peek()).periodIndex != i) {
                long periodDurationMs = getPeriodDurationMs(i);
                if (periodDurationMs != -9223372036854775807L) {
                    j += periodDurationMs;
                }
            } else {
                com.google.android.exoplayer2.source.dash.manifest.Period period = getPeriod(i);
                arrayList.add(new com.google.android.exoplayer2.source.dash.manifest.Period(period.id, period.startMs - j, a(period.adaptationSets, linkedList), period.eventStreams));
            }
            i++;
        }
        long j2 = this.durationMs;
        return new com.google.android.exoplayer2.source.dash.manifest.DashManifest(this.availabilityStartTimeMs, j2 != -9223372036854775807L ? j2 - j : -9223372036854775807L, this.minBufferTimeMs, this.dynamic, this.minUpdatePeriodMs, this.timeShiftBufferDepthMs, this.suggestedPresentationDelayMs, this.publishTimeMs, this.programInformation, this.utcTiming, this.location, arrayList);
    }

    @Override // com.google.android.exoplayer2.offline.FilterableManifest
    public /* bridge */ /* synthetic */ com.google.android.exoplayer2.source.dash.manifest.DashManifest copy(java.util.List list) {
        return copy((java.util.List<com.google.android.exoplayer2.offline.StreamKey>) list);
    }

    public final com.google.android.exoplayer2.source.dash.manifest.Period getPeriod(int i) {
        return this.a.get(i);
    }

    public final int getPeriodCount() {
        return this.a.size();
    }

    public final long getPeriodDurationMs(int i) {
        long j;
        long j2;
        if (i == this.a.size() - 1) {
            j = this.durationMs;
            if (j == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            j2 = this.a.get(i).startMs;
        } else {
            j = this.a.get(i + 1).startMs;
            j2 = this.a.get(i).startMs;
        }
        return j - j2;
    }

    public final long getPeriodDurationUs(int i) {
        return com.google.android.exoplayer2.C.msToUs(getPeriodDurationMs(i));
    }
}
