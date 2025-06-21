package androidx.core.net;

/* loaded from: classes.dex */
public final class MailTo {
    private static final java.lang.String BCC = "bcc";
    private static final java.lang.String BODY = "body";
    private static final java.lang.String CC = "cc";
    private static final java.lang.String MAILTO = "mailto";
    public static final java.lang.String MAILTO_SCHEME = "mailto:";
    private static final java.lang.String SUBJECT = "subject";
    private static final java.lang.String TO = "to";
    private java.util.HashMap<java.lang.String, java.lang.String> mHeaders = new java.util.HashMap<>();

    private MailTo() {
    }

    public static boolean isMailTo(@androidx.annotation.Nullable android.net.Uri uri) {
        return uri != null && MAILTO.equals(uri.getScheme());
    }

    public static boolean isMailTo(@androidx.annotation.Nullable java.lang.String str) {
        return str != null && str.startsWith(MAILTO_SCHEME);
    }

    @androidx.annotation.NonNull
    public static androidx.core.net.MailTo parse(@androidx.annotation.NonNull android.net.Uri uri) throws androidx.core.net.ParseException {
        return parse(uri.toString());
    }

    @androidx.annotation.NonNull
    public static androidx.core.net.MailTo parse(@androidx.annotation.NonNull java.lang.String str) throws androidx.core.net.ParseException {
        java.lang.String decode;
        java.lang.String substring;
        androidx.core.util.Preconditions.checkNotNull(str);
        if (!isMailTo(str)) {
            throw new androidx.core.net.ParseException("Not a mailto scheme");
        }
        int indexOf = str.indexOf(35);
        if (indexOf != -1) {
            str = str.substring(0, indexOf);
        }
        int indexOf2 = str.indexOf(63);
        if (indexOf2 == -1) {
            decode = android.net.Uri.decode(str.substring(7));
            substring = null;
        } else {
            decode = android.net.Uri.decode(str.substring(7, indexOf2));
            substring = str.substring(indexOf2 + 1);
        }
        androidx.core.net.MailTo mailTo = new androidx.core.net.MailTo();
        if (substring != null) {
            for (java.lang.String str2 : substring.split("&")) {
                java.lang.String[] split = str2.split(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER, 2);
                if (split.length != 0) {
                    mailTo.mHeaders.put(android.net.Uri.decode(split[0]).toLowerCase(java.util.Locale.ROOT), split.length > 1 ? android.net.Uri.decode(split[1]) : null);
                }
            }
        }
        java.lang.String to = mailTo.getTo();
        if (to != null) {
            decode = decode + ", " + to;
        }
        mailTo.mHeaders.put("to", decode);
        return mailTo;
    }

    @androidx.annotation.Nullable
    public java.lang.String getBcc() {
        return this.mHeaders.get(BCC);
    }

    @androidx.annotation.Nullable
    public java.lang.String getBody() {
        return this.mHeaders.get(BODY);
    }

    @androidx.annotation.Nullable
    public java.lang.String getCc() {
        return this.mHeaders.get("cc");
    }

    @androidx.annotation.Nullable
    public java.util.Map<java.lang.String, java.lang.String> getHeaders() {
        return this.mHeaders;
    }

    @androidx.annotation.Nullable
    public java.lang.String getSubject() {
        return this.mHeaders.get(SUBJECT);
    }

    @androidx.annotation.Nullable
    public java.lang.String getTo() {
        return this.mHeaders.get("to");
    }

    @androidx.annotation.NonNull
    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(MAILTO_SCHEME);
        sb.append('?');
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : this.mHeaders.entrySet()) {
            sb.append(android.net.Uri.encode(entry.getKey()));
            sb.append(com.alipay.sdk.m.n.a.h);
            sb.append(android.net.Uri.encode(entry.getValue()));
            sb.append(kotlin.text.Typography.amp);
        }
        return sb.toString();
    }
}
