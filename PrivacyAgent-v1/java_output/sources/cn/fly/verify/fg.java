package cn.fly.verify;

/* loaded from: classes.dex */
public class fg {
    private static cn.fly.verify.fg a;
    private java.util.HashSet<cn.fly.verify.fg.b> b = new java.util.HashSet<>();

    /* renamed from: cn.fly.verify.fg$1, reason: invalid class name */
    public class AnonymousClass1 implements android.app.Application.ActivityLifecycleCallbacks {
        public AnonymousClass1() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(android.app.Activity activity, android.os.Bundle bundle) {
            cn.fly.verify.fg.this.a(activity, bundle);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(android.app.Activity activity) {
            cn.fly.verify.fg.this.e(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(android.app.Activity activity) {
            cn.fly.verify.fg.this.c(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(android.app.Activity activity) {
            cn.fly.verify.fg.this.b(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(android.app.Activity activity, android.os.Bundle bundle) {
            cn.fly.verify.fg.this.b(activity, bundle);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(android.app.Activity activity) {
            cn.fly.verify.fg.this.a(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(android.app.Activity activity) {
            cn.fly.verify.fg.this.d(activity);
        }
    }

    /* renamed from: cn.fly.verify.fg$2, reason: invalid class name */
    public class AnonymousClass2 implements cn.fly.verify.fg.a {
        final /* synthetic */ android.app.Activity a;
        final /* synthetic */ android.os.Bundle b;

        public AnonymousClass2(android.app.Activity activity, android.os.Bundle bundle) {
            this.a = activity;
            this.b = bundle;
        }

        @Override // cn.fly.verify.fg.a
        public void a(cn.fly.verify.fg.b bVar) {
            bVar.a(this.a, this.b);
        }
    }

    /* renamed from: cn.fly.verify.fg$3, reason: invalid class name */
    public class AnonymousClass3 implements cn.fly.verify.fg.a {
        final /* synthetic */ android.app.Activity a;

        public AnonymousClass3(android.app.Activity activity) {
            this.a = activity;
        }

        @Override // cn.fly.verify.fg.a
        public void a(cn.fly.verify.fg.b bVar) {
            bVar.a(this.a);
        }
    }

    /* renamed from: cn.fly.verify.fg$4, reason: invalid class name */
    public class AnonymousClass4 implements cn.fly.verify.fg.a {
        final /* synthetic */ android.app.Activity a;

        public AnonymousClass4(android.app.Activity activity) {
            this.a = activity;
        }

        @Override // cn.fly.verify.fg.a
        public void a(cn.fly.verify.fg.b bVar) {
            bVar.b(this.a);
        }
    }

    /* renamed from: cn.fly.verify.fg$5, reason: invalid class name */
    public class AnonymousClass5 implements cn.fly.verify.fg.a {
        final /* synthetic */ android.app.Activity a;

        public AnonymousClass5(android.app.Activity activity) {
            this.a = activity;
        }

        @Override // cn.fly.verify.fg.a
        public void a(cn.fly.verify.fg.b bVar) {
            bVar.c(this.a);
        }
    }

    /* renamed from: cn.fly.verify.fg$6, reason: invalid class name */
    public class AnonymousClass6 implements cn.fly.verify.fg.a {
        final /* synthetic */ android.app.Activity a;

        public AnonymousClass6(android.app.Activity activity) {
            this.a = activity;
        }

        @Override // cn.fly.verify.fg.a
        public void a(cn.fly.verify.fg.b bVar) {
            bVar.d(this.a);
        }
    }

    /* renamed from: cn.fly.verify.fg$7, reason: invalid class name */
    public class AnonymousClass7 implements cn.fly.verify.fg.a {
        final /* synthetic */ android.app.Activity a;

        public AnonymousClass7(android.app.Activity activity) {
            this.a = activity;
        }

        @Override // cn.fly.verify.fg.a
        public void a(cn.fly.verify.fg.b bVar) {
            bVar.e(this.a);
        }
    }

    /* renamed from: cn.fly.verify.fg$8, reason: invalid class name */
    public class AnonymousClass8 implements cn.fly.verify.fg.a {
        final /* synthetic */ android.app.Activity a;
        final /* synthetic */ android.os.Bundle b;

        public AnonymousClass8(android.app.Activity activity, android.os.Bundle bundle) {
            this.a = activity;
            this.b = bundle;
        }

        @Override // cn.fly.verify.fg.a
        public void a(cn.fly.verify.fg.b bVar) {
            bVar.b(this.a, this.b);
        }
    }

    public interface a {
        void a(cn.fly.verify.fg.b bVar);
    }

    public interface b {
        void a(android.app.Activity activity);

        void a(android.app.Activity activity, android.os.Bundle bundle);

        void b(android.app.Activity activity);

        void b(android.app.Activity activity, android.os.Bundle bundle);

        void c(android.app.Activity activity);

        void d(android.app.Activity activity);

        void e(android.app.Activity activity);
    }

    private fg(android.content.Context context) {
        b(context);
    }

    public static synchronized cn.fly.verify.fg a(android.content.Context context) {
        cn.fly.verify.fg fgVar;
        synchronized (cn.fly.verify.fg.class) {
            if (a == null) {
                a = new cn.fly.verify.fg(context);
            }
            fgVar = a;
        }
        return fgVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(android.app.Activity activity) {
        a(new cn.fly.verify.fg.AnonymousClass3(activity));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(android.app.Activity activity, android.os.Bundle bundle) {
        a(new cn.fly.verify.fg.AnonymousClass2(activity, bundle));
    }

    private void a(cn.fly.verify.fg.a aVar) {
        cn.fly.verify.fg.b[] bVarArr;
        try {
            synchronized (this.b) {
                java.util.HashSet<cn.fly.verify.fg.b> hashSet = this.b;
                bVarArr = (cn.fly.verify.fg.b[]) hashSet.toArray(new cn.fly.verify.fg.b[hashSet.size()]);
            }
            for (cn.fly.verify.fg.b bVar : bVarArr) {
                if (bVar != null) {
                    aVar.a(bVar);
                }
            }
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().b(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(android.app.Activity activity) {
        a(new cn.fly.verify.fg.AnonymousClass4(activity));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(android.app.Activity activity, android.os.Bundle bundle) {
        a(new cn.fly.verify.fg.AnonymousClass8(activity, bundle));
    }

    private void b(android.content.Context context) {
        try {
            ((android.app.Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new cn.fly.verify.fg.AnonymousClass1());
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().b(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(android.app.Activity activity) {
        a(new cn.fly.verify.fg.AnonymousClass5(activity));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(android.app.Activity activity) {
        a(new cn.fly.verify.fg.AnonymousClass6(activity));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(android.app.Activity activity) {
        a(new cn.fly.verify.fg.AnonymousClass7(activity));
    }

    public void a(cn.fly.verify.fg.b bVar) {
        synchronized (this.b) {
            this.b.add(bVar);
        }
    }
}
