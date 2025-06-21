package com.liulishuo.filedownloader;

/* loaded from: classes23.dex */
public class DownloadSpeedMonitor implements com.liulishuo.filedownloader.IDownloadSpeed.Monitor, com.liulishuo.filedownloader.IDownloadSpeed.Lookup {
    public long a;
    public long b;
    public long c;
    public long d;
    public int e;
    public int f = 1000;

    @Override // com.liulishuo.filedownloader.IDownloadSpeed.Monitor
    public void end(long j) {
        if (this.d <= 0) {
            return;
        }
        long j2 = j - this.c;
        this.a = 0L;
        long uptimeMillis = android.os.SystemClock.uptimeMillis() - this.d;
        if (uptimeMillis <= 0) {
            this.e = (int) j2;
        } else {
            this.e = (int) (j2 / uptimeMillis);
        }
    }

    @Override // com.liulishuo.filedownloader.IDownloadSpeed.Lookup
    public int getSpeed() {
        return this.e;
    }

    @Override // com.liulishuo.filedownloader.IDownloadSpeed.Monitor
    public void reset() {
        this.e = 0;
        this.a = 0L;
    }

    @Override // com.liulishuo.filedownloader.IDownloadSpeed.Lookup
    public void setMinIntervalUpdateSpeed(int i) {
        this.f = i;
    }

    @Override // com.liulishuo.filedownloader.IDownloadSpeed.Monitor
    public void start(long j) {
        this.d = android.os.SystemClock.uptimeMillis();
        this.c = j;
    }

    @Override // com.liulishuo.filedownloader.IDownloadSpeed.Monitor
    public void update(long j) {
        if (this.f <= 0) {
            return;
        }
        boolean z = true;
        if (this.a != 0) {
            long uptimeMillis = android.os.SystemClock.uptimeMillis() - this.a;
            if (uptimeMillis >= this.f || (this.e == 0 && uptimeMillis > 0)) {
                int i = (int) ((j - this.b) / uptimeMillis);
                this.e = i;
                this.e = java.lang.Math.max(0, i);
            } else {
                z = false;
            }
        }
        if (z) {
            this.b = j;
            this.a = android.os.SystemClock.uptimeMillis();
        }
    }
}
