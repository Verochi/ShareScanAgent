package okio;

/* loaded from: classes24.dex */
final class Segment {
    static final int SHARE_MINIMUM = 1024;
    static final int SIZE = 8192;
    final byte[] data;
    int limit;
    okio.Segment next;
    boolean owner;
    int pos;
    okio.Segment prev;
    boolean shared;

    public Segment() {
        this.data = new byte[8192];
        this.owner = true;
        this.shared = false;
    }

    public Segment(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.data = bArr;
        this.pos = i;
        this.limit = i2;
        this.shared = z;
        this.owner = z2;
    }

    public final void compact() {
        okio.Segment segment = this.prev;
        if (segment == this) {
            throw new java.lang.IllegalStateException();
        }
        if (segment.owner) {
            int i = this.limit - this.pos;
            if (i > (8192 - segment.limit) + (segment.shared ? 0 : segment.pos)) {
                return;
            }
            writeTo(segment, i);
            pop();
            okio.SegmentPool.recycle(this);
        }
    }

    @javax.annotation.Nullable
    public final okio.Segment pop() {
        okio.Segment segment = this.next;
        okio.Segment segment2 = segment != this ? segment : null;
        okio.Segment segment3 = this.prev;
        segment3.next = segment;
        this.next.prev = segment3;
        this.next = null;
        this.prev = null;
        return segment2;
    }

    public final okio.Segment push(okio.Segment segment) {
        segment.prev = this;
        segment.next = this.next;
        this.next.prev = segment;
        this.next = segment;
        return segment;
    }

    public final okio.Segment sharedCopy() {
        this.shared = true;
        return new okio.Segment(this.data, this.pos, this.limit, true, false);
    }

    public final okio.Segment split(int i) {
        okio.Segment take;
        if (i <= 0 || i > this.limit - this.pos) {
            throw new java.lang.IllegalArgumentException();
        }
        if (i >= 1024) {
            take = sharedCopy();
        } else {
            take = okio.SegmentPool.take();
            java.lang.System.arraycopy(this.data, this.pos, take.data, 0, i);
        }
        take.limit = take.pos + i;
        this.pos += i;
        this.prev.push(take);
        return take;
    }

    public final okio.Segment unsharedCopy() {
        return new okio.Segment((byte[]) this.data.clone(), this.pos, this.limit, false, true);
    }

    public final void writeTo(okio.Segment segment, int i) {
        if (!segment.owner) {
            throw new java.lang.IllegalArgumentException();
        }
        int i2 = segment.limit;
        if (i2 + i > 8192) {
            if (segment.shared) {
                throw new java.lang.IllegalArgumentException();
            }
            int i3 = segment.pos;
            if ((i2 + i) - i3 > 8192) {
                throw new java.lang.IllegalArgumentException();
            }
            byte[] bArr = segment.data;
            java.lang.System.arraycopy(bArr, i3, bArr, 0, i2 - i3);
            segment.limit -= segment.pos;
            segment.pos = 0;
        }
        java.lang.System.arraycopy(this.data, this.pos, segment.data, segment.limit, i);
        segment.limit += i;
        this.pos += i;
    }
}
