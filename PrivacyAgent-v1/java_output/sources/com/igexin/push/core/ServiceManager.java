package com.igexin.push.core;

/* loaded from: classes31.dex */
public class ServiceManager {
    public static android.content.Context b = null;
    private static final java.lang.String c = "ServiceManager";
    public com.igexin.sdk.IPushCore a;
    private final java.util.concurrent.atomic.AtomicBoolean d;
    private java.lang.String e;
    private java.lang.Class f;
    private java.lang.Class g;
    private java.util.concurrent.atomic.AtomicBoolean h;
    private final android.content.ServiceConnection i;
    public android.util.Pair<java.lang.Integer, java.lang.String> initType;

    /* renamed from: com.igexin.push.core.ServiceManager$1, reason: invalid class name */
    /* loaded from: classes23.dex */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ android.content.Intent b;
        final /* synthetic */ android.app.Service c;
        final /* synthetic */ int d;
        final /* synthetic */ int e;

        public AnonymousClass1(android.content.Context context, android.content.Intent intent, android.app.Service service, int i, int i2) {
            this.a = context;
            this.b = intent;
            this.c = service;
            this.d = i;
            this.e = i2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.igexin.push.core.ServiceManager serviceManager;
            android.app.Service service;
            android.content.Intent intent;
            int i;
            int i2;
            try {
                com.igexin.c.a.c.a.a(com.igexin.push.core.ServiceManager.c, "| PushService startCommand... time = " + java.lang.System.currentTimeMillis() + " intent = " + this.b);
                android.content.Intent intent2 = this.b;
                if (intent2 == null) {
                    com.igexin.push.core.ServiceManager.this.initType = android.util.Pair.create(0, null);
                    com.igexin.push.core.ServiceManager.this.b(this.c);
                    return;
                }
                com.igexin.push.h.o.a(this.a, intent2);
                android.os.Bundle extras = this.b.getExtras();
                if (extras != null) {
                    for (java.lang.String str : extras.keySet()) {
                        extras.get(str);
                        com.igexin.c.a.c.a.a("ServiceManager|key [" + str + "]: " + extras.get(str), new java.lang.Object[0]);
                    }
                } else {
                    com.igexin.c.a.c.a.a("ServiceManager|no extras", new java.lang.Object[0]);
                }
                java.lang.String stringExtra = this.b.getStringExtra("action");
                boolean booleanExtra = this.b.getBooleanExtra("isGuard", false);
                boolean booleanExtra2 = this.b.getBooleanExtra("isGuardForce", false);
                if (com.igexin.push.core.ServiceManager.this.d.getAndSet(true)) {
                    if (((java.lang.Integer) com.igexin.push.core.ServiceManager.this.initType.first).equals(0) && booleanExtra2) {
                        com.igexin.push.core.ServiceManager.this.initType = android.util.Pair.create(1, this.b.getStringExtra("pkg"));
                        com.igexin.push.h.o.a(this.a, "it", com.igexin.push.core.ServiceManager.this.initType.first);
                    }
                    com.igexin.push.core.ServiceManager.this.a(this.b, this.d, this.e);
                    return;
                }
                if (booleanExtra) {
                    com.igexin.push.core.ServiceManager.this.initType = android.util.Pair.create(1, this.b.getStringExtra("pkg"));
                    com.igexin.push.core.ServiceManager.this.c(this.c, this.b, this.d, this.e);
                    com.igexin.push.h.o.a(this.a, "it", com.igexin.push.core.ServiceManager.this.initType.first);
                    return;
                }
                com.igexin.push.core.ServiceManager.this.initType = android.util.Pair.create(0, null);
                if (true ^ com.igexin.push.h.j.a(this.a)) {
                    serviceManager = com.igexin.push.core.ServiceManager.this;
                    service = this.c;
                    intent = this.b;
                    i = this.d;
                    i2 = this.e;
                } else if (!com.igexin.sdk.PushConsts.ACTION_SERVICE_INITIALIZE.equals(stringExtra)) {
                    com.igexin.push.core.ServiceManager.this.d.set(false);
                    this.c.stopSelf();
                    return;
                } else {
                    serviceManager = com.igexin.push.core.ServiceManager.this;
                    service = this.c;
                    intent = this.b;
                    i = this.d;
                    i2 = this.e;
                }
                serviceManager.b(service, intent, i, i2);
                com.igexin.push.h.o.a(this.a, "it", com.igexin.push.core.ServiceManager.this.initType.first);
            } catch (java.lang.Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
        }
    }

    /* renamed from: com.igexin.push.core.ServiceManager$2, reason: invalid class name */
    /* loaded from: classes23.dex */
    public class AnonymousClass2 implements com.igexin.push.h.h.a {
        final /* synthetic */ android.app.Service a;

        public AnonymousClass2(android.app.Service service) {
            this.a = service;
        }

        @Override // com.igexin.push.h.h.a
        public final void a(boolean z) {
            com.igexin.c.a.c.a.a(com.igexin.push.core.ServiceManager.c, "load encrypt error, report bi result = " + z + " ###########");
            com.igexin.c.a.c.a.a("ServiceManager|load encrypt error, report bi result = " + z + " ###########", new java.lang.Object[0]);
            this.a.stopSelf();
        }
    }

    /* renamed from: com.igexin.push.core.ServiceManager$3, reason: invalid class name */
    /* loaded from: classes23.dex */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ boolean a;
        final /* synthetic */ long b;

        public AnonymousClass3(boolean z, long j) {
            this.a = z;
            this.b = j;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.igexin.push.core.d.d.a().a(this.a ? com.igexin.push.core.d.d.b : com.igexin.push.core.d.d.c, java.lang.Long.valueOf(this.b));
            java.lang.StringBuilder sb = new java.lang.StringBuilder("init in ");
            sb.append(this.a ? "main process " : "other process ");
            sb.append(this.b);
            com.igexin.c.a.c.a.b(com.igexin.push.core.ServiceManager.c, sb.toString());
        }
    }

    /* renamed from: com.igexin.push.core.ServiceManager$4, reason: invalid class name */
    /* loaded from: classes23.dex */
    public class AnonymousClass4 implements java.lang.Runnable {
        final /* synthetic */ android.content.Intent a;
        final /* synthetic */ long b;
        final /* synthetic */ android.app.Activity c;
        final /* synthetic */ java.lang.String d;

        public AnonymousClass4(android.content.Intent intent, long j, android.app.Activity activity, java.lang.String str) {
            this.a = intent;
            this.b = j;
            this.c = activity;
            this.d = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (!com.igexin.push.h.j.a(com.igexin.push.core.ServiceManager.b)) {
                    android.content.Intent intent = this.a;
                    if (intent != null && intent.getExtras() != null) {
                        try {
                            android.os.Bundle extras = this.a.getExtras();
                            android.os.IBinder binder = extras.getBinder("callback");
                            if (binder != null) {
                                new com.igexin.a.b(binder).a(new android.os.Bundle());
                                extras.remove("callback");
                            }
                        } catch (java.lang.Throwable th) {
                            com.igexin.c.a.c.a.a(th);
                        }
                    }
                    long a = com.igexin.push.core.d.d.a().a(com.igexin.push.core.d.d.b, 0);
                    long a2 = com.igexin.push.core.d.d.a().a(com.igexin.push.core.d.d.c, 0);
                    boolean z = (a == 0 || a2 == 0 || a2 >= a) ? false : true;
                    if (a != 0) {
                        long j = this.b;
                        if (j - a < 5000 || j - a2 < 5000) {
                            z = true;
                        }
                    }
                    android.app.Activity activity = this.c;
                    com.igexin.push.core.a.b.d();
                    android.content.Intent intent2 = new android.content.Intent(activity, (java.lang.Class<?>) com.igexin.push.core.a.b.a((android.content.Context) this.c));
                    android.content.Intent intent3 = this.a;
                    if (intent3 != null && intent3.hasExtra("action") && this.a.hasExtra("isSlave")) {
                        intent2.putExtra("action", this.a.getStringExtra("action"));
                        intent2.putExtra("isSlave", this.a.getBooleanExtra("isSlave", false));
                        if (this.a.hasExtra("op_app")) {
                            intent2.putExtra("op_app", this.a.getStringExtra("op_app"));
                        }
                    }
                    android.content.Intent intent4 = this.a;
                    if (intent4 != null && intent4.hasExtra("pkg")) {
                        intent2.putExtra("pkg", this.a.getStringExtra("pkg"));
                    }
                    intent2.putExtra("isGuard", true);
                    intent2.putExtra("isGuardForce", z);
                    com.igexin.push.core.ServiceManager.this.b(this.c, intent2);
                    com.igexin.c.a.c.a.a("ServiceManager|start PushService from da " + this.d, new java.lang.Object[0]);
                }
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    /* renamed from: com.igexin.push.core.ServiceManager$5, reason: invalid class name */
    /* loaded from: classes23.dex */
    public class AnonymousClass5 implements java.lang.Runnable {
        final /* synthetic */ android.content.Intent a;
        final /* synthetic */ long b;
        final /* synthetic */ android.content.Context c;

        public AnonymousClass5(android.content.Intent intent, long j, android.content.Context context) {
            this.a = intent;
            this.b = j;
            this.c = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (com.igexin.push.h.j.a(com.igexin.push.core.ServiceManager.b)) {
                return;
            }
            android.content.Intent intent = this.a;
            if (intent != null && intent.getExtras() != null) {
                try {
                    android.os.Bundle extras = this.a.getExtras();
                    android.os.IBinder binder = extras.getBinder("callback");
                    if (binder != null) {
                        new com.igexin.a.b(binder).a(new android.os.Bundle());
                        extras.remove("callback");
                    }
                } catch (java.lang.Throwable th) {
                    com.igexin.c.a.c.a.a(th);
                }
            }
            long a = com.igexin.push.core.d.d.a().a(com.igexin.push.core.d.d.b, 0);
            long a2 = com.igexin.push.core.d.d.a().a(com.igexin.push.core.d.d.c, 0);
            boolean z = (a == 0 || a2 == 0 || a2 >= a) ? false : true;
            if (a != 0 && this.b - a < 5000) {
                z = true;
            }
            android.content.Context context = this.c;
            com.igexin.push.core.a.b.d();
            android.content.Intent intent2 = new android.content.Intent(context, (java.lang.Class<?>) com.igexin.push.core.a.b.a(this.c));
            android.content.Intent intent3 = this.a;
            if (intent3 != null && intent3.hasExtra("action") && this.a.hasExtra("isSlave")) {
                intent2.putExtra("action", this.a.getStringExtra("action"));
                intent2.putExtra("isSlave", this.a.getBooleanExtra("isSlave", false));
                if (this.a.hasExtra("op_app")) {
                    intent2.putExtra("op_app", this.a.getStringExtra("op_app"));
                }
            }
            android.content.Intent intent4 = this.a;
            if (intent4 != null && intent4.hasExtra("pkg")) {
                intent2.putExtra("pkg", this.a.getStringExtra("pkg"));
            }
            intent2.putExtra("isGuard", true);
            intent2.putExtra("isGuardForce", z);
            com.igexin.push.core.ServiceManager.this.b(this.c, intent2);
            com.igexin.c.a.c.a.a("ServiceManager|start PushService from da", new java.lang.Object[0]);
        }
    }

    /* renamed from: com.igexin.push.core.ServiceManager$6, reason: invalid class name */
    /* loaded from: classes23.dex */
    public class AnonymousClass6 implements java.lang.Runnable {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ android.content.Intent b;

        public AnonymousClass6(android.content.Context context, android.content.Intent intent) {
            this.a = context;
            this.b = intent;
        }

        private void a() {
            try {
                com.igexin.c.a.c.a.a("ServiceManager|startPService by bind", new java.lang.Object[0]);
                this.b.setType("PB-" + java.lang.System.nanoTime());
                android.content.Intent intent = this.b;
                android.content.Context context = this.a;
                intent.setClass(context, com.igexin.push.core.ServiceManager.this.b(context));
                this.a.getApplicationContext().bindService(this.b, com.igexin.push.core.ServiceManager.this.i, 1);
            } catch (java.lang.Throwable th) {
                com.igexin.c.a.c.a.b(com.igexin.push.core.ServiceManager.c, "startPService exception = " + th.toString());
                com.igexin.c.a.c.a.a(th);
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (android.os.Build.VERSION.SDK_INT < 26 || !com.igexin.push.h.c.g()) {
                    this.a.getApplicationContext().startService(this.b);
                } else {
                    a();
                }
            } catch (java.lang.Throwable th) {
                com.igexin.c.a.c.a.b(com.igexin.push.core.ServiceManager.c, "startPService exception = " + th.toString());
                com.igexin.c.a.c.a.a(th);
                if (th instanceof java.lang.IllegalStateException) {
                    a();
                }
            }
        }
    }

    /* renamed from: com.igexin.push.core.ServiceManager$7, reason: invalid class name */
    /* loaded from: classes23.dex */
    public class AnonymousClass7 implements android.content.ServiceConnection {
        public AnonymousClass7() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(android.content.ComponentName componentName) {
        }
    }

    /* loaded from: classes23.dex */
    public static class a {
        private static final com.igexin.push.core.ServiceManager a = new com.igexin.push.core.ServiceManager((byte) 0);

        private a() {
        }
    }

    private ServiceManager() {
        this.d = new java.util.concurrent.atomic.AtomicBoolean(false);
        this.h = new java.util.concurrent.atomic.AtomicBoolean(false);
        this.i = new com.igexin.push.core.ServiceManager.AnonymousClass7();
    }

    public /* synthetic */ ServiceManager(byte b2) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(android.content.Intent intent, int i, int i2) {
        if (this.a == null) {
            return 2;
        }
        com.igexin.c.a.c.a.a("ServiceManager|inInit = true, call onServiceStartCommand...", new java.lang.Object[0]);
        return this.a.onServiceStartCommand(intent, i, i2);
    }

    public static void a() {
        com.igexin.c.a.c.a.a("ServiceManager|onLowMemory...", new java.lang.Object[0]);
    }

    private void a(android.app.Activity activity) {
        try {
            android.content.Context applicationContext = activity.getApplicationContext();
            b = applicationContext;
            com.getui.gtc.base.GtcProvider.setContext(applicationContext);
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            java.lang.String name = activity.getClass().getName();
            com.igexin.b.a.a().a("gd").execute(new com.igexin.push.core.ServiceManager.AnonymousClass4(activity.getIntent(), currentTimeMillis, activity, name));
        } catch (java.lang.Throwable th) {
            activity.finish();
            com.igexin.c.a.c.a.a(th);
        }
    }

    private void a(android.app.Service service) {
        com.igexin.c.a.c.a.a("ServiceManager|startGTCore ++++", new java.lang.Object[0]);
        if (!com.igexin.push.h.g.a()) {
            com.igexin.b.a.a().a.execute(new com.igexin.push.h.h.AnonymousClass1(service, new com.igexin.push.core.ServiceManager.AnonymousClass2(service)));
            return;
        }
        com.igexin.sdk.main.PushCoreLoader.getInstance().init(service);
        this.a = com.igexin.sdk.main.PushCoreLoader.getInstance().getPushCore();
        if (com.igexin.sdk.main.PushCoreLoader.getInstance().getGtcCore() != null) {
            com.igexin.sdk.main.PushCoreLoader.getInstance().getGtcCore().start(service);
        }
        com.igexin.sdk.IPushCore iPushCore = this.a;
        if (iPushCore != null) {
            iPushCore.start(service);
        }
    }

    public static void a(android.content.Context context) {
        b = context.getApplicationContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(android.app.Service service) {
        com.igexin.c.a.c.a.a("ServiceManager|start by system ####", new java.lang.Object[0]);
        if (!g(service)) {
            service.stopSelf();
            return 2;
        }
        com.igexin.c.a.c.a.a("ServiceManager|intent = null", new java.lang.Object[0]);
        if (!this.d.getAndSet(true)) {
            a(service);
        }
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(android.app.Service service, android.content.Intent intent, int i, int i2) {
        com.igexin.c.a.c.a.a("ServiceManager|start from initialize...", new java.lang.Object[0]);
        com.igexin.c.a.c.a.d.a().a("[ServiceManager] ServiceManager start from initialize...");
        a(service);
        com.igexin.sdk.IPushCore iPushCore = this.a;
        if (iPushCore != null) {
            return iPushCore.onServiceStartCommand(intent, i, i2);
        }
        return 2;
    }

    private void b() {
        com.igexin.c.a.c.a.a("ServiceManager|onDestroy...", new java.lang.Object[0]);
        com.igexin.sdk.IPushCore iPushCore = this.a;
        if (iPushCore != null) {
            iPushCore.onServiceDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c(android.app.Service service, android.content.Intent intent, int i, int i2) {
        com.igexin.c.a.c.a.a("ServiceManager|start from guard...", new java.lang.Object[0]);
        if (!g(service)) {
            this.d.set(false);
            service.stopSelf();
            return 2;
        }
        a(service);
        com.igexin.sdk.IPushCore iPushCore = this.a;
        if (iPushCore != null) {
            return iPushCore.onServiceStartCommand(intent, i, i2);
        }
        return 2;
    }

    private boolean c(android.content.Context context, android.content.Intent intent) {
        com.igexin.b.a.a().a("pushservice").execute(new com.igexin.push.core.ServiceManager.AnonymousClass6(context, intent));
        return true;
    }

    public static java.lang.String d(android.content.Context context) {
        return (java.lang.String) com.igexin.push.h.o.b(context, "ua", "");
    }

    public static java.lang.String e(android.content.Context context) {
        return (java.lang.String) com.igexin.push.h.o.b(context, "us", "");
    }

    private static boolean g(android.content.Context context) {
        return !com.igexin.push.h.j.a(context);
    }

    public static com.igexin.push.core.ServiceManager getInstance() {
        return com.igexin.push.core.ServiceManager.a.a;
    }

    public final int a(android.app.Service service, android.content.Intent intent, int i, int i2) {
        com.igexin.b.a.a().a("pushservice").execute(new com.igexin.push.core.ServiceManager.AnonymousClass1(service.getApplicationContext(), intent, service, i, i2));
        return 2;
    }

    public final android.os.IBinder a(android.app.Service service, android.content.Intent intent) {
        com.igexin.c.a.c.a.a("ServiceManager|onBind...", new java.lang.Object[0]);
        a(service, intent, 0, 0);
        com.igexin.sdk.IPushCore iPushCore = this.a;
        if (iPushCore != null) {
            return iPushCore.onServiceBind(intent);
        }
        return null;
    }

    public final void a(android.content.Context context, android.content.Intent intent) {
        try {
            android.content.Context applicationContext = context.getApplicationContext();
            b = applicationContext;
            com.getui.gtc.base.GtcProvider.setContext(applicationContext);
            com.igexin.b.a.a().a("gd").execute(new com.igexin.push.core.ServiceManager.AnonymousClass5(intent, java.lang.System.currentTimeMillis(), context));
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    public final java.lang.Class b(android.content.Context context) {
        android.content.ComponentName componentName;
        try {
            if (this.g == null) {
                java.lang.Class cls = (java.lang.Class) com.igexin.push.h.d.a(context, com.igexin.sdk.PushService.class).second;
                this.g = cls;
                if (cls == null) {
                    java.lang.String str = (java.lang.String) com.igexin.push.h.o.b(context, com.igexin.push.h.o.b, "");
                    if (!android.text.TextUtils.isEmpty(str)) {
                        this.g = java.lang.Class.forName(str);
                    }
                }
                if (this.g == null) {
                    this.g = com.igexin.sdk.PushService.class;
                }
            }
            componentName = new android.content.ComponentName(context, (java.lang.Class<?>) this.g);
        } catch (java.lang.Throwable th) {
            try {
                this.g = com.igexin.sdk.PushService.class;
                com.igexin.c.a.c.a.a(th);
                componentName = new android.content.ComponentName(context, (java.lang.Class<?>) this.g);
            } catch (java.lang.Throwable th2) {
                context.getPackageManager().setComponentEnabledSetting(new android.content.ComponentName(context, (java.lang.Class<?>) this.g), 1, 1);
                throw th2;
            }
        }
        context.getPackageManager().setComponentEnabledSetting(componentName, 1, 1);
        return this.g;
    }

    public final boolean b(android.content.Context context, android.content.Intent intent) {
        return c(context.getApplicationContext(), intent);
    }

    public final java.lang.Class c(android.content.Context context) {
        java.lang.Class cls = this.f;
        if (cls != null) {
            return cls;
        }
        java.lang.Class cls2 = (java.lang.Class) com.igexin.push.h.d.a(context, com.igexin.sdk.GTIntentService.class).second;
        this.f = cls2;
        if (cls2 != null) {
            return cls2;
        }
        try {
            java.lang.String str = (java.lang.String) com.igexin.push.h.o.b(context, "uis", "");
            if (!android.text.TextUtils.isEmpty(str)) {
                java.lang.Class<?> cls3 = java.lang.Class.forName(str);
                this.f = cls3;
                return cls3;
            }
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
        return this.f;
    }

    public final void f(android.content.Context context) {
        b = context.getApplicationContext();
        boolean isMainProcess = com.getui.gtc.base.util.CommonUtil.isMainProcess();
        if (this.h.getAndSet(true)) {
            com.igexin.b.a.a().a("gd").execute(new com.igexin.push.core.ServiceManager.AnonymousClass3(isMainProcess, java.lang.System.currentTimeMillis()));
        }
    }
}
