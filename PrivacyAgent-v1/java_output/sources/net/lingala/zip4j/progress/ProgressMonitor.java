package net.lingala.zip4j.progress;

/* loaded from: classes23.dex */
public class ProgressMonitor {
    public static final int OPERATION_ADD = 0;
    public static final int OPERATION_CALC_CRC = 3;
    public static final int OPERATION_EXTRACT = 1;
    public static final int OPERATION_MERGE = 4;
    public static final int OPERATION_NONE = -1;
    public static final int OPERATION_REMOVE = 2;
    public static final int RESULT_CANCELLED = 3;
    public static final int RESULT_ERROR = 2;
    public static final int RESULT_SUCCESS = 0;
    public static final int RESULT_WORKING = 1;
    public static final int STATE_BUSY = 1;
    public static final int STATE_READY = 0;
    public int a;
    public long b;
    public long c;
    public int d;
    public int e;
    public java.lang.String f;
    public int g;
    public java.lang.Throwable h;
    public boolean i;
    public boolean j;

    public ProgressMonitor() {
        reset();
        this.d = 0;
    }

    public void cancelAllTasks() {
        this.i = true;
    }

    public void endProgressMonitorError(java.lang.Throwable th) throws net.lingala.zip4j.exception.ZipException {
        reset();
        this.g = 2;
        this.h = th;
    }

    public void endProgressMonitorSuccess() throws net.lingala.zip4j.exception.ZipException {
        reset();
        this.g = 0;
    }

    public void fullReset() {
        reset();
        this.h = null;
        this.g = 0;
    }

    public int getCurrentOperation() {
        return this.e;
    }

    public java.lang.Throwable getException() {
        return this.h;
    }

    public java.lang.String getFileName() {
        return this.f;
    }

    public int getPercentDone() {
        return this.d;
    }

    public int getResult() {
        return this.g;
    }

    public int getState() {
        return this.a;
    }

    public long getTotalWork() {
        return this.b;
    }

    public long getWorkCompleted() {
        return this.c;
    }

    public boolean isCancelAllTasks() {
        return this.i;
    }

    public boolean isPause() {
        return this.j;
    }

    public void reset() {
        this.e = -1;
        this.a = 0;
        this.f = null;
        this.b = 0L;
        this.c = 0L;
        this.d = 0;
    }

    public void setCurrentOperation(int i) {
        this.e = i;
    }

    public void setException(java.lang.Throwable th) {
        this.h = th;
    }

    public void setFileName(java.lang.String str) {
        this.f = str;
    }

    public void setPause(boolean z) {
        this.j = z;
    }

    public void setPercentDone(int i) {
        this.d = i;
    }

    public void setResult(int i) {
        this.g = i;
    }

    public void setState(int i) {
        this.a = i;
    }

    public void setTotalWork(long j) {
        this.b = j;
    }

    public void updateWorkCompleted(long j) {
        long j2 = this.c + j;
        this.c = j2;
        long j3 = this.b;
        if (j3 > 0) {
            int i = (int) ((j2 * 100) / j3);
            this.d = i;
            if (i > 100) {
                this.d = 100;
            }
        }
        while (this.j) {
            try {
                java.lang.Thread.sleep(150L);
            } catch (java.lang.InterruptedException unused) {
            }
        }
    }
}
