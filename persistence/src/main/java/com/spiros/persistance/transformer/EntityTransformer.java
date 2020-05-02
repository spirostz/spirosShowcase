package com.spiros.persistance.transformer;

import org.jetbrains.annotations.Nullable;

import java.util.Optional;

/**
 * Transforms an Object of type {@link E} to an Object of type {@link T} and vice versa
 *
 * @param <E> Entity Object Type
 * @param <T> Transfer Object Type
 */
public interface EntityTransformer<E, T> {

    /**
     * Transforms {@link E} Entity Object Type to {@link T} Transfer Object Type
     *
     * @param entity Object that is going to be transformed, it can be null
     * @return transfer Object in the {@link T} type as an optional
     */
    Optional<T> fromEntityToTransfer(@Nullable E entity);

    /**
     * Transforms {@link T} Transfer Object Type to {@link E} Entity Object Type
     *
     * @param transfer Object that is going to be transformed, it can be null
     * @return entity Object in the {@link E} type as an optional
     */
    Optional<E> fromTransferToEntity(@Nullable T transfer);

}
