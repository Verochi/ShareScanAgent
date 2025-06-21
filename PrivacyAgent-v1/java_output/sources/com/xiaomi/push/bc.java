package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class bc implements java.lang.Runnable {
    private java.lang.String a;
    private java.lang.ref.WeakReference<android.content.Context> b;

    public bc(java.lang.String str, java.lang.ref.WeakReference<android.content.Context> weakReference) {
        this.a = str;
        this.b = weakReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        android.content.Context context;
        com.xiaomi.push.bd bdVar;
        java.lang.ref.WeakReference<android.content.Context> weakReference = this.b;
        if (weakReference == null || (context = weakReference.get()) == null) {
            return;
        }
        if (com.xiaomi.push.bp.a(this.a) <= com.xiaomi.push.bb.b) {
            com.xiaomi.channel.commonutils.logger.b.b("=====> do not need clean db");
            return;
        }
        com.xiaomi.push.bf bfVar = new com.xiaomi.push.bf(this.a, "status = ?", new java.lang.String[]{"2"}, "a job build to delete uploaded job");
        java.lang.String str = this.a;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add("count(*)");
        com.xiaomi.push.be beVar = new com.xiaomi.push.be(str, arrayList, "job to get count of all message");
        bfVar.e = beVar;
        java.lang.String str2 = this.a;
        com.xiaomi.channel.commonutils.logger.b.b("delete  messages when db size is too bigger");
        java.lang.String a = com.xiaomi.push.bj.a(context).a(str2).a();
        if (android.text.TextUtils.isEmpty(a)) {
            bdVar = null;
        } else {
            bdVar = new com.xiaomi.push.bd(str2, "rowDataId in (select " + "rowDataId from ".concat(java.lang.String.valueOf(a)) + " order by createTimeStamp asc limit ?)", new java.lang.String[]{com.tencent.connect.common.Constants.DEFAULT_UIN}, "a job build to delete history message");
        }
        beVar.e = bdVar;
        com.xiaomi.push.bj.a(context).a((com.xiaomi.push.bj.a) bfVar);
    }
}
