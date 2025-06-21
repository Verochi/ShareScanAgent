package com.jd.ad.sdk.jad_wf;

/* loaded from: classes23.dex */
public final class jad_fs extends com.jd.ad.sdk.jad_wf.jad_cp {
    public static final com.jd.ad.sdk.jad_hk.jad_cp jad_ly = com.jd.ad.sdk.jad_hk.jad_cp.jad_an("'\\");
    public static final com.jd.ad.sdk.jad_hk.jad_cp jad_mz = com.jd.ad.sdk.jad_hk.jad_cp.jad_an("\"\\");
    public static final com.jd.ad.sdk.jad_hk.jad_cp jad_na = com.jd.ad.sdk.jad_hk.jad_cp.jad_an("{}[]:, \n\t\r\f/\\;#=");
    public static final com.jd.ad.sdk.jad_hk.jad_cp jad_ob = com.jd.ad.sdk.jad_hk.jad_cp.jad_an("\n\r");
    public static final com.jd.ad.sdk.jad_hk.jad_cp jad_pc = com.jd.ad.sdk.jad_hk.jad_cp.jad_an("*/");
    public final com.jd.ad.sdk.jad_hk.jad_bo jad_fs;
    public int jad_hu = 0;
    public long jad_iv;
    public final com.jd.ad.sdk.jad_hk.jad_an jad_jt;
    public int jad_jw;

    @androidx.annotation.Nullable
    public java.lang.String jad_kx;

    public jad_fs(com.jd.ad.sdk.jad_hk.jad_bo jad_boVar) {
        if (jad_boVar == null) {
            throw new java.lang.NullPointerException("source == null");
        }
        this.jad_fs = jad_boVar;
        this.jad_jt = jad_boVar.jad_an();
        jad_an(6);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.jad_hu = 0;
        this.jad_bo[0] = 8;
        this.jad_an = 1;
        com.jd.ad.sdk.jad_hk.jad_an jad_anVar = this.jad_jt;
        jad_anVar.getClass();
        try {
            jad_anVar.jad_dq(jad_anVar.jad_bo);
            this.jad_fs.close();
        } catch (java.io.EOFException e) {
            throw new java.lang.AssertionError(e);
        }
    }

    @Override // com.jd.ad.sdk.jad_wf.jad_cp
    public int jad_an(com.jd.ad.sdk.jad_wf.jad_cp.jad_an jad_anVar) {
        int i = this.jad_hu;
        if (i == 0) {
            i = jad_qd();
        }
        if (i < 12 || i > 15) {
            return -1;
        }
        if (i == 15) {
            return jad_an(this.jad_kx, jad_anVar);
        }
        int jad_an = this.jad_fs.jad_an(jad_anVar.jad_bo);
        if (jad_an != -1) {
            this.jad_hu = 0;
            this.jad_cp[this.jad_an - 1] = jad_anVar.jad_an[jad_an];
            return jad_an;
        }
        java.lang.String str = this.jad_cp[this.jad_an - 1];
        java.lang.String jad_kx = jad_kx();
        int jad_an2 = jad_an(jad_kx, jad_anVar);
        if (jad_an2 == -1) {
            this.jad_hu = 15;
            this.jad_kx = jad_kx;
            this.jad_cp[this.jad_an - 1] = str;
        }
        return jad_an2;
    }

    public final int jad_an(java.lang.String str, com.jd.ad.sdk.jad_wf.jad_cp.jad_an jad_anVar) {
        int length = jad_anVar.jad_an.length;
        for (int i = 0; i < length; i++) {
            if (str.equals(jad_anVar.jad_an[i])) {
                this.jad_hu = 0;
                this.jad_cp[this.jad_an - 1] = str;
                return i;
            }
        }
        return -1;
    }

    public final int jad_an(boolean z) {
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!this.jad_fs.jad_an(i2)) {
                if (z) {
                    throw new java.io.EOFException("End of input");
                }
                return -1;
            }
            byte jad_bo = this.jad_jt.jad_bo(i);
            if (jad_bo != 10 && jad_bo != 32 && jad_bo != 13 && jad_bo != 9) {
                this.jad_jt.jad_dq(i2 - 1);
                if (jad_bo == 47) {
                    if (!this.jad_fs.jad_an(2L)) {
                        return jad_bo;
                    }
                    jad_pc();
                    throw null;
                }
                if (jad_bo != 35) {
                    return jad_bo;
                }
                jad_pc();
                throw null;
            }
            i = i2;
        }
    }

    public final java.lang.String jad_bo(com.jd.ad.sdk.jad_hk.jad_cp jad_cpVar) {
        java.lang.StringBuilder sb = null;
        while (true) {
            long jad_an = this.jad_fs.jad_an(jad_cpVar);
            if (jad_an == -1) {
                jad_an("Unterminated string");
                throw null;
            }
            if (this.jad_jt.jad_bo(jad_an) != 92) {
                if (sb == null) {
                    com.jd.ad.sdk.jad_hk.jad_an jad_anVar = this.jad_jt;
                    jad_anVar.getClass();
                    java.lang.String jad_an2 = jad_anVar.jad_an(jad_an, com.jd.ad.sdk.jad_hk.jad_ob.jad_an);
                    this.jad_jt.jad_bo();
                    return jad_an2;
                }
                com.jd.ad.sdk.jad_hk.jad_an jad_anVar2 = this.jad_jt;
                jad_anVar2.getClass();
                sb.append(jad_anVar2.jad_an(jad_an, com.jd.ad.sdk.jad_hk.jad_ob.jad_an));
                this.jad_jt.jad_bo();
                return sb.toString();
            }
            if (sb == null) {
                sb = new java.lang.StringBuilder();
            }
            com.jd.ad.sdk.jad_hk.jad_an jad_anVar3 = this.jad_jt;
            jad_anVar3.getClass();
            sb.append(jad_anVar3.jad_an(jad_an, com.jd.ad.sdk.jad_hk.jad_ob.jad_an));
            this.jad_jt.jad_bo();
            sb.append(jad_sf());
        }
    }

    @Override // com.jd.ad.sdk.jad_wf.jad_cp
    public void jad_bo() {
        int i = this.jad_hu;
        if (i == 0) {
            i = jad_qd();
        }
        if (i == 3) {
            jad_an(1);
            this.jad_dq[this.jad_an - 1] = 0;
            this.jad_hu = 0;
        } else {
            java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_lu.jad_zm.jad_an("Expected BEGIN_ARRAY but was ");
            jad_an.append(com.jd.ad.sdk.jad_wf.jad_dq.jad_an(jad_mz()));
            jad_an.append(" at path ");
            throw new com.jd.ad.sdk.jad_wf.jad_an(com.jd.ad.sdk.jad_wf.jad_er.jad_an(this, jad_an));
        }
    }

    public final boolean jad_bo(int i) {
        if (i == 9 || i == 10 || i == 12 || i == 13 || i == 32) {
            return false;
        }
        if (i != 35) {
            if (i == 44) {
                return false;
            }
            if (i != 47 && i != 61) {
                if (i == 123 || i == 125 || i == 58) {
                    return false;
                }
                if (i != 59) {
                    switch (i) {
                        case 91:
                        case 93:
                            return false;
                        case 92:
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        jad_pc();
        throw null;
    }

    @Override // com.jd.ad.sdk.jad_wf.jad_cp
    public void jad_cp() {
        int i = this.jad_hu;
        if (i == 0) {
            i = jad_qd();
        }
        if (i == 1) {
            jad_an(3);
            this.jad_hu = 0;
        } else {
            java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_lu.jad_zm.jad_an("Expected BEGIN_OBJECT but was ");
            jad_an.append(com.jd.ad.sdk.jad_wf.jad_dq.jad_an(jad_mz()));
            jad_an.append(" at path ");
            throw new com.jd.ad.sdk.jad_wf.jad_an(com.jd.ad.sdk.jad_wf.jad_er.jad_an(this, jad_an));
        }
    }

    public final void jad_cp(com.jd.ad.sdk.jad_hk.jad_cp jad_cpVar) {
        while (true) {
            long jad_an = this.jad_fs.jad_an(jad_cpVar);
            if (jad_an == -1) {
                jad_an("Unterminated string");
                throw null;
            }
            if (this.jad_jt.jad_bo(jad_an) != 92) {
                this.jad_jt.jad_dq(jad_an + 1);
                return;
            } else {
                this.jad_jt.jad_dq(jad_an + 1);
                jad_sf();
            }
        }
    }

    @Override // com.jd.ad.sdk.jad_wf.jad_cp
    public void jad_dq() {
        int i = this.jad_hu;
        if (i == 0) {
            i = jad_qd();
        }
        if (i != 4) {
            java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_lu.jad_zm.jad_an("Expected END_ARRAY but was ");
            jad_an.append(com.jd.ad.sdk.jad_wf.jad_dq.jad_an(jad_mz()));
            jad_an.append(" at path ");
            throw new com.jd.ad.sdk.jad_wf.jad_an(com.jd.ad.sdk.jad_wf.jad_er.jad_an(this, jad_an));
        }
        int i2 = this.jad_an - 1;
        this.jad_an = i2;
        int[] iArr = this.jad_dq;
        int i3 = i2 - 1;
        iArr[i3] = iArr[i3] + 1;
        this.jad_hu = 0;
    }

    @Override // com.jd.ad.sdk.jad_wf.jad_cp
    public void jad_er() {
        int i = this.jad_hu;
        if (i == 0) {
            i = jad_qd();
        }
        if (i != 2) {
            java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_lu.jad_zm.jad_an("Expected END_OBJECT but was ");
            jad_an.append(com.jd.ad.sdk.jad_wf.jad_dq.jad_an(jad_mz()));
            jad_an.append(" at path ");
            throw new com.jd.ad.sdk.jad_wf.jad_an(com.jd.ad.sdk.jad_wf.jad_er.jad_an(this, jad_an));
        }
        int i2 = this.jad_an - 1;
        this.jad_an = i2;
        this.jad_cp[i2] = null;
        int[] iArr = this.jad_dq;
        int i3 = i2 - 1;
        iArr[i3] = iArr[i3] + 1;
        this.jad_hu = 0;
    }

    @Override // com.jd.ad.sdk.jad_wf.jad_cp
    public boolean jad_hu() {
        int i = this.jad_hu;
        if (i == 0) {
            i = jad_qd();
        }
        if (i == 5) {
            this.jad_hu = 0;
            int[] iArr = this.jad_dq;
            int i2 = this.jad_an - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        }
        if (i != 6) {
            java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_lu.jad_zm.jad_an("Expected a boolean but was ");
            jad_an.append(com.jd.ad.sdk.jad_wf.jad_dq.jad_an(jad_mz()));
            jad_an.append(" at path ");
            throw new com.jd.ad.sdk.jad_wf.jad_an(com.jd.ad.sdk.jad_wf.jad_er.jad_an(this, jad_an));
        }
        this.jad_hu = 0;
        int[] iArr2 = this.jad_dq;
        int i3 = this.jad_an - 1;
        iArr2[i3] = iArr2[i3] + 1;
        return false;
    }

    @Override // com.jd.ad.sdk.jad_wf.jad_cp
    public double jad_iv() {
        java.lang.String jad_re;
        com.jd.ad.sdk.jad_hk.jad_cp jad_cpVar;
        double parseDouble;
        int i = this.jad_hu;
        if (i == 0) {
            i = jad_qd();
        }
        if (i == 16) {
            this.jad_hu = 0;
            int[] iArr = this.jad_dq;
            int i2 = this.jad_an - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.jad_iv;
        }
        try {
            if (i == 17) {
                com.jd.ad.sdk.jad_hk.jad_an jad_anVar = this.jad_jt;
                long j = this.jad_jw;
                jad_anVar.getClass();
                jad_re = jad_anVar.jad_an(j, com.jd.ad.sdk.jad_hk.jad_ob.jad_an);
            } else {
                if (i == 9) {
                    jad_cpVar = jad_mz;
                } else if (i == 8) {
                    jad_cpVar = jad_ly;
                } else {
                    if (i != 10) {
                        if (i != 11) {
                            java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_lu.jad_zm.jad_an("Expected a double but was ");
                            jad_an.append(com.jd.ad.sdk.jad_wf.jad_dq.jad_an(jad_mz()));
                            jad_an.append(" at path ");
                            throw new com.jd.ad.sdk.jad_wf.jad_an(com.jd.ad.sdk.jad_wf.jad_er.jad_an(this, jad_an));
                        }
                        this.jad_hu = 11;
                        parseDouble = java.lang.Double.parseDouble(this.jad_kx);
                        if (!java.lang.Double.isNaN(parseDouble) || java.lang.Double.isInfinite(parseDouble)) {
                            java.lang.StringBuilder sb = new java.lang.StringBuilder();
                            sb.append("JSON forbids NaN and infinities: ");
                            sb.append(parseDouble);
                            sb.append(" at path ");
                            throw new com.jd.ad.sdk.jad_wf.jad_bo(com.jd.ad.sdk.jad_wf.jad_er.jad_an(this, sb));
                        }
                        this.jad_kx = null;
                        this.jad_hu = 0;
                        int[] iArr2 = this.jad_dq;
                        int i3 = this.jad_an - 1;
                        iArr2[i3] = iArr2[i3] + 1;
                        return parseDouble;
                    }
                    jad_re = jad_re();
                }
                jad_re = jad_bo(jad_cpVar);
            }
            parseDouble = java.lang.Double.parseDouble(this.jad_kx);
            if (java.lang.Double.isNaN(parseDouble)) {
            }
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append("JSON forbids NaN and infinities: ");
            sb2.append(parseDouble);
            sb2.append(" at path ");
            throw new com.jd.ad.sdk.jad_wf.jad_bo(com.jd.ad.sdk.jad_wf.jad_er.jad_an(this, sb2));
        } catch (java.lang.NumberFormatException unused) {
            java.lang.StringBuilder jad_an2 = com.jd.ad.sdk.jad_lu.jad_zm.jad_an("Expected a double but was ");
            jad_an2.append(this.jad_kx);
            jad_an2.append(" at path ");
            throw new com.jd.ad.sdk.jad_wf.jad_an(com.jd.ad.sdk.jad_wf.jad_er.jad_an(this, jad_an2));
        }
        this.jad_kx = jad_re;
        this.jad_hu = 11;
    }

    @Override // com.jd.ad.sdk.jad_wf.jad_cp
    public boolean jad_jt() {
        int i = this.jad_hu;
        if (i == 0) {
            i = jad_qd();
        }
        return (i == 2 || i == 4 || i == 18) ? false : true;
    }

    @Override // com.jd.ad.sdk.jad_wf.jad_cp
    public int jad_jw() {
        int i = this.jad_hu;
        if (i == 0) {
            i = jad_qd();
        }
        if (i == 16) {
            long j = this.jad_iv;
            int i2 = (int) j;
            if (j != i2) {
                java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_lu.jad_zm.jad_an("Expected an int but was ");
                jad_an.append(this.jad_iv);
                jad_an.append(" at path ");
                throw new com.jd.ad.sdk.jad_wf.jad_an(com.jd.ad.sdk.jad_wf.jad_er.jad_an(this, jad_an));
            }
            this.jad_hu = 0;
            int[] iArr = this.jad_dq;
            int i3 = this.jad_an - 1;
            iArr[i3] = iArr[i3] + 1;
            return i2;
        }
        if (i == 17) {
            com.jd.ad.sdk.jad_hk.jad_an jad_anVar = this.jad_jt;
            long j2 = this.jad_jw;
            jad_anVar.getClass();
            this.jad_kx = jad_anVar.jad_an(j2, com.jd.ad.sdk.jad_hk.jad_ob.jad_an);
        } else if (i == 9 || i == 8) {
            java.lang.String jad_bo = jad_bo(i == 9 ? jad_mz : jad_ly);
            this.jad_kx = jad_bo;
            try {
                int parseInt = java.lang.Integer.parseInt(jad_bo);
                this.jad_hu = 0;
                int[] iArr2 = this.jad_dq;
                int i4 = this.jad_an - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseInt;
            } catch (java.lang.NumberFormatException unused) {
            }
        } else if (i != 11) {
            java.lang.StringBuilder jad_an2 = com.jd.ad.sdk.jad_lu.jad_zm.jad_an("Expected an int but was ");
            jad_an2.append(com.jd.ad.sdk.jad_wf.jad_dq.jad_an(jad_mz()));
            jad_an2.append(" at path ");
            throw new com.jd.ad.sdk.jad_wf.jad_an(com.jd.ad.sdk.jad_wf.jad_er.jad_an(this, jad_an2));
        }
        this.jad_hu = 11;
        try {
            double parseDouble = java.lang.Double.parseDouble(this.jad_kx);
            int i5 = (int) parseDouble;
            if (i5 != parseDouble) {
                java.lang.StringBuilder jad_an3 = com.jd.ad.sdk.jad_lu.jad_zm.jad_an("Expected an int but was ");
                jad_an3.append(this.jad_kx);
                jad_an3.append(" at path ");
                throw new com.jd.ad.sdk.jad_wf.jad_an(com.jd.ad.sdk.jad_wf.jad_er.jad_an(this, jad_an3));
            }
            this.jad_kx = null;
            this.jad_hu = 0;
            int[] iArr3 = this.jad_dq;
            int i6 = this.jad_an - 1;
            iArr3[i6] = iArr3[i6] + 1;
            return i5;
        } catch (java.lang.NumberFormatException unused2) {
            java.lang.StringBuilder jad_an4 = com.jd.ad.sdk.jad_lu.jad_zm.jad_an("Expected an int but was ");
            jad_an4.append(this.jad_kx);
            jad_an4.append(" at path ");
            throw new com.jd.ad.sdk.jad_wf.jad_an(com.jd.ad.sdk.jad_wf.jad_er.jad_an(this, jad_an4));
        }
    }

    @Override // com.jd.ad.sdk.jad_wf.jad_cp
    public java.lang.String jad_kx() {
        java.lang.String str;
        com.jd.ad.sdk.jad_hk.jad_cp jad_cpVar;
        int i = this.jad_hu;
        if (i == 0) {
            i = jad_qd();
        }
        if (i == 14) {
            str = jad_re();
        } else {
            if (i == 13) {
                jad_cpVar = jad_mz;
            } else if (i == 12) {
                jad_cpVar = jad_ly;
            } else {
                if (i != 15) {
                    java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_lu.jad_zm.jad_an("Expected a name but was ");
                    jad_an.append(com.jd.ad.sdk.jad_wf.jad_dq.jad_an(jad_mz()));
                    jad_an.append(" at path ");
                    throw new com.jd.ad.sdk.jad_wf.jad_an(com.jd.ad.sdk.jad_wf.jad_er.jad_an(this, jad_an));
                }
                str = this.jad_kx;
            }
            str = jad_bo(jad_cpVar);
        }
        this.jad_hu = 0;
        this.jad_cp[this.jad_an - 1] = str;
        return str;
    }

    @Override // com.jd.ad.sdk.jad_wf.jad_cp
    public java.lang.String jad_ly() {
        java.lang.String jad_an;
        com.jd.ad.sdk.jad_hk.jad_cp jad_cpVar;
        int i = this.jad_hu;
        if (i == 0) {
            i = jad_qd();
        }
        if (i == 10) {
            jad_an = jad_re();
        } else {
            if (i == 9) {
                jad_cpVar = jad_mz;
            } else if (i == 8) {
                jad_cpVar = jad_ly;
            } else if (i == 11) {
                jad_an = this.jad_kx;
                this.jad_kx = null;
            } else if (i == 16) {
                jad_an = java.lang.Long.toString(this.jad_iv);
            } else {
                if (i != 17) {
                    java.lang.StringBuilder jad_an2 = com.jd.ad.sdk.jad_lu.jad_zm.jad_an("Expected a string but was ");
                    jad_an2.append(com.jd.ad.sdk.jad_wf.jad_dq.jad_an(jad_mz()));
                    jad_an2.append(" at path ");
                    throw new com.jd.ad.sdk.jad_wf.jad_an(com.jd.ad.sdk.jad_wf.jad_er.jad_an(this, jad_an2));
                }
                com.jd.ad.sdk.jad_hk.jad_an jad_anVar = this.jad_jt;
                long j = this.jad_jw;
                jad_anVar.getClass();
                jad_an = jad_anVar.jad_an(j, com.jd.ad.sdk.jad_hk.jad_ob.jad_an);
            }
            jad_an = jad_bo(jad_cpVar);
        }
        this.jad_hu = 0;
        int[] iArr = this.jad_dq;
        int i2 = this.jad_an - 1;
        iArr[i2] = iArr[i2] + 1;
        return jad_an;
    }

    @Override // com.jd.ad.sdk.jad_wf.jad_cp
    public int jad_mz() {
        int i = this.jad_hu;
        if (i == 0) {
            i = jad_qd();
        }
        switch (i) {
            case 1:
                return 3;
            case 2:
                return 4;
            case 3:
                return 1;
            case 4:
                return 2;
            case 5:
            case 6:
                return 8;
            case 7:
                return 9;
            case 8:
            case 9:
            case 10:
            case 11:
                return 6;
            case 12:
            case 13:
            case 14:
            case 15:
                return 5;
            case 16:
            case 17:
                return 7;
            case 18:
                return 10;
            default:
                throw new java.lang.AssertionError();
        }
    }

    @Override // com.jd.ad.sdk.jad_wf.jad_cp
    public void jad_na() {
        com.jd.ad.sdk.jad_hk.jad_cp jad_cpVar;
        int i = this.jad_hu;
        if (i == 0) {
            i = jad_qd();
        }
        if (i == 14) {
            jad_tg();
        } else {
            if (i == 13) {
                jad_cpVar = jad_mz;
            } else if (i == 12) {
                jad_cpVar = jad_ly;
            } else if (i != 15) {
                java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_lu.jad_zm.jad_an("Expected a name but was ");
                jad_an.append(com.jd.ad.sdk.jad_wf.jad_dq.jad_an(jad_mz()));
                jad_an.append(" at path ");
                throw new com.jd.ad.sdk.jad_wf.jad_an(com.jd.ad.sdk.jad_wf.jad_er.jad_an(this, jad_an));
            }
            jad_cp(jad_cpVar);
        }
        this.jad_hu = 0;
        this.jad_cp[this.jad_an - 1] = com.igexin.push.core.b.m;
    }

    @Override // com.jd.ad.sdk.jad_wf.jad_cp
    public void jad_ob() {
        com.jd.ad.sdk.jad_hk.jad_cp jad_cpVar;
        int i = 0;
        do {
            int i2 = this.jad_hu;
            if (i2 == 0) {
                i2 = jad_qd();
            }
            if (i2 == 3) {
                jad_an(1);
            } else if (i2 == 1) {
                jad_an(3);
            } else {
                if (i2 == 4) {
                    i--;
                    if (i < 0) {
                        java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_lu.jad_zm.jad_an("Expected a value but was ");
                        jad_an.append(com.jd.ad.sdk.jad_wf.jad_dq.jad_an(jad_mz()));
                        jad_an.append(" at path ");
                        throw new com.jd.ad.sdk.jad_wf.jad_an(com.jd.ad.sdk.jad_wf.jad_er.jad_an(this, jad_an));
                    }
                } else if (i2 == 2) {
                    i--;
                    if (i < 0) {
                        java.lang.StringBuilder jad_an2 = com.jd.ad.sdk.jad_lu.jad_zm.jad_an("Expected a value but was ");
                        jad_an2.append(com.jd.ad.sdk.jad_wf.jad_dq.jad_an(jad_mz()));
                        jad_an2.append(" at path ");
                        throw new com.jd.ad.sdk.jad_wf.jad_an(com.jd.ad.sdk.jad_wf.jad_er.jad_an(this, jad_an2));
                    }
                } else {
                    if (i2 == 14 || i2 == 10) {
                        jad_tg();
                    } else {
                        if (i2 == 9 || i2 == 13) {
                            jad_cpVar = jad_mz;
                        } else if (i2 == 8 || i2 == 12) {
                            jad_cpVar = jad_ly;
                        } else if (i2 == 17) {
                            this.jad_jt.jad_dq(this.jad_jw);
                        } else if (i2 == 18) {
                            java.lang.StringBuilder jad_an3 = com.jd.ad.sdk.jad_lu.jad_zm.jad_an("Expected a value but was ");
                            jad_an3.append(com.jd.ad.sdk.jad_wf.jad_dq.jad_an(jad_mz()));
                            jad_an3.append(" at path ");
                            throw new com.jd.ad.sdk.jad_wf.jad_an(com.jd.ad.sdk.jad_wf.jad_er.jad_an(this, jad_an3));
                        }
                        jad_cp(jad_cpVar);
                    }
                    this.jad_hu = 0;
                }
                this.jad_an--;
                this.jad_hu = 0;
            }
            i++;
            this.jad_hu = 0;
        } while (i != 0);
        int[] iArr = this.jad_dq;
        int i3 = this.jad_an - 1;
        iArr[i3] = iArr[i3] + 1;
        this.jad_cp[i3] = com.igexin.push.core.b.m;
    }

    public final void jad_pc() {
        jad_an("Use JsonReader.setLenient(true) to accept malformed JSON");
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x01bf, code lost:
    
        if (r1 != 7) goto L167;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x01c1, code lost:
    
        r17.jad_jw = r2;
        r13 = 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0194, code lost:
    
        if (jad_bo(r4) != false) goto L167;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0196, code lost:
    
        if (r1 != 2) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0198, code lost:
    
        if (r8 == false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x019e, code lost:
    
        if (r13 != Long.MIN_VALUE) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01a0, code lost:
    
        if (r7 == false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01a6, code lost:
    
        if (r13 != 0) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01a8, code lost:
    
        if (r7 != false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01aa, code lost:
    
        if (r7 == false) goto L140;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01ad, code lost:
    
        r13 = -r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01ae, code lost:
    
        r17.jad_iv = r13;
        r17.jad_jt.jad_dq(r2);
        r13 = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01c5, code lost:
    
        r17.jad_hu = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01b9, code lost:
    
        if (r1 == 2) goto L147;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01bc, code lost:
    
        if (r1 == 4) goto L147;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0116 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01f3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01f4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int jad_qd() {
        int i;
        java.lang.String str;
        java.lang.String str2;
        int i2;
        byte jad_bo;
        int i3;
        int[] iArr = this.jad_bo;
        boolean z = true;
        int i4 = this.jad_an - 1;
        int i5 = iArr[i4];
        if (i5 == 1) {
            iArr[i4] = 2;
        } else if (i5 == 2) {
            int jad_an = jad_an(true);
            this.jad_jt.jad_bo();
            if (jad_an != 44) {
                if (jad_an != 59) {
                    if (jad_an == 93) {
                        this.jad_hu = 4;
                        return 4;
                    }
                    jad_an("Unterminated array");
                    throw null;
                }
                jad_pc();
                throw null;
            }
        } else {
            if (i5 == 3 || i5 == 5) {
                iArr[i4] = 4;
                if (i5 == 5) {
                    int jad_an2 = jad_an(true);
                    this.jad_jt.jad_bo();
                    if (jad_an2 != 44) {
                        if (jad_an2 == 59) {
                            jad_pc();
                            throw null;
                        }
                        if (jad_an2 == 125) {
                            this.jad_hu = 2;
                            return 2;
                        }
                        jad_an("Unterminated object");
                        throw null;
                    }
                }
                int jad_an3 = jad_an(true);
                if (jad_an3 == 34) {
                    this.jad_jt.jad_bo();
                    this.jad_hu = 13;
                    return 13;
                }
                if (jad_an3 == 39) {
                    this.jad_jt.jad_bo();
                    jad_pc();
                    throw null;
                }
                if (jad_an3 != 125) {
                    jad_pc();
                    throw null;
                }
                if (i5 == 5) {
                    jad_an("Expected name");
                    throw null;
                }
                this.jad_jt.jad_bo();
                this.jad_hu = 2;
                return 2;
            }
            if (i5 == 4) {
                iArr[i4] = 5;
                int jad_an4 = jad_an(true);
                this.jad_jt.jad_bo();
                if (jad_an4 != 58) {
                    if (jad_an4 == 61) {
                        jad_pc();
                        throw null;
                    }
                    jad_an("Expected ':'");
                    throw null;
                }
            } else if (i5 == 6) {
                iArr[i4] = 7;
            } else {
                if (i5 == 7) {
                    if (jad_an(false) == -1) {
                        this.jad_hu = 18;
                        return 18;
                    }
                    jad_pc();
                    throw null;
                }
                if (i5 == 8) {
                    throw new java.lang.IllegalStateException("JsonReader is closed");
                }
            }
        }
        int jad_an5 = jad_an(true);
        if (jad_an5 == 34) {
            this.jad_jt.jad_bo();
            this.jad_hu = 9;
            return 9;
        }
        if (jad_an5 == 39) {
            jad_pc();
            throw null;
        }
        if (jad_an5 == 44 || jad_an5 == 59) {
            i = 1;
        } else {
            if (jad_an5 == 91) {
                this.jad_jt.jad_bo();
                this.jad_hu = 3;
                return 3;
            }
            if (jad_an5 == 93) {
                i = 1;
                if (i5 == 1) {
                    this.jad_jt.jad_bo();
                    this.jad_hu = 4;
                    return 4;
                }
            } else {
                if (jad_an5 == 123) {
                    this.jad_jt.jad_bo();
                    this.jad_hu = 1;
                    return 1;
                }
                byte jad_bo2 = this.jad_jt.jad_bo(0L);
                if (jad_bo2 == 116 || jad_bo2 == 84) {
                    str = com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE;
                    str2 = "TRUE";
                    i2 = 5;
                } else if (jad_bo2 == 102 || jad_bo2 == 70) {
                    str = com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE;
                    str2 = "FALSE";
                    i2 = 6;
                } else {
                    if (jad_bo2 == 110 || jad_bo2 == 78) {
                        str = com.igexin.push.core.b.m;
                        str2 = "NULL";
                        i2 = 7;
                    }
                    i2 = 0;
                    if (i2 == 0) {
                        return i2;
                    }
                    long j = 0;
                    char c = 0;
                    int i6 = 0;
                    boolean z2 = false;
                    boolean z3 = true;
                    while (true) {
                        int i7 = i6 + 1;
                        if (!this.jad_fs.jad_an(i7)) {
                            break;
                        }
                        byte jad_bo3 = this.jad_jt.jad_bo(i6);
                        if (jad_bo3 != 43) {
                            if (jad_bo3 == 69 || jad_bo3 == 101) {
                                if (c != 2 && c != 4) {
                                    break;
                                }
                                c = 5;
                                i6 = i7;
                                z = true;
                            } else if (jad_bo3 != 45) {
                                if (jad_bo3 == 46) {
                                    if (c != 2) {
                                        break;
                                    }
                                    c = 3;
                                    i6 = i7;
                                    z = true;
                                } else {
                                    if (jad_bo3 < 48 || jad_bo3 > 57) {
                                        break;
                                    }
                                    if (c == z || c == 0) {
                                        j = -(jad_bo3 - 48);
                                        c = 2;
                                    } else if (c == 2) {
                                        if (j == 0) {
                                            break;
                                        }
                                        long j2 = (10 * j) - (jad_bo3 - 48);
                                        z3 &= j > -922337203685477580L || (j == -922337203685477580L && j2 < j);
                                        j = j2;
                                    } else if (c == 3) {
                                        c = 4;
                                    } else if (c == 5 || c == 6) {
                                        c = 7;
                                    }
                                    i6 = i7;
                                    z = true;
                                }
                            } else if (c == 0) {
                                c = 1;
                                z2 = true;
                                i6 = i7;
                                z = true;
                            } else {
                                if (c != 5) {
                                    break;
                                }
                                c = 6;
                                i6 = i7;
                                z = true;
                            }
                            if (i3 == 0) {
                                return i3;
                            }
                            if (jad_bo(this.jad_jt.jad_bo(0L))) {
                                jad_pc();
                                throw null;
                            }
                            jad_an("Expected value");
                            throw null;
                        }
                        if (c != 5) {
                            break;
                        }
                        c = 6;
                        i6 = i7;
                        z = true;
                    }
                    i3 = 0;
                    if (i3 == 0) {
                    }
                }
                int length = str.length();
                int i8 = 1;
                while (true) {
                    if (i8 < length) {
                        int i9 = i8 + 1;
                        if (!this.jad_fs.jad_an(i9) || ((jad_bo = this.jad_jt.jad_bo(i8)) != str.charAt(i8) && jad_bo != str2.charAt(i8))) {
                            break;
                        }
                        i8 = i9;
                    } else if (!this.jad_fs.jad_an(length + 1) || !jad_bo(this.jad_jt.jad_bo(length))) {
                        this.jad_jt.jad_dq(length);
                        this.jad_hu = i2;
                    }
                }
                if (i2 == 0) {
                }
            }
        }
        if (i5 == i || i5 == 2) {
            jad_pc();
            throw null;
        }
        jad_an("Unexpected value");
        throw null;
    }

    public final java.lang.String jad_re() {
        long jad_an = this.jad_fs.jad_an(jad_na);
        if (jad_an != -1) {
            com.jd.ad.sdk.jad_hk.jad_an jad_anVar = this.jad_jt;
            jad_anVar.getClass();
            return jad_anVar.jad_an(jad_an, com.jd.ad.sdk.jad_hk.jad_ob.jad_an);
        }
        com.jd.ad.sdk.jad_hk.jad_an jad_anVar2 = this.jad_jt;
        jad_anVar2.getClass();
        try {
            return jad_anVar2.jad_an(jad_anVar2.jad_bo, com.jd.ad.sdk.jad_hk.jad_ob.jad_an);
        } catch (java.io.EOFException e) {
            throw new java.lang.AssertionError(e);
        }
    }

    public final char jad_sf() {
        int i;
        int i2;
        if (!this.jad_fs.jad_an(1L)) {
            jad_an("Unterminated escape sequence");
            throw null;
        }
        byte jad_bo = this.jad_jt.jad_bo();
        if (jad_bo == 10 || jad_bo == 34 || jad_bo == 39 || jad_bo == 47 || jad_bo == 92) {
            return (char) jad_bo;
        }
        if (jad_bo == 98) {
            return '\b';
        }
        if (jad_bo == 102) {
            return '\f';
        }
        if (jad_bo == 110) {
            return '\n';
        }
        if (jad_bo == 114) {
            return '\r';
        }
        if (jad_bo == 116) {
            return '\t';
        }
        if (jad_bo != 117) {
            java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_lu.jad_zm.jad_an("Invalid escape sequence: \\");
            jad_an.append((char) jad_bo);
            jad_an(jad_an.toString());
            throw null;
        }
        if (!this.jad_fs.jad_an(4L)) {
            throw new java.io.EOFException(com.jd.ad.sdk.jad_wf.jad_er.jad_an(this, com.jd.ad.sdk.jad_lu.jad_zm.jad_an("Unterminated escape sequence at path ")));
        }
        char c = 0;
        for (int i3 = 0; i3 < 4; i3++) {
            byte jad_bo2 = this.jad_jt.jad_bo(i3);
            char c2 = (char) (c << 4);
            if (jad_bo2 < 48 || jad_bo2 > 57) {
                if (jad_bo2 >= 97 && jad_bo2 <= 102) {
                    i = jad_bo2 - 97;
                } else {
                    if (jad_bo2 < 65 || jad_bo2 > 70) {
                        java.lang.StringBuilder jad_an2 = com.jd.ad.sdk.jad_lu.jad_zm.jad_an("\\u");
                        com.jd.ad.sdk.jad_hk.jad_an jad_anVar = this.jad_jt;
                        jad_anVar.getClass();
                        jad_an2.append(jad_anVar.jad_an(4L, com.jd.ad.sdk.jad_hk.jad_ob.jad_an));
                        jad_an(jad_an2.toString());
                        throw null;
                    }
                    i = jad_bo2 - 65;
                }
                i2 = i + 10;
            } else {
                i2 = jad_bo2 - 48;
            }
            c = (char) (i2 + c2);
        }
        this.jad_jt.jad_dq(4L);
        return c;
    }

    public final void jad_tg() {
        long jad_an = this.jad_fs.jad_an(jad_na);
        com.jd.ad.sdk.jad_hk.jad_an jad_anVar = this.jad_jt;
        if (jad_an == -1) {
            jad_an = jad_anVar.jad_bo;
        }
        jad_anVar.jad_dq(jad_an);
    }

    public java.lang.String toString() {
        java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_lu.jad_zm.jad_an("JsonReader(");
        jad_an.append(this.jad_fs);
        jad_an.append(")");
        return jad_an.toString();
    }
}
