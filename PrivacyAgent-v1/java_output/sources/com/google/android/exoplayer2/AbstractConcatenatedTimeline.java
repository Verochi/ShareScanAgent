package com.google.android.exoplayer2;

/* loaded from: classes22.dex */
public abstract class AbstractConcatenatedTimeline extends com.google.android.exoplayer2.Timeline {
    public final int a;
    public final com.google.android.exoplayer2.source.ShuffleOrder b;
    public final boolean c;

    public AbstractConcatenatedTimeline(boolean z, com.google.android.exoplayer2.source.ShuffleOrder shuffleOrder) {
        this.c = z;
        this.b = shuffleOrder;
        this.a = shuffleOrder.getLength();
    }

    public static java.lang.Object getChildPeriodUidFromConcatenatedUid(java.lang.Object obj) {
        return ((android.util.Pair) obj).second;
    }

    public static java.lang.Object getChildTimelineUidFromConcatenatedUid(java.lang.Object obj) {
        return ((android.util.Pair) obj).first;
    }

    public static java.lang.Object getConcatenatedUid(java.lang.Object obj, java.lang.Object obj2) {
        return android.util.Pair.create(obj, obj2);
    }

    public final int a(int i, boolean z) {
        if (z) {
            return this.b.getNextIndex(i);
        }
        if (i < this.a - 1) {
            return i + 1;
        }
        return -1;
    }

    public final int b(int i, boolean z) {
        if (z) {
            return this.b.getPreviousIndex(i);
        }
        if (i > 0) {
            return i - 1;
        }
        return -1;
    }

    public abstract int getChildIndexByChildUid(java.lang.Object obj);

    public abstract int getChildIndexByPeriodIndex(int i);

    public abstract int getChildIndexByWindowIndex(int i);

    public abstract java.lang.Object getChildUidByChildIndex(int i);

    public abstract int getFirstPeriodIndexByChildIndex(int i);

    @Override // com.google.android.exoplayer2.Timeline
    public int getFirstWindowIndex(boolean z) {
        if (this.a == 0) {
            return -1;
        }
        if (this.c) {
            z = false;
        }
        int firstIndex = z ? this.b.getFirstIndex() : 0;
        while (getTimelineByChildIndex(firstIndex).isEmpty()) {
            firstIndex = a(firstIndex, z);
            if (firstIndex == -1) {
                return -1;
            }
        }
        return getFirstWindowIndexByChildIndex(firstIndex) + getTimelineByChildIndex(firstIndex).getFirstWindowIndex(z);
    }

    public abstract int getFirstWindowIndexByChildIndex(int i);

    @Override // com.google.android.exoplayer2.Timeline
    public final int getIndexOfPeriod(java.lang.Object obj) {
        int indexOfPeriod;
        if (!(obj instanceof android.util.Pair)) {
            return -1;
        }
        java.lang.Object childTimelineUidFromConcatenatedUid = getChildTimelineUidFromConcatenatedUid(obj);
        java.lang.Object childPeriodUidFromConcatenatedUid = getChildPeriodUidFromConcatenatedUid(obj);
        int childIndexByChildUid = getChildIndexByChildUid(childTimelineUidFromConcatenatedUid);
        if (childIndexByChildUid == -1 || (indexOfPeriod = getTimelineByChildIndex(childIndexByChildUid).getIndexOfPeriod(childPeriodUidFromConcatenatedUid)) == -1) {
            return -1;
        }
        return getFirstPeriodIndexByChildIndex(childIndexByChildUid) + indexOfPeriod;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getLastWindowIndex(boolean z) {
        int i = this.a;
        if (i == 0) {
            return -1;
        }
        if (this.c) {
            z = false;
        }
        int lastIndex = z ? this.b.getLastIndex() : i - 1;
        while (getTimelineByChildIndex(lastIndex).isEmpty()) {
            lastIndex = b(lastIndex, z);
            if (lastIndex == -1) {
                return -1;
            }
        }
        return getFirstWindowIndexByChildIndex(lastIndex) + getTimelineByChildIndex(lastIndex).getLastWindowIndex(z);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getNextWindowIndex(int i, int i2, boolean z) {
        if (this.c) {
            if (i2 == 1) {
                i2 = 2;
            }
            z = false;
        }
        int childIndexByWindowIndex = getChildIndexByWindowIndex(i);
        int firstWindowIndexByChildIndex = getFirstWindowIndexByChildIndex(childIndexByWindowIndex);
        int nextWindowIndex = getTimelineByChildIndex(childIndexByWindowIndex).getNextWindowIndex(i - firstWindowIndexByChildIndex, i2 != 2 ? i2 : 0, z);
        if (nextWindowIndex != -1) {
            return firstWindowIndexByChildIndex + nextWindowIndex;
        }
        int a = a(childIndexByWindowIndex, z);
        while (a != -1 && getTimelineByChildIndex(a).isEmpty()) {
            a = a(a, z);
        }
        if (a != -1) {
            return getFirstWindowIndexByChildIndex(a) + getTimelineByChildIndex(a).getFirstWindowIndex(z);
        }
        if (i2 == 2) {
            return getFirstWindowIndex(z);
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public final com.google.android.exoplayer2.Timeline.Period getPeriod(int i, com.google.android.exoplayer2.Timeline.Period period, boolean z) {
        int childIndexByPeriodIndex = getChildIndexByPeriodIndex(i);
        int firstWindowIndexByChildIndex = getFirstWindowIndexByChildIndex(childIndexByPeriodIndex);
        getTimelineByChildIndex(childIndexByPeriodIndex).getPeriod(i - getFirstPeriodIndexByChildIndex(childIndexByPeriodIndex), period, z);
        period.windowIndex += firstWindowIndexByChildIndex;
        if (z) {
            period.uid = getConcatenatedUid(getChildUidByChildIndex(childIndexByPeriodIndex), com.google.android.exoplayer2.util.Assertions.checkNotNull(period.uid));
        }
        return period;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public final com.google.android.exoplayer2.Timeline.Period getPeriodByUid(java.lang.Object obj, com.google.android.exoplayer2.Timeline.Period period) {
        java.lang.Object childTimelineUidFromConcatenatedUid = getChildTimelineUidFromConcatenatedUid(obj);
        java.lang.Object childPeriodUidFromConcatenatedUid = getChildPeriodUidFromConcatenatedUid(obj);
        int childIndexByChildUid = getChildIndexByChildUid(childTimelineUidFromConcatenatedUid);
        int firstWindowIndexByChildIndex = getFirstWindowIndexByChildIndex(childIndexByChildUid);
        getTimelineByChildIndex(childIndexByChildUid).getPeriodByUid(childPeriodUidFromConcatenatedUid, period);
        period.windowIndex += firstWindowIndexByChildIndex;
        period.uid = obj;
        return period;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getPreviousWindowIndex(int i, int i2, boolean z) {
        if (this.c) {
            if (i2 == 1) {
                i2 = 2;
            }
            z = false;
        }
        int childIndexByWindowIndex = getChildIndexByWindowIndex(i);
        int firstWindowIndexByChildIndex = getFirstWindowIndexByChildIndex(childIndexByWindowIndex);
        int previousWindowIndex = getTimelineByChildIndex(childIndexByWindowIndex).getPreviousWindowIndex(i - firstWindowIndexByChildIndex, i2 != 2 ? i2 : 0, z);
        if (previousWindowIndex != -1) {
            return firstWindowIndexByChildIndex + previousWindowIndex;
        }
        int b = b(childIndexByWindowIndex, z);
        while (b != -1 && getTimelineByChildIndex(b).isEmpty()) {
            b = b(b, z);
        }
        if (b != -1) {
            return getFirstWindowIndexByChildIndex(b) + getTimelineByChildIndex(b).getLastWindowIndex(z);
        }
        if (i2 == 2) {
            return getLastWindowIndex(z);
        }
        return -1;
    }

    public abstract com.google.android.exoplayer2.Timeline getTimelineByChildIndex(int i);

    @Override // com.google.android.exoplayer2.Timeline
    public final java.lang.Object getUidOfPeriod(int i) {
        int childIndexByPeriodIndex = getChildIndexByPeriodIndex(i);
        return getConcatenatedUid(getChildUidByChildIndex(childIndexByPeriodIndex), getTimelineByChildIndex(childIndexByPeriodIndex).getUidOfPeriod(i - getFirstPeriodIndexByChildIndex(childIndexByPeriodIndex)));
    }

    @Override // com.google.android.exoplayer2.Timeline
    public final com.google.android.exoplayer2.Timeline.Window getWindow(int i, com.google.android.exoplayer2.Timeline.Window window, long j) {
        int childIndexByWindowIndex = getChildIndexByWindowIndex(i);
        int firstWindowIndexByChildIndex = getFirstWindowIndexByChildIndex(childIndexByWindowIndex);
        int firstPeriodIndexByChildIndex = getFirstPeriodIndexByChildIndex(childIndexByWindowIndex);
        getTimelineByChildIndex(childIndexByWindowIndex).getWindow(i - firstWindowIndexByChildIndex, window, j);
        java.lang.Object childUidByChildIndex = getChildUidByChildIndex(childIndexByWindowIndex);
        if (!com.google.android.exoplayer2.Timeline.Window.SINGLE_WINDOW_UID.equals(window.uid)) {
            childUidByChildIndex = getConcatenatedUid(childUidByChildIndex, window.uid);
        }
        window.uid = childUidByChildIndex;
        window.firstPeriodIndex += firstPeriodIndexByChildIndex;
        window.lastPeriodIndex += firstPeriodIndexByChildIndex;
        return window;
    }
}
