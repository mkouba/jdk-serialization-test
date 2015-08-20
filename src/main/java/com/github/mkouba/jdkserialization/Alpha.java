package com.github.mkouba.jdkserialization;

import java.io.Serializable;

/**
 *
 * @author Martin Kouba
 *
 */
@SuppressWarnings("serial")
public class Alpha implements Serializable {

    private final Charlie charlie;

    public Alpha(Charlie charlie) {
        this.charlie = charlie;
    }

    Charlie getCharlie() {
        return charlie;
    }

}
