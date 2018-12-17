package com.rarchives.ripme.tst.ripper.rippers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import com.rarchives.ripme.ripper.rippers.JabArchivesRipper;

public class JabArchivesRipperTest extends RippersTest {
    // TODO add a test

    public void testGetGID() throws IOException {
        URL goodURL = new URL(
                "http://jabarchives.com/main/view/noznorohc_CowboyBebop"
        );
        JabArchivesRipper ripper = new JabArchivesRipper(goodURL);
        assertEquals(ripper.getGID(goodURL), "noznorohc_CowboyBebop");
        URL badURL = new URL(
                "http://jabarchives.com/main/gallery/noznorohc"
        );
        try {
            String GID = ripper.getGID(badURL);
            fail("Ripper should throw exception, instead it returned: " + GID);
        } catch (MalformedURLException e){}
    }
}