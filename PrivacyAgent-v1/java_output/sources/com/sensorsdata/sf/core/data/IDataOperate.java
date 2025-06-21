package com.sensorsdata.sf.core.data;

/* loaded from: classes19.dex */
public interface IDataOperate {
    void deletePlan(java.lang.String str);

    void deletePlanOutTime(long j);

    java.lang.String getGlobalPopupLimit();

    java.lang.String getPlanLocal(java.lang.String str);

    java.lang.String getPlanRemote(java.lang.String str);

    java.lang.String getSPValue(java.lang.String str, java.lang.String str2);

    java.lang.String getUserId(java.lang.String str);

    boolean hasPlan(java.lang.String str);

    void next(com.sensorsdata.sf.core.data.IDataOperate iDataOperate);

    void saveGlobalPopupLimit(java.lang.String str);

    void savePlanLocal(java.lang.String str, java.lang.String str2);

    void savePlanRemote(java.lang.String str, java.lang.String str2);

    void savePlanUserId(java.lang.String str, java.lang.String str2);

    void saveUser(java.lang.String str, java.lang.String str2);

    void setSPValue(java.lang.String str, java.lang.String str2);

    void updatePlanTime(java.lang.String str, long j);
}
