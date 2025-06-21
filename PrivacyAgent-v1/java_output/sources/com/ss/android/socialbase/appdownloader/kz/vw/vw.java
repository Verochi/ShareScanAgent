package com.ss.android.socialbase.appdownloader.kz.vw;

/* loaded from: classes19.dex */
class vw implements com.ss.android.socialbase.appdownloader.kz.vw.x {
    private boolean bt;
    private int cp;
    private int d;
    private int es;
    private int o;
    private int u;
    private com.ss.android.socialbase.appdownloader.kz.vw.kz v;
    private int[] vl;
    private com.ss.android.socialbase.appdownloader.kz.vw.v wg;
    private int x;
    private int[] yl;
    private int z;
    private boolean t = false;
    private com.ss.android.socialbase.appdownloader.kz.vw.vw.C0482vw kz = new com.ss.android.socialbase.appdownloader.kz.vw.vw.C0482vw();

    /* renamed from: com.ss.android.socialbase.appdownloader.kz.vw.vw$vw, reason: collision with other inner class name */
    public static final class C0482vw {
        private int t;
        private int[] vw = new int[32];
        private int wg;

        private void vw(int i) {
            int[] iArr = this.vw;
            int length = iArr.length;
            int i2 = this.wg;
            int i3 = length - i2;
            if (i3 <= i) {
                int[] iArr2 = new int[(iArr.length + i3) * 2];
                java.lang.System.arraycopy(iArr, 0, iArr2, 0, i2);
                this.vw = iArr2;
            }
        }

        public final void kz() {
            int i = this.wg;
            if (i != 0) {
                int i2 = i - 1;
                int i3 = this.vw[i2] * 2;
                if ((i2 - 1) - i3 != 0) {
                    this.wg = i - (i3 + 2);
                    this.t--;
                }
            }
        }

        public final boolean t() {
            int i;
            int[] iArr;
            int i2;
            int i3 = this.wg;
            if (i3 == 0 || (i2 = (iArr = this.vw)[i3 - 1]) == 0) {
                return false;
            }
            int i4 = i2 - 1;
            int i5 = i - 2;
            iArr[i5] = i4;
            iArr[i5 - ((i4 * 2) + 1)] = i4;
            this.wg = i3 - 2;
            return true;
        }

        public final int v() {
            return this.t;
        }

        public final void vw() {
            this.wg = 0;
            this.t = 0;
        }

        public final void vw(int i, int i2) {
            if (this.t == 0) {
                yl();
            }
            vw(2);
            int i3 = this.wg;
            int i4 = i3 - 1;
            int[] iArr = this.vw;
            int i5 = iArr[i4];
            int i6 = (i4 - 1) - (i5 * 2);
            int i7 = i5 + 1;
            iArr[i6] = i7;
            iArr[i4] = i;
            iArr[i4 + 1] = i2;
            iArr[i4 + 2] = i7;
            this.wg = i3 + 2;
        }

        public final int wg() {
            int i = this.wg;
            if (i == 0) {
                return 0;
            }
            return this.vw[i - 1];
        }

        public final void yl() {
            vw(2);
            int i = this.wg;
            int[] iArr = this.vw;
            iArr[i] = 0;
            iArr[i + 1] = 0;
            this.wg = i + 2;
            this.t++;
        }
    }

    public vw() {
        bt();
    }

    private final void bt() {
        this.o = -1;
        this.x = -1;
        this.es = -1;
        this.z = -1;
        this.vl = null;
        this.u = -1;
        this.cp = -1;
        this.d = -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:73:0x0182, code lost:
    
        throw new java.io.IOException("Invalid chunk type (" + r5 + ").");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void o() throws java.io.IOException {
        int wg;
        if (this.v == null) {
            com.ss.android.socialbase.appdownloader.kz.vw.wg.vw(this.wg, 524291);
            this.wg.t();
            this.v = com.ss.android.socialbase.appdownloader.kz.vw.kz.vw(this.wg);
            this.kz.yl();
            this.t = true;
        }
        int i = this.o;
        if (i != 1) {
            bt();
            while (true) {
                if (this.bt) {
                    this.bt = false;
                    this.kz.kz();
                }
                int i2 = 3;
                if (i == 3 && this.kz.v() == 1 && this.kz.wg() == 0) {
                    this.o = 1;
                    return;
                }
                int wg2 = i == 0 ? 1048834 : this.wg.wg();
                if (wg2 == 524672) {
                    wg = this.wg.wg();
                    if (wg < 8 || wg % 4 != 0) {
                        break;
                    } else {
                        this.yl = this.wg.wg((wg / 4) - 2);
                    }
                } else {
                    if (wg2 < 1048832 || wg2 > 1048836) {
                        break;
                    }
                    if (wg2 == 1048834 && i == -1) {
                        this.o = 0;
                        return;
                    }
                    this.wg.t();
                    int wg3 = this.wg.wg();
                    this.wg.t();
                    if (wg2 != 1048832 && wg2 != 1048833) {
                        this.x = wg3;
                        if (wg2 == 1048834) {
                            this.z = this.wg.wg();
                            this.es = this.wg.wg();
                            this.wg.t();
                            int wg4 = this.wg.wg();
                            this.u = (wg4 >>> 16) - 1;
                            int wg5 = this.wg.wg();
                            this.d = (wg5 >>> 16) - 1;
                            this.cp = (65535 & wg5) - 1;
                            this.vl = this.wg.wg((wg4 & 65535) * 5);
                            while (true) {
                                int[] iArr = this.vl;
                                if (i2 >= iArr.length) {
                                    this.kz.yl();
                                    this.o = 2;
                                    return;
                                } else {
                                    iArr[i2] = iArr[i2] >>> 24;
                                    i2 += 5;
                                }
                            }
                        } else {
                            if (wg2 == 1048835) {
                                this.z = this.wg.wg();
                                this.es = this.wg.wg();
                                this.o = 3;
                                this.bt = true;
                                return;
                            }
                            if (wg2 == 1048836) {
                                this.es = this.wg.wg();
                                this.wg.t();
                                this.wg.t();
                                this.o = 4;
                                return;
                            }
                        }
                    } else if (wg2 == 1048832) {
                        this.kz.vw(this.wg.wg(), this.wg.wg());
                    } else {
                        this.wg.t();
                        this.wg.t();
                        this.kz.t();
                    }
                }
            }
            throw new java.io.IOException("Invalid resource ids size (" + wg + ").");
        }
    }

    private final int yl(int i) {
        if (this.o != 2) {
            throw new java.lang.IndexOutOfBoundsException("Current event is not START_TAG.");
        }
        int i2 = i * 5;
        if (i2 < this.vl.length) {
            return i2;
        }
        throw new java.lang.IndexOutOfBoundsException("Invalid attribute index (" + i + ").");
    }

    @Override // com.ss.android.socialbase.appdownloader.kz.vw.bt
    public int kz() {
        return -1;
    }

    @Override // com.ss.android.socialbase.appdownloader.kz.vw.bt
    public int t() {
        return this.x;
    }

    public int t(int i) {
        return this.vl[yl(i) + 4];
    }

    @Override // com.ss.android.socialbase.appdownloader.kz.vw.bt
    public java.lang.String v() {
        return "XML line #" + t();
    }

    public java.lang.String v(int i) {
        int yl = yl(i);
        int[] iArr = this.vl;
        if (iArr[yl + 3] != 3) {
            return "";
        }
        return this.v.vw(iArr[yl + 2]);
    }

    public java.lang.String vw(int i) {
        int i2 = this.vl[yl(i) + 1];
        return i2 == -1 ? "" : this.v.vw(i2);
    }

    public void vw() {
        if (this.t) {
            this.t = false;
            this.wg.vw();
            this.wg = null;
            this.v = null;
            this.yl = null;
            this.kz.vw();
            bt();
        }
    }

    public void vw(java.io.InputStream inputStream) {
        vw();
        if (inputStream != null) {
            this.wg = new com.ss.android.socialbase.appdownloader.kz.vw.v(inputStream, false);
        }
    }

    public int wg() throws com.ss.android.socialbase.appdownloader.kz.vw.o, java.io.IOException {
        if (this.wg == null) {
            throw new com.ss.android.socialbase.appdownloader.kz.vw.o("Parser is not opened.", this, null);
        }
        try {
            o();
            return this.o;
        } catch (java.io.IOException e) {
            vw();
            throw e;
        }
    }

    public int wg(int i) {
        return this.vl[yl(i) + 3];
    }

    public int yl() {
        if (this.o != 2) {
            return -1;
        }
        return this.vl.length / 5;
    }
}
