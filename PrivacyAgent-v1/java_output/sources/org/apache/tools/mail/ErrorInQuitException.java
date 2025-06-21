package org.apache.tools.mail;

/* loaded from: classes26.dex */
public class ErrorInQuitException extends java.io.IOException {
    public ErrorInQuitException(java.io.IOException iOException) {
        super(iOException.getMessage());
    }
}
