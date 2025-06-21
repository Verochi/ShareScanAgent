package com.badlogic.gdx.utils;

/* loaded from: classes12.dex */
public class SerializationException extends java.lang.RuntimeException {
    private java.lang.StringBuffer trace;

    public SerializationException() {
    }

    public SerializationException(java.lang.String str) {
        super(str);
    }

    public SerializationException(java.lang.String str, java.lang.Throwable th) {
        super(str, th);
    }

    public SerializationException(java.lang.Throwable th) {
        super("", th);
    }

    private boolean causedBy(java.lang.Throwable th, java.lang.Class cls) {
        java.lang.Throwable cause = th.getCause();
        if (cause == null || cause == th) {
            return false;
        }
        if (cls.isAssignableFrom(cause.getClass())) {
            return true;
        }
        return causedBy(cause, cls);
    }

    public void addTrace(java.lang.String str) {
        if (str == null) {
            throw new java.lang.IllegalArgumentException("info cannot be null.");
        }
        if (this.trace == null) {
            this.trace = new java.lang.StringBuffer(512);
        }
        this.trace.append('\n');
        this.trace.append(str);
    }

    public boolean causedBy(java.lang.Class cls) {
        return causedBy(this, cls);
    }

    @Override // java.lang.Throwable
    public java.lang.String getMessage() {
        if (this.trace == null) {
            return super.getMessage();
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(512);
        stringBuffer.append(super.getMessage());
        if (stringBuffer.length() > 0) {
            stringBuffer.append('\n');
        }
        stringBuffer.append("Serialization trace:");
        stringBuffer.append(this.trace);
        return stringBuffer.toString();
    }
}
