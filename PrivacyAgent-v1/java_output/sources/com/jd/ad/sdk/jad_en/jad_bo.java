package com.jd.ad.sdk.jad_en;

/* loaded from: classes23.dex */
public final class jad_bo implements com.jd.ad.sdk.jad_en.jad_fs, com.jd.ad.sdk.jad_en.jad_dq {
    public final java.lang.Object jad_an;

    @androidx.annotation.Nullable
    public final com.jd.ad.sdk.jad_en.jad_fs jad_bo;
    public volatile com.jd.ad.sdk.jad_en.jad_dq jad_cp;
    public volatile com.jd.ad.sdk.jad_en.jad_dq jad_dq;

    @androidx.annotation.GuardedBy("requestLock")
    public int jad_er = 3;

    @androidx.annotation.GuardedBy("requestLock")
    public int jad_fs = 3;

    public jad_bo(java.lang.Object obj, @androidx.annotation.Nullable com.jd.ad.sdk.jad_en.jad_fs jad_fsVar) {
        this.jad_an = obj;
        this.jad_bo = jad_fsVar;
    }

    @Override // com.jd.ad.sdk.jad_en.jad_dq
    public void clear() {
        synchronized (this.jad_an) {
            this.jad_er = 3;
            this.jad_cp.clear();
            if (this.jad_fs != 3) {
                this.jad_fs = 3;
                this.jad_dq.clear();
            }
        }
    }

    @Override // com.jd.ad.sdk.jad_en.jad_dq
    public boolean isRunning() {
        boolean z;
        synchronized (this.jad_an) {
            z = true;
            if (this.jad_er != 1 && this.jad_fs != 1) {
                z = false;
            }
        }
        return z;
    }

    @Override // com.jd.ad.sdk.jad_en.jad_fs, com.jd.ad.sdk.jad_en.jad_dq
    public boolean jad_an() {
        boolean z;
        synchronized (this.jad_an) {
            z = this.jad_cp.jad_an() || this.jad_dq.jad_an();
        }
        return z;
    }

    @Override // com.jd.ad.sdk.jad_en.jad_fs
    public boolean jad_an(com.jd.ad.sdk.jad_en.jad_dq jad_dqVar) {
        boolean z;
        boolean z2;
        synchronized (this.jad_an) {
            com.jd.ad.sdk.jad_en.jad_fs jad_fsVar = this.jad_bo;
            z = false;
            if (jad_fsVar != null && !jad_fsVar.jad_an(this)) {
                z2 = false;
                if (z2 && jad_jt(jad_dqVar)) {
                    z = true;
                }
            }
            z2 = true;
            if (z2) {
                z = true;
            }
        }
        return z;
    }

    @Override // com.jd.ad.sdk.jad_en.jad_fs
    public com.jd.ad.sdk.jad_en.jad_fs jad_bo() {
        com.jd.ad.sdk.jad_en.jad_fs jad_bo;
        synchronized (this.jad_an) {
            com.jd.ad.sdk.jad_en.jad_fs jad_fsVar = this.jad_bo;
            jad_bo = jad_fsVar != null ? jad_fsVar.jad_bo() : this;
        }
        return jad_bo;
    }

    @Override // com.jd.ad.sdk.jad_en.jad_fs
    public boolean jad_bo(com.jd.ad.sdk.jad_en.jad_dq jad_dqVar) {
        boolean z;
        boolean z2;
        synchronized (this.jad_an) {
            com.jd.ad.sdk.jad_en.jad_fs jad_fsVar = this.jad_bo;
            z = false;
            if (jad_fsVar != null && !jad_fsVar.jad_bo(this)) {
                z2 = false;
                if (z2 && jad_jt(jad_dqVar)) {
                    z = true;
                }
            }
            z2 = true;
            if (z2) {
                z = true;
            }
        }
        return z;
    }

    @Override // com.jd.ad.sdk.jad_en.jad_dq
    public boolean jad_cp() {
        boolean z;
        synchronized (this.jad_an) {
            z = this.jad_er == 4 || this.jad_fs == 4;
        }
        return z;
    }

    @Override // com.jd.ad.sdk.jad_en.jad_fs
    public boolean jad_cp(com.jd.ad.sdk.jad_en.jad_dq jad_dqVar) {
        boolean z;
        boolean z2;
        synchronized (this.jad_an) {
            com.jd.ad.sdk.jad_en.jad_fs jad_fsVar = this.jad_bo;
            z = false;
            if (jad_fsVar != null && !jad_fsVar.jad_cp(this)) {
                z2 = false;
                if (z2 && jad_jt(jad_dqVar)) {
                    z = true;
                }
            }
            z2 = true;
            if (z2) {
                z = true;
            }
        }
        return z;
    }

    @Override // com.jd.ad.sdk.jad_en.jad_dq
    public void jad_dq() {
        synchronized (this.jad_an) {
            if (this.jad_er == 1) {
                this.jad_er = 2;
                this.jad_cp.jad_dq();
            }
            if (this.jad_fs == 1) {
                this.jad_fs = 2;
                this.jad_dq.jad_dq();
            }
        }
    }

    @Override // com.jd.ad.sdk.jad_en.jad_fs
    public void jad_dq(com.jd.ad.sdk.jad_en.jad_dq jad_dqVar) {
        synchronized (this.jad_an) {
            if (jad_dqVar.equals(this.jad_cp)) {
                this.jad_er = 4;
            } else if (jad_dqVar.equals(this.jad_dq)) {
                this.jad_fs = 4;
            }
            com.jd.ad.sdk.jad_en.jad_fs jad_fsVar = this.jad_bo;
            if (jad_fsVar != null) {
                jad_fsVar.jad_dq(this);
            }
        }
    }

    @Override // com.jd.ad.sdk.jad_en.jad_dq
    public boolean jad_er() {
        boolean z;
        synchronized (this.jad_an) {
            z = this.jad_er == 3 && this.jad_fs == 3;
        }
        return z;
    }

    @Override // com.jd.ad.sdk.jad_en.jad_dq
    public boolean jad_er(com.jd.ad.sdk.jad_en.jad_dq jad_dqVar) {
        if (!(jad_dqVar instanceof com.jd.ad.sdk.jad_en.jad_bo)) {
            return false;
        }
        com.jd.ad.sdk.jad_en.jad_bo jad_boVar = (com.jd.ad.sdk.jad_en.jad_bo) jad_dqVar;
        return this.jad_cp.jad_er(jad_boVar.jad_cp) && this.jad_dq.jad_er(jad_boVar.jad_dq);
    }

    @Override // com.jd.ad.sdk.jad_en.jad_dq
    public void jad_fs() {
        synchronized (this.jad_an) {
            if (this.jad_er != 1) {
                this.jad_er = 1;
                this.jad_cp.jad_fs();
            }
        }
    }

    @Override // com.jd.ad.sdk.jad_en.jad_fs
    public void jad_fs(com.jd.ad.sdk.jad_en.jad_dq jad_dqVar) {
        synchronized (this.jad_an) {
            if (jad_dqVar.equals(this.jad_dq)) {
                this.jad_fs = 5;
                com.jd.ad.sdk.jad_en.jad_fs jad_fsVar = this.jad_bo;
                if (jad_fsVar != null) {
                    jad_fsVar.jad_fs(this);
                }
                return;
            }
            this.jad_er = 5;
            if (this.jad_fs != 1) {
                this.jad_fs = 1;
                this.jad_dq.jad_fs();
            }
        }
    }

    @androidx.annotation.GuardedBy("requestLock")
    public final boolean jad_jt(com.jd.ad.sdk.jad_en.jad_dq jad_dqVar) {
        return jad_dqVar.equals(this.jad_cp) || (this.jad_er == 5 && jad_dqVar.equals(this.jad_dq));
    }
}
