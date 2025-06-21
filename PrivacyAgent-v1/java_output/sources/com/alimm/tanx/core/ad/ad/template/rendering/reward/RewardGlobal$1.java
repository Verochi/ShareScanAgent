package com.alimm.tanx.core.ad.ad.template.rendering.reward;

/* loaded from: classes.dex */
public class RewardGlobal$1 extends java.util.LinkedHashMap<java.lang.String, com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_if> {
    public RewardGlobal$1(int i) {
        super(i);
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(java.util.Map.Entry<java.lang.String, com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_if> entry) {
        return com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_if.tanxc_do.size() > 3;
    }
}
