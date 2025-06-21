package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public class r implements com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer {
    private static final java.lang.String a = "vstart";
    private static final java.lang.String b = "vrepeatedplay";
    private static final java.lang.String c = "vclose";
    private static final java.lang.String d = "vreadyplay";
    private static final java.lang.String e = "vplayfail";
    private static final java.lang.String f = "vmute";
    private static final java.lang.String g = "vfrozen";
    private static final java.lang.String h = "vshow";
    private static final java.lang.String i = "curTimeSec";
    private static final java.lang.String j = "startTimeSec";
    private static final java.lang.String k = "autoPlay";
    private static final java.lang.String l = "reasonValue";
    private final com.baidu.mobads.sdk.internal.de m;
    private final com.baidu.mobads.sdk.internal.a n;
    private boolean o = false;
    private int p = 0;

    public r(com.baidu.mobads.sdk.internal.de deVar, com.baidu.mobads.sdk.internal.a aVar) {
        this.m = deVar;
        this.n = aVar;
    }

    private org.json.JSONObject a(int i2, int i3, boolean z, int i4) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put(j, i2 / 1000);
            jSONObject.put(i, i3 / 1000);
            jSONObject.put("autoPlay", z);
            jSONObject.put(l, i4);
        } catch (java.lang.Throwable th) {
            com.baidu.mobads.sdk.internal.bt.a().d(th.getMessage());
        }
        return jSONObject;
    }

    private void a(java.lang.String str, org.json.JSONObject jSONObject) {
        com.baidu.mobads.sdk.internal.a aVar;
        org.json.JSONObject U;
        if (this.m == null || (aVar = this.n) == null || (U = aVar.U()) == null) {
            return;
        }
        try {
            U.put("msg", "sendVideoThirdLog");
            U.put("trackType", str);
            U.put("trackInfo", jSONObject);
            this.m.a(U);
        } catch (java.lang.Throwable th) {
            com.baidu.mobads.sdk.internal.bt.a().d(th.getMessage());
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public java.lang.String getVideoUrl() {
        com.baidu.mobads.sdk.internal.a aVar = this.n;
        if (aVar != null) {
            return aVar.n();
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportPlayError(int i2) {
        a(e, a(this.p, i2, this.o, 0));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportPlayFrozen(int i2) {
        a(g, a(this.p, i2, this.o, 0));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportPlayerReady() {
        a(d, a(0, 0, false, 0));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoMuteChange(int i2, boolean z) {
        a(f, a(this.p, i2, this.o, z ? 2 : 1));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoPause(int i2, com.baidu.mobads.sdk.api.NativeResponse.VideoReason videoReason) {
        a(c, a(this.p, i2, this.o, videoReason.getCode()));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoReplay() {
        this.p = 0;
        a(b, a(0, 0, this.o, 0));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoResume(int i2) {
        this.p = i2;
        a(a, a(i2, i2, this.o, 0));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoShow() {
        a(h, a(0, 0, false, 7));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoStart(boolean z) {
        this.p = 0;
        this.o = z;
        a(a, a(0, 0, z, 0));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoStop(int i2, com.baidu.mobads.sdk.api.NativeResponse.VideoReason videoReason) {
        a(c, a(this.p, i2, this.o, videoReason.getCode()));
    }
}
