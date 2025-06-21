package com.getui.gs;

/* loaded from: classes22.dex */
public class SdkSource extends com.getui.gtc.dim.DimSource {
    public static final com.getui.gs.SdkSource INSTANCE = new com.getui.gs.SdkSource();

    private SdkSource() {
    }

    @Override // com.getui.gtc.dim.DimSource
    public <P, V> V get(P p, com.getui.gtc.dim.DimCallback<P, V> dimCallback) {
        com.getui.gs.h.b.a.a.a.d("dim sys call from ido");
        if (dimCallback != null) {
            return dimCallback.get(p);
        }
        return null;
    }
}
