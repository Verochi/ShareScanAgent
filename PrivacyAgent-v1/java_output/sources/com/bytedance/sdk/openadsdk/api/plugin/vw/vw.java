package com.bytedance.sdk.openadsdk.api.plugin.vw;

/* loaded from: classes22.dex */
public final class vw implements com.bykv.vk.openvk.api.proto.Bridge {
    private static volatile com.bytedance.sdk.openadsdk.api.plugin.vw.vw vw;

    private com.bytedance.pangle.plugin.Plugin vw(com.bykv.vk.openvk.api.proto.ValueSet valueSet) {
        if (valueSet == null) {
            return null;
        }
        java.lang.String stringValue = valueSet.stringValue(0);
        if (android.text.TextUtils.isEmpty(stringValue)) {
            return null;
        }
        return com.bytedance.pangle.Zeus.getPlugin(stringValue);
    }

    public static com.bytedance.sdk.openadsdk.api.plugin.vw.vw vw() {
        if (vw == null) {
            synchronized (com.bytedance.sdk.openadsdk.api.plugin.vw.vw.class) {
                if (vw == null) {
                    vw = new com.bytedance.sdk.openadsdk.api.plugin.vw.vw();
                }
            }
        }
        return vw;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0082  */
    @Override // com.bykv.vk.openvk.api.proto.Caller
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> T call(int i, com.bykv.vk.openvk.api.proto.ValueSet valueSet, java.lang.Class<T> cls) {
        switch (i) {
            case 4:
                if (valueSet != null) {
                    return (T) com.bytedance.pangle.Zeus.getPlugin(valueSet.stringValue(0)).mClassLoader;
                }
                return null;
            case 5:
                return (T) java.lang.Boolean.valueOf(valueSet != null ? com.bytedance.pangle.Zeus.loadPlugin(valueSet.stringValue(0)) : false);
            case 6:
                return (T) java.lang.Boolean.valueOf(valueSet != null ? com.bytedance.pangle.Zeus.isPluginInstalled(valueSet.stringValue(0)) : false);
            case 7:
                return (T) java.lang.Boolean.valueOf(valueSet != null ? com.bytedance.pangle.Zeus.isPluginLoaded(valueSet.stringValue(0)) : false);
            case 8:
                java.lang.CharSequence charSequence = valueSet != null ? (T) com.bytedance.sdk.openadsdk.api.plugin.yl.vw(valueSet.stringValue(0)) : (T) "";
                return android.text.TextUtils.isEmpty(charSequence) ? "0.0.0.0" : (T) charSequence;
            default:
                switch (i) {
                    case 100:
                        if (valueSet != null) {
                            com.bytedance.pangle.Zeus.unInstallPlugin(valueSet.stringValue(0));
                        }
                        return null;
                    case 101:
                        com.bytedance.pangle.plugin.Plugin vw2 = vw(valueSet);
                        if (vw2 != null) {
                            return (T) java.lang.Integer.valueOf(vw2.getApiVersionCode());
                        }
                        return null;
                    case 102:
                        com.bytedance.pangle.plugin.Plugin vw3 = vw(valueSet);
                        if (vw3 != null) {
                            return (T) java.lang.Integer.valueOf(vw3.getInternalVersionCode());
                        }
                        return null;
                    case 103:
                        com.bytedance.pangle.plugin.Plugin vw4 = vw(valueSet);
                        if (vw4 != null) {
                            return (T) java.lang.Integer.valueOf(vw4.getVersion());
                        }
                        return null;
                    case 104:
                        break;
                    case 105:
                        break;
                    case 106:
                        com.bytedance.sdk.openadsdk.TTPluginListener tTPluginListener = valueSet != null ? (com.bytedance.sdk.openadsdk.TTPluginListener) valueSet.objectValue(0, com.bytedance.sdk.openadsdk.TTPluginListener.class) : null;
                        if (tTPluginListener != null) {
                            com.bytedance.sdk.openadsdk.api.plugin.yl.vw(com.bytedance.sdk.openadsdk.TTAppContextHolder.getContext()).wg(tTPluginListener);
                        }
                    default:
                        return null;
                }
                break;
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public com.bykv.vk.openvk.api.proto.ValueSet values() {
        return com.bykv.vw.vw.vw.vw.wg.vw().vw(10000, 4).wg();
    }
}
