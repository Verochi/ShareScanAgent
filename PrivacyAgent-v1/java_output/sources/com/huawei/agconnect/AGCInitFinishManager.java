package com.huawei.agconnect;

/* loaded from: classes22.dex */
public abstract class AGCInitFinishManager {
    public static final com.huawei.agconnect.AGCInitFinishManager a = new com.huawei.agconnect.core.a.a();

    public interface AGCInitFinishCallback {
        void onFinish();
    }

    public static com.huawei.agconnect.AGCInitFinishManager getInstance() {
        return a;
    }

    public abstract void addAGCInitFinishCallback(com.huawei.agconnect.AGCInitFinishManager.AGCInitFinishCallback aGCInitFinishCallback);
}
