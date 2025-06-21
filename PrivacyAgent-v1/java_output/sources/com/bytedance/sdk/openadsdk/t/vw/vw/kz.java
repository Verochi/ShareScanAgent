package com.bytedance.sdk.openadsdk.t.vw.vw;

/* loaded from: classes22.dex */
public final class kz implements com.bykv.vk.openvk.api.proto.Bridge, com.bytedance.sdk.openadsdk.FilterWord {
    private final com.bykv.vk.openvk.api.proto.Bridge vw;
    private com.bytedance.sdk.openadsdk.FilterWord wg;

    public kz(com.bykv.vk.openvk.api.proto.Bridge bridge) {
        this.vw = bridge == null ? com.bykv.vw.vw.vw.vw.wg.wg : bridge;
    }

    public kz(com.bytedance.sdk.openadsdk.FilterWord filterWord) {
        this.wg = filterWord;
        this.vw = com.bykv.vw.vw.vw.vw.wg.wg;
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public void addOption(com.bytedance.sdk.openadsdk.FilterWord filterWord) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(1);
        vw.vw(0, new com.bytedance.sdk.openadsdk.t.vw.vw.kz(filterWord));
        this.vw.call(241101, vw.wg(), java.lang.Void.class);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, com.bykv.vk.openvk.api.proto.ValueSet valueSet, java.lang.Class<T> cls) {
        com.bytedance.sdk.openadsdk.FilterWord filterWord = this.wg;
        if (filterWord == null) {
            return null;
        }
        switch (i) {
            case 241101:
                this.wg.addOption(new com.bytedance.sdk.openadsdk.t.vw.vw.kz((com.bykv.vk.openvk.api.proto.Bridge) valueSet.objectValue(0, com.bykv.vk.openvk.api.proto.Bridge.class)));
                return null;
            case 241102:
                this.wg.setIsSelected(valueSet.booleanValue(0));
                return null;
            case 241103:
                return (T) filterWord.getId();
            case 241104:
                return (T) filterWord.getName();
            case 241105:
                return (T) java.lang.Boolean.class.cast(java.lang.Boolean.valueOf(filterWord.getIsSelected()));
            case 241106:
                return (T) java.lang.Boolean.class.cast(java.lang.Boolean.valueOf(filterWord.hasSecondOptions()));
            case 241107:
                return (T) java.lang.Boolean.class.cast(java.lang.Boolean.valueOf(filterWord.isValid()));
            case 241108:
                return (T) filterWord.getOptions();
            default:
                return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public java.lang.String getId() {
        return (java.lang.String) this.vw.call(241103, com.bykv.vw.vw.vw.vw.wg.vw(0).wg(), java.lang.String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public boolean getIsSelected() {
        return ((java.lang.Boolean) this.vw.call(241105, com.bykv.vw.vw.vw.vw.wg.vw(0).wg(), java.lang.Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public java.lang.String getName() {
        return (java.lang.String) this.vw.call(241104, com.bykv.vw.vw.vw.vw.wg.vw(0).wg(), java.lang.String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public java.util.List<com.bytedance.sdk.openadsdk.FilterWord> getOptions() {
        java.util.List list = (java.util.List) this.vw.call(241108, com.bykv.vw.vw.vw.vw.wg.vw(0).wg(), java.util.List.class);
        if (list == null) {
            list = new java.util.ArrayList(0);
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new com.bytedance.sdk.openadsdk.t.vw.vw.kz((com.bykv.vk.openvk.api.proto.Bridge) it.next()));
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public boolean hasSecondOptions() {
        return ((java.lang.Boolean) this.vw.call(241106, com.bykv.vw.vw.vw.vw.wg.vw(0).wg(), java.lang.Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public boolean isValid() {
        return ((java.lang.Boolean) this.vw.call(241107, com.bykv.vw.vw.vw.vw.wg.vw(0).wg(), java.lang.Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public void setIsSelected(boolean z) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(1);
        vw.vw(0, z);
        this.vw.call(241102, vw.wg(), java.lang.Void.class);
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public com.bykv.vk.openvk.api.proto.ValueSet values() {
        return com.bykv.vw.vw.vw.vw.wg.vw;
    }
}
