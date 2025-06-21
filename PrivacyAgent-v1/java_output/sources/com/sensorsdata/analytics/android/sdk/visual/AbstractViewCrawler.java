package com.sensorsdata.analytics.android.sdk.visual;

/* loaded from: classes19.dex */
public abstract class AbstractViewCrawler implements com.sensorsdata.analytics.android.sdk.visual.VTrack {
    private static final int MESSAGE_SEND_STATE_FOR_EDITING = 1;
    private static final java.lang.String TAG = "SA.AbstractViewCrawler";
    public static final java.lang.String TYPE_HEAT_MAP = "heat_map";
    public static final java.lang.String TYPE_VISUAL = "visual";
    private java.lang.String mAppVersion;
    private final android.content.Context mContext;
    private final com.sensorsdata.analytics.android.sdk.visual.snap.EditState mEditState;
    private java.lang.String mFeatureCode;
    private final com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.LifecycleCallbacks mLifecycleCallbacks;
    private final android.os.Handler mMainThreadHandler;
    private final com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.ViewCrawlerHandler mMessageThreadHandler;
    private java.lang.String mPostUrl;
    private boolean mServiceRunning = false;
    private java.lang.String mType;

    public class LifecycleCallbacks implements android.app.Application.ActivityLifecycleCallbacks {
        private LifecycleCallbacks() {
        }

        public /* synthetic */ LifecycleCallbacks(com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler abstractViewCrawler, com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(android.app.Activity activity, android.os.Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(android.app.Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(android.app.Activity activity) {
            com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.this.mEditState.remove(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(android.app.Activity activity) {
            com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.this.mEditState.add(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(android.app.Activity activity, android.os.Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(android.app.Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(android.app.Activity activity) {
        }
    }

    public class ViewCrawlerHandler extends android.os.Handler {
        private java.lang.String mAppId;
        private java.lang.StringBuilder mLastImageHash;
        private final com.sensorsdata.analytics.android.sdk.visual.snap.EditProtocol mProtocol;
        private final java.lang.String mSDKVersion;
        private com.sensorsdata.analytics.android.sdk.visual.ViewSnapshot mSnapshot;
        private boolean mUseGzip;

        private ViewCrawlerHandler(android.content.Context context, android.os.Looper looper, java.lang.String str) {
            super(looper);
            this.mSnapshot = null;
            this.mProtocol = new com.sensorsdata.analytics.android.sdk.visual.snap.EditProtocol(new com.sensorsdata.analytics.android.sdk.visual.snap.ResourceReader.Ids(str, context));
            this.mLastImageHash = new java.lang.StringBuilder();
            this.mUseGzip = true;
            this.mAppId = com.sensorsdata.analytics.android.sdk.util.AppInfoUtils.getProcessName(context);
            this.mSDKVersion = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().getSDKVersion();
        }

        public /* synthetic */ ViewCrawlerHandler(com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler abstractViewCrawler, android.content.Context context, android.os.Looper looper, java.lang.String str, com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.AnonymousClass1 anonymousClass1) {
            this(context, looper, str);
        }

        private void onSnapFinished(com.sensorsdata.analytics.android.sdk.visual.model.SnapInfo snapInfo) {
            if (snapInfo != null && !com.sensorsdata.analytics.android.sdk.visual.NodesProcess.getInstance().getWebNodesManager().hasThirdView()) {
                com.sensorsdata.analytics.android.sdk.visual.NodesProcess.getInstance().getWebNodesManager().clear();
            }
            if (snapInfo == null || com.sensorsdata.analytics.android.sdk.visual.NodesProcess.getInstance().getFlutterNodesManager().hasThirdView()) {
                return;
            }
            com.sensorsdata.analytics.android.sdk.visual.NodesProcess.getInstance().getFlutterNodesManager().clear();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:103:0x01d9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:110:? A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:111:0x01cf A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:116:0x01c5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:121:0x01bb A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:52:0x019e  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x01b2  */
        /* JADX WARN: Removed duplicated region for block: B:81:0x0199 A[Catch: Exception -> 0x015b, TRY_ENTER, TRY_LEAVE, TryCatch #18 {Exception -> 0x015b, blocks: (B:49:0x0157, B:81:0x0199), top: B:6:0x0022 }] */
        /* JADX WARN: Removed duplicated region for block: B:82:0x018f A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:87:0x0185 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:92:0x017b A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r1v1 */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v21 */
        /* JADX WARN: Type inference failed for: r1v22 */
        /* JADX WARN: Type inference failed for: r1v23 */
        /* JADX WARN: Type inference failed for: r1v24 */
        /* JADX WARN: Type inference failed for: r1v6 */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Type inference failed for: r1v8 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:137:0x015c -> B:48:0x019c). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void postSnapshot(java.io.ByteArrayOutputStream byteArrayOutputStream) {
            java.io.InputStream inputStream;
            java.io.OutputStream outputStream;
            boolean z;
            ?? r1 = com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.TAG;
            if (android.text.TextUtils.isEmpty(com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.this.mFeatureCode) || android.text.TextUtils.isEmpty(com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.this.mPostUrl)) {
                return;
            }
            java.io.BufferedOutputStream bufferedOutputStream = null;
            r4 = null;
            java.io.InputStream inputStream2 = null;
            bufferedOutputStream = null;
            bufferedOutputStream = null;
            bufferedOutputStream = null;
            try {
                try {
                    java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.this.mPostUrl).openConnection();
                    com.sensorsdata.analytics.android.sdk.SAConfigOptions configOptions = com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.getConfigOptions();
                    if (configOptions != null) {
                        if (configOptions.isDisableSDK()) {
                            com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.this.mMessageThreadHandler.sendMessageDelayed(com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.this.mMessageThreadHandler.obtainMessage(1), 1000L);
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                    return;
                                } catch (java.lang.Exception e) {
                                    com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                                    return;
                                }
                            }
                            return;
                        }
                        if (configOptions.getSSLSocketFactory() != null && (httpURLConnection instanceof javax.net.ssl.HttpsURLConnection)) {
                            ((javax.net.ssl.HttpsURLConnection) httpURLConnection).setSSLSocketFactory(configOptions.getSSLSocketFactory());
                        }
                    }
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setRequestProperty("Content-type", com.baidu.mobads.sdk.internal.am.e);
                    outputStream = httpURLConnection.getOutputStream();
                    try {
                        java.io.BufferedOutputStream bufferedOutputStream2 = new java.io.BufferedOutputStream(outputStream);
                        try {
                            try {
                                bufferedOutputStream2.write(byteArrayOutputStream.toString().getBytes("UTF-8"));
                                bufferedOutputStream2.flush();
                                int responseCode = httpURLConnection.getResponseCode();
                                try {
                                    inputStream2 = httpURLConnection.getInputStream();
                                } catch (java.io.FileNotFoundException unused) {
                                    inputStream2 = httpURLConnection.getErrorStream();
                                }
                                java.lang.String str = new java.lang.String(slurp(inputStream2), "UTF-8");
                                com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.TAG, "request url =" + com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.this.mPostUrl);
                                com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.TAG, "responseCode=" + responseCode);
                                com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.TAG, "response=" + str);
                                org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                                if (responseCode == 200) {
                                    boolean z2 = jSONObject.getInt("delay") >= 0;
                                    try {
                                        java.lang.String optString = jSONObject.optString("visualized_sdk_config");
                                        boolean optBoolean = jSONObject.optBoolean("visualized_config_disabled");
                                        if ((!android.text.TextUtils.isEmpty(optString) || optBoolean) && com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.getConfigOptions().isVisualizedPropertiesEnabled()) {
                                            com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager.getInstance().save2Cache(optString);
                                        }
                                        com.sensorsdata.analytics.android.sdk.visual.VisualizedAutoTrackService.getInstance().setDebugModeEnabled(jSONObject.optBoolean("visualized_debug_mode_enabled"));
                                        z = z2;
                                    } catch (java.lang.Exception e2) {
                                        e = e2;
                                        inputStream = inputStream2;
                                        bufferedOutputStream = bufferedOutputStream2;
                                        r1 = z2;
                                        try {
                                            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                                            if (bufferedOutputStream != null) {
                                                try {
                                                    bufferedOutputStream.close();
                                                } catch (java.lang.Exception e3) {
                                                    com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e3);
                                                }
                                            }
                                            if (inputStream != null) {
                                                try {
                                                    inputStream.close();
                                                } catch (java.lang.Exception e4) {
                                                    com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e4);
                                                }
                                            }
                                            if (outputStream != null) {
                                                try {
                                                    outputStream.close();
                                                } catch (java.lang.Exception e5) {
                                                    com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e5);
                                                }
                                            }
                                            if (byteArrayOutputStream != null) {
                                                byteArrayOutputStream.close();
                                                r1 = r1;
                                            }
                                            if (r1 != 0) {
                                            }
                                        } catch (java.lang.Throwable th) {
                                            th = th;
                                            if (bufferedOutputStream != null) {
                                            }
                                            if (inputStream != null) {
                                            }
                                            if (outputStream != null) {
                                            }
                                            if (byteArrayOutputStream != null) {
                                            }
                                        }
                                    }
                                } else {
                                    z = true;
                                }
                                try {
                                    bufferedOutputStream2.close();
                                } catch (java.lang.Exception e6) {
                                    com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e6);
                                }
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (java.lang.Exception e7) {
                                        com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e7);
                                    }
                                }
                                if (outputStream != null) {
                                    try {
                                        outputStream.close();
                                    } catch (java.lang.Exception e8) {
                                        com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e8);
                                    }
                                }
                                byteArrayOutputStream.close();
                                r1 = z;
                            } catch (java.lang.Throwable th2) {
                                th = th2;
                                inputStream = inputStream2;
                                bufferedOutputStream = bufferedOutputStream2;
                                if (bufferedOutputStream != null) {
                                    try {
                                        bufferedOutputStream.close();
                                    } catch (java.lang.Exception e9) {
                                        com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e9);
                                    }
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (java.lang.Exception e10) {
                                        com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e10);
                                    }
                                }
                                if (outputStream != null) {
                                    try {
                                        outputStream.close();
                                    } catch (java.lang.Exception e11) {
                                        com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e11);
                                    }
                                }
                                if (byteArrayOutputStream != null) {
                                    throw th;
                                }
                                try {
                                    byteArrayOutputStream.close();
                                    throw th;
                                } catch (java.lang.Exception e12) {
                                    com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e12);
                                    throw th;
                                }
                            }
                        } catch (java.lang.Exception e13) {
                            e = e13;
                            inputStream = inputStream2;
                            bufferedOutputStream = bufferedOutputStream2;
                            r1 = 1;
                            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                            if (bufferedOutputStream != null) {
                            }
                            if (inputStream != null) {
                            }
                            if (outputStream != null) {
                            }
                            if (byteArrayOutputStream != null) {
                            }
                            if (r1 != 0) {
                            }
                        }
                    } catch (java.lang.Exception e14) {
                        e = e14;
                        inputStream = null;
                    } catch (java.lang.Throwable th3) {
                        th = th3;
                        inputStream = null;
                    }
                } catch (java.lang.Exception e15) {
                    com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e15);
                    r1 = r1;
                }
            } catch (java.lang.Exception e16) {
                e = e16;
                inputStream = null;
                outputStream = null;
            } catch (java.lang.Throwable th4) {
                th = th4;
                inputStream = null;
                outputStream = null;
            }
            if (r1 != 0) {
                com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.this.mMessageThreadHandler.sendMessageDelayed(com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.this.mMessageThreadHandler.obtainMessage(1), 1000L);
            } else {
                com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.this.stopUpdates(true);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:121:0x04e4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:126:0x04d9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:131:0x04ce A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:142:0x0529 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:154:0x051e A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:159:0x0513 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void sendSnapshot() {
            java.lang.String str;
            java.lang.String str2;
            java.lang.String str3;
            java.io.IOException iOException;
            com.sensorsdata.analytics.android.sdk.visual.model.SnapInfo snapInfo;
            java.lang.Throwable th;
            java.util.zip.GZIPOutputStream gZIPOutputStream;
            java.io.ByteArrayOutputStream byteArrayOutputStream;
            java.io.ByteArrayOutputStream byteArrayOutputStream2;
            java.lang.Throwable th2;
            java.io.IOException iOException2;
            java.lang.String str4;
            java.lang.String str5;
            java.lang.String str6;
            java.io.ByteArrayOutputStream byteArrayOutputStream3;
            java.lang.String str7;
            byte[] bytes;
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            try {
                com.sensorsdata.analytics.android.sdk.visual.ViewSnapshot readSnapshotConfig = this.mProtocol.readSnapshotConfig(com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.this.mMainThreadHandler);
                this.mSnapshot = readSnapshotConfig;
                if (readSnapshotConfig == null) {
                    com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.TAG, "Snapshot should be initialize at first calling.");
                    return;
                }
                java.io.ByteArrayOutputStream byteArrayOutputStream4 = new java.io.ByteArrayOutputStream();
                java.io.BufferedOutputStream bufferedOutputStream = new java.io.BufferedOutputStream(byteArrayOutputStream4);
                try {
                    bufferedOutputStream.write("{".getBytes());
                    bufferedOutputStream.write("\"type\": \"snapshot_response\",".getBytes());
                    bufferedOutputStream.write(("\"feature_code\": \"" + com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.this.mFeatureCode + "\",").getBytes());
                    bufferedOutputStream.write(("\"app_version\": \"" + com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.this.mAppVersion + "\",").getBytes());
                    bufferedOutputStream.write(("\"lib_version\": \"" + this.mSDKVersion + "\",").getBytes());
                    bufferedOutputStream.write("\"os\": \"Android\",".getBytes());
                    bufferedOutputStream.write("\"lib\": \"Android\",".getBytes());
                    bufferedOutputStream.write(("\"app_id\": \"" + this.mAppId + "\",").getBytes());
                    bufferedOutputStream.write(("\"app_enablevisualizedproperties\": " + com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.getConfigOptions().isVisualizedPropertiesEnabled() + ",").getBytes());
                    try {
                        try {
                            org.json.JSONArray jSONArray = new org.json.JSONArray();
                            if (!com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().isAutoTrackEventTypeIgnored(com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AutoTrackEventType.APP_CLICK)) {
                                jSONArray.put("$AppClick");
                            }
                            if (!com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().isAutoTrackEventTypeIgnored(com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AutoTrackEventType.APP_VIEW_SCREEN)) {
                                jSONArray.put("$AppViewScreen");
                            }
                            bufferedOutputStream.write(("\"app_autotrack\": " + jSONArray.toString() + ",").getBytes());
                        } catch (java.lang.Throwable th3) {
                            th2 = th3;
                            str = "Can't close writer.";
                            str2 = "Can't close payload_out.";
                            str3 = "Can't close gos.";
                            gZIPOutputStream = null;
                            byteArrayOutputStream = null;
                            byteArrayOutputStream2 = null;
                            th = th2;
                            if (byteArrayOutputStream2 != null) {
                            }
                            if (gZIPOutputStream != null) {
                            }
                            if (byteArrayOutputStream != null) {
                            }
                            try {
                                bufferedOutputStream.close();
                                throw th;
                            } catch (java.io.IOException e) {
                                com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.TAG, str, e);
                                throw th;
                            }
                        }
                    } catch (java.lang.Exception e2) {
                        com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e2);
                    }
                    java.lang.String visualConfigVersion = com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager.getInstance().getVisualConfigVersion();
                    if (!android.text.TextUtils.isEmpty(visualConfigVersion)) {
                        try {
                            bufferedOutputStream.write(("\"config_version\": \"" + visualConfigVersion + "\",").getBytes());
                        } catch (java.io.IOException e3) {
                            str = "Can't close writer.";
                            str2 = "Can't close payload_out.";
                            str3 = "Can't close gos.";
                            snapInfo = null;
                            gZIPOutputStream = null;
                            byteArrayOutputStream = null;
                            byteArrayOutputStream2 = null;
                            iOException = e3;
                            try {
                                com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.TAG, "Can't write snapshot request to server", iOException);
                                if (byteArrayOutputStream2 != null) {
                                    try {
                                        byteArrayOutputStream2.close();
                                    } catch (java.lang.Exception e4) {
                                        com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.TAG, "Can't close os.", e4);
                                    }
                                }
                                if (gZIPOutputStream != null) {
                                    try {
                                        gZIPOutputStream.close();
                                    } catch (java.lang.Exception e5) {
                                        com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.TAG, str3, e5);
                                    }
                                }
                                if (byteArrayOutputStream != null) {
                                    try {
                                        byteArrayOutputStream.close();
                                    } catch (java.lang.Exception e6) {
                                        com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.TAG, str2, e6);
                                    }
                                }
                                try {
                                    bufferedOutputStream.close();
                                } catch (java.io.IOException e7) {
                                    iOException2 = e7;
                                    com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.TAG, str, iOException2);
                                    com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.TAG, "sendSnapshot = " + byteArrayOutputStream4);
                                    onSnapFinished(snapInfo);
                                    postSnapshot(byteArrayOutputStream4);
                                }
                                com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.TAG, "sendSnapshot = " + byteArrayOutputStream4);
                                onSnapFinished(snapInfo);
                                postSnapshot(byteArrayOutputStream4);
                            } catch (java.lang.Throwable th4) {
                                th2 = th4;
                                th = th2;
                                if (byteArrayOutputStream2 != null) {
                                }
                                if (gZIPOutputStream != null) {
                                }
                                if (byteArrayOutputStream != null) {
                                }
                                bufferedOutputStream.close();
                                throw th;
                            }
                        }
                    }
                    if (this.mUseGzip) {
                        byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                        str4 = "Can't close writer.";
                        try {
                            java.io.BufferedOutputStream bufferedOutputStream2 = new java.io.BufferedOutputStream(byteArrayOutputStream);
                            str5 = "Can't close payload_out.";
                            try {
                                bufferedOutputStream2.write("{\"activities\":".getBytes());
                                bufferedOutputStream2.flush();
                                str6 = "Can't close gos.";
                                try {
                                    try {
                                        snapInfo = this.mSnapshot.snapshots(byteArrayOutputStream, this.mLastImageHash);
                                        try {
                                            long currentTimeMillis2 = java.lang.System.currentTimeMillis() - currentTimeMillis;
                                            bufferedOutputStream2.write(",\"snapshot_time_millis\": ".getBytes());
                                            bufferedOutputStream2.write(java.lang.Long.toString(currentTimeMillis2).getBytes());
                                            java.lang.String debugInfo = com.sensorsdata.analytics.android.sdk.visual.VisualizedAutoTrackService.getInstance().getDebugInfo();
                                            if (!android.text.TextUtils.isEmpty(debugInfo)) {
                                                bufferedOutputStream2.write(",".getBytes());
                                                bufferedOutputStream2.write("\"event_debug\": ".getBytes());
                                                bufferedOutputStream2.write(debugInfo.getBytes());
                                            }
                                            java.lang.String visualLogInfo = com.sensorsdata.analytics.android.sdk.visual.VisualizedAutoTrackService.getInstance().getVisualLogInfo();
                                            if (!android.text.TextUtils.isEmpty(visualLogInfo)) {
                                                bufferedOutputStream2.write(",".getBytes());
                                                bufferedOutputStream2.write("\"log_info\":".getBytes());
                                                bufferedOutputStream2.write(visualLogInfo.getBytes());
                                            }
                                            bufferedOutputStream2.write(com.alipay.sdk.m.u.i.d.getBytes());
                                            bufferedOutputStream2.flush();
                                            byteArrayOutputStream.close();
                                            bytes = byteArrayOutputStream.toString().getBytes();
                                            byteArrayOutputStream3 = new java.io.ByteArrayOutputStream(bytes.length);
                                        } catch (java.io.IOException e8) {
                                            iOException = e8;
                                            str = str4;
                                            str3 = str6;
                                            str2 = str5;
                                            gZIPOutputStream = null;
                                            byteArrayOutputStream2 = null;
                                            com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.TAG, "Can't write snapshot request to server", iOException);
                                            if (byteArrayOutputStream2 != null) {
                                            }
                                            if (gZIPOutputStream != null) {
                                            }
                                            if (byteArrayOutputStream != null) {
                                            }
                                            bufferedOutputStream.close();
                                            com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.TAG, "sendSnapshot = " + byteArrayOutputStream4);
                                            onSnapFinished(snapInfo);
                                            postSnapshot(byteArrayOutputStream4);
                                        }
                                    } catch (java.lang.Throwable th5) {
                                        th = th5;
                                        str = str4;
                                        str3 = str6;
                                        str2 = str5;
                                        gZIPOutputStream = null;
                                        byteArrayOutputStream2 = null;
                                        if (byteArrayOutputStream2 != null) {
                                        }
                                        if (gZIPOutputStream != null) {
                                        }
                                        if (byteArrayOutputStream != null) {
                                        }
                                        bufferedOutputStream.close();
                                        throw th;
                                    }
                                } catch (java.io.IOException e9) {
                                    iOException = e9;
                                    str = str4;
                                    str3 = str6;
                                    str2 = str5;
                                    snapInfo = null;
                                    gZIPOutputStream = null;
                                    byteArrayOutputStream2 = null;
                                    com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.TAG, "Can't write snapshot request to server", iOException);
                                    if (byteArrayOutputStream2 != null) {
                                    }
                                    if (gZIPOutputStream != null) {
                                    }
                                    if (byteArrayOutputStream != null) {
                                    }
                                    bufferedOutputStream.close();
                                    com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.TAG, "sendSnapshot = " + byteArrayOutputStream4);
                                    onSnapFinished(snapInfo);
                                    postSnapshot(byteArrayOutputStream4);
                                }
                                try {
                                    gZIPOutputStream = new java.util.zip.GZIPOutputStream(byteArrayOutputStream3);
                                    try {
                                        gZIPOutputStream.write(bytes);
                                        gZIPOutputStream.close();
                                        byte[] byteArray = byteArrayOutputStream3.toByteArray();
                                        byteArrayOutputStream3.close();
                                        bufferedOutputStream.write(("\"gzip_payload\": \"" + new java.lang.String(com.sensorsdata.analytics.android.sdk.util.Base64Coder.encode(byteArray)) + "\"").getBytes());
                                    } catch (java.io.IOException e10) {
                                        iOException = e10;
                                        byteArrayOutputStream2 = byteArrayOutputStream3;
                                        str = str4;
                                        str3 = str6;
                                        str2 = str5;
                                        com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.TAG, "Can't write snapshot request to server", iOException);
                                        if (byteArrayOutputStream2 != null) {
                                        }
                                        if (gZIPOutputStream != null) {
                                        }
                                        if (byteArrayOutputStream != null) {
                                        }
                                        bufferedOutputStream.close();
                                        com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.TAG, "sendSnapshot = " + byteArrayOutputStream4);
                                        onSnapFinished(snapInfo);
                                        postSnapshot(byteArrayOutputStream4);
                                    } catch (java.lang.Throwable th6) {
                                        th = th6;
                                        byteArrayOutputStream2 = byteArrayOutputStream3;
                                        str = str4;
                                        str3 = str6;
                                        str2 = str5;
                                        if (byteArrayOutputStream2 != null) {
                                        }
                                        if (gZIPOutputStream != null) {
                                        }
                                        if (byteArrayOutputStream != null) {
                                        }
                                        bufferedOutputStream.close();
                                        throw th;
                                    }
                                } catch (java.io.IOException e11) {
                                    iOException = e11;
                                    byteArrayOutputStream2 = byteArrayOutputStream3;
                                    str = str4;
                                    str3 = str6;
                                    str2 = str5;
                                    gZIPOutputStream = null;
                                    com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.TAG, "Can't write snapshot request to server", iOException);
                                    if (byteArrayOutputStream2 != null) {
                                    }
                                    if (gZIPOutputStream != null) {
                                    }
                                    if (byteArrayOutputStream != null) {
                                    }
                                    bufferedOutputStream.close();
                                    com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.TAG, "sendSnapshot = " + byteArrayOutputStream4);
                                    onSnapFinished(snapInfo);
                                    postSnapshot(byteArrayOutputStream4);
                                } catch (java.lang.Throwable th7) {
                                    th = th7;
                                    byteArrayOutputStream2 = byteArrayOutputStream3;
                                    str = str4;
                                    str3 = str6;
                                    str2 = str5;
                                    gZIPOutputStream = null;
                                    if (byteArrayOutputStream2 != null) {
                                    }
                                    if (gZIPOutputStream != null) {
                                    }
                                    if (byteArrayOutputStream != null) {
                                    }
                                    bufferedOutputStream.close();
                                    throw th;
                                }
                            } catch (java.io.IOException e12) {
                                iOException = e12;
                                str3 = "Can't close gos.";
                                str = str4;
                            } catch (java.lang.Throwable th8) {
                                th = th8;
                                str3 = "Can't close gos.";
                                str = str4;
                            }
                        } catch (java.io.IOException e13) {
                            iOException = e13;
                            str2 = "Can't close payload_out.";
                            str3 = "Can't close gos.";
                            str = str4;
                        } catch (java.lang.Throwable th9) {
                            th = th9;
                            str2 = "Can't close payload_out.";
                            str3 = "Can't close gos.";
                            str = str4;
                        }
                    } else {
                        str4 = "Can't close writer.";
                        str5 = "Can't close payload_out.";
                        str6 = "Can't close gos.";
                        try {
                            try {
                                bufferedOutputStream.write("\"payload\": {".getBytes());
                                bufferedOutputStream.write("\"activities\":".getBytes());
                                bufferedOutputStream.flush();
                                snapInfo = this.mSnapshot.snapshots(byteArrayOutputStream4, this.mLastImageHash);
                            } catch (java.lang.Throwable th10) {
                                th = th10;
                                str = str4;
                                str3 = str6;
                                str2 = str5;
                                th = th;
                                gZIPOutputStream = null;
                                byteArrayOutputStream = null;
                                byteArrayOutputStream2 = null;
                                if (byteArrayOutputStream2 != null) {
                                    try {
                                        byteArrayOutputStream2.close();
                                    } catch (java.lang.Exception e14) {
                                        com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.TAG, "Can't close os.", e14);
                                    }
                                }
                                if (gZIPOutputStream != null) {
                                    try {
                                        gZIPOutputStream.close();
                                    } catch (java.lang.Exception e15) {
                                        com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.TAG, str3, e15);
                                    }
                                }
                                if (byteArrayOutputStream != null) {
                                    try {
                                        byteArrayOutputStream.close();
                                    } catch (java.lang.Exception e16) {
                                        com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.TAG, str2, e16);
                                    }
                                }
                                bufferedOutputStream.close();
                                throw th;
                            }
                        } catch (java.io.IOException e17) {
                            e = e17;
                            str = str4;
                            str3 = str6;
                            str2 = str5;
                            iOException = e;
                            snapInfo = null;
                            gZIPOutputStream = null;
                            byteArrayOutputStream = null;
                            byteArrayOutputStream2 = null;
                            com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.TAG, "Can't write snapshot request to server", iOException);
                            if (byteArrayOutputStream2 != null) {
                            }
                            if (gZIPOutputStream != null) {
                            }
                            if (byteArrayOutputStream != null) {
                            }
                            bufferedOutputStream.close();
                            com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.TAG, "sendSnapshot = " + byteArrayOutputStream4);
                            onSnapFinished(snapInfo);
                            postSnapshot(byteArrayOutputStream4);
                        }
                        try {
                            long currentTimeMillis3 = java.lang.System.currentTimeMillis() - currentTimeMillis;
                            bufferedOutputStream.write(",\"snapshot_time_millis\": ".getBytes());
                            bufferedOutputStream.write(java.lang.Long.toString(currentTimeMillis3).getBytes());
                            bufferedOutputStream.write(com.alipay.sdk.m.u.i.d.getBytes());
                            byteArrayOutputStream3 = null;
                            gZIPOutputStream = null;
                            byteArrayOutputStream = null;
                        } catch (java.io.IOException e18) {
                            str = str4;
                            str3 = str6;
                            str2 = str5;
                            iOException = e18;
                            gZIPOutputStream = null;
                            byteArrayOutputStream = null;
                            byteArrayOutputStream2 = null;
                            com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.TAG, "Can't write snapshot request to server", iOException);
                            if (byteArrayOutputStream2 != null) {
                            }
                            if (gZIPOutputStream != null) {
                            }
                            if (byteArrayOutputStream != null) {
                            }
                            bufferedOutputStream.close();
                            com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.TAG, "sendSnapshot = " + byteArrayOutputStream4);
                            onSnapFinished(snapInfo);
                            postSnapshot(byteArrayOutputStream4);
                        }
                    }
                } catch (java.io.IOException e19) {
                    e = e19;
                    str = "Can't close writer.";
                    str2 = "Can't close payload_out.";
                    str3 = "Can't close gos.";
                    iOException = e;
                    snapInfo = null;
                    gZIPOutputStream = null;
                    byteArrayOutputStream = null;
                    byteArrayOutputStream2 = null;
                    com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.TAG, "Can't write snapshot request to server", iOException);
                    if (byteArrayOutputStream2 != null) {
                    }
                    if (gZIPOutputStream != null) {
                    }
                    if (byteArrayOutputStream != null) {
                    }
                    bufferedOutputStream.close();
                    com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.TAG, "sendSnapshot = " + byteArrayOutputStream4);
                    onSnapFinished(snapInfo);
                    postSnapshot(byteArrayOutputStream4);
                } catch (java.lang.Throwable th11) {
                    th = th11;
                    str = "Can't close writer.";
                    str2 = "Can't close payload_out.";
                    str3 = "Can't close gos.";
                    th = th;
                    gZIPOutputStream = null;
                    byteArrayOutputStream = null;
                    byteArrayOutputStream2 = null;
                    if (byteArrayOutputStream2 != null) {
                    }
                    if (gZIPOutputStream != null) {
                    }
                    if (byteArrayOutputStream != null) {
                    }
                    bufferedOutputStream.close();
                    throw th;
                }
                try {
                    if (android.text.TextUtils.isEmpty(snapInfo.screenName)) {
                        str7 = null;
                    } else {
                        bufferedOutputStream.write((",\"screen_name\": \"" + snapInfo.screenName + "\"").getBytes());
                        str7 = snapInfo.screenName;
                    }
                    if (snapInfo.hasFragment) {
                        java.lang.String fragmentScreenName = com.sensorsdata.analytics.android.sdk.util.AppStateTools.getInstance().getFragmentScreenName();
                        if (!android.text.TextUtils.isEmpty(fragmentScreenName)) {
                            str7 = fragmentScreenName;
                        }
                    }
                    com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.TAG, "page_name： " + str7);
                    if (!android.text.TextUtils.isEmpty(str7)) {
                        bufferedOutputStream.write((",\"page_name\": \"" + str7 + "\"").getBytes());
                    }
                    if (!android.text.TextUtils.isEmpty(snapInfo.activityTitle)) {
                        bufferedOutputStream.write((",\"title\": \"" + snapInfo.activityTitle + "\"").getBytes());
                    }
                    bufferedOutputStream.write((",\"is_webview\": " + snapInfo.isWebView).getBytes());
                    if (!android.text.TextUtils.isEmpty(snapInfo.webLibVersion)) {
                        bufferedOutputStream.write((",\"web_lib_version\": \"" + snapInfo.webLibVersion + "\"").getBytes());
                    }
                    if (snapInfo.isWebView && !android.text.TextUtils.isEmpty(snapInfo.webViewUrl)) {
                        com.sensorsdata.analytics.android.sdk.visual.utils.AlertMessageUtils.buildH5AlertInfo(bufferedOutputStream, com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.this.mType, snapInfo, com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.this.mContext);
                    }
                    if (!android.text.TextUtils.isEmpty(snapInfo.flutterLibVersion)) {
                        bufferedOutputStream.write((",\"flutter_lib_version\": \"" + snapInfo.flutterLibVersion + "\"").getBytes());
                    }
                    if (snapInfo.isFlutter && !android.text.TextUtils.isEmpty(snapInfo.activityName)) {
                        com.sensorsdata.analytics.android.sdk.visual.utils.AlertMessageUtils.buildFlutterAlertInfo(bufferedOutputStream, com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.this.mType, snapInfo, com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.this.mContext);
                    }
                    bufferedOutputStream.write(com.alipay.sdk.m.u.i.d.getBytes());
                    bufferedOutputStream.flush();
                    if (byteArrayOutputStream3 != null) {
                        try {
                            byteArrayOutputStream3.close();
                        } catch (java.lang.Exception e20) {
                            com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.TAG, "Can't close os.", e20);
                        }
                    }
                    if (gZIPOutputStream != null) {
                        try {
                            gZIPOutputStream.close();
                        } catch (java.lang.Exception e21) {
                            com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.TAG, str6, e21);
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (java.lang.Exception e22) {
                            com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.TAG, str5, e22);
                        }
                    }
                    try {
                        bufferedOutputStream.close();
                    } catch (java.io.IOException e23) {
                        iOException2 = e23;
                        str = str4;
                        com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.TAG, str, iOException2);
                        com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.TAG, "sendSnapshot = " + byteArrayOutputStream4);
                        onSnapFinished(snapInfo);
                        postSnapshot(byteArrayOutputStream4);
                    }
                } catch (java.io.IOException e24) {
                    str = str4;
                    str3 = str6;
                    str2 = str5;
                    iOException = e24;
                    byteArrayOutputStream2 = byteArrayOutputStream3;
                    com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.TAG, "Can't write snapshot request to server", iOException);
                    if (byteArrayOutputStream2 != null) {
                    }
                    if (gZIPOutputStream != null) {
                    }
                    if (byteArrayOutputStream != null) {
                    }
                    bufferedOutputStream.close();
                    com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.TAG, "sendSnapshot = " + byteArrayOutputStream4);
                    onSnapFinished(snapInfo);
                    postSnapshot(byteArrayOutputStream4);
                } catch (java.lang.Throwable th12) {
                    str = str4;
                    str3 = str6;
                    str2 = str5;
                    th = th12;
                    byteArrayOutputStream2 = byteArrayOutputStream3;
                    if (byteArrayOutputStream2 != null) {
                    }
                    if (gZIPOutputStream != null) {
                    }
                    if (byteArrayOutputStream != null) {
                    }
                    bufferedOutputStream.close();
                    throw th;
                }
                com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.TAG, "sendSnapshot = " + byteArrayOutputStream4);
                onSnapFinished(snapInfo);
                postSnapshot(byteArrayOutputStream4);
            } catch (com.sensorsdata.analytics.android.sdk.visual.snap.EditProtocol.BadInstructionsException e25) {
                com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.TAG, "VisualizedAutoTrack server sent malformed message with snapshot request", e25);
            }
        }

        private byte[] slurp(java.io.InputStream inputStream) throws java.io.IOException {
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            byte[] bArr = new byte[8192];
            while (true) {
                int read = inputStream.read(bArr, 0, 8192);
                if (read == -1) {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            if (message.what != 1) {
                return;
            }
            sendSnapshot();
        }

        public void start() {
        }
    }

    public AbstractViewCrawler(android.app.Activity activity, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        this.mContext = activity.getApplicationContext();
        this.mFeatureCode = str2;
        com.sensorsdata.analytics.android.sdk.visual.snap.EditState editState = new com.sensorsdata.analytics.android.sdk.visual.snap.EditState();
        this.mEditState = editState;
        this.mType = str4;
        editState.add(activity);
        this.mLifecycleCallbacks = new com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.LifecycleCallbacks(this, null);
        try {
            this.mPostUrl = java.net.URLDecoder.decode(str3, "UTF-8");
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
        ((android.app.Application) this.mContext.getApplicationContext()).registerActivityLifecycleCallbacks(this.mLifecycleCallbacks);
        try {
            this.mAppVersion = activity.getPackageManager().getPackageInfo(activity.getPackageName(), 0).versionName;
        } catch (java.lang.Exception unused) {
            this.mAppVersion = "";
        }
        android.os.HandlerThread handlerThread = new android.os.HandlerThread(com.sensorsdata.analytics.android.sdk.visual.VisualizedAutoTrackViewCrawler.class.getCanonicalName(), 10);
        handlerThread.start();
        this.mMessageThreadHandler = new com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.ViewCrawlerHandler(this, this.mContext, handlerThread.getLooper(), str, null);
        this.mMainThreadHandler = new android.os.Handler(android.os.Looper.getMainLooper());
    }

    @Override // com.sensorsdata.analytics.android.sdk.visual.VTrack
    public boolean isServiceRunning() {
        return this.mServiceRunning;
    }

    @Override // com.sensorsdata.analytics.android.sdk.visual.VTrack
    public void startUpdates() {
        try {
            if (android.text.TextUtils.isEmpty(this.mFeatureCode) || android.text.TextUtils.isEmpty(this.mPostUrl)) {
                return;
            }
            ((android.app.Application) this.mContext.getApplicationContext()).registerActivityLifecycleCallbacks(this.mLifecycleCallbacks);
            this.mMessageThreadHandler.start();
            com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.ViewCrawlerHandler viewCrawlerHandler = this.mMessageThreadHandler;
            viewCrawlerHandler.sendMessage(viewCrawlerHandler.obtainMessage(1));
            if (!this.mServiceRunning) {
                com.sensorsdata.analytics.android.sdk.visual.utils.FlutterUtils.visualizedConnectionStatusChanged();
            }
            this.mServiceRunning = true;
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.visual.VTrack
    public void stopUpdates(boolean z) {
        if (z) {
            try {
                this.mFeatureCode = null;
                this.mPostUrl = null;
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                return;
            }
        }
        this.mMessageThreadHandler.removeMessages(1);
        ((android.app.Application) this.mContext.getApplicationContext()).unregisterActivityLifecycleCallbacks(this.mLifecycleCallbacks);
        if (this.mServiceRunning) {
            com.sensorsdata.analytics.android.sdk.visual.utils.FlutterUtils.visualizedConnectionStatusChanged();
            this.mServiceRunning = false;
        }
    }
}
