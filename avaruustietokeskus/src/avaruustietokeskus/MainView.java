package avaruustietokeskus;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainView extends JFrame{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String planeetat[]={"Kuu","Mars","Jupiter","Saturnus"};
	
	private static final JLabel nimi = new JLabel();
	private static final JLabel teksti2 = new JLabel();
	private static final JLabel teksti3 = new JLabel();
	
	private static JComboBox<Object> combobox;
	private static JTextField teksti;
	private static JButton button, laskuriButton, tietokanButton;
	private static JPanel paneeli, paneeli2, paneeli4, sivuNapit, tietoKanPanel, cardPanel;
	
    final static String data[][]={ {"1","Kuu","Aurinkokunta"},    
            {"2","Mars","Aurinkokunta"},    
            {"3","Jupiter","Aurinkokunta"},
            {"4","Saturnus","Aurinkokunta"}
	};
    
    static String column[]={"ID","Nimi","Sijainti"};
	String aika;
	BorderLayout blayout;
	JFrame frame;
	 
	
	final static String LASKURIPANEL = "Card with JButtons";
	final static String TIETOKANTAPANEL = "Card with JTextField";
	
	MainView() {
		
		sidePanel();
		upperPanel();
	    cardPanel();
	    
	    blayout = new BorderLayout();
	    
		frame = new JFrame("Avaruustietokeskus");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(650,480);
		frame.setLayout(blayout);
		frame.setVisible(true);
		
		frame.add(paneeli, BorderLayout.WEST);
        frame.add(paneeli2, BorderLayout.NORTH);
        frame.add(cardPanel, BorderLayout.CENTER);
		
		
	    button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            	int tunnit = Integer.parseInt(teksti.getText());
            	int aika = 0;
            	
            	if (combobox.getSelectedIndex() == 0 ) 
            	{
            		aika = 384400 / tunnit;           		
            	}
                else if (combobox.getSelectedIndex() == 1 ) 
                {
                    aika = 253000000 / tunnit;                  
                }
                else if (combobox.getSelectedIndex() == 2 ) 
                {
                    aika = 780000000 / tunnit;                                  
                }    
                else if (combobox.getSelectedIndex() == 3 ) 
                {
                    aika = 1200000000 / tunnit;                   
                }
            	
            	convertHours(aika);	
            }
            	
	    });

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    new MainView();
	}
	
	private static void convertHours(int aika) {
	
		int vuodet, kuukaudet, paivat;
		
		vuodet = aika / 8760;
		aika = aika % 8760;
		
		kuukaudet = aika / 720;
		aika = aika % 720;
		
		paivat = aika / 24;
		aika = aika % 24;
		
		JOptionPane.showMessageDialog(null, "Olet perillä arviolta " + vuodet + " vuoden, " + kuukaudet + " kuukauden ja " + paivat + " päivän kuluttua");
		
}

	
	private static void centerPanel() {

		paneeli4 = new JPanel();
		paneeli4.setLayout(new BoxLayout(paneeli4, BoxLayout.Y_AXIS));
		paneeli4.setBackground(Color.darkGray);
		
		
		teksti = new JTextField();
		combobox = new JComboBox<Object>(planeetat);
		button = new JButton("Laske");
		teksti2.setText("Valitse kohde:");
		teksti2.setForeground(Color.white);
		teksti3.setText("Kerro nopeutesi (km/h):");
		teksti3.setForeground(Color.white);
		
		teksti.setMaximumSize(new Dimension(200, 30));
	  	combobox.setMaximumSize(new Dimension(200, 30));
		
        paneeli4.add(Box.createRigidArea(new Dimension(5,20)));
        paneeli4.add(teksti2);
        paneeli4.add(combobox);
	    paneeli4.add(Box.createRigidArea(new Dimension(5, 20)));
	    paneeli4.add(teksti3);
		paneeli4.add(teksti);
        paneeli4.add(Box.createRigidArea(new Dimension(5, 40)));
	    paneeli4.add(button);

	    combobox.setAlignmentX(Component.LEFT_ALIGNMENT);
	    teksti.setAlignmentX(Component.LEFT_ALIGNMENT);
	    button.setAlignmentX(Component.LEFT_ALIGNMENT);
	}	
	
	
	private static void sidePanel() {

		paneeli = new JPanel();
		paneeli.setBackground(Color.LIGHT_GRAY);
		paneeli.setPreferredSize(new Dimension(150, 100));
		paneeli.setLayout(new BoxLayout(paneeli, BoxLayout.PAGE_AXIS ));
		sidePanelButtons();
		
	}	
	
	private static void upperPanel() {
		
        nimi.setText("Avaruustietokeskus");
        nimi.setForeground(Color.white);
		paneeli2 = new JPanel();
		paneeli2.setBackground(Color.BLACK);
		paneeli2.setPreferredSize(new Dimension(100,100));
		paneeli2.setLayout(new BoxLayout(paneeli2, BoxLayout.PAGE_AXIS));
		paneeli2.add(Box.createRigidArea(new Dimension(5, 40)));
		paneeli2.add(nimi); 
		
	}	
	
	private static void sidePanelButtons() {
		
		laskuriButton = new JButton("Matkalaskuri");
		tietokanButton = new JButton("Planeetta-tietokanta");
		sivuNapit = new JPanel();
		
		sivuNapit.setLayout(new BoxLayout(sivuNapit, BoxLayout.PAGE_AXIS));
		sivuNapit.setBackground(Color.LIGHT_GRAY);
		sivuNapit.add(Box.createRigidArea(new Dimension(5, 20)));
		sivuNapit.add(laskuriButton);
		sivuNapit.add(Box.createRigidArea(new Dimension(5, 20)));
		sivuNapit.add(tietokanButton);
		
		paneeli.add(sivuNapit);
		
		laskuriButton.addActionListener( new ActionListener()
		{
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
		    	CardLayout cl = (CardLayout)(cardPanel.getLayout());
				cl.show(cardPanel, LASKURIPANEL);
		    }
		});
		
		
		tietokanButton.addActionListener( new ActionListener()
		{
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
		    	CardLayout cl = (CardLayout)(cardPanel.getLayout());
				cl.show(cardPanel, TIETOKANTAPANEL);
		    }
		});
		
		
		
	}	
	
	private static void TietokantaPanel() {
		
		tietoKanPanel = new JPanel();
	    tietoKanPanel.setLayout(new BoxLayout(tietoKanPanel, BoxLayout.Y_AXIS));
	    tietoKanPanel.setBackground(Color.darkGray);
		
	    JTable planlista= new JTable(data, column); 
	    planlista.setPreferredSize(new Dimension(40,40));
	    planlista.setAlignmentX(Component.LEFT_ALIGNMENT);
	    
	    planlista.getColumnModel().getColumn(0).setMaxWidth(50);
	    planlista.getColumnModel().getColumn(1).setMaxWidth(100);
	    planlista.getColumnModel().getColumn(2).setMaxWidth(100);
//	   
	    tietoKanPanel.add(Box.createRigidArea(new Dimension(25, 100)));
	    tietoKanPanel.add(planlista);
	    
	}	
	
	private static void cardPanel() {
		
		centerPanel();
		TietokantaPanel();
	
		cardPanel = new JPanel(new CardLayout());
		cardPanel.add(paneeli4, LASKURIPANEL);
		cardPanel.add(tietoKanPanel, TIETOKANTAPANEL);
		
	}
	
	
}
