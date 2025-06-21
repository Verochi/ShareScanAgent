package com.tencent.open.utils;

/* loaded from: classes19.dex */
public class l {
    private static java.lang.String a = "";
    private static java.lang.String b = "";
    private static java.lang.String c = "";
    private static java.lang.String d = "";
    private static int e = -1;
    private static java.lang.String f = "0123456789ABCDEF";

    /* renamed from: com.tencent.open.utils.l$1, reason: invalid class name */
    public static class AnonymousClass1 extends java.lang.Thread {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ android.os.Bundle b;

        public AnonymousClass1(android.content.Context context, android.os.Bundle bundle) {
            this.a = context;
            this.b = bundle;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                com.tencent.open.utils.HttpUtils.openUrl2(this.a, "https://cgi.qplus.com/report/report", "GET", this.b);
            } catch (java.lang.Exception e) {
                com.tencent.open.log.SLog.e("openSDK_LOG.Util", "reportBernoulli has exception: " + e.getMessage());
            }
        }
    }

    public static class a {
        public java.lang.String a;
        public long b;
        public long c;

        public a(java.lang.String str, int i) {
            this.a = str;
            this.b = i;
            if (str != null) {
                this.c = str.length();
            }
        }
    }

    private static char a(int i) {
        int i2 = i & 15;
        return (char) (i2 < 10 ? i2 + 48 : (i2 - 10) + 97);
    }

    public static android.graphics.drawable.Drawable a(java.lang.String str, android.content.Context context) {
        java.io.InputStream inputStream;
        java.lang.StringBuilder sb;
        java.io.InputStream inputStream2 = null;
        r1 = null;
        android.graphics.drawable.Drawable drawable = null;
        if (context == null) {
            com.tencent.open.log.SLog.e("openSDK_LOG.Util", "context null!");
            return null;
        }
        try {
            inputStream = context.getAssets().open(str);
            try {
                try {
                    drawable = android.graphics.drawable.Drawable.createFromStream(inputStream, str);
                    try {
                        inputStream.close();
                    } catch (java.lang.Exception e2) {
                        e = e2;
                        sb = new java.lang.StringBuilder();
                        sb.append("inputStream close exception: ");
                        sb.append(e.getMessage());
                        com.tencent.open.log.SLog.e("openSDK_LOG.Util", sb.toString());
                        return drawable;
                    }
                } catch (java.io.IOException e3) {
                    e = e3;
                    com.tencent.open.log.SLog.e("openSDK_LOG.Util", "getDrawable exception: " + e.getMessage());
                    try {
                        inputStream.close();
                    } catch (java.lang.Exception e4) {
                        e = e4;
                        sb = new java.lang.StringBuilder();
                        sb.append("inputStream close exception: ");
                        sb.append(e.getMessage());
                        com.tencent.open.log.SLog.e("openSDK_LOG.Util", sb.toString());
                        return drawable;
                    }
                    return drawable;
                }
            } catch (java.lang.Throwable th) {
                th = th;
                inputStream2 = inputStream;
                try {
                    inputStream2.close();
                } catch (java.lang.Exception e5) {
                    com.tencent.open.log.SLog.e("openSDK_LOG.Util", "inputStream close exception: " + e5.getMessage());
                }
                throw th;
            }
        } catch (java.io.IOException e6) {
            e = e6;
            inputStream = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            inputStream2.close();
            throw th;
        }
        return drawable;
    }

    public static android.os.Bundle a(java.lang.String str) {
        android.os.Bundle bundle = new android.os.Bundle();
        if (str == null) {
            return bundle;
        }
        try {
            for (java.lang.String str2 : str.split("&")) {
                java.lang.String[] split = str2.split(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
                if (split.length == 2) {
                    bundle.putString(java.net.URLDecoder.decode(split[0]), java.net.URLDecoder.decode(split[1]));
                }
            }
            return bundle;
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static android.os.Bundle a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6) {
        return a(str, str3, str4, str2, str5, str6, "", "", "", "", "", "");
    }

    public static android.os.Bundle a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7, java.lang.String str8, java.lang.String str9) {
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putString("platform", "1");
        bundle.putString("result", str);
        bundle.putString("code", str2);
        bundle.putString("tmcost", str3);
        bundle.putString("rate", str4);
        bundle.putString("cmd", str5);
        bundle.putString("uin", str6);
        bundle.putString("appid", str7);
        bundle.putString("share_type", str8);
        bundle.putString("detail", str9);
        bundle.putString("os_ver", android.os.Build.VERSION.RELEASE);
        bundle.putString("network", com.tencent.open.a.a.a(com.tencent.open.utils.f.a()));
        bundle.putString("apn", com.tencent.open.a.a.b(com.tencent.open.utils.f.a()));
        bundle.putString("model_name", android.os.Build.MODEL);
        bundle.putString("sdk_ver", com.tencent.connect.common.Constants.SDK_VERSION);
        bundle.putString(me.leolin.shortcutbadger.impl.NewHtcHomeBadger.PACKAGENAME, com.tencent.open.utils.f.b());
        bundle.putString("app_ver", d(com.tencent.open.utils.f.a(), com.tencent.open.utils.f.b()));
        return bundle;
    }

    public static android.os.Bundle a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7, java.lang.String str8, java.lang.String str9, java.lang.String str10, java.lang.String str11, java.lang.String str12) {
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putString("openid", str);
        bundle.putString("report_type", str2);
        bundle.putString("act_type", str3);
        bundle.putString("via", str4);
        bundle.putString("app_id", str5);
        bundle.putString("result", str6);
        bundle.putString("type", str7);
        bundle.putString("login_status", str8);
        bundle.putString("need_user_auth", str9);
        bundle.putString("to_uin", str10);
        bundle.putString("call_source", str11);
        bundle.putString("to_type", str12);
        bundle.putString("platform", "1");
        return bundle;
    }

    public static final java.lang.String a(android.content.Context context) {
        java.lang.CharSequence applicationLabel;
        if (context == null || (applicationLabel = context.getPackageManager().getApplicationLabel(context.getApplicationInfo())) == null) {
            return null;
        }
        return applicationLabel.toString();
    }

    @android.annotation.SuppressLint({"NewApi"})
    public static java.lang.String a(android.content.Context context, android.net.Uri uri) {
        android.net.Uri uri2;
        if (uri == null) {
            return null;
        }
        if (!android.provider.DocumentsContract.isDocumentUri(context, uri)) {
            java.lang.String scheme = uri.getScheme();
            if ("content".equals(scheme)) {
                return b(context, uri);
            }
            if ("file".equals(scheme)) {
                return uri.getPath();
            }
            return null;
        }
        java.lang.String authority = uri.getAuthority();
        if ("com.android.externalstorage.documents".equals(authority)) {
            java.lang.String[] split = android.provider.DocumentsContract.getDocumentId(uri).split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
            java.lang.String str = split[0];
            return "primary".equals(str) ? android.os.Environment.getExternalStorageDirectory().getAbsolutePath().concat(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR).concat(split[1]) : "/storage/".concat(str).concat(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR).concat(split[1]);
        }
        if ("com.android.providers.downloads.documents".equals(authority)) {
            java.lang.String documentId = android.provider.DocumentsContract.getDocumentId(uri);
            return documentId.startsWith("raw:") ? documentId.replaceFirst("raw:", "") : b(context, android.content.ContentUris.withAppendedId(android.net.Uri.parse("content://downloads/public_downloads"), java.lang.Long.parseLong(documentId)));
        }
        if ("com.android.providers.media.documents".equals(authority)) {
            java.lang.String[] split2 = android.provider.DocumentsContract.getDocumentId(uri).split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
            java.lang.String str2 = split2[0];
            if ("image".equals(str2)) {
                uri2 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            } else if ("video".equals(str2)) {
                uri2 = android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            } else if ("audio".equals(str2)) {
                uri2 = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            }
            return b(context, android.content.ContentUris.withAppendedId(uri2, java.lang.Long.parseLong(split2[1])));
        }
        return null;
    }

    public static final java.lang.String a(java.lang.String str, int i, java.lang.String str2, java.lang.String str3) {
        if (android.text.TextUtils.isEmpty(str)) {
            return "";
        }
        if (android.text.TextUtils.isEmpty(str2)) {
            str2 = "UTF-8";
        }
        try {
            if (str.getBytes(str2).length <= i) {
                return str;
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < str.length()) {
                int i4 = i2 + 1;
                i3 += str.substring(i2, i4).getBytes(str2).length;
                if (i3 > i) {
                    java.lang.String substring = str.substring(0, i2);
                    if (android.text.TextUtils.isEmpty(str3)) {
                        return substring;
                    }
                    return substring + str3;
                }
                i2 = i4;
            }
            return str;
        } catch (java.lang.Exception e2) {
            com.tencent.open.log.SLog.e("openSDK_LOG.Util", "Util.subString has exception: " + e2.getMessage());
            return str;
        }
    }

    public static java.lang.String a(java.lang.String str, android.app.Activity activity, java.lang.String str2, com.tencent.tauth.IUiListener iUiListener) {
        java.lang.String str3;
        try {
            boolean n = n(str2);
            com.tencent.open.log.SLog.i("openSDK_LOG.Util", "doPublishMood() check file: isAppSpecificDir=" + n + ",hasSDPermission=" + c());
            if (!n) {
                java.io.File a2 = com.tencent.open.utils.f.a("Images");
                if (a2 != null) {
                    str3 = a2.getAbsolutePath() + java.io.File.separator + com.tencent.connect.common.Constants.QQ_SHARE_TEMP_DIR;
                } else {
                    java.io.File cacheDir = com.tencent.open.utils.f.a().getCacheDir();
                    if (cacheDir == null) {
                        com.tencent.open.log.SLog.e("openSDK_LOG.Util", "getMediaFileUri error, cacheDir is null");
                        return null;
                    }
                    str3 = cacheDir.getAbsolutePath() + java.io.File.separator + com.tencent.connect.common.Constants.QQ_SHARE_TEMP_DIR;
                }
                java.io.File file = new java.io.File(str2);
                java.lang.String absolutePath = file.getAbsolutePath();
                java.lang.String str4 = str3 + java.io.File.separator + file.getName();
                str2 = a(absolutePath, str4) ? str4 : null;
            }
            if (android.text.TextUtils.isEmpty(str2)) {
                com.tencent.open.log.SLog.e("openSDK_LOG.Util", "getMediaFileUri error, destAppSpecific is null");
                return null;
            }
            java.io.File file2 = new java.io.File(str2);
            java.lang.String authorities = com.tencent.tauth.Tencent.getAuthorities(str);
            if (!android.text.TextUtils.isEmpty(authorities)) {
                android.net.Uri uriForFile = androidx.core.content.FileProvider.getUriForFile(activity, authorities, file2);
                activity.grantUriPermission("com.tencent.mobileqq", uriForFile, 3);
                return uriForFile.toString();
            }
            com.tencent.open.log.SLog.e("openSDK_LOG.Util", "getMediaFileUri error, authorities is null");
            if (iUiListener != null) {
                iUiListener.onWarning(-19);
            }
            return null;
        } catch (java.lang.Exception e2) {
            com.tencent.open.log.SLog.e("openSDK_LOG.Util", "getMediaFileUri error", e2);
            return null;
        }
    }

    public static java.lang.String a(java.util.Map<java.lang.String, java.lang.Object> map, java.lang.String str, java.lang.String str2) {
        if (map == null) {
            com.tencent.open.log.SLog.e("openSDK_LOG.Util", "getString error, params==null");
            return str2;
        }
        if (map.containsKey(str)) {
            java.lang.Object obj = map.get(str);
            return obj instanceof java.lang.String ? (java.lang.String) obj : str2;
        }
        com.tencent.open.log.SLog.e("openSDK_LOG.Util", "getString error, not comtain : " + str);
        return str2;
    }

    public static java.lang.String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder(bArr.length * 2);
        for (byte b2 : bArr) {
            java.lang.String num = java.lang.Integer.toString(b2 & 255, 16);
            if (num.length() == 1) {
                num = "0" + num;
            }
            sb.append(num);
        }
        return sb.toString();
    }

    public static org.json.JSONObject a(org.json.JSONObject jSONObject, java.lang.String str) {
        if (jSONObject == null) {
            jSONObject = new org.json.JSONObject();
        }
        if (str != null) {
            for (java.lang.String str2 : str.split("&")) {
                java.lang.String[] split = str2.split(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
                if (split.length == 2) {
                    try {
                        split[0] = java.net.URLDecoder.decode(split[0]);
                        split[1] = java.net.URLDecoder.decode(split[1]);
                    } catch (java.lang.Exception unused) {
                    }
                    try {
                        jSONObject.put(split[0], split[1]);
                    } catch (org.json.JSONException e2) {
                        com.tencent.open.log.SLog.e("openSDK_LOG.Util", "decodeUrlToJson has exception: " + e2.getMessage());
                    }
                }
            }
        }
        return jSONObject;
    }

    public static void a(android.content.Context context, java.lang.String str, long j, java.lang.String str2) {
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putString("appid_for_getting_config", str2);
        bundle.putString("strValue", str2);
        bundle.putString("nValue", str);
        bundle.putString("qver", com.tencent.connect.common.Constants.SDK_VERSION);
        if (j != 0) {
            bundle.putLong("elt", j);
        }
        new com.tencent.open.utils.l.AnonymousClass1(context, bundle).start();
    }

    private static void a(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        android.content.Intent intent = new android.content.Intent();
        intent.setComponent(new android.content.ComponentName(str, str2));
        intent.setAction("android.intent.action.VIEW");
        intent.addFlags(1073741824);
        intent.addFlags(268435456);
        intent.setData(android.net.Uri.parse(str3));
        context.startActivity(intent);
    }

    public static boolean a() {
        return (android.os.Environment.getExternalStorageState().equals("mounted") ? android.os.Environment.getExternalStorageDirectory() : null) != null;
    }

    public static boolean a(android.content.Context context, java.lang.String str) {
        boolean z;
        try {
            z = g(context);
        } catch (java.lang.Exception unused) {
            z = false;
        }
        try {
            if (z) {
                a(context, "com.tencent.mtt", "com.tencent.mtt.MainActivity", str);
            } else {
                a(context, "com.android.browser", "com.android.browser.BrowserActivity", str);
            }
            return true;
        } catch (java.lang.Exception unused2) {
            if (!z) {
                try {
                    try {
                        a(context, "com.google.android.browser", "com.android.browser.BrowserActivity", str);
                        return true;
                    } catch (java.lang.Exception unused3) {
                        return false;
                    }
                } catch (java.lang.Exception unused4) {
                    a(context, "com.android.chrome", "com.google.android.apps.chrome.Main", str);
                    return true;
                }
            }
            try {
                try {
                    try {
                        a(context, "com.android.browser", "com.android.browser.BrowserActivity", str);
                        return true;
                    } catch (java.lang.Exception unused5) {
                        return false;
                    }
                } catch (java.lang.Exception unused6) {
                    a(context, "com.android.chrome", "com.google.android.apps.chrome.Main", str);
                    return true;
                }
            } catch (java.lang.Exception unused7) {
                a(context, "com.google.android.browser", "com.android.browser.BrowserActivity", str);
                return true;
            }
        }
    }

    public static boolean a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        boolean a2 = a(str, str2);
        com.tencent.open.log.SLog.i("openSDK_LOG.Util", "copyFileByCheckPermission() copy success:" + a2);
        return a2;
    }

    public static boolean a(android.content.Context context, boolean z) {
        return (c(context) && com.tencent.open.utils.i.a(context, com.tencent.connect.common.Constants.PACKAGE_QQ_PAD) != null) || com.tencent.open.utils.i.c(context, "4.1") >= 0 || com.tencent.open.utils.i.a(context, com.tencent.connect.common.Constants.PACKAGE_TIM) != null || com.tencent.open.utils.i.a(context, com.tencent.connect.common.Constants.PACKAGE_QQ_SPEED) != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v19 */
    /* JADX WARN: Type inference failed for: r7v20 */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v9 */
    public static boolean a(java.io.File file, java.io.File file2) {
        java.io.FileOutputStream fileOutputStream;
        java.io.FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (file2.getParentFile() != null && !file2.getParentFile().exists()) {
                        file2.getParentFile().mkdirs();
                    }
                    fileOutputStream = new java.io.FileOutputStream(file2);
                    try {
                        file2 = new java.io.BufferedInputStream(new java.io.FileInputStream(file));
                    } catch (java.io.IOException e2) {
                        e = e2;
                        file2 = 0;
                    } catch (java.lang.OutOfMemoryError e3) {
                        e = e3;
                        file2 = 0;
                    } catch (java.lang.Throwable th) {
                        th = th;
                        file2 = 0;
                    }
                } catch (java.io.IOException e4) {
                    com.tencent.open.log.SLog.e("openSDK_LOG.Util", "copyFile error, ", e4);
                    return false;
                }
            } catch (java.io.IOException e5) {
                e = e5;
                file2 = 0;
            } catch (java.lang.OutOfMemoryError e6) {
                e = e6;
                file2 = 0;
            } catch (java.lang.Throwable th2) {
                th = th2;
                file2 = 0;
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
        }
        try {
            byte[] bArr = new byte[102400];
            while (true) {
                int read = file2.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                    fileOutputStream.flush();
                } else {
                    try {
                        break;
                    } catch (java.io.IOException e7) {
                        com.tencent.open.log.SLog.e("openSDK_LOG.Util", "copyFile error, ", e7);
                    }
                }
            }
            fileOutputStream.close();
            try {
                file2.close();
            } catch (java.io.IOException e8) {
                com.tencent.open.log.SLog.e("openSDK_LOG.Util", "copyFile error, ", e8);
            }
            return true;
        } catch (java.io.IOException e9) {
            e = e9;
            fileOutputStream2 = fileOutputStream;
            file2 = file2;
            com.tencent.open.log.SLog.e("openSDK_LOG.Util", "copyFile error, ", e);
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (java.io.IOException e10) {
                    com.tencent.open.log.SLog.e("openSDK_LOG.Util", "copyFile error, ", e10);
                }
            }
            if (file2 != 0) {
                file2.close();
                file2 = file2;
            }
            return false;
        } catch (java.lang.OutOfMemoryError e11) {
            e = e11;
            fileOutputStream2 = fileOutputStream;
            file2 = file2;
            com.tencent.open.log.SLog.e("openSDK_LOG.Util", "copyFile error, ", e);
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (java.io.IOException e12) {
                    com.tencent.open.log.SLog.e("openSDK_LOG.Util", "copyFile error, ", e12);
                }
            }
            if (file2 != 0) {
                file2.close();
                file2 = file2;
            }
            return false;
        } catch (java.lang.Throwable th4) {
            th = th4;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (java.io.IOException e13) {
                    com.tencent.open.log.SLog.e("openSDK_LOG.Util", "copyFile error, ", e13);
                }
            }
            if (file2 == 0) {
                throw th;
            }
            try {
                file2.close();
                throw th;
            } catch (java.io.IOException e14) {
                com.tencent.open.log.SLog.e("openSDK_LOG.Util", "copyFile error, ", e14);
                throw th;
            }
        }
    }

    public static boolean a(java.lang.String str, java.lang.String str2) {
        java.io.File file = new java.io.File(str);
        if (file.exists()) {
            try {
                return a(file, m(str2));
            } catch (java.io.IOException e2) {
                com.tencent.open.log.SLog.d("openSDK_LOG.Util", "copy fail from " + str + " to " + str2 + " ", e2);
            }
        }
        return false;
    }

    public static boolean a(java.util.Map<java.lang.String, java.lang.Object> map, java.lang.String str, boolean z) {
        if (map == null) {
            com.tencent.open.log.SLog.e("openSDK_LOG.Util", "getBoolean error, params==null");
            return z;
        }
        if (map.containsKey(str)) {
            java.lang.Object obj = map.get(str);
            return obj instanceof java.lang.Boolean ? ((java.lang.Boolean) obj).booleanValue() : z;
        }
        com.tencent.open.log.SLog.e("openSDK_LOG.Util", "getBoolean error, not comtain : " + str);
        return z;
    }

    private static byte[] a(byte[] bArr, java.lang.String str) {
        if (bArr != null) {
            try {
                char[] charArray = str.toCharArray();
                int length = bArr.length;
                byte[] bArr2 = new byte[length];
                for (int i = 0; i < length; i++) {
                    bArr2[i] = (byte) (bArr[i] ^ charArray[i % charArray.length]);
                }
                return bArr2;
            } catch (java.lang.Throwable th) {
                com.tencent.open.log.SLog.e("Util", "xor Exception! ", th);
            }
        }
        return bArr;
    }

    public static android.os.Bundle b(java.lang.String str) {
        try {
            java.net.URL url = new java.net.URL(str.replace("auth://", "http://"));
            android.os.Bundle a2 = a(url.getQuery());
            a2.putAll(a(url.getRef()));
            return a2;
        } catch (java.net.MalformedURLException unused) {
            return new android.os.Bundle();
        }
    }

    public static java.lang.String b() {
        java.io.File e2 = com.tencent.open.utils.f.e();
        if (e2 == null) {
            return null;
        }
        if (!e2.exists()) {
            e2.mkdirs();
        }
        return e2.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:104:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01e2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01c5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01ff A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String b(android.content.Context context, android.net.Uri uri) {
        android.database.Cursor cursor;
        java.io.FileOutputStream fileOutputStream;
        android.os.ParcelFileDescriptor parcelFileDescriptor;
        java.io.FileInputStream fileInputStream;
        java.io.FileInputStream fileInputStream2 = null;
        try {
            cursor = context.getContentResolver().query(uri, new java.lang.String[]{"_data"}, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        return cursor.getString(cursor.getColumnIndexOrThrow("_data"));
                    }
                } catch (java.lang.Exception e2) {
                    e = e2;
                    com.tencent.open.log.SLog.e("openSDK_LOG.Util", "queryAbsolutePath error : " + e.getMessage());
                    if (cursor != null) {
                        cursor.close();
                    }
                    try {
                        parcelFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r");
                        try {
                            fileInputStream = new java.io.FileInputStream(parcelFileDescriptor.getFileDescriptor());
                        } catch (java.lang.Exception e3) {
                            e = e3;
                            fileOutputStream = null;
                            fileInputStream = null;
                        } catch (java.lang.Throwable th) {
                            th = th;
                            fileOutputStream = null;
                        }
                    } catch (java.lang.Exception e4) {
                        e = e4;
                        fileOutputStream = null;
                        parcelFileDescriptor = null;
                        fileInputStream = null;
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        fileOutputStream = null;
                        parcelFileDescriptor = null;
                    }
                    try {
                        java.io.File h = h(context, "Images");
                        if (h == null) {
                            com.tencent.open.log.SLog.e("openSDK_LOG.Util", "getExternalFilesDir return null");
                            try {
                                fileInputStream.close();
                            } catch (java.io.IOException e5) {
                                com.tencent.open.log.SLog.e("openSDK_LOG.Util", "close fileIuputStream error" + e5.getMessage());
                            }
                            try {
                                parcelFileDescriptor.close();
                            } catch (java.io.IOException e6) {
                                com.tencent.open.log.SLog.e("openSDK_LOG.Util", "close ParcelFileDescriptor error" + e6.getMessage());
                            }
                            return null;
                        }
                        if (!h.exists()) {
                            h.mkdirs();
                        }
                        java.io.File file = new java.io.File(h, uri.getLastPathSegment());
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                        java.io.FileOutputStream fileOutputStream2 = new java.io.FileOutputStream(file);
                        try {
                            byte[] bArr = new byte[2048];
                            while (true) {
                                int read = fileInputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                fileOutputStream2.write(bArr, 0, read);
                            }
                            fileOutputStream2.flush();
                            java.lang.String absolutePath = file.getAbsolutePath();
                            try {
                                fileInputStream.close();
                            } catch (java.io.IOException e7) {
                                com.tencent.open.log.SLog.e("openSDK_LOG.Util", "close fileIuputStream error" + e7.getMessage());
                            }
                            try {
                                fileOutputStream2.close();
                            } catch (java.io.IOException e8) {
                                com.tencent.open.log.SLog.e("openSDK_LOG.Util", "close fileOutputStream error" + e8.getMessage());
                            }
                            try {
                                parcelFileDescriptor.close();
                            } catch (java.io.IOException e9) {
                                com.tencent.open.log.SLog.e("openSDK_LOG.Util", "close ParcelFileDescriptor error" + e9.getMessage());
                            }
                            return absolutePath;
                        } catch (java.lang.Exception e10) {
                            fileOutputStream = fileOutputStream2;
                            e = e10;
                            try {
                                com.tencent.open.log.SLog.e("openSDK_LOG.Util", "copy file from uri error : " + e.getMessage());
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (java.io.IOException e11) {
                                        com.tencent.open.log.SLog.e("openSDK_LOG.Util", "close fileIuputStream error" + e11.getMessage());
                                    }
                                }
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (java.io.IOException e12) {
                                        com.tencent.open.log.SLog.e("openSDK_LOG.Util", "close fileOutputStream error" + e12.getMessage());
                                    }
                                }
                                if (parcelFileDescriptor != null) {
                                    try {
                                        parcelFileDescriptor.close();
                                    } catch (java.io.IOException e13) {
                                        com.tencent.open.log.SLog.e("openSDK_LOG.Util", "close ParcelFileDescriptor error" + e13.getMessage());
                                    }
                                }
                                return null;
                            } catch (java.lang.Throwable th3) {
                                th = th3;
                                fileInputStream2 = fileInputStream;
                                if (fileInputStream2 != null) {
                                    try {
                                        fileInputStream2.close();
                                    } catch (java.io.IOException e14) {
                                        com.tencent.open.log.SLog.e("openSDK_LOG.Util", "close fileIuputStream error" + e14.getMessage());
                                    }
                                }
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (java.io.IOException e15) {
                                        com.tencent.open.log.SLog.e("openSDK_LOG.Util", "close fileOutputStream error" + e15.getMessage());
                                    }
                                }
                                if (parcelFileDescriptor == null) {
                                    throw th;
                                }
                                try {
                                    parcelFileDescriptor.close();
                                    throw th;
                                } catch (java.io.IOException e16) {
                                    com.tencent.open.log.SLog.e("openSDK_LOG.Util", "close ParcelFileDescriptor error" + e16.getMessage());
                                    throw th;
                                }
                            }
                        } catch (java.lang.Throwable th4) {
                            fileInputStream2 = fileInputStream;
                            fileOutputStream = fileOutputStream2;
                            th = th4;
                            if (fileInputStream2 != null) {
                            }
                            if (fileOutputStream != null) {
                            }
                            if (parcelFileDescriptor == null) {
                            }
                        }
                    } catch (java.lang.Exception e17) {
                        e = e17;
                        fileOutputStream = null;
                    } catch (java.lang.Throwable th5) {
                        th = th5;
                        fileOutputStream = null;
                        fileInputStream2 = fileInputStream;
                        if (fileInputStream2 != null) {
                        }
                        if (fileOutputStream != null) {
                        }
                        if (parcelFileDescriptor == null) {
                        }
                    }
                }
            }
            return null;
        } catch (java.lang.Exception e18) {
            e = e18;
            cursor = null;
        }
    }

    public static void b(android.content.Context context, java.lang.String str) {
        if (context == null) {
            return;
        }
        try {
            android.content.pm.PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            java.lang.String str2 = packageInfo.versionName;
            b = str2;
            a = str2.substring(0, str2.lastIndexOf(46));
            java.lang.String str3 = b;
            d = str3.substring(str3.lastIndexOf(46) + 1, b.length());
            e = packageInfo.versionCode;
        } catch (android.content.pm.PackageManager.NameNotFoundException e2) {
            com.tencent.open.log.SLog.e("openSDK_LOG.Util", "getPackageInfo has exception: " + e2.getMessage());
        } catch (java.lang.Exception e3) {
            com.tencent.open.log.SLog.e("openSDK_LOG.Util", "getPackageInfo has exception: " + e3.getMessage());
        }
    }

    public static boolean b(android.content.Context context) {
        android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return true;
        }
        android.net.NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
        if (allNetworkInfo != null) {
            for (android.net.NetworkInfo networkInfo : allNetworkInfo) {
                if (networkInfo.isConnectedOrConnecting()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static java.lang.String c(android.content.Context context, java.lang.String str) {
        if (context == null) {
            return "";
        }
        b(context, str);
        return b;
    }

    public static org.json.JSONObject c(java.lang.String str) {
        try {
            java.net.URL url = new java.net.URL(str.replace("auth://", "http://"));
            org.json.JSONObject a2 = a((org.json.JSONObject) null, url.getQuery());
            a(a2, url.getRef());
            return a2;
        } catch (java.net.MalformedURLException unused) {
            return new org.json.JSONObject();
        }
    }

    public static boolean c() {
        android.content.Context a2 = com.tencent.open.utils.f.a();
        return a2 != null && a2.getPackageManager().checkPermission(com.anythink.china.common.d.b, a2.getPackageName()) == 0;
    }

    public static boolean c(android.content.Context context) {
        double d2;
        try {
            android.util.DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            d2 = java.lang.Math.sqrt(java.lang.Math.pow(displayMetrics.widthPixels / displayMetrics.xdpi, 2.0d) + java.lang.Math.pow(displayMetrics.heightPixels / displayMetrics.ydpi, 2.0d));
        } catch (java.lang.Throwable unused) {
            d2 = 0.0d;
        }
        return d2 > 6.5d;
    }

    public static java.lang.String d(android.content.Context context, java.lang.String str) {
        if (context == null) {
            return "";
        }
        b(context, str);
        return a;
    }

    public static org.json.JSONObject d(java.lang.String str) throws org.json.JSONException {
        if (str.equals(com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE)) {
            str = "{value : false}";
        }
        if (str.equals(com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE)) {
            str = "{value : true}";
        }
        if (str.contains("allback(")) {
            str = str.replaceFirst("[\\s\\S]*allback\\(([\\s\\S]*)\\);[^\\)]*\\z", "$1").trim();
        }
        if (str.contains("online[0]=")) {
            str = "{online:" + str.charAt(str.length() - 2) + com.alipay.sdk.m.u.i.d;
        }
        return new org.json.JSONObject(str);
    }

    public static boolean d(android.content.Context context) {
        return com.tencent.open.utils.i.c(context, "8.1.5") >= 0;
    }

    public static java.lang.String e(android.content.Context context, java.lang.String str) {
        if (context == null) {
            return "";
        }
        java.lang.String d2 = d(context, str);
        c = d2;
        return d2;
    }

    public static boolean e(android.content.Context context) {
        return com.tencent.open.utils.i.c(context, "8.1.8") >= 0;
    }

    public static boolean e(java.lang.String str) {
        return str == null || str.length() == 0;
    }

    public static java.lang.String f(java.lang.String str) {
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
            messageDigest.update(i(str));
            byte[] digest = messageDigest.digest();
            if (digest == null) {
                return str;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            for (byte b2 : digest) {
                sb.append(a(b2 >>> 4));
                sb.append(a(b2));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e2) {
            com.tencent.open.log.SLog.e("openSDK_LOG.Util", "encrypt has exception: " + e2.getMessage());
            return str;
        }
    }

    public static boolean f(android.content.Context context) {
        return com.tencent.open.utils.i.c(context, "5.9.5") >= 0 || com.tencent.open.utils.i.a(context, com.tencent.connect.common.Constants.PACKAGE_QQ_SPEED) != null;
    }

    public static boolean f(android.content.Context context, java.lang.String str) {
        boolean z = !c(context) || com.tencent.open.utils.i.a(context, com.tencent.connect.common.Constants.PACKAGE_QQ_PAD) == null;
        if (z && com.tencent.open.utils.i.a(context, com.tencent.connect.common.Constants.PACKAGE_TIM) != null) {
            z = false;
        }
        if (z && com.tencent.open.utils.i.a(context, com.tencent.connect.common.Constants.PACKAGE_QQ_SPEED) != null) {
            z = false;
        }
        if (z) {
            return com.tencent.open.utils.i.c(context, str) < 0;
        }
        return z;
    }

    private static boolean g(android.content.Context context) {
        android.content.pm.Signature[] signatureArr;
        try {
            android.content.pm.PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.tencent.mtt", 64);
            java.lang.String str = packageInfo.versionName;
            if (com.tencent.open.utils.i.a(str, "4.3") >= 0 && !str.startsWith("4.4") && (signatureArr = packageInfo.signatures) != null) {
                try {
                    java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
                    messageDigest.update(signatureArr[0].toByteArray());
                    java.lang.String a2 = a(messageDigest.digest());
                    messageDigest.reset();
                    if (a2.equals("d8391a394d4a179e6fe7bdb8a301258b")) {
                        return true;
                    }
                } catch (java.security.NoSuchAlgorithmException e2) {
                    com.tencent.open.log.SLog.e("openSDK_LOG.Util", "isQQBrowerAvailable has exception: " + e2.getMessage());
                }
            }
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public static boolean g(android.content.Context context, java.lang.String str) {
        boolean z = !c(context) || com.tencent.open.utils.i.a(context, com.tencent.connect.common.Constants.PACKAGE_QQ_PAD) == null;
        if (z && com.tencent.open.utils.i.a(context, com.tencent.connect.common.Constants.PACKAGE_QQ_SPEED) != null) {
            z = false;
        }
        if (z) {
            return com.tencent.open.utils.i.c(context, str) < 0;
        }
        return z;
    }

    public static final boolean g(java.lang.String str) {
        if (str == null) {
            return false;
        }
        return str.startsWith("http://") || str.startsWith("https://");
    }

    public static java.io.File h(android.content.Context context, java.lang.String str) {
        java.io.File[] externalFilesDirs;
        if (context == null || (externalFilesDirs = context.getExternalFilesDirs(str)) == null || externalFilesDirs.length <= 0) {
            return null;
        }
        return externalFilesDirs[0];
    }

    public static boolean h(java.lang.String str) {
        return str != null && new java.io.File(str).exists();
    }

    public static byte[] i(java.lang.String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (java.io.UnsupportedEncodingException unused) {
            return null;
        }
    }

    public static long j(java.lang.String str) {
        java.io.FileInputStream fileInputStream = null;
        try {
            java.io.File file = new java.io.File(str);
            if (!file.exists()) {
                return 0L;
            }
            java.io.FileInputStream fileInputStream2 = new java.io.FileInputStream(file);
            try {
                long available = fileInputStream2.available();
                try {
                    fileInputStream2.close();
                } catch (java.io.IOException unused) {
                }
                return available;
            } catch (java.lang.Exception unused2) {
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (java.io.IOException unused3) {
                    }
                }
                return 0L;
            } catch (java.lang.Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (java.io.IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (java.lang.Exception unused5) {
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    public static java.lang.String k(java.lang.String str) {
        if (str == null) {
            return null;
        }
        return android.util.Base64.encodeToString(a(str.getBytes(), "JCPTZXEZ"), 3);
    }

    public static java.lang.String l(java.lang.String str) {
        if (!android.text.TextUtils.isEmpty(str)) {
            try {
                return android.util.Base64.encodeToString(str.getBytes("UTF-8"), 2);
            } catch (java.io.UnsupportedEncodingException e2) {
                com.tencent.open.log.SLog.e("openSDK_LOG.Util", "convert2Base64String exception: " + e2.getMessage());
            }
        }
        return "";
    }

    public static java.io.File m(java.lang.String str) throws java.io.IOException {
        java.io.File file = new java.io.File(str);
        if (!file.exists()) {
            if (file.getParentFile() == null || file.getParentFile().exists()) {
                file.createNewFile();
            } else if (file.getParentFile().mkdirs()) {
                file.createNewFile();
            } else {
                com.tencent.open.log.SLog.d("openSDK_LOG.Util", "createFile failed" + str);
            }
        }
        return file;
    }

    public static boolean n(java.lang.String str) {
        java.lang.String b2 = b();
        return (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(b2) || !str.contains(b2)) ? false : true;
    }
}
