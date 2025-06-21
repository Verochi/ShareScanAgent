package com.ss.android.socialbase.downloader.network;

/* loaded from: classes19.dex */
public class DownloadDnsManager {
    private final com.ss.android.socialbase.downloader.utils.LruCache<java.lang.String, com.ss.android.socialbase.downloader.network.DownloadDnsManager.DnsRecord> cache;
    private final android.os.Handler cpuHandler;
    private final android.os.Handler networkHandler;

    /* renamed from: com.ss.android.socialbase.downloader.network.DownloadDnsManager$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.ss.android.socialbase.downloader.network.DownloadDnsManager.Callback val$cb;
        final /* synthetic */ long val$timeout;
        final /* synthetic */ java.lang.String val$url;

        public AnonymousClass1(java.lang.String str, com.ss.android.socialbase.downloader.network.DownloadDnsManager.Callback callback, long j) {
            this.val$url = str;
            this.val$cb = callback;
            this.val$timeout = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.socialbase.downloader.network.DownloadDnsManager.this.resolveDns(this.val$url, this.val$cb, this.val$timeout);
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.network.DownloadDnsManager$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ com.ss.android.socialbase.downloader.network.DownloadDnsManager.Callback val$cb;
        final /* synthetic */ com.ss.android.socialbase.downloader.network.DownloadDnsManager.DnsRecord val$recordFromCache;
        final /* synthetic */ java.lang.String val$url;

        public AnonymousClass2(com.ss.android.socialbase.downloader.network.DownloadDnsManager.Callback callback, java.lang.String str, com.ss.android.socialbase.downloader.network.DownloadDnsManager.DnsRecord dnsRecord) {
            this.val$cb = callback;
            this.val$url = str;
            this.val$recordFromCache = dnsRecord;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.socialbase.downloader.network.DownloadDnsManager.Callback callback = this.val$cb;
            if (callback != null) {
                java.lang.String str = this.val$url;
                com.ss.android.socialbase.downloader.network.DownloadDnsManager.DnsRecord dnsRecord = this.val$recordFromCache;
                callback.onDnsResolved(str, dnsRecord == null ? null : dnsRecord.value);
            }
        }
    }

    public interface Callback {
        void onDnsResolved(java.lang.String str, java.util.List<java.net.InetAddress> list);
    }

    public static class DnsRecord {
        long timestamp;
        java.util.List<java.net.InetAddress> value;

        private DnsRecord() {
        }

        public /* synthetic */ DnsRecord(com.ss.android.socialbase.downloader.network.DownloadDnsManager.AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public static class Holder {
        private static final com.ss.android.socialbase.downloader.network.DownloadDnsManager INSTANCE = new com.ss.android.socialbase.downloader.network.DownloadDnsManager(null);

        private Holder() {
        }
    }

    private DownloadDnsManager() {
        this.cache = new com.ss.android.socialbase.downloader.utils.LruCache<>(4, 16, false);
        this.networkHandler = new android.os.Handler(com.ss.android.socialbase.downloader.network.connectionpool.DownloadPreconnecter.getLooper());
        this.cpuHandler = new android.os.Handler(com.ss.android.socialbase.downloader.thread.DownloadWatchDog.getThreadLooper());
    }

    public /* synthetic */ DownloadDnsManager(com.ss.android.socialbase.downloader.network.DownloadDnsManager.AnonymousClass1 anonymousClass1) {
        this();
    }

    public static com.ss.android.socialbase.downloader.network.DownloadDnsManager getInstance() {
        return com.ss.android.socialbase.downloader.network.DownloadDnsManager.Holder.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(14:1|2|a|(2:8|(1:(2:11|12)(1:14)))|15|(6:19|20|(3:36|37|38)|(3:28|29|(2:31|32)(1:33))|29|(0)(0))|45|(1:22)|36|37|38|(4:25|28|29|(0)(0))|29|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0085, code lost:
    
        r10 = r2.value;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0072, code lost:
    
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0073, code lost:
    
        r11.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008e A[Catch: all -> 0x0095, TRY_LEAVE, TryCatch #2 {all -> 0x0095, blocks: (B:2:0x0000, B:3:0x000a, B:8:0x0016, B:11:0x0034, B:15:0x003a, B:17:0x0051, B:22:0x0063, B:25:0x0078, B:28:0x007f, B:29:0x0087, B:31:0x008e, B:35:0x0085, B:36:0x0069, B:41:0x0073, B:44:0x005d, B:49:0x0094, B:38:0x006d, B:5:0x000b, B:6:0x0013, B:20:0x0057), top: B:1:0x0000, inners: #0, #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void resolveDns(java.lang.String str, com.ss.android.socialbase.downloader.network.DownloadDnsManager.Callback callback, long j) {
        com.ss.android.socialbase.downloader.network.DownloadDnsManager.DnsRecord dnsRecord;
        java.util.List<java.net.InetAddress> list;
        com.ss.android.socialbase.downloader.network.IDownloadDns downloadDns;
        try {
            java.lang.String host = android.net.Uri.parse(str).getHost();
            synchronized (this.cache) {
                dnsRecord = this.cache.get(host);
            }
            if (dnsRecord != null) {
                if (java.lang.System.currentTimeMillis() - dnsRecord.timestamp < com.ss.android.socialbase.downloader.setting.DownloadSetting.obtainGlobal().optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.DNS_EXPIRE_MIN, 10) * 60 * 1000) {
                    if (callback != null) {
                        callback.onDnsResolved(str, dnsRecord.value);
                        return;
                    }
                    return;
                }
            }
            com.ss.android.socialbase.downloader.network.DownloadDnsManager.AnonymousClass2 anonymousClass2 = new com.ss.android.socialbase.downloader.network.DownloadDnsManager.AnonymousClass2(callback, str, dnsRecord);
            this.cpuHandler.postDelayed(anonymousClass2, j);
            if (com.ss.android.socialbase.downloader.setting.DownloadSetting.obtainGlobal().optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.USE_HOST_DNS, 1) == 1 && (downloadDns = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getDownloadDns()) != null) {
                try {
                    list = downloadDns.lookup(host);
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                }
                if (list != null || list.isEmpty()) {
                    list = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getDefaultDownloadDns().lookup(host);
                }
                if (list != null && !list.isEmpty()) {
                    updateIpAddressToCache(host, list);
                    this.cpuHandler.removeCallbacks(anonymousClass2);
                    if (callback == null) {
                        callback.onDnsResolved(str, list);
                        return;
                    }
                    return;
                }
                this.cpuHandler.removeCallbacks(anonymousClass2);
                if (callback == null) {
                }
            }
            list = null;
            if (list != null) {
            }
            list = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getDefaultDownloadDns().lookup(host);
            if (list != null) {
                updateIpAddressToCache(host, list);
                this.cpuHandler.removeCallbacks(anonymousClass2);
                if (callback == null) {
                }
            }
            this.cpuHandler.removeCallbacks(anonymousClass2);
            if (callback == null) {
            }
        } catch (java.lang.Throwable th2) {
            th2.printStackTrace();
        }
    }

    private void updateIpAddressToCache(java.lang.String str, java.util.List<java.net.InetAddress> list) {
        synchronized (this.cache) {
            com.ss.android.socialbase.downloader.network.DownloadDnsManager.DnsRecord dnsRecord = this.cache.get(str);
            if (dnsRecord == null) {
                dnsRecord = new com.ss.android.socialbase.downloader.network.DownloadDnsManager.DnsRecord(null);
                this.cache.put(str, dnsRecord);
            }
            dnsRecord.value = list;
            dnsRecord.timestamp = java.lang.System.currentTimeMillis();
        }
    }

    public void resolveDnsAsync(java.lang.String str, com.ss.android.socialbase.downloader.network.DownloadDnsManager.Callback callback, long j) {
        this.networkHandler.post(new com.ss.android.socialbase.downloader.network.DownloadDnsManager.AnonymousClass1(str, callback, j));
    }
}
