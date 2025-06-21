package com.aliyun.svideo.editor.msg;

/* loaded from: classes12.dex */
public class Dispatcher {
    private static com.aliyun.svideo.editor.msg.Dispatcher sDefaultInstance;
    private java.lang.ThreadLocal<com.aliyun.svideo.editor.msg.MessageQueue> mThreadLocalQueue = new java.lang.ThreadLocal<>();
    private java.util.concurrent.ConcurrentHashMap<com.aliyun.svideo.editor.msg.MessageInfo, com.aliyun.svideo.editor.msg.MessageHandler> mServices = new java.util.concurrent.ConcurrentHashMap<>();

    public static com.aliyun.svideo.editor.msg.Dispatcher getInstance() {
        if (sDefaultInstance == null) {
            synchronized (com.aliyun.svideo.editor.msg.Dispatcher.class) {
                if (sDefaultInstance == null) {
                    sDefaultInstance = new com.aliyun.svideo.editor.msg.Dispatcher();
                }
            }
        }
        return sDefaultInstance;
    }

    public <T> void postMsg(int i, int i2, T t) {
        for (java.util.Map.Entry<com.aliyun.svideo.editor.msg.MessageInfo, com.aliyun.svideo.editor.msg.MessageHandler> entry : this.mServices.entrySet()) {
            if (i == entry.getKey().getMsgId() && t.getClass().equals(entry.getKey().getMessageBody())) {
                com.aliyun.svideo.editor.msg.MessageQueue messageQueue = this.mThreadLocalQueue.get();
                if (messageQueue == null) {
                    messageQueue = new com.aliyun.svideo.editor.msg.MessageQueue();
                }
                messageQueue.pushMessage(new com.aliyun.svideo.editor.msg.Message(entry.getKey(), t, entry.getValue()));
            }
        }
        t.getClass();
    }

    public void postMsg(java.lang.Object obj) {
        org.greenrobot.eventbus.EventBus.getDefault().post(obj);
    }

    public void register(java.lang.Object obj) {
        org.greenrobot.eventbus.EventBus.getDefault().register(obj);
    }

    public synchronized void registerService(com.aliyun.svideo.editor.msg.MessageInfo messageInfo, com.aliyun.svideo.editor.msg.MessageHandler messageHandler) {
        for (java.lang.reflect.Method method : messageHandler.getClass().getDeclaredMethods()) {
            messageInfo.setMessageBody(method.getParameterTypes()[0]);
        }
        messageInfo.setId(messageHandler.hashCode());
        this.mServices.put(messageInfo, messageHandler);
    }

    public void unRegister(java.lang.Object obj) {
        org.greenrobot.eventbus.EventBus.getDefault().unregister(obj);
    }

    public synchronized void unRegisterService(com.aliyun.svideo.editor.msg.MessageInfo messageInfo) {
    }
}
