package com.igexin.push;

/* loaded from: classes.dex */
public class SdkSource extends com.getui.gtc.dim.DimSource {
    public static final com.igexin.push.SdkSource INSTANCE = new com.igexin.push.SdkSource();

    private SdkSource() {
    }

    @Override // com.getui.gtc.dim.DimSource
    public <P, V> V get(P p, com.getui.gtc.dim.DimCallback<P, V> dimCallback) {
        com.igexin.c.a.c.a.b("SdkSource", "dim sys call from push");
        if (dimCallback != null) {
            return dimCallback.get(p);
        }
        return null;
    }
}
