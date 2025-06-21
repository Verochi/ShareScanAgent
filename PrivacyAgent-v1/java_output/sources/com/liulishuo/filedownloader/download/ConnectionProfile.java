package com.liulishuo.filedownloader.download;

/* loaded from: classes23.dex */
public class ConnectionProfile {
    public final long a;
    public final long b;
    public final long c;
    public final long d;
    public final boolean e;
    public final boolean f;

    public static class ConnectionProfileBuild {
        public static com.liulishuo.filedownloader.download.ConnectionProfile buildBeginToEndConnectionProfile(long j) {
            return new com.liulishuo.filedownloader.download.ConnectionProfile(0L, 0L, -1L, j, (com.liulishuo.filedownloader.download.ConnectionProfile.AnonymousClass1) null);
        }

        public static com.liulishuo.filedownloader.download.ConnectionProfile buildConnectionProfile(long j, long j2, long j3, long j4) {
            return new com.liulishuo.filedownloader.download.ConnectionProfile(j, j2, j3, j4, (com.liulishuo.filedownloader.download.ConnectionProfile.AnonymousClass1) null);
        }

        public static com.liulishuo.filedownloader.download.ConnectionProfile buildToEndConnectionProfile(long j, long j2, long j3) {
            return new com.liulishuo.filedownloader.download.ConnectionProfile(j, j2, -1L, j3, (com.liulishuo.filedownloader.download.ConnectionProfile.AnonymousClass1) null);
        }

        public static com.liulishuo.filedownloader.download.ConnectionProfile buildTrialConnectionProfile() {
            return new com.liulishuo.filedownloader.download.ConnectionProfile(null);
        }

        public static com.liulishuo.filedownloader.download.ConnectionProfile buildTrialConnectionProfileNoRange() {
            return new com.liulishuo.filedownloader.download.ConnectionProfile(0L, 0L, 0L, 0L, true, null);
        }
    }

    public ConnectionProfile() {
        this.a = 0L;
        this.b = 0L;
        this.c = 0L;
        this.d = 0L;
        this.e = false;
        this.f = true;
    }

    public ConnectionProfile(long j, long j2, long j3, long j4) {
        this(j, j2, j3, j4, false);
    }

    public /* synthetic */ ConnectionProfile(long j, long j2, long j3, long j4, com.liulishuo.filedownloader.download.ConnectionProfile.AnonymousClass1 anonymousClass1) {
        this(j, j2, j3, j4);
    }

    public ConnectionProfile(long j, long j2, long j3, long j4, boolean z) {
        if (!(j == 0 && j3 == 0) && z) {
            throw new java.lang.IllegalArgumentException();
        }
        this.a = j;
        this.b = j2;
        this.c = j3;
        this.d = j4;
        this.e = z;
        this.f = false;
    }

    public /* synthetic */ ConnectionProfile(long j, long j2, long j3, long j4, boolean z, com.liulishuo.filedownloader.download.ConnectionProfile.AnonymousClass1 anonymousClass1) {
        this(j, j2, j3, j4, z);
    }

    public /* synthetic */ ConnectionProfile(com.liulishuo.filedownloader.download.ConnectionProfile.AnonymousClass1 anonymousClass1) {
        this();
    }

    public void processProfile(com.liulishuo.filedownloader.connection.FileDownloadConnection fileDownloadConnection) throws java.net.ProtocolException {
        if (this.e) {
            return;
        }
        if (this.f && com.liulishuo.filedownloader.util.FileDownloadProperties.getImpl().trialConnectionHeadMethod) {
            fileDownloadConnection.setRequestMethod("HEAD");
        }
        fileDownloadConnection.addHeader("Range", this.c == -1 ? com.liulishuo.filedownloader.util.FileDownloadUtils.formatString("bytes=%d-", java.lang.Long.valueOf(this.b)) : com.liulishuo.filedownloader.util.FileDownloadUtils.formatString("bytes=%d-%d", java.lang.Long.valueOf(this.b), java.lang.Long.valueOf(this.c)));
    }

    public java.lang.String toString() {
        return com.liulishuo.filedownloader.util.FileDownloadUtils.formatString("range[%d, %d) current offset[%d]", java.lang.Long.valueOf(this.a), java.lang.Long.valueOf(this.c), java.lang.Long.valueOf(this.b));
    }
}
