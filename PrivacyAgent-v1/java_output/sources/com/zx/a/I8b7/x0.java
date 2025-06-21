package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class x0 {
    public static final java.util.regex.Pattern c = java.util.regex.Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    public static final java.util.regex.Pattern d = java.util.regex.Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
    public final java.lang.String a;
    public final java.lang.String b;

    public x0(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        this.a = str;
        this.b = str4;
    }

    public static com.zx.a.I8b7.x0 a(java.lang.String str) {
        java.util.regex.Matcher matcher = c.matcher(str);
        if (!matcher.lookingAt()) {
            throw new java.lang.IllegalArgumentException("No subtype found for: \"" + str + kotlin.text.Typography.quote);
        }
        java.lang.String group = matcher.group(1);
        java.util.Locale locale = java.util.Locale.US;
        java.lang.String lowerCase = group.toLowerCase(locale);
        java.lang.String lowerCase2 = matcher.group(2).toLowerCase(locale);
        java.util.regex.Matcher matcher2 = d.matcher(str);
        java.lang.String str2 = null;
        for (int end = matcher.end(); end < str.length(); end = matcher2.end()) {
            matcher2.region(end, str.length());
            if (!matcher2.lookingAt()) {
                java.lang.StringBuilder a = com.zx.a.I8b7.f3.a("Parameter is not formatted correctly: \"");
                a.append(str.substring(end));
                a.append("\" for: \"");
                a.append(str);
                a.append(kotlin.text.Typography.quote);
                throw new java.lang.IllegalArgumentException(a.toString());
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
        return new com.zx.a.I8b7.x0(str, lowerCase, lowerCase2, str2);
    }

    public static com.zx.a.I8b7.x0 b(java.lang.String str) {
        try {
            return a(str);
        } catch (java.lang.IllegalArgumentException unused) {
            return null;
        }
    }

    public java.nio.charset.Charset a() {
        java.nio.charset.Charset charset = java.nio.charset.StandardCharsets.UTF_8;
        try {
            java.lang.String str = this.b;
            return str != null ? java.nio.charset.Charset.forName(str) : charset;
        } catch (java.lang.IllegalArgumentException unused) {
            return charset;
        }
    }

    public boolean equals(java.lang.Object obj) {
        return (obj instanceof com.zx.a.I8b7.x0) && ((com.zx.a.I8b7.x0) obj).a.equals(this.a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public java.lang.String toString() {
        return this.a;
    }
}
