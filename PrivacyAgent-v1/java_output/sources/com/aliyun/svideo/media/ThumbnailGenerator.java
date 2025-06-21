package com.aliyun.svideo.media;

/* loaded from: classes12.dex */
public class ThumbnailGenerator {
    private android.content.ContentResolver resolver;
    private android.os.Handler handler = new android.os.Handler();
    private java.util.concurrent.Executor executor = new java.util.concurrent.ThreadPoolExecutor(3, 3, 0, java.util.concurrent.TimeUnit.MILLISECONDS, new com.aliyun.svideo.media.ThumbnailGenerator.LruLinkedBlockingDeque(), new com.aliyun.svideo.media.ThumbnailGenerator.ThumbnailGeneratorFactory());

    public static class LruLinkedBlockingDeque<E> extends java.util.concurrent.LinkedBlockingDeque<E> {
        @Override // java.util.concurrent.LinkedBlockingDeque, java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue
        public E poll(long j, java.util.concurrent.TimeUnit timeUnit) throws java.lang.InterruptedException {
            return (E) super.pollLast(j, timeUnit);
        }

        @Override // java.util.concurrent.LinkedBlockingDeque, java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue
        @androidx.annotation.NonNull
        public E take() throws java.lang.InterruptedException {
            return (E) super.takeLast();
        }
    }

    public class MemoryCache {
        private final java.util.Map<java.lang.String, java.lang.ref.Reference<android.graphics.Bitmap>> softMap = new java.util.HashMap();

        public MemoryCache() {
        }

        public void clear() {
            java.util.Iterator<java.lang.ref.Reference<android.graphics.Bitmap>> it = this.softMap.values().iterator();
            while (it.hasNext()) {
                android.graphics.Bitmap bitmap = it.next().get();
                if (bitmap != null) {
                    bitmap.recycle();
                }
            }
            this.softMap.clear();
        }

        public java.lang.ref.Reference<android.graphics.Bitmap> createReference(android.graphics.Bitmap bitmap) {
            return new java.lang.ref.SoftReference(bitmap);
        }

        public android.graphics.Bitmap get(java.lang.String str) {
            java.lang.ref.Reference<android.graphics.Bitmap> reference = this.softMap.get(str);
            if (reference != null) {
                return reference.get();
            }
            return null;
        }

        public java.util.Collection<java.lang.String> keys() {
            java.util.HashSet hashSet;
            synchronized (this.softMap) {
                hashSet = new java.util.HashSet(this.softMap.keySet());
            }
            return hashSet;
        }

        public boolean put(java.lang.String str, android.graphics.Bitmap bitmap) {
            this.softMap.put(str, createReference(bitmap));
            return true;
        }

        public android.graphics.Bitmap remove(java.lang.String str) {
            java.lang.ref.Reference<android.graphics.Bitmap> remove = this.softMap.remove(str);
            if (remove == null) {
                return null;
            }
            return remove.get();
        }
    }

    public interface OnThumbnailGenerateListener {
        void onThumbnailGenerate(int i, android.graphics.Bitmap bitmap);
    }

    public static class ThumbnailGeneratorFactory implements java.util.concurrent.ThreadFactory {
        @Override // java.util.concurrent.ThreadFactory
        public java.lang.Thread newThread(java.lang.Runnable runnable) {
            java.lang.Thread thread = new java.lang.Thread(runnable);
            thread.setName("ThumbnailGenerator #");
            return thread;
        }
    }

    public class ThumbnailTask implements java.lang.Runnable {
        private int id;
        private com.aliyun.svideo.media.ThumbnailGenerator.OnThumbnailGenerateListener listener;
        private int resId;
        private int type;

        /* renamed from: com.aliyun.svideo.media.ThumbnailGenerator$ThumbnailTask$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            final /* synthetic */ android.graphics.Bitmap val$bitmap;
            final /* synthetic */ int val$key;

            public AnonymousClass1(int i, android.graphics.Bitmap bitmap) {
                this.val$key = i;
                this.val$bitmap = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (com.aliyun.svideo.media.ThumbnailGenerator.ThumbnailTask.this.listener != null) {
                    com.aliyun.svideo.media.ThumbnailGenerator.ThumbnailTask.this.listener.onThumbnailGenerate(this.val$key, this.val$bitmap);
                    com.aliyun.svideo.media.ThumbnailGenerator.ThumbnailTask.this.listener = null;
                }
            }
        }

        public ThumbnailTask(int i, int i2, int i3, com.aliyun.svideo.media.ThumbnailGenerator.OnThumbnailGenerateListener onThumbnailGenerateListener) {
            this.type = i;
            this.id = i2;
            this.resId = i3;
            this.listener = onThumbnailGenerateListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            android.graphics.Bitmap thumbnail;
            android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
            options.inDither = false;
            options.inPreferredConfig = android.graphics.Bitmap.Config.ARGB_8888;
            if (this.type == 1) {
                android.content.ContentResolver contentResolver = com.aliyun.svideo.media.ThumbnailGenerator.this.resolver;
                int i = this.id;
                thumbnail = android.provider.MediaStore.Images.Thumbnails.getThumbnail(contentResolver, i == -1 ? this.resId : i, 1, options);
            } else {
                android.content.ContentResolver contentResolver2 = com.aliyun.svideo.media.ThumbnailGenerator.this.resolver;
                int i2 = this.id;
                thumbnail = android.provider.MediaStore.Video.Thumbnails.getThumbnail(contentResolver2, i2 == -1 ? this.resId : i2, 1, options);
            }
            int generateKey = com.aliyun.svideo.media.ThumbnailGenerator.generateKey(this.type, this.id);
            if (thumbnail == null) {
                return;
            }
            com.aliyun.svideo.media.ThumbnailGenerator.this.handler.post(new com.aliyun.svideo.media.ThumbnailGenerator.ThumbnailTask.AnonymousClass1(generateKey, thumbnail));
        }
    }

    public ThumbnailGenerator(android.content.Context context) {
        this.resolver = context.getApplicationContext().getContentResolver();
    }

    public static int generateKey(int i, int i2) {
        return (i << 16) | i2;
    }

    public static java.lang.String generateKey(java.lang.String str, int i, int i2) {
        return str + "_" + i + "x" + i2;
    }

    public void cancelAllTask() {
        ((java.util.concurrent.ExecutorService) this.executor).shutdown();
    }

    public void generateThumbnail(int i, int i2, int i3, com.aliyun.svideo.media.ThumbnailGenerator.OnThumbnailGenerateListener onThumbnailGenerateListener) {
        this.executor.execute(new com.aliyun.svideo.media.ThumbnailGenerator.ThumbnailTask(i, i2, i3, onThumbnailGenerateListener));
    }
}
