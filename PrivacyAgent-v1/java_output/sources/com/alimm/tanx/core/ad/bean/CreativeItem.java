package com.alimm.tanx.core.ad.bean;

/* loaded from: classes.dex */
public class CreativeItem extends com.alimm.tanx.core.ad.bean.BaseBean implements com.alimm.tanx.core.ad.listener.bean.IMaterialBean {

    @com.alibaba.fastjson.annotation.JSONField(name = "action_text")
    private java.lang.String actionText;

    @com.alibaba.fastjson.annotation.JSONField(name = com.anythink.expressad.foundation.d.c.a.h)
    private java.lang.String advLogo;

    @com.alibaba.fastjson.annotation.JSONField(name = com.anythink.expressad.foundation.d.c.a.g)
    private java.lang.String advName;
    private java.lang.String description;

    @com.alibaba.fastjson.annotation.JSONField(name = "img_url_height")
    private java.lang.String imageHeight;

    @com.alibaba.fastjson.annotation.JSONField(name = "img_url_md5")
    private java.lang.String imageMd5;

    @com.alibaba.fastjson.annotation.JSONField(name = "img_size")
    private java.lang.String imageSize;

    @com.alibaba.fastjson.annotation.JSONField(name = "img_url")
    private java.lang.String imageUrl;

    @com.alibaba.fastjson.annotation.JSONField(name = "img_url_width")
    private java.lang.String imageWidth;

    @com.alibaba.fastjson.annotation.JSONField(name = "img_height")
    private java.lang.String imgHeight;

    @com.alibaba.fastjson.annotation.JSONField(name = "img_sm")
    private java.lang.String imgSm;

    @com.alibaba.fastjson.annotation.JSONField(name = "img_sm_height")
    private java.lang.String imgSmHeight;

    @com.alibaba.fastjson.annotation.JSONField(name = "img_sm_md5")
    private java.lang.String imgSmMd5;

    @com.alibaba.fastjson.annotation.JSONField(name = "img_sm_width")
    private java.lang.String imgSmWidth;

    @com.alibaba.fastjson.annotation.JSONField(name = "img_width")
    private java.lang.String imgWidth;

    @com.alibaba.fastjson.annotation.JSONField(name = "title")
    private java.lang.String title;

    @com.alibaba.fastjson.annotation.JSONField(name = "video")
    private java.lang.String video;

    @com.alibaba.fastjson.annotation.JSONField(name = "video_duration")
    private java.lang.String videoDuration;

    @com.alibaba.fastjson.annotation.JSONField(name = "video_height")
    private java.lang.String videoHeight;

    @com.alibaba.fastjson.annotation.JSONField(name = "video_md5")
    private java.lang.String videoMd5;

    @com.alibaba.fastjson.annotation.JSONField(name = "video_width")
    private java.lang.String videoWidth;

    @Override // com.alimm.tanx.core.ad.listener.bean.IMaterialBean
    public java.lang.String getActionText() {
        return this.actionText;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IMaterialBean
    public java.lang.String getAdvLogo() {
        return this.advLogo;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IMaterialBean
    public java.lang.String getAdvName() {
        return this.advName;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IMaterialBean
    public java.lang.String getDescription() {
        return this.description;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IMaterialBean
    public java.lang.String getImageHeight() {
        return this.imageHeight;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IMaterialBean
    public java.lang.String getImageMd5() {
        return this.imageMd5;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IMaterialBean
    public java.lang.String getImageSize() {
        return this.imageSize;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IMaterialBean
    public java.lang.String getImageUrl() {
        return this.imageUrl;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IMaterialBean
    public java.lang.String getImageWidth() {
        return this.imageWidth;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IMaterialBean
    public java.lang.String getImgHeight() {
        return this.imgHeight;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IMaterialBean
    public java.lang.String getImgSm() {
        return this.imgSm;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IMaterialBean
    public java.lang.String getImgSmHeight() {
        return this.imgSmHeight;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IMaterialBean
    public java.lang.String getImgSmMd5() {
        return this.imgSmMd5;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IMaterialBean
    public java.lang.String getImgSmWidth() {
        return this.imgSmWidth;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IMaterialBean
    public java.lang.String getImgWidth() {
        return this.imgWidth;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IMaterialBean
    public java.lang.String getTitle() {
        return this.title;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IMaterialBean
    public java.lang.String getVideo() {
        return this.video;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IMaterialBean
    public java.lang.String getVideoDuration() {
        return this.videoDuration;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IMaterialBean
    public java.lang.String getVideoHeight() {
        return this.videoHeight;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IMaterialBean
    public java.lang.String getVideoMd5() {
        return this.videoMd5;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IMaterialBean
    public java.lang.String getVideoWidth() {
        return this.videoWidth;
    }

    public void setActionText(java.lang.String str) {
        this.actionText = str;
    }

    public void setAdvLogo(java.lang.String str) {
        this.advLogo = str;
    }

    public void setAdvName(java.lang.String str) {
        this.advName = str;
    }

    public void setDescription(java.lang.String str) {
        this.description = str;
    }

    public void setImageHeight(java.lang.String str) {
        this.imageHeight = str;
    }

    public void setImageMd5(java.lang.String str) {
        this.imageMd5 = str;
    }

    public void setImageSize(java.lang.String str) {
        this.imageSize = str;
    }

    public void setImageUrl(java.lang.String str) {
        this.imageUrl = str;
    }

    public void setImageWidth(java.lang.String str) {
        this.imageWidth = str;
    }

    public void setImgHeight(java.lang.String str) {
        this.imgHeight = str;
    }

    public void setImgSm(java.lang.String str) {
        this.imgSm = str;
    }

    public void setImgSmHeight(java.lang.String str) {
        this.imgSmHeight = str;
    }

    public void setImgSmMd5(java.lang.String str) {
        this.imgSmMd5 = str;
    }

    public void setImgSmWidth(java.lang.String str) {
        this.imgSmWidth = str;
    }

    public void setImgWidth(java.lang.String str) {
        this.imgWidth = str;
    }

    public void setTitle(java.lang.String str) {
        this.title = str;
    }

    public void setVideo(java.lang.String str) {
        this.video = str;
    }

    public void setVideoDuration(java.lang.String str) {
        this.videoDuration = str;
    }

    public void setVideoHeight(java.lang.String str) {
        this.videoHeight = str;
    }

    public void setVideoMd5(java.lang.String str) {
        this.videoMd5 = str;
    }

    public void setVideoWidth(java.lang.String str) {
        this.videoWidth = str;
    }
}
