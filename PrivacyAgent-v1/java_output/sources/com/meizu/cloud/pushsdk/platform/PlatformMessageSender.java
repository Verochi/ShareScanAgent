package com.meizu.cloud.pushsdk.platform;

/* loaded from: classes23.dex */
public class PlatformMessageSender {

    /* renamed from: com.meizu.cloud.pushsdk.platform.PlatformMessageSender$1, reason: invalid class name */
    public static class AnonymousClass1 implements com.meizu.cloud.pushsdk.platform.PlatformMessageSender.a {
        final /* synthetic */ com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus a;

        public AnonymousClass1(com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus pushSwitchStatus) {
            this.a = pushSwitchStatus;
        }

        @Override // com.meizu.cloud.pushsdk.platform.PlatformMessageSender.a
        public java.lang.String a() {
            return com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PUSH_STATUS;
        }

        @Override // com.meizu.cloud.pushsdk.platform.PlatformMessageSender.a
        public com.meizu.cloud.pushsdk.platform.message.BasicPushStatus b() {
            return this.a;
        }

        @Override // com.meizu.cloud.pushsdk.platform.PlatformMessageSender.a
        public java.lang.String c() {
            return com.meizu.cloud.pushsdk.constants.PushConstants.EXTRA_APP_PUSH_SWITCH_STATUS;
        }

        @Override // com.meizu.cloud.pushsdk.platform.PlatformMessageSender.a
        public java.lang.String d() {
            return com.meizu.cloud.pushsdk.platform.message.a.a(this.a);
        }
    }

    /* renamed from: com.meizu.cloud.pushsdk.platform.PlatformMessageSender$2, reason: invalid class name */
    public static class AnonymousClass2 implements com.meizu.cloud.pushsdk.platform.PlatformMessageSender.a {
        final /* synthetic */ com.meizu.cloud.pushsdk.platform.message.RegisterStatus a;

        public AnonymousClass2(com.meizu.cloud.pushsdk.platform.message.RegisterStatus registerStatus) {
            this.a = registerStatus;
        }

        @Override // com.meizu.cloud.pushsdk.platform.PlatformMessageSender.a
        public java.lang.String a() {
            return com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_REGISTER_STATUS;
        }

        @Override // com.meizu.cloud.pushsdk.platform.PlatformMessageSender.a
        public com.meizu.cloud.pushsdk.platform.message.BasicPushStatus b() {
            return this.a;
        }

        @Override // com.meizu.cloud.pushsdk.platform.PlatformMessageSender.a
        public java.lang.String c() {
            return com.meizu.cloud.pushsdk.constants.PushConstants.EXTRA_APP_PUSH_REGISTER_STATUS;
        }

        @Override // com.meizu.cloud.pushsdk.platform.PlatformMessageSender.a
        public java.lang.String d() {
            return com.meizu.cloud.pushsdk.platform.message.a.a(this.a);
        }
    }

    /* renamed from: com.meizu.cloud.pushsdk.platform.PlatformMessageSender$3, reason: invalid class name */
    public static class AnonymousClass3 implements com.meizu.cloud.pushsdk.platform.PlatformMessageSender.a {
        final /* synthetic */ com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus a;

        public AnonymousClass3(com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus unRegisterStatus) {
            this.a = unRegisterStatus;
        }

        @Override // com.meizu.cloud.pushsdk.platform.PlatformMessageSender.a
        public java.lang.String a() {
            return com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_UNREGISTER_STATUS;
        }

        @Override // com.meizu.cloud.pushsdk.platform.PlatformMessageSender.a
        public com.meizu.cloud.pushsdk.platform.message.BasicPushStatus b() {
            return this.a;
        }

        @Override // com.meizu.cloud.pushsdk.platform.PlatformMessageSender.a
        public java.lang.String c() {
            return com.meizu.cloud.pushsdk.constants.PushConstants.EXTRA_APP_PUSH_UNREGISTER_STATUS;
        }

        @Override // com.meizu.cloud.pushsdk.platform.PlatformMessageSender.a
        public java.lang.String d() {
            return com.meizu.cloud.pushsdk.platform.message.a.a(this.a);
        }
    }

    /* renamed from: com.meizu.cloud.pushsdk.platform.PlatformMessageSender$4, reason: invalid class name */
    public static class AnonymousClass4 implements com.meizu.cloud.pushsdk.platform.PlatformMessageSender.a {
        final /* synthetic */ com.meizu.cloud.pushsdk.platform.message.SubTagsStatus a;

        public AnonymousClass4(com.meizu.cloud.pushsdk.platform.message.SubTagsStatus subTagsStatus) {
            this.a = subTagsStatus;
        }

        @Override // com.meizu.cloud.pushsdk.platform.PlatformMessageSender.a
        public java.lang.String a() {
            return com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_SUBTAGS_STATUS;
        }

        @Override // com.meizu.cloud.pushsdk.platform.PlatformMessageSender.a
        public com.meizu.cloud.pushsdk.platform.message.BasicPushStatus b() {
            return this.a;
        }

        @Override // com.meizu.cloud.pushsdk.platform.PlatformMessageSender.a
        public java.lang.String c() {
            return com.meizu.cloud.pushsdk.constants.PushConstants.EXTRA_APP_PUSH_SUBTAGS_STATUS;
        }

        @Override // com.meizu.cloud.pushsdk.platform.PlatformMessageSender.a
        public java.lang.String d() {
            return com.meizu.cloud.pushsdk.platform.message.a.a(this.a);
        }
    }

    /* renamed from: com.meizu.cloud.pushsdk.platform.PlatformMessageSender$5, reason: invalid class name */
    public static class AnonymousClass5 implements com.meizu.cloud.pushsdk.platform.PlatformMessageSender.a {
        final /* synthetic */ com.meizu.cloud.pushsdk.platform.message.SubAliasStatus a;

        public AnonymousClass5(com.meizu.cloud.pushsdk.platform.message.SubAliasStatus subAliasStatus) {
            this.a = subAliasStatus;
        }

        @Override // com.meizu.cloud.pushsdk.platform.PlatformMessageSender.a
        public java.lang.String a() {
            return com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_SUBALIAS_STATUS;
        }

        @Override // com.meizu.cloud.pushsdk.platform.PlatformMessageSender.a
        public com.meizu.cloud.pushsdk.platform.message.BasicPushStatus b() {
            return this.a;
        }

        @Override // com.meizu.cloud.pushsdk.platform.PlatformMessageSender.a
        public java.lang.String c() {
            return com.meizu.cloud.pushsdk.constants.PushConstants.EXTRA_APP_PUSH_SUBALIAS_STATUS;
        }

        @Override // com.meizu.cloud.pushsdk.platform.PlatformMessageSender.a
        public java.lang.String d() {
            return com.meizu.cloud.pushsdk.platform.message.a.a(this.a);
        }
    }

    public interface a {
        java.lang.String a();

        com.meizu.cloud.pushsdk.platform.message.BasicPushStatus b();

        java.lang.String c();

        java.lang.String d();
    }

    public static void a(android.content.Context context, int i, boolean z, java.lang.String str) {
        java.lang.String appVersionName = com.meizu.cloud.pushsdk.util.MzSystemUtils.getAppVersionName(context, com.meizu.cloud.pushsdk.constants.PushConstants.PUSH_PACKAGE_NAME);
        com.meizu.cloud.pushinternal.DebugLogger.i("PlatformMessageSender", context.getPackageName() + " switchPushMessageSetting cloudVersion_name " + appVersionName);
        if (android.text.TextUtils.isEmpty(appVersionName) || java.lang.Integer.parseInt(appVersionName.substring(0, 1)) < 6) {
            return;
        }
        android.content.Intent intent = new android.content.Intent(com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_ON_MESSAGE_SWITCH_SETTING);
        intent.putExtra(com.meizu.cloud.pushsdk.constants.PushConstants.EXTRA_APP_PUSH_SWITCH_SETTING_TYPE, i);
        intent.putExtra(com.meizu.cloud.pushsdk.constants.PushConstants.EXTRA_APP_PUSH_SWITCH_SETTING_STATUS, z);
        intent.putExtra(com.meizu.cloud.pushsdk.constants.PushConstants.EXTRA_APP_PUSH_SWITCH_SETTING_PACKAGE_NAME, str);
        intent.setClassName(com.meizu.cloud.pushsdk.constants.PushConstants.PUSH_PACKAGE_NAME, com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_SERVICE_NAME);
        try {
            context.startService(intent);
        } catch (java.lang.Exception e) {
            com.meizu.cloud.pushinternal.DebugLogger.e("PlatformMessageSender", "start switch push message setting service error " + e.getMessage());
        }
    }

    private static void a(android.content.Context context, java.lang.String str, com.meizu.cloud.pushsdk.platform.PlatformMessageSender.a aVar) {
        android.content.Intent intent = new android.content.Intent();
        intent.addCategory(str);
        intent.setPackage(str);
        intent.putExtra("method", aVar.a());
        if (com.meizu.cloud.pushsdk.util.MinSdkChecker.isSupportTransmitMessageValue(context, str)) {
            intent.putExtra(com.meizu.cloud.pushsdk.constants.PushConstants.MZ_MESSAGE_VALUE, aVar.d());
        } else {
            intent.putExtra(aVar.c(), aVar.b());
        }
        com.meizu.cloud.pushsdk.util.MzSystemUtils.sendMessageFromBroadcast(context, intent, com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_ON_MESSAGE_ACTION, str);
        com.meizu.cloud.pushsdk.a.a(context);
    }

    public static void a(android.content.Context context, java.lang.String str, com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus pushSwitchStatus) {
        a(context, str, new com.meizu.cloud.pushsdk.platform.PlatformMessageSender.AnonymousClass1(pushSwitchStatus));
    }

    public static void a(android.content.Context context, java.lang.String str, com.meizu.cloud.pushsdk.platform.message.RegisterStatus registerStatus) {
        a(context, str, new com.meizu.cloud.pushsdk.platform.PlatformMessageSender.AnonymousClass2(registerStatus));
    }

    public static void a(android.content.Context context, java.lang.String str, com.meizu.cloud.pushsdk.platform.message.SubAliasStatus subAliasStatus) {
        a(context, str, new com.meizu.cloud.pushsdk.platform.PlatformMessageSender.AnonymousClass5(subAliasStatus));
    }

    public static void a(android.content.Context context, java.lang.String str, com.meizu.cloud.pushsdk.platform.message.SubTagsStatus subTagsStatus) {
        a(context, str, new com.meizu.cloud.pushsdk.platform.PlatformMessageSender.AnonymousClass4(subTagsStatus));
    }

    public static void a(android.content.Context context, java.lang.String str, com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus unRegisterStatus) {
        a(context, str, new com.meizu.cloud.pushsdk.platform.PlatformMessageSender.AnonymousClass3(unRegisterStatus));
    }

    public static void launchStartActivity(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        com.meizu.cloud.pushsdk.handler.a.c.d a2 = com.meizu.cloud.pushsdk.util.d.a(str3);
        com.meizu.cloud.pushsdk.handler.MessageV3 parse = com.meizu.cloud.pushsdk.handler.MessageV3.parse(str, str, a2.e(), a2.f(), a2.c(), a2.d(), str2);
        android.content.Intent intent = new android.content.Intent();
        intent.setData(android.net.Uri.parse("custom://" + java.lang.System.currentTimeMillis()));
        intent.putExtra(com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_PRIVATE_MESSAGE, parse);
        intent.putExtra("method", com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE);
        intent.setAction(com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_ON_MESSAGE_ACTION);
        if (!android.text.TextUtils.isEmpty(str)) {
            intent.setPackage(str);
            intent.setClassName(str, "com.meizu.cloud.pushsdk.NotificationService");
        }
        intent.putExtra("command_type", "reflect_receiver");
        com.meizu.cloud.pushinternal.DebugLogger.i("PlatformMessageSender", "start notification service " + parse);
        try {
            context.startService(intent);
        } catch (java.lang.Exception e) {
            com.meizu.cloud.pushinternal.DebugLogger.e("PlatformMessageSender", "launchStartActivity error " + e.getMessage());
        }
    }

    public static void showQuickNotification(android.content.Context context, java.lang.String str, java.lang.String str2) {
        com.meizu.cloud.pushsdk.handler.a.c.d a2 = com.meizu.cloud.pushsdk.util.d.a(str2);
        android.content.Intent intent = new android.content.Intent();
        intent.putExtra(com.meizu.cloud.pushsdk.constants.PushConstants.EXTRA_APP_PUSH_SEQ_ID, a2.d());
        intent.putExtra(com.meizu.cloud.pushsdk.constants.PushConstants.EXTRA_APP_PUSH_TASK_ID, a2.c());
        intent.putExtra(com.meizu.cloud.pushsdk.constants.PushConstants.EXTRA_APP_PUSH_TASK_TIMES_TAMP, a2.e());
        intent.putExtra(com.meizu.cloud.pushsdk.constants.PushConstants.EXTRA_APP_PUSH_SERVICE_DEFAULT_PACKAGE_NAME, context.getPackageName());
        intent.putExtra(com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_PRIVATE_MESSAGE, str);
        intent.putExtra(com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_MESSAGE_STATISTICS_IMEI_KEY, a2.f());
        intent.putExtra("method", com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_NOTIFICATION_SHOW_V3);
        intent.setAction(com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_ON_MESSAGE_ACTION);
        intent.setClassName(context.getPackageName(), "com.meizu.cloud.pushsdk.NotificationService");
        intent.putExtra("command_type", "reflect_receiver");
        try {
            com.meizu.cloud.pushinternal.DebugLogger.e("PlatformMessageSender", "start notification service to show notification");
            context.startService(intent);
        } catch (java.lang.Exception e) {
            com.meizu.cloud.pushinternal.DebugLogger.e("PlatformMessageSender", "showNotification error " + e.getMessage());
        }
    }
}
