package cn.fly.verify;

/* loaded from: classes.dex */
public class bq {
    private static final java.lang.String a = cn.fly.verify.ds.b("005+ecceeg'cHeg");

    private static java.util.HashMap<java.lang.String, java.lang.Object> a() {
        java.util.HashMap<java.lang.String, java.lang.Object> hashMap;
        java.io.File file = new java.io.File(cn.fly.verify.ax.g().getFilesDir().getAbsolutePath() + cn.fly.verify.ds.b("005k@gbdcedDk"), a);
        if (file.exists()) {
            hashMap = (java.util.HashMap) cn.fly.verify.fq.a(file.getAbsolutePath());
            cn.fly.verify.bl.a().b("all_ds", hashMap);
            file.delete();
        } else {
            hashMap = null;
        }
        return (hashMap == null || hashMap.isEmpty()) ? (java.util.HashMap) cn.fly.verify.bl.a().c("all_ds", null) : hashMap;
    }

    public static synchronized java.util.HashMap<java.lang.String, java.lang.Object> a(android.content.Context context) {
        synchronized (cn.fly.verify.bq.class) {
            java.util.HashMap<java.lang.String, java.lang.Object> hashMap = new java.util.HashMap<>();
            java.util.HashMap<java.lang.String, java.lang.Object> a2 = a();
            boolean z = a2 != null && a2.size() > 0;
            if (z) {
                java.util.HashMap hashMap2 = new java.util.HashMap();
                if (a2.containsKey(cn.fly.verify.ds.b("004?cfcbchcb"))) {
                    a2.put(cn.fly.verify.ds.b("005cBcfcbchcb"), a2.remove(cn.fly.verify.ds.b("004[cfcbchcb")));
                }
                if (a2.containsKey(cn.fly.verify.ds.b("009PegcfSii_dcci>he@cb"))) {
                    a2.put(cn.fly.verify.ds.b("011^chcbdicf_ii6dcci]heHcb"), a2.remove(cn.fly.verify.ds.b("009Oegcf8iiAdcciFhe:cb")));
                }
                hashMap2.putAll(a2);
                hashMap.put(cn.fly.verify.ds.b("009!dechcbegfj.cbge"), hashMap2);
            }
            java.lang.String ah = cn.fly.verify.eh.a(context).d().ah();
            if (!z && android.text.TextUtils.isEmpty(ah)) {
                return null;
            }
            boolean b = b(context);
            hashMap.put(cn.fly.verify.ds.b("004]dcLc*chcb"), ah);
            hashMap.put(cn.fly.verify.ds.b("011$chcbdicfYiiLdcci2he0cb"), java.lang.Boolean.valueOf(b));
            a(ah, b);
            return hashMap;
        }
    }

    private static void a(java.lang.String str, boolean z) {
        java.util.HashMap hashMap = new java.util.HashMap();
        if (!android.text.TextUtils.isEmpty(str)) {
            hashMap.put(cn.fly.verify.ds.b("004]dc.cZchcb"), str);
        }
        hashMap.put(cn.fly.verify.ds.b("009^egcf%ii2dcci_heDcb"), java.lang.Boolean.valueOf(z));
        cn.fly.verify.bl.a().b("all_ds", hashMap);
    }

    public static boolean b(android.content.Context context) {
        if (cn.fly.verify.de.a()) {
            return cn.fly.verify.br.b(context);
        }
        return false;
    }

    public static java.lang.String c(android.content.Context context) {
        return cn.fly.verify.br.c(context);
    }
}
