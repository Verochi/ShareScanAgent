package com.alimm.tanx.core.ad.ad.template.rendering.reward;

/* loaded from: classes.dex */
public class tanxc_try {
    public java.lang.String tanxc_do;
    public java.lang.String tanxc_for;
    public java.lang.String tanxc_if;
    public com.alimm.tanx.core.ad.bean.RewardParam tanxc_int;

    public tanxc_try() {
    }

    public tanxc_try(java.lang.String str, java.lang.String str2, java.lang.String str3, com.alimm.tanx.core.ad.bean.RewardParam rewardParam) {
        this.tanxc_do = str;
        this.tanxc_if = str2;
        this.tanxc_for = str3;
        this.tanxc_int = rewardParam;
    }

    public java.lang.String toString() {
        return "WaitQueryReward{pid='" + this.tanxc_do + "', mediaUid='" + this.tanxc_if + "', sessionId='" + this.tanxc_for + "', rewardParam=" + this.tanxc_int + '}';
    }
}
