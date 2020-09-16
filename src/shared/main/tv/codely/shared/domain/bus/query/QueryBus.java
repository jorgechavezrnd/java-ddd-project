package tv.codely.shared.domain.bus.query;

public interface QueryBus {
    <R extends Response> R ask(Query query) throws QueryHandlerExecutionError;
}
