package com.alimm.tanx.core.ad.bean;

/* loaded from: classes.dex */
public class RewardResponse extends com.alimm.tanx.core.ad.bean.BaseBean {

    @com.alibaba.fastjson.annotation.JSONField(name = "tasks")
    private java.util.List<com.alimm.tanx.core.ad.bean.RewardResponse.PidRewards> pidRewards;

    @com.alibaba.fastjson.annotation.JSONField(name = "id")
    private java.lang.String requestId;

    @com.alibaba.fastjson.annotation.JSONField(name = "status")
    private int status;

    public class PidRewards extends com.alimm.tanx.core.ad.bean.BaseBean {

        @com.alibaba.fastjson.annotation.JSONField(name = "complete_time")
        private java.lang.String completeTime;
        private java.lang.String pid;

        @com.alibaba.fastjson.annotation.JSONField(name = "reward_count")
        private int rewardCount;

        @com.alibaba.fastjson.annotation.JSONField(name = "reward_name")
        private java.lang.String rewardName;

        @com.alibaba.fastjson.annotation.JSONField(name = "session_id")
        private java.lang.String sessionId;

        @com.alibaba.fastjson.annotation.JSONField(name = "task_type")
        private int taskType;

        public PidRewards() {
        }

        public java.lang.String getCompleteTime() {
            return this.completeTime;
        }

        public java.lang.String getPid() {
            return this.pid;
        }

        public int getRewardCount() {
            return this.rewardCount;
        }

        public java.lang.String getRewardName() {
            return this.rewardName;
        }

        public java.lang.String getSessionId() {
            return this.sessionId;
        }

        public int getTaskType() {
            return this.taskType;
        }

        public void setCompleteTime(java.lang.String str) {
            this.completeTime = str;
        }

        public void setPid(java.lang.String str) {
            this.pid = str;
        }

        public void setRewardCount(int i) {
            this.rewardCount = i;
        }

        public void setRewardName(java.lang.String str) {
            this.rewardName = str;
        }

        public void setSessionId(java.lang.String str) {
            this.sessionId = str;
        }

        public void setTaskType(int i) {
            this.taskType = i;
        }
    }

    public java.util.List<com.alimm.tanx.core.ad.bean.RewardResponse.PidRewards> getPidRewards() {
        return this.pidRewards;
    }

    public java.lang.String getRequestId() {
        return this.requestId;
    }

    public int getStatus() {
        return this.status;
    }

    public void setPidRewards(java.util.List<com.alimm.tanx.core.ad.bean.RewardResponse.PidRewards> list) {
        this.pidRewards = list;
    }

    public void setRequestId(java.lang.String str) {
        this.requestId = str;
    }

    public void setStatus(int i) {
        this.status = i;
    }
}
