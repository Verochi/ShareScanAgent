package com.getui.gtc.extension.a;

/* loaded from: classes22.dex */
public final class a {
    android.os.Handler a;
    public com.igexin.push.GtPushInterface b;

    /* renamed from: com.getui.gtc.extension.a.a$1, reason: invalid class name */
    public class AnonymousClass1 extends android.os.Handler {
        final /* synthetic */ com.getui.gtc.extension.a.b a;
        final /* synthetic */ android.os.HandlerThread b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(android.os.Looper looper, com.getui.gtc.extension.a.b bVar, android.os.HandlerThread handlerThread) {
            super(looper);
            this.a = bVar;
            this.b = handlerThread;
        }

        @Override // android.os.Handler
        public final void handleMessage(android.os.Message message) {
            try {
            } catch (java.lang.Exception e) {
                com.getui.gtc.h.c.a.b(e);
                com.getui.gtc.extension.a.b bVar = this.a;
                if (bVar != null) {
                    bVar.a(false);
                }
            }
            if (message.what < 0) {
                com.getui.gtc.extension.a.b bVar2 = this.a;
                if (bVar2 != null) {
                    bVar2.a(false);
                    return;
                }
                return;
            }
            boolean loadSdk = com.getui.gtc.extension.a.a.this.b.loadSdk(message.getData());
            com.getui.gtc.extension.a.b bVar3 = this.a;
            if (bVar3 != null) {
                bVar3.a(loadSdk);
            }
            this.b.quit();
            com.getui.gtc.extension.a.a.this.a = null;
        }
    }

    /* renamed from: com.getui.gtc.extension.a.a$2, reason: invalid class name */
    public class AnonymousClass2 implements android.content.ServiceConnection {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ java.lang.String c;
        final /* synthetic */ java.lang.String d;
        final /* synthetic */ java.lang.String e;

        public AnonymousClass2(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.e = str5;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            com.getui.gtc.extension.a.a.this.b = com.igexin.push.GtPushInterface.Stub.asInterface(iBinder);
            com.getui.gtc.extension.a.a.this.a(this.a, this.b, this.c, this.d, this.e);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(android.content.ComponentName componentName) {
            com.getui.gtc.extension.a.a.this.b = null;
        }
    }

    public a(com.getui.gtc.extension.a.b bVar) {
        android.os.HandlerThread handlerThread = new android.os.HandlerThread("Plugin Handler Thread");
        handlerThread.start();
        this.a = new com.getui.gtc.extension.a.a.AnonymousClass1(handlerThread.getLooper(), bVar, handlerThread);
    }

    public static android.util.Pair<android.content.pm.ServiceInfo, java.lang.Class> a(android.content.Context context, java.lang.Class cls) {
        boolean z;
        try {
            android.content.pm.ServiceInfo[] serviceInfoArr = com.getui.gtc.base.util.CommonUtil.getPackageInfoForSelf(context).services;
            if (serviceInfoArr == null || serviceInfoArr.length <= 0) {
                com.getui.gtc.h.c.a.b("no any service");
            } else {
                int length = serviceInfoArr.length;
                for (int i = 0; i < length; i++) {
                    android.content.pm.ServiceInfo serviceInfo = serviceInfoArr[i];
                    try {
                        java.lang.Class<?> cls2 = java.lang.Class.forName(serviceInfo.name);
                        if (cls2 != cls) {
                            java.lang.Class<?> cls3 = cls2;
                            for (int i2 = 5; cls3 != null && cls != null && i2 > 0; i2--) {
                                if (cls3 == cls) {
                                    z = true;
                                    break;
                                }
                                if (cls3.getSuperclass() == null) {
                                    break;
                                }
                                cls3 = cls3.getSuperclass();
                            }
                            z = false;
                            if (z) {
                                return android.util.Pair.create(serviceInfo, cls2);
                            }
                            continue;
                        }
                    } catch (java.lang.Throwable unused) {
                    }
                }
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.h.c.a.a("findGtImplClassInManifest error", th);
        }
        return android.util.Pair.create(null, null);
    }

    public final void a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) {
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putString("dp", str);
        bundle.putString("od", str2);
        bundle.putString(com.meizu.cloud.pushsdk.notification.model.AdvanceSetting.CLEAR_NOTIFICATION, str3);
        bundle.putString(com.umeng.analytics.pro.bo.aC, str4);
        bundle.putString("gd", str5);
        android.os.Message obtain = android.os.Message.obtain();
        obtain.setData(bundle);
        obtain.what = 0;
        android.os.Handler handler = this.a;
        if (handler != null) {
            obtain.setTarget(handler);
            obtain.sendToTarget();
        }
    }
}
