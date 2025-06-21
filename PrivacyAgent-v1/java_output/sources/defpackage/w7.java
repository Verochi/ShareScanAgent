package defpackage;

/* loaded from: classes22.dex */
public final /* synthetic */ class w7 {
    public static java.util.List a(com.google.android.exoplayer2.source.ads.AdsLoader.AdViewProvider adViewProvider) {
        com.google.common.collect.ImmutableList.Builder builder = new com.google.common.collect.ImmutableList.Builder();
        for (android.view.View view : adViewProvider.getAdOverlayViews()) {
            builder.add((com.google.common.collect.ImmutableList.Builder) new com.google.android.exoplayer2.source.ads.AdsLoader.OverlayInfo(view, 0));
        }
        return builder.build();
    }

    @java.lang.Deprecated
    public static android.view.View[] b(com.google.android.exoplayer2.source.ads.AdsLoader.AdViewProvider adViewProvider) {
        return new android.view.View[0];
    }
}
