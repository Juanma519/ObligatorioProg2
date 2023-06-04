package uy.edu.um.adt.hash;

import uy.edu.um.adt.Hash.MyHash;
import uy.edu.um.adt.Hash.HashImpl;
import static org.junit.Assert.*;
import org.junit.Test;
import uy.edu.um.adt.LinkedList.MyList;

public class TestHash {
    @Test
public void testFlujoNormal() {

    MyHash<Integer, String> hash = new HashImpl<>(5);

    hash.put(1, "Daniel");
    hash.put(3, "Lola");
    hash.put(4, "Toby");
    hash.put(5, "Siny");

    assertEquals(4, hash.size());

    assertTrue(hash.contains(3));
    assertEquals("Lola", hash.get(3));
    hash.remove(3);

    assertEquals(3, hash.size());

    assertFalse(hash.contains(3));
    assertNull(hash.get(3));
    //LE FALTAN UN PAR DE TESTS;
}
}

