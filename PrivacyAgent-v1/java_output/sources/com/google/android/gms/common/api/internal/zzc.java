package com.google.android.gms.common.api.internal;

/* loaded from: classes22.dex */
public final class zzc extends androidx.fragment.app.Fragment implements com.google.android.gms.common.api.internal.LifecycleFragment {
    public static java.util.WeakHashMap<androidx.fragment.app.FragmentActivity, java.lang.ref.WeakReference<com.google.android.gms.common.api.internal.zzc>> w = new java.util.WeakHashMap<>();
    public java.util.Map<java.lang.String, com.google.android.gms.common.api.internal.LifecycleCallback> t = java.util.Collections.synchronizedMap(new androidx.collection.ArrayMap());
    public int u = 0;

    @androidx.annotation.Nullable
    public android.os.Bundle v;

    public static com.google.android.gms.common.api.internal.zzc zza(androidx.fragment.app.FragmentActivity fragmentActivity) {
        com.google.android.gms.common.api.internal.zzc zzcVar;
        java.lang.ref.WeakReference<com.google.android.gms.common.api.internal.zzc> weakReference = w.get(fragmentActivity);
        if (weakReference != null && (zzcVar = weakReference.get()) != null) {
            return zzcVar;
        }
        try {
            com.google.android.gms.common.api.internal.zzc zzcVar2 = (com.google.android.gms.common.api.internal.zzc) fragmentActivity.getSupportFragmentManager().findFragmentByTag("SupportLifecycleFragmentImpl");
            if (zzcVar2 == null || zzcVar2.isRemoving()) {
                zzcVar2 = new com.google.android.gms.common.api.internal.zzc();
                fragmentActivity.getSupportFragmentManager().beginTransaction().add(zzcVar2, "SupportLifecycleFragmentImpl").commitAllowingStateLoss();
            }
            w.put(fragmentActivity, new java.lang.ref.WeakReference<>(zzcVar2));
            return zzcVar2;
        } catch (java.lang.ClassCastException e) {
            throw new java.lang.IllegalStateException("Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", e);
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleFragment
    public final void addCallback(java.lang.String str, @androidx.annotation.NonNull com.google.android.gms.common.api.internal.LifecycleCallback lifecycleCallback) {
        if (this.t.containsKey(str)) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(str).length() + 59);
            sb.append("LifecycleCallback with tag ");
            sb.append(str);
            sb.append(" already added to this fragment.");
            throw new java.lang.IllegalArgumentException(sb.toString());
        }
        this.t.put(str, lifecycleCallback);
        if (this.u > 0) {
            new com.google.android.gms.internal.common.zzi(android.os.Looper.getMainLooper()).post(new com.google.android.gms.common.api.internal.zzd(this, lifecycleCallback, str));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void dump(java.lang.String str, @androidx.annotation.Nullable java.io.FileDescriptor fileDescriptor, java.io.PrintWriter printWriter, @androidx.annotation.Nullable java.lang.String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        java.util.Iterator<com.google.android.gms.common.api.internal.LifecycleCallback> it = this.t.values().iterator();
        while (it.hasNext()) {
            it.next().dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleFragment
    @androidx.annotation.Nullable
    public final <T extends com.google.android.gms.common.api.internal.LifecycleCallback> T getCallbackOrNull(java.lang.String str, java.lang.Class<T> cls) {
        return cls.cast(this.t.get(str));
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleFragment
    public final /* synthetic */ android.app.Activity getLifecycleActivity() {
        return getActivity();
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleFragment
    public final boolean isCreated() {
        return this.u > 0;
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleFragment
    public final boolean isStarted() {
        return this.u >= 2;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int i, int i2, @androidx.annotation.Nullable android.content.Intent intent) {
        super.onActivityResult(i, i2, intent);
        java.util.Iterator<com.google.android.gms.common.api.internal.LifecycleCallback> it = this.t.values().iterator();
        while (it.hasNext()) {
            it.next().onActivityResult(i, i2, intent);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(@androidx.annotation.Nullable android.os.Bundle bundle) {
        super.onCreate(bundle);
        this.u = 1;
        this.v = bundle;
        for (java.util.Map.Entry<java.lang.String, com.google.android.gms.common.api.internal.LifecycleCallback> entry : this.t.entrySet()) {
            entry.getValue().onCreate(bundle != null ? bundle.getBundle(entry.getKey()) : null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.u = 5;
        java.util.Iterator<com.google.android.gms.common.api.internal.LifecycleCallback> it = this.t.values().iterator();
        while (it.hasNext()) {
            it.next().onDestroy();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        this.u = 3;
        java.util.Iterator<com.google.android.gms.common.api.internal.LifecycleCallback> it = this.t.values().iterator();
        while (it.hasNext()) {
            it.next().onResume();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onSaveInstanceState(android.os.Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle == null) {
            return;
        }
        for (java.util.Map.Entry<java.lang.String, com.google.android.gms.common.api.internal.LifecycleCallback> entry : this.t.entrySet()) {
            android.os.Bundle bundle2 = new android.os.Bundle();
            entry.getValue().onSaveInstanceState(bundle2);
            bundle.putBundle(entry.getKey(), bundle2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        this.u = 2;
        java.util.Iterator<com.google.android.gms.common.api.internal.LifecycleCallback> it = this.t.values().iterator();
        while (it.hasNext()) {
            it.next().onStart();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        this.u = 4;
        java.util.Iterator<com.google.android.gms.common.api.internal.LifecycleCallback> it = this.t.values().iterator();
        while (it.hasNext()) {
            it.next().onStop();
        }
    }
}
