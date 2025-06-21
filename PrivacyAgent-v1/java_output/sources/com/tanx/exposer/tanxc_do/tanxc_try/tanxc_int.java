package com.tanx.exposer.tanxc_do.tanxc_try;

/* loaded from: classes19.dex */
public class tanxc_int implements com.tanx.exposer.tanxc_do.tanxc_try.tanxc_do {
    public static com.tanx.exposer.tanxc_do.tanxc_try.tanxc_do a;

    public tanxc_int(com.tanx.exposer.tanxc_do.tanxc_try.tanxc_do tanxc_doVar) {
        a = tanxc_doVar;
    }

    public void tanxc_do(java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map) {
        track("tanx_exposer_sdk_trace", com.tanx.exposer.tanxc_do.tanxc_try.tanxc_for.tanxc_do(), str, null, null, map);
    }

    @Override // com.tanx.exposer.tanxc_do.tanxc_try.tanxc_do
    public void track(java.lang.String str, int i, java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3, java.util.Map<java.lang.String, java.lang.Object> map) {
        try {
            com.tanx.exposer.tanxc_do.tanxc_try.tanxc_do tanxc_doVar = a;
            if (tanxc_doVar != null) {
                tanxc_doVar.track(str, i, obj, obj2, obj3, map);
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }
}
