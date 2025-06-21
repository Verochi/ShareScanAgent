package com.jd.ad.sdk.jad_nw;

@android.annotation.TargetApi(19)
/* loaded from: classes23.dex */
public class jad_ly implements com.jd.ad.sdk.jad_nw.jad_mz, com.jd.ad.sdk.jad_nw.jad_jw {
    public final java.lang.String jad_dq;
    public final com.jd.ad.sdk.jad_sb.jad_iv jad_fs;
    public final android.graphics.Path jad_an = new android.graphics.Path();
    public final android.graphics.Path jad_bo = new android.graphics.Path();
    public final android.graphics.Path jad_cp = new android.graphics.Path();
    public final java.util.List<com.jd.ad.sdk.jad_nw.jad_mz> jad_er = new java.util.ArrayList();

    public jad_ly(com.jd.ad.sdk.jad_sb.jad_iv jad_ivVar) {
        this.jad_dq = jad_ivVar.jad_an();
        this.jad_fs = jad_ivVar;
    }

    @android.annotation.TargetApi(19)
    public final void jad_an(android.graphics.Path.Op op) {
        android.graphics.Matrix matrix;
        android.graphics.Matrix matrix2;
        this.jad_bo.reset();
        this.jad_an.reset();
        for (int size = this.jad_er.size() - 1; size >= 1; size--) {
            com.jd.ad.sdk.jad_nw.jad_mz jad_mzVar = this.jad_er.get(size);
            if (jad_mzVar instanceof com.jd.ad.sdk.jad_nw.jad_dq) {
                com.jd.ad.sdk.jad_nw.jad_dq jad_dqVar = (com.jd.ad.sdk.jad_nw.jad_dq) jad_mzVar;
                java.util.List<com.jd.ad.sdk.jad_nw.jad_mz> jad_dq = jad_dqVar.jad_dq();
                for (int size2 = jad_dq.size() - 1; size2 >= 0; size2--) {
                    android.graphics.Path jad_bo = jad_dq.get(size2).jad_bo();
                    com.jd.ad.sdk.jad_ox.jad_pc jad_pcVar = jad_dqVar.jad_kx;
                    if (jad_pcVar != null) {
                        matrix2 = jad_pcVar.jad_bo();
                    } else {
                        jad_dqVar.jad_cp.reset();
                        matrix2 = jad_dqVar.jad_cp;
                    }
                    jad_bo.transform(matrix2);
                    this.jad_bo.addPath(jad_bo);
                }
            } else {
                this.jad_bo.addPath(jad_mzVar.jad_bo());
            }
        }
        com.jd.ad.sdk.jad_nw.jad_mz jad_mzVar2 = this.jad_er.get(0);
        if (jad_mzVar2 instanceof com.jd.ad.sdk.jad_nw.jad_dq) {
            com.jd.ad.sdk.jad_nw.jad_dq jad_dqVar2 = (com.jd.ad.sdk.jad_nw.jad_dq) jad_mzVar2;
            java.util.List<com.jd.ad.sdk.jad_nw.jad_mz> jad_dq2 = jad_dqVar2.jad_dq();
            for (int i = 0; i < jad_dq2.size(); i++) {
                android.graphics.Path jad_bo2 = jad_dq2.get(i).jad_bo();
                com.jd.ad.sdk.jad_ox.jad_pc jad_pcVar2 = jad_dqVar2.jad_kx;
                if (jad_pcVar2 != null) {
                    matrix = jad_pcVar2.jad_bo();
                } else {
                    jad_dqVar2.jad_cp.reset();
                    matrix = jad_dqVar2.jad_cp;
                }
                jad_bo2.transform(matrix);
                this.jad_an.addPath(jad_bo2);
            }
        } else {
            this.jad_an.set(jad_mzVar2.jad_bo());
        }
        this.jad_cp.op(this.jad_an, this.jad_bo, op);
    }

    @Override // com.jd.ad.sdk.jad_nw.jad_cp
    public void jad_an(java.util.List<com.jd.ad.sdk.jad_nw.jad_cp> list, java.util.List<com.jd.ad.sdk.jad_nw.jad_cp> list2) {
        for (int i = 0; i < this.jad_er.size(); i++) {
            this.jad_er.get(i).jad_an(list, list2);
        }
    }

    @Override // com.jd.ad.sdk.jad_nw.jad_jw
    public void jad_an(java.util.ListIterator<com.jd.ad.sdk.jad_nw.jad_cp> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            com.jd.ad.sdk.jad_nw.jad_cp previous = listIterator.previous();
            if (previous instanceof com.jd.ad.sdk.jad_nw.jad_mz) {
                this.jad_er.add((com.jd.ad.sdk.jad_nw.jad_mz) previous);
                listIterator.remove();
            }
        }
    }

    @Override // com.jd.ad.sdk.jad_nw.jad_mz
    public android.graphics.Path jad_bo() {
        android.graphics.Path.Op op;
        this.jad_cp.reset();
        com.jd.ad.sdk.jad_sb.jad_iv jad_ivVar = this.jad_fs;
        if (jad_ivVar.jad_cp) {
            return this.jad_cp;
        }
        int jad_an = com.jd.ad.sdk.jad_jt.jad_fs.jad_an(jad_ivVar.jad_bo);
        if (jad_an != 0) {
            if (jad_an == 1) {
                op = android.graphics.Path.Op.UNION;
            } else if (jad_an == 2) {
                op = android.graphics.Path.Op.REVERSE_DIFFERENCE;
            } else if (jad_an == 3) {
                op = android.graphics.Path.Op.INTERSECT;
            } else if (jad_an == 4) {
                op = android.graphics.Path.Op.XOR;
            }
            jad_an(op);
        } else {
            for (int i = 0; i < this.jad_er.size(); i++) {
                this.jad_cp.addPath(this.jad_er.get(i).jad_bo());
            }
        }
        return this.jad_cp;
    }

    @Override // com.jd.ad.sdk.jad_nw.jad_cp
    public java.lang.String jad_cp() {
        return this.jad_dq;
    }
}
