package pl;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import dal.HadithDAO;
import dal.IDAL;
import to.HadithTO;

public class UpdateHadith extends JFrame{
	
	private JPanel contentPane;
	private JTextField NUM;
	private JTextField NAME;
	private JTextField SANAD;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try 
				{
					UpdateHadith frame = new UpdateHadith();
					frame.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

public UpdateHadith() throws SQLException, ClassNotFoundException 
{
	IDAL iDAL = new HadithDAO();
	
	setTitle("Update Hadith");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 571, 580);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel lblNewLabel_1 = new JLabel("Update Hadith");
	lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblNewLabel_1.setBounds(218, 46, 166, 29);
	contentPane.add(lblNewLabel_1);
	
	JLabel search_by_number = new JLabel("Enter Hadith number");
	search_by_number.setBounds(43, 105, 120, 29);
	contentPane.add(search_by_number);
	
	NUM = new JTextField();
	NUM.setBounds(218, 105, 273, 29);
	contentPane.add(NUM);
	NUM.setColumns(10);
	
	JLabel search_by_name = new JLabel("Enter Book name");
	search_by_name.setBounds(43, 173, 120, 29);
	contentPane.add(search_by_name);
	
	NAME = new JTextField();
	NAME.setBounds(218, 173, 273, 29);
	contentPane.add(NAME);
	NAME.setColumns(10);
	
	
	JLabel search_by_name_1 = new JLabel("Enter Sanad lenght to update : ");
	search_by_name_1.setBounds(43, 239, 175, 29);
	contentPane.add(search_by_name_1);
	
	
	SANAD = new JTextField();
	SANAD.setColumns(10);
	SANAD.setBounds(218, 239, 273, 29);
	contentPane.add(SANAD);

	
	JButton btnNewButton = new JButton("Update Hadith");
	btnNewButton.setBounds(218, 317, 131, 29);
	contentPane.add(btnNewButton);

	btnNewButton.addActionListener(new ActionListener() 
	{
		public void actionPerformed(ActionEvent e) 
		{
			String num = NUM.getText();
			String book_name = NAME.getText();
			String sanad_length = SANAD.getText();
			
			iDAL.UpdateHadith(num, book_name,sanad_length);
			try
			{	
				JOptionPane.showMessageDialog(null,"Hadith Updated");
			}
			catch(Exception e1) 
			{
				JOptionPane.showMessageDialog(null,"Error!");
				e1.printStackTrace();
			} 
		}
	});
}
}