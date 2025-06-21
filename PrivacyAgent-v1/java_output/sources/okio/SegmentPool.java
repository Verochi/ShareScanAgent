package okio;

/* loaded from: classes24.dex */
final class SegmentPool {
    static final long MAX_SIZE = 65536;
    static long byteCount;

    @javax.annotation.Nullable
    static okio.Segment next;

    private SegmentPool() {
    }

    public static void recycle(okio.Segment segment) {
        if (segment.next != null || segment.prev != null) {
            throw new java.lang.IllegalArgumentException();
        }
        if (segment.shared) {
            return;
        }
        synchronized (okio.SegmentPool.class) {
            long j = byteCount;
            if (j + 8192 > 65536) {
                return;
            }
            byteCount = j + 8192;
            segment.next = next;
            segment.limit = 0;
            segment.pos = 0;
            next = segment;
        }
    }

    public static okio.Segment take() {
        synchronized (okio.SegmentPool.class) {
            okio.Segment segment = next;
            if (segment == null) {
                return new okio.Segment();
            }
            next = segment.next;
            segment.next = null;
            byteCount -= 8192;
            return segment;
        }
    }
}
