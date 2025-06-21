package com.alibaba.sdk.android.oss;

/* loaded from: classes.dex */
public class ClientConfiguration {
    private static final int DEFAULT_MAX_RETRIES = 2;
    private java.lang.String ipWithHeader;
    private java.lang.String mUserAgentMark;
    private java.lang.String proxyHost;
    private int proxyPort;
    private int maxConcurrentRequest = 5;
    private int maxConcurrentRequestsPerHost = -1;
    private int socketTimeout = 60000;
    private int connectionTimeout = 60000;
    private long max_log_size = com.google.android.exoplayer2.upstream.cache.CacheDataSink.DEFAULT_FRAGMENT_SIZE;
    private int maxErrorRetry = 2;
    private java.util.List<java.lang.String> customCnameExcludeList = new java.util.ArrayList();
    private boolean httpDnsEnable = false;
    private boolean checkCRC64 = false;
    private boolean pathStyleAccessEnable = false;
    private boolean customPathPrefixEnable = false;
    private boolean followRedirectsEnable = false;
    private okhttp3.OkHttpClient okHttpClient = null;
    private java.util.concurrent.ExecutorService executorService = null;
    private com.alibaba.sdk.android.oss.signer.SignVersion signVersion = com.alibaba.sdk.android.oss.signer.SignVersion.V1;
    private com.alibaba.sdk.android.oss.common.HttpProtocol httpProtocol = com.alibaba.sdk.android.oss.common.HttpProtocol.HTTPS;

    public static com.alibaba.sdk.android.oss.ClientConfiguration getDefaultConf() {
        return new com.alibaba.sdk.android.oss.ClientConfiguration();
    }

    public int getConnectionTimeout() {
        return this.connectionTimeout;
    }

    public java.util.List<java.lang.String> getCustomCnameExcludeList() {
        return java.util.Collections.unmodifiableList(this.customCnameExcludeList);
    }

    public java.lang.String getCustomUserMark() {
        return this.mUserAgentMark;
    }

    public java.util.concurrent.ExecutorService getExecutorService() {
        return this.executorService;
    }

    public com.alibaba.sdk.android.oss.common.HttpProtocol getHttpProtocol() {
        return this.httpProtocol;
    }

    public java.lang.String getIpWithHeader() {
        return this.ipWithHeader;
    }

    public int getMaxConcurrentRequest() {
        return this.maxConcurrentRequest;
    }

    public int getMaxConcurrentRequestsPerHost() {
        return this.maxConcurrentRequestsPerHost;
    }

    public int getMaxErrorRetry() {
        return this.maxErrorRetry;
    }

    public long getMaxLogSize() {
        return this.max_log_size;
    }

    public okhttp3.OkHttpClient getOkHttpClient() {
        return this.okHttpClient;
    }

    public java.lang.String getProxyHost() {
        return this.proxyHost;
    }

    public int getProxyPort() {
        return this.proxyPort;
    }

    public com.alibaba.sdk.android.oss.signer.SignVersion getSignVersion() {
        return this.signVersion;
    }

    public int getSocketTimeout() {
        return this.socketTimeout;
    }

    public boolean isCheckCRC64() {
        return this.checkCRC64;
    }

    public boolean isCustomPathPrefixEnable() {
        return this.customPathPrefixEnable;
    }

    public boolean isFollowRedirectsEnable() {
        return this.followRedirectsEnable;
    }

    public boolean isHttpDnsEnable() {
        return this.httpDnsEnable;
    }

    public boolean isPathStyleAccessEnable() {
        return this.pathStyleAccessEnable;
    }

    public void setCheckCRC64(boolean z) {
        this.checkCRC64 = z;
    }

    public void setConnectionTimeout(int i) {
        this.connectionTimeout = i;
    }

    public void setCustomCnameExcludeList(java.util.List<java.lang.String> list) {
        if (list == null || list.size() == 0) {
            throw new java.lang.IllegalArgumentException("cname exclude list should not be null.");
        }
        this.customCnameExcludeList.clear();
        for (java.lang.String str : list) {
            if (str.contains("://")) {
                this.customCnameExcludeList.add(str.substring(str.indexOf("://") + 3));
            } else {
                this.customCnameExcludeList.add(str);
            }
        }
    }

    public void setCustomPathPrefixEnable(boolean z) {
        this.customPathPrefixEnable = z;
    }

    public void setExecutorService(java.util.concurrent.ExecutorService executorService) {
        this.executorService = executorService;
    }

    public void setFollowRedirectsEnable(boolean z) {
        this.followRedirectsEnable = z;
    }

    public void setHttpDnsEnable(boolean z) {
        this.httpDnsEnable = z;
    }

    public void setHttpProtocol(com.alibaba.sdk.android.oss.common.HttpProtocol httpProtocol) {
        this.httpProtocol = httpProtocol;
    }

    public void setIpWithHeader(java.lang.String str) {
        this.ipWithHeader = str;
    }

    public void setMaxConcurrentRequest(int i) {
        this.maxConcurrentRequest = i;
    }

    public void setMaxConcurrentRequestsPerHost(int i) {
        this.maxConcurrentRequestsPerHost = i;
    }

    public void setMaxErrorRetry(int i) {
        this.maxErrorRetry = i;
    }

    public void setMaxLogSize(long j) {
        this.max_log_size = j;
    }

    public void setOkHttpClient(okhttp3.OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }

    public void setPathStyleAccessEnable(boolean z) {
        this.pathStyleAccessEnable = z;
    }

    public void setProxyHost(java.lang.String str) {
        this.proxyHost = str;
    }

    public void setProxyPort(int i) {
        this.proxyPort = i;
    }

    public void setSignVersion(com.alibaba.sdk.android.oss.signer.SignVersion signVersion) {
        this.signVersion = signVersion;
    }

    public void setSocketTimeout(int i) {
        this.socketTimeout = i;
    }

    public void setUserAgentMark(java.lang.String str) {
        this.mUserAgentMark = str;
    }
}
