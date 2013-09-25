package de.eppleton.fx2d.resourcetest;

import de.eppleton.fx2d.event.KeyCode;
import de.eppleton.fx2d.event.KeyEvent;
import de.eppleton.fx2d.samples.pong.Pong;
import org.apidesign.bck2brwsr.htmlpage.api.On;
import org.apidesign.bck2brwsr.htmlpage.api.OnEvent;
import org.apidesign.bck2brwsr.htmlpage.api.Page;

@Page(xhtml = "index.html", className = "Index")
public final class Main {

    private static Pong rpg;

    private Main() {
    }

    /**
     * Called when the page is ready.
     */
    static {
        Index model = new Index();
        net.java.html.canvas.GraphicsContext gc = model.canvas.getContext();
        rpg = new Pong(gc, 800   , 600, 800, 600);
        rpg.start();
    }
    
        @On(event = OnEvent.KEY_DOWN, id = "canvas")
    static void keyPress(final Index m, int keyCode) {
        KeyCode keyCode1 = KeyCode.getKeyCode(keyCode);
        rpg.dispatchEvent(new KeyEvent(rpg, KeyEvent.KEY_PRESSED, keyCode1));
    }

    @On(event = OnEvent.KEY_UP, id = "canvas")
    static void keyRealeased(final Index m, int keyCode) {
        KeyCode keyCode1 = KeyCode.getKeyCode(keyCode);
        rpg.dispatchEvent(new KeyEvent(rpg, KeyEvent.KEY_RELEASED, keyCode1));
    }
}
