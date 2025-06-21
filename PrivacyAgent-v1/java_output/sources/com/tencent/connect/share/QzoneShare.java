package com.tencent.connect.share;

/* loaded from: classes19.dex */
public class QzoneShare extends com.tencent.connect.common.BaseApi {
    public static final java.lang.String SHARE_TO_QQ_APP_NAME = "appName";
    public static final java.lang.String SHARE_TO_QQ_AUDIO_URL = "audio_url";
    public static final java.lang.String SHARE_TO_QQ_EXT_INT = "cflag";
    public static final java.lang.String SHARE_TO_QQ_EXT_STR = "share_qq_ext_str";
    public static final java.lang.String SHARE_TO_QQ_IMAGE_LOCAL_URL = "imageLocalUrl";
    public static final java.lang.String SHARE_TO_QQ_IMAGE_URL = "imageUrl";
    public static final java.lang.String SHARE_TO_QQ_SITE = "site";
    public static final java.lang.String SHARE_TO_QQ_SUMMARY = "summary";
    public static final java.lang.String SHARE_TO_QQ_TARGET_URL = "targetUrl";
    public static final java.lang.String SHARE_TO_QQ_TITLE = "title";
    public static final java.lang.String SHARE_TO_QZONE_EXTMAP = "extMap";
    public static final java.lang.String SHARE_TO_QZONE_KEY_TYPE = "req_type";
    public static final int SHARE_TO_QZONE_TYPE_IMAGE = 5;
    public static final int SHARE_TO_QZONE_TYPE_IMAGE_TEXT = 1;
    public static final int SHARE_TO_QZONE_TYPE_MINI_PROGRAM = 7;
    public static final int SHARE_TO_QZONE_TYPE_NO_TYPE = 0;
    private boolean a;
    private boolean d;
    private boolean e;
    private boolean f;
    public java.lang.String mViaShareQzoneType;

    public QzoneShare(android.content.Context context, com.tencent.connect.auth.QQToken qQToken) {
        super(qQToken);
        this.mViaShareQzoneType = "";
        this.a = true;
        this.d = false;
        this.e = false;
        this.f = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0373  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x03b4  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x03fc  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x038b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(android.app.Activity activity, android.os.Bundle bundle, com.tencent.tauth.IUiListener iUiListener) {
        int i;
        java.lang.String str;
        java.lang.String str2;
        java.lang.String appId;
        java.lang.String openIdWithCache;
        android.content.Intent intent;
        java.lang.String str3;
        com.tencent.open.log.SLog.i("openSDK_LOG.QzoneShare", "doshareToQzone() --start");
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer("mqqapi://share/to_qzone?src_type=app&version=1&file_type=news");
        java.util.ArrayList<java.lang.String> stringArrayList = bundle.getStringArrayList("imageUrl");
        java.lang.String string = bundle.getString("title");
        java.lang.String string2 = bundle.getString("summary");
        java.lang.String string3 = bundle.getString("targetUrl");
        java.lang.String string4 = bundle.getString("audio_url");
        int i2 = bundle.getInt("req_type", 1);
        java.lang.String string5 = bundle.getString("appName");
        java.lang.String string6 = bundle.getString(com.tencent.connect.share.QQShare.SHARE_TO_QQ_MINI_PROGRAM_APPID);
        java.lang.String string7 = bundle.getString(com.tencent.connect.share.QQShare.SHARE_TO_QQ_MINI_PROGRAM_PATH);
        java.lang.String string8 = bundle.getString(com.tencent.connect.share.QQShare.SHARE_TO_QQ_MINI_PROGRAM_TYPE);
        int i3 = bundle.getInt("cflag", 0);
        java.lang.String string9 = bundle.getString("share_qq_ext_str");
        java.lang.String str4 = "";
        try {
            android.os.Bundle bundle2 = bundle.getBundle("extMap");
            if (bundle2 != null) {
                java.util.Set<java.lang.String> keySet = bundle2.keySet();
                str2 = string9;
                try {
                    org.json.JSONObject jSONObject = new org.json.JSONObject();
                    for (java.lang.String str5 : keySet) {
                        str = string6;
                        try {
                            i = i2;
                            try {
                                jSONObject.put(str5, bundle2.get(str5));
                                i2 = i;
                                string6 = str;
                            } catch (java.lang.Exception e) {
                                e = e;
                                com.tencent.open.log.SLog.e("openSDK_LOG.QzoneShare", "ShareToQzone()  --error parse extmap", e);
                                appId = this.c.getAppId();
                                openIdWithCache = this.c.getOpenIdWithCache();
                                com.tencent.open.log.SLog.v("openSDK_LOG.QzoneShare", "openId:" + openIdWithCache);
                                if (stringArrayList != null) {
                                    str3 = stringArrayList.get(0);
                                    stringBuffer.append("&image_url=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(java.net.URLEncoder.encode(str3)), 2));
                                    if (!com.tencent.open.utils.l.g(str3)) {
                                    }
                                }
                                if (!android.text.TextUtils.isEmpty(string)) {
                                }
                                if (!android.text.TextUtils.isEmpty(string2)) {
                                }
                                if (!android.text.TextUtils.isEmpty(appId)) {
                                }
                                if (!android.text.TextUtils.isEmpty(string3)) {
                                }
                                if (!android.text.TextUtils.isEmpty(string5)) {
                                }
                                if (!com.tencent.open.utils.l.e(openIdWithCache)) {
                                }
                                if (!com.tencent.open.utils.l.e(string4)) {
                                }
                                stringBuffer.append("&req_type=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(java.lang.String.valueOf(i)), 2));
                                if (!android.text.TextUtils.isEmpty(str)) {
                                }
                                if (!android.text.TextUtils.isEmpty(string7)) {
                                }
                                if (!android.text.TextUtils.isEmpty(string8)) {
                                }
                                if (!com.tencent.open.utils.l.e(str2)) {
                                }
                                if (!android.text.TextUtils.isEmpty(str4)) {
                                }
                                stringBuffer.append("&cflag=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(java.lang.String.valueOf(i3)), 2));
                                com.tencent.open.log.SLog.v("openSDK_LOG.QzoneShare", "doshareToQzone, url: " + stringBuffer.toString());
                                com.tencent.connect.a.a.a(com.tencent.open.utils.f.a(), this.c, "requireApi", "shareToNativeQQ");
                                intent = new android.content.Intent("android.intent.action.VIEW");
                                intent.setData(android.net.Uri.parse(stringBuffer.toString()));
                                intent.putExtra("pkg_name", activity.getPackageName());
                                if (com.tencent.open.utils.l.g(activity, "4.6.0")) {
                                }
                                if (a(intent)) {
                                }
                                com.tencent.open.log.SLog.i(com.tencent.open.log.SLog.TAG, "doShareToQzone() --end");
                            }
                        } catch (java.lang.Exception e2) {
                            e = e2;
                            i = i2;
                            com.tencent.open.log.SLog.e("openSDK_LOG.QzoneShare", "ShareToQzone()  --error parse extmap", e);
                            appId = this.c.getAppId();
                            openIdWithCache = this.c.getOpenIdWithCache();
                            com.tencent.open.log.SLog.v("openSDK_LOG.QzoneShare", "openId:" + openIdWithCache);
                            if (stringArrayList != null) {
                            }
                            if (!android.text.TextUtils.isEmpty(string)) {
                            }
                            if (!android.text.TextUtils.isEmpty(string2)) {
                            }
                            if (!android.text.TextUtils.isEmpty(appId)) {
                            }
                            if (!android.text.TextUtils.isEmpty(string3)) {
                            }
                            if (!android.text.TextUtils.isEmpty(string5)) {
                            }
                            if (!com.tencent.open.utils.l.e(openIdWithCache)) {
                            }
                            if (!com.tencent.open.utils.l.e(string4)) {
                            }
                            stringBuffer.append("&req_type=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(java.lang.String.valueOf(i)), 2));
                            if (!android.text.TextUtils.isEmpty(str)) {
                            }
                            if (!android.text.TextUtils.isEmpty(string7)) {
                            }
                            if (!android.text.TextUtils.isEmpty(string8)) {
                            }
                            if (!com.tencent.open.utils.l.e(str2)) {
                            }
                            if (!android.text.TextUtils.isEmpty(str4)) {
                            }
                            stringBuffer.append("&cflag=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(java.lang.String.valueOf(i3)), 2));
                            com.tencent.open.log.SLog.v("openSDK_LOG.QzoneShare", "doshareToQzone, url: " + stringBuffer.toString());
                            com.tencent.connect.a.a.a(com.tencent.open.utils.f.a(), this.c, "requireApi", "shareToNativeQQ");
                            intent = new android.content.Intent("android.intent.action.VIEW");
                            intent.setData(android.net.Uri.parse(stringBuffer.toString()));
                            intent.putExtra("pkg_name", activity.getPackageName());
                            if (com.tencent.open.utils.l.g(activity, "4.6.0")) {
                            }
                            if (a(intent)) {
                            }
                            com.tencent.open.log.SLog.i(com.tencent.open.log.SLog.TAG, "doShareToQzone() --end");
                        }
                    }
                    i = i2;
                    str = string6;
                    if (keySet.size() > 0) {
                        str4 = jSONObject.toString();
                    }
                } catch (java.lang.Exception e3) {
                    e = e3;
                    i = i2;
                    str = string6;
                }
            } else {
                i = i2;
                str = string6;
                str2 = string9;
            }
        } catch (java.lang.Exception e4) {
            e = e4;
            i = i2;
            str = string6;
            str2 = string9;
        }
        appId = this.c.getAppId();
        openIdWithCache = this.c.getOpenIdWithCache();
        com.tencent.open.log.SLog.v("openSDK_LOG.QzoneShare", "openId:" + openIdWithCache);
        if (stringArrayList != null && stringArrayList.size() > 0) {
            str3 = stringArrayList.get(0);
            stringBuffer.append("&image_url=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(java.net.URLEncoder.encode(str3)), 2));
            if (!com.tencent.open.utils.l.g(str3)) {
                java.lang.String a = com.tencent.open.utils.l.a(appId, activity, str3, iUiListener);
                if (!android.text.TextUtils.isEmpty(a)) {
                    stringBuffer.append("&image_uri=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(java.net.URLEncoder.encode(a)), 2));
                }
            }
        }
        if (!android.text.TextUtils.isEmpty(string)) {
            stringBuffer.append("&title=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(string), 2));
        }
        if (!android.text.TextUtils.isEmpty(string2)) {
            stringBuffer.append("&description=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(string2), 2));
        }
        if (!android.text.TextUtils.isEmpty(appId)) {
            stringBuffer.append("&share_id=" + appId);
        }
        if (!android.text.TextUtils.isEmpty(string3)) {
            stringBuffer.append("&url=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(string3), 2));
        }
        if (!android.text.TextUtils.isEmpty(string5)) {
            stringBuffer.append("&app_name=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(string5), 2));
        }
        if (!com.tencent.open.utils.l.e(openIdWithCache)) {
            stringBuffer.append("&open_id=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(openIdWithCache), 2));
        }
        if (!com.tencent.open.utils.l.e(string4)) {
            stringBuffer.append("&audioUrl=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(string4), 2));
        }
        stringBuffer.append("&req_type=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(java.lang.String.valueOf(i)), 2));
        if (!android.text.TextUtils.isEmpty(str)) {
            stringBuffer.append("&mini_program_appid=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(java.lang.String.valueOf(str)), 2));
        }
        if (!android.text.TextUtils.isEmpty(string7)) {
            stringBuffer.append("&mini_program_path=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(java.lang.String.valueOf(string7)), 2));
        }
        if (!android.text.TextUtils.isEmpty(string8)) {
            stringBuffer.append("&mini_program_type=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(java.lang.String.valueOf(string8)), 2));
        }
        if (!com.tencent.open.utils.l.e(str2)) {
            stringBuffer.append("&share_qq_ext_str=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(str2), 2));
        }
        if (!android.text.TextUtils.isEmpty(str4)) {
            stringBuffer.append("&share_qzone_ext_str=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(str4), 2));
        }
        stringBuffer.append("&cflag=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(java.lang.String.valueOf(i3)), 2));
        com.tencent.open.log.SLog.v("openSDK_LOG.QzoneShare", "doshareToQzone, url: " + stringBuffer.toString());
        com.tencent.connect.a.a.a(com.tencent.open.utils.f.a(), this.c, "requireApi", "shareToNativeQQ");
        intent = new android.content.Intent("android.intent.action.VIEW");
        intent.setData(android.net.Uri.parse(stringBuffer.toString()));
        intent.putExtra("pkg_name", activity.getPackageName());
        if (com.tencent.open.utils.l.g(activity, "4.6.0")) {
            if (a(intent)) {
                com.tencent.connect.common.UIListenerManager.getInstance().setListenerWithRequestcode(com.tencent.connect.common.Constants.REQUEST_OLD_QZSHARE, iUiListener);
                a(activity, intent, com.tencent.connect.common.Constants.REQUEST_OLD_QZSHARE);
            }
            com.tencent.open.log.SLog.i("openSDK_LOG.QzoneShare", "doShareToQzone() -- QQ Version is < 4.6.0");
        } else {
            com.tencent.open.log.SLog.i("openSDK_LOG.QzoneShare", "doShareToQzone() -- QQ Version is > 4.6.0");
            if (com.tencent.connect.common.UIListenerManager.getInstance().setListnerWithAction("shareToQzone", iUiListener) != null) {
                com.tencent.open.log.SLog.i("openSDK_LOG.QzoneShare", "doShareToQzone() -- do listener onCancel()");
            }
            if (a(intent)) {
                a(activity, com.tencent.connect.common.Constants.REQUEST_QZONE_SHARE, intent, false);
            }
        }
        if (a(intent)) {
            com.tencent.open.a.d.a().a(this.c.getOpenId(), this.c.getAppId(), com.tencent.connect.common.Constants.VIA_SHARE_TO_QZONE, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, "3", "0", this.mViaShareQzoneType, "0", "1", "0");
            com.tencent.open.a.d.a().a(0, "SHARE_CHECK_SDK", com.tencent.connect.common.Constants.DEFAULT_UIN, this.c.getAppId(), java.lang.String.valueOf(4), java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime()), 0, 1, "");
        } else {
            com.tencent.open.a.d.a().a(this.c.getOpenId(), this.c.getAppId(), com.tencent.connect.common.Constants.VIA_SHARE_TO_QZONE, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, "3", "1", this.mViaShareQzoneType, "0", "1", "0");
            com.tencent.open.a.d.a().a(1, "SHARE_CHECK_SDK", com.tencent.connect.common.Constants.DEFAULT_UIN, this.c.getAppId(), java.lang.String.valueOf(4), java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime()), 0, 1, "hasActivityForIntent fail");
        }
        com.tencent.open.log.SLog.i(com.tencent.open.log.SLog.TAG, "doShareToQzone() --end");
    }

    @Override // com.tencent.connect.common.BaseApi
    public void releaseResource() {
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0391  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x039b  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0351  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void shareToQzone(android.app.Activity activity, android.os.Bundle bundle, com.tencent.tauth.IUiListener iUiListener) {
        java.lang.String str;
        java.lang.String str2;
        int i;
        android.os.Bundle bundle2;
        java.lang.String str3;
        com.tencent.open.log.SLog.i("openSDK_LOG.QzoneShare", "shareToQzone() -- start");
        if (bundle == null) {
            iUiListener.onError(new com.tencent.tauth.UiError(-6, com.tencent.connect.common.Constants.MSG_PARAM_NULL_ERROR, null));
            com.tencent.open.log.SLog.e("openSDK_LOG.QzoneShare", "shareToQzone() params is null");
            com.tencent.open.a.d.a().a(1, "SHARE_CHECK_SDK", com.tencent.connect.common.Constants.DEFAULT_UIN, this.c.getAppId(), java.lang.String.valueOf(4), java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime()), 0, 1, com.tencent.connect.common.Constants.MSG_PARAM_NULL_ERROR);
            return;
        }
        java.lang.String string = bundle.getString("title");
        java.lang.String string2 = bundle.getString("summary");
        java.lang.String string3 = bundle.getString("targetUrl");
        java.lang.String string4 = bundle.getString(com.tencent.connect.share.QQShare.SHARE_TO_QQ_MINI_PROGRAM_APPID);
        java.lang.String string5 = bundle.getString(com.tencent.connect.share.QQShare.SHARE_TO_QQ_MINI_PROGRAM_PATH);
        java.util.ArrayList<java.lang.String> stringArrayList = bundle.getStringArrayList("imageUrl");
        java.lang.String a = com.tencent.open.utils.l.a(activity);
        if (a == null) {
            a = bundle.getString("appName");
            str = "appName";
        } else {
            str = "appName";
            if (a.length() > 20) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                str2 = "summary";
                sb.append(a.substring(0, 20));
                sb.append("...");
                a = sb.toString();
                i = bundle.getInt("req_type");
                com.tencent.open.log.SLog.e("openSDK_LOG.QzoneShare", "shareToQzone() get SHARE_TO_QZONE_KEY_TYPE: " + i);
                if (i != 1) {
                    this.mViaShareQzoneType = "1";
                } else if (i != 5) {
                    this.mViaShareQzoneType = "1";
                } else {
                    this.mViaShareQzoneType = "2";
                }
                if (i != 1) {
                    com.tencent.open.log.SLog.e("openSDK_LOG.QzoneShare", "-->shareToQzone, SHARE_TO_QZONE_TYPE_IMAGE_TEXT needTitle = true");
                    this.a = true;
                    this.d = false;
                    this.e = true;
                    this.f = false;
                } else {
                    if (i == 5) {
                        iUiListener.onError(new com.tencent.tauth.UiError(-5, com.tencent.connect.common.Constants.MSG_SHARE_TYPE_ERROR, null));
                        com.tencent.open.log.SLog.e("openSDK_LOG.QzoneShare", "shareToQzone() error--end请选择支持的分享类型");
                        com.tencent.open.a.d.a().a(1, "SHARE_CHECK_SDK", com.tencent.connect.common.Constants.DEFAULT_UIN, this.c.getAppId(), java.lang.String.valueOf(4), java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime()), 0, 1, "shareToQzone() 请选择支持的分享类型");
                        return;
                    }
                    if (i != 7) {
                        if (!com.tencent.open.utils.l.e(string) || !com.tencent.open.utils.l.e(string2)) {
                            this.a = true;
                        } else if (stringArrayList == null || stringArrayList.size() == 0) {
                            string = "来自" + a + "的分享";
                            this.a = true;
                        } else {
                            this.a = false;
                        }
                        this.d = false;
                        com.tencent.open.log.SLog.e("openSDK_LOG.QzoneShare", "-->shareToQzone, default needTitle = true, shareType = " + i);
                        this.e = true;
                        this.f = false;
                    } else {
                        if (android.text.TextUtils.isEmpty(string4) || android.text.TextUtils.isEmpty(string5)) {
                            iUiListener.onError(new com.tencent.tauth.UiError(-5, com.tencent.connect.common.Constants.MSG_PARAM_ERROR, "appid or path empty."));
                        }
                        this.e = false;
                        this.f = false;
                        this.a = false;
                    }
                }
                if (com.tencent.open.utils.l.a() && com.tencent.open.utils.l.g(activity, "4.5.0")) {
                    iUiListener.onError(new com.tencent.tauth.UiError(-6, com.tencent.connect.common.Constants.MSG_SHARE_NOSD_ERROR, null));
                    com.tencent.open.log.SLog.e("openSDK_LOG.QzoneShare", "shareToQzone() sdcard is null--end");
                    com.tencent.open.a.d.a().a(1, "SHARE_CHECK_SDK", com.tencent.connect.common.Constants.DEFAULT_UIN, this.c.getAppId(), java.lang.String.valueOf(4), java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime()), 0, 1, com.tencent.connect.common.Constants.MSG_SHARE_NOSD_ERROR);
                    return;
                }
                if (this.a) {
                    if (android.text.TextUtils.isEmpty(string3)) {
                        iUiListener.onError(new com.tencent.tauth.UiError(-5, com.tencent.connect.common.Constants.MSG_PARAM_TARGETURL_NULL_ERROR, null));
                        com.tencent.open.log.SLog.e("openSDK_LOG.QzoneShare", "shareToQzone() targetUrl null error--end");
                        com.tencent.open.a.d.a().a(1, "SHARE_CHECK_SDK", com.tencent.connect.common.Constants.DEFAULT_UIN, this.c.getAppId(), java.lang.String.valueOf(4), java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime()), 0, 1, com.tencent.connect.common.Constants.MSG_PARAM_TARGETURL_NULL_ERROR);
                        return;
                    } else if (!com.tencent.open.utils.l.g(string3)) {
                        iUiListener.onError(new com.tencent.tauth.UiError(-5, com.tencent.connect.common.Constants.MSG_PARAM_TARGETURL_ERROR, null));
                        com.tencent.open.log.SLog.e("openSDK_LOG.QzoneShare", "shareToQzone() targetUrl error--end");
                        com.tencent.open.a.d.a().a(1, "SHARE_CHECK_SDK", com.tencent.connect.common.Constants.DEFAULT_UIN, this.c.getAppId(), java.lang.String.valueOf(4), java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime()), 0, 1, com.tencent.connect.common.Constants.MSG_PARAM_TARGETURL_ERROR);
                        return;
                    }
                }
                if (this.d) {
                    bundle2 = bundle;
                    java.lang.String str4 = str2;
                    if (this.e && com.tencent.open.utils.l.e(string)) {
                        iUiListener.onError(new com.tencent.tauth.UiError(-6, com.tencent.connect.common.Constants.MSG_PARAM_TITLE_NULL_ERROR, null));
                        com.tencent.open.log.SLog.e("openSDK_LOG.QzoneShare", "shareToQzone() title is null--end");
                        com.tencent.open.a.d.a().a(1, "SHARE_CHECK_SDK", com.tencent.connect.common.Constants.DEFAULT_UIN, this.c.getAppId(), java.lang.String.valueOf(4), java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime()), 0, 1, "shareToQzone() title is null");
                        return;
                    }
                    if (com.tencent.open.utils.l.e(string) || string.length() <= 200) {
                        str3 = null;
                    } else {
                        str3 = null;
                        bundle2.putString("title", com.tencent.open.utils.l.a(string, 200, (java.lang.String) null, (java.lang.String) null));
                    }
                    if (!com.tencent.open.utils.l.e(string2) && string2.length() > 600) {
                        bundle2.putString(str4, com.tencent.open.utils.l.a(string2, 600, str3, str3));
                    }
                } else {
                    bundle2 = bundle;
                    bundle2.putString("title", "");
                    bundle2.putString(str2, "");
                }
                if (!android.text.TextUtils.isEmpty(a)) {
                    bundle2.putString(str, a);
                }
                if (stringArrayList == null && stringArrayList.size() != 0) {
                    int i2 = 0;
                    while (i2 < stringArrayList.size()) {
                        java.lang.String str5 = stringArrayList.get(i2);
                        if (!com.tencent.open.utils.l.g(str5) && !com.tencent.open.utils.l.h(str5)) {
                            stringArrayList.remove(i2);
                            i2--;
                        }
                        i2++;
                    }
                    if (stringArrayList.size() == 0) {
                        iUiListener.onError(new com.tencent.tauth.UiError(-6, com.tencent.connect.common.Constants.MSG_PARAM_IMAGE_URL_FORMAT_ERROR, null));
                        com.tencent.open.log.SLog.e("openSDK_LOG.QzoneShare", "shareToQzone() MSG_PARAM_IMAGE_URL_FORMAT_ERROR--end");
                        com.tencent.open.a.d.a().a(1, "SHARE_CHECK_SDK", com.tencent.connect.common.Constants.DEFAULT_UIN, this.c.getAppId(), java.lang.String.valueOf(4), java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime()), 0, 1, "shareToQzone() 非法的图片地址!");
                        return;
                    }
                    bundle2.putStringArrayList("imageUrl", stringArrayList);
                } else if (this.f) {
                    iUiListener.onError(new com.tencent.tauth.UiError(-6, com.tencent.connect.common.Constants.MSG_PARAM_IMAGE_ERROR, null));
                    com.tencent.open.log.SLog.e("openSDK_LOG.QzoneShare", "shareToQzone() imageUrl is null -- end");
                    com.tencent.open.a.d.a().a(1, "SHARE_CHECK_SDK", com.tencent.connect.common.Constants.DEFAULT_UIN, this.c.getAppId(), java.lang.String.valueOf(4), java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime()), 0, 1, "shareToQzone() imageUrl is null");
                    return;
                }
                if (com.tencent.open.utils.l.g(activity, "4.6.0")) {
                    com.tencent.open.log.SLog.i("openSDK_LOG.QzoneShare", "shareToQzone() qqver greater than 4.6.0");
                    b(activity, bundle, iUiListener);
                } else if (com.tencent.open.utils.i.c(activity, "4.2.0") < 0 || com.tencent.open.utils.i.c(activity, "4.6.0") >= 0) {
                    com.tencent.open.log.SLog.w("openSDK_LOG.QzoneShare", "shareToQzone() qqver below 4.2.0, will show download dialog");
                    new com.tencent.open.TDialog(activity, "", a(""), null, this.c).show();
                } else {
                    com.tencent.open.log.SLog.w("openSDK_LOG.QzoneShare", "shareToQzone() qqver between 4.2.0 and 4.6.0, will use qqshare");
                    com.tencent.connect.share.QQShare qQShare = new com.tencent.connect.share.QQShare(activity, this.c);
                    if (stringArrayList != null && stringArrayList.size() > 0) {
                        java.lang.String str6 = stringArrayList.get(0);
                        if (i == 5 && !com.tencent.open.utils.l.h(str6)) {
                            iUiListener.onError(new com.tencent.tauth.UiError(-6, com.tencent.connect.common.Constants.MSG_PARAM_IMAGE_URL_MUST_BE_LOCAL, null));
                            com.tencent.open.log.SLog.e("openSDK_LOG.QzoneShare", "shareToQzone()手Q版本过低，纯图分享不支持网路图片");
                            com.tencent.open.a.d.a().a(1, "SHARE_CHECK_SDK", com.tencent.connect.common.Constants.DEFAULT_UIN, this.c.getAppId(), java.lang.String.valueOf(4), java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime()), 0, 1, "shareToQzone()手Q版本过低，纯图分享不支持网路图片");
                            return;
                        }
                        bundle2.putString("imageLocalUrl", str6);
                    }
                    if (!com.tencent.open.utils.l.g(activity, "4.5.0")) {
                        bundle2.putInt("cflag", 1);
                    }
                    qQShare.shareToQQ(activity, bundle2, iUiListener);
                }
                com.tencent.open.log.SLog.i("openSDK_LOG.QzoneShare", "shareToQzone() --end");
            }
        }
        str2 = "summary";
        i = bundle.getInt("req_type");
        com.tencent.open.log.SLog.e("openSDK_LOG.QzoneShare", "shareToQzone() get SHARE_TO_QZONE_KEY_TYPE: " + i);
        if (i != 1) {
        }
        if (i != 1) {
        }
        if (com.tencent.open.utils.l.a()) {
        }
        if (this.a) {
        }
        if (this.d) {
        }
        if (!android.text.TextUtils.isEmpty(a)) {
        }
        if (stringArrayList == null) {
        }
        if (this.f) {
        }
        if (com.tencent.open.utils.l.g(activity, "4.6.0")) {
        }
        com.tencent.open.log.SLog.i("openSDK_LOG.QzoneShare", "shareToQzone() --end");
    }
}
