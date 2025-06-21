package com.google.android.gms.common.api.internal;

/* loaded from: classes22.dex */
public final class zzb extends android.app.Fragment implements com.google.android.gms.common.api.internal.LifecycleFragment {
    public static java.util.WeakHashMap<android.app.Activity, java.lang.ref.WeakReference<com.google.android.gms.common.api.internal.zzb>> v = new java.util.WeakHashMap<>();
    public java.util.Map<java.lang.String, com.google.android.gms.common.api.internal.LifecycleCallback> n = java.util.Collections.synchronizedMap(new androidx.collection.ArrayMap());
    public int t = 0;

    @androidx.annotation.Nullable
    public android.os.Bundle u;

    public static com.google.android.gms.common.api.internal.zzb zza(android.app.Activity activity) {
        com.google.android.gms.common.api.internal.zzb zzbVar;
        java.lang.ref.WeakReference<com.google.android.gms.common.api.internal.zzb> weakReference = v.get(activity);
        if (weakReference != null && (zzbVar = weakReference.get()) != null) {
            return zzbVar;
        }
        try {
            com.google.android.gms.common.api.internal.zzb zzbVar2 = (com.google.android.gms.common.api.internal.zzb) activity.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
            if (zzbVar2 == null || zzbVar2.isRemoving()) {
                zzbVar2 = new com.google.android.gms.common.api.internal.zzb();
                activity.getFragmentManager().beginTransaction().add(zzbVar2, "LifecycleFragmentImpl").commitAllowingStateLoss();
            }
            v.put(activity, new java.lang.ref.WeakReference<>(zzbVar2));
            return zzbVar2;
        } catch (java.lang.ClassCastException e) {
            throw new java.lang.IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", e);
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleFragment
    public final void addCallback(java.lang.String str, @androidx.annotation.NonNull com.google.android.gms.common.api.internal.LifecycleCallback lifecycleCallback) {
        if (this.n.containsKey(str)) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(str).length() + 59);
            sb.append("LifecycleCallback with tag ");
            sb.append(str);
            sb.append(" already added to this fragment.");
            throw new java.lang.IllegalArgumentException(sb.toString());
        }
        this.n.put(str, lifecycleCallback);
        if (this.t > 0) {
            new com.google.android.gms.internal.common.zzi(android.os.Looper.getMainLooper()).post(new com.google.android.gms.common.api.internal.zza(this, lifecycleCallback, str));
        }
    }

    @Override // android.app.Fragment
    public final void dump(java.lang.String str, @androidx.annotation.Nullable java.io.FileDescriptor fileDescriptor, java.io.PrintWriter printWriter, @androidx.annotation.Nullable java.lang.String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        java.util.Iterator<com.google.android.gms.common.api.internal.LifecycleCallback> it = this.n.values().iterator();
        while (it.hasNext()) {
            it.next().dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleFragment
    @androidx.annotation.Nullable
    public final <T extends com.google.android.gms.common.api.internal.LifecycleCallback> T getCallbackOrNull(java.lang.String str, java.lang.Class<T> cls) {
        return cls.cast(this.n.get(str));
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleFragment
    public final android.app.Activity getLifecycleActivity() {
        return getActivity();
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleFragment
    public final boolean isCreated() {
        return this.t > 0;
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleFragment
    public final boolean isStarted() {
        return this.t >= 2;
    }

    @Override // android.app.Fragment
    public final void onActivityResult(int i, int i2, @androidx.annotation.Nullable android.content.Intent intent) {
        super.onActivityResult(i, i2, intent);
        java.util.Iterator<com.google.android.gms.common.api.internal.LifecycleCallback> it = this.n.values().iterator();
        while (it.hasNext()) {
            it.next().onActivityResult(i, i2, intent);
        }
    }

    @Override // android.app.Fragment
    public final void onCreate(@androidx.annotation.Nullable android.os.Bundle bundle) {
        super.onCreate(bundle);
        this.t = 1;
        this.u = bundle;
        for (java.util.Map.Entry<java.lang.String, com.google.android.gms.common.api.internal.LifecycleCallback> entry : this.n.entrySet()) {
            entry.getValue().onCreate(bundle != null ? bundle.getBundle(entry.getKey()) : null);
        }
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.t = 5;
        java.util.Iterator<com.google.android.gms.common.api.internal.LifecycleCallback> it = this.n.values().iterator();
        while (it.hasNext()) {
            it.next().onDestroy();
        }
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
        this.t = 3;
        java.util.Iterator<com.google.android.gms.common.api.internal.LifecycleCallback> it = this.n.values().iterator();
        while (it.hasNext()) {
            it.next().onResume();
        }
    }

    @Override // android.app.Fragment
    public final void onSaveInstanceState(android.os.Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle == null) {
            return;
        }
        for (java.util.Map.Entry<java.lang.String, com.google.android.gms.common.api.internal.LifecycleCallback> entry : this.n.entrySet()) {
            android.os.Bundle bundle2 = new android.os.Bundle();
            entry.getValue().onSaveInstanceState(bundle2);
            bundle.putBundle(entry.getKey(), bundle2);
        }
    }

    @Override // android.app.Fragment
    public final void onStart() {
        super.onStart();
        this.t = 2;
        java.util.Iterator<com.google.android.gms.common.api.internal.LifecycleCallback> it = this.n.values().iterator();
        while (it.hasNext()) {
            it.next().onStart();
        }
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        this.t = 4;
        java.util.Iterator<com.google.android.gms.common.api.internal.LifecycleCallback> it = this.n.values().iterator();
        while (it.hasNext()) {
            it.next().onStop();
        }
    }
}
