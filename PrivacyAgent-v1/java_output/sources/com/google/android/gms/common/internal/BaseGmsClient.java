package com.google.android.gms.common.internal;

@com.google.android.gms.common.annotation.KeepForSdk
/* loaded from: classes22.dex */
public abstract class BaseGmsClient<T extends android.os.IInterface> {

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static final int CONNECT_STATE_CONNECTED = 4;

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static final int CONNECT_STATE_DISCONNECTED = 1;

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static final int CONNECT_STATE_DISCONNECTING = 5;

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static final java.lang.String DEFAULT_ACCOUNT = "<<default account>>";

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static final java.lang.String KEY_PENDING_INTENT = "pendingIntent";
    public int a;
    public long b;
    public long c;
    public int d;
    public long e;

    @androidx.annotation.Nullable
    public volatile java.lang.String f;

    @com.google.android.gms.common.util.VisibleForTesting
    public com.google.android.gms.common.internal.zzl g;
    public final android.content.Context h;
    public final android.os.Looper i;
    public final com.google.android.gms.common.internal.GmsClientSupervisor j;
    public final com.google.android.gms.common.GoogleApiAvailabilityLight k;
    public final android.os.Handler l;
    public final java.lang.Object m;
    public final java.lang.Object n;

    @androidx.annotation.Nullable
    @javax.annotation.concurrent.GuardedBy("mServiceBrokerLock")
    public com.google.android.gms.common.internal.IGmsServiceBroker o;

    @androidx.annotation.Nullable
    @javax.annotation.concurrent.GuardedBy("mLock")
    public T p;
    public final java.util.ArrayList<com.google.android.gms.common.internal.BaseGmsClient.zzc<?>> q;

    @androidx.annotation.Nullable
    @javax.annotation.concurrent.GuardedBy("mLock")
    public com.google.android.gms.common.internal.BaseGmsClient.zzd r;

    /* renamed from: s, reason: collision with root package name */
    @javax.annotation.concurrent.GuardedBy("mLock")
    public int f370s;

    @androidx.annotation.Nullable
    public final com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks t;

    @androidx.annotation.Nullable
    public final com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener u;
    public final int v;

    @androidx.annotation.Nullable
    public final java.lang.String w;

    @androidx.annotation.Nullable
    public com.google.android.gms.common.ConnectionResult x;
    public boolean y;

    @androidx.annotation.Nullable
    public volatile com.google.android.gms.common.internal.zzc z;

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.util.VisibleForTesting
    protected com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks zzb;

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.util.VisibleForTesting
    protected java.util.concurrent.atomic.AtomicInteger zzc;
    public static final com.google.android.gms.common.Feature[] A = new com.google.android.gms.common.Feature[0];

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static final java.lang.String[] GOOGLE_PLUS_REQUIRED_FEATURES = {"service_esmobile", "service_googleme"};

    @com.google.android.gms.common.annotation.KeepForSdk
    public interface BaseConnectionCallbacks {

        @androidx.annotation.RecentlyNonNull
        @com.google.android.gms.common.annotation.KeepForSdk
        public static final int CAUSE_DEAD_OBJECT_EXCEPTION = 3;

        @androidx.annotation.RecentlyNonNull
        @com.google.android.gms.common.annotation.KeepForSdk
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;

        @com.google.android.gms.common.annotation.KeepForSdk
        void onConnected(@androidx.annotation.Nullable android.os.Bundle bundle);

        @com.google.android.gms.common.annotation.KeepForSdk
        void onConnectionSuspended(@androidx.annotation.RecentlyNonNull int i);
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public interface BaseOnConnectionFailedListener {
        @com.google.android.gms.common.annotation.KeepForSdk
        void onConnectionFailed(@androidx.annotation.RecentlyNonNull com.google.android.gms.common.ConnectionResult connectionResult);
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public interface ConnectionProgressReportCallbacks {
        @com.google.android.gms.common.annotation.KeepForSdk
        void onReportServiceBinding(@androidx.annotation.RecentlyNonNull com.google.android.gms.common.ConnectionResult connectionResult);
    }

    public class LegacyClientCallbackAdapter implements com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks {
        @com.google.android.gms.common.annotation.KeepForSdk
        public LegacyClientCallbackAdapter() {
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks
        public void onReportServiceBinding(@androidx.annotation.RecentlyNonNull com.google.android.gms.common.ConnectionResult connectionResult) {
            if (connectionResult.isSuccess()) {
                com.google.android.gms.common.internal.BaseGmsClient baseGmsClient = com.google.android.gms.common.internal.BaseGmsClient.this;
                baseGmsClient.getRemoteService(null, baseGmsClient.getScopes());
            } else if (com.google.android.gms.common.internal.BaseGmsClient.this.u != null) {
                com.google.android.gms.common.internal.BaseGmsClient.this.u.onConnectionFailed(connectionResult);
            }
        }
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public interface SignOutCallbacks {
        @com.google.android.gms.common.annotation.KeepForSdk
        void onSignOutComplete();
    }

    public abstract class zza extends com.google.android.gms.common.internal.BaseGmsClient.zzc<java.lang.Boolean> {
        public final int d;

        @androidx.annotation.Nullable
        public final android.os.Bundle e;

        @androidx.annotation.BinderThread
        public zza(int i, @androidx.annotation.Nullable android.os.Bundle bundle) {
            super(java.lang.Boolean.TRUE);
            this.d = i;
            this.e = bundle;
        }

        public abstract void zza(com.google.android.gms.common.ConnectionResult connectionResult);

        @Override // com.google.android.gms.common.internal.BaseGmsClient.zzc
        public final /* synthetic */ void zza(java.lang.Boolean bool) {
            if (bool == null) {
                com.google.android.gms.common.internal.BaseGmsClient.this.f(1, null);
                return;
            }
            if (this.d != 0) {
                com.google.android.gms.common.internal.BaseGmsClient.this.f(1, null);
                android.os.Bundle bundle = this.e;
                zza(new com.google.android.gms.common.ConnectionResult(this.d, bundle != null ? (android.app.PendingIntent) bundle.getParcelable(com.google.android.gms.common.internal.BaseGmsClient.KEY_PENDING_INTENT) : null));
            } else {
                if (zza()) {
                    return;
                }
                com.google.android.gms.common.internal.BaseGmsClient.this.f(1, null);
                zza(new com.google.android.gms.common.ConnectionResult(8, null));
            }
        }

        public abstract boolean zza();

        @Override // com.google.android.gms.common.internal.BaseGmsClient.zzc
        public final void zzb() {
        }
    }

    public final class zzb extends com.google.android.gms.internal.common.zzi {
        public zzb(android.os.Looper looper) {
            super(looper);
        }

        public static void a(android.os.Message message) {
            com.google.android.gms.common.internal.BaseGmsClient.zzc zzcVar = (com.google.android.gms.common.internal.BaseGmsClient.zzc) message.obj;
            zzcVar.zzb();
            zzcVar.zzd();
        }

        public static boolean b(android.os.Message message) {
            int i = message.what;
            return i == 2 || i == 1 || i == 7;
        }

        @Override // android.os.Handler
        public final void handleMessage(android.os.Message message) {
            if (com.google.android.gms.common.internal.BaseGmsClient.this.zzc.get() != message.arg1) {
                if (b(message)) {
                    a(message);
                    return;
                }
                return;
            }
            int i = message.what;
            if ((i == 1 || i == 7 || ((i == 4 && !com.google.android.gms.common.internal.BaseGmsClient.this.enableLocalFallback()) || message.what == 5)) && !com.google.android.gms.common.internal.BaseGmsClient.this.isConnecting()) {
                a(message);
                return;
            }
            int i2 = message.what;
            if (i2 == 4) {
                com.google.android.gms.common.internal.BaseGmsClient.this.x = new com.google.android.gms.common.ConnectionResult(message.arg2);
                if (com.google.android.gms.common.internal.BaseGmsClient.this.o() && !com.google.android.gms.common.internal.BaseGmsClient.this.y) {
                    com.google.android.gms.common.internal.BaseGmsClient.this.f(3, null);
                    return;
                }
                com.google.android.gms.common.ConnectionResult connectionResult = com.google.android.gms.common.internal.BaseGmsClient.this.x != null ? com.google.android.gms.common.internal.BaseGmsClient.this.x : new com.google.android.gms.common.ConnectionResult(8);
                com.google.android.gms.common.internal.BaseGmsClient.this.zzb.onReportServiceBinding(connectionResult);
                com.google.android.gms.common.internal.BaseGmsClient.this.onConnectionFailed(connectionResult);
                return;
            }
            if (i2 == 5) {
                com.google.android.gms.common.ConnectionResult connectionResult2 = com.google.android.gms.common.internal.BaseGmsClient.this.x != null ? com.google.android.gms.common.internal.BaseGmsClient.this.x : new com.google.android.gms.common.ConnectionResult(8);
                com.google.android.gms.common.internal.BaseGmsClient.this.zzb.onReportServiceBinding(connectionResult2);
                com.google.android.gms.common.internal.BaseGmsClient.this.onConnectionFailed(connectionResult2);
                return;
            }
            if (i2 == 3) {
                java.lang.Object obj = message.obj;
                com.google.android.gms.common.ConnectionResult connectionResult3 = new com.google.android.gms.common.ConnectionResult(message.arg2, obj instanceof android.app.PendingIntent ? (android.app.PendingIntent) obj : null);
                com.google.android.gms.common.internal.BaseGmsClient.this.zzb.onReportServiceBinding(connectionResult3);
                com.google.android.gms.common.internal.BaseGmsClient.this.onConnectionFailed(connectionResult3);
                return;
            }
            if (i2 == 6) {
                com.google.android.gms.common.internal.BaseGmsClient.this.f(5, null);
                if (com.google.android.gms.common.internal.BaseGmsClient.this.t != null) {
                    com.google.android.gms.common.internal.BaseGmsClient.this.t.onConnectionSuspended(message.arg2);
                }
                com.google.android.gms.common.internal.BaseGmsClient.this.onConnectionSuspended(message.arg2);
                com.google.android.gms.common.internal.BaseGmsClient.this.k(5, 1, null);
                return;
            }
            if (i2 == 2 && !com.google.android.gms.common.internal.BaseGmsClient.this.isConnected()) {
                a(message);
                return;
            }
            if (b(message)) {
                ((com.google.android.gms.common.internal.BaseGmsClient.zzc) message.obj).zzc();
                return;
            }
            int i3 = message.what;
            java.lang.StringBuilder sb = new java.lang.StringBuilder(45);
            sb.append("Don't know how to handle message: ");
            sb.append(i3);
            android.util.Log.wtf("GmsClient", sb.toString(), new java.lang.Exception());
        }
    }

    public abstract class zzc<TListener> {

        @androidx.annotation.Nullable
        public TListener a;
        public boolean b = false;

        public zzc(TListener tlistener) {
            this.a = tlistener;
        }

        public abstract void zza(TListener tlistener);

        public abstract void zzb();

        public final void zzc() {
            TListener tlistener;
            synchronized (this) {
                tlistener = this.a;
                if (this.b) {
                    java.lang.String valueOf = java.lang.String.valueOf(this);
                    java.lang.StringBuilder sb = new java.lang.StringBuilder(valueOf.length() + 47);
                    sb.append("Callback proxy ");
                    sb.append(valueOf);
                    sb.append(" being reused. This is not safe.");
                }
            }
            if (tlistener != null) {
                try {
                    zza(tlistener);
                } catch (java.lang.RuntimeException e) {
                    zzb();
                    throw e;
                }
            } else {
                zzb();
            }
            synchronized (this) {
                this.b = true;
            }
            zzd();
        }

        public final void zzd() {
            zze();
            synchronized (com.google.android.gms.common.internal.BaseGmsClient.this.q) {
                com.google.android.gms.common.internal.BaseGmsClient.this.q.remove(this);
            }
        }

        public final void zze() {
            synchronized (this) {
                this.a = null;
            }
        }
    }

    @com.google.android.gms.common.util.VisibleForTesting
    public final class zzd implements android.content.ServiceConnection {
        public final int n;

        public zzd(int i) {
            this.n = i;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            if (iBinder == null) {
                com.google.android.gms.common.internal.BaseGmsClient.this.e(16);
                return;
            }
            synchronized (com.google.android.gms.common.internal.BaseGmsClient.this.n) {
                com.google.android.gms.common.internal.BaseGmsClient baseGmsClient = com.google.android.gms.common.internal.BaseGmsClient.this;
                android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                baseGmsClient.o = (queryLocalInterface == null || !(queryLocalInterface instanceof com.google.android.gms.common.internal.IGmsServiceBroker)) ? new com.google.android.gms.common.internal.IGmsServiceBroker.Stub.zza(iBinder) : (com.google.android.gms.common.internal.IGmsServiceBroker) queryLocalInterface;
            }
            com.google.android.gms.common.internal.BaseGmsClient.this.zza(0, null, this.n);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(android.content.ComponentName componentName) {
            synchronized (com.google.android.gms.common.internal.BaseGmsClient.this.n) {
                com.google.android.gms.common.internal.BaseGmsClient.this.o = null;
            }
            android.os.Handler handler = com.google.android.gms.common.internal.BaseGmsClient.this.l;
            handler.sendMessage(handler.obtainMessage(6, this.n, 1));
        }
    }

    @com.google.android.gms.common.util.VisibleForTesting
    public static final class zze extends com.google.android.gms.common.internal.IGmsCallbacks.zza {

        @androidx.annotation.Nullable
        private com.google.android.gms.common.internal.BaseGmsClient zza;
        private final int zzb;

        public zze(@androidx.annotation.NonNull com.google.android.gms.common.internal.BaseGmsClient baseGmsClient, int i) {
            this.zza = baseGmsClient;
            this.zzb = i;
        }

        @Override // com.google.android.gms.common.internal.IGmsCallbacks
        @androidx.annotation.BinderThread
        public final void onPostInitComplete(int i, @androidx.annotation.NonNull android.os.IBinder iBinder, @androidx.annotation.Nullable android.os.Bundle bundle) {
            com.google.android.gms.common.internal.Preconditions.checkNotNull(this.zza, "onPostInitComplete can be called only once per call to getRemoteService");
            this.zza.onPostInitHandler(i, iBinder, bundle, this.zzb);
            this.zza = null;
        }

        @Override // com.google.android.gms.common.internal.IGmsCallbacks
        @androidx.annotation.BinderThread
        public final void zza(int i, @androidx.annotation.Nullable android.os.Bundle bundle) {
            android.util.Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new java.lang.Exception());
        }

        @Override // com.google.android.gms.common.internal.IGmsCallbacks
        @androidx.annotation.BinderThread
        public final void zza(int i, @androidx.annotation.NonNull android.os.IBinder iBinder, @androidx.annotation.NonNull com.google.android.gms.common.internal.zzc zzcVar) {
            com.google.android.gms.common.internal.BaseGmsClient baseGmsClient = this.zza;
            com.google.android.gms.common.internal.Preconditions.checkNotNull(baseGmsClient, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
            com.google.android.gms.common.internal.Preconditions.checkNotNull(zzcVar);
            baseGmsClient.j(zzcVar);
            onPostInitComplete(i, iBinder, zzcVar.zza);
        }
    }

    public final class zzf extends com.google.android.gms.common.internal.BaseGmsClient.zza {

        @androidx.annotation.Nullable
        public final android.os.IBinder g;

        @androidx.annotation.BinderThread
        public zzf(int i, @androidx.annotation.Nullable android.os.IBinder iBinder, @androidx.annotation.Nullable android.os.Bundle bundle) {
            super(i, bundle);
            this.g = iBinder;
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.zza
        public final void zza(com.google.android.gms.common.ConnectionResult connectionResult) {
            if (com.google.android.gms.common.internal.BaseGmsClient.this.u != null) {
                com.google.android.gms.common.internal.BaseGmsClient.this.u.onConnectionFailed(connectionResult);
            }
            com.google.android.gms.common.internal.BaseGmsClient.this.onConnectionFailed(connectionResult);
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.zza
        public final boolean zza() {
            try {
                java.lang.String interfaceDescriptor = ((android.os.IBinder) com.google.android.gms.common.internal.Preconditions.checkNotNull(this.g)).getInterfaceDescriptor();
                if (!com.google.android.gms.common.internal.BaseGmsClient.this.getServiceDescriptor().equals(interfaceDescriptor)) {
                    java.lang.String serviceDescriptor = com.google.android.gms.common.internal.BaseGmsClient.this.getServiceDescriptor();
                    java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(serviceDescriptor).length() + 34 + java.lang.String.valueOf(interfaceDescriptor).length());
                    sb.append("service descriptor mismatch: ");
                    sb.append(serviceDescriptor);
                    sb.append(" vs. ");
                    sb.append(interfaceDescriptor);
                    return false;
                }
                android.os.IInterface createServiceInterface = com.google.android.gms.common.internal.BaseGmsClient.this.createServiceInterface(this.g);
                if (createServiceInterface == null) {
                    return false;
                }
                if (!com.google.android.gms.common.internal.BaseGmsClient.this.k(2, 4, createServiceInterface) && !com.google.android.gms.common.internal.BaseGmsClient.this.k(3, 4, createServiceInterface)) {
                    return false;
                }
                com.google.android.gms.common.internal.BaseGmsClient.this.x = null;
                android.os.Bundle connectionHint = com.google.android.gms.common.internal.BaseGmsClient.this.getConnectionHint();
                if (com.google.android.gms.common.internal.BaseGmsClient.this.t != null) {
                    com.google.android.gms.common.internal.BaseGmsClient.this.t.onConnected(connectionHint);
                }
                return true;
            } catch (android.os.RemoteException unused) {
                return false;
            }
        }
    }

    public final class zzg extends com.google.android.gms.common.internal.BaseGmsClient.zza {
        @androidx.annotation.BinderThread
        public zzg(int i, @androidx.annotation.Nullable android.os.Bundle bundle) {
            super(i, null);
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.zza
        public final void zza(com.google.android.gms.common.ConnectionResult connectionResult) {
            if (com.google.android.gms.common.internal.BaseGmsClient.this.enableLocalFallback() && com.google.android.gms.common.internal.BaseGmsClient.this.o()) {
                com.google.android.gms.common.internal.BaseGmsClient.this.e(16);
            } else {
                com.google.android.gms.common.internal.BaseGmsClient.this.zzb.onReportServiceBinding(connectionResult);
                com.google.android.gms.common.internal.BaseGmsClient.this.onConnectionFailed(connectionResult);
            }
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.zza
        public final boolean zza() {
            com.google.android.gms.common.internal.BaseGmsClient.this.zzb.onReportServiceBinding(com.google.android.gms.common.ConnectionResult.RESULT_SUCCESS);
            return true;
        }
    }

    @com.google.android.gms.common.util.VisibleForTesting
    @com.google.android.gms.common.annotation.KeepForSdk
    public BaseGmsClient(@androidx.annotation.RecentlyNonNull android.content.Context context, @androidx.annotation.RecentlyNonNull android.os.Handler handler, @androidx.annotation.RecentlyNonNull com.google.android.gms.common.internal.GmsClientSupervisor gmsClientSupervisor, @androidx.annotation.RecentlyNonNull com.google.android.gms.common.GoogleApiAvailabilityLight googleApiAvailabilityLight, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.Nullable com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks, @androidx.annotation.Nullable com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        this.f = null;
        this.m = new java.lang.Object();
        this.n = new java.lang.Object();
        this.q = new java.util.ArrayList<>();
        this.f370s = 1;
        this.x = null;
        this.y = false;
        this.z = null;
        this.zzc = new java.util.concurrent.atomic.AtomicInteger(0);
        this.h = (android.content.Context) com.google.android.gms.common.internal.Preconditions.checkNotNull(context, "Context must not be null");
        this.l = (android.os.Handler) com.google.android.gms.common.internal.Preconditions.checkNotNull(handler, "Handler must not be null");
        this.i = handler.getLooper();
        this.j = (com.google.android.gms.common.internal.GmsClientSupervisor) com.google.android.gms.common.internal.Preconditions.checkNotNull(gmsClientSupervisor, "Supervisor must not be null");
        this.k = (com.google.android.gms.common.GoogleApiAvailabilityLight) com.google.android.gms.common.internal.Preconditions.checkNotNull(googleApiAvailabilityLight, "API availability must not be null");
        this.v = i;
        this.t = baseConnectionCallbacks;
        this.u = baseOnConnectionFailedListener;
        this.w = null;
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public BaseGmsClient(@androidx.annotation.RecentlyNonNull android.content.Context context, @androidx.annotation.RecentlyNonNull android.os.Looper looper, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.RecentlyNonNull com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks, @androidx.annotation.RecentlyNonNull com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener baseOnConnectionFailedListener, @androidx.annotation.RecentlyNonNull java.lang.String str) {
        this(context, looper, com.google.android.gms.common.internal.GmsClientSupervisor.getInstance(context), com.google.android.gms.common.GoogleApiAvailabilityLight.getInstance(), i, (com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks) com.google.android.gms.common.internal.Preconditions.checkNotNull(baseConnectionCallbacks), (com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener) com.google.android.gms.common.internal.Preconditions.checkNotNull(baseOnConnectionFailedListener), str);
    }

    @com.google.android.gms.common.util.VisibleForTesting
    @com.google.android.gms.common.annotation.KeepForSdk
    public BaseGmsClient(@androidx.annotation.RecentlyNonNull android.content.Context context, @androidx.annotation.RecentlyNonNull android.os.Looper looper, @androidx.annotation.RecentlyNonNull com.google.android.gms.common.internal.GmsClientSupervisor gmsClientSupervisor, @androidx.annotation.RecentlyNonNull com.google.android.gms.common.GoogleApiAvailabilityLight googleApiAvailabilityLight, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.Nullable com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks, @androidx.annotation.Nullable com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener baseOnConnectionFailedListener, @androidx.annotation.Nullable java.lang.String str) {
        this.f = null;
        this.m = new java.lang.Object();
        this.n = new java.lang.Object();
        this.q = new java.util.ArrayList<>();
        this.f370s = 1;
        this.x = null;
        this.y = false;
        this.z = null;
        this.zzc = new java.util.concurrent.atomic.AtomicInteger(0);
        this.h = (android.content.Context) com.google.android.gms.common.internal.Preconditions.checkNotNull(context, "Context must not be null");
        this.i = (android.os.Looper) com.google.android.gms.common.internal.Preconditions.checkNotNull(looper, "Looper must not be null");
        this.j = (com.google.android.gms.common.internal.GmsClientSupervisor) com.google.android.gms.common.internal.Preconditions.checkNotNull(gmsClientSupervisor, "Supervisor must not be null");
        this.k = (com.google.android.gms.common.GoogleApiAvailabilityLight) com.google.android.gms.common.internal.Preconditions.checkNotNull(googleApiAvailabilityLight, "API availability must not be null");
        this.l = new com.google.android.gms.common.internal.BaseGmsClient.zzb(looper);
        this.v = i;
        this.t = baseConnectionCallbacks;
        this.u = baseOnConnectionFailedListener;
        this.w = str;
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public void checkAvailabilityAndConnect() {
        int isGooglePlayServicesAvailable = this.k.isGooglePlayServicesAvailable(this.h, getMinApkVersion());
        if (isGooglePlayServicesAvailable == 0) {
            connect(new com.google.android.gms.common.internal.BaseGmsClient.LegacyClientCallbackAdapter());
        } else {
            f(1, null);
            triggerNotAvailable(new com.google.android.gms.common.internal.BaseGmsClient.LegacyClientCallbackAdapter(), isGooglePlayServicesAvailable, null);
        }
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public final void checkConnected() {
        if (!isConnected()) {
            throw new java.lang.IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public void connect(@androidx.annotation.RecentlyNonNull com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        this.zzb = (com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks) com.google.android.gms.common.internal.Preconditions.checkNotNull(connectionProgressReportCallbacks, "Connection progress callbacks cannot be null.");
        f(2, null);
    }

    @androidx.annotation.RecentlyNullable
    @com.google.android.gms.common.annotation.KeepForSdk
    public abstract T createServiceInterface(@androidx.annotation.RecentlyNonNull android.os.IBinder iBinder);

    public final java.lang.String d() {
        java.lang.String str = this.w;
        return str == null ? this.h.getClass().getName() : str;
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public void disconnect() {
        this.zzc.incrementAndGet();
        synchronized (this.q) {
            int size = this.q.size();
            for (int i = 0; i < size; i++) {
                this.q.get(i).zze();
            }
            this.q.clear();
        }
        synchronized (this.n) {
            this.o = null;
        }
        f(1, null);
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public void disconnect(@androidx.annotation.RecentlyNonNull java.lang.String str) {
        this.f = str;
        disconnect();
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public void dump(@androidx.annotation.RecentlyNonNull java.lang.String str, @androidx.annotation.RecentlyNonNull java.io.FileDescriptor fileDescriptor, @androidx.annotation.RecentlyNonNull java.io.PrintWriter printWriter, @androidx.annotation.RecentlyNonNull java.lang.String[] strArr) {
        int i;
        T t;
        com.google.android.gms.common.internal.IGmsServiceBroker iGmsServiceBroker;
        synchronized (this.m) {
            i = this.f370s;
            t = this.p;
        }
        synchronized (this.n) {
            iGmsServiceBroker = this.o;
        }
        printWriter.append((java.lang.CharSequence) str).append("mConnectState=");
        if (i == 1) {
            printWriter.print("DISCONNECTED");
        } else if (i == 2) {
            printWriter.print("REMOTE_CONNECTING");
        } else if (i == 3) {
            printWriter.print("LOCAL_CONNECTING");
        } else if (i == 4) {
            printWriter.print("CONNECTED");
        } else if (i != 5) {
            printWriter.print(com.huawei.hms.framework.network.grs.GrsBaseInfo.CountryCodeSource.UNKNOWN);
        } else {
            printWriter.print("DISCONNECTING");
        }
        printWriter.append(" mService=");
        if (t == null) {
            printWriter.append(com.igexin.push.core.b.m);
        } else {
            printWriter.append((java.lang.CharSequence) getServiceDescriptor()).append("@").append((java.lang.CharSequence) java.lang.Integer.toHexString(java.lang.System.identityHashCode(t.asBinder())));
        }
        printWriter.append(" mServiceBroker=");
        if (iGmsServiceBroker == null) {
            printWriter.println(com.igexin.push.core.b.m);
        } else {
            printWriter.append("IGmsServiceBroker@").println(java.lang.Integer.toHexString(java.lang.System.identityHashCode(iGmsServiceBroker.asBinder())));
        }
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", java.util.Locale.US);
        if (this.c > 0) {
            java.io.PrintWriter append = printWriter.append((java.lang.CharSequence) str).append("lastConnectedTime=");
            long j = this.c;
            java.lang.String format = simpleDateFormat.format(new java.util.Date(this.c));
            java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(format).length() + 21);
            sb.append(j);
            sb.append(" ");
            sb.append(format);
            append.println(sb.toString());
        }
        if (this.b > 0) {
            printWriter.append((java.lang.CharSequence) str).append("lastSuspendedCause=");
            int i2 = this.a;
            if (i2 == 1) {
                printWriter.append("CAUSE_SERVICE_DISCONNECTED");
            } else if (i2 == 2) {
                printWriter.append("CAUSE_NETWORK_LOST");
            } else if (i2 != 3) {
                printWriter.append((java.lang.CharSequence) java.lang.String.valueOf(i2));
            } else {
                printWriter.append("CAUSE_DEAD_OBJECT_EXCEPTION");
            }
            java.io.PrintWriter append2 = printWriter.append(" lastSuspendedTime=");
            long j2 = this.b;
            java.lang.String format2 = simpleDateFormat.format(new java.util.Date(this.b));
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder(java.lang.String.valueOf(format2).length() + 21);
            sb2.append(j2);
            sb2.append(" ");
            sb2.append(format2);
            append2.println(sb2.toString());
        }
        if (this.e > 0) {
            printWriter.append((java.lang.CharSequence) str).append("lastFailedStatus=").append((java.lang.CharSequence) com.google.android.gms.common.api.CommonStatusCodes.getStatusCodeString(this.d));
            java.io.PrintWriter append3 = printWriter.append(" lastFailedTime=");
            long j3 = this.e;
            java.lang.String format3 = simpleDateFormat.format(new java.util.Date(this.e));
            java.lang.StringBuilder sb3 = new java.lang.StringBuilder(java.lang.String.valueOf(format3).length() + 21);
            sb3.append(j3);
            sb3.append(" ");
            sb3.append(format3);
            append3.println(sb3.toString());
        }
    }

    public final void e(int i) {
        int i2;
        if (m()) {
            this.y = true;
            i2 = 5;
        } else {
            i2 = 4;
        }
        android.os.Handler handler = this.l;
        handler.sendMessage(handler.obtainMessage(i2, this.zzc.get(), 16));
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public boolean enableLocalFallback() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f(int i, @androidx.annotation.Nullable T t) {
        com.google.android.gms.common.internal.zzl zzlVar;
        com.google.android.gms.common.internal.Preconditions.checkArgument((i == 4) == (t != null));
        synchronized (this.m) {
            this.f370s = i;
            this.p = t;
            if (i == 1) {
                com.google.android.gms.common.internal.BaseGmsClient.zzd zzdVar = this.r;
                if (zzdVar != null) {
                    this.j.zza((java.lang.String) com.google.android.gms.common.internal.Preconditions.checkNotNull(this.g.a()), this.g.b(), this.g.c(), zzdVar, d(), this.g.d());
                    this.r = null;
                }
            } else if (i == 2 || i == 3) {
                com.google.android.gms.common.internal.BaseGmsClient.zzd zzdVar2 = this.r;
                if (zzdVar2 != null && (zzlVar = this.g) != null) {
                    java.lang.String a = zzlVar.a();
                    java.lang.String b = this.g.b();
                    java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(a).length() + 70 + java.lang.String.valueOf(b).length());
                    sb.append("Calling connect() while still connected, missing disconnect() for ");
                    sb.append(a);
                    sb.append(" on ");
                    sb.append(b);
                    this.j.zza((java.lang.String) com.google.android.gms.common.internal.Preconditions.checkNotNull(this.g.a()), this.g.b(), this.g.c(), zzdVar2, d(), this.g.d());
                    this.zzc.incrementAndGet();
                }
                com.google.android.gms.common.internal.BaseGmsClient.zzd zzdVar3 = new com.google.android.gms.common.internal.BaseGmsClient.zzd(this.zzc.get());
                this.r = zzdVar3;
                com.google.android.gms.common.internal.zzl zzlVar2 = (this.f370s != 3 || getLocalStartServiceAction() == null) ? new com.google.android.gms.common.internal.zzl(getStartServicePackage(), getStartServiceAction(), false, com.google.android.gms.common.internal.GmsClientSupervisor.getDefaultBindFlags(), getUseDynamicLookup()) : new com.google.android.gms.common.internal.zzl(getContext().getPackageName(), getLocalStartServiceAction(), true, com.google.android.gms.common.internal.GmsClientSupervisor.getDefaultBindFlags(), false);
                this.g = zzlVar2;
                if (zzlVar2.d() && getMinApkVersion() < 17895000) {
                    java.lang.String valueOf = java.lang.String.valueOf(this.g.a());
                    throw new java.lang.IllegalStateException(valueOf.length() != 0 ? "Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(valueOf) : new java.lang.String("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: "));
                }
                if (!this.j.zza(new com.google.android.gms.common.internal.GmsClientSupervisor.zza((java.lang.String) com.google.android.gms.common.internal.Preconditions.checkNotNull(this.g.a()), this.g.b(), this.g.c(), this.g.d()), zzdVar3, d())) {
                    java.lang.String a2 = this.g.a();
                    java.lang.String b2 = this.g.b();
                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder(java.lang.String.valueOf(a2).length() + 34 + java.lang.String.valueOf(b2).length());
                    sb2.append("unable to connect to service: ");
                    sb2.append(a2);
                    sb2.append(" on ");
                    sb2.append(b2);
                    zza(16, null, this.zzc.get());
                }
            } else if (i == 4) {
                onConnectedLocked((android.os.IInterface) com.google.android.gms.common.internal.Preconditions.checkNotNull(t));
            }
        }
    }

    @androidx.annotation.RecentlyNullable
    @com.google.android.gms.common.annotation.KeepForSdk
    public android.accounts.Account getAccount() {
        return null;
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public com.google.android.gms.common.Feature[] getApiFeatures() {
        return A;
    }

    @androidx.annotation.RecentlyNullable
    @com.google.android.gms.common.annotation.KeepForSdk
    public final com.google.android.gms.common.Feature[] getAvailableFeatures() {
        com.google.android.gms.common.internal.zzc zzcVar = this.z;
        if (zzcVar == null) {
            return null;
        }
        return zzcVar.zzb;
    }

    @androidx.annotation.RecentlyNullable
    @com.google.android.gms.common.annotation.KeepForSdk
    public android.os.Bundle getConnectionHint() {
        return null;
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public final android.content.Context getContext() {
        return this.h;
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public java.lang.String getEndpointPackageName() {
        com.google.android.gms.common.internal.zzl zzlVar;
        if (!isConnected() || (zzlVar = this.g) == null) {
            throw new java.lang.RuntimeException("Failed to connect when checking package");
        }
        return zzlVar.b();
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public android.os.Bundle getGetServiceRequestExtraArgs() {
        return new android.os.Bundle();
    }

    @androidx.annotation.RecentlyNullable
    @com.google.android.gms.common.annotation.KeepForSdk
    public java.lang.String getLastDisconnectMessage() {
        return this.f;
    }

    @androidx.annotation.RecentlyNullable
    @com.google.android.gms.common.annotation.KeepForSdk
    public java.lang.String getLocalStartServiceAction() {
        return null;
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public final android.os.Looper getLooper() {
        return this.i;
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public int getMinApkVersion() {
        return com.google.android.gms.common.GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    @androidx.annotation.WorkerThread
    public void getRemoteService(@androidx.annotation.Nullable com.google.android.gms.common.internal.IAccountAccessor iAccountAccessor, @androidx.annotation.RecentlyNonNull java.util.Set<com.google.android.gms.common.api.Scope> set) {
        android.os.Bundle getServiceRequestExtraArgs = getGetServiceRequestExtraArgs();
        com.google.android.gms.common.internal.GetServiceRequest getServiceRequest = new com.google.android.gms.common.internal.GetServiceRequest(this.v);
        getServiceRequest.zza = this.h.getPackageName();
        getServiceRequest.zzd = getServiceRequestExtraArgs;
        if (set != null) {
            getServiceRequest.zzc = (com.google.android.gms.common.api.Scope[]) set.toArray(new com.google.android.gms.common.api.Scope[set.size()]);
        }
        if (requiresSignIn()) {
            android.accounts.Account account = getAccount();
            if (account == null) {
                account = new android.accounts.Account("<<default account>>", com.google.android.gms.common.internal.AccountType.GOOGLE);
            }
            getServiceRequest.zze = account;
            if (iAccountAccessor != null) {
                getServiceRequest.zzb = iAccountAccessor.asBinder();
            }
        } else if (requiresAccount()) {
            getServiceRequest.zze = getAccount();
        }
        getServiceRequest.zzf = A;
        getServiceRequest.zzg = getApiFeatures();
        if (usesClientTelemetry()) {
            getServiceRequest.zzh = true;
        }
        try {
            try {
                synchronized (this.n) {
                    com.google.android.gms.common.internal.IGmsServiceBroker iGmsServiceBroker = this.o;
                    if (iGmsServiceBroker != null) {
                        iGmsServiceBroker.getService(new com.google.android.gms.common.internal.BaseGmsClient.zze(this, this.zzc.get()), getServiceRequest);
                    }
                }
            } catch (android.os.RemoteException | java.lang.RuntimeException unused) {
                onPostInitHandler(8, null, null, this.zzc.get());
            }
        } catch (android.os.DeadObjectException unused2) {
            triggerConnectionSuspended(3);
        } catch (java.lang.SecurityException e) {
            throw e;
        }
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public java.util.Set<com.google.android.gms.common.api.Scope> getScopes() {
        return java.util.Collections.emptySet();
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public final T getService() throws android.os.DeadObjectException {
        T t;
        synchronized (this.m) {
            if (this.f370s == 5) {
                throw new android.os.DeadObjectException();
            }
            checkConnected();
            t = (T) com.google.android.gms.common.internal.Preconditions.checkNotNull(this.p, "Client is connected but service is null");
        }
        return t;
    }

    @androidx.annotation.RecentlyNullable
    @com.google.android.gms.common.annotation.KeepForSdk
    public android.os.IBinder getServiceBrokerBinder() {
        synchronized (this.n) {
            com.google.android.gms.common.internal.IGmsServiceBroker iGmsServiceBroker = this.o;
            if (iGmsServiceBroker == null) {
                return null;
            }
            return iGmsServiceBroker.asBinder();
        }
    }

    @androidx.annotation.NonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public abstract java.lang.String getServiceDescriptor();

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public android.content.Intent getSignInIntent() {
        throw new java.lang.UnsupportedOperationException("Not a sign in API");
    }

    @androidx.annotation.NonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public abstract java.lang.String getStartServiceAction();

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public java.lang.String getStartServicePackage() {
        return "com.google.android.gms";
    }

    @androidx.annotation.RecentlyNullable
    @com.google.android.gms.common.annotation.KeepForSdk
    public com.google.android.gms.common.internal.ConnectionTelemetryConfiguration getTelemetryConfiguration() {
        return null;
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public boolean getUseDynamicLookup() {
        return false;
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public boolean isConnected() {
        boolean z;
        synchronized (this.m) {
            z = this.f370s == 4;
        }
        return z;
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public boolean isConnecting() {
        boolean z;
        synchronized (this.m) {
            int i = this.f370s;
            z = i == 2 || i == 3;
        }
        return z;
    }

    public final void j(com.google.android.gms.common.internal.zzc zzcVar) {
        this.z = zzcVar;
    }

    public final boolean k(int i, int i2, @androidx.annotation.Nullable T t) {
        synchronized (this.m) {
            if (this.f370s != i) {
                return false;
            }
            f(i2, t);
            return true;
        }
    }

    public final boolean m() {
        boolean z;
        synchronized (this.m) {
            z = this.f370s == 3;
        }
        return z;
    }

    public final boolean o() {
        if (this.y || android.text.TextUtils.isEmpty(getServiceDescriptor()) || android.text.TextUtils.isEmpty(getLocalStartServiceAction())) {
            return false;
        }
        try {
            java.lang.Class.forName(getServiceDescriptor());
            return true;
        } catch (java.lang.ClassNotFoundException unused) {
            return false;
        }
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    @androidx.annotation.CallSuper
    public void onConnectedLocked(@androidx.annotation.RecentlyNonNull T t) {
        this.c = java.lang.System.currentTimeMillis();
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    @androidx.annotation.CallSuper
    public void onConnectionFailed(@androidx.annotation.RecentlyNonNull com.google.android.gms.common.ConnectionResult connectionResult) {
        this.d = connectionResult.getErrorCode();
        this.e = java.lang.System.currentTimeMillis();
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    @androidx.annotation.CallSuper
    public void onConnectionSuspended(@androidx.annotation.RecentlyNonNull int i) {
        this.a = i;
        this.b = java.lang.System.currentTimeMillis();
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public void onPostInitHandler(@androidx.annotation.RecentlyNonNull int i, @androidx.annotation.Nullable android.os.IBinder iBinder, @androidx.annotation.Nullable android.os.Bundle bundle, @androidx.annotation.RecentlyNonNull int i2) {
        android.os.Handler handler = this.l;
        handler.sendMessage(handler.obtainMessage(1, i2, -1, new com.google.android.gms.common.internal.BaseGmsClient.zzf(i, iBinder, bundle)));
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public void onUserSignOut(@androidx.annotation.RecentlyNonNull com.google.android.gms.common.internal.BaseGmsClient.SignOutCallbacks signOutCallbacks) {
        signOutCallbacks.onSignOutComplete();
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public boolean providesSignIn() {
        return false;
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public boolean requiresAccount() {
        return false;
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public boolean requiresGooglePlayServices() {
        return true;
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public boolean requiresSignIn() {
        return false;
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public void triggerConnectionSuspended(@androidx.annotation.RecentlyNonNull int i) {
        android.os.Handler handler = this.l;
        handler.sendMessage(handler.obtainMessage(6, this.zzc.get(), i));
    }

    @com.google.android.gms.common.util.VisibleForTesting
    @com.google.android.gms.common.annotation.KeepForSdk
    public void triggerNotAvailable(@androidx.annotation.RecentlyNonNull com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks, @androidx.annotation.RecentlyNonNull int i, @androidx.annotation.Nullable android.app.PendingIntent pendingIntent) {
        this.zzb = (com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks) com.google.android.gms.common.internal.Preconditions.checkNotNull(connectionProgressReportCallbacks, "Connection progress callbacks cannot be null.");
        android.os.Handler handler = this.l;
        handler.sendMessage(handler.obtainMessage(3, this.zzc.get(), i, pendingIntent));
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public boolean usesClientTelemetry() {
        return false;
    }

    public final void zza(@androidx.annotation.RecentlyNonNull int i, @androidx.annotation.Nullable android.os.Bundle bundle, @androidx.annotation.RecentlyNonNull int i2) {
        android.os.Handler handler = this.l;
        handler.sendMessage(handler.obtainMessage(7, i2, -1, new com.google.android.gms.common.internal.BaseGmsClient.zzg(i, null)));
    }
}
