package com.meizu.cloud.pushsdk.platform.message;

import com.meizu.cloud.pushsdk.platform.message.SubTagsStatus.Tag;

/* loaded from: classes23.dex */
public class a {
    public static com.meizu.cloud.pushsdk.platform.message.RegisterStatus a(java.lang.String str) {
        com.meizu.cloud.pushinternal.DebugLogger.i("StatusSerialize", "register status serialize stringToRegisterStatus start, statusText=" + str);
        try {
            com.meizu.cloud.pushsdk.platform.message.RegisterStatus registerStatus = new com.meizu.cloud.pushsdk.platform.message.RegisterStatus();
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            com.meizu.cloud.pushsdk.platform.message.RegisterStatus registerStatus2 = (com.meizu.cloud.pushsdk.platform.message.RegisterStatus) b(jSONObject, registerStatus);
            if (!jSONObject.isNull(com.meizu.cloud.pushsdk.constants.PushConstants.REGISTER_STATUS_PUSH_ID)) {
                registerStatus2.setPushId(jSONObject.getString(com.meizu.cloud.pushsdk.constants.PushConstants.REGISTER_STATUS_PUSH_ID));
            }
            if (!jSONObject.isNull("expire_time")) {
                registerStatus2.setExpireTime(jSONObject.getInt("expire_time"));
            }
            com.meizu.cloud.pushinternal.DebugLogger.i("StatusSerialize", "register status serialize stringToRegisterStatus success, RegisterStatus=" + registerStatus2);
            return registerStatus2;
        } catch (org.json.JSONException e) {
            com.meizu.cloud.pushinternal.DebugLogger.e("StatusSerialize", "register status serialize stringToRegisterStatus error, " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public static java.lang.String a(com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus pushSwitchStatus) {
        com.meizu.cloud.pushinternal.DebugLogger.i("StatusSerialize", "register status serialize pushSwitchStatusToString start, PushSwitchStatus=" + pushSwitchStatus);
        try {
            org.json.JSONObject a = a(new org.json.JSONObject(), pushSwitchStatus);
            if (!android.text.TextUtils.isEmpty(pushSwitchStatus.getPushId())) {
                a.put(com.meizu.cloud.pushsdk.constants.PushConstants.REGISTER_STATUS_PUSH_ID, pushSwitchStatus.getPushId());
            }
            a.put(com.meizu.cloud.pushsdk.constants.PushConstants.PUSH_SWITCH_STATUS_IS_NOTIFICATION_SWITCH, pushSwitchStatus.isSwitchNotificationMessage());
            a.put(com.meizu.cloud.pushsdk.constants.PushConstants.PUSH_SWITCH_STATUS_IS_THROUGH_SWITCH, pushSwitchStatus.isSwitchThroughMessage());
            java.lang.String jSONObject = a.toString();
            com.meizu.cloud.pushinternal.DebugLogger.i("StatusSerialize", "register status serialize pushSwitchStatusToString success, statusText=" + jSONObject);
            return jSONObject;
        } catch (org.json.JSONException e) {
            com.meizu.cloud.pushinternal.DebugLogger.e("StatusSerialize", "register status serialize pushSwitchStatusToString error, " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public static java.lang.String a(com.meizu.cloud.pushsdk.platform.message.RegisterStatus registerStatus) {
        com.meizu.cloud.pushinternal.DebugLogger.i("StatusSerialize", "register status serialize registerStatusToString start, RegisterStatus=" + registerStatus);
        try {
            org.json.JSONObject a = a(new org.json.JSONObject(), registerStatus);
            if (!android.text.TextUtils.isEmpty(registerStatus.getPushId())) {
                a.put(com.meizu.cloud.pushsdk.constants.PushConstants.REGISTER_STATUS_PUSH_ID, registerStatus.getPushId());
            }
            if (registerStatus.getExpireTime() > 0) {
                a.put("expire_time", registerStatus.getExpireTime());
            }
            java.lang.String jSONObject = a.toString();
            com.meizu.cloud.pushinternal.DebugLogger.i("StatusSerialize", "register status serialize registerStatusToString success, statusText=" + jSONObject);
            return jSONObject;
        } catch (org.json.JSONException e) {
            com.meizu.cloud.pushinternal.DebugLogger.e("StatusSerialize", "register status serialize registerStatusToString error, " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public static java.lang.String a(com.meizu.cloud.pushsdk.platform.message.SubAliasStatus subAliasStatus) {
        com.meizu.cloud.pushinternal.DebugLogger.i("StatusSerialize", "register status serialize subAliasStatusToString start, SubAliasStatus=" + subAliasStatus);
        try {
            org.json.JSONObject a = a(new org.json.JSONObject(), subAliasStatus);
            if (!android.text.TextUtils.isEmpty(subAliasStatus.getPushId())) {
                a.put(com.meizu.cloud.pushsdk.constants.PushConstants.REGISTER_STATUS_PUSH_ID, subAliasStatus.getPushId());
            }
            a.put(com.meizu.cloud.pushsdk.constants.PushConstants.SUB_ALIAS_STATUS_NAME, subAliasStatus.getAlias());
            java.lang.String jSONObject = a.toString();
            com.meizu.cloud.pushinternal.DebugLogger.i("StatusSerialize", "register status serialize subAliasStatusToString success, statusText=" + jSONObject);
            return jSONObject;
        } catch (org.json.JSONException e) {
            com.meizu.cloud.pushinternal.DebugLogger.e("StatusSerialize", "register status serialize subAliasStatusToString error, " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public static java.lang.String a(com.meizu.cloud.pushsdk.platform.message.SubTagsStatus subTagsStatus) {
        com.meizu.cloud.pushinternal.DebugLogger.i("StatusSerialize", "register status serialize subTagsStatusToString start, SubTagsStatus=" + subTagsStatus);
        try {
            org.json.JSONObject a = a(new org.json.JSONObject(), subTagsStatus);
            if (!android.text.TextUtils.isEmpty(subTagsStatus.getPushId())) {
                a.put(com.meizu.cloud.pushsdk.constants.PushConstants.REGISTER_STATUS_PUSH_ID, subTagsStatus.getPushId());
            }
            if (subTagsStatus.getTagList() != null) {
                org.json.JSONArray jSONArray = new org.json.JSONArray();
                for (int i = 0; i < subTagsStatus.getTagList().size(); i++) {
                    org.json.JSONObject jSONObject = new org.json.JSONObject();
                    jSONObject.put(com.meizu.cloud.pushsdk.constants.PushConstants.SUB_TAGS_STATUS_ID, subTagsStatus.getTagList().get(i).getTagId());
                    jSONObject.put(com.meizu.cloud.pushsdk.constants.PushConstants.SUB_TAGS_STATUS_NAME, subTagsStatus.getTagList().get(i).getTagName());
                    jSONArray.put(jSONObject);
                }
                a.put(com.meizu.cloud.pushsdk.constants.PushConstants.SUB_TAGS_STATUS_LIST, jSONArray);
            }
            java.lang.String jSONObject2 = a.toString();
            com.meizu.cloud.pushinternal.DebugLogger.i("StatusSerialize", "register status serialize subTagsStatusToString success, statusText=" + jSONObject2);
            return jSONObject2;
        } catch (org.json.JSONException e) {
            com.meizu.cloud.pushinternal.DebugLogger.e("StatusSerialize", "register status serialize subTagsStatusToString error, " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public static java.lang.String a(com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus unRegisterStatus) {
        com.meizu.cloud.pushinternal.DebugLogger.i("StatusSerialize", "register status serialize unregisterStatusToString start, UnRegisterStatus=" + unRegisterStatus);
        try {
            org.json.JSONObject a = a(new org.json.JSONObject(), unRegisterStatus);
            a.put(com.meizu.cloud.pushsdk.constants.PushConstants.UNREGISTER_STATUS_IS_SUCCESS, unRegisterStatus.isUnRegisterSuccess());
            java.lang.String jSONObject = a.toString();
            com.meizu.cloud.pushinternal.DebugLogger.i("StatusSerialize", "register status serialize unregisterStatusToString success, statusText=" + jSONObject);
            return jSONObject;
        } catch (org.json.JSONException e) {
            com.meizu.cloud.pushinternal.DebugLogger.e("StatusSerialize", "register status serialize unregisterStatusToString error, " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    private static org.json.JSONObject a(org.json.JSONObject jSONObject, com.meizu.cloud.pushsdk.platform.message.BasicPushStatus basicPushStatus) throws org.json.JSONException {
        if (jSONObject == null || basicPushStatus == null) {
            return null;
        }
        jSONObject.put("code", basicPushStatus.getCode());
        jSONObject.put("message", basicPushStatus.getMessage());
        return jSONObject;
    }

    private static com.meizu.cloud.pushsdk.platform.message.BasicPushStatus b(org.json.JSONObject jSONObject, com.meizu.cloud.pushsdk.platform.message.BasicPushStatus basicPushStatus) throws org.json.JSONException {
        if (jSONObject == null || basicPushStatus == null) {
            return null;
        }
        if (!jSONObject.isNull("code")) {
            basicPushStatus.setCode(jSONObject.getString("code"));
        }
        if (!jSONObject.isNull("message")) {
            basicPushStatus.setMessage(jSONObject.getString("message"));
        }
        return basicPushStatus;
    }

    public static com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus b(java.lang.String str) {
        com.meizu.cloud.pushinternal.DebugLogger.i("StatusSerialize", "register status serialize stringToUnregisterStatus start, statusText=" + str);
        try {
            com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus unRegisterStatus = new com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus();
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus unRegisterStatus2 = (com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus) b(jSONObject, unRegisterStatus);
            if (!jSONObject.isNull(com.meizu.cloud.pushsdk.constants.PushConstants.UNREGISTER_STATUS_IS_SUCCESS)) {
                unRegisterStatus2.setIsUnRegisterSuccess(jSONObject.getBoolean(com.meizu.cloud.pushsdk.constants.PushConstants.UNREGISTER_STATUS_IS_SUCCESS));
            }
            com.meizu.cloud.pushinternal.DebugLogger.i("StatusSerialize", "register status serialize stringToUnregisterStatus success, UnRegisterStatus=" + unRegisterStatus2);
            return unRegisterStatus2;
        } catch (org.json.JSONException e) {
            com.meizu.cloud.pushinternal.DebugLogger.e("StatusSerialize", "register status serialize stringToUnregisterStatus error, " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public static com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus c(java.lang.String str) {
        com.meizu.cloud.pushinternal.DebugLogger.i("StatusSerialize", "register status serialize stringToPushSwitchStatus start, statusText=" + str);
        try {
            com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus pushSwitchStatus = new com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus();
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus pushSwitchStatus2 = (com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus) b(jSONObject, pushSwitchStatus);
            if (!jSONObject.isNull(com.meizu.cloud.pushsdk.constants.PushConstants.REGISTER_STATUS_PUSH_ID)) {
                pushSwitchStatus2.setPushId(jSONObject.getString(com.meizu.cloud.pushsdk.constants.PushConstants.REGISTER_STATUS_PUSH_ID));
            }
            if (!jSONObject.isNull(com.meizu.cloud.pushsdk.constants.PushConstants.PUSH_SWITCH_STATUS_IS_NOTIFICATION_SWITCH)) {
                pushSwitchStatus2.setSwitchNotificationMessage(jSONObject.getBoolean(com.meizu.cloud.pushsdk.constants.PushConstants.PUSH_SWITCH_STATUS_IS_NOTIFICATION_SWITCH));
            }
            if (!jSONObject.isNull(com.meizu.cloud.pushsdk.constants.PushConstants.PUSH_SWITCH_STATUS_IS_THROUGH_SWITCH)) {
                pushSwitchStatus2.setSwitchThroughMessage(jSONObject.getBoolean(com.meizu.cloud.pushsdk.constants.PushConstants.PUSH_SWITCH_STATUS_IS_THROUGH_SWITCH));
            }
            com.meizu.cloud.pushinternal.DebugLogger.i("StatusSerialize", "register status serialize stringToPushSwitchStatus success, PushSwitchStatus=" + pushSwitchStatus2);
            return pushSwitchStatus2;
        } catch (org.json.JSONException e) {
            com.meizu.cloud.pushinternal.DebugLogger.e("StatusSerialize", "register status serialize stringToPushSwitchStatus error, " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public static com.meizu.cloud.pushsdk.platform.message.SubAliasStatus d(java.lang.String str) {
        com.meizu.cloud.pushinternal.DebugLogger.i("StatusSerialize", "register status serialize stringToSubAliasStatus start, statusText=" + str);
        try {
            com.meizu.cloud.pushsdk.platform.message.SubAliasStatus subAliasStatus = new com.meizu.cloud.pushsdk.platform.message.SubAliasStatus();
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            com.meizu.cloud.pushsdk.platform.message.SubAliasStatus subAliasStatus2 = (com.meizu.cloud.pushsdk.platform.message.SubAliasStatus) b(jSONObject, subAliasStatus);
            if (!jSONObject.isNull(com.meizu.cloud.pushsdk.constants.PushConstants.REGISTER_STATUS_PUSH_ID)) {
                subAliasStatus2.setPushId(jSONObject.getString(com.meizu.cloud.pushsdk.constants.PushConstants.REGISTER_STATUS_PUSH_ID));
            }
            if (!jSONObject.isNull(com.meizu.cloud.pushsdk.constants.PushConstants.SUB_ALIAS_STATUS_NAME)) {
                subAliasStatus2.setAlias(jSONObject.getString(com.meizu.cloud.pushsdk.constants.PushConstants.SUB_ALIAS_STATUS_NAME));
            }
            com.meizu.cloud.pushinternal.DebugLogger.i("StatusSerialize", "register status serialize stringToSubAliasStatus success, SubAliasStatus=" + subAliasStatus2);
            return subAliasStatus2;
        } catch (org.json.JSONException e) {
            com.meizu.cloud.pushinternal.DebugLogger.e("StatusSerialize", "register status serialize stringToSubAliasStatus error, " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public static com.meizu.cloud.pushsdk.platform.message.SubTagsStatus e(java.lang.String str) {
        com.meizu.cloud.pushinternal.DebugLogger.i("StatusSerialize", "register status serialize stringToSubTagsStatus start, statusText=" + str);
        try {
            com.meizu.cloud.pushsdk.platform.message.SubTagsStatus subTagsStatus = new com.meizu.cloud.pushsdk.platform.message.SubTagsStatus();
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            com.meizu.cloud.pushsdk.platform.message.SubTagsStatus subTagsStatus2 = (com.meizu.cloud.pushsdk.platform.message.SubTagsStatus) b(jSONObject, subTagsStatus);
            if (!jSONObject.isNull(com.meizu.cloud.pushsdk.constants.PushConstants.REGISTER_STATUS_PUSH_ID)) {
                subTagsStatus2.setPushId(jSONObject.getString(com.meizu.cloud.pushsdk.constants.PushConstants.REGISTER_STATUS_PUSH_ID));
            }
            if (!jSONObject.isNull(com.meizu.cloud.pushsdk.constants.PushConstants.SUB_TAGS_STATUS_LIST)) {
                org.json.JSONArray jSONArray = jSONObject.getJSONArray(com.meizu.cloud.pushsdk.constants.PushConstants.SUB_TAGS_STATUS_LIST);
                java.util.ArrayList arrayList = new java.util.ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    org.json.JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    subTagsStatus2.getClass();
                    com.meizu.cloud.pushsdk.platform.message.SubTagsStatus.Tag tag = subTagsStatus2.new Tag();
                    if (!jSONObject2.isNull(com.meizu.cloud.pushsdk.constants.PushConstants.SUB_TAGS_STATUS_ID)) {
                        tag.setTagId(jSONObject2.getInt(com.meizu.cloud.pushsdk.constants.PushConstants.SUB_TAGS_STATUS_ID));
                    }
                    if (!jSONObject2.isNull(com.meizu.cloud.pushsdk.constants.PushConstants.SUB_TAGS_STATUS_NAME)) {
                        tag.setTagName(jSONObject2.getString(com.meizu.cloud.pushsdk.constants.PushConstants.SUB_TAGS_STATUS_NAME));
                    }
                    arrayList.add(tag);
                }
                subTagsStatus2.setTagList(arrayList);
            }
            com.meizu.cloud.pushinternal.DebugLogger.i("StatusSerialize", "register status serialize stringToSubTagsStatus success, SubTagsStatus=" + subTagsStatus2);
            return subTagsStatus2;
        } catch (org.json.JSONException e) {
            com.meizu.cloud.pushinternal.DebugLogger.e("StatusSerialize", "register status serialize stringToSubTagsStatus error, " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
