package kotlinx.coroutines;

@kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "This is internal API and may be removed in the future releases")
@kotlin.Metadata(d1 = {"\u0000Ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0006Ì\u0001Í\u0001Î\u0001B\u0012\u0012\u0007\u0010É\u0001\u001a\u00020\t¢\u0006\u0006\bÊ\u0001\u0010Ë\u0001J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001H\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\f\u0010\rJ\u0011\u0010\u0010\u001a\u00060\u000ej\u0002`\u000f¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0015\u001a\u00060\u000ej\u0002`\u000f*\u00020\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0004¢\u0006\u0004\b\u0015\u0010\u0016J6\u0010\u001e\u001a\u00020\u001d2'\u0010\u001c\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00060\u0017j\u0002`\u001b¢\u0006\u0004\b\u001e\u0010\u001fJF\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\t2'\u0010\u001c\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00060\u0017j\u0002`\u001b¢\u0006\u0004\b\u001e\u0010\"J\u0013\u0010#\u001a\u00020\u0006H\u0086@ø\u0001\u0000¢\u0006\u0004\b#\u0010$JB\u0010+\u001a\u00020\u0006\"\u0004\b\u0000\u0010%2\f\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000&2\u001c\u0010*\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000(\u0012\u0006\u0012\u0004\u0018\u00010)0\u0017ø\u0001\u0000¢\u0006\u0004\b+\u0010,J\u0017\u00101\u001a\u00020\u00062\u0006\u0010.\u001a\u00020-H\u0000¢\u0006\u0004\b/\u00100J\u001f\u00102\u001a\u00020\u00062\u000e\u0010\u001a\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000fH\u0016¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\u0013H\u0014¢\u0006\u0004\b4\u00105J\u0019\u00102\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0012H\u0017¢\u0006\u0004\b2\u00106J\u0017\u00107\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0012H\u0016¢\u0006\u0004\b7\u00108J\u0015\u0010:\u001a\u00020\u00062\u0006\u00109\u001a\u00020\u0003¢\u0006\u0004\b:\u0010;J\u0017\u0010<\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0012H\u0016¢\u0006\u0004\b<\u00106J\u0017\u0010=\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b=\u00106J\u0019\u0010@\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010)H\u0000¢\u0006\u0004\b>\u0010?J(\u0010D\u001a\u00020A2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0012H\u0080\b¢\u0006\u0004\bB\u0010CJ\u0013\u0010E\u001a\u00060\u000ej\u0002`\u000fH\u0016¢\u0006\u0004\bE\u0010\u0011J\u0019\u0010H\u001a\u00020\t2\b\u0010F\u001a\u0004\u0018\u00010)H\u0000¢\u0006\u0004\bG\u0010?J\u001b\u0010K\u001a\u0004\u0018\u00010)2\b\u0010F\u001a\u0004\u0018\u00010)H\u0000¢\u0006\u0004\bI\u0010JJ\u0015\u0010N\u001a\u00020M2\u0006\u0010L\u001a\u00020\u0002¢\u0006\u0004\bN\u0010OJ\u0017\u0010R\u001a\u00020\u00062\u0006\u0010P\u001a\u00020\u0012H\u0010¢\u0006\u0004\bQ\u00108J\u0019\u0010 \u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u0012H\u0014¢\u0006\u0004\b \u00108J\u0017\u0010S\u001a\u00020\t2\u0006\u0010P\u001a\u00020\u0012H\u0014¢\u0006\u0004\bS\u00106J\u0019\u0010U\u001a\u00020\u00062\b\u0010T\u001a\u0004\u0018\u00010)H\u0014¢\u0006\u0004\bU\u0010VJ\u0019\u0010W\u001a\u00020\u00062\b\u0010T\u001a\u0004\u0018\u00010)H\u0014¢\u0006\u0004\bW\u0010VJ\u000f\u0010X\u001a\u00020\u0013H\u0016¢\u0006\u0004\bX\u00105J\u000f\u0010Y\u001a\u00020\u0013H\u0007¢\u0006\u0004\bY\u00105J\u000f\u0010[\u001a\u00020\u0013H\u0010¢\u0006\u0004\bZ\u00105J\u000f\u0010\\\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\\\u0010]J\u0011\u0010`\u001a\u0004\u0018\u00010)H\u0000¢\u0006\u0004\b^\u0010_J\u0015\u0010b\u001a\u0004\u0018\u00010)H\u0080@ø\u0001\u0000¢\u0006\u0004\ba\u0010$JP\u0010g\u001a\u00020\u0006\"\u0004\b\u0000\u0010c\"\u0004\b\u0001\u0010%2\f\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00010&2\"\u0010*\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010(\u0012\u0006\u0012\u0004\u0018\u00010)0dH\u0000ø\u0001\u0000¢\u0006\u0004\be\u0010fJP\u0010i\u001a\u00020\u0006\"\u0004\b\u0000\u0010c\"\u0004\b\u0001\u0010%2\f\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00010&2\"\u0010*\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010(\u0012\u0006\u0012\u0004\u0018\u00010)0dH\u0000ø\u0001\u0000¢\u0006\u0004\bh\u0010fJ#\u0010k\u001a\u0004\u0018\u00010)2\u0006\u0010T\u001a\u00020j2\b\u0010F\u001a\u0004\u0018\u00010)H\u0002¢\u0006\u0004\bk\u0010lJ'\u0010o\u001a\u0004\u0018\u00010\u00122\u0006\u0010T\u001a\u00020j2\f\u0010n\u001a\b\u0012\u0004\u0012\u00020\u00120mH\u0002¢\u0006\u0004\bo\u0010pJ%\u0010r\u001a\u00020\u00062\u0006\u0010q\u001a\u00020\u00122\f\u0010n\u001a\b\u0012\u0004\u0012\u00020\u00120mH\u0002¢\u0006\u0004\br\u0010sJ!\u0010v\u001a\u00020\t2\u0006\u0010T\u001a\u00020t2\b\u0010u\u001a\u0004\u0018\u00010)H\u0002¢\u0006\u0004\bv\u0010wJ!\u0010x\u001a\u00020\u00062\u0006\u0010T\u001a\u00020t2\b\u0010u\u001a\u0004\u0018\u00010)H\u0002¢\u0006\u0004\bx\u0010yJ\u001f\u0010|\u001a\u00020\u00062\u0006\u0010{\u001a\u00020z2\u0006\u0010\u001a\u001a\u00020\u0012H\u0002¢\u0006\u0004\b|\u0010}J\u0017\u0010~\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0012H\u0002¢\u0006\u0004\b~\u00106J\u001d\u0010\u007f\u001a\u00020\u0006*\u00020z2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u007f\u0010}J\u001d\u0010\u0081\u0001\u001a\u00030\u0080\u00012\b\u0010T\u001a\u0004\u0018\u00010)H\u0002¢\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001JC\u0010\u0083\u0001\u001a\u00020-2'\u0010\u001c\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00060\u0017j\u0002`\u001b2\u0006\u0010 \u001a\u00020\tH\u0002¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001J+\u0010\u0086\u0001\u001a\u00020\t2\u0007\u0010\u0085\u0001\u001a\u00020)2\u0006\u0010{\u001a\u00020z2\u0006\u0010.\u001a\u00020-H\u0002¢\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J\u001b\u0010\u0089\u0001\u001a\u00020\u00062\u0007\u0010T\u001a\u00030\u0088\u0001H\u0002¢\u0006\u0006\b\u0089\u0001\u0010\u008a\u0001J\u0019\u0010\u008b\u0001\u001a\u00020\u00062\u0006\u0010T\u001a\u00020-H\u0002¢\u0006\u0005\b\u008b\u0001\u00100J\u0011\u0010\u008c\u0001\u001a\u00020\tH\u0002¢\u0006\u0005\b\u008c\u0001\u0010\u000bJ\u0015\u0010\u008d\u0001\u001a\u00020\u0006H\u0082@ø\u0001\u0000¢\u0006\u0005\b\u008d\u0001\u0010$J\u001d\u0010\u008e\u0001\u001a\u0004\u0018\u00010)2\b\u0010\u001a\u001a\u0004\u0018\u00010)H\u0002¢\u0006\u0005\b\u008e\u0001\u0010JJ\u001c\u0010\u008f\u0001\u001a\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010)H\u0002¢\u0006\u0006\b\u008f\u0001\u0010\u0090\u0001J\u001d\u0010\u0091\u0001\u001a\u0004\u0018\u00010)2\b\u0010\u001a\u001a\u0004\u0018\u00010)H\u0002¢\u0006\u0005\b\u0091\u0001\u0010JJ\u001c\u0010\u0092\u0001\u001a\u0004\u0018\u00010z2\u0006\u0010T\u001a\u00020tH\u0002¢\u0006\u0006\b\u0092\u0001\u0010\u0093\u0001J\"\u0010\u0094\u0001\u001a\u00020\t2\u0006\u0010T\u001a\u00020t2\u0006\u0010q\u001a\u00020\u0012H\u0002¢\u0006\u0006\b\u0094\u0001\u0010\u0095\u0001J(\u0010\u0096\u0001\u001a\u0004\u0018\u00010)2\b\u0010T\u001a\u0004\u0018\u00010)2\b\u0010F\u001a\u0004\u0018\u00010)H\u0002¢\u0006\u0006\b\u0096\u0001\u0010\u0097\u0001J&\u0010\u0098\u0001\u001a\u0004\u0018\u00010)2\u0006\u0010T\u001a\u00020t2\b\u0010F\u001a\u0004\u0018\u00010)H\u0002¢\u0006\u0006\b\u0098\u0001\u0010\u0099\u0001J\u001d\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u009a\u00012\u0006\u0010T\u001a\u00020tH\u0002¢\u0006\u0006\b\u009b\u0001\u0010\u009c\u0001J.\u0010\u009d\u0001\u001a\u00020\t2\u0006\u0010T\u001a\u00020j2\u0007\u0010L\u001a\u00030\u009a\u00012\b\u0010F\u001a\u0004\u0018\u00010)H\u0082\u0010¢\u0006\u0006\b\u009d\u0001\u0010\u009e\u0001J.\u0010 \u0001\u001a\u00020\u00062\u0006\u0010T\u001a\u00020j2\b\u0010\u009f\u0001\u001a\u00030\u009a\u00012\b\u0010F\u001a\u0004\u0018\u00010)H\u0002¢\u0006\u0006\b \u0001\u0010¡\u0001J\u001a\u0010£\u0001\u001a\u0005\u0018\u00010\u009a\u0001*\u00030¢\u0001H\u0002¢\u0006\u0006\b£\u0001\u0010¤\u0001J\u001c\u0010¥\u0001\u001a\u00020\u00132\b\u0010T\u001a\u0004\u0018\u00010)H\u0002¢\u0006\u0006\b¥\u0001\u0010¦\u0001J\u0017\u0010§\u0001\u001a\u0004\u0018\u00010)H\u0082@ø\u0001\u0000¢\u0006\u0005\b§\u0001\u0010$R\u0019\u0010«\u0001\u001a\u0007\u0012\u0002\b\u00030¨\u00018F¢\u0006\b\u001a\u0006\b©\u0001\u0010ª\u0001R.\u0010±\u0001\u001a\u0004\u0018\u00010M2\t\u0010¬\u0001\u001a\u0004\u0018\u00010M8@@@X\u0080\u000e¢\u0006\u0010\u001a\u0006\b\u00ad\u0001\u0010®\u0001\"\u0006\b¯\u0001\u0010°\u0001R\u0017\u0010T\u001a\u0004\u0018\u00010)8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\b²\u0001\u0010_R\u0016\u0010³\u0001\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b³\u0001\u0010\u000bR\u0013\u0010´\u0001\u001a\u00020\t8F¢\u0006\u0007\u001a\u0005\b´\u0001\u0010\u000bR\u0013\u0010µ\u0001\u001a\u00020\t8F¢\u0006\u0007\u001a\u0005\bµ\u0001\u0010\u000bR\u0018\u0010·\u0001\u001a\u0004\u0018\u00010\u00128DX\u0084\u0004¢\u0006\u0007\u001a\u0005\b¶\u0001\u0010]R\u0016\u0010¹\u0001\u001a\u00020\t8DX\u0084\u0004¢\u0006\u0007\u001a\u0005\b¸\u0001\u0010\u000bR\u0014\u0010¼\u0001\u001a\u00020\u00048F¢\u0006\b\u001a\u0006\bº\u0001\u0010»\u0001R\u0016\u0010¾\u0001\u001a\u00020\t8PX\u0090\u0004¢\u0006\u0007\u001a\u0005\b½\u0001\u0010\u000bR\u001b\u0010Â\u0001\u001a\t\u0012\u0004\u0012\u00020\u00010¿\u00018F¢\u0006\b\u001a\u0006\bÀ\u0001\u0010Á\u0001R\u0016\u0010Ã\u0001\u001a\u00020\t8TX\u0094\u0004¢\u0006\u0007\u001a\u0005\bÃ\u0001\u0010\u000bR\u0016\u0010Å\u0001\u001a\u00020\t8PX\u0090\u0004¢\u0006\u0007\u001a\u0005\bÄ\u0001\u0010\u000bR\u0013\u0010Æ\u0001\u001a\u00020\t8F¢\u0006\u0007\u001a\u0005\bÆ\u0001\u0010\u000bR\u001f\u0010È\u0001\u001a\u0004\u0018\u00010\u0012*\u0004\u0018\u00010)8BX\u0082\u0004¢\u0006\b\u001a\u0006\bÇ\u0001\u0010\u0090\u0001\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006Ï\u0001"}, d2 = {"Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/ChildJob;", "Lkotlinx/coroutines/ParentJob;", "Lkotlinx/coroutines/selects/SelectClause0;", "parent", "", "initParentJob", "(Lkotlinx/coroutines/Job;)V", "", com.anythink.expressad.foundation.d.c.bT, "()Z", "onStart", "()V", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "getCancellationException", "()Ljava/util/concurrent/CancellationException;", "", "", "message", "toCancellationException", "(Ljava/lang/Throwable;Ljava/lang/String;)Ljava/util/concurrent/CancellationException;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "cause", "Lkotlinx/coroutines/CompletionHandler;", "handler", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnCompletion", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "onCancelling", "invokeImmediately", "(ZZLkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "join", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "R", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "Lkotlin/coroutines/Continuation;", "", "block", "registerSelectClause0", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/JobNode;", "node", "removeNode$kotlinx_coroutines_core", "(Lkotlinx/coroutines/JobNode;)V", "removeNode", com.anythink.expressad.d.a.b.dO, "(Ljava/util/concurrent/CancellationException;)V", "cancellationExceptionMessage", "()Ljava/lang/String;", "(Ljava/lang/Throwable;)Z", "cancelInternal", "(Ljava/lang/Throwable;)V", "parentJob", "parentCancelled", "(Lkotlinx/coroutines/ParentJob;)V", "childCancelled", "cancelCoroutine", "cancelImpl$kotlinx_coroutines_core", "(Ljava/lang/Object;)Z", "cancelImpl", "Lkotlinx/coroutines/JobCancellationException;", "defaultCancellationException$kotlinx_coroutines_core", "(Ljava/lang/String;Ljava/lang/Throwable;)Lkotlinx/coroutines/JobCancellationException;", "defaultCancellationException", "getChildJobCancellationCause", "proposedUpdate", "makeCompleting$kotlinx_coroutines_core", "makeCompleting", "makeCompletingOnce$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Object;", "makeCompletingOnce", "child", "Lkotlinx/coroutines/ChildHandle;", "attachChild", "(Lkotlinx/coroutines/ChildJob;)Lkotlinx/coroutines/ChildHandle;", "exception", "handleOnCompletionException$kotlinx_coroutines_core", "handleOnCompletionException", "handleJobException", com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.b, "onCompletionInternal", "(Ljava/lang/Object;)V", "afterCompletion", "toString", "toDebugString", "nameString$kotlinx_coroutines_core", "nameString", "getCompletionExceptionOrNull", "()Ljava/lang/Throwable;", "getCompletedInternal$kotlinx_coroutines_core", "()Ljava/lang/Object;", "getCompletedInternal", "awaitInternal$kotlinx_coroutines_core", "awaitInternal", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function2;", "registerSelectClause1Internal$kotlinx_coroutines_core", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "registerSelectClause1Internal", "selectAwaitCompletion$kotlinx_coroutines_core", "selectAwaitCompletion", "Lkotlinx/coroutines/JobSupport$Finishing;", "i", "(Lkotlinx/coroutines/JobSupport$Finishing;Ljava/lang/Object;)Ljava/lang/Object;", "", "exceptions", "l", "(Lkotlinx/coroutines/JobSupport$Finishing;Ljava/util/List;)Ljava/lang/Throwable;", "rootCause", "b", "(Ljava/lang/Throwable;Ljava/util/List;)V", "Lkotlinx/coroutines/Incomplete;", "update", "y", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)Z", "f", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)V", "Lkotlinx/coroutines/NodeList;", org.apache.tools.ant.taskdefs.optional.j2ee.HotDeploymentTool.ACTION_LIST, "s", "(Lkotlinx/coroutines/NodeList;Ljava/lang/Throwable;)V", "e", "t", "", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH, "(Ljava/lang/Object;)I", "q", "(Lkotlin/jvm/functions/Function1;Z)Lkotlinx/coroutines/JobNode;", "expect", "a", "(Ljava/lang/Object;Lkotlinx/coroutines/NodeList;Lkotlinx/coroutines/JobNode;)Z", "Lkotlinx/coroutines/Empty;", com.umeng.analytics.pro.bo.aN, "(Lkotlinx/coroutines/Empty;)V", "v", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "o", "d", "h", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "p", com.anythink.expressad.d.a.b.dH, "(Lkotlinx/coroutines/Incomplete;)Lkotlinx/coroutines/NodeList;", com.umeng.analytics.pro.bo.aJ, "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Throwable;)Z", androidx.exifinterface.media.ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "B", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/ChildHandleNode;", "j", "(Lkotlinx/coroutines/Incomplete;)Lkotlinx/coroutines/ChildHandleNode;", "C", "(Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)Z", "lastChild", "g", "(Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)V", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "r", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/ChildHandleNode;", "x", "(Ljava/lang/Object;)Ljava/lang/String;", "c", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "key", "value", "getParentHandle$kotlinx_coroutines_core", "()Lkotlinx/coroutines/ChildHandle;", "setParentHandle$kotlinx_coroutines_core", "(Lkotlinx/coroutines/ChildHandle;)V", "parentHandle", "getState$kotlinx_coroutines_core", "isActive", "isCompleted", "isCancelled", "getCompletionCause", "completionCause", "getCompletionCauseHandled", "completionCauseHandled", "getOnJoin", "()Lkotlinx/coroutines/selects/SelectClause0;", "onJoin", "getOnCancelComplete$kotlinx_coroutines_core", "onCancelComplete", "Lkotlin/sequences/Sequence;", "getChildren", "()Lkotlin/sequences/Sequence;", "children", "isScopedCoroutine", "getHandlesException$kotlinx_coroutines_core", "handlesException", "isCompletedExceptionally", "k", "exceptionOrNull", "active", "<init>", "(Z)V", "AwaitContinuation", "ChildCompletion", "Finishing", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes15.dex */
public class JobSupport implements kotlinx.coroutines.Job, kotlinx.coroutines.ChildJob, kotlinx.coroutines.ParentJob, kotlinx.coroutines.selects.SelectClause0 {
    public static final /* synthetic */ java.util.concurrent.atomic.AtomicReferenceFieldUpdater n = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(kotlinx.coroutines.JobSupport.class, java.lang.Object.class, "_state");

    @org.jetbrains.annotations.NotNull
    private volatile /* synthetic */ java.lang.Object _parentHandle;

    @org.jetbrains.annotations.NotNull
    private volatile /* synthetic */ java.lang.Object _state;

    @kotlin.Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001d\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0014R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/JobSupport$AwaitContinuation;", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CancellableContinuationImpl;", "Lkotlinx/coroutines/Job;", "parent", "", "getContinuationCancellationCause", "", "nameString", "Lkotlinx/coroutines/JobSupport;", "x", "Lkotlinx/coroutines/JobSupport;", "job", "Lkotlin/coroutines/Continuation;", "delegate", "<init>", "(Lkotlin/coroutines/Continuation;Lkotlinx/coroutines/JobSupport;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
    public static final class AwaitContinuation<T> extends kotlinx.coroutines.CancellableContinuationImpl<T> {

        /* renamed from: x, reason: from kotlin metadata */
        @org.jetbrains.annotations.NotNull
        public final kotlinx.coroutines.JobSupport job;

        public AwaitContinuation(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> continuation, @org.jetbrains.annotations.NotNull kotlinx.coroutines.JobSupport jobSupport) {
            super(continuation, 1);
            this.job = jobSupport;
        }

        @Override // kotlinx.coroutines.CancellableContinuationImpl
        @org.jetbrains.annotations.NotNull
        public java.lang.Throwable getContinuationCancellationCause(@org.jetbrains.annotations.NotNull kotlinx.coroutines.Job parent) {
            java.lang.Throwable d;
            java.lang.Object state$kotlinx_coroutines_core = this.job.getState$kotlinx_coroutines_core();
            return (!(state$kotlinx_coroutines_core instanceof kotlinx.coroutines.JobSupport.Finishing) || (d = ((kotlinx.coroutines.JobSupport.Finishing) state$kotlinx_coroutines_core).d()) == null) ? state$kotlinx_coroutines_core instanceof kotlinx.coroutines.CompletedExceptionally ? ((kotlinx.coroutines.CompletedExceptionally) state$kotlinx_coroutines_core).cause : parent.getCancellationException() : d;
        }

        @Override // kotlinx.coroutines.CancellableContinuationImpl
        @org.jetbrains.annotations.NotNull
        public java.lang.String nameString() {
            return "AwaitContinuation";
        }
    }

    @kotlin.Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0016\u0010\u0017J\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lkotlinx/coroutines/JobSupport$ChildCompletion;", "Lkotlinx/coroutines/JobNode;", "", "cause", "", "invoke", "Lkotlinx/coroutines/JobSupport;", "v", "Lkotlinx/coroutines/JobSupport;", "parent", "Lkotlinx/coroutines/JobSupport$Finishing;", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH, "Lkotlinx/coroutines/JobSupport$Finishing;", com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.b, "Lkotlinx/coroutines/ChildHandleNode;", "x", "Lkotlinx/coroutines/ChildHandleNode;", "child", "", "y", "Ljava/lang/Object;", "proposedUpdate", "<init>", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
    public static final class ChildCompletion extends kotlinx.coroutines.JobNode {

        /* renamed from: v, reason: from kotlin metadata */
        @org.jetbrains.annotations.NotNull
        public final kotlinx.coroutines.JobSupport parent;

        /* renamed from: w, reason: from kotlin metadata */
        @org.jetbrains.annotations.NotNull
        public final kotlinx.coroutines.JobSupport.Finishing state;

        /* renamed from: x, reason: from kotlin metadata */
        @org.jetbrains.annotations.NotNull
        public final kotlinx.coroutines.ChildHandleNode child;

        /* renamed from: y, reason: from kotlin metadata */
        @org.jetbrains.annotations.Nullable
        public final java.lang.Object proposedUpdate;

        public ChildCompletion(@org.jetbrains.annotations.NotNull kotlinx.coroutines.JobSupport jobSupport, @org.jetbrains.annotations.NotNull kotlinx.coroutines.JobSupport.Finishing finishing, @org.jetbrains.annotations.NotNull kotlinx.coroutines.ChildHandleNode childHandleNode, @org.jetbrains.annotations.Nullable java.lang.Object obj) {
            this.parent = jobSupport;
            this.state = finishing;
            this.child = childHandleNode;
            this.proposedUpdate = obj;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ kotlin.Unit invoke(java.lang.Throwable th) {
            invoke2(th);
            return kotlin.Unit.INSTANCE;
        }

        @Override // kotlinx.coroutines.CompletionHandlerBase
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public void invoke2(@org.jetbrains.annotations.Nullable java.lang.Throwable cause) {
            this.parent.g(this.state, this.child, this.proposedUpdate);
        }
    }

    @kotlin.Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u0003B!\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u0012\u0006\u0010 \u001a\u00020\u001a\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b/\u00100J\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0010j\b\u0012\u0004\u0012\u00020\u0004`\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0019\u001a\u00020\u00148\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R$\u0010 \u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR(\u0010$\u001a\u0004\u0018\u00010\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u00048F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010\fR\u0011\u0010&\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b%\u0010\u001dR\u0011\u0010(\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b'\u0010\u001dR\u0014\u0010)\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u001dR(\u0010.\u001a\u0004\u0018\u00010\u00012\b\u0010\u001b\u001a\u0004\u0018\u00010\u00018B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u00061"}, d2 = {"Lkotlinx/coroutines/JobSupport$Finishing;", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "Lkotlinx/coroutines/Incomplete;", "", "proposedException", "", "h", "(Ljava/lang/Throwable;)Ljava/util/List;", "exception", "", "a", "(Ljava/lang/Throwable;)V", "", "toString", "()Ljava/lang/String;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "b", "()Ljava/util/ArrayList;", "Lkotlinx/coroutines/NodeList;", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Lkotlinx/coroutines/NodeList;", "getList", "()Lkotlinx/coroutines/NodeList;", org.apache.tools.ant.taskdefs.optional.j2ee.HotDeploymentTool.ACTION_LIST, "", "value", "f", "()Z", "i", "(Z)V", "isCompleting", "d", "()Ljava/lang/Throwable;", "k", "rootCause", "g", "isSealed", "e", "isCancelling", "isActive", "c", "()Ljava/lang/Object;", "j", "(Ljava/lang/Object;)V", "exceptionsHolder", "<init>", "(Lkotlinx/coroutines/NodeList;ZLjava/lang/Throwable;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
    public static final class Finishing implements kotlinx.coroutines.Incomplete {

        @org.jetbrains.annotations.NotNull
        private volatile /* synthetic */ java.lang.Object _exceptionsHolder = null;

        @org.jetbrains.annotations.NotNull
        private volatile /* synthetic */ int _isCompleting;

        @org.jetbrains.annotations.NotNull
        private volatile /* synthetic */ java.lang.Object _rootCause;

        /* renamed from: n, reason: from kotlin metadata */
        @org.jetbrains.annotations.NotNull
        public final kotlinx.coroutines.NodeList list;

        public Finishing(@org.jetbrains.annotations.NotNull kotlinx.coroutines.NodeList nodeList, boolean z, @org.jetbrains.annotations.Nullable java.lang.Throwable th) {
            this.list = nodeList;
            this._isCompleting = z ? 1 : 0;
            this._rootCause = th;
        }

        public final void a(@org.jetbrains.annotations.NotNull java.lang.Throwable exception) {
            java.lang.Throwable d = d();
            if (d == null) {
                k(exception);
                return;
            }
            if (exception == d) {
                return;
            }
            java.lang.Object obj = get_exceptionsHolder();
            if (obj == null) {
                j(exception);
                return;
            }
            if (!(obj instanceof java.lang.Throwable)) {
                if (!(obj instanceof java.util.ArrayList)) {
                    throw new java.lang.IllegalStateException(kotlin.jvm.internal.Intrinsics.stringPlus("State is ", obj).toString());
                }
                ((java.util.ArrayList) obj).add(exception);
            } else {
                if (exception == obj) {
                    return;
                }
                java.util.ArrayList<java.lang.Throwable> b = b();
                b.add(obj);
                b.add(exception);
                kotlin.Unit unit = kotlin.Unit.INSTANCE;
                j(b);
            }
        }

        public final java.util.ArrayList<java.lang.Throwable> b() {
            return new java.util.ArrayList<>(4);
        }

        /* renamed from: c, reason: from getter */
        public final java.lang.Object get_exceptionsHolder() {
            return this._exceptionsHolder;
        }

        @org.jetbrains.annotations.Nullable
        public final java.lang.Throwable d() {
            return (java.lang.Throwable) this._rootCause;
        }

        public final boolean e() {
            return d() != null;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
        public final boolean f() {
            return this._isCompleting;
        }

        public final boolean g() {
            kotlinx.coroutines.internal.Symbol symbol;
            java.lang.Object obj = get_exceptionsHolder();
            symbol = kotlinx.coroutines.JobSupportKt.d;
            return obj == symbol;
        }

        @Override // kotlinx.coroutines.Incomplete
        @org.jetbrains.annotations.NotNull
        public kotlinx.coroutines.NodeList getList() {
            return this.list;
        }

        @org.jetbrains.annotations.NotNull
        public final java.util.List<java.lang.Throwable> h(@org.jetbrains.annotations.Nullable java.lang.Throwable proposedException) {
            java.util.ArrayList<java.lang.Throwable> arrayList;
            kotlinx.coroutines.internal.Symbol symbol;
            java.lang.Object obj = get_exceptionsHolder();
            if (obj == null) {
                arrayList = b();
            } else if (obj instanceof java.lang.Throwable) {
                java.util.ArrayList<java.lang.Throwable> b = b();
                b.add(obj);
                arrayList = b;
            } else {
                if (!(obj instanceof java.util.ArrayList)) {
                    throw new java.lang.IllegalStateException(kotlin.jvm.internal.Intrinsics.stringPlus("State is ", obj).toString());
                }
                arrayList = (java.util.ArrayList) obj;
            }
            java.lang.Throwable d = d();
            if (d != null) {
                arrayList.add(0, d);
            }
            if (proposedException != null && !kotlin.jvm.internal.Intrinsics.areEqual(proposedException, d)) {
                arrayList.add(proposedException);
            }
            symbol = kotlinx.coroutines.JobSupportKt.d;
            j(symbol);
            return arrayList;
        }

        public final void i(boolean z) {
            this._isCompleting = z ? 1 : 0;
        }

        @Override // kotlinx.coroutines.Incomplete
        /* renamed from: isActive */
        public boolean getIsActive() {
            return d() == null;
        }

        public final void j(java.lang.Object obj) {
            this._exceptionsHolder = obj;
        }

        public final void k(@org.jetbrains.annotations.Nullable java.lang.Throwable th) {
            this._rootCause = th;
        }

        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return "Finishing[cancelling=" + e() + ", completing=" + f() + ", rootCause=" + d() + ", exceptions=" + get_exceptionsHolder() + ", list=" + getList() + ']';
        }
    }

    public JobSupport(boolean z) {
        this._state = z ? kotlinx.coroutines.JobSupportKt.f : kotlinx.coroutines.JobSupportKt.e;
        this._parentHandle = null;
    }

    public static /* synthetic */ kotlinx.coroutines.JobCancellationException defaultCancellationException$kotlinx_coroutines_core$default(kotlinx.coroutines.JobSupport jobSupport, java.lang.String str, java.lang.Throwable th, int i, java.lang.Object obj) {
        if (obj != null) {
            throw new java.lang.UnsupportedOperationException("Super calls with default arguments not supported in this target, function: defaultCancellationException");
        }
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            th = null;
        }
        if (str == null) {
            str = jobSupport.cancellationExceptionMessage();
        }
        return new kotlinx.coroutines.JobCancellationException(str, th, jobSupport);
    }

    public static /* synthetic */ java.util.concurrent.CancellationException toCancellationException$default(kotlinx.coroutines.JobSupport jobSupport, java.lang.Throwable th, java.lang.String str, int i, java.lang.Object obj) {
        if (obj != null) {
            throw new java.lang.UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
        }
        if ((i & 1) != 0) {
            str = null;
        }
        return jobSupport.toCancellationException(th, str);
    }

    public final java.lang.Object A(java.lang.Object state, java.lang.Object proposedUpdate) {
        kotlinx.coroutines.internal.Symbol symbol;
        kotlinx.coroutines.internal.Symbol symbol2;
        if (!(state instanceof kotlinx.coroutines.Incomplete)) {
            symbol2 = kotlinx.coroutines.JobSupportKt.a;
            return symbol2;
        }
        if ((!(state instanceof kotlinx.coroutines.Empty) && !(state instanceof kotlinx.coroutines.JobNode)) || (state instanceof kotlinx.coroutines.ChildHandleNode) || (proposedUpdate instanceof kotlinx.coroutines.CompletedExceptionally)) {
            return B((kotlinx.coroutines.Incomplete) state, proposedUpdate);
        }
        if (y((kotlinx.coroutines.Incomplete) state, proposedUpdate)) {
            return proposedUpdate;
        }
        symbol = kotlinx.coroutines.JobSupportKt.b;
        return symbol;
    }

    public final java.lang.Object B(kotlinx.coroutines.Incomplete state, java.lang.Object proposedUpdate) {
        kotlinx.coroutines.internal.Symbol symbol;
        kotlinx.coroutines.internal.Symbol symbol2;
        kotlinx.coroutines.internal.Symbol symbol3;
        kotlinx.coroutines.NodeList m = m(state);
        if (m == null) {
            symbol3 = kotlinx.coroutines.JobSupportKt.b;
            return symbol3;
        }
        kotlinx.coroutines.JobSupport.Finishing finishing = state instanceof kotlinx.coroutines.JobSupport.Finishing ? (kotlinx.coroutines.JobSupport.Finishing) state : null;
        if (finishing == null) {
            finishing = new kotlinx.coroutines.JobSupport.Finishing(m, false, null);
        }
        synchronized (finishing) {
            if (finishing.f()) {
                symbol2 = kotlinx.coroutines.JobSupportKt.a;
                return symbol2;
            }
            finishing.i(true);
            if (finishing != state && !defpackage.q1.a(n, this, state, finishing)) {
                symbol = kotlinx.coroutines.JobSupportKt.b;
                return symbol;
            }
            boolean e = finishing.e();
            kotlinx.coroutines.CompletedExceptionally completedExceptionally = proposedUpdate instanceof kotlinx.coroutines.CompletedExceptionally ? (kotlinx.coroutines.CompletedExceptionally) proposedUpdate : null;
            if (completedExceptionally != null) {
                finishing.a(completedExceptionally.cause);
            }
            java.lang.Throwable d = true ^ e ? finishing.d() : null;
            kotlin.Unit unit = kotlin.Unit.INSTANCE;
            if (d != null) {
                s(m, d);
            }
            kotlinx.coroutines.ChildHandleNode j = j(state);
            return (j == null || !C(finishing, j, proposedUpdate)) ? i(finishing, proposedUpdate) : kotlinx.coroutines.JobSupportKt.COMPLETING_WAITING_CHILDREN;
        }
    }

    public final boolean C(kotlinx.coroutines.JobSupport.Finishing state, kotlinx.coroutines.ChildHandleNode child, java.lang.Object proposedUpdate) {
        while (kotlinx.coroutines.Job.DefaultImpls.invokeOnCompletion$default(child.childJob, false, false, new kotlinx.coroutines.JobSupport.ChildCompletion(this, state, child, proposedUpdate), 1, null) == kotlinx.coroutines.NonDisposableHandle.INSTANCE) {
            child = r(child);
            if (child == null) {
                return false;
            }
        }
        return true;
    }

    public final boolean a(java.lang.Object expect, kotlinx.coroutines.NodeList list, kotlinx.coroutines.JobNode node) {
        int tryCondAddNext;
        kotlinx.coroutines.JobSupport$addLastAtomic$$inlined$addLastIf$1 jobSupport$addLastAtomic$$inlined$addLastIf$1 = new kotlinx.coroutines.JobSupport$addLastAtomic$$inlined$addLastIf$1(node, this, expect);
        do {
            tryCondAddNext = list.getPrevNode().tryCondAddNext(node, list, jobSupport$addLastAtomic$$inlined$addLastIf$1);
            if (tryCondAddNext == 1) {
                return true;
            }
        } while (tryCondAddNext != 2);
        return false;
    }

    public void afterCompletion(@org.jetbrains.annotations.Nullable java.lang.Object state) {
    }

    @Override // kotlinx.coroutines.Job
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.ChildHandle attachChild(@org.jetbrains.annotations.NotNull kotlinx.coroutines.ChildJob child) {
        return (kotlinx.coroutines.ChildHandle) kotlinx.coroutines.Job.DefaultImpls.invokeOnCompletion$default(this, true, false, new kotlinx.coroutines.ChildHandleNode(child), 2, null);
    }

    @org.jetbrains.annotations.Nullable
    public final java.lang.Object awaitInternal$kotlinx_coroutines_core(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<java.lang.Object> continuation) {
        java.lang.Object state$kotlinx_coroutines_core;
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof kotlinx.coroutines.Incomplete)) {
                if (state$kotlinx_coroutines_core instanceof kotlinx.coroutines.CompletedExceptionally) {
                    throw ((kotlinx.coroutines.CompletedExceptionally) state$kotlinx_coroutines_core).cause;
                }
                return kotlinx.coroutines.JobSupportKt.unboxState(state$kotlinx_coroutines_core);
            }
        } while (w(state$kotlinx_coroutines_core) < 0);
        return c(continuation);
    }

    public final void b(java.lang.Throwable rootCause, java.util.List<? extends java.lang.Throwable> exceptions) {
        if (exceptions.size() <= 1) {
            return;
        }
        java.util.Set newSetFromMap = java.util.Collections.newSetFromMap(new java.util.IdentityHashMap(exceptions.size()));
        for (java.lang.Throwable th : exceptions) {
            if (th != rootCause && th != rootCause && !(th instanceof java.util.concurrent.CancellationException) && newSetFromMap.add(th)) {
                kotlin.ExceptionsKt__ExceptionsKt.addSuppressed(rootCause, th);
            }
        }
    }

    public final java.lang.Object c(kotlin.coroutines.Continuation<java.lang.Object> continuation) {
        kotlin.coroutines.Continuation intercepted;
        java.lang.Object coroutine_suspended;
        intercepted = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        kotlinx.coroutines.JobSupport.AwaitContinuation awaitContinuation = new kotlinx.coroutines.JobSupport.AwaitContinuation(intercepted, this);
        awaitContinuation.initCancellability();
        kotlinx.coroutines.CancellableContinuationKt.disposeOnCancellation(awaitContinuation, invokeOnCompletion(new kotlinx.coroutines.ResumeAwaitOnCompletion(awaitContinuation)));
        java.lang.Object result = awaitContinuation.getResult();
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @Override // kotlinx.coroutines.Job
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ void cancel() {
        cancel((java.util.concurrent.CancellationException) null);
    }

    @Override // kotlinx.coroutines.Job
    public void cancel(@org.jetbrains.annotations.Nullable java.util.concurrent.CancellationException cause) {
        if (cause == null) {
            cause = new kotlinx.coroutines.JobCancellationException(cancellationExceptionMessage(), null, this);
        }
        cancelInternal(cause);
    }

    @Override // kotlinx.coroutines.Job
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Added since 1.2.0 for binary compatibility with versions <= 1.1.x")
    public /* synthetic */ boolean cancel(java.lang.Throwable cause) {
        cancelInternal(cause == null ? new kotlinx.coroutines.JobCancellationException(cancellationExceptionMessage(), null, this) : toCancellationException$default(this, cause, null, 1, null));
        return true;
    }

    public final boolean cancelCoroutine(@org.jetbrains.annotations.Nullable java.lang.Throwable cause) {
        return cancelImpl$kotlinx_coroutines_core(cause);
    }

    public final boolean cancelImpl$kotlinx_coroutines_core(@org.jetbrains.annotations.Nullable java.lang.Object cause) {
        java.lang.Object obj;
        kotlinx.coroutines.internal.Symbol symbol;
        kotlinx.coroutines.internal.Symbol symbol2;
        kotlinx.coroutines.internal.Symbol symbol3;
        obj = kotlinx.coroutines.JobSupportKt.a;
        if (getOnCancelComplete$kotlinx_coroutines_core() && (obj = d(cause)) == kotlinx.coroutines.JobSupportKt.COMPLETING_WAITING_CHILDREN) {
            return true;
        }
        symbol = kotlinx.coroutines.JobSupportKt.a;
        if (obj == symbol) {
            obj = p(cause);
        }
        symbol2 = kotlinx.coroutines.JobSupportKt.a;
        if (obj == symbol2 || obj == kotlinx.coroutines.JobSupportKt.COMPLETING_WAITING_CHILDREN) {
            return true;
        }
        symbol3 = kotlinx.coroutines.JobSupportKt.c;
        if (obj == symbol3) {
            return false;
        }
        afterCompletion(obj);
        return true;
    }

    public void cancelInternal(@org.jetbrains.annotations.NotNull java.lang.Throwable cause) {
        cancelImpl$kotlinx_coroutines_core(cause);
    }

    @org.jetbrains.annotations.NotNull
    public java.lang.String cancellationExceptionMessage() {
        return "Job was cancelled";
    }

    public boolean childCancelled(@org.jetbrains.annotations.NotNull java.lang.Throwable cause) {
        if (cause instanceof java.util.concurrent.CancellationException) {
            return true;
        }
        return cancelImpl$kotlinx_coroutines_core(cause) && getHandlesException();
    }

    public final java.lang.Object d(java.lang.Object cause) {
        kotlinx.coroutines.internal.Symbol symbol;
        java.lang.Object A;
        kotlinx.coroutines.internal.Symbol symbol2;
        do {
            java.lang.Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof kotlinx.coroutines.Incomplete) || ((state$kotlinx_coroutines_core instanceof kotlinx.coroutines.JobSupport.Finishing) && ((kotlinx.coroutines.JobSupport.Finishing) state$kotlinx_coroutines_core).f())) {
                symbol = kotlinx.coroutines.JobSupportKt.a;
                return symbol;
            }
            A = A(state$kotlinx_coroutines_core, new kotlinx.coroutines.CompletedExceptionally(h(cause), false, 2, null));
            symbol2 = kotlinx.coroutines.JobSupportKt.b;
        } while (A == symbol2);
        return A;
    }

    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.JobCancellationException defaultCancellationException$kotlinx_coroutines_core(@org.jetbrains.annotations.Nullable java.lang.String message, @org.jetbrains.annotations.Nullable java.lang.Throwable cause) {
        if (message == null) {
            message = cancellationExceptionMessage();
        }
        return new kotlinx.coroutines.JobCancellationException(message, cause, this);
    }

    public final boolean e(java.lang.Throwable cause) {
        if (isScopedCoroutine()) {
            return true;
        }
        boolean z = cause instanceof java.util.concurrent.CancellationException;
        kotlinx.coroutines.ChildHandle parentHandle$kotlinx_coroutines_core = getParentHandle$kotlinx_coroutines_core();
        return (parentHandle$kotlinx_coroutines_core == null || parentHandle$kotlinx_coroutines_core == kotlinx.coroutines.NonDisposableHandle.INSTANCE) ? z : parentHandle$kotlinx_coroutines_core.childCancelled(cause) || z;
    }

    public final void f(kotlinx.coroutines.Incomplete state, java.lang.Object update) {
        kotlinx.coroutines.ChildHandle parentHandle$kotlinx_coroutines_core = getParentHandle$kotlinx_coroutines_core();
        if (parentHandle$kotlinx_coroutines_core != null) {
            parentHandle$kotlinx_coroutines_core.dispose();
            setParentHandle$kotlinx_coroutines_core(kotlinx.coroutines.NonDisposableHandle.INSTANCE);
        }
        kotlinx.coroutines.CompletedExceptionally completedExceptionally = update instanceof kotlinx.coroutines.CompletedExceptionally ? (kotlinx.coroutines.CompletedExceptionally) update : null;
        java.lang.Throwable th = completedExceptionally != null ? completedExceptionally.cause : null;
        if (!(state instanceof kotlinx.coroutines.JobNode)) {
            kotlinx.coroutines.NodeList list = state.getList();
            if (list == null) {
                return;
            }
            t(list, th);
            return;
        }
        try {
            ((kotlinx.coroutines.JobNode) state).invoke(th);
        } catch (java.lang.Throwable th2) {
            handleOnCompletionException$kotlinx_coroutines_core(new kotlinx.coroutines.CompletionHandlerException("Exception in completion handler " + state + " for " + this, th2));
        }
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super R, ? super kotlin.coroutines.CoroutineContext.Element, ? extends R> function2) {
        return (R) kotlinx.coroutines.Job.DefaultImpls.fold(this, r, function2);
    }

    public final void g(kotlinx.coroutines.JobSupport.Finishing state, kotlinx.coroutines.ChildHandleNode lastChild, java.lang.Object proposedUpdate) {
        kotlinx.coroutines.ChildHandleNode r = r(lastChild);
        if (r == null || !C(state, r, proposedUpdate)) {
            afterCompletion(i(state, proposedUpdate));
        }
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    @org.jetbrains.annotations.Nullable
    public <E extends kotlin.coroutines.CoroutineContext.Element> E get(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext.Key<E> key) {
        return (E) kotlinx.coroutines.Job.DefaultImpls.get(this, key);
    }

    @Override // kotlinx.coroutines.Job
    @org.jetbrains.annotations.NotNull
    public final java.util.concurrent.CancellationException getCancellationException() {
        java.lang.Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (!(state$kotlinx_coroutines_core instanceof kotlinx.coroutines.JobSupport.Finishing)) {
            if (state$kotlinx_coroutines_core instanceof kotlinx.coroutines.Incomplete) {
                throw new java.lang.IllegalStateException(kotlin.jvm.internal.Intrinsics.stringPlus("Job is still new or active: ", this).toString());
            }
            return state$kotlinx_coroutines_core instanceof kotlinx.coroutines.CompletedExceptionally ? toCancellationException$default(this, ((kotlinx.coroutines.CompletedExceptionally) state$kotlinx_coroutines_core).cause, null, 1, null) : new kotlinx.coroutines.JobCancellationException(kotlin.jvm.internal.Intrinsics.stringPlus(kotlinx.coroutines.DebugStringsKt.getClassSimpleName(this), " has completed normally"), null, this);
        }
        java.lang.Throwable d = ((kotlinx.coroutines.JobSupport.Finishing) state$kotlinx_coroutines_core).d();
        if (d != null) {
            return toCancellationException(d, kotlin.jvm.internal.Intrinsics.stringPlus(kotlinx.coroutines.DebugStringsKt.getClassSimpleName(this), " is cancelling"));
        }
        throw new java.lang.IllegalStateException(kotlin.jvm.internal.Intrinsics.stringPlus("Job is still new or active: ", this).toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.lang.Throwable] */
    @Override // kotlinx.coroutines.ParentJob
    @org.jetbrains.annotations.NotNull
    public java.util.concurrent.CancellationException getChildJobCancellationCause() {
        java.util.concurrent.CancellationException cancellationException;
        java.lang.Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof kotlinx.coroutines.JobSupport.Finishing) {
            cancellationException = ((kotlinx.coroutines.JobSupport.Finishing) state$kotlinx_coroutines_core).d();
        } else if (state$kotlinx_coroutines_core instanceof kotlinx.coroutines.CompletedExceptionally) {
            cancellationException = ((kotlinx.coroutines.CompletedExceptionally) state$kotlinx_coroutines_core).cause;
        } else {
            if (state$kotlinx_coroutines_core instanceof kotlinx.coroutines.Incomplete) {
                throw new java.lang.IllegalStateException(kotlin.jvm.internal.Intrinsics.stringPlus("Cannot be cancelling child in this state: ", state$kotlinx_coroutines_core).toString());
            }
            cancellationException = null;
        }
        java.util.concurrent.CancellationException cancellationException2 = cancellationException instanceof java.util.concurrent.CancellationException ? cancellationException : null;
        return cancellationException2 == null ? new kotlinx.coroutines.JobCancellationException(kotlin.jvm.internal.Intrinsics.stringPlus("Parent job is ", x(state$kotlinx_coroutines_core)), cancellationException, this) : cancellationException2;
    }

    @Override // kotlinx.coroutines.Job
    @org.jetbrains.annotations.NotNull
    public final kotlin.sequences.Sequence<kotlinx.coroutines.Job> getChildren() {
        return kotlin.sequences.SequencesKt__SequenceBuilderKt.sequence(new kotlinx.coroutines.JobSupport$children$1(this, null));
    }

    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getCompletedInternal$kotlinx_coroutines_core() {
        java.lang.Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (!(!(state$kotlinx_coroutines_core instanceof kotlinx.coroutines.Incomplete))) {
            throw new java.lang.IllegalStateException("This job has not completed yet".toString());
        }
        if (state$kotlinx_coroutines_core instanceof kotlinx.coroutines.CompletedExceptionally) {
            throw ((kotlinx.coroutines.CompletedExceptionally) state$kotlinx_coroutines_core).cause;
        }
        return kotlinx.coroutines.JobSupportKt.unboxState(state$kotlinx_coroutines_core);
    }

    @org.jetbrains.annotations.Nullable
    public final java.lang.Throwable getCompletionCause() {
        java.lang.Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof kotlinx.coroutines.JobSupport.Finishing) {
            java.lang.Throwable d = ((kotlinx.coroutines.JobSupport.Finishing) state$kotlinx_coroutines_core).d();
            if (d != null) {
                return d;
            }
            throw new java.lang.IllegalStateException(kotlin.jvm.internal.Intrinsics.stringPlus("Job is still new or active: ", this).toString());
        }
        if (state$kotlinx_coroutines_core instanceof kotlinx.coroutines.Incomplete) {
            throw new java.lang.IllegalStateException(kotlin.jvm.internal.Intrinsics.stringPlus("Job is still new or active: ", this).toString());
        }
        if (state$kotlinx_coroutines_core instanceof kotlinx.coroutines.CompletedExceptionally) {
            return ((kotlinx.coroutines.CompletedExceptionally) state$kotlinx_coroutines_core).cause;
        }
        return null;
    }

    public final boolean getCompletionCauseHandled() {
        java.lang.Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        return (state$kotlinx_coroutines_core instanceof kotlinx.coroutines.CompletedExceptionally) && ((kotlinx.coroutines.CompletedExceptionally) state$kotlinx_coroutines_core).getHandled();
    }

    @org.jetbrains.annotations.Nullable
    public final java.lang.Throwable getCompletionExceptionOrNull() {
        java.lang.Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (!(state$kotlinx_coroutines_core instanceof kotlinx.coroutines.Incomplete)) {
            return k(state$kotlinx_coroutines_core);
        }
        throw new java.lang.IllegalStateException("This job has not completed yet".toString());
    }

    /* renamed from: getHandlesException$kotlinx_coroutines_core */
    public boolean getHandlesException() {
        return true;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    @org.jetbrains.annotations.NotNull
    public final kotlin.coroutines.CoroutineContext.Key<?> getKey() {
        return kotlinx.coroutines.Job.INSTANCE;
    }

    public boolean getOnCancelComplete$kotlinx_coroutines_core() {
        return false;
    }

    @Override // kotlinx.coroutines.Job
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.selects.SelectClause0 getOnJoin() {
        return this;
    }

    @org.jetbrains.annotations.Nullable
    public final kotlinx.coroutines.ChildHandle getParentHandle$kotlinx_coroutines_core() {
        return (kotlinx.coroutines.ChildHandle) this._parentHandle;
    }

    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getState$kotlinx_coroutines_core() {
        while (true) {
            java.lang.Object obj = this._state;
            if (!(obj instanceof kotlinx.coroutines.internal.OpDescriptor)) {
                return obj;
            }
            ((kotlinx.coroutines.internal.OpDescriptor) obj).perform(this);
        }
    }

    public final java.lang.Throwable h(java.lang.Object cause) {
        if (cause == null ? true : cause instanceof java.lang.Throwable) {
            java.lang.Throwable th = (java.lang.Throwable) cause;
            return th == null ? new kotlinx.coroutines.JobCancellationException(cancellationExceptionMessage(), null, this) : th;
        }
        if (cause != null) {
            return ((kotlinx.coroutines.ParentJob) cause).getChildJobCancellationCause();
        }
        throw new java.lang.NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
    }

    public boolean handleJobException(@org.jetbrains.annotations.NotNull java.lang.Throwable exception) {
        return false;
    }

    public void handleOnCompletionException$kotlinx_coroutines_core(@org.jetbrains.annotations.NotNull java.lang.Throwable exception) {
        throw exception;
    }

    public final java.lang.Object i(kotlinx.coroutines.JobSupport.Finishing state, java.lang.Object proposedUpdate) {
        boolean e;
        java.lang.Throwable l;
        kotlinx.coroutines.CompletedExceptionally completedExceptionally = proposedUpdate instanceof kotlinx.coroutines.CompletedExceptionally ? (kotlinx.coroutines.CompletedExceptionally) proposedUpdate : null;
        java.lang.Throwable th = completedExceptionally == null ? null : completedExceptionally.cause;
        synchronized (state) {
            e = state.e();
            java.util.List<java.lang.Throwable> h = state.h(th);
            l = l(state, h);
            if (l != null) {
                b(l, h);
            }
        }
        if (l != null && l != th) {
            proposedUpdate = new kotlinx.coroutines.CompletedExceptionally(l, false, 2, null);
        }
        if (l != null) {
            if (e(l) || handleJobException(l)) {
                if (proposedUpdate == null) {
                    throw new java.lang.NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
                }
                ((kotlinx.coroutines.CompletedExceptionally) proposedUpdate).makeHandled();
            }
        }
        if (!e) {
            onCancelling(l);
        }
        onCompletionInternal(proposedUpdate);
        defpackage.q1.a(n, this, state, kotlinx.coroutines.JobSupportKt.boxIncomplete(proposedUpdate));
        f(state, proposedUpdate);
        return proposedUpdate;
    }

    public final void initParentJob(@org.jetbrains.annotations.Nullable kotlinx.coroutines.Job parent) {
        if (parent == null) {
            setParentHandle$kotlinx_coroutines_core(kotlinx.coroutines.NonDisposableHandle.INSTANCE);
            return;
        }
        parent.start();
        kotlinx.coroutines.ChildHandle attachChild = parent.attachChild(this);
        setParentHandle$kotlinx_coroutines_core(attachChild);
        if (isCompleted()) {
            attachChild.dispose();
            setParentHandle$kotlinx_coroutines_core(kotlinx.coroutines.NonDisposableHandle.INSTANCE);
        }
    }

    @Override // kotlinx.coroutines.Job
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.DisposableHandle invokeOnCompletion(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit> handler) {
        return invokeOnCompletion(false, true, handler);
    }

    @Override // kotlinx.coroutines.Job
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.DisposableHandle invokeOnCompletion(boolean onCancelling, boolean invokeImmediately, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit> handler) {
        kotlinx.coroutines.JobNode q = q(handler, onCancelling);
        while (true) {
            java.lang.Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (state$kotlinx_coroutines_core instanceof kotlinx.coroutines.Empty) {
                kotlinx.coroutines.Empty empty = (kotlinx.coroutines.Empty) state$kotlinx_coroutines_core;
                if (!empty.getIsActive()) {
                    u(empty);
                } else if (defpackage.q1.a(n, this, state$kotlinx_coroutines_core, q)) {
                    return q;
                }
            } else {
                if (!(state$kotlinx_coroutines_core instanceof kotlinx.coroutines.Incomplete)) {
                    if (invokeImmediately) {
                        kotlinx.coroutines.CompletedExceptionally completedExceptionally = state$kotlinx_coroutines_core instanceof kotlinx.coroutines.CompletedExceptionally ? (kotlinx.coroutines.CompletedExceptionally) state$kotlinx_coroutines_core : null;
                        handler.invoke(completedExceptionally != null ? completedExceptionally.cause : null);
                    }
                    return kotlinx.coroutines.NonDisposableHandle.INSTANCE;
                }
                kotlinx.coroutines.NodeList list = ((kotlinx.coroutines.Incomplete) state$kotlinx_coroutines_core).getList();
                if (list != null) {
                    kotlinx.coroutines.DisposableHandle disposableHandle = kotlinx.coroutines.NonDisposableHandle.INSTANCE;
                    if (onCancelling && (state$kotlinx_coroutines_core instanceof kotlinx.coroutines.JobSupport.Finishing)) {
                        synchronized (state$kotlinx_coroutines_core) {
                            r3 = ((kotlinx.coroutines.JobSupport.Finishing) state$kotlinx_coroutines_core).d();
                            if (r3 == null || ((handler instanceof kotlinx.coroutines.ChildHandleNode) && !((kotlinx.coroutines.JobSupport.Finishing) state$kotlinx_coroutines_core).f())) {
                                if (a(state$kotlinx_coroutines_core, list, q)) {
                                    if (r3 == null) {
                                        return q;
                                    }
                                    disposableHandle = q;
                                }
                            }
                            kotlin.Unit unit = kotlin.Unit.INSTANCE;
                        }
                    }
                    if (r3 != null) {
                        if (invokeImmediately) {
                            handler.invoke(r3);
                        }
                        return disposableHandle;
                    }
                    if (a(state$kotlinx_coroutines_core, list, q)) {
                        return q;
                    }
                } else {
                    if (state$kotlinx_coroutines_core == null) {
                        throw new java.lang.NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                    }
                    v((kotlinx.coroutines.JobNode) state$kotlinx_coroutines_core);
                }
            }
        }
    }

    @Override // kotlinx.coroutines.Job
    public boolean isActive() {
        java.lang.Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        return (state$kotlinx_coroutines_core instanceof kotlinx.coroutines.Incomplete) && ((kotlinx.coroutines.Incomplete) state$kotlinx_coroutines_core).getIsActive();
    }

    @Override // kotlinx.coroutines.Job
    public final boolean isCancelled() {
        java.lang.Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        return (state$kotlinx_coroutines_core instanceof kotlinx.coroutines.CompletedExceptionally) || ((state$kotlinx_coroutines_core instanceof kotlinx.coroutines.JobSupport.Finishing) && ((kotlinx.coroutines.JobSupport.Finishing) state$kotlinx_coroutines_core).e());
    }

    @Override // kotlinx.coroutines.Job
    public final boolean isCompleted() {
        return !(getState$kotlinx_coroutines_core() instanceof kotlinx.coroutines.Incomplete);
    }

    public final boolean isCompletedExceptionally() {
        return getState$kotlinx_coroutines_core() instanceof kotlinx.coroutines.CompletedExceptionally;
    }

    public boolean isScopedCoroutine() {
        return false;
    }

    public final kotlinx.coroutines.ChildHandleNode j(kotlinx.coroutines.Incomplete state) {
        kotlinx.coroutines.ChildHandleNode childHandleNode = state instanceof kotlinx.coroutines.ChildHandleNode ? (kotlinx.coroutines.ChildHandleNode) state : null;
        if (childHandleNode != null) {
            return childHandleNode;
        }
        kotlinx.coroutines.NodeList list = state.getList();
        if (list == null) {
            return null;
        }
        return r(list);
    }

    @Override // kotlinx.coroutines.Job
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object join(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        java.lang.Object coroutine_suspended;
        if (!n()) {
            kotlinx.coroutines.JobKt.ensureActive(continuation.getContext());
            return kotlin.Unit.INSTANCE;
        }
        java.lang.Object o = o(continuation);
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return o == coroutine_suspended ? o : kotlin.Unit.INSTANCE;
    }

    public final java.lang.Throwable k(java.lang.Object obj) {
        kotlinx.coroutines.CompletedExceptionally completedExceptionally = obj instanceof kotlinx.coroutines.CompletedExceptionally ? (kotlinx.coroutines.CompletedExceptionally) obj : null;
        if (completedExceptionally == null) {
            return null;
        }
        return completedExceptionally.cause;
    }

    public final java.lang.Throwable l(kotlinx.coroutines.JobSupport.Finishing state, java.util.List<? extends java.lang.Throwable> exceptions) {
        java.lang.Object obj;
        java.lang.Object obj2 = null;
        if (exceptions.isEmpty()) {
            if (state.e()) {
                return new kotlinx.coroutines.JobCancellationException(cancellationExceptionMessage(), null, this);
            }
            return null;
        }
        java.util.List<? extends java.lang.Throwable> list = exceptions;
        java.util.Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (!(((java.lang.Throwable) obj) instanceof java.util.concurrent.CancellationException)) {
                break;
            }
        }
        java.lang.Throwable th = (java.lang.Throwable) obj;
        if (th != null) {
            return th;
        }
        java.lang.Throwable th2 = exceptions.get(0);
        if (th2 instanceof kotlinx.coroutines.TimeoutCancellationException) {
            java.util.Iterator<T> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                java.lang.Object next = it2.next();
                java.lang.Throwable th3 = (java.lang.Throwable) next;
                if (th3 != th2 && (th3 instanceof kotlinx.coroutines.TimeoutCancellationException)) {
                    obj2 = next;
                    break;
                }
            }
            java.lang.Throwable th4 = (java.lang.Throwable) obj2;
            if (th4 != null) {
                return th4;
            }
        }
        return th2;
    }

    public final kotlinx.coroutines.NodeList m(kotlinx.coroutines.Incomplete state) {
        kotlinx.coroutines.NodeList list = state.getList();
        if (list != null) {
            return list;
        }
        if (state instanceof kotlinx.coroutines.Empty) {
            return new kotlinx.coroutines.NodeList();
        }
        if (!(state instanceof kotlinx.coroutines.JobNode)) {
            throw new java.lang.IllegalStateException(kotlin.jvm.internal.Intrinsics.stringPlus("State should have list: ", state).toString());
        }
        v((kotlinx.coroutines.JobNode) state);
        return null;
    }

    public final boolean makeCompleting$kotlinx_coroutines_core(@org.jetbrains.annotations.Nullable java.lang.Object proposedUpdate) {
        java.lang.Object A;
        kotlinx.coroutines.internal.Symbol symbol;
        kotlinx.coroutines.internal.Symbol symbol2;
        do {
            A = A(getState$kotlinx_coroutines_core(), proposedUpdate);
            symbol = kotlinx.coroutines.JobSupportKt.a;
            if (A == symbol) {
                return false;
            }
            if (A == kotlinx.coroutines.JobSupportKt.COMPLETING_WAITING_CHILDREN) {
                return true;
            }
            symbol2 = kotlinx.coroutines.JobSupportKt.b;
        } while (A == symbol2);
        afterCompletion(A);
        return true;
    }

    @org.jetbrains.annotations.Nullable
    public final java.lang.Object makeCompletingOnce$kotlinx_coroutines_core(@org.jetbrains.annotations.Nullable java.lang.Object proposedUpdate) {
        java.lang.Object A;
        kotlinx.coroutines.internal.Symbol symbol;
        kotlinx.coroutines.internal.Symbol symbol2;
        do {
            A = A(getState$kotlinx_coroutines_core(), proposedUpdate);
            symbol = kotlinx.coroutines.JobSupportKt.a;
            if (A == symbol) {
                throw new java.lang.IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + proposedUpdate, k(proposedUpdate));
            }
            symbol2 = kotlinx.coroutines.JobSupportKt.b;
        } while (A == symbol2);
        return A;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    @org.jetbrains.annotations.NotNull
    public kotlin.coroutines.CoroutineContext minusKey(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext.Key<?> key) {
        return kotlinx.coroutines.Job.DefaultImpls.minusKey(this, key);
    }

    public final boolean n() {
        java.lang.Object state$kotlinx_coroutines_core;
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof kotlinx.coroutines.Incomplete)) {
                return false;
            }
        } while (w(state$kotlinx_coroutines_core) < 0);
        return true;
    }

    @org.jetbrains.annotations.NotNull
    public java.lang.String nameString$kotlinx_coroutines_core() {
        return kotlinx.coroutines.DebugStringsKt.getClassSimpleName(this);
    }

    public final java.lang.Object o(kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        kotlin.coroutines.Continuation intercepted;
        java.lang.Object coroutine_suspended;
        java.lang.Object coroutine_suspended2;
        intercepted = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        kotlinx.coroutines.CancellableContinuationImpl cancellableContinuationImpl = new kotlinx.coroutines.CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        kotlinx.coroutines.CancellableContinuationKt.disposeOnCancellation(cancellableContinuationImpl, invokeOnCompletion(new kotlinx.coroutines.ResumeOnCompletion(cancellableContinuationImpl)));
        java.lang.Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        coroutine_suspended2 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return result == coroutine_suspended2 ? result : kotlin.Unit.INSTANCE;
    }

    public void onCancelling(@org.jetbrains.annotations.Nullable java.lang.Throwable cause) {
    }

    public void onCompletionInternal(@org.jetbrains.annotations.Nullable java.lang.Object state) {
    }

    public void onStart() {
    }

    public final java.lang.Object p(java.lang.Object cause) {
        kotlinx.coroutines.internal.Symbol symbol;
        kotlinx.coroutines.internal.Symbol symbol2;
        kotlinx.coroutines.internal.Symbol symbol3;
        kotlinx.coroutines.internal.Symbol symbol4;
        kotlinx.coroutines.internal.Symbol symbol5;
        kotlinx.coroutines.internal.Symbol symbol6;
        java.lang.Throwable th = null;
        while (true) {
            java.lang.Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (state$kotlinx_coroutines_core instanceof kotlinx.coroutines.JobSupport.Finishing) {
                synchronized (state$kotlinx_coroutines_core) {
                    if (((kotlinx.coroutines.JobSupport.Finishing) state$kotlinx_coroutines_core).g()) {
                        symbol2 = kotlinx.coroutines.JobSupportKt.c;
                        return symbol2;
                    }
                    boolean e = ((kotlinx.coroutines.JobSupport.Finishing) state$kotlinx_coroutines_core).e();
                    if (cause != null || !e) {
                        if (th == null) {
                            th = h(cause);
                        }
                        ((kotlinx.coroutines.JobSupport.Finishing) state$kotlinx_coroutines_core).a(th);
                    }
                    java.lang.Throwable d = e ^ true ? ((kotlinx.coroutines.JobSupport.Finishing) state$kotlinx_coroutines_core).d() : null;
                    if (d != null) {
                        s(((kotlinx.coroutines.JobSupport.Finishing) state$kotlinx_coroutines_core).getList(), d);
                    }
                    symbol = kotlinx.coroutines.JobSupportKt.a;
                    return symbol;
                }
            }
            if (!(state$kotlinx_coroutines_core instanceof kotlinx.coroutines.Incomplete)) {
                symbol3 = kotlinx.coroutines.JobSupportKt.c;
                return symbol3;
            }
            if (th == null) {
                th = h(cause);
            }
            kotlinx.coroutines.Incomplete incomplete = (kotlinx.coroutines.Incomplete) state$kotlinx_coroutines_core;
            if (!incomplete.getIsActive()) {
                java.lang.Object A = A(state$kotlinx_coroutines_core, new kotlinx.coroutines.CompletedExceptionally(th, false, 2, null));
                symbol5 = kotlinx.coroutines.JobSupportKt.a;
                if (A == symbol5) {
                    throw new java.lang.IllegalStateException(kotlin.jvm.internal.Intrinsics.stringPlus("Cannot happen in ", state$kotlinx_coroutines_core).toString());
                }
                symbol6 = kotlinx.coroutines.JobSupportKt.b;
                if (A != symbol6) {
                    return A;
                }
            } else if (z(incomplete, th)) {
                symbol4 = kotlinx.coroutines.JobSupportKt.a;
                return symbol4;
            }
        }
    }

    @Override // kotlinx.coroutines.ChildJob
    public final void parentCancelled(@org.jetbrains.annotations.NotNull kotlinx.coroutines.ParentJob parentJob) {
        cancelImpl$kotlinx_coroutines_core(parentJob);
    }

    @Override // kotlin.coroutines.CoroutineContext
    @org.jetbrains.annotations.NotNull
    public kotlin.coroutines.CoroutineContext plus(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext coroutineContext) {
        return kotlinx.coroutines.Job.DefaultImpls.plus(this, coroutineContext);
    }

    @Override // kotlinx.coroutines.Job
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.Job plus(@org.jetbrains.annotations.NotNull kotlinx.coroutines.Job job) {
        return kotlinx.coroutines.Job.DefaultImpls.plus((kotlinx.coroutines.Job) this, job);
    }

    public final kotlinx.coroutines.JobNode q(kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit> handler, boolean onCancelling) {
        kotlinx.coroutines.JobNode jobNode;
        if (onCancelling) {
            jobNode = handler instanceof kotlinx.coroutines.JobCancellingNode ? (kotlinx.coroutines.JobCancellingNode) handler : null;
            if (jobNode == null) {
                jobNode = new kotlinx.coroutines.InvokeOnCancelling(handler);
            }
        } else {
            kotlinx.coroutines.JobNode jobNode2 = handler instanceof kotlinx.coroutines.JobNode ? (kotlinx.coroutines.JobNode) handler : null;
            jobNode = jobNode2 != null ? jobNode2 : null;
            if (jobNode == null) {
                jobNode = new kotlinx.coroutines.InvokeOnCompletion(handler);
            }
        }
        jobNode.setJob(this);
        return jobNode;
    }

    public final kotlinx.coroutines.ChildHandleNode r(kotlinx.coroutines.internal.LockFreeLinkedListNode lockFreeLinkedListNode) {
        while (lockFreeLinkedListNode.isRemoved()) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.getPrevNode();
        }
        while (true) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode();
            if (!lockFreeLinkedListNode.isRemoved()) {
                if (lockFreeLinkedListNode instanceof kotlinx.coroutines.ChildHandleNode) {
                    return (kotlinx.coroutines.ChildHandleNode) lockFreeLinkedListNode;
                }
                if (lockFreeLinkedListNode instanceof kotlinx.coroutines.NodeList) {
                    return null;
                }
            }
        }
    }

    @Override // kotlinx.coroutines.selects.SelectClause0
    public final <R> void registerSelectClause0(@org.jetbrains.annotations.NotNull kotlinx.coroutines.selects.SelectInstance<? super R> select, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> block) {
        java.lang.Object state$kotlinx_coroutines_core;
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (select.isSelected()) {
                return;
            }
            if (!(state$kotlinx_coroutines_core instanceof kotlinx.coroutines.Incomplete)) {
                if (select.trySelect()) {
                    kotlinx.coroutines.intrinsics.UndispatchedKt.startCoroutineUnintercepted(block, select.getCompletion());
                    return;
                }
                return;
            }
        } while (w(state$kotlinx_coroutines_core) != 0);
        select.disposeOnSelect(invokeOnCompletion(new kotlinx.coroutines.SelectJoinOnCompletion(select, block)));
    }

    public final <T, R> void registerSelectClause1Internal$kotlinx_coroutines_core(@org.jetbrains.annotations.NotNull kotlinx.coroutines.selects.SelectInstance<? super R> select, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> block) {
        java.lang.Object state$kotlinx_coroutines_core;
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (select.isSelected()) {
                return;
            }
            if (!(state$kotlinx_coroutines_core instanceof kotlinx.coroutines.Incomplete)) {
                if (select.trySelect()) {
                    if (state$kotlinx_coroutines_core instanceof kotlinx.coroutines.CompletedExceptionally) {
                        select.resumeSelectWithException(((kotlinx.coroutines.CompletedExceptionally) state$kotlinx_coroutines_core).cause);
                        return;
                    } else {
                        kotlinx.coroutines.intrinsics.UndispatchedKt.startCoroutineUnintercepted(block, kotlinx.coroutines.JobSupportKt.unboxState(state$kotlinx_coroutines_core), select.getCompletion());
                        return;
                    }
                }
                return;
            }
        } while (w(state$kotlinx_coroutines_core) != 0);
        select.disposeOnSelect(invokeOnCompletion(new kotlinx.coroutines.SelectAwaitOnCompletion(select, block)));
    }

    public final void removeNode$kotlinx_coroutines_core(@org.jetbrains.annotations.NotNull kotlinx.coroutines.JobNode node) {
        java.lang.Object state$kotlinx_coroutines_core;
        java.util.concurrent.atomic.AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        kotlinx.coroutines.Empty empty;
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof kotlinx.coroutines.JobNode)) {
                if (!(state$kotlinx_coroutines_core instanceof kotlinx.coroutines.Incomplete) || ((kotlinx.coroutines.Incomplete) state$kotlinx_coroutines_core).getList() == null) {
                    return;
                }
                node.remove();
                return;
            }
            if (state$kotlinx_coroutines_core != node) {
                return;
            }
            atomicReferenceFieldUpdater = n;
            empty = kotlinx.coroutines.JobSupportKt.f;
        } while (!defpackage.q1.a(atomicReferenceFieldUpdater, this, state$kotlinx_coroutines_core, empty));
    }

    public final void s(kotlinx.coroutines.NodeList list, java.lang.Throwable cause) {
        kotlinx.coroutines.CompletionHandlerException completionHandlerException;
        onCancelling(cause);
        kotlinx.coroutines.CompletionHandlerException completionHandlerException2 = null;
        for (kotlinx.coroutines.internal.LockFreeLinkedListNode lockFreeLinkedListNode = (kotlinx.coroutines.internal.LockFreeLinkedListNode) list.getNext(); !kotlin.jvm.internal.Intrinsics.areEqual(lockFreeLinkedListNode, list); lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode()) {
            if (lockFreeLinkedListNode instanceof kotlinx.coroutines.JobCancellingNode) {
                kotlinx.coroutines.JobNode jobNode = (kotlinx.coroutines.JobNode) lockFreeLinkedListNode;
                try {
                    jobNode.invoke(cause);
                } catch (java.lang.Throwable th) {
                    if (completionHandlerException2 == null) {
                        completionHandlerException = null;
                    } else {
                        kotlin.ExceptionsKt__ExceptionsKt.addSuppressed(completionHandlerException2, th);
                        completionHandlerException = completionHandlerException2;
                    }
                    if (completionHandlerException == null) {
                        completionHandlerException2 = new kotlinx.coroutines.CompletionHandlerException("Exception in completion handler " + jobNode + " for " + this, th);
                    }
                }
            }
        }
        if (completionHandlerException2 != null) {
            handleOnCompletionException$kotlinx_coroutines_core(completionHandlerException2);
        }
        e(cause);
    }

    public final <T, R> void selectAwaitCompletion$kotlinx_coroutines_core(@org.jetbrains.annotations.NotNull kotlinx.coroutines.selects.SelectInstance<? super R> select, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> block) {
        java.lang.Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof kotlinx.coroutines.CompletedExceptionally) {
            select.resumeSelectWithException(((kotlinx.coroutines.CompletedExceptionally) state$kotlinx_coroutines_core).cause);
        } else {
            kotlinx.coroutines.intrinsics.CancellableKt.startCoroutineCancellable$default(block, kotlinx.coroutines.JobSupportKt.unboxState(state$kotlinx_coroutines_core), select.getCompletion(), null, 4, null);
        }
    }

    public final void setParentHandle$kotlinx_coroutines_core(@org.jetbrains.annotations.Nullable kotlinx.coroutines.ChildHandle childHandle) {
        this._parentHandle = childHandle;
    }

    @Override // kotlinx.coroutines.Job
    public final boolean start() {
        int w;
        do {
            w = w(getState$kotlinx_coroutines_core());
            if (w == 0) {
                return false;
            }
        } while (w != 1);
        return true;
    }

    public final void t(kotlinx.coroutines.NodeList nodeList, java.lang.Throwable th) {
        kotlinx.coroutines.CompletionHandlerException completionHandlerException;
        kotlinx.coroutines.CompletionHandlerException completionHandlerException2 = null;
        for (kotlinx.coroutines.internal.LockFreeLinkedListNode lockFreeLinkedListNode = (kotlinx.coroutines.internal.LockFreeLinkedListNode) nodeList.getNext(); !kotlin.jvm.internal.Intrinsics.areEqual(lockFreeLinkedListNode, nodeList); lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode()) {
            if (lockFreeLinkedListNode instanceof kotlinx.coroutines.JobNode) {
                kotlinx.coroutines.JobNode jobNode = (kotlinx.coroutines.JobNode) lockFreeLinkedListNode;
                try {
                    jobNode.invoke(th);
                } catch (java.lang.Throwable th2) {
                    if (completionHandlerException2 == null) {
                        completionHandlerException = null;
                    } else {
                        kotlin.ExceptionsKt__ExceptionsKt.addSuppressed(completionHandlerException2, th2);
                        completionHandlerException = completionHandlerException2;
                    }
                    if (completionHandlerException == null) {
                        completionHandlerException2 = new kotlinx.coroutines.CompletionHandlerException("Exception in completion handler " + jobNode + " for " + this, th2);
                    }
                }
            }
        }
        if (completionHandlerException2 == null) {
            return;
        }
        handleOnCompletionException$kotlinx_coroutines_core(completionHandlerException2);
    }

    @org.jetbrains.annotations.NotNull
    public final java.util.concurrent.CancellationException toCancellationException(@org.jetbrains.annotations.NotNull java.lang.Throwable th, @org.jetbrains.annotations.Nullable java.lang.String str) {
        java.util.concurrent.CancellationException cancellationException = th instanceof java.util.concurrent.CancellationException ? (java.util.concurrent.CancellationException) th : null;
        if (cancellationException == null) {
            if (str == null) {
                str = cancellationExceptionMessage();
            }
            cancellationException = new kotlinx.coroutines.JobCancellationException(str, th, this);
        }
        return cancellationException;
    }

    @kotlinx.coroutines.InternalCoroutinesApi
    @org.jetbrains.annotations.NotNull
    public final java.lang.String toDebugString() {
        return nameString$kotlinx_coroutines_core() + '{' + x(getState$kotlinx_coroutines_core()) + '}';
    }

    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return toDebugString() + '@' + kotlinx.coroutines.DebugStringsKt.getHexAddress(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [kotlinx.coroutines.InactiveNodeList] */
    public final void u(kotlinx.coroutines.Empty state) {
        kotlinx.coroutines.NodeList nodeList = new kotlinx.coroutines.NodeList();
        if (!state.getIsActive()) {
            nodeList = new kotlinx.coroutines.InactiveNodeList(nodeList);
        }
        defpackage.q1.a(n, this, state, nodeList);
    }

    public final void v(kotlinx.coroutines.JobNode state) {
        state.addOneIfEmpty(new kotlinx.coroutines.NodeList());
        defpackage.q1.a(n, this, state, state.getNextNode());
    }

    public final int w(java.lang.Object state) {
        kotlinx.coroutines.Empty empty;
        if (!(state instanceof kotlinx.coroutines.Empty)) {
            if (!(state instanceof kotlinx.coroutines.InactiveNodeList)) {
                return 0;
            }
            if (!defpackage.q1.a(n, this, state, ((kotlinx.coroutines.InactiveNodeList) state).getList())) {
                return -1;
            }
            onStart();
            return 1;
        }
        if (((kotlinx.coroutines.Empty) state).getIsActive()) {
            return 0;
        }
        java.util.concurrent.atomic.AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = n;
        empty = kotlinx.coroutines.JobSupportKt.f;
        if (!defpackage.q1.a(atomicReferenceFieldUpdater, this, state, empty)) {
            return -1;
        }
        onStart();
        return 1;
    }

    public final java.lang.String x(java.lang.Object state) {
        if (!(state instanceof kotlinx.coroutines.JobSupport.Finishing)) {
            return state instanceof kotlinx.coroutines.Incomplete ? ((kotlinx.coroutines.Incomplete) state).getIsActive() ? "Active" : "New" : state instanceof kotlinx.coroutines.CompletedExceptionally ? "Cancelled" : "Completed";
        }
        kotlinx.coroutines.JobSupport.Finishing finishing = (kotlinx.coroutines.JobSupport.Finishing) state;
        return finishing.e() ? "Cancelling" : finishing.f() ? "Completing" : "Active";
    }

    public final boolean y(kotlinx.coroutines.Incomplete state, java.lang.Object update) {
        if (!defpackage.q1.a(n, this, state, kotlinx.coroutines.JobSupportKt.boxIncomplete(update))) {
            return false;
        }
        onCancelling(null);
        onCompletionInternal(update);
        f(state, update);
        return true;
    }

    public final boolean z(kotlinx.coroutines.Incomplete state, java.lang.Throwable rootCause) {
        kotlinx.coroutines.NodeList m = m(state);
        if (m == null) {
            return false;
        }
        if (!defpackage.q1.a(n, this, state, new kotlinx.coroutines.JobSupport.Finishing(m, false, rootCause))) {
            return false;
        }
        s(m, rootCause);
        return true;
    }
}
