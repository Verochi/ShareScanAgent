package com.aliyun.svideo.editor.effects.imv;

/* loaded from: classes12.dex */
public class IMVPreviewDialog extends androidx.fragment.app.DialogFragment {
    private static final java.lang.String KEY_THUMB_URL = "thumb_url";
    private static final java.lang.String KEY_VIDEO_URL = "video_url";
    private android.widget.ImageView mCloseBtn;
    private android.content.Context mContext;
    private com.aliyun.svideo.editor.effects.imv.ViewMediaPlayer mPlayer;
    private java.lang.String mVideoUrl;
    private com.aliyun.svideo.base.widget.SquareFrameLayout mVideoView;
    private android.widget.ImageView thumbView;

    /* renamed from: com.aliyun.svideo.editor.effects.imv.IMVPreviewDialog$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.aliyun.svideo.editor.effects.imv.IMVPreviewDialog.this.dismiss();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    private com.aliyun.svideo.editor.effects.imv.ViewMediaPlayer createPlayer(android.content.Context context, android.net.Uri uri) {
        return new com.aliyun.svideo.editor.effects.imv.ViewMediaPlayer(context, null, uri, this.thumbView);
    }

    private void initView() {
        this.mVideoUrl = getArguments().getString("video_url");
        android.widget.ImageView imageView = new android.widget.ImageView(this.mContext);
        this.thumbView = imageView;
        this.mVideoView.addView(imageView, -1, -1);
        this.thumbView.setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
        new com.aliyun.svideo.common.utils.image.ImageLoaderImpl().loadImage(this.mContext, getArguments().getString(KEY_THUMB_URL, "")).into(this.thumbView);
        startPlayVideo();
    }

    public static com.aliyun.svideo.editor.effects.imv.IMVPreviewDialog newInstance(java.lang.String str, java.lang.String str2) {
        com.aliyun.svideo.editor.effects.imv.IMVPreviewDialog iMVPreviewDialog = new com.aliyun.svideo.editor.effects.imv.IMVPreviewDialog();
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putString("video_url", str);
        bundle.putString(KEY_THUMB_URL, str2);
        iMVPreviewDialog.setArguments(bundle);
        return iMVPreviewDialog;
    }

    private void startPlayVideo() {
        com.aliyun.svideo.editor.effects.imv.ViewMediaPlayer createPlayer = createPlayer(this.mContext, android.net.Uri.parse(this.mVideoUrl));
        this.mPlayer = createPlayer;
        if (createPlayer != null) {
            android.view.View findViewById = this.mVideoView.findViewById(java.lang.Math.abs(this.mVideoUrl.hashCode()));
            if (findViewById != null) {
                this.mVideoView.removeView(findViewById);
            }
            android.view.View showView = this.mPlayer.getShowView();
            if (showView != null) {
                android.view.ViewGroup viewGroup = (android.view.ViewGroup) showView.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(showView);
                }
                this.mVideoView.addView(showView, 0);
                showView.setId(java.lang.Math.abs(this.mVideoUrl.hashCode()));
            }
            this.mPlayer.startVideoPlay();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        setStyle(2, com.aliyun.svideo.editor.R.style.ResourcePreviewStyle);
    }

    @Override // androidx.fragment.app.DialogFragment
    public android.app.Dialog onCreateDialog(android.os.Bundle bundle) {
        android.app.Dialog onCreateDialog = super.onCreateDialog(bundle);
        onCreateDialog.setCanceledOnTouchOutside(true);
        onCreateDialog.setCancelable(true);
        return onCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public android.view.View onCreateView(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, android.os.Bundle bundle) {
        android.view.View inflate = android.view.LayoutInflater.from(getActivity()).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_dialog_imv_preview, viewGroup);
        this.mContext = inflate.getContext();
        this.mVideoView = (com.aliyun.svideo.base.widget.SquareFrameLayout) inflate.findViewById(com.aliyun.svideo.editor.R.id.imv_video_view);
        android.widget.ImageView imageView = (android.widget.ImageView) inflate.findViewById(com.aliyun.svideo.editor.R.id.iv_imv_close_btn);
        this.mCloseBtn = imageView;
        imageView.setOnClickListener(new com.aliyun.svideo.editor.effects.imv.IMVPreviewDialog.AnonymousClass1());
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackOnHiddenChanged(this, z);
    }

    @Override // androidx.fragment.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onPause() {
        super.onPause();
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackFragmentPause(this);
    }

    @Override // androidx.fragment.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onResume() {
        getDialog().getWindow().setLayout(-1, -1);
        initView();
        super.onResume();
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackFragmentResume(this);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onViewCreated(android.view.View view, android.os.Bundle bundle) {
        super.onViewCreated(view, bundle);
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    @Override // androidx.fragment.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z);
    }
}
