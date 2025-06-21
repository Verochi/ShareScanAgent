package com.aliyun.player;

/* loaded from: classes.dex */
public class VidPlayerConfigGen {
    private java.util.Map<java.lang.String, java.lang.Object> configMap = new java.util.HashMap();

    public enum EncryptType {
        Unencrypted,
        AliyunVodEncryption,
        HLSEncryption
    }

    public void addPlayerConfig(java.lang.String str, int i) {
        if (str != null) {
            this.configMap.put(str, java.lang.Integer.valueOf(i));
        }
    }

    public void addPlayerConfig(java.lang.String str, java.lang.String str2) {
        if (str != null) {
            this.configMap.put(str, str2);
        }
    }

    public java.lang.String genConfig() {
        if (this.configMap.isEmpty()) {
            return "";
        }
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        for (java.lang.String str : this.configMap.keySet()) {
            try {
                jSONObject.put(str, this.configMap.get(str));
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    public void setEncryptType(com.aliyun.player.VidPlayerConfigGen.EncryptType encryptType) {
        addPlayerConfig("EncryptType", encryptType == com.aliyun.player.VidPlayerConfigGen.EncryptType.AliyunVodEncryption ? "AliyunVoDEncryption" : encryptType.name());
    }

    public void setMtsHlsUriToken(java.lang.String str) {
        addPlayerConfig("MtsHlsUriToken", str);
    }

    public void setPreviewTime(int i) {
        addPlayerConfig("PreviewTime", i);
    }
}
