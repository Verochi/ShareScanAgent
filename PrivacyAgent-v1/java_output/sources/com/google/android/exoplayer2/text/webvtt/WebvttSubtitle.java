package com.google.android.exoplayer2.text.webvtt;

/* loaded from: classes22.dex */
final class WebvttSubtitle implements com.google.android.exoplayer2.text.Subtitle {
    public final java.util.List<com.google.android.exoplayer2.text.webvtt.WebvttCueInfo> n;
    public final long[] t;
    public final long[] u;

    public WebvttSubtitle(java.util.List<com.google.android.exoplayer2.text.webvtt.WebvttCueInfo> list) {
        this.n = java.util.Collections.unmodifiableList(new java.util.ArrayList(list));
        this.t = new long[list.size() * 2];
        for (int i = 0; i < list.size(); i++) {
            com.google.android.exoplayer2.text.webvtt.WebvttCueInfo webvttCueInfo = list.get(i);
            int i2 = i * 2;
            long[] jArr = this.t;
            jArr[i2] = webvttCueInfo.startTimeUs;
            jArr[i2 + 1] = webvttCueInfo.endTimeUs;
        }
        long[] jArr2 = this.t;
        long[] copyOf = java.util.Arrays.copyOf(jArr2, jArr2.length);
        this.u = copyOf;
        java.util.Arrays.sort(copyOf);
    }

    public static /* synthetic */ int b(com.google.android.exoplayer2.text.webvtt.WebvttCueInfo webvttCueInfo, com.google.android.exoplayer2.text.webvtt.WebvttCueInfo webvttCueInfo2) {
        return java.lang.Long.compare(webvttCueInfo.startTimeUs, webvttCueInfo2.startTimeUs);
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public java.util.List<com.google.android.exoplayer2.text.Cue> getCues(long j) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        for (int i = 0; i < this.n.size(); i++) {
            long[] jArr = this.t;
            int i2 = i * 2;
            if (jArr[i2] <= j && j < jArr[i2 + 1]) {
                com.google.android.exoplayer2.text.webvtt.WebvttCueInfo webvttCueInfo = this.n.get(i);
                com.google.android.exoplayer2.text.Cue cue = webvttCueInfo.cue;
                if (cue.line == -3.4028235E38f) {
                    arrayList2.add(webvttCueInfo);
                } else {
                    arrayList.add(cue);
                }
            }
        }
        java.util.Collections.sort(arrayList2, new com.google.android.exoplayer2.text.webvtt.b());
        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
            arrayList.add(((com.google.android.exoplayer2.text.webvtt.WebvttCueInfo) arrayList2.get(i3)).cue.buildUpon().setLine((-1) - i3, 1).build());
        }
        return arrayList;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public long getEventTime(int i) {
        com.google.android.exoplayer2.util.Assertions.checkArgument(i >= 0);
        com.google.android.exoplayer2.util.Assertions.checkArgument(i < this.u.length);
        return this.u[i];
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getEventTimeCount() {
        return this.u.length;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getNextEventTimeIndex(long j) {
        int binarySearchCeil = com.google.android.exoplayer2.util.Util.binarySearchCeil(this.u, j, false, false);
        if (binarySearchCeil < this.u.length) {
            return binarySearchCeil;
        }
        return -1;
    }
}
