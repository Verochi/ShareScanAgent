package com.alimm.tanx.core.ad.ad.template.rendering.reward;

/* loaded from: classes.dex */
public class tanxc_if {
    public static java.util.LinkedHashMap<java.lang.String, com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_if> tanxc_do = new com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardGlobal$1(3);
    public static volatile com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_try tanxc_if;

    public static void tanxc_do() {
        try {
            tanxc_if = null;
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e(e);
        }
    }

    public static void tanxc_do(java.lang.String str) {
        try {
            java.util.Iterator<java.lang.String> it = tanxc_do.keySet().iterator();
            while (it.hasNext()) {
                if (it.next().equalsIgnoreCase(str)) {
                    it.remove();
                    return;
                }
            }
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e(e);
        }
    }
}
