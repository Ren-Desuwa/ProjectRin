package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import data_access_objects.DataAccessObjectManager;

public class Main_Menu extends JWindow {

    private static final long serialVersionUID = 1L;
    private DataAccessObjectManager daoManager;
    private JTextArea notesArea;
    private JPanel controlPanel;
    private boolean isVisible = true;
    
    // Keyboard shortcut: Ctrl+Shift+` (backtick/tilde key)
    private final KeyStroke TOGGLE_SHORTCUT = KeyStroke.getKeyStroke(KeyEvent.VK_BACK_QUOTE, 
            InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK);
    
    public static void launch(DataAccessObjectManager daoManager) {
        EventQueue.invokeLater(() -> {
            new Main_Menu(daoManager);
        });
    }
    
    private Main_Menu(DataAccessObjectManager daoManager) {
        this.daoManager = daoManager;
        initComponents();
        setupGlobalKeyListener();
        setVisible(true);
    }

    private void initComponents() {
        // Make the window cover the entire screen
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Rectangle screenBounds = ge.getMaximumWindowBounds();
        setBounds(screenBounds);
        
        // Set up semi-transparent background
        setBackground(new Color(0, 0, 0, 50)); // Black with 50/255 alpha
        
        // Main container with border layout
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setOpaque(false);
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        
        // Control panel at the top
        controlPanel = createControlPanel();
        mainPanel.add(controlPanel, BorderLayout.NORTH);
        
        // Notes area in the center
        notesArea = createNotesArea();
        JScrollPane scrollPane = new JScrollPane(notesArea);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setPreferredSize(new Dimension(400, 300));
        
        // Center the notes area
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setOpaque(false);
        centerPanel.add(scrollPane);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        
        // Instructions panel at the bottom
        JPanel instructionsPanel = createInstructionsPanel();
        mainPanel.add(instructionsPanel, BorderLayout.SOUTH);
        
        add(mainPanel);
    }
    
    private JPanel createControlPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panel.setOpaque(false);
        
        // New Note button
        JButton newNoteBtn = createStyledButton("New Note");
        newNoteBtn.addActionListener(e -> clearNotes());
        
        // Save Note button
        JButton saveNoteBtn = createStyledButton("Save Note");
        saveNoteBtn.addActionListener(e -> saveNote());
        
        // Load Note button
        JButton loadNoteBtn = createStyledButton("Load Note");
        loadNoteBtn.addActionListener(e -> loadNote());
        
        // Hide button
        JButton hideBtn = createStyledButton("Hide (Ctrl+Shift+`)");
        hideBtn.addActionListener(e -> toggleVisibility());
        
        // Close button
        JButton closeBtn = createStyledButton("Close");
        closeBtn.setBackground(new Color(220, 53, 69));
        closeBtn.addActionListener(e -> closeApplication());
        
        panel.add(newNoteBtn);
        panel.add(saveNoteBtn);
        panel.add(loadNoteBtn);
        panel.add(hideBtn);
        panel.add(closeBtn);
        
        return panel;
    }
    
    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 12));
        button.setBackground(new Color(52, 144, 220));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        // Hover effect
        button.addMouseListener(new MouseAdapter() {
            Color originalColor = button.getBackground();
            
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(originalColor.brighter());
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(originalColor);
            }
        });
        
        return button;
    }
    
    private JTextArea createNotesArea() {
        JTextArea textArea = new JTextArea(15, 40);
        textArea.setFont(new Font("Arial", Font.PLAIN, 14));
        textArea.setBackground(new Color(255, 255, 255, 200)); // Semi-transparent white
        textArea.setBorder(new EmptyBorder(10, 10, 10, 10));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setPlaceholderText("Start typing your notes here...");
        
        return textArea;
    }
    
    private JPanel createInstructionsPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.setOpaque(false);
        
        JLabel instructions = new JLabel(
            "<html><center>Press <b>Ctrl+Shift+`</b> to show/hide | " +
            "Press <b>Escape</b> to close | Click anywhere to focus notes</center></html>"
        );
        instructions.setFont(new Font("Arial", Font.PLAIN, 11));
        instructions.setForeground(Color.WHITE);
        
        panel.add(instructions);
        return panel;
    }
    
    private void setupGlobalKeyListener() {
        // Global key listener for shortcuts
        KeyboardFocusManager.getCurrentKeyboardFocusManager()
            .addKeyEventDispatcher(new KeyEventDispatcher() {
                @Override
                public boolean dispatchKeyEvent(KeyEvent e) {
                    if (e.getID() == KeyEvent.KEY_PRESSED) {
                        // Toggle visibility with Ctrl+Shift+` (backtick)
                        if (e.getKeyCode() == KeyEvent.VK_BACK_QUOTE && 
                            e.isControlDown() && e.isShiftDown()) {
                            toggleVisibility();
                            return true;
                        }
                        // Close with Escape
                        else if (e.getKeyCode() == KeyEvent.VK_ESCAPE && isVisible) {
                            closeApplication();
                            return true;
                        }
                    }
                    return false;
                }
            });
        
        // Click anywhere to focus the notes area
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                notesArea.requestFocusInWindow();
            }
        });
    }
    
    private void toggleVisibility() {
        isVisible = !isVisible;
        setVisible(isVisible);
        if (isVisible) {
            toFront();
            notesArea.requestFocusInWindow();
        }
    }
    
    private void clearNotes() {
        notesArea.setText("");
        notesArea.requestFocusInWindow();
    }
    
    private void saveNote() {
        // TODO: Implement save functionality using daoManager
        String noteContent = notesArea.getText();
        if (!noteContent.trim().isEmpty()) {
            // For now, just show a confirmation
            JOptionPane.showMessageDialog(this, 
                "Note saved! (Implementation pending with DAO)", 
                "Save Successful", 
                JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void loadNote() {
        // TODO: Implement load functionality using daoManager
        // For now, just show a placeholder
        JOptionPane.showMessageDialog(this, 
            "Load functionality pending with DAO implementation", 
            "Load Note", 
            JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void closeApplication() {
        System.exit(0);
    }
}

// Extension to JTextArea to support placeholder text
class JTextArea extends javax.swing.JTextArea {
    private String placeholder;
    
    public JTextArea(int rows, int cols) {
        super(rows, cols);
    }
    
    public void setPlaceholderText(String placeholder) {
        this.placeholder = placeholder;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if (placeholder != null && getText().isEmpty() && !hasFocus()) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setColor(Color.GRAY);
            g2.setFont(getFont().deriveFont(Font.ITALIC));
            g2.drawString(placeholder, getInsets().left, 
                g2.getFontMetrics().getMaxAscent() + getInsets().top);
            g2.dispose();
        }
    }
}