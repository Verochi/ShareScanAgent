package com.getui.gtc.base.http;

/* loaded from: classes22.dex */
public class MediaType {
    private static final java.lang.String QUOTED = "\"([^\"]*)\"";
    private static final java.lang.String TOKEN = "([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)";
    private final java.lang.String charset;
    private final java.lang.String mediaType;
    private final java.lang.String subtype;
    private final java.lang.String type;
    private static final java.util.regex.Pattern TYPE_SUBTYPE = java.util.regex.Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    private static final java.util.regex.Pattern PARAMETER = java.util.regex.Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    private MediaType(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        this.mediaType = str;
        this.type = str2;
        this.subtype = str3;
        this.charset = str4;
    }

    public static com.getui.gtc.base.http.MediaType get(java.lang.String str) {
        java.util.regex.Matcher matcher = TYPE_SUBTYPE.matcher(str);
        if (!matcher.lookingAt()) {
            throw new java.lang.IllegalArgumentException("No subtype found for: \"" + str + kotlin.text.Typography.quote);
        }
        java.lang.String group = matcher.group(1);
        java.util.Locale locale = java.util.Locale.US;
        java.lang.String lowerCase = group.toLowerCase(locale);
        java.lang.String lowerCase2 = matcher.group(2).toLowerCase(locale);
        java.util.regex.Matcher matcher2 = PARAMETER.matcher(str);
        java.lang.String str2 = null;
        for (int end = matcher.end(); end < str.length(); end = matcher2.end()) {
            matcher2.region(end, str.length());
            if (!matcher2.lookingAt()) {
                throw new java.lang.IllegalArgumentException("Parameter is not formatted correctly: \"" + str.substring(end) + "\" for: \"" + str + kotlin.text.Typography.quote);
            }
            java.lang.String group2 = matcher2.group(1);
            if (group2 != null && group2.equalsIgnoreCase("charset")) {
                java.lang.String group3 = matcher2.group(2);
                if (group3 == null) {
                    group3 = matcher2.group(3);
                } else if (group3.startsWith("'") && group3.endsWith("'") && group3.length() > 2) {
                    group3 = group3.substring(1, group3.length() - 1);
                }
                if (str2 != null && !group3.equalsIgnoreCase(str2)) {
                    throw new java.lang.IllegalArgumentException("Multiple charsets defined: \"" + str2 + "\" and: \"" + group3 + "\" for: \"" + str + kotlin.text.Typography.quote);
                }
                str2 = group3;
            }
        }
        return new com.getui.gtc.base.http.MediaType(str, lowerCase, lowerCase2, str2);
    }

    public static com.getui.gtc.base.http.MediaType parse(java.lang.String str) {
        try {
            return get(str);
        } catch (java.lang.IllegalArgumentException unused) {
            return null;
        }
    }

    public java.nio.charset.Charset charset() {
        return charset(java.nio.charset.Charset.defaultCharset());
    }

    public java.nio.charset.Charset charset(java.nio.charset.Charset charset) {
        try {
            java.lang.String str = this.charset;
            return str != null ? java.nio.charset.Charset.forName(str) : charset;
        } catch (java.lang.IllegalArgumentException unused) {
            return charset;
        }
    }

    public boolean equals(java.lang.Object obj) {
        return (obj instanceof com.getui.gtc.base.http.MediaType) && ((com.getui.gtc.base.http.MediaType) obj).mediaType.equals(this.mediaType);
    }

    public int hashCode() {
        return this.mediaType.hashCode();
    }

    public java.lang.String subtype() {
        return this.subtype;
    }

    public java.lang.String toString() {
        return this.mediaType;
    }

    public java.lang.String type() {
        return this.type;
    }
}
