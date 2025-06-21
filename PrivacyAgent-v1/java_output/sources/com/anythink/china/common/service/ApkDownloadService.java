package com.anythink.china.common.service;

/* loaded from: classes12.dex */
public class ApkDownloadService extends android.app.Service {
    public static final java.lang.String a = "extra_unique_id";
    private static final java.lang.String b = "ApkDownloadService";
    private java.util.Map<java.lang.String, com.anythink.china.common.a.d> c = new java.util.HashMap();

    /* renamed from: com.anythink.china.common.service.ApkDownloadService$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.china.common.a.a.InterfaceC0157a {
        public AnonymousClass1() {
        }

        @Override // com.anythink.china.common.a.a.InterfaceC0157a
        public final void a(com.anythink.china.common.a.e eVar, long j) {
            if (com.anythink.china.common.service.ApkDownloadService.this.c != null) {
                com.anythink.china.common.service.ApkDownloadService.this.c.remove(eVar.n);
            }
            com.anythink.china.common.a.a.InterfaceC0157a c = com.anythink.china.common.a.a(com.anythink.china.common.service.ApkDownloadService.this.getApplicationContext()).c(eVar.n);
            if (c != null) {
                c.a(eVar, j);
            }
        }

        @Override // com.anythink.china.common.a.a.InterfaceC0157a
        public final void a(com.anythink.china.common.a.e eVar, long j, long j2) {
            com.anythink.china.common.a.a.InterfaceC0157a c = com.anythink.china.common.a.a(com.anythink.china.common.service.ApkDownloadService.this.getApplicationContext()).c(eVar.n);
            if (c != null) {
                c.a(eVar, j, j2);
            }
        }

        @Override // com.anythink.china.common.a.a.InterfaceC0157a
        public final void a(com.anythink.china.common.a.e eVar, long j, long j2, int i) {
            if (com.anythink.china.common.service.ApkDownloadService.this.c != null) {
                com.anythink.china.common.service.ApkDownloadService.this.c.remove(eVar.n);
            }
            com.anythink.china.common.a.a.InterfaceC0157a c = com.anythink.china.common.a.a(com.anythink.china.common.service.ApkDownloadService.this.getApplicationContext()).c(eVar.n);
            if (c != null) {
                c.a(eVar, j, j2, i);
            }
        }

        @Override // com.anythink.china.common.a.a.InterfaceC0157a
        public final void a(com.anythink.china.common.a.e eVar, java.lang.String str) {
            if (com.anythink.china.common.service.ApkDownloadService.this.c != null) {
                com.anythink.china.common.service.ApkDownloadService.this.c.remove(eVar.n);
            }
            com.anythink.china.common.a.a.InterfaceC0157a c = com.anythink.china.common.a.a(com.anythink.china.common.service.ApkDownloadService.this.getApplicationContext()).c(eVar.n);
            if (c != null) {
                c.a(eVar, str);
            }
        }

        @Override // com.anythink.china.common.a.a.InterfaceC0157a
        public final void b(com.anythink.china.common.a.e eVar, long j, long j2) {
            com.anythink.china.common.a.a.InterfaceC0157a c = com.anythink.china.common.a.a(com.anythink.china.common.service.ApkDownloadService.this.getApplicationContext()).c(eVar.n);
            if (c != null) {
                c.b(eVar, j, j2);
            }
        }
    }

    public class a extends android.os.Binder implements com.anythink.china.common.service.a {
        public a() {
        }

        @Override // com.anythink.china.common.service.a
        public final void a(java.lang.String str) {
            com.anythink.china.common.service.ApkDownloadService.this.a(str);
        }

        @Override // com.anythink.china.common.service.a
        public final boolean a() {
            return com.anythink.china.common.service.ApkDownloadService.this.c.size() == 0;
        }

        @Override // com.anythink.china.common.service.a
        public final void b(java.lang.String str) {
            com.anythink.china.common.a.d dVar = (com.anythink.china.common.a.d) com.anythink.china.common.service.ApkDownloadService.this.c.get(str);
            if (dVar != null) {
                dVar.b();
                com.anythink.china.common.service.ApkDownloadService.this.c.remove(str);
            }
        }

        @Override // com.anythink.china.common.service.a
        public final void c(java.lang.String str) {
            com.anythink.china.common.a.d dVar = (com.anythink.china.common.a.d) com.anythink.china.common.service.ApkDownloadService.this.c.get(str);
            if (dVar != null) {
                dVar.a();
                com.anythink.china.common.service.ApkDownloadService.this.c.remove(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(java.lang.String str) {
        try {
            com.anythink.china.common.a.e eVar = com.anythink.china.common.a.a(getApplicationContext()).f().get(str);
            if (eVar == null) {
                return;
            }
            com.anythink.china.common.a.d dVar = new com.anythink.china.common.a.d(eVar);
            dVar.a(new com.anythink.china.common.service.ApkDownloadService.AnonymousClass1());
            java.util.Map<java.lang.String, com.anythink.china.common.a.d> map = this.c;
            if (map != null) {
                map.put(str, dVar);
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Service
    @androidx.annotation.Nullable
    public android.os.IBinder onBind(android.content.Intent intent) {
        if (intent != null) {
            a(intent.getStringExtra(a));
        }
        return new com.anythink.china.common.service.ApkDownloadService.a();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Service
    public void onTaskRemoved(android.content.Intent intent) {
        com.anythink.china.common.b.a.a(getApplicationContext()).a();
        super.onTaskRemoved(intent);
    }

    @Override // android.app.Service
    public boolean onUnbind(android.content.Intent intent) {
        return super.onUnbind(intent);
    }
}
