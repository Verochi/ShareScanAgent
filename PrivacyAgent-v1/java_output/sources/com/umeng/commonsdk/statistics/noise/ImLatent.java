package com.umeng.commonsdk.statistics.noise;

/* loaded from: classes19.dex */
public class ImLatent implements com.umeng.commonsdk.statistics.internal.d {
    private static com.umeng.commonsdk.statistics.noise.ImLatent instanse;
    private android.content.Context context;
    private com.umeng.commonsdk.statistics.internal.StatTracer statTracer;
    private com.umeng.commonsdk.statistics.common.d storeHelper;
    private final int _DEFAULT_HOURS = com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE;
    private final int _DEFAULT_MIN_HOURS = 36;
    private final int _DEFAULT_MIN_LATENT = 1;
    private final int _DEFAULT_MAX_LATENT = 1800;
    private final long _ONE_HOURS_IN_MS = 3600000;
    private final long _360HOURS_IN_MS = 1296000000;
    private final long _36HOURS_IN_MS = 129600000;
    private final int LATENT_MAX = 1800000;
    private final int LATENT_WINDOW = 10;
    private long latentHour = 1296000000;
    private int latentWindow = 10;
    private long mDelay = 0;
    private long mElapsed = 0;
    private boolean mLatentActivite = false;
    private java.lang.Object mLatentLock = new java.lang.Object();

    private ImLatent(android.content.Context context, com.umeng.commonsdk.statistics.internal.StatTracer statTracer) {
        this.context = context;
        this.storeHelper = com.umeng.commonsdk.statistics.common.d.a(context);
        this.statTracer = statTracer;
    }

    public static synchronized com.umeng.commonsdk.statistics.noise.ImLatent getService(android.content.Context context, com.umeng.commonsdk.statistics.internal.StatTracer statTracer) {
        com.umeng.commonsdk.statistics.noise.ImLatent imLatent;
        synchronized (com.umeng.commonsdk.statistics.noise.ImLatent.class) {
            if (instanse == null) {
                com.umeng.commonsdk.statistics.noise.ImLatent imLatent2 = new com.umeng.commonsdk.statistics.noise.ImLatent(context, statTracer);
                instanse = imLatent2;
                imLatent2.onImprintChanged(com.umeng.commonsdk.statistics.idtracking.ImprintHandler.getImprintService(context).c());
            }
            imLatent = instanse;
        }
        return imLatent;
    }

    public long getDelayTime() {
        long j;
        synchronized (this.mLatentLock) {
            j = this.mDelay;
        }
        return j;
    }

    public long getElapsedTime() {
        return this.mElapsed;
    }

    public boolean isLatentActivite() {
        boolean z;
        synchronized (this.mLatentLock) {
            z = this.mLatentActivite;
        }
        return z;
    }

    public void latentDeactivite() {
        synchronized (this.mLatentLock) {
            this.mLatentActivite = false;
        }
    }

    @Override // com.umeng.commonsdk.statistics.internal.d
    public void onImprintChanged(com.umeng.commonsdk.statistics.idtracking.ImprintHandler.a aVar) {
        int i = com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE;
        int intValue = java.lang.Integer.valueOf(aVar.a("latent_hours", java.lang.String.valueOf(com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE))).intValue();
        if (intValue > 36) {
            i = intValue;
        }
        this.latentHour = i * 3600000;
        int intValue2 = java.lang.Integer.valueOf(aVar.a(com.umeng.analytics.pro.bo.aY, "0")).intValue();
        if (intValue2 < 1 || intValue2 > 1800) {
            intValue2 = 0;
        }
        if (intValue2 != 0) {
            this.latentWindow = intValue2;
            return;
        }
        int i2 = com.umeng.commonsdk.statistics.a.c;
        if (i2 <= 0 || i2 > 1800000) {
            this.latentWindow = 10;
        } else {
            this.latentWindow = i2;
        }
    }

    public boolean shouldStartLatency() {
        if (this.storeHelper.c() || this.statTracer.isFirstRequest()) {
            return false;
        }
        synchronized (this.mLatentLock) {
            if (this.mLatentActivite) {
                return false;
            }
            long currentTimeMillis = java.lang.System.currentTimeMillis() - this.statTracer.getLastReqTime();
            if (currentTimeMillis > this.latentHour) {
                java.lang.String signature = com.umeng.commonsdk.statistics.idtracking.Envelope.getSignature(this.context);
                synchronized (this.mLatentLock) {
                    this.mDelay = com.umeng.commonsdk.statistics.common.DataHelper.random(this.latentWindow, signature);
                    this.mElapsed = currentTimeMillis;
                    this.mLatentActivite = true;
                }
                return true;
            }
            if (currentTimeMillis <= 129600000) {
                return false;
            }
            synchronized (this.mLatentLock) {
                this.mDelay = 0L;
                this.mElapsed = currentTimeMillis;
                this.mLatentActivite = true;
            }
            return true;
        }
    }
}
