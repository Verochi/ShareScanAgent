package okhttp3;

/* loaded from: classes23.dex */
public final class Credentials {
    public static java.lang.String basic(java.lang.String str, java.lang.String str2) {
        return basic(str, str2, java.nio.charset.StandardCharsets.ISO_8859_1);
    }

    public static java.lang.String basic(java.lang.String str, java.lang.String str2, java.nio.charset.Charset charset) {
        return "Basic " + okio.ByteString.encodeString(str + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + str2, charset).base64();
    }
}
