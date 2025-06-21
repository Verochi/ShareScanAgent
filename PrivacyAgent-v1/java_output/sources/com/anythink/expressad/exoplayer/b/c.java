package com.anythink.expressad.exoplayer.b;

@android.annotation.TargetApi(21)
/* loaded from: classes12.dex */
public final class c {
    public static final com.anythink.expressad.exoplayer.b.c a = new com.anythink.expressad.exoplayer.b.c(new int[]{2}, 2);
    private final int[] b;
    private final int c;

    private c(int[] iArr, int i) {
        if (iArr != null) {
            int[] copyOf = java.util.Arrays.copyOf(iArr, iArr.length);
            this.b = copyOf;
            java.util.Arrays.sort(copyOf);
        } else {
            this.b = new int[0];
        }
        this.c = i;
    }

    private int a() {
        return this.c;
    }

    public static com.anythink.expressad.exoplayer.b.c a(android.content.Context context) {
        return a(context.registerReceiver(null, new android.content.IntentFilter("android.media.action.HDMI_AUDIO_PLUG")));
    }

    @android.annotation.SuppressLint({"InlinedApi"})
    public static com.anythink.expressad.exoplayer.b.c a(android.content.Intent intent) {
        return (intent == null || intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) == 0) ? a : new com.anythink.expressad.exoplayer.b.c(intent.getIntArrayExtra("android.media.extra.ENCODINGS"), intent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 0));
    }

    public final boolean a(int i) {
        return java.util.Arrays.binarySearch(this.b, i) >= 0;
    }

    public final boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof com.anythink.expressad.exoplayer.b.c)) {
            return false;
        }
        com.anythink.expressad.exoplayer.b.c cVar = (com.anythink.expressad.exoplayer.b.c) obj;
        return java.util.Arrays.equals(this.b, cVar.b) && this.c == cVar.c;
    }

    public final int hashCode() {
        return this.c + (java.util.Arrays.hashCode(this.b) * 31);
    }

    public final java.lang.String toString() {
        return "AudioCapabilities[maxChannelCount=" + this.c + ", supportedEncodings=" + java.util.Arrays.toString(this.b) + "]";
    }
}
