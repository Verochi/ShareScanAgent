package com.meizu.cloud.pushsdk.handler;

/* loaded from: classes23.dex */
public class d {
    public static com.meizu.cloud.pushsdk.handler.MessageV3 a(java.lang.String str) {
        java.lang.String str2;
        com.meizu.cloud.pushinternal.DebugLogger.i("MessageSerialize", "message serialize stringToMessageV3 start, msgText=" + str);
        try {
            com.meizu.cloud.pushsdk.handler.MessageV3 messageV3 = new com.meizu.cloud.pushsdk.handler.MessageV3();
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                if (!jSONObject.isNull("task_id")) {
                    messageV3.setTaskId(jSONObject.getString("task_id"));
                }
                if (!jSONObject.isNull(com.meizu.cloud.pushsdk.constants.PushConstants.SEQ_ID)) {
                    messageV3.setSeqId(jSONObject.getString(com.meizu.cloud.pushsdk.constants.PushConstants.SEQ_ID));
                }
                if (!jSONObject.isNull("device_id")) {
                    messageV3.setDeviceId(jSONObject.getString("device_id"));
                }
                if (!jSONObject.isNull("title")) {
                    messageV3.setTitle(jSONObject.getString("title"));
                }
                if (!jSONObject.isNull("content")) {
                    messageV3.setContent(jSONObject.getString("content"));
                }
                if (!jSONObject.isNull("package_name")) {
                    messageV3.setPackageName(jSONObject.getString("package_name"));
                }
                if (!jSONObject.isNull(com.meizu.cloud.pushsdk.constants.PushConstants.CLICK_TYPE)) {
                    messageV3.setClickType(jSONObject.getInt(com.meizu.cloud.pushsdk.constants.PushConstants.CLICK_TYPE));
                }
                if (!jSONObject.isNull(com.meizu.cloud.pushsdk.constants.PushConstants.IS_DISCARD)) {
                    messageV3.setIsDiscard(jSONObject.getBoolean(com.meizu.cloud.pushsdk.constants.PushConstants.IS_DISCARD));
                }
                if (!jSONObject.isNull("activity")) {
                    messageV3.setActivity(jSONObject.getString("activity"));
                }
                if (!jSONObject.isNull("url")) {
                    messageV3.setWebUrl(jSONObject.getString("url"));
                }
                if (!jSONObject.isNull("pk")) {
                    messageV3.setUriPackageName(jSONObject.getString("pk"));
                }
                if (!jSONObject.isNull(com.meizu.cloud.pushsdk.constants.PushConstants.PUSH_TIMESTAMP)) {
                    messageV3.setPushTimestamp(jSONObject.getString(com.meizu.cloud.pushsdk.constants.PushConstants.PUSH_TIMESTAMP));
                }
                if (!jSONObject.isNull(com.meizu.cloud.pushsdk.constants.PushConstants.UPLOAD_DATA_PACKAGE_NAME)) {
                    messageV3.setUploadDataPackageName(jSONObject.getString(com.meizu.cloud.pushsdk.constants.PushConstants.UPLOAD_DATA_PACKAGE_NAME));
                }
                if (!jSONObject.isNull(com.meizu.cloud.pushsdk.constants.PushConstants.PARAMS)) {
                    org.json.JSONObject jSONObject2 = jSONObject.getJSONObject(com.meizu.cloud.pushsdk.constants.PushConstants.PARAMS);
                    java.util.HashMap hashMap = new java.util.HashMap(jSONObject2.length());
                    java.util.Iterator<java.lang.String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        java.lang.String next = keys.next();
                        hashMap.put(next, jSONObject2.getString(next));
                    }
                    messageV3.setParamsMap(hashMap);
                }
                if (!jSONObject.isNull(com.meizu.cloud.pushsdk.constants.PushConstants.THROUGH_MESSAGE)) {
                    messageV3.setThroughMessage(jSONObject.getString(com.meizu.cloud.pushsdk.constants.PushConstants.THROUGH_MESSAGE));
                }
                if (!jSONObject.isNull(com.meizu.cloud.pushsdk.constants.PushConstants.NOTIFICATION_MESSAGE)) {
                    messageV3.setNotificationMessage(jSONObject.getString(com.meizu.cloud.pushsdk.constants.PushConstants.NOTIFICATION_MESSAGE));
                }
                str2 = "MessageSerialize";
                try {
                    com.meizu.cloud.pushinternal.DebugLogger.i(str2, "message serialize stringToMessageV3 success, messageV3=" + messageV3);
                    return messageV3;
                } catch (org.json.JSONException e) {
                    e = e;
                    com.meizu.cloud.pushinternal.DebugLogger.e(str2, "message serialize stringToMessageV3 error， " + e.getMessage());
                    e.printStackTrace();
                    return null;
                }
            } catch (org.json.JSONException e2) {
                e = e2;
                str2 = "MessageSerialize";
            }
        } catch (org.json.JSONException e3) {
            e = e3;
            str2 = "MessageSerialize";
        }
    }

    public static java.lang.String a(com.meizu.cloud.pushsdk.handler.MessageV3 messageV3) {
        com.meizu.cloud.pushinternal.DebugLogger.i("MessageSerialize", "message serialize messageV3ToString start, messageV3=" + messageV3);
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            if (!android.text.TextUtils.isEmpty(messageV3.getTaskId())) {
                jSONObject.put("task_id", messageV3.getTaskId());
            }
            if (!android.text.TextUtils.isEmpty(messageV3.getSeqId())) {
                jSONObject.put(com.meizu.cloud.pushsdk.constants.PushConstants.SEQ_ID, messageV3.getSeqId());
            }
            if (!android.text.TextUtils.isEmpty(messageV3.getDeviceId())) {
                jSONObject.put("device_id", messageV3.getDeviceId());
            }
            if (!android.text.TextUtils.isEmpty(messageV3.getTitle())) {
                jSONObject.put("title", messageV3.getTitle());
            }
            if (!android.text.TextUtils.isEmpty(messageV3.getContent())) {
                jSONObject.put("content", messageV3.getContent());
            }
            if (!android.text.TextUtils.isEmpty(messageV3.getPackageName())) {
                jSONObject.put("package_name", messageV3.getPackageName());
            }
            jSONObject.put(com.meizu.cloud.pushsdk.constants.PushConstants.CLICK_TYPE, messageV3.getClickType());
            jSONObject.put(com.meizu.cloud.pushsdk.constants.PushConstants.IS_DISCARD, messageV3.isDiscard());
            if (!android.text.TextUtils.isEmpty(messageV3.getActivity())) {
                jSONObject.put("activity", messageV3.getActivity());
            }
            if (!android.text.TextUtils.isEmpty(messageV3.getWebUrl())) {
                jSONObject.put("url", messageV3.getWebUrl());
            }
            if (!android.text.TextUtils.isEmpty(messageV3.getUriPackageName())) {
                jSONObject.put("pk", messageV3.getUriPackageName());
            }
            if (!android.text.TextUtils.isEmpty(messageV3.getPushTimestamp())) {
                jSONObject.put(com.meizu.cloud.pushsdk.constants.PushConstants.PUSH_TIMESTAMP, messageV3.getPushTimestamp());
            }
            if (!android.text.TextUtils.isEmpty(messageV3.getUploadDataPackageName())) {
                jSONObject.put(com.meizu.cloud.pushsdk.constants.PushConstants.UPLOAD_DATA_PACKAGE_NAME, messageV3.getUploadDataPackageName());
            }
            if (messageV3.getParamsMap() != null && messageV3.getParamsMap().size() > 0) {
                jSONObject.put(com.meizu.cloud.pushsdk.constants.PushConstants.PARAMS, new org.json.JSONObject(messageV3.getParamsMap()));
            }
            if (!android.text.TextUtils.isEmpty(messageV3.getThroughMessage())) {
                jSONObject.put(com.meizu.cloud.pushsdk.constants.PushConstants.THROUGH_MESSAGE, messageV3.getThroughMessage());
            }
            if (!android.text.TextUtils.isEmpty(messageV3.getNotificationMessage())) {
                jSONObject.put(com.meizu.cloud.pushsdk.constants.PushConstants.NOTIFICATION_MESSAGE, messageV3.getNotificationMessage());
            }
            java.lang.String jSONObject2 = jSONObject.toString();
            com.meizu.cloud.pushinternal.DebugLogger.i("MessageSerialize", "message serialize messageV3ToString success, msgText=" + jSONObject2);
            return jSONObject2;
        } catch (org.json.JSONException e) {
            com.meizu.cloud.pushinternal.DebugLogger.e("MessageSerialize", "message serialize messageV3ToString error, " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
