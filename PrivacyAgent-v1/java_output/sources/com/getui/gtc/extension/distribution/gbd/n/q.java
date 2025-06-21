package com.getui.gtc.extension.distribution.gbd.n;

/* loaded from: classes22.dex */
public final class q {
    private static final java.lang.String a = "GBD_NS";

    /* renamed from: com.getui.gtc.extension.distribution.gbd.n.q$1, reason: invalid class name */
    public static class AnonymousClass1 extends android.net.ConnectivityManager.NetworkCallback {
        final /* synthetic */ java.util.concurrent.atomic.AtomicReference a;
        final /* synthetic */ java.util.concurrent.CountDownLatch b;

        public AnonymousClass1(java.util.concurrent.atomic.AtomicReference atomicReference, java.util.concurrent.CountDownLatch countDownLatch) {
            this.a = atomicReference;
            this.b = countDownLatch;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onAvailable(android.net.Network network) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(com.getui.gtc.extension.distribution.gbd.n.q.a, "network onAvailable");
            this.a.set(network);
            this.b.countDown();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onLost(android.net.Network network) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(com.getui.gtc.extension.distribution.gbd.n.q.a, "network onLost");
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onUnavailable() {
            com.getui.gtc.extension.distribution.gbd.n.j.a(com.getui.gtc.extension.distribution.gbd.n.q.a, "network onUnavailable");
        }
    }

    @android.annotation.TargetApi(21)
    public static android.util.Pair<android.net.Network, android.net.ConnectivityManager.NetworkCallback> a(android.net.ConnectivityManager connectivityManager) {
        try {
            java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
            java.util.concurrent.atomic.AtomicReference atomicReference = new java.util.concurrent.atomic.AtomicReference();
            android.net.NetworkRequest build = new android.net.NetworkRequest.Builder().addCapability(12).addTransportType(0).build();
            com.getui.gtc.extension.distribution.gbd.n.q.AnonymousClass1 anonymousClass1 = new com.getui.gtc.extension.distribution.gbd.n.q.AnonymousClass1(atomicReference, countDownLatch);
            connectivityManager.requestNetwork(build, anonymousClass1);
            countDownLatch.await(3000L, java.util.concurrent.TimeUnit.MILLISECONDS);
            android.net.Network network = (android.net.Network) atomicReference.get();
            if (network != null) {
                return new android.util.Pair<>(network, anonymousClass1);
            }
            connectivityManager.unregisterNetworkCallback(anonymousClass1);
            return null;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, th.toString());
            return null;
        }
    }

    public static boolean a(android.content.Context context) {
        try {
            android.net.NetworkInfo activeNetworkInfo = c(context).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.getType() == 0) {
                if (activeNetworkInfo.isAvailable()) {
                    return true;
                }
            }
            return false;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(a, th);
            return false;
        }
    }

    public static boolean b(android.content.Context context) {
        try {
            android.net.NetworkInfo activeNetworkInfo = ((android.net.ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isAvailable()) {
                    return true;
                }
            }
            return false;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(a, th);
            return true;
        }
    }

    public static android.net.ConnectivityManager c(android.content.Context context) {
        return (android.net.ConnectivityManager) context.getSystemService("connectivity");
    }

    public static boolean d(android.content.Context context) {
        try {
            android.net.ConnectivityManager c = c(context);
            java.lang.reflect.Method declaredMethod = android.net.ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new java.lang.Class[0]);
            declaredMethod.setAccessible(true);
            return ((java.lang.Boolean) declaredMethod.invoke(c, new java.lang.Object[0])).booleanValue();
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(a, th);
            return true;
        }
    }
}
