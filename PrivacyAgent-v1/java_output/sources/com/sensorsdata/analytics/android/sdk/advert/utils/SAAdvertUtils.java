package com.sensorsdata.analytics.android.sdk.advert.utils;

/* loaded from: classes19.dex */
public class SAAdvertUtils {
    private static final java.lang.String TAG = "SA.SAAdvert";

    public static java.lang.String getIdentifier(android.content.Context context) {
        return com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils.getIdentifier(context);
    }

    public static java.lang.String getInstallSource(android.content.Context context) {
        return java.lang.String.format("imei=%s##imei_old=%s##imei_slot1=%s##imei_slot2=%s##imei_meid=%s", "", "", "", "", "");
    }

    public static boolean isFirstTrackInstallation(boolean z) {
        return z ? com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader.getInstance().getFirstInstallationWithCallbackPst().get().booleanValue() : com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader.getInstance().getFirstInstallationPst().get().booleanValue();
    }

    public static boolean isInstallationTracked() {
        return com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager.getInstance().isExists(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PersistentName.FIRST_INSTALL) || com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager.getInstance().isExists(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PersistentName.FIRST_INSTALL_CALLBACK);
    }

    public static void sendData(android.content.Context context, java.lang.String str, org.json.JSONObject jSONObject, java.lang.String str2) {
        java.lang.String str3;
        if (!com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().isNetworkRequestEnable()) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "NetworkRequest is disabled");
            return;
        }
        if (com.sensorsdata.analytics.android.sdk.util.NetworkUtils.isNetworkAvailable(context) && jSONObject != null && jSONObject.length() > 0) {
            try {
                org.json.JSONArray jSONArray = new org.json.JSONArray();
                jSONArray.put(jSONObject);
                java.lang.String jSONArray2 = jSONArray.toString();
                if (jSONObject.has("ekey")) {
                    str3 = "9";
                } else {
                    jSONArray2 = com.sensorsdata.analytics.android.sdk.util.SADataHelper.gzipData(jSONArray2);
                    str3 = "1";
                }
                jSONObject.put("_flush_time", java.lang.System.currentTimeMillis());
                sendHttpRequest(str, java.lang.String.valueOf(jSONArray2.hashCode()), str3, jSONArray2, str2);
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v15, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v9, types: [java.net.HttpURLConnection, java.net.URLConnection] */
    private static synchronized void sendHttpRequest(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) throws com.sensorsdata.analytics.android.sdk.exceptions.ConnectErrorException, com.sensorsdata.analytics.android.sdk.exceptions.ResponseErrorException {
        java.net.HttpURLConnection httpURLConnection;
        java.io.OutputStream outputStream;
        java.io.BufferedOutputStream bufferedOutputStream;
        ?? r2;
        ?? r22;
        java.net.HttpURLConnection httpURLConnection2;
        ?? r8;
        java.net.URL url;
        synchronized (com.sensorsdata.analytics.android.sdk.advert.utils.SAAdvertUtils.class) {
            java.io.BufferedOutputStream bufferedOutputStream2 = null;
            try {
                url = new java.net.URL(str);
                r8 = (java.net.HttpURLConnection) url.openConnection();
            } catch (java.io.IOException e) {
                e = e;
                outputStream = null;
                bufferedOutputStream = null;
                r2 = 0;
            } catch (java.lang.Throwable th) {
                th = th;
                httpURLConnection = null;
                outputStream = null;
            }
            try {
                if (r8 == 0) {
                    com.sensorsdata.analytics.android.sdk.SALog.i(TAG, java.lang.String.format("can not connect %s, it shouldn't happen", url));
                    com.sensorsdata.analytics.android.sdk.util.SADataHelper.closeStream(null, null, null, r8);
                    return;
                }
                r8.setInstanceFollowRedirects(false);
                android.net.Uri.Builder builder = new android.net.Uri.Builder();
                if (!android.text.TextUtils.isEmpty(str2)) {
                    builder.appendQueryParameter("crc", str2);
                }
                builder.appendQueryParameter("gzip", str3);
                builder.appendQueryParameter("data_list", str4);
                builder.appendQueryParameter("sink_name", "mirror");
                java.lang.String encodedQuery = builder.build().getEncodedQuery();
                if (android.text.TextUtils.isEmpty(encodedQuery)) {
                    com.sensorsdata.analytics.android.sdk.util.SADataHelper.closeStream(null, null, null, r8);
                    return;
                }
                r8.setFixedLengthStreamingMode(encodedQuery.getBytes("UTF-8").length);
                r8.setDoOutput(true);
                r8.setRequestMethod("POST");
                r8.setConnectTimeout(30000);
                r8.setReadTimeout(30000);
                outputStream = r8.getOutputStream();
                try {
                    bufferedOutputStream = new java.io.BufferedOutputStream(outputStream);
                    try {
                        bufferedOutputStream.write(encodedQuery.getBytes("UTF-8"));
                        bufferedOutputStream.flush();
                        int responseCode = r8.getResponseCode();
                        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "responseCode: " + responseCode);
                        try {
                            r2 = r8.getInputStream();
                        } catch (java.io.FileNotFoundException unused) {
                            r2 = r8.getErrorStream();
                        }
                        try {
                            byte[] slurp = com.sensorsdata.analytics.android.sdk.util.SADataHelper.slurp(r2);
                            r2.close();
                            java.lang.String str6 = new java.lang.String(slurp, "UTF-8");
                            if (com.sensorsdata.analytics.android.sdk.SALog.isLogEnabled()) {
                                java.lang.String formatJson = com.sensorsdata.analytics.android.sdk.util.JSONUtils.formatJson(str5);
                                if (responseCode < 200 || responseCode >= 300) {
                                    com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "sat invalid message: \n" + formatJson);
                                    com.sensorsdata.analytics.android.sdk.SALog.i(TAG, java.lang.String.format(com.sensorsdata.analytics.android.sdk.util.TimeUtils.SDK_LOCALE, "ret_code: %d", java.lang.Integer.valueOf(responseCode)));
                                    com.sensorsdata.analytics.android.sdk.SALog.i(TAG, java.lang.String.format(com.sensorsdata.analytics.android.sdk.util.TimeUtils.SDK_LOCALE, "ret_content: %s", str6));
                                } else {
                                    com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "sat valid message: \n" + formatJson);
                                }
                            }
                            com.sensorsdata.analytics.android.sdk.util.SADataHelper.closeStream(bufferedOutputStream, outputStream, null, r8);
                        } catch (java.io.IOException e2) {
                            e = e2;
                            bufferedOutputStream2 = r8;
                            r2 = r2;
                            try {
                                throw new com.sensorsdata.analytics.android.sdk.exceptions.ConnectErrorException(e);
                            } catch (java.lang.Throwable th2) {
                                th = th2;
                                r8 = bufferedOutputStream2;
                                bufferedOutputStream2 = bufferedOutputStream;
                                r22 = r2;
                                httpURLConnection2 = r8;
                                com.sensorsdata.analytics.android.sdk.util.SADataHelper.closeStream(bufferedOutputStream2, outputStream, r22, httpURLConnection2);
                                throw th;
                            }
                        } catch (java.lang.Throwable th3) {
                            th = th3;
                            bufferedOutputStream2 = bufferedOutputStream;
                            r22 = r2;
                            httpURLConnection2 = r8;
                            com.sensorsdata.analytics.android.sdk.util.SADataHelper.closeStream(bufferedOutputStream2, outputStream, r22, httpURLConnection2);
                            throw th;
                        }
                    } catch (java.io.IOException e3) {
                        e = e3;
                        r2 = 0;
                    } catch (java.lang.Throwable th4) {
                        th = th4;
                        r2 = 0;
                    }
                } catch (java.io.IOException e4) {
                    e = e4;
                    bufferedOutputStream = null;
                    r2 = bufferedOutputStream;
                    bufferedOutputStream2 = r8;
                    r2 = r2;
                    throw new com.sensorsdata.analytics.android.sdk.exceptions.ConnectErrorException(e);
                } catch (java.lang.Throwable th5) {
                    th = th5;
                    r22 = 0;
                    httpURLConnection2 = r8;
                    com.sensorsdata.analytics.android.sdk.util.SADataHelper.closeStream(bufferedOutputStream2, outputStream, r22, httpURLConnection2);
                    throw th;
                }
            } catch (java.io.IOException e5) {
                e = e5;
                outputStream = null;
                bufferedOutputStream = null;
            } catch (java.lang.Throwable th6) {
                th = th6;
                outputStream = null;
                httpURLConnection = r8;
                r22 = outputStream;
                httpURLConnection2 = httpURLConnection;
                com.sensorsdata.analytics.android.sdk.util.SADataHelper.closeStream(bufferedOutputStream2, outputStream, r22, httpURLConnection2);
                throw th;
            }
        }
    }

    public static void setTrackInstallation(boolean z) {
        if (z) {
            com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader.getInstance().getFirstInstallationWithCallbackPst().commit(java.lang.Boolean.FALSE);
        }
        com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader.getInstance().getFirstInstallationPst().commit(java.lang.Boolean.FALSE);
    }
}
