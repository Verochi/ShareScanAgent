package com.heytap.mcssdk.d;

/* loaded from: classes22.dex */
public class b extends com.heytap.mcssdk.d.c {
    @Override // com.heytap.mcssdk.d.d
    public com.heytap.msp.push.mode.BaseMode a(android.content.Context context, int i, android.content.Intent intent) {
        if (4103 != i && 4098 != i && 4108 != i) {
            return null;
        }
        com.heytap.msp.push.mode.BaseMode a = a(intent, i);
        com.heytap.mcssdk.f.a.a(context, com.heytap.mcssdk.constant.c.a.b, (com.heytap.msp.push.mode.DataMessage) a);
        return a;
    }

    @Override // com.heytap.mcssdk.d.c
    public com.heytap.msp.push.mode.BaseMode a(android.content.Intent intent, int i) {
        try {
            com.heytap.msp.push.mode.DataMessage dataMessage = new com.heytap.msp.push.mode.DataMessage();
            dataMessage.setMessageID(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.c)));
            dataMessage.setTaskID(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.d)));
            dataMessage.setGlobalId(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.h)));
            dataMessage.setAppPackage(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.e)));
            dataMessage.setTitle(com.heytap.mcssdk.utils.b.d(intent.getStringExtra("title")));
            dataMessage.setContent(com.heytap.mcssdk.utils.b.d(intent.getStringExtra("content")));
            dataMessage.setDescription(com.heytap.mcssdk.utils.b.d(intent.getStringExtra("description")));
            java.lang.String d = com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.j));
            int i2 = 0;
            dataMessage.setNotifyID(android.text.TextUtils.isEmpty(d) ? 0 : java.lang.Integer.parseInt(d));
            dataMessage.setMiniProgramPkg(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.w)));
            dataMessage.setMessageType(i);
            dataMessage.setEventId(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.k)));
            dataMessage.setStatisticsExtra(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.l)));
            java.lang.String d2 = com.heytap.mcssdk.utils.b.d(intent.getStringExtra("data_extra"));
            dataMessage.setDataExtra(d2);
            java.lang.String a = a(d2);
            if (!android.text.TextUtils.isEmpty(a)) {
                i2 = java.lang.Integer.parseInt(a);
            }
            dataMessage.setMsgCommand(i2);
            dataMessage.setBalanceTime(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.n)));
            dataMessage.setStartDate(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.f375s)));
            dataMessage.setEndDate(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.t)));
            dataMessage.setTimeRanges(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.o)));
            dataMessage.setRule(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.p)));
            dataMessage.setForcedDelivery(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.q)));
            dataMessage.setDistinctContent(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.r)));
            dataMessage.setAppId(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.u)));
            return dataMessage;
        } catch (java.lang.Exception e) {
            com.heytap.mcssdk.utils.d.b("OnHandleIntent--" + e.getMessage());
            return null;
        }
    }

    public java.lang.String a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new org.json.JSONObject(str).optString(com.heytap.mcssdk.constant.b.v);
        } catch (org.json.JSONException e) {
            com.heytap.mcssdk.utils.d.b(e.getMessage());
            return "";
        }
    }
}
