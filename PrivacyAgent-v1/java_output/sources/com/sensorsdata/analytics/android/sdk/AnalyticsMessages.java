package com.sensorsdata.analytics.android.sdk;

/* loaded from: classes19.dex */
public class AnalyticsMessages {
    private static final int DELETE_ALL = 4;
    private static final int FLUSH_INSTANT_EVENT = 7;
    private static final int FLUSH_QUEUE = 3;
    private static final int FLUSH_SCHEDULE = 5;
    private static final java.util.Map<android.content.Context, com.sensorsdata.analytics.android.sdk.AnalyticsMessages> S_INSTANCES = new java.util.HashMap();
    private static final java.lang.String TAG = "SA.AnalyticsMessages";
    private final android.content.Context mContext;
    private final com.sensorsdata.analytics.android.sdk.internal.beans.InternalConfigOptions mInternalConfigs;
    private final com.sensorsdata.analytics.android.sdk.SensorsDataAPI mSensorsDataAPI;
    private final com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter mDbAdapter = com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter.getInstance();
    private final com.sensorsdata.analytics.android.sdk.AnalyticsMessages.Worker mWorker = new com.sensorsdata.analytics.android.sdk.AnalyticsMessages.Worker();

    public class Worker {
        private final android.os.Handler mHandler;
        private final java.lang.Object mHandlerLock = new java.lang.Object();

        public class AnalyticsMessageHandler extends android.os.Handler {
            public AnalyticsMessageHandler(android.os.Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public void handleMessage(android.os.Message message) {
                try {
                    int i = message.what;
                    if (i == 3) {
                        com.sensorsdata.analytics.android.sdk.AnalyticsMessages.this.sendData(true);
                        com.sensorsdata.analytics.android.sdk.AnalyticsMessages.this.sendData(false);
                    } else if (i == 4) {
                        try {
                            com.sensorsdata.analytics.android.sdk.AnalyticsMessages.this.mDbAdapter.deleteAllEvents();
                        } catch (java.lang.Exception e) {
                            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                        }
                    } else if (i == 5) {
                        com.sensorsdata.analytics.android.sdk.AnalyticsMessages.this.flushScheduled();
                        com.sensorsdata.analytics.android.sdk.AnalyticsMessages.this.sendData(false);
                    } else if (i == 7) {
                        com.sensorsdata.analytics.android.sdk.AnalyticsMessages.this.sendData(true);
                    } else {
                        com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.AnalyticsMessages.TAG, "Unexpected message received by SensorsData worker: " + message);
                    }
                } catch (java.lang.RuntimeException e2) {
                    com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.AnalyticsMessages.TAG, "Worker threw an unhandled exception", e2);
                }
            }
        }

        public Worker() {
            android.os.HandlerThread handlerThread = new android.os.HandlerThread("com.sensorsdata.analytics.android.sdk.AnalyticsMessages.Worker", 1);
            handlerThread.start();
            this.mHandler = new com.sensorsdata.analytics.android.sdk.AnalyticsMessages.Worker.AnalyticsMessageHandler(handlerThread.getLooper());
        }

        public void runMessage(android.os.Message message) {
            synchronized (this.mHandlerLock) {
                android.os.Handler handler = this.mHandler;
                if (handler == null) {
                    com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.AnalyticsMessages.TAG, "Dead worker dropping a message: " + message.what);
                } else {
                    handler.sendMessage(message);
                }
            }
        }

        public void runMessageOnce(android.os.Message message, long j) {
            synchronized (this.mHandlerLock) {
                android.os.Handler handler = this.mHandler;
                if (handler == null) {
                    com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.AnalyticsMessages.TAG, "Dead worker dropping a message: " + message.what);
                } else if (!handler.hasMessages(message.what)) {
                    this.mHandler.sendMessageDelayed(message, j);
                }
            }
        }
    }

    private AnalyticsMessages(android.content.Context context, com.sensorsdata.analytics.android.sdk.SensorsDataAPI sensorsDataAPI, com.sensorsdata.analytics.android.sdk.internal.beans.InternalConfigOptions internalConfigOptions) {
        this.mContext = context;
        this.mSensorsDataAPI = sensorsDataAPI;
        this.mInternalConfigs = internalConfigOptions;
    }

    public static com.sensorsdata.analytics.android.sdk.AnalyticsMessages getInstance(android.content.Context context) {
        return S_INSTANCES.get(context);
    }

    public static com.sensorsdata.analytics.android.sdk.AnalyticsMessages getInstance(android.content.Context context, com.sensorsdata.analytics.android.sdk.SensorsDataAPI sensorsDataAPI, com.sensorsdata.analytics.android.sdk.internal.beans.InternalConfigOptions internalConfigOptions) {
        com.sensorsdata.analytics.android.sdk.AnalyticsMessages analyticsMessages;
        java.util.Map<android.content.Context, com.sensorsdata.analytics.android.sdk.AnalyticsMessages> map = S_INSTANCES;
        synchronized (map) {
            android.content.Context applicationContext = context.getApplicationContext();
            if (map.containsKey(applicationContext)) {
                analyticsMessages = map.get(applicationContext);
            } else {
                analyticsMessages = new com.sensorsdata.analytics.android.sdk.AnalyticsMessages(applicationContext, sensorsDataAPI, internalConfigOptions);
                map.put(applicationContext, analyticsMessages);
            }
        }
        return analyticsMessages;
    }

    private boolean isDeleteEventsByCode(int i) {
        return (i == 404 || i == 403 || (i >= 500 && i < 600)) ? false : true;
    }

    private boolean sendCheck() {
        try {
            if (!this.mSensorsDataAPI.isNetworkRequestEnable()) {
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "NetworkRequest is disabled");
                return false;
            }
            if (android.text.TextUtils.isEmpty(this.mSensorsDataAPI.getServerUrl())) {
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "Server url is null or empty.");
                return false;
            }
            if (!com.sensorsdata.analytics.android.sdk.util.NetworkUtils.isNetworkAvailable(this.mContext)) {
                return false;
            }
            java.lang.String networkType = com.sensorsdata.analytics.android.sdk.util.NetworkUtils.networkType(this.mContext);
            if (!com.sensorsdata.analytics.android.sdk.util.NetworkUtils.isShouldFlush(networkType, this.mSensorsDataAPI.getSAContextManager().getInternalConfigs().saConfigOptions.mNetworkTypePolicy)) {
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, java.lang.String.format("Invalid NetworkType = %s", networkType));
                return false;
            }
            if (this.mInternalConfigs.saConfigOptions.isMultiProcessFlush()) {
                if (com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter.getInstance().isSubProcessFlushing()) {
                    return false;
                }
                com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter.getInstance().commitSubProcessFlushState(true);
            } else if (!this.mInternalConfigs.isMainProcess) {
                return false;
            }
            return true;
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0274 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0296 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void sendData(boolean z) {
        java.lang.String[] generateDataString;
        boolean z2;
        java.lang.String str;
        java.lang.String format;
        java.lang.String str2;
        java.lang.String format2;
        boolean isDebugMode;
        if (!sendCheck()) {
            return;
        }
        int i = 100;
        while (true) {
            int i2 = 0;
            if (i <= 0) {
                if (this.mInternalConfigs.saConfigOptions.isMultiProcessFlush()) {
                    com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter.getInstance().commitSubProcessFlushState(false);
                    return;
                }
                return;
            }
            synchronized (this.mDbAdapter) {
                generateDataString = this.mSensorsDataAPI.isDebugMode() ? this.mDbAdapter.generateDataString("events", 1, z) : this.mDbAdapter.generateDataString("events", 50, z);
            }
            if (generateDataString == null) {
                com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter.getInstance().commitSubProcessFlushState(false);
                return;
            }
            java.lang.String str3 = generateDataString[0];
            java.lang.String str4 = generateDataString[1];
            java.lang.String str5 = generateDataString[2];
            try {
                try {
                    java.lang.String gzipData = "1".equals(str5) ? com.sensorsdata.analytics.android.sdk.util.SADataHelper.gzipData(str4) : str4;
                    if (!android.text.TextUtils.isEmpty(gzipData)) {
                        sendHttpRequest(this.mSensorsDataAPI.getServerUrl(), gzipData, str5, str4, false, z);
                    }
                    boolean isDebugMode2 = this.mSensorsDataAPI.isDebugMode();
                    if (!android.text.TextUtils.isEmpty(null) && (isDebugMode2 || com.sensorsdata.analytics.android.sdk.SALog.isLogEnabled())) {
                        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, (java.lang.String) null);
                        if (isDebugMode2 && this.mInternalConfigs.isShowDebugView) {
                            com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.showHttpErrorDialog(com.sensorsdata.analytics.android.sdk.util.AppStateTools.getInstance().getForegroundActivity(), null);
                        }
                    }
                    try {
                        i = this.mDbAdapter.cleanupEvents(new org.json.JSONArray(str3), z);
                    } catch (java.lang.Exception e) {
                        com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                    }
                    str2 = TAG;
                    format2 = java.lang.String.format(com.sensorsdata.analytics.android.sdk.util.TimeUtils.SDK_LOCALE, "Events flushed. [left = %d]", java.lang.Integer.valueOf(i));
                } catch (java.lang.Throwable th) {
                    th = th;
                    z2 = true;
                    isDebugMode = this.mSensorsDataAPI.isDebugMode();
                    if (!android.text.TextUtils.isEmpty(null)) {
                    }
                    if (!z2) {
                    }
                    try {
                        i = this.mDbAdapter.cleanupEvents(new org.json.JSONArray(str3), z);
                    } catch (java.lang.Exception e2) {
                        com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e2);
                    }
                    com.sensorsdata.analytics.android.sdk.SALog.i(TAG, java.lang.String.format(com.sensorsdata.analytics.android.sdk.util.TimeUtils.SDK_LOCALE, "Events flushed. [left = %d]", java.lang.Integer.valueOf(i)));
                    throw th;
                }
            } catch (com.sensorsdata.analytics.android.sdk.exceptions.ConnectErrorException e3) {
                java.lang.String str6 = "Connection error: " + e3.getMessage();
                boolean isDebugMode3 = this.mSensorsDataAPI.isDebugMode();
                if (!android.text.TextUtils.isEmpty(str6) && (isDebugMode3 || com.sensorsdata.analytics.android.sdk.SALog.isLogEnabled())) {
                    com.sensorsdata.analytics.android.sdk.SALog.i(TAG, str6);
                    if (isDebugMode3 && this.mInternalConfigs.isShowDebugView) {
                        com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.showHttpErrorDialog(com.sensorsdata.analytics.android.sdk.util.AppStateTools.getInstance().getForegroundActivity(), str6);
                    }
                }
                if (isDebugMode3) {
                    try {
                        i = this.mDbAdapter.cleanupEvents(new org.json.JSONArray(str3), z);
                    } catch (java.lang.Exception e4) {
                        com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e4);
                    }
                    str = TAG;
                    format = java.lang.String.format(com.sensorsdata.analytics.android.sdk.util.TimeUtils.SDK_LOCALE, "Events flushed. [left = %d]", java.lang.Integer.valueOf(i));
                    com.sensorsdata.analytics.android.sdk.SALog.i(str, format);
                    i2 = i;
                }
                i = i2;
            } catch (com.sensorsdata.analytics.android.sdk.exceptions.InvalidDataException e5) {
                java.lang.String str7 = "Invalid data: " + e5.getMessage();
                boolean isDebugMode4 = this.mSensorsDataAPI.isDebugMode();
                if (!android.text.TextUtils.isEmpty(str7) && (isDebugMode4 || com.sensorsdata.analytics.android.sdk.SALog.isLogEnabled())) {
                    com.sensorsdata.analytics.android.sdk.SALog.i(TAG, str7);
                    if (isDebugMode4 && this.mInternalConfigs.isShowDebugView) {
                        com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.showHttpErrorDialog(com.sensorsdata.analytics.android.sdk.util.AppStateTools.getInstance().getForegroundActivity(), str7);
                    }
                }
                try {
                    i = this.mDbAdapter.cleanupEvents(new org.json.JSONArray(str3), z);
                } catch (java.lang.Exception e6) {
                    com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e6);
                }
                str2 = TAG;
                format2 = java.lang.String.format(com.sensorsdata.analytics.android.sdk.util.TimeUtils.SDK_LOCALE, "Events flushed. [left = %d]", java.lang.Integer.valueOf(i));
            } catch (com.sensorsdata.analytics.android.sdk.exceptions.ResponseErrorException e7) {
                z2 = isDeleteEventsByCode(e7.getHttpCode());
                try {
                    java.lang.String str8 = "ResponseErrorException: " + e7.getMessage();
                    boolean isDebugMode5 = this.mSensorsDataAPI.isDebugMode();
                    if (!android.text.TextUtils.isEmpty(str8) && (isDebugMode5 || com.sensorsdata.analytics.android.sdk.SALog.isLogEnabled())) {
                        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, str8);
                        if (isDebugMode5 && this.mInternalConfigs.isShowDebugView) {
                            com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.showHttpErrorDialog(com.sensorsdata.analytics.android.sdk.util.AppStateTools.getInstance().getForegroundActivity(), str8);
                        }
                    }
                    if (z2 || isDebugMode5) {
                        try {
                            i = this.mDbAdapter.cleanupEvents(new org.json.JSONArray(str3), z);
                        } catch (java.lang.Exception e8) {
                            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e8);
                        }
                        str = TAG;
                        format = java.lang.String.format(com.sensorsdata.analytics.android.sdk.util.TimeUtils.SDK_LOCALE, "Events flushed. [left = %d]", java.lang.Integer.valueOf(i));
                        com.sensorsdata.analytics.android.sdk.SALog.i(str, format);
                        i2 = i;
                    }
                    i = i2;
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    isDebugMode = this.mSensorsDataAPI.isDebugMode();
                    if (!android.text.TextUtils.isEmpty(null)) {
                        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, (java.lang.String) null);
                        if (isDebugMode) {
                            com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.showHttpErrorDialog(com.sensorsdata.analytics.android.sdk.util.AppStateTools.getInstance().getForegroundActivity(), null);
                        }
                    }
                    if (!z2) {
                    }
                    i = this.mDbAdapter.cleanupEvents(new org.json.JSONArray(str3), z);
                    com.sensorsdata.analytics.android.sdk.SALog.i(TAG, java.lang.String.format(com.sensorsdata.analytics.android.sdk.util.TimeUtils.SDK_LOCALE, "Events flushed. [left = %d]", java.lang.Integer.valueOf(i)));
                    throw th;
                }
            } catch (java.lang.Exception e9) {
                try {
                    java.lang.String str9 = "Exception: " + e9.getMessage();
                    boolean isDebugMode6 = this.mSensorsDataAPI.isDebugMode();
                    if (!android.text.TextUtils.isEmpty(str9) && (isDebugMode6 || com.sensorsdata.analytics.android.sdk.SALog.isLogEnabled())) {
                        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, str9);
                        if (isDebugMode6 && this.mInternalConfigs.isShowDebugView) {
                            com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.showHttpErrorDialog(com.sensorsdata.analytics.android.sdk.util.AppStateTools.getInstance().getForegroundActivity(), str9);
                        }
                    }
                    if (isDebugMode6) {
                        try {
                            i = this.mDbAdapter.cleanupEvents(new org.json.JSONArray(str3), z);
                        } catch (java.lang.Exception e10) {
                            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e10);
                        }
                        str = TAG;
                        format = java.lang.String.format(com.sensorsdata.analytics.android.sdk.util.TimeUtils.SDK_LOCALE, "Events flushed. [left = %d]", java.lang.Integer.valueOf(i));
                        com.sensorsdata.analytics.android.sdk.SALog.i(str, format);
                        i2 = i;
                    }
                    i = i2;
                } catch (java.lang.Throwable th3) {
                    th = th3;
                    z2 = false;
                    isDebugMode = this.mSensorsDataAPI.isDebugMode();
                    if (!android.text.TextUtils.isEmpty(null) && (isDebugMode || com.sensorsdata.analytics.android.sdk.SALog.isLogEnabled())) {
                        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, (java.lang.String) null);
                        if (isDebugMode && this.mInternalConfigs.isShowDebugView) {
                            com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.showHttpErrorDialog(com.sensorsdata.analytics.android.sdk.util.AppStateTools.getInstance().getForegroundActivity(), null);
                        }
                    }
                    if (!z2 || isDebugMode) {
                        i = this.mDbAdapter.cleanupEvents(new org.json.JSONArray(str3), z);
                        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, java.lang.String.format(com.sensorsdata.analytics.android.sdk.util.TimeUtils.SDK_LOCALE, "Events flushed. [left = %d]", java.lang.Integer.valueOf(i)));
                    }
                    throw th;
                }
            }
            com.sensorsdata.analytics.android.sdk.SALog.i(str2, format2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v2 */
    private void sendHttpRequest(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, boolean z, boolean z2) throws com.sensorsdata.analytics.android.sdk.exceptions.ConnectErrorException, com.sensorsdata.analytics.android.sdk.exceptions.ResponseErrorException {
        java.io.InputStream inputStream;
        java.net.HttpURLConnection httpURLConnection;
        java.io.OutputStream outputStream;
        java.io.BufferedOutputStream bufferedOutputStream;
        java.io.InputStream errorStream;
        javax.net.ssl.SSLSocketFactory sSLSocketFactory;
        java.io.BufferedOutputStream bufferedOutputStream2 = null;
        try {
            java.net.URL url = new java.net.URL(str);
            java.net.HttpURLConnection httpURLConnection2 = (java.net.HttpURLConnection) url.openConnection();
            try {
                if (httpURLConnection2 == 0) {
                    com.sensorsdata.analytics.android.sdk.SALog.i(TAG, java.lang.String.format("can not connect %s, it shouldn't happen", url));
                    com.sensorsdata.analytics.android.sdk.util.SADataHelper.closeStream(null, null, null, httpURLConnection2);
                    return;
                }
                com.sensorsdata.analytics.android.sdk.SAConfigOptions configOptions = com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.getConfigOptions();
                if (configOptions != null && (sSLSocketFactory = configOptions.mSSLSocketFactory) != null && (httpURLConnection2 instanceof javax.net.ssl.HttpsURLConnection)) {
                    ((javax.net.ssl.HttpsURLConnection) httpURLConnection2).setSSLSocketFactory(sSLSocketFactory);
                }
                httpURLConnection2.setInstanceFollowRedirects(false);
                if (this.mSensorsDataAPI.getDebugMode() == com.sensorsdata.analytics.android.sdk.SensorsDataAPI.DebugMode.DEBUG_ONLY) {
                    httpURLConnection2.addRequestProperty("Dry-Run", com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE);
                }
                java.lang.String cookie = this.mSensorsDataAPI.getCookie(false);
                if (!android.text.TextUtils.isEmpty(cookie)) {
                    httpURLConnection2.setRequestProperty(com.google.common.net.HttpHeaders.COOKIE, cookie);
                }
                android.net.Uri.Builder builder = new android.net.Uri.Builder();
                if (!android.text.TextUtils.isEmpty(str2)) {
                    builder.appendQueryParameter("crc", java.lang.String.valueOf(str2.hashCode()));
                }
                builder.appendQueryParameter("gzip", str3);
                builder.appendQueryParameter("data_list", str2);
                if (z2) {
                    builder.appendQueryParameter("instant_event", com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE);
                }
                java.lang.String encodedQuery = builder.build().getEncodedQuery();
                if (android.text.TextUtils.isEmpty(encodedQuery)) {
                    com.sensorsdata.analytics.android.sdk.util.SADataHelper.closeStream(null, null, null, httpURLConnection2);
                    return;
                }
                httpURLConnection2.setFixedLengthStreamingMode(encodedQuery.getBytes("UTF-8").length);
                httpURLConnection2.setDoOutput(true);
                httpURLConnection2.setRequestMethod("POST");
                httpURLConnection2.setConnectTimeout(30000);
                httpURLConnection2.setReadTimeout(30000);
                outputStream = httpURLConnection2.getOutputStream();
                try {
                    bufferedOutputStream = new java.io.BufferedOutputStream(outputStream);
                    try {
                        bufferedOutputStream.write(encodedQuery.getBytes("UTF-8"));
                        bufferedOutputStream.flush();
                        int responseCode = httpURLConnection2.getResponseCode();
                        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "responseCode: " + responseCode);
                        if (!z && com.sensorsdata.analytics.android.sdk.util.NetworkUtils.needRedirects(responseCode)) {
                            java.lang.String location = com.sensorsdata.analytics.android.sdk.util.NetworkUtils.getLocation(httpURLConnection2, str);
                            if (!android.text.TextUtils.isEmpty(location)) {
                                com.sensorsdata.analytics.android.sdk.util.SADataHelper.closeStream(bufferedOutputStream, outputStream, null, httpURLConnection2);
                                sendHttpRequest(location, str2, str3, str4, true, z2);
                                com.sensorsdata.analytics.android.sdk.util.SADataHelper.closeStream(bufferedOutputStream, outputStream, null, httpURLConnection2);
                                return;
                            }
                        }
                        try {
                            errorStream = httpURLConnection2.getInputStream();
                        } catch (java.io.FileNotFoundException unused) {
                            errorStream = httpURLConnection2.getErrorStream();
                        }
                        inputStream = errorStream;
                        try {
                            byte[] slurp = com.sensorsdata.analytics.android.sdk.util.SADataHelper.slurp(inputStream);
                            inputStream.close();
                            java.lang.String str5 = new java.lang.String(slurp, "UTF-8");
                            if (com.sensorsdata.analytics.android.sdk.SALog.isLogEnabled()) {
                                java.lang.String formatJson = com.sensorsdata.analytics.android.sdk.util.JSONUtils.formatJson(str4);
                                if (responseCode < 200 || responseCode >= 300) {
                                    com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "invalid message: \n" + formatJson);
                                    com.sensorsdata.analytics.android.sdk.SALog.i(TAG, java.lang.String.format(com.sensorsdata.analytics.android.sdk.util.TimeUtils.SDK_LOCALE, "ret_code: %d", java.lang.Integer.valueOf(responseCode)));
                                    com.sensorsdata.analytics.android.sdk.SALog.i(TAG, java.lang.String.format(com.sensorsdata.analytics.android.sdk.util.TimeUtils.SDK_LOCALE, "ret_content: %s", str5));
                                } else {
                                    com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "valid message: \n" + formatJson);
                                }
                            }
                            if (responseCode < 200 || responseCode >= 300) {
                                throw new com.sensorsdata.analytics.android.sdk.exceptions.ResponseErrorException(java.lang.String.format("flush failure with response '%s', the response code is '%d'", str5, java.lang.Integer.valueOf(responseCode)), responseCode);
                            }
                            com.sensorsdata.analytics.android.sdk.util.SADataHelper.closeStream(bufferedOutputStream, outputStream, null, httpURLConnection2);
                        } catch (java.io.IOException e) {
                            e = e;
                            bufferedOutputStream2 = httpURLConnection2;
                            try {
                                throw new com.sensorsdata.analytics.android.sdk.exceptions.ConnectErrorException(e);
                            } catch (java.lang.Throwable th) {
                                th = th;
                                httpURLConnection2 = bufferedOutputStream2;
                                bufferedOutputStream2 = bufferedOutputStream;
                                httpURLConnection = httpURLConnection2;
                                com.sensorsdata.analytics.android.sdk.util.SADataHelper.closeStream(bufferedOutputStream2, outputStream, inputStream, httpURLConnection);
                                throw th;
                            }
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                            bufferedOutputStream2 = bufferedOutputStream;
                            httpURLConnection = httpURLConnection2;
                            com.sensorsdata.analytics.android.sdk.util.SADataHelper.closeStream(bufferedOutputStream2, outputStream, inputStream, httpURLConnection);
                            throw th;
                        }
                    } catch (java.io.IOException e2) {
                        e = e2;
                        inputStream = null;
                    } catch (java.lang.Throwable th3) {
                        th = th3;
                        inputStream = null;
                    }
                } catch (java.io.IOException e3) {
                    e = e3;
                    inputStream = null;
                    bufferedOutputStream = null;
                } catch (java.lang.Throwable th4) {
                    th = th4;
                    inputStream = null;
                    httpURLConnection = httpURLConnection2;
                    com.sensorsdata.analytics.android.sdk.util.SADataHelper.closeStream(bufferedOutputStream2, outputStream, inputStream, httpURLConnection);
                    throw th;
                }
            } catch (java.io.IOException e4) {
                e = e4;
                inputStream = null;
                outputStream = null;
                bufferedOutputStream = null;
            } catch (java.lang.Throwable th5) {
                th = th5;
                inputStream = null;
                outputStream = null;
                httpURLConnection = httpURLConnection2;
            }
        } catch (java.io.IOException e5) {
            e = e5;
            inputStream = null;
            outputStream = null;
            bufferedOutputStream = null;
        } catch (java.lang.Throwable th6) {
            th = th6;
            inputStream = null;
            httpURLConnection = null;
            outputStream = null;
        }
    }

    public void deleteAll() {
        try {
            android.os.Message obtain = android.os.Message.obtain();
            obtain.what = 4;
            this.mWorker.runMessage(obtain);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public void flush() {
        try {
            android.os.Message obtain = android.os.Message.obtain();
            obtain.what = 3;
            this.mWorker.runMessage(obtain);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public void flushEventMessage(boolean z) {
        try {
            synchronized (this.mDbAdapter) {
                android.os.Message obtain = android.os.Message.obtain();
                obtain.what = 3;
                if (z) {
                    this.mWorker.runMessage(obtain);
                } else {
                    this.mWorker.runMessageOnce(obtain, this.mSensorsDataAPI.getFlushInterval());
                }
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "enqueueEventMessage error:" + e);
        }
    }

    public void flushInstanceEvent() {
        try {
            android.os.Message obtain = android.os.Message.obtain();
            obtain.what = 7;
            this.mWorker.runMessage(obtain);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public void flushScheduled() {
        try {
            android.os.Message obtain = android.os.Message.obtain();
            obtain.what = 5;
            this.mWorker.runMessageOnce(obtain, this.mSensorsDataAPI.getFlushInterval());
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }
}
