package pl;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import dal.HadithDAO;
import dal.IDAL;
import to.HadithTO;

public class FromNarattors extends JFrame
{
	
	private JPanel contentPane;
	private JTextField NUM_HADITH;
	private JTextField NAME;
	private JTextField SANAD;
	private JTextField BOOK;
	private JTextField textField;
	private String S;
	

	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					FromNarattors frame = new FromNarattors();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	public FromNarattors() throws SQLException, ClassNotFoundException 
	{
		IDAL iDAL = new HadithDAO();
		
		setTitle("From Narattors");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 571, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel_1 = new JLabel("Search From Narattors");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(207, 25, 166, 29);
		contentPane.add(lblNewLabel_1);
	
		JLabel search_by_book = new JLabel("Enter Book Name : ");
		search_by_book.setBounds(27, 98, 142, 29);
		contentPane.add(search_by_book);
		
		BOOK = new JTextField();
		BOOK.setBounds(179, 94, 322, 36);
		contentPane.add(BOOK);
		BOOK.setColumns(10);
		
		JLabel search_by_hadith = new JLabel("Enter Hadith No : ");
		search_by_hadith.setBounds(27, 176, 142, 29);
		contentPane.add(search_by_hadith);
		
		NUM_HADITH = new JTextField();
		NUM_HADITH.setBounds(179, 169, 322, 36);
		contentPane.add(NUM_HADITH);
		NUM_HADITH.setColumns(10);
		
		JLabel search_narattor_1 = new JLabel("Enter Narrator Name : ");
		search_narattor_1.setBounds(27, 259, 142, 29);
		contentPane.add(search_narattor_1);
	
		NAME = new JTextField();
		NAME.setBounds(179, 255, 322, 36);
		contentPane.add(NAME);
		NAME.setColumns(10);
		
		String name = NAME.getText();
		
		JButton btnNewButton = new JButton("Search From Narattors");
		btnNewButton.setBounds(226, 353, 176, 29);
		contentPane.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{

				String num_hadith = NUM_HADITH.getText();
				String book = BOOK.getText();
				String name = NAME.getText();
				S  = iDAL.GetSanad(num_hadith, book);
				
				System.out.println(S);
				
				String updatedString = iDAL.From_Narattor(S,name,book);
				System.out.println(updatedString);
				textField.setText(updatedString);
			}
		});
		
		JLabel search_narattor_2 = new JLabel("From Narattors : ");
		search_narattor_2.setBounds(27, 442, 142, 29);
		contentPane.add(search_narattor_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(179, 438, 322, 62);
		contentPane.add(textField);
		
		}
}