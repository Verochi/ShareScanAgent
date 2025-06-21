package com.anythink.core.api;

/* loaded from: classes12.dex */
public class ATNetworkConfig {
    java.util.List<com.anythink.core.api.ATInitConfig> mATInitConfigList;

    public static class Builder {
        java.util.List<com.anythink.core.api.ATInitConfig> mATInitConfigs;

        public com.anythink.core.api.ATNetworkConfig build() {
            com.anythink.core.api.ATNetworkConfig aTNetworkConfig = new com.anythink.core.api.ATNetworkConfig();
            aTNetworkConfig.mATInitConfigList = this.mATInitConfigs;
            return aTNetworkConfig;
        }

        public com.anythink.core.api.ATNetworkConfig.Builder withInitConfigList(java.util.List<com.anythink.core.api.ATInitConfig> list) {
            this.mATInitConfigs = list;
            return this;
        }
    }

    public java.util.List<com.anythink.core.api.ATInitConfig> getATInitConfigList() {
        return this.mATInitConfigList;
    }
}
