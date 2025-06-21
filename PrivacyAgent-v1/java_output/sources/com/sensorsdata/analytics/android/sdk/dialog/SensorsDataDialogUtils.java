package com.sensorsdata.analytics.android.sdk.dialog;

/* loaded from: classes19.dex */
public class SensorsDataDialogUtils {
    private static final java.lang.String TAG = "SA.SensorsDataDialogUtils";
    private static boolean isShowHttpErrorDialog = true;
    private static android.app.Dialog sDialog;

    /* renamed from: com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ android.app.Activity val$activity;

        /* renamed from: com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils$1$1, reason: invalid class name and collision with other inner class name */
        public class RunnableC04401 implements java.lang.Runnable {
            public RunnableC04401() {
            }

            @Override // java.lang.Runnable
            public void run() {
                android.app.Activity activity = com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.AnonymousClass1.this.val$activity;
                com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.showDialog(activity, com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(activity, com.sensorsdata.analytics.android.sdk.R.string.sensors_analytics_popwindow_fail));
            }
        }

        public AnonymousClass1(android.app.Activity activity) {
            this.val$activity = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            android.app.Activity activity = this.val$activity;
            if (activity == null) {
                return;
            }
            activity.runOnUiThread(new com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.AnonymousClass1.RunnableC04401());
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils$2, reason: invalid class name */
    public static class AnonymousClass2 implements com.sensorsdata.analytics.android.sdk.dialog.DebugModeSelectDialog.OnDebugModeViewClickListener {
        @Override // com.sensorsdata.analytics.android.sdk.dialog.DebugModeSelectDialog.OnDebugModeViewClickListener
        public void onCancel(android.app.Dialog dialog) {
            dialog.cancel();
        }

        @Override // com.sensorsdata.analytics.android.sdk.dialog.DebugModeSelectDialog.OnDebugModeViewClickListener
        public void setDebugMode(android.app.Dialog dialog, com.sensorsdata.analytics.android.sdk.SensorsDataAPI.DebugMode debugMode) {
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().setDebugMode(debugMode);
            dialog.cancel();
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils$3, reason: invalid class name */
    public static class AnonymousClass3 implements android.content.DialogInterface.OnCancelListener {
        final /* synthetic */ android.app.Activity val$activity;
        final /* synthetic */ java.lang.String val$infoId;
        final /* synthetic */ java.lang.String val$locationHref;
        final /* synthetic */ java.lang.String val$project;

        public AnonymousClass3(java.lang.String str, java.lang.String str2, java.lang.String str3, android.app.Activity activity) {
            this.val$infoId = str;
            this.val$locationHref = str2;
            this.val$project = str3;
            this.val$activity = activity;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(android.content.DialogInterface dialogInterface) {
            java.lang.String serverUrl = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().getServerUrl();
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI.DebugMode debugMode = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().getDebugMode();
            if (com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().isNetworkRequestEnable() && !android.text.TextUtils.isEmpty(serverUrl) && !android.text.TextUtils.isEmpty(this.val$infoId) && debugMode != com.sensorsdata.analytics.android.sdk.SensorsDataAPI.DebugMode.DEBUG_OFF) {
                if (android.text.TextUtils.isEmpty(this.val$locationHref)) {
                    new com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.SendDebugIdThread(serverUrl, com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().getDistinctId(), this.val$infoId, com.sensorsdata.analytics.android.sdk.core.tasks.ThreadNameConstants.THREAD_SEND_DISTINCT_ID).start();
                } else {
                    try {
                        if (!android.text.TextUtils.isEmpty(this.val$project)) {
                            java.lang.String str = this.val$locationHref + "?project=" + this.val$project;
                            com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.TAG, "sf url:" + str);
                            new com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.SendDebugIdThread(str, com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().getDistinctId(), this.val$infoId, com.sensorsdata.analytics.android.sdk.core.tasks.ThreadNameConstants.THREAD_SEND_DISTINCT_ID).start();
                        }
                    } catch (java.lang.Exception e) {
                        com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                    }
                }
            }
            com.sensorsdata.analytics.android.sdk.util.ToastUtil.showLong(this.val$activity, debugMode == com.sensorsdata.analytics.android.sdk.SensorsDataAPI.DebugMode.DEBUG_OFF ? com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(this.val$activity, com.sensorsdata.analytics.android.sdk.R.string.sensors_analytics_debug_tip_off) : debugMode == com.sensorsdata.analytics.android.sdk.SensorsDataAPI.DebugMode.DEBUG_ONLY ? com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(this.val$activity, com.sensorsdata.analytics.android.sdk.R.string.sensors_analytics_debug_tip_only) : debugMode == com.sensorsdata.analytics.android.sdk.SensorsDataAPI.DebugMode.DEBUG_AND_TRACK ? com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(this.val$activity, com.sensorsdata.analytics.android.sdk.R.string.sensors_analytics_debug_tip_track) : "");
            com.sensorsdata.analytics.android.sdk.SALog.info(com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.TAG, "The App current DebugMode is ：" + debugMode, null);
            com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.startLaunchActivity(this.val$activity);
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils$4, reason: invalid class name */
    public static class AnonymousClass4 implements android.content.DialogInterface.OnClickListener {
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(android.content.DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils$5, reason: invalid class name */
    public static class AnonymousClass5 implements android.content.DialogInterface.OnClickListener {
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(android.content.DialogInterface dialogInterface, int i) {
            boolean unused = com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.isShowHttpErrorDialog = false;
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils$6, reason: invalid class name */
    public static class AnonymousClass6 implements android.content.DialogInterface.OnClickListener {
        final /* synthetic */ android.content.Context val$context;

        public AnonymousClass6(android.content.Context context) {
            this.val$context = context;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(android.content.DialogInterface dialogInterface, int i) {
            com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.startLaunchActivity(this.val$context);
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils$7, reason: invalid class name */
    public static class AnonymousClass7 implements android.content.DialogInterface.OnDismissListener {
        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(android.content.DialogInterface dialogInterface) {
            android.app.Dialog unused = com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.sDialog = null;
        }
    }

    public static class SendDebugIdThread extends java.lang.Thread {
        private java.lang.String distinctId;
        private java.lang.String infoId;
        private java.lang.String serverUrl;

        public SendDebugIdThread(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
            super(str4);
            this.distinctId = str2;
            this.infoId = str3;
            this.serverUrl = str;
        }

        private void closeStream(java.io.ByteArrayOutputStream byteArrayOutputStream, java.io.OutputStream outputStream, java.io.BufferedOutputStream bufferedOutputStream, java.net.HttpURLConnection httpURLConnection) {
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (java.lang.Exception e) {
                    com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (java.lang.Exception e2) {
                    com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e2);
                }
            }
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (java.lang.Exception e3) {
                    com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e3);
                }
            }
            if (httpURLConnection != null) {
                try {
                    httpURLConnection.disconnect();
                } catch (java.lang.Exception e4) {
                    com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e4);
                }
            }
        }

        private void sendHttpRequest(java.lang.String str, boolean z) {
            java.net.HttpURLConnection httpURLConnection;
            java.io.OutputStream outputStream;
            java.io.BufferedOutputStream bufferedOutputStream;
            java.io.ByteArrayOutputStream byteArrayOutputStream = null;
            try {
                java.net.URL url = new java.net.URL(java.lang.String.format(str + "&info_id=%s", this.infoId));
                com.sensorsdata.analytics.android.sdk.SALog.info(com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.TAG, java.lang.String.format("DebugMode URL:%s", url), null);
                httpURLConnection = (java.net.HttpURLConnection) url.openConnection();
                try {
                    if (httpURLConnection == null) {
                        com.sensorsdata.analytics.android.sdk.SALog.info(com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.TAG, java.lang.String.format("can not connect %s,shouldn't happen", url.toString()), null);
                        closeStream(null, null, null, httpURLConnection);
                        return;
                    }
                    com.sensorsdata.analytics.android.sdk.SAConfigOptions configOptions = com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.getConfigOptions();
                    if (configOptions != null && configOptions.getSSLSocketFactory() != null && (httpURLConnection instanceof javax.net.ssl.HttpsURLConnection)) {
                        ((javax.net.ssl.HttpsURLConnection) httpURLConnection).setSSLSocketFactory(configOptions.getSSLSocketFactory());
                    }
                    httpURLConnection.setInstanceFollowRedirects(false);
                    java.io.ByteArrayOutputStream byteArrayOutputStream2 = new java.io.ByteArrayOutputStream();
                    try {
                        java.io.OutputStreamWriter outputStreamWriter = new java.io.OutputStreamWriter(byteArrayOutputStream2);
                        java.lang.String str2 = "{\"distinct_id\": \"" + this.distinctId + "\"}";
                        outputStreamWriter.write(str2);
                        outputStreamWriter.flush();
                        com.sensorsdata.analytics.android.sdk.SALog.info(com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.TAG, java.lang.String.format("DebugMode request body : %s", str2), null);
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setUseCaches(false);
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setRequestProperty("Content-type", com.baidu.mobads.sdk.internal.am.e);
                        outputStream = httpURLConnection.getOutputStream();
                        try {
                            bufferedOutputStream = new java.io.BufferedOutputStream(outputStream);
                            try {
                                bufferedOutputStream.write(byteArrayOutputStream2.toString().getBytes("UTF-8"));
                                bufferedOutputStream.flush();
                                byteArrayOutputStream2.close();
                                int responseCode = httpURLConnection.getResponseCode();
                                com.sensorsdata.analytics.android.sdk.SALog.info(com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.TAG, java.lang.String.format(com.sensorsdata.analytics.android.sdk.util.TimeUtils.SDK_LOCALE, "DebugMode ResponseCode: %d", java.lang.Integer.valueOf(responseCode)), null);
                                if (!z && com.sensorsdata.analytics.android.sdk.util.NetworkUtils.needRedirects(responseCode)) {
                                    java.lang.String location = com.sensorsdata.analytics.android.sdk.util.NetworkUtils.getLocation(httpURLConnection, str);
                                    if (!android.text.TextUtils.isEmpty(location)) {
                                        closeStream(byteArrayOutputStream2, outputStream, bufferedOutputStream, httpURLConnection);
                                        sendHttpRequest(location, true);
                                    }
                                }
                                closeStream(byteArrayOutputStream2, outputStream, bufferedOutputStream, httpURLConnection);
                            } catch (java.lang.Exception e) {
                                e = e;
                                byteArrayOutputStream = byteArrayOutputStream2;
                                try {
                                    com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                                    closeStream(byteArrayOutputStream, outputStream, bufferedOutputStream, httpURLConnection);
                                } catch (java.lang.Throwable th) {
                                    th = th;
                                    closeStream(byteArrayOutputStream, outputStream, bufferedOutputStream, httpURLConnection);
                                    throw th;
                                }
                            } catch (java.lang.Throwable th2) {
                                th = th2;
                                byteArrayOutputStream = byteArrayOutputStream2;
                                closeStream(byteArrayOutputStream, outputStream, bufferedOutputStream, httpURLConnection);
                                throw th;
                            }
                        } catch (java.lang.Exception e2) {
                            e = e2;
                            bufferedOutputStream = null;
                        } catch (java.lang.Throwable th3) {
                            th = th3;
                            bufferedOutputStream = null;
                        }
                    } catch (java.lang.Exception e3) {
                        e = e3;
                        outputStream = null;
                        bufferedOutputStream = null;
                    } catch (java.lang.Throwable th4) {
                        th = th4;
                        outputStream = null;
                        bufferedOutputStream = null;
                    }
                } catch (java.lang.Exception e4) {
                    e = e4;
                    outputStream = null;
                    bufferedOutputStream = outputStream;
                    com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                    closeStream(byteArrayOutputStream, outputStream, bufferedOutputStream, httpURLConnection);
                } catch (java.lang.Throwable th5) {
                    th = th5;
                    outputStream = null;
                    bufferedOutputStream = outputStream;
                    closeStream(byteArrayOutputStream, outputStream, bufferedOutputStream, httpURLConnection);
                    throw th;
                }
            } catch (java.lang.Exception e5) {
                e = e5;
                httpURLConnection = null;
                outputStream = null;
            } catch (java.lang.Throwable th6) {
                th = th6;
                httpURLConnection = null;
                outputStream = null;
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            sendHttpRequest(this.serverUrl, false);
        }
    }

    public static void dialogShowDismissOld(android.app.Dialog dialog) {
        try {
            android.app.Dialog dialog2 = sDialog;
            if (dialog2 != null && dialog2.isShowing()) {
                try {
                    sDialog.dismiss();
                    com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "Dialog dismiss");
                } catch (java.lang.Exception e) {
                    com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                }
            }
            sDialog = dialog;
            if (dialog != null) {
                dialog.show();
                dialog.setOnDismissListener(new com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.AnonymousClass7());
            }
        } catch (java.lang.Exception e2) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e2);
        }
    }

    public static android.graphics.drawable.StateListDrawable getDrawable() {
        android.graphics.drawable.GradientDrawable gradientDrawable = new android.graphics.drawable.GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(android.graphics.Color.parseColor("#dddddd"));
        android.graphics.drawable.GradientDrawable gradientDrawable2 = new android.graphics.drawable.GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setColor(-1);
        android.graphics.drawable.StateListDrawable stateListDrawable = new android.graphics.drawable.StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_focused}, gradientDrawable);
        stateListDrawable.addState(new int[0], gradientDrawable2);
        return stateListDrawable;
    }

    public static boolean isSchemeActivity(android.content.Context context) {
        if (context == null) {
            return false;
        }
        java.lang.String name = context.getClass().getName();
        if (!android.text.TextUtils.isEmpty(name) && name.endsWith(com.sensorsdata.analytics.android.sdk.dialog.SchemeActivity.class.getSimpleName())) {
            java.lang.Object findFieldRecur = com.sensorsdata.analytics.android.sdk.util.ReflectUtil.findFieldRecur(context, "SCHEME_ACTIVITY_SIGN");
            if (findFieldRecur instanceof java.lang.String) {
                return android.text.TextUtils.equals((java.lang.String) findFieldRecur, com.sensorsdata.analytics.android.sdk.dialog.SchemeActivity.SCHEME_ACTIVITY_SIGN);
            }
        }
        return false;
    }

    public static void showDebugModeSelectDialog(android.app.Activity activity, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        try {
            com.sensorsdata.analytics.android.sdk.dialog.DebugModeSelectDialog debugModeSelectDialog = new com.sensorsdata.analytics.android.sdk.dialog.DebugModeSelectDialog(activity, com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().getDebugMode());
            debugModeSelectDialog.setCanceledOnTouchOutside(false);
            debugModeSelectDialog.setOnDebugModeDialogClickListener(new com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.AnonymousClass2());
            debugModeSelectDialog.setOnCancelListener(new com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.AnonymousClass3(str, str2, str3, activity));
            dialogShowDismissOld(debugModeSelectDialog);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public static void showDialog(android.app.Activity activity, java.lang.String str, java.lang.String str2, java.lang.String str3, android.content.DialogInterface.OnClickListener onClickListener, java.lang.String str4, android.content.DialogInterface.OnClickListener onClickListener2) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(activity);
        if (!android.text.TextUtils.isEmpty(str)) {
            builder.setTitle(str);
        }
        if (!android.text.TextUtils.isEmpty(str2)) {
            builder.setMessage(str2);
        }
        builder.setCancelable(false);
        builder.setNegativeButton(str4, onClickListener2);
        builder.setPositiveButton(str3, onClickListener);
        android.app.AlertDialog create = builder.create();
        dialogShowDismissOld(create);
        create.getButton(-2).setAllCaps(false);
        create.getButton(-1).setAllCaps(false);
    }

    public static void showDialog(android.content.Context context, java.lang.String str) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(context);
        builder.setTitle(com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(context, com.sensorsdata.analytics.android.sdk.R.string.sensors_analytics_common_title)).setMessage(str).setCancelable(false).setPositiveButton(com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(context, com.sensorsdata.analytics.android.sdk.R.string.sensors_analytics_common_ok), new com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.AnonymousClass6(context));
        android.app.AlertDialog create = builder.create();
        dialogShowDismissOld(create);
        try {
            create.getButton(-1).setTextColor(androidx.core.internal.view.SupportMenu.CATEGORY_MASK);
            create.getButton(-1).setBackgroundColor(-1);
            create.getButton(-1).setAllCaps(false);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public static void showHttpErrorDialog(android.app.Activity activity, java.lang.String str) {
        try {
            if (!android.text.TextUtils.isEmpty(str) && isShowHttpErrorDialog && activity != null) {
                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(activity);
                builder.setTitle(com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(activity, com.sensorsdata.analytics.android.sdk.R.string.sensors_analytics_common_title));
                builder.setMessage(str);
                builder.setCancelable(false);
                builder.setNegativeButton(com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(activity, com.sensorsdata.analytics.android.sdk.R.string.sensors_analytics_common_ok), new com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.AnonymousClass4());
                builder.setPositiveButton(com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(activity, com.sensorsdata.analytics.android.sdk.R.string.sensors_analytics_common_no), new com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.AnonymousClass5());
                android.app.AlertDialog create = builder.create();
                dialogShowDismissOld(create);
                try {
                    create.getButton(-2).setTextColor(androidx.core.view.ViewCompat.MEASURED_STATE_MASK);
                    create.getButton(-2).setBackgroundColor(-1);
                    create.getButton(-2).setAllCaps(false);
                    create.getButton(-1).setTextColor(androidx.core.internal.view.SupportMenu.CATEGORY_MASK);
                    create.getButton(-1).setBackgroundColor(-1);
                    create.getButton(-1).setAllCaps(false);
                    create.getButton(-2).setBackground(getDrawable());
                    create.getButton(-1).setBackground(getDrawable());
                } catch (java.lang.Exception e) {
                    com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                }
            }
        } catch (java.lang.Exception e2) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e2);
        }
    }

    public static void showPopupWindowDialog(android.app.Activity activity, android.net.Uri uri) {
        com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.AnonymousClass1 anonymousClass1;
        try {
            java.lang.String queryParameter = uri.getQueryParameter("sf_popup_test");
            java.lang.String queryParameter2 = uri.getQueryParameter("popup_window_id");
            boolean parseBoolean = !android.text.TextUtils.isEmpty(queryParameter) ? java.lang.Boolean.parseBoolean(queryParameter) : false;
            java.lang.reflect.Method[] declaredMethods = com.sensorsdata.sf.ui.utils.PreviewUtil.class.getDeclaredMethods();
            int length = declaredMethods.length;
            java.lang.reflect.Method method = null;
            int i = 0;
            while (true) {
                if (i >= length) {
                    anonymousClass1 = null;
                    break;
                }
                java.lang.reflect.Method method2 = declaredMethods[i];
                if (method2.getName().equals("showPreview")) {
                    if (method2.getParameterTypes().length == 4) {
                        anonymousClass1 = new com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.AnonymousClass1(activity);
                        method = method2;
                        break;
                    }
                    method = method2;
                }
                i++;
            }
            if (method == null) {
                startLaunchActivity(activity);
                return;
            }
            if (anonymousClass1 != null) {
                method.invoke(null, activity, java.lang.Boolean.valueOf(parseBoolean), queryParameter2, anonymousClass1);
            } else {
                method.invoke(null, activity, java.lang.Boolean.valueOf(parseBoolean), queryParameter2);
            }
            com.sensorsdata.analytics.android.sdk.dialog.SchemeActivity.isPopWindow = true;
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            startLaunchActivity(activity);
        }
    }

    public static void startLaunchActivity(android.content.Context context) {
        try {
            if (isSchemeActivity(context)) {
                context.startActivity(context.getPackageManager().getLaunchIntentForPackage(context.getPackageName()));
                ((com.sensorsdata.analytics.android.sdk.dialog.SchemeActivity) context).finish();
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "startLaunchActivity");
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }
}
