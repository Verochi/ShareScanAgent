package com.google.android.exoplayer2.upstream;

/* loaded from: classes22.dex */
public final class DataSourceException extends java.io.IOException {
    public static final int POSITION_OUT_OF_RANGE = 0;
    public final int reason;

    public DataSourceException(int i) {
        this.reason = i;
    }

    public static boolean isCausedByPositionOutOfRange(java.io.IOException iOException) {
        for (java.io.IOException iOException2 = iOException; iOException2 != null; iOException2 = iOException2.getCause()) {
            if ((iOException2 instanceof com.google.android.exoplayer2.upstream.DataSourceException) && ((com.google.android.exoplayer2.upstream.DataSourceException) iOException2).reason == 0) {
                return true;
            }
        }
        return false;
    }
}
