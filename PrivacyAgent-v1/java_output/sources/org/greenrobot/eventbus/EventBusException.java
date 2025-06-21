package org.greenrobot.eventbus;

/* loaded from: classes26.dex */
public class EventBusException extends java.lang.RuntimeException {
    private static final long serialVersionUID = -2912559384646531479L;

    public EventBusException(java.lang.String str) {
        super(str);
    }

    public EventBusException(java.lang.String str, java.lang.Throwable th) {
        super(str, th);
    }

    public EventBusException(java.lang.Throwable th) {
        super(th);
    }
}
