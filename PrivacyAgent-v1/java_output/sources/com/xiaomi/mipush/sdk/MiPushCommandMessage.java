package com.xiaomi.mipush.sdk;

/* loaded from: classes19.dex */
public class MiPushCommandMessage implements com.xiaomi.mipush.sdk.PushMessageHandler.a {
    private static final java.lang.String KEY_AUTO_MARK_PKGS = "autoMarkPkgs";
    private static final java.lang.String KEY_CATEGORY = "category";
    private static final java.lang.String KEY_COMMAND = "command";
    private static final java.lang.String KEY_COMMAND_ARGUMENTS = "commandArguments";
    private static final java.lang.String KEY_REASON = "reason";
    private static final java.lang.String KEY_RESULT_CODE = "resultCode";
    private static final long serialVersionUID = 1;
    private java.util.List<java.lang.String> autoMarkPkgs;
    private java.lang.String category;
    private java.lang.String command;
    private java.util.List<java.lang.String> commandArguments;
    private java.lang.String reason;
    private long resultCode;

    public static com.xiaomi.mipush.sdk.MiPushCommandMessage fromBundle(android.os.Bundle bundle) {
        com.xiaomi.mipush.sdk.MiPushCommandMessage miPushCommandMessage = new com.xiaomi.mipush.sdk.MiPushCommandMessage();
        miPushCommandMessage.command = bundle.getString("command");
        miPushCommandMessage.resultCode = bundle.getLong(KEY_RESULT_CODE);
        miPushCommandMessage.reason = bundle.getString("reason");
        miPushCommandMessage.commandArguments = bundle.getStringArrayList(KEY_COMMAND_ARGUMENTS);
        miPushCommandMessage.category = bundle.getString("category");
        miPushCommandMessage.autoMarkPkgs = bundle.getStringArrayList(KEY_AUTO_MARK_PKGS);
        return miPushCommandMessage;
    }

    public java.util.List<java.lang.String> getAutoMarkPkgs() {
        return this.autoMarkPkgs;
    }

    public java.lang.String getCategory() {
        return this.category;
    }

    public java.lang.String getCommand() {
        return this.command;
    }

    public java.util.List<java.lang.String> getCommandArguments() {
        return this.commandArguments;
    }

    public java.lang.String getReason() {
        return this.reason;
    }

    public long getResultCode() {
        return this.resultCode;
    }

    public void setAutoMarkPkgs(java.util.List<java.lang.String> list) {
        this.autoMarkPkgs = list;
    }

    public void setCategory(java.lang.String str) {
        this.category = str;
    }

    public void setCommand(java.lang.String str) {
        this.command = str;
    }

    public void setCommandArguments(java.util.List<java.lang.String> list) {
        this.commandArguments = list;
    }

    public void setReason(java.lang.String str) {
        this.reason = str;
    }

    public void setResultCode(long j) {
        this.resultCode = j;
    }

    public android.os.Bundle toBundle() {
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putString("command", this.command);
        bundle.putLong(KEY_RESULT_CODE, this.resultCode);
        bundle.putString("reason", this.reason);
        java.util.List<java.lang.String> list = this.commandArguments;
        if (list != null) {
            bundle.putStringArrayList(KEY_COMMAND_ARGUMENTS, (java.util.ArrayList) list);
        }
        bundle.putString("category", this.category);
        java.util.List<java.lang.String> list2 = this.autoMarkPkgs;
        if (list2 != null) {
            bundle.putStringArrayList(KEY_AUTO_MARK_PKGS, (java.util.ArrayList) list2);
        }
        return bundle;
    }

    public java.lang.String toString() {
        return "command={" + this.command + "}, resultCode={" + this.resultCode + "}, reason={" + this.reason + "}, category={" + this.category + "}, commandArguments={" + this.commandArguments + com.alipay.sdk.m.u.i.d;
    }
}
