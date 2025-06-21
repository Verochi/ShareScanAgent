package com.tanx.exposer;

/* loaded from: classes19.dex */
public final class tanxc_for {
    public com.tanx.exposer.tanxc_do a;
    public com.tanx.exposer.achieve.tanxc_do.tanxc_if b;
    public android.content.Context c;
    public volatile boolean d;

    public static class tanxc_do {
        public static volatile com.tanx.exposer.tanxc_for a = new com.tanx.exposer.tanxc_for((byte) 0);
    }

    public tanxc_for() {
    }

    public /* synthetic */ tanxc_for(byte b) {
        this();
    }

    public static com.tanx.exposer.tanxc_for tanxc_do() {
        return com.tanx.exposer.tanxc_for.tanxc_do.a;
    }

    public com.tanx.exposer.AdMonitorInitResult tanxc_do(android.content.Context context, com.tanx.exposer.tanxc_do tanxc_doVar) {
        try {
            if (tanxc_doVar == null) {
                com.tanx.exposer.tanxc_if.tanxc_do.tanxc_do("adMonitorInitError", "params is null");
                return com.tanx.exposer.AdMonitorInitResult.PARAMS_ERROR;
            }
            this.c = context.getApplicationContext();
            this.a = tanxc_doVar;
            this.b = new com.tanx.exposer.achieve.tanxc_do.tanxc_if();
            com.tanx.exposer.tanxc_do.tanxc_do.tanxc_if.tanxc_do().tanxc_do(tanxc_doVar.tanxc_try());
            com.tanx.exposer.achieve.retry.tanxc_if.C0489tanxc_if.tanxc_do.tanxc_do(context, this);
            this.d = true;
            return com.tanx.exposer.AdMonitorInitResult.SUCCESS;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.tanx.exposer.tanxc_if.tanxc_do.tanxc_do("adMonitorInitError", e.getMessage());
            return com.tanx.exposer.AdMonitorInitResult.INTERNAL_ERROR;
        }
    }

    public com.tanx.exposer.achieve.AdMonitorCommitResult tanxc_do(java.util.List<java.lang.String> list, com.tanx.exposer.tanxc_if tanxc_ifVar) {
        return com.tanx.exposer.achieve.tanxc_do.C0490tanxc_do.tanxc_do.tanxc_do(com.tanx.exposer.achieve.AdMonitorType.EXPOSE, list, tanxc_ifVar);
    }

    public void tanxc_do(com.tanx.exposer.achieve.tanxc_do.tanxc_do tanxc_doVar) {
        com.tanx.exposer.achieve.tanxc_do.tanxc_if tanxc_ifVar = this.b;
        if (tanxc_ifVar != null) {
            tanxc_ifVar.tanxc_do(tanxc_doVar);
        }
    }

    public android.content.Context tanxc_for() {
        return this.c;
    }

    public com.tanx.exposer.achieve.AdMonitorCommitResult tanxc_for(java.util.List<java.lang.String> list, com.tanx.exposer.tanxc_if tanxc_ifVar) {
        return com.tanx.exposer.achieve.tanxc_do.C0490tanxc_do.tanxc_do.tanxc_do(com.tanx.exposer.achieve.AdMonitorType.INTERACT_DEDUPLICATION, list, tanxc_ifVar);
    }

    public com.tanx.exposer.achieve.AdMonitorCommitResult tanxc_if(java.util.List<java.lang.String> list, com.tanx.exposer.tanxc_if tanxc_ifVar) {
        return com.tanx.exposer.achieve.tanxc_do.C0490tanxc_do.tanxc_do.tanxc_do(com.tanx.exposer.achieve.AdMonitorType.CLICK, list, tanxc_ifVar);
    }

    public com.tanx.exposer.achieve.tanxc_do.tanxc_if tanxc_if() {
        return this.b;
    }

    public com.tanx.exposer.tanxc_do tanxc_int() {
        return this.a;
    }
}
