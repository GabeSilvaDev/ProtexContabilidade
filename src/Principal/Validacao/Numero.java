
package Principal.Validacao;

import java.awt.event.KeyEvent;


public class Numero {
    public static void justNumbers(KeyEvent evt){
        char vchar = evt.getKeyChar();
        if(!(Character.isDigit(vchar)
                || vchar == KeyEvent.VK_BACK_SPACE
                || vchar == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }
}
