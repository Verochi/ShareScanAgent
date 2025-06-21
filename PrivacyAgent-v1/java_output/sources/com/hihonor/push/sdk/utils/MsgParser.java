package com.hihonor.push.sdk.utils;

/* loaded from: classes22.dex */
public class MsgParser {
    public static com.hihonor.push.sdk.bean.DataMessage parseRemoteDataMessage(android.content.Intent intent) {
        com.hihonor.push.sdk.bean.DataMessage dataMessage = null;
        if (intent == null) {
            return null;
        }
        try {
            long parserMsgId = com.hihonor.push.sdk.common.parser.PassByMsgIntentParser.parserMsgId(intent);
            java.lang.String unZipString = com.hihonor.push.sdk.common.parser.DeflateUtil.unZipString(com.hihonor.push.sdk.common.parser.PassByMsgIntentParser.parseMsgContent(intent));
            if (android.text.TextUtils.isEmpty(unZipString)) {
                return null;
            }
            java.lang.String parserContentMessage = parserContentMessage(unZipString);
            if (android.text.TextUtils.isEmpty(parserContentMessage)) {
                return null;
            }
            com.hihonor.push.sdk.bean.DataMessage dataMessage2 = new com.hihonor.push.sdk.bean.DataMessage();
            try {
                dataMessage2.setMsgId(parserMsgId);
                dataMessage2.setContent(parserContentMessage);
                return dataMessage2;
            } catch (org.json.JSONException unused) {
                dataMessage = dataMessage2;
                com.hihonor.push.sdk.common.logger.Logger.e("parse remote json data message error.");
                return dataMessage;
            } catch (java.lang.Exception unused2) {
                dataMessage = dataMessage2;
                com.hihonor.push.sdk.common.logger.Logger.e("parse remote data message error.");
                return dataMessage;
            }
        } catch (org.json.JSONException unused3) {
        } catch (java.lang.Exception unused4) {
        }
    }

    private static java.lang.String parserContentMessage(java.lang.String str) throws org.json.JSONException {
        return new org.json.JSONObject(str).optString("data");
    }
}
