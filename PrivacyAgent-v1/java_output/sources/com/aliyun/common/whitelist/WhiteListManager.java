package com.aliyun.common.whitelist;

/* loaded from: classes.dex */
public class WhiteListManager {
    private static com.aliyun.common.whitelist.WhiteListManager sInstance = new com.aliyun.common.whitelist.WhiteListManager();
    private java.util.HashMap<java.lang.String, com.aliyun.common.whitelist.WhiteItem> mWhiteListMap = new java.util.HashMap<>();

    static {
        com.aliyun.common.whitelist.WhiteItem whiteItem = new com.aliyun.common.whitelist.WhiteItem(com.aliyun.common.whitelist.DeviceModelList.HUWEI.HUAWEI_P6);
        whiteItem.getPropertyValueExchanger().addPropertyEntry(com.aliyun.common.whitelist.PropertyValueExchanger.KEY_ENCODER_YUV420_FORMAT, 21, 39);
        com.aliyun.common.whitelist.WhiteItem whiteItem2 = new com.aliyun.common.whitelist.WhiteItem(com.aliyun.common.whitelist.DeviceModelList.HUWEI.HUAWEI_P9);
        whiteItem2.getPropertyValueExchanger().addPropertyEntry(com.aliyun.common.whitelist.PropertyValueExchanger.KEY_ENCODER_YUV420_FORMAT, 39, 21);
        com.aliyun.common.whitelist.WhiteItem whiteItem3 = new com.aliyun.common.whitelist.WhiteItem(com.aliyun.common.whitelist.DeviceModelList.HUWEI.HUAWEI_6Plus);
        whiteItem3.getPropertyValueExchanger().addPropertyEntry(com.aliyun.common.whitelist.PropertyValueExchanger.KEY_ENCODER_YUV420_FORMAT, 39, 21);
        com.aliyun.common.whitelist.WhiteItem whiteItem4 = new com.aliyun.common.whitelist.WhiteItem(com.aliyun.common.whitelist.DeviceModelList.HUWEI.HUAWEI_HONOR_6PLUS);
        whiteItem4.getPropertyValueExchanger().addPropertyEntry(com.aliyun.common.whitelist.PropertyValueExchanger.KEY_ENCODER_YUV420_FORMAT, 39, 21);
        com.aliyun.common.whitelist.WhiteItem whiteItem5 = new com.aliyun.common.whitelist.WhiteItem(com.aliyun.common.whitelist.DeviceModelList.HUWEI.HUAWEI_P9_EVA);
        whiteItem5.getPropertyValueExchanger().addPropertyEntry(com.aliyun.common.whitelist.PropertyValueExchanger.KEY_ENCODER_YUV420_FORMAT, 20, 19);
        com.aliyun.common.whitelist.WhiteItem whiteItem6 = new com.aliyun.common.whitelist.WhiteItem(com.aliyun.common.whitelist.DeviceModelList.HUWEI.HUAWEI_H60);
        whiteItem6.getPropertyValueExchanger().addPropertyEntry(com.aliyun.common.whitelist.PropertyValueExchanger.KEY_ENCODER_YUV420_FORMAT, 20, 19);
        com.aliyun.common.whitelist.WhiteItem whiteItem7 = new com.aliyun.common.whitelist.WhiteItem(com.aliyun.common.whitelist.DeviceModelList.HUWEI.HUAWEI_MATE7);
        whiteItem7.getPropertyValueExchanger().addPropertyEntry(com.aliyun.common.whitelist.PropertyValueExchanger.KEY_ENCODER_YUV420_FORMAT, 20, 19);
        sInstance.putWhiteItem(whiteItem.getDevice(), whiteItem);
        sInstance.putWhiteItem(whiteItem2.getDevice(), whiteItem2);
        sInstance.putWhiteItem(whiteItem3.getDevice(), whiteItem3);
        sInstance.putWhiteItem(whiteItem4.getDevice(), whiteItem4);
        sInstance.putWhiteItem(whiteItem5.getDevice(), whiteItem5);
        sInstance.putWhiteItem(whiteItem6.getDevice(), whiteItem6);
        sInstance.putWhiteItem(whiteItem7.getDevice(), whiteItem7);
    }

    public static com.aliyun.common.whitelist.WhiteListManager getInstance() {
        return sInstance;
    }

    public com.aliyun.common.whitelist.WhiteItem getWhiteItem(java.lang.String str) {
        return this.mWhiteListMap.get(str);
    }

    public void putWhiteItem(java.lang.String str, com.aliyun.common.whitelist.WhiteItem whiteItem) {
        this.mWhiteListMap.put(str, whiteItem);
    }
}
