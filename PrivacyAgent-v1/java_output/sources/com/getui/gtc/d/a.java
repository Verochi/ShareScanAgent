package com.getui.gtc.d;

/* loaded from: classes22.dex */
public final class a {
    final com.getui.gtc.extension.c a;
    private final android.os.Handler b;

    /* renamed from: com.getui.gtc.d.a$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.getui.gtc.api.GtcIdCallback a;

        public AnonymousClass1(com.getui.gtc.api.GtcIdCallback gtcIdCallback) {
            this.a = gtcIdCallback;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.getui.gtc.c.b.a(this.a);
            } catch (java.lang.Exception e) {
                com.getui.gtc.h.c.a.c(e);
            }
        }
    }

    /* renamed from: com.getui.gtc.d.a$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ com.getui.gtc.api.SdkInfo a;

        public AnonymousClass2(com.getui.gtc.api.SdkInfo sdkInfo) {
            this.a = sdkInfo;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.getui.gtc.d.a.this.a.a(this.a);
            } catch (java.lang.Throwable th) {
                com.getui.gtc.h.c.a.b(th);
            }
        }
    }

    /* renamed from: com.getui.gtc.d.a$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ int a;

        public AnonymousClass3(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.getui.gtc.a.a.a(this.a);
            } catch (java.lang.Throwable th) {
                com.getui.gtc.h.c.a.b(th);
            }
        }
    }

    /* renamed from: com.getui.gtc.d.a$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        public AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.getui.gtc.api.SdkInfo.Builder psUrl = new com.getui.gtc.api.SdkInfo.Builder().moduleName("GTC").version(com.getui.gtc.BuildConfig.VERSION_NAME).appid(com.getui.gtc.c.b.a).cid(com.getui.gtc.c.b.d).psUrl(java.lang.String.format("%s/api.php?format=json&t=1", com.getui.gtc.server.ServerManager.getServer("gtc.cs")));
                try {
                    psUrl.addStub("com.getui.gtc.extension.distribution.gbd.stub.PushExtension", false);
                } catch (java.lang.ClassNotFoundException unused) {
                    com.getui.gtc.h.c.a.a("no local gbd");
                }
                try {
                    java.lang.Class.forName("com.getui.gtc.extension.distribution.gws.stub.PushExtension");
                    psUrl.addStub("com.getui.gtc.extension.distribution.gws.stub.PushExtension", false);
                } catch (java.lang.ClassNotFoundException unused2) {
                    com.getui.gtc.h.c.a.a("no local gws");
                }
                com.getui.gtc.d.a.this.a.a(psUrl.build());
            } catch (java.lang.Throwable th) {
                com.getui.gtc.h.c.a.b(th);
            }
        }
    }

    /* renamed from: com.getui.gtc.d.a$5, reason: invalid class name */
    public class AnonymousClass5 implements java.lang.Runnable {
        final /* synthetic */ int[] a;

        public AnonymousClass5(int[] iArr) {
            this.a = iArr;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.getui.gtc.entity.a a;
            com.getui.gtc.entity.a.C0306a b;
            try {
                if (this.a == null) {
                    return;
                }
                com.getui.gtc.h.c.a.a("remove gtcFile id: " + java.util.Arrays.toString(this.a));
                for (int i : this.a) {
                    java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.String>> a2 = com.getui.gtc.dyc.b.a.a(com.getui.gtc.base.GtcProvider.context());
                    if (a2 == null) {
                        return;
                    }
                    java.util.Iterator<java.util.Map.Entry<java.lang.String, java.util.Map<java.lang.String, java.lang.String>>> it = a2.entrySet().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        java.util.Map.Entry<java.lang.String, java.util.Map<java.lang.String, java.lang.String>> next = it.next();
                        java.util.Map<java.lang.String, java.lang.String> value = next.getValue();
                        if (value != null && (a = com.getui.gtc.entity.a.a(value)) != null && (b = a.b(i)) != null) {
                            com.getui.gtc.h.c.a.a("found gtcFile id: " + i + ", remove it");
                            com.getui.gtc.d.a.this.a.a(b.c);
                            a.a.remove(i);
                            value.put("ext_infos", a.a());
                            com.getui.gtc.dyc.b.a.a(com.getui.gtc.base.GtcProvider.context(), next.getKey(), value);
                            break;
                        }
                    }
                }
            } catch (java.lang.Throwable th) {
                com.getui.gtc.h.c.a.b(th);
            }
        }
    }

    /* renamed from: com.getui.gtc.d.a$a, reason: collision with other inner class name */
    public static class C0297a {
        private static final com.getui.gtc.d.a a = new com.getui.gtc.d.a((byte) 0);
    }

    private a() {
        com.getui.gtc.extension.c cVar;
        com.getui.gtc.h.d.b unused;
        android.os.HandlerThread handlerThread = new android.os.HandlerThread("Gtc HandlerThread");
        handlerThread.start();
        android.os.Handler handler = new android.os.Handler(handlerThread.getLooper());
        this.b = handler;
        cVar = com.getui.gtc.extension.c.a.a;
        this.a = cVar;
        com.getui.gtc.c.b.a();
        unused = com.getui.gtc.h.d.b.C0330b.a;
        com.getui.gtc.a.a.a();
        handler.post(new com.getui.gtc.d.a.AnonymousClass4());
    }

    public /* synthetic */ a(byte b) {
        this();
    }

    public final java.lang.String a(com.getui.gtc.api.GtcIdCallback gtcIdCallback) {
        this.b.post(new com.getui.gtc.d.a.AnonymousClass1(gtcIdCallback));
        com.getui.gtc.h.c.a.a("gtcid is " + com.getui.gtc.c.b.d);
        return com.getui.gtc.c.b.d;
    }

    public final void a(int i) {
        this.b.post(new com.getui.gtc.d.a.AnonymousClass3(i));
    }

    public final void a(com.getui.gtc.api.SdkInfo sdkInfo) {
        this.b.post(new com.getui.gtc.d.a.AnonymousClass2(sdkInfo));
    }

    public final void a(int[] iArr) {
        this.b.post(new com.getui.gtc.d.a.AnonymousClass5(iArr));
    }
}
