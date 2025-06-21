package com.tencent.open.utils;

/* loaded from: classes19.dex */
public class i {
    public static int a(java.lang.String str) {
        return "shareToQQ".equals(str) ? com.tencent.connect.common.Constants.REQUEST_QQ_SHARE : "shareToQzone".equals(str) ? com.tencent.connect.common.Constants.REQUEST_QZONE_SHARE : "addToQQFavorites".equals(str) ? com.tencent.connect.common.Constants.REQUEST_QQ_FAVORITES : "sendToMyComputer".equals(str) ? com.tencent.connect.common.Constants.REQUEST_SEND_TO_MY_COMPUTER : "shareToTroopBar".equals(str) ? com.tencent.connect.common.Constants.REQUEST_SHARE_TO_TROOP_BAR : "action_login".equals(str) ? com.tencent.connect.common.Constants.REQUEST_LOGIN : "action_request".equals(str) ? 10100 : -1;
    }

    public static int a(java.lang.String str, java.lang.String str2) {
        if (str == null && str2 == null) {
            return 0;
        }
        if (str != null && str2 == null) {
            return 1;
        }
        if (str == null && str2 != null) {
            return -1;
        }
        java.lang.String[] split = str.split("\\.");
        java.lang.String[] split2 = str2.split("\\.");
        int i = 0;
        while (i < split.length && i < split2.length) {
            try {
                int parseInt = java.lang.Integer.parseInt(split[i]);
                int parseInt2 = java.lang.Integer.parseInt(split2[i]);
                if (parseInt < parseInt2) {
                    return -1;
                }
                if (parseInt > parseInt2) {
                    return 1;
                }
                i++;
            } catch (java.lang.NumberFormatException unused) {
                return str.compareTo(str2);
            }
        }
        if (split.length > i) {
            return 1;
        }
        return split2.length > i ? -1 : 0;
    }

    private static long a(java.io.InputStream inputStream, java.io.OutputStream outputStream) throws java.io.IOException {
        byte[] bArr = new byte[8192];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr, 0, 8192);
            if (read == -1) {
                com.tencent.open.log.SLog.i("openSDK_LOG.SystemUtils", "-->copy, copyed size is: " + j);
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += read;
        }
    }

    public static java.lang.String a(int i) {
        if (i == 10103) {
            return "shareToQQ";
        }
        if (i == 10104) {
            return "shareToQzone";
        }
        if (i == 10105) {
            return "addToQQFavorites";
        }
        if (i == 10106) {
            return "sendToMyComputer";
        }
        if (i == 10107) {
            return "shareToTroopBar";
        }
        if (i == 11101) {
            return "action_login";
        }
        if (i == 10100) {
            return "action_request";
        }
        return null;
    }

    public static java.lang.String a(android.app.Activity activity) {
        try {
            android.content.pm.ApplicationInfo applicationInfo = activity.getPackageManager().getApplicationInfo(activity.getApplicationContext().getPackageName(), 128);
            com.tencent.open.log.SLog.i("openSDK_LOG.SystemUtils", "apkPath=" + applicationInfo.sourceDir);
            return applicationInfo.sourceDir;
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            com.tencent.open.log.SLog.e("openSDK_LOG.SystemUtils", "NameNotFoundException", e);
            return null;
        } catch (java.lang.Exception e2) {
            com.tencent.open.log.SLog.e("openSDK_LOG.SystemUtils", "Exception", e2);
            return null;
        }
    }

    public static java.lang.String a(android.app.Activity activity, java.lang.String str) {
        if (activity == null) {
            com.tencent.open.log.SLog.e("openSDK_LOG.SystemUtils", "getEncryptPkgName activity==null !!!!!!");
            return "";
        }
        try {
            byte[] a = com.tencent.open.utils.e.a(str);
            if (a == null) {
                com.tencent.open.log.SLog.e("openSDK_LOG.SystemUtils", "getEncryptPkgName shaBytes==null !!!!!!");
                return "";
            }
            byte[] bArr = new byte[8];
            java.lang.System.arraycopy(a, 5, bArr, 0, 8);
            byte[] bArr2 = new byte[16];
            java.lang.System.arraycopy(a, 8, bArr2, 0, 16);
            return com.tencent.open.utils.e.a(activity.getPackageName(), com.tencent.open.utils.e.a(bArr2), bArr);
        } catch (java.lang.Exception e) {
            com.tencent.open.log.SLog.e("openSDK_LOG.SystemUtils", "getEncryptPkgName", e);
            return "";
        }
    }

    public static java.lang.String a(android.content.Context context) {
        return context.getApplicationInfo().loadLabel(context.getPackageManager()).toString();
    }

    public static java.lang.String a(android.content.Context context, java.lang.String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private static boolean a() {
        try {
            return ((java.lang.Boolean) android.os.Environment.class.getMethod("isExternalStorageLegacy", new java.lang.Class[0]).invoke(android.os.Environment.class, new java.lang.Object[0])).booleanValue();
        } catch (java.lang.IllegalAccessException | java.lang.NoSuchMethodException | java.lang.reflect.InvocationTargetException unused) {
            return false;
        }
    }

    public static boolean a(android.content.Context context, android.content.Intent intent) {
        return (context == null || intent == null || context.getPackageManager().queryIntentActivities(intent, 0).size() == 0) ? false : true;
    }

    public static boolean a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        com.tencent.open.log.SLog.v("openSDK_LOG.SystemUtils", "OpenUi, validateAppSignatureForPackage");
        try {
            for (android.content.pm.Signature signature : context.getPackageManager().getPackageInfo(str, 64).signatures) {
                if (com.tencent.open.utils.l.f(signature.toCharsString()).equals(str2)) {
                    return true;
                }
            }
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00c5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00be A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @android.annotation.SuppressLint({"SdCardPath"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(java.lang.String str, java.lang.String str2, int i) {
        java.io.FileOutputStream fileOutputStream;
        com.tencent.open.log.SLog.i("openSDK_LOG.SystemUtils", "-->extractSecureLib, libName: " + str);
        android.content.Context a = com.tencent.open.utils.f.a();
        if (a == null) {
            com.tencent.open.log.SLog.i("openSDK_LOG.SystemUtils", "-->extractSecureLib, global context is null. ");
            return false;
        }
        android.content.SharedPreferences sharedPreferences = a.getSharedPreferences("secure_lib", 0);
        java.io.File file = new java.io.File(a.getFilesDir(), str2);
        if (file.exists()) {
            int i2 = sharedPreferences.getInt("version", 0);
            com.tencent.open.log.SLog.i("openSDK_LOG.SystemUtils", "-->extractSecureLib, libVersion: " + i + " | oldVersion: " + i2);
            if (i == i2) {
                return true;
            }
        } else {
            java.io.File parentFile = file.getParentFile();
            if (parentFile != null && parentFile.mkdirs()) {
                try {
                    file.createNewFile();
                } catch (java.io.IOException e) {
                    e.printStackTrace();
                }
            }
        }
        java.io.InputStream inputStream = null;
        r4 = null;
        java.io.FileOutputStream fileOutputStream2 = null;
        inputStream = null;
        try {
            java.io.InputStream open = a.getAssets().open(str);
            try {
                fileOutputStream2 = a.openFileOutput(str2, 0);
                a(open, fileOutputStream2);
                android.content.SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putInt("version", i);
                edit.commit();
                if (open != null) {
                    try {
                        open.close();
                    } catch (java.io.IOException unused) {
                    }
                }
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (java.io.IOException unused2) {
                    }
                }
                return true;
            } catch (java.lang.Exception e2) {
                e = e2;
                java.io.FileOutputStream fileOutputStream3 = fileOutputStream2;
                inputStream = open;
                fileOutputStream = fileOutputStream3;
                try {
                    com.tencent.open.log.SLog.e("openSDK_LOG.SystemUtils", "-->extractSecureLib, when copy lib execption.", e);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (java.io.IOException unused3) {
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (java.io.IOException unused4) {
                        }
                    }
                    return false;
                } catch (java.lang.Throwable th) {
                    th = th;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (java.io.IOException unused5) {
                        }
                    }
                    if (fileOutputStream != null) {
                        throw th;
                    }
                    try {
                        fileOutputStream.close();
                        throw th;
                    } catch (java.io.IOException unused6) {
                        throw th;
                    }
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                java.io.FileOutputStream fileOutputStream4 = fileOutputStream2;
                inputStream = open;
                fileOutputStream = fileOutputStream4;
                if (inputStream != null) {
                }
                if (fileOutputStream != null) {
                }
            }
        } catch (java.lang.Exception e3) {
            e = e3;
            fileOutputStream = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }

    public static java.lang.String b(android.content.Context context, java.lang.String str) {
        com.tencent.open.log.SLog.v("openSDK_LOG.SystemUtils", "OpenUi, getSignValidString");
        java.lang.String str2 = "";
        try {
            java.lang.String packageName = context.getPackageName();
            android.content.pm.Signature[] signatureArr = context.getPackageManager().getPackageInfo(packageName, 64).signatures;
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
            messageDigest.update(signatureArr[0].toByteArray());
            java.lang.String a = com.tencent.open.utils.l.a(messageDigest.digest());
            messageDigest.reset();
            com.tencent.open.log.SLog.v("openSDK_LOG.SystemUtils", "-->sign: " + a);
            messageDigest.update(com.tencent.open.utils.l.i(packageName + "_" + a + "_" + str + ""));
            str2 = com.tencent.open.utils.l.a(messageDigest.digest());
            messageDigest.reset();
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("-->signEncryped: ");
            sb.append(str2);
            com.tencent.open.log.SLog.v("openSDK_LOG.SystemUtils", sb.toString());
            return str2;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.tencent.open.log.SLog.e("openSDK_LOG.SystemUtils", "OpenUi, getSignValidString error", e);
            return str2;
        }
    }

    public static boolean b(android.content.Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.tencent.mobileqq", 0);
            com.tencent.open.log.SLog.i("openSDK_LOG.SystemUtils", "isQQInstalled true");
            return true;
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            com.tencent.open.log.SLog.e("openSDK_LOG.SystemUtils", "PackageManager.NameNotFoundException", e);
            return false;
        } catch (java.lang.Exception e2) {
            com.tencent.open.log.SLog.e("openSDK_LOG.SystemUtils", "Exception", e2);
            return false;
        }
    }

    public static int c(android.content.Context context, java.lang.String str) {
        return a(a(context, "com.tencent.mobileqq"), str);
    }

    public static boolean c(android.content.Context context) {
        return context != null && context.getApplicationInfo().targetSdkVersion >= 29 && android.os.Build.VERSION.SDK_INT >= 29 && !a();
    }

    public static int d(android.content.Context context, java.lang.String str) {
        return a(a(context, com.tencent.connect.common.Constants.PACKAGE_TIM), str);
    }

    public static int e(android.content.Context context, java.lang.String str) {
        return a(a(context, com.tencent.connect.common.Constants.PACKAGE_QQ_SPEED), str);
    }
}
