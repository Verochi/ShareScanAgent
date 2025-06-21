package com.tencent.connect.share;

/* loaded from: classes19.dex */
public class QzonePublish extends com.tencent.connect.common.BaseApi {
    public static final java.lang.String HULIAN_CALL_BACK = "hulian_call_back";
    public static final java.lang.String HULIAN_EXTRA_SCENE = "hulian_extra_scene";
    public static final java.lang.String PUBLISH_TO_QZONE_APP_NAME = "appName";
    public static final java.lang.String PUBLISH_TO_QZONE_EXTMAP = "extMap";
    public static final java.lang.String PUBLISH_TO_QZONE_IMAGE_URL = "imageUrl";
    public static final java.lang.String PUBLISH_TO_QZONE_KEY_TYPE = "req_type";
    public static final java.lang.String PUBLISH_TO_QZONE_SUMMARY = "summary";
    public static final int PUBLISH_TO_QZONE_TYPE_PUBLISHMOOD = 3;
    public static final int PUBLISH_TO_QZONE_TYPE_PUBLISHVIDEO = 4;
    public static final java.lang.String PUBLISH_TO_QZONE_VIDEO_DURATION = "videoDuration";
    public static final java.lang.String PUBLISH_TO_QZONE_VIDEO_PATH = "videoPath";
    public static final java.lang.String PUBLISH_TO_QZONE_VIDEO_SIZE = "videoSize";

    /* renamed from: com.tencent.connect.share.QzonePublish$1, reason: invalid class name */
    public class AnonymousClass1 implements android.media.MediaPlayer.OnPreparedListener {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ android.os.Bundle b;
        final /* synthetic */ android.app.Activity c;
        final /* synthetic */ com.tencent.tauth.IUiListener d;

        public AnonymousClass1(java.lang.String str, android.os.Bundle bundle, android.app.Activity activity, com.tencent.tauth.IUiListener iUiListener) {
            this.a = str;
            this.b = bundle;
            this.c = activity;
            this.d = iUiListener;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(android.media.MediaPlayer mediaPlayer) {
            long length = new java.io.File(this.a).length();
            int duration = mediaPlayer.getDuration();
            this.b.putString(com.tencent.connect.share.QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH, this.a);
            this.b.putInt(com.tencent.connect.share.QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, duration);
            this.b.putLong(com.tencent.connect.share.QzonePublish.PUBLISH_TO_QZONE_VIDEO_SIZE, length);
            com.tencent.connect.share.QzonePublish.this.b(this.c, this.b, this.d);
            com.tencent.open.log.SLog.i("openSDK_LOG.QzonePublish", "publishToQzone() --end");
        }
    }

    /* renamed from: com.tencent.connect.share.QzonePublish$2, reason: invalid class name */
    public class AnonymousClass2 implements android.media.MediaPlayer.OnErrorListener {
        final /* synthetic */ com.tencent.tauth.IUiListener a;

        public AnonymousClass2(com.tencent.tauth.IUiListener iUiListener) {
            this.a = iUiListener;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(android.media.MediaPlayer mediaPlayer, int i, int i2) {
            com.tencent.open.log.SLog.e("openSDK_LOG.QzonePublish", "publishToQzone() mediaplayer onError()");
            this.a.onError(new com.tencent.tauth.UiError(-5, com.tencent.connect.common.Constants.MSG_PUBLISH_VIDEO_ERROR, null));
            return false;
        }
    }

    public QzonePublish(android.content.Context context, com.tencent.connect.auth.QQToken qQToken) {
        super(qQToken);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00cc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x035e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(android.app.Activity activity, android.os.Bundle bundle, com.tencent.tauth.IUiListener iUiListener) {
        java.lang.String str;
        java.lang.String str2;
        java.lang.String str3;
        java.lang.String appId;
        java.lang.String openId;
        java.lang.String str4;
        java.lang.String str5;
        java.lang.String str6;
        java.lang.String str7;
        android.content.Intent intent;
        android.os.Bundle bundle2;
        org.json.JSONObject jSONObject;
        com.tencent.open.log.SLog.i("openSDK_LOG.QzonePublish", "doPublishToQzone() --start");
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer("mqqapi://qzone/publish?src_type=app&version=1&file_type=news");
        java.util.ArrayList<java.lang.String> stringArrayList = bundle.getStringArrayList("imageUrl");
        java.lang.String string = bundle.getString("summary");
        int i = bundle.getInt("req_type", 3);
        java.lang.String string2 = bundle.getString("appName");
        java.lang.String string3 = bundle.getString(PUBLISH_TO_QZONE_VIDEO_PATH);
        int i2 = bundle.getInt(PUBLISH_TO_QZONE_VIDEO_DURATION);
        long j = bundle.getLong(PUBLISH_TO_QZONE_VIDEO_SIZE);
        try {
            bundle2 = bundle.getBundle("extMap");
        } catch (java.lang.Exception e) {
            e = e;
            str = string2;
            str2 = "";
        }
        if (bundle2 != null) {
            java.util.Set<java.lang.String> keySet = bundle2.keySet();
            str2 = "";
            try {
                jSONObject = new org.json.JSONObject();
                java.util.Iterator<java.lang.String> it = keySet.iterator();
                while (it.hasNext()) {
                    java.util.Iterator<java.lang.String> it2 = it;
                    java.lang.String next = it.next();
                    if (android.text.TextUtils.isEmpty(bundle2.getString(next))) {
                        str = string2;
                    } else {
                        str = string2;
                        try {
                            jSONObject.put(next, bundle2.getString(next));
                        } catch (java.lang.Exception e2) {
                            e = e2;
                            com.tencent.open.log.SLog.e("openSDK_LOG.QzonePublish", "publishToQzone()  --error parse extmap", e);
                            str3 = str2;
                            appId = this.c.getAppId();
                            openId = this.c.getOpenId();
                            com.tencent.open.log.SLog.v("openSDK_LOG.QzonePublish", "openId:" + openId);
                            if (3 == i) {
                            }
                            str4 = str3;
                            str5 = "openSDK_LOG.QzonePublish";
                            str6 = openId;
                            str7 = str2;
                            if (4 == i) {
                            }
                            java.lang.String str8 = str7;
                            if (!android.text.TextUtils.isEmpty(string)) {
                            }
                            if (!android.text.TextUtils.isEmpty(appId)) {
                            }
                            if (!android.text.TextUtils.isEmpty(str)) {
                            }
                            if (!com.tencent.open.utils.l.e(str6)) {
                            }
                            if (!android.text.TextUtils.isEmpty(str4)) {
                            }
                            stringBuffer.append("&req_type=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(java.lang.String.valueOf(i)), 2));
                            java.lang.String str9 = str5;
                            com.tencent.open.log.SLog.v(str9, "doPublishToQzone, url: " + stringBuffer.toString());
                            com.tencent.connect.a.a.a(com.tencent.open.utils.f.a(), this.c, "requireApi", "shareToNativeQQ");
                            intent = new android.content.Intent("android.intent.action.VIEW");
                            intent.setData(android.net.Uri.parse(stringBuffer.toString()));
                            intent.putExtra("pkg_name", activity.getPackageName());
                            if (a(intent)) {
                            }
                            com.tencent.open.log.SLog.i(com.tencent.open.log.SLog.TAG, "doPublishToQzone() --end");
                        }
                    }
                    it = it2;
                    string2 = str;
                }
                str = string2;
            } catch (java.lang.Exception e3) {
                e = e3;
                str = string2;
            }
            if (jSONObject.length() > 0) {
                str3 = jSONObject.toString();
                appId = this.c.getAppId();
                openId = this.c.getOpenId();
                com.tencent.open.log.SLog.v("openSDK_LOG.QzonePublish", "openId:" + openId);
                if (3 == i || stringArrayList == null) {
                    str4 = str3;
                    str5 = "openSDK_LOG.QzonePublish";
                    str6 = openId;
                    str7 = str2;
                } else {
                    java.lang.StringBuffer stringBuffer2 = new java.lang.StringBuffer();
                    java.lang.StringBuffer stringBuffer3 = new java.lang.StringBuffer();
                    str5 = "openSDK_LOG.QzonePublish";
                    int size = stringArrayList.size();
                    str4 = str3;
                    int i3 = 0;
                    while (i3 < size) {
                        java.lang.String str10 = openId;
                        stringBuffer2.append(java.net.URLEncoder.encode(stringArrayList.get(i3)));
                        java.lang.String a = com.tencent.open.utils.l.a(appId, activity, stringArrayList.get(i3), iUiListener);
                        if (!android.text.TextUtils.isEmpty(a)) {
                            stringBuffer3.append(java.net.URLEncoder.encode(a));
                        }
                        if (i3 != size - 1) {
                            stringBuffer2.append(com.alipay.sdk.m.u.i.b);
                            stringBuffer3.append(com.alipay.sdk.m.u.i.b);
                        }
                        i3++;
                        openId = str10;
                    }
                    str6 = openId;
                    stringBuffer.append("&image_url=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(stringBuffer2.toString()), 2));
                    if (!android.text.TextUtils.isEmpty(stringBuffer3.toString())) {
                        stringBuffer.append("&image_uri=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(stringBuffer3.toString()), 2));
                    }
                    str7 = "7";
                }
                if (4 == i) {
                    stringBuffer.append("&videoPath=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(string3), 2));
                    java.lang.String a2 = com.tencent.open.utils.l.a(appId, activity, string3, iUiListener);
                    if (!android.text.TextUtils.isEmpty(a2)) {
                        stringBuffer.append("&videoUri=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(a2), 2));
                    }
                    stringBuffer.append("&videoDuration=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(java.lang.String.valueOf(i2)), 2));
                    stringBuffer.append("&videoSize=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(java.lang.String.valueOf(j)), 2));
                    str7 = "8";
                }
                java.lang.String str82 = str7;
                if (!android.text.TextUtils.isEmpty(string)) {
                    stringBuffer.append("&description=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(string), 2));
                }
                if (!android.text.TextUtils.isEmpty(appId)) {
                    stringBuffer.append("&share_id=" + appId);
                }
                if (!android.text.TextUtils.isEmpty(str)) {
                    stringBuffer.append("&app_name=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(str), 2));
                }
                if (!com.tencent.open.utils.l.e(str6)) {
                    stringBuffer.append("&open_id=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(str6), 2));
                }
                if (!android.text.TextUtils.isEmpty(str4)) {
                    stringBuffer.append("&share_qzone_ext_str=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(str4), 2));
                }
                stringBuffer.append("&req_type=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(java.lang.String.valueOf(i)), 2));
                java.lang.String str92 = str5;
                com.tencent.open.log.SLog.v(str92, "doPublishToQzone, url: " + stringBuffer.toString());
                com.tencent.connect.a.a.a(com.tencent.open.utils.f.a(), this.c, "requireApi", "shareToNativeQQ");
                intent = new android.content.Intent("android.intent.action.VIEW");
                intent.setData(android.net.Uri.parse(stringBuffer.toString()));
                intent.putExtra("pkg_name", activity.getPackageName());
                if (a(intent)) {
                    a(activity, com.tencent.connect.common.Constants.REQUEST_QZONE_SHARE, intent, false);
                    com.tencent.open.a.d.a().a(0, "SHARE_CHECK_SDK", com.tencent.connect.common.Constants.DEFAULT_UIN, this.c.getAppId(), java.lang.String.valueOf(4), java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime()), 0, 1, "hasActivityForIntent success");
                    com.tencent.open.a.d.a().a(this.c.getOpenId(), this.c.getAppId(), com.tencent.connect.common.Constants.VIA_SHARE_TO_QZONE, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, "3", "1", str82, "0", "1", "0");
                } else {
                    com.tencent.open.log.SLog.e(str92, "doPublishToQzone() target activity not found");
                    com.tencent.open.a.d.a().a(1, "SHARE_CHECK_SDK", com.tencent.connect.common.Constants.DEFAULT_UIN, this.c.getAppId(), java.lang.String.valueOf(4), java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime()), 0, 1, "hasActivityForIntent fail");
                    com.tencent.open.a.d.a().a(this.c.getOpenId(), this.c.getAppId(), com.tencent.connect.common.Constants.VIA_SHARE_TO_QZONE, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, "3", "1", str82, "0", "1", "0");
                }
                com.tencent.open.log.SLog.i(com.tencent.open.log.SLog.TAG, "doPublishToQzone() --end");
            }
        } else {
            str = string2;
            str2 = "";
        }
        str3 = str2;
        appId = this.c.getAppId();
        openId = this.c.getOpenId();
        com.tencent.open.log.SLog.v("openSDK_LOG.QzonePublish", "openId:" + openId);
        if (3 == i) {
        }
        str4 = str3;
        str5 = "openSDK_LOG.QzonePublish";
        str6 = openId;
        str7 = str2;
        if (4 == i) {
        }
        java.lang.String str822 = str7;
        if (!android.text.TextUtils.isEmpty(string)) {
        }
        if (!android.text.TextUtils.isEmpty(appId)) {
        }
        if (!android.text.TextUtils.isEmpty(str)) {
        }
        if (!com.tencent.open.utils.l.e(str6)) {
        }
        if (!android.text.TextUtils.isEmpty(str4)) {
        }
        stringBuffer.append("&req_type=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(java.lang.String.valueOf(i)), 2));
        java.lang.String str922 = str5;
        com.tencent.open.log.SLog.v(str922, "doPublishToQzone, url: " + stringBuffer.toString());
        com.tencent.connect.a.a.a(com.tencent.open.utils.f.a(), this.c, "requireApi", "shareToNativeQQ");
        intent = new android.content.Intent("android.intent.action.VIEW");
        intent.setData(android.net.Uri.parse(stringBuffer.toString()));
        intent.putExtra("pkg_name", activity.getPackageName());
        if (a(intent)) {
        }
        com.tencent.open.log.SLog.i(com.tencent.open.log.SLog.TAG, "doPublishToQzone() --end");
    }

    public void publishToQzone(android.app.Activity activity, android.os.Bundle bundle, com.tencent.tauth.IUiListener iUiListener) {
        com.tencent.open.log.SLog.i("openSDK_LOG.QzonePublish", "publishToQzone() -- start");
        if (bundle == null) {
            iUiListener.onError(new com.tencent.tauth.UiError(-6, com.tencent.connect.common.Constants.MSG_PARAM_NULL_ERROR, null));
            com.tencent.open.log.SLog.e("openSDK_LOG.QzonePublish", "-->publishToQzone, params is null");
            com.tencent.open.a.d.a().a(1, "SHARE_CHECK_SDK", com.tencent.connect.common.Constants.DEFAULT_UIN, this.c.getAppId(), java.lang.String.valueOf(4), java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime()), 0, 1, com.tencent.connect.common.Constants.MSG_PARAM_NULL_ERROR);
            return;
        }
        if (!com.tencent.open.utils.l.f(activity)) {
            iUiListener.onError(new com.tencent.tauth.UiError(-15, com.tencent.connect.common.Constants.MSG_PARAM_VERSION_TOO_LOW, null));
            com.tencent.open.log.SLog.e("openSDK_LOG.QzonePublish", "-->publishToQzone, this is not support below qq 5.9.5");
            com.tencent.open.a.d.a().a(1, "SHARE_CHECK_SDK", com.tencent.connect.common.Constants.DEFAULT_UIN, this.c.getAppId(), java.lang.String.valueOf(4), java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime()), 0, 1, "publicToQzone, this is not support below qq 5.9.5");
            new com.tencent.open.TDialog(activity, "", a(""), null, this.c).show();
            return;
        }
        java.lang.String a = com.tencent.open.utils.l.a(activity);
        int i = 0;
        if (a == null) {
            a = bundle.getString("appName");
        } else if (a.length() > 20) {
            a = a.substring(0, 20) + "...";
        }
        if (!android.text.TextUtils.isEmpty(a)) {
            bundle.putString("appName", a);
        }
        int i2 = bundle.getInt("req_type");
        if (i2 == 3) {
            java.util.ArrayList<java.lang.String> stringArrayList = bundle.getStringArrayList("imageUrl");
            if (stringArrayList != null && stringArrayList.size() > 0) {
                while (i < stringArrayList.size()) {
                    if (!com.tencent.open.utils.l.h(stringArrayList.get(i))) {
                        stringArrayList.remove(i);
                        i--;
                    }
                    i++;
                }
                bundle.putStringArrayList("imageUrl", stringArrayList);
            }
            b(activity, bundle, iUiListener);
            com.tencent.open.log.SLog.i("openSDK_LOG.QzonePublish", "publishToQzone() --end");
            return;
        }
        if (i2 != 4) {
            iUiListener.onError(new com.tencent.tauth.UiError(-5, com.tencent.connect.common.Constants.MSG_SHARE_TYPE_ERROR, null));
            com.tencent.open.log.SLog.e("openSDK_LOG.QzonePublish", "publishToQzone() error--end请选择支持的分享类型");
            com.tencent.open.a.d.a().a(1, "SHARE_CHECK_SDK", com.tencent.connect.common.Constants.DEFAULT_UIN, this.c.getAppId(), java.lang.String.valueOf(4), java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime()), 0, 1, "publishToQzone() 请选择支持的分享类型");
            return;
        }
        java.lang.String string = bundle.getString(PUBLISH_TO_QZONE_VIDEO_PATH);
        if (!com.tencent.open.utils.l.h(string)) {
            com.tencent.open.log.SLog.e("openSDK_LOG.QzonePublish", "publishToQzone() video url invalid");
            iUiListener.onError(new com.tencent.tauth.UiError(-5, com.tencent.connect.common.Constants.MSG_PUBLISH_VIDEO_ERROR, null));
            return;
        }
        android.media.MediaPlayer mediaPlayer = new android.media.MediaPlayer();
        mediaPlayer.setOnPreparedListener(new com.tencent.connect.share.QzonePublish.AnonymousClass1(string, bundle, activity, iUiListener));
        mediaPlayer.setOnErrorListener(new com.tencent.connect.share.QzonePublish.AnonymousClass2(iUiListener));
        try {
            mediaPlayer.setDataSource(string);
            mediaPlayer.prepareAsync();
        } catch (java.lang.Exception unused) {
            com.tencent.open.log.SLog.e("openSDK_LOG.QzonePublish", "publishToQzone() exception(s) occurred when preparing mediaplayer");
            iUiListener.onError(new com.tencent.tauth.UiError(-5, com.tencent.connect.common.Constants.MSG_PUBLISH_VIDEO_ERROR, null));
        }
    }
}
