package com.github.mkouba.jdkserialization;

import java.io.Serializable;

/**
 *
 * @author Martin Kouba
 */
@SuppressWarnings("serial")
public class Charlie implements Serializable {

    private final String id;

    public Charlie(String id) {
        this.id = id;
    }

    String getId() {
        return id;
    }

    protected Object writeReplace() {
        return new Bravo(id);
    }

}
