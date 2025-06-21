package com.google.thirdparty.publicsuffix;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
final class TrieParser {
    public static final com.google.common.base.Joiner a = com.google.common.base.Joiner.on("");

    public static int a(java.util.List<java.lang.CharSequence> list, java.lang.CharSequence charSequence, int i, com.google.common.collect.ImmutableMap.Builder<java.lang.String, com.google.thirdparty.publicsuffix.PublicSuffixType> builder) {
        int length = charSequence.length();
        int i2 = i;
        char c = 0;
        while (i2 < length && (c = charSequence.charAt(i2)) != '&' && c != '?' && c != '!' && c != ':' && c != ',') {
            i2++;
        }
        list.add(0, c(charSequence.subSequence(i, i2)));
        if (c == '!' || c == '?' || c == ':' || c == ',') {
            java.lang.String join = a.join(list);
            if (join.length() > 0) {
                builder.put(join, com.google.thirdparty.publicsuffix.PublicSuffixType.fromCode(c));
            }
        }
        int i3 = i2 + 1;
        if (c != '?' && c != ',') {
            while (i3 < length) {
                i3 += a(list, charSequence, i3, builder);
                if (charSequence.charAt(i3) == '?' || charSequence.charAt(i3) == ',') {
                    i3++;
                    break;
                }
            }
        }
        list.remove(0);
        return i3 - i;
    }

    public static com.google.common.collect.ImmutableMap<java.lang.String, com.google.thirdparty.publicsuffix.PublicSuffixType> b(java.lang.CharSequence charSequence) {
        com.google.common.collect.ImmutableMap.Builder builder = com.google.common.collect.ImmutableMap.builder();
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            i += a(com.google.common.collect.Lists.newLinkedList(), charSequence, i, builder);
        }
        return builder.build();
    }

    public static java.lang.CharSequence c(java.lang.CharSequence charSequence) {
        return new java.lang.StringBuilder(charSequence).reverse();
    }
}
