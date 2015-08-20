package com.github.mkouba.jdkserialization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 *
 * @author Martin Kouba
 */
public class Bravo implements Externalizable {

    private String id;

    public Bravo() {
    }

    public Bravo(String id) {
        this.id = id;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(id);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
       id = (String) in.readObject();
    }

    protected Object readResolve() {
        return new Charlie(id);
    }


}
