package org.eclipse.jakarta.hello;

import javax.ws.rs.core.Application;
import javax.ws.rs.ApplicationPath;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("api")
public class ProductManagerApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        classes.add(ProductResource.class);
        classes.add(ConstraintViolationExceptionMapper.class);
        return classes;
    }
}