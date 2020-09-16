package tv.codely.mooc.notifications.application.send_welcome_user_email;

import tv.codely.shared.domain.bus.event.DomainEvent;
import tv.codely.shared.domain.bus.event.DomainEventSubscriber;

import java.lang.annotation.Annotation;

public class SendWelcomeUserEmailOnUserRegistered implements DomainEventSubscriber {
    @Override
    public Class<? extends DomainEvent<?>>[] value() {
        return new Class[0];
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
