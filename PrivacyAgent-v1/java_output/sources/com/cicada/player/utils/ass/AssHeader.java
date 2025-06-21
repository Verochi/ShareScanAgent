package com.cicada.player.utils.ass;

/* loaded from: classes22.dex */
public class AssHeader {
    public java.lang.String mEventFormat;
    public java.lang.String mStyleFormat;
    public java.util.Map<java.lang.String, com.cicada.player.utils.ass.AssStyle> mStyles = null;
    public com.cicada.player.utils.ass.AssHeader.SubtitleType mType = com.cicada.player.utils.ass.AssHeader.SubtitleType.SubtitleTypeUnknown;
    public int mPlayResX = 0;
    public int mPlayResY = 0;
    public double mTimer = 0.0d;
    public int mWrapStyle = 0;
    public int mScaledBorderAndShadow = 0;

    public enum SubtitleType {
        SubtitleTypeUnknown,
        SubtitleTypeAss,
        SubtitleTypeSsa
    }

    private java.lang.Object getStyles() {
        return this.mStyles;
    }

    private int getType() {
        com.cicada.player.utils.ass.AssHeader.SubtitleType subtitleType = this.mType;
        if (subtitleType == com.cicada.player.utils.ass.AssHeader.SubtitleType.SubtitleTypeUnknown) {
            return 0;
        }
        if (subtitleType == com.cicada.player.utils.ass.AssHeader.SubtitleType.SubtitleTypeAss) {
            return 1;
        }
        return subtitleType == com.cicada.player.utils.ass.AssHeader.SubtitleType.SubtitleTypeSsa ? 2 : 0;
    }

    private void setStyles(java.lang.Object obj) {
        this.mStyles = (java.util.Map) obj;
    }

    private void setType(int i) {
        com.cicada.player.utils.ass.AssHeader.SubtitleType subtitleType;
        if (i == 0) {
            subtitleType = com.cicada.player.utils.ass.AssHeader.SubtitleType.SubtitleTypeUnknown;
        } else if (i == 1) {
            subtitleType = com.cicada.player.utils.ass.AssHeader.SubtitleType.SubtitleTypeAss;
        } else if (i != 2) {
            return;
        } else {
            subtitleType = com.cicada.player.utils.ass.AssHeader.SubtitleType.SubtitleTypeSsa;
        }
        this.mType = subtitleType;
    }
}
