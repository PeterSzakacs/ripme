package com.rarchives.ripme.tst.ripper.rippers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import com.rarchives.ripme.ripper.rippers.DribbbleRipper;

public class DribbbleRipperTest extends RippersTest {
    public void testDribbbleRip() throws IOException {
        DribbbleRipper ripper = new DribbbleRipper(new URL("https://dribbble.com/typogriff"));
        testRipper(ripper);
    }

    public void testGetGID() throws IOException {
        URL goodURL = new URL("https://dribbble.com/typogriff");
        DribbbleRipper ripper = new DribbbleRipper(goodURL);
        assertEquals(ripper.getGID(goodURL), "typogriff");
        URL badURL = new URL(
                "https://cdn.dribbble.com/users/327319/screenshots/5662137/sb100_dribbble-01_teaser.png"
        );
        try {
            String GID = ripper.getGID(badURL);
            fail("Ripper should throw exception, instead it returned: " + GID);
        } catch (MalformedURLException e){}
    }
}
