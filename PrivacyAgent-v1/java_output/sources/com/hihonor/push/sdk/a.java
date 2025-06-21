package com.hihonor.push.sdk;

/* loaded from: classes22.dex */
public class a implements java.util.concurrent.Callable<java.util.List<com.hihonor.push.sdk.bean.MessageBoxBean>> {
    public final android.content.Context a;

    public a(android.content.Context context) {
        this.a = context;
    }

    @Override // java.util.concurrent.Callable
    public java.util.List<com.hihonor.push.sdk.bean.MessageBoxBean> call() throws java.lang.Exception {
        java.util.ArrayList<android.content.ContentValues> parcelableArrayList;
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putString("pkg_name", this.a.getPackageName());
        android.os.Bundle call = this.a.getContentResolver().call(android.net.Uri.parse("content://com.hihonor.android.pushagent.provider.MessageBoxProvider/"), com.hihonor.push.sdk.common.constants.MessageBoxConstants.QUERY_UNREAD_MSG, "", bundle);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (call != null && (parcelableArrayList = call.getParcelableArrayList(com.hihonor.push.sdk.common.constants.MessageBoxConstants.KEY_MESSAGES)) != null) {
            for (android.content.ContentValues contentValues : parcelableArrayList) {
                com.hihonor.push.sdk.bean.MessageBoxBean messageBoxBean = new com.hihonor.push.sdk.bean.MessageBoxBean();
                messageBoxBean.setTitle(contentValues.getAsString("title"));
                messageBoxBean.setContent(contentValues.getAsString("content"));
                messageBoxBean.setImage(contentValues.getAsString("image"));
                messageBoxBean.setMsgExtra(contentValues.getAsString(com.hihonor.push.sdk.common.constants.MessageBoxConstants.KEY_MSG_EXTRA));
                if (contentValues.containsKey(com.hihonor.push.sdk.common.constants.MessageBoxConstants.KEY_SKIP_TYPE)) {
                    java.lang.String asString = contentValues.getAsString(com.hihonor.push.sdk.common.constants.MessageBoxConstants.KEY_SKIP_TYPE);
                    com.hihonor.push.sdk.bean.SkipType skipType = com.hihonor.push.sdk.bean.SkipType.TYPE_INTENT;
                    if ("1".equals(asString)) {
                        skipType = com.hihonor.push.sdk.bean.SkipType.TYPE_ACTION;
                    } else if ("2".equals(asString)) {
                        skipType = com.hihonor.push.sdk.bean.SkipType.TYPE_LAUNCHER;
                    }
                    messageBoxBean.setSkipType(skipType);
                }
                if (contentValues.containsKey(com.hihonor.push.sdk.common.constants.MessageBoxConstants.KEY_SKIP_URL)) {
                    messageBoxBean.setSkipUrl(contentValues.getAsString(com.hihonor.push.sdk.common.constants.MessageBoxConstants.KEY_SKIP_URL));
                }
                if (contentValues.containsKey(com.hihonor.push.sdk.common.constants.MessageBoxConstants.KEY_RECEIVE_TIME_MILLIS)) {
                    java.lang.Long asLong = contentValues.getAsLong(com.hihonor.push.sdk.common.constants.MessageBoxConstants.KEY_RECEIVE_TIME_MILLIS);
                    messageBoxBean.setReceiveTimeMillis(asLong == null ? 0L : asLong.longValue());
                }
                arrayList.add(messageBoxBean);
            }
        }
        return arrayList;
    }
}
