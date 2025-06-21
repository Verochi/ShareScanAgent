package com.huawei.hms.adapter.sysobs;

/* loaded from: classes22.dex */
public interface SystemObserver {
    boolean onNoticeResult(int i);

    boolean onSolutionResult(android.content.Intent intent, java.lang.String str);

    boolean onUpdateResult(int i);
}
