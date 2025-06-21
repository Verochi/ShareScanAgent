package androidx.activity.result.contract;

/* loaded from: classes.dex */
public final class ActivityResultContracts {

    @android.annotation.TargetApi(19)
    public static class CreateDocument extends androidx.activity.result.contract.ActivityResultContract<java.lang.String, android.net.Uri> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        @androidx.annotation.NonNull
        @androidx.annotation.CallSuper
        public android.content.Intent createIntent(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.lang.String str) {
            return new android.content.Intent("android.intent.action.CREATE_DOCUMENT").setType("*/*").putExtra("android.intent.extra.TITLE", str);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @androidx.annotation.Nullable
        public final androidx.activity.result.contract.ActivityResultContract.SynchronousResult<android.net.Uri> getSynchronousResult(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.lang.String str) {
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        @androidx.annotation.Nullable
        public final android.net.Uri parseResult(int i, @androidx.annotation.Nullable android.content.Intent intent) {
            if (intent == null || i != -1) {
                return null;
            }
            return intent.getData();
        }
    }

    public static class GetContent extends androidx.activity.result.contract.ActivityResultContract<java.lang.String, android.net.Uri> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        @androidx.annotation.NonNull
        @androidx.annotation.CallSuper
        public android.content.Intent createIntent(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.lang.String str) {
            return new android.content.Intent("android.intent.action.GET_CONTENT").addCategory("android.intent.category.OPENABLE").setType(str);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @androidx.annotation.Nullable
        public final androidx.activity.result.contract.ActivityResultContract.SynchronousResult<android.net.Uri> getSynchronousResult(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.lang.String str) {
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        @androidx.annotation.Nullable
        public final android.net.Uri parseResult(int i, @androidx.annotation.Nullable android.content.Intent intent) {
            if (intent == null || i != -1) {
                return null;
            }
            return intent.getData();
        }
    }

    @android.annotation.TargetApi(18)
    public static class GetMultipleContents extends androidx.activity.result.contract.ActivityResultContract<java.lang.String, java.util.List<android.net.Uri>> {
        @androidx.annotation.NonNull
        public static java.util.List<android.net.Uri> getClipDataUris(@androidx.annotation.NonNull android.content.Intent intent) {
            java.util.LinkedHashSet linkedHashSet = new java.util.LinkedHashSet();
            if (intent.getData() != null) {
                linkedHashSet.add(intent.getData());
            }
            android.content.ClipData clipData = intent.getClipData();
            if (clipData == null && linkedHashSet.isEmpty()) {
                return java.util.Collections.emptyList();
            }
            if (clipData != null) {
                for (int i = 0; i < clipData.getItemCount(); i++) {
                    android.net.Uri uri = clipData.getItemAt(i).getUri();
                    if (uri != null) {
                        linkedHashSet.add(uri);
                    }
                }
            }
            return new java.util.ArrayList(linkedHashSet);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @androidx.annotation.NonNull
        @androidx.annotation.CallSuper
        public android.content.Intent createIntent(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.lang.String str) {
            return new android.content.Intent("android.intent.action.GET_CONTENT").addCategory("android.intent.category.OPENABLE").setType(str).putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @androidx.annotation.Nullable
        public final androidx.activity.result.contract.ActivityResultContract.SynchronousResult<java.util.List<android.net.Uri>> getSynchronousResult(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.lang.String str) {
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @androidx.annotation.NonNull
        public final java.util.List<android.net.Uri> parseResult(int i, @androidx.annotation.Nullable android.content.Intent intent) {
            return (intent == null || i != -1) ? java.util.Collections.emptyList() : getClipDataUris(intent);
        }
    }

    @android.annotation.TargetApi(19)
    public static class OpenDocument extends androidx.activity.result.contract.ActivityResultContract<java.lang.String[], android.net.Uri> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        @androidx.annotation.NonNull
        @androidx.annotation.CallSuper
        public android.content.Intent createIntent(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.lang.String[] strArr) {
            return new android.content.Intent("android.intent.action.OPEN_DOCUMENT").putExtra("android.intent.extra.MIME_TYPES", strArr).setType("*/*");
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @androidx.annotation.Nullable
        public final androidx.activity.result.contract.ActivityResultContract.SynchronousResult<android.net.Uri> getSynchronousResult(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.lang.String[] strArr) {
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        @androidx.annotation.Nullable
        public final android.net.Uri parseResult(int i, @androidx.annotation.Nullable android.content.Intent intent) {
            if (intent == null || i != -1) {
                return null;
            }
            return intent.getData();
        }
    }

    @android.annotation.TargetApi(21)
    public static class OpenDocumentTree extends androidx.activity.result.contract.ActivityResultContract<android.net.Uri, android.net.Uri> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        @androidx.annotation.NonNull
        @androidx.annotation.CallSuper
        public android.content.Intent createIntent(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.net.Uri uri) {
            android.content.Intent intent = new android.content.Intent("android.intent.action.OPEN_DOCUMENT_TREE");
            if (android.os.Build.VERSION.SDK_INT >= 26 && uri != null) {
                intent.putExtra("android.provider.extra.INITIAL_URI", uri);
            }
            return intent;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @androidx.annotation.Nullable
        public final androidx.activity.result.contract.ActivityResultContract.SynchronousResult<android.net.Uri> getSynchronousResult(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.net.Uri uri) {
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        @androidx.annotation.Nullable
        public final android.net.Uri parseResult(int i, @androidx.annotation.Nullable android.content.Intent intent) {
            if (intent == null || i != -1) {
                return null;
            }
            return intent.getData();
        }
    }

    @android.annotation.TargetApi(19)
    public static class OpenMultipleDocuments extends androidx.activity.result.contract.ActivityResultContract<java.lang.String[], java.util.List<android.net.Uri>> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        @androidx.annotation.NonNull
        @androidx.annotation.CallSuper
        public android.content.Intent createIntent(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.lang.String[] strArr) {
            return new android.content.Intent("android.intent.action.OPEN_DOCUMENT").putExtra("android.intent.extra.MIME_TYPES", strArr).putExtra("android.intent.extra.ALLOW_MULTIPLE", true).setType("*/*");
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @androidx.annotation.Nullable
        public final androidx.activity.result.contract.ActivityResultContract.SynchronousResult<java.util.List<android.net.Uri>> getSynchronousResult(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.lang.String[] strArr) {
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @androidx.annotation.NonNull
        public final java.util.List<android.net.Uri> parseResult(int i, @androidx.annotation.Nullable android.content.Intent intent) {
            return (i != -1 || intent == null) ? java.util.Collections.emptyList() : androidx.activity.result.contract.ActivityResultContracts.GetMultipleContents.getClipDataUris(intent);
        }
    }

    public static final class PickContact extends androidx.activity.result.contract.ActivityResultContract<java.lang.Void, android.net.Uri> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        @androidx.annotation.NonNull
        public android.content.Intent createIntent(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable java.lang.Void r2) {
            return new android.content.Intent("android.intent.action.PICK").setType("vnd.android.cursor.dir/contact");
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        @androidx.annotation.Nullable
        public android.net.Uri parseResult(int i, @androidx.annotation.Nullable android.content.Intent intent) {
            if (intent == null || i != -1) {
                return null;
            }
            return intent.getData();
        }
    }

    public static final class RequestMultiplePermissions extends androidx.activity.result.contract.ActivityResultContract<java.lang.String[], java.util.Map<java.lang.String, java.lang.Boolean>> {
        public static final java.lang.String ACTION_REQUEST_PERMISSIONS = "androidx.activity.result.contract.action.REQUEST_PERMISSIONS";
        public static final java.lang.String EXTRA_PERMISSIONS = "androidx.activity.result.contract.extra.PERMISSIONS";
        public static final java.lang.String EXTRA_PERMISSION_GRANT_RESULTS = "androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS";

        @androidx.annotation.NonNull
        public static android.content.Intent createIntent(@androidx.annotation.NonNull java.lang.String[] strArr) {
            return new android.content.Intent(ACTION_REQUEST_PERMISSIONS).putExtra(EXTRA_PERMISSIONS, strArr);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @androidx.annotation.NonNull
        public android.content.Intent createIntent(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.lang.String[] strArr) {
            return createIntent(strArr);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @androidx.annotation.Nullable
        public androidx.activity.result.contract.ActivityResultContract.SynchronousResult<java.util.Map<java.lang.String, java.lang.Boolean>> getSynchronousResult(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable java.lang.String[] strArr) {
            if (strArr == null || strArr.length == 0) {
                return new androidx.activity.result.contract.ActivityResultContract.SynchronousResult<>(java.util.Collections.emptyMap());
            }
            androidx.collection.ArrayMap arrayMap = new androidx.collection.ArrayMap();
            boolean z = true;
            for (java.lang.String str : strArr) {
                boolean z2 = androidx.core.content.ContextCompat.checkSelfPermission(context, str) == 0;
                arrayMap.put(str, java.lang.Boolean.valueOf(z2));
                if (!z2) {
                    z = false;
                }
            }
            if (z) {
                return new androidx.activity.result.contract.ActivityResultContract.SynchronousResult<>(arrayMap);
            }
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @androidx.annotation.NonNull
        public java.util.Map<java.lang.String, java.lang.Boolean> parseResult(int i, @androidx.annotation.Nullable android.content.Intent intent) {
            if (i == -1 && intent != null) {
                java.lang.String[] stringArrayExtra = intent.getStringArrayExtra(EXTRA_PERMISSIONS);
                int[] intArrayExtra = intent.getIntArrayExtra(EXTRA_PERMISSION_GRANT_RESULTS);
                if (intArrayExtra == null || stringArrayExtra == null) {
                    return java.util.Collections.emptyMap();
                }
                java.util.HashMap hashMap = new java.util.HashMap();
                int length = stringArrayExtra.length;
                for (int i2 = 0; i2 < length; i2++) {
                    hashMap.put(stringArrayExtra[i2], java.lang.Boolean.valueOf(intArrayExtra[i2] == 0));
                }
                return hashMap;
            }
            return java.util.Collections.emptyMap();
        }
    }

    public static final class RequestPermission extends androidx.activity.result.contract.ActivityResultContract<java.lang.String, java.lang.Boolean> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        @androidx.annotation.NonNull
        public android.content.Intent createIntent(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.lang.String str) {
            return androidx.activity.result.contract.ActivityResultContracts.RequestMultiplePermissions.createIntent(new java.lang.String[]{str});
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @androidx.annotation.Nullable
        public androidx.activity.result.contract.ActivityResultContract.SynchronousResult<java.lang.Boolean> getSynchronousResult(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable java.lang.String str) {
            if (str == null) {
                return new androidx.activity.result.contract.ActivityResultContract.SynchronousResult<>(java.lang.Boolean.FALSE);
            }
            if (androidx.core.content.ContextCompat.checkSelfPermission(context, str) == 0) {
                return new androidx.activity.result.contract.ActivityResultContract.SynchronousResult<>(java.lang.Boolean.TRUE);
            }
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        @androidx.annotation.NonNull
        public java.lang.Boolean parseResult(int i, @androidx.annotation.Nullable android.content.Intent intent) {
            if (intent == null || i != -1) {
                return java.lang.Boolean.FALSE;
            }
            int[] intArrayExtra = intent.getIntArrayExtra(androidx.activity.result.contract.ActivityResultContracts.RequestMultiplePermissions.EXTRA_PERMISSION_GRANT_RESULTS);
            if (intArrayExtra == null || intArrayExtra.length == 0) {
                return java.lang.Boolean.FALSE;
            }
            return java.lang.Boolean.valueOf(intArrayExtra[0] == 0);
        }
    }

    public static final class StartActivityForResult extends androidx.activity.result.contract.ActivityResultContract<android.content.Intent, androidx.activity.result.ActivityResult> {
        public static final java.lang.String EXTRA_ACTIVITY_OPTIONS_BUNDLE = "androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE";

        @Override // androidx.activity.result.contract.ActivityResultContract
        @androidx.annotation.NonNull
        public android.content.Intent createIntent(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.content.Intent intent) {
            return intent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        @androidx.annotation.NonNull
        public androidx.activity.result.ActivityResult parseResult(int i, @androidx.annotation.Nullable android.content.Intent intent) {
            return new androidx.activity.result.ActivityResult(i, intent);
        }
    }

    public static final class StartIntentSenderForResult extends androidx.activity.result.contract.ActivityResultContract<androidx.activity.result.IntentSenderRequest, androidx.activity.result.ActivityResult> {
        public static final java.lang.String ACTION_INTENT_SENDER_REQUEST = "androidx.activity.result.contract.action.INTENT_SENDER_REQUEST";
        public static final java.lang.String EXTRA_INTENT_SENDER_REQUEST = "androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST";
        public static final java.lang.String EXTRA_SEND_INTENT_EXCEPTION = "androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION";

        @Override // androidx.activity.result.contract.ActivityResultContract
        @androidx.annotation.NonNull
        public android.content.Intent createIntent(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull androidx.activity.result.IntentSenderRequest intentSenderRequest) {
            return new android.content.Intent(ACTION_INTENT_SENDER_REQUEST).putExtra(EXTRA_INTENT_SENDER_REQUEST, intentSenderRequest);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        @androidx.annotation.NonNull
        public androidx.activity.result.ActivityResult parseResult(int i, @androidx.annotation.Nullable android.content.Intent intent) {
            return new androidx.activity.result.ActivityResult(i, intent);
        }
    }

    public static class TakePicture extends androidx.activity.result.contract.ActivityResultContract<android.net.Uri, java.lang.Boolean> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        @androidx.annotation.NonNull
        @androidx.annotation.CallSuper
        public android.content.Intent createIntent(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.net.Uri uri) {
            return new android.content.Intent("android.media.action.IMAGE_CAPTURE").putExtra("output", uri);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @androidx.annotation.Nullable
        public final androidx.activity.result.contract.ActivityResultContract.SynchronousResult<java.lang.Boolean> getSynchronousResult(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.net.Uri uri) {
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        @androidx.annotation.NonNull
        public final java.lang.Boolean parseResult(int i, @androidx.annotation.Nullable android.content.Intent intent) {
            return java.lang.Boolean.valueOf(i == -1);
        }
    }

    public static class TakePicturePreview extends androidx.activity.result.contract.ActivityResultContract<java.lang.Void, android.graphics.Bitmap> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        @androidx.annotation.NonNull
        @androidx.annotation.CallSuper
        public android.content.Intent createIntent(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable java.lang.Void r2) {
            return new android.content.Intent("android.media.action.IMAGE_CAPTURE");
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @androidx.annotation.Nullable
        public final androidx.activity.result.contract.ActivityResultContract.SynchronousResult<android.graphics.Bitmap> getSynchronousResult(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable java.lang.Void r2) {
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        @androidx.annotation.Nullable
        public final android.graphics.Bitmap parseResult(int i, @androidx.annotation.Nullable android.content.Intent intent) {
            if (intent == null || i != -1) {
                return null;
            }
            return (android.graphics.Bitmap) intent.getParcelableExtra("data");
        }
    }

    public static class TakeVideo extends androidx.activity.result.contract.ActivityResultContract<android.net.Uri, android.graphics.Bitmap> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        @androidx.annotation.NonNull
        @androidx.annotation.CallSuper
        public android.content.Intent createIntent(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.net.Uri uri) {
            return new android.content.Intent("android.media.action.VIDEO_CAPTURE").putExtra("output", uri);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @androidx.annotation.Nullable
        public final androidx.activity.result.contract.ActivityResultContract.SynchronousResult<android.graphics.Bitmap> getSynchronousResult(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.net.Uri uri) {
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        @androidx.annotation.Nullable
        public final android.graphics.Bitmap parseResult(int i, @androidx.annotation.Nullable android.content.Intent intent) {
            if (intent == null || i != -1) {
                return null;
            }
            return (android.graphics.Bitmap) intent.getParcelableExtra("data");
        }
    }

    private ActivityResultContracts() {
    }
}
