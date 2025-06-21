package fm.jiecao.jcvideoplayer_lib;

/* loaded from: classes9.dex */
public interface JCMediaPlayerListener {
    void autoFullscreen(int i);

    boolean backToOtherListener();

    void changeSystemVoice(int i);

    int getScreenType();

    int getState();

    java.lang.String getUrl();

    void goBackThisListener(int i);

    void onAutoCompletion();

    void onBufferingUpdate(int i);

    void onCompletion();

    void onError(int i, int i2);

    void onInfo(int i, int i2);

    void onPrepared();

    void onScrollChange();

    void onSeekComplete();

    void onVideoSizeChanged();
}
