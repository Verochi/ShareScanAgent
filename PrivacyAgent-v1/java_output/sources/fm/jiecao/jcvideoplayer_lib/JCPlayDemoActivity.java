package fm.jiecao.jcvideoplayer_lib;

/* loaded from: classes30.dex */
public class JCPlayDemoActivity extends androidx.fragment.app.FragmentActivity {
    public fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard n;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@androidx.annotation.Nullable android.os.Bundle bundle) {
        super.onCreate(bundle);
        setContentView(fm.jiecao.jcvideoplayer_lib.R.layout.video_main_activity);
        fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard jCVideoPlayerStandard = (fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard) findViewById(fm.jiecao.jcvideoplayer_lib.R.id.jc_video);
        this.n = jCVideoPlayerStandard;
        jCVideoPlayerStandard.setIsNeedFullButton(false).setIsNeedVoice(false).setIsNeedTime(false).setIsNeedShowView(false).setIsNeedCyclePlay(true).setIsNeedScreenFull(false).setIsNeedMute(false).setUp("http://jzvd.nathen.cn/342a5f7ef6124a4a8faf00e738b8bee4/cf6d9db0bd4d41f59d09ea0a81e918fd-5287d2089db37e62345123a1be272f8b.mp4", 1, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_QQ);
        this.n.changeVideoState();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        fm.jiecao.jcvideoplayer_lib.JCVideoPlayer.releaseAllVideos();
    }
}
