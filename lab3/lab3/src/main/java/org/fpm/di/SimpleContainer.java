package org.fpm.di;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class SimpleContainer implements Container {
    private final HashMap<Class<?>, Object> singletons = new HashMap<>();
    private final HashMap<Class<?>, Object> instances = new HashMap<>();
    private final HashMap<Class<?>, Class<?>> implementationClasses = new HashMap<>();

    public <T> void bind(Class<T> clazz) {
        implementationClasses.put(clazz, null);
    }

    public <T> void bind(Class<T> clazz, Class<? extends T> implementation) {
        implementationClasses.put(clazz, implementation);
    }

    public <T> void bind(Class<T> clazz, T instance) {
        bind(clazz);
        instances.put(clazz, instance);
    }

    private <T> Class<? extends T> getImplementationClass(Class<T> clazz) {
        Class<? extends T> previous = clazz;
        while(true) {
            if (!implementationClasses.containsKey(previous)) {
                throw new RuntimeException("No obligation");
            }

            Class<?> impl = implementationClasses.get(previous);

            if (impl == null) {
                return previous;
            }

            previous = (Class<? extends T>) impl;
        }
    }

    @Override
    public <T> T getComponent(Class<T> clazz) {
        Class<? extends T> impl = getImplementationClass(clazz);

        if (instances.containsKey(impl)) {
            return (T)instances.get(impl);
        }

        if (impl.isAnnotationPresent(Singleton.class)) {
            if (singletons.containsKey(impl)) {
                return (T)singletons.get(impl);
            }

            T result = createComponent(impl);
            singletons.put(clazz, result);

            return result;
        }

        return createComponent(impl);
    }

    private <T> T createComponent(Class<T> clazz) {
        Constructor<T> cons = findConstructor(clazz);

        Object[] params = new Object[cons.getParameterCount()];
        Class<?>[] paramTypes = cons.getParameterTypes();

        for (int i = 0; i < params.length; i++) {
            params[i] = getComponent(paramTypes[i]);
        }

        try {
            return cons.newInstance(params);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private static<T> Constructor<T> findConstructor(Class<T> clazz) {
        Constructor<?>[] constructors = clazz.getConstructors();

        for (Constructor<?> constructor : constructors) {
            if (constructor.getParameterCount() == 0 || constructor.isAnnotationPresent(Inject.class)) {
                return (Constructor<T>)constructor;
            }
        }

        throw new RuntimeException("Can't find constructor");
    }
}
