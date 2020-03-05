package main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

public class DFS extends JPanel{

	private JFrame frmAi;
	private JTextField txtNr;
	private JTextField textField;
	public static int N;
	
public void paint(Graphics g){
	
	
		int xs = (int) (600 / (double)N);
	
        
        g.fillRect(100, 100, N*50, N*50);
        for(int i = 100; i <= N*50; i+=100){
            for(int j = 100; j <= N*50; j+=100){
                g.clearRect(i, j, 50, 50);
            }
        }
        
        for(int i = 150; i <= N*75; i+=100){
            for(int j = 150; j <= N*75; j+=100){
                g.clearRect(i, j, 50, 50);
            }
        }
}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DFS window = new DFS();
					window.frmAi.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DFS() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAi = new JFrame();
		frmAi.setTitle("Artificial Intelligence");
		frmAi.setBounds(100, 100, 766, 704);
		frmAi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAi.getContentPane().setLayout(null);
		
		txtNr = new JTextField();
		txtNr.setBounds(300, 11, 158, 20);
		frmAi.getContentPane().add(txtNr);
		txtNr.setColumns(10);
		
		JLabel lblQueenNr = new JLabel("Queen Nr.");
		lblQueenNr.setBounds(232, 14, 58, 14);
		frmAi.getContentPane().add(lblQueenNr);
		
		JLabel lblBlockField = new JLabel("Block field:");
		lblBlockField.setBounds(232, 39, 71, 14);
		frmAi.getContentPane().add(lblBlockField);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(300, 36, 158, 20);
		frmAi.getContentPane().add(textField);
		JButton btnStart = new JButton("Start");		
		btnStart.setBounds(300, 67, 89, 23);
		frmAi.getContentPane().add(btnStart);
		
		JTextPane lblSolution = new JTextPane();
		lblSolution.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSolution.setBounds(232, 137, 320, 517);
		frmAi.getContentPane().add(lblSolution);
		
		
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					if(!txtNr.getText().isEmpty() && !textField.getText().isEmpty())
					{
						N = Integer.parseInt(txtNr.getText());
						Board board = new Board(N);
						String[] blockField = textField.getText().split(",");
						int row = Integer.parseInt(blockField[0]);
						int column = Integer.parseInt(blockField[1]);
						board.column = column;
						board.row = row;
						Board res = board.DFS(board);
												
						
						if (res != null)
						{
			
//							JFrame frame = new JFrame();
//					        frame.setSize(600,600);
//					        frame.getContentPane().add(new DFS());
//					        frame.setLocationRelativeTo(null);
//					        frame.setBackground(Color.LIGHT_GRAY);
//					        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
//					        frame.addWindowListener(new WindowAdapter() {
//					            public void windowClosing(WindowEvent ev) {
//					                frame.dispose();
//					            }
//					        });
//					        frame.setVisible(true);
					        lblSolution.setText(board.printSolution());
					        		
						
						}
						else
						{
							JOptionPane.showMessageDialog(null, "No Result");
						}
						
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Invalid inputs");
					}
				}
				
				catch (Exception eMsg) {
					System.out.println(eMsg.getMessage());
				}
			}
		});
		
	}
}
