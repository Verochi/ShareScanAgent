package com.google.android.exoplayer2.database;

/* loaded from: classes22.dex */
public final class DatabaseIOException extends java.io.IOException {
    public DatabaseIOException(android.database.SQLException sQLException) {
        super(sQLException);
    }

    public DatabaseIOException(android.database.SQLException sQLException, java.lang.String str) {
        super(str, sQLException);
    }
}
