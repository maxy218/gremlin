package com.tinkerpop.gremlin.test.sideeffect;

import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.pipes.Pipe;
import junit.framework.TestCase;

import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class TreeStepTest extends TestCase {

    public void testCompliance() {
        assertTrue(true);
    }
    
    public void test_g_v1_out_out_treeXnameX_cap(final Pipe<Vertex, Map> pipe) {
        Map map = pipe.next();
        assertFalse(pipe.hasNext());
        assertEquals(map.size(),1);
        assertTrue(map.containsKey("marko"));
        assertEquals(((Map)map.get("marko")).size(), 1);
        assertTrue(((Map)map.get("marko")).containsKey("josh"));
        assertTrue(((Map)((Map)map.get("marko")).get("josh")).containsKey("lop"));
        assertTrue(((Map)((Map)map.get("marko")).get("josh")).containsKey("ripple"));
    }
}