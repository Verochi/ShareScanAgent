package com.igexin.assist;

/* loaded from: classes22.dex */
public class MessageBean {
    private java.lang.String a;
    private java.lang.String b;
    private java.lang.Object c;
    private android.content.Context d;
    public final android.os.Bundle extra = new android.os.Bundle();

    public MessageBean(android.content.Context context, java.lang.String str, java.lang.Object obj) {
        this.b = str;
        this.c = obj;
        this.d = context;
    }

    public android.content.Context getContext() {
        return this.d;
    }

    public java.lang.Object getMessage() {
        return this.c;
    }

    public java.lang.String getMessageSource() {
        return this.a;
    }

    public java.lang.String getMessageType() {
        return this.b;
    }

    public java.lang.Object getObjectMessage() {
        return this.c;
    }

    public java.lang.String getStringMessage() {
        java.lang.Object obj = this.c;
        if (obj instanceof java.lang.String) {
            return (java.lang.String) obj;
        }
        return null;
    }

    public void setMessageSource(java.lang.String str) {
        this.a = str;
    }
}
