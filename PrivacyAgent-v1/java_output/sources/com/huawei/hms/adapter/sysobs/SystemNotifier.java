package com.huawei.hms.adapter.sysobs;

/* loaded from: classes22.dex */
public interface SystemNotifier {
    void notifyNoticeObservers(int i);

    void notifyObservers(int i);

    void notifyObservers(android.content.Intent intent, java.lang.String str);

    void registerObserver(com.huawei.hms.adapter.sysobs.SystemObserver systemObserver);

    void unRegisterObserver(com.huawei.hms.adapter.sysobs.SystemObserver systemObserver);
}
