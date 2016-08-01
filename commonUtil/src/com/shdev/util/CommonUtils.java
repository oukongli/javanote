package com.shdev.util;

import java.lang.reflect.Constructor;
import java.util.*;

public final class CommonUtils {
    private CommonUtils() {
    }

    public interface IGetKey<K, V> {
        K getKey(V obj);
    }

    public interface IMapper<S, T> {
        T map(S value);
    }

    public static <T, R> List<R> map(List<T> list, IMapper<T, R> mapper) {
        List<R> result = new ArrayList<R>();
        for (T item : list) {
            result.add(mapper.map(item));
        }
        return result;
    }

    public interface IPredicate<T> {
        boolean isMatch(T obj);
    }

    public static <T> T find(Iterable<T> list, IPredicate<T> predicate) {
        for (T item : list) {
            if (predicate.isMatch(item)) return item;
        }
        return null;
    }

    public static <T> T newObject(Class<T> type) {
        try {
            return type.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T newObject(Class<T> type, Object... args) {
        if (args == null || args.length == 0) {
            return newObject(type);
        }
        try {
            Class<?>[] argsClasses = new Class<?>[args.length];
            for (int i = 0; i < args.length; i++) {
                if (args[i] == null) {
                    argsClasses[i] = null;
                } else {
                    argsClasses[i] = args[i].getClass();
                }
            }
            Constructor<T> ctor = type.getDeclaredConstructor(argsClasses);
            return ctor.newInstance(args);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <E> List<E> toList(E... elements) {
        List<E> list = new ArrayList<E>();
        if (elements == null || elements.length == 0) {
            return list;
        }
        Collections.addAll(list, elements);
        return list;
    }

    public static <K, V> Map<K, V> toMap(List<V> list, IGetKey<K, V> keyMapper) {
        Map<K, V> resultMap = new HashMap<K, V>();
        if (list == null || list.size() == 0) {
            return resultMap;
        }
        for (V item : list) {
            resultMap.put(keyMapper.getKey(item), item);
        }
        return resultMap;
    }

    public static <K, V> Map<K, List<V>> toListMap(List<V> list, IGetKey<K, V> keyMapper) {
        Map<K, List<V>> resultMap = new HashMap<K, List<V>>();
        if (list == null || list.size() == 0) {
            return resultMap;
        }
        for (V item : list) {
            K key = keyMapper.getKey(item);
            if (resultMap.get(key) == null) {
                resultMap.put(key, new ArrayList<V>());
            }
            resultMap.get(key).add(item);
        }
        return resultMap;
    }
}
