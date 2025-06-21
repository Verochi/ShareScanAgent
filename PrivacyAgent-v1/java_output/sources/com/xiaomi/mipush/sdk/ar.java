package com.xiaomi.mipush.sdk;

/* loaded from: classes19.dex */
class ar extends android.database.ContentObserver {
    final /* synthetic */ com.xiaomi.mipush.sdk.ao a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ar(com.xiaomi.mipush.sdk.ao aoVar, android.os.Handler handler) {
        super(handler);
        this.a = aoVar;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        android.content.Context context;
        java.lang.Integer num;
        android.content.Context context2;
        android.content.Context context3;
        com.xiaomi.mipush.sdk.ao aoVar = this.a;
        context = aoVar.f28a;
        aoVar.f32a = java.lang.Integer.valueOf(com.xiaomi.push.service.aq.a(context).a());
        num = this.a.f32a;
        if (num.intValue() != 0) {
            context2 = this.a.f28a;
            context2.getContentResolver().unregisterContentObserver(this);
            context3 = this.a.f28a;
            if (com.xiaomi.push.ai.a(context3)) {
                this.a.m123c();
            }
        }
    }
}
