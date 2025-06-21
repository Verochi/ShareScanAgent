package com.google.common.net;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public final class HttpHeaders {
    public static final java.lang.String ACCEPT = "Accept";
    public static final java.lang.String ACCEPT_CHARSET = "Accept-Charset";
    public static final java.lang.String ACCEPT_ENCODING = "Accept-Encoding";
    public static final java.lang.String ACCEPT_LANGUAGE = "Accept-Language";
    public static final java.lang.String ACCEPT_RANGES = "Accept-Ranges";
    public static final java.lang.String ACCESS_CONTROL_ALLOW_CREDENTIALS = "Access-Control-Allow-Credentials";
    public static final java.lang.String ACCESS_CONTROL_ALLOW_HEADERS = "Access-Control-Allow-Headers";
    public static final java.lang.String ACCESS_CONTROL_ALLOW_METHODS = "Access-Control-Allow-Methods";
    public static final java.lang.String ACCESS_CONTROL_ALLOW_ORIGIN = "Access-Control-Allow-Origin";
    public static final java.lang.String ACCESS_CONTROL_EXPOSE_HEADERS = "Access-Control-Expose-Headers";
    public static final java.lang.String ACCESS_CONTROL_MAX_AGE = "Access-Control-Max-Age";
    public static final java.lang.String ACCESS_CONTROL_REQUEST_HEADERS = "Access-Control-Request-Headers";
    public static final java.lang.String ACCESS_CONTROL_REQUEST_METHOD = "Access-Control-Request-Method";
    public static final java.lang.String AGE = "Age";
    public static final java.lang.String ALLOW = "Allow";
    public static final java.lang.String AUTHORIZATION = "Authorization";
    public static final java.lang.String CACHE_CONTROL = "Cache-Control";
    public static final java.lang.String CONNECTION = "Connection";
    public static final java.lang.String CONTENT_DISPOSITION = "Content-Disposition";
    public static final java.lang.String CONTENT_ENCODING = "Content-Encoding";
    public static final java.lang.String CONTENT_LANGUAGE = "Content-Language";
    public static final java.lang.String CONTENT_LENGTH = "Content-Length";
    public static final java.lang.String CONTENT_LOCATION = "Content-Location";
    public static final java.lang.String CONTENT_MD5 = "Content-MD5";
    public static final java.lang.String CONTENT_RANGE = "Content-Range";
    public static final java.lang.String CONTENT_SECURITY_POLICY = "Content-Security-Policy";
    public static final java.lang.String CONTENT_SECURITY_POLICY_REPORT_ONLY = "Content-Security-Policy-Report-Only";
    public static final java.lang.String CONTENT_TYPE = "Content-Type";
    public static final java.lang.String COOKIE = "Cookie";
    public static final java.lang.String DATE = "Date";
    public static final java.lang.String DNT = "DNT";
    public static final java.lang.String EARLY_DATA = "Early-Data";
    public static final java.lang.String ETAG = "ETag";
    public static final java.lang.String EXPECT = "Expect";
    public static final java.lang.String EXPIRES = "Expires";

    @com.google.common.annotations.Beta
    public static final java.lang.String FOLLOW_ONLY_WHEN_PRERENDER_SHOWN = "Follow-Only-When-Prerender-Shown";
    public static final java.lang.String FORWARDED = "Forwarded";
    public static final java.lang.String FROM = "From";
    public static final java.lang.String HOST = "Host";
    public static final java.lang.String HTTP2_SETTINGS = "HTTP2-Settings";
    public static final java.lang.String IF_MATCH = "If-Match";
    public static final java.lang.String IF_MODIFIED_SINCE = "If-Modified-Since";
    public static final java.lang.String IF_NONE_MATCH = "If-None-Match";
    public static final java.lang.String IF_RANGE = "If-Range";
    public static final java.lang.String IF_UNMODIFIED_SINCE = "If-Unmodified-Since";
    public static final java.lang.String LAST_EVENT_ID = "Last-Event-ID";
    public static final java.lang.String LAST_MODIFIED = "Last-Modified";
    public static final java.lang.String LINK = "Link";
    public static final java.lang.String LOCATION = "Location";
    public static final java.lang.String MAX_FORWARDS = "Max-Forwards";
    public static final java.lang.String ORIGIN = "Origin";
    public static final java.lang.String ORIGIN_TRIAL = "Origin-Trial";
    public static final java.lang.String P3P = "P3P";
    public static final java.lang.String PING_FROM = "Ping-From";
    public static final java.lang.String PING_TO = "Ping-To";
    public static final java.lang.String PRAGMA = "Pragma";
    public static final java.lang.String PROXY_AUTHENTICATE = "Proxy-Authenticate";
    public static final java.lang.String PROXY_AUTHORIZATION = "Proxy-Authorization";

    @com.google.common.annotations.Beta
    public static final java.lang.String PUBLIC_KEY_PINS = "Public-Key-Pins";

    @com.google.common.annotations.Beta
    public static final java.lang.String PUBLIC_KEY_PINS_REPORT_ONLY = "Public-Key-Pins-Report-Only";
    public static final java.lang.String RANGE = "Range";
    public static final java.lang.String REFERER = "Referer";
    public static final java.lang.String REFERRER_POLICY = "Referrer-Policy";
    public static final java.lang.String REFRESH = "Refresh";
    public static final java.lang.String REPORT_TO = "Report-To";
    public static final java.lang.String RETRY_AFTER = "Retry-After";
    public static final java.lang.String SEC_FETCH_DEST = "Sec-Fetch-Dest";
    public static final java.lang.String SEC_FETCH_MODE = "Sec-Fetch-Mode";
    public static final java.lang.String SEC_FETCH_SITE = "Sec-Fetch-Site";
    public static final java.lang.String SEC_FETCH_USER = "Sec-Fetch-User";
    public static final java.lang.String SEC_METADATA = "Sec-Metadata";
    public static final java.lang.String SEC_PROVIDED_TOKEN_BINDING_ID = "Sec-Provided-Token-Binding-ID";
    public static final java.lang.String SEC_REFERRED_TOKEN_BINDING_ID = "Sec-Referred-Token-Binding-ID";
    public static final java.lang.String SEC_TOKEN_BINDING = "Sec-Token-Binding";
    public static final java.lang.String SERVER = "Server";
    public static final java.lang.String SERVER_TIMING = "Server-Timing";
    public static final java.lang.String SERVICE_WORKER = "Service-Worker";
    public static final java.lang.String SERVICE_WORKER_ALLOWED = "Service-Worker-Allowed";
    public static final java.lang.String SET_COOKIE = "Set-Cookie";
    public static final java.lang.String SET_COOKIE2 = "Set-Cookie2";

    @com.google.common.annotations.Beta
    public static final java.lang.String SOURCE_MAP = "SourceMap";
    public static final java.lang.String STRICT_TRANSPORT_SECURITY = "Strict-Transport-Security";
    public static final java.lang.String TE = "TE";
    public static final java.lang.String TIMING_ALLOW_ORIGIN = "Timing-Allow-Origin";
    public static final java.lang.String TRAILER = "Trailer";
    public static final java.lang.String TRANSFER_ENCODING = "Transfer-Encoding";
    public static final java.lang.String UPGRADE = "Upgrade";
    public static final java.lang.String USER_AGENT = "User-Agent";
    public static final java.lang.String VARY = "Vary";
    public static final java.lang.String VIA = "Via";
    public static final java.lang.String WARNING = "Warning";
    public static final java.lang.String WWW_AUTHENTICATE = "WWW-Authenticate";
    public static final java.lang.String X_CONTENT_SECURITY_POLICY = "X-Content-Security-Policy";
    public static final java.lang.String X_CONTENT_SECURITY_POLICY_REPORT_ONLY = "X-Content-Security-Policy-Report-Only";
    public static final java.lang.String X_CONTENT_TYPE_OPTIONS = "X-Content-Type-Options";
    public static final java.lang.String X_DNS_PREFETCH_CONTROL = "X-DNS-Prefetch-Control";

    @com.google.common.annotations.Beta
    public static final java.lang.String X_DOWNLOAD_OPTIONS = "X-Download-Options";
    public static final java.lang.String X_DO_NOT_TRACK = "X-Do-Not-Track";
    public static final java.lang.String X_FORWARDED_FOR = "X-Forwarded-For";
    public static final java.lang.String X_FORWARDED_HOST = "X-Forwarded-Host";
    public static final java.lang.String X_FORWARDED_PORT = "X-Forwarded-Port";
    public static final java.lang.String X_FORWARDED_PROTO = "X-Forwarded-Proto";
    public static final java.lang.String X_FRAME_OPTIONS = "X-Frame-Options";
    public static final java.lang.String X_POWERED_BY = "X-Powered-By";
    public static final java.lang.String X_REQUESTED_WITH = "X-Requested-With";
    public static final java.lang.String X_USER_IP = "X-User-IP";
    public static final java.lang.String X_WEBKIT_CSP = "X-WebKit-CSP";
    public static final java.lang.String X_WEBKIT_CSP_REPORT_ONLY = "X-WebKit-CSP-Report-Only";
    public static final java.lang.String X_XSS_PROTECTION = "X-XSS-Protection";

    public static final class ReferrerPolicyValues {
        public static final java.lang.String NO_REFERRER = "no-referrer";
        public static final java.lang.String NO_REFFERER_WHEN_DOWNGRADE = "no-referrer-when-downgrade";
        public static final java.lang.String ORIGIN = "origin";
        public static final java.lang.String ORIGIN_WHEN_CROSS_ORIGIN = "origin-when-cross-origin";
        public static final java.lang.String SAME_ORIGIN = "same-origin";
        public static final java.lang.String STRICT_ORIGIN = "strict-origin";
        public static final java.lang.String STRICT_ORIGIN_WHEN_CROSS_ORIGIN = "strict-origin-when-cross-origin";
        public static final java.lang.String UNSAFE_URL = "unsafe-url";
    }
}
