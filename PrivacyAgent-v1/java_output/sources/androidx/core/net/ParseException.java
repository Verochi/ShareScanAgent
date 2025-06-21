package androidx.core.net;

/* loaded from: classes.dex */
public class ParseException extends java.lang.RuntimeException {

    @androidx.annotation.NonNull
    public final java.lang.String response;

    public ParseException(@androidx.annotation.NonNull java.lang.String str) {
        super(str);
        this.response = str;
    }
}
