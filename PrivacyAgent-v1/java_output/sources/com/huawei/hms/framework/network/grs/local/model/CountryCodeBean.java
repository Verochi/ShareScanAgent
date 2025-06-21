package com.huawei.hms.framework.network.grs.local.model;

/* loaded from: classes22.dex */
public class CountryCodeBean {
    private static final java.lang.String ANDRIOD_SYSTEMPROP = "android.os.SystemProperties";
    private static final int ANDROID_9_API_LEVEL = 28;
    private static final int COUNTRYCODE_SIZE = 2;
    private static final java.lang.String KEY_VERSION_EMUI = "ro.build.version.emui";
    private static final java.lang.String LOCALE_COUNTRYSYSTEMPROP = "ro.product.locale";
    private static final java.lang.String LOCALE_REGION_COUNTRYSYSTEMPROP = "ro.product.locale.region";
    private static final java.lang.String SPECIAL_COUNTRYCODE_CN = "cn";
    private static final java.lang.String SPECIAL_COUNTRYCODE_EU = "eu";
    private static final java.lang.String SPECIAL_COUNTRYCODE_GB = "gb";
    private static final java.lang.String SPECIAL_COUNTRYCODE_LA = "la";
    private static final java.lang.String SPECIAL_COUNTRYCODE_UK = "uk";
    private static final java.lang.String TAG = "CountryCodeBean";
    private static final java.lang.String VENDORCOUNTRY_SYSTEMPROP = "ro.hw.country";
    private java.lang.String countryCode;
    private java.lang.String countrySource = com.huawei.hms.framework.network.grs.GrsBaseInfo.CountryCodeSource.UNKNOWN;

    public CountryCodeBean(android.content.Context context, boolean z) {
        this.countryCode = com.huawei.hms.framework.network.grs.GrsBaseInfo.CountryCodeSource.UNKNOWN;
        init(context, z);
        this.countryCode = this.countryCode.toUpperCase(java.util.Locale.ENGLISH);
    }

    private void checkCodeLenth() {
        java.lang.String str = this.countryCode;
        if (str == null || str.length() != 2) {
            this.countryCode = com.huawei.hms.framework.network.grs.GrsBaseInfo.CountryCodeSource.UNKNOWN;
            this.countrySource = com.huawei.hms.framework.network.grs.GrsBaseInfo.CountryCodeSource.UNKNOWN;
        }
    }

    private void getLocaleCountryCode() {
        java.lang.String str;
        java.lang.String str2;
        if (com.huawei.hms.framework.common.SystemPropUtils.getProperty(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, "ro.build.version.emui", ANDRIOD_SYSTEMPROP, "").isEmpty()) {
            if (android.os.Build.VERSION.SDK_INT >= 28 || android.os.Build.VERSION.RELEASE.charAt(0) >= '9') {
                getRegionSettingCountryCode();
                str = TAG;
                str2 = "other Android 9.0 upper， get countryCode form Locale.getDefault().getCountry()";
            } else {
                getProductCountryCode();
                str = TAG;
                str2 = "other Android 9.0 lower, get countryCode form ro.product.locale.region or locale";
            }
        } else if (com.huawei.hms.framework.common.EmuiUtil.isUpPVersion()) {
            getRegionSettingCountryCode();
            str = TAG;
            str2 = "EMUI 9.0 upper System, get countryCode form Locale.getDefault().getCountry()";
        } else {
            getProductCountryCode();
            str = TAG;
            str2 = "EMUI 9.0 lower System, get countryCode form ro.product.locale.region or locale";
        }
        com.huawei.hms.framework.common.Logger.i(str, str2);
        this.countrySource = com.huawei.hms.framework.network.grs.GrsBaseInfo.CountryCodeSource.LOCALE_INFO;
    }

    private void getProductCountryCode() {
        int lastIndexOf;
        this.countryCode = com.huawei.hms.framework.common.SystemPropUtils.getProperty(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, LOCALE_REGION_COUNTRYSYSTEMPROP, ANDRIOD_SYSTEMPROP, com.huawei.hms.framework.network.grs.GrsBaseInfo.CountryCodeSource.UNKNOWN);
        java.lang.String str = TAG;
        com.huawei.hms.framework.common.Logger.i(str, "countryCode by ro.product.locale.region is:" + this.countryCode);
        if (android.text.TextUtils.isEmpty(this.countryCode) || com.huawei.hms.framework.network.grs.GrsBaseInfo.CountryCodeSource.UNKNOWN.equals(this.countryCode)) {
            java.lang.String property = com.huawei.hms.framework.common.SystemPropUtils.getProperty(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, LOCALE_COUNTRYSYSTEMPROP, ANDRIOD_SYSTEMPROP, com.huawei.hms.framework.network.grs.GrsBaseInfo.CountryCodeSource.UNKNOWN);
            if (!android.text.TextUtils.isEmpty(property) && (lastIndexOf = property.lastIndexOf(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER)) != -1) {
                this.countryCode = property.substring(lastIndexOf + 1);
                com.huawei.hms.framework.common.Logger.i(str, "countryCode by ro.product.locale is:" + this.countryCode);
            }
        }
        if ("cn".equalsIgnoreCase(this.countryCode)) {
            return;
        }
        this.countryCode = com.huawei.hms.framework.network.grs.GrsBaseInfo.CountryCodeSource.UNKNOWN;
    }

    private void getRegionSettingCountryCode() {
        this.countryCode = java.util.Locale.getDefault().getCountry();
        com.huawei.hms.framework.common.Logger.i(TAG, "countryCode by system's region setting is: " + this.countryCode);
        if (android.text.TextUtils.isEmpty(this.countryCode)) {
            this.countryCode = com.huawei.hms.framework.network.grs.GrsBaseInfo.CountryCodeSource.UNKNOWN;
        }
    }

    private void getSimCountryCode(android.content.Context context) {
        getSimCountryCode(context, false);
    }

    private void getSimCountryCode(android.content.Context context, boolean z) {
        java.lang.String str;
        java.lang.StringBuilder sb;
        java.lang.String str2;
        android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getApplicationContext().getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE);
        if (telephonyManager != null) {
            if (!z || telephonyManager.getPhoneType() == 2) {
                this.countryCode = telephonyManager.getSimCountryIso();
                this.countrySource = com.huawei.hms.framework.network.grs.GrsBaseInfo.CountryCodeSource.SIM_COUNTRY;
                str = TAG;
                sb = new java.lang.StringBuilder();
                str2 = "countryCode by SimCountryIso is: ";
            } else {
                this.countryCode = telephonyManager.getNetworkCountryIso();
                this.countrySource = com.huawei.hms.framework.network.grs.GrsBaseInfo.CountryCodeSource.NETWORK_COUNTRY;
                str = TAG;
                sb = new java.lang.StringBuilder();
                str2 = "countryCode by NetworkCountryIso is: ";
            }
            sb.append(str2);
            sb.append(this.countryCode);
            com.huawei.hms.framework.common.Logger.i(str, sb.toString());
        }
        checkCodeLenth();
    }

    private void getVendorCountryCode() {
        this.countrySource = com.huawei.hms.framework.network.grs.GrsBaseInfo.CountryCodeSource.VENDOR_COUNTRY;
        this.countryCode = com.huawei.hms.framework.common.SystemPropUtils.getProperty(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, VENDORCOUNTRY_SYSTEMPROP, ANDRIOD_SYSTEMPROP, com.huawei.hms.framework.network.grs.GrsBaseInfo.CountryCodeSource.UNKNOWN);
        java.lang.String str = TAG;
        com.huawei.hms.framework.common.Logger.i(str, "countryCode by ro.hw.country is: " + this.countryCode);
        if (SPECIAL_COUNTRYCODE_EU.equalsIgnoreCase(this.countryCode) || SPECIAL_COUNTRYCODE_LA.equalsIgnoreCase(this.countryCode)) {
            this.countryCode = com.huawei.hms.framework.network.grs.GrsBaseInfo.CountryCodeSource.UNKNOWN;
            this.countrySource = com.huawei.hms.framework.network.grs.GrsBaseInfo.CountryCodeSource.UNKNOWN;
        } else {
            if (!SPECIAL_COUNTRYCODE_UK.equalsIgnoreCase(this.countryCode)) {
                checkCodeLenth();
                return;
            }
            com.huawei.hms.framework.common.Logger.i(str, "special country of UK to map GB.");
            this.countryCode = SPECIAL_COUNTRYCODE_GB;
            this.countrySource = com.huawei.hms.framework.network.grs.GrsBaseInfo.CountryCodeSource.VENDOR_COUNTRY;
        }
    }

    private void init(android.content.Context context, boolean z) {
        if (context == null) {
            throw new java.lang.NullPointerException("context must be not null.Please provide app's Context");
        }
        try {
            getVendorCountryCode();
            if (isCodeValidate()) {
                com.huawei.hms.framework.common.Logger.i(TAG, "get issue_country code from VENDOR_COUNTRY");
                return;
            }
            getSimCountryCode(context);
            if (isCodeValidate()) {
                com.huawei.hms.framework.common.Logger.i(TAG, "get issue_country code from SIM_COUNTRY");
                return;
            }
            getLocaleCountryCode();
            if (isCodeValidate()) {
                com.huawei.hms.framework.common.Logger.i(TAG, "get issue_country code from LOCALE_INFO");
            }
        } catch (java.lang.Exception unused) {
            com.huawei.hms.framework.common.Logger.w(TAG, "get CountryCode error");
        }
    }

    private boolean isCodeValidate() {
        return !com.huawei.hms.framework.network.grs.GrsBaseInfo.CountryCodeSource.UNKNOWN.equals(this.countryCode);
    }

    public java.lang.String getCountryCode() {
        return this.countryCode;
    }

    public java.lang.String getCountrySource() {
        return this.countrySource;
    }
}
