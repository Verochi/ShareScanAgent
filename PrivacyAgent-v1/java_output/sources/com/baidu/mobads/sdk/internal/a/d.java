package com.baidu.mobads.sdk.internal.a;

/* loaded from: classes.dex */
class d implements com.baidu.mobads.sdk.api.IOAdEventListener {
    final /* synthetic */ com.baidu.mobads.sdk.internal.a.a a;
    final /* synthetic */ com.baidu.mobads.sdk.internal.a.c b;

    public d(com.baidu.mobads.sdk.internal.a.c cVar, com.baidu.mobads.sdk.internal.a.a aVar) {
        this.b = cVar;
        this.a = aVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(com.baidu.mobads.sdk.api.IOAdEvent iOAdEvent) {
        java.util.Map<java.lang.String, java.lang.Object> data;
        if (iOAdEvent == null || !com.baidu.mobads.sdk.internal.a.c.h.equals(iOAdEvent.getType()) || (data = iOAdEvent.getData()) == null || data.isEmpty()) {
            return;
        }
        java.lang.Object obj = data.get("e_t");
        java.lang.Object obj2 = data.get("e_n");
        java.lang.Object obj3 = data.get("e_a");
        if ((obj instanceof java.lang.String) && (obj2 instanceof java.lang.String)) {
            data.put("e_r", this.a.handleEvent((java.lang.String) obj, (java.lang.String) obj2, obj3 instanceof java.lang.Object[] ? (java.lang.Object[]) obj3 : null));
        }
    }
}
