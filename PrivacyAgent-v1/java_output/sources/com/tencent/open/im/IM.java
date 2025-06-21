package com.tencent.open.im;

/* loaded from: classes19.dex */
public class IM extends com.tencent.connect.common.BaseApi {
    public static final java.lang.String CHAT_TYPE_AIO = "thirdparty2c";
    public static final java.lang.String CHAT_TYPE_AUDIO_CHAT = "audio_chat";
    public static final java.lang.String CHAT_TYPE_VIDEO_CHAT = "video_chat";
    public static final int IM_LENGTH_SHORT = -3;
    public static final int IM_SHOULD_DOWNLOAD = -2;
    public static final int IM_SUCCESS = 0;
    public static final int IM_UIN_EMPTY = -1;
    public static final int IM_UIN_NOT_DIGIT = -4;
    public static final int IM_UNKNOWN_TYPE = -5;

    public IM(android.content.Context context, com.tencent.connect.auth.QQToken qQToken) {
        super(qQToken);
    }

    public IM(android.content.Context context, com.tencent.connect.auth.c cVar, com.tencent.connect.auth.QQToken qQToken) {
        super(cVar, qQToken);
    }

    public IM(com.tencent.connect.auth.QQToken qQToken) {
        super(qQToken);
    }

    public int startIMConversation(android.app.Activity activity, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (str == null) {
            return -5;
        }
        if (!str.equals(CHAT_TYPE_AIO) && !str.equals(CHAT_TYPE_AUDIO_CHAT) && !str.equals(CHAT_TYPE_VIDEO_CHAT)) {
            return -5;
        }
        if (!str.equals(CHAT_TYPE_AUDIO_CHAT)) {
            str.equals(CHAT_TYPE_VIDEO_CHAT);
        }
        if (android.text.TextUtils.isEmpty(str2)) {
            return -1;
        }
        if (str2.length() < 5) {
            return -3;
        }
        for (int i = 0; i < str2.length(); i++) {
            if (!java.lang.Character.isDigit(str2.charAt(i))) {
                return -4;
            }
        }
        if (com.tencent.open.utils.l.d(activity)) {
            android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW");
            intent.setData(android.net.Uri.parse(java.lang.String.format("mqqapi://im/chat?chat_type=%1$s&uin=%2$s&version=1&src_type=app&open_id=%3$s&app_id=%4$s&app_pkg_name=%5$s", str, str2, com.tencent.open.utils.l.l(this.c.getOpenId()), com.tencent.open.utils.l.l(this.c.getAppId()), com.tencent.open.utils.l.l(str3))));
            intent.putExtra("pkg_name", str3);
            activity.startActivity(intent);
            return 0;
        }
        try {
            new com.tencent.open.TDialog(activity, "", a(""), null, this.c).show();
            return -2;
        } catch (java.lang.RuntimeException e) {
            e.printStackTrace();
            return -2;
        }
    }
}
