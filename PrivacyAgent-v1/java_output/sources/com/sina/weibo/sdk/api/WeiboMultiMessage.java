package com.sina.weibo.sdk.api;

/* loaded from: classes19.dex */
public class WeiboMultiMessage implements java.io.Serializable {
    private static final long serialVersionUID = -3336491646257094828L;
    public com.sina.weibo.sdk.api.ImageObject imageObject;
    public com.sina.weibo.sdk.api.MediaObject mediaObject;
    public com.sina.weibo.sdk.api.MultiImageObject multiImageObject;
    public com.sina.weibo.sdk.api.TextObject textObject;
    public com.sina.weibo.sdk.api.VideoSourceObject videoSourceObject;

    public void readFromBundle(android.os.Bundle bundle) {
        this.mediaObject = (com.sina.weibo.sdk.api.MediaObject) bundle.getParcelable("_weibo_message_media");
        this.textObject = (com.sina.weibo.sdk.api.TextObject) bundle.getParcelable("_weibo_message_text");
        this.imageObject = (com.sina.weibo.sdk.api.ImageObject) bundle.getParcelable("_weibo_message_image");
        this.multiImageObject = (com.sina.weibo.sdk.api.MultiImageObject) bundle.getParcelable("_weibo_message_multi_image");
        this.videoSourceObject = (com.sina.weibo.sdk.api.VideoSourceObject) bundle.getParcelable("_weibo_message_video_source");
    }

    public android.os.Bundle writeToBundle(android.os.Bundle bundle) {
        com.sina.weibo.sdk.api.MediaObject mediaObject = this.mediaObject;
        if (mediaObject != null) {
            bundle.putParcelable("_weibo_message_media", mediaObject);
        } else {
            bundle.putParcelable("_weibo_message_media", null);
        }
        com.sina.weibo.sdk.api.TextObject textObject = this.textObject;
        if (textObject != null) {
            bundle.putParcelable("_weibo_message_text", textObject);
        } else {
            bundle.putParcelable("_weibo_message_text", null);
        }
        com.sina.weibo.sdk.api.ImageObject imageObject = this.imageObject;
        if (imageObject != null) {
            bundle.putParcelable("_weibo_message_image", imageObject);
        } else {
            bundle.putParcelable("_weibo_message_image", null);
        }
        com.sina.weibo.sdk.api.MultiImageObject multiImageObject = this.multiImageObject;
        if (multiImageObject != null) {
            bundle.putParcelable("_weibo_message_multi_image", multiImageObject);
        } else {
            bundle.putParcelable("_weibo_message_multi_image", null);
        }
        com.sina.weibo.sdk.api.VideoSourceObject videoSourceObject = this.videoSourceObject;
        if (videoSourceObject != null) {
            bundle.putParcelable("_weibo_message_video_source", videoSourceObject);
        } else {
            bundle.putParcelable("_weibo_message_video_source", null);
        }
        return bundle;
    }
}
