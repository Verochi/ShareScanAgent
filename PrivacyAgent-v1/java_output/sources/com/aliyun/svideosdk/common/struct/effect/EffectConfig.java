package com.aliyun.svideosdk.common.struct.effect;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class EffectConfig {
    private java.lang.String module;
    private java.util.List<com.aliyun.svideosdk.common.struct.effect.EffectConfig.NodeBean> nodeTree;
    private int type;
    private int version;

    /* renamed from: com.aliyun.svideosdk.common.struct.effect.EffectConfig$1, reason: invalid class name */
    public class AnonymousClass1 extends com.google.gson.reflect.TypeToken<java.util.List<com.aliyun.svideosdk.common.struct.effect.EffectConfig.NodeBean.Params>> {
        public AnonymousClass1() {
        }
    }

    public static class NodeBean {
        private java.lang.String fragment;

        @com.google.gson.annotations.SerializedName("name")
        private java.lang.String nameX;
        private int nodeId;
        private java.util.List<com.aliyun.svideosdk.common.struct.effect.EffectConfig.NodeBean.Params> params;
        private java.util.List<com.aliyun.svideosdk.common.struct.effect.EffectConfig.NodeBean.Textures> textures;

        public static class Params {
            private transient com.aliyun.svideosdk.common.struct.effect.ValueTypeEnum.Value mMaxValue;
            private transient com.aliyun.svideosdk.common.struct.effect.ValueTypeEnum.Value mMinValue;
            private transient com.aliyun.svideosdk.common.struct.effect.ValueTypeEnum mType;
            private transient com.aliyun.svideosdk.common.struct.effect.ValueTypeEnum.Value mValue;
            private java.lang.Object[] maxValue;
            private java.lang.Object[] minValue;

            @com.google.gson.annotations.SerializedName("name")
            private java.lang.String nameX;
            private int nodeId;
            private java.lang.String type;
            private java.lang.Object[] value;

            public com.aliyun.svideosdk.common.struct.effect.ValueTypeEnum.Value getMaxValue() {
                if (this.mMaxValue == null) {
                    this.mMaxValue = com.aliyun.svideosdk.common.struct.effect.ValueTypeEnum.getValue(this.type, this.maxValue);
                }
                return this.mMaxValue;
            }

            public com.aliyun.svideosdk.common.struct.effect.ValueTypeEnum.Value getMinValue() {
                if (this.mMinValue == null) {
                    this.mMinValue = com.aliyun.svideosdk.common.struct.effect.ValueTypeEnum.getValue(this.type, this.minValue);
                }
                return this.mMinValue;
            }

            public java.lang.String getName() {
                return this.nameX;
            }

            public com.aliyun.svideosdk.common.struct.effect.ValueTypeEnum getType() {
                if (this.mType == null) {
                    this.mType = com.aliyun.svideosdk.common.struct.effect.ValueTypeEnum.typeOf(this.type);
                }
                return this.mType;
            }

            public com.aliyun.svideosdk.common.struct.effect.ValueTypeEnum.Value getValue() {
                if (this.mValue == null) {
                    this.mValue = com.aliyun.svideosdk.common.struct.effect.ValueTypeEnum.getValue(this.type, this.value);
                }
                return this.mValue;
            }
        }

        public static class Textures {

            @com.google.gson.annotations.SerializedName("name")
            private java.lang.String nameX;
            private int nodeId;
            private java.lang.String srcType;

            public java.lang.String getNameX() {
                return this.nameX;
            }

            public int getNodeId() {
                return this.nodeId;
            }

            public java.lang.String getSrcType() {
                return this.srcType;
            }
        }

        public java.util.List<com.aliyun.svideosdk.common.struct.effect.EffectConfig.NodeBean.Params> getParams() {
            return this.params;
        }

        public java.util.List<com.aliyun.svideosdk.common.struct.effect.EffectConfig.NodeBean.Textures> getTextures() {
            return this.textures;
        }
    }

    public java.util.List<com.aliyun.svideosdk.common.struct.effect.EffectConfig.NodeBean> getNodeTree() {
        return this.nodeTree;
    }

    public java.lang.String getParamsJsonString() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.List<com.aliyun.svideosdk.common.struct.effect.EffectConfig.NodeBean> nodeTree = getNodeTree();
        if (nodeTree == null) {
            return null;
        }
        for (com.aliyun.svideosdk.common.struct.effect.EffectConfig.NodeBean nodeBean : nodeTree) {
            if (nodeBean.params != null) {
                for (com.aliyun.svideosdk.common.struct.effect.EffectConfig.NodeBean.Params params : nodeBean.params) {
                    params.nodeId = nodeBean.nodeId;
                    if (params.mValue != null) {
                        java.lang.System.arraycopy(params.mValue.getValue(), 0, params.value, 0, params.value.length);
                    }
                    arrayList.add(params);
                }
            }
        }
        try {
            return new com.aliyun.common.jasonparse.JSONSupportImpl().writeValue(arrayList);
        } catch (java.lang.Exception e) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("EffectConfig getParamsJsonString failure! msg : ");
            sb.append(e.getMessage());
            return null;
        }
    }

    public void readParamsJson(java.lang.String str) {
        java.util.List<com.aliyun.svideosdk.common.struct.effect.EffectConfig.NodeBean> nodeTree;
        if (com.aliyun.common.utils.StringUtils.isEmpty(str)) {
            return;
        }
        try {
            java.util.List<com.aliyun.svideosdk.common.struct.effect.EffectConfig.NodeBean.Params> list = (java.util.List) new com.aliyun.common.jasonparse.JSONSupportImpl().readListValue(str, new com.aliyun.svideosdk.common.struct.effect.EffectConfig.AnonymousClass1().getType());
            if ((list == null || !list.isEmpty()) && (nodeTree = getNodeTree()) != null) {
                for (com.aliyun.svideosdk.common.struct.effect.EffectConfig.NodeBean nodeBean : nodeTree) {
                    if (nodeBean.params != null) {
                        for (com.aliyun.svideosdk.common.struct.effect.EffectConfig.NodeBean.Params params : nodeBean.params) {
                            for (com.aliyun.svideosdk.common.struct.effect.EffectConfig.NodeBean.Params params2 : list) {
                                if (params2.nodeId == nodeBean.nodeId && params2.nameX != null && params2.nameX.equals(params.nameX) && params2.value != null) {
                                    java.lang.System.arraycopy(params2.value, 0, params.value, 0, params.value.length);
                                }
                            }
                        }
                    }
                }
            }
        } catch (java.lang.Exception unused) {
        }
    }
}
