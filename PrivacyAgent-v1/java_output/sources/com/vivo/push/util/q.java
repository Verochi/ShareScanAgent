package com.vivo.push.util;

/* loaded from: classes19.dex */
public final class q {
    public static com.vivo.push.model.InsideNotificationItem a(java.lang.String str) {
        com.vivo.push.model.InsideNotificationItem insideNotificationItem = new com.vivo.push.model.InsideNotificationItem();
        try {
        } catch (org.json.JSONException e) {
            com.vivo.push.util.p.a("MessageConvertUtil", "notify msg pack to obj error", e);
        }
        if (android.text.TextUtils.isEmpty(str)) {
            com.vivo.push.util.p.a("MessageConvertUtil", "notify msg pack to obj is null");
            return null;
        }
        org.json.JSONArray jSONArray = new org.json.JSONArray(str);
        insideNotificationItem.setTargetType(jSONArray.getInt(0));
        insideNotificationItem.setTragetContext(jSONArray.getString(1));
        insideNotificationItem.setTitle(jSONArray.getString(2));
        insideNotificationItem.setContent(jSONArray.getString(3));
        insideNotificationItem.setNotifyType(jSONArray.getInt(4));
        insideNotificationItem.setPurePicUrl(jSONArray.getString(5));
        insideNotificationItem.setIconUrl(jSONArray.getString(6));
        insideNotificationItem.setCoverUrl(jSONArray.getString(7));
        insideNotificationItem.setSkipContent(jSONArray.getString(8));
        insideNotificationItem.setSkipType(jSONArray.getInt(9));
        insideNotificationItem.setShowTime(jSONArray.getBoolean(10));
        if (jSONArray.length() > 11) {
            insideNotificationItem.setParams(com.vivo.push.util.m.a(new org.json.JSONObject(jSONArray.getString(11))));
        }
        if (jSONArray.length() > 15) {
            insideNotificationItem.setAppType(jSONArray.getInt(12));
            insideNotificationItem.setReactPackage(jSONArray.getString(13));
            insideNotificationItem.setIsShowBigPicOnMobileNet(jSONArray.getBoolean(14));
            insideNotificationItem.setSuitReactVersion(jSONArray.getString(15));
        }
        if (jSONArray.length() > 16) {
            insideNotificationItem.setMessageType(jSONArray.getInt(16));
        }
        if (jSONArray.length() > 18) {
            insideNotificationItem.setIsMacroReplace(jSONArray.getInt(17));
            insideNotificationItem.setAdClickCheckUrl(jSONArray.getString(18));
        }
        if (jSONArray.length() > 19) {
            insideNotificationItem.setCompatibleType(jSONArray.getInt(19));
        }
        if (jSONArray.length() > 20) {
            insideNotificationItem.setInnerPriority(jSONArray.getInt(20));
        }
        if (jSONArray.length() > 21) {
            insideNotificationItem.setDisplayStyle(jSONArray.getInt(21));
        }
        return insideNotificationItem;
    }

    public static com.vivo.push.model.UPSNotificationMessage a(com.vivo.push.model.InsideNotificationItem insideNotificationItem) {
        com.vivo.push.model.UPSNotificationMessage uPSNotificationMessage = new com.vivo.push.model.UPSNotificationMessage();
        uPSNotificationMessage.setTargetType(insideNotificationItem.getTargetType());
        uPSNotificationMessage.setTragetContext(insideNotificationItem.getTragetContent());
        uPSNotificationMessage.setTitle(insideNotificationItem.getTitle());
        uPSNotificationMessage.setContent(insideNotificationItem.getContent());
        uPSNotificationMessage.setNotifyType(insideNotificationItem.getNotifyType());
        uPSNotificationMessage.setPurePicUrl(insideNotificationItem.getPurePicUrl());
        uPSNotificationMessage.setIconUrl(insideNotificationItem.getIconUrl());
        uPSNotificationMessage.setCoverUrl(insideNotificationItem.getCoverUrl());
        uPSNotificationMessage.setSkipContent(insideNotificationItem.getSkipContent());
        uPSNotificationMessage.setSkipType(insideNotificationItem.getSkipType());
        uPSNotificationMessage.setShowTime(insideNotificationItem.isShowTime());
        uPSNotificationMessage.setMsgId(insideNotificationItem.getMsgId());
        uPSNotificationMessage.setParams(insideNotificationItem.getParams());
        return uPSNotificationMessage;
    }

    public static java.lang.String b(com.vivo.push.model.InsideNotificationItem insideNotificationItem) {
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        jSONArray.put(insideNotificationItem.getTargetType());
        jSONArray.put(insideNotificationItem.getTragetContent());
        jSONArray.put(insideNotificationItem.getTitle());
        jSONArray.put(insideNotificationItem.getContent());
        jSONArray.put(insideNotificationItem.getNotifyType());
        jSONArray.put(insideNotificationItem.getPurePicUrl());
        jSONArray.put(insideNotificationItem.getIconUrl());
        jSONArray.put(insideNotificationItem.getCoverUrl());
        jSONArray.put(insideNotificationItem.getSkipContent());
        jSONArray.put(insideNotificationItem.getSkipType());
        jSONArray.put(insideNotificationItem.isShowTime());
        jSONArray.put(insideNotificationItem.getParams() != null ? new org.json.JSONObject(insideNotificationItem.getParams()) : "{}");
        jSONArray.put(insideNotificationItem.getAppType());
        jSONArray.put(insideNotificationItem.getReactPackage());
        jSONArray.put(insideNotificationItem.isShowBigPicOnMobileNet());
        jSONArray.put(insideNotificationItem.getSuitReactVersion());
        jSONArray.put(insideNotificationItem.getMessageType());
        jSONArray.put(insideNotificationItem.getIsMacroReplace());
        jSONArray.put(insideNotificationItem.getAdClickCheckUrl());
        jSONArray.put(insideNotificationItem.getCompatibleType());
        jSONArray.put(insideNotificationItem.getInnerPriority());
        jSONArray.put(insideNotificationItem.getDisplayStyle());
        return jSONArray.toString();
    }
}
