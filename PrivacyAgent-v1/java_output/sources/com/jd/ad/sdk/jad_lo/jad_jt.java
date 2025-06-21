package com.jd.ad.sdk.jad_lo;

/* loaded from: classes23.dex */
public final class jad_jt extends java.lang.Thread {
    public boolean jad_an;
    public java.io.InputStream jad_bo;
    public java.lang.StringBuilder jad_cp = new java.lang.StringBuilder();
    public volatile boolean jad_dq;

    public jad_jt(java.io.InputStream inputStream, boolean z) {
        this.jad_an = false;
        this.jad_dq = false;
        this.jad_bo = inputStream;
        this.jad_dq = false;
        this.jad_an = z;
    }

    public final java.lang.String jad_an() {
        if (!this.jad_dq) {
            synchronized (this) {
                try {
                    if (!this.jad_dq) {
                        wait();
                    }
                } finally {
                }
            }
        }
        return this.jad_cp.toString();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        java.io.BufferedReader bufferedReader = null;
        try {
            java.io.BufferedReader bufferedReader2 = new java.io.BufferedReader(new java.io.InputStreamReader(this.jad_bo));
            try {
                java.lang.String property = this.jad_an ? java.lang.System.getProperty("line.separator") : "";
                while (true) {
                    java.lang.String readLine = bufferedReader2.readLine();
                    if (readLine != null) {
                        this.jad_cp.append(readLine + property);
                    } else {
                        try {
                            break;
                        } catch (java.lang.Exception unused) {
                        }
                    }
                }
                bufferedReader2.close();
                try {
                    this.jad_bo.close();
                } catch (java.lang.Exception unused2) {
                }
                this.jad_dq = true;
                synchronized (this) {
                    notify();
                }
            } catch (java.io.IOException unused3) {
                bufferedReader = bufferedReader2;
                try {
                    bufferedReader.close();
                } catch (java.lang.Exception unused4) {
                }
                try {
                    this.jad_bo.close();
                } catch (java.lang.Exception unused5) {
                }
                this.jad_dq = true;
                synchronized (this) {
                    notify();
                }
            } catch (java.lang.Throwable th) {
                th = th;
                bufferedReader = bufferedReader2;
                try {
                    bufferedReader.close();
                } catch (java.lang.Exception unused6) {
                }
                try {
                    this.jad_bo.close();
                } catch (java.lang.Exception unused7) {
                }
                this.jad_dq = true;
                synchronized (this) {
                    notify();
                }
                throw th;
            }
        } catch (java.io.IOException unused8) {
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }
}
