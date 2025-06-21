package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
class cv implements com.baidu.mobads.sdk.api.IOAdEventListener {
    final /* synthetic */ com.baidu.mobads.sdk.internal.cs a;

    public cv(com.baidu.mobads.sdk.internal.cs csVar) {
        this.a = csVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(com.baidu.mobads.sdk.api.IOAdEvent iOAdEvent) {
        if (iOAdEvent != null) {
            try {
                if (iOAdEvent.getData() != null) {
                    java.lang.Object obj = iOAdEvent.getData().get("intervalpages");
                    java.lang.Object obj2 = iOAdEvent.getData().get("bannerseconds");
                    java.lang.Object obj3 = iOAdEvent.getData().get("novelrouter");
                    java.lang.Object obj4 = iOAdEvent.getData().get(com.anythink.expressad.foundation.g.a.aj);
                    java.lang.Object obj5 = iOAdEvent.getData().get(com.huawei.hms.push.constant.RemoteMessageConst.Notification.CHANNEL_ID);
                    java.lang.Object obj6 = iOAdEvent.getData().get("contentId");
                    if (obj3 != null) {
                        int intValue = obj != null ? ((java.lang.Integer) obj).intValue() : 6;
                        int intValue2 = obj2 != null ? ((java.lang.Integer) obj2).intValue() : 10;
                        int intValue3 = obj4 != null ? ((java.lang.Integer) obj4).intValue() : 0;
                        int intValue4 = obj5 != null ? ((java.lang.Integer) obj5).intValue() : 1022;
                        java.lang.String str = obj6 != null ? (java.lang.String) obj6 : null;
                        org.json.JSONObject jSONObject = new org.json.JSONObject();
                        if (com.baidu.mobads.sdk.internal.an.f()) {
                            jSONObject.put("status", "0");
                        } else {
                            jSONObject.put("status", "1");
                        }
                        this.a.a(jSONObject);
                        this.a.a(intValue, intValue2, (java.lang.String) obj3, intValue3, intValue4, str);
                    }
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }
}
