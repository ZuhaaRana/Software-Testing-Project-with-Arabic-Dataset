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

public class NLevelNarattor extends JFrame
{
	
	private JPanel contentPane;
	private JTextField NUM_HADITH;
	private JTextField NAME;
	private JTextField SANAD;
	private JTextField BOOK;
	String S;
	
	private JLabel lblNewLabel_2;
	private JTextField NarattorLevel;

	
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					NLevelNarattor frame = new NLevelNarattor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public NLevelNarattor() throws SQLException, ClassNotFoundException 
	{
		IDAL iDAL = new HadithDAO();
		
		setTitle("N Level Narattor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 571, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel_1 = new JLabel("N Level Narattor");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(207, 25, 166, 29);
		contentPane.add(lblNewLabel_1);
	
		JLabel search_by_book = new JLabel("Enter Book Name : ");
		search_by_book.setBounds(27, 76, 142, 29);
		contentPane.add(search_by_book);
		
		BOOK = new JTextField();
		BOOK.setBounds(179, 72, 322, 36);
		contentPane.add(BOOK);
		BOOK.setColumns(10);
		
		JLabel search_by_hadith = new JLabel("Enter Hadith No : ");
		search_by_hadith.setBounds(27, 159, 142, 29);
		contentPane.add(search_by_hadith);
		
		NUM_HADITH = new JTextField();
		NUM_HADITH.setBounds(179, 155, 322, 36);
		contentPane.add(NUM_HADITH);
		NUM_HADITH.setColumns(10);
		
		JLabel search_narattor_1 = new JLabel("Enter Narrator Name : ");
		search_narattor_1.setBounds(27, 241, 142, 29);
		contentPane.add(search_narattor_1);
	
		NAME = new JTextField();
		NAME.setBounds(179, 237, 322, 36);
		contentPane.add(NAME);
		NAME.setColumns(10);
		
		
//		JLabel SAN = new JLabel("Sanad : ");
//		SAN.setBounds(27, 401, 142, 29);
//		contentPane.add(SAN);
//	
//		SANAD = new JTextField();
//		SANAD.setBounds(179, 377, 322, 53);
//		contentPane.add(SANAD);
//		SANAD.setColumns(10);
		
		String name = NAME.getText();
		
		JButton btnNewButton_1 = new JButton("Search Level");
		btnNewButton_1.setBounds(255, 350, 138, 29);
		contentPane.add(btnNewButton_1);
		

		JLabel search_narattor_2 = new JLabel("Narattor Level : ");
		search_narattor_2.setBounds(27, 459, 142, 29);
		contentPane.add(search_narattor_2);
		
		NarattorLevel = new JTextField();
		NarattorLevel.setColumns(10);
		NarattorLevel.setBounds(179, 455, 322, 36);
		contentPane.add(NarattorLevel);
	
		
		btnNewButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{

				String num_hadith = NUM_HADITH.getText();
				String book = BOOK.getText();
				String name = NAME.getText();
				
				S  = iDAL.GetSanad(num_hadith, book);
				
				System.out.println(S);
	//			System.out.print(num_hadith);
//				try 
//				{
//						{
//							SANAD.setText(S);
//						}
//				}
//				catch(Exception e1) 
//				{
//					System.err.println("Exception: " + e1.getMessage());
//				} 
				String level = iDAL.LEVEL(name, S);
				 
				NarattorLevel.setText(level);
			}
		});
		
		}
}