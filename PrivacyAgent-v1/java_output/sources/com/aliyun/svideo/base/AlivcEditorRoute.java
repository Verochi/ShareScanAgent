package com.aliyun.svideo.base;

/* loaded from: classes.dex */
public class AlivcEditorRoute {
    public static final java.lang.String KEY_INTENT_ISOPENCROP = "key_intent_isopencrop";
    public static final java.lang.String KEY_INTENT_MEDIA_INFO = "key_media_info";
    public static final int KEY_REQUEST_EDITOR_CODE = 10001;

    public static void startEditorActivity(android.app.Activity activity, com.aliyun.svideo.base.AlivcSvideoEditParam alivcSvideoEditParam, java.util.ArrayList<com.aliyun.svideo.media.MediaInfo> arrayList) {
        android.content.Intent intent = new android.content.Intent();
        intent.setClassName(activity, "com.aliyun.svideo.editor.editor.EditorActivity");
        alivcSvideoEditParam.setMediaInfo(arrayList.get(0));
        intent.putExtra("video_param", alivcSvideoEditParam.generateVideoParam());
        intent.putParcelableArrayListExtra(KEY_INTENT_MEDIA_INFO, arrayList);
        intent.putExtra("hasTailAnimation", alivcSvideoEditParam.isHasTailAnimation());
        intent.putExtra(com.aliyun.svideo.base.AlivcSvideoEditParam.INTENT_PARAM_KEY_ENTRANCE, alivcSvideoEditParam.getEntrance());
        activity.startActivity(intent);
    }

    public static void startMediaActivity(android.app.Activity activity, com.aliyun.svideo.base.AlivcSvideoEditParam alivcSvideoEditParam) {
        android.content.Intent intent = new android.content.Intent();
        intent.setClassName(activity, "com.aliyun.svideo.media.MediaActivity");
        boolean isOpenCrop = alivcSvideoEditParam.isOpenCrop();
        intent.putExtra(KEY_INTENT_ISOPENCROP, isOpenCrop);
        if (isOpenCrop) {
            intent.putExtra("video_framerate", alivcSvideoEditParam.getFrameRate());
            intent.putExtra("video_gop", alivcSvideoEditParam.getGop());
            intent.putExtra("video_ratio", alivcSvideoEditParam.getRatio());
            intent.putExtra("video_quality", alivcSvideoEditParam.getVideoQuality());
            intent.putExtra(com.aliyun.svideo.base.AlivcSvideoEditParam.VIDEO_RESOLUTION, alivcSvideoEditParam.getResolutionMode());
            intent.putExtra("crop_mode", alivcSvideoEditParam.getCropMode());
            intent.putExtra(com.aliyun.svideo.base.AlivcSvideoEditParam.TAIL_ANIMATION, alivcSvideoEditParam.isHasTailAnimation());
            intent.putExtra(com.aliyun.svideo.base.AlivcSvideoEditParam.INTENT_PARAM_KEY_ENTRANCE, "svideo");
        }
        activity.startActivityForResult(intent, 10001);
    }
}
