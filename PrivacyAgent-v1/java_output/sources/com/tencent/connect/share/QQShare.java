package com.tencent.connect.share;

/* loaded from: classes19.dex */
public class QQShare extends com.tencent.connect.common.BaseApi {
    public static final int QQ_SHARE_SUMMARY_MAX_LENGTH = 512;
    public static final int QQ_SHARE_TITLE_MAX_LENGTH = 128;
    public static final java.lang.String SHARE_TO_QQ_APP_NAME = "appName";
    public static final java.lang.String SHARE_TO_QQ_ARK_INFO = "share_to_qq_ark_info";
    public static final java.lang.String SHARE_TO_QQ_AUDIO_URL = "audio_url";
    public static final java.lang.String SHARE_TO_QQ_EXT_INT = "cflag";
    public static final java.lang.String SHARE_TO_QQ_EXT_STR = "share_qq_ext_str";
    public static final int SHARE_TO_QQ_FLAG_QZONE_AUTO_OPEN = 1;
    public static final int SHARE_TO_QQ_FLAG_QZONE_ITEM_HIDE = 2;
    public static final java.lang.String SHARE_TO_QQ_IMAGE_LOCAL_URL = "imageLocalUrl";
    public static final java.lang.String SHARE_TO_QQ_IMAGE_URL = "imageUrl";
    public static final java.lang.String SHARE_TO_QQ_KEY_TYPE = "req_type";
    public static final int SHARE_TO_QQ_MINI_PROGRAM = 7;
    public static final java.lang.String SHARE_TO_QQ_MINI_PROGRAM_APPID = "mini_program_appid";
    public static final java.lang.String SHARE_TO_QQ_MINI_PROGRAM_PATH = "mini_program_path";
    public static final java.lang.String SHARE_TO_QQ_MINI_PROGRAM_TYPE = "mini_program_type";
    public static final java.lang.String SHARE_TO_QQ_SITE = "site";
    public static final java.lang.String SHARE_TO_QQ_SUMMARY = "summary";
    public static final java.lang.String SHARE_TO_QQ_TARGET_URL = "targetUrl";
    public static final java.lang.String SHARE_TO_QQ_TITLE = "title";
    public static final int SHARE_TO_QQ_TYPE_AUDIO = 2;
    public static final int SHARE_TO_QQ_TYPE_DEFAULT = 1;
    public static final int SHARE_TO_QQ_TYPE_IMAGE = 5;
    public java.lang.String mViaShareQQType;

    /* renamed from: com.tencent.connect.share.QQShare$1, reason: invalid class name */
    public class AnonymousClass1 implements com.tencent.open.utils.d {
        final /* synthetic */ android.os.Bundle a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ java.lang.String c;
        final /* synthetic */ com.tencent.tauth.IUiListener d;
        final /* synthetic */ android.app.Activity e;

        public AnonymousClass1(android.os.Bundle bundle, java.lang.String str, java.lang.String str2, com.tencent.tauth.IUiListener iUiListener, android.app.Activity activity) {
            this.a = bundle;
            this.b = str;
            this.c = str2;
            this.d = iUiListener;
            this.e = activity;
        }

        @Override // com.tencent.open.utils.d
        public void a(int i, java.lang.String str) {
            if (i == 0) {
                this.a.putString("imageLocalUrl", str);
            } else if (android.text.TextUtils.isEmpty(this.b) && android.text.TextUtils.isEmpty(this.c)) {
                com.tencent.tauth.IUiListener iUiListener = this.d;
                if (iUiListener != null) {
                    iUiListener.onError(new com.tencent.tauth.UiError(-6, com.tencent.connect.common.Constants.MSG_SHARE_GETIMG_ERROR, null));
                    com.tencent.open.log.SLog.e("openSDK_LOG.QQShare", "shareToMobileQQ -- error: 获取分享图片失败!");
                }
                com.tencent.open.a.d.a().a(1, "SHARE_CHECK_SDK", com.tencent.connect.common.Constants.DEFAULT_UIN, ((com.tencent.connect.common.BaseApi) com.tencent.connect.share.QQShare.this).c.getAppId(), java.lang.String.valueOf(0), java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime()), 0, 1, com.tencent.connect.common.Constants.MSG_SHARE_GETIMG_ERROR);
                return;
            }
            com.tencent.connect.share.QQShare.this.d(this.e, this.a, this.d);
        }

        @Override // com.tencent.open.utils.d
        public void a(int i, java.util.ArrayList<java.lang.String> arrayList) {
        }
    }

    /* renamed from: com.tencent.connect.share.QQShare$2, reason: invalid class name */
    public class AnonymousClass2 implements com.tencent.open.utils.d {
        final /* synthetic */ android.os.Bundle a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ java.lang.String c;
        final /* synthetic */ com.tencent.tauth.IUiListener d;
        final /* synthetic */ android.app.Activity e;

        public AnonymousClass2(android.os.Bundle bundle, java.lang.String str, java.lang.String str2, com.tencent.tauth.IUiListener iUiListener, android.app.Activity activity) {
            this.a = bundle;
            this.b = str;
            this.c = str2;
            this.d = iUiListener;
            this.e = activity;
        }

        @Override // com.tencent.open.utils.d
        public void a(int i, java.lang.String str) {
            if (i == 0) {
                this.a.putString("imageLocalUrl", str);
            } else if (android.text.TextUtils.isEmpty(this.b) && android.text.TextUtils.isEmpty(this.c)) {
                com.tencent.tauth.IUiListener iUiListener = this.d;
                if (iUiListener != null) {
                    iUiListener.onError(new com.tencent.tauth.UiError(-6, com.tencent.connect.common.Constants.MSG_SHARE_GETIMG_ERROR, null));
                    com.tencent.open.log.SLog.e("openSDK_LOG.QQShare", "shareToMobileQQ -- error: 获取分享图片失败!");
                }
                com.tencent.open.a.d.a().a(1, "SHARE_CHECK_SDK", com.tencent.connect.common.Constants.DEFAULT_UIN, ((com.tencent.connect.common.BaseApi) com.tencent.connect.share.QQShare.this).c.getAppId(), java.lang.String.valueOf(0), java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime()), 0, 1, com.tencent.connect.common.Constants.MSG_SHARE_GETIMG_ERROR);
                return;
            }
            com.tencent.connect.share.QQShare.this.d(this.e, this.a, this.d);
        }

        @Override // com.tencent.open.utils.d
        public void a(int i, java.util.ArrayList<java.lang.String> arrayList) {
            if (i == 0) {
                this.a.putStringArrayList("imageLocalUrlArray", arrayList);
            } else if (android.text.TextUtils.isEmpty(this.b) && android.text.TextUtils.isEmpty(this.c)) {
                com.tencent.tauth.IUiListener iUiListener = this.d;
                if (iUiListener != null) {
                    iUiListener.onError(new com.tencent.tauth.UiError(-6, com.tencent.connect.common.Constants.MSG_SHARE_GETIMG_ERROR, null));
                    com.tencent.open.log.SLog.e("openSDK_LOG.QQShare", "shareToMobileQQ -- error: 获取分享图片失败!");
                }
                com.tencent.open.a.d.a().a(1, "SHARE_CHECK_SDK", com.tencent.connect.common.Constants.DEFAULT_UIN, ((com.tencent.connect.common.BaseApi) com.tencent.connect.share.QQShare.this).c.getAppId(), java.lang.String.valueOf(0), java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime()), 0, 1, com.tencent.connect.common.Constants.MSG_SHARE_GETIMG_ERROR);
                return;
            }
            com.tencent.connect.share.QQShare.this.d(this.e, this.a, this.d);
        }
    }

    public QQShare(android.content.Context context, com.tencent.connect.auth.QQToken qQToken) {
        super(qQToken);
        this.mViaShareQQType = "";
    }

    private void b(android.app.Activity activity, android.os.Bundle bundle, com.tencent.tauth.IUiListener iUiListener) {
        com.tencent.open.log.SLog.i("openSDK_LOG.QQShare", "shareToMobileQQ() -- start.");
        java.lang.String string = bundle.getString("imageUrl");
        java.lang.String string2 = bundle.getString("title");
        java.lang.String string3 = bundle.getString("summary");
        com.tencent.open.log.SLog.v("openSDK_LOG.QQShare", "shareToMobileQQ -- imageUrl: " + string);
        if (android.text.TextUtils.isEmpty(string)) {
            if (bundle.getInt("req_type", 1) == 5) {
                c(activity, bundle, iUiListener);
            } else {
                d(activity, bundle, iUiListener);
            }
        } else if (!com.tencent.open.utils.l.g(string)) {
            bundle.putString("imageUrl", null);
            if (com.tencent.open.utils.l.f(activity, "4.3.0")) {
                com.tencent.open.log.SLog.d("openSDK_LOG.QQShare", "shareToMobileQQ -- QQ Version is < 4.3.0 ");
                d(activity, bundle, iUiListener);
            } else {
                com.tencent.open.log.SLog.d("openSDK_LOG.QQShare", "shareToMobileQQ -- QQ Version is > 4.3.0:isAppSpecificDir=" + com.tencent.open.utils.l.n(string) + ",hasSDPermission:" + com.tencent.open.utils.l.c());
                com.tencent.connect.share.a.a(activity, string, new com.tencent.connect.share.QQShare.AnonymousClass2(bundle, string2, string3, iUiListener, activity));
            }
        } else if (com.tencent.open.utils.l.f(activity, "4.3.0")) {
            new com.tencent.open.utils.c(activity).a(string, new com.tencent.connect.share.QQShare.AnonymousClass1(bundle, string2, string3, iUiListener, activity));
        } else {
            d(activity, bundle, iUiListener);
        }
        com.tencent.open.log.SLog.i("openSDK_LOG.QQShare", "shareToMobileQQ() -- end");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x00d1, code lost:
    
        if (r2 != false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void c(android.app.Activity activity, android.os.Bundle bundle, com.tencent.tauth.IUiListener iUiListener) {
        java.lang.String str;
        java.lang.String string = bundle.getString("imageLocalUrl");
        java.lang.String str2 = null;
        if (new java.io.File(string).length() >= com.google.android.exoplayer2.upstream.cache.CacheDataSink.DEFAULT_FRAGMENT_SIZE) {
            if (iUiListener != null) {
                iUiListener.onError(new com.tencent.tauth.UiError(-16, com.tencent.connect.common.Constants.MSG_SHARE_IMAGE_TOO_LARGE_ERROR, null));
            }
            com.tencent.open.log.SLog.e("openSDK_LOG.QQShare", "doShareImageToQQ -- error: 图片太大，请压缩到5M内再分享!");
            return;
        }
        java.io.File a = com.tencent.open.utils.f.a("Images");
        if (a != null) {
            str2 = a.getAbsolutePath() + java.io.File.separator + com.tencent.connect.common.Constants.QQ_SHARE_TEMP_DIR;
        } else {
            com.tencent.open.log.SLog.i("openSDK_LOG.QQShare", "doShareImageToQQ() getExternalFilesDir return null");
        }
        java.io.File file = new java.io.File(string);
        java.lang.String absolutePath = file.getAbsolutePath();
        java.lang.String name = file.getName();
        boolean n = com.tencent.open.utils.l.n(absolutePath);
        com.tencent.open.log.SLog.i("openSDK_LOG.QQShare", "doShareImageToQQ() check file: isAppSpecificDir=" + n + ",hasSDPermission=" + com.tencent.open.utils.l.c() + ",fileDir=" + absolutePath);
        java.util.ArrayList<java.lang.String> arrayList = new java.util.ArrayList<>(2);
        if (!n && !android.text.TextUtils.isEmpty(str2)) {
            str = str2 + java.io.File.separator + name;
            boolean a2 = com.tencent.open.utils.l.a(activity, absolutePath, str);
            com.tencent.open.log.SLog.i("openSDK_LOG.QQShare", "doShareImageToQQ() sd permission not denied. copy to app specific:" + str + ",isSuccess=" + a2);
        }
        str = absolutePath;
        arrayList.add(absolutePath);
        arrayList.add(str);
        com.tencent.open.log.SLog.i("openSDK_LOG.QQShare", "doShareImageToQQ() destFilePaths=[" + arrayList.get(0) + "," + arrayList.get(1) + "]");
        bundle.putStringArrayList("imageLocalUrlArray", arrayList);
        d(activity, bundle, iUiListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(android.app.Activity activity, android.os.Bundle bundle, com.tencent.tauth.IUiListener iUiListener) {
        int i;
        int i2;
        com.tencent.open.log.SLog.i("openSDK_LOG.QQShare", "doShareToQQ() -- start");
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer("mqqapi://share/to_fri?src_type=app&version=1&file_type=news");
        java.lang.String string = bundle.getString("imageUrl");
        java.lang.String string2 = bundle.getString("title");
        java.lang.String string3 = bundle.getString("summary");
        java.lang.String string4 = bundle.getString("targetUrl");
        java.lang.String string5 = bundle.getString("audio_url");
        int i3 = bundle.getInt("req_type", 1);
        java.lang.String string6 = bundle.getString(SHARE_TO_QQ_ARK_INFO);
        java.lang.String string7 = bundle.getString(SHARE_TO_QQ_MINI_PROGRAM_APPID);
        java.lang.String string8 = bundle.getString(SHARE_TO_QQ_MINI_PROGRAM_PATH);
        java.lang.String string9 = bundle.getString(SHARE_TO_QQ_MINI_PROGRAM_TYPE);
        int i4 = bundle.getInt("cflag", 0);
        java.lang.String string10 = bundle.getString("share_qq_ext_str");
        java.lang.String a = com.tencent.open.utils.l.a(activity);
        if (a == null) {
            a = bundle.getString("appName");
        }
        java.lang.String str = a;
        java.lang.String string11 = bundle.getString("imageLocalUrl");
        java.util.ArrayList<java.lang.String> stringArrayList = bundle.getStringArrayList("imageLocalUrlArray");
        java.lang.String appId = this.c.getAppId();
        java.lang.String openIdWithCache = this.c.getOpenIdWithCache();
        com.tencent.open.log.SLog.i("openSDK_LOG.QQShare", "doShareToQQ -- openid: " + openIdWithCache + ",appName=" + str);
        if (stringArrayList != null && stringArrayList.size() >= 2) {
            java.lang.String str2 = stringArrayList.get(0);
            if (str2 == null) {
                str2 = "";
            }
            stringBuffer.append("&file_data=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(str2), 2));
            java.lang.String str3 = stringArrayList.get(1);
            if (i3 == 7 && !android.text.TextUtils.isEmpty(str3) && com.tencent.open.utils.i.c(activity, "8.3.3") < 0) {
                com.tencent.open.log.SLog.e("openSDK_LOG.QQShare", "doShareToQQ() share to mini program set file uri empty");
                str3 = null;
            }
            if (!android.text.TextUtils.isEmpty(str3)) {
                try {
                    java.io.File file = new java.io.File(str3);
                    java.lang.String authorities = com.tencent.tauth.Tencent.getAuthorities(appId);
                    if (!android.text.TextUtils.isEmpty(authorities)) {
                        android.net.Uri uriForFile = androidx.core.content.FileProvider.getUriForFile(activity, authorities, file);
                        activity.grantUriPermission("com.tencent.mobileqq", uriForFile, 3);
                        stringBuffer.append("&file_uri=");
                        stringBuffer.append(android.util.Base64.encodeToString(com.tencent.open.utils.l.i(uriForFile.toString()), 2));
                    }
                } catch (java.lang.Exception e) {
                    com.tencent.open.log.SLog.e("openSDK_LOG.QQShare", "doShareToQQ() getUriForFile exception:", e);
                }
            }
        } else if (!android.text.TextUtils.isEmpty(string11)) {
            stringBuffer.append("&file_data=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(string11), 2));
        }
        if (!android.text.TextUtils.isEmpty(string)) {
            stringBuffer.append("&image_url=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(string), 2));
        }
        if (!android.text.TextUtils.isEmpty(string2)) {
            stringBuffer.append("&title=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(string2), 2));
        }
        if (!android.text.TextUtils.isEmpty(string3)) {
            stringBuffer.append("&description=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(string3), 2));
        }
        if (!android.text.TextUtils.isEmpty(appId)) {
            stringBuffer.append("&share_id=" + appId);
        }
        if (!android.text.TextUtils.isEmpty(string4)) {
            stringBuffer.append("&url=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(string4), 2));
        }
        if (!android.text.TextUtils.isEmpty(str)) {
            if (str.length() > 20) {
                str = str.substring(0, 20) + "...";
            }
            stringBuffer.append("&app_name=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(str), 2));
        }
        if (!android.text.TextUtils.isEmpty(openIdWithCache)) {
            stringBuffer.append("&open_id=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(openIdWithCache), 2));
        }
        if (!android.text.TextUtils.isEmpty(string5)) {
            stringBuffer.append("&audioUrl=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(string5), 2));
        }
        stringBuffer.append("&req_type=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(java.lang.String.valueOf(i3)), 2));
        if (!android.text.TextUtils.isEmpty(string7)) {
            stringBuffer.append("&mini_program_appid=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(java.lang.String.valueOf(string7)), 2));
        }
        if (!android.text.TextUtils.isEmpty(string8)) {
            stringBuffer.append("&mini_program_path=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(java.lang.String.valueOf(string8)), 2));
        }
        if (!android.text.TextUtils.isEmpty(string9)) {
            stringBuffer.append("&mini_program_type=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(java.lang.String.valueOf(string9)), 2));
        }
        if (!android.text.TextUtils.isEmpty(string6)) {
            stringBuffer.append("&share_to_qq_ark_info=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(string6), 2));
        }
        if (!android.text.TextUtils.isEmpty(string10)) {
            stringBuffer.append("&share_qq_ext_str=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(string10), 2));
        }
        stringBuffer.append("&cflag=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(java.lang.String.valueOf(i4)), 2));
        stringBuffer.append("&third_sd=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(java.lang.String.valueOf(com.tencent.open.utils.l.c())), 2));
        com.tencent.open.log.SLog.v("openSDK_LOG.QQShare", "doShareToQQ -- url: " + stringBuffer.toString());
        com.tencent.connect.a.a.a(com.tencent.open.utils.f.a(), this.c, "requireApi", "shareToNativeQQ");
        android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW");
        intent.setData(android.net.Uri.parse(stringBuffer.toString()));
        intent.putExtra("pkg_name", activity.getPackageName());
        if (com.tencent.open.utils.l.f(activity, "4.6.0")) {
            com.tencent.open.log.SLog.i("openSDK_LOG.QQShare", "doShareToQQ, qqver below 4.6.");
            if (a(intent)) {
                com.tencent.connect.common.UIListenerManager.getInstance().setListenerWithRequestcode(com.tencent.connect.common.Constants.REQUEST_OLD_SHARE, iUiListener);
                a(activity, intent, com.tencent.connect.common.Constants.REQUEST_OLD_SHARE);
            }
            i2 = i4;
            i = 1;
        } else {
            com.tencent.open.log.SLog.i("openSDK_LOG.QQShare", "doShareToQQ, qqver greater than 4.6.");
            if (com.tencent.connect.common.UIListenerManager.getInstance().setListnerWithAction("shareToQQ", iUiListener) != null) {
                com.tencent.open.log.SLog.i("openSDK_LOG.QQShare", "doShareToQQ, last listener is not null, cancel it.");
            }
            if (a(intent)) {
                i = 1;
                a(activity, com.tencent.connect.common.Constants.REQUEST_QQ_SHARE, intent, true);
            } else {
                i = 1;
            }
            i2 = i4;
        }
        java.lang.String str4 = i2 == i ? com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE : com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_QQ;
        if (a(intent)) {
            com.tencent.open.a.d.a().a(this.c.getOpenId(), this.c.getAppId(), com.tencent.connect.common.Constants.VIA_SHARE_TO_QQ, str4, "3", "0", this.mViaShareQQType, "0", "1", "0");
            com.tencent.open.a.d.a().a(0, "SHARE_CHECK_SDK", com.tencent.connect.common.Constants.DEFAULT_UIN, this.c.getAppId(), java.lang.String.valueOf(0), java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime()), 0, 1, "");
        } else {
            com.tencent.open.a.d.a().a(this.c.getOpenId(), this.c.getAppId(), com.tencent.connect.common.Constants.VIA_SHARE_TO_QQ, str4, "3", "1", this.mViaShareQQType, "0", "1", "0");
            com.tencent.open.a.d.a().a(1, "SHARE_CHECK_SDK", com.tencent.connect.common.Constants.DEFAULT_UIN, this.c.getAppId(), java.lang.String.valueOf(0), java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime()), 0, 1, "hasActivityForIntent fail");
        }
        com.tencent.open.log.SLog.i("openSDK_LOG.QQShare", "doShareToQQ() --end");
    }

    @Override // com.tencent.connect.common.BaseApi
    public void releaseResource() {
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x02e2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void shareToQQ(android.app.Activity activity, android.os.Bundle bundle, com.tencent.tauth.IUiListener iUiListener) {
        int i;
        android.os.Bundle bundle2;
        java.lang.String str;
        com.tencent.open.log.SLog.i("openSDK_LOG.QQShare", "shareToQQ() -- start.");
        java.lang.String string = bundle.getString("imageUrl");
        java.lang.String string2 = bundle.getString("title");
        java.lang.String string3 = bundle.getString("summary");
        java.lang.String string4 = bundle.getString("targetUrl");
        java.lang.String string5 = bundle.getString("imageLocalUrl");
        java.lang.String string6 = bundle.getString(SHARE_TO_QQ_MINI_PROGRAM_APPID);
        java.lang.String string7 = bundle.getString(SHARE_TO_QQ_MINI_PROGRAM_PATH);
        int i2 = bundle.getInt("req_type", 1);
        com.tencent.open.log.SLog.i("openSDK_LOG.QQShare", "shareToQQ -- type: " + i2);
        if (i2 == 1) {
            this.mViaShareQQType = "1";
        } else if (i2 == 2) {
            this.mViaShareQQType = "3";
        } else if (i2 == 5) {
            this.mViaShareQQType = "2";
        } else if (i2 == 7) {
            this.mViaShareQQType = "9";
        }
        if (!com.tencent.open.utils.l.a() && com.tencent.open.utils.l.f(activity, "4.5.0")) {
            iUiListener.onError(new com.tencent.tauth.UiError(-6, com.tencent.connect.common.Constants.MSG_SHARE_NOSD_ERROR, null));
            com.tencent.open.log.SLog.e("openSDK_LOG.QQShare", "shareToQQ sdcard is null--end");
            com.tencent.open.a.d.a().a(1, "SHARE_CHECK_SDK", com.tencent.connect.common.Constants.DEFAULT_UIN, this.c.getAppId(), java.lang.String.valueOf(0), java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime()), 0, 1, "shareToQQ sdcard is null");
            return;
        }
        if (i2 == 5) {
            if (com.tencent.open.utils.l.f(activity, "4.3.0")) {
                iUiListener.onError(new com.tencent.tauth.UiError(-6, com.tencent.connect.common.Constants.MSG_PARAM_QQ_VERSION_ERROR, null));
                com.tencent.open.log.SLog.e("openSDK_LOG.QQShare", "shareToQQ, version below 4.3 is not support.");
                com.tencent.open.a.d.a().a(1, "SHARE_CHECK_SDK", com.tencent.connect.common.Constants.DEFAULT_UIN, this.c.getAppId(), java.lang.String.valueOf(0), java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime()), 0, 1, "shareToQQ, version below 4.3 is not support.");
                return;
            } else if (!com.tencent.open.utils.l.h(string5)) {
                iUiListener.onError(new com.tencent.tauth.UiError(-6, com.tencent.connect.common.Constants.MSG_PARAM_IMAGE_URL_FORMAT_ERROR, null));
                com.tencent.open.log.SLog.e("openSDK_LOG.QQShare", "shareToQQ -- error: 非法的图片地址!");
                com.tencent.open.a.d.a().a(1, "SHARE_CHECK_SDK", com.tencent.connect.common.Constants.DEFAULT_UIN, this.c.getAppId(), java.lang.String.valueOf(0), java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime()), 0, 1, com.tencent.connect.common.Constants.MSG_PARAM_IMAGE_URL_FORMAT_ERROR);
                return;
            }
        }
        if (i2 != 5) {
            i = 7;
            if (i2 != 7) {
                if (android.text.TextUtils.isEmpty(string4) || !(string4.startsWith("http://") || string4.startsWith("https://"))) {
                    iUiListener.onError(new com.tencent.tauth.UiError(-6, com.tencent.connect.common.Constants.MSG_PARAM_ERROR, null));
                    com.tencent.open.log.SLog.e("openSDK_LOG.QQShare", "shareToQQ, targetUrl is empty or illegal..");
                    com.tencent.open.a.d.a().a(1, "SHARE_CHECK_SDK", com.tencent.connect.common.Constants.DEFAULT_UIN, this.c.getAppId(), java.lang.String.valueOf(0), java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime()), 0, 1, "shareToQQ, targetUrl is empty or illegal..");
                    return;
                } else if (android.text.TextUtils.isEmpty(string2)) {
                    iUiListener.onError(new com.tencent.tauth.UiError(-6, com.tencent.connect.common.Constants.MSG_PARAM_TITLE_NULL_ERROR, null));
                    com.tencent.open.log.SLog.e("openSDK_LOG.QQShare", "shareToQQ, title is empty.");
                    com.tencent.open.a.d.a().a(1, "SHARE_CHECK_SDK", com.tencent.connect.common.Constants.DEFAULT_UIN, this.c.getAppId(), java.lang.String.valueOf(0), java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime()), 0, 1, "shareToQQ, title is empty.");
                    return;
                }
            }
            if (i2 == i) {
                if (android.text.TextUtils.isEmpty(string6) || android.text.TextUtils.isEmpty(string7) || android.text.TextUtils.isEmpty(string4) || android.text.TextUtils.isEmpty(this.c.getAppId())) {
                    iUiListener.onError(new com.tencent.tauth.UiError(-5, com.tencent.connect.common.Constants.MSG_PARAM_ERROR, "appid || path || url empty."));
                    return;
                }
                if (!(com.tencent.open.utils.i.c(activity, "8.0.8") >= 0 || com.tencent.open.utils.i.d(activity, "3.1") >= 0 || com.tencent.open.utils.i.a((android.content.Context) activity, com.tencent.connect.common.Constants.PACKAGE_QQ_SPEED) != null)) {
                    iUiListener.onError(new com.tencent.tauth.UiError(-5, com.tencent.connect.common.Constants.MSG_PARAM_QQ_VERSION_ERROR, "版本过低，不支持分享小程序"));
                    return;
                } else if (android.text.TextUtils.isEmpty(string2) || android.text.TextUtils.isEmpty(string3)) {
                    iUiListener.onError(new com.tencent.tauth.UiError(-5, com.tencent.connect.common.Constants.MSG_PARAM_ERROR, "title || summary empty."));
                    return;
                }
            }
            if (android.text.TextUtils.isEmpty(string) && !string.startsWith("http://") && !string.startsWith("https://") && !new java.io.File(string).exists()) {
                iUiListener.onError(new com.tencent.tauth.UiError(-6, com.tencent.connect.common.Constants.MSG_PARAM_IMAGE_URL_FORMAT_ERROR, null));
                com.tencent.open.log.SLog.e("openSDK_LOG.QQShare", "shareToQQ, image url is emprty or illegal.");
                com.tencent.open.a.d.a().a(1, "SHARE_CHECK_SDK", com.tencent.connect.common.Constants.DEFAULT_UIN, this.c.getAppId(), java.lang.String.valueOf(0), java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime()), 0, 1, "shareToQQ, image url is emprty or illegal.");
                return;
            }
            if (!android.text.TextUtils.isEmpty(string2) || string2.length() <= 128) {
                bundle2 = bundle;
                str = null;
            } else {
                str = null;
                bundle2 = bundle;
                bundle2.putString("title", com.tencent.open.utils.l.a(string2, 128, (java.lang.String) null, (java.lang.String) null));
            }
            if (!android.text.TextUtils.isEmpty(string3) && string3.length() > 512) {
                bundle2.putString("summary", com.tencent.open.utils.l.a(string3, 512, str, str));
            }
            if (com.tencent.open.utils.l.a(activity, bundle2.getInt("cflag", 0) != 1)) {
                try {
                    com.tencent.open.log.SLog.w("openSDK_LOG.QQShare", "shareToQQ, don't support share, will show download dialog");
                    new com.tencent.open.TDialog(activity, "", a(""), null, this.c).show();
                } catch (java.lang.RuntimeException e) {
                    com.tencent.open.log.SLog.e("openSDK_LOG.QQShare", " shareToQQ, TDialog.show not in main thread", e);
                    e.printStackTrace();
                    iUiListener.onError(new com.tencent.tauth.UiError(-6, com.tencent.connect.common.Constants.MSG_NOT_CALL_ON_MAIN_THREAD, null));
                }
            } else {
                com.tencent.open.log.SLog.i("openSDK_LOG.QQShare", "shareToQQ, support share");
                b(activity, bundle, iUiListener);
            }
            com.tencent.open.log.SLog.i("openSDK_LOG.QQShare", "shareToQQ() -- end.");
        }
        i = 7;
        if (i2 == i) {
        }
        if (android.text.TextUtils.isEmpty(string)) {
        }
        if (android.text.TextUtils.isEmpty(string2)) {
        }
        bundle2 = bundle;
        str = null;
        if (!android.text.TextUtils.isEmpty(string3)) {
            bundle2.putString("summary", com.tencent.open.utils.l.a(string3, 512, str, str));
        }
        if (com.tencent.open.utils.l.a(activity, bundle2.getInt("cflag", 0) != 1)) {
        }
        com.tencent.open.log.SLog.i("openSDK_LOG.QQShare", "shareToQQ() -- end.");
    }
}
