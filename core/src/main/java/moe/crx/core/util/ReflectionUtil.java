package moe.crx.core.util;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReflectionUtil {

    public static final class Null {
        private static final Null INSTANCE = new Null();

        private Null() {}

        @Override
        public String toString() {
            return "null";
        }

        @Override
        public boolean equals(Object o) {
            return o == null || o instanceof Null;
        }

        @Override
        public int hashCode() {
            return 0;
        }

        @Override
        protected Object clone() {
            return INSTANCE;
        }
    }

    public static @NotNull Map<String, Object> getAllFields(@NotNull Object object) {
        return Stream.of(object.getClass().getDeclaredFields()).collect(Collectors.toMap(Field::getName, field -> {
            try {
                field.setAccessible(true);

                var clazz = field.getType();

                if (!clazz.isPrimitive()) {
                    Object value = field.get(object);

                    return Objects.requireNonNullElse(value, Null.INSTANCE);
                }

                if (clazz.equals(Boolean.TYPE)) {
                    return field.getBoolean(object);
                }
                if (clazz.equals(Character.TYPE)) {
                    return field.getChar(object);
                }
                if (clazz.equals(Byte.TYPE)) {
                    return field.getByte(object);
                }
                if (clazz.equals(Short.TYPE)) {
                    return field.getShort(object);
                }
                if (clazz.equals(Integer.TYPE)) {
                    return field.getInt(object);
                }
                if (clazz.equals(Long.TYPE)) {
                    return field.getLong(object);
                }
                if (clazz.equals(Float.TYPE)) {
                    return field.getFloat(object);
                }
                if (clazz.equals(Double.TYPE)) {
                    return field.getDouble(object);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return Null.INSTANCE;
        }));
    }

    public static @NotNull String getClassName(@Nullable Object object) {
        if (object == null) {
            return "";
        }

        return object.getClass().getSimpleName();
    }
}
