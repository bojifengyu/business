/*
 * Copyright © 2013-2017, The SeedStack authors <http://seedstack.org>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.seedstack.business.spi;

import org.seedstack.business.domain.AggregateRoot;

/**
 * Interface for classes implementing the ability to instantiate corresponding aggregates and
 * identifiers from a DTO. DTO resolvers are used by
 * {@link org.seedstack.business.assembler.dsl.FluentAssembler}
 * to create domain aggregates and/or identifiers from DTO instances.
 *
 * <p> There can be several {@link DtoInfoResolver}s in the system: the first one returning true
 * from the {@link #supports(Object)} for a particular DTO will be used. Implementations can be
 * annotated with {@code javax.annotation.Priority} to define an absolute order amongst them. </p>
 */
public interface DtoInfoResolver {

  /**
   * Returns whether the resolver supports the DTO instance passed as argument. The first resolver
   * to support a particular DTO is used.
   *
   * @param dto    the DTO to check for.
   * @param <DtoT> the type of the DTO.
   * @return true if the resolver supports this particular DTO, false otherwise.
   */
  <DtoT> boolean supports(DtoT dto);

  /**
   * Returns the identifier instance derived from the DTO instance passed as first argument.
   *
   * @param dto              the DTO used to resolve the identifier.
   * @param aggregateIdClass the identifier class.
   * @param <DtoT>           the type of the DTO.
   * @param <IdT>            the type of the identifier.
   * @return the newly created identifier derived from the DTO.
   */
  <DtoT, IdT> IdT resolveId(DtoT dto, Class<IdT> aggregateIdClass);

  /**
   * Similar to {@link #resolveId(Object, Class)} but used in the case where a {@link
   * org.javatuples.Tuple} of multiple aggregates corresponds to a single DTO. The position argument
   * specifies the index of the identifier in the tuple.
   *
   * @param dto              the DTO used to resolve the identifier.
   * @param aggregateIdClass the identifier class.
   * @param position         the position in the tuple of the aggregate this identifier relates to.
   * @param <DtoT>           the type of the DTO.
   * @param <IdT>            the type of the identifier.
   * @return the newly created identifier derived from the DTO.
   */
  <DtoT, IdT> IdT resolveId(DtoT dto, Class<IdT> aggregateIdClass, int position);

  /**
   * Returns the aggregate instance derived from the DTO instance passed as first argument.
   *
   * @param dto                the DTO sued to resolve the aggregate.
   * @param aggregateRootClass the aggregate root class.
   * @param <DtoT>             the type of the DTO.
   * @param <AggregateRootT>   the type of the aggregate root.
   * @return the newly created aggregate derived from the DTO.
   */
  <DtoT, AggregateRootT extends AggregateRoot<?>> AggregateRootT resolveAggregate(DtoT dto,
      Class<AggregateRootT> aggregateRootClass);

  /**
   * Similar to {@link #resolveAggregate(Object, Class)} but used in the case where a {@link
   * org.javatuples.Tuple} of multiple aggregates corresponds to a single DTO. The position argument
   * specifies the index of the aggregate in the tuple.
   *
   * @param dto                the DTO sued to resolve the aggregate.
   * @param aggregateRootClass the aggregate root class.
   * @param position           the position in the tuple of the aggregate to create.
   * @param <DtoT>             the type of the DTO.
   * @param <AggregateRootT>   the type of the aggregate root.
   * @return the newly created aggregate derived from the DTO.
   */
  <DtoT, AggregateRootT extends AggregateRoot<?>> AggregateRootT resolveAggregate(DtoT dto,
      Class<AggregateRootT> aggregateRootClass,
      int position);
}