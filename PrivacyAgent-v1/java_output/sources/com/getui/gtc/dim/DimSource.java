package com.getui.gtc.dim;

/* loaded from: classes22.dex */
public abstract class DimSource {
    private static final java.util.HashMap<com.getui.gtc.dim.Caller, com.getui.gtc.dim.DimSource> SOURCE_MAP = new java.util.HashMap<>(4);

    public static synchronized com.getui.gtc.dim.DimSource of(com.getui.gtc.dim.Caller caller) {
        synchronized (com.getui.gtc.dim.DimSource.class) {
            java.lang.String str = null;
            if (caller != null) {
                if (caller != com.getui.gtc.dim.Caller.UNKNOWN) {
                    java.util.HashMap<com.getui.gtc.dim.Caller, com.getui.gtc.dim.DimSource> hashMap = SOURCE_MAP;
                    if (hashMap.containsKey(caller)) {
                        return hashMap.get(caller);
                    }
                    if (caller == com.getui.gtc.dim.Caller.PUSH) {
                        str = "Y29tLmlnZXhpbi5wdXNo";
                    } else if (caller == com.getui.gtc.dim.Caller.IDO) {
                        str = "Y29tLmdldHVpLmdz";
                    } else if (caller == com.getui.gtc.dim.Caller.GY) {
                        str = "Y29tLmcuZ3lzZGs=";
                    } else if (caller == com.getui.gtc.dim.Caller.WUS) {
                        str = "Y29tLnNkay5wbHVz";
                    } else if (caller == com.getui.gtc.dim.Caller.ONEID) {
                        str = "Y29tLmdldHVpLm9uZWlk";
                    }
                    com.getui.gtc.dim.DimSource of = of(str);
                    hashMap.put(caller, of);
                    return of;
                }
            }
            return null;
        }
    }

    private static com.getui.gtc.dim.DimSource of(java.lang.String str) {
        try {
            return (com.getui.gtc.dim.DimSource) java.lang.Class.forName(new java.lang.String(android.util.Base64.decode(str, 0)) + ".SdkSource").getDeclaredField("INSTANCE").get(null);
        } catch (java.lang.Throwable th) {
            com.getui.gtc.dim.e.b.b(th);
            return null;
        }
    }

    public abstract <P, V> V get(P p, com.getui.gtc.dim.DimCallback<P, V> dimCallback);
}
