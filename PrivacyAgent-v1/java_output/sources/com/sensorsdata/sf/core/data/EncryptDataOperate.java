package com.sensorsdata.sf.core.data;

/* loaded from: classes19.dex */
public class EncryptDataOperate implements com.sensorsdata.sf.core.data.IDataOperate {
    private com.sensorsdata.sf.core.data.IDataOperate mNextNode;

    @Override // com.sensorsdata.sf.core.data.IDataOperate
    public void deletePlan(java.lang.String str) {
        this.mNextNode.deletePlan(com.sensorsdata.sf.core.data.SecretUtil.encryptAES(str));
    }

    @Override // com.sensorsdata.sf.core.data.IDataOperate
    public void deletePlanOutTime(long j) {
        this.mNextNode.deletePlanOutTime(j);
    }

    @Override // com.sensorsdata.sf.core.data.IDataOperate
    public java.lang.String getGlobalPopupLimit() {
        return com.sensorsdata.sf.core.data.SecretUtil.decryptAES(this.mNextNode.getGlobalPopupLimit());
    }

    @Override // com.sensorsdata.sf.core.data.IDataOperate
    public java.lang.String getPlanLocal(java.lang.String str) {
        return com.sensorsdata.sf.core.data.SecretUtil.decryptAES(this.mNextNode.getPlanLocal(com.sensorsdata.sf.core.data.SecretUtil.encryptAES(str)));
    }

    @Override // com.sensorsdata.sf.core.data.IDataOperate
    public java.lang.String getPlanRemote(java.lang.String str) {
        return com.sensorsdata.sf.core.data.SecretUtil.decryptAES(this.mNextNode.getPlanRemote(com.sensorsdata.sf.core.data.SecretUtil.encryptAES(str)));
    }

    @Override // com.sensorsdata.sf.core.data.IDataOperate
    public java.lang.String getSPValue(java.lang.String str, java.lang.String str2) {
        java.lang.String sPValue = this.mNextNode.getSPValue(com.sensorsdata.sf.core.data.SecretUtil.encryptAES(str), str2);
        return android.text.TextUtils.isEmpty(sPValue) ? str2 : com.sensorsdata.sf.core.data.SecretUtil.decryptAES(sPValue);
    }

    @Override // com.sensorsdata.sf.core.data.IDataOperate
    public java.lang.String getUserId(java.lang.String str) {
        return com.sensorsdata.sf.core.data.SecretUtil.decryptAES(this.mNextNode.getUserId(com.sensorsdata.sf.core.data.SecretUtil.encryptAES(str)));
    }

    @Override // com.sensorsdata.sf.core.data.IDataOperate
    public boolean hasPlan(java.lang.String str) {
        return this.mNextNode.hasPlan(com.sensorsdata.sf.core.data.SecretUtil.encryptAES(str));
    }

    @Override // com.sensorsdata.sf.core.data.IDataOperate
    public void next(com.sensorsdata.sf.core.data.IDataOperate iDataOperate) {
        this.mNextNode = iDataOperate;
    }

    @Override // com.sensorsdata.sf.core.data.IDataOperate
    public void saveGlobalPopupLimit(java.lang.String str) {
        this.mNextNode.saveGlobalPopupLimit(com.sensorsdata.sf.core.data.SecretUtil.encryptAES(str));
    }

    @Override // com.sensorsdata.sf.core.data.IDataOperate
    public void savePlanLocal(java.lang.String str, java.lang.String str2) {
        this.mNextNode.savePlanLocal(com.sensorsdata.sf.core.data.SecretUtil.encryptAES(str), com.sensorsdata.sf.core.data.SecretUtil.encryptAES(str2));
    }

    @Override // com.sensorsdata.sf.core.data.IDataOperate
    public void savePlanRemote(java.lang.String str, java.lang.String str2) {
        this.mNextNode.savePlanRemote(com.sensorsdata.sf.core.data.SecretUtil.encryptAES(str), com.sensorsdata.sf.core.data.SecretUtil.encryptAES(str2));
    }

    @Override // com.sensorsdata.sf.core.data.IDataOperate
    public void savePlanUserId(java.lang.String str, java.lang.String str2) {
        this.mNextNode.savePlanUserId(com.sensorsdata.sf.core.data.SecretUtil.encryptAES(str), com.sensorsdata.sf.core.data.SecretUtil.encryptAES(str2));
    }

    @Override // com.sensorsdata.sf.core.data.IDataOperate
    public void saveUser(java.lang.String str, java.lang.String str2) {
        this.mNextNode.saveUser(com.sensorsdata.sf.core.data.SecretUtil.encryptAES(str), com.sensorsdata.sf.core.data.SecretUtil.encryptAES(str2));
    }

    @Override // com.sensorsdata.sf.core.data.IDataOperate
    public void setSPValue(java.lang.String str, java.lang.String str2) {
        this.mNextNode.setSPValue(com.sensorsdata.sf.core.data.SecretUtil.encryptAES(str), com.sensorsdata.sf.core.data.SecretUtil.encryptAES(str2));
    }

    @Override // com.sensorsdata.sf.core.data.IDataOperate
    public void updatePlanTime(java.lang.String str, long j) {
        this.mNextNode.updatePlanTime(com.sensorsdata.sf.core.data.SecretUtil.encryptAES(str), j);
    }
}
