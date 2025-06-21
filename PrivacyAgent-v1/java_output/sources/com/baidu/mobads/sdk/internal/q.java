package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
class q implements java.lang.Runnable {
    final /* synthetic */ com.baidu.mobads.sdk.api.IOAdEvent a;
    final /* synthetic */ com.baidu.mobads.sdk.internal.p b;

    public q(com.baidu.mobads.sdk.internal.p pVar, com.baidu.mobads.sdk.api.IOAdEvent iOAdEvent) {
        this.b = pVar;
        this.a = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        java.lang.String str;
        com.baidu.mobads.sdk.api.CpuChannelListManager.CpuChannelListListener cpuChannelListListener;
        com.baidu.mobads.sdk.api.CpuChannelListManager.CpuChannelListListener cpuChannelListListener2;
        com.baidu.mobads.sdk.api.CpuChannelListManager.CpuChannelListListener cpuChannelListListener3;
        com.baidu.mobads.sdk.api.CpuChannelListManager.CpuChannelListListener cpuChannelListListener4;
        com.baidu.mobads.sdk.api.IOAdEvent iOAdEvent = this.a;
        if (iOAdEvent == null || android.text.TextUtils.isEmpty(iOAdEvent.getType())) {
            return;
        }
        java.lang.String type = this.a.getType();
        if (com.baidu.mobads.sdk.internal.z.ap.equals(type)) {
            java.util.List<com.baidu.mobads.sdk.api.CpuChannelResponse> a = com.baidu.mobads.sdk.internal.n.a((org.json.JSONArray) this.a.getData().get("cpuChannelList"));
            cpuChannelListListener3 = this.b.a.t;
            if (cpuChannelListListener3 != null) {
                cpuChannelListListener4 = this.b.a.t;
                cpuChannelListListener4.onChannelListLoaded(a);
                return;
            }
            return;
        }
        if (com.baidu.mobads.sdk.internal.z.aq.equals(type)) {
            java.util.Map<java.lang.String, java.lang.Object> data = this.a.getData();
            int i = 0;
            if (data != null) {
                str = (java.lang.String) data.get("error_message");
                java.lang.Object obj = data.get("error_code");
                if (obj == null) {
                    obj = 0;
                }
                i = ((java.lang.Integer) obj).intValue();
            } else {
                str = "";
            }
            cpuChannelListListener = this.b.a.t;
            if (cpuChannelListListener != null) {
                cpuChannelListListener2 = this.b.a.t;
                cpuChannelListListener2.onChannelListError(str, i);
            }
        }
    }
}
