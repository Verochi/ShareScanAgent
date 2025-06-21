package com.google.common.net;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public final class UrlEscapers {
    public static final com.google.common.escape.Escaper a = new com.google.common.net.PercentEscaper("-_.*", true);
    public static final com.google.common.escape.Escaper b = new com.google.common.net.PercentEscaper("-._~!$'()*,;&=@:+", false);
    public static final com.google.common.escape.Escaper c = new com.google.common.net.PercentEscaper("-._~!$'()*,;&=@:+/?", false);

    public static com.google.common.escape.Escaper urlFormParameterEscaper() {
        return a;
    }

    public static com.google.common.escape.Escaper urlFragmentEscaper() {
        return c;
    }

    public static com.google.common.escape.Escaper urlPathSegmentEscaper() {
        return b;
    }
}
