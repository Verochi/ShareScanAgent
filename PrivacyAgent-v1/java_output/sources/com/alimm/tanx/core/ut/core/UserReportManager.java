package com.alimm.tanx.core.ut.core;

/* loaded from: classes.dex */
public class UserReportManager implements com.alimm.tanx.core.ut.core.IUserReport {
    private static volatile com.alimm.tanx.core.ut.core.UserReportManager instance;
    public java.lang.String TAG = "UserReportManager";

    /* renamed from: com.alimm.tanx.core.ut.core.UserReportManager$1, reason: invalid class name */
    public class AnonymousClass1 implements com.alimm.tanx.core.ut.core.LifeCycleManager.AppVisibleCallBack {
        public AnonymousClass1() {
        }

        @Override // com.alimm.tanx.core.ut.core.LifeCycleManager.AppVisibleCallBack
        public void appVisibleCallBack(boolean z, boolean z2) {
            java.lang.String str = com.alimm.tanx.core.ut.core.UserReportManager.this.TAG;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("当前前后台状态：->");
            sb.append(z ? "后台" : "前台");
            sb.append(",是否由后台切换到前台：");
            sb.append(z2);
            com.alimm.tanx.core.utils.LogUtils.d(str, sb.toString());
            if (z) {
                com.alimm.tanx.core.ut.core.UserReportManager.this.destroy();
            }
            if (z2) {
                com.alimm.tanx.core.ut.core.UserReportManager.this.run();
            }
        }
    }

    public static com.alimm.tanx.core.ut.core.UserReportManager getInstance() {
        if (instance == null) {
            synchronized (com.alimm.tanx.core.ut.core.UserReportManager.class) {
                if (instance == null) {
                    instance = new com.alimm.tanx.core.ut.core.UserReportManager();
                }
            }
        }
        return instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void run() {
        com.alimm.tanx.core.ut.core.QueueManager.getInstance().run();
    }

    public void destroy() {
        com.alimm.tanx.core.ut.core.QueueManager.getInstance().destroy();
        com.alimm.tanx.core.ut.core.UtRequest.getInstance().destroy();
    }

    public void init() {
        run();
        com.alimm.tanx.core.ut.core.LifeCycleManager.getInstance().register(this.TAG, new com.alimm.tanx.core.ut.core.UserReportManager.AnonymousClass1());
    }

    @Override // com.alimm.tanx.core.ut.core.IUserReport
    public void send(com.alimm.tanx.core.ut.bean.UtItemBean utItemBean) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(utItemBean);
        send(arrayList);
    }

    @Override // com.alimm.tanx.core.ut.core.IUserReport
    public void send(java.util.List<com.alimm.tanx.core.ut.bean.UtItemBean> list) {
        com.alimm.tanx.core.ut.core.QueueManager.getInstance().addRealTimeQueue(new com.alimm.tanx.core.ut.bean.UtBean(list));
    }
}
