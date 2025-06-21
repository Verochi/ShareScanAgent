package com.anythink.expressad.reward.a;

/* loaded from: classes12.dex */
public final class e implements com.anythink.expressad.e.b {
    private static final java.lang.String a = "RewardUnitCacheManager";
    private java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.expressad.videocommon.e.d> b;

    public static final class a {
        private static final com.anythink.expressad.reward.a.e a = new com.anythink.expressad.reward.a.e((byte) 0);

        private a() {
        }
    }

    private e() {
        this.b = new java.util.concurrent.ConcurrentHashMap<>();
    }

    public /* synthetic */ e(byte b) {
        this();
    }

    public static com.anythink.expressad.reward.a.e a() {
        return com.anythink.expressad.reward.a.e.a.a;
    }

    public final com.anythink.expressad.videocommon.e.d a(java.lang.String str, java.lang.String str2) {
        try {
            try {
                return this.b.remove(str + "_" + str2);
            } catch (java.lang.Exception e) {
                e.getMessage();
                return null;
            }
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public final void a(java.lang.String str, java.lang.String str2, com.anythink.expressad.videocommon.e.d dVar) {
        try {
            java.lang.String str3 = str + "_" + str2;
            if (dVar != null && this.b.containsKey(str3)) {
                this.b.remove(str3);
            }
            this.b.put(str3, dVar);
        } catch (java.lang.Exception e) {
            e.getMessage();
        }
    }
}
