package com.huawei.hmf.tasks.a;

/* loaded from: classes22.dex */
public final class g extends android.app.Fragment {
    public static final java.util.WeakHashMap<android.app.Activity, java.lang.ref.WeakReference<com.huawei.hmf.tasks.a.g>> t = new java.util.WeakHashMap<>();
    public final java.util.List<java.lang.ref.WeakReference<com.huawei.hmf.tasks.ExecuteResult<?>>> n = new java.util.ArrayList();

    public static com.huawei.hmf.tasks.a.g a(android.app.Activity activity) {
        com.huawei.hmf.tasks.a.g gVar;
        java.util.WeakHashMap<android.app.Activity, java.lang.ref.WeakReference<com.huawei.hmf.tasks.a.g>> weakHashMap = t;
        java.lang.ref.WeakReference<com.huawei.hmf.tasks.a.g> weakReference = weakHashMap.get(activity);
        if (weakReference != null && weakReference.get() != null) {
            return weakReference.get();
        }
        android.app.FragmentManager fragmentManager = activity.getFragmentManager();
        try {
            com.huawei.hmf.tasks.a.g gVar2 = (com.huawei.hmf.tasks.a.g) fragmentManager.findFragmentByTag("com.huawei.hmf.tasks.lifecycle_fragment_tag");
            if (gVar2 == null) {
                try {
                    gVar = b(fragmentManager);
                } catch (java.lang.ClassCastException e) {
                    e = e;
                    gVar = gVar2;
                    new java.lang.StringBuilder("found LifecycleCallbackFragment but the type do not match. ").append(e.getMessage());
                    return gVar;
                }
            } else {
                gVar = gVar2;
            }
            try {
                weakHashMap.put(activity, new java.lang.ref.WeakReference<>(gVar));
            } catch (java.lang.ClassCastException e2) {
                e = e2;
                new java.lang.StringBuilder("found LifecycleCallbackFragment but the type do not match. ").append(e.getMessage());
                return gVar;
            }
        } catch (java.lang.ClassCastException e3) {
            e = e3;
            gVar = null;
        }
        return gVar;
    }

    public static void a(android.app.Activity activity, com.huawei.hmf.tasks.ExecuteResult executeResult) {
        com.huawei.hmf.tasks.a.g a = a(activity);
        if (a != null) {
            synchronized (a.n) {
                a.n.add(new java.lang.ref.WeakReference<>(executeResult));
            }
        }
    }

    public static com.huawei.hmf.tasks.a.g b(android.app.FragmentManager fragmentManager) {
        com.huawei.hmf.tasks.a.g gVar;
        com.huawei.hmf.tasks.a.g gVar2 = null;
        try {
            gVar = new com.huawei.hmf.tasks.a.g();
        } catch (java.lang.Exception e) {
            e = e;
        }
        try {
            fragmentManager.beginTransaction().add(gVar, "com.huawei.hmf.tasks.lifecycle_fragment_tag").commitAllowingStateLoss();
            return gVar;
        } catch (java.lang.Exception e2) {
            e = e2;
            gVar2 = gVar;
            new java.lang.StringBuilder("create fragment failed.").append(e.getMessage());
            return gVar2;
        }
    }

    @Override // android.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackOnHiddenChanged(this, z);
    }

    @Override // android.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onPause() {
        super.onPause();
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackFragmentPause(this);
    }

    @Override // android.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onResume() {
        super.onResume();
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackFragmentResume(this);
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        synchronized (this.n) {
            java.util.Iterator<java.lang.ref.WeakReference<com.huawei.hmf.tasks.ExecuteResult<?>>> it = this.n.iterator();
            while (it.hasNext()) {
                com.huawei.hmf.tasks.ExecuteResult<?> executeResult = it.next().get();
                if (executeResult != null) {
                    executeResult.cancel();
                }
            }
            this.n.clear();
        }
    }

    @Override // android.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onViewCreated(android.view.View view, android.os.Bundle bundle) {
        super.onViewCreated(view, bundle);
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    @Override // android.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z);
    }
}
