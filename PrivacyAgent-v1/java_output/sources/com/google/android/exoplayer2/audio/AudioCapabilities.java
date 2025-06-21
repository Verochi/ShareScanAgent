package com.google.android.exoplayer2.audio;

/* loaded from: classes22.dex */
public final class AudioCapabilities {
    public static final com.google.android.exoplayer2.audio.AudioCapabilities DEFAULT_AUDIO_CAPABILITIES = new com.google.android.exoplayer2.audio.AudioCapabilities(new int[]{2}, 8);
    public static final com.google.android.exoplayer2.audio.AudioCapabilities c = new com.google.android.exoplayer2.audio.AudioCapabilities(new int[]{2, 5, 6}, 8);
    public final int[] a;
    public final int b;

    public AudioCapabilities(@androidx.annotation.Nullable int[] iArr, int i) {
        if (iArr != null) {
            int[] copyOf = java.util.Arrays.copyOf(iArr, iArr.length);
            this.a = copyOf;
            java.util.Arrays.sort(copyOf);
        } else {
            this.a = new int[0];
        }
        this.b = i;
    }

    public static boolean a() {
        return com.google.android.exoplayer2.util.Util.SDK_INT >= 17 && "Amazon".equals(com.google.android.exoplayer2.util.Util.MANUFACTURER);
    }

    @android.annotation.SuppressLint({"InlinedApi"})
    public static com.google.android.exoplayer2.audio.AudioCapabilities b(android.content.Context context, @androidx.annotation.Nullable android.content.Intent intent) {
        return (a() && android.provider.Settings.Global.getInt(context.getContentResolver(), "external_surround_sound_enabled", 0) == 1) ? c : (intent == null || intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) == 0) ? DEFAULT_AUDIO_CAPABILITIES : new com.google.android.exoplayer2.audio.AudioCapabilities(intent.getIntArrayExtra("android.media.extra.ENCODINGS"), intent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 8));
    }

    @androidx.annotation.Nullable
    public static android.net.Uri c() {
        if (a()) {
            return android.provider.Settings.Global.getUriFor("external_surround_sound_enabled");
        }
        return null;
    }

    public static com.google.android.exoplayer2.audio.AudioCapabilities getCapabilities(android.content.Context context) {
        return b(context, context.registerReceiver(null, new android.content.IntentFilter("android.media.action.HDMI_AUDIO_PLUG")));
    }

    public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof com.google.android.exoplayer2.audio.AudioCapabilities)) {
            return false;
        }
        com.google.android.exoplayer2.audio.AudioCapabilities audioCapabilities = (com.google.android.exoplayer2.audio.AudioCapabilities) obj;
        return java.util.Arrays.equals(this.a, audioCapabilities.a) && this.b == audioCapabilities.b;
    }

    public int getMaxChannelCount() {
        return this.b;
    }

    public int hashCode() {
        return this.b + (java.util.Arrays.hashCode(this.a) * 31);
    }

    public boolean supportsEncoding(int i) {
        return java.util.Arrays.binarySearch(this.a, i) >= 0;
    }

    public java.lang.String toString() {
        int i = this.b;
        java.lang.String arrays = java.util.Arrays.toString(this.a);
        java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(arrays).length() + 67);
        sb.append("AudioCapabilities[maxChannelCount=");
        sb.append(i);
        sb.append(", supportedEncodings=");
        sb.append(arrays);
        sb.append("]");
        return sb.toString();
    }
}
