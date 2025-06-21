package com.alibaba.sdk.android.oss.common.utils;

/* loaded from: classes.dex */
public class HttpdnsMini {
    private static final java.lang.String ACCOUNT_ID = "181345";
    private static final int EMPTY_RESULT_HOST_TTL = 30;
    private static final int MAX_HOLD_HOST_NUM = 100;
    private static final int MAX_THREAD_NUM = 5;
    private static final int RESOLVE_TIMEOUT_IN_SEC = 10;
    private static final java.lang.String SERVER_IP = "203.107.1.1";
    private static final java.lang.String TAG = "HttpDnsMini";
    private static com.alibaba.sdk.android.oss.common.utils.HttpdnsMini instance;
    private java.util.concurrent.ConcurrentMap<java.lang.String, com.alibaba.sdk.android.oss.common.utils.HttpdnsMini.HostObject> hostManager = new java.util.concurrent.ConcurrentHashMap();
    private java.util.concurrent.ExecutorService pool = java.util.concurrent.Executors.newFixedThreadPool(5);

    public class HostObject {
        private java.lang.String hostName;
        private java.lang.String ip;
        private long queryTime;
        private long ttl;

        public HostObject() {
        }

        public java.lang.String getHostName() {
            return this.hostName;
        }

        public java.lang.String getIp() {
            return this.ip;
        }

        public long getQueryTime() {
            return this.queryTime;
        }

        public long getTtl() {
            return this.ttl;
        }

        public boolean isExpired() {
            return getQueryTime() + this.ttl < java.lang.System.currentTimeMillis() / 1000;
        }

        public boolean isStillAvailable() {
            return (getQueryTime() + this.ttl) + 600 > java.lang.System.currentTimeMillis() / 1000;
        }

        public void setHostName(java.lang.String str) {
            this.hostName = str;
        }

        public void setIp(java.lang.String str) {
            this.ip = str;
        }

        public void setQueryTime(long j) {
            this.queryTime = j;
        }

        public void setTtl(long j) {
            this.ttl = j;
        }

        public java.lang.String toString() {
            return "[hostName=" + getHostName() + ", ip=" + this.ip + ", ttl=" + getTtl() + ", queryTime=" + this.queryTime + "]";
        }
    }

    public class QueryHostTask implements java.util.concurrent.Callable<java.lang.String> {
        private boolean hasRetryed = false;
        private java.lang.String hostName;

        public QueryHostTask(java.lang.String str) {
            this.hostName = str;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x015e  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0166 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:54:0x016b A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // java.util.concurrent.Callable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public java.lang.String call() {
            java.io.InputStream inputStream;
            java.io.InputStream inputStream2;
            java.lang.String str = "https://" + com.alibaba.sdk.android.oss.common.utils.HttpdnsMini.SERVER_IP + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + com.alibaba.sdk.android.oss.common.utils.HttpdnsMini.ACCOUNT_ID + "/d?host=" + this.hostName;
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[httpdnsmini] - buildUrl: " + str);
            java.io.InputStream inputStream3 = null;
            try {
                try {
                    java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(str).openConnection();
                    httpURLConnection.setConnectTimeout(10000);
                    httpURLConnection.setReadTimeout(10000);
                    if (httpURLConnection.getResponseCode() != 200) {
                        com.alibaba.sdk.android.oss.common.OSSLog.logError("[httpdnsmini] - responseCodeNot 200, but: " + httpURLConnection.getResponseCode());
                        inputStream2 = null;
                    } else {
                        inputStream2 = httpURLConnection.getInputStream();
                        try {
                            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(inputStream2, "UTF-8"));
                            java.lang.StringBuilder sb = new java.lang.StringBuilder();
                            while (true) {
                                java.lang.String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                sb.append(readLine);
                            }
                            org.json.JSONObject jSONObject = new org.json.JSONObject(sb.toString());
                            java.lang.String string = jSONObject.getString(com.alipay.sdk.m.l.c.f);
                            long j = jSONObject.getLong(com.huawei.hms.push.constant.RemoteMessageConst.TTL);
                            org.json.JSONArray jSONArray = jSONObject.getJSONArray("ips");
                            com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[httpdnsmini] - ips:" + jSONArray.toString());
                            if (string != null && jSONArray.length() > 0) {
                                if (j == 0) {
                                    j = 30;
                                }
                                com.alibaba.sdk.android.oss.common.utils.HttpdnsMini.HostObject hostObject = com.alibaba.sdk.android.oss.common.utils.HttpdnsMini.this.new HostObject();
                                java.lang.String string2 = jSONArray.getString(0);
                                hostObject.setHostName(string);
                                hostObject.setTtl(j);
                                hostObject.setIp(string2);
                                hostObject.setQueryTime(java.lang.System.currentTimeMillis() / 1000);
                                com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[httpdnsmini] - resolve result:" + hostObject.toString());
                                if (com.alibaba.sdk.android.oss.common.utils.HttpdnsMini.this.hostManager.size() < 100) {
                                    com.alibaba.sdk.android.oss.common.utils.HttpdnsMini.this.hostManager.put(this.hostName, hostObject);
                                }
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (java.io.IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                                return string2;
                            }
                        } catch (java.lang.Exception e2) {
                            inputStream = inputStream2;
                            e = e2;
                            try {
                                if (com.alibaba.sdk.android.oss.common.OSSLog.isEnableLog()) {
                                    e.printStackTrace();
                                    com.alibaba.sdk.android.oss.common.OSSLog.logThrowable2Local(e);
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (!this.hasRetryed) {
                                }
                            } catch (java.lang.Throwable th) {
                                th = th;
                                inputStream3 = inputStream;
                                if (inputStream3 != null) {
                                    try {
                                        inputStream3.close();
                                    } catch (java.io.IOException e3) {
                                        e3.printStackTrace();
                                    }
                                }
                                throw th;
                            }
                        } catch (java.lang.Throwable th2) {
                            inputStream3 = inputStream2;
                            th = th2;
                            if (inputStream3 != null) {
                            }
                            throw th;
                        }
                    }
                } catch (java.io.IOException e4) {
                    e4.printStackTrace();
                }
            } catch (java.lang.Exception e5) {
                e = e5;
                inputStream = null;
            } catch (java.lang.Throwable th3) {
                th = th3;
            }
            if (inputStream2 != null) {
                inputStream2.close();
            }
            if (!this.hasRetryed) {
                return null;
            }
            this.hasRetryed = true;
            return call();
        }
    }

    private HttpdnsMini() {
    }

    public static com.alibaba.sdk.android.oss.common.utils.HttpdnsMini getInstance() {
        if (instance == null) {
            synchronized (com.alibaba.sdk.android.oss.common.utils.HttpdnsMini.class) {
                if (instance == null) {
                    instance = new com.alibaba.sdk.android.oss.common.utils.HttpdnsMini();
                }
            }
        }
        return instance;
    }

    public java.lang.String getIpByHostAsync(java.lang.String str) {
        com.alibaba.sdk.android.oss.common.utils.HttpdnsMini.HostObject hostObject = this.hostManager.get(str);
        if (hostObject == null || hostObject.isExpired()) {
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[httpdnsmini] - refresh host: " + str);
            this.pool.submit(new com.alibaba.sdk.android.oss.common.utils.HttpdnsMini.QueryHostTask(str));
        }
        if (hostObject == null || !hostObject.isStillAvailable()) {
            return null;
        }
        return hostObject.getIp();
    }
}
