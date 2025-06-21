package com.tanx.exposer.achieve;

/* loaded from: classes19.dex */
public class tanxc_do {

    /* renamed from: com.tanx.exposer.achieve.tanxc_do$tanxc_do, reason: collision with other inner class name */
    public static class C0490tanxc_do {
        public static volatile com.tanx.exposer.achieve.tanxc_do tanxc_do = new com.tanx.exposer.achieve.tanxc_do((byte) 0);
    }

    public tanxc_do() {
    }

    public /* synthetic */ tanxc_do(byte b) {
        this();
    }

    public com.tanx.exposer.achieve.AdMonitorCommitResult tanxc_do(com.tanx.exposer.achieve.AdMonitorType adMonitorType, java.util.List<java.lang.String> list, com.tanx.exposer.tanxc_if tanxc_ifVar) {
        try {
            if (com.tanx.exposer.tanxc_if.tanxc_do.tanxc_do && tanxc_ifVar != null) {
                com.tanx.exposer.tanxc_if.tanxc_do.tanxc_do("utArgs", tanxc_ifVar.toString());
            }
            if (list != null && !list.isEmpty()) {
                com.tanx.exposer.tanxc_do.tanxc_try.tanxc_for.tanxc_do(tanxc_ifVar, adMonitorType);
                if (adMonitorType != com.tanx.exposer.achieve.AdMonitorType.EXPOSE && adMonitorType != com.tanx.exposer.achieve.AdMonitorType.INTERACT_DEDUPLICATION) {
                    return new com.tanx.exposer.achieve.tanxc_if.tanxc_do(adMonitorType, list, tanxc_ifVar).tanxc_do();
                }
                return new com.tanx.exposer.achieve.tanxc_if.tanxc_if(adMonitorType, list, tanxc_ifVar).tanxc_do();
            }
            com.tanx.exposer.tanxc_do.tanxc_try.tanxc_for.tanxc_do(tanxc_ifVar, adMonitorType, "urls is empty");
            return com.tanx.exposer.achieve.AdMonitorCommitResult.PARAMS_ERROR;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.tanx.exposer.tanxc_do.tanxc_try.tanxc_for.tanxc_do(tanxc_ifVar, adMonitorType, e.getMessage());
            return com.tanx.exposer.achieve.AdMonitorCommitResult.INTERNAL_ERROR;
        }
    }
}
