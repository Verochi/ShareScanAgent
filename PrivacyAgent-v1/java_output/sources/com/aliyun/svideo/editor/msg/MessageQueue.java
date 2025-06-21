package com.aliyun.svideo.editor.msg;

/* loaded from: classes12.dex */
public class MessageQueue extends java.lang.Thread {
    private java.util.concurrent.ConcurrentLinkedQueue<com.aliyun.svideo.editor.msg.Message> mQueue = new java.util.concurrent.ConcurrentLinkedQueue<>();
    private java.util.concurrent.CountDownLatch mLatch = null;
    private volatile boolean mQuit = false;
    private android.os.Handler mMainHandler = new android.os.Handler(android.os.Looper.getMainLooper());

    /* renamed from: com.aliyun.svideo.editor.msg.MessageQueue$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.aliyun.svideo.editor.msg.Message val$m;

        public AnonymousClass1(com.aliyun.svideo.editor.msg.Message message) {
            this.val$m = message;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.val$m.getHandler().onHandleMessage(this.val$m.getMessageBody());
        }
    }

    public MessageQueue() {
        start();
    }

    public synchronized void clearMessage(com.aliyun.svideo.editor.msg.MessageInfo messageInfo) {
        if (messageInfo == null) {
            return;
        }
        java.util.Iterator<com.aliyun.svideo.editor.msg.Message> it = this.mQueue.iterator();
        while (it.hasNext()) {
            if (it.next().getInfo().getMsgId() == messageInfo.getId()) {
                it.remove();
            }
        }
    }

    public synchronized void pushMessage(com.aliyun.svideo.editor.msg.Message message) {
        this.mQueue.add(message);
        java.util.concurrent.CountDownLatch countDownLatch = this.mLatch;
        if (countDownLatch != null) {
            countDownLatch.countDown();
            this.mLatch = null;
        }
    }

    public synchronized void quitSafely() {
        this.mQueue.clear();
        this.mQuit = true;
        java.util.concurrent.CountDownLatch countDownLatch = this.mLatch;
        if (countDownLatch != null) {
            countDownLatch.countDown();
            this.mLatch = null;
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        while (!this.mQuit) {
            if (this.mQueue.isEmpty()) {
                java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
                this.mLatch = countDownLatch;
                try {
                    countDownLatch.await();
                } catch (java.lang.InterruptedException e) {
                    e.printStackTrace();
                }
            }
            com.aliyun.svideo.editor.msg.Message remove = this.mQueue.remove();
            int msgType = remove.getInfo().getMsgType();
            if (msgType == 2) {
                remove.getHandler().onHandleMessage(remove.getMessageBody());
            } else if (msgType == 3) {
                this.mMainHandler.post(new com.aliyun.svideo.editor.msg.MessageQueue.AnonymousClass1(remove));
            }
        }
    }
}
