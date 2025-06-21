package com.meizu.cloud.pushsdk.handler;

/* loaded from: classes23.dex */
public class MessageV3 implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.meizu.cloud.pushsdk.handler.MessageV3> CREATOR = new com.meizu.cloud.pushsdk.handler.MessageV3.AnonymousClass1();
    private static final java.lang.String TAG = "Message_V3";
    private java.lang.String activity;
    private int clickType;
    private java.lang.String content;
    private java.lang.String deviceId;
    private boolean isDiscard;
    private com.meizu.cloud.pushsdk.notification.model.AdvanceSetting mAdvanceSetting;
    private com.meizu.cloud.pushsdk.notification.model.AppIconSetting mAppIconSetting;
    private com.meizu.cloud.pushsdk.notification.model.NotificationStyle mNotificationStyle;
    private com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting mTimeDisplaySetting;
    private java.lang.String notificationMessage;
    private java.lang.String packageName;
    private java.util.Map<java.lang.String, java.lang.String> paramsMap;
    private java.lang.String pushTimestamp;
    private java.lang.String seqId;
    private java.lang.String taskId;
    private java.lang.String throughMessage;
    private java.lang.String title;
    private java.lang.String uploadDataPackageName;
    private java.lang.String uriPackageName;
    private java.lang.String webUrl;

    /* renamed from: com.meizu.cloud.pushsdk.handler.MessageV3$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.meizu.cloud.pushsdk.handler.MessageV3> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.meizu.cloud.pushsdk.handler.MessageV3 createFromParcel(android.os.Parcel parcel) {
            return new com.meizu.cloud.pushsdk.handler.MessageV3(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.meizu.cloud.pushsdk.handler.MessageV3[] newArray(int i) {
            return new com.meizu.cloud.pushsdk.handler.MessageV3[i];
        }
    }

    public MessageV3() {
        this.paramsMap = new java.util.HashMap();
    }

    public MessageV3(android.os.Parcel parcel) {
        this.paramsMap = new java.util.HashMap();
        this.taskId = parcel.readString();
        this.seqId = parcel.readString();
        this.deviceId = parcel.readString();
        this.title = parcel.readString();
        this.content = parcel.readString();
        this.packageName = parcel.readString();
        this.clickType = parcel.readInt();
        this.isDiscard = parcel.readByte() != 0;
        this.activity = parcel.readString();
        this.webUrl = parcel.readString();
        this.uriPackageName = parcel.readString();
        this.uploadDataPackageName = parcel.readString();
        this.pushTimestamp = parcel.readString();
        this.paramsMap = parcel.readHashMap(getClass().getClassLoader());
        this.throughMessage = parcel.readString();
        this.notificationMessage = parcel.readString();
        this.mAdvanceSetting = (com.meizu.cloud.pushsdk.notification.model.AdvanceSetting) parcel.readParcelable(com.meizu.cloud.pushsdk.notification.model.AdvanceSetting.class.getClassLoader());
        this.mAppIconSetting = (com.meizu.cloud.pushsdk.notification.model.AppIconSetting) parcel.readParcelable(com.meizu.cloud.pushsdk.notification.model.AppIconSetting.class.getClassLoader());
        this.mNotificationStyle = (com.meizu.cloud.pushsdk.notification.model.NotificationStyle) parcel.readParcelable(com.meizu.cloud.pushsdk.notification.model.NotificationStyle.class.getClassLoader());
        this.mTimeDisplaySetting = (com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting) parcel.readParcelable(com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting.class.getClassLoader());
    }

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

    public static com.meizu.cloud.pushsdk.handler.MessageV3 parse(java.lang.String str, java.lang.String str2, java.lang.String str3, com.meizu.cloud.pushsdk.notification.MPushMessage mPushMessage) {
        com.meizu.cloud.pushinternal.DebugLogger.e(TAG, "V2 message " + mPushMessage);
        com.meizu.cloud.pushsdk.handler.MessageV3 messageV3 = new com.meizu.cloud.pushsdk.handler.MessageV3();
        messageV3.setPackageName(str);
        messageV3.setUploadDataPackageName(str);
        messageV3.setDeviceId(str2);
        messageV3.setTaskId(str3);
        messageV3.setTitle(mPushMessage.getTitle());
        messageV3.setContent(mPushMessage.getContent());
        messageV3.setIsDiscard(com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE.equals(mPushMessage.getIsDiscard()));
        messageV3.setClickType(java.lang.Integer.valueOf(mPushMessage.getClickType()).intValue());
        messageV3.setWhiteList(false);
        messageV3.setDelayedReportMillis(0L);
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : mPushMessage.getExtra().entrySet()) {
            java.lang.String key = entry.getKey();
            java.lang.String value = entry.getValue();
            if ("activity".equals(key)) {
                messageV3.setActivity(value);
            }
            if ("url".equals(key)) {
                messageV3.setWebUrl(value);
            }
            if ("pk".equals(key)) {
                messageV3.setUriPackageName(value);
            }
            if (com.meizu.cloud.pushsdk.notification.model.NotificationStyle.NOTIFICATION_STYLE.equals(key)) {
                messageV3.setNotificationStyle(com.meizu.cloud.pushsdk.notification.model.NotificationStyle.parse(value));
            }
            if ("as".equals(key)) {
                messageV3.setAdvanceSetting(com.meizu.cloud.pushsdk.notification.model.AdvanceSetting.parse(value));
            }
            if ("is".equals(key)) {
                messageV3.setAppIconSetting(com.meizu.cloud.pushsdk.notification.model.AppIconSetting.parse(value));
            }
            if ("ts".equals(key)) {
                messageV3.setTimeDisplaySetting(com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting.parse(value));
            }
            if ("bs".equals(key)) {
                messageV3.setBrightRemindSetting(com.meizu.cloud.pushsdk.notification.model.BrightRemindSetting.parse(value));
            }
            if ("as".equals(key)) {
                messageV3.setAdvanceSettingEx(com.meizu.cloud.pushsdk.notification.model.AdvanceSettingEx.parse(value));
            }
            if (com.meizu.cloud.pushsdk.notification.model.AdvertisementOption.ADVERTISEMENT_OPTION.equals(key)) {
                messageV3.setAdvertisementOption(com.meizu.cloud.pushsdk.notification.model.AdvertisementOption.parse(value));
            }
        }
        messageV3.setParamsMap(mPushMessage.getParams());
        java.lang.String jSONObject = com.meizu.cloud.pushsdk.d.f.e.a((java.util.Map) mPushMessage.getExtra()).toString();
        com.meizu.cloud.pushinternal.DebugLogger.e(TAG, "MessageV2 extra json is " + jSONObject);
        if (!android.text.TextUtils.isEmpty(jSONObject)) {
            messageV3.setNotificationMessage(jSONObject);
        }
        com.meizu.cloud.pushinternal.DebugLogger.i(TAG, "parse V2 message to V3 message " + messageV3);
        return messageV3;
    }

    public static com.meizu.cloud.pushsdk.handler.MessageV3 parse(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        return parse(str, null, null, str2, str3, null, str4, false, 0L);
    }

    public static com.meizu.cloud.pushsdk.handler.MessageV3 parse(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) {
        return parse(str, null, null, str2, str3, str4, str5, false, 0L);
    }

    public static com.meizu.cloud.pushsdk.handler.MessageV3 parse(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7) {
        return parse(str, str2, str3, str4, str5, str6, str7, false, 0L);
    }

    public static com.meizu.cloud.pushsdk.handler.MessageV3 parse(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7, boolean z, long j) {
        java.lang.String str8;
        com.meizu.cloud.pushsdk.handler.MessageV3 messageV3 = new com.meizu.cloud.pushsdk.handler.MessageV3();
        if (str.isEmpty()) {
            str8 = "pk";
        } else {
            str8 = "pk";
            messageV3.setPackageName(str);
        }
        if (!str2.isEmpty()) {
            messageV3.setUploadDataPackageName(str2);
        }
        if (!str3.isEmpty()) {
            messageV3.setPushTimestamp(str3);
        }
        if (!str4.isEmpty()) {
            messageV3.setDeviceId(str4);
        }
        if (!str5.isEmpty()) {
            messageV3.setTaskId(str5);
        }
        if (!str6.isEmpty()) {
            messageV3.setSeqId(str6);
        }
        if (!str7.isEmpty()) {
            messageV3.setNotificationMessage(str7);
        }
        messageV3.setWhiteList(z);
        messageV3.setDelayedReportMillis(j);
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str7).getJSONObject("data");
            if (!jSONObject.isNull("title")) {
                messageV3.setTitle(jSONObject.getString("title"));
            }
            if (!jSONObject.isNull("content")) {
                messageV3.setContent(jSONObject.getString("content"));
            }
            if (!jSONObject.isNull(com.meizu.cloud.pushsdk.constants.PushConstants.IS_DISCARD)) {
                messageV3.setIsDiscard(jSONObject.getBoolean(com.meizu.cloud.pushsdk.constants.PushConstants.IS_DISCARD));
            }
            if (!jSONObject.isNull(com.meizu.cloud.pushsdk.constants.PushConstants.CLICK_TYPE)) {
                messageV3.setClickType(jSONObject.getInt(com.meizu.cloud.pushsdk.constants.PushConstants.CLICK_TYPE));
            }
            if (!jSONObject.isNull("extra")) {
                org.json.JSONObject jSONObject2 = jSONObject.getJSONObject("extra");
                if (!jSONObject2.isNull(com.meizu.cloud.pushsdk.notification.model.NotificationStyle.NOTIFICATION_STYLE)) {
                    messageV3.setNotificationStyle(com.meizu.cloud.pushsdk.notification.model.NotificationStyle.parse(jSONObject2.getJSONObject(com.meizu.cloud.pushsdk.notification.model.NotificationStyle.NOTIFICATION_STYLE)));
                }
                if (!jSONObject2.isNull("is")) {
                    messageV3.setAppIconSetting(com.meizu.cloud.pushsdk.notification.model.AppIconSetting.parse(jSONObject2.getJSONObject("is")));
                }
                if (!jSONObject2.isNull("as")) {
                    messageV3.setAdvanceSetting(com.meizu.cloud.pushsdk.notification.model.AdvanceSetting.parse(jSONObject2.getJSONObject("as")));
                }
                if (!jSONObject2.isNull("ts")) {
                    messageV3.setTimeDisplaySetting(com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting.parse(jSONObject2.getJSONObject("ts")));
                }
                if (!jSONObject2.isNull("activity")) {
                    messageV3.setActivity(jSONObject2.getString("activity"));
                }
                if (!jSONObject2.isNull("url")) {
                    messageV3.setWebUrl(jSONObject2.getString("url"));
                }
                if (!jSONObject2.isNull("task_id") && android.text.TextUtils.isEmpty(str5)) {
                    com.meizu.cloud.pushinternal.DebugLogger.e(TAG, "Flyme 4 notification message by through message or taskId is null");
                    messageV3.setTaskId(jSONObject2.getString("task_id"));
                }
                java.lang.String str9 = str8;
                if (!jSONObject2.isNull(str9)) {
                    messageV3.setUriPackageName(jSONObject2.getString(str9));
                }
                if (!jSONObject2.isNull(com.meizu.cloud.pushsdk.constants.PushConstants.PARAMS)) {
                    messageV3.setParamsMap(getParamsMap(jSONObject2.getJSONObject(com.meizu.cloud.pushsdk.constants.PushConstants.PARAMS)));
                }
                if (!jSONObject2.isNull("bs")) {
                    messageV3.setBrightRemindSetting(com.meizu.cloud.pushsdk.notification.model.BrightRemindSetting.parse(jSONObject2.getJSONObject("bs")));
                }
                if (!jSONObject2.isNull("as")) {
                    messageV3.setAdvanceSettingEx(com.meizu.cloud.pushsdk.notification.model.AdvanceSettingEx.parse(jSONObject2.getJSONObject("as")));
                }
                if (!jSONObject2.isNull(com.meizu.cloud.pushsdk.notification.model.AdvertisementOption.ADVERTISEMENT_OPTION)) {
                    messageV3.setAdvertisementOption(com.meizu.cloud.pushsdk.notification.model.AdvertisementOption.parse(jSONObject2.getJSONObject(com.meizu.cloud.pushsdk.notification.model.AdvertisementOption.ADVERTISEMENT_OPTION)));
                }
            }
        } catch (org.json.JSONException e) {
            com.meizu.cloud.pushinternal.DebugLogger.e(TAG, "parse message error " + e.getMessage());
        }
        return messageV3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public java.lang.String getActivity() {
        return this.activity;
    }

    public com.meizu.cloud.pushsdk.notification.model.AdvanceSetting getAdvanceSetting() {
        return this.mAdvanceSetting;
    }

    public com.meizu.cloud.pushsdk.notification.model.AdvanceSettingEx getAdvanceSettingEx() {
        return null;
    }

    public com.meizu.cloud.pushsdk.notification.model.AdvertisementOption getAdvertisementOption() {
        return null;
    }

    public com.meizu.cloud.pushsdk.notification.model.AppIconSetting getAppIconSetting() {
        return this.mAppIconSetting;
    }

    public com.meizu.cloud.pushsdk.notification.model.BrightRemindSetting getBrightRemindSetting() {
        return null;
    }

    public int getClickType() {
        return this.clickType;
    }

    public java.lang.String getContent() {
        return this.content;
    }

    public long getDelayedReportMillis() {
        return 0L;
    }

    public java.lang.String getDeviceId() {
        return this.deviceId;
    }

    public java.lang.String getNotificationMessage() {
        return this.notificationMessage;
    }

    public com.meizu.cloud.pushsdk.notification.model.NotificationStyle getNotificationStyle() {
        return this.mNotificationStyle;
    }

    public java.lang.String getPackageName() {
        return this.packageName;
    }

    public java.util.Map<java.lang.String, java.lang.String> getParamsMap() {
        return this.paramsMap;
    }

    public java.lang.String getPushTimestamp() {
        return this.pushTimestamp;
    }

    public java.lang.String getSeqId() {
        return this.seqId;
    }

    public java.lang.String getTaskId() {
        return this.taskId;
    }

    public java.lang.String getThroughMessage() {
        return this.throughMessage;
    }

    public com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting getTimeDisplaySetting() {
        return this.mTimeDisplaySetting;
    }

    public java.lang.String getTitle() {
        return this.title;
    }

    public java.lang.String getUploadDataPackageName() {
        return this.uploadDataPackageName;
    }

    public java.lang.String getUriPackageName() {
        return this.uriPackageName;
    }

    public java.lang.String getWebUrl() {
        return this.webUrl;
    }

    public boolean getWhiteList() {
        return false;
    }

    public boolean isDiscard() {
        return this.isDiscard;
    }

    public void setActivity(java.lang.String str) {
        this.activity = str;
    }

    public void setAdvanceSetting(com.meizu.cloud.pushsdk.notification.model.AdvanceSetting advanceSetting) {
        this.mAdvanceSetting = advanceSetting;
    }

    public void setAdvanceSettingEx(com.meizu.cloud.pushsdk.notification.model.AdvanceSettingEx advanceSettingEx) {
    }

    public void setAdvertisementOption(com.meizu.cloud.pushsdk.notification.model.AdvertisementOption advertisementOption) {
    }

    public void setAppIconSetting(com.meizu.cloud.pushsdk.notification.model.AppIconSetting appIconSetting) {
        this.mAppIconSetting = appIconSetting;
    }

    public void setBrightRemindSetting(com.meizu.cloud.pushsdk.notification.model.BrightRemindSetting brightRemindSetting) {
    }

    public void setClickType(int i) {
        this.clickType = i;
    }

    public void setContent(java.lang.String str) {
        this.content = str;
    }

    public void setDelayedReportMillis(long j) {
    }

    public void setDeviceId(java.lang.String str) {
        this.deviceId = str;
    }

    public void setIsDiscard(boolean z) {
        this.isDiscard = z;
    }

    public void setNotificationMessage(java.lang.String str) {
        this.notificationMessage = str;
    }

    public void setNotificationStyle(com.meizu.cloud.pushsdk.notification.model.NotificationStyle notificationStyle) {
        this.mNotificationStyle = notificationStyle;
    }

    public void setPackageName(java.lang.String str) {
        this.packageName = str;
    }

    public void setParamsMap(java.util.Map<java.lang.String, java.lang.String> map) {
        this.paramsMap = map;
    }

    public void setPushTimestamp(java.lang.String str) {
        this.pushTimestamp = str;
    }

    public void setSeqId(java.lang.String str) {
        this.seqId = str;
    }

    public void setTaskId(java.lang.String str) {
        this.taskId = str;
    }

    public void setThroughMessage(java.lang.String str) {
        this.throughMessage = str;
    }

    public void setTimeDisplaySetting(com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting timeDisplaySetting) {
        this.mTimeDisplaySetting = timeDisplaySetting;
    }

    public void setTitle(java.lang.String str) {
        this.title = str;
    }

    public void setUploadDataPackageName(java.lang.String str) {
        this.uploadDataPackageName = str;
    }

    public void setUriPackageName(java.lang.String str) {
        this.uriPackageName = str;
    }

    public void setWebUrl(java.lang.String str) {
        this.webUrl = str;
    }

    public void setWhiteList(boolean z) {
    }

    public java.lang.String toString() {
        return "MessageV3{taskId='" + this.taskId + "', seqId='" + this.seqId + "', deviceId='" + this.deviceId + "', title='" + this.title + "', content='" + this.content + "', packageName='" + this.packageName + "', clickType=" + this.clickType + "', isDiscard=" + this.isDiscard + "', activity='" + this.activity + "', webUrl='" + this.webUrl + "', uriPackageName='" + this.uriPackageName + "', pushTimestamp='" + this.pushTimestamp + "', uploadDataPackageName='" + this.uploadDataPackageName + "', paramsMap=" + this.paramsMap + "', throughMessage='" + this.throughMessage + "', notificationMessage='" + this.notificationMessage + "', mAdvanceSetting=" + this.mAdvanceSetting + "', mAppIconSetting=" + this.mAppIconSetting + "', mNotificationStyle=" + this.mNotificationStyle + "', mTimeDisplaySetting=" + this.mTimeDisplaySetting + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.taskId);
        parcel.writeString(this.seqId);
        parcel.writeString(this.deviceId);
        parcel.writeString(this.title);
        parcel.writeString(this.content);
        parcel.writeString(this.packageName);
        parcel.writeInt(this.clickType);
        parcel.writeByte(this.isDiscard ? (byte) 1 : (byte) 0);
        parcel.writeString(this.activity);
        parcel.writeString(this.webUrl);
        parcel.writeString(this.uriPackageName);
        parcel.writeString(this.uploadDataPackageName);
        parcel.writeString(this.pushTimestamp);
        parcel.writeMap(this.paramsMap);
        parcel.writeString(this.throughMessage);
        parcel.writeString(this.notificationMessage);
        parcel.writeParcelable(this.mAdvanceSetting, i);
        parcel.writeParcelable(this.mAppIconSetting, i);
        parcel.writeParcelable(this.mNotificationStyle, i);
        parcel.writeParcelable(this.mTimeDisplaySetting, i);
    }
}
