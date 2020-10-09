/*
 * Copyright 2017, Yahoo Holdings Inc.
 * Copyrights licensed under the GPL License.
 * See the accompanying LICENSE file for terms.
 */

package com.yahoo.sherlock.store.core;

import io.lettuce.core.codec.RedisCodec;

/**
 * Generic class used to create {@code RedisConnection} instances.
 */
public interface ConnectionProducer {

    /**
     * @param codec Redis codec to use
     * @param <K> codec primary type
     * @return a redis connection
     */
    <K> RedisConnection<K> produce(RedisCodec<K, K> codec);
}
