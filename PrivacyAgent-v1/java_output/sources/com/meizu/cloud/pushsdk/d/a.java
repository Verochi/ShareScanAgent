package com.meizu.cloud.pushsdk.d;

/* loaded from: classes23.dex */
public class a {
    private static com.meizu.cloud.pushsdk.d.e.a a;
    private static android.content.BroadcastReceiver b;

    /* renamed from: com.meizu.cloud.pushsdk.d.a$1, reason: invalid class name */
    public static class AnonymousClass1 extends android.content.BroadcastReceiver {
        final /* synthetic */ com.meizu.cloud.pushsdk.d.e.a a;

        public AnonymousClass1(com.meizu.cloud.pushsdk.d.e.a aVar) {
            this.a = aVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(android.content.Context context, android.content.Intent intent) {
            if (com.meizu.cloud.pushsdk.d.f.e.a(context)) {
                com.meizu.cloud.pushsdk.d.f.c.a("QuickTracker", "restart track event: %s", "online true");
                this.a.a();
            }
        }
    }

    public static com.meizu.cloud.pushsdk.d.e.a a(android.content.Context context, com.meizu.cloud.pushsdk.c.c.a aVar, com.meizu.cloud.pushsdk.d.b.f fVar) {
        if (a == null) {
            synchronized (com.meizu.cloud.pushsdk.d.a.class) {
                if (a == null) {
                    com.meizu.cloud.pushsdk.d.e.a a2 = a(b(context, aVar, fVar), (com.meizu.cloud.pushsdk.d.e.c) null, context);
                    a = a2;
                    a(context, a2);
                }
            }
        }
        return a;
    }

    public static com.meizu.cloud.pushsdk.d.e.a a(android.content.Context context, boolean z) {
        if (a == null) {
            synchronized (com.meizu.cloud.pushsdk.d.a.class) {
                if (a == null) {
                    a = a(b(context, null, null), (com.meizu.cloud.pushsdk.d.e.c) null, context);
                }
            }
        }
        com.meizu.cloud.pushinternal.DebugLogger.i("PushAndroidTracker", "can upload subject " + z);
        if (z) {
            a.a(a(context));
        }
        return a;
    }

    private static com.meizu.cloud.pushsdk.d.e.a a(com.meizu.cloud.pushsdk.d.b.a aVar, com.meizu.cloud.pushsdk.d.e.c cVar, android.content.Context context) {
        return new com.meizu.cloud.pushsdk.d.e.a.a(new com.meizu.cloud.pushsdk.d.e.a.C0427a(aVar, "PushAndroidTracker", context.getPackageCodePath(), context, com.meizu.cloud.pushsdk.d.e.a.a.class).a(com.meizu.cloud.pushsdk.d.f.b.VERBOSE).a(java.lang.Boolean.FALSE).a(cVar).a(4));
    }

    private static com.meizu.cloud.pushsdk.d.e.c a(android.content.Context context) {
        return new com.meizu.cloud.pushsdk.d.e.c.a().a(context).a();
    }

    private static java.lang.String a() {
        java.lang.String str = com.meizu.cloud.pushsdk.util.MzSystemUtils.isOverseas() ? com.meizu.cloud.pushsdk.constants.PushConstants.URL_ABROAD_STATICS_DOMAIN : com.meizu.cloud.pushsdk.constants.PushConstants.URL_STATICS_DOMAIN;
        com.meizu.cloud.pushinternal.DebugLogger.e("QuickTracker", "current statics domain is " + str);
        return str;
    }

    private static void a(android.content.Context context, com.meizu.cloud.pushsdk.d.e.a aVar) {
        if (b != null) {
            return;
        }
        b = new com.meizu.cloud.pushsdk.d.a.AnonymousClass1(aVar);
        context.registerReceiver(b, new android.content.IntentFilter(com.igexin.sdk.PushConsts.ACTION_BROADCAST_NETWORK_CHANGE));
    }

    private static com.meizu.cloud.pushsdk.d.b.a b(android.content.Context context, com.meizu.cloud.pushsdk.c.c.a aVar, com.meizu.cloud.pushsdk.d.b.f fVar) {
        com.meizu.cloud.pushsdk.d.b.a.C0424a a2 = new com.meizu.cloud.pushsdk.d.b.a.C0424a(a(), context, com.meizu.cloud.pushsdk.d.b.a.a.class).a(fVar).a(aVar).a(1);
        com.meizu.cloud.pushsdk.d.b.b bVar = com.meizu.cloud.pushsdk.d.b.b.DefaultGroup;
        return new com.meizu.cloud.pushsdk.d.b.a.a(a2.a(bVar).b(bVar.a()).c(2));
    }
}
