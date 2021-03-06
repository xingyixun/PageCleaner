package cc.openhome;

import java.io.IOException;
import static java.nio.file.Paths.get;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class ArgsTest {
    @Test
    public void testConstructorWith2Args() {
        String arg1 = "UTF-8";
        String arg2 = "src";
        Args args = new Args(new String[] {arg1, arg2});
        
        assertEquals(args.charsetName, arg1);
        assertEquals(args.src, get(arg2));
        assertEquals(args.dest, get(arg2));
    }
    
    @Test
    public void testConstructorWith3Args() {
        String arg1 = "UTF-8";
        String arg2 = "src";
        String arg3 = "dest";
        Args args = new Args(new String[] {arg1, arg2, arg3});
        
        assertEquals(args.charsetName, arg1);
        assertEquals(args.src, get(arg2));
        assertEquals(args.dest, get(arg3));
    }
    
    @Test
    public void testIsSrcRegularFile() {   
        Args args = new Args(new String[] {"UTF-8", 
            "fixtures/expected/Blog/index.html"});
        assertTrue(args.isSrcRegularFile());
    }
    
    @Test
    public void testIsSrcDirectory() {   
        Args args = new Args(new String[] {"UTF-8", 
            "fixtures/expected/Blog"});
        assertTrue(args.isSrcDirectory());
    }
    
    @Test
    public void testHasDiffSrcDir() throws IOException {   
        Args args = new Args(new String[] {"UTF-8", 
            "fixtures/expected/Blog", "fixtures/expected/Blog2"});
        assertTrue(args.hasDiffSrcDest());
    }
}
