package uz.micros.jstore.repository;

import uz.micros.jstore.entity.blog.Post;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Mapper<T> {


    public T map(Map<String, Object> item) {
        T res = null;

        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        Type types[] = type.getActualTypeArguments();
        Class c = (Class) types[0];
        try {
            res = (T) c.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        List<Method> setters = findsetters(res.getClass());

        for (Method n : setters) {
            String name = n.getName().replace("set", "").toLowerCase();
            Object val = item.get(name);
            try {
                n.invoke(res, val);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        return res;
    }

    private List<Method> findsetters(Class<?> aClass) {
        List<Method> res = new ArrayList<>();
        Method[] methods = aClass.getDeclaredMethods();
        for (Method m : methods)
            if (isSetter(m))
                res.add(m);

        return res;
    }

    private boolean isSetter(Method m) {
        return Modifier.isPublic(m.getModifiers()) &&
                m.getReturnType().equals(void.class) &&
                m.getParameterTypes().length == 1 &&
                m.getName().matches("^set[A-Z].*");
    }
}
