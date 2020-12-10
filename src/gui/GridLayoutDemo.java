package gui;

/**
 * Demo für den Layout-Manager GridLayout.
 *
 * Wenn Sie dieses Codebeispiel zum Laufen bringen wollen, beachten Sie, dass
 * Sie den Quelltext in einer Datei namens GridLayoutDemo.java speichern
 * (Achtung auf Groß-und Kleinschreibung) und dass sich die Datei in einem
 * Unterordner „gui“ unter Ihrem Projektordner befinden muss.
 *
 * Die meisten Swing-Formulare leiten javax.swing.JFrame ab.
 *
 * @author phaidros
 */
public class GridLayoutDemo extends javax.swing.JFrame {

    // Die Objektvariablen für die Elemente auf dem JFrame:

    // Auf dem JPanel wird alles angeordnet.
    // Es ist das Element, dem das Flow-Layout zugewiesen wird
    private javax.swing.JPanel jPanel1 = new javax.swing.JPanel();

    // Die sichtbaren Elemente werden als Objektvariablen angelegt:

    // Wir *könnten* hier 9 JButtons erzeugen, aber wir nützen die Gelegenheit,
    // um unser Interface etwas pfiffiger aufzubauen: statt jButton1-jButton9
    // erzeugen wir *ein* Array JButton[9].
    //
    // Anm.: Der graphische GUI-editor matisse könnte dieses Interface so
    // gar nicht erzeugen: er kann nicht mit Arrays aus Elementen umgehen!

    // Anm.: Achtung! Hier werden keineswegs, wie man annehmen könnte,
    // 9 Buttons erzeugt, sondern *ein* Array (das ja als "Array" ein
    // eigenständiges Objekt ist. Die Buttons, um es zu befüllen, müssen erst
    // erzeugt werden.
    private javax.swing.JButton[] jButton = new javax.swing.JButton[9];

    /**
     * Der Konstruktor.
     */
    public GridLayoutDemo() {

        // Was soll bei Klick auf das System-X rechts oben passieren:
        // Das Programm soll gänzlich beendet werden.
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        // Beachten Sie, dass Swing gar nicht so selten auf Elemente der
        // Vorgänger-Bibliothek 'awt' zugreift. Auch Das GridLayout
        // gehört eigentlich zum awt.
        // Das JPanel bekommt sein Layout, in diesem Fall ein 3x3-Grid:
        jPanel1.setLayout( new java.awt.GridLayout( 3, 3 ) );

        // Der Vollständigkeit halber erzeugen wir auch eine Listener-Methode
        // (nicht das eigentliche Thema des Codebeispiels)
        // Alle 9 Buttons des JButton-array werden ein und denselben Listener
        // aufrufen – und zwar diesen hier:
        ButtonListener bl = new ButtonListener();
        // Buttonlistener ist eine eigene, "innere" Klasse, siehe weiter unten.

        // Hier werden die JButtons erzeugt und dem Panel hinzugefügt
        // Bemerkenswert: die Reihenfolge bestimmt, wie die Buttons im 3x3-Grid
        // verteilt werden.
        for ( int i = 0; i<9; i++ ) {
            jButton[i] = new javax.swing.JButton ( "JButton" + (i+1) );
            jButton[i].addActionListener ( bl );
            jPanel1.add ( jButton[i] );
        }

        // Das Panel zum aktiven, sichtbaren Inhalt des JFrame machen:
        this.getContentPane().add ( jPanel1 ) ;

        // Alle Elemente auf kleinstmögliche Größe bringen
        pack();

        // Anm.: Durch das pack() sieht dieses Beispiel etwas anders aus, als
        // das, das Sie ev. mit matisse zusammengebeut haben, weil die Buttons
        // klein sind. Aber wenn Sie das Fenster skalieren werden Sie sehen,
        // dass wir hier genau dasselbe Design erzeugt haben
    }

    // Da Java haufenweise »Events« erzeugt (von denen uns die meisten
    // nicht interessieren), müssen wir einen »ActionListener« programmieren,
    // der auf *bestimmte* Ereignisse hört (die uns eben interessieren)
    // Auch das Interface ActionListener ist in awt definiert.
    class ButtonListener implements java.awt.event.ActionListener {
        public void actionPerformed(java.awt.event.ActionEvent e) {

            // Wenn dieser Code aufgerufen wird wissenw wir, dass ein Button
            // geklickt wurde – aber *welcher*? Hier können Sie sehen, dass es
            // Situationen gibt, wo Objekte mit '==' verglichen werden!
            // (Objektidentität wird gefragt, nicht (nur) inhaltliche Identität!)
            for (int i=0; i<9; i++) {
                if( e.getSource() == jButton[i] ){
                    System.out.println("JButton" + (i+1) + " wurde geklickt.");
                }
            }
        }
    }

    /**
     * Zeigt ein JFrame mit einem 3x3-Grid aus JButtons an.
     * Jedes Java-Programm beginnt bei einer Methode main() zu laufen, so auch
     * dieses. Beachten Sie, dass die Methode main() in jeder beliebigen
     * Klasse stehen könnte, die Zugriff auf GridLayoutDemo hat, also auch in
     * ihr selbst – also hier:
     */
    public static void main(String args[]) {
        // Ein Objekt der Klasse erzeugen und sichtbar machen.
        new GridLayoutDemo().setVisible ( true );
    }
}