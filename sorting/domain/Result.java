package sorting.domain;

import java.io.Serializable;

public interface Result extends Serializable {
    /**
     * get a result summary to display.
     * @return result summary as a string.
     */
    String getResult();
}
