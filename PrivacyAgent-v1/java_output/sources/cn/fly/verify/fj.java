package cn.fly.verify;

/* loaded from: classes.dex */
public class fj {
    private java.io.FileOutputStream a;
    private java.nio.channels.FileLock b;

    private boolean b(boolean z) throws java.lang.Throwable {
        this.b = z ? this.a.getChannel().lock() : this.a.getChannel().tryLock();
        return this.b != null;
    }

    public synchronized void a() {
        java.nio.channels.FileLock fileLock = this.b;
        if (fileLock == null) {
            return;
        }
        try {
            fileLock.release();
        } catch (java.lang.Throwable unused) {
        }
        this.b = null;
    }

    public synchronized void a(java.lang.String str) {
        try {
            this.a = new java.io.FileOutputStream(str);
        } catch (java.lang.Throwable unused) {
            java.io.FileOutputStream fileOutputStream = this.a;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (java.lang.Throwable unused2) {
                }
                this.a = null;
            }
        }
    }

    public synchronized boolean a(boolean z) {
        return a(z, z ? 1000L : 500L, 16L);
    }

    public synchronized boolean a(boolean z, long j, long j2) {
        boolean z2;
        if (this.a == null) {
            return false;
        }
        try {
            return b(z);
        } catch (java.lang.Throwable th) {
            if (j <= 0 || !(th instanceof java.nio.channels.OverlappingFileLockException)) {
                cn.fly.verify.ed.a().b(th);
            } else {
                long elapsedRealtime = android.os.SystemClock.elapsedRealtime() + j;
                while (true) {
                    if (j <= 0) {
                        z2 = false;
                        break;
                    }
                    try {
                        java.lang.Thread.sleep(j2);
                    } catch (java.lang.Throwable unused) {
                    }
                    try {
                        j = elapsedRealtime - android.os.SystemClock.elapsedRealtime();
                        z2 = b(z);
                        break;
                    } catch (java.lang.Throwable th2) {
                        if (!(th2 instanceof java.nio.channels.OverlappingFileLockException)) {
                            cn.fly.verify.ed.a().b(th);
                            j = -1;
                        } else if (j <= 0) {
                            cn.fly.verify.ed.a().b("OverlappingFileLockException and timeout");
                        }
                    }
                }
                if (j > 0) {
                    return z2;
                }
            }
            java.nio.channels.FileLock fileLock = this.b;
            if (fileLock != null) {
                try {
                    fileLock.release();
                } catch (java.lang.Throwable unused2) {
                }
                this.b = null;
            }
            java.io.FileOutputStream fileOutputStream = this.a;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (java.lang.Throwable unused3) {
                }
                this.a = null;
            }
            return false;
        }
    }

    public synchronized void b() {
        if (this.a == null) {
            return;
        }
        a();
        try {
            this.a.close();
        } catch (java.lang.Throwable unused) {
        }
        this.a = null;
    }
}
