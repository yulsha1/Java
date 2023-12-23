package org.fpm.di;

public class SimpleEnvironment implements Environment {
    @Override
    public Container configure(Configuration configuration) {
        var container = new SimpleContainer();
        var binder = new SimpleBinder(container);
        configuration.configure(binder);

        return container;
    }
}
