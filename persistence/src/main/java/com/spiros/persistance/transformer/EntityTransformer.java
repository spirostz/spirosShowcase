package com.spiros.persistance.transformer;

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
     * @param entity Object that is going to be transformed
     * @return transfer Object in the {@link T} type
     */
    T fromEntityToTransfer(E entity);

    /**
     * Transforms {@link T} Transfer Object Type to {@link E} Entity Object Type
     *
     * @param transfer Object that is going to be transformed
     * @return entity Object in the {@link E} type
     */
    E fromTransferToEntity(T transfer);

}
