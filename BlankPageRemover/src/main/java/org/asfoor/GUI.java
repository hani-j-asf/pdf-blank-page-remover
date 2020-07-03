package org.asfoor;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

public class GUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel title_label = new JLabel();
	private JLabel instructionLabel = new JLabel();
	private JButton fileButton = new JButton();
	private JLabel fileLabel = new JLabel();
	private JButton runButton = new JButton();
	private JLabel copyLabel = new JLabel();

	private File input;
	private FileChooser fc = new FileChooser();
	private ButtonController bc = new ButtonController();
	private LabelController lc = new LabelController();

	public GUI() {
		super();
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		int frameWidth = 420;
		int frameHeight = 300;
		setSize(frameWidth, frameHeight);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (d.width - getSize().width) / 2;
		int y = (d.height - getSize().height) / 2;
		setLocation(x, y);
		setTitle("PDF Blank Page Remover");
		setResizable(false);
		Container cp = getContentPane();
		cp.setLayout(null);

		cp.setBackground(Color.WHITE);
		title_label.setBounds(0, 0, 400, 39);
		title_label.setText("PDF Blank Page Remover");
		title_label.setHorizontalTextPosition(SwingConstants.CENTER);
		title_label.setHorizontalAlignment(SwingConstants.CENTER);
		title_label.setFont(new Font("Arial", Font.PLAIN, 24));
		cp.add(title_label);
		instructionLabel.setBounds(0, 50, 400, 20);
		instructionLabel.setText("Klicke auf den Button um eine PDF-Datei auszuwählen");
		instructionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cp.add(instructionLabel);
		fileButton.setBounds(150, 85, 100, 25);
		fileButton.setText("Datei suchen");
		fileButton.setMargin(new Insets(2, 2, 2, 2));
		fileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				File inputFile = fc.chooseFile();
				if (inputValidater.validateInput(inputFile)) {
					input = inputFile;
					lc.setPath(fileLabel, input);
				} else {
					lc.setInvalid(fileLabel);
				}
			}
		});
		cp.add(fileButton);
		fileLabel.setBounds(0, 133, 400, 20);
		fileLabel.setText("");
		fileLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cp.add(fileLabel);
		runButton.setBounds(140, 173, 120, 25);
		runButton.setText("Datei bearbeiten");
		runButton.setMargin(new Insets(2, 2, 2, 2));
		runButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					bc.runButton_ActionPerformed(evt, input);
					if (bc.runButton_ActionPerformed(evt, input)) {
						lc.setRemoved(fileLabel);
					} else {
						lc.setNoBlanks(fileLabel);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		cp.add(runButton);
		copyLabel.setBounds(0, 235, 400, 20);
		copyLabel.setText("(C) Hani Asfoor 2020");
		copyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cp.add(copyLabel);
		setVisible(true);
	}
}