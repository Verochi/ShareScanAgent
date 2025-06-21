package com.tencent.mm.opensdk.modelmsg;

/* loaded from: classes19.dex */
public class WXMusicObject implements com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject {
    private static final int LENGTH_LIMIT = 10240;
    private static final int LYRIC_LENGTH_LIMIT = 32768;
    private static final java.lang.String TAG = "MicroMsg.SDK.WXMusicObject";
    public java.lang.String musicDataUrl;
    public java.lang.String musicLowBandDataUrl;
    public java.lang.String musicLowBandUrl;
    public java.lang.String musicUrl;
    public java.lang.String songAlbumUrl;
    public java.lang.String songLyric;

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        java.lang.String str;
        java.lang.String str2;
        java.lang.String str3 = this.musicUrl;
        if ((str3 == null || str3.length() == 0) && ((str = this.musicLowBandUrl) == null || str.length() == 0)) {
            str2 = "both arguments are null";
        } else {
            java.lang.String str4 = this.musicUrl;
            if (str4 == null || str4.length() <= 10240) {
                java.lang.String str5 = this.musicLowBandUrl;
                if (str5 == null || str5.length() <= 10240) {
                    java.lang.String str6 = this.songAlbumUrl;
                    if (str6 == null || str6.length() <= 10240) {
                        java.lang.String str7 = this.songLyric;
                        if (str7 == null || str7.length() <= 32768) {
                            return true;
                        }
                        str2 = "checkArgs fail, songLyric is too long";
                    } else {
                        str2 = "checkArgs fail, songAlbumUrl is too long";
                    }
                } else {
                    str2 = "checkArgs fail, musicLowBandUrl is too long";
                }
            } else {
                str2 = "checkArgs fail, musicUrl is too long";
            }
        }
        com.tencent.mm.opensdk.utils.Log.e(TAG, str2);
        return false;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(android.os.Bundle bundle) {
        bundle.putString("_wxmusicobject_musicUrl", this.musicUrl);
        bundle.putString("_wxmusicobject_musicLowBandUrl", this.musicLowBandUrl);
        bundle.putString("_wxmusicobject_musicDataUrl", this.musicDataUrl);
        bundle.putString("_wxmusicobject_musicLowBandDataUrl", this.musicLowBandDataUrl);
        bundle.putString("_wxmusicobject_musicAlbumUrl", this.songAlbumUrl);
        bundle.putString("_wxmusicobject_musicLyric", this.songLyric);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        return 3;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(android.os.Bundle bundle) {
        this.musicUrl = bundle.getString("_wxmusicobject_musicUrl");
        this.musicLowBandUrl = bundle.getString("_wxmusicobject_musicLowBandUrl");
        this.musicDataUrl = bundle.getString("_wxmusicobject_musicDataUrl");
        this.musicLowBandDataUrl = bundle.getString("_wxmusicobject_musicLowBandDataUrl");
        this.songAlbumUrl = bundle.getString("_wxmusicobject_musicAlbumUrl");
        this.songLyric = bundle.getString("_wxmusicobject_musicLyric");
    }
}
