package com.google.android.gms.common.internal;

@com.google.android.gms.common.annotation.KeepForSdk
/* loaded from: classes22.dex */
public abstract class GmsClientSupervisor {
    public static int a = 4225;
    public static final java.lang.Object b = new java.lang.Object();
    public static com.google.android.gms.common.internal.GmsClientSupervisor c;

    public static final class zza {
        public static final android.net.Uri f = new android.net.Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();

        @androidx.annotation.Nullable
        public final java.lang.String a;

        @androidx.annotation.Nullable
        public final java.lang.String b;

        @androidx.annotation.Nullable
        public final android.content.ComponentName c;
        public final int d;
        public final boolean e;

        public zza(android.content.ComponentName componentName, int i) {
            this.a = null;
            this.b = null;
            this.c = (android.content.ComponentName) com.google.android.gms.common.internal.Preconditions.checkNotNull(componentName);
            this.d = i;
            this.e = false;
        }

        public zza(java.lang.String str, int i) {
            this(str, "com.google.android.gms", i);
        }

        public zza(java.lang.String str, java.lang.String str2, int i) {
            this(str, str2, i, false);
        }

        public zza(java.lang.String str, java.lang.String str2, int i, boolean z) {
            this.a = com.google.android.gms.common.internal.Preconditions.checkNotEmpty(str);
            this.b = com.google.android.gms.common.internal.Preconditions.checkNotEmpty(str2);
            this.c = null;
            this.d = i;
            this.e = z;
        }

        @androidx.annotation.Nullable
        public final android.content.Intent a(android.content.Context context) {
            android.os.Bundle bundle;
            android.os.Bundle bundle2 = new android.os.Bundle();
            bundle2.putString("serviceActionBundleKey", this.a);
            try {
                bundle = context.getContentResolver().call(f, "serviceIntentCall", (java.lang.String) null, bundle2);
            } catch (java.lang.IllegalArgumentException e) {
                java.lang.String valueOf = java.lang.String.valueOf(e);
                java.lang.StringBuilder sb = new java.lang.StringBuilder(valueOf.length() + 34);
                sb.append("Dynamic intent resolution failed: ");
                sb.append(valueOf);
                bundle = null;
            }
            android.content.Intent intent = bundle != null ? (android.content.Intent) bundle.getParcelable("serviceResponseIntentKey") : null;
            if (intent == null) {
                java.lang.String valueOf2 = java.lang.String.valueOf(this.a);
                if (valueOf2.length() != 0) {
                    "Dynamic lookup for intent failed for action: ".concat(valueOf2);
                }
            }
            return intent;
        }

        public final boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof com.google.android.gms.common.internal.GmsClientSupervisor.zza)) {
                return false;
            }
            com.google.android.gms.common.internal.GmsClientSupervisor.zza zzaVar = (com.google.android.gms.common.internal.GmsClientSupervisor.zza) obj;
            return com.google.android.gms.common.internal.Objects.equal(this.a, zzaVar.a) && com.google.android.gms.common.internal.Objects.equal(this.b, zzaVar.b) && com.google.android.gms.common.internal.Objects.equal(this.c, zzaVar.c) && this.d == zzaVar.d && this.e == zzaVar.e;
        }

        public final int hashCode() {
            return com.google.android.gms.common.internal.Objects.hashCode(this.a, this.b, this.c, java.lang.Integer.valueOf(this.d), java.lang.Boolean.valueOf(this.e));
        }

        public final java.lang.String toString() {
            java.lang.String str = this.a;
            if (str != null) {
                return str;
            }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(this.c);
            return this.c.flattenToString();
        }

        public final android.content.Intent zza(android.content.Context context) {
            if (this.a == null) {
                return new android.content.Intent().setComponent(this.c);
            }
            android.content.Intent a = this.e ? a(context) : null;
            return a == null ? new android.content.Intent(this.a).setPackage(this.b) : a;
        }

        @androidx.annotation.Nullable
        public final java.lang.String zza() {
            return this.b;
        }

        @androidx.annotation.Nullable
        public final android.content.ComponentName zzb() {
            return this.c;
        }

        public final int zzc() {
            return this.d;
        }
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static int getDefaultBindFlags() {
        return a;
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static com.google.android.gms.common.internal.GmsClientSupervisor getInstance(@androidx.annotation.RecentlyNonNull android.content.Context context) {
        synchronized (b) {
            if (c == null) {
                c = new com.google.android.gms.common.internal.zzg(context.getApplicationContext());
            }
        }
        return c;
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public boolean bindService(@androidx.annotation.RecentlyNonNull android.content.ComponentName componentName, @androidx.annotation.RecentlyNonNull android.content.ServiceConnection serviceConnection, @androidx.annotation.RecentlyNonNull java.lang.String str) {
        return zza(new com.google.android.gms.common.internal.GmsClientSupervisor.zza(componentName, getDefaultBindFlags()), serviceConnection, str);
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public boolean bindService(@androidx.annotation.RecentlyNonNull java.lang.String str, @androidx.annotation.RecentlyNonNull android.content.ServiceConnection serviceConnection, @androidx.annotation.RecentlyNonNull java.lang.String str2) {
        return zza(new com.google.android.gms.common.internal.GmsClientSupervisor.zza(str, getDefaultBindFlags()), serviceConnection, str2);
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public void unbindService(@androidx.annotation.RecentlyNonNull android.content.ComponentName componentName, @androidx.annotation.RecentlyNonNull android.content.ServiceConnection serviceConnection, @androidx.annotation.RecentlyNonNull java.lang.String str) {
        zzb(new com.google.android.gms.common.internal.GmsClientSupervisor.zza(componentName, getDefaultBindFlags()), serviceConnection, str);
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public void unbindService(@androidx.annotation.RecentlyNonNull java.lang.String str, @androidx.annotation.RecentlyNonNull android.content.ServiceConnection serviceConnection, @androidx.annotation.RecentlyNonNull java.lang.String str2) {
        zzb(new com.google.android.gms.common.internal.GmsClientSupervisor.zza(str, getDefaultBindFlags()), serviceConnection, str2);
    }

    public final void zza(@androidx.annotation.RecentlyNonNull java.lang.String str, @androidx.annotation.RecentlyNonNull java.lang.String str2, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull android.content.ServiceConnection serviceConnection, @androidx.annotation.RecentlyNonNull java.lang.String str3, @androidx.annotation.RecentlyNonNull boolean z) {
        zzb(new com.google.android.gms.common.internal.GmsClientSupervisor.zza(str, str2, i, z), serviceConnection, str3);
    }

    public abstract boolean zza(com.google.android.gms.common.internal.GmsClientSupervisor.zza zzaVar, android.content.ServiceConnection serviceConnection, java.lang.String str);

    public abstract void zzb(com.google.android.gms.common.internal.GmsClientSupervisor.zza zzaVar, android.content.ServiceConnection serviceConnection, java.lang.String str);
}
