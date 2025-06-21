package org.greenrobot.eventbus.util;

/* loaded from: classes26.dex */
public class ErrorDialogConfig {
    public final android.content.res.Resources a;
    public final int b;
    public final int c;
    public org.greenrobot.eventbus.EventBus e;
    public java.lang.String g;
    public int h;
    public java.lang.Class<?> i;
    public boolean f = true;
    public final org.greenrobot.eventbus.util.ExceptionToResourceMapping d = new org.greenrobot.eventbus.util.ExceptionToResourceMapping();

    public ErrorDialogConfig(android.content.res.Resources resources, int i, int i2) {
        this.a = resources;
        this.b = i;
        this.c = i2;
    }

    public org.greenrobot.eventbus.EventBus a() {
        org.greenrobot.eventbus.EventBus eventBus = this.e;
        return eventBus != null ? eventBus : org.greenrobot.eventbus.EventBus.getDefault();
    }

    public org.greenrobot.eventbus.util.ErrorDialogConfig addMapping(java.lang.Class<? extends java.lang.Throwable> cls, int i) {
        this.d.addMapping(cls, i);
        return this;
    }

    public void disableExceptionLogging() {
        this.f = false;
    }

    public int getMessageIdForThrowable(java.lang.Throwable th) {
        java.lang.Integer mapThrowable = this.d.mapThrowable(th);
        if (mapThrowable != null) {
            return mapThrowable.intValue();
        }
        java.lang.String str = org.greenrobot.eventbus.EventBus.TAG;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("No specific message ressource ID found for ");
        sb.append(th);
        return this.c;
    }

    public void setDefaultDialogIconId(int i) {
        this.h = i;
    }

    public void setDefaultEventTypeOnDialogClosed(java.lang.Class<?> cls) {
        this.i = cls;
    }

    public void setEventBus(org.greenrobot.eventbus.EventBus eventBus) {
        this.e = eventBus;
    }

    public void setTagForLoggingExceptions(java.lang.String str) {
        this.g = str;
    }
}
