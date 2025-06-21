package com.ss.android.socialbase.downloader.impls;

/* loaded from: classes19.dex */
public class DefaultRetryDelayTimeCalculator implements com.ss.android.socialbase.downloader.downloader.IRetryDelayTimeCalculator {
    @Override // com.ss.android.socialbase.downloader.downloader.IRetryDelayTimeCalculator
    public long calculateRetryDelayTime(int i, int i2) {
        if (i == 1) {
            return 3000L;
        }
        if (i == 2) {
            return 15000L;
        }
        if (i == 3) {
            return 30000L;
        }
        return i > 3 ? 300000L : 0L;
    }
}
