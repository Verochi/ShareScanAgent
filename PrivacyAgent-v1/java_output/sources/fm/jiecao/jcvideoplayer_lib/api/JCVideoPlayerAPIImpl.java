package fm.jiecao.jcvideoplayer_lib.api;

@kotlin.Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lfm/jiecao/jcvideoplayer_lib/api/JCVideoPlayerAPIImpl;", "Lcom/moji/iapi/jc/IJCVideoPlayerAPI;", "()V", "backPress", "", "goPlayFullVideo", "", "releaseAllVideos", "MJVideoModule_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class JCVideoPlayerAPIImpl implements com.moji.iapi.jc.IJCVideoPlayerAPI {
    public boolean backPress() {
        return fm.jiecao.jcvideoplayer_lib.JCVideoPlayer.backPress();
    }

    public void goPlayFullVideo() {
        fm.jiecao.jcvideoplayer_lib.JCVideoPlayer.goPlayFullVideo();
    }

    public void releaseAllVideos() {
        fm.jiecao.jcvideoplayer_lib.JCVideoPlayer.releaseAllVideos();
    }
}
