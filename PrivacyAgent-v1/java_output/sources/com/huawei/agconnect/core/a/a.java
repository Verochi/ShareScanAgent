package com.huawei.agconnect.core.a;

/* loaded from: classes22.dex */
public class a extends com.huawei.agconnect.AGCInitFinishManager {
    public static final java.util.List<com.huawei.agconnect.AGCInitFinishManager.AGCInitFinishCallback> b = new java.util.concurrent.CopyOnWriteArrayList();

    public static void a() {
        java.util.Iterator<com.huawei.agconnect.AGCInitFinishManager.AGCInitFinishCallback> it = b.iterator();
        while (it.hasNext()) {
            it.next().onFinish();
        }
    }

    @Override // com.huawei.agconnect.AGCInitFinishManager
    public void addAGCInitFinishCallback(com.huawei.agconnect.AGCInitFinishManager.AGCInitFinishCallback aGCInitFinishCallback) {
        if (aGCInitFinishCallback != null) {
            b.add(aGCInitFinishCallback);
        }
    }
}
