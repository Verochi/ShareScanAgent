package com.anythink.expressad.exoplayer.scheduler;

/* loaded from: classes12.dex */
public final class a {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;
    private static final int f = 8;
    private static final int g = 16;
    private static final int h = 7;
    private static final java.lang.String i = "Requirements";
    private static final java.lang.String[] j = null;
    private final int k;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    /* renamed from: com.anythink.expressad.exoplayer.scheduler.a$a, reason: collision with other inner class name */
    public @interface InterfaceC0205a {
    }

    public a(int i2) {
        this.k = i2;
    }

    private a(int i2, boolean z, boolean z2) {
        this(i2 | (z ? 16 : 0) | (z2 ? 8 : 0));
    }

    private static boolean a(android.net.ConnectivityManager connectivityManager) {
        android.net.Network activeNetwork;
        if (com.anythink.expressad.exoplayer.k.af.a < 23) {
            return true;
        }
        activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null) {
            return false;
        }
        android.net.NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
        return !(networkCapabilities == null || !networkCapabilities.hasCapability(16));
    }

    private static boolean a(android.net.ConnectivityManager connectivityManager, android.net.NetworkInfo networkInfo) {
        if (com.anythink.expressad.exoplayer.k.af.a >= 16) {
            return connectivityManager.isActiveNetworkMetered();
        }
        int type = networkInfo.getType();
        return (type == 1 || type == 7 || type == 9) ? false : true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x003e, code lost:
    
        if ((r6 == null || !r6.hasCapability(16)) == false) goto L12;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0044 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean b(android.content.Context context) {
        android.net.Network activeNetwork;
        boolean z;
        boolean z2;
        int i2 = this.k & 7;
        if (i2 == 0) {
            return true;
        }
        android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
        android.net.NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return false;
        }
        int i3 = com.anythink.expressad.exoplayer.k.af.a;
        if (i3 >= 23) {
            activeNetwork = connectivityManager.getActiveNetwork();
            if (activeNetwork != null) {
                android.net.NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
            }
            z = false;
            if (z) {
                return false;
            }
            if (i2 == 1) {
                return true;
            }
            if (i2 == 3) {
                return !activeNetworkInfo.isRoaming();
            }
            if (i3 >= 16) {
                z2 = connectivityManager.isActiveNetworkMetered();
            } else {
                int type = activeNetworkInfo.getType();
                z2 = (type == 1 || type == 7 || type == 9) ? false : true;
            }
            if (i2 == 2) {
                return !z2;
            }
            if (i2 == 4) {
                return z2;
            }
            throw new java.lang.IllegalStateException();
        }
        z = true;
        if (z) {
        }
    }

    private boolean c(android.content.Context context) {
        if (!b()) {
            return true;
        }
        android.content.Intent registerReceiver = context.registerReceiver(null, new android.content.IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return false;
        }
        int intExtra = registerReceiver.getIntExtra("status", -1);
        return intExtra == 2 || intExtra == 5;
    }

    private boolean d(android.content.Context context) {
        boolean isDeviceIdleMode;
        if (!c()) {
            return true;
        }
        android.os.PowerManager powerManager = (android.os.PowerManager) context.getSystemService("power");
        int i2 = com.anythink.expressad.exoplayer.k.af.a;
        if (i2 < 23) {
            return i2 >= 20 ? !powerManager.isInteractive() : !powerManager.isScreenOn();
        }
        isDeviceIdleMode = powerManager.isDeviceIdleMode();
        return !isDeviceIdleMode;
    }

    private static void e() {
    }

    public final int a() {
        return this.k & 7;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x00bc, code lost:
    
        if (r12 == false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0053, code lost:
    
        if (r7.isRoaming() == false) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x006e, code lost:
    
        if (r1 == false) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0042, code lost:
    
        if ((r10 == null || !r10.hasCapability(16)) == false) goto L12;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00d5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:5:0x007e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(android.content.Context context) {
        boolean z;
        android.net.Network activeNetwork;
        boolean z2;
        android.content.Intent registerReceiver;
        int intExtra;
        boolean isDeviceIdleMode;
        boolean z3;
        int i2 = this.k & 7;
        if (i2 != 0) {
            android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
            android.net.NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                int i3 = com.anythink.expressad.exoplayer.k.af.a;
                if (i3 >= 23) {
                    activeNetwork = connectivityManager.getActiveNetwork();
                    if (activeNetwork != null) {
                        android.net.NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
                    }
                    z2 = false;
                    if (z2) {
                        if (i2 != 1) {
                            if (i2 != 3) {
                                if (i3 >= 16) {
                                    z = connectivityManager.isActiveNetworkMetered();
                                } else {
                                    int type = activeNetworkInfo.getType();
                                    z = (type == 1 || type == 7 || type == 9) ? false : true;
                                }
                                if (i2 != 2) {
                                    if (i2 != 4) {
                                        throw new java.lang.IllegalStateException();
                                    }
                                }
                            }
                            if (z) {
                                if (!b() || ((registerReceiver = context.registerReceiver(null, new android.content.IntentFilter("android.intent.action.BATTERY_CHANGED"))) != null && ((intExtra = registerReceiver.getIntExtra("status", -1)) == 2 || intExtra == 5))) {
                                    if (c()) {
                                        android.os.PowerManager powerManager = (android.os.PowerManager) context.getSystemService("power");
                                        int i4 = com.anythink.expressad.exoplayer.k.af.a;
                                        if (i4 >= 23) {
                                            isDeviceIdleMode = powerManager.isDeviceIdleMode();
                                        } else {
                                            z3 = i4 < 20 ? false : false;
                                        }
                                        if (!z3) {
                                            return true;
                                        }
                                    }
                                    z3 = true;
                                    if (!z3) {
                                    }
                                }
                            }
                            return false;
                        }
                    }
                }
                z2 = true;
                if (z2) {
                }
            }
            z = false;
            if (z) {
            }
            return false;
        }
        z = true;
        if (z) {
        }
        return false;
    }

    public final boolean b() {
        return (this.k & 16) != 0;
    }

    public final boolean c() {
        return (this.k & 8) != 0;
    }

    public final int d() {
        return this.k;
    }

    public final java.lang.String toString() {
        return super.toString();
    }
}
