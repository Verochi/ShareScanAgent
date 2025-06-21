package com.ss.android.socialbase.downloader.segment;

/* loaded from: classes19.dex */
public final class Segment {
    private static final java.lang.String TAG = "Segment";
    int competitor;
    private final java.util.concurrent.atomic.AtomicLong currentOffset;
    private volatile long currentOffsetRead;
    private long endOffset;
    private int index;
    private org.json.JSONObject jsonObject;
    volatile com.ss.android.socialbase.downloader.segment.SegmentReader owner;
    private final long startOffset;

    /* renamed from: com.ss.android.socialbase.downloader.segment.Segment$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.util.Comparator<com.ss.android.socialbase.downloader.segment.Segment> {
        @Override // java.util.Comparator
        public int compare(com.ss.android.socialbase.downloader.segment.Segment segment, com.ss.android.socialbase.downloader.segment.Segment segment2) {
            return (int) (segment.getStartOffset() - segment2.getStartOffset());
        }
    }

    public interface JsonKey {
        public static final java.lang.String CURRENT = "cu";
        public static final java.lang.String END = "en";
        public static final java.lang.String START = "st";
    }

    public Segment(long j) {
        this(j, -1L);
    }

    public Segment(long j, long j2) {
        java.util.concurrent.atomic.AtomicLong atomicLong = new java.util.concurrent.atomic.AtomicLong();
        this.currentOffset = atomicLong;
        this.competitor = 0;
        this.startOffset = j;
        atomicLong.set(j);
        this.currentOffsetRead = j;
        if (j2 >= j) {
            this.endOffset = j2;
        } else {
            this.endOffset = -1L;
        }
    }

    public Segment(com.ss.android.socialbase.downloader.segment.Segment segment) {
        java.util.concurrent.atomic.AtomicLong atomicLong = new java.util.concurrent.atomic.AtomicLong();
        this.currentOffset = atomicLong;
        this.competitor = 0;
        this.startOffset = segment.startOffset;
        this.endOffset = segment.endOffset;
        atomicLong.set(segment.currentOffset.get());
        this.currentOffsetRead = atomicLong.get();
        this.index = segment.index;
    }

    public Segment(org.json.JSONObject jSONObject) {
        this.currentOffset = new java.util.concurrent.atomic.AtomicLong();
        this.competitor = 0;
        this.startOffset = jSONObject.optLong("st");
        setEndOffset(jSONObject.optLong("en"));
        setCurrentOffset(jSONObject.optLong(com.ss.android.socialbase.downloader.segment.Segment.JsonKey.CURRENT));
        setCurrentOffsetRead(getCurrentOffset());
    }

    public static java.lang.String toString(java.util.List<com.ss.android.socialbase.downloader.segment.Segment> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        java.util.Collections.sort(list, new com.ss.android.socialbase.downloader.segment.Segment.AnonymousClass1());
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.util.Iterator<com.ss.android.socialbase.downloader.segment.Segment> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append("\r\n");
        }
        return sb.toString();
    }

    public void decreaseCompetitor() {
        this.competitor--;
    }

    public int getCompetitor() {
        return this.competitor;
    }

    public long getCurrentOffset() {
        long j = this.currentOffset.get();
        long j2 = this.endOffset;
        if (j2 > 0) {
            long j3 = j2 + 1;
            if (j > j3) {
                return j3;
            }
        }
        return j;
    }

    public long getCurrentOffsetRead() {
        com.ss.android.socialbase.downloader.segment.SegmentReader segmentReader = this.owner;
        if (segmentReader != null) {
            long curSegmentReadOffset = segmentReader.getCurSegmentReadOffset();
            if (curSegmentReadOffset > this.currentOffsetRead) {
                return curSegmentReadOffset;
            }
        }
        return this.currentOffsetRead;
    }

    public long getDownloadBytes() {
        return this.currentOffset.get() - this.startOffset;
    }

    public long getEndOffset() {
        return this.endOffset;
    }

    public int getIndex() {
        return this.index;
    }

    public long getReadBytes() {
        return getCurrentOffsetRead() - this.startOffset;
    }

    public long getRemainDownloadBytes() {
        long j = this.endOffset;
        if (j >= this.startOffset) {
            return (j - this.currentOffset.get()) + 1;
        }
        return -1L;
    }

    public long getRemainReadBytes() {
        long j = this.endOffset;
        if (j >= this.startOffset) {
            return (j - getCurrentOffsetRead()) + 1;
        }
        return -1L;
    }

    public long getStartOffset() {
        return this.startOffset;
    }

    public void increaseCompetitor() {
        this.competitor++;
    }

    public void increaseCurrentOffset(long j) {
        this.currentOffset.addAndGet(j);
    }

    public boolean isDownloaded() {
        return this.endOffset >= this.startOffset && this.currentOffset.get() > this.endOffset;
    }

    public boolean isReadFinish() {
        return this.endOffset >= this.startOffset && getCurrentOffsetRead() > this.endOffset;
    }

    public void setCompetitor(int i) {
        this.competitor = i;
    }

    public void setCurrentOffset(long j) {
        long j2 = this.startOffset;
        if (j < j2) {
            j = j2;
        }
        long j3 = this.endOffset;
        if (j3 > 0) {
            long j4 = j3 + 1;
            if (j > j4) {
                j = j4;
            }
        }
        this.currentOffset.set(j);
    }

    public void setCurrentOffsetRead(long j) {
        if (j >= this.currentOffset.get()) {
            this.currentOffsetRead = j;
        }
    }

    public void setEndOffset(long j) {
        if (j >= this.startOffset) {
            this.endOffset = j;
            return;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder("setEndOffset: endOffset = ");
        sb.append(j);
        sb.append(", segment = ");
        sb.append(this);
        if (j == -1) {
            this.endOffset = j;
        }
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public org.json.JSONObject toJson() throws org.json.JSONException {
        org.json.JSONObject jSONObject = this.jsonObject;
        if (jSONObject == null) {
            jSONObject = new org.json.JSONObject();
            this.jsonObject = jSONObject;
        }
        jSONObject.put("st", getStartOffset());
        jSONObject.put(com.ss.android.socialbase.downloader.segment.Segment.JsonKey.CURRENT, getCurrentOffset());
        jSONObject.put("en", getEndOffset());
        return jSONObject;
    }

    public java.lang.String toString() {
        return "Segment{startOffset=" + this.startOffset + ",\t currentOffset=" + this.currentOffset + ",\t currentOffsetRead=" + getCurrentOffsetRead() + ",\t endOffset=" + this.endOffset + '}';
    }
}
