package com.sensorsdata.analytics.android.sdk.network;

/* loaded from: classes19.dex */
class RealRequest {
    private static final java.lang.String TAG = "SA.HttpRequest";
    private static java.lang.String sRequestURL;
    private com.sensorsdata.analytics.android.sdk.network.HttpConfig httpConfig = new com.sensorsdata.analytics.android.sdk.network.HttpConfig();

    private com.sensorsdata.analytics.android.sdk.network.RealResponse getExceptionResponse(java.lang.Exception exc) {
        com.sensorsdata.analytics.android.sdk.network.RealResponse realResponse = new com.sensorsdata.analytics.android.sdk.network.RealResponse();
        realResponse.exception = exc;
        realResponse.errorMsg = exc.getMessage();
        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, realResponse.toString());
        return realResponse;
    }

    private java.net.HttpURLConnection getHttpURLConnection(java.lang.String str, java.lang.String str2) throws java.io.IOException {
        java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(str).openConnection();
        httpURLConnection.setRequestMethod(str2);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setConnectTimeout(this.httpConfig.getConnectionTimeout());
        httpURLConnection.setReadTimeout(this.httpConfig.getReadTimeout());
        if (str2.equals("POST")) {
            httpURLConnection.setDoOutput(true);
        }
        com.sensorsdata.analytics.android.sdk.SAConfigOptions configOptions = com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.getConfigOptions();
        if (configOptions != null && configOptions.getSSLSocketFactory() != null && (httpURLConnection instanceof javax.net.ssl.HttpsURLConnection)) {
            ((javax.net.ssl.HttpsURLConnection) httpURLConnection).setSSLSocketFactory(configOptions.getSSLSocketFactory());
        }
        return httpURLConnection;
    }

    private com.sensorsdata.analytics.android.sdk.network.RealResponse getRealResponse(java.net.HttpURLConnection httpURLConnection) {
        com.sensorsdata.analytics.android.sdk.network.RealResponse realResponse = new com.sensorsdata.analytics.android.sdk.network.RealResponse();
        try {
            try {
                int responseCode = httpURLConnection.getResponseCode();
                realResponse.code = responseCode;
                if (com.sensorsdata.analytics.android.sdk.network.HttpUtils.needRedirects(responseCode)) {
                    realResponse.location = com.sensorsdata.analytics.android.sdk.network.HttpUtils.getLocation(httpURLConnection, sRequestURL);
                }
                realResponse.contentLength = httpURLConnection.getContentLength();
                if (realResponse.code < 400) {
                    realResponse.result = com.sensorsdata.analytics.android.sdk.network.HttpUtils.getRetString(httpURLConnection.getInputStream());
                } else {
                    realResponse.errorMsg = com.sensorsdata.analytics.android.sdk.network.HttpUtils.getRetString(httpURLConnection.getErrorStream());
                }
                httpURLConnection.disconnect();
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, realResponse.toString());
                return realResponse;
            } catch (java.io.IOException e) {
                com.sensorsdata.analytics.android.sdk.network.RealResponse exceptionResponse = getExceptionResponse(e);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return exceptionResponse;
            }
        } catch (java.lang.Throwable th) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    private void setHeader(java.net.HttpURLConnection httpURLConnection, java.util.Map<java.lang.String, java.lang.String> map) {
        if (map != null) {
            for (java.lang.String str : map.keySet()) {
                httpURLConnection.setRequestProperty(str, map.get(str));
            }
        }
    }

    public com.sensorsdata.analytics.android.sdk.network.RealResponse getData(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map) {
        try {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, java.lang.String.format("url:%s,\nmethod:GET", str));
            sRequestURL = str;
            java.net.HttpURLConnection httpURLConnection = getHttpURLConnection(str, "GET");
            if (map != null) {
                setHeader(httpURLConnection, map);
            }
            httpURLConnection.connect();
            return getRealResponse(httpURLConnection);
        } catch (java.lang.Exception e) {
            return getExceptionResponse(e);
        }
    }

    public com.sensorsdata.analytics.android.sdk.network.RealResponse postData(java.lang.String str, java.lang.String str2, java.lang.String str3, java.util.Map<java.lang.String, java.lang.String> map) {
        java.io.BufferedWriter bufferedWriter = null;
        try {
            try {
                sRequestURL = str;
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, java.lang.String.format("url:%s\nparams:%s\nmethod:POST", str, str2));
                java.net.HttpURLConnection httpURLConnection = getHttpURLConnection(str, "POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                if (!android.text.TextUtils.isEmpty(str3)) {
                    httpURLConnection.setRequestProperty("Content-Type", str3);
                }
                if (map != null) {
                    setHeader(httpURLConnection, map);
                }
                httpURLConnection.connect();
                if (!android.text.TextUtils.isEmpty(str2)) {
                    java.io.BufferedWriter bufferedWriter2 = new java.io.BufferedWriter(new java.io.OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8"));
                    try {
                        bufferedWriter2.write(str2);
                        bufferedWriter2.flush();
                        bufferedWriter = bufferedWriter2;
                    } catch (java.lang.Exception e) {
                        e = e;
                        bufferedWriter = bufferedWriter2;
                        com.sensorsdata.analytics.android.sdk.network.RealResponse exceptionResponse = getExceptionResponse(e);
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.close();
                            } catch (java.io.IOException e2) {
                                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e2);
                            }
                        }
                        return exceptionResponse;
                    } catch (java.lang.Throwable th) {
                        th = th;
                        bufferedWriter = bufferedWriter2;
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.close();
                            } catch (java.io.IOException e3) {
                                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e3);
                            }
                        }
                        throw th;
                    }
                }
                com.sensorsdata.analytics.android.sdk.network.RealResponse realResponse = getRealResponse(httpURLConnection);
                if (bufferedWriter != null) {
                    try {
                        bufferedWriter.close();
                    } catch (java.io.IOException e4) {
                        com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e4);
                    }
                }
                return realResponse;
            } catch (java.lang.Exception e5) {
                e = e5;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    public com.sensorsdata.analytics.android.sdk.network.RealRequest setHttpConfig(com.sensorsdata.analytics.android.sdk.network.HttpConfig httpConfig) {
        if (httpConfig == null) {
            return this;
        }
        this.httpConfig = httpConfig;
        return this;
    }
}
