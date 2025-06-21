package com.google.android.exoplayer2.source;

/* loaded from: classes22.dex */
public class UnrecognizedInputFormatException extends com.google.android.exoplayer2.ParserException {
    public final android.net.Uri uri;

    public UnrecognizedInputFormatException(java.lang.String str, android.net.Uri uri) {
        super(str);
        this.uri = uri;
    }
}
