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

public class HadithView extends JFrame{
	
	private JPanel contentPane;
	private JTextField NUM;
	private JTextField NAME;
	private JLabel lblNewLabel_2;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HadithView frame = new HadithView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

public HadithView() throws SQLException, ClassNotFoundException 
{
	IDAL iDAL = new HadithDAO();
	
	setTitle("Display Hadith");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 571, 580);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel search_by_number = new JLabel("Enter Hadith number");
	search_by_number.setBounds(43, 76, 120, 29);
	contentPane.add(search_by_number);
	
	NUM = new JTextField();
	NUM.setBounds(173, 76, 322, 29);
	contentPane.add(NUM);
	NUM.setColumns(10);
	
	JLabel search_by_name = new JLabel("Enter Book name");
	search_by_name.setBounds(43, 116, 120, 29);
	contentPane.add(search_by_name);
	
	NAME = new JTextField();
	NAME.setBounds(173, 116, 322, 29);
	contentPane.add(NAME);
	NAME.setColumns(10);
	
	JLabel lblNewLabel_1 = new JLabel("Search Hadith Data");
	lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblNewLabel_1.setBounds(207, 25, 166, 29);
	contentPane.add(lblNewLabel_1);
	
	lblNewLabel_2 = new JLabel("Hadith");
	lblNewLabel_2.setBounds(43, 187, 64, 29);
	contentPane.add(lblNewLabel_2);
	
	JLabel lblNewLabel_2_1 = new JLabel("Book");
	lblNewLabel_2_1.setBounds(43, 256, 91, 14);
	contentPane.add(lblNewLabel_2_1);
	
	JLabel lblNewLabel_2_2 = new JLabel("Hadith  Number");
	lblNewLabel_2_2.setBounds(43, 322, 120, 29);
	contentPane.add(lblNewLabel_2_2);
	
	JLabel lblNewLabel_2_3 = new JLabel("Matn");
	lblNewLabel_2_3.setBounds(43, 377, 78, 22);
	contentPane.add(lblNewLabel_2_3);
	
	JLabel lblNewLabel_2_4 = new JLabel("Sanad");
	lblNewLabel_2_4.setBounds(43, 438, 78, 22);
	contentPane.add(lblNewLabel_2_4);
	
	JLabel lblNewLabel_2_5 = new JLabel("Sanad Length");
	lblNewLabel_2_5.setBounds(43, 504, 78, 22);
	contentPane.add(lblNewLabel_2_5);
	
	
	textField_1 = new JTextField();
	textField_1.setColumns(10);
	textField_1.setBounds(173, 186, 322, 36);
	contentPane.add(textField_1);
	
	textField_2 = new JTextField();
	textField_2.setColumns(10);
	textField_2.setBounds(173, 248, 322, 36);
	contentPane.add(textField_2);
	
	textField_3 = new JTextField();
	textField_3.setColumns(10);
	textField_3.setBounds(173, 314, 322, 36);
	contentPane.add(textField_3);
	
	textField_4 = new JTextField();
	textField_4.setColumns(10);
	textField_4.setBounds(173, 373, 322, 36);
	contentPane.add(textField_4);
	
	textField_5 = new JTextField();
	textField_5.setColumns(10);
	textField_5.setBounds(173, 434, 322, 36);
	contentPane.add(textField_5);
	
	textField_6 = new JTextField();
	textField_6.setColumns(10);
	textField_6.setBounds(173, 494, 322, 36);
	contentPane.add(textField_6);
	
	JButton btnNewButton = new JButton("Search");
	btnNewButton.addActionListener(new ActionListener() 
	{
		public void actionPerformed(ActionEvent e) 
		{
			String num = NUM.getText();
			String book_name = NAME.getText();
			HadithTO H  = iDAL.SearchHadith(num, book_name);
//			System.out.println(H.getHadith);
//			System.out.print(book_name);
			try 
			{
					{
					textField_1.setText(H.getHadith());
					textField_2.setText(H.getBook());
					textField_3.setText(H.getNum_hadith());
					textField_4.setText(H.getMatn());
					textField_5.setText(H.getSanad());
					textField_6.setText(H.getSanad_length());
					}
			}
			catch(Exception e1) 
			{
				System.err.println("Exception: " + e1.getMessage());
			} 
		}
	});
	btnNewButton.setBounds(270, 154, 98, 29);
	contentPane.add(btnNewButton);
	
}
}