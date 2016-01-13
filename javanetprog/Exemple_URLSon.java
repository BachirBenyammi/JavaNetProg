// Exemple_URLSon.java
import java.net.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Exemple_URLSon extends Applet 
 implements ActionListener {

 AudioClip ding;
 AudioClip oiseau;
 Button btnDing=new Button("DING");
 Button btnOiseau=new Button("DEPART");
 boolean enMarche=false;
 
 public void init() {
 try { 
  URL urlDing = new URL("http://127.0.0.1/fichiers/ding.au") ;
  URL urlOiseau = new URL("http://127.0.0.1/fichiers/oiseau.au") ;
  ding=getAudioClip(urlDing);
  oiseau=getAudioClip(urlOiseau);
  add(btnDing);
  btnDing.addActionListener(this);
  add(btnOiseau);
  btnOiseau.addActionListener(this);
 }
    catch (MalformedURLException excep) { } 
}

 public void actionPerformed(ActionEvent e) {
  if (e.getSource()==btnDing) ding.play();
  else if (e.getSource()==btnOiseau) {
   if (enMarche) {
    oiseau.stop();
    btnOiseau.setLabel("DEPART");
    enMarche=false;
   }
   else {
    oiseau.loop();
    btnOiseau.setLabel("STOP");
    enMarche=true;
   }
  }
 } 
 
 public void stop() {
  if (enMarche) oiseau.stop();
 }
}
