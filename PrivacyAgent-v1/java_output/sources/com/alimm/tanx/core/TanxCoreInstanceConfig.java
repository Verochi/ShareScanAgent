package com.alimm.tanx.core;

/* loaded from: classes.dex */
public class TanxCoreInstanceConfig implements com.alimm.tanx.core.utils.NotConfused {
    private static volatile com.alimm.tanx.core.TanxCoreInstanceConfig instance;
    private volatile com.alimm.tanx.core.ad.listener.bean.IAdInfo iAdInfo;
    private volatile com.alimm.tanx.core.ad.listener.request.IAdRequest iAdRequest;
    private volatile com.alimm.tanx.core.ad.listener.bean.IBidInfo iBidInfo;
    private volatile com.alimm.tanx.core.image.IImageLoader iImageLoader;
    private volatile com.alimm.tanx.core.net.INetWork iNetWork;
    private volatile com.alimm.tanx.core.ad.listener.bean.ISeatInfo iSeatInfo;
    private volatile com.alimm.tanx.core.ad.listener.model.IModel iSplashModel;
    private volatile com.alimm.tanx.core.view.player.core.ITanxPlayer iTanxPlayer;
    private volatile com.alimm.tanx.core.ad.listener.ut.ITanxUserTracker iTanxUserTracker;
    private volatile com.tanx.exposer.tanxc_do.tanxc_try.tanxc_do iUserTracker;

    public static com.alimm.tanx.core.TanxCoreInstanceConfig getInstance() {
        if (instance == null) {
            synchronized (com.alimm.tanx.core.TanxCoreInstanceConfig.class) {
                if (instance == null) {
                    instance = new com.alimm.tanx.core.TanxCoreInstanceConfig();
                }
            }
        }
        return instance;
    }

    public com.alimm.tanx.core.ad.listener.bean.IAdInfo getAdInfo() {
        return this.iAdInfo;
    }

    public com.alimm.tanx.core.ad.listener.request.IAdRequest getAdRequest() {
        return this.iAdRequest;
    }

    public com.alimm.tanx.core.ad.listener.bean.IBidInfo getBidInfo() {
        return this.iBidInfo;
    }

    public com.alimm.tanx.core.ad.listener.bean.IClickBean getClickBean() {
        if (this.iBidInfo != null) {
            return this.iBidInfo.getClickBean();
        }
        return null;
    }

    public com.alimm.tanx.core.image.IImageLoader getImageLoader() {
        return this.iImageLoader;
    }

    public com.alimm.tanx.core.ad.listener.bean.IMaterialBean getMaterialBean() {
        if (this.iBidInfo != null) {
            return this.iBidInfo.getMaterialBean();
        }
        return null;
    }

    public com.alimm.tanx.core.ad.listener.bean.IMonitorBean getMonitorBean() {
        if (this.iBidInfo != null) {
            return this.iBidInfo.getMonitorBean();
        }
        return null;
    }

    public com.alimm.tanx.core.net.INetWork getNetWork() {
        return this.iNetWork;
    }

    public com.alimm.tanx.core.ad.listener.bean.ISeatInfo getSeatInfo() {
        return this.iSeatInfo;
    }

    public com.alimm.tanx.core.ad.listener.model.IModel getSplashModel() {
        return this.iSplashModel;
    }

    public com.alimm.tanx.core.view.player.core.ITanxPlayer getTanxPlayer() {
        return this.iTanxPlayer;
    }

    public com.alimm.tanx.core.ad.listener.ut.ITanxUserTracker getTanxUserTracker() {
        return this.iTanxUserTracker;
    }

    public com.tanx.exposer.tanxc_do.tanxc_try.tanxc_do getUserTracker() {
        return this.iUserTracker;
    }

    public void setAdInfo(com.alimm.tanx.core.ad.listener.bean.IAdInfo iAdInfo) {
        this.iAdInfo = iAdInfo;
    }

    public void setAdRequest(com.alimm.tanx.core.ad.listener.request.IAdRequest iAdRequest) {
        this.iAdRequest = iAdRequest;
    }

    public void setBidInfo(com.alimm.tanx.core.ad.listener.bean.IBidInfo iBidInfo) {
        this.iBidInfo = iBidInfo;
    }

    public void setImageLoader(com.alimm.tanx.core.image.IImageLoader iImageLoader) {
        this.iImageLoader = iImageLoader;
    }

    public void setNetWork(com.alimm.tanx.core.net.INetWork iNetWork) {
        this.iNetWork = iNetWork;
    }

    public void setSeatInfo(com.alimm.tanx.core.ad.listener.bean.ISeatInfo iSeatInfo) {
        this.iSeatInfo = iSeatInfo;
    }

    public void setSplashModel(com.alimm.tanx.core.ad.listener.model.IModel iModel) {
        this.iSplashModel = iModel;
    }

    public void setTanxPlayer(com.alimm.tanx.core.view.player.core.ITanxPlayer iTanxPlayer) {
        this.iTanxPlayer = iTanxPlayer;
    }

    public void setTanxUserTracker(com.alimm.tanx.core.ad.listener.ut.ITanxUserTracker iTanxUserTracker) {
        this.iTanxUserTracker = iTanxUserTracker;
    }

    public void setUserTracker(com.tanx.exposer.tanxc_do.tanxc_try.tanxc_do tanxc_doVar) {
        this.iUserTracker = tanxc_doVar;
    }
}
