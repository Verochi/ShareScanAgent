package com.alibaba.sdk.android.oss.common;

/* loaded from: classes.dex */
public class DefaultLogPrinter implements com.alibaba.sdk.android.oss.common.LogPrinter {
    private static final java.lang.String TAG = "OSS-Android-SDK";

    /* renamed from: com.alibaba.sdk.android.oss.common.DefaultLogPrinter$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$alibaba$sdk$android$oss$common$LogLevel;

        static {
            int[] iArr = new int[com.alibaba.sdk.android.oss.common.LogLevel.values().length];
            $SwitchMap$com$alibaba$sdk$android$oss$common$LogLevel = iArr;
            try {
                iArr[com.alibaba.sdk.android.oss.common.LogLevel.INFO.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$alibaba$sdk$android$oss$common$LogLevel[com.alibaba.sdk.android.oss.common.LogLevel.VERBOSE.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$alibaba$sdk$android$oss$common$LogLevel[com.alibaba.sdk.android.oss.common.LogLevel.WARN.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$alibaba$sdk$android$oss$common$LogLevel[com.alibaba.sdk.android.oss.common.LogLevel.DEBUG.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$alibaba$sdk$android$oss$common$LogLevel[com.alibaba.sdk.android.oss.common.LogLevel.ERROR.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
        }
    }

    @Override // com.alibaba.sdk.android.oss.common.LogPrinter
    public void log(com.alibaba.sdk.android.oss.common.LogLevel logLevel, java.lang.String str) {
        int i = com.alibaba.sdk.android.oss.common.DefaultLogPrinter.AnonymousClass1.$SwitchMap$com$alibaba$sdk$android$oss$common$LogLevel[logLevel.ordinal()];
        if (i == 1) {
            "[INFO]: ".concat(str);
            return;
        }
        if (i == 2) {
            "[VERBOSE]: ".concat(str);
            return;
        }
        if (i == 3) {
            "[WARN]: ".concat(str);
        } else if (i == 4) {
            "[DEBUG]: ".concat(str);
        } else {
            if (i != 5) {
                return;
            }
            "[ERROR]: ".concat(str);
        }
    }
}
