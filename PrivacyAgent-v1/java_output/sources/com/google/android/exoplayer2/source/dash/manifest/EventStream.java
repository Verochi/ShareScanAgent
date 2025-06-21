package com.google.android.exoplayer2.source.dash.manifest;

/* loaded from: classes22.dex */
public final class EventStream {
    public final com.google.android.exoplayer2.metadata.emsg.EventMessage[] events;
    public final long[] presentationTimesUs;
    public final java.lang.String schemeIdUri;
    public final long timescale;
    public final java.lang.String value;

    public EventStream(java.lang.String str, java.lang.String str2, long j, long[] jArr, com.google.android.exoplayer2.metadata.emsg.EventMessage[] eventMessageArr) {
        this.schemeIdUri = str;
        this.value = str2;
        this.timescale = j;
        this.presentationTimesUs = jArr;
        this.events = eventMessageArr;
    }

    public java.lang.String id() {
        java.lang.String str = this.schemeIdUri;
        java.lang.String str2 = this.value;
        java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(str).length() + 1 + java.lang.String.valueOf(str2).length());
        sb.append(str);
        sb.append(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
        sb.append(str2);
        return sb.toString();
    }
}
