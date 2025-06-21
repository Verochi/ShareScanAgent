package com.ss.android.socialbase.downloader.segment;

/* loaded from: classes19.dex */
class SegmentApplyException extends com.ss.android.socialbase.downloader.exception.BaseException {
    public static final int ALREADY_APPLY_BY_OTHER = 1;
    public static final int BAD_SEGMENT = 6;
    public static final int CHANGE_SEGMENT = 5;
    public static final int PREV_END_ADJUST_FAIL = 4;
    public static final int PREV_OVERSTEP = 3;
    public static final int SEGMENT_NOT_EXIST = 2;
    private int applyCode;

    public SegmentApplyException(int i, java.lang.String str) {
        super(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_SEGMENT_APPLY, "applyCode=" + i + ", " + str);
        this.applyCode = i;
    }

    public int getSegmentApplyErrorCode() {
        return this.applyCode;
    }
}
