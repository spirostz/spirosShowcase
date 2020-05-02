package com.spiros.view.transformer;

import org.jetbrains.annotations.Nullable;

import java.util.Optional;

/**
 * Transforms an Object of type {@link V} to an Object of type {@link T} and vice versa
 *
 * @param <V> Visual Object Type
 * @param <T> Transfer Object Type
 */
public interface VisualTransformer<V, T> {

    /**
     * Transforms {@link V} Visual Object Type to {@link T} Transfer Object Type
     *
     * @param visual Object that is going to be transformed
     * @return transfer Object in the {@link T} type
     */
    Optional<T> fromVisualToTransfer(@Nullable V visual);

    /**
     * Transforms {@link T} Transfer Object Type to {@link V} Visual Object Type
     *
     * @param transfer Object that is going to be transformed
     * @return visual Object in the {@link V} type
     */
    Optional<V> fromTransferToVisual(@Nullable T transfer);

}
