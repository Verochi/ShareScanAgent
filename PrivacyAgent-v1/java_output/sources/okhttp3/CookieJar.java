package okhttp3;

/* loaded from: classes23.dex */
public interface CookieJar {
    public static final okhttp3.CookieJar NO_COOKIES = new okhttp3.CookieJar.AnonymousClass1();

    /* renamed from: okhttp3.CookieJar$1, reason: invalid class name */
    public class AnonymousClass1 implements okhttp3.CookieJar {
        @Override // okhttp3.CookieJar
        public java.util.List<okhttp3.Cookie> loadForRequest(okhttp3.HttpUrl httpUrl) {
            return java.util.Collections.emptyList();
        }

        @Override // okhttp3.CookieJar
        public void saveFromResponse(okhttp3.HttpUrl httpUrl, java.util.List<okhttp3.Cookie> list) {
        }
    }

    java.util.List<okhttp3.Cookie> loadForRequest(okhttp3.HttpUrl httpUrl);

    void saveFromResponse(okhttp3.HttpUrl httpUrl, java.util.List<okhttp3.Cookie> list);
}
