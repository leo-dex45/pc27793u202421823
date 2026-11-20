package com.medisupply.platform.u202421823.shared.infrastructure.events;

import com.medisupply.platform.u202421823.shared.domain.model.aggregates.AbstractDomainAggregateRoot;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * Shared infrastructure service responsible for publishing and clearing domain events
 * registered on {@link AbstractDomainAggregateRoot} instances.
 */

@Component
@NullMarked
public class DomainEventPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;


    public DomainEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }


    public <T extends AbstractDomainAggregateRoot<T>> void publishAndClearEvents(@Nullable T aggregate) {
        if (aggregate == null) {
            return;
        }
        aggregate.domainEvents().forEach(applicationEventPublisher::publishEvent);
        aggregate.clearDomainEvents();
    }
}
