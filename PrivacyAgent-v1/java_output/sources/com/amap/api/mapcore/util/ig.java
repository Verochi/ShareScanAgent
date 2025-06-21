package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class ig extends com.amap.api.mapcore.util.Cif {
    private android.content.Context a;
    private boolean b;

    public ig(android.content.Context context, boolean z) {
        this.a = context;
        this.b = z;
    }

    @Override // com.amap.api.mapcore.util.Cif
    public final boolean c() {
        return com.amap.api.mapcore.util.ez.n(this.a) == 1 || this.b;
    }
}
