// Exemple_URLImage.java
import java.applet.Applet ;
import java.net.URL ;
import java.net.MalformedURLException ;
import java.awt.Graphics ; 
import java.awt.Image ;
import java.awt.event.* ;
import java.awt.* ;
 
public class Exemple_URLImage extends Applet 
     implements ActionListener {
  private Image image = null ;
  private Button ok ;

  public void init() {
    setLayout(new BorderLayout());
    add(ok = new Button("Téléchargement"), 
        BorderLayout.SOUTH);
    ok.addActionListener(this) ;
  }

  public void paint(Graphics g) {
    if ( image != null ) 
      g.drawImage(image,0,0,this) ;
  }

  public void actionPerformed(ActionEvent e) {
    try { 
      URL url = new URL("http://127.0.0.1/fichiers/logo.jpg") ;
      image = getImage(url) ;
          repaint() ; 
        }
    catch (MalformedURLException mue) { }
    } 
  }