package com.alimm.tanx.core.ad.bean;

/* loaded from: classes.dex */
public class TemplateConfig extends com.alimm.tanx.core.ad.bean.BaseBean {

    @com.alibaba.fastjson.annotation.JSONField(name = "action_text")
    private java.lang.String actionText;

    @com.alibaba.fastjson.annotation.JSONField(name = "all_slide_distance")
    private java.lang.String allSlideDistance;

    @com.alibaba.fastjson.annotation.JSONField(name = "back_pop")
    private java.lang.String backPop;

    @com.alibaba.fastjson.annotation.JSONField(name = "count_down")
    private java.lang.String countDown;
    private com.alimm.tanx.core.ad.bean.MediaRenderingMode day;

    @com.alibaba.fastjson.annotation.JSONField(name = "interact_img")
    private java.lang.String interactImg;
    private com.alimm.tanx.core.ad.bean.MediaRenderingMode night;

    @com.alibaba.fastjson.annotation.JSONField(name = "pid_style_id")
    private java.lang.String pidStyleId;

    @com.alibaba.fastjson.annotation.JSONField(name = "render_url")
    private java.lang.String renderUrl;

    @com.alibaba.fastjson.annotation.JSONField(name = "reward_mode")
    private int rewardMode;

    @com.alibaba.fastjson.annotation.JSONField(name = "shake_count")
    private java.lang.String shakeCount;

    @com.alibaba.fastjson.annotation.JSONField(name = "shake_sensor_check_interval")
    private java.lang.String shakeSensorCheckInterval;

    @com.alibaba.fastjson.annotation.JSONField(name = "shake_sensor_shake_interval")
    private java.lang.String shakeSensorShakeInterval;

    @com.alibaba.fastjson.annotation.JSONField(name = "shake_splash")
    private java.lang.String shakeSplash;

    @com.alibaba.fastjson.annotation.JSONField(name = "slide_distance")
    private java.lang.String slideDistance;

    @com.alibaba.fastjson.annotation.JSONField(name = "slide_type")
    private java.lang.String slideType;

    @com.alibaba.fastjson.annotation.JSONField(name = "sliding_direction")
    private int slidingDirection;

    @com.alibaba.fastjson.annotation.JSONField(name = "web_end_time")
    private java.lang.String webEndTime;

    @com.alibaba.fastjson.annotation.JSONField(name = "web_height")
    private java.lang.String webHeight;

    @com.alibaba.fastjson.annotation.JSONField(name = "web_start_time")
    private java.lang.String webStartTime;

    @com.alibaba.fastjson.annotation.JSONField(name = "web_type")
    private java.lang.String webType;

    @com.alibaba.fastjson.annotation.JSONField(name = "web_url")
    private java.lang.String webUrl;

    @com.alibaba.fastjson.annotation.JSONField(name = "web_width")
    private java.lang.String webWidth;

    public class DefaultConfig extends com.alimm.tanx.core.ad.bean.BaseBean {
        public static final java.lang.String adColor = "#ffffff";
        public static final java.lang.String adSize = "5";
        public static final java.lang.String advColor = "#ffffff";
        public static final java.lang.String advSize = "5";
        public static final java.lang.String bAdColor = "#999999";
        public static final java.lang.String bAdSize = "5";
        public static final java.lang.String bAdvColor = "#999999";
        public static final java.lang.String bAdvSize = "5";
        public static final java.lang.String bBgColor = "#ffffff";
        public static final java.lang.String bPicRadius = "4";
        public static final java.lang.String bTitleColor = "#333333";
        public static final java.lang.String bTitleSize = "8";
        public static final java.lang.String bgColor = "#333333";
        public static final java.lang.String picRadius = "4";
        public static final java.lang.String titleColor = "#ffffff";
        public static final java.lang.String titleSize = "8";

        public DefaultConfig() {
        }
    }

    private void setDefaultDaytimeMode() {
        this.day = new com.alimm.tanx.core.ad.bean.MediaRenderingMode("8", "#333333", "5", "#999999", "5", "#999999", "#ffffff", "4");
    }

    private void setDefaultNightMode() {
        this.night = new com.alimm.tanx.core.ad.bean.MediaRenderingMode("8", "#ffffff", "5", "#ffffff", "5", "#ffffff", "#333333", "4");
    }

    public java.lang.String getActionText() {
        return this.actionText;
    }

    public java.lang.String getAllSlideDistance() {
        return this.allSlideDistance;
    }

    public int getAllSlideDistance2Int() {
        try {
            return java.lang.Integer.parseInt(this.allSlideDistance);
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.d(com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(e), new java.lang.String[0]);
            return 120;
        }
    }

    public java.lang.String getBackPop() {
        return this.backPop;
    }

    public java.lang.String getCountDown() {
        return this.countDown;
    }

    public int getCountDown2Int() {
        if (android.text.TextUtils.isEmpty(this.countDown)) {
            return 0;
        }
        try {
            return java.lang.Integer.parseInt(this.countDown);
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e("countDown转Int error", e);
            return 0;
        }
    }

    public com.alimm.tanx.core.ad.bean.MediaRenderingMode getDay() {
        return this.day;
    }

    public java.lang.String getInteractImg() {
        return this.interactImg;
    }

    public com.alimm.tanx.core.ad.bean.MediaRenderingMode getNight() {
        return this.night;
    }

    public com.alimm.tanx.core.ad.bean.MediaRenderingMode getNowConfig(boolean z, boolean z2, int i) {
        com.alimm.tanx.core.utils.LogUtils.d("TemplateConfig", "getNowConfig start");
        try {
            com.alimm.tanx.core.ad.bean.MediaRenderingMode mediaRenderingMode = this.day;
            if (mediaRenderingMode == null || android.text.TextUtils.isEmpty(mediaRenderingMode.getTitleColor())) {
                com.alimm.tanx.core.utils.LogUtils.d("TemplateConfig", "getNowConfig setDefaultDaytimeMode");
                setDefaultDaytimeMode();
            }
            com.alimm.tanx.core.ad.bean.MediaRenderingMode mediaRenderingMode2 = this.night;
            if (mediaRenderingMode2 == null || android.text.TextUtils.isEmpty(mediaRenderingMode2.getTitleColor())) {
                com.alimm.tanx.core.utils.LogUtils.d("TemplateConfig", "getNowConfig setDefaultNightMode");
                setDefaultNightMode();
            }
            if (z) {
                com.alimm.tanx.core.utils.LogUtils.d("TemplateConfig", "isNightMode true customTitleSizeSwitch:" + z2 + ",night:" + this.night.toString());
                if (z2) {
                    if (android.text.TextUtils.isEmpty(this.night.getServerTitleSize())) {
                        com.alimm.tanx.core.ad.bean.MediaRenderingMode mediaRenderingMode3 = this.night;
                        mediaRenderingMode3.setServerTitleSize(mediaRenderingMode3.getTitleSize());
                    }
                    this.night.setTitleSize(i + "");
                } else if (!android.text.TextUtils.isEmpty(this.night.getServerTitleSize())) {
                    this.night.setTitleSize(this.night.getServerTitleSize() + "");
                }
                return this.night;
            }
            com.alimm.tanx.core.utils.LogUtils.d("TemplateConfig", "isNightMode false customTitleSizeSwitch:" + z2 + ",day:" + this.day.toString());
            if (z2) {
                if (android.text.TextUtils.isEmpty(this.day.getServerTitleSize())) {
                    com.alimm.tanx.core.ad.bean.MediaRenderingMode mediaRenderingMode4 = this.day;
                    mediaRenderingMode4.setServerTitleSize(mediaRenderingMode4.getTitleSize());
                }
                this.day.setTitleSize(i + "");
            } else if (!android.text.TextUtils.isEmpty(this.day.getServerTitleSize())) {
                this.day.setTitleSize(this.day.getServerTitleSize() + "");
            }
            return this.day;
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e("TemplateConfig getNowConfig Exception", e);
            return null;
        }
    }

    public java.lang.String getPidStyleId() {
        return this.pidStyleId;
    }

    public java.lang.String getRenderUrl() {
        return this.renderUrl;
    }

    public int getRewardMode() {
        return this.rewardMode;
    }

    public java.lang.String getShakeCount() {
        return this.shakeCount;
    }

    public java.lang.String getShakeSensorCheckInterval() {
        return this.shakeSensorCheckInterval;
    }

    public java.lang.String getShakeSensorShakeInterval() {
        return this.shakeSensorShakeInterval;
    }

    public java.lang.String getShakeSplash() {
        return this.shakeSplash;
    }

    public int getShakeSplash2Int() {
        try {
            return java.lang.Integer.parseInt(this.shakeSplash);
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.d(com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(e), new java.lang.String[0]);
            return 15;
        }
    }

    public java.lang.String getSlideDistance() {
        return this.slideDistance;
    }

    public int getSlideDistance2Int() {
        try {
            return java.lang.Integer.parseInt(this.slideDistance);
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.d(com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(e), new java.lang.String[0]);
            return 55;
        }
    }

    public java.lang.String getSlideType() {
        return this.slideType;
    }

    public int getSlideType2Int() {
        try {
            return java.lang.Integer.parseInt(this.slideType);
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.d(com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(e), new java.lang.String[0]);
            return 1;
        }
    }

    public int getSlidingDirection() {
        return this.slidingDirection;
    }

    public java.lang.String getWebEndTime() {
        return this.webEndTime;
    }

    public java.lang.Long getWebEndTime2Long() {
        try {
            return java.lang.Long.valueOf(java.lang.Long.parseLong(this.webEndTime));
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public java.lang.String getWebHeight() {
        return this.webHeight;
    }

    public int getWebHeight2Int() {
        int i;
        try {
            i = java.lang.Integer.parseInt(this.webHeight);
        } catch (java.lang.Exception unused) {
            i = 9;
        }
        if (i <= 0) {
            return 9;
        }
        return i;
    }

    public java.lang.String getWebStartTime() {
        return this.webStartTime;
    }

    public java.lang.Long getWebStartTime2Long() {
        try {
            return java.lang.Long.valueOf(java.lang.Long.parseLong(this.webStartTime));
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public java.lang.String getWebType() {
        return this.webType;
    }

    public int getWebType2Int() {
        try {
            return java.lang.Integer.parseInt(this.webType);
        } catch (java.lang.Exception unused) {
            return -1;
        }
    }

    public java.lang.String getWebUrl() {
        return this.webUrl;
    }

    public java.lang.String getWebWidth() {
        return this.webWidth;
    }

    public int getWebWidth2Int() {
        int i;
        try {
            i = java.lang.Integer.parseInt(this.webWidth);
        } catch (java.lang.Exception unused) {
            i = 16;
        }
        if (i <= 0) {
            return 16;
        }
        return i;
    }

    public void setActionText(java.lang.String str) {
        this.actionText = str;
    }

    public void setAllSlideDistance(java.lang.String str) {
        this.allSlideDistance = str;
    }

    public void setBackPop(java.lang.String str) {
        this.backPop = str;
    }

    public void setCountDown(java.lang.String str) {
        this.countDown = str;
    }

    public void setDay(com.alimm.tanx.core.ad.bean.MediaRenderingMode mediaRenderingMode) {
        this.day = mediaRenderingMode;
    }

    public void setInteractImg(java.lang.String str) {
        this.interactImg = str;
    }

    public void setNight(com.alimm.tanx.core.ad.bean.MediaRenderingMode mediaRenderingMode) {
        this.night = mediaRenderingMode;
    }

    public void setPidStyleId(java.lang.String str) {
        this.pidStyleId = str;
    }

    public void setRenderUrl(java.lang.String str) {
        this.renderUrl = str;
    }

    public void setRewardMode(int i) {
        this.rewardMode = i;
    }

    public void setShakeCount(java.lang.String str) {
        this.shakeCount = str;
    }

    public void setShakeSensorCheckInterval(java.lang.String str) {
        this.shakeSensorCheckInterval = str;
    }

    public void setShakeSensorShakeInterval(java.lang.String str) {
        this.shakeSensorShakeInterval = str;
    }

    public void setShakeSplash(java.lang.String str) {
        this.shakeSplash = str;
    }

    public void setSlideDistance(java.lang.String str) {
        this.slideDistance = str;
    }

    public void setSlideType(java.lang.String str) {
        this.slideType = str;
    }

    public void setSlidingDirection(int i) {
        this.slidingDirection = i;
    }

    public void setWebEndTime(java.lang.String str) {
        this.webEndTime = str;
    }

    public void setWebHeight(java.lang.String str) {
        this.webHeight = str;
    }

    public void setWebStartTime(java.lang.String str) {
        this.webStartTime = str;
    }

    public void setWebType(java.lang.String str) {
        this.webType = str;
    }

    public void setWebUrl(java.lang.String str) {
        this.webUrl = str;
    }

    public void setWebWidth(java.lang.String str) {
        this.webWidth = str;
    }
}
