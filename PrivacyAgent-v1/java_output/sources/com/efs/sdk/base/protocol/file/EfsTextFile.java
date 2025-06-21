package com.efs.sdk.base.protocol.file;

/* loaded from: classes22.dex */
public class EfsTextFile extends com.efs.sdk.base.protocol.file.AbsFileLog {
    private static final java.lang.String FILE_START = "*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** ***";
    private static final java.lang.String SECTION_START = "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---";
    private long beginTime;
    private long endTime;
    private boolean mHasInitLinkInfo;
    private java.lang.String mLinkID;
    private java.lang.String mLinkKey;
    private java.util.List<com.efs.sdk.base.protocol.file.section.AbsSection> sectionList;

    public EfsTextFile(java.lang.String str) {
        super(str);
        this.sectionList = new java.util.ArrayList();
        this.mLinkKey = null;
        this.mLinkID = null;
        this.mHasInitLinkInfo = false;
        this.beginTime = 0L;
        this.endTime = 0L;
    }

    private java.lang.String changeToStr() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(FILE_START);
        sb.append("\n");
        int i = 0;
        for (com.efs.sdk.base.protocol.file.section.AbsSection absSection : this.sectionList) {
            if (i > 0) {
                sb.append("--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n");
            }
            sb.append(absSection.changeToStr());
            i++;
        }
        return sb.toString();
    }

    private void initLinkInfo() {
        if ((android.text.TextUtils.isEmpty(this.mLinkID) || android.text.TextUtils.isEmpty(this.mLinkKey)) && !this.mHasInitLinkInfo) {
            for (com.efs.sdk.base.protocol.file.section.AbsSection absSection : this.sectionList) {
                if (absSection instanceof com.efs.sdk.base.protocol.file.section.KVSection) {
                    java.util.Map<java.lang.String, java.lang.Object> dataMap = ((com.efs.sdk.base.protocol.file.section.KVSection) absSection).getDataMap();
                    if (android.text.TextUtils.isEmpty(this.mLinkID) && dataMap.containsKey(com.efs.sdk.base.Constants.LOG_KEY_LINK_ID)) {
                        this.mLinkID = java.lang.String.valueOf(dataMap.get(com.efs.sdk.base.Constants.LOG_KEY_LINK_ID));
                    }
                    if (android.text.TextUtils.isEmpty(this.mLinkKey) && dataMap.containsKey(com.efs.sdk.base.Constants.LOG_KEY_LINK_KEY)) {
                        this.mLinkKey = java.lang.String.valueOf(dataMap.get(com.efs.sdk.base.Constants.LOG_KEY_LINK_KEY));
                    }
                }
            }
            this.mHasInitLinkInfo = true;
        }
    }

    private void insertCustomInfoSection() {
        com.efs.sdk.base.protocol.file.section.KVSection kVSection = new com.efs.sdk.base.protocol.file.section.KVSection(com.qq.e.comm.managers.setting.GlobalSetting.CUSTOM_INFO_KEY);
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().getPublicParamMap().entrySet()) {
            kVSection.put(entry.getKey(), entry.getValue());
        }
        this.sectionList.add(0, kVSection);
    }

    public com.efs.sdk.base.protocol.file.section.JSONSection createAndAddJSONSection(java.lang.String str) {
        com.efs.sdk.base.protocol.file.section.JSONSection jSONSection = new com.efs.sdk.base.protocol.file.section.JSONSection(str);
        this.sectionList.add(jSONSection);
        return jSONSection;
    }

    public com.efs.sdk.base.protocol.file.section.KVSection createAndAddKVSection(java.lang.String str) {
        com.efs.sdk.base.protocol.file.section.KVSection kVSection = new com.efs.sdk.base.protocol.file.section.KVSection(str);
        this.sectionList.add(kVSection);
        return kVSection;
    }

    public com.efs.sdk.base.protocol.file.section.TextSection createAndAddTextSection(java.lang.String str) {
        com.efs.sdk.base.protocol.file.section.TextSection textSection = new com.efs.sdk.base.protocol.file.section.TextSection(str);
        this.sectionList.add(textSection);
        return textSection;
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public byte[] generate() {
        java.lang.String changeToStr = changeToStr();
        if (com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().isPrintLogDetail()) {
            com.efs.sdk.base.core.util.Log.i("efs.base", changeToStr);
        }
        return changeToStr.getBytes();
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public java.lang.String generateString() {
        return changeToStr();
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public java.lang.String getLinkId() {
        initLinkInfo();
        return this.mLinkID;
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public java.lang.String getLinkKey() {
        initLinkInfo();
        return this.mLinkKey;
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public long getLogBeginTime() {
        return this.beginTime;
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public long getLogEndTime() {
        return this.endTime;
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public void insertGlobal(com.efs.sdk.base.core.config.GlobalInfo globalInfo) {
        insertCustomInfoSection();
        this.sectionList.addAll(0, globalInfo.getGlobalSectionList(getLogType()));
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public void setLogBeginTime(long j) {
        this.beginTime = j;
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public void setLogEndTime(long j) {
        this.endTime = j;
    }
}
