package com.bytedance.pangle.receiver;

/* loaded from: classes12.dex */
public final class a extends android.content.BroadcastReceiver {

    /* renamed from: com.bytedance.pangle.receiver.a$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ android.content.Intent b;

        public AnonymousClass1(android.content.Context context, android.content.Intent intent) {
            this.a = context;
            this.b = intent;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.bytedance.pangle.receiver.c.a().a(this.a, this.b);
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(android.content.Context context, android.content.Intent intent) {
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
        if (com.bytedance.pangle.receiver.c.a().c.contains(java.lang.Integer.valueOf(hashCode()))) {
            com.bytedance.pangle.receiver.c.a().a(context, intent);
        } else {
            com.bytedance.pangle.d.e.b(new com.bytedance.pangle.receiver.a.AnonymousClass1(context, intent));
        }
    }
}
