package org.fpm.di;

public class SimpleBinder implements Binder {
    private final SimpleContainer container;

    public SimpleBinder(SimpleContainer container) {
        this.container = container;
    }

    @Override
    public <T> void bind(Class<T> clazz) {
        container.bind(clazz);
    }

    @Override
    public <T> void bind(Class<T> clazz, Class<? extends T> implementation) {
        container.bind(clazz, implementation);
    }

    @Override
    public <T> void bind(Class<T> clazz, T instance) {
        container.bind(clazz, instance);
    }
}
