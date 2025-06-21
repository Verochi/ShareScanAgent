package com.meizu.cloud.pushsdk.handler;

/* loaded from: classes23.dex */
public class MzPushMessage implements java.io.Serializable {
    private static final java.lang.String TAG = "MzPushMessage";
    private java.lang.String content;
    private int notifyId;
    private int pushType;
    private java.lang.String selfDefineContentString;
    private java.lang.String taskId;
    private java.lang.String title;

    public static com.meizu.cloud.pushsdk.handler.MzPushMessage fromMessageV3(com.meizu.cloud.pushsdk.handler.MessageV3 messageV3) {
        com.meizu.cloud.pushsdk.handler.MzPushMessage mzPushMessage = new com.meizu.cloud.pushsdk.handler.MzPushMessage();
        mzPushMessage.setTitle(messageV3.getTitle());
        mzPushMessage.setContent(messageV3.getContent());
        mzPushMessage.setTaskId(messageV3.getTaskId());
        mzPushMessage.setPushType(0);
        mzPushMessage.setNotifyId(com.meizu.cloud.pushsdk.notification.model.a.b(messageV3));
        mzPushMessage.setSelfDefineContentString(selfDefineContentString(messageV3.getWebUrl(), messageV3.getParamsMap()));
        return mzPushMessage;
    }

    private static java.lang.String selfDefineContentString(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map) {
        if (android.text.TextUtils.isEmpty(str)) {
            if (map != null) {
                str = map.get("sk");
                if (android.text.TextUtils.isEmpty(str)) {
                    str = com.meizu.cloud.pushsdk.d.f.e.a((java.util.Map) map).toString();
                }
            } else {
                str = null;
            }
        }
        com.meizu.cloud.pushinternal.DebugLogger.e(TAG, "self json " + str);
        return str;
    }

    public java.lang.String getContent() {
        return this.content;
    }

    public int getNotifyId() {
        return this.notifyId;
    }

    public int getPushType() {
        return this.pushType;
    }

    public java.lang.String getSelfDefineContentString() {
        return this.selfDefineContentString;
    }

    public java.lang.String getTaskId() {
        return this.taskId;
    }

    public java.lang.String getTitle() {
        return this.title;
    }

    public void setContent(java.lang.String str) {
        this.content = str;
    }

    public void setNotifyId(int i) {
        this.notifyId = i;
    }

    public void setPushType(int i) {
        this.pushType = i;
    }

    public void setSelfDefineContentString(java.lang.String str) {
        this.selfDefineContentString = str;
    }

    public void setTaskId(java.lang.String str) {
        this.taskId = str;
    }

    public void setTitle(java.lang.String str) {
        this.title = str;
    }

    public java.lang.String toString() {
        return "MzPushMessage{title='" + this.title + "', content='" + this.content + "', pushType=" + this.pushType + ", taskId='" + this.taskId + "', selfDefineContentString='" + this.selfDefineContentString + "', notifyId=" + this.notifyId + '}';
    }
}
