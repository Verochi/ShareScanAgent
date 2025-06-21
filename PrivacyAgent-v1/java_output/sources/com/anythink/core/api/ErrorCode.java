package com.anythink.core.api;

/* loaded from: classes12.dex */
public class ErrorCode {
    public static final java.lang.String adShowError = "4006";
    public static final java.lang.String adSourceBidError = "4007";
    public static final java.lang.String adSourceNotFilledError = "4008";
    public static final java.lang.String adapterInnerError = "2006";
    public static final java.lang.String adapterNotExistError = "2002";
    public static final java.lang.String appIdError = "10003";
    public static final java.lang.String appIdOrPlaceIdEmpty = "3002";
    public static final java.lang.String appKeyError = "10001";
    public static final java.lang.String c2sBiddingCacheError = "2012";
    public static final java.lang.String contextDestoryError = "4002";
    public static final java.lang.String dataLevelLowError = "9992";
    public static final java.lang.String exception = "9999";
    public static final java.lang.String filterByRefreshSystemSplash = "2015";
    public static final java.lang.String filterSourceError = "2010";
    public static final java.lang.String formatError = "3003";
    public static final java.lang.String httpStatuException = "9990";
    public static final java.lang.String inNetworkErrorCodeRequestFailPacing = "2014";
    public static final java.lang.String inPacingError = "2004";
    public static final java.lang.String inRequestFailPacing = "2007";
    public static final java.lang.String loadCappingError = "2009";
    public static final java.lang.String loadFailInPacingError = "2008";
    public static final java.lang.String loadInShowingFilter = "2011";
    public static final java.lang.String loadingError = "2005";
    public static final java.lang.String networkError = "1001";
    public static final java.lang.String networkFirmIdfilterSourceError = "2013";
    public static final java.lang.String noADError = "4001";
    public static final java.lang.String noAdsourceConfig = "4004";
    public static final java.lang.String noAdsourceConfigInDebugerMode = "4009";
    public static final java.lang.String noAvailableAdsource = "4005";
    public static final java.lang.String outOfCapError = "2003";
    public static final java.lang.String placeStrategyError = "3001";
    public static final java.lang.String placementAdClose = "4003";
    public static final java.lang.String placementIdError = "10004";
    public static final java.lang.String serverError = "1002";
    public static final java.lang.String sharedPlacementIdError = "10019";
    public static final java.lang.String statuError = "9991";
    public static final java.lang.String timeOutError = "2001";
    public static final java.lang.String unknown = "-9999";

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static com.anythink.core.api.AdError getErrorCode(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.lang.String str4;
        java.lang.String str5;
        java.lang.String str6;
        java.lang.String str7;
        java.lang.String str8;
        str.hashCode();
        int hashCode = str.hashCode();
        java.lang.String str9 = inPacingError;
        java.lang.String str10 = outOfCapError;
        java.lang.String str11 = adapterNotExistError;
        java.lang.String str12 = timeOutError;
        java.lang.String str13 = serverError;
        switch (hashCode) {
            case 1507424:
                str4 = networkError;
                str5 = inRequestFailPacing;
                str6 = loadingError;
                str7 = adapterInnerError;
                if (str.equals(str4)) {
                    r24 = 0;
                    break;
                }
                break;
            case 1507425:
                str5 = inRequestFailPacing;
                str6 = loadingError;
                str7 = adapterInnerError;
                r24 = str.equals(str13) ? (char) 1 : (char) 65535;
                str13 = str13;
                str4 = networkError;
                break;
            case 1537215:
                str5 = inRequestFailPacing;
                str6 = loadingError;
                str7 = adapterInnerError;
                r24 = str.equals(str12) ? (char) 2 : (char) 65535;
                str12 = str12;
                str4 = networkError;
                break;
            case 1537216:
                str5 = inRequestFailPacing;
                str6 = loadingError;
                str7 = adapterInnerError;
                r24 = str.equals(str11) ? (char) 3 : (char) 65535;
                str11 = str11;
                str4 = networkError;
                break;
            case 1537217:
                str5 = inRequestFailPacing;
                str6 = loadingError;
                str7 = adapterInnerError;
                r24 = str.equals(str10) ? (char) 4 : (char) 65535;
                str10 = str10;
                str4 = networkError;
                break;
            case 1537218:
                str5 = inRequestFailPacing;
                str6 = loadingError;
                str7 = adapterInnerError;
                r24 = str.equals(str9) ? (char) 5 : (char) 65535;
                str9 = str9;
                str4 = networkError;
                break;
            case 1537219:
                str8 = adapterInnerError;
                str5 = inRequestFailPacing;
                str6 = loadingError;
                if (str.equals(str6)) {
                    r24 = 6;
                }
                str7 = str8;
                str4 = networkError;
                break;
            case 1537220:
                str8 = adapterInnerError;
                r24 = str.equals(str8) ? (char) 7 : (char) 65535;
                str5 = inRequestFailPacing;
                str6 = loadingError;
                str7 = str8;
                str4 = networkError;
                break;
            case 1537221:
                if (str.equals(inRequestFailPacing)) {
                    r24 = '\b';
                }
                str4 = networkError;
                str5 = inRequestFailPacing;
                str6 = loadingError;
                str7 = adapterInnerError;
                break;
            case 1537222:
                if (str.equals(loadFailInPacingError)) {
                    r24 = '\t';
                }
                str4 = networkError;
                str5 = inRequestFailPacing;
                str6 = loadingError;
                str7 = adapterInnerError;
                break;
            case 1537223:
                if (str.equals(loadCappingError)) {
                    r24 = '\n';
                }
                str4 = networkError;
                str5 = inRequestFailPacing;
                str6 = loadingError;
                str7 = adapterInnerError;
                break;
            case 1537246:
                if (str.equals(loadInShowingFilter)) {
                    r24 = 11;
                }
                str4 = networkError;
                str5 = inRequestFailPacing;
                str6 = loadingError;
                str7 = adapterInnerError;
                break;
            case 1537247:
                if (str.equals(c2sBiddingCacheError)) {
                    r24 = '\f';
                }
                str4 = networkError;
                str5 = inRequestFailPacing;
                str6 = loadingError;
                str7 = adapterInnerError;
                break;
            case 1537248:
                if (str.equals(networkFirmIdfilterSourceError)) {
                    r24 = '\r';
                }
                str4 = networkError;
                str5 = inRequestFailPacing;
                str6 = loadingError;
                str7 = adapterInnerError;
                break;
            case 1537250:
                if (str.equals(filterByRefreshSystemSplash)) {
                    r24 = 14;
                }
                str4 = networkError;
                str5 = inRequestFailPacing;
                str6 = loadingError;
                str7 = adapterInnerError;
                break;
            case 1567006:
                if (str.equals(placeStrategyError)) {
                    r24 = 15;
                }
                str4 = networkError;
                str5 = inRequestFailPacing;
                str6 = loadingError;
                str7 = adapterInnerError;
                break;
            case 1567007:
                if (str.equals(appIdOrPlaceIdEmpty)) {
                    r24 = 16;
                }
                str4 = networkError;
                str5 = inRequestFailPacing;
                str6 = loadingError;
                str7 = adapterInnerError;
                break;
            case 1567008:
                if (str.equals(formatError)) {
                    r24 = 17;
                }
                str4 = networkError;
                str5 = inRequestFailPacing;
                str6 = loadingError;
                str7 = adapterInnerError;
                break;
            case 1596797:
                if (str.equals(noADError)) {
                    r24 = 18;
                }
                str4 = networkError;
                str5 = inRequestFailPacing;
                str6 = loadingError;
                str7 = adapterInnerError;
                break;
            case 1596798:
                if (str.equals(contextDestoryError)) {
                    r24 = 19;
                }
                str4 = networkError;
                str5 = inRequestFailPacing;
                str6 = loadingError;
                str7 = adapterInnerError;
                break;
            case 1596799:
                if (str.equals(placementAdClose)) {
                    r24 = 20;
                }
                str4 = networkError;
                str5 = inRequestFailPacing;
                str6 = loadingError;
                str7 = adapterInnerError;
                break;
            case 1596800:
                if (str.equals(noAdsourceConfig)) {
                    r24 = 21;
                }
                str4 = networkError;
                str5 = inRequestFailPacing;
                str6 = loadingError;
                str7 = adapterInnerError;
                break;
            case 1596801:
                if (str.equals(noAvailableAdsource)) {
                    r24 = 22;
                }
                str4 = networkError;
                str5 = inRequestFailPacing;
                str6 = loadingError;
                str7 = adapterInnerError;
                break;
            case 1596802:
                if (str.equals(adShowError)) {
                    r24 = 23;
                }
                str4 = networkError;
                str5 = inRequestFailPacing;
                str6 = loadingError;
                str7 = adapterInnerError;
                break;
            case 1596803:
                if (str.equals(adSourceBidError)) {
                    r24 = 24;
                }
                str4 = networkError;
                str5 = inRequestFailPacing;
                str6 = loadingError;
                str7 = adapterInnerError;
                break;
            case 1596804:
                if (str.equals(adSourceNotFilledError)) {
                    r24 = 25;
                }
                str4 = networkError;
                str5 = inRequestFailPacing;
                str6 = loadingError;
                str7 = adapterInnerError;
                break;
            case 1596805:
                if (str.equals(noAdsourceConfigInDebugerMode)) {
                    r24 = com.alibaba.fastjson.parser.JSONLexer.EOI;
                }
                str4 = networkError;
                str5 = inRequestFailPacing;
                str6 = loadingError;
                str7 = adapterInnerError;
                break;
            case 1754679:
                if (str.equals(httpStatuException)) {
                    r24 = 27;
                }
                str4 = networkError;
                str5 = inRequestFailPacing;
                str6 = loadingError;
                str7 = adapterInnerError;
                break;
            case 1754680:
                if (str.equals(statuError)) {
                    r24 = 28;
                }
                str4 = networkError;
                str5 = inRequestFailPacing;
                str6 = loadingError;
                str7 = adapterInnerError;
                break;
            case 1754681:
                if (str.equals(dataLevelLowError)) {
                    r24 = 29;
                }
                str4 = networkError;
                str5 = inRequestFailPacing;
                str6 = loadingError;
                str7 = adapterInnerError;
                break;
            case 1754688:
                if (str.equals(exception)) {
                    r24 = 30;
                }
                str4 = networkError;
                str5 = inRequestFailPacing;
                str6 = loadingError;
                str7 = adapterInnerError;
                break;
            case 46730162:
                if (str.equals("10001")) {
                    r24 = 31;
                }
                str4 = networkError;
                str5 = inRequestFailPacing;
                str6 = loadingError;
                str7 = adapterInnerError;
                break;
            case 46730164:
                if (str.equals(appIdError)) {
                    r24 = ' ';
                }
                str4 = networkError;
                str5 = inRequestFailPacing;
                str6 = loadingError;
                str7 = adapterInnerError;
                break;
            case 46730165:
                if (str.equals(placementIdError)) {
                    r24 = '!';
                }
                str4 = networkError;
                str5 = inRequestFailPacing;
                str6 = loadingError;
                str7 = adapterInnerError;
                break;
            case 46730201:
                if (str.equals(sharedPlacementIdError)) {
                    r24 = kotlin.text.Typography.quote;
                }
                str4 = networkError;
                str5 = inRequestFailPacing;
                str6 = loadingError;
                str7 = adapterInnerError;
                break;
            default:
                str4 = networkError;
                str5 = inRequestFailPacing;
                str6 = loadingError;
                str7 = adapterInnerError;
                break;
        }
        switch (r24) {
            case 0:
                return new com.anythink.core.api.AdError(str4, "Network is unavailable.", str2, str3);
            case 1:
                return new com.anythink.core.api.AdError(str13, "Server is unavailable.", str2, str3);
            case 2:
                return new com.anythink.core.api.AdError(str12, "Ad load time out.", str2, str3);
            case 3:
                return new com.anythink.core.api.AdError(str11, "Adapter does not exist.", str2, str3);
            case 4:
                return new com.anythink.core.api.AdError(str10, "Not satisfy the Placement's Cap configuration.", str2, str3);
            case 5:
                return new com.anythink.core.api.AdError(str9, "Not satisfy the Placement's Placing configuration.", str2, str3);
            case 6:
                return new com.anythink.core.api.AdError(str6, "Placement's Ad is loading.", str2, str3);
            case 7:
                return new com.anythink.core.api.AdError(str7, "Please check if your network sdk version is correct and all the network plugin has been put in your package.", str2, str3);
            case '\b':
                return new com.anythink.core.api.AdError(str5, "Not satisfy the Fail-request's Placing configuration.", str2, str3);
            case '\t':
                return new com.anythink.core.api.AdError(loadFailInPacingError, "The placement load too frequent within the specified time period after the previous load failure.", str2, str3);
            case '\n':
                return new com.anythink.core.api.AdError(loadCappingError, "The placement load too many times within the specified time period.", str2, str3);
            case 11:
                return new com.anythink.core.api.AdError(loadInShowingFilter, "This unitgroup can't load on showing.", str2, str3);
            case '\f':
                return new com.anythink.core.api.AdError(c2sBiddingCacheError, "C2S Bidding Cache error.", str2, str3);
            case '\r':
                return new com.anythink.core.api.AdError(noAdsourceConfigInDebugerMode, "AdSource filter by network firm id.", str2, str3);
            case 14:
                return new com.anythink.core.api.AdError(filterByRefreshSystemSplash, "System splash not allow preload.", str2, str3);
            case 15:
                return new com.anythink.core.api.AdError(placeStrategyError, "Get placement strategy error, please check your network or your appid、appkey and placementid is availiable.", str2, str3);
            case 16:
                return new com.anythink.core.api.AdError(appIdOrPlaceIdEmpty, "AppId or PlacementId is empty.", str2, str3);
            case 17:
                return new com.anythink.core.api.AdError(formatError, "Mismatched ad placement and ad format", str2, str3);
            case 18:
                return new com.anythink.core.api.AdError(noADError, "Return Ad is empty.", str2, str3);
            case 19:
                return new com.anythink.core.api.AdError(contextDestoryError, "Context or activity has been destory.", str2, str3);
            case 20:
                return new com.anythink.core.api.AdError(placementAdClose, "Placement Ads switch is close.", str2, str3);
            case 21:
                return new com.anythink.core.api.AdError(noAdsourceConfig, "The placement strategy does not contain any ad sources, please check the mediation configuration in AT", str2, str3);
            case 22:
                return new com.anythink.core.api.AdError(noAvailableAdsource, "Ad sources are filtered, no ad source is currently available", str2, str3);
            case 23:
                return new com.anythink.core.api.AdError(adShowError, "Ad show failed", str2, str3);
            case 24:
                return new com.anythink.core.api.AdError(adSourceBidError, "Bid error", str2, str3);
            case 25:
                return new com.anythink.core.api.AdError(adSourceNotFilledError, "Ad source not filled, cause by customize fillter.", str2, str3);
            case 26:
                return new com.anythink.core.api.AdError(noAdsourceConfigInDebugerMode, "The placement strategy does not contain any ad sources, please check the debugger configuration in ATSDK.setDebuggerConfig", str2, str3);
            case 27:
                return new com.anythink.core.api.AdError(httpStatuException, "Https status exception.", str2, str3);
            case 28:
                return new com.anythink.core.api.AdError(statuError, "Service status error.", str2, str3);
            case 29:
                return new com.anythink.core.api.AdError(dataLevelLowError, "Upload data level is FORBIDDEN, must called 'ATSDK.setGDPRUploadDataLevel' to set the level.", str2, str3);
            case 30:
                return new com.anythink.core.api.AdError(exception, "Exception in sdk.", str2, str3);
            case 31:
                return new com.anythink.core.api.AdError("10001", "Please check your appkey.", str2, str3);
            case ' ':
                return new com.anythink.core.api.AdError(appIdError, "Please check your appid.", str2, str3);
            case '!':
                return new com.anythink.core.api.AdError(placementIdError, "Please check your placementid.", str2, str3);
            case '\"':
                return new com.anythink.core.api.AdError(sharedPlacementIdError, "Forbidden placement", str2, str3);
            default:
                return new com.anythink.core.api.AdError("-9999", "unknown", str2, str3);
        }
    }
}
