package com.meizu.cloud.pushsdk.c.c;

/* loaded from: classes23.dex */
public class g {
    private static final java.util.regex.Pattern a = java.util.regex.Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    private static final java.util.regex.Pattern b = java.util.regex.Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
    private final java.lang.String c;
    private final java.lang.String d;
    private final java.lang.String e;
    private final java.lang.String f;

    private g(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = str4;
    }

    public static com.meizu.cloud.pushsdk.c.c.g a(java.lang.String str) {
        java.util.regex.Matcher matcher = a.matcher(str);
        if (!matcher.lookingAt()) {
            return null;
        }
        java.lang.String group = matcher.group(1);
        java.util.Locale locale = java.util.Locale.US;
        java.lang.String lowerCase = group.toLowerCase(locale);
        java.lang.String lowerCase2 = matcher.group(2).toLowerCase(locale);
        java.util.regex.Matcher matcher2 = b.matcher(str);
        java.lang.String str2 = null;
        for (int end = matcher.end(); end < str.length(); end = matcher2.end()) {
            matcher2.region(end, str.length());
            if (!matcher2.lookingAt()) {
                return null;
            }
            if ("charset".equalsIgnoreCase(matcher2.group(1))) {
                java.lang.String group2 = matcher2.group(2) != null ? matcher2.group(2) : matcher2.group(3);
                if (str2 != null && !group2.equalsIgnoreCase(str2)) {
                    throw new java.lang.IllegalArgumentException("Multiple different charsets: " + str);
                }
                str2 = group2;
            }
        }
        return new com.meizu.cloud.pushsdk.c.c.g(str, lowerCase, lowerCase2, str2);
    }

    public java.lang.String a() {
        return this.d;
    }

    public java.nio.charset.Charset b() {
        java.lang.String str = this.f;
        if (str != null) {
            return java.nio.charset.Charset.forName(str);
        }
        return null;
    }

    public boolean equals(java.lang.Object obj) {
        return (obj instanceof com.meizu.cloud.pushsdk.c.c.g) && ((com.meizu.cloud.pushsdk.c.c.g) obj).c.equals(this.c);
    }

    public int hashCode() {
        return this.c.hashCode();
    }

    public java.lang.String toString() {
        return this.c;
    }
}
