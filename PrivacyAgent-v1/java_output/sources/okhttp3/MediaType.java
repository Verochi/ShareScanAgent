package okhttp3;

/* loaded from: classes23.dex */
public final class MediaType {
    public static final java.util.regex.Pattern e = java.util.regex.Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    public static final java.util.regex.Pattern f = java.util.regex.Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
    public final java.lang.String a;
    public final java.lang.String b;
    public final java.lang.String c;

    @javax.annotation.Nullable
    public final java.lang.String d;

    public MediaType(java.lang.String str, java.lang.String str2, java.lang.String str3, @javax.annotation.Nullable java.lang.String str4) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
    }

    public static okhttp3.MediaType get(java.lang.String str) {
        java.util.regex.Matcher matcher = e.matcher(str);
        if (!matcher.lookingAt()) {
            throw new java.lang.IllegalArgumentException("No subtype found for: \"" + str + kotlin.text.Typography.quote);
        }
        java.lang.String group = matcher.group(1);
        java.util.Locale locale = java.util.Locale.US;
        java.lang.String lowerCase = group.toLowerCase(locale);
        java.lang.String lowerCase2 = matcher.group(2).toLowerCase(locale);
        java.util.regex.Matcher matcher2 = f.matcher(str);
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
        return new okhttp3.MediaType(str, lowerCase, lowerCase2, str2);
    }

    @javax.annotation.Nullable
    public static okhttp3.MediaType parse(java.lang.String str) {
        try {
            return get(str);
        } catch (java.lang.IllegalArgumentException unused) {
            return null;
        }
    }

    @javax.annotation.Nullable
    public java.nio.charset.Charset charset() {
        return charset(null);
    }

    @javax.annotation.Nullable
    public java.nio.charset.Charset charset(@javax.annotation.Nullable java.nio.charset.Charset charset) {
        try {
            java.lang.String str = this.d;
            return str != null ? java.nio.charset.Charset.forName(str) : charset;
        } catch (java.lang.IllegalArgumentException unused) {
            return charset;
        }
    }

    public boolean equals(@javax.annotation.Nullable java.lang.Object obj) {
        return (obj instanceof okhttp3.MediaType) && ((okhttp3.MediaType) obj).a.equals(this.a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public java.lang.String subtype() {
        return this.c;
    }

    public java.lang.String toString() {
        return this.a;
    }

    public java.lang.String type() {
        return this.b;
    }
}
