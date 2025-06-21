package com.huawei.hms.common.internal;

/* loaded from: classes22.dex */
public class AutoLifecycleFragment extends android.app.Fragment {
    private final android.util.SparseArray<com.huawei.hms.common.internal.AutoLifecycleFragment.a> a = new android.util.SparseArray<>();
    private boolean b;

    public static class a {
        public final com.huawei.hms.api.HuaweiApiClient a;

        public a(int i, com.huawei.hms.api.HuaweiApiClient huaweiApiClient) {
            this.a = huaweiApiClient;
        }

        public void a() {
            this.a.disconnect();
        }
    }

    public static com.huawei.hms.common.internal.AutoLifecycleFragment getInstance(android.app.Activity activity) {
        com.huawei.hms.common.internal.Preconditions.checkMainThread("Must be called on the main thread");
        try {
            com.huawei.hms.common.internal.AutoLifecycleFragment autoLifecycleFragment = (com.huawei.hms.common.internal.AutoLifecycleFragment) activity.getFragmentManager().findFragmentByTag("HmsAutoLifecycleFrag");
            android.app.FragmentManager fragmentManager = activity.getFragmentManager();
            if (autoLifecycleFragment != null) {
                return autoLifecycleFragment;
            }
            com.huawei.hms.common.internal.AutoLifecycleFragment autoLifecycleFragment2 = new com.huawei.hms.common.internal.AutoLifecycleFragment();
            fragmentManager.beginTransaction().add(autoLifecycleFragment2, "HmsAutoLifecycleFrag").commitAllowingStateLoss();
            fragmentManager.executePendingTransactions();
            return autoLifecycleFragment2;
        } catch (java.lang.ClassCastException e) {
            throw new java.lang.IllegalStateException("Fragment with tag HmsAutoLifecycleFrag is not a AutoLifecycleFragment", e);
        }
    }

    @Override // android.app.Fragment
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.b = true;
        for (int i = 0; i < this.a.size(); i++) {
            this.a.valueAt(i).a.connect((android.app.Activity) null);
        }
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.b = false;
        for (int i = 0; i < this.a.size(); i++) {
            this.a.valueAt(i).a.disconnect();
        }
    }

    public void startAutoMange(int i, com.huawei.hms.api.HuaweiApiClient huaweiApiClient) {
        com.huawei.hms.common.internal.Preconditions.checkNotNull(huaweiApiClient, "HuaweiApiClient instance cannot be null");
        com.huawei.hms.common.internal.Preconditions.checkState(this.a.indexOfKey(i) < 0, "Already managing a HuaweiApiClient with this clientId: " + i);
        this.a.put(i, new com.huawei.hms.common.internal.AutoLifecycleFragment.a(i, huaweiApiClient));
        if (this.b) {
            huaweiApiClient.connect((android.app.Activity) null);
        }
    }

    public void stopAutoManage(int i) {
        com.huawei.hms.common.internal.AutoLifecycleFragment.a aVar = this.a.get(i);
        this.a.remove(i);
        if (aVar != null) {
            aVar.a();
        }
    }
}
