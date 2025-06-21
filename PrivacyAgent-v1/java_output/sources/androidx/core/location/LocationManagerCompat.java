package androidx.core.location;

/* loaded from: classes.dex */
public final class LocationManagerCompat {
    private static final long PRE_N_LOOPER_TIMEOUT_S = 4;
    private static java.lang.reflect.Field sContextField;

    @androidx.annotation.GuardedBy("sGnssStatusListeners")
    private static final androidx.collection.SimpleArrayMap<java.lang.Object, java.lang.Object> sGnssStatusListeners = new androidx.collection.SimpleArrayMap<>();

    /* renamed from: androidx.core.location.LocationManagerCompat$1, reason: invalid class name */
    public class AnonymousClass1 implements java.util.concurrent.Callable<java.lang.Boolean> {
        final /* synthetic */ android.location.LocationManager val$locationManager;
        final /* synthetic */ androidx.core.location.LocationManagerCompat.GpsStatusTransport val$myTransport;

        public AnonymousClass1(android.location.LocationManager locationManager, androidx.core.location.LocationManagerCompat.GpsStatusTransport gpsStatusTransport) {
            this.val$locationManager = locationManager;
            this.val$myTransport = gpsStatusTransport;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        @androidx.annotation.RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
        public java.lang.Boolean call() {
            return java.lang.Boolean.valueOf(this.val$locationManager.addGpsStatusListener(this.val$myTransport));
        }
    }

    @androidx.annotation.RequiresApi(28)
    public static class Api28Impl {
        private Api28Impl() {
        }

        public static boolean isLocationEnabled(android.location.LocationManager locationManager) {
            boolean isLocationEnabled;
            isLocationEnabled = locationManager.isLocationEnabled();
            return isLocationEnabled;
        }
    }

    @androidx.annotation.RequiresApi(30)
    public static class GnssStatusTransport extends android.location.GnssStatus.Callback {
        final androidx.core.location.GnssStatusCompat.Callback mCallback;

        public GnssStatusTransport(androidx.core.location.GnssStatusCompat.Callback callback) {
            androidx.core.util.Preconditions.checkArgument(callback != null, "invalid null callback");
            this.mCallback = callback;
        }

        @Override // android.location.GnssStatus.Callback
        public void onFirstFix(int i) {
            this.mCallback.onFirstFix(i);
        }

        @Override // android.location.GnssStatus.Callback
        public void onSatelliteStatusChanged(android.location.GnssStatus gnssStatus) {
            this.mCallback.onSatelliteStatusChanged(androidx.core.location.GnssStatusCompat.wrap(gnssStatus));
        }

        @Override // android.location.GnssStatus.Callback
        public void onStarted() {
            this.mCallback.onStarted();
        }

        @Override // android.location.GnssStatus.Callback
        public void onStopped() {
            this.mCallback.onStopped();
        }
    }

    public static class GpsStatusTransport implements android.location.GpsStatus.Listener {
        final androidx.core.location.GnssStatusCompat.Callback mCallback;

        @androidx.annotation.Nullable
        volatile java.util.concurrent.Executor mExecutor;
        private final android.location.LocationManager mLocationManager;

        /* renamed from: androidx.core.location.LocationManagerCompat$GpsStatusTransport$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            final /* synthetic */ java.util.concurrent.Executor val$executor;

            public AnonymousClass1(java.util.concurrent.Executor executor) {
                this.val$executor = executor;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (androidx.core.location.LocationManagerCompat.GpsStatusTransport.this.mExecutor != this.val$executor) {
                    return;
                }
                androidx.core.location.LocationManagerCompat.GpsStatusTransport.this.mCallback.onStarted();
            }
        }

        /* renamed from: androidx.core.location.LocationManagerCompat$GpsStatusTransport$2, reason: invalid class name */
        public class AnonymousClass2 implements java.lang.Runnable {
            final /* synthetic */ java.util.concurrent.Executor val$executor;

            public AnonymousClass2(java.util.concurrent.Executor executor) {
                this.val$executor = executor;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (androidx.core.location.LocationManagerCompat.GpsStatusTransport.this.mExecutor != this.val$executor) {
                    return;
                }
                androidx.core.location.LocationManagerCompat.GpsStatusTransport.this.mCallback.onStopped();
            }
        }

        /* renamed from: androidx.core.location.LocationManagerCompat$GpsStatusTransport$3, reason: invalid class name */
        public class AnonymousClass3 implements java.lang.Runnable {
            final /* synthetic */ java.util.concurrent.Executor val$executor;
            final /* synthetic */ int val$ttff;

            public AnonymousClass3(java.util.concurrent.Executor executor, int i) {
                this.val$executor = executor;
                this.val$ttff = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (androidx.core.location.LocationManagerCompat.GpsStatusTransport.this.mExecutor != this.val$executor) {
                    return;
                }
                androidx.core.location.LocationManagerCompat.GpsStatusTransport.this.mCallback.onFirstFix(this.val$ttff);
            }
        }

        /* renamed from: androidx.core.location.LocationManagerCompat$GpsStatusTransport$4, reason: invalid class name */
        public class AnonymousClass4 implements java.lang.Runnable {
            final /* synthetic */ java.util.concurrent.Executor val$executor;
            final /* synthetic */ androidx.core.location.GnssStatusCompat val$gnssStatus;

            public AnonymousClass4(java.util.concurrent.Executor executor, androidx.core.location.GnssStatusCompat gnssStatusCompat) {
                this.val$executor = executor;
                this.val$gnssStatus = gnssStatusCompat;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (androidx.core.location.LocationManagerCompat.GpsStatusTransport.this.mExecutor != this.val$executor) {
                    return;
                }
                androidx.core.location.LocationManagerCompat.GpsStatusTransport.this.mCallback.onSatelliteStatusChanged(this.val$gnssStatus);
            }
        }

        public GpsStatusTransport(android.location.LocationManager locationManager, androidx.core.location.GnssStatusCompat.Callback callback) {
            androidx.core.util.Preconditions.checkArgument(callback != null, "invalid null callback");
            this.mLocationManager = locationManager;
            this.mCallback = callback;
        }

        @Override // android.location.GpsStatus.Listener
        @androidx.annotation.RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
        public void onGpsStatusChanged(int i) {
            android.location.GpsStatus gpsStatus;
            java.util.concurrent.Executor executor = this.mExecutor;
            if (executor == null) {
                return;
            }
            if (i == 1) {
                executor.execute(new androidx.core.location.LocationManagerCompat.GpsStatusTransport.AnonymousClass1(executor));
                return;
            }
            if (i == 2) {
                executor.execute(new androidx.core.location.LocationManagerCompat.GpsStatusTransport.AnonymousClass2(executor));
                return;
            }
            if (i != 3) {
                if (i == 4 && (gpsStatus = this.mLocationManager.getGpsStatus(null)) != null) {
                    executor.execute(new androidx.core.location.LocationManagerCompat.GpsStatusTransport.AnonymousClass4(executor, androidx.core.location.GnssStatusCompat.wrap(gpsStatus)));
                    return;
                }
                return;
            }
            android.location.GpsStatus gpsStatus2 = this.mLocationManager.getGpsStatus(null);
            if (gpsStatus2 != null) {
                executor.execute(new androidx.core.location.LocationManagerCompat.GpsStatusTransport.AnonymousClass3(executor, gpsStatus2.getTimeToFirstFix()));
            }
        }

        public void register(java.util.concurrent.Executor executor) {
            androidx.core.util.Preconditions.checkState(this.mExecutor == null);
            this.mExecutor = executor;
        }

        public void unregister() {
            this.mExecutor = null;
        }
    }

    public static class InlineHandlerExecutor implements java.util.concurrent.Executor {
        private final android.os.Handler mHandler;

        public InlineHandlerExecutor(@androidx.annotation.NonNull android.os.Handler handler) {
            this.mHandler = (android.os.Handler) androidx.core.util.Preconditions.checkNotNull(handler);
        }

        @Override // java.util.concurrent.Executor
        public void execute(@androidx.annotation.NonNull java.lang.Runnable runnable) {
            if (android.os.Looper.myLooper() == this.mHandler.getLooper()) {
                runnable.run();
            } else {
                if (this.mHandler.post((java.lang.Runnable) androidx.core.util.Preconditions.checkNotNull(runnable))) {
                    return;
                }
                throw new java.util.concurrent.RejectedExecutionException(this.mHandler + " is shutting down");
            }
        }
    }

    @androidx.annotation.RequiresApi(24)
    public static class PreRGnssStatusTransport extends android.location.GnssStatus.Callback {
        final androidx.core.location.GnssStatusCompat.Callback mCallback;

        @androidx.annotation.Nullable
        volatile java.util.concurrent.Executor mExecutor;

        /* renamed from: androidx.core.location.LocationManagerCompat$PreRGnssStatusTransport$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            final /* synthetic */ java.util.concurrent.Executor val$executor;

            public AnonymousClass1(java.util.concurrent.Executor executor) {
                this.val$executor = executor;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (androidx.core.location.LocationManagerCompat.PreRGnssStatusTransport.this.mExecutor != this.val$executor) {
                    return;
                }
                androidx.core.location.LocationManagerCompat.PreRGnssStatusTransport.this.mCallback.onStarted();
            }
        }

        /* renamed from: androidx.core.location.LocationManagerCompat$PreRGnssStatusTransport$2, reason: invalid class name */
        public class AnonymousClass2 implements java.lang.Runnable {
            final /* synthetic */ java.util.concurrent.Executor val$executor;

            public AnonymousClass2(java.util.concurrent.Executor executor) {
                this.val$executor = executor;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (androidx.core.location.LocationManagerCompat.PreRGnssStatusTransport.this.mExecutor != this.val$executor) {
                    return;
                }
                androidx.core.location.LocationManagerCompat.PreRGnssStatusTransport.this.mCallback.onStopped();
            }
        }

        /* renamed from: androidx.core.location.LocationManagerCompat$PreRGnssStatusTransport$3, reason: invalid class name */
        public class AnonymousClass3 implements java.lang.Runnable {
            final /* synthetic */ java.util.concurrent.Executor val$executor;
            final /* synthetic */ int val$ttffMillis;

            public AnonymousClass3(java.util.concurrent.Executor executor, int i) {
                this.val$executor = executor;
                this.val$ttffMillis = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (androidx.core.location.LocationManagerCompat.PreRGnssStatusTransport.this.mExecutor != this.val$executor) {
                    return;
                }
                androidx.core.location.LocationManagerCompat.PreRGnssStatusTransport.this.mCallback.onFirstFix(this.val$ttffMillis);
            }
        }

        /* renamed from: androidx.core.location.LocationManagerCompat$PreRGnssStatusTransport$4, reason: invalid class name */
        public class AnonymousClass4 implements java.lang.Runnable {
            final /* synthetic */ java.util.concurrent.Executor val$executor;
            final /* synthetic */ android.location.GnssStatus val$status;

            public AnonymousClass4(java.util.concurrent.Executor executor, android.location.GnssStatus gnssStatus) {
                this.val$executor = executor;
                this.val$status = gnssStatus;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (androidx.core.location.LocationManagerCompat.PreRGnssStatusTransport.this.mExecutor != this.val$executor) {
                    return;
                }
                androidx.core.location.LocationManagerCompat.PreRGnssStatusTransport.this.mCallback.onSatelliteStatusChanged(androidx.core.location.GnssStatusCompat.wrap(this.val$status));
            }
        }

        public PreRGnssStatusTransport(androidx.core.location.GnssStatusCompat.Callback callback) {
            androidx.core.util.Preconditions.checkArgument(callback != null, "invalid null callback");
            this.mCallback = callback;
        }

        @Override // android.location.GnssStatus.Callback
        public void onFirstFix(int i) {
            java.util.concurrent.Executor executor = this.mExecutor;
            if (executor == null) {
                return;
            }
            executor.execute(new androidx.core.location.LocationManagerCompat.PreRGnssStatusTransport.AnonymousClass3(executor, i));
        }

        @Override // android.location.GnssStatus.Callback
        public void onSatelliteStatusChanged(android.location.GnssStatus gnssStatus) {
            java.util.concurrent.Executor executor = this.mExecutor;
            if (executor == null) {
                return;
            }
            executor.execute(new androidx.core.location.LocationManagerCompat.PreRGnssStatusTransport.AnonymousClass4(executor, gnssStatus));
        }

        @Override // android.location.GnssStatus.Callback
        public void onStarted() {
            java.util.concurrent.Executor executor = this.mExecutor;
            if (executor == null) {
                return;
            }
            executor.execute(new androidx.core.location.LocationManagerCompat.PreRGnssStatusTransport.AnonymousClass1(executor));
        }

        @Override // android.location.GnssStatus.Callback
        public void onStopped() {
            java.util.concurrent.Executor executor = this.mExecutor;
            if (executor == null) {
                return;
            }
            executor.execute(new androidx.core.location.LocationManagerCompat.PreRGnssStatusTransport.AnonymousClass2(executor));
        }

        public void register(java.util.concurrent.Executor executor) {
            androidx.core.util.Preconditions.checkArgument(executor != null, "invalid null executor");
            androidx.core.util.Preconditions.checkState(this.mExecutor == null);
            this.mExecutor = executor;
        }

        public void unregister() {
            this.mExecutor = null;
        }
    }

    private LocationManagerCompat() {
    }

    public static boolean isLocationEnabled(@androidx.annotation.NonNull android.location.LocationManager locationManager) {
        return android.os.Build.VERSION.SDK_INT >= 28 ? androidx.core.location.LocationManagerCompat.Api28Impl.isLocationEnabled(locationManager) : locationManager.isProviderEnabled("network") || locationManager.isProviderEnabled(com.amap.api.services.geocoder.GeocodeSearch.GPS);
    }

    /* JADX WARN: Removed duplicated region for block: B:78:0x010a A[Catch: all -> 0x0126, TryCatch #2 {all -> 0x0126, blocks: (B:88:0x00e9, B:89:0x00ff, B:76:0x0102, B:78:0x010a, B:80:0x0112, B:81:0x0118, B:82:0x0119, B:83:0x011e, B:84:0x011f, B:85:0x0125, B:71:0x00d8), top: B:53:0x0098 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x011f A[Catch: all -> 0x0126, TryCatch #2 {all -> 0x0126, blocks: (B:88:0x00e9, B:89:0x00ff, B:76:0x0102, B:78:0x010a, B:80:0x0112, B:81:0x0118, B:82:0x0119, B:83:0x011e, B:84:0x011f, B:85:0x0125, B:71:0x00d8), top: B:53:0x0098 }] */
    @androidx.annotation.RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean registerGnssStatusCallback(android.location.LocationManager locationManager, android.os.Handler handler, java.util.concurrent.Executor executor, androidx.core.location.GnssStatusCompat.Callback callback) {
        boolean registerGnssStatusCallback;
        boolean registerGnssStatusCallback2;
        int i = android.os.Build.VERSION.SDK_INT;
        boolean z = true;
        if (i >= 30) {
            androidx.collection.SimpleArrayMap<java.lang.Object, java.lang.Object> simpleArrayMap = sGnssStatusListeners;
            synchronized (simpleArrayMap) {
                androidx.core.location.LocationManagerCompat.GnssStatusTransport gnssStatusTransport = (androidx.core.location.LocationManagerCompat.GnssStatusTransport) simpleArrayMap.get(callback);
                if (gnssStatusTransport == null) {
                    gnssStatusTransport = new androidx.core.location.LocationManagerCompat.GnssStatusTransport(callback);
                }
                registerGnssStatusCallback2 = locationManager.registerGnssStatusCallback(executor, gnssStatusTransport);
                if (!registerGnssStatusCallback2) {
                    return false;
                }
                simpleArrayMap.put(callback, gnssStatusTransport);
                return true;
            }
        }
        if (i >= 24) {
            androidx.core.util.Preconditions.checkArgument(handler != null);
            androidx.collection.SimpleArrayMap<java.lang.Object, java.lang.Object> simpleArrayMap2 = sGnssStatusListeners;
            synchronized (simpleArrayMap2) {
                androidx.core.location.LocationManagerCompat.PreRGnssStatusTransport preRGnssStatusTransport = (androidx.core.location.LocationManagerCompat.PreRGnssStatusTransport) simpleArrayMap2.get(callback);
                if (preRGnssStatusTransport == null) {
                    preRGnssStatusTransport = new androidx.core.location.LocationManagerCompat.PreRGnssStatusTransport(callback);
                } else {
                    preRGnssStatusTransport.unregister();
                }
                preRGnssStatusTransport.register(executor);
                registerGnssStatusCallback = locationManager.registerGnssStatusCallback(preRGnssStatusTransport, handler);
                if (!registerGnssStatusCallback) {
                    return false;
                }
                simpleArrayMap2.put(callback, preRGnssStatusTransport);
                return true;
            }
        }
        androidx.core.util.Preconditions.checkArgument(handler != null);
        androidx.collection.SimpleArrayMap<java.lang.Object, java.lang.Object> simpleArrayMap3 = sGnssStatusListeners;
        synchronized (simpleArrayMap3) {
            androidx.core.location.LocationManagerCompat.GpsStatusTransport gpsStatusTransport = (androidx.core.location.LocationManagerCompat.GpsStatusTransport) simpleArrayMap3.get(callback);
            if (gpsStatusTransport == null) {
                gpsStatusTransport = new androidx.core.location.LocationManagerCompat.GpsStatusTransport(locationManager, callback);
            } else {
                gpsStatusTransport.unregister();
            }
            gpsStatusTransport.register(executor);
            java.util.concurrent.FutureTask futureTask = new java.util.concurrent.FutureTask(new androidx.core.location.LocationManagerCompat.AnonymousClass1(locationManager, gpsStatusTransport));
            if (android.os.Looper.myLooper() == handler.getLooper()) {
                futureTask.run();
            } else if (!handler.post(futureTask)) {
                throw new java.lang.IllegalStateException(handler + " is shutting down");
            }
            try {
                try {
                    long nanos = java.util.concurrent.TimeUnit.SECONDS.toNanos(4L);
                    long nanoTime = java.lang.System.nanoTime() + nanos;
                    boolean z2 = false;
                    while (((java.lang.Boolean) futureTask.get(nanos, java.util.concurrent.TimeUnit.NANOSECONDS)).booleanValue()) {
                        try {
                            try {
                                sGnssStatusListeners.put(callback, gpsStatusTransport);
                                if (z2) {
                                    java.lang.Thread.currentThread().interrupt();
                                }
                                return true;
                            } catch (java.util.concurrent.ExecutionException e) {
                                e = e;
                                if (!(e.getCause() instanceof java.lang.RuntimeException)) {
                                    throw ((java.lang.RuntimeException) e.getCause());
                                }
                                if (e.getCause() instanceof java.lang.Error) {
                                    throw ((java.lang.Error) e.getCause());
                                }
                                throw new java.lang.IllegalStateException(e);
                            } catch (java.util.concurrent.TimeoutException e2) {
                                e = e2;
                                throw new java.lang.IllegalStateException(handler + " appears to be blocked, please run registerGnssStatusCallback() directly on a Looper thread or ensure the main Looper is not blocked by this thread", e);
                            }
                        } catch (java.lang.InterruptedException unused) {
                            nanos = nanoTime - java.lang.System.nanoTime();
                            z2 = true;
                        } catch (java.util.concurrent.ExecutionException e3) {
                            e = e3;
                            if (!(e.getCause() instanceof java.lang.RuntimeException)) {
                            }
                        } catch (java.util.concurrent.TimeoutException e4) {
                            e = e4;
                            throw new java.lang.IllegalStateException(handler + " appears to be blocked, please run registerGnssStatusCallback() directly on a Looper thread or ensure the main Looper is not blocked by this thread", e);
                        } catch (java.lang.Throwable th) {
                            th = th;
                            z = z2;
                            if (z) {
                                java.lang.Thread.currentThread().interrupt();
                            }
                            throw th;
                        }
                    }
                    if (z2) {
                        java.lang.Thread.currentThread().interrupt();
                    }
                    return false;
                } catch (java.lang.Throwable th2) {
                    th = th2;
                }
            } catch (java.util.concurrent.ExecutionException e5) {
                e = e5;
            } catch (java.util.concurrent.TimeoutException e6) {
                e = e6;
            } catch (java.lang.Throwable th3) {
                th = th3;
                z = false;
            }
        }
    }

    @androidx.annotation.RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    public static boolean registerGnssStatusCallback(@androidx.annotation.NonNull android.location.LocationManager locationManager, @androidx.annotation.NonNull androidx.core.location.GnssStatusCompat.Callback callback, @androidx.annotation.NonNull android.os.Handler handler) {
        return android.os.Build.VERSION.SDK_INT >= 30 ? registerGnssStatusCallback(locationManager, androidx.core.os.ExecutorCompat.create(handler), callback) : registerGnssStatusCallback(locationManager, new androidx.core.location.LocationManagerCompat.InlineHandlerExecutor(handler), callback);
    }

    @androidx.annotation.RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    public static boolean registerGnssStatusCallback(@androidx.annotation.NonNull android.location.LocationManager locationManager, @androidx.annotation.NonNull java.util.concurrent.Executor executor, @androidx.annotation.NonNull androidx.core.location.GnssStatusCompat.Callback callback) {
        if (android.os.Build.VERSION.SDK_INT >= 30) {
            return registerGnssStatusCallback(locationManager, null, executor, callback);
        }
        android.os.Looper myLooper = android.os.Looper.myLooper();
        if (myLooper == null) {
            myLooper = android.os.Looper.getMainLooper();
        }
        return registerGnssStatusCallback(locationManager, new android.os.Handler(myLooper), executor, callback);
    }

    public static void unregisterGnssStatusCallback(@androidx.annotation.NonNull android.location.LocationManager locationManager, @androidx.annotation.NonNull androidx.core.location.GnssStatusCompat.Callback callback) {
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 30) {
            androidx.collection.SimpleArrayMap<java.lang.Object, java.lang.Object> simpleArrayMap = sGnssStatusListeners;
            synchronized (simpleArrayMap) {
                androidx.core.location.LocationManagerCompat.GnssStatusTransport gnssStatusTransport = (androidx.core.location.LocationManagerCompat.GnssStatusTransport) simpleArrayMap.remove(callback);
                if (gnssStatusTransport != null) {
                    locationManager.unregisterGnssStatusCallback(gnssStatusTransport);
                }
            }
            return;
        }
        if (i >= 24) {
            androidx.collection.SimpleArrayMap<java.lang.Object, java.lang.Object> simpleArrayMap2 = sGnssStatusListeners;
            synchronized (simpleArrayMap2) {
                androidx.core.location.LocationManagerCompat.PreRGnssStatusTransport preRGnssStatusTransport = (androidx.core.location.LocationManagerCompat.PreRGnssStatusTransport) simpleArrayMap2.remove(callback);
                if (preRGnssStatusTransport != null) {
                    preRGnssStatusTransport.unregister();
                    locationManager.unregisterGnssStatusCallback(preRGnssStatusTransport);
                }
            }
            return;
        }
        androidx.collection.SimpleArrayMap<java.lang.Object, java.lang.Object> simpleArrayMap3 = sGnssStatusListeners;
        synchronized (simpleArrayMap3) {
            androidx.core.location.LocationManagerCompat.GpsStatusTransport gpsStatusTransport = (androidx.core.location.LocationManagerCompat.GpsStatusTransport) simpleArrayMap3.remove(callback);
            if (gpsStatusTransport != null) {
                gpsStatusTransport.unregister();
                locationManager.removeGpsStatusListener(gpsStatusTransport);
            }
        }
    }
}
