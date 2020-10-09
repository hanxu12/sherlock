/*
 * Copyright 2017, Yahoo Holdings Inc.
 * Copyrights licensed under the GPL License.
 * See the accompanying LICENSE file for terms.
 */

package com.yahoo.sherlock.store.core;

import io.lettuce.core.codec.ByteArrayCodec;
import io.lettuce.core.codec.StringCodec;
import com.yahoo.sherlock.store.StoreParams;

/**
 * This abstract class manages a {@code ConnectionProducer} instance which
 * either creates cluster connections or regular connections.
 */
public abstract class BaseAccessor {

    private final ConnectionProducer producer;

    /**
     * @param params parameters to use for the clients
     * @param clustered whether this accessor should use clustered connections
     */
    public BaseAccessor(StoreParams params, boolean clustered) {
        producer = clustered ? new ConnectionProducerClusterImpl(params) : new ConnectionProducerImpl(params);
    }

    /**
     * @return a string connection
     */
    public RedisConnection<String> connect() {
        return producer.produce(new StringCodec());
    }

    /**
     * @return a binary connection
     */
    public RedisConnection<byte[]> binary() {
        return producer.produce(new ByteArrayCodec());
    }

}
