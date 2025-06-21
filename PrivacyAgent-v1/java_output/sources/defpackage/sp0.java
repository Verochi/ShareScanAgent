package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class sp0 {
    static {
        com.google.common.base.Predicate<java.lang.String> predicate = com.google.android.exoplayer2.upstream.HttpDataSource.REJECT_PAYWALL_TYPES;
    }

    public static /* synthetic */ boolean a(java.lang.String str) {
        java.lang.String lowerInvariant = com.google.android.exoplayer2.util.Util.toLowerInvariant(str);
        return (android.text.TextUtils.isEmpty(lowerInvariant) || (lowerInvariant.contains("text") && !lowerInvariant.contains("text/vtt")) || lowerInvariant.contains(com.baidu.mobads.sdk.internal.a.f) || lowerInvariant.contains(com.aliyun.auth.common.AliyunVodHttpCommon.Format.FORMAT_XML)) ? false : true;
    }
}
