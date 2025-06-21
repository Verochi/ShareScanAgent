package com.bytedance.pangle.service.a;

/* loaded from: classes.dex */
public class a extends com.bytedance.pangle.e.a {
    private static volatile com.bytedance.pangle.service.a.a c;
    private final java.util.HashMap<android.content.ComponentName, android.os.IBinder> d = new java.util.HashMap<>();
    private final java.util.HashMap<android.content.ComponentName, com.bytedance.pangle.service.a.a.b> e = new java.util.HashMap<>();
    private final com.bytedance.pangle.service.a.a.C0273a<android.content.Intent> f = new com.bytedance.pangle.service.a.a.C0273a<>();
    private final java.util.HashMap<android.content.ComponentName, com.bytedance.pangle.service.a> g = new java.util.HashMap<>();
    private final java.util.HashSet<android.content.ComponentName> h = new java.util.HashSet<>();
    private final java.util.HashSet<android.content.ComponentName> i = new java.util.HashSet<>();
    public final java.util.List<java.lang.Runnable> b = new java.util.ArrayList();
    public final android.os.Handler a = new android.os.Handler(android.os.Looper.getMainLooper());

    /* renamed from: com.bytedance.pangle.service.a.a$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ android.content.Intent a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass1(android.content.Intent intent, java.lang.String str) {
            this.a = intent;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.bytedance.pangle.service.a.a.this.c(this.a, this.b);
        }
    }

    /* renamed from: com.bytedance.pangle.service.a.a$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ android.content.Intent a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass2(android.content.Intent intent, java.lang.String str) {
            this.a = intent;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.bytedance.pangle.service.a.a.this.c(this.a, this.b);
        }
    }

    /* renamed from: com.bytedance.pangle.service.a.a$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ android.content.Intent a;

        public AnonymousClass3(android.content.Intent intent) {
            this.a = intent;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.bytedance.pangle.service.a.a.b().a(this.a.getComponent());
        }
    }

    /* renamed from: com.bytedance.pangle.service.a.a$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        final /* synthetic */ android.content.Intent a;
        final /* synthetic */ com.bytedance.pangle.g b;
        final /* synthetic */ int c;
        final /* synthetic */ java.lang.String d;

        public AnonymousClass4(android.content.Intent intent, com.bytedance.pangle.g gVar, int i, java.lang.String str) {
            this.a = intent;
            this.b = gVar;
            this.c = i;
            this.d = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.bytedance.pangle.service.a.a.this.a(this.a, this.b, this.d);
            } catch (android.os.RemoteException e) {
                com.bytedance.pangle.log.ZeusLogger.errReport(com.bytedance.pangle.log.ZeusLogger.TAG_SERVICE, "bindService failed", e);
            }
        }
    }

    /* renamed from: com.bytedance.pangle.service.a.a$5, reason: invalid class name */
    public class AnonymousClass5 implements java.lang.Runnable {
        final /* synthetic */ android.content.Intent a;
        final /* synthetic */ com.bytedance.pangle.g b;
        final /* synthetic */ int c;
        final /* synthetic */ java.lang.String d;

        public AnonymousClass5(android.content.Intent intent, com.bytedance.pangle.g gVar, int i, java.lang.String str) {
            this.a = intent;
            this.b = gVar;
            this.c = i;
            this.d = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.bytedance.pangle.service.a.a.this.a(this.a, this.b, this.d);
            } catch (android.os.RemoteException e) {
                com.bytedance.pangle.log.ZeusLogger.errReport(com.bytedance.pangle.log.ZeusLogger.TAG_SERVICE, "pending bindService failed", e);
            }
        }
    }

    /* renamed from: com.bytedance.pangle.service.a.a$6, reason: invalid class name */
    public class AnonymousClass6 implements java.lang.Runnable {
        final /* synthetic */ com.bytedance.pangle.g a;

        public AnonymousClass6(com.bytedance.pangle.g gVar) {
            this.a = gVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.bytedance.pangle.service.a.a.this.b(this.a);
        }
    }

    /* renamed from: com.bytedance.pangle.service.a.a$a, reason: collision with other inner class name */
    public class C0273a<T> extends java.util.HashMap<com.bytedance.pangle.g, T> {
        public C0273a() {
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final boolean containsKey(@androidx.annotation.Nullable java.lang.Object obj) {
            if (super.containsKey(obj)) {
                return true;
            }
            if (!(obj instanceof com.bytedance.pangle.g)) {
                return false;
            }
            java.util.Iterator<com.bytedance.pangle.g> it = keySet().iterator();
            while (it.hasNext()) {
                try {
                } catch (android.os.RemoteException e) {
                    e.printStackTrace();
                }
                if (it.next().a() == ((com.bytedance.pangle.g) obj).a()) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        @androidx.annotation.Nullable
        public final T remove(@androidx.annotation.Nullable java.lang.Object obj) {
            com.bytedance.pangle.g gVar;
            T t = (T) super.remove(obj);
            if (t != null) {
                return t;
            }
            java.util.Iterator<com.bytedance.pangle.g> it = keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    gVar = null;
                    break;
                }
                gVar = it.next();
                try {
                } catch (android.os.RemoteException e) {
                    e.printStackTrace();
                }
                if (gVar.a() == ((com.bytedance.pangle.g) obj).a()) {
                    break;
                }
            }
            return (T) super.remove(gVar);
        }
    }

    public class b extends java.util.HashSet<com.bytedance.pangle.g> {
        public b() {
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(@androidx.annotation.Nullable java.lang.Object obj) {
            if (super.contains(obj)) {
                return true;
            }
            if (!(obj instanceof com.bytedance.pangle.g)) {
                return false;
            }
            java.util.Iterator<com.bytedance.pangle.g> it = iterator();
            while (it.hasNext()) {
                try {
                } catch (android.os.RemoteException e) {
                    e.printStackTrace();
                }
                if (it.next().a() == ((com.bytedance.pangle.g) obj).a()) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(@androidx.annotation.Nullable java.lang.Object obj) {
            com.bytedance.pangle.g gVar;
            if (super.remove(obj)) {
                return true;
            }
            java.util.Iterator it = iterator();
            while (true) {
                if (!it.hasNext()) {
                    gVar = null;
                    break;
                }
                gVar = (com.bytedance.pangle.g) it.next();
                try {
                } catch (android.os.RemoteException e) {
                    e.printStackTrace();
                }
                if (gVar.a() == ((com.bytedance.pangle.g) obj).a()) {
                    break;
                }
            }
            return super.remove(gVar);
        }
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean a(android.content.Intent intent, com.bytedance.pangle.g gVar, java.lang.String str) {
        android.content.ComponentName component = intent.getComponent();
        if (!this.g.containsKey(component)) {
            com.bytedance.pangle.service.a d = d(intent, str);
            if (d == null) {
                return false;
            }
            this.g.put(component, d);
        }
        com.bytedance.pangle.service.a aVar = this.g.get(component);
        if (!this.d.containsKey(component)) {
            this.d.put(component, aVar.onBind(intent));
        }
        android.os.IBinder iBinder = this.d.get(component);
        if (iBinder != null) {
            if (!this.e.containsKey(component)) {
                com.bytedance.pangle.service.a.a.b bVar = new com.bytedance.pangle.service.a.a.b();
                bVar.add(gVar);
                this.e.put(component, bVar);
                this.f.put(gVar, intent);
                gVar.a(component, iBinder);
            } else if (!this.e.get(component).contains(gVar)) {
                this.e.get(component).add(gVar);
                this.f.put(gVar, intent);
                gVar.a(component, iBinder);
            }
        }
        return true;
    }

    public static com.bytedance.pangle.service.a.a b() {
        if (c == null) {
            synchronized (com.bytedance.pangle.service.a.a.class) {
                if (c == null) {
                    c = new com.bytedance.pangle.service.a.a();
                }
            }
        }
        return c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(com.bytedance.pangle.g gVar) {
        for (android.content.ComponentName componentName : this.e.keySet()) {
            com.bytedance.pangle.service.a.a.b bVar = this.e.get(componentName);
            if (bVar.contains(gVar)) {
                bVar.remove(gVar);
                android.content.Intent remove = this.f.remove(gVar);
                if (bVar.size() == 0) {
                    this.e.remove(componentName);
                    com.bytedance.pangle.service.a aVar = this.g.get(componentName);
                    if (aVar != null) {
                        aVar.onUnbind(remove);
                    }
                }
                b(componentName);
                return;
            }
        }
    }

    private boolean b(android.content.ComponentName componentName) {
        if (!this.h.contains(componentName)) {
            if (this.e.get(componentName) != null) {
                return false;
            }
            c(componentName);
            return true;
        }
        if (!this.i.contains(componentName) || this.e.containsKey(componentName)) {
            return false;
        }
        c(componentName);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized android.content.ComponentName c(android.content.Intent intent, java.lang.String str) {
        android.content.ComponentName component = intent.getComponent();
        if (!this.g.containsKey(component)) {
            com.bytedance.pangle.service.a d = d(intent, str);
            if (d == null) {
                return component;
            }
            this.g.put(component, d);
            this.h.add(component);
        }
        com.bytedance.pangle.service.a aVar = this.g.get(component);
        if (aVar != null) {
            aVar.onStartCommand(intent, 0, 0);
        }
        return component;
    }

    private void c(android.content.ComponentName componentName) {
        com.bytedance.pangle.service.a remove = this.g.remove(componentName);
        this.i.remove(componentName);
        this.d.remove(componentName);
        this.h.remove(componentName);
        if (remove != null) {
            remove.onDestroy();
        }
    }

    private static com.bytedance.pangle.service.a d(android.content.Intent intent, java.lang.String str) {
        com.bytedance.pangle.service.a e = e(intent, str);
        if (e != null) {
            e.onCreate();
        }
        return e;
    }

    private static com.bytedance.pangle.service.a e(android.content.Intent intent, java.lang.String str) {
        boolean z;
        android.content.ComponentName component = intent.getComponent();
        com.bytedance.pangle.plugin.Plugin plugin = com.bytedance.pangle.plugin.PluginManager.getInstance().getPlugin(str);
        try {
            z = com.bytedance.pangle.Zeus.loadPlugin(str);
        } catch (java.lang.Exception e) {
            e = e;
            z = false;
        }
        try {
            com.bytedance.pangle.service.a aVar = (com.bytedance.pangle.service.a) plugin.mClassLoader.loadClass(component.getClassName()).newInstance();
            aVar.attach(plugin);
            return aVar;
        } catch (java.lang.Exception e2) {
            e = e2;
            com.bytedance.pangle.log.ZeusLogger.errReport(com.bytedance.pangle.log.ZeusLogger.TAG_SERVICE, "newServiceInstance failed! loadPlugin = ".concat(java.lang.String.valueOf(z)), e);
            return null;
        }
    }

    @Override // com.bytedance.pangle.e
    public final android.content.ComponentName a(android.content.Intent intent, java.lang.String str) {
        if (!com.bytedance.pangle.Zeus.hasInit()) {
            this.b.add(new com.bytedance.pangle.service.a.a.AnonymousClass2(intent, str));
        } else {
            if (android.os.Looper.myLooper() == android.os.Looper.getMainLooper()) {
                return c(intent, str);
            }
            this.a.post(new com.bytedance.pangle.service.a.a.AnonymousClass1(intent, str));
        }
        return intent.getComponent();
    }

    @Override // com.bytedance.pangle.e
    public final void a(com.bytedance.pangle.g gVar) {
        if (android.os.Looper.myLooper() == android.os.Looper.getMainLooper()) {
            b(gVar);
        } else {
            this.a.post(new com.bytedance.pangle.service.a.a.AnonymousClass6(gVar));
        }
    }

    public final synchronized boolean a(android.content.ComponentName componentName) {
        if (!this.g.containsKey(componentName)) {
            return false;
        }
        this.i.add(componentName);
        return b(componentName);
    }

    @Override // com.bytedance.pangle.e
    public final boolean a(android.content.Intent intent, com.bytedance.pangle.g gVar, int i, java.lang.String str) {
        if (!com.bytedance.pangle.Zeus.hasInit()) {
            this.b.add(new com.bytedance.pangle.service.a.a.AnonymousClass5(intent, gVar, i, str));
            return true;
        }
        if (android.os.Looper.myLooper() == android.os.Looper.getMainLooper()) {
            return a(intent, gVar, str);
        }
        this.a.post(new com.bytedance.pangle.service.a.a.AnonymousClass4(intent, gVar, i, str));
        return true;
    }

    @Override // com.bytedance.pangle.e.a, android.os.IInterface
    public android.os.IBinder asBinder() {
        return null;
    }

    @Override // com.bytedance.pangle.e
    public final boolean b(android.content.Intent intent, java.lang.String str) {
        if (android.os.Looper.myLooper() == android.os.Looper.getMainLooper()) {
            b().a(intent.getComponent());
            return true;
        }
        this.a.post(new com.bytedance.pangle.service.a.a.AnonymousClass3(intent));
        return true;
    }
}
