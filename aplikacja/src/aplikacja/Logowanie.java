package aplikacja;
 
import java.awt.*;
import java.awt.event.*;
 
import javax.swing.*;
 
@SuppressWarnings("serial")
public class Logowanie extends JFrame {
 
   public Logowanie() {
 
        setTitle("MyStats - Ekran logowania");
        setSize(400,300);
        setResizable(false);
        setLocationRelativeTo(null);
        initComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
  }
 
           JPanel panel = new JPanel();
 
    public void initComponents()
    {
 
          JButton  PrzyciskZamknij = new JButton ("Zamknij");
          JButton  PrzyciskOK = new JButton ("OK");
          JLabel  Login= new JLabel("Login: ");
          JLabel  Haslo = new JLabel("Hasło: ");
          JTextField LoginUzytkownika = new JTextField(6);
          JPasswordField HasloUzytkownika = new JPasswordField(6);
          PrzyciskZamknij.setSize(90, 30);
          PrzyciskOK.setSize(90, 30);
          Login.setSize(100,30);
          Haslo.setSize(100,30);
          LoginUzytkownika.setSize(100,30);
          HasloUzytkownika.setSize(100,30);
          PrzyciskZamknij.setLocation(getWidth()-190,getHeight()-100);
          PrzyciskOK.setLocation(getWidth()-310,getHeight()-100);
          Login.setLocation(getWidth()-300,getHeight()-220);
          Haslo.setLocation(getWidth()-300,getHeight()-180);
          LoginUzytkownika.setLocation(getWidth()-250,getHeight()-220);
          HasloUzytkownika.setLocation(getWidth()-250,getHeight()-180);
          panel.setLayout(null);
          panel.add(PrzyciskZamknij);
          panel.add(PrzyciskOK);
          panel.add(Login);
          panel.add(Haslo);
          panel.add(LoginUzytkownika);
          panel.add(HasloUzytkownika);
          PrzyciskZamknij.setToolTipText("Zamknij Program.");
          PrzyciskOK.setToolTipText("Zaloguj się.");
          LoginUzytkownika.setToolTipText("Podaj swój login.");
          HasloUzytkownika.setToolTipText("Podaj swoje hasło.");
          this.getContentPane().add(panel);
          PrzyciskZamknij.addActionListener(new ButtonZamknij());
          PrzyciskOK.addActionListener(new ActionListener() {
 
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = LoginUzytkownika.getText();
                String pass = HasloUzytkownika.getText();
                if(user.equals("admin") && pass.equals("admin")) {
                    System.out.print("zalogowano");
                }
                else {
                    System.out.print("blad");
                }
 
            }
 
          });
 
    }

    private static class LoginUzytkownika {

        private static String getText() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public LoginUzytkownika() {
        }
    }

    private static class HasloUzytkownika {

        private static String getText() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public HasloUzytkownika() {
        }
    }
 
     //akcja przy przycisku zamknij   
    private class ButtonZamknij implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            System.exit(0);
        }
    }
 
    //akcja przy przycisku ok
    private class ButtonOK implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
 
            String user = LoginUzytkownika.getText();
            String pass = HasloUzytkownika.getText();
            if(user.equals("admin") && pass.equals("admin")) {
                System.out.print("zalogowano");
            }
            else {
                System.out.print("blad");
            }
 
        }
    }
 
    public static void main(String[] args) {
 
       EventQueue.invokeLater(new Runnable() {
         public void run() {
             Logowanie EkranLogowania = new Logowanie();
            EkranLogowania.setVisible(true);
            Toolkit t = Toolkit.getDefaultToolkit();
            Dimension d = t.getScreenSize();
            EkranLogowania.setLocation((d.width/4), (d.height/4));
 
            // EkranLogowania.setBounds(d.width/4, d.height/4,500 ,300);
         } 
        });
    }
}