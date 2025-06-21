package com.google.zxing;

/* loaded from: classes22.dex */
public final class FormatException extends com.google.zxing.ReaderException {
    private static final com.google.zxing.FormatException INSTANCE;

    static {
        com.google.zxing.FormatException formatException = new com.google.zxing.FormatException();
        INSTANCE = formatException;
        formatException.setStackTrace(com.google.zxing.ReaderException.NO_TRACE);
    }

    private FormatException() {
    }

    private FormatException(java.lang.Throwable th) {
        super(th);
    }

    public static com.google.zxing.FormatException getFormatInstance() {
        return com.google.zxing.ReaderException.isStackTrace ? new com.google.zxing.FormatException() : INSTANCE;
    }

    public static com.google.zxing.FormatException getFormatInstance(java.lang.Throwable th) {
        return com.google.zxing.ReaderException.isStackTrace ? new com.google.zxing.FormatException(th) : INSTANCE;
    }
}
