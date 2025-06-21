package com.umeng.commonsdk.statistics.noise;

/* loaded from: classes19.dex */
public class Defcon implements com.umeng.commonsdk.statistics.internal.d {
    private static final int LEVEL_0 = 0;
    private static final int LEVEL_1 = 1;
    private static final int LEVEL_2 = 2;
    private static final int LEVEL_3 = 3;
    private static final long MILLIS_24_HOURS = 86400000;
    private static final long MILLIS_4_HOURS = 14400000;
    private static final long MILLIS_8_HOURS = 28800000;
    private static com.umeng.commonsdk.statistics.noise.Defcon instanse;
    private int mLevel = 0;

    private Defcon() {
    }

    public static synchronized com.umeng.commonsdk.statistics.noise.Defcon getService(android.content.Context context) {
        com.umeng.commonsdk.statistics.noise.Defcon defcon;
        synchronized (com.umeng.commonsdk.statistics.noise.Defcon.class) {
            if (instanse == null) {
                instanse = new com.umeng.commonsdk.statistics.noise.Defcon();
                instanse.setLevel(java.lang.Integer.valueOf(com.umeng.commonsdk.framework.UMEnvelopeBuild.imprintProperty(context, "defcon", "0")).intValue());
            }
            defcon = instanse;
        }
        return defcon;
    }

    public int getLevel() {
        return this.mLevel;
    }

    public long getReqInterval() {
        int i = this.mLevel;
        return i != 1 ? i != 2 ? i != 3 ? 0L : 86400000L : MILLIS_8_HOURS : MILLIS_4_HOURS;
    }

    public long getRetryInterval() {
        return this.mLevel == 0 ? 0L : 300000L;
    }

    public boolean isOpen() {
        return this.mLevel != 0;
    }

    @Override // com.umeng.commonsdk.statistics.internal.d
    public void onImprintChanged(com.umeng.commonsdk.statistics.idtracking.ImprintHandler.a aVar) {
        setLevel(java.lang.Integer.valueOf(aVar.a("defcon", java.lang.String.valueOf(0))).intValue());
    }

    public void setLevel(int i) {
        if (i < 0 || i > 3) {
            return;
        }
        this.mLevel = i;
    }
}
