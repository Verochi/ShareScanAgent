package com.ss.android.socialbase.downloader.segment;

/* loaded from: classes19.dex */
class UrlRecord {
    private final java.util.concurrent.atomic.AtomicLong downloadBytes;
    private int failedTimes;
    private int hashCode;
    final java.lang.String ip;
    final java.lang.String ipFamily;
    private boolean isCurrentFailed;
    final boolean isMainUrl;
    private java.lang.String key;
    private final java.util.List<com.ss.android.socialbase.downloader.segment.SegmentReader> readers;
    final java.lang.String url;

    public UrlRecord(java.lang.String str, java.lang.String str2) {
        this.readers = new java.util.ArrayList();
        this.downloadBytes = new java.util.concurrent.atomic.AtomicLong();
        this.url = str;
        this.isMainUrl = false;
        this.ip = str2;
        this.ipFamily = getIpFamily(str2);
    }

    public UrlRecord(java.lang.String str, boolean z) {
        this.readers = new java.util.ArrayList();
        this.downloadBytes = new java.util.concurrent.atomic.AtomicLong();
        this.url = str;
        this.isMainUrl = z;
        this.ip = null;
        this.ipFamily = null;
    }

    private java.lang.String getIpFamily(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            int lastIndexOf = str.lastIndexOf(".");
            if (lastIndexOf <= 0 || lastIndexOf >= str.length()) {
                return null;
            }
            return str.substring(0, lastIndexOf);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private java.lang.String getKey() {
        if (this.key == null) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(this.url);
            sb.append("_");
            java.lang.String str = this.ip;
            if (str == null) {
                str = "";
            }
            sb.append(str);
            sb.append("_");
            sb.append(this.isMainUrl);
            this.key = sb.toString();
        }
        return this.key;
    }

    public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof com.ss.android.socialbase.downloader.segment.UrlRecord) {
            return getKey().equals(((com.ss.android.socialbase.downloader.segment.UrlRecord) obj).getKey());
        }
        return false;
    }

    public synchronized int getCurrentUsers() {
        return this.readers.size();
    }

    public long getDownloadBytes() {
        long j = this.downloadBytes.get();
        java.util.Iterator<com.ss.android.socialbase.downloader.segment.SegmentReader> it = this.readers.iterator();
        while (it.hasNext()) {
            j += it.next().getReadingBytes();
        }
        return j;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = getKey().hashCode();
        }
        return this.hashCode;
    }

    public void increaseDownloadBytes(long j) {
        this.downloadBytes.addAndGet(j);
    }

    public synchronized boolean isCurrentFailed() {
        return this.isCurrentFailed;
    }

    public synchronized void recordFailed() {
        this.failedTimes++;
        this.isCurrentFailed = true;
    }

    public synchronized void recordSucceed() {
        this.isCurrentFailed = false;
    }

    public synchronized void recordUnUse(com.ss.android.socialbase.downloader.segment.SegmentReader segmentReader) {
        try {
            this.readers.remove(segmentReader);
        } catch (java.lang.Throwable unused) {
        }
    }

    public synchronized void recordUse(com.ss.android.socialbase.downloader.segment.SegmentReader segmentReader) {
        this.readers.add(segmentReader);
    }

    public java.lang.String toString() {
        return "UrlRecord{url='" + this.url + "', ip='" + this.ip + "', ipFamily='" + this.ipFamily + "', isMainUrl=" + this.isMainUrl + ", failedTimes=" + this.failedTimes + ", isCurrentFailed=" + this.isCurrentFailed + '}';
    }
}
