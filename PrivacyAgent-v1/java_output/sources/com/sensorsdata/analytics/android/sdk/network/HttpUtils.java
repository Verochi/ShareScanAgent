package com.sensorsdata.analytics.android.sdk.network;

/* loaded from: classes19.dex */
class HttpUtils {
    private static final int HTTP_307 = 307;

    public static java.lang.String getLocation(java.net.HttpURLConnection httpURLConnection, java.lang.String str) throws java.net.MalformedURLException {
        if (httpURLConnection == null || android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        java.lang.String headerField = httpURLConnection.getHeaderField("Location");
        if (android.text.TextUtils.isEmpty(headerField)) {
            headerField = httpURLConnection.getHeaderField(com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_LOCATION);
        }
        if (android.text.TextUtils.isEmpty(headerField)) {
            return null;
        }
        if (headerField.startsWith("http://") || headerField.startsWith("https://")) {
            return headerField;
        }
        java.net.URL url = new java.net.URL(str);
        return url.getProtocol() + "://" + url.getHost() + headerField;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x006b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0061 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String getRetString(java.io.InputStream inputStream) {
        java.io.BufferedReader bufferedReader;
        java.lang.Throwable th;
        java.lang.Exception e;
        try {
            bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(inputStream, "UTF-8"));
            try {
                try {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    while (true) {
                        java.lang.String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                        sb.append("\n");
                    }
                    inputStream.close();
                    java.lang.String sb2 = sb.toString();
                    try {
                        bufferedReader.close();
                    } catch (java.io.IOException e2) {
                        com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e2);
                    }
                    try {
                        inputStream.close();
                    } catch (java.io.IOException e3) {
                        com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e3);
                    }
                    return sb2;
                } catch (java.lang.Exception e4) {
                    e = e4;
                    com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (java.io.IOException e5) {
                            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e5);
                        }
                    }
                    if (inputStream == null) {
                        return "";
                    }
                    try {
                        inputStream.close();
                        return "";
                    } catch (java.io.IOException e6) {
                        com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e6);
                        return "";
                    }
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (java.io.IOException e7) {
                        com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e7);
                    }
                }
                if (inputStream != null) {
                    throw th;
                }
                try {
                    inputStream.close();
                    throw th;
                } catch (java.io.IOException e8) {
                    com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e8);
                    throw th;
                }
            }
        } catch (java.lang.Exception e9) {
            bufferedReader = null;
            e = e9;
        } catch (java.lang.Throwable th3) {
            bufferedReader = null;
            th = th3;
            if (bufferedReader != null) {
            }
            if (inputStream != null) {
            }
        }
    }

    public static boolean needRedirects(int i) {
        return i == 301 || i == 302 || i == 307;
    }
}
