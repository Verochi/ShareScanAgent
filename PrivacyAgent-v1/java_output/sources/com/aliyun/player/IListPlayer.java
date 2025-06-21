package com.aliyun.player;

/* loaded from: classes.dex */
public interface IListPlayer extends com.aliyun.player.IPlayer {

    public enum MultiBitratesMode {
        MultiBitratesMode_Default(0),
        MultiBitratesMode_FCPrio(1),
        MultiBitratesMode_FC_AND_SMOOTH(2),
        MultiBitratesMode_SmoothPrio(3);

        private int mValue;

        MultiBitratesMode(int i) {
            this.mValue = i;
        }

        public int getValue() {
            return this.mValue;
        }
    }

    public enum SceneType {
        SCENE_NONE(-1),
        SCENE_VERY_SHORT(0),
        SCENE_SHORT(1),
        SCENE_MIDDLE(2),
        SCENE_LONG(3);

        private int mValue;

        SceneType(int i) {
            this.mValue = i;
        }

        public int getValue() {
            return this.mValue;
        }
    }

    public enum StrategyType {
        STRATEGY_DYNAMIC_PRELOAD_DURATION(1);

        private int mValue;

        StrategyType(int i) {
            this.mValue = i;
        }

        public int getValue() {
            return this.mValue;
        }
    }

    com.aliyun.player.IListPlayer.MultiBitratesMode GetMultiBitratesMode();

    void SetMultiBitratesMode(com.aliyun.player.IListPlayer.MultiBitratesMode multiBitratesMode);

    void clear();

    void enablePreloadStrategy(com.aliyun.player.IListPlayer.StrategyType strategyType, boolean z);

    java.lang.String getCurrentUid();

    int getMaxPreloadMemorySizeMB();

    void removeSource(java.lang.String str);

    void setMaxPreloadMemorySizeMB(int i);

    void setPreloadCount(int i);

    void setPreloadCount(int i, int i2);

    void setPreloadScene(com.aliyun.player.IListPlayer.SceneType sceneType);

    void setPreloadStrategy(com.aliyun.player.IListPlayer.StrategyType strategyType, java.lang.String str);
}
