package cn.fly.verify;

/* loaded from: classes31.dex */
public abstract class bu {
    protected final android.content.Context a;
    protected final java.lang.String b;
    private boolean c = false;
    private boolean d = false;
    private java.lang.String e = null;
    private int f = 0;

    /* loaded from: classes.dex */
    public class a implements android.content.ServiceConnection {
        boolean a;
        private final java.util.concurrent.BlockingQueue<android.os.IBinder> c;

        private a() {
            this.a = false;
            this.c = new java.util.concurrent.LinkedBlockingQueue();
        }

        public /* synthetic */ a(cn.fly.verify.bu buVar, cn.fly.verify.bu.AnonymousClass1 anonymousClass1) {
            this();
        }

        public android.os.IBinder a(long j) throws java.lang.InterruptedException {
            if (this.a) {
                throw new java.lang.IllegalStateException();
            }
            this.a = true;
            java.util.concurrent.BlockingQueue<android.os.IBinder> blockingQueue = this.c;
            if (j <= 0) {
                j = 1500;
            }
            return blockingQueue.poll(j, java.util.concurrent.TimeUnit.MILLISECONDS);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            try {
                this.c.put(iBinder);
            } catch (java.lang.Throwable unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(android.content.ComponentName componentName) {
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        boolean a;
        java.lang.String b;
    }

    public bu(android.content.Context context) {
        this.a = context;
        this.b = context.getPackageName();
    }

    private cn.fly.verify.bu.b a(android.content.Context context, android.content.Intent intent) throws java.lang.Throwable {
        if (android.os.Looper.myLooper() == android.os.Looper.getMainLooper()) {
            throw new java.lang.Throwable("unable to invoke in main thread!");
        }
        cn.fly.verify.bu.a aVar = new cn.fly.verify.bu.a(this, null);
        try {
            boolean bindService = android.os.Build.VERSION.SDK_INT >= 34 ? context.bindService(intent, aVar, 513) : context.bindService(intent, aVar, 1);
            if (intent == null || !bindService) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("bind service ");
                sb.append(intent == null ? com.igexin.push.core.b.m : intent.getComponent());
                sb.append(" failed!");
                throw new java.lang.Throwable(sb.toString());
            }
            long c = c();
            cn.fly.verify.ed.a().a("wte " + c, new java.lang.Object[0]);
            android.os.IBinder a2 = aVar.a(c());
            if (a2 != null) {
                return a(a2);
            }
            throw new java.lang.Throwable("get binder " + intent.getComponent() + " failed!");
        } finally {
            try {
                context.unbindService(aVar);
            } catch (java.lang.Throwable th) {
                cn.fly.verify.ed.a().a(th);
            }
        }
    }

    private synchronized boolean a(android.content.Intent intent) {
        boolean z;
        cn.fly.verify.bu.b b2;
        z = true;
        this.f++;
        long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
        try {
            b2 = b();
            if (b2 == null) {
                b2 = a(this.a, intent);
            }
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().a(th);
        }
        if (b2 != null) {
            this.d = b2.a;
            this.e = b2.b;
            long elapsedRealtime2 = android.os.SystemClock.elapsedRealtime() - elapsedRealtime;
            cn.fly.verify.ed.a().a("oa use time: " + elapsedRealtime2, new java.lang.Object[0]);
        }
        z = false;
        long elapsedRealtime22 = android.os.SystemClock.elapsedRealtime() - elapsedRealtime;
        cn.fly.verify.ed.a().a("oa use time: " + elapsedRealtime22, new java.lang.Object[0]);
        return z;
    }

    private synchronized void f() {
        if (this.c) {
            return;
        }
        if (a(a()) || this.f >= 4) {
            this.c = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x005b A[Catch: all -> 0x005e, TRY_LEAVE, TryCatch #5 {all -> 0x005e, blocks: (B:34:0x0056, B:29:0x005b), top: B:33:0x0056 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0056 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int a(java.lang.String str, android.os.IBinder iBinder, java.lang.String str2, int i) {
        android.os.Parcel parcel;
        android.os.Parcel parcel2;
        android.os.Parcel parcel3 = null;
        try {
            parcel = android.os.Parcel.obtain();
            try {
                parcel3 = android.os.Parcel.obtain();
                parcel.writeInterfaceToken(str2);
                iBinder.transact(i, parcel, parcel3, 0);
                parcel3.readException();
                int readInt = parcel3.readInt();
                try {
                    parcel3.recycle();
                    parcel.recycle();
                } catch (java.lang.Throwable unused) {
                }
                return readInt;
            } catch (android.os.RemoteException unused2) {
                parcel2 = parcel3;
                parcel3 = parcel;
                try {
                    cn.fly.verify.ed.a().a("getIntValue: " + str + " failed! (remoteException)", new java.lang.Object[0]);
                    if (parcel2 != null) {
                        try {
                            parcel2.recycle();
                        } catch (java.lang.Throwable unused3) {
                            return 0;
                        }
                    }
                    if (parcel3 != null) {
                        parcel3.recycle();
                    }
                    return 0;
                } catch (java.lang.Throwable th) {
                    th = th;
                    parcel = parcel3;
                    parcel3 = parcel2;
                    if (parcel3 != null) {
                        try {
                            parcel3.recycle();
                        } catch (java.lang.Throwable unused4) {
                            throw th;
                        }
                    }
                    if (parcel != null) {
                        parcel.recycle();
                    }
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                if (parcel3 != null) {
                }
                if (parcel != null) {
                }
                throw th;
            }
        } catch (android.os.RemoteException unused5) {
            parcel2 = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            parcel = null;
        }
    }

    public android.content.Intent a() {
        return null;
    }

    public cn.fly.verify.bu.b a(android.os.IBinder iBinder) {
        return null;
    }

    public java.lang.String a(java.lang.String str, android.os.IBinder iBinder, java.lang.String str2, int i, java.lang.String... strArr) {
        android.os.Parcel parcel;
        android.os.Parcel parcel2;
        try {
            parcel = android.os.Parcel.obtain();
            try {
                parcel2 = android.os.Parcel.obtain();
            } catch (java.lang.Throwable th) {
                th = th;
                parcel2 = null;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            parcel = null;
            parcel2 = null;
        }
        try {
            parcel.writeInterfaceToken(str2);
            if (strArr != null && strArr.length > 0) {
                for (java.lang.String str3 : strArr) {
                    parcel.writeString(str3);
                }
            }
            iBinder.transact(i, parcel, parcel2, 0);
            parcel2.readException();
            java.lang.String readString = parcel2.readString();
            try {
                parcel2.recycle();
                parcel.recycle();
            } catch (java.lang.Throwable unused) {
            }
            return readString;
        } catch (java.lang.Throwable th3) {
            th = th3;
            try {
                cn.fly.verify.ed.a().a("getStringValue: " + str + " failed! " + th.getMessage(), new java.lang.Object[0]);
                if (parcel2 != null) {
                    try {
                        parcel2.recycle();
                    } catch (java.lang.Throwable unused2) {
                        return null;
                    }
                }
                return null;
            } finally {
                if (parcel2 != null) {
                    try {
                        parcel2.recycle();
                    } catch (java.lang.Throwable unused3) {
                    }
                }
                if (parcel != null) {
                    parcel.recycle();
                }
            }
        }
    }

    public synchronized void a(java.lang.String str) {
        if (str != null) {
            if (!java.util.regex.Pattern.compile("^[0fF\\-]+").matcher(str).matches()) {
                this.e = str;
            }
        }
    }

    public cn.fly.verify.bu.b b() {
        return null;
    }

    public long c() {
        return (((this.f - 1) * 2) + 2) * 1000;
    }

    public synchronized java.lang.String d() {
        f();
        return this.e;
    }

    public synchronized boolean e() {
        f();
        return this.d;
    }
}
