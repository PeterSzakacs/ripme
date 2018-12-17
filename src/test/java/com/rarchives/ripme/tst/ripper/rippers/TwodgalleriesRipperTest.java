package com.rarchives.ripme.tst.ripper.rippers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import com.rarchives.ripme.ripper.rippers.TwodgalleriesRipper;

public class TwodgalleriesRipperTest extends RippersTest {
    // https://github.com/RipMeApp/ripme/issues/182
    /*
    public void testTwodgalleriesRip() throws IOException {
        TwodgalleriesRipper ripper = new TwodgalleriesRipper(new URL("http://www.2dgalleries.com/artist/regis-loisel-6477"));
        testRipper(ripper);
    }
    */

    public void testGetGID() throws IOException {
        URL goodURL = new URL(
                "http://www.2dgalleries.com/artist/regis-loisel-6477"
        );
        TwodgalleriesRipper ripper = new TwodgalleriesRipper(goodURL);
        assertEquals(ripper.getGID(goodURL), "regis-loisel-6477");
        URL badURL = new URL(
                "https://www.2dgalleries.com/art/quete-de-l-oiseau-du-temps-t4-p18-96047"
        );
        try {
            String GID = ripper.getGID(badURL);
            fail("Ripper should throw exception, instead it returned: " + GID);
        } catch (MalformedURLException e){}
    }
}

