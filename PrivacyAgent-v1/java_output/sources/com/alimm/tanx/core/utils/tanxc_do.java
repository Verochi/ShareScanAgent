package com.alimm.tanx.core.utils;

/* loaded from: classes.dex */
public class tanxc_do {
    private java.lang.String tanxc_byte;
    private java.lang.String tanxc_case;
    private java.lang.String tanxc_char;
    private java.lang.String tanxc_else;
    private java.lang.String tanxc_goto;
    private java.lang.String tanxc_if;
    private java.lang.String tanxc_int;
    private java.util.List<com.alimm.tanx.core.ad.listener.bean.NewTrackItem> tanxc_long;
    private java.lang.String tanxc_new;
    private java.lang.String tanxc_try;
    private int tanxc_do = -1;
    private int tanxc_for = -1;

    public com.alimm.tanx.core.ad.interaction.AdClickInfo tanxc_do(com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot, com.alimm.tanx.core.ad.bean.BidInfo bidInfo, com.alimm.tanx.core.ut.AdUtConstants adUtConstants) {
        return tanxc_do(tanxAdSlot, bidInfo, adUtConstants, null, null);
    }

    public com.alimm.tanx.core.ad.interaction.AdClickInfo tanxc_do(com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot, com.alimm.tanx.core.ad.bean.BidInfo bidInfo, com.alimm.tanx.core.ut.AdUtConstants adUtConstants, java.lang.String str, java.lang.String str2) {
        if (tanxAdSlot != null) {
            this.tanxc_do = tanxAdSlot.getAdType();
            this.tanxc_byte = tanxAdSlot.getPid();
            this.tanxc_case = tanxAdSlot.getReqId();
        }
        if (bidInfo != null) {
            this.tanxc_char = bidInfo.getClickThroughUrl();
            this.tanxc_else = bidInfo.getDeepLinkUrl();
            this.tanxc_if = bidInfo.getCreativeId();
            this.tanxc_for = bidInfo.getOpenType();
            this.tanxc_int = bidInfo.getTemplateId();
            this.tanxc_new = bidInfo.getSessionId();
            this.tanxc_try = bidInfo.getTemplateConf() != null ? bidInfo.getTemplateConf().getPidStyleId() : null;
            this.tanxc_goto = bidInfo.getRawJsonStr();
            this.tanxc_long = bidInfo.getEventTrack();
        }
        return new com.alimm.tanx.core.ad.interaction.AdClickInfo(this.tanxc_do, this.tanxc_if, this.tanxc_for, this.tanxc_int, this.tanxc_new, this.tanxc_try, this.tanxc_byte, this.tanxc_case, this.tanxc_char, this.tanxc_else, adUtConstants, str, str2, this.tanxc_goto, this.tanxc_long);
    }
}
