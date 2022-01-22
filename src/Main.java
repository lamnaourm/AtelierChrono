import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private JPanel contentPane;
	JLabel label;
	Timer timer;
	int s=0,m=0,h=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setTitle("Chrono");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 431, 154);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label = new JLabel("00:00:00");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBorder(new LineBorder(new Color(0, 0, 0)));
		label.setFont(new Font("Tahoma", Font.PLAIN, 60));
		label.setBounds(10, 7, 260, 82);
		contentPane.add(label);
		
		timer = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				s++;
				
				if(s>59) {
					s=0;
					m++;
				}
				if(m>59) {
					m=0;
					h++;
				}
				label.setText(String.format("%02d:%02d:%02d", h,m,s));
			}
		});
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				timer.start();
			}
		});
		btnStart.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnStart.setBounds(290, 7, 115, 23);
		contentPane.add(btnStart);
		
		JButton btnPause = new JButton("Pause");
		btnPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				timer.stop();
			}
		});
		btnPause.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnPause.setBounds(290, 41, 115, 23);
		contentPane.add(btnPause);
		
		JButton btnFermer = new JButton("Reset");
		btnFermer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s=m=h=0;
				timer.stop();
				label.setText(String.format("%02d:%02d:%02d", h,m,s));
			}
		});
		btnFermer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnFermer.setBounds(290, 75, 115, 23);
		contentPane.add(btnFermer);
	}
}
