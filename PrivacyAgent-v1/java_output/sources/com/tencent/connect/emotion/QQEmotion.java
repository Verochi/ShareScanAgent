package com.tencent.connect.emotion;

/* loaded from: classes19.dex */
public class QQEmotion extends com.tencent.connect.common.BaseApi {
    private com.tencent.tauth.IUiListener a;

    public QQEmotion(com.tencent.connect.auth.QQToken qQToken) {
        super(qQToken);
    }

    private java.lang.String a(java.util.ArrayList<android.net.Uri> arrayList) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i = 0; i < arrayList.size(); i++) {
            sb.append(arrayList.get(i));
            sb.append(com.alipay.sdk.m.u.i.b);
        }
        java.lang.String sb2 = sb.toString();
        com.tencent.open.log.SLog.i("QQEMOTION", "-->getFilePathListJson listStr : " + sb2);
        return android.util.Base64.encodeToString(com.tencent.open.utils.l.i(sb2), 2);
    }

    private boolean a(android.content.Context context, java.util.ArrayList<android.net.Uri> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return false;
        }
        if (arrayList.size() > 9) {
            com.tencent.open.log.SLog.i("QQEMOTION", "isLegality -->illegal, file count > 9, count = " + arrayList.size());
            return false;
        }
        long j = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            java.lang.String a = com.tencent.open.utils.l.a(context, arrayList.get(i));
            long j2 = com.tencent.open.utils.l.j(a);
            if (j2 > 1048576) {
                com.tencent.open.log.SLog.i("QQEMOTION", "isLegality -->illegal, fileSize: " + j2 + "， path =" + a);
                return false;
            }
            j += j2;
        }
        if (j > 3145728) {
            com.tencent.open.log.SLog.i("QQEMOTION", "isLegality -->illegal, totalSize: " + j);
            return false;
        }
        com.tencent.open.log.SLog.i("QQEMOTION", "isLegality -->legal, totalSize: " + j);
        return true;
    }

    public void setEmotions(android.app.Activity activity, java.util.ArrayList<android.net.Uri> arrayList, com.tencent.tauth.IUiListener iUiListener) {
        com.tencent.tauth.IUiListener iUiListener2 = this.a;
        if (iUiListener2 != null) {
            iUiListener2.onCancel();
        }
        this.a = iUiListener;
        if (!com.tencent.open.utils.i.b(activity)) {
            android.widget.Toast.makeText(activity.getApplicationContext(), "当前手机未安装QQ，请安装最新版QQ后再试。", 1).show();
            return;
        }
        if (com.tencent.open.utils.i.c(activity, "8.0.0") < 0) {
            android.widget.Toast.makeText(activity.getApplicationContext(), "当前手机QQ版本过低，不支持设置表情功能。", 1).show();
            return;
        }
        if (!a(activity.getApplicationContext(), arrayList)) {
            android.widget.Toast.makeText(activity.getApplicationContext(), "图片不符合要求，不支持设置表情功能。", 1).show();
            return;
        }
        java.lang.String a = com.tencent.open.utils.l.a(activity);
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer("mqqapi://profile/sdk_face_collection?");
        if (!android.text.TextUtils.isEmpty(a)) {
            if (a.length() > 20) {
                a = a.substring(0, 20) + "...";
            }
            stringBuffer.append("&app_name=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(a), 2));
        }
        java.lang.String appId = this.c.getAppId();
        java.lang.String openId = this.c.getOpenId();
        if (!android.text.TextUtils.isEmpty(appId)) {
            stringBuffer.append("&share_id=" + appId);
        }
        if (!android.text.TextUtils.isEmpty(openId)) {
            stringBuffer.append("&open_id=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(openId), 2));
        }
        stringBuffer.append("&sdk_version=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(com.tencent.connect.common.Constants.SDK_VERSION), 2));
        java.lang.String a2 = a(arrayList);
        if (!android.text.TextUtils.isEmpty(a2)) {
            stringBuffer.append("&set_uri_list=" + a2);
        }
        com.tencent.open.log.SLog.v("QQEMOTION", "-->set avatar, url: " + stringBuffer.toString());
        android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW");
        intent.setData(android.net.Uri.parse(stringBuffer.toString()));
        intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
        if (a(intent)) {
            com.tencent.connect.common.UIListenerManager.getInstance().setListenerWithRequestcode(com.tencent.connect.common.Constants.REQUEST_EDIT_EMOTION, iUiListener);
            a(activity, com.tencent.connect.common.Constants.REQUEST_EDIT_EMOTION, intent, false);
        }
    }
}
