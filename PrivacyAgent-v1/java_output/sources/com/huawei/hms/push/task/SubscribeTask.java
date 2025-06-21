package com.huawei.hms.push.task;

/* loaded from: classes22.dex */
public class SubscribeTask extends com.huawei.hms.push.task.BaseVoidTask {
    public SubscribeTask(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        super(str, str2, str3);
    }

    @Override // com.huawei.hms.push.task.BaseVoidTask, com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return 40003000;
    }
}
