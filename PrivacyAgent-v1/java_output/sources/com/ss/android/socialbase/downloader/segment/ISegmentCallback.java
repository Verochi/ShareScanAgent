package com.ss.android.socialbase.downloader.segment;

/* loaded from: classes19.dex */
interface ISegmentCallback {
    void applySegment(com.ss.android.socialbase.downloader.segment.SegmentReader segmentReader, com.ss.android.socialbase.downloader.segment.Segment segment) throws com.ss.android.socialbase.downloader.exception.BaseException;

    com.ss.android.socialbase.downloader.segment.IOutput createOutput(com.ss.android.socialbase.downloader.segment.SegmentReader segmentReader, com.ss.android.socialbase.downloader.segment.Segment segment) throws com.ss.android.socialbase.downloader.exception.BaseException;

    com.ss.android.socialbase.downloader.segment.Segment obtainSegment(com.ss.android.socialbase.downloader.segment.SegmentReader segmentReader, com.ss.android.socialbase.downloader.segment.UrlRecord urlRecord);

    void onReaderExit(com.ss.android.socialbase.downloader.segment.SegmentReader segmentReader);

    void onReaderRun(com.ss.android.socialbase.downloader.segment.SegmentReader segmentReader);

    void onSegmentConnected(com.ss.android.socialbase.downloader.segment.SegmentReader segmentReader, com.ss.android.socialbase.downloader.segment.Segment segment, com.ss.android.socialbase.downloader.segment.UrlRecord urlRecord, com.ss.android.socialbase.downloader.model.HttpResponse httpResponse) throws com.ss.android.socialbase.downloader.exception.BaseException, com.ss.android.socialbase.downloader.exception.RetryThrowable;

    void onSegmentFailed(com.ss.android.socialbase.downloader.segment.SegmentReader segmentReader, com.ss.android.socialbase.downloader.segment.UrlRecord urlRecord, com.ss.android.socialbase.downloader.segment.Segment segment, com.ss.android.socialbase.downloader.exception.BaseException baseException);

    void onSegmentRetry(com.ss.android.socialbase.downloader.segment.SegmentReader segmentReader, com.ss.android.socialbase.downloader.segment.UrlRecord urlRecord, com.ss.android.socialbase.downloader.segment.Segment segment, com.ss.android.socialbase.downloader.exception.BaseException baseException, int i, int i2);

    void unApplySegment(com.ss.android.socialbase.downloader.segment.SegmentReader segmentReader, com.ss.android.socialbase.downloader.segment.Segment segment);

    void unObtainSegment(com.ss.android.socialbase.downloader.segment.SegmentReader segmentReader, com.ss.android.socialbase.downloader.segment.Segment segment);
}
