package com.github.mkouba.jdkserialization;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

public class ExternalizableReadResolveTest {

    @Test
    public void testReadResolve() throws ClassNotFoundException, IOException {
        Alpha thereAndBackAgain = deserialize(serialize(new Alpha(new Charlie("foo"))));
        assertEquals("foo", thereAndBackAgain.getCharlie().getId());
    }

    public static byte[] serialize(Object instance) throws IOException {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bytes);
        out.writeObject(instance);
        return bytes.toByteArray();
    }

    @SuppressWarnings("unchecked")
    public static <T> T deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bytes));
        return (T) in.readObject();
    }

}
