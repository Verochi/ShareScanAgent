package com.vivo.push.d;

/* loaded from: classes19.dex */
final class s implements java.lang.Runnable {
    final /* synthetic */ com.vivo.push.model.InsideNotificationItem a;
    final /* synthetic */ com.vivo.push.b.q b;
    final /* synthetic */ com.vivo.push.d.r c;

    public s(com.vivo.push.d.r rVar, com.vivo.push.model.InsideNotificationItem insideNotificationItem, com.vivo.push.b.q qVar) {
        this.c = rVar;
        this.a = insideNotificationItem;
        this.b = qVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        android.content.Context context;
        android.content.Context context2;
        android.content.Context context3;
        android.content.Context context4;
        android.content.Context context5;
        android.content.Context context6;
        char c;
        android.content.Context context7;
        android.content.Context context8;
        android.content.Context context9;
        android.content.Context context10;
        android.content.Context context11;
        android.content.Context context12;
        android.content.Context context13;
        android.content.Context context14;
        com.vivo.push.d.r rVar = this.c;
        com.vivo.push.sdk.PushMessageCallback pushMessageCallback = ((com.vivo.push.d.z) rVar).b;
        context = ((com.vivo.push.l) rVar).a;
        if (pushMessageCallback.onNotificationMessageArrived(context, com.vivo.push.util.q.a(this.a))) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder("pkg name : ");
            context11 = ((com.vivo.push.l) this.c).a;
            sb.append(context11.getPackageName());
            sb.append(" 应用主动拦截通知");
            com.vivo.push.util.p.b("OnNotificationArrivedTask", sb.toString());
            context12 = ((com.vivo.push.l) this.c).a;
            com.vivo.push.util.p.b(context12, "应用主动拦截通知，导致通知无法展示，如需打开请在onNotificationMessageArrived中返回false");
            java.util.HashMap hashMap = new java.util.HashMap();
            hashMap.put(com.heytap.mcssdk.constant.b.c, java.lang.String.valueOf(this.b.f()));
            context13 = ((com.vivo.push.l) this.c).a;
            context14 = ((com.vivo.push.l) this.c).a;
            java.lang.String b = com.vivo.push.util.z.b(context13, context14.getPackageName());
            if (!android.text.TextUtils.isEmpty(b)) {
                hashMap.put("remoteAppId", b);
            }
            com.vivo.push.util.e.a(2120L, hashMap);
            return;
        }
        int b2 = this.c.b();
        if (b2 > 0) {
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder("pkg name : ");
            context7 = ((com.vivo.push.l) this.c).a;
            sb2.append(context7.getPackageName());
            sb2.append(" notify channel switch is ");
            sb2.append(b2);
            com.vivo.push.util.p.b("OnNotificationArrivedTask", sb2.toString());
            context8 = ((com.vivo.push.l) this.c).a;
            com.vivo.push.util.p.b(context8, "允许通知开关或者推送通知渠道开关关闭，导致通知无法展示，请到设置页打开应用通知开关 ".concat(java.lang.String.valueOf(b2)));
            java.util.HashMap hashMap2 = new java.util.HashMap();
            hashMap2.put(com.heytap.mcssdk.constant.b.c, java.lang.String.valueOf(this.b.f()));
            context9 = ((com.vivo.push.l) this.c).a;
            context10 = ((com.vivo.push.l) this.c).a;
            java.lang.String b3 = com.vivo.push.util.z.b(context9, context10.getPackageName());
            if (!android.text.TextUtils.isEmpty(b3)) {
                hashMap2.put("remoteAppId", b3);
            }
            com.vivo.push.util.e.a(b2, hashMap2);
            return;
        }
        context2 = ((com.vivo.push.l) this.c).a;
        com.vivo.push.model.InsideNotificationItem insideNotificationItem = this.a;
        long f = this.b.f();
        com.vivo.push.d.r rVar2 = this.c;
        com.vivo.push.sdk.PushMessageCallback pushMessageCallback2 = ((com.vivo.push.d.z) rVar2).b;
        context3 = ((com.vivo.push.l) rVar2).a;
        com.vivo.push.util.k kVar = new com.vivo.push.util.k(context2, insideNotificationItem, f, pushMessageCallback2.isAllowNet(context3), new com.vivo.push.d.t(this));
        boolean isShowBigPicOnMobileNet = this.a.isShowBigPicOnMobileNet();
        java.lang.String purePicUrl = this.a.getPurePicUrl();
        if (android.text.TextUtils.isEmpty(purePicUrl)) {
            purePicUrl = this.a.getCoverUrl();
        }
        if (!android.text.TextUtils.isEmpty(purePicUrl)) {
            com.vivo.push.util.p.c("OnNotificationArrivedTask", "showCode=".concat(java.lang.String.valueOf(isShowBigPicOnMobileNet)));
            if (isShowBigPicOnMobileNet) {
                context4 = ((com.vivo.push.l) this.c).a;
                com.vivo.push.util.p.a(context4, "mobile net show");
            } else {
                context5 = ((com.vivo.push.l) this.c).a;
                com.vivo.push.util.p.a(context5, "mobile net unshow");
                context6 = ((com.vivo.push.l) this.c).a;
                android.net.NetworkInfo a = com.vivo.push.util.r.a(context6);
                if (a != null && a.getState() == android.net.NetworkInfo.State.CONNECTED) {
                    int type = a.getType();
                    c = type == 1 ? (char) 2 : type == 0 ? (char) 1 : (char) 3;
                } else {
                    c = 0;
                }
                if (c == 1) {
                    this.a.clearCoverUrl();
                    this.a.clearPurePicUrl();
                    purePicUrl = null;
                }
            }
        }
        kVar.execute(this.a.getIconUrl(), purePicUrl);
    }
}
