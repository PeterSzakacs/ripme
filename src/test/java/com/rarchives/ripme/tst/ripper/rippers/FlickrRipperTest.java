package com.rarchives.ripme.tst.ripper.rippers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import com.rarchives.ripme.ripper.rippers.FlickrRipper;

public class FlickrRipperTest extends RippersTest {
    // https://github.com/RipMeApp/ripme/issues/243
    /*
    public void testFlickrAlbum() throws IOException {
        FlickrRipper ripper = new FlickrRipper(new URL("https://www.flickr.com/photos/leavingallbehind/sets/72157621895942720/"));
        testRipper(ripper);
    }
    */

    public void testGetGID() throws IOException {
        // specific album URL
        URL goodURL = new URL(
                "https://www.flickr.com/photos/leavingallbehind/albums/72157621895942720/page2"
        );
        FlickrRipper ripper = new FlickrRipper(goodURL);
        assertEquals(ripper.getGID(goodURL), "leavingallbehind_72157621895942720");
        // user homepage URL
        goodURL = new URL(
                "https://www.flickr.com/photos/leavingallbehind/"
        );
        assertEquals(ripper.getGID(goodURL), "leavingallbehind");
        // group URL
        goodURL = new URL(
                "https://www.flickr.com/groups/catchy/"
        );
        assertEquals(ripper.getGID(goodURL), "groups-catchy");
        URL badURL = new URL(
                "https://www.flickr.com/people/leavingallbehind/groups/"
        );
        try {
            String GID = ripper.getGID(badURL);
            fail("Ripper should throw exception, instead it returned: " + GID);
        } catch (MalformedURLException e){}
    }
}
