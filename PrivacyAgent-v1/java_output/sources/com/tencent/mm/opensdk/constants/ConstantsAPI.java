package com.tencent.mm.opensdk.constants;

/* loaded from: classes19.dex */
public interface ConstantsAPI {
    public static final java.lang.String ACTION_HANDLE_APP_REGISTER = "com.tencent.mm.plugin.openapi.Intent.ACTION_HANDLE_APP_REGISTER";
    public static final java.lang.String ACTION_HANDLE_APP_UNREGISTER = "com.tencent.mm.plugin.openapi.Intent.ACTION_HANDLE_APP_UNREGISTER";
    public static final java.lang.String ACTION_REFRESH_WXAPP = "com.tencent.mm.plugin.openapi.Intent.ACTION_REFRESH_WXAPP";
    public static final java.lang.String APP_PACKAGE = "_mmessage_appPackage";
    public static final java.lang.String APP_SUPORT_CONTENT_TYPE = "_mmessage_support_content_type";
    public static final java.lang.String CHECK_SUM = "_mmessage_checksum";
    public static final int COMMAND_ADD_CARD_TO_EX_CARD_PACKAGE = 9;
    public static final int COMMAND_CHOOSE_CARD_FROM_EX_CARD_PACKAGE = 16;
    public static final int COMMAND_CREATE_CHATROOM = 14;
    public static final int COMMAND_GETMESSAGE_FROM_WX = 3;
    public static final int COMMAND_HANDLE_SCAN_RESULT = 17;
    public static final int COMMAND_INVOICE_AUTH_INSERT = 20;
    public static final int COMMAND_JOINT_PAY = 27;
    public static final int COMMAND_JOIN_CHATROOM = 15;
    public static final int COMMAND_JUMP_BIZ_TEMPSESSION = 10;
    public static final int COMMAND_JUMP_BIZ_WEBVIEW = 8;
    public static final int COMMAND_JUMP_TO_BIZ_PROFILE = 7;
    public static final int COMMAND_JUMP_TO_OFFLINE_PAY = 24;
    public static final int COMMAND_LAUNCH_BY_WX = 6;
    public static final int COMMAND_LAUNCH_WX_MINIPROGRAM = 19;
    public static final int COMMAND_LAUNCH_WX_MINIPROGRAM_WITH_TOKEN = 29;
    public static final int COMMAND_LAUNCH_WX_SEND_TDI_AUTH = 31;
    public static final int COMMAND_LAUNCH_WX_WXA_REDIRECTING_PAGE = 30;
    public static final int COMMAND_NON_TAX_PAY = 21;
    public static final int COMMAND_OPEN_BUSINESS_VIEW = 26;
    public static final int COMMAND_OPEN_BUSINESS_WEBVIEW = 25;
    public static final int COMMAND_OPEN_BUSI_LUCKY_MONEY = 13;
    public static final int COMMAND_OPEN_RANK_LIST = 11;
    public static final int COMMAND_OPEN_WEBVIEW = 12;
    public static final int COMMAND_PAY_BY_WX = 5;
    public static final int COMMAND_PAY_INSURANCE = 22;
    public static final int COMMAND_PRELOAD_MINI_PROGRAM = 28;
    public static final int COMMAND_SENDAUTH = 1;
    public static final int COMMAND_SENDMESSAGE_TO_WX = 2;
    public static final int COMMAND_SHOWMESSAGE_FROM_WX = 4;
    public static final int COMMAND_SUBSCRIBE_MESSAGE = 18;
    public static final int COMMAND_SUBSCRIBE_MINI_PROGRAM_MSG = 23;
    public static final int COMMAND_UNKNOWN = 0;
    public static final java.lang.String CONTENT = "_mmessage_content";
    public static final java.lang.String SDK_VERSION = "_mmessage_sdkVersion";
    public static final java.lang.String TOKEN = "_message_token";

    public static final class AppSupportContentFlag {
        public static final long MMAPP_SUPPORT_AUDIO = 16;
        public static final long MMAPP_SUPPORT_DOC = 64;
        public static final long MMAPP_SUPPORT_DOCX = 128;
        public static final long MMAPP_SUPPORT_LOCATION = 4;
        public static final long MMAPP_SUPPORT_PDF = 4096;
        public static final long MMAPP_SUPPORT_PICTURE = 2;
        public static final long MMAPP_SUPPORT_PPT = 256;
        public static final long MMAPP_SUPPORT_PPTX = 512;
        public static final long MMAPP_SUPPORT_TEXT = 1;
        public static final long MMAPP_SUPPORT_VIDEO = 8;
        public static final long MMAPP_SUPPORT_WEBPAGE = 32;
        public static final long MMAPP_SUPPORT_XLS = 1024;
        public static final long MMAPP_SUPPORT_XLSX = 2048;
    }

    public static final class LaunchWX {
        public static final int LAUNCH_PENDING_INTENT_REQUEST_CODE = 1;
        public static final int LAUNCH_PENDING_INTENT_SEND_CODE = 2;
        public static final int LAUNCH_WX_ENTRY_PENDING_INTENT_REQUEST_CODE = 3;
        public static final int LAUNCH_WX_ENTRY_PENDING_INTENT_SEND_CODE = 4;
    }

    public interface OpenWebviewType {
        public static final int TYPE_INVOICE_AUTH_INSERT = 2;
        public static final int TYPE_NONTAX_PAY = 3;
        public static final int TYPE_PAYINSURANCE = 4;
        public static final int TYPE_SUBSCRIBE_MESSAGE = 1;
        public static final int TYPE_SUBSCRIBE_MINI_PROGRAM_MSG = 5;
    }

    public static final class Token {
        public static final java.lang.String WX_LAUNCH_PARAM_KEY = "launchParam";
        public static final java.lang.String WX_TOKEN_KEY = "wx_token_key";
        public static final java.lang.String WX_TOKEN_PLATFORMID_KEY = "platformId";
        public static final java.lang.String WX_TOKEN_PLATFORMID_VALUE = "wechat";
        public static final java.lang.String WX_TOKEN_VALUE_MSG = "com.tencent.mm.openapi.token";
    }

    public static final class WXApp {
        public static final java.lang.String WXAPP_BROADCAST_PERMISSION = "com.tencent.mm.permission.MM_MESSAGE";
        public static final java.lang.String WXAPP_MSG_ENTRY_CLASSNAME = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
        public static final java.lang.String WXAPP_PACKAGE_NAME = "com.tencent.mm";
    }
}
