package com.google.common.html;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public final class HtmlEscapers {
    public static final com.google.common.escape.Escaper a = com.google.common.escape.Escapers.builder().addEscape(kotlin.text.Typography.quote, "&quot;").addEscape('\'', "&#39;").addEscape(kotlin.text.Typography.amp, "&amp;").addEscape(kotlin.text.Typography.less, "&lt;").addEscape(kotlin.text.Typography.greater, "&gt;").build();

    public static com.google.common.escape.Escaper htmlEscaper() {
        return a;
    }
}
