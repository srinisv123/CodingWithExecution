
import junit.framework.TestCase;

/**
 * @author ssingan on 7/23/15.
 */
public class DoesStringHaveUniqueCharactersTest extends TestCase {


    public void testIsStringUniqueWithHashSet() {
        DoesStringHaveUniqueCharacters doesStringHaveUniqueCharacters = new DoesStringHaveUniqueCharacters();

        assertEquals("Test unique characters", true, doesStringHaveUniqueCharacters.isStringUniqueWithHashSet("abcdef"));
    }

}
