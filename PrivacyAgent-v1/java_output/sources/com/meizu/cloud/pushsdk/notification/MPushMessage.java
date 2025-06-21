package com.meizu.cloud.pushsdk.notification;

/* loaded from: classes23.dex */
public class MPushMessage implements java.io.Serializable {
    private static final java.lang.String TAG = "MPushMessage";
    private java.lang.String clickType;
    private java.lang.String content;
    private java.lang.String isDiscard;
    private java.lang.String notifyType;
    private java.lang.String packageName;
    private java.lang.String pushType;
    private java.lang.String taskId;
    private java.lang.String title;
    private java.util.Map<java.lang.String, java.lang.String> extra = new java.util.HashMap();
    private java.util.Map<java.lang.String, java.lang.String> params = new java.util.HashMap();

    private static java.util.Map<java.lang.String, java.lang.String> getParamsMap(org.json.JSONObject jSONObject) {
        try {
            java.util.HashMap hashMap = new java.util.HashMap(jSONObject.length());
            java.util.Iterator<java.lang.String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                java.lang.String next = keys.next();
                hashMap.put(next, jSONObject.getString(next));
            }
            return hashMap;
        } catch (org.json.JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static com.meizu.cloud.pushsdk.notification.MPushMessage parsePushMessage(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        org.json.JSONObject jSONObject;
        com.meizu.cloud.pushsdk.notification.MPushMessage mPushMessage = new com.meizu.cloud.pushsdk.notification.MPushMessage();
        try {
            mPushMessage.setTaskId(str4);
            mPushMessage.setPushType(str);
            mPushMessage.setPackageName(str3);
            org.json.JSONObject jSONObject2 = new org.json.JSONObject(str2).getJSONObject("data");
            if (!jSONObject2.isNull("content")) {
                mPushMessage.setContent(jSONObject2.getString("content"));
            }
            if (!jSONObject2.isNull(com.meizu.cloud.pushsdk.constants.PushConstants.IS_DISCARD)) {
                mPushMessage.setIsDiscard(jSONObject2.getString(com.meizu.cloud.pushsdk.constants.PushConstants.IS_DISCARD));
            }
            if (!jSONObject2.isNull("title")) {
                mPushMessage.setTitle(jSONObject2.getString("title"));
            }
            if (!jSONObject2.isNull(com.meizu.cloud.pushsdk.constants.PushConstants.CLICK_TYPE)) {
                mPushMessage.setClickType(jSONObject2.getString(com.meizu.cloud.pushsdk.constants.PushConstants.CLICK_TYPE));
            }
            if (!jSONObject2.isNull("extra") && (jSONObject = jSONObject2.getJSONObject("extra")) != null) {
                try {
                    if (!jSONObject.isNull(com.meizu.cloud.pushsdk.constants.PushConstants.PARAMS)) {
                        try {
                            org.json.JSONObject jSONObject3 = jSONObject.getJSONObject(com.meizu.cloud.pushsdk.constants.PushConstants.PARAMS);
                            if (jSONObject3 != null) {
                                mPushMessage.setParams(getParamsMap(jSONObject3));
                            }
                        } catch (org.json.JSONException e) {
                            com.meizu.cloud.pushinternal.DebugLogger.i(TAG, "parameter parse error message " + e.getMessage());
                        }
                    }
                    mPushMessage.setExtra(getParamsMap(jSONObject));
                } finally {
                    jSONObject.remove(com.meizu.cloud.pushsdk.constants.PushConstants.PARAMS);
                }
            }
        } catch (org.json.JSONException e2) {
            com.meizu.cloud.pushinternal.DebugLogger.i(TAG, "parse push message error " + e2.getMessage());
        }
        com.meizu.cloud.pushinternal.DebugLogger.i(TAG, " parsePushMessage " + mPushMessage);
        return mPushMessage;
    }

    public java.lang.String getClickType() {
        return this.clickType;
    }

    public java.lang.String getContent() {
        return this.content;
    }

    public java.util.Map<java.lang.String, java.lang.String> getExtra() {
        return this.extra;
    }

    public java.lang.String getIsDiscard() {
        return this.isDiscard;
    }

    public java.lang.String getNotifyType() {
        return this.notifyType;
    }

    public java.lang.String getPackageName() {
        return this.packageName;
    }

    public java.util.Map<java.lang.String, java.lang.String> getParams() {
        return this.params;
    }

    public java.lang.String getPushType() {
        return this.pushType;
    }

    public java.lang.String getTaskId() {
        return this.taskId;
    }

    public java.lang.String getTitle() {
        return this.title;
    }

    public void setClickType(java.lang.String str) {
        this.clickType = str;
    }

    public void setContent(java.lang.String str) {
        this.content = str;
    }

    public void setExtra(java.util.Map<java.lang.String, java.lang.String> map) {
        this.extra = map;
    }

    public void setIsDiscard(java.lang.String str) {
        this.isDiscard = str;
    }

    public void setNotifyType(java.lang.String str) {
        this.notifyType = str;
    }

    public void setPackageName(java.lang.String str) {
        this.packageName = str;
    }

    public void setParams(java.util.Map<java.lang.String, java.lang.String> map) {
        this.params = map;
    }

    public void setPushType(java.lang.String str) {
        this.pushType = str;
    }

    public void setTaskId(java.lang.String str) {
        this.taskId = str;
    }

    public void setTitle(java.lang.String str) {
        this.title = str;
    }

    public java.lang.String toString() {
        return "MPushMessage{taskId='" + this.taskId + "', pushType='" + this.pushType + "', packageName='" + this.packageName + "', title='" + this.title + "', content='" + this.content + "', notifyType='" + this.notifyType + "', clickType='" + this.clickType + "', isDiscard='" + this.isDiscard + "', extra=" + this.extra + ", params=" + this.params + '}';
    }
}
