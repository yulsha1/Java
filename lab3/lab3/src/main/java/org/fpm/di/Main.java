package org.fpm.di;

import javax.inject.Inject;
import javax.inject.Singleton;

public class Main {
    public static class A {

    }

    public static class B extends A {

    }

    @Singleton
    public static class MySingleton {

    }

    public static void main(String[] args) {
        var container = new SimpleEnvironment().configure(binder -> {
            binder.bind(A.class, B.class);
            binder.bind(A.class);
            binder.bind(B.class);
        });

        System.out.println(container.getComponent(A.class));
        System.out.println(container.getComponent(B.class));
        System.out.println(container.getComponent(A.class));
        System.out.println(container.getComponent(B.class));
    }
}
