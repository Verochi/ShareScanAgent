package com.alimm.tanx.core.constant;

/* loaded from: classes.dex */
public class TanxAdType implements com.alimm.tanx.core.utils.NotConfused {
    public static final int FEED = 2;
    public static final java.lang.String FEED_STRING = "flow";
    public static final int REWARD = 4;
    public static final java.lang.String REWARD_STRING = "reward";
    public static final int REWARD_VIDEO = 3;
    public static final java.lang.String REWARD_VIDEO_STRING = "rewardVideo";
    public static final int SPLASH = 1;
    public static final java.lang.String SPLASH_STRING = "screen";
    public static final int TABLE_SCREEN = 5;
    public static final java.lang.String TABLE_SCREEN_STRING = "tableScreen";

    public static java.lang.String getAdTypeStr(int i) {
        if (i == 1) {
            return "screen";
        }
        if (i == 2) {
            return FEED_STRING;
        }
        if (i == 3) {
            return "rewardVideo";
        }
        if (i == 4) {
            return "reward";
        }
        if (i != 5) {
            return null;
        }
        return TABLE_SCREEN_STRING;
    }
}
