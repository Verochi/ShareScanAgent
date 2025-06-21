package com.alimm.tanx.core.ad.bean;

/* loaded from: classes.dex */
public class RewardRequestBean extends com.alimm.tanx.core.ad.bean.RequestBaseBean {
    public com.alimm.tanx.core.ad.bean.RewardRequestBean.Type ad_context;
    public java.util.List<com.alimm.tanx.core.ad.bean.RewardRequestBean.PidVerifications> task_check;
    public java.lang.Integer trigger_event;
    public com.alimm.tanx.core.ad.bean.RewardRequestBean.RewardUserBean user;

    public static class PidVerifications extends com.alimm.tanx.core.ad.bean.BaseBean {
        public int check;
        public java.lang.String pid;

        public PidVerifications(java.lang.String str, int i) {
            this.pid = str;
            this.check = i;
        }
    }

    public static class RewardUserBean extends com.alimm.tanx.core.ad.bean.BaseBean {
        public java.lang.String media_uid;
    }

    public static class Type extends com.alimm.tanx.core.ad.bean.BaseBean {
        public java.lang.String session_id;
    }

    private com.alimm.tanx.core.ad.bean.RewardRequestBean build(java.lang.String str, java.util.List<com.alimm.tanx.core.ad.bean.RewardRequestBean.PidVerifications> list) {
        com.alimm.tanx.core.ad.bean.RewardRequestBean.RewardUserBean rewardUserBean = new com.alimm.tanx.core.ad.bean.RewardRequestBean.RewardUserBean();
        this.user = rewardUserBean;
        rewardUserBean.media_uid = str;
        this.task_check = list;
        return this;
    }

    public com.alimm.tanx.core.ad.bean.RewardRequestBean build(java.lang.String str, java.lang.String str2, com.alimm.tanx.core.ad.bean.RewardParam rewardParam) {
        if (rewardParam == null) {
            rewardParam = new com.alimm.tanx.core.ad.bean.RewardParam();
        }
        com.alimm.tanx.core.ad.bean.RewardRequestBean.PidVerifications pidVerifications = new com.alimm.tanx.core.ad.bean.RewardRequestBean.PidVerifications(str2, rewardParam.isRewardVerification() ? 1 : 0);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(pidVerifications);
        return build(str, arrayList);
    }

    public com.alimm.tanx.core.ad.bean.RewardRequestBean build(java.lang.String str, java.util.List<java.lang.String> list, com.alimm.tanx.core.ad.bean.RewardParam rewardParam) {
        if (rewardParam == null) {
            rewardParam = new com.alimm.tanx.core.ad.bean.RewardParam();
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                if (!android.text.TextUtils.isEmpty(list.get(i))) {
                    arrayList.add(new com.alimm.tanx.core.ad.bean.RewardRequestBean.PidVerifications(list.get(i), rewardParam.isRewardVerification() ? 1 : 0));
                }
            }
        }
        return build(str, arrayList);
    }

    public com.alimm.tanx.core.ad.bean.RewardRequestBean buildSessionId(java.lang.Integer num, java.lang.String str) {
        this.trigger_event = num;
        if (this.ad_context == null) {
            this.ad_context = new com.alimm.tanx.core.ad.bean.RewardRequestBean.Type();
        }
        this.ad_context.session_id = str;
        return this;
    }
}
