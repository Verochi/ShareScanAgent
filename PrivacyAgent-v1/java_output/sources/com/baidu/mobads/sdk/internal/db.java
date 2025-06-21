package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
class db implements android.view.ViewTreeObserver.OnWindowFocusChangeListener {
    final /* synthetic */ android.widget.RelativeLayout a;
    final /* synthetic */ com.baidu.mobads.sdk.internal.cx b;

    public db(com.baidu.mobads.sdk.internal.cx cxVar, android.widget.RelativeLayout relativeLayout) {
        this.b = cxVar;
        this.a = relativeLayout;
    }

    @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
    public void onWindowFocusChanged(boolean z) {
        if (z) {
            java.util.HashMap<java.lang.String, java.lang.Object> hashMap = new java.util.HashMap<>();
            hashMap.put("novel_activity", (android.app.Activity) this.b.i);
            hashMap.put("banner_container", this.a);
            hashMap.put(com.anythink.expressad.foundation.g.a.aj, java.lang.Integer.valueOf(this.b.G));
            hashMap.put(com.huawei.hms.push.constant.RemoteMessageConst.Notification.CHANNEL_ID, java.lang.Integer.valueOf(this.b.H));
            hashMap.put("novel_id", this.b.I);
            hashMap.put("isnight", java.lang.Boolean.valueOf(this.b.x()));
            this.b.a(com.baidu.mobads.sdk.internal.cx.x, hashMap);
        }
    }
}
