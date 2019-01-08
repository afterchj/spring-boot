package svndemo.test.function;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by after on 2018/12/19.
 */


@Retention(value = RetentionPolicy.RUNTIME)
public @interface Annos {
    Anno[] value();
}
