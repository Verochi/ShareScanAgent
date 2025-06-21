package com.aliyun.common.crash;

/* loaded from: classes.dex */
public class CrashHandler implements java.lang.Thread.UncaughtExceptionHandler {
    private static final java.lang.String CRASH_PATH = "/mnt/sdcard/crash/";
    private static final java.lang.String TAG = "CrashHandler";
    private static com.aliyun.common.crash.CrashHandler mCrashHandler;
    private android.content.Context mContext;
    private java.lang.Thread.UncaughtExceptionHandler mHandler;
    private java.util.Map<java.lang.String, java.lang.String> mInfos = new java.util.HashMap();
    private java.text.DateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");

    /* renamed from: com.aliyun.common.crash.CrashHandler$1, reason: invalid class name */
    public class AnonymousClass1 extends java.lang.Thread {
        public AnonymousClass1() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            android.os.Looper.prepare();
            android.widget.Toast.makeText(com.aliyun.common.crash.CrashHandler.this.mContext, "很抱歉,程序出现异常,即将退出.", 0).show();
            android.os.Looper.loop();
        }
    }

    private CrashHandler() {
    }

    public static com.aliyun.common.crash.CrashHandler getInstance() {
        if (mCrashHandler == null) {
            mCrashHandler = new com.aliyun.common.crash.CrashHandler();
        }
        return mCrashHandler;
    }

    private boolean handleException(java.lang.Throwable th) {
        if (th == null) {
            return false;
        }
        collectDeviceInfo(this.mContext);
        new com.aliyun.common.crash.CrashHandler.AnonymousClass1().start();
        saveCatchInfo2File(th);
        return true;
    }

    private java.lang.String saveCatchInfo2File(java.lang.Throwable th) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : this.mInfos.entrySet()) {
            stringBuffer.append(entry.getKey() + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + entry.getValue() + "\n");
        }
        java.io.StringWriter stringWriter = new java.io.StringWriter();
        java.io.PrintWriter printWriter = new java.io.PrintWriter(stringWriter);
        do {
            th.printStackTrace(printWriter);
            th = th.getCause();
        } while (th != null);
        printWriter.close();
        stringBuffer.append(stringWriter.toString());
        try {
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            java.lang.String str = "crash-" + this.formatter.format(new java.util.Date()) + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + currentTimeMillis + com.anythink.china.common.a.a.f;
            if (android.os.Environment.getExternalStorageState().equals("mounted")) {
                java.io.File file = new java.io.File(CRASH_PATH);
                if (!file.exists()) {
                    file.mkdirs();
                }
                java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(CRASH_PATH + str);
                fileOutputStream.write(stringBuffer.toString().getBytes());
                fileOutputStream.close();
            }
            return str;
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10, types: [java.io.IOException, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v24 */
    /* JADX WARN: Type inference failed for: r6v25 */
    private void sendCrashLog2PM(java.lang.String e) {
        java.io.FileInputStream fileInputStream;
        java.io.BufferedReader bufferedReader;
        java.lang.Throwable th;
        java.io.FileInputStream fileInputStream2;
        java.io.IOException e2;
        java.io.BufferedReader bufferedReader2;
        java.io.FileNotFoundException e3;
        if (!new java.io.File((java.lang.String) e).exists()) {
            android.widget.Toast.makeText(this.mContext, "日志文件不存在！", 0).show();
            return;
        }
        java.io.FileInputStream fileInputStream3 = null;
        try {
        } catch (java.lang.Throwable th2) {
            fileInputStream = fileInputStream2;
            bufferedReader = e;
            th = th2;
        }
        try {
            try {
                fileInputStream2 = new java.io.FileInputStream((java.lang.String) e);
                try {
                    bufferedReader2 = new java.io.BufferedReader(new java.io.InputStreamReader(fileInputStream2, "GBK"));
                    do {
                        try {
                        } catch (java.io.FileNotFoundException e4) {
                            e3 = e4;
                            e3.printStackTrace();
                            bufferedReader2.close();
                            fileInputStream2.close();
                            e = bufferedReader2;
                        } catch (java.io.IOException e5) {
                            e2 = e5;
                            e2.printStackTrace();
                            bufferedReader2.close();
                            fileInputStream2.close();
                            e = bufferedReader2;
                        }
                    } while (bufferedReader2.readLine() != null);
                    bufferedReader2.close();
                    fileInputStream2.close();
                    e = bufferedReader2;
                } catch (java.io.FileNotFoundException e6) {
                    e3 = e6;
                    bufferedReader2 = null;
                } catch (java.io.IOException e7) {
                    e2 = e7;
                    bufferedReader2 = null;
                } catch (java.lang.Throwable th3) {
                    th = th3;
                    fileInputStream = fileInputStream2;
                    bufferedReader = null;
                    fileInputStream3 = fileInputStream;
                    try {
                        bufferedReader.close();
                        fileInputStream3.close();
                    } catch (java.io.IOException e8) {
                        e8.printStackTrace();
                    }
                    throw th;
                }
            } catch (java.io.IOException e9) {
                e = e9;
                e.printStackTrace();
            }
        } catch (java.io.FileNotFoundException e10) {
            fileInputStream2 = null;
            e3 = e10;
            bufferedReader2 = null;
        } catch (java.io.IOException e11) {
            fileInputStream2 = null;
            e2 = e11;
            bufferedReader2 = null;
        } catch (java.lang.Throwable th4) {
            th = th4;
            bufferedReader = null;
            bufferedReader.close();
            fileInputStream3.close();
            throw th;
        }
    }

    public void collectDeviceInfo(android.content.Context context) {
        try {
            android.content.pm.PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 1);
            if (packageInfo != null) {
                java.lang.String str = packageInfo.versionName;
                if (str == null) {
                    str = com.igexin.push.core.b.m;
                }
                java.lang.String str2 = packageInfo.versionCode + "";
                this.mInfos.put(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_VERSION_NAME, str);
                this.mInfos.put(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_VERSION_CODE, str2);
            }
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
        }
        for (java.lang.reflect.Field field : android.os.Build.class.getDeclaredFields()) {
            try {
                field.setAccessible(true);
                this.mInfos.put(field.getName(), field.get(null).toString());
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(field.getName());
                sb.append(" : ");
                sb.append(field.get(null));
            } catch (java.lang.Exception unused2) {
            }
        }
    }

    public void init(android.content.Context context) {
        this.mContext = context;
        this.mHandler = java.lang.Thread.getDefaultUncaughtExceptionHandler();
        java.lang.Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(java.lang.Thread thread, java.lang.Throwable th) {
        java.lang.Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        if (!handleException(th) && (uncaughtExceptionHandler = this.mHandler) != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
            return;
        }
        try {
            java.lang.Thread.sleep(3000L);
        } catch (java.lang.InterruptedException unused) {
        }
        android.os.Process.killProcess(android.os.Process.myPid());
        java.lang.System.exit(1);
    }
}
