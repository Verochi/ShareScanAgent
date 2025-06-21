package com.alimm.tanx.core.ad.interaction;

/* loaded from: classes.dex */
public class tanxc_do {
    private com.alimm.tanx.core.ad.interaction.AdClickHandler tanxc_do;
    private java.util.Map<java.lang.String, java.lang.String> tanxc_if;

    /* renamed from: com.alimm.tanx.core.ad.interaction.tanxc_do$tanxc_do, reason: collision with other inner class name */
    public static class C0023tanxc_do {
        private static final com.alimm.tanx.core.ad.interaction.tanxc_do tanxc_do = new com.alimm.tanx.core.ad.interaction.tanxc_do((byte) 0);
    }

    private tanxc_do() {
        this.tanxc_if = new java.util.concurrent.ConcurrentHashMap(16);
        this.tanxc_do = new com.alimm.tanx.core.ad.interaction.AdClickHandler();
    }

    public /* synthetic */ tanxc_do(byte b) {
        this();
    }

    public static com.alimm.tanx.core.ad.interaction.tanxc_do tanxc_do() {
        return com.alimm.tanx.core.ad.interaction.tanxc_do.C0023tanxc_do.tanxc_do;
    }

    public java.lang.String tanxc_do(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        this.tanxc_if.remove(str);
        return str;
    }

    public void tanxc_do(android.content.Context context, com.alimm.tanx.core.ad.interaction.AdClickInfo adClickInfo, boolean z) {
        tanxc_do(context, adClickInfo, false, z);
    }

    public void tanxc_do(android.content.Context context, com.alimm.tanx.core.ad.interaction.AdClickInfo adClickInfo, boolean z, boolean z2) {
        this.tanxc_if.clear();
        this.tanxc_do.handleClickAndUt(context, adClickInfo, z, z2);
    }

    public void tanxc_do(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            return;
        }
        this.tanxc_if.put(str, str2);
    }
}
