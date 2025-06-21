package com.alibaba.sdk.android.oss.internal;

/* loaded from: classes.dex */
public class OSSRetryHandler {
    private int maxRetryCount = 2;

    /* renamed from: com.alibaba.sdk.android.oss.internal.OSSRetryHandler$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$alibaba$sdk$android$oss$internal$OSSRetryType;

        static {
            int[] iArr = new int[com.alibaba.sdk.android.oss.internal.OSSRetryType.values().length];
            $SwitchMap$com$alibaba$sdk$android$oss$internal$OSSRetryType = iArr;
            try {
                iArr[com.alibaba.sdk.android.oss.internal.OSSRetryType.OSSRetryTypeShouldRetry.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
        }
    }

    public OSSRetryHandler(int i) {
        setMaxRetryCount(i);
    }

    public void setMaxRetryCount(int i) {
        this.maxRetryCount = i;
    }

    public com.alibaba.sdk.android.oss.internal.OSSRetryType shouldRetry(java.lang.Exception exc, int i) {
        if (i >= this.maxRetryCount) {
            return com.alibaba.sdk.android.oss.internal.OSSRetryType.OSSRetryTypeShouldNotRetry;
        }
        if (exc instanceof com.alibaba.sdk.android.oss.ClientException) {
            if (((com.alibaba.sdk.android.oss.ClientException) exc).isCanceledException().booleanValue()) {
                return com.alibaba.sdk.android.oss.internal.OSSRetryType.OSSRetryTypeShouldNotRetry;
            }
            java.lang.Exception exc2 = (java.lang.Exception) exc.getCause();
            if ((exc2 instanceof java.io.InterruptedIOException) && !(exc2 instanceof java.net.SocketTimeoutException)) {
                com.alibaba.sdk.android.oss.common.OSSLog.logError("[shouldRetry] - is interrupted!");
                return com.alibaba.sdk.android.oss.internal.OSSRetryType.OSSRetryTypeShouldNotRetry;
            }
            if (exc2 instanceof java.lang.IllegalArgumentException) {
                return com.alibaba.sdk.android.oss.internal.OSSRetryType.OSSRetryTypeShouldNotRetry;
            }
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug("shouldRetry - " + exc.toString());
            exc.getCause().printStackTrace();
            return com.alibaba.sdk.android.oss.internal.OSSRetryType.OSSRetryTypeShouldRetry;
        }
        if (!(exc instanceof com.alibaba.sdk.android.oss.ServiceException)) {
            return com.alibaba.sdk.android.oss.internal.OSSRetryType.OSSRetryTypeShouldNotRetry;
        }
        com.alibaba.sdk.android.oss.ServiceException serviceException = (com.alibaba.sdk.android.oss.ServiceException) exc;
        if (serviceException.getErrorCode() != null && serviceException.getErrorCode().equalsIgnoreCase("RequestTimeTooSkewed")) {
            return com.alibaba.sdk.android.oss.internal.OSSRetryType.OSSRetryTypeShouldFixedTimeSkewedAndRetry;
        }
        if (serviceException.getErrorCode() == null || serviceException.getMessage() == null || !serviceException.getErrorCode().equalsIgnoreCase(com.alibaba.sdk.android.vod.upload.exception.VODErrorCode.INVALID_ARGUMENT) || !serviceException.getMessage().equalsIgnoreCase("Invalid signing date in Authorization header.")) {
            return serviceException.getStatusCode() >= 500 ? com.alibaba.sdk.android.oss.internal.OSSRetryType.OSSRetryTypeShouldRetry : com.alibaba.sdk.android.oss.internal.OSSRetryType.OSSRetryTypeShouldNotRetry;
        }
        try {
            java.lang.String date = serviceException.getDate();
            if (date == null) {
                return com.alibaba.sdk.android.oss.internal.OSSRetryType.OSSRetryTypeShouldNotRetry;
            }
            long fixedSkewedTimeMillis = com.alibaba.sdk.android.oss.common.utils.DateUtil.getFixedSkewedTimeMillis() - com.alibaba.sdk.android.oss.common.utils.DateUtil.parseRfc822Date(date).getTime();
            if (fixedSkewedTimeMillis <= com.heytap.mcssdk.constant.a.h && fixedSkewedTimeMillis >= -900000) {
                return com.alibaba.sdk.android.oss.internal.OSSRetryType.OSSRetryTypeShouldNotRetry;
            }
            return com.alibaba.sdk.android.oss.internal.OSSRetryType.OSSRetryTypeShouldFixedTimeSkewedAndRetry;
        } catch (java.text.ParseException e) {
            com.alibaba.sdk.android.oss.common.OSSLog.logThrowable2Local(e);
            return com.alibaba.sdk.android.oss.internal.OSSRetryType.OSSRetryTypeShouldNotRetry;
        }
    }

    public long timeInterval(int i, com.alibaba.sdk.android.oss.internal.OSSRetryType oSSRetryType) {
        if (com.alibaba.sdk.android.oss.internal.OSSRetryHandler.AnonymousClass1.$SwitchMap$com$alibaba$sdk$android$oss$internal$OSSRetryType[oSSRetryType.ordinal()] != 1) {
            return 0L;
        }
        return ((long) java.lang.Math.pow(2.0d, i)) * 200;
    }
}
