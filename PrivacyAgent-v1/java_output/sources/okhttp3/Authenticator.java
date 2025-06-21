package okhttp3;

/* loaded from: classes23.dex */
public interface Authenticator {
    public static final okhttp3.Authenticator NONE = new defpackage.qe();

    @javax.annotation.Nullable
    okhttp3.Request authenticate(@javax.annotation.Nullable okhttp3.Route route, okhttp3.Response response) throws java.io.IOException;
}
