/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.netty.util.internal.shaded.jctools.queues.atomic;

import io.netty.util.internal.shaded.jctools.util.PortableJvmInfo;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;

/**
 * NOTE: This class was automatically generated by io.netty.util.internal.shaded.jctools.queues.atomic.JavaParsingAtomicArrayQueueGenerator
 * which can found in the jctools-build module. The original source file is MpscArrayQueue.java.
 */
abstract class MpscAtomicArrayQueueL1Pad<E> extends AtomicReferenceArrayQueue<E> {

    long p00, p01, p02, p03, p04, p05, p06, p07;

    long p10, p11, p12, p13, p14, p15, p16;

    MpscAtomicArrayQueueL1Pad(int capacity) {
        super(capacity);
    }
}

/**
 * NOTE: This class was automatically generated by io.netty.util.internal.shaded.jctools.queues.atomic.JavaParsingAtomicArrayQueueGenerator
 * which can found in the jctools-build module. The original source file is MpscArrayQueue.java.
 */
abstract class MpscAtomicArrayQueueProducerIndexField<E> extends MpscAtomicArrayQueueL1Pad<E> {

    private static final AtomicLongFieldUpdater<MpscAtomicArrayQueueProducerIndexField> P_INDEX_UPDATER = AtomicLongFieldUpdater.newUpdater(MpscAtomicArrayQueueProducerIndexField.class, "producerIndex");

    private volatile long producerIndex;

    MpscAtomicArrayQueueProducerIndexField(int capacity) {
        super(capacity);
    }

    @Override
    public final long lvProducerIndex() {
        return producerIndex;
    }

    final boolean casProducerIndex(long expect, long newValue) {
        return P_INDEX_UPDATER.compareAndSet(this, expect, newValue);
    }
}

/**
 * NOTE: This class was automatically generated by io.netty.util.internal.shaded.jctools.queues.atomic.JavaParsingAtomicArrayQueueGenerator
 * which can found in the jctools-build module. The original source file is MpscArrayQueue.java.
 */
abstract class MpscAtomicArrayQueueMidPad<E> extends MpscAtomicArrayQueueProducerIndexField<E> {

    long p01, p02, p03, p04, p05, p06, p07;

    long p10, p11, p12, p13, p14, p15, p16, p17;

    MpscAtomicArrayQueueMidPad(int capacity) {
        super(capacity);
    }
}

/**
 * NOTE: This class was automatically generated by io.netty.util.internal.shaded.jctools.queues.atomic.JavaParsingAtomicArrayQueueGenerator
 * which can found in the jctools-build module. The original source file is MpscArrayQueue.java.
 */
abstract class MpscAtomicArrayQueueProducerLimitField<E> extends MpscAtomicArrayQueueMidPad<E> {

    private static final AtomicLongFieldUpdater<MpscAtomicArrayQueueProducerLimitField> P_LIMIT_UPDATER = AtomicLongFieldUpdater.newUpdater(MpscAtomicArrayQueueProducerLimitField.class, "producerLimit");

    // First unavailable index the producer may claim up to before rereading the consumer index
    private volatile long producerLimit;

    MpscAtomicArrayQueueProducerLimitField(int capacity) {
        super(capacity);
        this.producerLimit = capacity;
    }

    final long lvProducerLimit() {
        return producerLimit;
    }

    final void soProducerLimit(long newValue) {
        P_LIMIT_UPDATER.lazySet(this, newValue);
    }
}

/**
 * NOTE: This class was automatically generated by io.netty.util.internal.shaded.jctools.queues.atomic.JavaParsingAtomicArrayQueueGenerator
 * which can found in the jctools-build module. The original source file is MpscArrayQueue.java.
 */
abstract class MpscAtomicArrayQueueL2Pad<E> extends MpscAtomicArrayQueueProducerLimitField<E> {

    long p00, p01, p02, p03, p04, p05, p06, p07;

    long p10, p11, p12, p13, p14, p15, p16;

    MpscAtomicArrayQueueL2Pad(int capacity) {
        super(capacity);
    }
}

/**
 * NOTE: This class was automatically generated by io.netty.util.internal.shaded.jctools.queues.atomic.JavaParsingAtomicArrayQueueGenerator
 * which can found in the jctools-build module. The original source file is MpscArrayQueue.java.
 */
abstract class MpscAtomicArrayQueueConsumerIndexField<E> extends MpscAtomicArrayQueueL2Pad<E> {

    private static final AtomicLongFieldUpdater<MpscAtomicArrayQueueConsumerIndexField> C_INDEX_UPDATER = AtomicLongFieldUpdater.newUpdater(MpscAtomicArrayQueueConsumerIndexField.class, "consumerIndex");

    private volatile long consumerIndex;

    MpscAtomicArrayQueueConsumerIndexField(int capacity) {
        super(capacity);
    }

    @Override
    public final long lvConsumerIndex() {
        return consumerIndex;
    }

    final long lpConsumerIndex() {
        return consumerIndex;
    }

    final void soConsumerIndex(long newValue) {
        C_INDEX_UPDATER.lazySet(this, newValue);
    }
}

/**
 * NOTE: This class was automatically generated by io.netty.util.internal.shaded.jctools.queues.atomic.JavaParsingAtomicArrayQueueGenerator
 * which can found in the jctools-build module. The original source file is MpscArrayQueue.java.
 */
abstract class MpscAtomicArrayQueueL3Pad<E> extends MpscAtomicArrayQueueConsumerIndexField<E> {

    long p01, p02, p03, p04, p05, p06, p07;

    long p10, p11, p12, p13, p14, p15, p16, p17;

    MpscAtomicArrayQueueL3Pad(int capacity) {
        super(capacity);
    }
}

/**
 * NOTE: This class was automatically generated by io.netty.util.internal.shaded.jctools.queues.atomic.JavaParsingAtomicArrayQueueGenerator
 * which can found in the jctools-build module. The original source file is MpscArrayQueue.java.
 *
 * A Multi-Producer-Single-Consumer queue based on a {@link io.netty.util.internal.shaded.jctools.queues.ConcurrentCircularArrayQueue}. This
 * implies that any thread may call the offer method, but only a single thread may call poll/peek for correctness to
 * maintained. <br>
 * This implementation follows patterns documented on the package level for False Sharing protection.<br>
 * This implementation is using the <a href="http://sourceforge.net/projects/mc-fastflow/">Fast Flow</a>
 * method for polling from the queue (with minor change to correctly publish the index) and an extension of
 * the Leslie Lamport concurrent queue algorithm (originated by Martin Thompson) on the producer side.<br>
 *
 * @param <E>
 * @author nitsanw
 */
public class MpscAtomicArrayQueue<E> extends MpscAtomicArrayQueueL3Pad<E> {

    public MpscAtomicArrayQueue(final int capacity) {
        super(capacity);
    }

    /**
     * {@link #offer}} if {@link #size()} is less than threshold.
     *
     * @param e         the object to offer onto the queue, not null
     * @param threshold the maximum allowable size
     * @return true if the offer is successful, false if queue size exceeds threshold
     * @since 1.0.1
     */
    public boolean offerIfBelowThreshold(final E e, int threshold) {
        if (null == e) {
            throw new NullPointerException();
        }
        final int mask = this.mask;
        final long capacity = mask + 1;
        // LoadLoad
        long producerLimit = lvProducerLimit();
        long pIndex;
        do {
            // LoadLoad
            pIndex = lvProducerIndex();
            long available = producerLimit - pIndex;
            long size = capacity - available;
            if (size >= threshold) {
                // LoadLoad
                final long cIndex = lvConsumerIndex();
                size = pIndex - cIndex;
                if (size >= threshold) {
                    // the size exceeds threshold
                    return false;
                } else {
                    // update producer limit to the next index that we must recheck the consumer index
                    producerLimit = cIndex + capacity;
                    // this is racy, but the race is benign
                    soProducerLimit(producerLimit);
                }
            }
        } while (!casProducerIndex(pIndex, pIndex + 1));
        /*
         * NOTE: the new producer index value is made visible BEFORE the element in the array. If we relied on
         * the index visibility to poll() we would need to handle the case where the element is not visible.
         */
        // Won CAS, move on to storing
        final int offset = calcElementOffset(pIndex, mask);
        // StoreStore
        soElement(buffer, offset, e);
        // AWESOME :)
        return true;
    }

    /**
     * {@inheritDoc} <br>
     * <p>
     * IMPLEMENTATION NOTES:<br>
     * Lock free offer using a single CAS. As class name suggests access is permitted to many threads
     * concurrently.
     *
     * @see java.util.Queue#offer
     * @see io.netty.util.internal.shaded.jctools.queues.MessagePassingQueue#offer
     */
    @Override
    public boolean offer(final E e) {
        if (null == e) {
            throw new NullPointerException();
        }
        // use a cached view on consumer index (potentially updated in loop)
        final int mask = this.mask;
        // LoadLoad
        long producerLimit = lvProducerLimit();
        long pIndex;
        do {
            // LoadLoad
            pIndex = lvProducerIndex();
            if (pIndex >= producerLimit) {
                // LoadLoad
                final long cIndex = lvConsumerIndex();
                producerLimit = cIndex + mask + 1;
                if (pIndex >= producerLimit) {
                    // FULL :(
                    return false;
                } else {
                    // update producer limit to the next index that we must recheck the consumer index
                    // this is racy, but the race is benign
                    soProducerLimit(producerLimit);
                }
            }
        } while (!casProducerIndex(pIndex, pIndex + 1));
        /*
         * NOTE: the new producer index value is made visible BEFORE the element in the array. If we relied on
         * the index visibility to poll() we would need to handle the case where the element is not visible.
         */
        // Won CAS, move on to storing
        final int offset = calcElementOffset(pIndex, mask);
        // StoreStore
        soElement(buffer, offset, e);
        // AWESOME :)
        return true;
    }

    /**
     * A wait free alternative to offer which fails on CAS failure.
     *
     * @param e new element, not null
     * @return 1 if next element cannot be filled, -1 if CAS failed, 0 if successful
     */
    public final int failFastOffer(final E e) {
        if (null == e) {
            throw new NullPointerException();
        }
        final int mask = this.mask;
        final long capacity = mask + 1;
        // LoadLoad
        final long pIndex = lvProducerIndex();
        // LoadLoad
        long producerLimit = lvProducerLimit();
        if (pIndex >= producerLimit) {
            // LoadLoad
            final long cIndex = lvConsumerIndex();
            producerLimit = cIndex + capacity;
            if (pIndex >= producerLimit) {
                // FULL :(
                return 1;
            } else {
                // update producer limit to the next index that we must recheck the consumer index
                // StoreLoad
                soProducerLimit(producerLimit);
            }
        }
        // look Ma, no loop!
        if (!casProducerIndex(pIndex, pIndex + 1)) {
            // CAS FAIL :(
            return -1;
        }
        // Won CAS, move on to storing
        final int offset = calcElementOffset(pIndex, mask);
        soElement(buffer, offset, e);
        // AWESOME :)
        return 0;
    }

    /**
     * {@inheritDoc}
     * <p>
     * IMPLEMENTATION NOTES:<br>
     * Lock free poll using ordered loads/stores. As class name suggests access is limited to a single thread.
     *
     * @see java.util.Queue#poll
     * @see io.netty.util.internal.shaded.jctools.queues.MessagePassingQueue#poll
     */
    @Override
    public E poll() {
        final long cIndex = lpConsumerIndex();
        final int offset = calcElementOffset(cIndex);
        // Copy field to avoid re-reading after volatile load
        final AtomicReferenceArray<E> buffer = this.buffer;
        // If we can't see the next available element we can't poll
        // LoadLoad
        E e = lvElement(buffer, offset);
        if (null == e) {
            /*
             * NOTE: Queue may not actually be empty in the case of a producer (P1) being interrupted after
             * winning the CAS on offer but before storing the element in the queue. Other producers may go on
             * to fill up the queue after this element.
             */
            if (cIndex != lvProducerIndex()) {
                do {
                    e = lvElement(buffer, offset);
                } while (e == null);
            } else {
                return null;
            }
        }
        spElement(buffer, offset, null);
        // StoreStore
        soConsumerIndex(cIndex + 1);
        return e;
    }

    /**
     * {@inheritDoc}
     * <p>
     * IMPLEMENTATION NOTES:<br>
     * Lock free peek using ordered loads. As class name suggests access is limited to a single thread.
     *
     * @see java.util.Queue#poll
     * @see io.netty.util.internal.shaded.jctools.queues.MessagePassingQueue#poll
     */
    @Override
    public E peek() {
        // Copy field to avoid re-reading after volatile load
        final AtomicReferenceArray<E> buffer = this.buffer;
        // LoadLoad
        final long cIndex = lpConsumerIndex();
        final int offset = calcElementOffset(cIndex);
        E e = lvElement(buffer, offset);
        if (null == e) {
            /*
             * NOTE: Queue may not actually be empty in the case of a producer (P1) being interrupted after
             * winning the CAS on offer but before storing the element in the queue. Other producers may go on
             * to fill up the queue after this element.
             */
            if (cIndex != lvProducerIndex()) {
                do {
                    e = lvElement(buffer, offset);
                } while (e == null);
            } else {
                return null;
            }
        }
        return e;
    }

    @Override
    public boolean relaxedOffer(E e) {
        return offer(e);
    }

    @Override
    public E relaxedPoll() {
        final AtomicReferenceArray<E> buffer = this.buffer;
        final long cIndex = lpConsumerIndex();
        final int offset = calcElementOffset(cIndex);
        // If we can't see the next available element we can't poll
        // LoadLoad
        E e = lvElement(buffer, offset);
        if (null == e) {
            return null;
        }
        spElement(buffer, offset, null);
        // StoreStore
        soConsumerIndex(cIndex + 1);
        return e;
    }

    @Override
    public E relaxedPeek() {
        final AtomicReferenceArray<E> buffer = this.buffer;
        final int mask = this.mask;
        final long cIndex = lpConsumerIndex();
        return lvElement(buffer, calcElementOffset(cIndex, mask));
    }

    @Override
    public int drain(Consumer<E> c) {
        return drain(c, capacity());
    }

    @Override
    public int fill(Supplier<E> s) {
        // result is a long because we want to have a safepoint check at regular intervals
        long result = 0;
        final int capacity = capacity();
        do {
            final int filled = fill(s, PortableJvmInfo.RECOMENDED_OFFER_BATCH);
            if (filled == 0) {
                return (int) result;
            }
            result += filled;
        } while (result <= capacity);
        return (int) result;
    }

    @Override
    public int drain(final Consumer<E> c, final int limit) {
        final AtomicReferenceArray<E> buffer = this.buffer;
        final int mask = this.mask;
        final long cIndex = lpConsumerIndex();
        for (int i = 0; i < limit; i++) {
            final long index = cIndex + i;
            final int offset = calcElementOffset(index, mask);
            // LoadLoad
            final E e = lvElement(buffer, offset);
            if (null == e) {
                return i;
            }
            spElement(buffer, offset, null);
            // ordered store -> atomic and ordered for size()
            soConsumerIndex(index + 1);
            c.accept(e);
        }
        return limit;
    }

    @Override
    public int fill(Supplier<E> s, int limit) {
        if (null == s)
            throw new IllegalArgumentException("supplier is null");
        if (limit < 0)
            throw new IllegalArgumentException("limit is negative:" + limit);
        if (limit == 0)
            return 0;
        final int mask = this.mask;
        final long capacity = mask + 1;
        // LoadLoad
        long producerLimit = lvProducerLimit();
        long pIndex;
        int actualLimit = 0;
        do {
            // LoadLoad
            pIndex = lvProducerIndex();
            long available = producerLimit - pIndex;
            if (available <= 0) {
                // LoadLoad
                final long cIndex = lvConsumerIndex();
                producerLimit = cIndex + capacity;
                available = producerLimit - pIndex;
                if (available <= 0) {
                    // FULL :(
                    return 0;
                } else {
                    // update producer limit to the next index that we must recheck the consumer index
                    // StoreLoad
                    soProducerLimit(producerLimit);
                }
            }
            actualLimit = Math.min((int) available, limit);
        } while (!casProducerIndex(pIndex, pIndex + actualLimit));
        // right, now we claimed a few slots and can fill them with goodness
        final AtomicReferenceArray<E> buffer = this.buffer;
        for (int i = 0; i < actualLimit; i++) {
            // Won CAS, move on to storing
            final int offset = calcElementOffset(pIndex + i, mask);
            soElement(buffer, offset, s.get());
        }
        return actualLimit;
    }

    @Override
    public void drain(Consumer<E> c, WaitStrategy w, ExitCondition exit) {
        final AtomicReferenceArray<E> buffer = this.buffer;
        final int mask = this.mask;
        long cIndex = lpConsumerIndex();
        int counter = 0;
        while (exit.keepRunning()) {
            for (int i = 0; i < 4096; i++) {
                final int offset = calcElementOffset(cIndex, mask);
                // LoadLoad
                final E e = lvElement(buffer, offset);
                if (null == e) {
                    counter = w.idle(counter);
                    continue;
                }
                cIndex++;
                counter = 0;
                spElement(buffer, offset, null);
                // ordered store -> atomic and ordered for size()
                soConsumerIndex(cIndex);
                c.accept(e);
            }
        }
    }

    @Override
    public void fill(Supplier<E> s, WaitStrategy w, ExitCondition exit) {
        if (null == w)
            throw new IllegalArgumentException("waiter is null");
        if (null == exit)
            throw new IllegalArgumentException("exit condition is null");
        int idleCounter = 0;
        while (exit.keepRunning()) {
            if (fill(s, PortableJvmInfo.RECOMENDED_OFFER_BATCH) == 0) {
                idleCounter = w.idle(idleCounter);
                continue;
            }
            idleCounter = 0;
        }
    }

    /**
     * @deprecated This was renamed to failFastOffer please migrate
     */
    @Deprecated
    public int weakOffer(E e) {
        return this.failFastOffer(e);
    }
}
