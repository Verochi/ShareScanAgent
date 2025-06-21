package com.ss.android.socialbase.downloader.impls;

/* loaded from: classes19.dex */
public class RetryDelayTimeParamCalculator implements com.ss.android.socialbase.downloader.downloader.IRetryDelayTimeCalculator {
    private final long[] mTimeArray;

    public RetryDelayTimeParamCalculator(java.lang.String str) {
        this.mTimeArray = parseTimeArray(str);
    }

    private long[] parseTimeArray(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            java.lang.String[] split = str.split(",");
            if (split.length == 0) {
                return null;
            }
            long[] jArr = new long[split.length];
            for (int i = 0; i < split.length; i++) {
                jArr[i] = java.lang.Long.parseLong(split[i]);
            }
            return jArr;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IRetryDelayTimeCalculator
    public long calculateRetryDelayTime(int i, int i2) {
        long[] jArr = this.mTimeArray;
        if (jArr == null || jArr.length <= 0) {
            return 0L;
        }
        int i3 = i - 1;
        if (i3 < 0) {
            i3 = 0;
        }
        if (i3 > jArr.length - 1) {
            i3 = jArr.length - 1;
        }
        return jArr[i3];
    }
}
