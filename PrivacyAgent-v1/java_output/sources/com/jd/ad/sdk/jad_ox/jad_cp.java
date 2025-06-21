package com.jd.ad.sdk.jad_ox;

/* loaded from: classes23.dex */
public class jad_cp implements com.jd.ad.sdk.jad_ox.jad_an.InterfaceC0397jad_an {
    public final com.jd.ad.sdk.jad_ox.jad_an.InterfaceC0397jad_an jad_an;
    public final com.jd.ad.sdk.jad_ox.jad_an<java.lang.Integer, java.lang.Integer> jad_bo;
    public final com.jd.ad.sdk.jad_ox.jad_an<java.lang.Float, java.lang.Float> jad_cp;
    public final com.jd.ad.sdk.jad_ox.jad_an<java.lang.Float, java.lang.Float> jad_dq;
    public final com.jd.ad.sdk.jad_ox.jad_an<java.lang.Float, java.lang.Float> jad_er;
    public final com.jd.ad.sdk.jad_ox.jad_an<java.lang.Float, java.lang.Float> jad_fs;
    public boolean jad_jt = true;

    public class jad_an extends com.jd.ad.sdk.jad_yh.jad_cp<java.lang.Float> {
        public final /* synthetic */ com.jd.ad.sdk.jad_yh.jad_cp jad_cp;

        public jad_an(com.jd.ad.sdk.jad_ox.jad_cp jad_cpVar, com.jd.ad.sdk.jad_yh.jad_cp jad_cpVar2) {
            this.jad_cp = jad_cpVar2;
        }

        @Override // com.jd.ad.sdk.jad_yh.jad_cp
        @androidx.annotation.Nullable
        public java.lang.Float jad_an(com.jd.ad.sdk.jad_yh.jad_bo<java.lang.Float> jad_boVar) {
            java.lang.Float f = (java.lang.Float) this.jad_cp.jad_an(jad_boVar);
            if (f == null) {
                return null;
            }
            return java.lang.Float.valueOf(f.floatValue() * 2.55f);
        }
    }

    public jad_cp(com.jd.ad.sdk.jad_ox.jad_an.InterfaceC0397jad_an interfaceC0397jad_an, com.jd.ad.sdk.jad_tc.jad_an jad_anVar, com.jd.ad.sdk.jad_ve.jad_jw jad_jwVar) {
        this.jad_an = interfaceC0397jad_an;
        com.jd.ad.sdk.jad_ox.jad_an<java.lang.Integer, java.lang.Integer> jad_an2 = jad_jwVar.jad_an().jad_an();
        this.jad_bo = jad_an2;
        jad_an2.jad_an(this);
        jad_anVar.jad_an(jad_an2);
        com.jd.ad.sdk.jad_ox.jad_an<java.lang.Float, java.lang.Float> jad_an3 = jad_jwVar.jad_dq().jad_an();
        this.jad_cp = jad_an3;
        jad_an3.jad_an(this);
        jad_anVar.jad_an(jad_an3);
        com.jd.ad.sdk.jad_ox.jad_an<java.lang.Float, java.lang.Float> jad_an4 = jad_jwVar.jad_bo().jad_an();
        this.jad_dq = jad_an4;
        jad_an4.jad_an(this);
        jad_anVar.jad_an(jad_an4);
        com.jd.ad.sdk.jad_ox.jad_an<java.lang.Float, java.lang.Float> jad_an5 = jad_jwVar.jad_cp().jad_an();
        this.jad_er = jad_an5;
        jad_an5.jad_an(this);
        jad_anVar.jad_an(jad_an5);
        com.jd.ad.sdk.jad_ox.jad_an<java.lang.Float, java.lang.Float> jad_an6 = jad_jwVar.jad_er().jad_an();
        this.jad_fs = jad_an6;
        jad_an6.jad_an(this);
        jad_anVar.jad_an(jad_an6);
    }

    @Override // com.jd.ad.sdk.jad_ox.jad_an.InterfaceC0397jad_an
    public void jad_an() {
        this.jad_jt = true;
        this.jad_an.jad_an();
    }

    public void jad_an(android.graphics.Paint paint) {
        if (this.jad_jt) {
            this.jad_jt = false;
            double floatValue = this.jad_dq.jad_fs().floatValue() * 0.017453292519943295d;
            float floatValue2 = this.jad_er.jad_fs().floatValue();
            float sin = ((float) java.lang.Math.sin(floatValue)) * floatValue2;
            float cos = ((float) java.lang.Math.cos(floatValue + 3.141592653589793d)) * floatValue2;
            int intValue = this.jad_bo.jad_fs().intValue();
            paint.setShadowLayer(this.jad_fs.jad_fs().floatValue(), sin, cos, android.graphics.Color.argb(java.lang.Math.round(this.jad_cp.jad_fs().floatValue()), android.graphics.Color.red(intValue), android.graphics.Color.green(intValue), android.graphics.Color.blue(intValue)));
        }
    }

    public void jad_an(@androidx.annotation.Nullable com.jd.ad.sdk.jad_yh.jad_cp<java.lang.Float> jad_cpVar) {
        if (jad_cpVar == null) {
            this.jad_cp.jad_er = null;
        } else {
            this.jad_cp.jad_er = new com.jd.ad.sdk.jad_ox.jad_cp.jad_an(this, jad_cpVar);
        }
    }
}
