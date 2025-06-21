package com.aliyun.utils;

/* loaded from: classes12.dex */
public abstract class a {
    private static final int CONNECTION_TIMEOUT = 10000;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0062 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.net.HttpURLConnection] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void doHttpGet(java.lang.String str) {
        java.net.HttpURLConnection httpURLConnection;
        java.net.URL url;
        java.io.InputStream errorStream;
        java.io.InputStream inputStream = null;
        try {
            try {
                url = new java.net.URL(str);
            } catch (java.lang.Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (java.io.IOException unused) {
                    }
                }
                if (str != 0) {
                    throw th;
                }
                str.disconnect();
                throw th;
            }
        } catch (java.lang.Exception e) {
            e = e;
            httpURLConnection = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            str = 0;
            if (0 != 0) {
            }
            if (str != 0) {
            }
        }
        if (url.openConnection() instanceof java.net.HttpURLConnection) {
            httpURLConnection = (java.net.HttpURLConnection) url.openConnection();
            try {
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setReadTimeout(10000);
                httpURLConnection.connect();
                if (httpURLConnection.getResponseCode() == 200) {
                    errorStream = httpURLConnection.getInputStream();
                    handleOKInputStream(errorStream);
                } else {
                    errorStream = httpURLConnection.getErrorStream();
                    handleErrorInputStream(errorStream);
                }
                if (errorStream != null) {
                    try {
                        errorStream.close();
                    } catch (java.io.IOException unused2) {
                    }
                }
            } catch (java.lang.Exception e2) {
                e = e2;
                com.cicada.player.utils.Logger.w("HttpClientUtil", e.getMessage());
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (java.io.IOException unused3) {
                    }
                }
                if (httpURLConnection == null) {
                    return;
                }
                httpURLConnection.disconnect();
            }
            httpURLConnection.disconnect();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0062 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.net.HttpURLConnection] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void doHttpsGet(java.lang.String str) {
        javax.net.ssl.HttpsURLConnection httpsURLConnection;
        java.net.URL url;
        java.io.InputStream errorStream;
        java.io.InputStream inputStream = null;
        try {
            try {
                url = new java.net.URL(str);
            } catch (java.lang.Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (java.io.IOException unused) {
                    }
                }
                if (str != 0) {
                    throw th;
                }
                str.disconnect();
                throw th;
            }
        } catch (java.lang.Exception e) {
            e = e;
            httpsURLConnection = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            str = 0;
            if (0 != 0) {
            }
            if (str != 0) {
            }
        }
        if (url.openConnection() instanceof javax.net.ssl.HttpsURLConnection) {
            httpsURLConnection = (javax.net.ssl.HttpsURLConnection) url.openConnection();
            try {
                httpsURLConnection.setRequestMethod("GET");
                httpsURLConnection.setConnectTimeout(10000);
                httpsURLConnection.setReadTimeout(10000);
                httpsURLConnection.connect();
                if (httpsURLConnection.getResponseCode() == 200) {
                    errorStream = httpsURLConnection.getInputStream();
                    handleOKInputStream(errorStream);
                } else {
                    errorStream = httpsURLConnection.getErrorStream();
                    handleErrorInputStream(errorStream);
                }
                if (errorStream != null) {
                    try {
                        errorStream.close();
                    } catch (java.io.IOException unused2) {
                    }
                }
            } catch (java.lang.Exception e2) {
                e = e2;
                com.cicada.player.utils.Logger.d("HttpClientUtil", e.getMessage());
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (java.io.IOException unused3) {
                    }
                }
                if (httpsURLConnection == null) {
                    return;
                }
                httpsURLConnection.disconnect();
            }
            httpsURLConnection.disconnect();
        }
    }

    public void doGet(java.lang.String str) {
        if (str.startsWith("https://")) {
            doHttpsGet(str);
        } else if (str.startsWith("http://")) {
            doHttpGet(str);
        }
    }

    public abstract void handleErrorInputStream(java.io.InputStream inputStream);

    public abstract void handleOKInputStream(java.io.InputStream inputStream);
}
