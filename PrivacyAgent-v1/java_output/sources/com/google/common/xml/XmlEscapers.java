package com.google.common.xml;

@com.google.common.annotations.Beta
@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public class XmlEscapers {
    public static final com.google.common.escape.Escaper a;
    public static final com.google.common.escape.Escaper b;
    public static final com.google.common.escape.Escaper c;

    static {
        com.google.common.escape.Escapers.Builder builder = com.google.common.escape.Escapers.builder();
        builder.setSafeRange((char) 0, (char) 65533);
        builder.setUnsafeReplacement("�");
        for (char c2 = 0; c2 <= 31; c2 = (char) (c2 + 1)) {
            if (c2 != '\t' && c2 != '\n' && c2 != '\r') {
                builder.addEscape(c2, "�");
            }
        }
        builder.addEscape(kotlin.text.Typography.amp, "&amp;");
        builder.addEscape(kotlin.text.Typography.less, "&lt;");
        builder.addEscape(kotlin.text.Typography.greater, "&gt;");
        b = builder.build();
        builder.addEscape('\'', "&apos;");
        builder.addEscape(kotlin.text.Typography.quote, "&quot;");
        a = builder.build();
        builder.addEscape('\t', "&#x9;");
        builder.addEscape('\n', "&#xA;");
        builder.addEscape('\r', "&#xD;");
        c = builder.build();
    }

    public static com.google.common.escape.Escaper xmlAttributeEscaper() {
        return c;
    }

    public static com.google.common.escape.Escaper xmlContentEscaper() {
        return b;
    }
}
