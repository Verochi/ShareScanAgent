package com.ss.android.socialbase.downloader.segment;

/* loaded from: classes19.dex */
public class SegmentUtils {
    public static long getDownloadedBytes(@androidx.annotation.NonNull java.util.List<com.ss.android.socialbase.downloader.segment.Segment> list) {
        long j;
        long j2;
        long j3 = 0;
        loop0: while (true) {
            j = -1;
            j2 = -1;
            for (com.ss.android.socialbase.downloader.segment.Segment segment : list) {
                if (j == -1) {
                    if (segment.getDownloadBytes() > 0) {
                        j = segment.getStartOffset();
                        j2 = segment.getCurrentOffset();
                    }
                } else if (segment.getStartOffset() > j2) {
                    j3 += j2 - j;
                    if (segment.getDownloadBytes() > 0) {
                        j = segment.getStartOffset();
                        j2 = segment.getCurrentOffset();
                    }
                } else if (segment.getCurrentOffset() > j2) {
                    j2 = segment.getCurrentOffset();
                }
            }
        }
        return (j < 0 || j2 <= j) ? j3 : j3 + (j2 - j);
    }

    public static long getFirstOffset(@androidx.annotation.NonNull java.util.List<com.ss.android.socialbase.downloader.segment.Segment> list) {
        int size = list.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            com.ss.android.socialbase.downloader.segment.Segment segment = list.get(i);
            if (segment.getStartOffset() > j) {
                break;
            }
            if (segment.getCurrentOffsetRead() > j) {
                j = segment.getCurrentOffsetRead();
            }
        }
        return j;
    }
}
