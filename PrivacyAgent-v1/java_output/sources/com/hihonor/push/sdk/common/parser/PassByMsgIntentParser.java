package com.hihonor.push.sdk.common.parser;

/* loaded from: classes22.dex */
public class PassByMsgIntentParser {
    private static final java.lang.String KEY_MSG_CONTENT = "msg_content";
    private static final java.lang.String KEY_MSG_ID = "msg_id";
    private static final java.lang.String TAG = "PassByMsgIntentParser";

    public static byte[] parseMsgContent(android.content.Intent intent) {
        try {
            return intent.getByteArrayExtra("msg_content");
        } catch (java.lang.Exception e) {
            com.hihonor.push.sdk.common.logger.Logger.e(TAG, "parseMsgContent", e);
            return null;
        }
    }

    public static long parserMsgId(android.content.Intent intent) {
        try {
            return intent.getLongExtra("msg_id", 0L);
        } catch (java.lang.Exception e) {
            com.hihonor.push.sdk.common.logger.Logger.e(TAG, "parserMsgId", e);
            return 0L;
        }
    }

    public static void putParams(android.content.Intent intent, long j, byte[] bArr) {
        try {
            intent.putExtra("msg_id", j);
            intent.putExtra("msg_content", bArr);
        } catch (java.lang.Exception e) {
            com.hihonor.push.sdk.common.logger.Logger.e(TAG, "putParams", e);
        }
    }
}
