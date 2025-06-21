package com.xiaomi.mipush.sdk;

/* loaded from: classes19.dex */
public class MiPushMessage implements com.xiaomi.mipush.sdk.PushMessageHandler.a {
    private static final java.lang.String KEY_ALIAS = "alias";
    private static final java.lang.String KEY_CATEGORY = "category";
    private static final java.lang.String KEY_CONTENT = "content";
    private static final java.lang.String KEY_DESC = "description";
    private static final java.lang.String KEY_EXTRA = "extra";
    private static final java.lang.String KEY_MESSAGE_ID = "messageId";
    private static final java.lang.String KEY_MESSAGE_TYPE = "messageType";
    private static final java.lang.String KEY_NOTIFIED = "isNotified";
    private static final java.lang.String KEY_NOTIFY_ID = "notifyId";
    private static final java.lang.String KEY_NOTIFY_TYPE = "notifyType";
    private static final java.lang.String KEY_PASS_THROUGH = "passThrough";
    private static final java.lang.String KEY_TITLE = "title";
    private static final java.lang.String KEY_TOPIC = "topic";
    private static final java.lang.String KEY_USER_ACCOUNT = "user_account";
    public static final int MESSAGE_TYPE_ACCOUNT = 3;
    public static final int MESSAGE_TYPE_ALIAS = 1;
    public static final int MESSAGE_TYPE_REG = 0;
    public static final int MESSAGE_TYPE_TOPIC = 2;
    private static final long serialVersionUID = 1;
    private java.lang.String alias;
    private java.lang.String category;
    private java.lang.String content;
    private java.lang.String description;
    private boolean isNotified;
    private java.lang.String messageId;
    private int messageType;
    private int notifyId;
    private int notifyType;
    private int passThrough;
    private java.lang.String title;
    private java.lang.String topic;
    private java.lang.String userAccount;
    private boolean arrived = false;
    private java.util.HashMap<java.lang.String, java.lang.String> extra = new java.util.HashMap<>();

    public static com.xiaomi.mipush.sdk.MiPushMessage fromBundle(android.os.Bundle bundle) {
        com.xiaomi.mipush.sdk.MiPushMessage miPushMessage = new com.xiaomi.mipush.sdk.MiPushMessage();
        miPushMessage.messageId = bundle.getString(KEY_MESSAGE_ID);
        miPushMessage.messageType = bundle.getInt(KEY_MESSAGE_TYPE);
        miPushMessage.passThrough = bundle.getInt(KEY_PASS_THROUGH);
        miPushMessage.alias = bundle.getString("alias");
        miPushMessage.userAccount = bundle.getString(KEY_USER_ACCOUNT);
        miPushMessage.topic = bundle.getString(KEY_TOPIC);
        miPushMessage.content = bundle.getString("content");
        miPushMessage.description = bundle.getString("description");
        miPushMessage.title = bundle.getString("title");
        miPushMessage.isNotified = bundle.getBoolean(KEY_NOTIFIED);
        miPushMessage.notifyId = bundle.getInt("notifyId");
        miPushMessage.notifyType = bundle.getInt(KEY_NOTIFY_TYPE);
        miPushMessage.category = bundle.getString("category");
        miPushMessage.extra = (java.util.HashMap) bundle.getSerializable("extra");
        return miPushMessage;
    }

    public java.lang.String getAlias() {
        return this.alias;
    }

    public java.lang.String getCategory() {
        return this.category;
    }

    public java.lang.String getContent() {
        return this.content;
    }

    public java.lang.String getDescription() {
        return this.description;
    }

    public java.util.Map<java.lang.String, java.lang.String> getExtra() {
        return this.extra;
    }

    public java.lang.String getMessageId() {
        return this.messageId;
    }

    public int getMessageType() {
        return this.messageType;
    }

    public int getNotifyId() {
        return this.notifyId;
    }

    public int getNotifyType() {
        return this.notifyType;
    }

    public int getPassThrough() {
        return this.passThrough;
    }

    public java.lang.String getTitle() {
        return this.title;
    }

    public java.lang.String getTopic() {
        return this.topic;
    }

    public java.lang.String getUserAccount() {
        return this.userAccount;
    }

    public boolean isArrivedMessage() {
        return this.arrived;
    }

    public boolean isNotified() {
        return this.isNotified;
    }

    public void setAlias(java.lang.String str) {
        this.alias = str;
    }

    public void setArrivedMessage(boolean z) {
        this.arrived = z;
    }

    public void setCategory(java.lang.String str) {
        this.category = str;
    }

    public void setContent(java.lang.String str) {
        this.content = str;
    }

    public void setDescription(java.lang.String str) {
        this.description = str;
    }

    public void setExtra(java.util.Map<java.lang.String, java.lang.String> map) {
        this.extra.clear();
        if (map != null) {
            this.extra.putAll(map);
        }
    }

    public void setMessageId(java.lang.String str) {
        this.messageId = str;
    }

    public void setMessageType(int i) {
        this.messageType = i;
    }

    public void setNotified(boolean z) {
        this.isNotified = z;
    }

    public void setNotifyId(int i) {
        this.notifyId = i;
    }

    public void setNotifyType(int i) {
        this.notifyType = i;
    }

    public void setPassThrough(int i) {
        this.passThrough = i;
    }

    public void setTitle(java.lang.String str) {
        this.title = str;
    }

    public void setTopic(java.lang.String str) {
        this.topic = str;
    }

    public void setUserAccount(java.lang.String str) {
        this.userAccount = str;
    }

    public android.os.Bundle toBundle() {
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putString(KEY_MESSAGE_ID, this.messageId);
        bundle.putInt(KEY_PASS_THROUGH, this.passThrough);
        bundle.putInt(KEY_MESSAGE_TYPE, this.messageType);
        if (!android.text.TextUtils.isEmpty(this.alias)) {
            bundle.putString("alias", this.alias);
        }
        if (!android.text.TextUtils.isEmpty(this.userAccount)) {
            bundle.putString(KEY_USER_ACCOUNT, this.userAccount);
        }
        if (!android.text.TextUtils.isEmpty(this.topic)) {
            bundle.putString(KEY_TOPIC, this.topic);
        }
        bundle.putString("content", this.content);
        if (!android.text.TextUtils.isEmpty(this.description)) {
            bundle.putString("description", this.description);
        }
        if (!android.text.TextUtils.isEmpty(this.title)) {
            bundle.putString("title", this.title);
        }
        bundle.putBoolean(KEY_NOTIFIED, this.isNotified);
        bundle.putInt("notifyId", this.notifyId);
        bundle.putInt(KEY_NOTIFY_TYPE, this.notifyType);
        if (!android.text.TextUtils.isEmpty(this.category)) {
            bundle.putString("category", this.category);
        }
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = this.extra;
        if (hashMap != null) {
            bundle.putSerializable("extra", hashMap);
        }
        return bundle;
    }

    public java.lang.String toString() {
        return "messageId={" + this.messageId + "},passThrough={" + this.passThrough + "},alias={" + this.alias + "},topic={" + this.topic + "},userAccount={" + this.userAccount + "},content={" + this.content + "},description={" + this.description + "},title={" + this.title + "},isNotified={" + this.isNotified + "},notifyId={" + this.notifyId + "},notifyType={" + this.notifyType + "}, category={" + this.category + "}, extra={" + this.extra + com.alipay.sdk.m.u.i.d;
    }
}
