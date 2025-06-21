package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class ag extends com.amap.api.mapcore.util.af {

    public static abstract class a implements com.amap.api.mapcore.util.af.a {
        @Override // com.amap.api.mapcore.util.af.a
        public final boolean a(com.amap.api.mapcore.util.af afVar) {
            return a((com.amap.api.mapcore.util.ag) afVar);
        }

        public abstract boolean a(com.amap.api.mapcore.util.ag agVar);

        @Override // com.amap.api.mapcore.util.af.a
        public final boolean b(com.amap.api.mapcore.util.af afVar) {
            return b((com.amap.api.mapcore.util.ag) afVar);
        }

        public abstract boolean b(com.amap.api.mapcore.util.ag agVar);

        @Override // com.amap.api.mapcore.util.af.a
        public final void c(com.amap.api.mapcore.util.af afVar) {
            c((com.amap.api.mapcore.util.ag) afVar);
        }

        public abstract void c(com.amap.api.mapcore.util.ag agVar);
    }

    public ag(android.content.Context context, com.amap.api.mapcore.util.ag.a aVar) {
        super(context, aVar);
    }

    public final float j() {
        return (float) (((java.lang.Math.atan2(g(), f()) - java.lang.Math.atan2(e(), d())) * 180.0d) / 3.141592653589793d);
    }
}
