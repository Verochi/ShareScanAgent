package com.uc.crashsdk;

/* loaded from: classes19.dex */
final class c implements android.app.Application.ActivityLifecycleCallbacks {
    private boolean a = false;
    private boolean b = false;

    private void a(int i) {
        java.util.WeakHashMap weakHashMap;
        java.util.WeakHashMap weakHashMap2;
        if (com.uc.crashsdk.e.u()) {
            com.uc.crashsdk.a.a.a("crashsdk", "[LifeCycle] ignore state change while crashing");
            return;
        }
        boolean z = true;
        boolean z2 = 1 == i;
        if (!z2) {
            weakHashMap2 = com.uc.crashsdk.b.ab;
            java.util.Iterator it = weakHashMap2.entrySet().iterator();
            while (it.hasNext()) {
                java.lang.Object value = ((java.util.Map.Entry) it.next()).getValue();
                if (value != null && ((java.lang.Integer) value).intValue() == 1) {
                    break;
                }
            }
        }
        z = z2;
        if (this.a != z) {
            com.uc.crashsdk.b.b(z);
            this.a = z;
        }
        weakHashMap = com.uc.crashsdk.b.ab;
        boolean isEmpty = weakHashMap.isEmpty();
        if (this.b != isEmpty) {
            if (isEmpty) {
                com.uc.crashsdk.b.w();
            }
            this.b = isEmpty;
        }
    }

    private void a(android.app.Activity activity, int i) {
        java.util.WeakHashMap weakHashMap;
        java.util.WeakHashMap weakHashMap2;
        if (1 == i) {
            java.lang.String unused = com.uc.crashsdk.b.ad = activity.getComponentName().flattenToShortString();
        } else {
            java.lang.String unused2 = com.uc.crashsdk.b.ad = "";
        }
        com.uc.crashsdk.b.D();
        if (com.uc.crashsdk.g.M()) {
            com.uc.crashsdk.b.O();
            weakHashMap = com.uc.crashsdk.b.ab;
            synchronized (weakHashMap) {
                weakHashMap2 = com.uc.crashsdk.b.ab;
                weakHashMap2.put(activity, java.lang.Integer.valueOf(i));
                a(i);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(android.app.Activity activity, android.os.Bundle bundle) {
        a(activity, 2);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(android.app.Activity activity) {
        java.util.WeakHashMap weakHashMap;
        java.util.WeakHashMap weakHashMap2;
        if (com.uc.crashsdk.g.M()) {
            com.uc.crashsdk.b.O();
            weakHashMap = com.uc.crashsdk.b.ab;
            synchronized (weakHashMap) {
                weakHashMap2 = com.uc.crashsdk.b.ab;
                weakHashMap2.remove(activity);
                a(2);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(android.app.Activity activity) {
        a(activity, 2);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(android.app.Activity activity) {
        a(activity, 1);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(android.app.Activity activity, android.os.Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(android.app.Activity activity) {
        a(activity, 1);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(android.app.Activity activity) {
        a(activity, 2);
    }
}
