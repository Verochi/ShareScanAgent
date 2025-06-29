package com.tencent.mm.opensdk.modelmsg;

/* loaded from: classes19.dex */
public final class WXMediaMessage {
    public static final java.lang.String ACTION_WXAPPMESSAGE = "com.tencent.mm.sdk.openapi.Intent.ACTION_WXAPPMESSAGE";
    public static final int DESCRIPTION_LENGTH_LIMIT = 1024;
    public static final int MEDIA_TAG_NAME_LENGTH_LIMIT = 64;
    public static final int MESSAGE_ACTION_LENGTH_LIMIT = 2048;
    public static final int MESSAGE_EXT_LENGTH_LIMIT = 2048;
    public static final int MINI_PROGRAM__THUMB_LENGHT = 131072;
    private static final java.lang.String TAG = "MicroMsg.SDK.WXMediaMessage";
    public static final int THUMB_LENGTH_LIMIT = 65536;
    public static final int TITLE_LENGTH_LIMIT = 512;
    public java.lang.String description;
    public com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject mediaObject;
    public java.lang.String mediaTagName;
    public java.lang.String messageAction;
    public java.lang.String messageExt;
    public int sdkVer;
    public byte[] thumbData;
    public java.lang.String title;

    public static class Builder {
        public static final java.lang.String KEY_IDENTIFIER = "_wxobject_identifier_";

        public static com.tencent.mm.opensdk.modelmsg.WXMediaMessage fromBundle(android.os.Bundle bundle) {
            com.tencent.mm.opensdk.modelmsg.WXMediaMessage wXMediaMessage = new com.tencent.mm.opensdk.modelmsg.WXMediaMessage();
            wXMediaMessage.sdkVer = bundle.getInt("_wxobject_sdkVer");
            wXMediaMessage.title = bundle.getString("_wxobject_title");
            wXMediaMessage.description = bundle.getString("_wxobject_description");
            wXMediaMessage.thumbData = bundle.getByteArray("_wxobject_thumbdata");
            wXMediaMessage.mediaTagName = bundle.getString("_wxobject_mediatagname");
            wXMediaMessage.messageAction = bundle.getString("_wxobject_message_action");
            wXMediaMessage.messageExt = bundle.getString("_wxobject_message_ext");
            java.lang.String pathOldToNew = pathOldToNew(bundle.getString(KEY_IDENTIFIER));
            if (pathOldToNew != null && pathOldToNew.length() > 0) {
                try {
                    com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject iMediaObject = (com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject) java.lang.Class.forName(pathOldToNew).newInstance();
                    wXMediaMessage.mediaObject = iMediaObject;
                    iMediaObject.unserialize(bundle);
                    return wXMediaMessage;
                } catch (java.lang.Exception e) {
                    com.tencent.mm.opensdk.utils.Log.e(com.tencent.mm.opensdk.modelmsg.WXMediaMessage.TAG, "get media object from bundle failed: unknown ident " + pathOldToNew + ", ex = " + e.getMessage());
                }
            }
            return wXMediaMessage;
        }

        private static java.lang.String pathNewToOld(java.lang.String str) {
            if (str != null && str.length() != 0) {
                return str.replace("com.tencent.mm.opensdk.modelmsg", "com.tencent.mm.sdk.openapi");
            }
            com.tencent.mm.opensdk.utils.Log.e(com.tencent.mm.opensdk.modelmsg.WXMediaMessage.TAG, "pathNewToOld fail, newPath is null");
            return str;
        }

        private static java.lang.String pathOldToNew(java.lang.String str) {
            com.tencent.mm.opensdk.utils.Log.i(com.tencent.mm.opensdk.modelmsg.WXMediaMessage.TAG, "pathOldToNew, oldPath = " + str);
            if (str == null || str.length() == 0) {
                com.tencent.mm.opensdk.utils.Log.e(com.tencent.mm.opensdk.modelmsg.WXMediaMessage.TAG, "pathOldToNew fail, oldPath is null");
                return str;
            }
            int lastIndexOf = str.lastIndexOf(46);
            if (lastIndexOf != -1) {
                return "com.tencent.mm.opensdk.modelmsg" + str.substring(lastIndexOf);
            }
            com.tencent.mm.opensdk.utils.Log.e(com.tencent.mm.opensdk.modelmsg.WXMediaMessage.TAG, "pathOldToNew fail, invalid pos, oldPath = " + str);
            return str;
        }

        public static android.os.Bundle toBundle(com.tencent.mm.opensdk.modelmsg.WXMediaMessage wXMediaMessage) {
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putInt("_wxobject_sdkVer", wXMediaMessage.sdkVer);
            bundle.putString("_wxobject_title", wXMediaMessage.title);
            bundle.putString("_wxobject_description", wXMediaMessage.description);
            bundle.putByteArray("_wxobject_thumbdata", wXMediaMessage.thumbData);
            com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject iMediaObject = wXMediaMessage.mediaObject;
            if (iMediaObject != null) {
                bundle.putString(KEY_IDENTIFIER, pathNewToOld(iMediaObject.getClass().getName()));
                wXMediaMessage.mediaObject.serialize(bundle);
            }
            bundle.putString("_wxobject_mediatagname", wXMediaMessage.mediaTagName);
            bundle.putString("_wxobject_message_action", wXMediaMessage.messageAction);
            bundle.putString("_wxobject_message_ext", wXMediaMessage.messageExt);
            return bundle;
        }
    }

    public interface IMediaObject {
        public static final int TYPE_APPBRAND = 33;
        public static final int TYPE_APPDATA = 7;
        public static final int TYPE_BUSINESS_CARD = 45;
        public static final int TYPE_CARD_SHARE = 16;
        public static final int TYPE_DESIGNER_SHARED = 25;
        public static final int TYPE_DEVICE_ACCESS = 12;
        public static final int TYPE_EMOJI = 8;
        public static final int TYPE_EMOJILIST_SHARED = 27;
        public static final int TYPE_EMOTICON_GIFT = 11;
        public static final int TYPE_EMOTICON_SHARED = 15;
        public static final int TYPE_EMOTIONLIST_SHARED = 26;
        public static final int TYPE_FILE = 6;
        public static final int TYPE_GAME_VIDEO_FILE = 39;
        public static final int TYPE_GIFTCARD = 34;
        public static final int TYPE_IMAGE = 2;
        public static final int TYPE_LOCATION = 30;
        public static final int TYPE_LOCATION_SHARE = 17;
        public static final int TYPE_MALL_PRODUCT = 13;
        public static final int TYPE_MUSIC = 3;
        public static final int TYPE_NOTE = 24;
        public static final int TYPE_OLD_TV = 14;
        public static final int TYPE_OPENSDK_APPBRAND = 36;
        public static final int TYPE_OPENSDK_APPBRAND_WEISHIVIDEO = 46;
        public static final int TYPE_OPENSDK_WEWORK_OBJECT = 49;
        public static final int TYPE_PRODUCT = 10;
        public static final int TYPE_RECORD = 19;
        public static final int TYPE_TEXT = 1;
        public static final int TYPE_TV = 20;
        public static final int TYPE_UNKNOWN = 0;
        public static final int TYPE_URL = 5;
        public static final int TYPE_VIDEO = 4;
        public static final int TYPE_VIDEO_FILE = 38;

        boolean checkArgs();

        void serialize(android.os.Bundle bundle);

        int type();

        void unserialize(android.os.Bundle bundle);
    }

    public WXMediaMessage() {
        this(null);
    }

    public WXMediaMessage(com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject iMediaObject) {
        this.mediaObject = iMediaObject;
    }

    public boolean checkArgs() {
        java.lang.String str;
        byte[] bArr;
        byte[] bArr2;
        byte[] bArr3;
        if (getType() == 8 && ((bArr3 = this.thumbData) == null || bArr3.length == 0)) {
            str = "checkArgs fail, thumbData should not be null when send emoji";
        } else if (com.tencent.mm.opensdk.utils.b.a(getType()) && ((bArr2 = this.thumbData) == null || bArr2.length > 131072)) {
            str = "checkArgs fail, thumbData should not be null or exceed 128kb";
        } else if (com.tencent.mm.opensdk.utils.b.a(getType()) || (bArr = this.thumbData) == null || bArr.length <= 65536) {
            java.lang.String str2 = this.title;
            if (str2 == null || str2.length() <= 512) {
                java.lang.String str3 = this.description;
                if (str3 != null && str3.length() > 1024) {
                    str = "checkArgs fail, description is invalid";
                } else if (this.mediaObject == null) {
                    str = "checkArgs fail, mediaObject is null";
                } else {
                    java.lang.String str4 = this.mediaTagName;
                    if (str4 == null || str4.length() <= 64) {
                        java.lang.String str5 = this.messageAction;
                        if (str5 == null || str5.length() <= 2048) {
                            java.lang.String str6 = this.messageExt;
                            if (str6 == null || str6.length() <= 2048) {
                                return this.mediaObject.checkArgs();
                            }
                            str = "checkArgs fail, messageExt is too long";
                        } else {
                            str = "checkArgs fail, messageAction is too long";
                        }
                    } else {
                        str = "checkArgs fail, mediaTagName is too long";
                    }
                }
            } else {
                str = "checkArgs fail, title is invalid";
            }
        } else {
            str = "checkArgs fail, thumbData is invalid";
        }
        com.tencent.mm.opensdk.utils.Log.e(TAG, str);
        return false;
    }

    public int getType() {
        com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject iMediaObject = this.mediaObject;
        if (iMediaObject == null) {
            return 0;
        }
        return iMediaObject.type();
    }

    public void setThumbImage(android.graphics.Bitmap bitmap) {
        try {
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream);
            this.thumbData = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        } catch (java.lang.Exception e) {
            com.tencent.mm.opensdk.utils.Log.e(TAG, "setThumbImage exception:" + e.getMessage());
        }
    }
}
