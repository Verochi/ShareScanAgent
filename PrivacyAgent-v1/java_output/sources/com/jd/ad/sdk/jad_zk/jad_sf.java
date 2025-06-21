package com.jd.ad.sdk.jad_zk;

/* loaded from: classes23.dex */
public final class jad_sf {
    public static volatile com.jd.ad.sdk.jad_zk.jad_sf jad_dq;
    public final com.jd.ad.sdk.jad_zk.jad_sf.jad_cp jad_an;

    @androidx.annotation.GuardedBy("this")
    public final java.util.Set<com.jd.ad.sdk.jad_zk.jad_cp.jad_an> jad_bo = new java.util.HashSet();

    @androidx.annotation.GuardedBy("this")
    public boolean jad_cp;

    public class jad_an implements com.jd.ad.sdk.jad_ir.jad_fs.jad_bo<android.net.ConnectivityManager> {
        public final /* synthetic */ android.content.Context jad_an;

        public jad_an(com.jd.ad.sdk.jad_zk.jad_sf jad_sfVar, android.content.Context context) {
            this.jad_an = context;
        }

        @Override // com.jd.ad.sdk.jad_ir.jad_fs.jad_bo
        public android.net.ConnectivityManager get() {
            return (android.net.ConnectivityManager) this.jad_an.getSystemService("connectivity");
        }
    }

    public class jad_bo implements com.jd.ad.sdk.jad_zk.jad_cp.jad_an {
        public jad_bo() {
        }

        @Override // com.jd.ad.sdk.jad_zk.jad_cp.jad_an
        public void jad_an(boolean z) {
            java.util.ArrayList arrayList;
            synchronized (com.jd.ad.sdk.jad_zk.jad_sf.this) {
                arrayList = new java.util.ArrayList(com.jd.ad.sdk.jad_zk.jad_sf.this.jad_bo);
            }
            java.util.Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((com.jd.ad.sdk.jad_zk.jad_cp.jad_an) it.next()).jad_an(z);
            }
        }
    }

    public interface jad_cp {
        void jad_an();

        boolean jad_bo();
    }

    @androidx.annotation.RequiresApi(24)
    public static final class jad_dq implements com.jd.ad.sdk.jad_zk.jad_sf.jad_cp {
        public boolean jad_an;
        public final com.jd.ad.sdk.jad_zk.jad_cp.jad_an jad_bo;
        public final com.jd.ad.sdk.jad_ir.jad_fs.jad_bo<android.net.ConnectivityManager> jad_cp;
        public final android.net.ConnectivityManager.NetworkCallback jad_dq = new com.jd.ad.sdk.jad_zk.jad_sf.jad_dq.jad_an();

        public class jad_an extends android.net.ConnectivityManager.NetworkCallback {
            public jad_an() {
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(@androidx.annotation.NonNull android.net.Network network) {
                com.jd.ad.sdk.jad_ir.jad_ly.jad_bo().post(new com.jd.ad.sdk.jad_zk.jad_tg(this, true));
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(@androidx.annotation.NonNull android.net.Network network) {
                com.jd.ad.sdk.jad_ir.jad_ly.jad_bo().post(new com.jd.ad.sdk.jad_zk.jad_tg(this, false));
            }
        }

        public jad_dq(com.jd.ad.sdk.jad_ir.jad_fs.jad_bo<android.net.ConnectivityManager> jad_boVar, com.jd.ad.sdk.jad_zk.jad_cp.jad_an jad_anVar) {
            this.jad_cp = jad_boVar;
            this.jad_bo = jad_anVar;
        }

        @Override // com.jd.ad.sdk.jad_zk.jad_sf.jad_cp
        public void jad_an() {
            this.jad_cp.get().unregisterNetworkCallback(this.jad_dq);
        }

        @Override // com.jd.ad.sdk.jad_zk.jad_sf.jad_cp
        @android.annotation.SuppressLint({"MissingPermission"})
        public boolean jad_bo() {
            android.net.Network activeNetwork;
            activeNetwork = this.jad_cp.get().getActiveNetwork();
            this.jad_an = activeNetwork != null;
            try {
                this.jad_cp.get().registerDefaultNetworkCallback(this.jad_dq);
                return true;
            } catch (java.lang.RuntimeException e) {
                if (android.util.Log.isLoggable("ConnectivityMonitor", 5)) {
                    com.jd.ad.sdk.logger.Logger.w("ConnectivityMonitor", "Failed to register callback", e);
                }
                return false;
            }
        }
    }

    public static final class jad_er implements com.jd.ad.sdk.jad_zk.jad_sf.jad_cp {
        public final android.content.Context jad_an;
        public final com.jd.ad.sdk.jad_zk.jad_cp.jad_an jad_bo;
        public final com.jd.ad.sdk.jad_ir.jad_fs.jad_bo<android.net.ConnectivityManager> jad_cp;
        public boolean jad_dq;
        public final android.content.BroadcastReceiver jad_er = new com.jd.ad.sdk.jad_zk.jad_sf.jad_er.jad_an();

        public class jad_an extends android.content.BroadcastReceiver {
            public jad_an() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(@androidx.annotation.NonNull android.content.Context context, android.content.Intent intent) {
                com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
                com.jd.ad.sdk.jad_zk.jad_sf.jad_er jad_erVar = com.jd.ad.sdk.jad_zk.jad_sf.jad_er.this;
                boolean z = jad_erVar.jad_dq;
                jad_erVar.jad_dq = jad_erVar.jad_cp();
                if (z != com.jd.ad.sdk.jad_zk.jad_sf.jad_er.this.jad_dq) {
                    if (android.util.Log.isLoggable("ConnectivityMonitor", 3)) {
                        java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_gr.jad_ly.jad_an("connectivity changed, isConnected: ");
                        jad_an.append(com.jd.ad.sdk.jad_zk.jad_sf.jad_er.this.jad_dq);
                        com.jd.ad.sdk.logger.Logger.d("ConnectivityMonitor", jad_an.toString());
                    }
                    com.jd.ad.sdk.jad_zk.jad_sf.jad_er jad_erVar2 = com.jd.ad.sdk.jad_zk.jad_sf.jad_er.this;
                    jad_erVar2.jad_bo.jad_an(jad_erVar2.jad_dq);
                }
            }
        }

        public jad_er(android.content.Context context, com.jd.ad.sdk.jad_ir.jad_fs.jad_bo<android.net.ConnectivityManager> jad_boVar, com.jd.ad.sdk.jad_zk.jad_cp.jad_an jad_anVar) {
            this.jad_an = context.getApplicationContext();
            this.jad_cp = jad_boVar;
            this.jad_bo = jad_anVar;
        }

        @Override // com.jd.ad.sdk.jad_zk.jad_sf.jad_cp
        public void jad_an() {
            this.jad_an.unregisterReceiver(this.jad_er);
        }

        @Override // com.jd.ad.sdk.jad_zk.jad_sf.jad_cp
        public boolean jad_bo() {
            this.jad_dq = jad_cp();
            try {
                this.jad_an.registerReceiver(this.jad_er, new android.content.IntentFilter(com.igexin.sdk.PushConsts.ACTION_BROADCAST_NETWORK_CHANGE), null, null);
                return true;
            } catch (java.lang.SecurityException e) {
                if (android.util.Log.isLoggable("ConnectivityMonitor", 5)) {
                    com.jd.ad.sdk.logger.Logger.w("ConnectivityMonitor", "Failed to register", e);
                }
                return false;
            }
        }

        @android.annotation.SuppressLint({"MissingPermission"})
        public boolean jad_cp() {
            try {
                android.net.NetworkInfo activeNetworkInfo = this.jad_cp.get().getActiveNetworkInfo();
                return activeNetworkInfo != null && activeNetworkInfo.isConnected();
            } catch (java.lang.RuntimeException e) {
                if (android.util.Log.isLoggable("ConnectivityMonitor", 5)) {
                    com.jd.ad.sdk.logger.Logger.w("ConnectivityMonitor", "Failed to determine connectivity status when connectivity changed", e);
                }
                return true;
            }
        }
    }

    public jad_sf(@androidx.annotation.NonNull android.content.Context context) {
        com.jd.ad.sdk.jad_ir.jad_fs.jad_bo jad_an2 = com.jd.ad.sdk.jad_ir.jad_fs.jad_an(new com.jd.ad.sdk.jad_zk.jad_sf.jad_an(this, context));
        com.jd.ad.sdk.jad_zk.jad_sf.jad_bo jad_boVar = new com.jd.ad.sdk.jad_zk.jad_sf.jad_bo();
        this.jad_an = android.os.Build.VERSION.SDK_INT >= 24 ? new com.jd.ad.sdk.jad_zk.jad_sf.jad_dq(jad_an2, jad_boVar) : new com.jd.ad.sdk.jad_zk.jad_sf.jad_er(context, jad_an2, jad_boVar);
    }

    public static com.jd.ad.sdk.jad_zk.jad_sf jad_an(@androidx.annotation.NonNull android.content.Context context) {
        if (jad_dq == null) {
            synchronized (com.jd.ad.sdk.jad_zk.jad_sf.class) {
                if (jad_dq == null) {
                    jad_dq = new com.jd.ad.sdk.jad_zk.jad_sf(context.getApplicationContext());
                }
            }
        }
        return jad_dq;
    }
}
