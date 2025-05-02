package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import model.Note;
import javax.swing.JTextField;
import java.awt.BorderLayout;

public class NoteFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Note note;
	private JTextField txtAsdasd;

	/**
	 * Launch the application.
	 */
	public NoteFrame(Note note) {
		this.note = note;
		initComponents();
	}
	
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle(note.getTitle());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		txtAsdasd = new JTextField();
		txtAsdasd.setText(note.getNote());
		contentPane.add(txtAsdasd);
		txtAsdasd.setColumns(10);
	}
	public void OpenNote() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NoteFrame frame = new NoteFrame(note);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
