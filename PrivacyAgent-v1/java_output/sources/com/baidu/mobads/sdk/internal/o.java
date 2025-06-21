package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public class o extends com.baidu.mobads.sdk.internal.ae {
    private com.baidu.mobads.sdk.api.CpuChannelListManager.CpuChannelListListener t;
    private java.lang.String u;
    private int v;

    public o(android.content.Context context) {
        super(context);
    }

    @Override // com.baidu.mobads.sdk.internal.ae, com.baidu.mobads.sdk.internal.bi
    public void a() {
        if (this.m == null) {
            this.n = false;
            return;
        }
        this.n = true;
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            jSONObject2.put(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.PROD, "cpu");
            this.m.createProdHandler(jSONObject2);
            com.baidu.mobads.sdk.internal.p pVar = new com.baidu.mobads.sdk.internal.p(this);
            this.m.addEventListener(com.baidu.mobads.sdk.internal.z.ap, pVar);
            this.m.addEventListener(com.baidu.mobads.sdk.internal.z.aq, pVar);
            jSONObject.put("appsid", this.u);
            jSONObject.put("subChannelId", this.v);
            jSONObject.put(com.hihonor.push.sdk.common.constants.PushApiKeys.EVENT_TYPE, "cpu_channelIds");
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        a(jSONObject);
    }

    public void a(com.baidu.mobads.sdk.api.CpuChannelListManager.CpuChannelListListener cpuChannelListListener) {
        this.t = cpuChannelListListener;
    }

    public void a(java.lang.String str, int i) {
        this.u = str;
        this.v = i;
    }
}
